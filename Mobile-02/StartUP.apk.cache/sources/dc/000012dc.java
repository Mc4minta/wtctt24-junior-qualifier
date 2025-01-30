package com.coinbase.wallet.bip44wallets.interfaces;

import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.bip44wallets.apis.BatchBalanceAPI;
import com.coinbase.wallet.bip44wallets.dtos.BatchBalanceDTO;
import com.coinbase.wallet.bip44wallets.exceptions.BIP44Exception;
import com.coinbase.wallet.bip44wallets.extensions.StoreKeys_BIP44WalletsKt;
import com.coinbase.wallet.bip44wallets.extensions.TraceKey_BIP44WalletsKt;
import com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging;
import com.coinbase.wallet.bip44wallets.models.BIP44Configuration;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.interfaces.BalanceManaging;
import com.coinbase.wallet.blockchains.models.Address;
import com.coinbase.wallet.blockchains.models.AddressType;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.RefreshContext;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.core.models.TraceKey;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: BIP44BalanceManaging.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007JU\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001b0\u001a0\u00042\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b \u0010!J\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\"\u0010\u0007J+\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140#H\u0002¢\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b'\u0010(J\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b)\u0010(J\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b*\u0010(J5\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b*\u0010+J7\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0#0\u00042\u0006\u0010-\u001a\u00020,2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001f0.H\u0002¢\u0006\u0004\b0\u00101J\u0013\u00102\u001a\u00020\u0014*\u00020\u001fH\u0002¢\u0006\u0004\b2\u00103R\u0016\u00107\u001a\u0002048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bM\u0010N¨\u0006P"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/interfaces/BIP44BalanceManaging;", "Lcom/coinbase/wallet/blockchains/interfaces/BalanceManaging;", "Lcom/coinbase/wallet/blockchains/models/RefreshContext;", "context", "Lh/c/b0;", "Lkotlin/x;", "refreshBalances", "(Lcom/coinbase/wallet/blockchains/models/RefreshContext;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "addressType", "", "isChangeAddress", "", "index", "", "xpubKey", "shouldSaveOnError", "saveAddress", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/blockchains/models/AddressType;ZILjava/lang/String;Z)Lh/c/b0;", "address", "Lkotlin/o;", "Ljava/math/BigInteger;", "fetchAddressChanges", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/blockchains/models/Address;", "getNextAvailableReceiveAddress", "(Lcom/coinbase/wallet/blockchains/models/AddressType;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "refreshAll", "", ApiConstants.ADDRESSES, "refreshSubset", "(Lcom/coinbase/wallet/blockchains/models/Network;Ljava/util/List;)Lh/c/b0;", "refreshWallet", "(Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "scanExistingAddresses", "scanNewAddresses", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/AddressType;ZLcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "Lcom/coinbase/wallet/bip44wallets/dtos/BatchBalanceDTO;", "batchBalanceDTO", "", "addressMap", "updateAddresses", "(Lcom/coinbase/wallet/bip44wallets/dtos/BatchBalanceDTO;Ljava/util/Map;)Lh/c/b0;", "logID", "(Lcom/coinbase/wallet/blockchains/models/Address;)Ljava/lang/String;", "Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration;", "getConfiguration", "()Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration;", "configuration", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "getStore", "()Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;", "getBatchBalanceAPI", "()Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;", "batchBalanceAPI", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "getAddressDao", "()Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/bip44wallets/interfaces/BIP44WalletService;", "getWalletService", "()Lcom/coinbase/wallet/bip44wallets/interfaces/BIP44WalletService;", "walletService", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "getWalletDao", "()Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "walletDao", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "getTracer", "()Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "bip44wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface BIP44BalanceManaging extends BalanceManaging {
    AddressDao getAddressDao();

    BatchBalanceAPI getBatchBalanceAPI();

    BIP44Configuration getConfiguration();

    StoreInterface getStore();

    Tracing getTracer();

    WalletDao getWalletDao();

    BIP44WalletService getWalletService();

    @Override // com.coinbase.wallet.blockchains.interfaces.BalanceManaging
    h.c.b0<kotlin.x> refreshBalances(RefreshContext refreshContext);

    h.c.b0<Boolean> saveAddress(Blockchain blockchain, CurrencyCode currencyCode, Network network, AddressType addressType, boolean z, int i2, String str, boolean z2);

    /* compiled from: BIP44BalanceManaging.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object a(kotlin.jvm.internal.b0 b0Var, Boolean bool) {
            return m719scanNewAddresses$lambda26$lambda24$lambda21(b0Var, bool);
        }

        public static /* synthetic */ h.c.h0 b(BIP44BalanceManaging bIP44BalanceManaging, String str, int i2, AddressType addressType, boolean z, Network network, Optional optional) {
            return m709saveAddress$lambda1(bIP44BalanceManaging, str, i2, addressType, z, network, optional);
        }

        public static /* synthetic */ h.c.x c(List list) {
            return m714scanExistingAddresses$lambda27(list);
        }

        public static /* synthetic */ h.c.h0 d(Throwable th) {
            return m720scanNewAddresses$lambda26$lambda24$lambda22(th);
        }

        public static /* synthetic */ h.c.h0 e(BIP44BalanceManaging bIP44BalanceManaging, Network network, AddressType addressType, Optional optional) {
            return m703getNextAvailableReceiveAddress$lambda18(bIP44BalanceManaging, network, addressType, optional);
        }

        public static /* synthetic */ Boolean f(kotlin.o oVar, Address address) {
            return m713saveAddress$lambda5$lambda4(oVar, address);
        }

        private static h.c.b0<kotlin.o<Boolean, BigInteger>> fetchAddressChanges(BIP44BalanceManaging bIP44BalanceManaging, String str, Network network) {
            BIP44WalletService walletService = bIP44BalanceManaging.getWalletService();
            h.c.b0 logError$default = Single_AnalyticsKt.logError$default(walletService.isAddressUsed(str, network.isTestnet()), null, null, 3, null);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            h.c.b0<kotlin.o<Boolean, BigInteger>> trace = Single_CoreKt.trace(h.c.t0.e.a.a(Single_CoreKt.retryWithDelay(logError$default, 3L, 1L, timeUnit), Single_CoreKt.retryWithDelay(Single_AnalyticsKt.logError$default(walletService.getBalance(str, network.isTestnet()), null, null, 3, null), 3L, 1L, timeUnit)), TraceKey_BIP44WalletsKt.fetchAddressChangesTrace(TraceKey.Companion), bIP44BalanceManaging.getTracer());
            kotlin.jvm.internal.m.f(trace, "Singles.zip(isAddressUsedSingle, getBalanceSingle)\n            .trace(TraceKey.fetchAddressChangesTrace(), tracer)");
            return trace;
        }

        public static /* synthetic */ h.c.x g(BIP44BalanceManaging bIP44BalanceManaging, Blockchain blockchain, CurrencyCode currencyCode, Network network, AddressType addressType, boolean z, kotlin.jvm.internal.b0 b0Var, String str, kotlin.jvm.internal.b0 b0Var2, Integer num) {
            return m718scanNewAddresses$lambda26$lambda24(bIP44BalanceManaging, blockchain, currencyCode, network, addressType, z, b0Var, str, b0Var2, num);
        }

        private static h.c.b0<Optional<Address>> getNextAvailableReceiveAddress(final BIP44BalanceManaging bIP44BalanceManaging, final AddressType addressType, final Network network) {
            CurrencyCode currencyCode = bIP44BalanceManaging.getConfiguration().getCurrencyCode();
            h.c.b0 flatMap = bIP44BalanceManaging.getAddressDao().getFirstUnusedAddress(bIP44BalanceManaging.getConfiguration().getBlockchain(), currencyCode, network, addressType, false).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.e
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BalanceManaging.DefaultImpls.e(BIP44BalanceManaging.this, network, addressType, (Optional) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap, "addressDao\n        .getFirstUnusedAddress(\n            currencyCode = configuration.currencyCode,\n            addressType = addressType,\n            isChangeAddress = false,\n            network = network,\n            blockchain = configuration.blockchain\n        )\n        .flatMap {\n            if (it.value != null) {\n                return@flatMap Single.just(it)\n            }\n\n            addressDao.getLatestAddress(\n                blockchain = configuration.blockchain,\n                currencyCode = configuration.currencyCode,\n                addressType = addressType,\n                isChangeAddress = false,\n                network = network\n            )\n        }");
            return flatMap;
        }

        /* renamed from: getNextAvailableReceiveAddress$lambda-18 */
        public static h.c.h0 m703getNextAvailableReceiveAddress$lambda18(BIP44BalanceManaging this$0, Network network, AddressType addressType, Optional it) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(network, "$network");
            kotlin.jvm.internal.m.g(addressType, "$addressType");
            kotlin.jvm.internal.m.g(it, "it");
            if (it.getValue() != null) {
                return h.c.b0.just(it);
            }
            return this$0.getAddressDao().getLatestAddress(this$0.getConfiguration().getBlockchain(), this$0.getConfiguration().getCurrencyCode(), network, addressType, false);
        }

        public static /* synthetic */ h.c.h0 h(BIP44BalanceManaging bIP44BalanceManaging, Network network, List list) {
            return m705refreshSubset$lambda10(bIP44BalanceManaging, network, list);
        }

        public static /* synthetic */ h.c.h0 i(BIP44BalanceManaging bIP44BalanceManaging, Map map, BatchBalanceDTO batchBalanceDTO) {
            return m716scanExistingAddresses$lambda31$lambda30(bIP44BalanceManaging, map, batchBalanceDTO);
        }

        public static /* synthetic */ h.c.x j(BIP44BalanceManaging bIP44BalanceManaging, Network network, List list) {
            return m715scanExistingAddresses$lambda31(bIP44BalanceManaging, network, list);
        }

        public static /* synthetic */ boolean k(kotlin.jvm.internal.b0 b0Var) {
            return m722scanNewAddresses$lambda26$lambda25(b0Var);
        }

        public static /* synthetic */ h.c.h0 l(BIP44BalanceManaging bIP44BalanceManaging, AddressType addressType, int i2, boolean z, Network network, CurrencyCode currencyCode, Blockchain blockchain, kotlin.o oVar) {
            return m712saveAddress$lambda5(bIP44BalanceManaging, addressType, i2, z, network, currencyCode, blockchain, oVar);
        }

        private static String logID(BIP44BalanceManaging bIP44BalanceManaging, Address address) {
            StringBuilder sb = new StringBuilder();
            sb.append(address.getBlockchain());
            sb.append('/');
            sb.append(address.getCurrencyCode());
            sb.append('/');
            sb.append(address.getNetwork());
            sb.append('/');
            sb.append(address.getType());
            sb.append('/');
            sb.append(address.isChangeAddress());
            sb.append('/');
            sb.append(address.getIndex());
            return sb.toString();
        }

        public static /* synthetic */ kotlin.o m(boolean z, Throwable th) {
            return m711saveAddress$lambda3$lambda2(z, th);
        }

        public static /* synthetic */ h.c.h0 n(BIP44BalanceManaging bIP44BalanceManaging, Network network, boolean z, String str) {
            return m710saveAddress$lambda3(bIP44BalanceManaging, network, z, str);
        }

        public static /* synthetic */ h.c.h0 o(BIP44BalanceManaging bIP44BalanceManaging, List list) {
            return m706refreshSubset$lambda9(bIP44BalanceManaging, list);
        }

        public static /* synthetic */ h.c.h0 p(Address address, BIP44BalanceManaging bIP44BalanceManaging, BigInteger bigInteger) {
            return m707refreshSubset$lambda9$lambda8$lambda7(address, bIP44BalanceManaging, bigInteger);
        }

        public static /* synthetic */ kotlin.x q(kotlin.jvm.internal.b0 b0Var, Object obj) {
            return m721scanNewAddresses$lambda26$lambda24$lambda23(b0Var, obj);
        }

        public static /* synthetic */ h.c.h0 r(BIP44BalanceManaging bIP44BalanceManaging, Network network, kotlin.o oVar) {
            return m708refreshWallet$lambda17(bIP44BalanceManaging, network, oVar);
        }

        private static h.c.b0<kotlin.x> refreshAll(final BIP44BalanceManaging bIP44BalanceManaging, final RefreshContext refreshContext) {
            h.c.b0 flatMap = Single_CoreKt.asUnit(h.c.t0.e.a.a(scanExistingAddresses(bIP44BalanceManaging, refreshContext.getNetwork()), scanNewAddresses(bIP44BalanceManaging, refreshContext.getNetwork()))).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.s
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BalanceManaging.DefaultImpls.s(BIP44BalanceManaging.this, refreshContext, (kotlin.x) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap, "Singles\n        .zip(\n            scanExistingAddresses(context.network),\n            scanNewAddresses(context.network)\n        )\n        .asUnit()\n        .flatMap { refreshWallet(context.network) }");
            return flatMap;
        }

        /* renamed from: refreshAll$lambda-6 */
        public static h.c.h0 m704refreshAll$lambda6(BIP44BalanceManaging this$0, RefreshContext context, kotlin.x it) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(context, "$context");
            kotlin.jvm.internal.m.g(it, "it");
            return refreshWallet(this$0, context.getNetwork());
        }

        public static h.c.b0<kotlin.x> refreshBalances(BIP44BalanceManaging bIP44BalanceManaging, RefreshContext context) {
            h.c.b0<kotlin.x> refreshAll;
            kotlin.jvm.internal.m.g(bIP44BalanceManaging, "this");
            kotlin.jvm.internal.m.g(context, "context");
            RefreshContext.Mode mode = context.getMode();
            if (mode instanceof RefreshContext.Mode.Quick) {
                refreshAll = refreshWallet(bIP44BalanceManaging, context.getNetwork());
            } else if (mode instanceof RefreshContext.Mode.Subset) {
                refreshAll = refreshSubset(bIP44BalanceManaging, context.getNetwork(), ((RefreshContext.Mode.Subset) mode).getAddresses());
            } else if (!(mode instanceof RefreshContext.Mode.Full)) {
                throw new NoWhenBranchMatchedException();
            } else {
                refreshAll = refreshAll(bIP44BalanceManaging, context);
            }
            h.c.b0<kotlin.x> trace = Single_CoreKt.trace(refreshAll, TraceKey_BIP44WalletsKt.refreshBalancesTrace(TraceKey.Companion, context), bIP44BalanceManaging.getTracer());
            kotlin.jvm.internal.m.f(trace, "refreshTask.trace(TraceKey.refreshBalancesTrace(context), tracer)");
            return trace;
        }

        private static h.c.b0<kotlin.x> refreshSubset(final BIP44BalanceManaging bIP44BalanceManaging, final Network network, List<String> list) {
            h.c.b0<kotlin.x> flatMap = bIP44BalanceManaging.getAddressDao().getAddresses(bIP44BalanceManaging.getConfiguration().getBlockchain(), bIP44BalanceManaging.getConfiguration().getCurrencyCode(), list, network).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.o
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BalanceManaging.DefaultImpls.o(BIP44BalanceManaging.this, (List) obj);
                }
            }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.h
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BalanceManaging.DefaultImpls.h(BIP44BalanceManaging.this, network, (List) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap, "addressDao\n        .getAddresses(\n            blockchain = configuration.blockchain,\n            currencyCode = configuration.currencyCode,\n            addresses = addresses,\n            network = network\n        )\n        .flatMap { hdAddresses ->\n            hdAddresses\n                .map { hdAddress ->\n                    walletService\n                        .getBalance(address = hdAddress.address, testnet = hdAddress.network.isTestnet)\n                        .flatMap { balance ->\n                            val updatedAddress = Address(\n                                address = hdAddress.address,\n                                index = hdAddress.index,\n                                balance = balance,\n                                currencyCode = hdAddress.currencyCode,\n                                isChangeAddress = hdAddress.isChangeAddress,\n                                network = hdAddress.network,\n                                type = hdAddress.type,\n                                derivationPath = hdAddress.derivationPath,\n                                isUsed = true,\n                                blockchain = hdAddress.blockchain\n                            )\n\n                            addressDao.save(updatedAddress)\n                        }\n                        .asUnit()\n                }\n                .zipOrEmpty()\n        }\n        .flatMap { refreshWallet(network) }");
            return flatMap;
        }

        /* renamed from: refreshSubset$lambda-10 */
        public static h.c.h0 m705refreshSubset$lambda10(BIP44BalanceManaging this$0, Network network, List it) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(network, "$network");
            kotlin.jvm.internal.m.g(it, "it");
            return refreshWallet(this$0, network);
        }

        /* renamed from: refreshSubset$lambda-9 */
        public static h.c.h0 m706refreshSubset$lambda9(final BIP44BalanceManaging this$0, List hdAddresses) {
            int r;
            List g2;
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(hdAddresses, "hdAddresses");
            r = kotlin.a0.s.r(hdAddresses, 10);
            ArrayList arrayList = new ArrayList(r);
            Iterator it = hdAddresses.iterator();
            while (it.hasNext()) {
                final Address address = (Address) it.next();
                h.c.b0<R> flatMap = this$0.getWalletService().getBalance(address.getAddress(), address.getNetwork().isTestnet()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.p
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return BIP44BalanceManaging.DefaultImpls.p(Address.this, this$0, (BigInteger) obj);
                    }
                });
                kotlin.jvm.internal.m.f(flatMap, "walletService\n                        .getBalance(address = hdAddress.address, testnet = hdAddress.network.isTestnet)\n                        .flatMap { balance ->\n                            val updatedAddress = Address(\n                                address = hdAddress.address,\n                                index = hdAddress.index,\n                                balance = balance,\n                                currencyCode = hdAddress.currencyCode,\n                                isChangeAddress = hdAddress.isChangeAddress,\n                                network = hdAddress.network,\n                                type = hdAddress.type,\n                                derivationPath = hdAddress.derivationPath,\n                                isUsed = true,\n                                blockchain = hdAddress.blockchain\n                            )\n\n                            addressDao.save(updatedAddress)\n                        }");
                arrayList.add(Single_CoreKt.asUnit(flatMap));
            }
            h.c.t0.e eVar = h.c.t0.e.a;
            if (arrayList.isEmpty()) {
                g2 = kotlin.a0.r.g();
                h.c.b0 just = h.c.b0.just(g2);
                kotlin.jvm.internal.m.f(just, "just(emptyList())");
                return just;
            }
            h.c.b0 zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging$DefaultImpls$refreshSubset$lambda-9$$inlined$zipOrEmpty$1
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
                        if (obj instanceof kotlin.x) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
            return zip;
        }

        /* renamed from: refreshSubset$lambda-9$lambda-8$lambda-7 */
        public static h.c.h0 m707refreshSubset$lambda9$lambda8$lambda7(Address hdAddress, BIP44BalanceManaging this$0, BigInteger balance) {
            kotlin.jvm.internal.m.g(hdAddress, "$hdAddress");
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(balance, "balance");
            return this$0.getAddressDao().save(new Address(hdAddress.getIndex(), hdAddress.getAddress(), balance, hdAddress.getCurrencyCode(), hdAddress.isChangeAddress(), hdAddress.getNetwork(), hdAddress.getType(), hdAddress.getDerivationPath(), true, hdAddress.getBlockchain(), null, 1024, null));
        }

        private static h.c.b0<kotlin.x> refreshWallet(final BIP44BalanceManaging bIP44BalanceManaging, final Network network) {
            int r;
            h.c.b0 zip;
            List g2;
            h.c.b0<List<Address>> orderedAddresses = bIP44BalanceManaging.getAddressDao().getOrderedAddresses(bIP44BalanceManaging.getConfiguration().getBlockchain(), bIP44BalanceManaging.getConfiguration().getCurrencyCode(), network);
            List<AddressType> supportedAddressTypes = bIP44BalanceManaging.getConfiguration().getSupportedAddressTypes();
            r = kotlin.a0.s.r(supportedAddressTypes, 10);
            ArrayList arrayList = new ArrayList(r);
            for (AddressType addressType : supportedAddressTypes) {
                arrayList.add(getNextAvailableReceiveAddress(bIP44BalanceManaging, addressType, network));
            }
            h.c.t0.e eVar = h.c.t0.e.a;
            if (arrayList.isEmpty()) {
                g2 = kotlin.a0.r.g();
                zip = h.c.b0.just(g2);
                kotlin.jvm.internal.m.f(zip, "just(emptyList())");
            } else {
                zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging$DefaultImpls$refreshWallet$$inlined$zipOrEmpty$1
                    @Override // h.c.m0.n
                    public final List<T> apply(Object[] it) {
                        List<T> g3;
                        kotlin.jvm.internal.m.g(it, "it");
                        if (it.length == 0) {
                            g3 = kotlin.a0.r.g();
                            return g3;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj : it) {
                            if (obj instanceof Optional) {
                                arrayList2.add(obj);
                            }
                        }
                        return arrayList2;
                    }
                });
                kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
            }
            h.c.b0<kotlin.x> flatMap = eVar.a(orderedAddresses, zip).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.r
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BalanceManaging.DefaultImpls.r(BIP44BalanceManaging.this, network, (kotlin.o) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap, "Singles.zip(getAddresses, getReceivableAddresses)\n            .flatMap { (addresses, receivableAddresses) ->\n                val coinAddresses = receivableAddresses\n                    .mapNotNull { it.toNullable() }\n                    .map { WalletAddress(it.type, it.address, it.index) }\n\n                if (coinAddresses.isEmpty()) {\n                    return@flatMap Single.just(Unit)\n                }\n\n                val totalBalance: BigInteger = addresses\n                    .map { it.balance }\n                    .reduce { sum, balance -> sum.plus(balance) }\n\n                val defaultAddress = coinAddresses\n                    .firstOrNull { it.type == configuration.defaultReceiveType }\n                    ?: coinAddresses.first()\n\n                val coin = Wallet(\n                    primaryAddress = defaultAddress.address,\n                    addresses = coinAddresses,\n                    displayName = configuration.displayName(network),\n                    currencyCode = configuration.currencyCode,\n                    imageURL = configuration.imageURL,\n                    balance = totalBalance,\n                    decimals = configuration.decimals,\n                    blockchain = configuration.blockchain,\n                    minimumBalance = null,\n                    network = network,\n                    selectedIndex = null\n                )\n\n                walletDao.save(coin).asUnit()\n            }");
            return flatMap;
        }

        /* renamed from: refreshWallet$lambda-17 */
        public static h.c.h0 m708refreshWallet$lambda17(BIP44BalanceManaging this$0, Network network, kotlin.o dstr$addresses$receivableAddresses) {
            int r;
            int r2;
            Object obj;
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(network, "$network");
            kotlin.jvm.internal.m.g(dstr$addresses$receivableAddresses, "$dstr$addresses$receivableAddresses");
            List<Address> addresses = (List) dstr$addresses$receivableAddresses.a();
            List<Optional> receivableAddresses = (List) dstr$addresses$receivableAddresses.b();
            kotlin.jvm.internal.m.f(receivableAddresses, "receivableAddresses");
            ArrayList<Address> arrayList = new ArrayList();
            for (Optional optional : receivableAddresses) {
                Address address = (Address) optional.toNullable();
                if (address != null) {
                    arrayList.add(address);
                }
            }
            r = kotlin.a0.s.r(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(r);
            for (Address address2 : arrayList) {
                arrayList2.add(new WalletAddress(address2.getType(), address2.getAddress(), address2.getIndex()));
            }
            if (arrayList2.isEmpty()) {
                return h.c.b0.just(kotlin.x.a);
            }
            kotlin.jvm.internal.m.f(addresses, "addresses");
            r2 = kotlin.a0.s.r(addresses, 10);
            ArrayList arrayList3 = new ArrayList(r2);
            for (Address address3 : addresses) {
                arrayList3.add(address3.getBalance());
            }
            Iterator it = arrayList3.iterator();
            if (it.hasNext()) {
                BigInteger bigInteger = it.next();
                while (it.hasNext()) {
                    BigInteger add = ((BigInteger) bigInteger).add((BigInteger) it.next());
                    kotlin.jvm.internal.m.f(add, "this.add(other)");
                    bigInteger = add;
                }
                BigInteger bigInteger2 = (BigInteger) bigInteger;
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    if (kotlin.jvm.internal.m.c(((WalletAddress) obj).getType(), this$0.getConfiguration().getDefaultReceiveType())) {
                        break;
                    }
                }
                WalletAddress walletAddress = (WalletAddress) obj;
                if (walletAddress == null) {
                    walletAddress = (WalletAddress) kotlin.a0.p.Y(arrayList2);
                }
                return Single_CoreKt.asUnit(this$0.getWalletDao().save(new Wallet(walletAddress.getAddress(), arrayList2, this$0.getConfiguration().displayName(network), this$0.getConfiguration().getCurrencyCode(), this$0.getConfiguration().getImageURL(), bigInteger2, this$0.getConfiguration().getDecimals(), this$0.getConfiguration().getBlockchain(), null, network, null, null, 1024, null)));
            }
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }

        public static /* synthetic */ h.c.h0 s(BIP44BalanceManaging bIP44BalanceManaging, RefreshContext refreshContext, kotlin.x xVar) {
            return m704refreshAll$lambda6(bIP44BalanceManaging, refreshContext, xVar);
        }

        public static h.c.b0<Boolean> saveAddress(final BIP44BalanceManaging bIP44BalanceManaging, final Blockchain blockchain, final CurrencyCode currencyCode, final Network network, final AddressType addressType, final boolean z, final int i2, final String xpubKey, final boolean z2) {
            kotlin.jvm.internal.m.g(bIP44BalanceManaging, "this");
            kotlin.jvm.internal.m.g(blockchain, "blockchain");
            kotlin.jvm.internal.m.g(currencyCode, "currencyCode");
            kotlin.jvm.internal.m.g(network, "network");
            kotlin.jvm.internal.m.g(addressType, "addressType");
            kotlin.jvm.internal.m.g(xpubKey, "xpubKey");
            h.c.b0<Boolean> flatMap = bIP44BalanceManaging.getAddressDao().getAddressForIndex(blockchain, currencyCode, network, addressType, z, i2).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.b
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BalanceManaging.DefaultImpls.b(BIP44BalanceManaging.this, xpubKey, i2, addressType, z, network, (Optional) obj);
                }
            }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.n
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BalanceManaging.DefaultImpls.n(BIP44BalanceManaging.this, network, z2, (String) obj);
                }
            }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.l
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BalanceManaging.DefaultImpls.l(BIP44BalanceManaging.this, addressType, i2, z, network, currencyCode, blockchain, (kotlin.o) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap, "addressDao\n        .getAddressForIndex(\n            blockchain = blockchain,\n            currencyCode = currencyCode,\n            network = network,\n            addressType = addressType,\n            isChangeAddress = isChangeAddress,\n            index = index\n        )\n        .flatMap { optionalAddress ->\n            optionalAddress.toNullable()?.let { return@flatMap Single.just(it.address) }\n\n            walletService.deriveAddressFromXpubKey(\n                xpubKey = xpubKey,\n                index = index.toUInt(),\n                addressType = addressType,\n                change = isChangeAddress,\n                testnet = network.isTestnet\n            )\n        }\n        .flatMap {\n            val fetchAddressChanges = fetchAddressChanges(it, network)\n                .onErrorReturn { throwable ->\n                    if (shouldSaveOnError) {\n                        Pair(false, BigInteger.ZERO)\n                    } else {\n                        throw throwable\n                    }\n                }\n\n            Singles.zip(fetchAddressChanges, Single.just(it))\n        }\n        .flatMap { (pair, address) ->\n            val derivationPath = walletService\n                .addressDerivationPath(\n                    addressType = addressType,\n                    index = index,\n                    isChangeAddress = isChangeAddress,\n                    testnet = network.isTestnet\n                ) ?: throw BIP44Exception.UnableToGenerateAddressDerivationPath\n\n            val bip44Address = Address(\n                index = index,\n                address = address,\n                balance = pair.second,\n                currencyCode = currencyCode,\n                isChangeAddress = isChangeAddress,\n                network = network,\n                type = addressType,\n                derivationPath = derivationPath,\n                isUsed = pair.first,\n                blockchain = blockchain\n            )\n\n            addressDao.save(bip44Address).map { pair.first }\n        }");
            return flatMap;
        }

        /* renamed from: saveAddress$lambda-1 */
        public static h.c.h0 m709saveAddress$lambda1(BIP44BalanceManaging this$0, String xpubKey, int i2, AddressType addressType, boolean z, Network network, Optional optionalAddress) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(xpubKey, "$xpubKey");
            kotlin.jvm.internal.m.g(addressType, "$addressType");
            kotlin.jvm.internal.m.g(network, "$network");
            kotlin.jvm.internal.m.g(optionalAddress, "optionalAddress");
            Address address = (Address) optionalAddress.toNullable();
            if (address == null) {
                return this$0.getWalletService().mo760deriveAddressFromXpubKeyroUYKiI(xpubKey, UInt.s(i2), addressType, z, network.isTestnet());
            }
            return h.c.b0.just(address.getAddress());
        }

        /* renamed from: saveAddress$lambda-3 */
        public static h.c.h0 m710saveAddress$lambda3(BIP44BalanceManaging this$0, Network network, final boolean z, String it) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(network, "$network");
            kotlin.jvm.internal.m.g(it, "it");
            h.c.b0<kotlin.o<Boolean, BigInteger>> onErrorReturn = fetchAddressChanges(this$0, it, network).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.m
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BalanceManaging.DefaultImpls.m(z, (Throwable) obj);
                }
            });
            kotlin.jvm.internal.m.f(onErrorReturn, "fetchAddressChanges(it, network)\n                .onErrorReturn { throwable ->\n                    if (shouldSaveOnError) {\n                        Pair(false, BigInteger.ZERO)\n                    } else {\n                        throw throwable\n                    }\n                }");
            h.c.t0.e eVar = h.c.t0.e.a;
            h.c.b0 just = h.c.b0.just(it);
            kotlin.jvm.internal.m.f(just, "just(it)");
            return eVar.a(onErrorReturn, just);
        }

        /* renamed from: saveAddress$lambda-3$lambda-2 */
        public static kotlin.o m711saveAddress$lambda3$lambda2(boolean z, Throwable throwable) {
            kotlin.jvm.internal.m.g(throwable, "throwable");
            if (z) {
                return new kotlin.o(Boolean.FALSE, BigInteger.ZERO);
            }
            throw throwable;
        }

        /* renamed from: saveAddress$lambda-5 */
        public static h.c.h0 m712saveAddress$lambda5(BIP44BalanceManaging this$0, AddressType addressType, int i2, boolean z, Network network, CurrencyCode currencyCode, Blockchain blockchain, kotlin.o dstr$pair$address) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(addressType, "$addressType");
            kotlin.jvm.internal.m.g(network, "$network");
            kotlin.jvm.internal.m.g(currencyCode, "$currencyCode");
            kotlin.jvm.internal.m.g(blockchain, "$blockchain");
            kotlin.jvm.internal.m.g(dstr$pair$address, "$dstr$pair$address");
            final kotlin.o oVar = (kotlin.o) dstr$pair$address.a();
            String address = (String) dstr$pair$address.b();
            String addressDerivationPath = this$0.getWalletService().addressDerivationPath(addressType, i2, z, network.isTestnet());
            if (addressDerivationPath != null) {
                kotlin.jvm.internal.m.f(address, "address");
                return this$0.getAddressDao().save(new Address(i2, address, (BigInteger) oVar.d(), currencyCode, z, network, addressType, addressDerivationPath, ((Boolean) oVar.c()).booleanValue(), blockchain, null, 1024, null)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.f
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return BIP44BalanceManaging.DefaultImpls.f(kotlin.o.this, (Address) obj);
                    }
                });
            }
            throw BIP44Exception.UnableToGenerateAddressDerivationPath.INSTANCE;
        }

        /* renamed from: saveAddress$lambda-5$lambda-4 */
        public static Boolean m713saveAddress$lambda5$lambda4(kotlin.o oVar, Address it) {
            kotlin.jvm.internal.m.g(it, "it");
            return (Boolean) oVar.c();
        }

        private static h.c.b0<kotlin.x> scanExistingAddresses(final BIP44BalanceManaging bIP44BalanceManaging, final Network network) {
            h.c.b0<kotlin.x> last = bIP44BalanceManaging.getAddressDao().getUsedAddresses(bIP44BalanceManaging.getConfiguration().getBlockchain(), bIP44BalanceManaging.getConfiguration().getCurrencyCode(), network).flatMapObservable(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.c
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BalanceManaging.DefaultImpls.c((List) obj);
                }
            }).buffer(500L, TimeUnit.MILLISECONDS, 100).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.j
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BalanceManaging.DefaultImpls.j(BIP44BalanceManaging.this, network, (List) obj);
                }
            }).last(kotlin.x.a);
            kotlin.jvm.internal.m.f(last, "addressDao.getUsedAddresses(configuration.blockchain, configuration.currencyCode, network)\n            .flatMapObservable { it.toObservable() }\n            .buffer(500, TimeUnit.MILLISECONDS, 100)\n            .flatMap { addressList ->\n                if (addressList.isEmpty()) return@flatMap Observable.just(Unit)\n\n                val code = configuration.currencyCode.code.toLowerCase(Locale.US)\n\n                val addressMap: Map<String, Address> = addressList\n                    .reduceIntoMap(LinkedHashMap(addressList.size)) { mutableMap, address ->\n                        mutableMap[address.address] = address\n                    }\n\n                batchBalanceAPI\n                    .getBalances(\n                        code = code,\n                        addressList = addressList.map { it.address },\n                        isTestnet = network.isTestnet\n                    )\n                    .retryWithDelay(3, 1, TimeUnit.SECONDS)\n                    .flatMap { updateAddresses(it, addressMap) }\n                    .logError()\n                    .asUnit()\n                    .toObservable()\n            }\n            .last(Unit)");
            return last;
        }

        /* renamed from: scanExistingAddresses$lambda-27 */
        public static h.c.x m714scanExistingAddresses$lambda27(List it) {
            kotlin.jvm.internal.m.g(it, "it");
            return h.c.t0.b.c(it);
        }

        /* renamed from: scanExistingAddresses$lambda-31 */
        public static h.c.x m715scanExistingAddresses$lambda31(final BIP44BalanceManaging this$0, Network network, List addressList) {
            int r;
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(network, "$network");
            kotlin.jvm.internal.m.g(addressList, "addressList");
            if (addressList.isEmpty()) {
                return h.c.s.just(kotlin.x.a);
            }
            String code = this$0.getConfiguration().getCurrencyCode().getCode();
            Locale US = Locale.US;
            kotlin.jvm.internal.m.f(US, "US");
            Objects.requireNonNull(code, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = code.toLowerCase(US);
            kotlin.jvm.internal.m.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            final LinkedHashMap linkedHashMap = new LinkedHashMap(addressList.size());
            Iterator it = addressList.iterator();
            while (it.hasNext()) {
                Address address = (Address) it.next();
                String address2 = address.getAddress();
                kotlin.jvm.internal.m.f(address, "address");
                linkedHashMap.put(address2, address);
            }
            BatchBalanceAPI batchBalanceAPI = this$0.getBatchBalanceAPI();
            r = kotlin.a0.s.r(addressList, 10);
            ArrayList arrayList = new ArrayList(r);
            Iterator it2 = addressList.iterator();
            while (it2.hasNext()) {
                arrayList.add(((Address) it2.next()).getAddress());
            }
            h.c.b0 flatMap = Single_CoreKt.retryWithDelay(batchBalanceAPI.getBalances(lowerCase, arrayList, network.isTestnet()), 3L, 1L, TimeUnit.SECONDS).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.i
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BalanceManaging.DefaultImpls.i(BIP44BalanceManaging.this, linkedHashMap, (BatchBalanceDTO) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap, "batchBalanceAPI\n                    .getBalances(\n                        code = code,\n                        addressList = addressList.map { it.address },\n                        isTestnet = network.isTestnet\n                    )\n                    .retryWithDelay(3, 1, TimeUnit.SECONDS)\n                    .flatMap { updateAddresses(it, addressMap) }");
            return Single_CoreKt.asUnit(Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null)).toObservable();
        }

        /* renamed from: scanExistingAddresses$lambda-31$lambda-30 */
        public static h.c.h0 m716scanExistingAddresses$lambda31$lambda30(BIP44BalanceManaging this$0, Map addressMap, BatchBalanceDTO it) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(addressMap, "$addressMap");
            kotlin.jvm.internal.m.g(it, "it");
            return updateAddresses(this$0, it, addressMap);
        }

        private static h.c.b0<kotlin.x> scanNewAddresses(BIP44BalanceManaging bIP44BalanceManaging, Network network) {
            List u;
            h.c.b0 zip;
            List g2;
            List<Boolean> j2;
            int r;
            ArrayList arrayList;
            List<AddressType> supportedAddressTypes = bIP44BalanceManaging.getConfiguration().getSupportedAddressTypes();
            ArrayList arrayList2 = new ArrayList();
            for (AddressType addressType : supportedAddressTypes) {
                String str = (String) bIP44BalanceManaging.getStore().get(StoreKeys_BIP44WalletsKt.xpubKey(StoreKeys.INSTANCE, bIP44BalanceManaging.getConfiguration().getBlockchain(), bIP44BalanceManaging.getConfiguration().getCurrencyCode(), addressType, network.isTestnet()));
                if (str == null) {
                    arrayList = null;
                } else {
                    j2 = kotlin.a0.r.j(Boolean.TRUE, Boolean.FALSE);
                    r = kotlin.a0.s.r(j2, 10);
                    ArrayList arrayList3 = new ArrayList(r);
                    for (Boolean bool : j2) {
                        arrayList3.add(scanNewAddresses(bIP44BalanceManaging, str, addressType, bool.booleanValue(), network));
                    }
                    arrayList = arrayList3;
                }
                if (arrayList != null) {
                    arrayList2.add(arrayList);
                }
            }
            u = kotlin.a0.s.u(arrayList2);
            h.c.t0.e eVar = h.c.t0.e.a;
            if (u.isEmpty()) {
                g2 = kotlin.a0.r.g();
                zip = h.c.b0.just(g2);
                kotlin.jvm.internal.m.f(zip, "just(emptyList())");
            } else {
                zip = h.c.b0.zip(u, new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging$DefaultImpls$scanNewAddresses$$inlined$zipOrEmpty$1
                    @Override // h.c.m0.n
                    public final List<T> apply(Object[] it) {
                        List<T> g3;
                        kotlin.jvm.internal.m.g(it, "it");
                        if (it.length == 0) {
                            g3 = kotlin.a0.r.g();
                            return g3;
                        }
                        ArrayList arrayList4 = new ArrayList();
                        for (Object obj : it) {
                            if (obj instanceof kotlin.x) {
                                arrayList4.add(obj);
                            }
                        }
                        return arrayList4;
                    }
                });
                kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
            }
            return Single_CoreKt.asUnit(zip);
        }

        /* renamed from: scanNewAddresses$lambda-26 */
        public static h.c.x m717scanNewAddresses$lambda26(final BIP44BalanceManaging this$0, final Network network, final AddressType addressType, final boolean z, final String xpubKey, final kotlin.jvm.internal.b0 totalUnused, Optional address) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(network, "$network");
            kotlin.jvm.internal.m.g(addressType, "$addressType");
            kotlin.jvm.internal.m.g(xpubKey, "$xpubKey");
            kotlin.jvm.internal.m.g(totalUnused, "$totalUnused");
            kotlin.jvm.internal.m.g(address, "address");
            Address address2 = (Address) address.toNullable();
            int index = address2 == null ? 0 : address2.getIndex();
            final Blockchain blockchain = this$0.getConfiguration().getBlockchain();
            final CurrencyCode currencyCode = this$0.getConfiguration().getCurrencyCode();
            final kotlin.jvm.internal.b0 b0Var = new kotlin.jvm.internal.b0();
            b0Var.a = index;
            return h.c.s.just(Integer.valueOf(index)).concatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.g
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BalanceManaging.DefaultImpls.g(BIP44BalanceManaging.this, blockchain, currencyCode, network, addressType, z, b0Var, xpubKey, totalUnused, (Integer) obj);
                }
            }).repeatUntil(new h.c.m0.e() { // from class: com.coinbase.wallet.bip44wallets.interfaces.k
                @Override // h.c.m0.e
                public final boolean a() {
                    return BIP44BalanceManaging.DefaultImpls.k(kotlin.jvm.internal.b0.this);
                }
            });
        }

        /* renamed from: scanNewAddresses$lambda-26$lambda-24 */
        public static h.c.x m718scanNewAddresses$lambda26$lambda24(BIP44BalanceManaging this$0, Blockchain blockchain, CurrencyCode currencyCode, Network network, AddressType addressType, boolean z, final kotlin.jvm.internal.b0 index, String xpubKey, final kotlin.jvm.internal.b0 totalUnused, Integer it) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(blockchain, "$blockchain");
            kotlin.jvm.internal.m.g(currencyCode, "$currencyCode");
            kotlin.jvm.internal.m.g(network, "$network");
            kotlin.jvm.internal.m.g(addressType, "$addressType");
            kotlin.jvm.internal.m.g(index, "$index");
            kotlin.jvm.internal.m.g(xpubKey, "$xpubKey");
            kotlin.jvm.internal.m.g(totalUnused, "$totalUnused");
            kotlin.jvm.internal.m.g(it, "it");
            return this$0.saveAddress(blockchain, currencyCode, network, addressType, z, index.a, xpubKey, false).map(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.a
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BalanceManaging.DefaultImpls.a(kotlin.jvm.internal.b0.this, (Boolean) obj);
                }
            }).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.d
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BalanceManaging.DefaultImpls.d((Throwable) obj);
                }
            }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.q
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BalanceManaging.DefaultImpls.q(kotlin.jvm.internal.b0.this, obj);
                }
            }).toObservable();
        }

        /* renamed from: scanNewAddresses$lambda-26$lambda-24$lambda-21 */
        public static Object m719scanNewAddresses$lambda26$lambda24$lambda21(kotlin.jvm.internal.b0 totalUnused, Boolean isAddressUsed) {
            kotlin.jvm.internal.m.g(totalUnused, "$totalUnused");
            kotlin.jvm.internal.m.g(isAddressUsed, "isAddressUsed");
            if (isAddressUsed.booleanValue()) {
                totalUnused.a = 0;
                return kotlin.x.a;
            }
            int i2 = totalUnused.a;
            totalUnused.a = i2 + 1;
            return Integer.valueOf(i2);
        }

        /* renamed from: scanNewAddresses$lambda-26$lambda-24$lambda-22 */
        public static h.c.h0 m720scanNewAddresses$lambda26$lambda24$lambda22(Throwable it) {
            kotlin.jvm.internal.m.g(it, "it");
            throw it;
        }

        /* renamed from: scanNewAddresses$lambda-26$lambda-24$lambda-23 */
        public static kotlin.x m721scanNewAddresses$lambda26$lambda24$lambda23(kotlin.jvm.internal.b0 index, Object it) {
            kotlin.jvm.internal.m.g(index, "$index");
            kotlin.jvm.internal.m.g(it, "it");
            index.a++;
            return kotlin.x.a;
        }

        /* renamed from: scanNewAddresses$lambda-26$lambda-25 */
        public static boolean m722scanNewAddresses$lambda26$lambda25(kotlin.jvm.internal.b0 totalUnused) {
            kotlin.jvm.internal.m.g(totalUnused, "$totalUnused");
            return totalUnused.a >= 20;
        }

        public static /* synthetic */ h.c.x t(BIP44BalanceManaging bIP44BalanceManaging, Network network, AddressType addressType, boolean z, String str, kotlin.jvm.internal.b0 b0Var, Optional optional) {
            return m717scanNewAddresses$lambda26(bIP44BalanceManaging, network, addressType, z, str, b0Var, optional);
        }

        private static h.c.b0<List<Address>> updateAddresses(BIP44BalanceManaging bIP44BalanceManaging, BatchBalanceDTO batchBalanceDTO, Map<String, Address> map) {
            Address copy;
            Map<String, BigInteger> result = batchBalanceDTO.getResult();
            ArrayList arrayList = new ArrayList(result.size());
            for (Map.Entry<String, BigInteger> entry : result.entrySet()) {
                String key = entry.getKey();
                BigInteger value = entry.getValue();
                Address address = map.get(key);
                if (address == null) {
                    l.a.a.a("returned address " + key + " is not an address we requested in the batch request", new Object[0]);
                    l.a.a.e(new IllegalStateException("returned address is not an address we requested in the batch request"));
                } else {
                    copy = address.copy((r26 & 1) != 0 ? address.getId() : null, (r26 & 2) != 0 ? address.index : 0, (r26 & 4) != 0 ? address.address : null, (r26 & 8) != 0 ? address.balance : value, (r26 & 16) != 0 ? address.currencyCode : null, (r26 & 32) != 0 ? address.isChangeAddress : false, (r26 & 64) != 0 ? address.network : null, (r26 & 128) != 0 ? address.type : null, (r26 & 256) != 0 ? address.derivationPath : null, (r26 & 512) != 0 ? address.isUsed : false, (r26 & 1024) != 0 ? address.blockchain : null, (r26 & PKIFailureInfo.wrongIntegrity) != 0 ? address.contractAddress : null);
                    arrayList.add(copy);
                }
            }
            return bIP44BalanceManaging.getAddressDao().saveAll(arrayList);
        }

        private static h.c.b0<kotlin.x> scanNewAddresses(final BIP44BalanceManaging bIP44BalanceManaging, final String str, final AddressType addressType, final boolean z, final Network network) {
            final kotlin.jvm.internal.b0 b0Var = new kotlin.jvm.internal.b0();
            h.c.b0<kotlin.x> last = bIP44BalanceManaging.getAddressDao().getFirstUnusedAddress(bIP44BalanceManaging.getConfiguration().getBlockchain(), bIP44BalanceManaging.getConfiguration().getCurrencyCode(), network, addressType, z).flatMapObservable(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.t
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BalanceManaging.DefaultImpls.t(BIP44BalanceManaging.this, network, addressType, z, str, b0Var, (Optional) obj);
                }
            }).last(kotlin.x.a);
            kotlin.jvm.internal.m.f(last, "addressDao\n            .getFirstUnusedAddress(\n                blockchain = configuration.blockchain,\n                currencyCode = configuration.currencyCode,\n                addressType = addressType,\n                isChangeAddress = isChangeAddress,\n                network = network\n            )\n            .flatMapObservable { address ->\n                val startIndex: Int = address.toNullable()?.index ?: 0\n                val blockchain = configuration.blockchain\n                val currencyCode = configuration.currencyCode\n\n                var index = startIndex\n                Observable.just(index)\n                    .concatMap {\n\n                        this\n                            .saveAddress(\n                                blockchain = blockchain,\n                                currencyCode = currencyCode,\n                                network = network,\n                                addressType = addressType,\n                                isChangeAddress = isChangeAddress,\n                                index = index,\n                                xpubKey = xpubKey,\n                                shouldSaveOnError = false\n                            )\n                            .map { isAddressUsed ->\n                                if (isAddressUsed) {\n                                    totalUnused = 0\n                                } else {\n                                    totalUnused++\n                                }\n                            }\n                            .onErrorResumeNext {\n                                throw it\n                            }\n                            .map { index += 1 }\n                            .toObservable()\n                    }\n                    .repeatUntil { totalUnused >= 20 }\n            }\n            .last(Unit)");
            return last;
        }
    }
}