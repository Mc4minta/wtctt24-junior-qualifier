package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public abstract class x1<T> {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b  reason: collision with root package name */
    private static Context f7399b;

    /* renamed from: c  reason: collision with root package name */
    private static m2<g2<t1>> f7400c;

    /* renamed from: e  reason: collision with root package name */
    private final d2 f7402e;

    /* renamed from: f  reason: collision with root package name */
    private final String f7403f;

    /* renamed from: g  reason: collision with root package name */
    private final T f7404g;

    /* renamed from: h  reason: collision with root package name */
    private volatile int f7405h;

    /* renamed from: i  reason: collision with root package name */
    private volatile T f7406i;
    private static final Object a = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicInteger f7401d = new AtomicInteger();

    private x1(d2 d2Var, String str, T t) {
        this.f7405h = -1;
        if (d2Var.f7088b != null) {
            this.f7402e = d2Var;
            this.f7403f = str;
            this.f7404g = t;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    private final String f(String str) {
        if (str == null || !str.isEmpty()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf(this.f7403f);
            return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        return this.f7403f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g() {
        f7401d.incrementAndGet();
    }

    public static void h(Context context) {
        synchronized (a) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (f7399b != context) {
                i1.d();
                c2.b();
                o1.b();
                f7401d.incrementAndGet();
                f7399b = context;
                f7400c = l2.a(w1.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static x1<Double> i(d2 d2Var, String str, double d2) {
        return new b2(d2Var, str, Double.valueOf(d2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static x1<Long> j(d2 d2Var, String str, long j2) {
        return new z1(d2Var, str, Long.valueOf(j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static x1<String> k(d2 d2Var, String str, String str2) {
        return new a2(d2Var, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static x1<Boolean> l(d2 d2Var, String str, boolean z) {
        return new y1(d2Var, str, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ g2 o() {
        new s1();
        return s1.b(f7399b);
    }

    abstract T e(Object obj);

    public final String m() {
        return f(this.f7402e.f7090d);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0096 A[Catch: all -> 0x00ed, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0013, B:11:0x0021, B:17:0x0033, B:19:0x0039, B:21:0x0041, B:25:0x005a, B:27:0x0064, B:45:0x00b5, B:47:0x00c3, B:49:0x00d7, B:50:0x00da, B:51:0x00de, B:38:0x0096, B:40:0x00aa, B:44:0x00b3, B:23:0x0052, B:28:0x0069, B:30:0x0072, B:32:0x0084, B:34:0x008f, B:33:0x0089, B:52:0x00e3, B:53:0x00ea, B:54:0x00eb), top: B:61:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c3 A[Catch: all -> 0x00ed, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0013, B:11:0x0021, B:17:0x0033, B:19:0x0039, B:21:0x0041, B:25:0x005a, B:27:0x0064, B:45:0x00b5, B:47:0x00c3, B:49:0x00d7, B:50:0x00da, B:51:0x00de, B:38:0x0096, B:40:0x00aa, B:44:0x00b3, B:23:0x0052, B:28:0x0069, B:30:0x0072, B:32:0x0084, B:34:0x008f, B:33:0x0089, B:52:0x00e3, B:53:0x00ea, B:54:0x00eb), top: B:61:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final T n() {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.x1.n():java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ x1(d2 d2Var, String str, Object obj, z1 z1Var) {
        this(d2Var, str, obj);
    }
}