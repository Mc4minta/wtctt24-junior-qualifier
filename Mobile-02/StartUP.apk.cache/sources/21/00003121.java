package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
public class d implements com.google.android.gms.common.api.i {
    private Status a;

    /* renamed from: b  reason: collision with root package name */
    private GoogleSignInAccount f5989b;

    public d(GoogleSignInAccount googleSignInAccount, Status status) {
        this.f5989b = googleSignInAccount;
        this.a = status;
    }

    public GoogleSignInAccount a() {
        return this.f5989b;
    }

    @Override // com.google.android.gms.common.api.i
    public Status getStatus() {
        return this.a;
    }
}