package com.google.firebase.crashlytics.c.g;

import com.google.firebase.crashlytics.c.i.v;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class d0 implements Comparator {
    private static final d0 a = new d0();

    private d0() {
    }

    public static Comparator a() {
        return a;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int compareTo;
        compareTo = ((v.b) obj).b().compareTo(((v.b) obj2).b());
        return compareTo;
    }
}