package com.coinbase.wallet.application.migrations;

import h.c.a0;
import h.c.b0;
import h.c.m0.n;
import java.util.ArrayList;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.a0.s;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.x;

/* compiled from: Migrations.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\f¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001d\u0010\u000b\u001a\u00020\u00068B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR(\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/coinbase/wallet/application/migrations/Migrations;", "", "Lh/c/b0;", "Lkotlin/x;", "execute", "()Lh/c/b0;", "Lh/c/a0;", "concurrentScheduler$delegate", "Lkotlin/h;", "getConcurrentScheduler", "()Lh/c/a0;", "concurrentScheduler", "", "", "Ljavax/inject/Provider;", "Lcom/coinbase/wallet/application/migrations/Migratable;", "migratables", "Ljava/util/Map;", "<init>", "(Ljava/util/Map;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Migrations {
    private final h concurrentScheduler$delegate;
    private final Map<Integer, Provider<Migratable>> migratables;

    public Migrations(Map<Integer, Provider<Migratable>> migratables) {
        h b2;
        m.g(migratables, "migratables");
        this.migratables = migratables;
        b2 = k.b(Migrations$concurrentScheduler$2.INSTANCE);
        this.concurrentScheduler$delegate = b2;
    }

    public static /* synthetic */ void a(Migratable migratable) {
        migratable.migrationComplete();
    }

    public static /* synthetic */ x b(x xVar) {
        return m652execute$lambda4(xVar);
    }

    /* renamed from: execute$lambda-4 */
    public static final x m652execute$lambda4(x it) {
        m.g(it, "it");
        l.a.a.a("migration finished", new Object[0]);
        return x.a;
    }

    private final a0 getConcurrentScheduler() {
        return (a0) this.concurrentScheduler$delegate.getValue();
    }

    public final b0<x> execute() {
        int r;
        Map<Integer, Provider<Migratable>> map = this.migratables;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<Integer, Provider<Migratable>> entry : map.entrySet()) {
            arrayList.add(entry.getValue().get());
        }
        ArrayList<Migratable> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!((Migratable) obj).isMigrated()) {
                arrayList2.add(obj);
            }
        }
        r = s.r(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(r);
        for (final Migratable migratable : arrayList2) {
            arrayList3.add(migratable.migrate().l(new h.c.m0.a() { // from class: com.coinbase.wallet.application.migrations.d
                @Override // h.c.m0.a
                public final void run() {
                    Migrations.a(Migratable.this);
                }
            }).x(x.a).toObservable());
        }
        if (arrayList3.isEmpty()) {
            b0<x> just = b0.just(x.a);
            m.f(just, "just(Unit)");
            return just;
        }
        b0<x> map2 = h.c.t0.b.a(arrayList3).subscribeOn(getConcurrentScheduler()).last(x.a).map(new n() { // from class: com.coinbase.wallet.application.migrations.e
            @Override // h.c.m0.n
            public final Object apply(Object obj2) {
                return Migrations.b((x) obj2);
            }
        });
        m.f(map2, "migratableObservables\n            .concatAll()\n            .subscribeOn(concurrentScheduler)\n            .last(Unit)\n            .map { Timber.d(\"migration finished\") }");
        return map2;
    }
}