package com.facebook.react.modules.fresco;

import android.net.Uri;
import android.os.SystemClock;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import e.f.j.b.a.b;
import e.f.j.l.f0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* compiled from: ReactOkHttpNetworkFetcher.java */
/* loaded from: classes2.dex */
class b extends e.f.j.b.a.b {

    /* renamed from: d  reason: collision with root package name */
    private final OkHttpClient f4946d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f4947e;

    public b(OkHttpClient okHttpClient) {
        super(okHttpClient);
        this.f4946d = okHttpClient;
        this.f4947e = okHttpClient.dispatcher().executorService();
    }

    private Map<String, String> n(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        HashMap hashMap = new HashMap();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            hashMap.put(nextKey, readableMap.getString(nextKey));
        }
        return hashMap;
    }

    @Override // e.f.j.b.a.b, e.f.j.l.f0
    /* renamed from: i */
    public void d(b.c cVar, f0.a aVar) {
        cVar.f12409f = SystemClock.elapsedRealtime();
        Uri h2 = cVar.h();
        Map<String, String> n = cVar.b().c() instanceof a ? n(((a) cVar.b().c()).x()) : null;
        if (n == null) {
            n = Collections.emptyMap();
        }
        j(cVar, aVar, new Request.Builder().cacheControl(new CacheControl.Builder().noStore().build()).url(h2.toString()).headers(Headers.of(n)).get().build());
    }
}