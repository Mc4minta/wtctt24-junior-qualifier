package com.coinbase.wallet.wallets.di;

import android.app.Application;
import android.content.Context;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.Coinbase;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.compoundfinance.repositories.CompoundFinanceRepository;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.ethereum.apis.ERC20ContractAPI;
import com.coinbase.wallet.ethereum.apis.MinerFeeAPI;
import com.coinbase.wallet.ethereum.daos.EthereumSignedTxDao;
import com.coinbase.wallet.ethereum.interfaces.IERC20Fetching;
import com.coinbase.wallet.ethereum.interfaces.IETCWalletRepository;
import com.coinbase.wallet.ethereum.interfaces.IETHTxRepository;
import com.coinbase.wallet.ethereum.interfaces.IETHWalletRepository;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.wallets.db.WalletsDatabase;
import com.coinbase.wallet.wallets.di.qualifier.WalletApiUrl;
import com.coinbase.wallet.wallets.di.qualifier.WalletBlockchainUrl;
import com.coinbase.wallet.wallets.di.qualifier.XRPNodeUrl;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.walletengine.WalletEngine;
import com.coinbase.walletengine.services.xrp.XRPService;
import java.util.List;
import kotlin.Metadata;
import retrofit2.t;

/* compiled from: WalletsComponent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001:\u0001:J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 H&¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H&¢\u0006\u0004\b%\u0010&J\u0015\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'H&¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H&¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H&¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u000201H&¢\u0006\u0004\b2\u00103J\u000f\u00105\u001a\u000204H&¢\u0006\u0004\b5\u00106J\u000f\u00108\u001a\u000207H&¢\u0006\u0004\b8\u00109¨\u0006;"}, d2 = {"Lcom/coinbase/wallet/wallets/di/WalletsComponent;", "", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "()Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "txRepository", "()Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "()Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "Lcom/coinbase/wallet/ethereum/interfaces/IETHWalletRepository;", "ethWalletRepository", "()Lcom/coinbase/wallet/ethereum/interfaces/IETHWalletRepository;", "Lcom/coinbase/wallet/ethereum/interfaces/IETCWalletRepository;", "etcWalletRepository", "()Lcom/coinbase/wallet/ethereum/interfaces/IETCWalletRepository;", "Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "fiatCurrencyRepository", "()Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "()Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "Lcom/coinbase/wallet/ethereum/interfaces/IERC20Fetching;", "erc20Fetching", "()Lcom/coinbase/wallet/ethereum/interfaces/IERC20Fetching;", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "()Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "Lcom/coinbase/wallet/ethereum/interfaces/IETHTxRepository;", "ethTxRepository", "()Lcom/coinbase/wallet/ethereum/interfaces/IETHTxRepository;", "", "Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "networkSettings", "()Ljava/util/List;", "Lcom/coinbase/walletengine/WalletEngine;", "walletEngine", "()Lcom/coinbase/walletengine/WalletEngine;", "Lcom/coinbase/wallet/libraries/databases/db/Database;", "Lcom/coinbase/wallet/wallets/db/WalletsDatabase;", "walletsDatabase", "()Lcom/coinbase/wallet/libraries/databases/db/Database;", "Lcom/coinbase/wallet/compoundfinance/repositories/CompoundFinanceRepository;", "compoundFinanceRepository", "()Lcom/coinbase/wallet/compoundfinance/repositories/CompoundFinanceRepository;", "Lcom/coinbase/walletengine/services/xrp/XRPService;", "xrpService", "()Lcom/coinbase/walletengine/services/xrp/XRPService;", "Lcom/coinbase/wallet/ethereum/apis/ERC20ContractAPI;", "erc20ContractAPI", "()Lcom/coinbase/wallet/ethereum/apis/ERC20ContractAPI;", "Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "minerFeeAPI", "()Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "ethereumSignedTxDao", "()Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "Factory", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface WalletsComponent {

    /* compiled from: WalletsComponent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001Js\u0010\u0015\u001a\u00020\u00142\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u0012\u001a\u00020\u00102\b\b\u0001\u0010\u0013\u001a\u00020\u0010H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/wallets/di/WalletsComponent$Factory;", "", "Lretrofit2/t;", "retrofit", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/Coinbase;", "coinbase", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Landroid/app/Application;", "application", "Landroid/content/Context;", "context", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "", "walletApiUrl", "walletBlockchainUrl", "walletXRPNodeUrl", "Lcom/coinbase/wallet/wallets/di/WalletsComponent;", "create", "(Lretrofit2/t;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/Coinbase;Lcom/coinbase/ciphercore/CipherCoreInterface;Landroid/app/Application;Landroid/content/Context;Lcom/coinbase/wallet/core/interfaces/Tracing;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/wallets/di/WalletsComponent;", "wallets_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface Factory {
        WalletsComponent create(t tVar, StoreInterface storeInterface, Coinbase coinbase, CipherCoreInterface cipherCoreInterface, Application application, Context context, Tracing tracing, @WalletApiUrl String str, @WalletBlockchainUrl String str2, @XRPNodeUrl String str3);
    }

    AddressDao addressDao();

    CompoundFinanceRepository compoundFinanceRepository();

    CurrencyFormatter currencyFormatter();

    ERC20ContractAPI erc20ContractAPI();

    IERC20Fetching erc20Fetching();

    IETCWalletRepository etcWalletRepository();

    IETHTxRepository ethTxRepository();

    IETHWalletRepository ethWalletRepository();

    EthereumSignedTxDao ethereumSignedTxDao();

    IExchangeRateRepository exchangeRateRepository();

    IFiatCurrencyRepository fiatCurrencyRepository();

    MinerFeeAPI minerFeeAPI();

    List<NetworkSetting> networkSettings();

    ITxRepository txRepository();

    WalletEngine walletEngine();

    IWalletRepository walletRepository();

    Database<WalletsDatabase> walletsDatabase();

    XRPService xrpService();
}