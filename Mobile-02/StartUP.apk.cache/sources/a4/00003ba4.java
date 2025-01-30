package com.google.firebase.remoteconfig;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public class FirebaseRemoteConfigFetchThrottledException extends FirebaseRemoteConfigFetchException {
    private final long a;

    public FirebaseRemoteConfigFetchThrottledException(long j2) {
        this("Fetch was throttled.", j2);
    }

    public FirebaseRemoteConfigFetchThrottledException(String str, long j2) {
        super(str);
        this.a = j2;
    }
}