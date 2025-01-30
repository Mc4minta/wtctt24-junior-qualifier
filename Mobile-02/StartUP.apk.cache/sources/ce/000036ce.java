package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.coinbase.ApiConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.measurement.b1;
import com.google.android.gms.internal.measurement.t0;
import com.google.android.gms.internal.measurement.v0;
import com.google.android.gms.internal.measurement.x0;
import com.google.android.gms.internal.measurement.zzfm;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class r9 extends k9 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public r9(j9 j9Var) {
        super(j9Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.android.gms.internal.measurement.v0 A(com.google.android.gms.internal.measurement.t0 t0Var, String str) {
        for (com.google.android.gms.internal.measurement.v0 v0Var : t0Var.C()) {
            if (v0Var.M().equals(str)) {
                return v0Var;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <Builder extends com.google.android.gms.internal.measurement.x5> Builder B(Builder builder, byte[] bArr) throws zzfm {
        com.google.android.gms.internal.measurement.z3 c2 = com.google.android.gms.internal.measurement.z3.c();
        if (c2 != null) {
            return (Builder) builder.z0(bArr, c2);
        }
        return (Builder) builder.a0(bArr);
    }

    private static String F(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Long> G(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            long j2 = 0;
            for (int i3 = 0; i3 < 64; i3++) {
                int i4 = (i2 << 6) + i3;
                if (i4 < bitSet.length()) {
                    if (bitSet.get(i4)) {
                        j2 |= 1 << i3;
                    }
                }
            }
            arrayList.add(Long.valueOf(j2));
        }
        return arrayList;
    }

    private static List<com.google.android.gms.internal.measurement.v0> I(Bundle[] bundleArr) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : bundleArr) {
            if (bundle != null) {
                v0.a c0 = com.google.android.gms.internal.measurement.v0.c0();
                for (String str : bundle.keySet()) {
                    v0.a A = com.google.android.gms.internal.measurement.v0.c0().A(str);
                    Object obj = bundle.get(str);
                    if (obj instanceof Long) {
                        A.w(((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        A.C((String) obj);
                    } else if (obj instanceof Double) {
                        A.v(((Double) obj).doubleValue());
                    }
                    c0.x(A);
                }
                if (c0.E() > 0) {
                    arrayList.add((com.google.android.gms.internal.measurement.v0) ((com.google.android.gms.internal.measurement.n4) c0.j()));
                }
            }
        }
        return arrayList;
    }

    private static void M(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("  ");
        }
    }

    private final void N(StringBuilder sb, int i2, com.google.android.gms.internal.measurement.e0 e0Var) {
        if (e0Var == null) {
            return;
        }
        M(sb, i2);
        sb.append("filter {\n");
        if (e0Var.H()) {
            Q(sb, i2, "complement", Boolean.valueOf(e0Var.I()));
        }
        if (e0Var.J()) {
            Q(sb, i2, "param_name", j().A(e0Var.K()));
        }
        if (e0Var.D()) {
            int i3 = i2 + 1;
            com.google.android.gms.internal.measurement.h0 E = e0Var.E();
            if (E != null) {
                M(sb, i3);
                sb.append("string_filter");
                sb.append(" {\n");
                if (E.B()) {
                    Q(sb, i3, "match_type", E.C().name());
                }
                if (E.D()) {
                    Q(sb, i3, "expression", E.E());
                }
                if (E.F()) {
                    Q(sb, i3, "case_sensitive", Boolean.valueOf(E.G()));
                }
                if (E.I() > 0) {
                    M(sb, i3 + 1);
                    sb.append("expression_list {\n");
                    for (String str : E.H()) {
                        M(sb, i3 + 2);
                        sb.append(str);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                M(sb, i3);
                sb.append("}\n");
            }
        }
        if (e0Var.F()) {
            O(sb, i2 + 1, "number_filter", e0Var.G());
        }
        M(sb, i2);
        sb.append("}\n");
    }

    private final void O(StringBuilder sb, int i2, String str, com.google.android.gms.internal.measurement.f0 f0Var) {
        if (f0Var == null) {
            return;
        }
        M(sb, i2);
        sb.append(str);
        sb.append(" {\n");
        if (f0Var.B()) {
            Q(sb, i2, "comparison_type", f0Var.C().name());
        }
        if (f0Var.D()) {
            Q(sb, i2, "match_as_float", Boolean.valueOf(f0Var.E()));
        }
        if (f0Var.F()) {
            Q(sb, i2, "comparison_value", f0Var.G());
        }
        if (f0Var.H()) {
            Q(sb, i2, "min_comparison_value", f0Var.I());
        }
        if (f0Var.J()) {
            Q(sb, i2, "max_comparison_value", f0Var.K());
        }
        M(sb, i2);
        sb.append("}\n");
    }

    private static void P(StringBuilder sb, int i2, String str, com.google.android.gms.internal.measurement.z0 z0Var, String str2) {
        if (z0Var == null) {
            return;
        }
        M(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (z0Var.Q() != 0) {
            M(sb, 4);
            sb.append("results: ");
            int i3 = 0;
            for (Long l2 : z0Var.N()) {
                int i4 = i3 + 1;
                if (i3 != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                i3 = i4;
            }
            sb.append('\n');
        }
        if (z0Var.H() != 0) {
            M(sb, 4);
            sb.append("status: ");
            int i5 = 0;
            for (Long l3 : z0Var.C()) {
                int i6 = i5 + 1;
                if (i5 != 0) {
                    sb.append(", ");
                }
                sb.append(l3);
                i5 = i6;
            }
            sb.append('\n');
        }
        if (z0Var.W() != 0) {
            M(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i7 = 0;
            for (com.google.android.gms.internal.measurement.s0 s0Var : z0Var.U()) {
                int i8 = i7 + 1;
                if (i7 != 0) {
                    sb.append(", ");
                }
                sb.append(s0Var.F() ? Integer.valueOf(s0Var.G()) : null);
                sb.append(":");
                sb.append(s0Var.H() ? Long.valueOf(s0Var.I()) : null);
                i7 = i8;
            }
            sb.append("}\n");
        }
        if (z0Var.Y() != 0) {
            M(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i9 = 0;
            for (com.google.android.gms.internal.measurement.a1 a1Var : z0Var.X()) {
                int i10 = i9 + 1;
                if (i9 != 0) {
                    sb.append(", ");
                }
                sb.append(a1Var.F() ? Integer.valueOf(a1Var.G()) : null);
                sb.append(": [");
                int i11 = 0;
                for (Long l4 : a1Var.I()) {
                    long longValue = l4.longValue();
                    int i12 = i11 + 1;
                    if (i11 != 0) {
                        sb.append(", ");
                    }
                    sb.append(longValue);
                    i11 = i12;
                }
                sb.append("]");
                i9 = i10;
            }
            sb.append("}\n");
        }
        M(sb, 3);
        sb.append("}\n");
    }

    private static void Q(StringBuilder sb, int i2, String str, Object obj) {
        if (obj == null) {
            return;
        }
        M(sb, i2 + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    private final void R(StringBuilder sb, int i2, List<com.google.android.gms.internal.measurement.v0> list) {
        if (list == null) {
            return;
        }
        int i3 = i2 + 1;
        for (com.google.android.gms.internal.measurement.v0 v0Var : list) {
            if (v0Var != null) {
                M(sb, i3);
                sb.append("param {\n");
                if (com.google.android.gms.internal.measurement.t8.b() && o().u(r.H0)) {
                    Q(sb, i3, ApiConstants.NAME, v0Var.L() ? j().A(v0Var.M()) : null);
                    Q(sb, i3, "string_value", v0Var.R() ? v0Var.S() : null);
                    Q(sb, i3, "int_value", v0Var.V() ? Long.valueOf(v0Var.W()) : null);
                    Q(sb, i3, "double_value", v0Var.X() ? Double.valueOf(v0Var.Y()) : null);
                    if (v0Var.b0() > 0) {
                        R(sb, i3, v0Var.Z());
                    }
                } else {
                    Q(sb, i3, ApiConstants.NAME, j().A(v0Var.M()));
                    Q(sb, i3, "string_value", v0Var.S());
                    Q(sb, i3, "int_value", v0Var.V() ? Long.valueOf(v0Var.W()) : null);
                    Q(sb, i3, "double_value", v0Var.X() ? Double.valueOf(v0Var.Y()) : null);
                }
                M(sb, i3);
                sb.append("}\n");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean T(p pVar, z9 z9Var) {
        com.google.android.gms.common.internal.t.k(pVar);
        com.google.android.gms.common.internal.t.k(z9Var);
        return (TextUtils.isEmpty(z9Var.f7972b) && TextUtils.isEmpty(z9Var.v)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean U(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean V(List<Long> list, int i2) {
        if (i2 < (list.size() << 6)) {
            return ((1 << (i2 % 64)) & list.get(i2 / 64).longValue()) != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int x(x0.a aVar, String str) {
        if (aVar == null) {
            return -1;
        }
        for (int i2 = 0; i2 < aVar.Z(); i2++) {
            if (str.equals(aVar.X(i2).P())) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String C(com.google.android.gms.internal.measurement.d0 d0Var) {
        if (d0Var == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (d0Var.G()) {
            Q(sb, 0, "filter_id", Integer.valueOf(d0Var.H()));
        }
        Q(sb, 0, "event_name", j().x(d0Var.I()));
        String F = F(d0Var.N(), d0Var.O(), d0Var.Q());
        if (!F.isEmpty()) {
            Q(sb, 0, "filter_type", F);
        }
        if (d0Var.L()) {
            O(sb, 1, "event_count_filter", d0Var.M());
        }
        if (d0Var.K() > 0) {
            sb.append("  filters {\n");
            for (com.google.android.gms.internal.measurement.e0 e0Var : d0Var.J()) {
                N(sb, 2, e0Var);
            }
        }
        M(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String D(com.google.android.gms.internal.measurement.g0 g0Var) {
        if (g0Var == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (g0Var.D()) {
            Q(sb, 0, "filter_id", Integer.valueOf(g0Var.E()));
        }
        Q(sb, 0, "property_name", j().B(g0Var.F()));
        String F = F(g0Var.H(), g0Var.I(), g0Var.K());
        if (!F.isEmpty()) {
            Q(sb, 0, "filter_type", F);
        }
        N(sb, 1, g0Var.G());
        sb.append("}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String E(com.google.android.gms.internal.measurement.w0 w0Var) {
        if (w0Var == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (com.google.android.gms.internal.measurement.x0 x0Var : w0Var.C()) {
            if (x0Var != null) {
                M(sb, 1);
                sb.append("bundle {\n");
                if (x0Var.W()) {
                    Q(sb, 1, "protocol_version", Integer.valueOf(x0Var.A0()));
                }
                Q(sb, 1, "platform", x0Var.F2());
                if (x0Var.O2()) {
                    Q(sb, 1, "gmp_version", Long.valueOf(x0Var.X()));
                }
                if (x0Var.Y()) {
                    Q(sb, 1, "uploading_gmp_version", Long.valueOf(x0Var.Z()));
                }
                if (x0Var.O0()) {
                    Q(sb, 1, "dynamite_version", Long.valueOf(x0Var.P0()));
                }
                if (x0Var.t0()) {
                    Q(sb, 1, "config_version", Long.valueOf(x0Var.u0()));
                }
                Q(sb, 1, "gmp_app_id", x0Var.k0());
                Q(sb, 1, "admob_app_id", x0Var.N0());
                Q(sb, 1, "app_id", x0Var.M2());
                Q(sb, 1, "app_version", x0Var.N2());
                if (x0Var.q0()) {
                    Q(sb, 1, "app_version_major", Integer.valueOf(x0Var.r0()));
                }
                Q(sb, 1, "firebase_instance_id", x0Var.p0());
                if (x0Var.f0()) {
                    Q(sb, 1, "dev_cert_hash", Long.valueOf(x0Var.g0()));
                }
                Q(sb, 1, "app_store", x0Var.L2());
                if (x0Var.Q1()) {
                    Q(sb, 1, "upload_timestamp_millis", Long.valueOf(x0Var.R1()));
                }
                if (x0Var.c2()) {
                    Q(sb, 1, "start_timestamp_millis", Long.valueOf(x0Var.d2()));
                }
                if (x0Var.n2()) {
                    Q(sb, 1, "end_timestamp_millis", Long.valueOf(x0Var.o2()));
                }
                if (x0Var.v2()) {
                    Q(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(x0Var.w2()));
                }
                if (x0Var.B2()) {
                    Q(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(x0Var.C2()));
                }
                Q(sb, 1, "app_instance_id", x0Var.e0());
                Q(sb, 1, "resettable_device_id", x0Var.b0());
                Q(sb, 1, "device_id", x0Var.s0());
                Q(sb, 1, "ds_id", x0Var.x0());
                if (x0Var.c0()) {
                    Q(sb, 1, "limited_ad_tracking", Boolean.valueOf(x0Var.d0()));
                }
                Q(sb, 1, "os_version", x0Var.G2());
                Q(sb, 1, "device_model", x0Var.H2());
                Q(sb, 1, "user_default_language", x0Var.I2());
                if (x0Var.J2()) {
                    Q(sb, 1, "time_zone_offset_minutes", Integer.valueOf(x0Var.K2()));
                }
                if (x0Var.h0()) {
                    Q(sb, 1, "bundle_sequential_index", Integer.valueOf(x0Var.i0()));
                }
                if (x0Var.l0()) {
                    Q(sb, 1, "service_upload", Boolean.valueOf(x0Var.m0()));
                }
                Q(sb, 1, "health_monitor", x0Var.j0());
                if (!o().u(r.Q0) && x0Var.v0() && x0Var.w0() != 0) {
                    Q(sb, 1, "android_id", Long.valueOf(x0Var.w0()));
                }
                if (x0Var.y0()) {
                    Q(sb, 1, "retry_counter", Integer.valueOf(x0Var.M0()));
                }
                List<com.google.android.gms.internal.measurement.b1> u1 = x0Var.u1();
                if (u1 != null) {
                    for (com.google.android.gms.internal.measurement.b1 b1Var : u1) {
                        if (b1Var != null) {
                            M(sb, 2);
                            sb.append("user_property {\n");
                            Q(sb, 2, "set_timestamp_millis", b1Var.I() ? Long.valueOf(b1Var.J()) : null);
                            Q(sb, 2, ApiConstants.NAME, j().B(b1Var.P()));
                            Q(sb, 2, "string_value", b1Var.S());
                            Q(sb, 2, "int_value", b1Var.T() ? Long.valueOf(b1Var.U()) : null);
                            Q(sb, 2, "double_value", b1Var.V() ? Double.valueOf(b1Var.W()) : null);
                            M(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.r0> n0 = x0Var.n0();
                String M2 = x0Var.M2();
                if (n0 != null) {
                    for (com.google.android.gms.internal.measurement.r0 r0Var : n0) {
                        if (r0Var != null) {
                            M(sb, 2);
                            sb.append("audience_membership {\n");
                            if (r0Var.H()) {
                                Q(sb, 2, "audience_id", Integer.valueOf(r0Var.I()));
                            }
                            if (r0Var.O()) {
                                Q(sb, 2, "new_audience", Boolean.valueOf(r0Var.P()));
                            }
                            P(sb, 2, "current_data", r0Var.L(), M2);
                            if (r0Var.M()) {
                                P(sb, 2, "previous_data", r0Var.N(), M2);
                            }
                            M(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.t0> b1 = x0Var.b1();
                if (b1 != null) {
                    for (com.google.android.gms.internal.measurement.t0 t0Var : b1) {
                        if (t0Var != null) {
                            M(sb, 2);
                            sb.append("event {\n");
                            Q(sb, 2, ApiConstants.NAME, j().x(t0Var.T()));
                            if (t0Var.U()) {
                                Q(sb, 2, "timestamp_millis", Long.valueOf(t0Var.V()));
                            }
                            if (t0Var.W()) {
                                Q(sb, 2, "previous_timestamp_millis", Long.valueOf(t0Var.X()));
                            }
                            if (t0Var.Y()) {
                                Q(sb, 2, "count", Integer.valueOf(t0Var.Z()));
                            }
                            if (t0Var.P() != 0) {
                                R(sb, 2, t0Var.C());
                            }
                            M(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                M(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<Long> H(List<Long> list, List<Integer> list2) {
        int i2;
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                f().K().b("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    f().K().c("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i3 = size2;
            i2 = size;
            size = i3;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void J(t0.a aVar, String str, Object obj) {
        List<com.google.android.gms.internal.measurement.v0> D = aVar.D();
        int i2 = 0;
        while (true) {
            if (i2 >= D.size()) {
                i2 = -1;
                break;
            } else if (str.equals(D.get(i2).M())) {
                break;
            } else {
                i2++;
            }
        }
        v0.a A = com.google.android.gms.internal.measurement.v0.c0().A(str);
        if (obj instanceof Long) {
            A.w(((Long) obj).longValue());
        } else if (obj instanceof String) {
            A.C((String) obj);
        } else if (obj instanceof Double) {
            A.v(((Double) obj).doubleValue());
        } else if (com.google.android.gms.internal.measurement.t8.b() && o().u(r.J0) && (obj instanceof Bundle[])) {
            A.y(I((Bundle[]) obj));
        }
        if (i2 >= 0) {
            aVar.u(i2, A);
        } else {
            aVar.x(A);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void K(v0.a aVar, Object obj) {
        com.google.android.gms.common.internal.t.k(obj);
        aVar.u().B().D().F();
        if (obj instanceof String) {
            aVar.C((String) obj);
        } else if (obj instanceof Long) {
            aVar.w(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            aVar.v(((Double) obj).doubleValue());
        } else if (com.google.android.gms.internal.measurement.t8.b() && o().u(r.J0) && (obj instanceof Bundle[])) {
            aVar.y(I((Bundle[]) obj));
        } else {
            f().H().b("Ignoring invalid (type) event param value", obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void L(b1.a aVar, Object obj) {
        com.google.android.gms.common.internal.t.k(obj);
        aVar.u().y().C();
        if (obj instanceof String) {
            aVar.B((String) obj);
        } else if (obj instanceof Long) {
            aVar.A(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            aVar.v(((Double) obj).doubleValue());
        } else {
            f().H().b("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean S(long j2, long j3) {
        return j2 == 0 || j3 <= 0 || Math.abs(i().a() - j2) > j3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object W(com.google.android.gms.internal.measurement.t0 t0Var, String str) {
        com.google.android.gms.internal.measurement.v0 A = A(t0Var, str);
        if (A != null) {
            if (A.R()) {
                return A.S();
            }
            if (A.V()) {
                return Long.valueOf(A.W());
            }
            if (A.X()) {
                return Double.valueOf(A.Y());
            }
            if (com.google.android.gms.internal.measurement.t8.b() && o().u(r.J0) && A.b0() > 0) {
                List<com.google.android.gms.internal.measurement.v0> Z = A.Z();
                ArrayList arrayList = new ArrayList();
                for (com.google.android.gms.internal.measurement.v0 v0Var : Z) {
                    if (v0Var != null) {
                        Bundle bundle = new Bundle();
                        for (com.google.android.gms.internal.measurement.v0 v0Var2 : v0Var.Z()) {
                            if (v0Var2.R()) {
                                bundle.putString(v0Var2.M(), v0Var2.S());
                            } else if (v0Var2.V()) {
                                bundle.putLong(v0Var2.M(), v0Var2.W());
                            } else if (v0Var2.X()) {
                                bundle.putDouble(v0Var2.M(), v0Var2.Y());
                            }
                        }
                        if (!bundle.isEmpty()) {
                            arrayList.add(bundle);
                        }
                    }
                }
                return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] X(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            f().H().b("Failed to ungzip content", e2);
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] Y(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            f().H().b("Failed to gzip content", e2);
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<Integer> Z() {
        Map<String, String> c2 = r.c(this.f7614b.h());
        if (c2 == null || c2.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int intValue = r.Q.a(null).intValue();
        for (Map.Entry<String, String> entry : c2.entrySet()) {
            if (entry.getKey().startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt(entry.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            f().K().b("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                        continue;
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e2) {
                    f().K().b("Experiment ID NumberFormatException", e2);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ j e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ x3 f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ ja g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ Context h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.util.e i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v3 j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ y4 l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v9 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ k4 n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ ka o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.g9
    public final /* bridge */ /* synthetic */ aa p() {
        return super.p();
    }

    @Override // com.google.android.gms.measurement.internal.g9
    public final /* bridge */ /* synthetic */ r9 q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.g9
    public final /* bridge */ /* synthetic */ e r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.g9
    public final /* bridge */ /* synthetic */ w4 s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.k9
    protected final boolean w() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long y(byte[] bArr) {
        com.google.android.gms.common.internal.t.k(bArr);
        m().d();
        MessageDigest I0 = v9.I0();
        if (I0 == null) {
            f().H().a("Failed to get MD5");
            return 0L;
        }
        return v9.A(I0.digest(bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T extends Parcelable> T z(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return creator.createFromParcel(obtain);
        } catch (SafeParcelReader.ParseException unused) {
            f().H().a("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
        }
    }
}