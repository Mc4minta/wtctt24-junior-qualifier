package com.google.android.gms.internal.p000firebaseperf;

import android.util.Log;
import com.google.android.gms.internal.p000firebaseperf.z1;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.internal.a;
import com.google.firebase.perf.internal.c;
import com.google.firebase.perf.internal.d;
import com.google.firebase.perf.internal.r;
import com.google.firebase.perf.internal.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okhttp3.HttpUrl;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.i0  reason: invalid package */
/* loaded from: classes2.dex */
public final class i0 extends c implements w {
    private final List<r> a;

    /* renamed from: b  reason: collision with root package name */
    private final GaugeManager f6740b;

    /* renamed from: c  reason: collision with root package name */
    private d f6741c;

    /* renamed from: d  reason: collision with root package name */
    private final z1.b f6742d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6743e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6744f;

    /* renamed from: g  reason: collision with root package name */
    private final WeakReference<w> f6745g;

    private i0(d dVar) {
        this(dVar, a.j(), GaugeManager.zzby());
    }

    public static i0 b(d dVar) {
        return new i0(dVar);
    }

    @Override // com.google.firebase.perf.internal.w
    public final void a(r rVar) {
        if (rVar == null) {
            Log.i("FirebasePerformance", "Unable to add new SessionId to the Network Trace. Continuing without it.");
        } else if (!this.f6742d.B() || this.f6742d.D()) {
        } else {
            this.a.add(rVar);
        }
    }

    public final i0 c(int i2) {
        this.f6742d.F(i2);
        return this;
    }

    public final boolean d() {
        return this.f6742d.A();
    }

    public final long e() {
        return this.f6742d.C();
    }

    public final i0 f() {
        this.f6742d.x(z1.d.GENERIC_CLIENT_ERROR);
        return this;
    }

    public final z1 g() {
        SessionManager.zzcm().zzd(this.f6745g);
        zzbr();
        h2[] b2 = r.b(e8.r(this.a));
        if (b2 != null) {
            this.f6742d.y(Arrays.asList(b2));
        }
        z1 z1Var = (z1) ((m4) this.f6742d.O());
        if (!this.f6743e) {
            d dVar = this.f6741c;
            if (dVar != null) {
                dVar.b(z1Var, zzbn());
            }
            this.f6743e = true;
        } else if (this.f6744f) {
            Log.i("FirebasePerformance", "This metric has already been queued for transmission.  Please create a new HttpMetric for each request/response");
        }
        return z1Var;
    }

    public final i0 h(String str) {
        HttpUrl parse;
        int lastIndexOf;
        if (str != null) {
            HttpUrl parse2 = HttpUrl.parse(str);
            if (parse2 != null) {
                str = parse2.newBuilder().username("").password("").query(null).fragment(null).toString();
            }
            z1.b bVar = this.f6742d;
            if (str.length() > 2000) {
                if (str.charAt(2000) != '/' && (parse = HttpUrl.parse(str)) != null && parse.encodedPath().lastIndexOf(47) >= 0 && (lastIndexOf = str.lastIndexOf(47, 1999)) >= 0) {
                    str = str.substring(0, lastIndexOf);
                } else {
                    str = str.substring(0, 2000);
                }
            }
            bVar.o(str);
        }
        return this;
    }

    public final i0 i(String str) {
        z1.c cVar;
        if (str != null) {
            String upperCase = str.toUpperCase();
            upperCase.hashCode();
            char c2 = 65535;
            switch (upperCase.hashCode()) {
                case -531492226:
                    if (upperCase.equals(HttpOptions.METHOD_NAME)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 70454:
                    if (upperCase.equals(HttpGet.METHOD_NAME)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 79599:
                    if (upperCase.equals(HttpPut.METHOD_NAME)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 2213344:
                    if (upperCase.equals(HttpHead.METHOD_NAME)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 2461856:
                    if (upperCase.equals(HttpPost.METHOD_NAME)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 75900968:
                    if (upperCase.equals(HttpPatch.METHOD_NAME)) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 80083237:
                    if (upperCase.equals(HttpTrace.METHOD_NAME)) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1669334218:
                    if (upperCase.equals("CONNECT")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 2012838315:
                    if (upperCase.equals(HttpDelete.METHOD_NAME)) {
                        c2 = '\b';
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    cVar = z1.c.OPTIONS;
                    break;
                case 1:
                    cVar = z1.c.GET;
                    break;
                case 2:
                    cVar = z1.c.PUT;
                    break;
                case 3:
                    cVar = z1.c.HEAD;
                    break;
                case 4:
                    cVar = z1.c.POST;
                    break;
                case 5:
                    cVar = z1.c.PATCH;
                    break;
                case 6:
                    cVar = z1.c.TRACE;
                    break;
                case 7:
                    cVar = z1.c.CONNECT;
                    break;
                case '\b':
                    cVar = z1.c.DELETE;
                    break;
                default:
                    cVar = z1.c.HTTP_METHOD_UNKNOWN;
                    break;
            }
            this.f6742d.w(cVar);
        }
        return this;
    }

    public final i0 j(String str) {
        if (str == null) {
            this.f6742d.E();
            return this;
        }
        boolean z = false;
        if (str.length() <= 128) {
            int i2 = 0;
            while (true) {
                if (i2 >= str.length()) {
                    z = true;
                    break;
                }
                char charAt = str.charAt(i2);
                if (charAt <= 31 || charAt > 127) {
                    break;
                }
                i2++;
            }
        }
        if (z) {
            this.f6742d.p(str);
        } else {
            Log.i("FirebasePerformance", str.length() != 0 ? "The content type of the response is not a valid content-type:".concat(str) : new String("The content type of the response is not a valid content-type:"));
        }
        return this;
    }

    public final i0 k(long j2) {
        this.f6742d.q(j2);
        return this;
    }

    public final i0 l(long j2) {
        r zzcn = SessionManager.zzcm().zzcn();
        SessionManager.zzcm().zzc(this.f6745g);
        this.f6742d.s(j2);
        a(zzcn);
        if (zzcn.f()) {
            this.f6740b.zzj(zzcn.e());
        }
        return this;
    }

    public final i0 m(long j2) {
        this.f6742d.t(j2);
        return this;
    }

    public final i0 n(long j2) {
        this.f6742d.u(j2);
        return this;
    }

    public final i0 o(long j2) {
        this.f6742d.v(j2);
        if (SessionManager.zzcm().zzcn().f()) {
            this.f6740b.zzj(SessionManager.zzcm().zzcn().e());
        }
        return this;
    }

    public final i0 p(long j2) {
        this.f6742d.r(j2);
        return this;
    }

    private i0(d dVar, a aVar, GaugeManager gaugeManager) {
        super(aVar);
        this.f6742d = z1.m0();
        this.f6745g = new WeakReference<>(this);
        this.f6741c = dVar;
        this.f6740b = gaugeManager;
        this.a = new ArrayList();
        zzbq();
    }
}