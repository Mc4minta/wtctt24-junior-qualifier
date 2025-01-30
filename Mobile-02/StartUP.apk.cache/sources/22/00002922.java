package com.coinbase.wallet.wallets.di;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.Coinbase;
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
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.walletengine.WalletEngine;
import com.coinbase.walletengine.services.xrp.XRPService;
import java.util.List;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;
import retrofit2.t;

/* compiled from: WalletsContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010A\u001a\u00020@\u0012\u0006\u0010C\u001a\u00020B\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010G\u001a\u00020F\u0012\u0006\u0010I\u001a\u00020H\u0012\u0006\u0010K\u001a\u00020J\u0012\u0006\u0010L\u001a\u00020J\u0012\u0006\u0010M\u001a\u00020J¢\u0006\u0004\bN\u0010OJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0004\b\u001f\u0010 J\r\u0010\"\u001a\u00020!¢\u0006\u0004\b\"\u0010#J\r\u0010%\u001a\u00020$¢\u0006\u0004\b%\u0010&J\u0013\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'¢\u0006\u0004\b)\u0010*J\r\u0010,\u001a\u00020+¢\u0006\u0004\b,\u0010-J\r\u0010/\u001a\u00020.¢\u0006\u0004\b/\u00100J\r\u00102\u001a\u000201¢\u0006\u0004\b2\u00103J\r\u00105\u001a\u000204¢\u0006\u0004\b5\u00106J\r\u00108\u001a\u000207¢\u0006\u0004\b8\u00109R\u001d\u0010?\u001a\u00020:8@@\u0000X\u0080\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>¨\u0006P"}, d2 = {"Lcom/coinbase/wallet/wallets/di/WalletsContainer;", "", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "()Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "Lcom/coinbase/wallet/ethereum/interfaces/IETHWalletRepository;", "ethWalletRepository", "()Lcom/coinbase/wallet/ethereum/interfaces/IETHWalletRepository;", "Lcom/coinbase/wallet/ethereum/interfaces/IETCWalletRepository;", "etcWalletRepository", "()Lcom/coinbase/wallet/ethereum/interfaces/IETCWalletRepository;", "Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "fiatCurrencyRepository", "()Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "()Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "Lcom/coinbase/wallet/ethereum/interfaces/IERC20Fetching;", "erc20Fetching", "()Lcom/coinbase/wallet/ethereum/interfaces/IERC20Fetching;", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "()Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "txRepository", "()Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "Lcom/coinbase/wallet/ethereum/interfaces/IETHTxRepository;", "ethTxRepository", "()Lcom/coinbase/wallet/ethereum/interfaces/IETHTxRepository;", "", "Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "networkSettings", "()Ljava/util/List;", "Lcom/coinbase/walletengine/WalletEngine;", "walletEngine", "()Lcom/coinbase/walletengine/WalletEngine;", "Lcom/coinbase/wallet/compoundfinance/repositories/CompoundFinanceRepository;", "compoundFinanceRepository", "()Lcom/coinbase/wallet/compoundfinance/repositories/CompoundFinanceRepository;", "Lcom/coinbase/wallet/libraries/databases/db/Database;", "Lcom/coinbase/wallet/wallets/db/WalletsDatabase;", "walletsDatabase", "()Lcom/coinbase/wallet/libraries/databases/db/Database;", "Lcom/coinbase/walletengine/services/xrp/XRPService;", "xrpService", "()Lcom/coinbase/walletengine/services/xrp/XRPService;", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "()Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "Lcom/coinbase/wallet/ethereum/apis/ERC20ContractAPI;", "erc20ContractAPI", "()Lcom/coinbase/wallet/ethereum/apis/ERC20ContractAPI;", "Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "minerFeeAPI", "()Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "ethereumSignedTxDao", "()Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "Lcom/coinbase/wallet/wallets/di/WalletsComponent;", "component$delegate", "Lkotlin/h;", "getComponent$wallets_release", "()Lcom/coinbase/wallet/wallets/di/WalletsComponent;", "component", "Lretrofit2/t;", "retrofit", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/Coinbase;", "coinbase", "Lcom/coinbase/wallet/wallets/di/CryptoContainer;", "cryptoContainer", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "", "walletApiUrl", "walletBlockchainUrl", "walletXRPNodeUrl", "<init>", "(Lretrofit2/t;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/Coinbase;Lcom/coinbase/wallet/wallets/di/CryptoContainer;Lcom/coinbase/wallet/core/interfaces/Tracing;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WalletsContainer {
    private final h component$delegate;

    public WalletsContainer(t retrofit, StoreInterface store, Coinbase coinbase, CryptoContainer cryptoContainer, Tracing tracer, String walletApiUrl, String walletBlockchainUrl, String walletXRPNodeUrl) {
        h b2;
        m.g(retrofit, "retrofit");
        m.g(store, "store");
        m.g(coinbase, "coinbase");
        m.g(cryptoContainer, "cryptoContainer");
        m.g(tracer, "tracer");
        m.g(walletApiUrl, "walletApiUrl");
        m.g(walletBlockchainUrl, "walletBlockchainUrl");
        m.g(walletXRPNodeUrl, "walletXRPNodeUrl");
        b2 = k.b(new WalletsContainer$component$2(retrofit, store, coinbase, cryptoContainer, tracer, walletApiUrl, walletBlockchainUrl, walletXRPNodeUrl));
        this.component$delegate = b2;
    }

    public final AddressDao addressDao() {
        return getComponent$wallets_release().addressDao();
    }

    public final CompoundFinanceRepository compoundFinanceRepository() {
        return getComponent$wallets_release().compoundFinanceRepository();
    }

    public final CurrencyFormatter currencyFormatter() {
        return getComponent$wallets_release().currencyFormatter();
    }

    public final ERC20ContractAPI erc20ContractAPI() {
        return getComponent$wallets_release().erc20ContractAPI();
    }

    public final IERC20Fetching erc20Fetching() {
        return getComponent$wallets_release().erc20Fetching();
    }

    public final IETCWalletRepository etcWalletRepository() {
        return getComponent$wallets_release().etcWalletRepository();
    }

    public final IETHTxRepository ethTxRepository() {
        return getComponent$wallets_release().ethTxRepository();
    }

    public final IETHWalletRepository ethWalletRepository() {
        return getComponent$wallets_release().ethWalletRepository();
    }

    public final EthereumSignedTxDao ethereumSignedTxDao() {
        return getComponent$wallets_release().ethereumSignedTxDao();
    }

    public final IExchangeRateRepository exchangeRateRepository() {
        return getComponent$wallets_release().exchangeRateRepository();
    }

    public final IFiatCurrencyRepository fiatCurrencyRepository() {
        return getComponent$wallets_release().fiatCurrencyRepository();
    }

    public final WalletsComponent getComponent$wallets_release() {
        return (WalletsComponent) this.component$delegate.getValue();
    }

    public final MinerFeeAPI minerFeeAPI() {
        return getComponent$wallets_release().minerFeeAPI();
    }

    public final List<NetworkSetting> networkSettings() {
        return getComponent$wallets_release().networkSettings();
    }

    public final ITxRepository txRepository() {
        return getComponent$wallets_release().txRepository();
    }

    public final WalletEngine walletEngine() {
        return getComponent$wallets_release().walletEngine();
    }

    public final IWalletRepository walletRepository() {
        return getComponent$wallets_release().walletRepository();
    }

    public final Database<WalletsDatabase> walletsDatabase() {
        return getComponent$wallets_release().walletsDatabase();
    }

    public final XRPService xrpService() {
        return getComponent$wallets_release().xrpService();
    }
}