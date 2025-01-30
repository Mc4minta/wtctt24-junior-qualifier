package com.coinbase.wallet.swap.di;

import android.app.Application;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.ethereum.apis.ERC20ContractAPI;
import com.coinbase.wallet.ethereum.apis.MinerFeeAPI;
import com.coinbase.wallet.http.models.HTTPService;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.swap.db.SwapDatabase;
import com.coinbase.wallet.swap.interfaces.ISwapRepository;
import kotlin.Metadata;

/* compiled from: SwapComponent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\tJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/swap/di/SwapComponent;", "", "Lcom/coinbase/wallet/swap/interfaces/ISwapRepository;", "swapRepository", "()Lcom/coinbase/wallet/swap/interfaces/ISwapRepository;", "Lcom/coinbase/wallet/libraries/databases/db/Database;", "Lcom/coinbase/wallet/swap/db/SwapDatabase;", "swapDatabase", "()Lcom/coinbase/wallet/libraries/databases/db/Database;", "Factory", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface SwapComponent {

    /* compiled from: SwapComponent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JU\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/coinbase/wallet/swap/di/SwapComponent$Factory;", "", "Landroid/app/Application;", "application", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/ethereum/apis/ERC20ContractAPI;", "erC20ContractAPI", "Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "minerFeeAPI", "Lcom/coinbase/wallet/http/models/HTTPService;", "swapHTTPService", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/swap/di/SwapComponent;", "create", "(Landroid/app/Application;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/ethereum/apis/ERC20ContractAPI;Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;Lcom/coinbase/wallet/http/models/HTTPService;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)Lcom/coinbase/wallet/swap/di/SwapComponent;", "swap_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface Factory {
        SwapComponent create(Application application, CipherCoreInterface cipherCoreInterface, AddressDao addressDao, ERC20ContractAPI eRC20ContractAPI, MinerFeeAPI minerFeeAPI, HTTPService hTTPService, StoreInterface storeInterface);
    }

    Database<SwapDatabase> swapDatabase();

    ISwapRepository swapRepository();
}