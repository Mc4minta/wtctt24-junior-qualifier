package com.google.firebase.i;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes2.dex */
public class d {
    private static volatile d a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<f> f9110b = new HashSet();

    d() {
    }

    public static d a() {
        d dVar = a;
        if (dVar == null) {
            synchronized (d.class) {
                dVar = a;
                if (dVar == null) {
                    dVar = new d();
                    a = dVar;
                }
            }
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<f> b() {
        Set<f> unmodifiableSet;
        synchronized (this.f9110b) {
            unmodifiableSet = Collections.unmodifiableSet(this.f9110b);
        }
        return unmodifiableSet;
    }
}