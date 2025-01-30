package com.facebook.react.common.g;

import okhttp3.Call;
import okhttp3.OkHttpClient;

/* compiled from: OkHttpCallUtil.java */
/* loaded from: classes2.dex */
public class a {
    public static void a(OkHttpClient okHttpClient, Object obj) {
        for (Call call : okHttpClient.dispatcher().queuedCalls()) {
            if (obj.equals(call.request().tag())) {
                call.cancel();
                return;
            }
        }
        for (Call call2 : okHttpClient.dispatcher().runningCalls()) {
            if (obj.equals(call2.request().tag())) {
                call2.cancel();
                return;
            }
        }
    }
}