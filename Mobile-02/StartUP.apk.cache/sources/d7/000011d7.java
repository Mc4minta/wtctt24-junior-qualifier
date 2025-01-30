package com.coinbase.wallet.application.migrations;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.application.extensions.StoreKeys_ApplicationKt;
import com.coinbase.wallet.application.migrations.Migratable;
import com.coinbase.wallet.application.model.DismissForeverDestination;
import com.coinbase.wallet.application.model.Notification;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import e.j.j.j;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: AppVersion251Migration.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u00020\r8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/application/migrations/AppVersion251Migration;", "Lcom/coinbase/wallet/application/migrations/Migratable;", "Lh/c/c;", "migrate", "()Lh/c/c;", "Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;", "legacyStore", "Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;", "getLegacyStore", "()Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;", "Le/j/j/j;", "notificationPrefs", "Le/j/j/j;", "", "migrationVersion", "I", "getMigrationVersion", "()I", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "<init>", "(Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;Le/j/j/j;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AppVersion251Migration implements Migratable {
    private final MigrationsDaoInterface legacyStore;
    private final int migrationVersion;
    private final j notificationPrefs;
    private final StoreInterface store;

    public AppVersion251Migration(MigrationsDaoInterface legacyStore, j notificationPrefs, StoreInterface store) {
        m.g(legacyStore, "legacyStore");
        m.g(notificationPrefs, "notificationPrefs");
        m.g(store, "store");
        this.legacyStore = legacyStore;
        this.notificationPrefs = notificationPrefs;
        this.store = store;
        this.migrationVersion = 251;
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
        if (this.notificationPrefs.c(Notification.Id.KEY_BACKUP_PROMPT)) {
            this.store.set(StoreKeys_ApplicationKt.lastNotificationAction(StoreKeys.INSTANCE, Notification.Id.KEY_BACKUP_PROMPT), new DismissForeverDestination(null, 1, null).getActionType());
        }
        h.c.c g3 = h.c.c.g();
        m.f(g3, "complete()");
        return g3;
    }

    @Override // com.coinbase.wallet.application.migrations.Migratable
    public void migrationComplete() {
        Migratable.DefaultImpls.migrationComplete(this);
    }
}