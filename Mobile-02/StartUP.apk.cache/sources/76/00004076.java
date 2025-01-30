package com.toshi.db;

import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.core.interfaces.Destroyable;
import e.j.f.i;
import h.c.b0;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.m;

/* compiled from: WalletDatabase.kt */
@ApplicationScoped
/* loaded from: classes2.dex */
public final class e implements Destroyable {
    private final WalletDatabase a;

    public e(WalletDatabase walletDatabase) {
        m.g(walletDatabase, "walletDatabase");
        this.a = walletDatabase;
    }

    public static final Boolean a(e this$0) {
        m.g(this$0, "this$0");
        return Boolean.valueOf(i.a(this$0.a));
    }

    public static /* synthetic */ Boolean b(e eVar) {
        return a(eVar);
    }

    @Override // com.coinbase.wallet.core.interfaces.Destroyable
    public b0<Boolean> destroy() {
        b0<Boolean> fromCallable = b0.fromCallable(new Callable() { // from class: com.toshi.db.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e.b(e.this);
            }
        });
        m.f(fromCallable, "fromCallable { walletDatabase.nukeDatabase() }");
        return fromCallable;
    }
}