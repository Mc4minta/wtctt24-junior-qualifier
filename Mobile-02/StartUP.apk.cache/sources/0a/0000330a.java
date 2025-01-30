package com.google.android.gms.internal.clearcut;

import java.util.Iterator;

/* loaded from: classes2.dex */
final class w3 implements Iterator<String> {
    private Iterator<String> a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ u3 f6607b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w3(u3 u3Var) {
        r1 r1Var;
        this.f6607b = u3Var;
        r1Var = u3Var.a;
        this.a = r1Var.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}