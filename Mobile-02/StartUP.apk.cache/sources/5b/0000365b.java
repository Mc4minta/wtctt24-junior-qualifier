package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.h0;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public abstract class ha {
    String a;

    /* renamed from: b  reason: collision with root package name */
    int f7628b;

    /* renamed from: c  reason: collision with root package name */
    Boolean f7629c;

    /* renamed from: d  reason: collision with root package name */
    Boolean f7630d;

    /* renamed from: e  reason: collision with root package name */
    Long f7631e;

    /* renamed from: f  reason: collision with root package name */
    Long f7632f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ha(String str, int i2) {
        this.a = str;
        this.f7628b = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean b(double d2, com.google.android.gms.internal.measurement.f0 f0Var) {
        try {
            return h(new BigDecimal(d2), f0Var, Math.ulp(d2));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean c(long j2, com.google.android.gms.internal.measurement.f0 f0Var) {
        try {
            return h(new BigDecimal(j2), f0Var, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean d(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean e(String str, com.google.android.gms.internal.measurement.f0 f0Var) {
        if (r9.U(str)) {
            try {
                return h(new BigDecimal(str), f0Var, 0.0d);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return null;
    }

    private static Boolean f(String str, h0.a aVar, boolean z, String str2, List<String> list, String str3, x3 x3Var) {
        if (str == null) {
            return null;
        }
        if (aVar == h0.a.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && aVar != h0.a.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (da.a[aVar.ordinal()]) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (x3Var != null) {
                        x3Var.K().b("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean g(String str, com.google.android.gms.internal.measurement.h0 h0Var, x3 x3Var) {
        String E;
        List<String> list;
        com.google.android.gms.common.internal.t.k(h0Var);
        if (str == null || !h0Var.B() || h0Var.C() == h0.a.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        h0.a C = h0Var.C();
        h0.a aVar = h0.a.IN_LIST;
        if (C == aVar) {
            if (h0Var.I() == 0) {
                return null;
            }
        } else if (!h0Var.D()) {
            return null;
        }
        h0.a C2 = h0Var.C();
        boolean G = h0Var.G();
        if (!G && C2 != h0.a.REGEXP && C2 != aVar) {
            E = h0Var.E().toUpperCase(Locale.ENGLISH);
        } else {
            E = h0Var.E();
        }
        String str2 = E;
        if (h0Var.I() == 0) {
            list = null;
        } else {
            List<String> H = h0Var.H();
            if (!G) {
                ArrayList arrayList = new ArrayList(H.size());
                for (String str3 : H) {
                    arrayList.add(str3.toUpperCase(Locale.ENGLISH));
                }
                H = Collections.unmodifiableList(arrayList);
            }
            list = H;
        }
        return f(str, C2, G, str2, list, C2 == h0.a.REGEXP ? str2 : null, x3Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0081, code lost:
        if (r3 != null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Boolean h(java.math.BigDecimal r9, com.google.android.gms.internal.measurement.f0 r10, double r11) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ha.h(java.math.BigDecimal, com.google.android.gms.internal.measurement.f0, double):java.lang.Boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean i();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean j();
}