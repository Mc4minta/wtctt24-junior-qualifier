package com.coinbase.wallet.consumer.apis;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.Coinbase;
import com.coinbase.CoinbaseResponse;
import com.coinbase.PagedResponse;
import com.coinbase.PaginationParams;
import com.coinbase.android.apiv3.V3Error;
import com.coinbase.android.apiv3.generated.authed.sends.PreviewSendAmountRequest;
import com.coinbase.android.apiv3.generated.authed.sends.PreviewSendAmountResponse;
import com.coinbase.android.apiv3.generated.authed.sends.Sends;
import com.coinbase.android.apiv3.generated.common.Amount;
import com.coinbase.android.apiv3.generated.common.Ref;
import com.coinbase.errors.CoinbaseException;
import com.coinbase.errors.Error;
import com.coinbase.errors.ErrorCodes;
import com.coinbase.network.adapter.NetworkResponse;
import com.coinbase.resources.accounts.Account;
import com.coinbase.resources.addresses.Address;
import com.coinbase.resources.auth.AccessToken;
import com.coinbase.resources.auth.RevokeTokenResponse;
import com.coinbase.resources.base.DynamicResource;
import com.coinbase.resources.prices.Price;
import com.coinbase.resources.transactions.Transaction;
import com.coinbase.resources.transactions.entities.CryptoAddress;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.common.annotations.AppCoreScoped;
import com.coinbase.wallet.common.extensions.BigDecimal_CommonKt;
import com.coinbase.wallet.consumer.apis.ConsumerAPIHttp;
import com.coinbase.wallet.consumer.dtos.BuyStatusWrapperDTO;
import com.coinbase.wallet.consumer.dtos.CompleteCDVRequestDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerAssetDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerAssetWrapperDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerAssetsWrapperDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerAvailablePaymentMethodDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerAvailablePaymentMethodResponseDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerBuyLimitDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerBuyLimitRemainingDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerBuyOrderRequestDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerBuyOrderResponseWrapperDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerBuyingPowerDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerCompleteBuyBodyDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerLimitsDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerPaymentMethodDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerPaymentMethodWrapperDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerPaymentResultsDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerSendFeeResponseDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerSendRequestDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerTxWrapperDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerUserResponseEnvelopeDTO;
import com.coinbase.wallet.consumer.dtos.PutConsumerWalletAddressRequestDTO;
import com.coinbase.wallet.consumer.exceptions.ConsumerException;
import com.coinbase.wallet.consumer.models.BuyStatus;
import com.coinbase.wallet.consumer.models.ConsumerAccount;
import com.coinbase.wallet.consumer.models.ConsumerAsset;
import com.coinbase.wallet.consumer.models.ConsumerAvailablePaymentMethod;
import com.coinbase.wallet.consumer.models.ConsumerBuyOrder;
import com.coinbase.wallet.consumer.models.ConsumerPaymentMethod;
import com.coinbase.wallet.consumer.models.ConsumerPaymentMethodType;
import com.coinbase.wallet.consumer.models.ConsumerSendFee;
import com.coinbase.wallet.consumer.models.ConsumerTx;
import com.coinbase.wallet.consumer.models.ConsumerUser;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.routing.models.RouteActionKey;
import h.c.h0;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.m0;

