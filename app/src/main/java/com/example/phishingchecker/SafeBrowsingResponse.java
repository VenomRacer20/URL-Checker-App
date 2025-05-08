package com.example.phishingchecker;

import java.util.List;

public class SafeBrowsingResponse {
    private List<Match> matches;

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public static class Match {
        private String threatType;
        private String platformType;
        private String threatEntryType;
        private Threat threat;
        private ThreatEntryMetadata threatEntryMetadata;
        private String cacheDuration;

        // Getters and setters...
        public String getThreatType() {
            return threatType;
        }

        public void setThreatType(String threatType) {
            this.threatType = threatType;
        }

        public String getPlatformType() {
            return platformType;
        }

        public void setPlatformType(String platformType) {
            this.platformType = platformType;
        }

        public String getThreatEntryType() {
            return threatEntryType;
        }

        public void setThreatEntryType(String threatEntryType) {
            this.threatEntryType = threatEntryType;
        }

        public Threat getThreat() {
            return threat;
        }

        public void setThreat(Threat threat) {
            this.threat = threat;
        }

        public ThreatEntryMetadata getThreatEntryMetadata() {
            return threatEntryMetadata;
        }

        public void setThreatEntryMetadata(ThreatEntryMetadata threatEntryMetadata) {
            this.threatEntryMetadata = threatEntryMetadata;
        }

        public String getCacheDuration() {
            return cacheDuration;
        }

        public void setCacheDuration(String cacheDuration) {
            this.cacheDuration = cacheDuration;
        }
    }

    public static class Threat {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class ThreatEntryMetadata {
        private List<Entry> entries;

        public List<Entry> getEntries() {
            return entries;
        }

        public void setEntries(List<Entry> entries) {
            this.entries = entries;
        }

        public static class Entry {
            private String key;
            private String value;

            // Getters and setters...
            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}