package com.google.firebase.components;

import java.util.Set;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes2.dex */
abstract class a implements e {
    @Override // com.google.firebase.components.e
    public <T> T a(Class<T> cls) {
        com.google.firebase.g.a<T> b2 = b(cls);
        if (b2 == null) {
            return null;
        }
        return b2.get();
    }

    @Override // com.google.firebase.components.e
    public <T> Set<T> d(Class<T> cls) {
        return c(cls).get();
    }
}