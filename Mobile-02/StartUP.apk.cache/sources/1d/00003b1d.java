package com.google.firebase.installations;

import com.google.firebase.FirebaseException;

/* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
/* loaded from: classes2.dex */
public class FirebaseInstallationsException extends FirebaseException {
    private final a a;

    /* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
    /* loaded from: classes2.dex */
    public enum a {
        BAD_CONFIG
    }

    public FirebaseInstallationsException(a aVar) {
        this.a = aVar;
    }

    public FirebaseInstallationsException(String str, a aVar) {
        super(str);
        this.a = aVar;
    }
}