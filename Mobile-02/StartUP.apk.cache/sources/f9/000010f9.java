package com.coinbase.resources.users;

/* loaded from: classes.dex */
public final class UpdateUserRequest {
    public final String name;
    public final String nativeCurrency;
    public final String timeZone;

    /* loaded from: classes.dex */
    public static class RequestBuilder {
        private String name;
        private String nativeCurrency;
        private String timeZone;

        public UpdateUserRequest build() {
            return new UpdateUserRequest(this.name, this.timeZone, this.nativeCurrency);
        }

        public RequestBuilder setName(String str) {
            this.name = str;
            return this;
        }

        public RequestBuilder setNativeCurrency(String str) {
            this.nativeCurrency = str;
            return this;
        }

        public RequestBuilder setTimeZone(String str) {
            this.timeZone = str;
            return this;
        }
    }

    public static RequestBuilder builder() {
        return new RequestBuilder();
    }

    private UpdateUserRequest(String str, String str2, String str3) {
        this.name = str;
        this.timeZone = str2;
        this.nativeCurrency = str3;
    }
}