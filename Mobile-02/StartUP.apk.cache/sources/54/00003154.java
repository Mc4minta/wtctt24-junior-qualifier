package com.google.android.gms.common;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class UserRecoverableException extends Exception {
    private final Intent a;

    public UserRecoverableException(String str, Intent intent) {
        super(str);
        this.a = intent;
    }

    public Intent a() {
        return new Intent(this.a);
    }
}