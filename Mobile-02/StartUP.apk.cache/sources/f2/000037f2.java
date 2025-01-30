package com.google.api.client.googleapis.extensions.android.gms.auth;

import com.google.android.gms.auth.GoogleAuthException;
import e.g.b.a.d.y;
import java.io.IOException;

/* loaded from: classes2.dex */
public class GoogleAuthIOException extends IOException {
    public GoogleAuthIOException(GoogleAuthException googleAuthException) {
        initCause((Throwable) y.d(googleAuthException));
    }

    @Override // java.lang.Throwable
    /* renamed from: a */
    public GoogleAuthException getCause() {
        return (GoogleAuthException) super.getCause();
    }
}