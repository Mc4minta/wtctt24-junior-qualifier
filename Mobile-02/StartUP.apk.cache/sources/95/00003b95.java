package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.android.gms.internal.p000firebaseperf.i0;
import com.google.android.gms.internal.p000firebaseperf.y0;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public class FirebasePerfOkHttpClient {
    private FirebasePerfOkHttpClient() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Response response, i0 i0Var, long j2, long j3) throws IOException {
        Request request = response.request();
        if (request == null) {
            return;
        }
        i0Var.h(request.url().url().toString());
        i0Var.i(request.method());
        if (request.body() != null) {
            long contentLength = request.body().contentLength();
            if (contentLength != -1) {
                i0Var.k(contentLength);
            }
        }
        ResponseBody body = response.body();
        if (body != null) {
            long contentLength2 = body.contentLength();
            if (contentLength2 != -1) {
                i0Var.p(contentLength2);
            }
            MediaType contentType = body.contentType();
            if (contentType != null) {
                i0Var.j(contentType.toString());
            }
        }
        i0Var.c(response.code());
        i0Var.l(j2);
        i0Var.o(j3);
        i0Var.g();
    }

    @Keep
    public static void enqueue(Call call, Callback callback) {
        y0 y0Var = new y0();
        call.enqueue(new h(callback, com.google.firebase.perf.internal.d.k(), y0Var, y0Var.c()));
    }

    @Keep
    public static Response execute(Call call) throws IOException {
        i0 b2 = i0.b(com.google.firebase.perf.internal.d.k());
        y0 y0Var = new y0();
        long c2 = y0Var.c();
        try {
            Response execute = call.execute();
            a(execute, b2, c2, y0Var.a());
            return execute;
        } catch (IOException e2) {
            Request request = call.request();
            if (request != null) {
                HttpUrl url = request.url();
                if (url != null) {
                    b2.h(url.url().toString());
                }
                if (request.method() != null) {
                    b2.i(request.method());
                }
            }
            b2.l(c2);
            b2.o(y0Var.a());
            g.c(b2);
            throw e2;
        }
    }
}