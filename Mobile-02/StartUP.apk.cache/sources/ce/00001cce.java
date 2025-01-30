package com.coinbase.wallet.ethereum.repositories;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.CipherCore;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.ERC20Info;
import com.coinbase.ciphercore.EthereumTransactionReceipt;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.AnalyticsEvent_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.analytics.models.EventProperty;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.exceptions.NetworkException;
import com.coinbase.wallet.blockchains.models.Address;
import com.coinbase.wallet.blockchains.models.AddressType;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.RefreshContext;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.blockchains.models.WalletConfiguration;
import com.coinbase.wallet.core.extensions.BigIntegers;
import com.coinbase.wallet.core.extensions.BigIntegers_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.extensions.String_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.ethereum.apis.ERC20TokenAPI;
import com.coinbase.wallet.ethereum.daos.ERC20Dao;
import com.coinbase.wallet.ethereum.daos.EthereumSignedTxDao;
import com.coinbase.wallet.ethereum.dtos.GetERC20BalancesDTO;
import com.coinbase.wallet.ethereum.dtos.GetERC20InfoDTO;
import com.coinbase.wallet.ethereum.dtos.GetERC20TokenResponseDTO;
import com.coinbase.wallet.ethereum.exceptions.EthereumException;
import com.coinbase.wallet.ethereum.extensions.CipherCore_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.StoreKeys_EthereumKt;
import com.coinbase.wallet.ethereum.models.ERC20;
import com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration;
import com.coinbase.wallet.ethereum.models.EthereumSignedTx;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.a0.l0;
import org.apache.http.message.TokenParser;

