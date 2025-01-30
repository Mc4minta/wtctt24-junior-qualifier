package com.google.api.client.googleapis.extensions.android.gms.auth;

import android.content.Intent;
import com.google.android.gms.auth.UserRecoverableAuthException;

/* loaded from: classes2.dex */
public class UserRecoverableAuthIOException extends GoogleAuthIOException {
    public UserRecoverableAuthIOException(UserRecoverableAuthException userRecoverableAuthException) {
        super(userRecoverableAuthException);
    }

    @Override // com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAuthIOException, java.lang.Throwable
    /* renamed from: b */
    public UserRecoverableAuthException getCause() {
        return (UserRecoverableAuthException) super.getCause();
    }

    public final Intent c() {
        return getCause().a();
    }
}