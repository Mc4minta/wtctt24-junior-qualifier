package com.google.firebase.remoteconfig.internal;

import android.text.format.DateUtils;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigFetchThrottledException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.l;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpStatus;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public class j {
    public static final long a = TimeUnit.HOURS.toSeconds(12);

    /* renamed from: b  reason: collision with root package name */
    static final int[] f9434b = {2, 4, 8, 16, 32, 64, 128, 256};

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseInstanceId f9435c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.firebase.analytics.a.a f9436d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f9437e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.gms.common.util.e f9438f;

    /* renamed from: g  reason: collision with root package name */
    private final Random f9439g;

    /* renamed from: h  reason: collision with root package name */
    private final e f9440h;

    /* renamed from: i  reason: collision with root package name */
    private final ConfigFetchHttpClient f9441i;

    /* renamed from: j  reason: collision with root package name */
    private final l f9442j;

    /* renamed from: k  reason: collision with root package name */
    private final Map<String, String> f9443k;

    /* compiled from: com.google.firebase:firebase-config@@19.0.4 */
    /* loaded from: classes2.dex */
    public static class a {
        private final Date a;

        /* renamed from: b  reason: collision with root package name */
        private final int f9444b;

        /* renamed from: c  reason: collision with root package name */
        private final f f9445c;

        /* renamed from: d  reason: collision with root package name */
        private final String f9446d;

        private a(Date date, int i2, f fVar, String str) {
            this.a = date;
            this.f9444b = i2;
            this.f9445c = fVar;
            this.f9446d = str;
        }

        public static a a(Date date) {
            return new a(date, 1, null, null);
        }

        public static a b(f fVar, String str) {
            return new a(fVar.e(), 0, fVar, str);
        }

        public static a c(Date date) {
            return new a(date, 2, null, null);
        }

        public f d() {
            return this.f9445c;
        }

        String e() {
            return this.f9446d;
        }

        int f() {
            return this.f9444b;
        }
    }

    public j(FirebaseInstanceId firebaseInstanceId, com.google.firebase.analytics.a.a aVar, Executor executor, com.google.android.gms.common.util.e eVar, Random random, e eVar2, ConfigFetchHttpClient configFetchHttpClient, l lVar, Map<String, String> map) {
        this.f9435c = firebaseInstanceId;
        this.f9436d = aVar;
        this.f9437e = executor;
        this.f9438f = eVar;
        this.f9439g = random;
        this.f9440h = eVar2;
        this.f9441i = configFetchHttpClient;
        this.f9442j = lVar;
        this.f9443k = map;
    }

    private boolean a(long j2, Date date) {
        Date e2 = this.f9442j.e();
        if (e2.equals(l.a)) {
            return false;
        }
        return date.before(new Date(e2.getTime() + TimeUnit.SECONDS.toMillis(j2)));
    }

    private FirebaseRemoteConfigServerException b(FirebaseRemoteConfigServerException firebaseRemoteConfigServerException) throws FirebaseRemoteConfigClientException {
        String str;
        int a2 = firebaseRemoteConfigServerException.a();
        if (a2 == 401) {
            str = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
        } else if (a2 == 403) {
            str = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
        } else if (a2 == 429) {
            throw new FirebaseRemoteConfigClientException("The throttled response from the server was not handled correctly by the FRC SDK.");
        } else {
            if (a2 != 500) {
                switch (a2) {
                    case HttpStatus.SC_BAD_GATEWAY /* 502 */:
                    case HttpStatus.SC_SERVICE_UNAVAILABLE /* 503 */:
                    case HttpStatus.SC_GATEWAY_TIMEOUT /* 504 */:
                        str = "The server is unavailable. Please try again later.";
                        break;
                    default:
                        str = "The server returned an unexpected error.";
                        break;
                }
            } else {
                str = "There was an internal server error.";
            }
        }
        int a3 = firebaseRemoteConfigServerException.a();
        return new FirebaseRemoteConfigServerException(a3, "Fetch failed: " + str, firebaseRemoteConfigServerException);
    }

    private String c(long j2) {
        return String.format("Fetch is throttled. Please wait before calling fetch again: %s", DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(j2)));
    }

    private a f(Date date) throws FirebaseRemoteConfigException {
        try {
            a fetch = this.f9441i.fetch(this.f9441i.c(), this.f9435c.b(), this.f9435c.e(), k(), this.f9442j.d(), this.f9443k, date);
            if (fetch.e() != null) {
                this.f9442j.j(fetch.e());
            }
            this.f9442j.h();
            return fetch;
        } catch (FirebaseRemoteConfigServerException e2) {
            l.a q = q(e2.a(), date);
            if (p(q, e2.a())) {
                throw new FirebaseRemoteConfigFetchThrottledException(q.a().getTime());
            }
            throw b(e2);
        }
    }

    private com.google.android.gms.tasks.g<a> g(Date date) {
        try {
            a f2 = f(date);
            if (f2.f() != 0) {
                return com.google.android.gms.tasks.j.e(f2);
            }
            return this.f9440h.i(f2.d()).s(this.f9437e, i.b(f2));
        } catch (FirebaseRemoteConfigException e2) {
            return com.google.android.gms.tasks.j.d(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.android.gms.tasks.g<a> h(com.google.android.gms.tasks.g<f> gVar, long j2) {
        com.google.android.gms.tasks.g<a> g2;
        Date date = new Date(this.f9438f.a());
        if (gVar.q() && a(j2, date)) {
            return com.google.android.gms.tasks.j.e(a.c(date));
        }
        Date i2 = i(date);
        if (i2 != null) {
            g2 = com.google.android.gms.tasks.j.d(new FirebaseRemoteConfigFetchThrottledException(c(i2.getTime() - date.getTime()), i2.getTime()));
        } else {
            g2 = g(date);
        }
        return g2.k(this.f9437e, h.b(this, date));
    }

    private Date i(Date date) {
        Date a2 = this.f9442j.a().a();
        if (date.before(a2)) {
            return a2;
        }
        return null;
    }

    private long j(int i2) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        int[] iArr = f9434b;
        long millis = timeUnit.toMillis(iArr[Math.min(i2, iArr.length) - 1]);
        return (millis / 2) + this.f9439g.nextInt((int) millis);
    }

    private Map<String, String> k() {
        HashMap hashMap = new HashMap();
        com.google.firebase.analytics.a.a aVar = this.f9436d;
        if (aVar == null) {
            return hashMap;
        }
        for (Map.Entry<String, Object> entry : aVar.a(false).entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().toString());
        }
        return hashMap;
    }

    private boolean l(int i2) {
        return i2 == 429 || i2 == 502 || i2 == 503 || i2 == 504;
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ com.google.android.gms.tasks.g o(com.google.firebase.remoteconfig.internal.j r0, java.util.Date r1, com.google.android.gms.tasks.g r2) throws java.lang.Exception {
        /*
            r0.s(r2, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.j.o(com.google.firebase.remoteconfig.internal.j, java.util.Date, com.google.android.gms.tasks.g):com.google.android.gms.tasks.g");
    }

    private boolean p(l.a aVar, int i2) {
        return aVar.b() > 1 || i2 == 429;
    }

    private l.a q(int i2, Date date) {
        if (l(i2)) {
            r(date);
        }
        return this.f9442j.a();
    }

    private void r(Date date) {
        int b2 = this.f9442j.a().b() + 1;
        this.f9442j.i(b2, new Date(date.getTime() + j(b2)));
    }

    private void s(com.google.android.gms.tasks.g<a> gVar, Date date) {
        if (gVar.q()) {
            this.f9442j.l(date);
            return;
        }
        Exception l2 = gVar.l();
        if (l2 == null) {
            return;
        }
        if (l2 instanceof FirebaseRemoteConfigFetchThrottledException) {
            this.f9442j.m();
        } else {
            this.f9442j.k();
        }
    }

    public com.google.android.gms.tasks.g<a> d() {
        return e(this.f9442j.f());
    }

    public com.google.android.gms.tasks.g<a> e(long j2) {
        if (this.f9442j.g()) {
            j2 = 0;
        }
        return this.f9440h.c().k(this.f9437e, g.b(this, j2));
    }
}