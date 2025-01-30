package com.google.firebase.perf.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.p000firebaseperf.a1;
import com.google.android.gms.internal.p000firebaseperf.z1;
import java.net.URI;
import org.apache.http.HttpHost;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public final class m extends s {
    private final z1 a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f9332b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(z1 z1Var, Context context) {
        this.f9332b = context;
        this.a = z1Var;
    }

    private static URI d(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URI.create(str);
        } catch (IllegalArgumentException | IllegalStateException e2) {
            Log.w("FirebasePerformance", "getResultUrl throws exception", e2);
            return null;
        }
    }

    private static boolean e(String str) {
        if (str == null) {
            return true;
        }
        return str.trim().isEmpty();
    }

    private static boolean f(long j2) {
        return j2 >= 0;
    }

    private static boolean g(long j2) {
        return j2 >= 0;
    }

    @Override // com.google.firebase.perf.internal.s
    public final boolean b() {
        if (e(this.a.t())) {
            String valueOf = String.valueOf(this.a.t());
            Log.i("FirebasePerformance", valueOf.length() != 0 ? "URL is missing:".concat(valueOf) : new String("URL is missing:"));
            return false;
        }
        URI d2 = d(this.a.t());
        if (d2 == null) {
            Log.i("FirebasePerformance", "URL cannot be parsed");
            return false;
        } else if (!a1.a(d2, this.f9332b)) {
            String valueOf2 = String.valueOf(d2);
            StringBuilder sb = new StringBuilder(valueOf2.length() + 26);
            sb.append("URL fails whitelist rule: ");
            sb.append(valueOf2);
            Log.i("FirebasePerformance", sb.toString());
            return false;
        } else {
            String host = d2.getHost();
            if (!((host == null || e(host) || host.length() > 255) ? false : true)) {
                Log.i("FirebasePerformance", "URL host is null or invalid");
                return false;
            }
            String scheme = d2.getScheme();
            if (!(scheme != null && (HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)))) {
                Log.i("FirebasePerformance", "URL scheme is null or invalid");
                return false;
            }
            if (!(d2.getUserInfo() == null)) {
                Log.i("FirebasePerformance", "URL user info is null");
                return false;
            }
            int port = d2.getPort();
            if (!(port == -1 || port > 0)) {
                Log.i("FirebasePerformance", "URL port is less than or equal to 0");
                return false;
            }
            z1.c W = this.a.U() ? this.a.W() : null;
            if (!((W == null || W == z1.c.HTTP_METHOD_UNKNOWN) ? false : true)) {
                String valueOf3 = String.valueOf(this.a.W());
                StringBuilder sb2 = new StringBuilder(valueOf3.length() + 32);
                sb2.append("HTTP Method is null or invalid: ");
                sb2.append(valueOf3);
                Log.i("FirebasePerformance", sb2.toString());
                return false;
            }
            if (this.a.Q()) {
                if (!(this.a.b0() > 0)) {
                    int b0 = this.a.b0();
                    StringBuilder sb3 = new StringBuilder(49);
                    sb3.append("HTTP ResponseCode is a negative value:");
                    sb3.append(b0);
                    Log.i("FirebasePerformance", sb3.toString());
                    return false;
                }
            }
            if (this.a.X() && !g(this.a.Y())) {
                long Y = this.a.Y();
                StringBuilder sb4 = new StringBuilder(56);
                sb4.append("Request Payload is a negative value:");
                sb4.append(Y);
                Log.i("FirebasePerformance", sb4.toString());
                return false;
            } else if (this.a.Z() && !g(this.a.a0())) {
                long a0 = this.a.a0();
                StringBuilder sb5 = new StringBuilder(57);
                sb5.append("Response Payload is a negative value:");
                sb5.append(a0);
                Log.i("FirebasePerformance", sb5.toString());
                return false;
            } else if (this.a.d0() && this.a.e0() > 0) {
                if (this.a.f0() && !f(this.a.g0())) {
                    long g0 = this.a.g0();
                    StringBuilder sb6 = new StringBuilder(69);
                    sb6.append("Time to complete the request is a negative value:");
                    sb6.append(g0);
                    Log.i("FirebasePerformance", sb6.toString());
                    return false;
                } else if (this.a.h0() && !f(this.a.i0())) {
                    long i0 = this.a.i0();
                    StringBuilder sb7 = new StringBuilder(112);
                    sb7.append("Time from the start of the request to the start of the response is null or a negative value:");
                    sb7.append(i0);
                    Log.i("FirebasePerformance", sb7.toString());
                    return false;
                } else if (this.a.j0() && this.a.k0() > 0) {
                    if (this.a.Q()) {
                        return true;
                    }
                    Log.i("FirebasePerformance", "Did not receive a HTTP Response Code");
                    return false;
                } else {
                    long k0 = this.a.k0();
                    StringBuilder sb8 = new StringBuilder(108);
                    sb8.append("Time from the start of the request to the end of the response is null, negative or zero:");
                    sb8.append(k0);
                    Log.i("FirebasePerformance", sb8.toString());
                    return false;
                }
            } else {
                long e0 = this.a.e0();
                StringBuilder sb9 = new StringBuilder(84);
                sb9.append("Start time of the request is null, or zero, or a negative value:");
                sb9.append(e0);
                Log.i("FirebasePerformance", sb9.toString());
                return false;
            }
        }
    }
}