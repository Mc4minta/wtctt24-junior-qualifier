package com.google.firebase.f;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes2.dex */
public interface c {

    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    /* loaded from: classes2.dex */
    public enum a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);
        

        /* renamed from: f  reason: collision with root package name */
        private final int f9103f;

        a(int i2) {
            this.f9103f = i2;
        }

        public int h() {
            return this.f9103f;
        }
    }

    a a(String str);
}