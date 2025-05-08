🌐 URL Checker – Android App
URL Checker is a simple yet powerful Android app that helps users determine if a given URL is safe or potentially malicious. Built using Android Studio and powered by the Google Safe Browsing API, the app empowers users to quickly verify the safety of links before clicking or sharing them.

🛡️ What It Does
The URL Checker app checks a provided URL to see if it matches known threats such as:

🧪 Malware
🎣 Phishing (Social Engineering)
⚠️ Unsafe sites flagged by Google
The app sends the URL to the Google Safe Browsing API, which maintains an up-to-date list of harmful websites. If the URL is detected as harmful, the app will immediately notify the user with a clear warning. Otherwise, the user is informed that the URL appears to be safe.

🧰 Built With
Android Studio – Native Android app development.
Java – App written in Java.
Google Safe Browsing API – For checking the safety of URLs.
Retrofit – For making HTTP POST requests to the Safe Browsing service.
Gson – To handle JSON parsing.
🖼️ Features
🔎 Check if any URL is safe or malicious.
🧠 Simple and intuitive UI – paste and check instantly.
🔐 Uses Google's trusted Safe Browsing service.
📋 Clear prompts and messages based on the result.
🔄 Clear button for quick resetting and testing multiple URLs.
📷 Screenshots
(Add screenshots here if you want to show off the UI)

🛠️ How to Use
Paste or type a URL into the input field.
Tap "Check".
The app will:
Notify you if the link is malicious (malware, phishing, etc.).
Inform you if the link appears to be safe.
🔐 API Key Warning
Important: This app uses the Google Safe Browsing API, which requires an API key.

If you're cloning or forking this project:

You must provide your own API key.
The API key should be stored securely. (Avoid hardcoding it directly into the code.)
For demonstration purposes, the project contains a placeholder:
"YOUR_API_KEY_HERE"
To get an API key:

Visit Google Developers Console
Enable the Safe Browsing API
Create and restrict your API key accordingly
🙋‍♂️ Author
Jianel Calongcagong
GitHub: @VenomRacer20

If you find this app useful, give it a ⭐ on GitHub!
