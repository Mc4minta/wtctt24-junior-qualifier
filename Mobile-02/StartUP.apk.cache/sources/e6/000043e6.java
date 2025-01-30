package com.uber.autodispose;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AtomicThrowable.java */
/* loaded from: classes2.dex */
final class b extends AtomicReference<Throwable> {
    public boolean a(Throwable th) {
        return t.a(this, th);
    }

    public Throwable b() {
        return t.b(this);
    }
}