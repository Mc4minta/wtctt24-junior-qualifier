package com.coinbase.wallet.application.migrations;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Migratable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/coinbase/wallet/application/migrations/Migratable;", "", "", "isMigrated", "()Z", "Lh/c/c;", "migrate", "()Lh/c/c;", "Lkotlin/x;", "migrationComplete", "()V", "", "getMigrationVersion", "()I", "migrationVersion", "Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;", "getLegacyStore", "()Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;", "legacyStore", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface Migratable {

    /* compiled from: Migratable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static boolean isMigrated(Migratable migratable) {
            m.g(migratable, "this");
            return migratable.getLegacyStore().getIsMigrated(migratable.getMigrationVersion());
        }

        public static void migrationComplete(Migratable migratable) {
            m.g(migratable, "this");
            migratable.getLegacyStore().setMigrated(migratable.getMigrationVersion());
        }
    }

    MigrationsDaoInterface getLegacyStore();

    int getMigrationVersion();

    boolean isMigrated();

    h.c.c migrate();

    void migrationComplete();
}