package com.google.firebase.components;

import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class j implements com.google.firebase.g.a {
    private final Set a;

    private j(Set set) {
        this.a = set;
    }

    public static com.google.firebase.g.a a(Set set) {
        return new j(set);
    }

    @Override // com.google.firebase.g.a
    public Object get() {
        return l.g(this.a);
    }
}