package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class n implements Iterator<String> {
    private Iterator<String> a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ o f7763b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(o oVar) {
        Bundle bundle;
        this.f7763b = oVar;
        bundle = oVar.a;
        this.a = bundle.keySet().iterator();
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
        throw new UnsupportedOperationException("Remove not supported");
    }
}