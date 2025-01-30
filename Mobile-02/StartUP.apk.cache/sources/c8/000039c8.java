package com.google.firebase.crashlytics.c.g;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.coinbase.wallet.core.extensions.Strings;
import com.google.firebase.crashlytics.c.i.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class m {
    private static final String a = String.format(Locale.US, "Crashlytics Android SDK/%s", "17.0.0");

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, Integer> f8772b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f8773c;

    /* renamed from: d  reason: collision with root package name */
    private final v f8774d;

    /* renamed from: e  reason: collision with root package name */
    private final b f8775e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.firebase.crashlytics.c.q.d f8776f;

    static {
        HashMap hashMap = new HashMap();
        f8772b = hashMap;
        hashMap.put("armeabi", 5);
        hashMap.put("armeabi-v7a", 6);
        hashMap.put("arm64-v8a", 9);
        hashMap.put("x86", 0);
        hashMap.put("x86_64", 1);
    }

    public m(Context context, v vVar, b bVar, com.google.firebase.crashlytics.c.q.d dVar) {
        this.f8773c = context;
        this.f8774d = vVar;
        this.f8775e = bVar;
        this.f8776f = dVar;
    }

    private v.a a() {
        return com.google.firebase.crashlytics.c.i.v.b().h("17.0.0").d(this.f8775e.a).e(this.f8774d.a()).b(this.f8775e.f8670e).c(this.f8775e.f8671f).g(4);
    }

    private static int d() {
        Integer num;
        String str = Build.CPU_ABI;
        if (TextUtils.isEmpty(str) || (num = f8772b.get(str.toLowerCase(Locale.US))) == null) {
            return 7;
        }
        return num.intValue();
    }

    private v.d.AbstractC0173d.a.b.AbstractC0175a e() {
        return v.d.AbstractC0173d.a.b.AbstractC0175a.a().b(0L).d(0L).c(this.f8775e.f8669d).e(this.f8775e.f8667b).a();
    }

    private com.google.firebase.crashlytics.c.i.w<v.d.AbstractC0173d.a.b.AbstractC0175a> f() {
        return com.google.firebase.crashlytics.c.i.w.i(e());
    }

    private v.d.AbstractC0173d.a g(int i2, com.google.firebase.crashlytics.c.q.e eVar, Thread thread, int i3, int i4, boolean z) {
        Boolean bool;
        ActivityManager.RunningAppProcessInfo k2 = h.k(this.f8775e.f8669d, this.f8773c);
        if (k2 != null) {
            bool = Boolean.valueOf(k2.importance != 100);
        } else {
            bool = null;
        }
        return v.d.AbstractC0173d.a.a().b(bool).e(i2).d(k(eVar, thread, i3, i4, z)).a();
    }

    private v.d.AbstractC0173d.c h(int i2) {
        e a2 = e.a(this.f8773c);
        Float b2 = a2.b();
        Double valueOf = b2 != null ? Double.valueOf(b2.doubleValue()) : null;
        int c2 = a2.c();
        boolean q = h.q(this.f8773c);
        return v.d.AbstractC0173d.c.a().b(valueOf).c(c2).f(q).e(i2).g(h.v() - h.a(this.f8773c)).d(h.b(Environment.getDataDirectory().getPath())).a();
    }

    private v.d.AbstractC0173d.a.b.c i(com.google.firebase.crashlytics.c.q.e eVar, int i2, int i3) {
        return j(eVar, i2, i3, 0);
    }

    private v.d.AbstractC0173d.a.b.c j(com.google.firebase.crashlytics.c.q.e eVar, int i2, int i3, int i4) {
        String str = eVar.f9074b;
        String str2 = eVar.a;
        StackTraceElement[] stackTraceElementArr = eVar.f9075c;
        int i5 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        com.google.firebase.crashlytics.c.q.e eVar2 = eVar.f9076d;
        if (i4 >= i3) {
            com.google.firebase.crashlytics.c.q.e eVar3 = eVar2;
            while (eVar3 != null) {
                eVar3 = eVar3.f9076d;
                i5++;
            }
        }
        v.d.AbstractC0173d.a.b.c.AbstractC0178a d2 = v.d.AbstractC0173d.a.b.c.a().f(str).e(str2).c(com.google.firebase.crashlytics.c.i.w.h(m(stackTraceElementArr, i2))).d(i5);
        if (eVar2 != null && i5 == 0) {
            d2.b(j(eVar2, i2, i3, i4 + 1));
        }
        return d2.a();
    }

    private v.d.AbstractC0173d.a.b k(com.google.firebase.crashlytics.c.q.e eVar, Thread thread, int i2, int i3, boolean z) {
        return v.d.AbstractC0173d.a.b.a().e(u(eVar, thread, i2, z)).c(i(eVar, i2, i3)).d(r()).b(f()).a();
    }

    private v.d.AbstractC0173d.a.b.e.AbstractC0182b l(StackTraceElement stackTraceElement, v.d.AbstractC0173d.a.b.e.AbstractC0182b.AbstractC0183a abstractC0183a) {
        long j2 = 0;
        long max = stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0L) : 0L;
        String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            j2 = stackTraceElement.getLineNumber();
        }
        return abstractC0183a.e(max).f(str).b(fileName).d(j2).a();
    }

    private com.google.firebase.crashlytics.c.i.w<v.d.AbstractC0173d.a.b.e.AbstractC0182b> m(StackTraceElement[] stackTraceElementArr, int i2) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            arrayList.add(l(stackTraceElement, v.d.AbstractC0173d.a.b.e.AbstractC0182b.a().c(i2)));
        }
        return com.google.firebase.crashlytics.c.i.w.h(arrayList);
    }

    private v.d.a n() {
        return v.d.a.a().c(this.f8774d.d()).e(this.f8775e.f8670e).b(this.f8775e.f8671f).d(this.f8774d.a()).a();
    }

    private v.d o(String str, long j2) {
        return v.d.a().l(j2).i(str).g(a).b(n()).k(q()).d(p()).h(3).a();
    }

    private v.d.c p() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int d2 = d();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long v = h.v();
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        boolean C = h.C(this.f8773c);
        int n = h.n(this.f8773c);
        String str = Build.MANUFACTURER;
        return v.d.c.a().b(d2).f(Build.MODEL).c(availableProcessors).h(v).d(blockCount).i(C).j(n).e(str).g(Build.PRODUCT).a();
    }

    private v.d.e q() {
        return v.d.e.a().d(3).e(Build.VERSION.RELEASE).b(Build.VERSION.CODENAME).c(h.E(this.f8773c)).a();
    }

    private v.d.AbstractC0173d.a.b.AbstractC0179d r() {
        return v.d.AbstractC0173d.a.b.AbstractC0179d.a().d(Strings.zero).c(Strings.zero).b(0L).a();
    }

    private v.d.AbstractC0173d.a.b.e s(Thread thread, StackTraceElement[] stackTraceElementArr) {
        return t(thread, stackTraceElementArr, 0);
    }

    private v.d.AbstractC0173d.a.b.e t(Thread thread, StackTraceElement[] stackTraceElementArr, int i2) {
        return v.d.AbstractC0173d.a.b.e.a().d(thread.getName()).c(i2).b(com.google.firebase.crashlytics.c.i.w.h(m(stackTraceElementArr, i2))).a();
    }

    private com.google.firebase.crashlytics.c.i.w<v.d.AbstractC0173d.a.b.e> u(com.google.firebase.crashlytics.c.q.e eVar, Thread thread, int i2, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(t(thread, eVar.f9075c, i2));
        if (z) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                if (!key.equals(thread)) {
                    arrayList.add(s(key, this.f8776f.a(entry.getValue())));
                }
            }
        }
        return com.google.firebase.crashlytics.c.i.w.h(arrayList);
    }

    public v.d.AbstractC0173d b(Throwable th, Thread thread, String str, long j2, int i2, int i3, boolean z) {
        int i4 = this.f8773c.getResources().getConfiguration().orientation;
        return v.d.AbstractC0173d.a().f(str).e(j2).b(g(i4, new com.google.firebase.crashlytics.c.q.e(th, this.f8776f), thread, i2, i3, z)).c(h(i4)).a();
    }

    public com.google.firebase.crashlytics.c.i.v c(String str, long j2) {
        return a().i(o(str, j2)).a();
    }
}