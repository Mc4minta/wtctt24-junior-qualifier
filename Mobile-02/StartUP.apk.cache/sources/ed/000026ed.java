package com.coinbase.wallet.swap.repositories;

import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.TxSource;
import com.coinbase.wallet.blockchains.models.UnsignedTxResult;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.ethereum.apis.ERC20ContractAPI;
import com.coinbase.wallet.ethereum.apis.MinerFeeAPI;
import com.coinbase.wallet.ethereum.dtos.AdjustableMinerFee1559Result;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.EthereumChain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.TxMetadataKey_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.WalletConfiguration_EthereumKt;
import com.coinbase.wallet.ethereum.interfaces.ERC20Approving;
import com.coinbase.wallet.ethereum.interfaces.EthereumTxCreating;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration;
import com.coinbase.wallet.ethereum.models.EthereumUnsigned1559Tx;
import com.coinbase.wallet.ethereum.models.EthereumUnsignedLegacyTx;
import com.coinbase.wallet.ethereum.models.GasEstimationStatus;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.swap.apis.SwapAPI;
import com.coinbase.wallet.swap.daos.SwapAssetStatsDAO;
import com.coinbase.wallet.swap.interfaces.ISwapRepository;
import com.coinbase.wallet.swap.models.Aggregator;
import com.coinbase.wallet.swap.models.AmountBase;
import com.coinbase.wallet.swap.models.ApproveTx;
import com.coinbase.wallet.swap.models.SwapAsset;
import com.coinbase.wallet.swap.models.SwapAssetInfo;
import com.coinbase.wallet.swap.models.SwapAssetStats;
import com.coinbase.wallet.swap.models.SwapQuote;
import com.coinbase.wallet.swap.models.SwapTrade;
import com.coinbase.wallet.wallets.extensions.StoreKeys_WalletsKt;
import h.c.b0;
import h.c.h0;
import h.c.m0.n;
import h.c.s;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.l0;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.l0.v;
import kotlin.u;
import kotlin.x;

