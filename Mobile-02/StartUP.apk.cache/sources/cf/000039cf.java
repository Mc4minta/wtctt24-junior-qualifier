package com.google.firebase.crashlytics.c.g;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public enum s {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    

    /* renamed from: f  reason: collision with root package name */
    private final int f8794f;

    s(int i2) {
        this.f8794f = i2;
    }

    public static s h(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }

    public int n() {
        return this.f8794f;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.f8794f);
    }
}