/* compiled from: EthereumBasedBalanceRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001BG\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010J\u001a\u00020I\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010;\u001a\u00020:¢\u0006\u0004\bN\u0010OJ3\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJG\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000f0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J;\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000f0\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000f0\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ+\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000f0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b \u0010!J7\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\"\u0010#J3\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001d0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%R\u0019\u0010'\u001a\u00020&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010,\u001a\u00020+8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001c\u00101\u001a\u0002008\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0019\u00106\u001a\u0002058\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0019\u0010;\u001a\u00020:8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0019\u0010@\u001a\u00020?8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0019\u0010E\u001a\u00020D8\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001c\u0010J\u001a\u00020I8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M¨\u0006P"}, d2 = {"Lcom/coinbase/wallet/ethereum/repositories/EthereumBasedBalanceRepository;", "Lcom/coinbase/wallet/accountwallets/interfaces/AccountBasedBalanceManaging;", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "", "address", "", "index", "Lh/c/b0;", "", "Lcom/coinbase/wallet/blockchains/models/Address;", "refreshERC20s", "(Lcom/coinbase/wallet/blockchains/models/Network;Ljava/lang/String;I)Lh/c/b0;", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "onChainBalance", "Lcom/coinbase/wallet/core/util/Optional;", "refreshERC20Address", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;ILjava/lang/String;)Lh/c/b0;", "erc20Address", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "addressType", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "getERC20Wallet", "(Lcom/coinbase/wallet/blockchains/models/Address;Lcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/blockchains/models/AddressType;I)Lh/c/b0;", "Ljava/math/BigInteger;", "getMinimumBalance", "(Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/RefreshContext;", "context", "Lkotlin/x;", "refreshBalances", "(Lcom/coinbase/wallet/blockchains/models/RefreshContext;)Lh/c/b0;", "getBalance", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "getERC20Balance", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;Ljava/lang/String;)Lh/c/b0;", "takeOwnership", "(Ljava/lang/String;ILjava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "getStore", "()Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "getAddressDao", "()Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;", "configuration", "Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;", "getConfiguration", "()Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;", "Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "ethereumSignedTxDao", "Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "getEthereumSignedTxDao", "()Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "Lcom/coinbase/wallet/ethereum/apis/ERC20TokenAPI;", "erc20TokenAPI", "Lcom/coinbase/wallet/ethereum/apis/ERC20TokenAPI;", "getErc20TokenAPI", "()Lcom/coinbase/wallet/ethereum/apis/ERC20TokenAPI;", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "getCipherCore", "()Lcom/coinbase/ciphercore/CipherCoreInterface;", "Lcom/coinbase/wallet/ethereum/daos/ERC20Dao;", "erc20Dao", "Lcom/coinbase/wallet/ethereum/daos/ERC20Dao;", "getErc20Dao", "()Lcom/coinbase/wallet/ethereum/daos/ERC20Dao;", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "walletDao", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "getWalletDao", "()Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "<init>", "(Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/ethereum/daos/ERC20Dao;Lcom/coinbase/wallet/ethereum/apis/ERC20TokenAPI;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EthereumBasedBalanceRepository implements AccountBasedBalanceManaging {
    private final AddressDao addressDao;
    private final CipherCoreInterface cipherCore;
    private final WalletConfiguration configuration;
    private final ERC20Dao erc20Dao;
    private final ERC20TokenAPI erc20TokenAPI;
    private final EthereumSignedTxDao ethereumSignedTxDao;
    private final StoreInterface store;
    private final WalletDao walletDao;

    public EthereumBasedBalanceRepository(WalletConfiguration configuration, AddressDao addressDao, WalletDao walletDao, StoreInterface store, EthereumSignedTxDao ethereumSignedTxDao, CipherCoreInterface cipherCore, ERC20Dao erc20Dao, ERC20TokenAPI erc20TokenAPI) {
        kotlin.jvm.internal.m.g(configuration, "configuration");
        kotlin.jvm.internal.m.g(addressDao, "addressDao");
        kotlin.jvm.internal.m.g(walletDao, "walletDao");
        kotlin.jvm.internal.m.g(store, "store");
        kotlin.jvm.internal.m.g(ethereumSignedTxDao, "ethereumSignedTxDao");
        kotlin.jvm.internal.m.g(cipherCore, "cipherCore");
        kotlin.jvm.internal.m.g(erc20Dao, "erc20Dao");
        kotlin.jvm.internal.m.g(erc20TokenAPI, "erc20TokenAPI");
        this.configuration = configuration;
        this.addressDao = addressDao;
        this.walletDao = walletDao;
        this.store = store;
        this.ethereumSignedTxDao = ethereumSignedTxDao;
        this.cipherCore = cipherCore;
        this.erc20Dao = erc20Dao;
        this.erc20TokenAPI = erc20TokenAPI;
    }

    public static /* synthetic */ Optional A(Throwable th) {
        return m1167getBalance$lambda14$lambda13$lambda11(th);
    }

    public static /* synthetic */ List B(List list) {
        return m1194refreshERC20s$lambda33(list);
    }

    public static /* synthetic */ h.c.h0 C(EthereumBasedBalanceRepository ethereumBasedBalanceRepository, Optional optional) {
        return m1199takeOwnership$lambda31(ethereumBasedBalanceRepository, optional);
    }

    public static /* synthetic */ Optional D(Address address, AddressType addressType, Network network, int i2, Optional optional) {
        return m1176getERC20Wallet$lambda50(address, addressType, network, i2, optional);
    }

    public static /* synthetic */ h.c.h0 E(EthereumBasedBalanceRepository ethereumBasedBalanceRepository, Address address) {
        return m1191refreshERC20Address$lambda47(ethereumBasedBalanceRepository, address);
    }

    public static /* synthetic */ kotlin.x F(int i2, EthereumBasedBalanceRepository ethereumBasedBalanceRepository, BigInteger bigInteger) {
        return m1178refreshBalances$lambda1(i2, ethereumBasedBalanceRepository, bigInteger);
    }

    public static /* synthetic */ h.c.h0 G(EthereumBasedBalanceRepository ethereumBasedBalanceRepository, EthereumChain ethereumChain, GetERC20TokenResponseDTO getERC20TokenResponseDTO) {
        return m1188refreshERC20Address$lambda45(ethereumBasedBalanceRepository, ethereumChain, getERC20TokenResponseDTO);
    }

    public static /* synthetic */ h.c.h0 H(EthereumBasedBalanceRepository ethereumBasedBalanceRepository, Network network, Optional optional) {
        return m1198takeOwnership$lambda30(ethereumBasedBalanceRepository, network, optional);
    }

    public static /* synthetic */ BigInteger I(kotlin.o oVar) {
        return m1175getERC20Balance$lambda29(oVar);
    }

    public static /* synthetic */ Optional a(Address address) {
        return m1192refreshERC20Address$lambda48(address);
    }

    public static /* synthetic */ h.c.h0 b(EthereumBasedBalanceRepository ethereumBasedBalanceRepository, BigInteger bigInteger, List list) {
        return m1171getERC20Balance$lambda25(ethereumBasedBalanceRepository, bigInteger, list);
    }

    public static /* synthetic */ Optional c(ERC20Info eRC20Info) {
        return m1184refreshERC20Address$lambda40(eRC20Info);
    }

    public static /* synthetic */ Optional d(Throwable th) {
        return m1173getERC20Balance$lambda25$lambda24$lambda22(th);
    }

    public static /* synthetic */ Optional e(Throwable th) {
        return m1193refreshERC20Address$lambda49(th);
    }

    public static /* synthetic */ SignedEtherTxReceipt f(EthereumSignedTx ethereumSignedTx, Optional optional) {
        return m1168getBalance$lambda14$lambda13$lambda12(ethereumSignedTx, optional);
    }

    public static /* synthetic */ h.c.h0 g(EthereumBasedBalanceRepository ethereumBasedBalanceRepository, Network network, Optional optional) {
        return m1179refreshBalances$lambda2(ethereumBasedBalanceRepository, network, optional);
    }

    /* renamed from: getBalance$lambda-14 */
    public static final h.c.h0 m1165getBalance$lambda14(EthereumBasedBalanceRepository this$0, BigInteger bigInteger, List signedTxs) {
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(signedTxs, "signedTxs");
        ArrayList arrayList = new ArrayList();
        Iterator it = signedTxs.iterator();
        while (it.hasNext()) {
            final EthereumSignedTx ethereumSignedTx = (EthereumSignedTx) it.next();
            byte[] asHexEncodedData = String_CoreKt.asHexEncodedData(ethereumSignedTx.getTxHash());
            h.c.b0 b0Var = null;
            if (asHexEncodedData != null) {
                h.c.b0<R> map = this$0.getCipherCore().getEthereumTransactionReceipt(asHexEncodedData, ethereumSignedTx.getChainId(), bigInteger).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.p
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return EthereumBasedBalanceRepository.o((com.coinbase.ciphercore.Optional) obj);
                    }
                });
                kotlin.jvm.internal.m.f(map, "cipherCore\n                            .getEthereumTransactionReceipt(txHashData, signedTx.chainId, blockHeight)\n                            .map { it.value.toOptional() }");
                b0Var = Single_AnalyticsKt.logError$default(map, null, null, 3, null).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.b0
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return EthereumBasedBalanceRepository.A((Throwable) obj);
                    }
                }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.g
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return EthereumBasedBalanceRepository.f(EthereumSignedTx.this, (Optional) obj);
                    }
                });
            }
            if (b0Var != null) {
                arrayList.add(b0Var);
            }
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            h.c.b0 just = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(just, "just(emptyList())");
            return just;
        }
        h.c.b0 zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.EthereumBasedBalanceRepository$getBalance$lambda-14$$inlined$zipOrEmpty$1
            @Override // h.c.m0.n
            public final List<T> apply(Object[] it2) {
                List<T> g3;
                kotlin.jvm.internal.m.g(it2, "it");
                if (it2.length == 0) {
                    g3 = kotlin.a0.r.g();
                    return g3;
                }
                ArrayList arrayList2 = new ArrayList();
                int length = it2.length;
                for (int i2 = 0; i2 < length; i2++) {
                    Object obj = it2[i2];
                    if (obj != null ? obj instanceof SignedEtherTxReceipt : true) {
                        arrayList2.add(obj);
                    }
                }
                return arrayList2;
            }
        });
        kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        return zip;
    }

    /* renamed from: getBalance$lambda-14$lambda-13$lambda-10 */
    public static final Optional m1166getBalance$lambda14$lambda13$lambda10(com.coinbase.ciphercore.Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        return OptionalKt.toOptional(it.getValue());
    }

    /* renamed from: getBalance$lambda-14$lambda-13$lambda-11 */
    public static final Optional m1167getBalance$lambda14$lambda13$lambda11(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new Optional(null);
    }

    /* renamed from: getBalance$lambda-14$lambda-13$lambda-12 */
    public static final SignedEtherTxReceipt m1168getBalance$lambda14$lambda13$lambda12(EthereumSignedTx signedTx, Optional it) {
        kotlin.jvm.internal.m.g(signedTx, "$signedTx");
        kotlin.jvm.internal.m.g(it, "it");
        return new SignedEtherTxReceipt((EthereumTransactionReceipt) it.getValue(), signedTx);
    }

    /* renamed from: getBalance$lambda-18 */
    public static final BigInteger m1169getBalance$lambda18(kotlin.o dstr$amount$pendingTxs) {
        kotlin.jvm.internal.m.g(dstr$amount$pendingTxs, "$dstr$amount$pendingTxs");
        BigInteger amount = (BigInteger) dstr$amount$pendingTxs.a();
        List pendingTxs = (List) dstr$amount$pendingTxs.b();
        kotlin.jvm.internal.m.f(pendingTxs, "pendingTxs");
        ArrayList<SignedEtherTxReceipt> arrayList = new ArrayList();
        for (Object obj : pendingTxs) {
            EthereumTransactionReceipt receipt = ((SignedEtherTxReceipt) obj).getReceipt();
            boolean z = false;
            if (receipt != null && receipt.isSuccessful()) {
                z = true;
            }
            if (!z) {
                arrayList.add(obj);
            }
        }
        ArrayList<BigInteger> arrayList2 = new ArrayList();
        for (SignedEtherTxReceipt signedEtherTxReceipt : arrayList) {
            BigInteger weiValue = signedEtherTxReceipt.getTx().getWeiValue();
            if (weiValue != null) {
                arrayList2.add(weiValue);
            }
        }
        BigInteger txBalance = BigInteger.ZERO;
        for (BigInteger bigInteger : arrayList2) {
            txBalance = txBalance.add(bigInteger);
        }
        kotlin.jvm.internal.m.f(amount, "amount");
        kotlin.jvm.internal.m.f(txBalance, "txBalance");
        BigInteger subtract = amount.subtract(txBalance);
        kotlin.jvm.internal.m.f(subtract, "this.subtract(other)");
        return subtract;
    }

    /* renamed from: getBalance$lambda-19 */
    public static final Optional m1170getBalance$lambda19(BigInteger it) {
        kotlin.jvm.internal.m.g(it, "it");
        return OptionalKt.toOptional(it);
    }

    public static /* synthetic */ h.c.b0 getERC20Balance$default(EthereumBasedBalanceRepository ethereumBasedBalanceRepository, String str, String str2, Network network, String str3, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        return ethereumBasedBalanceRepository.getERC20Balance(str, str2, network, str3);
    }

    /* renamed from: getERC20Balance$lambda-25 */
    public static final h.c.h0 m1171getERC20Balance$lambda25(EthereumBasedBalanceRepository this$0, BigInteger bigInteger, List signedTxs) {
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(signedTxs, "signedTxs");
        ArrayList arrayList = new ArrayList();
        Iterator it = signedTxs.iterator();
        while (it.hasNext()) {
            final EthereumSignedTx ethereumSignedTx = (EthereumSignedTx) it.next();
            byte[] asHexEncodedData = String_CoreKt.asHexEncodedData(ethereumSignedTx.getTxHash());
            h.c.b0 b0Var = null;
            if (asHexEncodedData != null) {
                h.c.b0<R> map = this$0.getCipherCore().getEthereumTransactionReceipt(asHexEncodedData, ethereumSignedTx.getChainId(), bigInteger).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.w
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return EthereumBasedBalanceRepository.v((com.coinbase.ciphercore.Optional) obj);
                    }
                });
                kotlin.jvm.internal.m.f(map, "cipherCore\n                            .getEthereumTransactionReceipt(txHashData, signedTx.chainId, blockHeight)\n                            .map { it.value.toOptional() }");
                b0Var = Single_AnalyticsKt.logError$default(map, null, null, 3, null).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.e
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return EthereumBasedBalanceRepository.d((Throwable) obj);
                    }
                }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.r
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return EthereumBasedBalanceRepository.q(EthereumSignedTx.this, (Optional) obj);
                    }
                });
            }
            if (b0Var != null) {
                arrayList.add(b0Var);
            }
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            h.c.b0 just = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(just, "just(emptyList())");
            return just;
        }
        h.c.b0 zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.EthereumBasedBalanceRepository$getERC20Balance$lambda-25$$inlined$zipOrEmpty$1
            @Override // h.c.m0.n
            public final List<T> apply(Object[] it2) {
                List<T> g3;
                kotlin.jvm.internal.m.g(it2, "it");
                if (it2.length == 0) {
                    g3 = kotlin.a0.r.g();
                    return g3;
                }
                ArrayList arrayList2 = new ArrayList();
                int length = it2.length;
                for (int i2 = 0; i2 < length; i2++) {
                    Object obj = it2[i2];
                    if (obj != null ? obj instanceof SignedERC20TxReceipt : true) {
                        arrayList2.add(obj);
                    }
                }
                return arrayList2;
            }
        });
        kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        return zip;
    }

    /* renamed from: getERC20Balance$lambda-25$lambda-24$lambda-21 */
    public static final Optional m1172getERC20Balance$lambda25$lambda24$lambda21(com.coinbase.ciphercore.Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        return OptionalKt.toOptional(it.getValue());
    }

    /* renamed from: getERC20Balance$lambda-25$lambda-24$lambda-22 */
    public static final Optional m1173getERC20Balance$lambda25$lambda24$lambda22(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new Optional(null);
    }

    /* renamed from: getERC20Balance$lambda-25$lambda-24$lambda-23 */
    public static final SignedERC20TxReceipt m1174getERC20Balance$lambda25$lambda24$lambda23(EthereumSignedTx signedTx, Optional it) {
        kotlin.jvm.internal.m.g(signedTx, "$signedTx");
        kotlin.jvm.internal.m.g(it, "it");
        return new SignedERC20TxReceipt((EthereumTransactionReceipt) it.getValue(), signedTx);
    }

    /* renamed from: getERC20Balance$lambda-29 */
    public static final BigInteger m1175getERC20Balance$lambda29(kotlin.o dstr$amount$statuses) {
        kotlin.jvm.internal.m.g(dstr$amount$statuses, "$dstr$amount$statuses");
        BigInteger amount = (BigInteger) dstr$amount$statuses.a();
        List statuses = (List) dstr$amount$statuses.b();
        kotlin.jvm.internal.m.f(statuses, "statuses");
        ArrayList<SignedERC20TxReceipt> arrayList = new ArrayList();
        for (Object obj : statuses) {
            EthereumTransactionReceipt receipt = ((SignedERC20TxReceipt) obj).getReceipt();
            boolean z = false;
            if (receipt != null && receipt.isSuccessful()) {
                z = true;
            }
            if (!z) {
                arrayList.add(obj);
            }
        }
        ArrayList<BigInteger> arrayList2 = new ArrayList();
        for (SignedERC20TxReceipt signedERC20TxReceipt : arrayList) {
            BigInteger erc20Value = signedERC20TxReceipt.getTx().getErc20Value();
            if (erc20Value != null) {
                arrayList2.add(erc20Value);
            }
        }
        BigInteger txBalance = BigInteger.ZERO;
        for (BigInteger bigInteger : arrayList2) {
            kotlin.jvm.internal.m.f(txBalance, "prev");
            txBalance = txBalance.add(bigInteger);
            kotlin.jvm.internal.m.f(txBalance, "this.add(other)");
        }
        kotlin.jvm.internal.m.f(amount, "amount");
        kotlin.jvm.internal.m.f(txBalance, "txBalance");
        BigInteger subtract = amount.subtract(txBalance);
        kotlin.jvm.internal.m.f(subtract, "this.subtract(other)");
        return subtract;
    }

    private final h.c.b0<Optional<Wallet>> getERC20Wallet(final Address address, final Network network, final AddressType addressType, final int i2) {
        String contractAddress = address.getContractAddress();
        if (contractAddress != null) {
            EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(network);
            if (asEthereumChain == null) {
                h.c.b0<Optional<Wallet>> error = h.c.b0.error(new NetworkException.InvalidNetwork(network));
                kotlin.jvm.internal.m.f(error, "error(NetworkException.InvalidNetwork(network))");
                return error;
            }
            h.c.b0 onErrorReturn = this.erc20Dao.getERC20(contractAddress, asEthereumChain.getChainId()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.e0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumBasedBalanceRepository.D(Address.this, addressType, network, i2, (Optional) obj);
                }
            }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.x
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumBasedBalanceRepository.w((Throwable) obj);
                }
            });
            kotlin.jvm.internal.m.f(onErrorReturn, "erc20Dao\n            .getERC20(contractAddress, ethereumChain.chainId)\n            .map {\n                val erc20Info = it.value ?: throw EthereumException.InvalidERC20\n                val wallet = Wallet(\n                    primaryAddress = erc20Address.address,\n                    addresses = listOf(WalletAddress(addressType, erc20Address.address, erc20Address.index)),\n                    displayName = erc20Info.name,\n                    currencyCode = erc20Info.currencyCode,\n                    imageURL = erc20Info.imageURL,\n                    balance = erc20Address.balance,\n                    decimals = erc20Info.decimals,\n                    blockchain = erc20Info.blockchain,\n                    minimumBalance = null,\n                    network = network,\n                    contractAddress = erc20Info.contractAddress,\n                    selectedIndex = index\n                )\n\n                wallet.toOptional()\n            }\n            .onErrorReturn { null.toOptional() }");
            return Single_AnalyticsKt.logError$default(onErrorReturn, "Unable to fetch erc20 wallet " + address + TokenParser.SP + network + TokenParser.SP + addressType + TokenParser.SP + i2, null, 2, null);
        }
        throw EthereumException.InvalidERC20.INSTANCE;
    }

    /* renamed from: getERC20Wallet$lambda-50 */
    public static final Optional m1176getERC20Wallet$lambda50(Address erc20Address, AddressType addressType, Network network, int i2, Optional it) {
        List b2;
        kotlin.jvm.internal.m.g(erc20Address, "$erc20Address");
        kotlin.jvm.internal.m.g(addressType, "$addressType");
        kotlin.jvm.internal.m.g(network, "$network");
        kotlin.jvm.internal.m.g(it, "it");
        ERC20 erc20 = (ERC20) it.getValue();
        if (erc20 != null) {
            String address = erc20Address.getAddress();
            b2 = kotlin.a0.q.b(new WalletAddress(addressType, erc20Address.getAddress(), erc20Address.getIndex()));
            return OptionalKt.toOptional(new Wallet(address, b2, erc20.getName(), erc20.getCurrencyCode(), erc20.getImageURL(), erc20Address.getBalance(), erc20.getDecimals(), erc20.getBlockchain(), null, network, erc20.getContractAddress(), Integer.valueOf(i2)));
        }
        throw EthereumException.InvalidERC20.INSTANCE;
    }

    /* renamed from: getERC20Wallet$lambda-51 */
    public static final Optional m1177getERC20Wallet$lambda51(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return OptionalKt.toOptional(null);
    }

    public static /* synthetic */ h.c.h0 h(EthereumBasedBalanceRepository ethereumBasedBalanceRepository, Network network, List list) {
        return m1180refreshBalances$lambda7(ethereumBasedBalanceRepository, network, list);
    }

    public static /* synthetic */ Optional i(Throwable th) {
        return m1185refreshERC20Address$lambda41(th);
    }

    public static /* synthetic */ Optional j(BigInteger bigInteger) {
        return m1170getBalance$lambda19(bigInteger);
    }

    public static /* synthetic */ h.c.h0 k(EthereumBasedBalanceRepository ethereumBasedBalanceRepository, String str, Network network, int i2, List list) {
        return m1196refreshERC20s$lambda37(ethereumBasedBalanceRepository, str, network, i2, list);
    }

    public static /* synthetic */ h.c.h0 l(EthereumBasedBalanceRepository ethereumBasedBalanceRepository, BigInteger bigInteger, List list) {
        return m1165getBalance$lambda14(ethereumBasedBalanceRepository, bigInteger, list);
    }

    public static /* synthetic */ h.c.h0 m(EthereumBasedBalanceRepository ethereumBasedBalanceRepository, RefreshContext refreshContext, h.c.b0 b0Var, kotlin.x xVar) {
        return m1183refreshBalances$lambda9(ethereumBasedBalanceRepository, refreshContext, b0Var, xVar);
    }

    public static /* synthetic */ List n(List list) {
        return m1197refreshERC20s$lambda39(list);
    }

    public static /* synthetic */ Optional o(com.coinbase.ciphercore.Optional optional) {
        return m1166getBalance$lambda14$lambda13$lambda10(optional);
    }

    public static /* synthetic */ h.c.h0 p(EthereumBasedBalanceRepository ethereumBasedBalanceRepository, String str, EthereumChain ethereumChain, kotlin.t tVar) {
        return m1186refreshERC20Address$lambda43(ethereumBasedBalanceRepository, str, ethereumChain, tVar);
    }

    public static /* synthetic */ SignedERC20TxReceipt q(EthereumSignedTx ethereumSignedTx, Optional optional) {
        return m1174getERC20Balance$lambda25$lambda24$lambda23(ethereumSignedTx, optional);
    }

    public static /* synthetic */ kotlin.o r(GetERC20TokenResponseDTO getERC20TokenResponseDTO, ERC20 erc20, Optional optional) {
        return m1189refreshERC20Address$lambda45$lambda44(getERC20TokenResponseDTO, erc20, optional);
    }

    /* renamed from: refreshBalances$lambda-1 */
    public static final kotlin.x m1178refreshBalances$lambda1(int i2, EthereumBasedBalanceRepository this$0, BigInteger blockHeight) {
        ReentrantLock blockHeightLock;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(blockHeight, "blockHeight");
        blockHeightLock = EthereumBasedBalanceRepositoryKt.getBlockHeightLock();
        blockHeightLock.lock();
        try {
            StoreKeys storeKeys = StoreKeys.INSTANCE;
            BigInteger bigInteger = (BigInteger) this$0.getStore().get(StoreKeys_EthereumKt.ethereumBlockHeight(storeKeys, i2));
            if (bigInteger == null || blockHeight.compareTo(bigInteger) > 0) {
                this$0.getStore().set(StoreKeys_EthereumKt.ethereumBlockHeight(storeKeys, i2), blockHeight);
            }
            return kotlin.x.a;
        } finally {
            blockHeightLock.unlock();
        }
    }

    /* renamed from: refreshBalances$lambda-2 */
    public static final h.c.h0 m1179refreshBalances$lambda2(EthereumBasedBalanceRepository this$0, Network network, Optional it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(network, "$network");
        kotlin.jvm.internal.m.g(it, "it");
        Address address = (Address) it.toNullable();
        if (address != null) {
            return this$0.refreshERC20s(network, address.getAddress(), address.getIndex());
        }
        throw EthereumException.UnableToFindWallet.INSTANCE;
    }

    /* renamed from: refreshBalances$lambda-7 */
    public static final h.c.h0 m1180refreshBalances$lambda7(EthereumBasedBalanceRepository this$0, Network network, List addresses) {
        int r;
        h.c.b0 zip;
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(network, "$network");
        kotlin.jvm.internal.m.g(addresses, "addresses");
        ArrayList<Address> arrayList = new ArrayList();
        for (Object obj : addresses) {
            if (((Address) obj).getContractAddress() != null) {
                arrayList.add(obj);
            }
        }
        r = kotlin.a0.s.r(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(r);
        for (Address address : arrayList) {
            arrayList2.add(this$0.getERC20Wallet(address, network, this$0.getConfiguration().getDefaultReceiveType(), address.getIndex()));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList2.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(arrayList2, new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.EthereumBasedBalanceRepository$refreshBalances$lambda-7$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it, "it");
                    if (it.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj2 : it) {
                        if (obj2 instanceof Optional) {
                            arrayList3.add(obj2);
                        }
                    }
                    return arrayList3;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        return zip.map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.y
            @Override // h.c.m0.n
            public final Object apply(Object obj2) {
                return EthereumBasedBalanceRepository.x((List) obj2);
            }
        });
    }

    /* renamed from: refreshBalances$lambda-7$lambda-6 */
    public static final List m1181refreshBalances$lambda7$lambda6(List wallets) {
        kotlin.jvm.internal.m.g(wallets, "wallets");
        ArrayList arrayList = new ArrayList();
        Iterator it = wallets.iterator();
        while (it.hasNext()) {
            Wallet wallet = (Wallet) ((Optional) it.next()).getValue();
            if (wallet != null) {
                arrayList.add(wallet);
            }
        }
        return arrayList;
    }

    /* renamed from: refreshBalances$lambda-8 */
    public static final h.c.h0 m1182refreshBalances$lambda8(EthereumBasedBalanceRepository this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.getWalletDao().saveAll(it);
    }

    /* renamed from: refreshBalances$lambda-9 */
    public static final h.c.h0 m1183refreshBalances$lambda9(EthereumBasedBalanceRepository this$0, RefreshContext context, h.c.b0 refreshERC20s, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(context, "$context");
        kotlin.jvm.internal.m.g(refreshERC20s, "$refreshERC20s");
        kotlin.jvm.internal.m.g(it, "it");
        return h.c.t0.e.a.a(AccountBasedBalanceManaging.DefaultImpls.refreshBalances(this$0, context), refreshERC20s);
    }

    private final h.c.b0<Optional<Address>> refreshERC20Address(final String str, final String str2, final Network network, final int i2, String str3) {
        final EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(network);
        if (asEthereumChain == null) {
            h.c.b0<Optional<Address>> error = h.c.b0.error(new NetworkException.InvalidNetwork(network));
            kotlin.jvm.internal.m.f(error, "error(NetworkException.InvalidNetwork(network))");
            return error;
        }
        h.c.b0<BigInteger> eRC20Balance = getERC20Balance(str, str2, network, str3);
        h.c.b0<Optional<String>> tokenIcon = this.erc20TokenAPI.getTokenIcon(str2, asEthereumChain.getChainId());
        h.c.b0 onErrorReturn = this.cipherCore.getERC20Info(str2, asEthereumChain.getChainId()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedBalanceRepository.c((ERC20Info) obj);
            }
        }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedBalanceRepository.i((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorReturn, "cipherCore.getERC20Info(contractAddress, ethereumChain.chainId)\n            .map { it.toOptional() }\n            .onErrorReturn { Optional(null) }");
        h.c.b0 map = h.c.t0.e.a.b(onErrorReturn, eRC20Balance, tokenIcon).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.q
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedBalanceRepository.p(EthereumBasedBalanceRepository.this, str2, asEthereumChain, (kotlin.t) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.h0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedBalanceRepository.G(EthereumBasedBalanceRepository.this, asEthereumChain, (GetERC20TokenResponseDTO) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.a0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedBalanceRepository.z(i2, this, network, str, (kotlin.o) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.f0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedBalanceRepository.E(EthereumBasedBalanceRepository.this, (Address) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedBalanceRepository.a((Address) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "Singles.zip(erc20Single, balanceSingle, getTokenIcon)\n            .flatMap { (erc20, balance, image) ->\n                val erc20Info = erc20.value\n                return@flatMap if (erc20Info == null) {\n                    erc20TokenAPI.getERC20Info(contractAddress, ethereumChain.chainId)\n                        .map { info ->\n                            GetERC20TokenResponseDTO(\n                                name = info.name,\n                                decimals = info.decimals,\n                                symbol = info.symbol,\n                                contractAddress = info.address,\n                                balance = balance,\n                                image = image.toNullable()\n                            )\n                        }\n                } else {\n                    val dto = GetERC20TokenResponseDTO(\n                        name = erc20Info.name,\n                        decimals = erc20Info.decimals,\n                        symbol = erc20Info.symbol,\n                        contractAddress = erc20Info.address,\n                        balance = balance,\n                        image = image.toNullable()\n                    )\n\n                    Single.just(dto)\n                }\n            }\n            .flatMap { dto ->\n                val erc20 = dto.asERC20(configuration.blockchain, ethereumChain)\n                erc20Dao.save(erc20).map { dto to erc20 }\n            }\n            .map { (dto, erc20) ->\n                val currencyCode = erc20.currencyCode.rawValue.toUpperCase(Locale.US)\n                if (erc20FilteredCurrencyCode.contains(currencyCode)) {\n                    throw EthereumException.InvalidERC20\n                }\n\n                val derivationPath = CipherCore.ethereumAddressDerivationPath(index)\n\n                dto.asAddress(\n                    index = index,\n                    blockchain = configuration.blockchain,\n                    network = network,\n                    address = address,\n                    addressType = configuration.defaultReceiveType,\n                    derivationPath = derivationPath\n                ) ?: throw EthereumException.InvalidERC20\n            }\n            .flatMap { addressDao.save(it) }\n            .map { it.toOptional() }");
        h.c.b0<Optional<Address>> onErrorReturn2 = Single_AnalyticsKt.logError$default(map, null, null, 3, null).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedBalanceRepository.e((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorReturn2, "Singles.zip(erc20Single, balanceSingle, getTokenIcon)\n            .flatMap { (erc20, balance, image) ->\n                val erc20Info = erc20.value\n                return@flatMap if (erc20Info == null) {\n                    erc20TokenAPI.getERC20Info(contractAddress, ethereumChain.chainId)\n                        .map { info ->\n                            GetERC20TokenResponseDTO(\n                                name = info.name,\n                                decimals = info.decimals,\n                                symbol = info.symbol,\n                                contractAddress = info.address,\n                                balance = balance,\n                                image = image.toNullable()\n                            )\n                        }\n                } else {\n                    val dto = GetERC20TokenResponseDTO(\n                        name = erc20Info.name,\n                        decimals = erc20Info.decimals,\n                        symbol = erc20Info.symbol,\n                        contractAddress = erc20Info.address,\n                        balance = balance,\n                        image = image.toNullable()\n                    )\n\n                    Single.just(dto)\n                }\n            }\n            .flatMap { dto ->\n                val erc20 = dto.asERC20(configuration.blockchain, ethereumChain)\n                erc20Dao.save(erc20).map { dto to erc20 }\n            }\n            .map { (dto, erc20) ->\n                val currencyCode = erc20.currencyCode.rawValue.toUpperCase(Locale.US)\n                if (erc20FilteredCurrencyCode.contains(currencyCode)) {\n                    throw EthereumException.InvalidERC20\n                }\n\n                val derivationPath = CipherCore.ethereumAddressDerivationPath(index)\n\n                dto.asAddress(\n                    index = index,\n                    blockchain = configuration.blockchain,\n                    network = network,\n                    address = address,\n                    addressType = configuration.defaultReceiveType,\n                    derivationPath = derivationPath\n                ) ?: throw EthereumException.InvalidERC20\n            }\n            .flatMap { addressDao.save(it) }\n            .map { it.toOptional() }\n            .logError()\n            .onErrorReturn { null.toOptional() }");
        return onErrorReturn2;
    }

    static /* synthetic */ h.c.b0 refreshERC20Address$default(EthereumBasedBalanceRepository ethereumBasedBalanceRepository, String str, String str2, Network network, int i2, String str3, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            str3 = null;
        }
        return ethereumBasedBalanceRepository.refreshERC20Address(str, str2, network, i2, str3);
    }

    /* renamed from: refreshERC20Address$lambda-40 */
    public static final Optional m1184refreshERC20Address$lambda40(ERC20Info it) {
        kotlin.jvm.internal.m.g(it, "it");
        return OptionalKt.toOptional(it);
    }

    /* renamed from: refreshERC20Address$lambda-41 */
    public static final Optional m1185refreshERC20Address$lambda41(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new Optional(null);
    }

    /* renamed from: refreshERC20Address$lambda-43 */
    public static final h.c.h0 m1186refreshERC20Address$lambda43(EthereumBasedBalanceRepository this$0, String contractAddress, EthereumChain ethereumChain, kotlin.t dstr$erc20$balance$image) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(contractAddress, "$contractAddress");
        kotlin.jvm.internal.m.g(ethereumChain, "$ethereumChain");
        kotlin.jvm.internal.m.g(dstr$erc20$balance$image, "$dstr$erc20$balance$image");
        final BigInteger bigInteger = (BigInteger) dstr$erc20$balance$image.b();
        final Optional optional = (Optional) dstr$erc20$balance$image.c();
        ERC20Info eRC20Info = (ERC20Info) ((Optional) dstr$erc20$balance$image.a()).getValue();
        if (eRC20Info == null) {
            return this$0.getErc20TokenAPI().getERC20Info(contractAddress, ethereumChain.getChainId()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.u
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumBasedBalanceRepository.t(Optional.this, bigInteger, (GetERC20InfoDTO) obj);
                }
            });
        }
        return h.c.b0.just(new GetERC20TokenResponseDTO(eRC20Info.getName(), eRC20Info.getDecimals(), eRC20Info.getAddress(), eRC20Info.getSymbol(), bigInteger, (String) optional.toNullable()));
    }

    /* renamed from: refreshERC20Address$lambda-43$lambda-42 */
    public static final GetERC20TokenResponseDTO m1187refreshERC20Address$lambda43$lambda42(Optional optional, BigInteger bigInteger, GetERC20InfoDTO info) {
        kotlin.jvm.internal.m.g(info, "info");
        return new GetERC20TokenResponseDTO(info.getName(), info.getDecimals(), info.getAddress(), info.getSymbol(), bigInteger, (String) optional.toNullable());
    }

    /* renamed from: refreshERC20Address$lambda-45 */
    public static final h.c.h0 m1188refreshERC20Address$lambda45(EthereumBasedBalanceRepository this$0, EthereumChain ethereumChain, final GetERC20TokenResponseDTO dto) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(ethereumChain, "$ethereumChain");
        kotlin.jvm.internal.m.g(dto, "dto");
        final ERC20 asERC20 = dto.asERC20(this$0.getConfiguration().getBlockchain(), ethereumChain);
        return this$0.getErc20Dao().save(asERC20).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.s
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedBalanceRepository.r(GetERC20TokenResponseDTO.this, asERC20, (Optional) obj);
            }
        });
    }

    /* renamed from: refreshERC20Address$lambda-45$lambda-44 */
    public static final kotlin.o m1189refreshERC20Address$lambda45$lambda44(GetERC20TokenResponseDTO dto, ERC20 erc20, Optional it) {
        kotlin.jvm.internal.m.g(dto, "$dto");
        kotlin.jvm.internal.m.g(erc20, "$erc20");
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.u.a(dto, erc20);
    }

    /* renamed from: refreshERC20Address$lambda-46 */
    public static final Address m1190refreshERC20Address$lambda46(int i2, EthereumBasedBalanceRepository this$0, Network network, String address, kotlin.o dstr$dto$erc20) {
        Set set;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(network, "$network");
        kotlin.jvm.internal.m.g(address, "$address");
        kotlin.jvm.internal.m.g(dstr$dto$erc20, "$dstr$dto$erc20");
        GetERC20TokenResponseDTO getERC20TokenResponseDTO = (GetERC20TokenResponseDTO) dstr$dto$erc20.a();
        String rawValue = ((ERC20) dstr$dto$erc20.b()).getCurrencyCode().getRawValue();
        Locale US = Locale.US;
        kotlin.jvm.internal.m.f(US, "US");
        Objects.requireNonNull(rawValue, "null cannot be cast to non-null type java.lang.String");
        String upperCase = rawValue.toUpperCase(US);
        kotlin.jvm.internal.m.f(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        set = EthereumBasedBalanceRepositoryKt.erc20FilteredCurrencyCode;
        if (!set.contains(upperCase)) {
            Address asAddress = getERC20TokenResponseDTO.asAddress(i2, this$0.getConfiguration().getBlockchain(), network, address, this$0.getConfiguration().getDefaultReceiveType(), CipherCore_EthereumKt.ethereumAddressDerivationPath(CipherCore.Companion, i2));
            if (asAddress != null) {
                return asAddress;
            }
            throw EthereumException.InvalidERC20.INSTANCE;
        }
        throw EthereumException.InvalidERC20.INSTANCE;
    }

    /* renamed from: refreshERC20Address$lambda-47 */
    public static final h.c.h0 m1191refreshERC20Address$lambda47(EthereumBasedBalanceRepository this$0, Address it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.getAddressDao().save(it);
    }

    /* renamed from: refreshERC20Address$lambda-48 */
    public static final Optional m1192refreshERC20Address$lambda48(Address it) {
        kotlin.jvm.internal.m.g(it, "it");
        return OptionalKt.toOptional(it);
    }

    /* renamed from: refreshERC20Address$lambda-49 */
    public static final Optional m1193refreshERC20Address$lambda49(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return OptionalKt.toOptional(null);
    }

    private final h.c.b0<List<Address>> refreshERC20s(final Network network, final String str, final int i2) {
        h.c.b0 flatMap;
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(network);
        if (asEthereumChain == null) {
            h.c.b0<List<Address>> error = h.c.b0.error(new NetworkException.InvalidNetwork(network));
            kotlin.jvm.internal.m.f(error, "error(NetworkException.InvalidNetwork(network))");
            return error;
        }
        if (asEthereumChain == EthereumChain.ETHEREUM_MAINNET) {
            flatMap = this.erc20TokenAPI.getERC20Balances(str, asEthereumChain.getChainId()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.c0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumBasedBalanceRepository.B((List) obj);
                }
            }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.z
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumBasedBalanceRepository.y(EthereumBasedBalanceRepository.this, str, network, i2, (List) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap, "{\n            erc20TokenAPI.getERC20Balances(address = address, chainId = ethereumChain.chainId)\n                .map { erc20Balances ->\n                    erc20Balances.mapNotNull { erc20Balance ->\n                        if (erc20Balance.errorMessage != null) {\n                            Analytics.log(\n                                AnalyticsEvent.generalError(\n                                    description = erc20Balance.errorMessage,\n                                    properties = mapOf(EventProperty.ContractAddress to erc20Balance.contractAddress)\n                                )\n                            )\n                            null\n                        } else {\n                            erc20Balance\n                        }\n                    }\n                }\n                .flatMap { erc20Balances ->\n                    erc20Balances.map {\n                        refreshERC20Address(\n                            address = address,\n                            contractAddress = it.contractAddress,\n                            network = network,\n                            index = index,\n                            onChainBalance = it.tokenBalance\n                        )\n                    }.zipOrEmpty()\n                }\n        }");
        } else {
            flatMap = this.erc20TokenAPI.getERC20TokensOwnedByAddress(str, asEthereumChain.getChainId()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.l
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumBasedBalanceRepository.k(EthereumBasedBalanceRepository.this, str, network, i2, (List) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap, "{\n            // While batch API supports only ETH mainnet for now, this remains as fallback option for other chains, testnets\n            erc20TokenAPI.getERC20TokensOwnedByAddress(address = address, chainId = ethereumChain.chainId)\n                .flatMap { addresses ->\n                    addresses.map { refreshERC20Address(address, it, network, index) }.zipOrEmpty()\n                }\n        }");
        }
        h.c.b0 map = flatMap.map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.o
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedBalanceRepository.n((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "addressesSingle.map { erc20Addresses -> erc20Addresses.mapNotNull { it.value } }");
        return Single_AnalyticsKt.logError$default(map, null, null, 3, null);
    }

    /* renamed from: refreshERC20s$lambda-33 */
    public static final List m1194refreshERC20s$lambda33(List erc20Balances) {
        Map e2;
        kotlin.jvm.internal.m.g(erc20Balances, "erc20Balances");
        ArrayList arrayList = new ArrayList();
        Iterator it = erc20Balances.iterator();
        while (it.hasNext()) {
            GetERC20BalancesDTO getERC20BalancesDTO = (GetERC20BalancesDTO) it.next();
            if (getERC20BalancesDTO.getErrorMessage() != null) {
                Analytics analytics = Analytics.INSTANCE;
                AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
                String errorMessage = getERC20BalancesDTO.getErrorMessage();
                e2 = l0.e(kotlin.u.a(EventProperty.Companion.getContractAddress(), getERC20BalancesDTO.getContractAddress()));
                analytics.log(AnalyticsEvent_AnalyticsKt.generalError(companion, errorMessage, e2));
                getERC20BalancesDTO = null;
            }
            if (getERC20BalancesDTO != null) {
                arrayList.add(getERC20BalancesDTO);
            }
        }
        return arrayList;
    }

    /* renamed from: refreshERC20s$lambda-35 */
    public static final h.c.h0 m1195refreshERC20s$lambda35(EthereumBasedBalanceRepository this$0, String address, Network network, int i2, List erc20Balances) {
        int r;
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(address, "$address");
        kotlin.jvm.internal.m.g(network, "$network");
        kotlin.jvm.internal.m.g(erc20Balances, "erc20Balances");
        r = kotlin.a0.s.r(erc20Balances, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = erc20Balances.iterator();
        while (it.hasNext()) {
            GetERC20BalancesDTO getERC20BalancesDTO = (GetERC20BalancesDTO) it.next();
            arrayList.add(this$0.refreshERC20Address(address, getERC20BalancesDTO.getContractAddress(), network, i2, getERC20BalancesDTO.getTokenBalance()));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            h.c.b0 just = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(just, "just(emptyList())");
            return just;
        }
        h.c.b0 zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.EthereumBasedBalanceRepository$refreshERC20s$lambda-35$$inlined$zipOrEmpty$1
            @Override // h.c.m0.n
            public final List<T> apply(Object[] it2) {
                List<T> g3;
                kotlin.jvm.internal.m.g(it2, "it");
                if (it2.length == 0) {
                    g3 = kotlin.a0.r.g();
                    return g3;
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : it2) {
                    if (obj instanceof Optional) {
                        arrayList2.add(obj);
                    }
                }
                return arrayList2;
            }
        });
        kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        return zip;
    }

    /* renamed from: refreshERC20s$lambda-37 */
    public static final h.c.h0 m1196refreshERC20s$lambda37(EthereumBasedBalanceRepository this$0, String address, Network network, int i2, List addresses) {
        int r;
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(address, "$address");
        kotlin.jvm.internal.m.g(network, "$network");
        kotlin.jvm.internal.m.g(addresses, "addresses");
        r = kotlin.a0.s.r(addresses, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = addresses.iterator();
        while (it.hasNext()) {
            arrayList.add(refreshERC20Address$default(this$0, address, (String) it.next(), network, i2, null, 16, null));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            h.c.b0 just = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(just, "just(emptyList())");
            return just;
        }
        h.c.b0 zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.EthereumBasedBalanceRepository$refreshERC20s$lambda-37$$inlined$zipOrEmpty$1
            @Override // h.c.m0.n
            public final List<T> apply(Object[] it2) {
                List<T> g3;
                kotlin.jvm.internal.m.g(it2, "it");
                if (it2.length == 0) {
                    g3 = kotlin.a0.r.g();
                    return g3;
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : it2) {
                    if (obj instanceof Optional) {
                        arrayList2.add(obj);
                    }
                }
                return arrayList2;
            }
        });
        kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        return zip;
    }

    /* renamed from: refreshERC20s$lambda-39 */
    public static final List m1197refreshERC20s$lambda39(List erc20Addresses) {
        kotlin.jvm.internal.m.g(erc20Addresses, "erc20Addresses");
        ArrayList arrayList = new ArrayList();
        Iterator it = erc20Addresses.iterator();
        while (it.hasNext()) {
            Address address = (Address) ((Optional) it.next()).getValue();
            if (address != null) {
                arrayList.add(address);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ h.c.h0 s(EthereumBasedBalanceRepository ethereumBasedBalanceRepository, List list) {
        return m1182refreshBalances$lambda8(ethereumBasedBalanceRepository, list);
    }

    public static /* synthetic */ GetERC20TokenResponseDTO t(Optional optional, BigInteger bigInteger, GetERC20InfoDTO getERC20InfoDTO) {
        return m1187refreshERC20Address$lambda43$lambda42(optional, bigInteger, getERC20InfoDTO);
    }

    /* renamed from: takeOwnership$lambda-30 */
    public static final h.c.h0 m1198takeOwnership$lambda30(EthereumBasedBalanceRepository this$0, Network network, Optional addressOptional) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(network, "$network");
        kotlin.jvm.internal.m.g(addressOptional, "addressOptional");
        Address address = (Address) addressOptional.toNullable();
        return address == null ? h.c.b0.just(OptionalKt.toOptional(null)) : this$0.getERC20Wallet(address, network, this$0.getConfiguration().getDefaultReceiveType(), address.getIndex());
    }

    /* renamed from: takeOwnership$lambda-31 */
    public static final h.c.h0 m1199takeOwnership$lambda31(EthereumBasedBalanceRepository this$0, Optional walletOptional) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(walletOptional, "walletOptional");
        Wallet wallet = (Wallet) walletOptional.toNullable();
        return wallet == null ? h.c.b0.just(kotlin.x.a) : Single_CoreKt.asUnit(this$0.getWalletDao().save(wallet));
    }

    public static /* synthetic */ BigInteger u(kotlin.o oVar) {
        return m1169getBalance$lambda18(oVar);
    }

    public static /* synthetic */ Optional v(com.coinbase.ciphercore.Optional optional) {
        return m1172getERC20Balance$lambda25$lambda24$lambda21(optional);
    }

    public static /* synthetic */ Optional w(Throwable th) {
        return m1177getERC20Wallet$lambda51(th);
    }

    public static /* synthetic */ List x(List list) {
        return m1181refreshBalances$lambda7$lambda6(list);
    }

    public static /* synthetic */ h.c.h0 y(EthereumBasedBalanceRepository ethereumBasedBalanceRepository, String str, Network network, int i2, List list) {
        return m1195refreshERC20s$lambda35(ethereumBasedBalanceRepository, str, network, i2, list);
    }

    public static /* synthetic */ Address z(int i2, EthereumBasedBalanceRepository ethereumBasedBalanceRepository, Network network, String str, kotlin.o oVar) {
        return m1190refreshERC20Address$lambda46(i2, ethereumBasedBalanceRepository, network, str, oVar);
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    public AddressDao getAddressDao() {
        return this.addressDao;
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    public h.c.b0<Optional<BigInteger>> getBalance(String address, Network network) {
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(network, "network");
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(network);
        if (asEthereumChain == null) {
            h.c.b0<Optional<BigInteger>> error = h.c.b0.error(new NetworkException.InvalidNetwork(network));
            kotlin.jvm.internal.m.f(error, "error(NetworkException.InvalidNetwork(network))");
            return error;
        }
        final BigInteger bigInteger = (BigInteger) this.store.get(StoreKeys_EthereumKt.ethereumBlockHeight(StoreKeys.INSTANCE, asEthereumChain.getChainId()));
        h.c.b0<BigInteger> weiBalance = this.cipherCore.getWeiBalance(address, asEthereumChain.getChainId(), bigInteger);
        h.c.h0 flatMap = this.ethereumSignedTxDao.getUnminedEtherTxs(address, asEthereumChain).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedBalanceRepository.l(EthereumBasedBalanceRepository.this, bigInteger, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "ethereumSignedTxDao.getUnminedEtherTxs(address, ethereumChain)\n            .flatMap { signedTxs ->\n                signedTxs\n                    .mapNotNull { signedTx ->\n                        val txHashData = signedTx.txHash.asHexEncodedData() ?: return@mapNotNull null\n\n                        cipherCore\n                            .getEthereumTransactionReceipt(txHashData, signedTx.chainId, blockHeight)\n                            .map { it.value.toOptional() }\n                            .logError()\n                            .onErrorReturn { Optional(null) }\n                            .map { SignedEtherTxReceipt(it.value, signedTx) }\n                    }\n                    .zipOrEmpty()\n            }");
        h.c.b0 map = h.c.t0.e.a.a(weiBalance, flatMap).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.v
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedBalanceRepository.u((kotlin.o) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedBalanceRepository.j((BigInteger) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "Singles.zip(getWeiBalance, getPendingTxs)\n            .map { (amount, pendingTxs) ->\n                val txBalance = pendingTxs\n                    .filter { it.receipt?.isSuccessful != true }\n                    .mapNotNull { it.tx.weiValue }\n                    .fold(BigInteger.ZERO) { prev, next -> prev.add(next) }\n\n                amount.minus(txBalance)\n            }\n            .map { it.toOptional() }");
        return Single_AnalyticsKt.logError$default(map, null, null, 3, null);
    }

    public final CipherCoreInterface getCipherCore() {
        return this.cipherCore;
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    public WalletConfiguration getConfiguration() {
        return this.configuration;
    }

    public final h.c.b0<BigInteger> getERC20Balance(String address, String contractAddress, Network network, String str) {
        h.c.b0<BigInteger> eRC20Balance;
        BigInteger fromHex;
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(contractAddress, "contractAddress");
        kotlin.jvm.internal.m.g(network, "network");
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(network);
        if (asEthereumChain == null) {
            h.c.b0<BigInteger> error = h.c.b0.error(new NetworkException.InvalidNetwork(network));
            kotlin.jvm.internal.m.f(error, "error(NetworkException.InvalidNetwork(network))");
            return error;
        }
        final BigInteger bigInteger = (BigInteger) this.store.get(StoreKeys_EthereumKt.ethereumBlockHeight(StoreKeys.INSTANCE, asEthereumChain.getChainId()));
        BigInteger bigInteger2 = null;
        if (str != null && (fromHex = BigIntegers_CoreKt.fromHex(BigIntegers.INSTANCE, str)) != null) {
            bigInteger2 = fromHex;
        }
        if (bigInteger2 != null) {
            eRC20Balance = h.c.b0.just(bigInteger2);
            kotlin.jvm.internal.m.f(eRC20Balance, "{\n            Single.just(bigIntOnChainBalance)\n        }");
        } else {
            eRC20Balance = this.cipherCore.getERC20Balance(address, contractAddress, asEthereumChain.getChainId(), bigInteger);
        }
        h.c.h0 flatMap = this.ethereumSignedTxDao.getUnminedERC20Txs(address, contractAddress, asEthereumChain).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedBalanceRepository.b(EthereumBasedBalanceRepository.this, bigInteger, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "ethereumSignedTxDao\n            .getUnminedERC20Txs(address, contractAddress, ethereumChain)\n            .flatMap { signedTxs ->\n                signedTxs\n                    .mapNotNull { signedTx ->\n                        val txHashData = signedTx.txHash.asHexEncodedData() ?: return@mapNotNull null\n\n                        cipherCore\n                            .getEthereumTransactionReceipt(txHashData, signedTx.chainId, blockHeight)\n                            .map { it.value.toOptional() }\n                            .logError()\n                            .onErrorReturn { Optional(null) }\n                            .map { SignedERC20TxReceipt(it.value, signedTx) }\n                    }\n                    .zipOrEmpty()\n            }");
        h.c.b0<BigInteger> map = h.c.t0.e.a.a(eRC20Balance, flatMap).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.j0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedBalanceRepository.I((kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "Singles.zip(getERC20Balance, getERC20PendingTxs)\n            .map { (amount, statuses) ->\n                val txBalance = statuses\n                    .filter { it.receipt?.isSuccessful != true }\n                    .mapNotNull { it.tx.erc20Value }\n                    .fold(BigInteger.ZERO) { prev, next -> prev + next }\n\n                amount.minus(txBalance)\n            }");
        return map;
    }

    public final ERC20Dao getErc20Dao() {
        return this.erc20Dao;
    }

    public final ERC20TokenAPI getErc20TokenAPI() {
        return this.erc20TokenAPI;
    }

    public final EthereumSignedTxDao getEthereumSignedTxDao() {
        return this.ethereumSignedTxDao;
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    public h.c.b0<Optional<BigInteger>> getMinimumBalance(Network network) {
        kotlin.jvm.internal.m.g(network, "network");
        h.c.b0<Optional<BigInteger>> just = h.c.b0.just(new Optional(null));
        kotlin.jvm.internal.m.f(just, "just(Optional(null))");
        return just;
    }

    public final StoreInterface getStore() {
        return this.store;
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    public WalletDao getWalletDao() {
        return this.walletDao;
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging, com.coinbase.wallet.blockchains.interfaces.BalanceManaging
    public h.c.b0<kotlin.x> refreshBalances(final RefreshContext context) {
        final h.c.b0<kotlin.x> just;
        kotlin.jvm.internal.m.g(context, "context");
        final Network network = context.getNetwork();
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(network);
        Integer valueOf = asEthereumChain == null ? null : Integer.valueOf(asEthereumChain.getChainId());
        if (valueOf == null) {
            h.c.b0<kotlin.x> error = h.c.b0.error(new NetworkException.InvalidNetwork(network));
            kotlin.jvm.internal.m.f(error, "error(NetworkException.InvalidNetwork(network))");
            return error;
        }
        final int intValue = valueOf.intValue();
        WalletConfiguration configuration = getConfiguration();
        EthereumBasedConfiguration ethereumBasedConfiguration = configuration instanceof EthereumBasedConfiguration ? (EthereumBasedConfiguration) configuration : null;
        if (ethereumBasedConfiguration == null) {
            h.c.b0<kotlin.x> error2 = h.c.b0.error(EthereumException.InvalidConfiguration.INSTANCE);
            kotlin.jvm.internal.m.f(error2, "error(EthereumException.InvalidConfiguration)");
            return error2;
        }
        h.c.b0<R> map = this.cipherCore.getEthereumBlockHeight(intValue).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.g0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedBalanceRepository.F(intValue, this, (BigInteger) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "cipherCore.getEthereumBlockHeight(chainId)\n            .map { blockHeight ->\n                blockHeightLock.withLock {\n                    val blockHeightKey = StoreKeys.ethereumBlockHeight(chainId)\n                    val storedBlockHeight = store.get(blockHeightKey)\n                    if (storedBlockHeight == null || blockHeight > storedBlockHeight) {\n                        store.set(StoreKeys.ethereumBlockHeight(chainId), blockHeight)\n                    }\n                }\n            }");
        h.c.b0<kotlin.x> asUnit = Single_CoreKt.asUnit(map);
        if (ethereumBasedConfiguration.isERC20Supported()) {
            AddressDao addressDao = getAddressDao();
            Blockchain blockchain = getConfiguration().getBlockchain();
            CurrencyCode currencyCodeForNetwork = getConfiguration().currencyCodeForNetwork(context.getNetwork());
            Network network2 = context.getNetwork();
            AddressType defaultReceiveType = getConfiguration().getDefaultReceiveType();
            Integer index = context.getIndex();
            h.c.b0 flatMap = addressDao.getAddressForIndex(blockchain, currencyCodeForNetwork, network2, defaultReceiveType, false, index == null ? 0 : index.intValue()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.h
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumBasedBalanceRepository.g(EthereumBasedBalanceRepository.this, network, (Optional) obj);
                }
            }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.i
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumBasedBalanceRepository.h(EthereumBasedBalanceRepository.this, network, (List) obj);
                }
            }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.t
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumBasedBalanceRepository.s(EthereumBasedBalanceRepository.this, (List) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap, "addressDao\n                .getAddressForIndex(\n                    blockchain = configuration.blockchain,\n                    currencyCode = configuration.currencyCodeForNetwork(context.network),\n                    network = context.network,\n                    addressType = configuration.defaultReceiveType,\n                    isChangeAddress = false,\n                    index = context.index ?: 0\n                )\n                .flatMap {\n                    val activeAddress = it.toNullable() ?: throw EthereumException.UnableToFindWallet\n                    refreshERC20s(network, activeAddress.address, activeAddress.index)\n                }\n                .flatMap { addresses ->\n                    addresses\n                        .filter { it.contractAddress != null }\n                        .map { getERC20Wallet(it, network, configuration.defaultReceiveType, it.index) }\n                        .zipOrEmpty()\n                        .map { wallets -> wallets.mapNotNull { it.value } }\n                }\n                .flatMap { walletDao.saveAll(wallets = it) }");
            just = Single_CoreKt.asUnit(flatMap);
        } else {
            just = h.c.b0.just(kotlin.x.a);
            kotlin.jvm.internal.m.f(just, "{\n            Single.just(Unit)\n        }");
        }
        h.c.b0<R> flatMap2 = asUnit.flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedBalanceRepository.m(EthereumBasedBalanceRepository.this, context, just, (kotlin.x) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap2, "refreshBlockHeight\n            .flatMap { Singles.zip(super.refreshBalances(context), refreshERC20s) }");
        return Single_CoreKt.asUnit(Single_AnalyticsKt.logError$default(flatMap2, kotlin.jvm.internal.m.o("Unable to refresh ", getConfiguration().getBlockchain()), null, 2, null));
    }

    public final h.c.b0<kotlin.x> takeOwnership(String address, int i2, String contractAddress, final Network network) {
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(contractAddress, "contractAddress");
        kotlin.jvm.internal.m.g(network, "network");
        h.c.b0<kotlin.x> flatMap = refreshERC20Address$default(this, address, contractAddress, network, i2, null, 16, null).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.i0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedBalanceRepository.H(EthereumBasedBalanceRepository.this, network, (Optional) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.d0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedBalanceRepository.C(EthereumBasedBalanceRepository.this, (Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "refreshERC20Address(address, contractAddress, network, index)\n            .flatMap { addressOptional ->\n                val erc20Address = addressOptional.toNullable() ?: return@flatMap Single.just(null.toOptional())\n\n                getERC20Wallet(erc20Address, network, configuration.defaultReceiveType, erc20Address.index)\n            }\n            .flatMap { walletOptional ->\n                val wallet = walletOptional.toNullable() ?: return@flatMap Single.just(Unit)\n\n                walletDao.save(wallet).asUnit()\n            }");
        return flatMap;
    }
}