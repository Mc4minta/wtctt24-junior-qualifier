package com.coinbase.wallet.application.migrations;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.application.migrations.Migratable;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.consumer.extensions.StoreKeys_ConsumerConnectKt;
import com.coinbase.wallet.consumer.models.ConsumerAuthToken;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: AppVersion210Migration.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/application/migrations/AppVersion210Migration;", "Lcom/coinbase/wallet/application/migrations/Migratable;", "Lh/c/c;", "migrate", "()Lh/c/c;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Le/j/c/a/a;", "consumerOAuthPrefs", "Le/j/c/a/a;", "", "migrationVersion", "I", "getMigrationVersion", "()I", "Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;", "legacyStore", "Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;", "getLegacyStore", "()Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;", "<init>", "(Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;Le/j/c/a/a;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AppVersion210Migration implements Migratable {
    private final e.j.c.a.a consumerOAuthPrefs;
    private final MigrationsDaoInterface legacyStore;
    private final int migrationVersion;
    private final StoreInterface store;

    public AppVersion210Migration(MigrationsDaoInterface legacyStore, e.j.c.a.a consumerOAuthPrefs, StoreInterface store) {
        m.g(legacyStore, "legacyStore");
        m.g(consumerOAuthPrefs, "consumerOAuthPrefs");
        m.g(store, "store");
        this.legacyStore = legacyStore;
        this.consumerOAuthPrefs = consumerOAuthPrefs;
        this.store = store;
        this.migrationVersion = 210;
    }

    public static /* synthetic */ x a(AppVersion210Migration appVersion210Migration) {
        return m648migrate$lambda1(appVersion210Migration);
    }

    /* renamed from: migrate$lambda-1 */
    public static final x m648migrate$lambda1(AppVersion210Migration this$0) {
        m.g(this$0, "this$0");
        ConsumerAuthToken c2 = this$0.consumerOAuthPrefs.c();
        if (c2 != null) {
            StoreInterface storeInterface = this$0.store;
            StoreKeys storeKeys = StoreKeys.INSTANCE;
            storeInterface.set(StoreKeys_ConsumerConnectKt.getConsumerAccessToken(storeKeys), c2.getAccessToken());
            this$0.store.set(StoreKeys_ConsumerConnectKt.getConsumerRefreshToken(storeKeys), c2.getRefreshToken());
            this$0.store.set(StoreKeys_ConsumerConnectKt.getConsumerScope(storeKeys), c2.getScope());
        }
        this$0.consumerOAuthPrefs.b();
        return x.a;
    }

    @Override // com.coinbase.wallet.application.migrations.Migratable
    public MigrationsDaoInterface getLegacyStore() {
        return this.legacyStore;
    }

    @Override // com.coinbase.wallet.application.migrations.Migratable
    public int getMigrationVersion() {
        return this.migrationVersion;
    }

    @Override // com.coinbase.wallet.application.migrations.Migratable
    public boolean isMigrated() {
        return Migratable.DefaultImpls.isMigrated(this);
    }

    @Override // com.coinbase.wallet.application.migrations.Migratable
    public h.c.c migrate() {
        if (isMigrated()) {
            h.c.c g2 = h.c.c.g();
            m.f(g2, "complete()");
            return g2;
        }
        h.c.c r = h.c.c.r(new Callable() { // from class: com.coinbase.wallet.application.migrations.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return AppVersion210Migration.a(AppVersion210Migration.this);
            }
        });
        m.f(r, "fromCallable {\n            consumerOAuthPrefs.oAuthToken?.apply {\n                store.set(StoreKeys.consumerAccessToken, accessToken)\n                store.set(StoreKeys.consumerRefreshToken, refreshToken)\n                store.set(StoreKeys.consumerScope, scope)\n            }\n\n            consumerOAuthPrefs.clearOAuthToken()\n        }");
        return r;
    }

    @Override // com.coinbase.wallet.application.migrations.Migratable
    public void migrationComplete() {
        Migratable.DefaultImpls.migrationComplete(this);
    }
}