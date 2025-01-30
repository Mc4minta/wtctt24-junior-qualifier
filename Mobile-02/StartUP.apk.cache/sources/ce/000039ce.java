package com.google.firebase.crashlytics.c.g;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public enum r {
    NONE,
    JAVA_ONLY,
    ALL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r h(com.google.firebase.crashlytics.c.p.i.b bVar) {
        return n(bVar.f9054h == 2, bVar.f9055i == 2);
    }

    static r n(boolean z, boolean z2) {
        if (z) {
            if (!z2) {
                return JAVA_ONLY;
            }
            return ALL;
        }
        return NONE;
    }
}