package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import e.g.a.e.d.c.j;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d implements e<TokenData> {
    private final /* synthetic */ Account a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f6028b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Bundle f6029c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Account account, String str, Bundle bundle) {
        this.a = account;
        this.f6028b = str;
        this.f6029c = bundle;
    }

    @Override // com.google.android.gms.auth.e
    public final /* synthetic */ TokenData a(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Object h2;
        com.google.android.gms.common.l.a aVar;
        h2 = c.h(j.n(iBinder).M0(this.a, this.f6028b, this.f6029c));
        Bundle bundle = (Bundle) h2;
        TokenData i1 = TokenData.i1(bundle, "tokenDetails");
        if (i1 != null) {
            return i1;
        }
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        e.g.a.e.d.c.f n = e.g.a.e.d.c.f.n(string);
        boolean z = false;
        if (e.g.a.e.d.c.f.h(n)) {
            aVar = c.f6027e;
            String valueOf = String.valueOf(n);
            StringBuilder sb = new StringBuilder(valueOf.length() + 31);
            sb.append("isUserRecoverableError status: ");
            sb.append(valueOf);
            aVar.f("GoogleAuthUtil", sb.toString());
            throw new UserRecoverableAuthException(string, intent);
        }
        if (e.g.a.e.d.c.f.NETWORK_ERROR.equals(n) || e.g.a.e.d.c.f.SERVICE_UNAVAILABLE.equals(n) || e.g.a.e.d.c.f.INTNERNAL_ERROR.equals(n)) {
            z = true;
        }
        if (z) {
            throw new IOException(string);
        }
        throw new GoogleAuthException(string);
    }
}