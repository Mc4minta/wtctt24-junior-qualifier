package com.google.android.gms.internal.clearcut;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.clearcut.d5;
import e.g.a.e.c.a;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class r5 implements a.b {
    private static final Charset a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    private static final p f6552b;

    /* renamed from: c  reason: collision with root package name */
    private static final p f6553c;

    /* renamed from: d  reason: collision with root package name */
    private static final ConcurrentHashMap<String, f<d5>> f6554d;

    /* renamed from: e  reason: collision with root package name */
    private static final HashMap<String, f<String>> f6555e;

    /* renamed from: f  reason: collision with root package name */
    private static Boolean f6556f;

    /* renamed from: g  reason: collision with root package name */
    private static Long f6557g;

    /* renamed from: h  reason: collision with root package name */
    private static final f<Boolean> f6558h;

    /* renamed from: i  reason: collision with root package name */
    private final Context f6559i;

    static {
        p h2 = new p(e.g.a.e.e.b.a("com.google.android.gms.clearcut.public")).f("gms:playlog:service:samplingrules_").h("LogSamplingRules__");
        f6552b = h2;
        f6553c = new p(e.g.a.e.e.b.a("com.google.android.gms.clearcut.public")).f("gms:playlog:service:sampling_").h("LogSampling__");
        f6554d = new ConcurrentHashMap<>();
        f6555e = new HashMap<>();
        f6556f = null;
        f6557g = null;
        f6558h = h2.e("enable_log_sampling_rules", false);
    }

    public r5(Context context) {
        this.f6559i = context;
        if (context != null) {
            f.b(context);
        }
    }

    private static long b(String str, long j2) {
        if (str == null || str.isEmpty()) {
            return m5.c(ByteBuffer.allocate(8).putLong(j2).array());
        }
        byte[] bytes = str.getBytes(a);
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 8);
        allocate.put(bytes);
        allocate.putLong(j2);
        return m5.c(allocate.array());
    }

    private static d5.b c(String str) {
        String str2;
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(44);
        int i2 = 0;
        if (indexOf >= 0) {
            i2 = indexOf + 1;
            str2 = str.substring(0, indexOf);
        } else {
            str2 = "";
        }
        int indexOf2 = str.indexOf(47, i2);
        if (indexOf2 <= 0) {
            Log.e("LogSamplerImpl", str.length() != 0 ? "Failed to parse the rule: ".concat(str) : new String("Failed to parse the rule: "));
            return null;
        }
        try {
            long parseLong = Long.parseLong(str.substring(i2, indexOf2));
            long parseLong2 = Long.parseLong(str.substring(indexOf2 + 1));
            if (parseLong < 0 || parseLong2 < 0) {
                StringBuilder sb = new StringBuilder(72);
                sb.append("negative values not supported: ");
                sb.append(parseLong);
                sb.append("/");
                sb.append(parseLong2);
                Log.e("LogSamplerImpl", sb.toString());
                return null;
            }
            return d5.b.y().q(str2).r(parseLong).s(parseLong2).p();
        } catch (NumberFormatException e2) {
            Log.e("LogSamplerImpl", str.length() != 0 ? "parseLong() failed while parsing: ".concat(str) : new String("parseLong() failed while parsing: "), e2);
            return null;
        }
    }

    private static boolean d(long j2, long j3, long j4) {
        if (j3 < 0 || j4 <= 0) {
            return true;
        }
        return ((j2 > 0L ? 1 : (j2 == 0L ? 0 : -1)) >= 0 ? j2 % j4 : (((Long.MAX_VALUE % j4) + 1) + ((j2 & Long.MAX_VALUE) % j4)) % j4) < j3;
    }

    private static boolean e(Context context) {
        if (f6556f == null) {
            f6556f = Boolean.valueOf(com.google.android.gms.common.n.c.a(context).a("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
        }
        return f6556f.booleanValue();
    }

    private static long f(Context context) {
        if (f6557g == null) {
            if (context == null) {
                return 0L;
            }
            f6557g = Long.valueOf(e(context) ? v5.a(context.getContentResolver(), "android_id", 0L) : 0L);
        }
        return f6557g.longValue();
    }

    @Override // e.g.a.e.c.a.b
    public final boolean a(e.g.a.e.c.f fVar) {
        List<d5.b> q;
        f<d5> putIfAbsent;
        t5 t5Var = fVar.a;
        String str = t5Var.f6566g;
        int i2 = t5Var.f6562c;
        i5 i5Var = fVar.f13127j;
        int i3 = i5Var != null ? i5Var.f6463g : 0;
        String str2 = null;
        if (!f6558h.a().booleanValue()) {
            if (str == null || str.isEmpty()) {
                str = i2 >= 0 ? String.valueOf(i2) : null;
            }
            if (str != null) {
                Context context = this.f6559i;
                if (context != null && e(context)) {
                    HashMap<String, f<String>> hashMap = f6555e;
                    f<String> fVar2 = hashMap.get(str);
                    if (fVar2 == null) {
                        fVar2 = f6553c.b(str, null);
                        hashMap.put(str, fVar2);
                    }
                    str2 = fVar2.a();
                }
                d5.b c2 = c(str2);
                if (c2 != null) {
                    return d(b(c2.v(), f(this.f6559i)), c2.w(), c2.x());
                }
                return true;
            }
            return true;
        }
        if (str == null || str.isEmpty()) {
            str = i2 >= 0 ? String.valueOf(i2) : null;
        }
        if (str != null) {
            if (this.f6559i == null) {
                q = Collections.emptyList();
            } else {
                ConcurrentHashMap<String, f<d5>> concurrentHashMap = f6554d;
                f<d5> fVar3 = concurrentHashMap.get(str);
                if (fVar3 == null && (putIfAbsent = concurrentHashMap.putIfAbsent(str, (fVar3 = f6552b.a(str, d5.r(), s5.a)))) != null) {
                    fVar3 = putIfAbsent;
                }
                q = fVar3.a().q();
            }
            for (d5.b bVar : q) {
                if (!bVar.u() || bVar.q() == 0 || bVar.q() == i3) {
                    if (!d(b(bVar.v(), f(this.f6559i)), bVar.w(), bVar.x())) {
                        return false;
                    }
                }
            }
            return true;
        }
        return true;
    }
}