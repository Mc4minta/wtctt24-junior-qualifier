package com.google.android.gms.auth;

import android.content.Intent;

/* loaded from: classes2.dex */
public class UserRecoverableAuthException extends GoogleAuthException {
    private final Intent a;

    public UserRecoverableAuthException(String str, Intent intent) {
        super(str);
        this.a = intent;
    }

    public Intent a() {
        if (this.a == null) {
            return null;
        }
        return new Intent(this.a);
    }
}