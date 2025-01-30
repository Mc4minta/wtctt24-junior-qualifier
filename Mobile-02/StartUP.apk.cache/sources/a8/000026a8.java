package com.coinbase.wallet.swap.di;

import android.app.Application;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.ethereum.apis.ERC20ContractAPI;
import com.coinbase.wallet.ethereum.apis.MinerFeeAPI;
import com.coinbase.wallet.http.models.HTTPService;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.libraries.databases.model.DiskOptions;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.swap.apis.SwapAPI;
import com.coinbase.wallet.swap.daos.SwapAssetStatsDAO;
import com.coinbase.wallet.swap.db.SwapDatabase;
import com.coinbase.wallet.swap.interfaces.ISwapRepository;
import com.coinbase.wallet.swap.repositories.SwapRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: SwapModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b'\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/swap/di/SwapModule;", "", "<init>", "()V", "Companion", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class SwapModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: SwapModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b!\u0010\"J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0010\u0010\u0011JG\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/coinbase/wallet/swap/di/SwapModule$Companion;", "", "Landroid/app/Application;", "app", "Lcom/coinbase/wallet/libraries/databases/db/Database;", "Lcom/coinbase/wallet/swap/db/SwapDatabase;", "providesDatabase", "(Landroid/app/Application;)Lcom/coinbase/wallet/libraries/databases/db/Database;", "db", "Lcom/coinbase/wallet/swap/daos/SwapAssetStatsDAO;", "providesSwapAssetStatsDAO$swap_release", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)Lcom/coinbase/wallet/swap/daos/SwapAssetStatsDAO;", "providesSwapAssetStatsDAO", "Lcom/coinbase/wallet/http/models/HTTPService;", "swapHTTPService", "Lcom/coinbase/wallet/swap/apis/SwapAPI;", "swapAPI$swap_release", "(Lcom/coinbase/wallet/http/models/HTTPService;)Lcom/coinbase/wallet/swap/apis/SwapAPI;", "swapAPI", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "minerFeeAPI", "Lcom/coinbase/wallet/ethereum/apis/ERC20ContractAPI;", "erc20ContractAPI", "swapAssetStatsDAO", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/swap/interfaces/ISwapRepository;", "providesSwapRepository", "(Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;Lcom/coinbase/wallet/ethereum/apis/ERC20ContractAPI;Lcom/coinbase/wallet/swap/apis/SwapAPI;Lcom/coinbase/wallet/swap/daos/SwapAssetStatsDAO;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)Lcom/coinbase/wallet/swap/interfaces/ISwapRepository;", "<init>", "()V", "swap_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Database<SwapDatabase> providesDatabase(Application app) {
            m.g(app, "app");
            return new Database<>(new DiskOptions(app, SwapDatabase.class, "SwapDatabase", null, false, 24, null));
        }

        public final SwapAssetStatsDAO providesSwapAssetStatsDAO$swap_release(Database<SwapDatabase> db) {
            m.g(db, "db");
            return new SwapAssetStatsDAO(db);
        }

        public final ISwapRepository providesSwapRepository(CipherCoreInterface cipherCore, AddressDao addressDao, MinerFeeAPI minerFeeAPI, ERC20ContractAPI erc20ContractAPI, SwapAPI swapAPI, SwapAssetStatsDAO swapAssetStatsDAO, StoreInterface store) {
            m.g(cipherCore, "cipherCore");
            m.g(addressDao, "addressDao");
            m.g(minerFeeAPI, "minerFeeAPI");
            m.g(erc20ContractAPI, "erc20ContractAPI");
            m.g(swapAPI, "swapAPI");
            m.g(swapAssetStatsDAO, "swapAssetStatsDAO");
            m.g(store, "store");
            return new SwapRepository(cipherCore, addressDao, erc20ContractAPI, minerFeeAPI, swapAPI, swapAssetStatsDAO, store);
        }

        public final SwapAPI swapAPI$swap_release(HTTPService swapHTTPService) {
            m.g(swapHTTPService, "swapHTTPService");
            return new SwapAPI(swapHTTPService);
        }
    }

    public static final Database<SwapDatabase> providesDatabase(Application application) {
        return Companion.providesDatabase(application);
    }

    public static final ISwapRepository providesSwapRepository(CipherCoreInterface cipherCoreInterface, AddressDao addressDao, MinerFeeAPI minerFeeAPI, ERC20ContractAPI eRC20ContractAPI, SwapAPI swapAPI, SwapAssetStatsDAO swapAssetStatsDAO, StoreInterface storeInterface) {
        return Companion.providesSwapRepository(cipherCoreInterface, addressDao, minerFeeAPI, eRC20ContractAPI, swapAPI, swapAssetStatsDAO, storeInterface);
    }
}