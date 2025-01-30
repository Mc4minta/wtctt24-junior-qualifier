package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class g7 implements Iterator<String> {
    private Iterator<String> a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ e7 f7141b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g7(e7 e7Var) {
        e5 e5Var;
        this.f7141b = e7Var;
        e5Var = e7Var.a;
        this.a = e5Var.iterator();
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