/* compiled from: SwapRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BA\b\u0007\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010[\u001a\u00020Z\u0012\u0006\u0010J\u001a\u00020I\u0012\u0006\u0010`\u001a\u00020_\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010R\u001a\u00020Q\u0012\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bd\u0010eJ\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00120\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J=\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00052\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b!\u0010\"JE\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00052\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b&\u0010'J+\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b)\u0010*J+\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b+\u0010*J#\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u000e0\u00052\u0006\u0010,\u001a\u00020%H\u0016¢\u0006\u0004\b.\u0010/J#\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000e0\u00052\u0006\u0010,\u001a\u00020%H\u0016¢\u0006\u0004\b1\u0010/J-\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u000e0\u00052\u0006\u0010,\u001a\u00020%2\b\u00102\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b3\u00104J-\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000e0\u00052\u0006\u0010,\u001a\u00020%2\b\u00102\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b5\u00104J\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u00106\u001a\u00020\u000fH\u0016¢\u0006\u0004\b7\u00108J\u001b\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00120\u0005H\u0016¢\u0006\u0004\b:\u0010;R\"\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00120<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010\u001f\u001a\u00020\u001e8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u001c\u0010E\u001a\u00020D8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001c\u0010J\u001a\u00020I8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0016\u0010O\u001a\u00020N8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010R\u001a\u00020Q8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR(\u0010U\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00150T0<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010>R(\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00120\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u001c\u0010[\u001a\u00020Z8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u001c\u0010`\u001a\u00020_8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c¨\u0006f"}, d2 = {"Lcom/coinbase/wallet/swap/repositories/SwapRepository;", "Lcom/coinbase/wallet/swap/interfaces/ISwapRepository;", "Lcom/coinbase/wallet/ethereum/interfaces/ERC20Approving;", "", "isForced", "Lh/c/b0;", "Lkotlin/x;", "refresh", "(Z)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/ethereum/models/ContractAddress;", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "Lh/c/s;", "Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "observeSwapAsset", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/ethereum/models/ContractAddress;)Lh/c/s;", "", "", "ids", "Lcom/coinbase/wallet/swap/models/Aggregator;", "getAggregators", "(Ljava/util/List;)Lh/c/b0;", Payload.SOURCE, "target", "Ljava/math/BigInteger;", "amount", "Lcom/coinbase/wallet/swap/models/AmountBase;", "amountBase", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lcom/coinbase/wallet/swap/models/SwapQuote;", "getFastQuote", "(Lcom/coinbase/wallet/swap/models/SwapAsset;Lcom/coinbase/wallet/swap/models/SwapAsset;Ljava/math/BigInteger;Lcom/coinbase/wallet/swap/models/AmountBase;I)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/WalletAddress;", "address", "Lcom/coinbase/wallet/swap/models/SwapTrade;", "getTrade", "(Lcom/coinbase/wallet/blockchains/models/WalletAddress;Lcom/coinbase/wallet/swap/models/SwapAsset;Lcom/coinbase/wallet/swap/models/SwapAsset;Ljava/math/BigInteger;Lcom/coinbase/wallet/swap/models/AmountBase;I)Lh/c/b0;", "signedTxHashes", "getEstimatedMinerFee", "(Ljava/util/List;I)Lh/c/b0;", "getEstimatedGasLimit", "trade", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsignedLegacyTx;", "generateUnsignedApproveTx", "(Lcom/coinbase/wallet/swap/models/SwapTrade;)Lh/c/b0;", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;", "generateUnsigned1559ApproveTx", AdjustableMinerFeeArgs.NONCE, "generateUnsignedSwapTx", "(Lcom/coinbase/wallet/swap/models/SwapTrade;Ljava/lang/Integer;)Lh/c/b0;", "generateUnsigned1559SwapTx", "asset", "selectSwapAsset", "(Lcom/coinbase/wallet/swap/models/SwapAsset;)Lh/c/b0;", "Lcom/coinbase/wallet/swap/models/SwapAssetStats;", "getSwapAssetStats", "()Lh/c/b0;", "Lh/c/v0/a;", "swapAssetListSubject", "Lh/c/v0/a;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "getChainId", "()I", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "getCipherCore", "()Lcom/coinbase/ciphercore/CipherCoreInterface;", "Lcom/coinbase/wallet/ethereum/apis/ERC20ContractAPI;", "erc20ContractAPI", "Lcom/coinbase/wallet/ethereum/apis/ERC20ContractAPI;", "getErc20ContractAPI", "()Lcom/coinbase/wallet/ethereum/apis/ERC20ContractAPI;", "Lcom/coinbase/wallet/swap/apis/SwapAPI;", "api", "Lcom/coinbase/wallet/swap/apis/SwapAPI;", "Lcom/coinbase/wallet/swap/daos/SwapAssetStatsDAO;", "swapStatsDAO", "Lcom/coinbase/wallet/swap/daos/SwapAssetStatsDAO;", "", "aggregatorMapSubject", "swapAssetListObservable", "Lh/c/s;", "getSwapAssetListObservable", "()Lh/c/s;", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "getAddressDao", "()Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "minerFeeAPI", "Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "getMinerFeeAPI", "()Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "<init>", "(Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/ethereum/apis/ERC20ContractAPI;Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;Lcom/coinbase/wallet/swap/apis/SwapAPI;Lcom/coinbase/wallet/swap/daos/SwapAssetStatsDAO;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapRepository implements ISwapRepository, ERC20Approving {
    private final AddressDao addressDao;
    private final h.c.v0.a<Map<String, Aggregator>> aggregatorMapSubject;
    private final SwapAPI api;
    private final CipherCoreInterface cipherCore;
    private final ERC20ContractAPI erc20ContractAPI;
    private final MinerFeeAPI minerFeeAPI;
    private final StoreInterface store;
    private final s<List<SwapAsset>> swapAssetListObservable;
    private final h.c.v0.a<List<SwapAsset>> swapAssetListSubject;
    private final SwapAssetStatsDAO swapStatsDAO;

    public SwapRepository(CipherCoreInterface cipherCore, AddressDao addressDao, ERC20ContractAPI erc20ContractAPI, MinerFeeAPI minerFeeAPI, SwapAPI api, SwapAssetStatsDAO swapStatsDAO, StoreInterface store) {
        m.g(cipherCore, "cipherCore");
        m.g(addressDao, "addressDao");
        m.g(erc20ContractAPI, "erc20ContractAPI");
        m.g(minerFeeAPI, "minerFeeAPI");
        m.g(api, "api");
        m.g(swapStatsDAO, "swapStatsDAO");
        m.g(store, "store");
        this.cipherCore = cipherCore;
        this.addressDao = addressDao;
        this.erc20ContractAPI = erc20ContractAPI;
        this.minerFeeAPI = minerFeeAPI;
        this.api = api;
        this.swapStatsDAO = swapStatsDAO;
        this.store = store;
        h.c.v0.a<List<SwapAsset>> d2 = h.c.v0.a.d();
        m.f(d2, "create()");
        this.swapAssetListSubject = d2;
        h.c.v0.a<Map<String, Aggregator>> d3 = h.c.v0.a.d();
        m.f(d3, "create()");
        this.aggregatorMapSubject = d3;
        s<List<SwapAsset>> hide = d2.hide();
        m.f(hide, "swapAssetListSubject.hide()");
        this.swapAssetListObservable = hide;
    }

    public static /* synthetic */ h0 b(SwapRepository swapRepository, SwapTrade swapTrade, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte[] bArr, Network network, Integer num, SwapQuote swapQuote, AdjustableMinerFee1559Result adjustableMinerFee1559Result) {
        return m1730generateUnsigned1559SwapTx$lambda11(swapRepository, swapTrade, bigInteger, bigInteger2, bigInteger3, bArr, network, num, swapQuote, adjustableMinerFee1559Result);
    }

    public static /* synthetic */ h0 c(SwapAsset swapAsset, SwapRepository swapRepository, Optional optional) {
        return m1737selectSwapAsset$lambda12(swapAsset, swapRepository, optional);
    }

    public static /* synthetic */ Optional d(UnsignedTxResult unsignedTxResult) {
        return m1731generateUnsigned1559SwapTx$lambda11$lambda10(unsignedTxResult);
    }

    public static /* synthetic */ List e(List list, Map map) {
        return m1734getAggregators$lambda5(list, map);
    }

    public static /* synthetic */ Optional f(UnsignedTxResult unsignedTxResult) {
        return m1729generateUnsigned1559ApproveTx$lambda8$lambda7(unsignedTxResult);
    }

    public static /* synthetic */ x g(SwapRepository swapRepository, SwapAssetInfo swapAssetInfo) {
        return m1736refresh$lambda1(swapRepository, swapAssetInfo);
    }

    /* renamed from: generateUnsigned1559ApproveTx$lambda-8 */
    public static final h0 m1728generateUnsigned1559ApproveTx$lambda8(ApproveTx approveTx, SwapQuote quote, SwapRepository this$0, BigInteger gasLimit, byte[] data, Network network, AdjustableMinerFee1559Result gasData) {
        Map e2;
        m.g(approveTx, "$approveTx");
        m.g(quote, "$quote");
        m.g(this$0, "this$0");
        m.g(gasLimit, "$gasLimit");
        m.g(data, "$data");
        m.g(network, "$network");
        m.g(gasData, "gasData");
        String from$swap_release = approveTx.getFrom$swap_release();
        String to$swap_release = approveTx.getTo$swap_release();
        BigInteger ZERO = BigInteger.ZERO;
        BigInteger bigInteger = new BigInteger(approveTx.getGasPrice$swap_release());
        BigInteger baseFee = gasData.getBaseFee();
        BigInteger fastPriorityFee = gasData.getFastPriorityFee();
        CurrencyCode currencyCode = quote.getFromAsset().getCurrencyCode();
        Blockchain ethereum = Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion);
        e2 = l0.e(u.a(TxMetadataKey_EthereumKt.getTxSource(TxMetadataKey.Companion), TxSource.Dex.getValue()));
        m.f(ZERO, "ZERO");
        return EthereumTxCreating.DefaultImpls.generateUnsignedEthereum1559Tx$default(this$0, from$swap_release, to$swap_release, ZERO, bigInteger, fastPriorityFee, baseFee, gasLimit, data, network, null, currencyCode, ethereum, e2, 512, null).map(new n() { // from class: com.coinbase.wallet.swap.repositories.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapRepository.f((UnsignedTxResult) obj);
            }
        });
    }

    /* renamed from: generateUnsigned1559ApproveTx$lambda-8$lambda-7 */
    public static final Optional m1729generateUnsigned1559ApproveTx$lambda8$lambda7(UnsignedTxResult it) {
        m.g(it, "it");
        UnsignedTx transaction = it.getTransaction();
        EthereumUnsigned1559Tx ethereumUnsigned1559Tx = transaction instanceof EthereumUnsigned1559Tx ? (EthereumUnsigned1559Tx) transaction : null;
        if (ethereumUnsigned1559Tx == null) {
            return null;
        }
        return OptionalKt.toOptional(ethereumUnsigned1559Tx);
    }

    /* renamed from: generateUnsigned1559SwapTx$lambda-11 */
    public static final h0 m1730generateUnsigned1559SwapTx$lambda11(SwapRepository this$0, SwapTrade trade, BigInteger ethValue, BigInteger gasPrice, BigInteger gasLimit, byte[] data, Network network, Integer num, SwapQuote quote, AdjustableMinerFee1559Result gasData) {
        Map<TxMetadataKey, ? extends Object> e2;
        m.g(this$0, "this$0");
        m.g(trade, "$trade");
        m.g(gasPrice, "$gasPrice");
        m.g(gasLimit, "$gasLimit");
        m.g(data, "$data");
        m.g(network, "$network");
        m.g(quote, "$quote");
        m.g(gasData, "gasData");
        String from$swap_release = trade.getTx$swap_release().getFrom$swap_release();
        String to$swap_release = trade.getTx$swap_release().getTo$swap_release();
        m.f(ethValue, "ethValue");
        BigInteger fastPriorityFee = gasData.getFastPriorityFee();
        BigInteger baseFee = gasData.getBaseFee();
        CurrencyCode currencyCode = quote.getFromAsset().getCurrencyCode();
        Blockchain ethereum = Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion);
        e2 = l0.e(u.a(TxMetadataKey_EthereumKt.getTxSource(TxMetadataKey.Companion), TxSource.Dex.getValue()));
        return this$0.generateUnsignedEthereum1559Tx(from$swap_release, to$swap_release, ethValue, gasPrice, fastPriorityFee, baseFee, gasLimit, data, network, num, currencyCode, ethereum, e2).map(new n() { // from class: com.coinbase.wallet.swap.repositories.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapRepository.d((UnsignedTxResult) obj);
            }
        });
    }

    /* renamed from: generateUnsigned1559SwapTx$lambda-11$lambda-10 */
    public static final Optional m1731generateUnsigned1559SwapTx$lambda11$lambda10(UnsignedTxResult it) {
        m.g(it, "it");
        UnsignedTx transaction = it.getTransaction();
        EthereumUnsigned1559Tx ethereumUnsigned1559Tx = transaction instanceof EthereumUnsigned1559Tx ? (EthereumUnsigned1559Tx) transaction : null;
        if (ethereumUnsigned1559Tx == null) {
            return null;
        }
        return OptionalKt.toOptional(ethereumUnsigned1559Tx);
    }

    /* renamed from: generateUnsignedApproveTx$lambda-6 */
    public static final Optional m1732generateUnsignedApproveTx$lambda6(UnsignedTxResult it) {
        m.g(it, "it");
        UnsignedTx transaction = it.getTransaction();
        EthereumUnsignedLegacyTx ethereumUnsignedLegacyTx = transaction instanceof EthereumUnsignedLegacyTx ? (EthereumUnsignedLegacyTx) transaction : null;
        if (ethereumUnsignedLegacyTx == null) {
            return null;
        }
        return OptionalKt.toOptional(ethereumUnsignedLegacyTx);
    }

    /* renamed from: generateUnsignedSwapTx$lambda-9 */
    public static final Optional m1733generateUnsignedSwapTx$lambda9(UnsignedTxResult it) {
        m.g(it, "it");
        UnsignedTx transaction = it.getTransaction();
        EthereumUnsignedLegacyTx ethereumUnsignedLegacyTx = transaction instanceof EthereumUnsignedLegacyTx ? (EthereumUnsignedLegacyTx) transaction : null;
        if (ethereumUnsignedLegacyTx == null) {
            return null;
        }
        return OptionalKt.toOptional(ethereumUnsignedLegacyTx);
    }

    /* renamed from: getAggregators$lambda-5 */
    public static final List m1734getAggregators$lambda5(List ids, Map aggregatorMap) {
        m.g(ids, "$ids");
        m.g(aggregatorMap, "aggregatorMap");
        ArrayList arrayList = new ArrayList();
        Iterator it = ids.iterator();
        while (it.hasNext()) {
            Aggregator aggregator = (Aggregator) aggregatorMap.get((String) it.next());
            if (aggregator != null) {
                arrayList.add(aggregator);
            }
        }
        return arrayList;
    }

    private final int getChainId() {
        EthereumChain asEthereumChain;
        Network network = (Network) this.store.get(StoreKeys_WalletsKt.activeNetwork(StoreKeys.INSTANCE, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)));
        Integer num = null;
        if (network != null && (asEthereumChain = Network_EthereumKt.getAsEthereumChain(network)) != null) {
            num = Integer.valueOf(asEthereumChain.getChainId());
        }
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    public static /* synthetic */ Optional h(UnsignedTxResult unsignedTxResult) {
        return m1732generateUnsignedApproveTx$lambda6(unsignedTxResult);
    }

    public static /* synthetic */ Optional i(UnsignedTxResult unsignedTxResult) {
        return m1733generateUnsignedSwapTx$lambda9(unsignedTxResult);
    }

    public static /* synthetic */ Optional j(ContractAddress contractAddress, CurrencyCode currencyCode, List list) {
        return m1735observeSwapAsset$lambda3(contractAddress, currencyCode, list);
    }

    public static /* synthetic */ h0 k(ApproveTx approveTx, SwapQuote swapQuote, SwapRepository swapRepository, BigInteger bigInteger, byte[] bArr, Network network, AdjustableMinerFee1559Result adjustableMinerFee1559Result) {
        return m1728generateUnsigned1559ApproveTx$lambda8(approveTx, swapQuote, swapRepository, bigInteger, bArr, network, adjustableMinerFee1559Result);
    }

    /* renamed from: observeSwapAsset$lambda-3 */
    public static final Optional m1735observeSwapAsset$lambda3(ContractAddress contractAddress, CurrencyCode currencyCode, List assetList) {
        Object obj;
        boolean z;
        m.g(currencyCode, "$currencyCode");
        m.g(assetList, "assetList");
        Iterator it = assetList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            SwapAsset swapAsset = (SwapAsset) obj;
            if (m.c(swapAsset.getContractAddress(), contractAddress) && m.c(swapAsset.getCurrencyCode(), currencyCode)) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        return OptionalKt.toOptional(obj);
    }

    /* renamed from: refresh$lambda-1 */
    public static final x m1736refresh$lambda1(SwapRepository this$0, SwapAssetInfo assetInfo) {
        List<SwapAsset> t0;
        m.g(this$0, "this$0");
        m.g(assetInfo, "assetInfo");
        List<Aggregator> aggregators = assetInfo.getAggregators();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Aggregator aggregator : aggregators) {
            linkedHashMap.put(aggregator.getId(), aggregator);
        }
        this$0.aggregatorMapSubject.onNext(linkedHashMap);
        h.c.v0.a<List<SwapAsset>> aVar = this$0.swapAssetListSubject;
        t0 = z.t0(assetInfo.getSupported(), assetInfo.getUnsupported());
        aVar.onNext(t0);
        return x.a;
    }

    /* renamed from: selectSwapAsset$lambda-12 */
    public static final h0 m1737selectSwapAsset$lambda12(SwapAsset asset, SwapRepository this$0, Optional assetStatOptional) {
        SwapAssetStats swapAssetStats;
        m.g(asset, "$asset");
        m.g(this$0, "this$0");
        m.g(assetStatOptional, "assetStatOptional");
        SwapAssetStats swapAssetStats2 = (SwapAssetStats) assetStatOptional.getValue();
        if (swapAssetStats2 != null) {
            swapAssetStats = SwapAssetStats.copy$default(swapAssetStats2, null, null, null, null, swapAssetStats2.getSelectedCount() + 1, 15, null);
        } else {
            swapAssetStats = new SwapAssetStats(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), asset.getCurrencyCode(), asset.getContractAddress(), 1);
        }
        return this$0.swapStatsDAO.save(swapAssetStats);
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.ERC20Approving
    public b0<Optional<UnsignedTxResult>> generateApproveTx(String str, String str2, String str3, CurrencyCode currencyCode, BigInteger bigInteger, BigInteger bigInteger2, Map<TxMetadataKey, ? extends Object> map) {
        return ERC20Approving.DefaultImpls.generateApproveTx(this, str, str2, str3, currencyCode, bigInteger, bigInteger2, map);
    }

    @Override // com.coinbase.wallet.swap.interfaces.ISwapRepository
    public b0<Optional<EthereumUnsigned1559Tx>> generateUnsigned1559ApproveTx(SwapTrade trade) {
        final BigInteger k2;
        m.g(trade, "trade");
        final ApproveTx approveTx$swap_release = trade.getApproveTx$swap_release();
        if (approveTx$swap_release == null) {
            h.c.t0.e eVar = h.c.t0.e.a;
            b0<Optional<EthereumUnsigned1559Tx>> just = b0.just(new Optional(null));
            m.f(just, "just(Optional(null))");
            return just;
        }
        final SwapQuote quote = trade.getQuote();
        final byte[] approveHexEncodedTxData = trade.getApproveHexEncodedTxData();
        if (approveHexEncodedTxData == null) {
            h.c.t0.e eVar2 = h.c.t0.e.a;
            b0<Optional<EthereumUnsigned1559Tx>> just2 = b0.just(new Optional(null));
            m.f(just2, "just(Optional(null))");
            return just2;
        }
        k2 = v.k(approveTx$swap_release.getGas$swap_release());
        if (k2 == null) {
            h.c.t0.e eVar3 = h.c.t0.e.a;
            b0<Optional<EthereumUnsigned1559Tx>> just3 = b0.just(new Optional(null));
            m.f(just3, "just(Optional(null))");
            return just3;
        }
        EthereumChain fromChainId = EthereumChain.Companion.fromChainId(getChainId());
        final Network asNetwork = fromChainId == null ? null : EthereumChain_EthereumKt.getAsNetwork(fromChainId);
        if (asNetwork == null) {
            h.c.t0.e eVar4 = h.c.t0.e.a;
            b0<Optional<EthereumUnsigned1559Tx>> just4 = b0.just(new Optional(null));
            m.f(just4, "just(Optional(null))");
            return just4;
        }
        b0 flatMap = getMinerFeeAPI().get1559MinerFeeEstimates(getChainId()).flatMap(new n() { // from class: com.coinbase.wallet.swap.repositories.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapRepository.k(ApproveTx.this, quote, this, k2, approveHexEncodedTxData, asNetwork, (AdjustableMinerFee1559Result) obj);
            }
        });
        m.f(flatMap, "minerFeeAPI.get1559MinerFeeEstimates(chainId).flatMap { gasData ->\n\n            generateUnsignedEthereum1559Tx(\n                fromAddress = approveTx.from,\n                toAddress = approveTx.to,\n                weiValue = BigInteger.ZERO,\n                maxFeePerGas = approveTx.gasPrice.toBigInteger(),\n                baseFeePerGas = gasData.baseFee,\n                gasLimit = gasLimit,\n                maxPriorityFeePerGas = gasData.fastPriorityFee,\n                data = data,\n                network = network,\n                currencyCode = quote.fromAsset.currencyCode,\n                blockchain = Blockchain.ETHEREUM,\n                metadata = mapOf(TxMetadataKey.txSource to TxSource.Dex.value)\n            )\n                .map {\n                    val unsignedTxResult = it.transaction as? EthereumUnsigned1559Tx ?: return@map null\n                    unsignedTxResult.toOptional()\n                }\n        }");
        return flatMap;
    }

    @Override // com.coinbase.wallet.swap.interfaces.ISwapRepository
    public b0<Optional<EthereumUnsigned1559Tx>> generateUnsigned1559SwapTx(final SwapTrade trade, final Integer num) {
        final BigInteger k2;
        final BigInteger k3;
        m.g(trade, "trade");
        final SwapQuote quote = trade.getQuote();
        final BigInteger chainPrimaryAssetValue = quote.getFromAsset().getContractAddress() == null && m.c(quote.getFromAsset().getCurrencyCode(), CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion)) ? trade.getChainPrimaryAssetValue() : BigInteger.ZERO;
        final byte[] swapHexEncodedTxData = trade.getSwapHexEncodedTxData();
        if (swapHexEncodedTxData == null) {
            h.c.t0.e eVar = h.c.t0.e.a;
            b0<Optional<EthereumUnsigned1559Tx>> just = b0.just(new Optional(null));
            m.f(just, "just(Optional(null))");
            return just;
        }
        k2 = v.k(trade.getTx$swap_release().getGas$swap_release());
        if (k2 == null) {
            h.c.t0.e eVar2 = h.c.t0.e.a;
            b0<Optional<EthereumUnsigned1559Tx>> just2 = b0.just(new Optional(null));
            m.f(just2, "just(Optional(null))");
            return just2;
        }
        k3 = v.k(trade.getTx$swap_release().getGasPrice$swap_release());
        if (k3 == null) {
            h.c.t0.e eVar3 = h.c.t0.e.a;
            b0<Optional<EthereumUnsigned1559Tx>> just3 = b0.just(new Optional(null));
            m.f(just3, "just(Optional(null))");
            return just3;
        }
        EthereumChain fromChainId = EthereumChain.Companion.fromChainId(getChainId());
        final Network asNetwork = fromChainId == null ? null : EthereumChain_EthereumKt.getAsNetwork(fromChainId);
        if (asNetwork == null) {
            h.c.t0.e eVar4 = h.c.t0.e.a;
            b0<Optional<EthereumUnsigned1559Tx>> just4 = b0.just(new Optional(null));
            m.f(just4, "just(Optional(null))");
            return just4;
        }
        b0 flatMap = getMinerFeeAPI().get1559MinerFeeEstimates(getChainId()).flatMap(new n() { // from class: com.coinbase.wallet.swap.repositories.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapRepository.b(SwapRepository.this, trade, chainPrimaryAssetValue, k3, k2, swapHexEncodedTxData, asNetwork, num, quote, (AdjustableMinerFee1559Result) obj);
            }
        });
        m.f(flatMap, "minerFeeAPI.get1559MinerFeeEstimates(chainId).flatMap { gasData ->\n            generateUnsignedEthereum1559Tx(\n                fromAddress = trade.tx.from,\n                toAddress = trade.tx.to,\n                weiValue = ethValue,\n                maxFeePerGas = gasPrice,\n                maxPriorityFeePerGas = gasData.fastPriorityFee,\n                baseFeePerGas = gasData.baseFee,\n                gasLimit = gasLimit,\n                data = data,\n                network = network,\n                nonce = nonce,\n                currencyCode = quote.fromAsset.currencyCode,\n                blockchain = Blockchain.ETHEREUM,\n                metadata = mapOf(TxMetadataKey.txSource to TxSource.Dex.value)\n            )\n                .map {\n                    val unsignedTxResult = it.transaction as? EthereumUnsigned1559Tx ?: return@map null\n                    unsignedTxResult.toOptional()\n                }\n        }");
        return flatMap;
    }

    @Override // com.coinbase.wallet.swap.interfaces.ISwapRepository
    public b0<Optional<EthereumUnsignedLegacyTx>> generateUnsignedApproveTx(SwapTrade trade) {
        BigInteger k2;
        BigInteger k3;
        Map e2;
        m.g(trade, "trade");
        ApproveTx approveTx$swap_release = trade.getApproveTx$swap_release();
        if (approveTx$swap_release == null) {
            h.c.t0.e eVar = h.c.t0.e.a;
            b0<Optional<EthereumUnsignedLegacyTx>> just = b0.just(new Optional(null));
            m.f(just, "just(Optional(null))");
            return just;
        }
        SwapQuote quote = trade.getQuote();
        byte[] approveHexEncodedTxData = trade.getApproveHexEncodedTxData();
        if (approveHexEncodedTxData == null) {
            h.c.t0.e eVar2 = h.c.t0.e.a;
            b0<Optional<EthereumUnsignedLegacyTx>> just2 = b0.just(new Optional(null));
            m.f(just2, "just(Optional(null))");
            return just2;
        }
        k2 = v.k(approveTx$swap_release.getGasPrice$swap_release());
        if (k2 == null) {
            h.c.t0.e eVar3 = h.c.t0.e.a;
            b0<Optional<EthereumUnsignedLegacyTx>> just3 = b0.just(new Optional(null));
            m.f(just3, "just(Optional(null))");
            return just3;
        }
        k3 = v.k(approveTx$swap_release.getGas$swap_release());
        if (k3 == null) {
            h.c.t0.e eVar4 = h.c.t0.e.a;
            b0<Optional<EthereumUnsignedLegacyTx>> just4 = b0.just(new Optional(null));
            m.f(just4, "just(Optional(null))");
            return just4;
        }
        EthereumChain fromChainId = EthereumChain.Companion.fromChainId(getChainId());
        Network asNetwork = fromChainId == null ? null : EthereumChain_EthereumKt.getAsNetwork(fromChainId);
        if (asNetwork == null) {
            h.c.t0.e eVar5 = h.c.t0.e.a;
            b0<Optional<EthereumUnsignedLegacyTx>> just5 = b0.just(new Optional(null));
            m.f(just5, "just(Optional(null))");
            return just5;
        }
        String from$swap_release = approveTx$swap_release.getFrom$swap_release();
        String to$swap_release = approveTx$swap_release.getTo$swap_release();
        BigInteger ZERO = BigInteger.ZERO;
        m.f(ZERO, "ZERO");
        CurrencyCode currencyCode = quote.getFromAsset().getCurrencyCode();
        Blockchain ethereum = Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion);
        e2 = l0.e(u.a(TxMetadataKey_EthereumKt.getTxSource(TxMetadataKey.Companion), TxSource.Dex.getValue()));
        b0<Optional<EthereumUnsignedLegacyTx>> map = EthereumTxCreating.DefaultImpls.generateUnsignedEthereumTx$default(this, from$swap_release, to$swap_release, ZERO, k2, k3, approveHexEncodedTxData, asNetwork, null, currencyCode, ethereum, e2, 128, null).map(new n() { // from class: com.coinbase.wallet.swap.repositories.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapRepository.h((UnsignedTxResult) obj);
            }
        });
        m.f(map, "generateUnsignedEthereumTx(\n            fromAddress = approveTx.from,\n            toAddress = approveTx.to,\n            weiValue = BigInteger.ZERO,\n            gasPrice = gasPrice,\n            gasLimit = gasLimit,\n            data = data,\n            network = network,\n            currencyCode = quote.fromAsset.currencyCode,\n            blockchain = Blockchain.ETHEREUM,\n            metadata = mapOf(TxMetadataKey.txSource to TxSource.Dex.value)\n        )\n            .map {\n                val unsignedTxResult = it.transaction as? EthereumUnsignedLegacyTx ?: return@map null\n                unsignedTxResult.toOptional()\n            }");
        return map;
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxCreating
    public b0<UnsignedTxResult> generateUnsignedEthereum1559Tx(String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, byte[] bArr, Network network, Integer num, CurrencyCode currencyCode, Blockchain blockchain, Map<TxMetadataKey, ? extends Object> map) {
        return ERC20Approving.DefaultImpls.generateUnsignedEthereum1559Tx(this, str, str2, bigInteger, bigInteger2, bigInteger3, bigInteger4, bigInteger5, bArr, network, num, currencyCode, blockchain, map);
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxCreating
    public b0<UnsignedTxResult> generateUnsignedEthereumTx(String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte[] bArr, Network network, Integer num, CurrencyCode currencyCode, Blockchain blockchain, Map<TxMetadataKey, ? extends Object> map) {
        return ERC20Approving.DefaultImpls.generateUnsignedEthereumTx(this, str, str2, bigInteger, bigInteger2, bigInteger3, bArr, network, num, currencyCode, blockchain, map);
    }

    @Override // com.coinbase.wallet.swap.interfaces.ISwapRepository
    public b0<Optional<EthereumUnsignedLegacyTx>> generateUnsignedSwapTx(SwapTrade trade, Integer num) {
        BigInteger k2;
        BigInteger k3;
        Map<TxMetadataKey, ? extends Object> e2;
        m.g(trade, "trade");
        SwapQuote quote = trade.getQuote();
        EthereumChain fromChainId = EthereumChain.Companion.fromChainId(getChainId());
        Network asNetwork = fromChainId == null ? null : EthereumChain_EthereumKt.getAsNetwork(fromChainId);
        if (asNetwork == null) {
            h.c.t0.e eVar = h.c.t0.e.a;
            b0<Optional<EthereumUnsignedLegacyTx>> just = b0.just(new Optional(null));
            m.f(just, "just(Optional(null))");
            return just;
        }
        BigInteger primaryAssetValue = quote.getFromAsset().getContractAddress() == null && m.c(WalletConfiguration_EthereumKt.getETH(EthereumBasedConfiguration.Companion).currencyCodeForNetwork(asNetwork), quote.getFromAsset().getCurrencyCode()) ? trade.getChainPrimaryAssetValue() : BigInteger.ZERO;
        byte[] swapHexEncodedTxData = trade.getSwapHexEncodedTxData();
        if (swapHexEncodedTxData == null) {
            h.c.t0.e eVar2 = h.c.t0.e.a;
            b0<Optional<EthereumUnsignedLegacyTx>> just2 = b0.just(new Optional(null));
            m.f(just2, "just(Optional(null))");
            return just2;
        }
        k2 = v.k(trade.getTx$swap_release().getGasPrice$swap_release());
        if (k2 == null) {
            h.c.t0.e eVar3 = h.c.t0.e.a;
            b0<Optional<EthereumUnsignedLegacyTx>> just3 = b0.just(new Optional(null));
            m.f(just3, "just(Optional(null))");
            return just3;
        }
        k3 = v.k(trade.getTx$swap_release().getGas$swap_release());
        if (k3 == null) {
            h.c.t0.e eVar4 = h.c.t0.e.a;
            b0<Optional<EthereumUnsignedLegacyTx>> just4 = b0.just(new Optional(null));
            m.f(just4, "just(Optional(null))");
            return just4;
        }
        String from$swap_release = trade.getTx$swap_release().getFrom$swap_release();
        String to$swap_release = trade.getTx$swap_release().getTo$swap_release();
        m.f(primaryAssetValue, "primaryAssetValue");
        CurrencyCode currencyCode = quote.getFromAsset().getCurrencyCode();
        Blockchain ethereum = Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion);
        e2 = l0.e(u.a(TxMetadataKey_EthereumKt.getTxSource(TxMetadataKey.Companion), TxSource.Dex.getValue()));
        b0 map = generateUnsignedEthereumTx(from$swap_release, to$swap_release, primaryAssetValue, k2, k3, swapHexEncodedTxData, asNetwork, num, currencyCode, ethereum, e2).map(new n() { // from class: com.coinbase.wallet.swap.repositories.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapRepository.i((UnsignedTxResult) obj);
            }
        });
        m.f(map, "generateUnsignedEthereumTx(\n            fromAddress = trade.tx.from,\n            toAddress = trade.tx.to,\n            weiValue = primaryAssetValue,\n            gasPrice = gasPrice,\n            gasLimit = gasLimit,\n            data = data,\n            network = network,\n            nonce = nonce,\n            currencyCode = quote.fromAsset.currencyCode,\n            blockchain = Blockchain.ETHEREUM,\n            metadata = mapOf(TxMetadataKey.txSource to TxSource.Dex.value)\n        )\n            .map {\n                val unsignedTxResult = it.transaction as? EthereumUnsignedLegacyTx ?: return@map null\n                unsignedTxResult.toOptional()\n            }");
        return map;
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxCreating
    public b0<AdjustableMinerFee1559Result> get1559GasPrice(int i2) {
        return ERC20Approving.DefaultImpls.get1559GasPrice(this, i2);
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxCreating
    public AddressDao getAddressDao() {
        return this.addressDao;
    }

    @Override // com.coinbase.wallet.swap.interfaces.ISwapRepository
    public b0<List<Aggregator>> getAggregators(final List<String> ids) {
        m.g(ids, "ids");
        b0<List<Aggregator>> map = Observable_CoreKt.takeSingle(this.aggregatorMapSubject).map(new n() { // from class: com.coinbase.wallet.swap.repositories.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapRepository.e(ids, (Map) obj);
            }
        });
        m.f(map, "aggregatorMapSubject\n            .takeSingle()\n            .map { aggregatorMap ->\n                ids.mapNotNull { aggregatorMap[it] }\n            }");
        return map;
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxCreating, com.coinbase.wallet.ethereum.interfaces.EthereumTxSubmitting, com.coinbase.wallet.ethereum.interfaces.EthereumTxSigning, com.coinbase.wallet.ethereum.interfaces.EthereumTxResubmitting
    public CipherCoreInterface getCipherCore() {
        return this.cipherCore;
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.ERC20Approving
    public ERC20ContractAPI getErc20ContractAPI() {
        return this.erc20ContractAPI;
    }

    @Override // com.coinbase.wallet.swap.interfaces.ISwapRepository
    public b0<BigInteger> getEstimatedGasLimit(List<String> signedTxHashes, int i2) {
        m.g(signedTxHashes, "signedTxHashes");
        return this.api.estimatedGasConsumed(signedTxHashes, i2);
    }

    @Override // com.coinbase.wallet.swap.interfaces.ISwapRepository
    public b0<BigInteger> getEstimatedMinerFee(List<String> signedTxHashes, int i2) {
        m.g(signedTxHashes, "signedTxHashes");
        return this.api.getEstimatedMinerFee(signedTxHashes, i2);
    }

    @Override // com.coinbase.wallet.swap.interfaces.ISwapRepository
    public b0<SwapQuote> getFastQuote(SwapAsset source, SwapAsset target, BigInteger amount, AmountBase amountBase, int i2) {
        m.g(source, "source");
        m.g(target, "target");
        m.g(amount, "amount");
        m.g(amountBase, "amountBase");
        return this.api.getFastQuote(source, target, amount, amountBase, i2);
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxCreating
    public b0<GasEstimationStatus> getGasLimit(String str, String str2, BigInteger bigInteger, byte[] bArr, int i2) {
        return ERC20Approving.DefaultImpls.getGasLimit(this, str, str2, bigInteger, bArr, i2);
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxCreating
    public b0<BigInteger> getGasPrice(int i2) {
        return ERC20Approving.DefaultImpls.getGasPrice(this, i2);
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxCreating
    public MinerFeeAPI getMinerFeeAPI() {
        return this.minerFeeAPI;
    }

    @Override // com.coinbase.wallet.swap.interfaces.ISwapRepository
    public s<List<SwapAsset>> getSwapAssetListObservable() {
        return this.swapAssetListObservable;
    }

    @Override // com.coinbase.wallet.swap.interfaces.ISwapRepository
    public b0<List<SwapAssetStats>> getSwapAssetStats() {
        return this.swapStatsDAO.getSortedSwapAssetStats();
    }

    @Override // com.coinbase.wallet.swap.interfaces.ISwapRepository
    public b0<SwapTrade> getTrade(WalletAddress address, SwapAsset source, SwapAsset target, BigInteger amount, AmountBase amountBase, int i2) {
        m.g(address, "address");
        m.g(source, "source");
        m.g(target, "target");
        m.g(amount, "amount");
        m.g(amountBase, "amountBase");
        return this.api.getTrade(address, source, target, amount, amountBase, i2);
    }

    @Override // com.coinbase.wallet.swap.interfaces.ISwapRepository
    public s<Optional<SwapAsset>> observeSwapAsset(final CurrencyCode currencyCode, final ContractAddress contractAddress) {
        m.g(currencyCode, "currencyCode");
        s map = this.swapAssetListSubject.map(new n() { // from class: com.coinbase.wallet.swap.repositories.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapRepository.j(ContractAddress.this, currencyCode, (List) obj);
            }
        });
        m.f(map, "swapAssetListSubject\n            .map { assetList ->\n                assetList\n                    .find { it.contractAddress == contractAddress && it.currencyCode == currencyCode }\n                    .toOptional()\n            }");
        return map;
    }

    @Override // com.coinbase.wallet.swap.interfaces.ISwapRepository, com.coinbase.wallet.core.interfaces.Refreshable
    public b0<x> refresh(boolean z) {
        b0 map = this.api.getAssets(getChainId()).map(new n() { // from class: com.coinbase.wallet.swap.repositories.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapRepository.g(SwapRepository.this, (SwapAssetInfo) obj);
            }
        });
        m.f(map, "api.getAssets(chainId = chainId)\n            .map { assetInfo ->\n                val aggregatorMap = assetInfo.aggregators\n                    .reduceIntoMap<String, Aggregator, Aggregator> { aggregatorMap, aggregator ->\n                        aggregatorMap[aggregator.id] = aggregator\n                    }\n\n                aggregatorMapSubject.onNext(aggregatorMap)\n                swapAssetListSubject.onNext(assetInfo.supported + assetInfo.unsupported)\n            }");
        return map;
    }

    @Override // com.coinbase.wallet.swap.interfaces.ISwapRepository
    public b0<x> selectSwapAsset(final SwapAsset asset) {
        m.g(asset, "asset");
        b0<R> flatMap = this.swapStatsDAO.getSwapAssetStat(asset).flatMap(new n() { // from class: com.coinbase.wallet.swap.repositories.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapRepository.c(SwapAsset.this, this, (Optional) obj);
            }
        });
        m.f(flatMap, "swapStatsDAO.getSwapAssetStat(asset)\n            .flatMap { assetStatOptional ->\n                val assetStat = assetStatOptional.value\n                val updatedAssetStat = if (assetStat != null) {\n                    assetStat.copy(selectedCount = assetStat.selectedCount + 1)\n                } else {\n                    SwapAssetStats(\n                        blockchain = Blockchain.ETHEREUM, // FIXME: Vishnu - Hardcoded ETH\n                        currencyCode = asset.currencyCode,\n                        contractAddress = asset.contractAddress,\n                        selectedCount = 1\n                    )\n                }\n\n                swapStatsDAO.save(updatedAssetStat)\n            }");
        return Single_CoreKt.asUnit(flatMap);
    }
}