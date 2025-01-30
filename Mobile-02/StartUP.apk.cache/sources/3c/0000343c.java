package com.google.android.gms.internal.p000firebaseperf;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.y0  reason: invalid package */
/* loaded from: classes2.dex */
public class y0 implements Parcelable {
    public static final Parcelable.Creator<y0> CREATOR = new x0();
    private long a;

    /* renamed from: b  reason: collision with root package name */
    private long f6983b;

    public y0() {
        this.a = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.f6983b = System.nanoTime();
    }

    public final long a() {
        return TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - this.f6983b);
    }

    public final void b() {
        this.a = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.f6983b = System.nanoTime();
    }

    public final long c() {
        return this.a;
    }

    public final long d() {
        return this.a + a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final long e(y0 y0Var) {
        return TimeUnit.NANOSECONDS.toMicros(y0Var.f6983b - this.f6983b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.a);
        parcel.writeLong(this.f6983b);
    }

    private y0(Parcel parcel) {
        this.a = parcel.readLong();
        this.f6983b = parcel.readLong();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ y0(Parcel parcel, x0 x0Var) {
        this(parcel);
    }
}