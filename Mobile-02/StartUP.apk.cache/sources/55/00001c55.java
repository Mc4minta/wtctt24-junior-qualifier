package com.coinbase.wallet.ethereum.interfaces;

import com.coinbase.ciphercore.CipherCore;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.KeyPair;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.accountwallets.interfaces.AccountBasedWalletManaging;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.models.Address;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.RefreshContext;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.blockchains.models.WalletConfiguration;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.ethereum.extensions.CipherCore_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.EthereumChain_EthereumKt;
import com.coinbase.wallet.ethereum.repositories.EthereumBasedBalanceRepository;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: EthereumBasedWalletManaging.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0000\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J5\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00052\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u00052\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000b¢\u0006\u0004\b\"\u0010#R\u001c\u0010%\u001a\u00020$8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00065"}, d2 = {"Lcom/coinbase/wallet/ethereum/interfaces/EthereumBasedWalletManaging;", "Lcom/coinbase/wallet/accountwallets/interfaces/AccountBasedWalletManaging;", "Lcom/coinbase/wallet/ethereum/interfaces/ERC20Owning;", "Lcom/coinbase/wallet/blockchains/models/RefreshContext;", "context", "Lh/c/b0;", "Lkotlin/x;", "refresh", "(Lcom/coinbase/wallet/blockchains/models/RefreshContext;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "", "numberOfAddress", "(Lcom/coinbase/wallet/blockchains/models/Network;)I", "index", "", "derivationPath", "(ILcom/coinbase/wallet/blockchains/models/Network;)Ljava/lang/String;", "", "seed", "deriveAddress", "([BLjava/lang/String;)Lh/c/b0;", "address", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "takeOwnership", "(Ljava/lang/String;ILjava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "", "Lcom/coinbase/wallet/blockchains/models/Address;", "getAddresses", "(Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "walletAddress", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "getWallet", "(Ljava/lang/String;I)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;", "configuration", "Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;", "getConfiguration", "()Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "Lcom/coinbase/wallet/ethereum/repositories/EthereumBasedBalanceRepository;", "ethereumBasedBalanceManaging", "Lcom/coinbase/wallet/ethereum/repositories/EthereumBasedBalanceRepository;", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "walletDao", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "<init>", "(Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/ethereum/repositories/EthereumBasedBalanceRepository;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/ciphercore/CipherCoreInterface;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class EthereumBasedWalletManaging extends AccountBasedWalletManaging implements ERC20Owning {
    private final AddressDao addressDao;
    private final WalletConfiguration configuration;
    private final EthereumBasedBalanceRepository ethereumBasedBalanceManaging;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EthereumBasedWalletManaging(WalletConfiguration configuration, AddressDao addressDao, EthereumBasedBalanceRepository ethereumBasedBalanceManaging, WalletDao walletDao, CipherCoreInterface cipherCore) {
        super(addressDao, walletDao, configuration, cipherCore);
        kotlin.jvm.internal.m.g(configuration, "configuration");
        kotlin.jvm.internal.m.g(addressDao, "addressDao");
        kotlin.jvm.internal.m.g(ethereumBasedBalanceManaging, "ethereumBasedBalanceManaging");
        kotlin.jvm.internal.m.g(walletDao, "walletDao");
        kotlin.jvm.internal.m.g(cipherCore, "cipherCore");
        this.configuration = configuration;
        this.addressDao = addressDao;
        this.ethereumBasedBalanceManaging = ethereumBasedBalanceManaging;
    }

    /* renamed from: deriveAddress$lambda-0 */
    public static final h.c.h0 m1127deriveAddress$lambda0(EthereumBasedWalletManaging this$0, KeyPair it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.getCipherCore().ethereumAddressFromPublicKey(it.getPublicKey());
    }

    /* renamed from: getAddresses$lambda-2 */
    public static final List m1128getAddresses$lambda2(List addresses) {
        List B0;
        kotlin.jvm.internal.m.g(addresses, "addresses");
        B0 = kotlin.a0.z.B0(addresses, new Comparator<T>() { // from class: com.coinbase.wallet.ethereum.interfaces.EthereumBasedWalletManaging$getAddresses$lambda-2$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int c2;
                c2 = kotlin.b0.b.c(Integer.valueOf(((Address) t).getIndex()), Integer.valueOf(((Address) t2).getIndex()));
                return c2;
            }
        });
        return B0;
    }

    /* renamed from: getWallet$lambda-3 */
    public static final Optional m1129getWallet$lambda3(EthereumBasedWalletManaging this$0, Network network, Optional optionalAddress) {
        List b2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(network, "$network");
        kotlin.jvm.internal.m.g(optionalAddress, "optionalAddress");
        Address address = (Address) optionalAddress.toNullable();
        if (address == null) {
            return new Optional(null);
        }
        String address2 = address.getAddress();
        b2 = kotlin.a0.q.b(new WalletAddress(this$0.getConfiguration().getDefaultReceiveType(), address.getAddress(), address.getIndex()));
        return OptionalKt.toOptional(new Wallet(address2, b2, this$0.getConfiguration().displayName(network), this$0.getConfiguration().currencyCodeForNetwork(network), this$0.getConfiguration().imageURLForNetwork(network), address.getBalance(), this$0.getConfiguration().getDecimals(), this$0.getConfiguration().getBlockchain(), null, network, null, Integer.valueOf(address.getIndex()), 1024, null));
    }

    public static /* synthetic */ Optional h(EthereumBasedWalletManaging ethereumBasedWalletManaging, Network network, Optional optional) {
        return m1129getWallet$lambda3(ethereumBasedWalletManaging, network, optional);
    }

    public static /* synthetic */ List i(List list) {
        return m1128getAddresses$lambda2(list);
    }

    public static /* synthetic */ h.c.h0 j(EthereumBasedWalletManaging ethereumBasedWalletManaging, KeyPair keyPair) {
        return m1127deriveAddress$lambda0(ethereumBasedWalletManaging, keyPair);
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedWalletManaging
    public String derivationPath(int i2, Network network) {
        kotlin.jvm.internal.m.g(network, "network");
        return CipherCore_EthereumKt.ethereumAddressDerivationPath(CipherCore.Companion, i2);
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedWalletManaging
    public h.c.b0<String> deriveAddress(byte[] seed, String derivationPath) {
        kotlin.jvm.internal.m.g(seed, "seed");
        kotlin.jvm.internal.m.g(derivationPath, "derivationPath");
        h.c.b0 flatMap = getCipherCore().deriveKeyPair(seed, derivationPath).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.e0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedWalletManaging.j(EthereumBasedWalletManaging.this, (KeyPair) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "cipherCore.deriveKeyPair(seed, derivationPath)\n        .flatMap { cipherCore.ethereumAddressFromPublicKey(it.publicKey) }");
        return flatMap;
    }

    public final h.c.b0<List<Address>> getAddresses(Network network) {
        kotlin.jvm.internal.m.g(network, "network");
        h.c.b0 map = this.addressDao.getOrderedAddresses(getConfiguration().getBlockchain(), getConfiguration().currencyCodeForNetwork(network), network).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.d0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedWalletManaging.i((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "addressDao\n        .getOrderedAddresses(\n            blockchain = configuration.blockchain,\n            currencyCode = configuration.currencyCodeForNetwork(network),\n            network = network\n        )\n        .map { addresses -> addresses.sortedBy { it.index } }");
        return map;
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedWalletManaging, com.coinbase.wallet.blockchains.interfaces.WalletManaging
    public WalletConfiguration getConfiguration() {
        return this.configuration;
    }

    public final h.c.b0<Optional<Wallet>> getWallet(String walletAddress, int i2) {
        kotlin.jvm.internal.m.g(walletAddress, "walletAddress");
        EthereumChain fromChainId = EthereumChain.Companion.fromChainId(i2);
        final Network asNetwork = fromChainId == null ? null : EthereumChain_EthereumKt.getAsNetwork(fromChainId);
        if (asNetwork == null) {
            h.c.b0<Optional<Wallet>> error = h.c.b0.error(new IllegalStateException(kotlin.jvm.internal.m.o("Illegal chain id passed in ", Integer.valueOf(i2))));
            kotlin.jvm.internal.m.f(error, "error(IllegalStateException(\"Illegal chain id passed in $chainId\"))");
            return error;
        }
        h.c.b0 map = this.addressDao.getAddress(getConfiguration().getBlockchain(), getConfiguration().currencyCodeForNetwork(asNetwork), asNetwork, walletAddress).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.c0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedWalletManaging.h(EthereumBasedWalletManaging.this, asNetwork, (Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "addressDao.getAddress(\n            configuration.blockchain,\n            configuration.currencyCodeForNetwork(network),\n            network,\n            walletAddress\n        )\n            .map { optionalAddress ->\n                val address = optionalAddress.toNullable() ?: return@map Optional(null)\n                val wallet = Wallet(\n                    primaryAddress = address.address,\n                    addresses = listOf(WalletAddress(configuration.defaultReceiveType, address.address, address.index)),\n                    displayName = configuration.displayName(network),\n                    currencyCode = configuration.currencyCodeForNetwork(network),\n                    imageURL = configuration.imageURLForNetwork(network),\n                    balance = address.balance,\n                    decimals = configuration.decimals,\n                    blockchain = configuration.blockchain,\n                    minimumBalance = null,\n                    network = network,\n                    selectedIndex = address.index\n                )\n\n                wallet.toOptional()\n            }");
        return map;
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedWalletManaging
    public int numberOfAddress(Network network) {
        kotlin.jvm.internal.m.g(network, "network");
        return 10;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.WalletManaging
    public h.c.b0<kotlin.x> refresh(RefreshContext context) {
        kotlin.jvm.internal.m.g(context, "context");
        return this.ethereumBasedBalanceManaging.refreshBalances(context);
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.ERC20Owning
    public h.c.b0<kotlin.x> takeOwnership(String address, int i2, String contractAddress, Network network) {
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(contractAddress, "contractAddress");
        kotlin.jvm.internal.m.g(network, "network");
        return this.ethereumBasedBalanceManaging.takeOwnership(address, i2, contractAddress, network);
    }
}