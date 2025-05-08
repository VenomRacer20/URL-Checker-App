package com.example.phishingchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://safebrowsing.googleapis.com/";

    private Retrofit retrofit;
    private SafeBrowsingApi safeBrowsingApi;

    private Button btnCheck, btnClear;
    private EditText inputUrl;

    private String apiKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCheck = findViewById(R.id.checkBtn);
        btnClear = findViewById(R.id.clearBtn);
        inputUrl = findViewById(R.id.urlInput);

        apiKey = getString(R.string.google_api_key); // Get the API key from strings.xml

        // Initialize Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        safeBrowsingApi = retrofit.create(SafeBrowsingApi.class);

        btnCheck.setOnClickListener(v -> {
            String url = inputUrl.getText().toString().trim();
            if (!url.isEmpty()) {
                checkPhishingWithSafeBrowsing(url);
            }
        });

        btnClear.setOnClickListener(v -> inputUrl.setText(""));
    }

    private void checkPhishingWithSafeBrowsing(String url) {
        SafeBrowsingRequest request = new SafeBrowsingRequest();

        SafeBrowsingRequest.Client client = new SafeBrowsingRequest.Client("com.example.phishingchecker", "1.5.2");
        request.setClient(client);

        SafeBrowsingRequest.ThreatInfo threatInfo = new SafeBrowsingRequest.ThreatInfo();
        threatInfo.setThreatTypes(Arrays.asList("MALWARE", "SOCIAL_ENGINEERING"));
        threatInfo.setPlatformTypes(Arrays.asList("ANY_PLATFORM"));
        threatInfo.setThreatEntryTypes(Arrays.asList("URL"));
        threatInfo.setThreatEntries(Arrays.asList(new SafeBrowsingRequest.ThreatInfo.ThreatEntry(url)));

        request.setThreatInfo(threatInfo);

        safeBrowsingApi.checkUrl(apiKey, request).enqueue(new Callback<SafeBrowsingResponse>() {
            @Override
            public void onResponse(Call<SafeBrowsingResponse> call, Response<SafeBrowsingResponse> response) {
                String message;
                if (response.isSuccessful() && response.body() != null) {
                    if (response.body().getMatches() != null && !response.body().getMatches().isEmpty()) {
                        message = "This URL is phishing/malicious!";
                    } else {
                        message = "URL seems safe!";
                    }
                } else {
                    message = "No data received or API error";
                }

                // Show the message in a prompt (AlertDialog)
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Phishing Check Result")
                        .setMessage(message)
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .show();
            }

            @Override
            public void onFailure(Call<SafeBrowsingResponse> call, Throwable t) {
                // Handle failure
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Error")
                        .setMessage("Error checking URL: " + t.getMessage())
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .show();
            }
        });
    }

    // Interface for Retrofit
    public interface SafeBrowsingApi {
        @POST("v4/threatMatches:find")
        Call<SafeBrowsingResponse> checkUrl(
                @Query("key") String apiKey,
                @Body SafeBrowsingRequest request
        );
    }
}