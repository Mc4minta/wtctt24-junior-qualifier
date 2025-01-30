package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public class u extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<u> CREATOR = new g0();
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final Account f6269b;

    /* renamed from: c  reason: collision with root package name */
    private final int f6270c;

    /* renamed from: d  reason: collision with root package name */
    private final GoogleSignInAccount f6271d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(int i2, Account account, int i3, GoogleSignInAccount googleSignInAccount) {
        this.a = i2;
        this.f6269b = account;
        this.f6270c = i3;
        this.f6271d = googleSignInAccount;
    }

    public int i1() {
        return this.f6270c;
    }

    public GoogleSignInAccount j1() {
        return this.f6271d;
    }

    public Account m() {
        return this.f6269b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 1, this.a);
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 2, m(), i2, false);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 3, i1());
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 4, j1(), i2, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }

    public u(Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i2, googleSignInAccount);
    }
}