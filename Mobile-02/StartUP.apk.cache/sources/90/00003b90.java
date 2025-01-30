package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private AtomicLong f9377b;

    public b(String str) {
        this.a = str;
        this.f9377b = new AtomicLong(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long a() {
        return this.f9377b.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String b() {
        return this.a;
    }

    public final void c(long j2) {
        this.f9377b.addAndGet(j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(long j2) {
        this.f9377b.set(j2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeLong(this.f9377b.get());
    }

    private b(Parcel parcel) {
        this.a = parcel.readString();
        this.f9377b = new AtomicLong(parcel.readLong());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(Parcel parcel, a aVar) {
        this(parcel);
    }
}