package e.g.a.e.e;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class a extends com.google.android.gms.common.internal.safeparcel.a {
    private static final byte[][] a;

    /* renamed from: b  reason: collision with root package name */
    private static final a f13160b;

    /* renamed from: g  reason: collision with root package name */
    private final String f13165g;

    /* renamed from: h  reason: collision with root package name */
    private final byte[] f13166h;

    /* renamed from: j  reason: collision with root package name */
    private final byte[][] f13167j;

    /* renamed from: k  reason: collision with root package name */
    private final byte[][] f13168k;

    /* renamed from: l  reason: collision with root package name */
    private final byte[][] f13169l;
    private final byte[][] m;
    private final int[] n;
    private final byte[][] p;
    public static final Parcelable.Creator<a> CREATOR = new g();

    /* renamed from: c  reason: collision with root package name */
    private static final InterfaceC0301a f13161c = new c();

    /* renamed from: d  reason: collision with root package name */
    private static final InterfaceC0301a f13162d = new d();

    /* renamed from: e  reason: collision with root package name */
    private static final InterfaceC0301a f13163e = new e();

    /* renamed from: f  reason: collision with root package name */
    private static final InterfaceC0301a f13164f = new f();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e.g.a.e.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0301a {
    }

    static {
        byte[][] bArr = new byte[0];
        a = bArr;
        f13160b = new a("", null, bArr, bArr, bArr, bArr, null, null);
    }

    public a(String str, byte[] bArr, byte[][] bArr2, byte[][] bArr3, byte[][] bArr4, byte[][] bArr5, int[] iArr, byte[][] bArr6) {
        this.f13165g = str;
        this.f13166h = bArr;
        this.f13167j = bArr2;
        this.f13168k = bArr3;
        this.f13169l = bArr4;
        this.m = bArr5;
        this.n = iArr;
        this.p = bArr6;
    }

    private static List<Integer> i1(int[] iArr) {
        if (iArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(i2));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static List<String> j1(byte[][] bArr) {
        if (bArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte[] bArr2 : bArr) {
            arrayList.add(Base64.encodeToString(bArr2, 3));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static void k1(StringBuilder sb, String str, byte[][] bArr) {
        String str2;
        sb.append(str);
        sb.append("=");
        if (bArr == null) {
            str2 = "null";
        } else {
            sb.append("(");
            int length = bArr.length;
            boolean z = true;
            int i2 = 0;
            while (i2 < length) {
                byte[] bArr2 = bArr[i2];
                if (!z) {
                    sb.append(", ");
                }
                sb.append("'");
                sb.append(Base64.encodeToString(bArr2, 3));
                sb.append("'");
                i2++;
                z = false;
            }
            str2 = ")";
        }
        sb.append(str2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (j.a(this.f13165g, aVar.f13165g) && Arrays.equals(this.f13166h, aVar.f13166h) && j.a(j1(this.f13167j), j1(aVar.f13167j)) && j.a(j1(this.f13168k), j1(aVar.f13168k)) && j.a(j1(this.f13169l), j1(aVar.f13169l)) && j.a(j1(this.m), j1(aVar.m)) && j.a(i1(this.n), i1(aVar.n)) && j.a(j1(this.p), j1(aVar.p))) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String sb;
        StringBuilder sb2 = new StringBuilder("ExperimentTokens");
        sb2.append("(");
        String str = this.f13165g;
        if (str == null) {
            sb = "null";
        } else {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 2);
            sb3.append("'");
            sb3.append(str);
            sb3.append("'");
            sb = sb3.toString();
        }
        sb2.append(sb);
        sb2.append(", ");
        byte[] bArr = this.f13166h;
        sb2.append("direct");
        sb2.append("=");
        if (bArr == null) {
            sb2.append("null");
        } else {
            sb2.append("'");
            sb2.append(Base64.encodeToString(bArr, 3));
            sb2.append("'");
        }
        sb2.append(", ");
        k1(sb2, "GAIA", this.f13167j);
        sb2.append(", ");
        k1(sb2, "PSEUDO", this.f13168k);
        sb2.append(", ");
        k1(sb2, "ALWAYS", this.f13169l);
        sb2.append(", ");
        k1(sb2, "OTHER", this.m);
        sb2.append(", ");
        int[] iArr = this.n;
        sb2.append("weak");
        sb2.append("=");
        if (iArr == null) {
            sb2.append("null");
        } else {
            sb2.append("(");
            int length = iArr.length;
            boolean z = true;
            int i2 = 0;
            while (i2 < length) {
                int i3 = iArr[i2];
                if (!z) {
                    sb2.append(", ");
                }
                sb2.append(i3);
                i2++;
                z = false;
            }
            sb2.append(")");
        }
        sb2.append(", ");
        k1(sb2, "directs", this.p);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 2, this.f13165g, false);
        com.google.android.gms.common.internal.safeparcel.b.f(parcel, 3, this.f13166h, false);
        com.google.android.gms.common.internal.safeparcel.b.g(parcel, 4, this.f13167j, false);
        com.google.android.gms.common.internal.safeparcel.b.g(parcel, 5, this.f13168k, false);
        com.google.android.gms.common.internal.safeparcel.b.g(parcel, 6, this.f13169l, false);
        com.google.android.gms.common.internal.safeparcel.b.g(parcel, 7, this.m, false);
        com.google.android.gms.common.internal.safeparcel.b.m(parcel, 8, this.n, false);
        com.google.android.gms.common.internal.safeparcel.b.g(parcel, 9, this.p, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a2);
    }
}