package e.g.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.clearcut.i5;
import com.google.android.gms.internal.clearcut.t5;
import e.g.a.e.c.a;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class f extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<f> CREATOR = new g();
    public t5 a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f13120b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f13121c;

    /* renamed from: d  reason: collision with root package name */
    private String[] f13122d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f13123e;

    /* renamed from: f  reason: collision with root package name */
    private byte[][] f13124f;

    /* renamed from: g  reason: collision with root package name */
    private e.g.a.e.e.a[] f13125g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f13126h;

    /* renamed from: j  reason: collision with root package name */
    public final i5 f13127j;

    /* renamed from: k  reason: collision with root package name */
    public final a.c f13128k;

    /* renamed from: l  reason: collision with root package name */
    public final a.c f13129l;

    public f(t5 t5Var, i5 i5Var, a.c cVar, a.c cVar2, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr, e.g.a.e.e.a[] aVarArr, boolean z) {
        this.a = t5Var;
        this.f13127j = i5Var;
        this.f13128k = cVar;
        this.f13129l = null;
        this.f13121c = iArr;
        this.f13122d = null;
        this.f13123e = iArr2;
        this.f13124f = null;
        this.f13125g = null;
        this.f13126h = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(t5 t5Var, byte[] bArr, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr2, boolean z, e.g.a.e.e.a[] aVarArr) {
        this.a = t5Var;
        this.f13120b = bArr;
        this.f13121c = iArr;
        this.f13122d = strArr;
        this.f13127j = null;
        this.f13128k = null;
        this.f13129l = null;
        this.f13123e = iArr2;
        this.f13124f = bArr2;
        this.f13125g = aVarArr;
        this.f13126h = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (r.a(this.a, fVar.a) && Arrays.equals(this.f13120b, fVar.f13120b) && Arrays.equals(this.f13121c, fVar.f13121c) && Arrays.equals(this.f13122d, fVar.f13122d) && r.a(this.f13127j, fVar.f13127j) && r.a(this.f13128k, fVar.f13128k) && r.a(this.f13129l, fVar.f13129l) && Arrays.equals(this.f13123e, fVar.f13123e) && Arrays.deepEquals(this.f13124f, fVar.f13124f) && Arrays.equals(this.f13125g, fVar.f13125g) && this.f13126h == fVar.f13126h) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return r.b(this.a, this.f13120b, this.f13121c, this.f13122d, this.f13127j, this.f13128k, this.f13129l, this.f13123e, this.f13124f, this.f13125g, Boolean.valueOf(this.f13126h));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LogEventParcelable[");
        sb.append(this.a);
        sb.append(", LogEventBytes: ");
        sb.append(this.f13120b == null ? null : new String(this.f13120b));
        sb.append(", TestCodes: ");
        sb.append(Arrays.toString(this.f13121c));
        sb.append(", MendelPackages: ");
        sb.append(Arrays.toString(this.f13122d));
        sb.append(", LogEvent: ");
        sb.append(this.f13127j);
        sb.append(", ExtensionProducer: ");
        sb.append(this.f13128k);
        sb.append(", VeProducer: ");
        sb.append(this.f13129l);
        sb.append(", ExperimentIDs: ");
        sb.append(Arrays.toString(this.f13123e));
        sb.append(", ExperimentTokens: ");
        sb.append(Arrays.toString(this.f13124f));
        sb.append(", ExperimentTokensParcelables: ");
        sb.append(Arrays.toString(this.f13125g));
        sb.append(", AddPhenotypeExperimentTokens: ");
        sb.append(this.f13126h);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 2, this.a, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.f(parcel, 3, this.f13120b, false);
        com.google.android.gms.common.internal.safeparcel.b.m(parcel, 4, this.f13121c, false);
        com.google.android.gms.common.internal.safeparcel.b.r(parcel, 5, this.f13122d, false);
        com.google.android.gms.common.internal.safeparcel.b.m(parcel, 6, this.f13123e, false);
        com.google.android.gms.common.internal.safeparcel.b.g(parcel, 7, this.f13124f, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 8, this.f13126h);
        com.google.android.gms.common.internal.safeparcel.b.t(parcel, 9, this.f13125g, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }
}