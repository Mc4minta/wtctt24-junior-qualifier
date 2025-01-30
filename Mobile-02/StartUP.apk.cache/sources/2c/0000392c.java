package com.google.firebase;

import com.google.android.gms.common.internal.t;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class FirebaseException extends Exception {
    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public FirebaseException() {
    }

    public FirebaseException(String str) {
        super(t.h(str, "Detail message must not be empty"));
    }

    public FirebaseException(String str, Throwable th) {
        super(t.h(str, "Detail message must not be empty"), th);
    }
}