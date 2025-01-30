package com.coinbase.wallet.di;

import com.coinbase.wallet.core.interfaces.Destroyable;
import h.c.b0;
import h.c.m0.n;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.x;
import okhttp3.Cache;

/* compiled from: DestroyableModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"com/coinbase/wallet/di/DestroyableModule$Companion$providesCacheDestroyable$1", "Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lh/c/b0;", "", "destroy", "()Lh/c/b0;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class DestroyableModule$Companion$providesCacheDestroyable$1 implements Destroyable {
    final /* synthetic */ Cache $cache;

    public DestroyableModule$Companion$providesCacheDestroyable$1(Cache cache) {
        this.$cache = cache;
    }

    public static /* synthetic */ Boolean a(x xVar) {
        return m1073destroy$lambda1(xVar);
    }

    public static /* synthetic */ x b(Cache cache) {
        return m1072destroy$lambda0(cache);
    }

    /* renamed from: destroy$lambda-0 */
    public static final x m1072destroy$lambda0(Cache cache) {
        m.g(cache, "$cache");
        cache.delete();
        return x.a;
    }

    /* renamed from: destroy$lambda-1 */
    public static final Boolean m1073destroy$lambda1(x it) {
        m.g(it, "it");
        return Boolean.TRUE;
    }

    @Override // com.coinbase.wallet.core.interfaces.Destroyable
    public b0<Boolean> destroy() {
        final Cache cache = this.$cache;
        b0<Boolean> map = b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.di.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DestroyableModule$Companion$providesCacheDestroyable$1.b(Cache.this);
            }
        }).map(new n() { // from class: com.coinbase.wallet.di.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return DestroyableModule$Companion$providesCacheDestroyable$1.a((x) obj);
            }
        });
        m.f(map, "fromCallable { cache.delete() }\n                .map { true }");
        return map;
    }
}