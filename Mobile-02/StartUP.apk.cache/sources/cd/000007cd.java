package com.bugsnag.android;

import com.bugsnag.android.o0;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultDelivery.java */
/* loaded from: classes.dex */
public class y implements z {
    private final t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(t tVar) {
        this.a = tVar;
    }

    @Override // com.bugsnag.android.z
    public void a(v0 v0Var, s sVar) throws DeliveryFailureException {
        int c2 = c(sVar.p(), v0Var, sVar.q());
        if (c2 / 100 != 2) {
            q0.e("Error API request failed with status " + c2, null);
            return;
        }
        q0.b("Completed error API request");
    }

    @Override // com.bugsnag.android.z
    public void b(z0 z0Var, s sVar) throws DeliveryFailureException {
        int c2 = c(sVar.C(), z0Var, sVar.A());
        if (c2 != 202) {
            q0.e("Session API request failed with status " + c2, null);
            return;
        }
        q0.b("Completed session tracking request");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(String str, o0.a aVar, Map<String, String> map) throws DeliveryFailureException {
        HttpURLConnection httpURLConnection;
        t tVar = this.a;
        HttpURLConnection httpURLConnection2 = null;
        o0 o0Var = null;
        HttpURLConnection httpURLConnection3 = null;
        if (tVar != null && !tVar.b()) {
            throw new DeliveryFailureException("No network connection available", null);
        }
        try {
            try {
                httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
            } catch (IOException e2) {
                e = e2;
            } catch (Exception e3) {
                e = e3;
            }
            try {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setChunkedStreamingMode(0);
                httpURLConnection.addRequestProperty("Content-Type", "application/json");
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                }
                try {
                    o0 o0Var2 = new o0(new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), Charset.forName("UTF-8"))));
                    try {
                        aVar.toStream(o0Var2);
                        l0.b(o0Var2);
                        int responseCode = httpURLConnection.getResponseCode();
                        l0.a(httpURLConnection);
                        return responseCode;
                    } catch (Throwable th) {
                        th = th;
                        o0Var = o0Var2;
                        l0.b(o0Var);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e4) {
                e = e4;
                throw new DeliveryFailureException("IOException encountered in request", e);
            } catch (Exception e5) {
                e = e5;
                httpURLConnection2 = httpURLConnection;
                q0.e("Unexpected error delivering payload", e);
                l0.a(httpURLConnection2);
                return 0;
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection3 = httpURLConnection;
                l0.a(httpURLConnection3);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}