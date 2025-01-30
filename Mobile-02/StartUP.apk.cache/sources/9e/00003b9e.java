package com.google.firebase.perf.network;

import com.google.android.gms.internal.p000firebaseperf.i0;
import com.google.android.gms.internal.p000firebaseperf.y0;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public final class h implements Callback {
    private final Callback a;

    /* renamed from: b  reason: collision with root package name */
    private final i0 f9393b;

    /* renamed from: c  reason: collision with root package name */
    private final long f9394c;

    /* renamed from: d  reason: collision with root package name */
    private final y0 f9395d;

    public h(Callback callback, com.google.firebase.perf.internal.d dVar, y0 y0Var, long j2) {
        this.a = callback;
        this.f9393b = i0.b(dVar);
        this.f9394c = j2;
        this.f9395d = y0Var;
    }

    @Override // okhttp3.Callback
    public final void onFailure(Call call, IOException iOException) {
        Request request = call.request();
        if (request != null) {
            HttpUrl url = request.url();
            if (url != null) {
                this.f9393b.h(url.url().toString());
            }
            if (request.method() != null) {
                this.f9393b.i(request.method());
            }
        }
        this.f9393b.l(this.f9394c);
        this.f9393b.o(this.f9395d.a());
        g.c(this.f9393b);
        this.a.onFailure(call, iOException);
    }

    @Override // okhttp3.Callback
    public final void onResponse(Call call, Response response) throws IOException {
        FirebasePerfOkHttpClient.a(response, this.f9393b, this.f9394c, this.f9395d.a());
        this.a.onResponse(call, response);
    }
}