package com.coinbase.wallet.accountwallets.interfaces;

import com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.exceptions.WalletException;
import com.coinbase.wallet.blockchains.interfaces.BalanceManaging;
import com.coinbase.wallet.blockchains.models.Address;
import com.coinbase.wallet.blockchains.models.AddressType;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.RefreshContext;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.blockchains.models.WalletConfiguration;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import h.c.b0;
import h.c.h0;
import h.c.m0.n;
import java.math.BigInteger;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.q;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.x;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: AccountBasedBalanceManaging.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/accountwallets/interfaces/AccountBasedBalanceManaging;", "Lcom/coinbase/wallet/blockchains/interfaces/BalanceManaging;", "", "address", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lh/c/b0;", "Lcom/coinbase/wallet/core/util/Optional;", "Ljava/math/BigInteger;", "getBalance", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "getMinimumBalance", "(Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/RefreshContext;", "context", "Lkotlin/x;", "refreshBalances", "(Lcom/coinbase/wallet/blockchains/models/RefreshContext;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "getAddressDao", "()Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;", "getConfiguration", "()Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;", "configuration", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "getWalletDao", "()Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "walletDao", "accountwallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface AccountBasedBalanceManaging extends BalanceManaging {

    /* compiled from: AccountBasedBalanceManaging.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ h0 a(AccountBasedBalanceManaging accountBasedBalanceManaging, RefreshContext refreshContext, o oVar) {
            return m615refreshBalances$lambda3(accountBasedBalanceManaging, refreshContext, oVar);
        }

        public static /* synthetic */ h0 b(AccountBasedBalanceManaging accountBasedBalanceManaging, Address address, BigInteger bigInteger) {
            return m614refreshBalances$lambda2$lambda1(accountBasedBalanceManaging, address, bigInteger);
        }

        public static /* synthetic */ h0 c(AccountBasedBalanceManaging accountBasedBalanceManaging, RefreshContext refreshContext, Optional optional) {
            return m612refreshBalances$lambda2(accountBasedBalanceManaging, refreshContext, optional);
        }

        public static /* synthetic */ BigInteger d(Address address, Optional optional) {
            return m613refreshBalances$lambda2$lambda0(address, optional);
        }

        public static b0<x> refreshBalances(final AccountBasedBalanceManaging accountBasedBalanceManaging, final RefreshContext context) {
            m.g(accountBasedBalanceManaging, "this");
            m.g(context, "context");
            AddressDao addressDao = accountBasedBalanceManaging.getAddressDao();
            Blockchain blockchain = accountBasedBalanceManaging.getConfiguration().getBlockchain();
            CurrencyCode currencyCodeForNetwork = accountBasedBalanceManaging.getConfiguration().currencyCodeForNetwork(context.getNetwork());
            Network network = context.getNetwork();
            AddressType defaultReceiveType = accountBasedBalanceManaging.getConfiguration().getDefaultReceiveType();
            Integer index = context.getIndex();
            b0 flatMap = addressDao.getAddressForIndex(blockchain, currencyCodeForNetwork, network, defaultReceiveType, false, index == null ? 0 : index.intValue()).flatMap(new n() { // from class: com.coinbase.wallet.accountwallets.interfaces.c
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return AccountBasedBalanceManaging.DefaultImpls.c(AccountBasedBalanceManaging.this, context, (Optional) obj);
                }
            }).flatMap(new n() { // from class: com.coinbase.wallet.accountwallets.interfaces.a
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return AccountBasedBalanceManaging.DefaultImpls.a(AccountBasedBalanceManaging.this, context, (o) obj);
                }
            });
            m.f(flatMap, "addressDao\n        .getAddressForIndex(\n            blockchain = configuration.blockchain,\n            currencyCode = configuration.currencyCodeForNetwork(context.network),\n            network = context.network,\n            addressType = configuration.defaultReceiveType,\n            isChangeAddress = false,\n            index = context.index ?: 0\n        )\n        .flatMap { optionalAddress ->\n            val address = optionalAddress.value ?: throw WalletException.UnableFetchBalance(configuration.blockchain)\n            val getMinimumBalance = getMinimumBalance(context.network)\n            val getAddress = getBalance(address = address.address, network = address.network)\n                .map { it.toNullable() ?: address.balance }\n                .flatMap { balance -> addressDao.save(address.copy(balance = balance)) }\n\n            Singles.zip(getAddress, getMinimumBalance)\n        }\n        .flatMap { (address, minimumBalance) ->\n            val wallet = Wallet(\n                primaryAddress = address.address,\n                addresses = listOf(WalletAddress(configuration.defaultReceiveType, address.address, address.index)),\n                displayName = configuration.displayName(context.network),\n                currencyCode = configuration.currencyCodeForNetwork(context.network),\n                imageURL = configuration.imageURLForNetwork(context.network),\n                balance = address.balance,\n                decimals = configuration.decimals,\n                blockchain = configuration.blockchain,\n                minimumBalance = minimumBalance.toNullable(),\n                network = context.network,\n                selectedIndex = address.index\n            )\n\n            walletDao.save(wallet)\n        }");
            return Single_AnalyticsKt.logError$default(Single_CoreKt.asUnit(flatMap), null, null, 3, null);
        }

        /* renamed from: refreshBalances$lambda-2 */
        public static h0 m612refreshBalances$lambda2(final AccountBasedBalanceManaging this$0, RefreshContext context, Optional optionalAddress) {
            m.g(this$0, "this$0");
            m.g(context, "$context");
            m.g(optionalAddress, "optionalAddress");
            final Address address = (Address) optionalAddress.getValue();
            if (address != null) {
                b0<Optional<BigInteger>> minimumBalance = this$0.getMinimumBalance(context.getNetwork());
                b0 flatMap = this$0.getBalance(address.getAddress(), address.getNetwork()).map(new n() { // from class: com.coinbase.wallet.accountwallets.interfaces.d
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return AccountBasedBalanceManaging.DefaultImpls.d(Address.this, (Optional) obj);
                    }
                }).flatMap(new n() { // from class: com.coinbase.wallet.accountwallets.interfaces.b
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return AccountBasedBalanceManaging.DefaultImpls.b(AccountBasedBalanceManaging.this, address, (BigInteger) obj);
                    }
                });
                m.f(flatMap, "getBalance(address = address.address, network = address.network)\n                .map { it.toNullable() ?: address.balance }\n                .flatMap { balance -> addressDao.save(address.copy(balance = balance)) }");
                return h.c.t0.e.a.a(flatMap, minimumBalance);
            }
            throw new WalletException.UnableFetchBalance(this$0.getConfiguration().getBlockchain());
        }

        /* renamed from: refreshBalances$lambda-2$lambda-0 */
        public static BigInteger m613refreshBalances$lambda2$lambda0(Address address, Optional it) {
            m.g(address, "$address");
            m.g(it, "it");
            BigInteger bigInteger = (BigInteger) it.toNullable();
            return bigInteger == null ? address.getBalance() : bigInteger;
        }

        /* renamed from: refreshBalances$lambda-2$lambda-1 */
        public static h0 m614refreshBalances$lambda2$lambda1(AccountBasedBalanceManaging this$0, Address address, BigInteger balance) {
            Address copy;
            m.g(this$0, "this$0");
            m.g(address, "$address");
            m.g(balance, "balance");
            AddressDao addressDao = this$0.getAddressDao();
            copy = address.copy((r26 & 1) != 0 ? address.getId() : null, (r26 & 2) != 0 ? address.index : 0, (r26 & 4) != 0 ? address.address : null, (r26 & 8) != 0 ? address.balance : balance, (r26 & 16) != 0 ? address.currencyCode : null, (r26 & 32) != 0 ? address.isChangeAddress : false, (r26 & 64) != 0 ? address.network : null, (r26 & 128) != 0 ? address.type : null, (r26 & 256) != 0 ? address.derivationPath : null, (r26 & 512) != 0 ? address.isUsed : false, (r26 & 1024) != 0 ? address.blockchain : null, (r26 & PKIFailureInfo.wrongIntegrity) != 0 ? address.contractAddress : null);
            return addressDao.save(copy);
        }

        /* renamed from: refreshBalances$lambda-3 */
        public static h0 m615refreshBalances$lambda3(AccountBasedBalanceManaging this$0, RefreshContext context, o dstr$address$minimumBalance) {
            List b2;
            m.g(this$0, "this$0");
            m.g(context, "$context");
            m.g(dstr$address$minimumBalance, "$dstr$address$minimumBalance");
            Address address = (Address) dstr$address$minimumBalance.a();
            String address2 = address.getAddress();
            b2 = q.b(new WalletAddress(this$0.getConfiguration().getDefaultReceiveType(), address.getAddress(), address.getIndex()));
            return this$0.getWalletDao().save(new Wallet(address2, b2, this$0.getConfiguration().displayName(context.getNetwork()), this$0.getConfiguration().currencyCodeForNetwork(context.getNetwork()), this$0.getConfiguration().imageURLForNetwork(context.getNetwork()), address.getBalance(), this$0.getConfiguration().getDecimals(), this$0.getConfiguration().getBlockchain(), (BigInteger) ((Optional) dstr$address$minimumBalance.b()).toNullable(), context.getNetwork(), null, Integer.valueOf(address.getIndex()), 1024, null));
        }
    }

    AddressDao getAddressDao();

    b0<Optional<BigInteger>> getBalance(String str, Network network);

    WalletConfiguration getConfiguration();

    b0<Optional<BigInteger>> getMinimumBalance(Network network);

    WalletDao getWalletDao();

    @Override // com.coinbase.wallet.blockchains.interfaces.BalanceManaging
    b0<x> refreshBalances(RefreshContext refreshContext);
}