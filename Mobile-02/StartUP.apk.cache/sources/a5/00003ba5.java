package com.google.firebase.remoteconfig;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public class FirebaseRemoteConfigServerException extends FirebaseRemoteConfigException {
    private final int a;

    public FirebaseRemoteConfigServerException(int i2, String str) {
        super(str);
        this.a = i2;
    }

    public int a() {
        return this.a;
    }

    public FirebaseRemoteConfigServerException(int i2, String str, Throwable th) {
        super(str, th);
        this.a = i2;
    }
}