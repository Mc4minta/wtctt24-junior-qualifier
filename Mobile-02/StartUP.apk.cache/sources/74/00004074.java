package com.toshi.db;

import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.core.interfaces.Destroyable;
import e.j.f.i;
import h.c.b0;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.m;

/* compiled from: DerivedDatabase.kt */
@ApplicationScoped
/* loaded from: classes2.dex */
public final class c implements Destroyable {
    private final DerivedDatabase a;

    public c(DerivedDatabase derivedDatabase) {
        m.g(derivedDatabase, "derivedDatabase");
        this.a = derivedDatabase;
    }

    public static final Boolean a(c this$0) {
        m.g(this$0, "this$0");
        return Boolean.valueOf(i.a(this$0.a));
    }

    public static /* synthetic */ Boolean b(c cVar) {
        return a(cVar);
    }

    @Override // com.coinbase.wallet.core.interfaces.Destroyable
    public b0<Boolean> destroy() {
        b0<Boolean> fromCallable = b0.fromCallable(new Callable() { // from class: com.toshi.db.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return c.b(c.this);
            }
        });
        m.f(fromCallable, "fromCallable { derivedDatabase.nukeDatabase() }");
        return fromCallable;
    }
}