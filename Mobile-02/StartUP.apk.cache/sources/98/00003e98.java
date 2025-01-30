package com.rd.c.c;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* compiled from: PositionSavedState.java */
/* loaded from: classes2.dex */
public class c extends View.BaseSavedState {
    public static final Parcelable.Creator<c> CREATOR = new a();
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private int f10654b;

    /* renamed from: c  reason: collision with root package name */
    private int f10655c;

    /* compiled from: PositionSavedState.java */
    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<c> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public c[] newArray(int i2) {
            return new c[i2];
        }
    }

    /* synthetic */ c(Parcel parcel, a aVar) {
        this(parcel);
    }

    public int a() {
        return this.f10655c;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.f10654b;
    }

    public void d(int i2) {
        this.f10655c = i2;
    }

    public void e(int i2) {
        this.a = i2;
    }

    public void f(int i2) {
        this.f10654b = i2;
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.a);
        parcel.writeInt(this.f10654b);
        parcel.writeInt(this.f10655c);
    }

    public c(Parcelable parcelable) {
        super(parcelable);
    }

    private c(Parcel parcel) {
        super(parcel);
        this.a = parcel.readInt();
        this.f10654b = parcel.readInt();
        this.f10655c = parcel.readInt();
    }
}