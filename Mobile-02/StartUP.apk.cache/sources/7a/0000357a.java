package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class s6 extends y6 {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ n6 f7338b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private s6(n6 n6Var) {
        super(n6Var, null);
        this.f7338b = n6Var;
    }

    @Override // com.google.android.gms.internal.measurement.y6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new p6(this.f7338b, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s6(n6 n6Var, q6 q6Var) {
        this(n6Var);
    }
}