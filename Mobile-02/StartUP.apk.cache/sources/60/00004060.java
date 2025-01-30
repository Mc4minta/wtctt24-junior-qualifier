package com.toshi.db;

import android.content.Context;
import androidx.room.i;
import androidx.room.j;
import com.coinbase.wallet.user.daos.UserDao;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: DerivedDatabase.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/toshi/db/DerivedDatabase;", "Landroidx/room/j;", "Lcom/toshi/db/i/a;", "i", "()Lcom/toshi/db/i/a;", "Lcom/toshi/db/h/a;", "h", "()Lcom/toshi/db/h/a;", "Lcom/coinbase/wallet/user/daos/UserDao;", "j", "()Lcom/coinbase/wallet/user/daos/UserDao;", "<init>", "()V", "a", "f", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class DerivedDatabase extends j {

    /* renamed from: b  reason: collision with root package name */
    private static volatile DerivedDatabase f11074b;
    public static final f a = new f(null);

    /* renamed from: c  reason: collision with root package name */
    private static final androidx.room.s.a f11075c = new a();

    /* renamed from: d  reason: collision with root package name */
    private static final androidx.room.s.a f11076d = new b();

    /* renamed from: e  reason: collision with root package name */
    private static final androidx.room.s.a f11077e = new c();

    /* renamed from: f  reason: collision with root package name */
    private static final androidx.room.s.a f11078f = new d();

    /* renamed from: g  reason: collision with root package name */
    private static final androidx.room.s.a f11079g = new e();

    /* compiled from: DerivedDatabase.kt */
    /* loaded from: classes2.dex */
    public static final class a extends androidx.room.s.a {
        a() {
            super(1, 2);
        }

        @Override // androidx.room.s.a
        public void migrate(c.r.a.b database) {
            m.g(database, "database");
            database.t("CREATE TABLE `all_transactions` (`id` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, `confirmedAt` INTEGER, `currencyCode` TEXT NOT NULL, `feeCurrencyCode` TEXT NOT NULL, `toAddress` TEXT, `fromAddress` TEXT, `amount` TEXT NOT NULL, `fee` TEXT NOT NULL, `metadata` TEXT NOT NULL, `state` INTEGER NOT NULL, `networkCode` TEXT NOT NULL, `transactionHash` TEXT, `isSent` INTEGER NOT NULL, PRIMARY KEY(`id`));");
            database.t("CREATE TABLE `ethereum_transaction` (`id` TEXT NOT NULL, `from_address` TEXT NOT NULL, `to_address` TEXT, `nonce` INTEGER, `chain_id` INTEGER NOT NULL, `signed_transaction_data` BLOB, `transaction_hash` BLOB, `wei_value` TEXT NOT NULL, `state` INTEGER NOT NULL, PRIMARY KEY(`id`));");
        }
    }

    /* compiled from: DerivedDatabase.kt */
    /* loaded from: classes2.dex */
    public static final class b extends androidx.room.s.a {
        b() {
            super(2, 3);
        }

        @Override // androidx.room.s.a
        public void migrate(c.r.a.b database) {
            m.g(database, "database");
            database.t("ALTER TABLE ethereum_transaction ADD COLUMN not_found_count INTEGER DEFAULT 0 NOT NULL");
        }
    }

    /* compiled from: DerivedDatabase.kt */
    /* loaded from: classes2.dex */
    public static final class c extends androidx.room.s.a {
        c() {
            super(3, 4);
        }

        @Override // androidx.room.s.a
        public void migrate(c.r.a.b database) {
            m.g(database, "database");
            database.t("CREATE TABLE `compound_token` (`id` TEXT NOT NULL,\n `code` TEXT NOT NULL, `decimals` INTEGER NOT NULL, `contractAddress` TEXT NOT NULL,\n `underlyingCode` TEXT NOT NULL, PRIMARY KEY(`id`));");
        }
    }

    /* compiled from: DerivedDatabase.kt */
    /* loaded from: classes2.dex */
    public static final class d extends androidx.room.s.a {
        d() {
            super(4, 5);
        }

        @Override // androidx.room.s.a
        public void migrate(c.r.a.b database) {
            m.g(database, "database");
            database.t("DROP TABLE collectible_types");
            database.t("CREATE TABLE `collectible_types` (`name` TEXT NOT NULL,\n `contract_address` TEXT NOT NULL COLLATE NOCASE, `address` TEXT NOT NULL,\n  `count` INTEGER NOT NULL, `image` TEXT, `chain_id` INTEGER NOT NULL,\n   PRIMARY KEY(`contract_address`));");
        }
    }

    /* compiled from: DerivedDatabase.kt */
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
            database.t("DROP TABLE ethereum_transaction");
            database.t("DROP TABLE xrp_wallet");
            database.t("DROP TABLE xrp_transaction");
            database.t("DROP TABLE stellar_wallet");
            database.t("DROP TABLE stellar_transaction");
            database.t("DROP TABLE compound_token");
        }
    }

    /* compiled from: DerivedDatabase.kt */
    /* loaded from: classes2.dex */
    public static final class f {
        private f() {
        }

        public /* synthetic */ f(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final DerivedDatabase a(Context context) {
            j b2 = i.a(context.getApplicationContext(), DerivedDatabase.class, "DERIVED_DATABASE").a(c()).a(d()).a(e()).a(f()).a(g()).c().b();
            m.f(b2, "databaseBuilder(\n                context.applicationContext,\n                DerivedDatabase::class.java,\n                DB_NAME\n            )\n                .addMigrations(MIGRATION_1_2)\n                .addMigrations(MIGRATION_2_3)\n                .addMigrations(MIGRATION_3_4)\n                .addMigrations(MIGRATION_4_5)\n                .addMigrations(MIGRATION_5_6)\n                .fallbackToDestructiveMigration()\n                .build()");
            return (DerivedDatabase) b2;
        }

        public final DerivedDatabase b(Context context) {
            m.g(context, "context");
            DerivedDatabase derivedDatabase = DerivedDatabase.f11074b;
            if (derivedDatabase == null) {
                synchronized (this) {
                    derivedDatabase = DerivedDatabase.f11074b;
                    if (derivedDatabase == null) {
                        DerivedDatabase a = DerivedDatabase.a.a(context);
                        DerivedDatabase.f11074b = a;
                        derivedDatabase = a;
                    }
                }
            }
            return derivedDatabase;
        }

        public final androidx.room.s.a c() {
            return DerivedDatabase.f11075c;
        }

        public final androidx.room.s.a d() {
            return DerivedDatabase.f11076d;
        }

        public final androidx.room.s.a e() {
            return DerivedDatabase.f11077e;
        }

        public final androidx.room.s.a f() {
            return DerivedDatabase.f11078f;
        }

        public final androidx.room.s.a g() {
            return DerivedDatabase.f11079g;
        }
    }

    public abstract com.toshi.db.h.a h();

    public abstract com.toshi.db.i.a i();

    public abstract UserDao j();
}