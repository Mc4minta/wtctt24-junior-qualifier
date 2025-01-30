package com.google.firebase.crashlytics.c.l;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class d implements Comparator {
    private static final d a = new d();

    private d() {
    }

    public static Comparator a() {
        return a;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int A;
        A = g.A((File) obj, (File) obj2);
        return A;
    }
}