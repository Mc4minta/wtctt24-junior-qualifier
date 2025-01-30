package com.appsflyer;

import android.content.Context;
import com.appsflyer.oaid.OaidClient;

@Deprecated
/* loaded from: classes.dex */
class OaidClient {

    @Deprecated
    /* loaded from: classes.dex */
    static class Info {
        private final String id;
        private final Boolean lat;

        @Deprecated
        public Info(String str, Boolean bool) {
            this.id = str;
            this.lat = bool;
        }

        @Deprecated
        public String getId() {
            return this.id;
        }

        @Deprecated
        public Boolean isLat() {
            return this.lat;
        }
    }

    OaidClient() {
    }

    @Deprecated
    public static Info fetch(Context context) {
        OaidClient.Info fetch = new com.appsflyer.oaid.OaidClient(context).fetch();
        if (fetch != null) {
            return new Info(fetch.getId(), fetch.getLat());
        }
        return null;
    }
}