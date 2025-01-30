package com.google.android.gms.internal.p000firebaseperf;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.s6  reason: invalid package */
/* loaded from: classes2.dex */
final class s6 extends y6 {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ n6 f6906b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private s6(n6 n6Var) {
        super(n6Var, null);
        this.f6906b = n6Var;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new p6(this.f6906b, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s6(n6 n6Var, q6 q6Var) {
        this(n6Var);
    }
}