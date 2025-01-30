package com.google.firebase.perf.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseperf.h2;
import com.google.android.gms.internal.p000firebaseperf.k0;
import com.google.android.gms.internal.p000firebaseperf.m0;
import com.google.android.gms.internal.p000firebaseperf.m4;
import com.google.android.gms.internal.p000firebaseperf.o2;
import com.google.android.gms.internal.p000firebaseperf.y0;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public class r implements Parcelable {
    public static final Parcelable.Creator<r> CREATOR = new u();
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f9341b;

    /* renamed from: c  reason: collision with root package name */
    private y0 f9342c;

    private r(String str, m0 m0Var) {
        this.f9341b = false;
        this.a = str;
        this.f9342c = new y0();
    }

    public static h2[] b(List<r> list) {
        if (list.isEmpty()) {
            return null;
        }
        h2[] h2VarArr = new h2[list.size()];
        h2 g2 = list.get(0).g();
        boolean z = false;
        for (int i2 = 1; i2 < list.size(); i2++) {
            h2 g3 = list.get(i2).g();
            if (!z && list.get(i2).f9341b) {
                h2VarArr[0] = g3;
                h2VarArr[i2] = g2;
                z = true;
            } else {
                h2VarArr[i2] = g3;
            }
        }
        if (!z) {
            h2VarArr[0] = g2;
        }
        return h2VarArr;
    }

    public static r c() {
        String replaceAll = UUID.randomUUID().toString().replaceAll("\\-", "");
        r rVar = new r(replaceAll, new m0());
        com.google.android.gms.internal.p000firebaseperf.i A = com.google.android.gms.internal.p000firebaseperf.i.A();
        rVar.f9341b = A.B() && Math.random() < ((double) A.H());
        k0 a = k0.a();
        Object[] objArr = new Object[2];
        objArr[0] = rVar.f9341b ? "Verbose" : "Non Verbose";
        objArr[1] = replaceAll;
        a.c(String.format("Creating a new %s Session: %s", objArr));
        return rVar;
    }

    public final boolean a() {
        return TimeUnit.MICROSECONDS.toMinutes(this.f9342c.a()) > com.google.android.gms.internal.p000firebaseperf.i.A().g();
    }

    public final String d() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final y0 e() {
        return this.f9342c;
    }

    public final boolean f() {
        return this.f9341b;
    }

    public final h2 g() {
        h2.a o = h2.y().o(this.a);
        if (this.f9341b) {
            o.p(o2.GAUGES_AND_SYSTEM_EVENTS);
        }
        return (h2) ((m4) o.O());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeByte(this.f9341b ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.f9342c, 0);
    }

    private r(Parcel parcel) {
        this.f9341b = false;
        this.a = parcel.readString();
        this.f9341b = parcel.readByte() != 0;
        this.f9342c = (y0) parcel.readParcelable(y0.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(Parcel parcel, u uVar) {
        this(parcel);
    }
}