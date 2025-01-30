package com.google.firebase.perf.network;

import com.google.android.gms.internal.p000firebaseperf.i0;
import com.google.android.gms.internal.p000firebaseperf.y0;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public final class e<T> implements ResponseHandler<T> {
    private final ResponseHandler<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    private final y0 f9387b;

    /* renamed from: c  reason: collision with root package name */
    private final i0 f9388c;

    public e(ResponseHandler<? extends T> responseHandler, y0 y0Var, i0 i0Var) {
        this.a = responseHandler;
        this.f9387b = y0Var;
        this.f9388c = i0Var;
    }

    @Override // org.apache.http.client.ResponseHandler
    public final T handleResponse(HttpResponse httpResponse) throws IOException {
        this.f9388c.o(this.f9387b.a());
        this.f9388c.c(httpResponse.getStatusLine().getStatusCode());
        Long a = g.a(httpResponse);
        if (a != null) {
            this.f9388c.p(a.longValue());
        }
        String b2 = g.b(httpResponse);
        if (b2 != null) {
            this.f9388c.j(b2);
        }
        this.f9388c.g();
        return this.a.handleResponse(httpResponse);
    }
}