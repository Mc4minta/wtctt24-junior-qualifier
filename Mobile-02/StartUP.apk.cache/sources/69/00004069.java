package com.toshi.db;

import android.content.Context;
import androidx.room.i;
import androidx.room.j;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: WalletDatabase.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/toshi/db/WalletDatabase;", "Landroidx/room/j;", "Lcom/toshi/db/g/a;", "h", "()Lcom/toshi/db/g/a;", "<init>", "()V", "a", "f", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class WalletDatabase extends j {

    /* renamed from: b  reason: collision with root package name */
    private static volatile WalletDatabase f11083b;
    public static final f a = new f(null);

    /* renamed from: c  reason: collision with root package name */
    private static final androidx.room.s.a f11084c = new a();

    /* renamed from: d  reason: collision with root package name */
    private static final androidx.room.s.a f11085d = new b();

    /* renamed from: e  reason: collision with root package name */
    private static final androidx.room.s.a f11086e = new c();

    /* renamed from: f  reason: collision with root package name */
    private static final androidx.room.s.a f11087f = new d();

    /* renamed from: g  reason: collision with root package name */
    private static final androidx.room.s.a f11088g = new e();

    /* compiled from: WalletDatabase.kt */
    /* loaded from: classes2.dex */
    public static final class a extends androidx.room.s.a {
        a() {
            super(11, 12);
        }

        @Override // androidx.room.s.a
        public void migrate(c.r.a.b database) {
            m.g(database, "database");
            database.t("CREATE TABLE user (\n    toshi_id TEXT NOT NULL, \n    payment_address TEXT NOT NULL, \n    avatar TEXT, \n    username TEXT NOT NULL, \n    display_name TEXT, \n    PRIMARY KEY(toshi_id)\n)");
        }
    }

    /* compiled from: WalletDatabase.kt */
    /* loaded from: classes2.dex */
    public static final class b extends androidx.room.s.a {
        b() {
            super(12, 13);
        }

        @Override // androidx.room.s.a
        public void migrate(c.r.a.b database) {
            m.g(database, "database");
            database.t("CREATE TABLE `all_transactions` (`id` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, `confirmedAt` INTEGER, `currencyCode` TEXT NOT NULL, `feeCurrencyCode` TEXT NOT NULL, `toAddress` TEXT, `fromAddress` TEXT, `amount` TEXT NOT NULL, `fee` TEXT NOT NULL, `metadata` TEXT NOT NULL, `state` INTEGER NOT NULL, `networkCode` TEXT NOT NULL, `txHash` TEXT, `isSent` INTEGER NOT NULL, PRIMARY KEY(`id`));");
            database.t("CREATE TABLE `ethereum_transaction` (`id` TEXT NOT NULL, `from_address` TEXT NOT NULL, `to_address` TEXT, `nonce` INTEGER, `chain_id` INTEGER NOT NULL, `signed_transaction_data` BLOB, `transaction_hash` BLOB, `wei_value` TEXT NOT NULL, `state` INTEGER NOT NULL, PRIMARY KEY(`id`));");
        }
    }

    /* compiled from: WalletDatabase.kt */
    /* loaded from: classes2.dex */
    public static final class c extends androidx.room.s.a {
        c() {
            super(13, 14);
        }

        @Override // androidx.room.s.a
        public void migrate(c.r.a.b database) {
            m.g(database, "database");
            database.t("ALTER TABLE ethereum_transaction ADD COLUMN not_found_count INTEGER DEFAULT 0 NOT NULL");
        }
    }

    /* compiled from: WalletDatabase.kt */
    /* loaded from: classes2.dex */
    public static final class d extends androidx.room.s.a {
        d() {
            super(14, 15);
        }

        @Override // androidx.room.s.a
        public void migrate(c.r.a.b database) {
            m.g(database, "database");
            database.t("DROP TABLE collectible_types");
            database.t("CREATE TABLE `collectible_types` (`name` TEXT NOT NULL, `contract_address` TEXT NOT NULL,\n `address` TEXT NOT NULL, `count` INTEGER NOT NULL, `image` TEXT, `chain_id` INTEGER NOT NULL,\n  PRIMARY KEY(`contract_address`));");
        }
    }

    /* compiled from: WalletDatabase.kt */
    /* loaded from: classes2.dex */
    public static final class e extends androidx.room.s.a {
        e() {
            super(14, 15);
        }

        @Override // androidx.room.s.a
        public void migrate(c.r.a.b database) {
            m.g(database, "database");
            database.t("DROP TABLE fiat_currency");
            database.t("DROP TABLE crypto_currency");
            database.t("DROP TABLE exchange_rate");
            database.t("DROP TABLE all_transactions");
            database.t("DROP TABLE stellar_transaction");
            database.t("DROP TABLE stellar_wallet");
            database.t("DROP TABLE user");
            database.t("DROP TABLE xrp_transaction");
            database.t("DROP TABLE xrp_wallet");
            database.t("DROP TABLE ethereum_transaction");
            database.t("DROP TABLE erc721_token");
            database.t("DROP TABLE erc20_token");
        }
    }

    /* compiled from: WalletDatabase.kt */
    /* loaded from: classes2.dex */
    public static final class f {
        private f() {
        }

        public /* synthetic */ f(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final WalletDatabase a(Context context) {
            j b2 = i.a(context.getApplicationContext(), WalletDatabase.class, "WALLET_DATABASE").a(c()).a(d()).a(e()).a(f()).a(g()).c().b();
            m.f(b2, "databaseBuilder(\n                context.applicationContext,\n                WalletDatabase::class.java,\n                DB_NAME\n            )\n                .addMigrations(MIGRATION_11_12)\n                .addMigrations(MIGRATION_12_13)\n                .addMigrations(MIGRATION_13_14)\n                .addMigrations(MIGRATION_14_15)\n                .addMigrations(MIGRATION_15_16)\n                .fallbackToDestructiveMigration()\n                .build()");
            return (WalletDatabase) b2;
        }

        public final WalletDatabase b(Context context) {
            m.g(context, "context");
            WalletDatabase walletDatabase = WalletDatabase.f11083b;
            if (walletDatabase == null) {
                synchronized (this) {
                    walletDatabase = WalletDatabase.f11083b;
                    if (walletDatabase == null) {
                        WalletDatabase a = WalletDatabase.a.a(context);
                        WalletDatabase.f11083b = a;
                        walletDatabase = a;
                    }
                }
            }
            return walletDatabase;
        }

        public final androidx.room.s.a c() {
            return WalletDatabase.f11084c;
        }

        public final androidx.room.s.a d() {
            return WalletDatabase.f11085d;
        }

        public final androidx.room.s.a e() {
            return WalletDatabase.f11086e;
        }

        public final androidx.room.s.a f() {
            return WalletDatabase.f11087f;
        }

        public final androidx.room.s.a g() {
            return WalletDatabase.f11088g;
        }
    }

    public abstract com.toshi.db.g.a h();
}