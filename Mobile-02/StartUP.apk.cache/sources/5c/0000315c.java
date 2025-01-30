package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.t;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class Scope extends com.google.android.gms.common.internal.safeparcel.a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new m();
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6032b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Scope(int i2, String str) {
        t.h(str, "scopeUri must not be null or empty");
        this.a = i2;
        this.f6032b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f6032b.equals(((Scope) obj).f6032b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f6032b.hashCode();
    }

    public final String i1() {
        return this.f6032b;
    }

    public final String toString() {
        return this.f6032b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 1, this.a);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 2, i1(), false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }

    public Scope(String str) {
        this(1, str);
    }
}