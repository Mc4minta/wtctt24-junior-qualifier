package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class f3 extends l3 {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ c3 f6431b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private f3(c3 c3Var) {
        super(c3Var, null);
        this.f6431b = c3Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f3(c3 c3Var, d3 d3Var) {
        this(c3Var);
    }

    @Override // com.google.android.gms.internal.clearcut.l3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new e3(this.f6431b, null);
    }
}