/* compiled from: ConsumerAPI.kt */
@AppCoreScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\f\u0010l\u001a\b\u0012\u0004\u0012\u00020k0j\u0012\u0006\u0010h\u001a\u00020g\u0012\u0006\u0010o\u001a\u00020n¢\u0006\u0004\bq\u0010rJ\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\r2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\r2\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\r¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\r¢\u0006\u0004\b\u001e\u0010\u001dJ\u001b\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b \u0010\u001aJ\u001b\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\r2\u0006\u0010!\u001a\u00020\u0004¢\u0006\u0004\b#\u0010\u001aJ\u001b\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\r2\u0006\u0010!\u001a\u00020\u0004¢\u0006\u0004\b$\u0010\u001aJ\u0019\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\b0\r¢\u0006\u0004\b&\u0010\u001dJ\u001b\u0010(\u001a\b\u0012\u0004\u0012\u00020%0\r2\u0006\u0010'\u001a\u00020\u0004¢\u0006\u0004\b(\u0010\u001aJ!\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\b0\r2\u0006\u0010)\u001a\u00020\u0004¢\u0006\u0004\b+\u0010\u001aJS\u00104\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u00100\u001a\u00020/2\n\b\u0002\u00102\u001a\u0004\u0018\u0001012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b4\u00105J9\u0010;\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020:090\r2\u0006\u0010)\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u00042\u0006\u00108\u001a\u000207¢\u0006\u0004\b;\u0010<J#\u0010@\u001a\b\u0012\u0004\u0012\u00020?0\r2\u0006\u0010>\u001a\u00020=2\u0006\u0010,\u001a\u00020\u0004¢\u0006\u0004\b@\u0010AJ\u001b\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00180\r2\u0006\u0010C\u001a\u00020B¢\u0006\u0004\bD\u0010EJ\u001b\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00180\r2\u0006\u0010F\u001a\u00020\u0004¢\u0006\u0004\bG\u0010\u001aJ'\u0010K\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020J0I0\r2\u0006\u0010H\u001a\u00020/¢\u0006\u0004\bK\u0010LJ'\u0010O\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020M N*\n\u0012\u0004\u0012\u00020M\u0018\u00010\b0\b0\r¢\u0006\u0004\bO\u0010\u001dJ\u0019\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020P0\b0\r¢\u0006\u0004\bQ\u0010\u001dJ#\u0010S\u001a\b\u0012\u0004\u0012\u00020R0\r2\u0006\u0010>\u001a\u00020=2\u0006\u0010-\u001a\u00020\u0004¢\u0006\u0004\bS\u0010AJ;\u0010W\u001a\b\u0012\u0004\u0012\u00020V0\r2\u0006\u0010)\u001a\u00020\u00042\u0006\u00100\u001a\u00020/2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010T\u001a\u00020\u00042\u0006\u0010U\u001a\u000201¢\u0006\u0004\bW\u0010XJ+\u0010[\u001a\u0010\u0012\f\u0012\n N*\u0004\u0018\u00010V0V0\r2\u0006\u0010Y\u001a\u00020=2\u0006\u0010Z\u001a\u00020\u0004¢\u0006\u0004\b[\u0010AJ+\u0010]\u001a\b\u0012\u0004\u0012\u00020V0\r2\u0006\u0010Y\u001a\u00020=2\u0006\u0010Z\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020\u0004¢\u0006\u0004\b]\u0010^J#\u0010a\u001a\b\u0012\u0004\u0012\u00020`0\r2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010_\u001a\u00020\u0004¢\u0006\u0004\ba\u0010bJ3\u0010e\u001a\u0010\u0012\f\u0012\n N*\u0004\u0018\u00010\u00180\u00180\r2\u0006\u0010T\u001a\u00020\u00042\u0006\u0010c\u001a\u00020\u00042\u0006\u0010d\u001a\u00020\u0004¢\u0006\u0004\be\u0010fR\u0016\u0010h\u001a\u00020g8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u001c\u0010l\u001a\b\u0012\u0004\u0012\u00020k0j8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010o\u001a\u00020n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010p¨\u0006s"}, d2 = {"Lcom/coinbase/wallet/consumer/apis/ConsumerAPI;", "", "", "throwable", "", "twoFactorId", "mapCoinbaseSendException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/lang/Throwable;", "", "Lcom/coinbase/resources/accounts/Account;", "accountList", "Lcom/coinbase/PagedResponse;", "pagedResponse", "Lh/c/b0;", "nextAccountPage", "(Ljava/util/List;Lcom/coinbase/PagedResponse;)Lh/c/b0;", "code", "clientId", "clientSecret", "redirectUri", "Lcom/coinbase/resources/auth/AccessToken;", "getAccessToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "accessToken", "Lkotlin/x;", "revokeAccessToken", "(Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/consumer/models/ConsumerUser;", "getUser", "()Lh/c/b0;", "getAccounts", "id", "getAccount", "accountID", "Lcom/coinbase/resources/addresses/Address;", "getAddress", "createAddress", "Lcom/coinbase/wallet/consumer/models/ConsumerAsset;", "getAssets", "assetID", "getAsset", "accountId", "Lcom/coinbase/wallet/consumer/models/ConsumerTx;", "getTransactions", "toAddress", "amount", "estimatedFee", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "", "noDestinationTag", "twoFactor", "send", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/Boolean;Ljava/lang/String;)Lh/c/b0;", "txId", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lkotlin/o;", "Lcom/coinbase/wallet/blockchains/models/TxState;", "getTxStatus", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Blockchain;)Lh/c/b0;", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "account", "Lcom/coinbase/wallet/consumer/models/ConsumerSendFee;", "getFeeEstimate", "(Lcom/coinbase/wallet/consumer/models/ConsumerAccount;Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/consumer/dtos/PutConsumerWalletAddressRequestDTO;", ApiConstants.ADDRESSES, "linkWalletAddresses", "(Lcom/coinbase/wallet/consumer/dtos/PutConsumerWalletAddressRequestDTO;)Lh/c/b0;", "userId", "deleteWalletAddresses", "fiatCurrency", "", "Ljava/math/BigDecimal;", "getExchangeRates", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;)Lh/c/b0;", "Lcom/coinbase/wallet/consumer/models/ConsumerAvailablePaymentMethod;", "kotlin.jvm.PlatformType", "availablePaymentMethods", "Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;", "paymentMethods", "Lcom/coinbase/android/apiv3/generated/authed/sends/PreviewSendAmountResponse;", "fundedSend", "paymentMethodId", "isTotal", "Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;", "buyQuote", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;Ljava/lang/String;Z)Lh/c/b0;", "consumerAccount", "orderId", "commitBuy", "redirectString", "completeBuyOrder", "(Lcom/coinbase/wallet/consumer/models/ConsumerAccount;Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "buyId", "Lcom/coinbase/wallet/consumer/models/BuyStatus;", "getCommitBuyStatus", "(Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "amount1", "amount2", "completeCardCDVVerification", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/consumer/apis/ConsumerAPIHttp;", "consumerAPI", "Lcom/coinbase/wallet/consumer/apis/ConsumerAPIHttp;", "Lf/a;", "Lcom/coinbase/Coinbase;", "coinbase", "Lf/a;", "Lcom/coinbase/android/apiv3/generated/authed/sends/Sends;", "sends", "Lcom/coinbase/android/apiv3/generated/authed/sends/Sends;", "<init>", "(Lf/a;Lcom/coinbase/wallet/consumer/apis/ConsumerAPIHttp;Lcom/coinbase/android/apiv3/generated/authed/sends/Sends;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAPI {
    private final f.a<Coinbase> coinbase;
    private final ConsumerAPIHttp consumerAPI;
    private final Sends sends;

    public ConsumerAPI(f.a<Coinbase> coinbase, ConsumerAPIHttp consumerAPI, Sends sends) {
        kotlin.jvm.internal.m.g(coinbase, "coinbase");
        kotlin.jvm.internal.m.g(consumerAPI, "consumerAPI");
        kotlin.jvm.internal.m.g(sends, "sends");
        this.coinbase = coinbase;
        this.consumerAPI = consumerAPI;
        this.sends = sends;
    }

    public static /* synthetic */ String A(ConsumerTxWrapperDTO consumerTxWrapperDTO) {
        return m851send$lambda13(consumerTxWrapperDTO);
    }

    public static /* synthetic */ h0 B(ConsumerAPI consumerAPI, List list, PagedResponse pagedResponse) {
        return m846nextAccountPage$lambda36(consumerAPI, list, pagedResponse);
    }

    public static /* synthetic */ List a(CoinbaseResponse coinbaseResponse) {
        return m838getExchangeRates$lambda18(coinbaseResponse);
    }

    /* renamed from: availablePaymentMethods$lambda-25 */
    public static final List m824availablePaymentMethods$lambda25(ConsumerAvailablePaymentMethodResponseDTO response) {
        int r;
        kotlin.jvm.internal.m.g(response, "response");
        List<ConsumerAvailablePaymentMethodDTO> availablePaymentMethods = response.getData().getAvailablePaymentMethods();
        r = kotlin.a0.s.r(availablePaymentMethods, 10);
        ArrayList arrayList = new ArrayList(r);
        for (ConsumerAvailablePaymentMethodDTO consumerAvailablePaymentMethodDTO : availablePaymentMethods) {
            ConsumerPaymentMethodType fromValueNullable = ConsumerPaymentMethodType.Companion.fromValueNullable(consumerAvailablePaymentMethodDTO.getType());
            if (fromValueNullable == null) {
                fromValueNullable = ConsumerPaymentMethodType.UNKNOWN;
            }
            ConsumerPaymentMethodType consumerPaymentMethodType = fromValueNullable;
            String name = consumerAvailablePaymentMethodDTO.getName();
            String description = consumerAvailablePaymentMethodDTO.getDescription();
            String additionalFees = consumerAvailablePaymentMethodDTO.getAdditionalFees();
            ConsumerBuyingPowerDTO buyingPower = consumerAvailablePaymentMethodDTO.getBuyingPower();
            String text = buyingPower == null ? null : buyingPower.getText();
            String buyTime = consumerAvailablePaymentMethodDTO.getBuyTime();
            List<String> supports = consumerAvailablePaymentMethodDTO.getSupports();
            if (supports == null) {
                supports = kotlin.a0.r.g();
            }
            arrayList.add(new ConsumerAvailablePaymentMethod(consumerPaymentMethodType, name, description, additionalFees, text, buyTime, supports));
        }
        return arrayList;
    }

    public static /* synthetic */ List b(PagedResponse pagedResponse) {
        return m843getTransactions$lambda9(pagedResponse);
    }

    /* renamed from: buyQuote$lambda-29 */
    public static final ConsumerBuyOrder m825buyQuote$lambda29(String paymentMethodId, ConsumerBuyOrderResponseWrapperDTO it) {
        kotlin.jvm.internal.m.g(paymentMethodId, "$paymentMethodId");
        kotlin.jvm.internal.m.g(it, "it");
        return it.getData().asConsumerBuyOrder(paymentMethodId);
    }

    /* renamed from: buyQuote$lambda-30 */
    public static final h0 m826buyQuote$lambda30(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        if (it instanceof CoinbaseException) {
            CoinbaseException coinbaseException = (CoinbaseException) it;
            List<Error> serverErrors = coinbaseException.getServerErrors();
            kotlin.jvm.internal.m.f(serverErrors, "it.serverErrors");
            if ((!serverErrors.isEmpty()) && kotlin.jvm.internal.m.c(coinbaseException.getServerErrors().get(0).getId(), "limit_error")) {
                it = ConsumerException.BuyOverLimit.INSTANCE;
            }
        }
        kotlin.jvm.internal.m.f(it, "when {\n                it !is CoinbaseException -> {\n                    it\n                }\n                it.serverErrors.isNotEmpty() && it.serverErrors[0].id == \"limit_error\" -> {\n                    ConsumerException.BuyOverLimit\n                }\n                else -> {\n                    it\n                }\n            }");
        return h.c.b0.error(it);
    }

    public static /* synthetic */ ConsumerUser c(ConsumerUserResponseEnvelopeDTO consumerUserResponseEnvelopeDTO) {
        return m845getUser$lambda0(consumerUserResponseEnvelopeDTO);
    }

    /* renamed from: commitBuy$lambda-31 */
    public static final ConsumerBuyOrder m827commitBuy$lambda31(ConsumerBuyOrderResponseWrapperDTO it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.getData().asConsumerBuyOrder(Strings_CoreKt.getEmpty(Strings.INSTANCE));
    }

    /* renamed from: completeBuyOrder$lambda-32 */
    public static final ConsumerBuyOrder m828completeBuyOrder$lambda32(ConsumerBuyOrderResponseWrapperDTO it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.getData().asConsumerBuyOrder(Strings_CoreKt.getEmpty(Strings.INSTANCE));
    }

    /* renamed from: completeCardCDVVerification$lambda-34 */
    public static final h0 m829completeCardCDVVerification$lambda34(Throwable throwable) {
        List<Error> serverErrors;
        Error error;
        kotlin.jvm.internal.m.g(throwable, "throwable");
        String str = null;
        CoinbaseException coinbaseException = throwable instanceof CoinbaseException ? (CoinbaseException) throwable : null;
        if (coinbaseException != null && (serverErrors = coinbaseException.getServerErrors()) != null && (error = serverErrors.get(0)) != null) {
            str = error.getMessage();
        }
        if (str == null) {
            str = throwable.getLocalizedMessage();
        }
        if (str != null) {
            return h.c.b0.error(new ConsumerException.CardVerifyException(str));
        }
        return h.c.b0.error(throwable);
    }

    /* renamed from: createAddress$lambda-4 */
    public static final Address m830createAddress$lambda4(CoinbaseResponse it) {
        kotlin.jvm.internal.m.g(it, "it");
        return (Address) it.getData();
    }

    public static /* synthetic */ h0 d(ConsumerAPI consumerAPI, PagedResponse pagedResponse) {
        return m833getAccounts$lambda1(consumerAPI, pagedResponse);
    }

    public static /* synthetic */ h0 e(Throwable th) {
        return m829completeCardCDVVerification$lambda34(th);
    }

    public static /* synthetic */ ConsumerBuyOrder f(ConsumerBuyOrderResponseWrapperDTO consumerBuyOrderResponseWrapperDTO) {
        return m828completeBuyOrder$lambda32(consumerBuyOrderResponseWrapperDTO);
    }

    /* renamed from: fundedSend$lambda-28 */
    public static final PreviewSendAmountResponse m831fundedSend$lambda28(NetworkResponse response) {
        kotlin.jvm.internal.m.g(response, "response");
        if (response instanceof NetworkResponse.Success) {
            return (PreviewSendAmountResponse) ((NetworkResponse.Success) response).getBody();
        }
        if (!(response instanceof NetworkResponse.NetworkError)) {
            if (response instanceof NetworkResponse.ServerError) {
                NetworkResponse.ServerError serverError = (NetworkResponse.ServerError) response;
                V3Error v3Error = (V3Error) serverError.getBody();
                String message = v3Error == null ? null : v3Error.getMessage();
                throw new ConsumerException.SendQuoteFailed("Failed with " + ((Object) message) + " status code " + serverError.getCode());
            }
            throw new NoWhenBranchMatchedException();
        }
        throw ((NetworkResponse.NetworkError) response).getError();
    }

    public static /* synthetic */ Address g(CoinbaseResponse coinbaseResponse) {
        return m830createAddress$lambda4(coinbaseResponse);
    }

    /* renamed from: getAccount$lambda-2 */
    public static final Account m832getAccount$lambda2(CoinbaseResponse it) {
        kotlin.jvm.internal.m.g(it, "it");
        return (Account) it.getData();
    }

    /* renamed from: getAccounts$lambda-1 */
    public static final h0 m833getAccounts$lambda1(ConsumerAPI this$0, PagedResponse it) {
        List<? extends Account> g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        g2 = kotlin.a0.r.g();
        return this$0.nextAccountPage(g2, it);
    }

    /* renamed from: getAddress$lambda-3 */
    public static final Address m834getAddress$lambda3(PagedResponse addresses) {
        kotlin.jvm.internal.m.g(addresses, "addresses");
        List data = addresses.getData();
        kotlin.jvm.internal.m.f(data, "addresses.data");
        Address address = (Address) kotlin.a0.p.a0(data);
        if (address != null) {
            return address;
        }
        throw ConsumerException.WalletAddressNotFound.INSTANCE;
    }

    /* renamed from: getAsset$lambda-7 */
    public static final ConsumerAsset m835getAsset$lambda7(ConsumerAssetWrapperDTO it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.getData().asModel();
    }

    /* renamed from: getAssets$lambda-6 */
    public static final List m836getAssets$lambda6(ConsumerAssetsWrapperDTO assets) {
        int r;
        kotlin.jvm.internal.m.g(assets, "assets");
        List<ConsumerAssetDTO> data = assets.getData();
        r = kotlin.a0.s.r(data, 10);
        ArrayList arrayList = new ArrayList(r);
        for (ConsumerAssetDTO consumerAssetDTO : data) {
            arrayList.add(consumerAssetDTO.asModel());
        }
        return arrayList;
    }

    /* renamed from: getCommitBuyStatus$lambda-33 */
    public static final BuyStatus m837getCommitBuyStatus$lambda33(BuyStatusWrapperDTO it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.getData().toBuyStatus();
    }

    /* renamed from: getExchangeRates$lambda-18 */
    public static final List m838getExchangeRates$lambda18(CoinbaseResponse it) {
        kotlin.jvm.internal.m.g(it, "it");
        return (List) it.getData();
    }

    /* renamed from: getExchangeRates$lambda-20 */
    public static final List m839getExchangeRates$lambda20(List it) {
        int r;
        kotlin.jvm.internal.m.g(it, "it");
        r = kotlin.a0.s.r(it, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it2 = it.iterator();
        while (it2.hasNext()) {
            Price price = (Price) it2.next();
            arrayList.add(kotlin.u.a(price.getBase(), new BigDecimal(price.getAmount())));
        }
        return arrayList;
    }

    /* renamed from: getExchangeRates$lambda-22 */
    public static final List m840getExchangeRates$lambda22(List it) {
        int r;
        kotlin.jvm.internal.m.g(it, "it");
        r = kotlin.a0.s.r(it, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it2 = it.iterator();
        while (it2.hasNext()) {
            kotlin.o oVar = (kotlin.o) it2.next();
            arrayList.add(kotlin.u.a((String) oVar.a(), BigDecimal.ONE.divide((BigDecimal) oVar.b(), MathContext.DECIMAL128)));
        }
        return arrayList;
    }

    /* renamed from: getExchangeRates$lambda-23 */
    public static final Map m841getExchangeRates$lambda23(List it) {
        Map r;
        kotlin.jvm.internal.m.g(it, "it");
        r = m0.r(it);
        return r;
    }

    /* renamed from: getFeeEstimate$lambda-17 */
    public static final ConsumerSendFee m842getFeeEstimate$lambda17(ConsumerAccount account, ConsumerSendFeeResponseDTO it) {
        kotlin.jvm.internal.m.g(account, "$account");
        kotlin.jvm.internal.m.g(it, "it");
        return new ConsumerSendFee(BigDecimal_CommonKt.asBigInteger(new BigDecimal(it.getData().getUserFee().getAmount()), account.getDecimals()));
    }

    /* renamed from: getTransactions$lambda-9 */
    public static final List m843getTransactions$lambda9(PagedResponse it) {
        kotlin.jvm.internal.m.g(it, "it");
        Iterable<Transaction> data = it.getData();
        kotlin.jvm.internal.m.f(data, "it.data");
        ArrayList arrayList = new ArrayList();
        for (Transaction transaction : data) {
            ConsumerTx consumerTx = null;
            if (kotlin.jvm.internal.m.c(transaction.getType(), "send") && (transaction.getTo() instanceof CryptoAddress)) {
                DynamicResource to = transaction.getTo();
                Objects.requireNonNull(to, "null cannot be cast to non-null type com.coinbase.resources.transactions.entities.CryptoAddress");
                CryptoAddress cryptoAddress = (CryptoAddress) to;
                if (cryptoAddress.getCurrency() != null) {
                    String address = cryptoAddress.getAddressInfo().getAddress();
                    kotlin.jvm.internal.m.f(address, "cryptoAddress.addressInfo.address");
                    String currency = cryptoAddress.getCurrency();
                    kotlin.jvm.internal.m.f(currency, "cryptoAddress.currency");
                    CurrencyCode currencyCode = new CurrencyCode(currency);
                    Date createdAt = transaction.getCreatedAt();
                    kotlin.jvm.internal.m.f(createdAt, "coinbaseTransaction.createdAt");
                    consumerTx = new ConsumerTx(address, currencyCode, createdAt);
                }
            }
            if (consumerTx != null) {
                arrayList.add(consumerTx);
            }
        }
        return arrayList;
    }

    /* renamed from: getTxStatus$lambda-16 */
    public static final kotlin.o m844getTxStatus$lambda16(Blockchain blockchain, CoinbaseResponse tx) {
        String hash;
        TxState txState;
        boolean Q;
        kotlin.jvm.internal.m.g(blockchain, "$blockchain");
        kotlin.jvm.internal.m.g(tx, "tx");
        TxState txState2 = null;
        try {
            Blockchain.Companion companion = Blockchain.Companion;
            if (kotlin.jvm.internal.m.c(blockchain, Blockchain_EthereumKt.getETHEREUM(companion)) ? true : kotlin.jvm.internal.m.c(blockchain, Blockchain_EthereumKt.getETHEREUM_CLASSIC(companion))) {
                hash = ((Transaction) tx.getData()).getNetwork().getHash();
                kotlin.jvm.internal.m.f(hash, "hash");
                Q = kotlin.l0.x.Q(hash, "0x", false, 2, null);
                if (!Q) {
                    hash = kotlin.jvm.internal.m.o("0x", hash);
                }
            } else {
                hash = ((Transaction) tx.getData()).getNetwork().getHash();
            }
        } catch (Exception unused) {
            hash = null;
        }
        try {
            String status = ((Transaction) tx.getData()).getStatus();
            if (status != null) {
                switch (status.hashCode()) {
                    case -1402931637:
                        if (status.equals("completed")) {
                            txState = TxState.CONFIRMED;
                            break;
                        } else {
                            txState = TxState.PENDING;
                            break;
                        }
                    case -1309235419:
                        if (!status.equals(Transaction.STATUS_EXPIRED)) {
                            txState = TxState.PENDING;
                            break;
                        }
                        txState = TxState.FAILED;
                        break;
                    case -1281977283:
                        if (!status.equals(Transaction.STATUS_FAILED)) {
                            txState = TxState.PENDING;
                            break;
                        }
                        txState = TxState.FAILED;
                        break;
                    case -682587753:
                        if (status.equals("pending")) {
                            txState = TxState.PENDING;
                            break;
                        } else {
                            txState = TxState.PENDING;
                            break;
                        }
                    case -123173735:
                        if (!status.equals("canceled")) {
                            txState = TxState.PENDING;
                            break;
                        }
                        txState = TxState.FAILED;
                        break;
                    default:
                        txState = TxState.PENDING;
                        break;
                }
                txState2 = txState;
            }
            if (txState2 == null) {
                txState2 = TxState.PENDING;
            }
        } catch (Exception unused2) {
            txState2 = TxState.PENDING;
        }
        return kotlin.u.a(hash, txState2);
    }

    /* renamed from: getUser$lambda-0 */
    public static final ConsumerUser m845getUser$lambda0(ConsumerUserResponseEnvelopeDTO it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.getData().getToConsumerUserModel();
    }

    public static /* synthetic */ h0 h(ConsumerAPI consumerAPI, Throwable th) {
        return m850send$lambda12(consumerAPI, th);
    }

    public static /* synthetic */ List i(List list) {
        return m840getExchangeRates$lambda22(list);
    }

    public static /* synthetic */ ConsumerAsset j(ConsumerAssetWrapperDTO consumerAssetWrapperDTO) {
        return m835getAsset$lambda7(consumerAssetWrapperDTO);
    }

    public static /* synthetic */ String k(ConsumerTxWrapperDTO consumerTxWrapperDTO) {
        return m849send$lambda11(consumerTxWrapperDTO);
    }

    public static /* synthetic */ PreviewSendAmountResponse l(NetworkResponse networkResponse) {
        return m831fundedSend$lambda28(networkResponse);
    }

    public static /* synthetic */ ConsumerBuyOrder m(ConsumerBuyOrderResponseWrapperDTO consumerBuyOrderResponseWrapperDTO) {
        return m827commitBuy$lambda31(consumerBuyOrderResponseWrapperDTO);
    }

    private final Throwable mapCoinbaseSendException(Throwable th, String str) {
        if (th instanceof CoinbaseException) {
            CoinbaseException coinbaseException = (CoinbaseException) th;
            List<Error> serverErrors = coinbaseException.getServerErrors();
            kotlin.jvm.internal.m.f(serverErrors, "throwable.serverErrors");
            if ((!serverErrors.isEmpty()) && kotlin.jvm.internal.m.c(coinbaseException.getServerErrors().get(0).getId(), str)) {
                return ConsumerException.SendNeedsTwoFactor.INSTANCE;
            }
            if (coinbaseException.getServerErrors().isEmpty() || coinbaseException.getServerErrors().get(0).getMessage() == null) {
                return th;
            }
            String message = coinbaseException.getServerErrors().get(0).getMessage();
            ConsumerException.KnownConsumerException knownConsumerException = message == null ? null : new ConsumerException.KnownConsumerException(message, th);
            return knownConsumerException == null ? (Exception) th : knownConsumerException;
        }
        return th;
    }

    public static /* synthetic */ h0 n(ConsumerAPI consumerAPI, Throwable th) {
        return m848send$lambda10(consumerAPI, th);
    }

    private final h.c.b0<List<Account>> nextAccountPage(List<? extends Account> list, PagedResponse<Account> pagedResponse) {
        final List t0;
        PaginationParams nextPage = PaginationParams.nextPage(pagedResponse.getPagination());
        Account data = pagedResponse.getData();
        kotlin.jvm.internal.m.f(data, "pagedResponse.data");
        t0 = kotlin.a0.z.t0(list, (Iterable) data);
        if (nextPage == null) {
            h.c.b0<List<Account>> just = h.c.b0.just(t0);
            kotlin.jvm.internal.m.f(just, "{\n            Single.just(updatedAccounts)\n        }");
            return just;
        }
        h.c.b0 flatMap = this.coinbase.get().getAccountResource().getAccountsRx(nextPage).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.b0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.B(ConsumerAPI.this, t0, (PagedResponse) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "{\n            coinbase.get().accountResource.getAccountsRx(nextPage)\n                .flatMap { nextAccountPage(updatedAccounts, it) }\n        }");
        return flatMap;
    }

    /* renamed from: nextAccountPage$lambda-36 */
    public static final h0 m846nextAccountPage$lambda36(ConsumerAPI this$0, List updatedAccounts, PagedResponse it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(updatedAccounts, "$updatedAccounts");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.nextAccountPage(updatedAccounts, it);
    }

    public static /* synthetic */ List o(List list) {
        return m839getExchangeRates$lambda20(list);
    }

    public static /* synthetic */ List p(ConsumerAssetsWrapperDTO consumerAssetsWrapperDTO) {
        return m836getAssets$lambda6(consumerAssetsWrapperDTO);
    }

    /* renamed from: paymentMethods$lambda-27 */
    public static final List m847paymentMethods$lambda27(ConsumerPaymentMethodWrapperDTO response) {
        int r;
        List<ConsumerBuyLimitDTO> buy;
        ConsumerBuyLimitDTO consumerBuyLimitDTO;
        ConsumerBuyLimitRemainingDTO remaining;
        String amount;
        kotlin.jvm.internal.m.g(response, "response");
        List<ConsumerPaymentMethodDTO> data = response.getData();
        r = kotlin.a0.s.r(data, 10);
        ArrayList arrayList = new ArrayList(r);
        for (ConsumerPaymentMethodDTO consumerPaymentMethodDTO : data) {
            String id = consumerPaymentMethodDTO.getId();
            String type = consumerPaymentMethodDTO.getType();
            String name = consumerPaymentMethodDTO.getName();
            CurrencyCode currencyCode = new CurrencyCode(consumerPaymentMethodDTO.getCurrency());
            boolean allow_buy = consumerPaymentMethodDTO.getAllow_buy();
            boolean allow_sell = consumerPaymentMethodDTO.getAllow_sell();
            boolean instant_buy = consumerPaymentMethodDTO.getInstant_buy();
            ConsumerLimitsDTO limits = consumerPaymentMethodDTO.getLimits();
            BigDecimal bigDecimal = null;
            if (limits != null && (buy = limits.getBuy()) != null && (consumerBuyLimitDTO = (ConsumerBuyLimitDTO) kotlin.a0.p.a0(buy)) != null && (remaining = consumerBuyLimitDTO.getRemaining()) != null && (amount = remaining.getAmount()) != null) {
                bigDecimal = kotlin.l0.v.j(amount);
            }
            if (bigDecimal == null) {
                bigDecimal = BigDecimal.ZERO;
            }
            kotlin.jvm.internal.m.f(bigDecimal, "paymentMethod.limits?.buy?.firstOrNull()?.remaining?.amount?.toBigDecimalOrNull()\n                        ?: BigDecimal.ZERO");
            arrayList.add(new ConsumerPaymentMethod(id, type, name, currencyCode, allow_buy, allow_sell, instant_buy, bigDecimal, consumerPaymentMethodDTO.getVerified()));
        }
        return arrayList;
    }

    public static /* synthetic */ BuyStatus q(BuyStatusWrapperDTO buyStatusWrapperDTO) {
        return m837getCommitBuyStatus$lambda33(buyStatusWrapperDTO);
    }

    public static /* synthetic */ kotlin.o r(Blockchain blockchain, CoinbaseResponse coinbaseResponse) {
        return m844getTxStatus$lambda16(blockchain, coinbaseResponse);
    }

    public static /* synthetic */ Address s(PagedResponse pagedResponse) {
        return m834getAddress$lambda3(pagedResponse);
    }

    /* renamed from: send$lambda-10 */
    public static final h0 m848send$lambda10(ConsumerAPI this$0, Throwable throwable) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(throwable, "throwable");
        return h.c.b0.error(this$0.mapCoinbaseSendException(throwable, ErrorCodes.TWO_FACTOR_REQUIRED));
    }

    /* renamed from: send$lambda-11 */
    public static final String m849send$lambda11(ConsumerTxWrapperDTO it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.getData().getId();
    }

    /* renamed from: send$lambda-12 */
    public static final h0 m850send$lambda12(ConsumerAPI this$0, Throwable throwable) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(throwable, "throwable");
        return h.c.b0.error(this$0.mapCoinbaseSendException(throwable, ErrorCodes.INVALID_REQUEST));
    }

    /* renamed from: send$lambda-13 */
    public static final String m851send$lambda13(ConsumerTxWrapperDTO it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.getData().getId();
    }

    public static /* synthetic */ h0 t(Throwable th) {
        return m826buyQuote$lambda30(th);
    }

    public static /* synthetic */ ConsumerBuyOrder u(String str, ConsumerBuyOrderResponseWrapperDTO consumerBuyOrderResponseWrapperDTO) {
        return m825buyQuote$lambda29(str, consumerBuyOrderResponseWrapperDTO);
    }

    public static /* synthetic */ Map v(List list) {
        return m841getExchangeRates$lambda23(list);
    }

    public static /* synthetic */ Account w(CoinbaseResponse coinbaseResponse) {
        return m832getAccount$lambda2(coinbaseResponse);
    }

    public static /* synthetic */ ConsumerSendFee x(ConsumerAccount consumerAccount, ConsumerSendFeeResponseDTO consumerSendFeeResponseDTO) {
        return m842getFeeEstimate$lambda17(consumerAccount, consumerSendFeeResponseDTO);
    }

    public static /* synthetic */ List y(ConsumerPaymentMethodWrapperDTO consumerPaymentMethodWrapperDTO) {
        return m847paymentMethods$lambda27(consumerPaymentMethodWrapperDTO);
    }

    public static /* synthetic */ List z(ConsumerAvailablePaymentMethodResponseDTO consumerAvailablePaymentMethodResponseDTO) {
        return m824availablePaymentMethods$lambda25(consumerAvailablePaymentMethodResponseDTO);
    }

    public final h.c.b0<List<ConsumerAvailablePaymentMethod>> availablePaymentMethods() {
        h.c.b0 map = this.consumerAPI.availablePaymentMethods().map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.z
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.z((ConsumerAvailablePaymentMethodResponseDTO) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "consumerAPI.availablePaymentMethods()\n        .map { response ->\n            response.data.availablePaymentMethods.map { paymentMethod ->\n                val type = ConsumerPaymentMethodType.fromValueNullable(paymentMethod.type)\n                    ?: ConsumerPaymentMethodType.UNKNOWN\n\n                ConsumerAvailablePaymentMethod(\n                    type = type,\n                    name = paymentMethod.name,\n                    description = paymentMethod.description,\n                    additionalFees = paymentMethod.additionalFees,\n                    buyingPower = paymentMethod.buyingPower?.text,\n                    buyTime = paymentMethod.buyTime,\n                    supports = paymentMethod.supports ?: emptyList()\n                )\n            }\n        }");
        return map;
    }

    public final h.c.b0<ConsumerBuyOrder> buyQuote(String accountId, CurrencyCode currencyCode, String amount, final String paymentMethodId, boolean z) {
        kotlin.jvm.internal.m.g(accountId, "accountId");
        kotlin.jvm.internal.m.g(currencyCode, "currencyCode");
        kotlin.jvm.internal.m.g(amount, "amount");
        kotlin.jvm.internal.m.g(paymentMethodId, "paymentMethodId");
        h.c.b0<ConsumerBuyOrder> onErrorResumeNext = this.consumerAPI.buyAssets(accountId, new ConsumerBuyOrderRequestDTO(currencyCode.getCode(), false, Boolean.FALSE, z ? null : amount, z ? amount : null, paymentMethodId, null, 64, null)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.u
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.u(paymentMethodId, (ConsumerBuyOrderResponseWrapperDTO) obj);
            }
        }).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.t
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.t((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorResumeNext, "consumerAPI\n        .buyAssets(\n            accountId,\n            ConsumerBuyOrderRequestDTO(\n                currency = currencyCode.code,\n                commit = false,\n                quote = false,\n                amount = if (isTotal) null else amount,\n                total = if (isTotal) amount else null,\n                paymentMethod = paymentMethodId\n            )\n        )\n        .map { it.data.asConsumerBuyOrder(paymentMethodID = paymentMethodId) }\n        .onErrorResumeNext {\n            val mappedThrowable = when {\n                it !is CoinbaseException -> {\n                    it\n                }\n                it.serverErrors.isNotEmpty() && it.serverErrors[0].id == \"limit_error\" -> {\n                    ConsumerException.BuyOverLimit\n                }\n                else -> {\n                    it\n                }\n            }\n            Single.error(mappedThrowable)\n        }");
        return onErrorResumeNext;
    }

    public final h.c.b0<ConsumerBuyOrder> commitBuy(ConsumerAccount consumerAccount, String orderId) {
        kotlin.jvm.internal.m.g(consumerAccount, "consumerAccount");
        kotlin.jvm.internal.m.g(orderId, "orderId");
        h.c.b0 map = this.consumerAPI.commitBuyAssets(consumerAccount.getId(), orderId).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.m((ConsumerBuyOrderResponseWrapperDTO) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "consumerAPI.commitBuyAssets(consumerAccount.id, orderId)\n        .map {\n            // TODO : Alex - pass in valid payment method id (if we need it)\n            it.data.asConsumerBuyOrder(Strings.empty)\n        }");
        return map;
    }

    public final h.c.b0<ConsumerBuyOrder> completeBuyOrder(ConsumerAccount consumerAccount, String orderId, String redirectString) {
        kotlin.jvm.internal.m.g(consumerAccount, "consumerAccount");
        kotlin.jvm.internal.m.g(orderId, "orderId");
        kotlin.jvm.internal.m.g(redirectString, "redirectString");
        h.c.b0 map = this.consumerAPI.completeBuyAssets(consumerAccount.getId(), orderId, new ConsumerCompleteBuyBodyDTO(new ConsumerPaymentResultsDTO(redirectString))).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.f((ConsumerBuyOrderResponseWrapperDTO) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "consumerAPI\n            .completeBuyAssets(\n                accountId = consumerAccount.id,\n                buyId = orderId,\n                body = ConsumerCompleteBuyBodyDTO((ConsumerPaymentResultsDTO(redirectString)))\n            )\n            .map {\n                // TODO : Alex - pass in valid payment method id (if we need it)\n                it.data.asConsumerBuyOrder(Strings.empty)\n            }");
        return map;
    }

    public final h.c.b0<kotlin.x> completeCardCDVVerification(String paymentMethodId, String amount1, String amount2) {
        kotlin.jvm.internal.m.g(paymentMethodId, "paymentMethodId");
        kotlin.jvm.internal.m.g(amount1, "amount1");
        kotlin.jvm.internal.m.g(amount2, "amount2");
        h.c.b0<kotlin.x> onErrorResumeNext = this.consumerAPI.completeCardCDVVerification(paymentMethodId, new CompleteCDVRequestDTO(amount1, amount2, null, 4, null)).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.e((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorResumeNext, "consumerAPI.completeCardCDVVerification(paymentMethodId, CompleteCDVRequestDTO(amount1, amount2))\n        .onErrorResumeNext { throwable ->\n            val verifyErrorMessage = (throwable as? CoinbaseException)?.serverErrors?.get(0)?.message\n                ?: throwable.localizedMessage\n\n            if (verifyErrorMessage != null) {\n                Single.error(ConsumerException.CardVerifyException(verifyErrorMessage))\n            } else {\n                Single.error(throwable)\n            }\n        }");
        return onErrorResumeNext;
    }

    public final h.c.b0<Address> createAddress(String accountID) {
        kotlin.jvm.internal.m.g(accountID, "accountID");
        h.c.b0 map = this.coinbase.get().getAddressResource().generateAddressRx(accountID, Strings_CoreKt.getEmpty(Strings.INSTANCE)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.g((CoinbaseResponse) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "coinbase.get().addressResource.generateAddressRx(accountID, Strings.empty)\n        .map { it.data }");
        return map;
    }

    public final h.c.b0<kotlin.x> deleteWalletAddresses(String userId) {
        kotlin.jvm.internal.m.g(userId, "userId");
        return this.consumerAPI.deleteWalletAddresses(userId);
    }

    public final h.c.b0<PreviewSendAmountResponse> fundedSend(ConsumerAccount account, String amount) {
        kotlin.jvm.internal.m.g(account, "account");
        kotlin.jvm.internal.m.g(amount, "amount");
        h.c.b0 map = this.sends.previewSendAmount(new PreviewSendAmountRequest(new Amount(amount, account.getCurrencyCode().getCode(), null, 4, null), new Ref(account.getId(), null, 2, null), null, 4, null)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.l
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.l((NetworkResponse) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "sends.previewSendAmount(\n        PreviewSendAmountRequest(\n            Amount(amount, account.currencyCode.code),\n            Ref(account.id)\n        )\n    )\n        .map { response ->\n            when (response) {\n                is NetworkResponse.Success -> response.body\n                is NetworkResponse.NetworkError -> throw response.error\n                is NetworkResponse.ServerError -> {\n                    val errorMessage = response.body?.message\n                    throw ConsumerException.SendQuoteFailed(\"Failed with $errorMessage status code ${response.code}\")\n                }\n            }\n        }");
        return map;
    }

    public final h.c.b0<AccessToken> getAccessToken(String code, String clientId, String clientSecret, String redirectUri) {
        kotlin.jvm.internal.m.g(code, "code");
        kotlin.jvm.internal.m.g(clientId, "clientId");
        kotlin.jvm.internal.m.g(clientSecret, "clientSecret");
        kotlin.jvm.internal.m.g(redirectUri, "redirectUri");
        h.c.b0<AccessToken> tokensRx = this.coinbase.get().getAuthResource().getTokensRx(clientId, clientSecret, code, redirectUri);
        kotlin.jvm.internal.m.f(tokensRx, "coinbase.get().authResource.getTokensRx(clientId, clientSecret, code, redirectUri)");
        return tokensRx;
    }

    public final h.c.b0<Account> getAccount(String id) {
        kotlin.jvm.internal.m.g(id, "id");
        h.c.b0 map = this.coinbase.get().getAccountResource().showAccountRx(id).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.w
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.w((CoinbaseResponse) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "coinbase.get().accountResource.showAccountRx(id).map { it.data }");
        return map;
    }

    public final h.c.b0<List<Account>> getAccounts() {
        h.c.b0 flatMap = this.coinbase.get().getAccountResource().getAccountsRx().flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.d(ConsumerAPI.this, (PagedResponse) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "coinbase.get().accountResource.accountsRx\n            .flatMap { nextAccountPage(emptyList(), it) }");
        return flatMap;
    }

    public final h.c.b0<Address> getAddress(String accountID) {
        kotlin.jvm.internal.m.g(accountID, "accountID");
        h.c.b0 map = this.coinbase.get().getAddressResource().listAddressesRx(accountID).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.s
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.s((PagedResponse) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "coinbase.get().addressResource.listAddressesRx(accountID)\n        .map { addresses ->\n            addresses.data.firstOrNull() ?: throw ConsumerException.WalletAddressNotFound\n        }");
        return map;
    }

    public final h.c.b0<ConsumerAsset> getAsset(String assetID) {
        kotlin.jvm.internal.m.g(assetID, "assetID");
        h.c.b0 map = this.consumerAPI.getAssetInfo(assetID).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.j((ConsumerAssetWrapperDTO) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "consumerAPI.getAssetInfo(assetID).map { it.data.asModel() }");
        return map;
    }

    public final h.c.b0<List<ConsumerAsset>> getAssets() {
        h.c.b0 map = this.consumerAPI.getAssets("top_50").map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.p
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.p((ConsumerAssetsWrapperDTO) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "consumerAPI\n            .getAssets(\"top_50\")\n            .map { assets -> assets.data.map { it.asModel() } }");
        return map;
    }

    public final h.c.b0<BuyStatus> getCommitBuyStatus(String accountId, String buyId) {
        kotlin.jvm.internal.m.g(accountId, "accountId");
        kotlin.jvm.internal.m.g(buyId, "buyId");
        h.c.b0 map = this.consumerAPI.getCommitBuyStatus(accountId, buyId).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.q
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.q((BuyStatusWrapperDTO) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "consumerAPI.getCommitBuyStatus(accountId, buyId)\n        .map { it.data.toBuyStatus() }");
        return map;
    }

    public final h.c.b0<Map<String, BigDecimal>> getExchangeRates(CurrencyCode fiatCurrency) {
        kotlin.jvm.internal.m.g(fiatCurrency, "fiatCurrency");
        h.c.b0<Map<String, BigDecimal>> map = this.coinbase.get().getPricesResource().getSpotPricesRx(fiatCurrency.getCode()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.a((CoinbaseResponse) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.o
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.o((List) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.i((List) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.v
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.v((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "coinbase.get()\n        .pricesResource\n        .getSpotPricesRx(fiatCurrency.code)\n        .map { it.data }\n        .map { it.map { price -> price.base to BigDecimal(price.amount) } }\n        .map { it.map { (currency, amount) -> currency to BigDecimal.ONE.divide(amount, MathContext.DECIMAL128) } }\n        .map { it.toMap() }");
        return map;
    }

    public final h.c.b0<ConsumerSendFee> getFeeEstimate(final ConsumerAccount account, String toAddress) {
        kotlin.jvm.internal.m.g(account, "account");
        kotlin.jvm.internal.m.g(toAddress, "toAddress");
        h.c.b0 map = this.consumerAPI.getFeeEstimate(account.getId(), toAddress).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.x
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.x(ConsumerAccount.this, (ConsumerSendFeeResponseDTO) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "consumerAPI\n        .getFeeEstimate(account.id, toAddress)\n        .map {\n            val fee = BigDecimal(it.data.userFee.amount).asBigInteger(account.decimals)\n            ConsumerSendFee(amount = fee)\n        }");
        return map;
    }

    public final h.c.b0<List<ConsumerTx>> getTransactions(String accountId) {
        kotlin.jvm.internal.m.g(accountId, "accountId");
        h.c.b0 map = this.coinbase.get().getTransactionsResource().listTransactionsRx(accountId, new Transaction.ExpandField[0]).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.b((PagedResponse) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "coinbase.get()\n        .transactionsResource\n        .listTransactionsRx(accountId)\n        .map {\n            it.data.mapNotNull { coinbaseTransaction ->\n                if (coinbaseTransaction.type != Transaction.TYPE_SEND || coinbaseTransaction.to !is CryptoAddress) {\n                    return@mapNotNull null\n                }\n\n                val cryptoAddress = coinbaseTransaction.to as CryptoAddress\n                if (cryptoAddress.currency == null) {\n                    null\n                } else {\n                    ConsumerTx(\n                        toAddress = cryptoAddress.addressInfo.address,\n                        currencyCode = CurrencyCode(cryptoAddress.currency),\n                        createdAt = coinbaseTransaction.createdAt\n                    )\n                }\n            }\n        }");
        return map;
    }

    public final h.c.b0<kotlin.o<String, TxState>> getTxStatus(String accountId, String txId, final Blockchain blockchain) {
        kotlin.jvm.internal.m.g(accountId, "accountId");
        kotlin.jvm.internal.m.g(txId, "txId");
        kotlin.jvm.internal.m.g(blockchain, "blockchain");
        h.c.b0<R> map = this.coinbase.get().getTransactionsResource().showTransactionRx(accountId, txId, Transaction.ExpandField.FROM).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.r
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.r(Blockchain.this, (CoinbaseResponse) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "coinbase.get().transactionsResource.showTransactionRx(accountId, txId, Transaction.ExpandField.FROM)\n            .map { tx ->\n                val hash = try {\n                    when (blockchain) {\n                        Blockchain.ETHEREUM,\n                        Blockchain.ETHEREUM_CLASSIC -> {\n                            tx.data.network.hash.let { hash -> if (!hash.startsWith(\"0x\")) \"0x$hash\" else hash }\n                        }\n                        else -> {\n                            tx.data.network.hash\n                        }\n                    }\n                } catch (e: Exception) {\n                    null\n                }\n                val state = try {\n                    tx.data.status?.let { status ->\n                        when (status) {\n                            Transaction.STATUS_PENDING -> TxState.PENDING\n                            Transaction.STATUS_COMPLETED -> TxState.CONFIRMED\n                            Transaction.STATUS_FAILED,\n                            Transaction.STATUS_EXPIRED,\n                            Transaction.STATUS_CANCELED -> TxState.FAILED\n                            else -> TxState.PENDING\n                        }\n                    } ?: TxState.PENDING\n                } catch (e: Exception) {\n                    TxState.PENDING\n                }\n\n                hash to state\n            }");
        return Single_AnalyticsKt.logError$default(map, null, null, 3, null);
    }

    public final h.c.b0<ConsumerUser> getUser() {
        h.c.b0 map = this.consumerAPI.getCurrentUser(true).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.c((ConsumerUserResponseEnvelopeDTO) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "consumerAPI.getCurrentUser(true)\n        .map { it.data.toConsumerUserModel }");
        return map;
    }

    public final h.c.b0<kotlin.x> linkWalletAddresses(PutConsumerWalletAddressRequestDTO addresses) {
        kotlin.jvm.internal.m.g(addresses, "addresses");
        return this.consumerAPI.updateWalletAddresses(addresses);
    }

    public final h.c.b0<List<ConsumerPaymentMethod>> paymentMethods() {
        h.c.b0 map = this.consumerAPI.paymentMethods().map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.y
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.y((ConsumerPaymentMethodWrapperDTO) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "consumerAPI.paymentMethods()\n        .map { response ->\n            response.data.map { paymentMethod ->\n                ConsumerPaymentMethod(\n                    id = paymentMethod.id,\n                    type = paymentMethod.type,\n                    name = paymentMethod.name,\n                    currencyCode = CurrencyCode(paymentMethod.currency),\n                    allowBuy = paymentMethod.allow_buy,\n                    allowSell = paymentMethod.allow_sell,\n                    instantBuy = paymentMethod.instant_buy,\n                    buyLimit = paymentMethod.limits?.buy?.firstOrNull()?.remaining?.amount?.toBigDecimalOrNull()\n                        ?: BigDecimal.ZERO,\n                    verified = paymentMethod.verified\n                )\n            }\n        }");
        return map;
    }

    public final h.c.b0<kotlin.x> revokeAccessToken(String accessToken) {
        kotlin.jvm.internal.m.g(accessToken, "accessToken");
        h.c.b0<RevokeTokenResponse> revokeTokenRx = this.coinbase.get().getAuthResource().revokeTokenRx(accessToken);
        kotlin.jvm.internal.m.f(revokeTokenRx, "coinbase.get().authResource.revokeTokenRx(accessToken)");
        return Single_CoreKt.asUnit(revokeTokenRx);
    }

    public final h.c.b0<String> send(String accountId, String toAddress, String amount, String estimatedFee, CurrencyCode currencyCode, Boolean bool, String str) {
        kotlin.jvm.internal.m.g(accountId, "accountId");
        kotlin.jvm.internal.m.g(toAddress, "toAddress");
        kotlin.jvm.internal.m.g(amount, "amount");
        kotlin.jvm.internal.m.g(estimatedFee, "estimatedFee");
        kotlin.jvm.internal.m.g(currencyCode, "currencyCode");
        ConsumerSendRequestDTO consumerSendRequestDTO = new ConsumerSendRequestDTO(amount, estimatedFee, null, null, currencyCode.getCode(), toAddress, null, 76, null);
        if (str == null) {
            h.c.b0<String> map = ConsumerAPIHttp.DefaultImpls.send$default(this.consumerAPI, accountId, consumerSendRequestDTO, bool, false, 8, null).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.n
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ConsumerAPI.n(ConsumerAPI.this, (Throwable) obj);
                }
            }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.k
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ConsumerAPI.k((ConsumerTxWrapperDTO) obj);
                }
            });
            kotlin.jvm.internal.m.f(map, "{\n            consumerAPI.send(accountId, sendRequest, noDestinationTag)\n                .onErrorResumeNext { throwable ->\n                    Single.error(mapCoinbaseSendException(throwable, \"two_factor_required\"))\n                }\n                .map { it.data.id }\n        }");
            return map;
        }
        h.c.b0<String> map2 = ConsumerAPIHttp.DefaultImpls.sendWith2fa$default(this.consumerAPI, accountId, str, consumerSendRequestDTO, bool, false, 16, null).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.h(ConsumerAPI.this, (Throwable) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.apis.a0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAPI.A((ConsumerTxWrapperDTO) obj);
            }
        });
        kotlin.jvm.internal.m.f(map2, "{\n            consumerAPI.sendWith2fa(accountId, twoFactor, sendRequest, noDestinationTag)\n                .onErrorResumeNext { throwable ->\n                    Single.error(mapCoinbaseSendException(throwable, \"invalid_request\"))\n                }\n                .map { it.data.id }\n        }");
        return map2;
    }
}