package com.coinbase.wallet.wallets.db;

import com.coinbase.wallet.bip44wallets.models.BIP44SignedTx;
import com.coinbase.wallet.blockchains.models.Address;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.compoundfinance.models.CompoundToken;
import com.coinbase.wallet.ethereum.models.ERC20;
import com.coinbase.wallet.ethereum.models.EthereumSignedTx;
import com.coinbase.wallet.libraries.databases.db.RoomDatabaseProvider;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface;
import com.coinbase.wallet.ripple.models.XRPSignedTx;
import com.coinbase.wallet.stellar.models.StellarSignedTx;
import com.coinbase.wallet.wallets.models.CryptoCurrency;
import com.coinbase.wallet.wallets.models.ExchangeRate;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.u;

/* compiled from: WalletsDatabase.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b3\u00104J#\u0010\u0005\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/coinbase/wallet/wallets/db/WalletsDatabase;", "Lcom/coinbase/wallet/libraries/databases/db/RoomDatabaseProvider;", "", "Ljava/lang/Class;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseDaoInterface;", "modelMappings", "()Ljava/util/Map;", "Lcom/coinbase/wallet/wallets/db/BIP44SignedTxRoomDao;", "getBip44SignedTxDao", "()Lcom/coinbase/wallet/wallets/db/BIP44SignedTxRoomDao;", "bip44SignedTxDao", "Lcom/coinbase/wallet/wallets/db/XRPSignedTxRoomDao;", "getXrpSignedTxDao", "()Lcom/coinbase/wallet/wallets/db/XRPSignedTxRoomDao;", "xrpSignedTxDao", "Lcom/coinbase/wallet/wallets/db/CompoundTokenRoomDao;", "getCompoundTokenRoomDao", "()Lcom/coinbase/wallet/wallets/db/CompoundTokenRoomDao;", "compoundTokenRoomDao", "Lcom/coinbase/wallet/wallets/db/FiatCurrencyRoomDao;", "getFiatCurrencyRoomDao", "()Lcom/coinbase/wallet/wallets/db/FiatCurrencyRoomDao;", "fiatCurrencyRoomDao", "Lcom/coinbase/wallet/wallets/db/EthereumSignedTxRoomDao;", "getEthereumSignedTxDao", "()Lcom/coinbase/wallet/wallets/db/EthereumSignedTxRoomDao;", "ethereumSignedTxDao", "Lcom/coinbase/wallet/wallets/db/CoinRoomDao;", "getCoinDao", "()Lcom/coinbase/wallet/wallets/db/CoinRoomDao;", "coinDao", "Lcom/coinbase/wallet/wallets/db/CryptoCurrencyRoomDao;", "getCryptoCurrencyRoomDao", "()Lcom/coinbase/wallet/wallets/db/CryptoCurrencyRoomDao;", "cryptoCurrencyRoomDao", "Lcom/coinbase/wallet/wallets/db/StellarSignedTxRoomDao;", "getStellarSignedTxDao", "()Lcom/coinbase/wallet/wallets/db/StellarSignedTxRoomDao;", "stellarSignedTxDao", "Lcom/coinbase/wallet/wallets/db/FiatExchangeRateRoomDao;", "getFiatExchangeRateRoomDao", "()Lcom/coinbase/wallet/wallets/db/FiatExchangeRateRoomDao;", "fiatExchangeRateRoomDao", "Lcom/coinbase/wallet/wallets/db/ERC20RoomDao;", "getErc20RoomDao", "()Lcom/coinbase/wallet/wallets/db/ERC20RoomDao;", "erc20RoomDao", "Lcom/coinbase/wallet/wallets/db/AddressRoomDao;", "getAddressDao", "()Lcom/coinbase/wallet/wallets/db/AddressRoomDao;", "addressDao", "<init>", "()V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class WalletsDatabase extends RoomDatabaseProvider {
    public abstract AddressRoomDao getAddressDao();

    public abstract BIP44SignedTxRoomDao getBip44SignedTxDao();

    public abstract CoinRoomDao getCoinDao();

    public abstract CompoundTokenRoomDao getCompoundTokenRoomDao();

    public abstract CryptoCurrencyRoomDao getCryptoCurrencyRoomDao();

    public abstract ERC20RoomDao getErc20RoomDao();

    public abstract EthereumSignedTxRoomDao getEthereumSignedTxDao();

    public abstract FiatCurrencyRoomDao getFiatCurrencyRoomDao();

    public abstract FiatExchangeRateRoomDao getFiatExchangeRateRoomDao();

    public abstract StellarSignedTxRoomDao getStellarSignedTxDao();

    public abstract XRPSignedTxRoomDao getXrpSignedTxDao();

    @Override // com.coinbase.wallet.libraries.databases.db.RoomDatabaseProvider
    public Map<Class<?>, DatabaseDaoInterface<?>> modelMappings() {
        Map<Class<?>, DatabaseDaoInterface<?>> l2;
        l2 = m0.l(u.a(Wallet.class, getCoinDao()), u.a(Address.class, getAddressDao()), u.a(EthereumSignedTx.class, getEthereumSignedTxDao()), u.a(XRPSignedTx.class, getXrpSignedTxDao()), u.a(StellarSignedTx.class, getStellarSignedTxDao()), u.a(BIP44SignedTx.class, getBip44SignedTxDao()), u.a(ERC20.class, getErc20RoomDao()), u.a(CompoundToken.class, getCompoundTokenRoomDao()), u.a(ExchangeRate.class, getFiatExchangeRateRoomDao()), u.a(FiatCurrency.class, getFiatCurrencyRoomDao()), u.a(CryptoCurrency.class, getCryptoCurrencyRoomDao()));
        return l2;
    }
}