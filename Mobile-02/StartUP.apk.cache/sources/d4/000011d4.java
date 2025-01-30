package com.coinbase.wallet.application.migrations;

import android.content.Context;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.application.extensions.StoreKeys_ApplicationKt;
import com.coinbase.wallet.application.migrations.Migratable;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: AppVersion232Migration.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B!\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/application/migrations/AppVersion232Migration;", "Lcom/coinbase/wallet/application/migrations/Migratable;", "Lh/c/c;", "migrate", "()Lh/c/c;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "", "migrationVersion", "I", "getMigrationVersion", "()I", "Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;", "legacyStore", "Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;", "getLegacyStore", "()Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;", "<init>", "(Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Landroid/content/Context;)V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AppVersion232Migration implements Migratable {
    public static final Companion Companion = new Companion(null);
    private static final String LEGACY_MNEMONIC_HASH_PREFS = "backupFileName";
    private final Context context;
    private final MigrationsDaoInterface legacyStore;
    private final int migrationVersion;
    private final StoreInterface store;

    /* compiled from: AppVersion232Migration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/application/migrations/AppVersion232Migration$Companion;", "", "", "LEGACY_MNEMONIC_HASH_PREFS", "Ljava/lang/String;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AppVersion232Migration(MigrationsDaoInterface legacyStore, StoreInterface store, Context context) {
        m.g(legacyStore, "legacyStore");
        m.g(store, "store");
        m.g(context, "context");
        this.legacyStore = legacyStore;
        this.store = store;
        this.context = context;
        this.migrationVersion = 232;
    }

    public static /* synthetic */ x a(AppVersion232Migration appVersion232Migration) {
        return m649migrate$lambda0(appVersion232Migration);
    }

    /* renamed from: migrate$lambda-0 */
    public static final x m649migrate$lambda0(AppVersion232Migration this$0) {
        m.g(this$0, "this$0");
        String string = this$0.context.getSharedPreferences("usm", 0).getString(LEGACY_MNEMONIC_HASH_PREFS, null);
        if (string == null) {
            return x.a;
        }
        this$0.store.set(StoreKeys_ApplicationKt.getActiveMnemonicHash(StoreKeys.INSTANCE), string);
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
        h.c.c r = h.c.c.r(new Callable() { // from class: com.coinbase.wallet.application.migrations.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return AppVersion232Migration.a(AppVersion232Migration.this);
            }
        });
        m.f(r, "fromCallable {\n            val prefs = context.getSharedPreferences(FileNames.USER_PREFS, Context.MODE_PRIVATE)\n            val legacyHash = prefs.getString(LEGACY_MNEMONIC_HASH_PREFS, null) ?: return@fromCallable Unit\n\n            store.set(StoreKeys.activeMnemonicHash, legacyHash)\n        }");
        return r;
    }

    @Override // com.coinbase.wallet.application.migrations.Migratable
    public void migrationComplete() {
        Migratable.DefaultImpls.migrationComplete(this);
    }
}