package com.google.firebase.crashlytics.c.l;

import java.io.File;
import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class e implements Comparator {
    private static final e a = new e();

    private e() {
    }

    public static Comparator a() {
        return a;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int compareTo;
        compareTo = ((File) obj2).getName().compareTo(((File) obj).getName());
        return compareTo;
    }
}