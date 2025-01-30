package com.coinbase.wallet.lending.di;

import android.app.Application;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.http.models.HTTPService;
import com.coinbase.wallet.lending.apis.LendAPI;
import com.coinbase.wallet.lending.daos.LendTokenDAO;
import com.coinbase.wallet.lending.db.LendDatabase;
import com.coinbase.wallet.lending.di.qualifier.ApiUrl;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.lending.repositories.LendRepository;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.libraries.databases.model.DiskOptions;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.walletengine.WalletEngine;
import h.c.s;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: LendModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b'\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/lending/di/LendModule;", "", "<init>", "()V", "Companion", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class LendModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: LendModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010#J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\r\u001a\u00020\n2\b\b\u0001\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0012\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0001¢\u0006\u0004\b\u0010\u0010\u0011JE\u0010!\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/coinbase/wallet/lending/di/LendModule$Companion;", "", "Landroid/app/Application;", "app", "Lcom/coinbase/wallet/libraries/databases/db/Database;", "Lcom/coinbase/wallet/lending/db/LendDatabase;", "providesDatabase", "(Landroid/app/Application;)Lcom/coinbase/wallet/libraries/databases/db/Database;", "", "walletApiUrl", "Lcom/coinbase/wallet/lending/apis/LendAPI;", "providesLendAPI$lending_release", "(Ljava/lang/String;)Lcom/coinbase/wallet/lending/apis/LendAPI;", "providesLendAPI", "database", "Lcom/coinbase/wallet/lending/daos/LendTokenDAO;", "providesLendTokenDAO$lending_release", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)Lcom/coinbase/wallet/lending/daos/LendTokenDAO;", "providesLendTokenDAO", "Lcom/coinbase/walletengine/WalletEngine;", "walletEngine", "Lh/c/s;", "Lcom/coinbase/wallet/blockchains/models/WalletAddress;", "walletAddressObservable", "lendTokenDAO", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "lendAPI", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "providesLendRepository$lending_release", "(Lcom/coinbase/walletengine/WalletEngine;Lh/c/s;Lcom/coinbase/wallet/lending/daos/LendTokenDAO;Lcom/coinbase/wallet/core/interfaces/Tracing;Lcom/coinbase/wallet/lending/apis/LendAPI;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "providesLendRepository", "<init>", "()V", "lending_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Database<LendDatabase> providesDatabase(Application app) {
            m.g(app, "app");
            return new Database<>(new DiskOptions(app, LendDatabase.class, "LendDatabase", null, true, 8, null));
        }

        public final LendAPI providesLendAPI$lending_release(@ApiUrl String walletApiUrl) {
            m.g(walletApiUrl, "walletApiUrl");
            return new LendAPI(new HTTPService(new URL(walletApiUrl)));
        }

        public final ILendRepository providesLendRepository$lending_release(WalletEngine walletEngine, s<WalletAddress> walletAddressObservable, LendTokenDAO lendTokenDAO, Tracing tracer, LendAPI lendAPI, StoreInterface store) {
            m.g(walletEngine, "walletEngine");
            m.g(walletAddressObservable, "walletAddressObservable");
            m.g(lendTokenDAO, "lendTokenDAO");
            m.g(tracer, "tracer");
            m.g(lendAPI, "lendAPI");
            m.g(store, "store");
            return new LendRepository(lendTokenDAO, walletAddressObservable, tracer, lendAPI, store);
        }

        public final LendTokenDAO providesLendTokenDAO$lending_release(Database<LendDatabase> database) {
            m.g(database, "database");
            return new LendTokenDAO(database);
        }
    }

    public static final Database<LendDatabase> providesDatabase(Application application) {
        return Companion.providesDatabase(application);
    }
}