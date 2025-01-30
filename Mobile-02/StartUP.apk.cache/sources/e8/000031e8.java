package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.c;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public abstract class h<T extends IInterface> extends c<T> implements a.f {
    private final d D;
    private final Set<Scope> E;
    private final Account F;

    protected h(Context context, Looper looper, int i2, d dVar, com.google.android.gms.common.api.internal.e eVar, com.google.android.gms.common.api.internal.k kVar) {
        this(context, looper, i.b(context), com.google.android.gms.common.e.o(), i2, dVar, (com.google.android.gms.common.api.internal.e) t.k(eVar), (com.google.android.gms.common.api.internal.k) t.k(kVar));
    }

    private static c.a j0(com.google.android.gms.common.api.internal.e eVar) {
        if (eVar == null) {
            return null;
        }
        return new a0(eVar);
    }

    private static c.b k0(com.google.android.gms.common.api.internal.k kVar) {
        if (kVar == null) {
            return null;
        }
        return new b0(kVar);
    }

    private final Set<Scope> l0(Set<Scope> set) {
        Set<Scope> i0 = i0(set);
        for (Scope scope : i0) {
            if (!set.contains(scope)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return i0;
    }

    @Override // com.google.android.gms.common.internal.c
    protected final Set<Scope> A() {
        return this.E;
    }

    @Override // com.google.android.gms.common.api.a.f
    public Set<Scope> a() {
        return p() ? this.E : Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final d h0() {
        return this.D;
    }

    protected Set<Scope> i0(Set<Scope> set) {
        return set;
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public int n() {
        return super.n();
    }

    @Override // com.google.android.gms.common.internal.c
    public final Account u() {
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public h(Context context, Looper looper, int i2, d dVar, d.a aVar, d.b bVar) {
        this(context, looper, i2, dVar, (com.google.android.gms.common.api.internal.e) aVar, (com.google.android.gms.common.api.internal.k) bVar);
    }

    protected h(Context context, Looper looper, i iVar, com.google.android.gms.common.e eVar, int i2, d dVar, com.google.android.gms.common.api.internal.e eVar2, com.google.android.gms.common.api.internal.k kVar) {
        super(context, looper, iVar, eVar, i2, j0(eVar2), k0(kVar), dVar.g());
        this.D = dVar;
        this.F = dVar.a();
        this.E = l0(dVar.d());
    }
}