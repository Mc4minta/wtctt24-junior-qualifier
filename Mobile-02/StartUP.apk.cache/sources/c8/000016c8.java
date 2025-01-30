package com.coinbase.wallet.consumer.repositories;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.authed.sends.PreviewSendAmountResponse;
import com.coinbase.android.apiv3.generated.authed.sends.SendPaymentMethod;
import com.coinbase.android.apiv3.generated.common.Amount;
import com.coinbase.android.apiv3.generated.resources.PaymentMethod;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.errors.CoinbaseException;
import com.coinbase.resources.accounts.Account;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.blockchains.exceptions.NetworkException;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.Transaction;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.TxMetadata;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.common.extensions.BigDecimal_CommonKt;
import com.coinbase.wallet.common.extensions.BigInteger_CommonKt;
import com.coinbase.wallet.common.extensions.Network_CommonKt;
import com.coinbase.wallet.common.models.RefreshState;
import com.coinbase.wallet.consumer.apis.ConsumerAPI;
import com.coinbase.wallet.consumer.daos.ConsumerAvailablePaymentMethodsDAO;
import com.coinbase.wallet.consumer.daos.ConsumerPaymentMethodsDAO;
import com.coinbase.wallet.consumer.exceptions.ConsumerException;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.extensions.TxMetadataKey_ConsumerConnectKt;
import com.coinbase.wallet.consumer.models.AvailableBuyAndSendTransfer;
import com.coinbase.wallet.consumer.models.AvailableSendTransfer;
import com.coinbase.wallet.consumer.models.AvailableTransfer;
import com.coinbase.wallet.consumer.models.BuyStatus;
import com.coinbase.wallet.consumer.models.ConsumerAccount;
import com.coinbase.wallet.consumer.models.ConsumerAsset;
import com.coinbase.wallet.consumer.models.ConsumerAvailablePaymentMethod;
import com.coinbase.wallet.consumer.models.ConsumerAvailableTransferContainer;
import com.coinbase.wallet.consumer.models.ConsumerBuyOrder;
import com.coinbase.wallet.consumer.models.ConsumerConnectionStatus;
import com.coinbase.wallet.consumer.models.ConsumerPaymentMethod;
import com.coinbase.wallet.consumer.models.ConsumerPaymentMethodType;
import com.coinbase.wallet.consumer.models.ConsumerSendFee;
import com.coinbase.wallet.consumer.models.ConsumerTx;
import com.coinbase.wallet.consumer.models.ConsumerUser;
import com.coinbase.wallet.consumer.models.ReceivableWallet;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.extensions.Singles_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.core.interfaces.Refreshable;
import com.coinbase.wallet.core.models.Four;
import com.coinbase.wallet.core.util.AssertionException;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.EthereumChain_EthereumKt;
import com.coinbase.wallet.ethereum.interfaces.IETHWalletRepository;
import com.coinbase.wallet.featureflags.models.FeatureFlag;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: ConsumerTransferRepository.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ö\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B_\b\u0007\u0012\b\u0010\u009f\u0001\u001a\u00030\u009e\u0001\u0012\b\u0010\u0087\u0001\u001a\u00030\u0086\u0001\u0012\u0006\u0010h\u001a\u00020g\u0012\b\u0010\u0084\u0001\u001a\u00030\u0083\u0001\u0012\b\u0010\u009c\u0001\u001a\u00030\u009b\u0001\u0012\b\u0010\u008a\u0001\u001a\u00030\u0089\u0001\u0012\u0006\u0010s\u001a\u00020r\u0012\u0006\u0010z\u001a\u00020y\u0012\b\u0010\u0093\u0001\u001a\u00030\u0092\u0001¢\u0006\u0006\b \u0001\u0010¡\u0001J9\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJs\u0010\u001d\u001a(\u0012$\u0012\"\u0012\u001e\u0012\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0004\u0012\u00020\u000f0\u0019j\u0002`\u001c0\b0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ]\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u000e2&\u0010\u001f\u001a\"\u0012\u001e\u0012\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0004\u0012\u00020\u000f0\u0019j\u0002`\u001c0\u000e2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b!\u0010\"JC\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0'0\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0017H\u0002¢\u0006\u0004\b(\u0010)J'\u0010/\u001a\u00020.2\u0006\u0010*\u001a\u00020\u00012\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u0017H\u0002¢\u0006\u0004\b/\u00100J#\u00103\u001a\u000202*\u00020\u000b2\u0006\u00101\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b3\u00104J\u001b\u00105\u001a\u00020\u0006*\u0002022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b5\u00106J\u001b\u00107\u001a\u00020\u0006*\u0002022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b7\u00106J\u001d\u00109\u001a\b\u0012\u0004\u0012\u0002080\b2\u0006\u0010-\u001a\u00020\u0017H\u0016¢\u0006\u0004\b9\u0010:J!\u0010<\u001a\b\u0012\u0004\u0012\u0002080\b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0004\b<\u0010=J\u0013\u0010>\u001a\b\u0012\u0004\u0012\u0002080\b¢\u0006\u0004\b>\u0010?J#\u0010A\u001a\b\u0012\u0004\u0012\u00020@0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\bA\u0010BJ+\u0010C\u001a\b\u0012\u0004\u0012\u00020@0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\bC\u0010\rJ+\u0010D\u001a\b\u0012\u0004\u0012\u00020@0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\bD\u0010\rJ#\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001a0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u0006¢\u0006\u0004\bF\u0010BJ+\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001a0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u0006¢\u0006\u0004\bH\u0010IJ#\u0010L\u001a\b\u0012\u0004\u0012\u00020K0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010J\u001a\u00020\u001a¢\u0006\u0004\bL\u0010MJ3\u0010R\u001a\u0010\u0012\f\u0012\n Q*\u0004\u0018\u000108080\b2\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\u0006¢\u0006\u0004\bR\u0010SJ#\u0010U\u001a\b\u0012\u0004\u0012\u00020T0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\bU\u0010BJ[\u0010]\u001a\b\u0012\u0004\u0012\u0002080\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010W\u001a\u00020V2\u0006\u0010\u0005\u001a\u0002022\u0006\u0010X\u001a\u0002022\u0006\u0010$\u001a\u00020#2\u0006\u0010Z\u001a\u00020Y2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b]\u0010^J!\u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020a0\u000e0`2\u0006\u0010_\u001a\u00020\u0006¢\u0006\u0004\bb\u0010cJ\u0013\u0010d\u001a\b\u0012\u0004\u0012\u0002080\b¢\u0006\u0004\bd\u0010?J\u001b\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\be\u0010fR\u0016\u0010h\u001a\u00020g8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u001f\u0010l\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0`8F@\u0006¢\u0006\u0006\u001a\u0004\bj\u0010kR&\u0010p\u001a\u0012\u0012\u0004\u0012\u00020n0mj\b\u0012\u0004\u0012\u00020n`o8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010s\u001a\u00020r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u001f\u0010v\u001a\b\u0012\u0004\u0012\u00020u0`8\u0006@\u0006¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010kR\u0016\u0010z\u001a\u00020y8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\"\u0010}\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020+0|8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~R,\u0010\u0081\u0001\u001a\u0015\u0012\u0005\u0012\u00030\u0080\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020n0m0\u007f8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001a\u0010\u0084\u0001\u001a\u00030\u0083\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001a\u0010\u0087\u0001\u001a\u00030\u0086\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001a\u0010\u008a\u0001\u001a\u00030\u0089\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\"\u0010\u008e\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008c\u00010\u000e0`8F@\u0006¢\u0006\u0007\u001a\u0005\b\u008d\u0001\u0010kR(\u0010\u0090\u0001\u001a\u0011\u0012\f\u0012\n Q*\u0004\u0018\u00010u0u0\u008f\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001a\u0010\u0093\u0001\u001a\u00030\u0092\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R#\u0010\u009a\u0001\u001a\u00030\u0095\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001a\u0010\u009c\u0001\u001a\u00030\u009b\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001¨\u0006¢\u0001"}, d2 = {"Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "Lcom/coinbase/wallet/core/interfaces/Refreshable;", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "account", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "amount", "", "toAddress", "Lh/c/b0;", "Lkotlin/o;", "Lcom/coinbase/wallet/consumer/models/AvailableSendTransfer;", "Ljava/math/BigDecimal;", "getAvailableSendTransferAndExchangeRate", "(Lcom/coinbase/wallet/consumer/models/ConsumerAccount;Lcom/coinbase/wallet/blockchains/models/TransferValue;Ljava/lang/String;)Lh/c/b0;", "", "Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;", "paymentMethods", "Lcom/coinbase/android/apiv3/generated/authed/sends/PreviewSendAmountResponse;", "sendPreview", "Lcom/coinbase/wallet/consumer/models/ConsumerUser;", ApiConstants.USER, "latestAccount", "sendTransfer", "", "onrampEUEnabled", "Lkotlin/t;", "Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;", "Lcom/coinbase/android/apiv3/generated/authed/sends/SendPaymentMethod;", "Lcom/coinbase/wallet/consumer/repositories/BuyOrderTriple;", "createBuyOrders", "(Ljava/util/List;Lcom/coinbase/android/apiv3/generated/authed/sends/PreviewSendAmountResponse;Lcom/coinbase/wallet/consumer/models/ConsumerUser;Lcom/coinbase/wallet/blockchains/models/TransferValue;Lcom/coinbase/wallet/consumer/models/ConsumerAccount;Lcom/coinbase/wallet/consumer/models/AvailableSendTransfer;Z)Ljava/util/List;", "buyOrders", "Lcom/coinbase/wallet/consumer/models/AvailableBuyAndSendTransfer;", "convertBuyOrdersIntoBuyTransfers", "(Ljava/util/List;Lcom/coinbase/wallet/consumer/models/ConsumerAccount;Lcom/coinbase/wallet/consumer/models/AvailableSendTransfer;Lcom/coinbase/wallet/blockchains/models/TransferValue;Z)Ljava/util/List;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "paymentMethod", "isTotal", "Lcom/coinbase/wallet/core/util/Optional;", "getBuyQuote", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/consumer/models/ConsumerAccount;Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;Z)Lh/c/b0;", "repository", "Lcom/coinbase/wallet/common/models/RefreshState;", "refreshState", "isForced", "Lh/c/k0/b;", "refreshRepository", "(Lcom/coinbase/wallet/core/interfaces/Refreshable;Lcom/coinbase/wallet/common/models/RefreshState;Z)Lh/c/k0/b;", "consumerNativeExchangeRate", "Ljava/math/BigInteger;", "toCrypto", "(Ljava/math/BigDecimal;Ljava/math/BigDecimal;Lcom/coinbase/wallet/consumer/models/ConsumerAccount;)Ljava/math/BigInteger;", "toConsumerSendAmount", "(Ljava/math/BigInteger;Lcom/coinbase/wallet/consumer/models/ConsumerAccount;)Ljava/lang/String;", "toConsumerBuyAmount", "Lkotlin/x;", "refresh", "(Z)Lh/c/b0;", "refreshables", "refreshBlocking", "(Ljava/util/List;)Lh/c/b0;", "refreshPaymentMethods", "()Lh/c/b0;", "Lcom/coinbase/wallet/consumer/models/ConsumerAvailableTransferContainer;", "getMaxTransfer", "(Lcom/coinbase/wallet/consumer/models/ConsumerAccount;Ljava/lang/String;)Lh/c/b0;", "getAvailableTransfers", "getAvailableSendTransfer", "buyOrderId", "commitBuy", "redirectString", "completeBuyOrderAfterSecure3DVerification", "(Lcom/coinbase/wallet/consumer/models/ConsumerAccount;Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "buyOrder", "Lcom/coinbase/wallet/consumer/models/BuyStatus;", "getCommitBuyStatus", "(Lcom/coinbase/wallet/consumer/models/ConsumerAccount;Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;)Lh/c/b0;", "paymentMethodId", "amount1", "amount2", "kotlin.jvm.PlatformType", "completeCardCDVVerification", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/consumer/models/ConsumerSendFee;", "getFeeEstimate", "Lcom/coinbase/wallet/consumer/models/ReceivableWallet;", "receiveWallet", "estimatedFee", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "noDestinationTag", "twoFactor", "send", "(Lcom/coinbase/wallet/consumer/models/ConsumerAccount;Lcom/coinbase/wallet/consumer/models/ReceivableWallet;Ljava/math/BigInteger;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/lang/Boolean;Ljava/lang/String;)Lh/c/b0;", "accountId", "Lh/c/s;", "Lcom/coinbase/wallet/consumer/models/ConsumerTx;", "reloadTransactions", "(Ljava/lang/String;)Lh/c/s;", "delete", "refreshAccountBalance", "(Lcom/coinbase/wallet/consumer/models/ConsumerAccount;)Lh/c/b0;", "Lcom/coinbase/wallet/ethereum/interfaces/IETHWalletRepository;", "erc20Owning", "Lcom/coinbase/wallet/ethereum/interfaces/IETHWalletRepository;", "getPaymentMethodsObservable", "()Lh/c/s;", "paymentMethodsObservable", "Ljava/util/Comparator;", "Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "Lkotlin/Comparator;", "entireBalanceComparator", "Ljava/util/Comparator;", "Lcom/coinbase/wallet/consumer/daos/ConsumerAvailablePaymentMethodsDAO;", "consumerAvailablePaymentMethodsDAO", "Lcom/coinbase/wallet/consumer/daos/ConsumerAvailablePaymentMethodsDAO;", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "submittedTxObservable", "Lh/c/s;", "getSubmittedTxObservable", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "featureFlagsRepository", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "", "refreshableMap", "Ljava/util/Map;", "Lkotlin/Function1;", "Lcom/coinbase/wallet/blockchains/models/TransferValue$Amount;", "amountComparator", "Lkotlin/e0/c/l;", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "consumerUserRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "Lcom/coinbase/wallet/consumer/apis/ConsumerAPI;", "consumerAPI", "Lcom/coinbase/wallet/consumer/apis/ConsumerAPI;", "Lcom/coinbase/wallet/consumer/daos/ConsumerPaymentMethodsDAO;", "consumerPaymentMethodsDAO", "Lcom/coinbase/wallet/consumer/daos/ConsumerPaymentMethodsDAO;", "Lcom/coinbase/wallet/consumer/models/ConsumerAvailablePaymentMethod;", "getAvailablePaymentMethodsObservable", "availablePaymentMethodsObservable", "Lh/c/v0/b;", "submittedTxSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "Lh/c/a0;", "refreshScheduler$delegate", "Lkotlin/h;", "getRefreshScheduler", "()Lh/c/a0;", "refreshScheduler", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "Lcom/coinbase/wallet/consumer/repositories/ConsumerAccountsRepository;", "consumerAccountsRepository", "<init>", "(Lcom/coinbase/wallet/consumer/repositories/ConsumerAccountsRepository;Lcom/coinbase/wallet/consumer/apis/ConsumerAPI;Lcom/coinbase/wallet/ethereum/interfaces/IETHWalletRepository;Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Lcom/coinbase/wallet/consumer/daos/ConsumerPaymentMethodsDAO;Lcom/coinbase/wallet/consumer/daos/ConsumerAvailablePaymentMethodsDAO;Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerTransferRepository implements Refreshable {
    private final kotlin.e0.c.l<TransferValue.Amount, Comparator<AvailableTransfer>> amountComparator;
    private final ConsumerAPI consumerAPI;
    private final ConsumerAvailablePaymentMethodsDAO consumerAvailablePaymentMethodsDAO;
    private final ConsumerPaymentMethodsDAO consumerPaymentMethodsDAO;
    private final ConsumerUserRepository consumerUserRepository;
    private final CurrencyFormatter currencyFormatter;
    private final Comparator<AvailableTransfer> entireBalanceComparator;
    private final IETHWalletRepository erc20Owning;
    private final IExchangeRateRepository exchangeRateRepository;
    private final FeatureFlagsRepository featureFlagsRepository;
    private final kotlin.h refreshScheduler$delegate;
    private final Map<Refreshable, RefreshState> refreshableMap;
    private final h.c.s<Transaction> submittedTxObservable;
    private final h.c.v0.b<Transaction> submittedTxSubject;

    public ConsumerTransferRepository(ConsumerAccountsRepository consumerAccountsRepository, ConsumerAPI consumerAPI, IETHWalletRepository erc20Owning, ConsumerUserRepository consumerUserRepository, CurrencyFormatter currencyFormatter, ConsumerPaymentMethodsDAO consumerPaymentMethodsDAO, ConsumerAvailablePaymentMethodsDAO consumerAvailablePaymentMethodsDAO, FeatureFlagsRepository featureFlagsRepository, IExchangeRateRepository exchangeRateRepository) {
        kotlin.h b2;
        Map<Refreshable, RefreshState> l2;
        kotlin.jvm.internal.m.g(consumerAccountsRepository, "consumerAccountsRepository");
        kotlin.jvm.internal.m.g(consumerAPI, "consumerAPI");
        kotlin.jvm.internal.m.g(erc20Owning, "erc20Owning");
        kotlin.jvm.internal.m.g(consumerUserRepository, "consumerUserRepository");
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        kotlin.jvm.internal.m.g(consumerPaymentMethodsDAO, "consumerPaymentMethodsDAO");
        kotlin.jvm.internal.m.g(consumerAvailablePaymentMethodsDAO, "consumerAvailablePaymentMethodsDAO");
        kotlin.jvm.internal.m.g(featureFlagsRepository, "featureFlagsRepository");
        kotlin.jvm.internal.m.g(exchangeRateRepository, "exchangeRateRepository");
        this.consumerAPI = consumerAPI;
        this.erc20Owning = erc20Owning;
        this.consumerUserRepository = consumerUserRepository;
        this.currencyFormatter = currencyFormatter;
        this.consumerPaymentMethodsDAO = consumerPaymentMethodsDAO;
        this.consumerAvailablePaymentMethodsDAO = consumerAvailablePaymentMethodsDAO;
        this.featureFlagsRepository = featureFlagsRepository;
        this.exchangeRateRepository = exchangeRateRepository;
        h.c.v0.b<Transaction> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<Transaction>()");
        this.submittedTxSubject = d2;
        b2 = kotlin.k.b(ConsumerTransferRepository$refreshScheduler$2.INSTANCE);
        this.refreshScheduler$delegate = b2;
        l2 = kotlin.a0.m0.l(kotlin.u.a(consumerUserRepository, new RefreshState(120L)), kotlin.u.a(consumerAccountsRepository, new RefreshState(120L)), kotlin.u.a(this, new RefreshState(120L)));
        this.refreshableMap = l2;
        this.entireBalanceComparator = new Comparator() { // from class: com.coinbase.wallet.consumer.repositories.r1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ConsumerTransferRepository.A((AvailableTransfer) obj, (AvailableTransfer) obj2);
            }
        };
        this.amountComparator = ConsumerTransferRepository$amountComparator$1.INSTANCE;
        h.c.s<Transaction> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "submittedTxSubject.hide()");
        this.submittedTxObservable = hide;
    }

    public static /* synthetic */ int A(AvailableTransfer availableTransfer, AvailableTransfer availableTransfer2) {
        return m906entireBalanceComparator$lambda0(availableTransfer, availableTransfer2);
    }

    public static /* synthetic */ List B(AvailableSendTransfer availableSendTransfer, List list) {
        return m917getAvailableTransfers$lambda20$lambda17$lambda16$lambda15(availableSendTransfer, list);
    }

    public static /* synthetic */ h.c.h0 E(ConsumerAccount consumerAccount, ConsumerTransferRepository consumerTransferRepository, Map map) {
        return m910getAvailableSendTransferAndExchangeRate$lambda31$lambda29(consumerAccount, consumerTransferRepository, map);
    }

    public static /* synthetic */ ConsumerAvailableTransferContainer F(ConsumerAccount consumerAccount, kotlin.o oVar) {
        return m908getAvailableSendTransfer$lambda22$lambda21(consumerAccount, oVar);
    }

    public static /* synthetic */ kotlin.x G(RefreshState refreshState, AtomicReference atomicReference) {
        return m924refreshBlocking$lambda7$lambda3(refreshState, atomicReference);
    }

    public static /* synthetic */ h.c.h0 H(ConsumerPaymentMethod consumerPaymentMethod, Throwable th) {
        return m921getBuyQuote$lambda39(consumerPaymentMethod, th);
    }

    public static /* synthetic */ h.c.h0 I(TransferValue transferValue, ConsumerTransferRepository consumerTransferRepository, ConsumerAccount consumerAccount, kotlin.o oVar) {
        return m914getAvailableTransfers$lambda20$lambda17(transferValue, consumerTransferRepository, consumerAccount, oVar);
    }

    public static /* synthetic */ kotlin.x b(Throwable th) {
        return m936send$lambda26$lambda24$lambda23(th);
    }

    public static /* synthetic */ ConsumerAvailableTransferContainer c(ConsumerAvailableTransferContainer consumerAvailableTransferContainer) {
        return m922getMaxTransfer$lambda13(consumerAvailableTransferContainer);
    }

    private final List<AvailableBuyAndSendTransfer> convertBuyOrdersIntoBuyTransfers(List<kotlin.t<ConsumerBuyOrder, SendPaymentMethod, ConsumerPaymentMethod>> list, ConsumerAccount consumerAccount, AvailableSendTransfer availableSendTransfer, TransferValue transferValue, boolean z) {
        int r;
        BigInteger bigInteger;
        Amount fiat_limit;
        PaymentMethod payment_method;
        PaymentMethod payment_method2;
        r = kotlin.a0.s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            kotlin.t tVar = (kotlin.t) it.next();
            ConsumerBuyOrder consumerBuyOrder = (ConsumerBuyOrder) tVar.a();
            SendPaymentMethod sendPaymentMethod = (SendPaymentMethod) tVar.b();
            ConsumerPaymentMethod consumerPaymentMethod = (ConsumerPaymentMethod) tVar.c();
            if (consumerBuyOrder != null) {
                BigInteger subtract = BigDecimal_CommonKt.asBigInteger(consumerBuyOrder.getAmount(), consumerAccount.getDecimals()).subtract(availableSendTransfer.getSendFee());
                kotlin.jvm.internal.m.f(subtract, "this.subtract(other)");
                if (consumerAccount.getDecimals() == consumerAccount.getTransferDecimals() && (transferValue instanceof TransferValue.Amount) && !kotlin.jvm.internal.m.c(((TransferValue.Amount) transferValue).getValue(), subtract)) {
                    throw new AssertionException("The transfer amount after fee != buy amount");
                }
                bigInteger = BigInteger.ZERO.max(subtract);
            } else {
                bigInteger = BigInteger.ZERO;
            }
            BigInteger transferAmount = bigInteger;
            ConsumerPaymentMethodType fromValueNullable = ConsumerPaymentMethodType.Companion.fromValueNullable(consumerPaymentMethod.getType());
            String value = (sendPaymentMethod == null || (fiat_limit = sendPaymentMethod.getFiat_limit()) == null) ? null : fiat_limit.getValue();
            boolean z2 = !kotlin.jvm.internal.m.c(consumerPaymentMethod.getType(), ConsumerPaymentMethodType.SECURE3D_CARD.toString()) || z;
            BigDecimal bigDecimal = value == null ? null : new BigDecimal(value);
            String image_url = (sendPaymentMethod == null || (payment_method = sendPaymentMethod.getPayment_method()) == null) ? null : payment_method.getImage_url();
            Integer iconRes = fromValueNullable == null ? null : fromValueNullable.getIconRes();
            String subtitle = (sendPaymentMethod == null || (payment_method2 = sendPaymentMethod.getPayment_method()) == null) ? null : payment_method2.getSubtitle();
            String supplemental_info = sendPaymentMethod == null ? null : sendPaymentMethod.getSupplemental_info();
            if (supplemental_info == null) {
                supplemental_info = Strings_CoreKt.getEmpty(Strings.INSTANCE);
            }
            String str = supplemental_info;
            BigInteger sendFee = availableSendTransfer.getSendFee();
            BigDecimal fee = consumerBuyOrder == null ? null : consumerBuyOrder.getFee();
            kotlin.jvm.internal.m.f(transferAmount, "transferAmount");
            arrayList.add(new AvailableBuyAndSendTransfer(sendFee, consumerAccount, transferAmount, consumerPaymentMethod, subtitle, str, bigDecimal, image_url, iconRes, fee, consumerBuyOrder, z2));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0109 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x002c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<h.c.b0<kotlin.t<com.coinbase.wallet.consumer.models.ConsumerBuyOrder, com.coinbase.android.apiv3.generated.authed.sends.SendPaymentMethod, com.coinbase.wallet.consumer.models.ConsumerPaymentMethod>>> createBuyOrders(java.util.List<com.coinbase.wallet.consumer.models.ConsumerPaymentMethod> r16, com.coinbase.android.apiv3.generated.authed.sends.PreviewSendAmountResponse r17, com.coinbase.wallet.consumer.models.ConsumerUser r18, com.coinbase.wallet.blockchains.models.TransferValue r19, com.coinbase.wallet.consumer.models.ConsumerAccount r20, com.coinbase.wallet.consumer.models.AvailableSendTransfer r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository.createBuyOrders(java.util.List, com.coinbase.android.apiv3.generated.authed.sends.PreviewSendAmountResponse, com.coinbase.wallet.consumer.models.ConsumerUser, com.coinbase.wallet.blockchains.models.TransferValue, com.coinbase.wallet.consumer.models.ConsumerAccount, com.coinbase.wallet.consumer.models.AvailableSendTransfer, boolean):java.util.List");
    }

    /* renamed from: createBuyOrders$lambda-35$lambda-34 */
    public static final kotlin.t m905createBuyOrders$lambda35$lambda34(SendPaymentMethod sendPaymentMethod, ConsumerPaymentMethod paymentMethod, Optional it) {
        kotlin.jvm.internal.m.g(paymentMethod, "$paymentMethod");
        kotlin.jvm.internal.m.g(it, "it");
        return new kotlin.t(it.toNullable(), sendPaymentMethod, paymentMethod);
    }

    public static /* synthetic */ kotlin.x d(RefreshState refreshState, AtomicReference atomicReference, kotlin.x xVar) {
        return m926refreshBlocking$lambda7$lambda5(refreshState, atomicReference, xVar);
    }

    public static /* synthetic */ kotlin.x e(Blockchain blockchain, ReceivableWallet receivableWallet, ConsumerAccount consumerAccount, CurrencyCode currencyCode, BigInteger bigInteger, BigInteger bigInteger2, ConsumerTransferRepository consumerTransferRepository, String str) {
        return m938send$lambda27(blockchain, receivableWallet, consumerAccount, currencyCode, bigInteger, bigInteger2, consumerTransferRepository, str);
    }

    /* renamed from: entireBalanceComparator$lambda-0 */
    public static final int m906entireBalanceComparator$lambda0(AvailableTransfer availableTransfer, AvailableTransfer availableTransfer2) {
        if (availableTransfer.getTransferAmount().compareTo(availableTransfer2.getTransferAmount()) <= 0) {
            if (availableTransfer.getTransferAmount().compareTo(availableTransfer2.getTransferAmount()) >= 0) {
                if (!(availableTransfer instanceof AvailableSendTransfer)) {
                    if (!(availableTransfer2 instanceof AvailableSendTransfer)) {
                        BigInteger transferAmount = availableTransfer.getTransferAmount();
                        BigInteger bigInteger = BigInteger.ZERO;
                        if (kotlin.jvm.internal.m.c(transferAmount, bigInteger) && kotlin.jvm.internal.m.c(availableTransfer2.getTransferAmount(), bigInteger)) {
                            return 0;
                        }
                        if ((availableTransfer instanceof AvailableBuyAndSendTransfer) && (availableTransfer2 instanceof AvailableBuyAndSendTransfer)) {
                            BigDecimal coinbaseFee = ((AvailableBuyAndSendTransfer) availableTransfer).getCoinbaseFee();
                            return -(coinbaseFee != null ? coinbaseFee.compareTo(((AvailableBuyAndSendTransfer) availableTransfer2).getCoinbaseFee()) : 0);
                        }
                        throw new IllegalStateException("Should never get here, logic error");
                    }
                }
            }
            return 1;
        }
        return -1;
    }

    public static /* synthetic */ kotlin.o f(ConsumerAccount consumerAccount, ConsumerTransferRepository consumerTransferRepository, TransferValue transferValue, kotlin.t tVar) {
        return m912getAvailableSendTransferAndExchangeRate$lambda32(consumerAccount, consumerTransferRepository, transferValue, tVar);
    }

    public static /* synthetic */ h.c.h0 g(Blockchain blockchain, ConsumerAccount consumerAccount, ConsumerTransferRepository consumerTransferRepository, ReceivableWallet receivableWallet, String str) {
        return m934send$lambda26(blockchain, consumerAccount, consumerTransferRepository, receivableWallet, str);
    }

    /* renamed from: getAvailableSendTransfer$lambda-22 */
    public static final h.c.h0 m907getAvailableSendTransfer$lambda22(ConsumerTransferRepository this$0, TransferValue amount, String toAddress, final ConsumerAccount latestAccount) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(amount, "$amount");
        kotlin.jvm.internal.m.g(toAddress, "$toAddress");
        kotlin.jvm.internal.m.g(latestAccount, "latestAccount");
        return this$0.getAvailableSendTransferAndExchangeRate(latestAccount, amount, toAddress).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.x1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.F(ConsumerAccount.this, (kotlin.o) obj);
            }
        });
    }

    /* renamed from: getAvailableSendTransfer$lambda-22$lambda-21 */
    public static final ConsumerAvailableTransferContainer m908getAvailableSendTransfer$lambda22$lambda21(ConsumerAccount latestAccount, kotlin.o dstr$transfer$_u24__u24) {
        List b2;
        kotlin.jvm.internal.m.g(latestAccount, "$latestAccount");
        kotlin.jvm.internal.m.g(dstr$transfer$_u24__u24, "$dstr$transfer$_u24__u24");
        AvailableSendTransfer availableSendTransfer = (AvailableSendTransfer) dstr$transfer$_u24__u24.a();
        BigInteger transferAmount = availableSendTransfer.getTransferAmount();
        b2 = kotlin.a0.q.b(availableSendTransfer);
        return new ConsumerAvailableTransferContainer(transferAmount, b2, latestAccount);
    }

    private final h.c.b0<kotlin.o<AvailableSendTransfer, BigDecimal>> getAvailableSendTransferAndExchangeRate(final ConsumerAccount consumerAccount, final TransferValue transferValue, String str) {
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0<ConsumerSendFee> feeEstimate = getFeeEstimate(consumerAccount, str);
        h.c.s<R> map = this.consumerUserRepository.getUserObservable().filter(new h.c.m0.p() { // from class: com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository$getAvailableSendTransferAndExchangeRate$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository$getAvailableSendTransferAndExchangeRate$$inlined$unwrap$2
            public final T apply(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        kotlin.jvm.internal.m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        h.c.b0<kotlin.o<AvailableSendTransfer, BigDecimal>> map2 = Single_AnalyticsKt.logError$default(eVar.a(feeEstimate, Observable_CoreKt.takeSingle(map)), null, null, 3, null).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.y0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.h(ConsumerTransferRepository.this, consumerAccount, (kotlin.o) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.w0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.f(ConsumerAccount.this, this, transferValue, (kotlin.t) obj);
            }
        });
        kotlin.jvm.internal.m.f(map2, "Singles\n        .zip(\n            getFeeEstimate(account, toAddress),\n            consumerUserRepository.userObservable.unwrap().takeSingle()\n        )\n        .logError()\n        .flatMap { (fee, user) ->\n            consumerAPI\n                .getExchangeRates(user.currencyCode)\n                .flatMap { exchangeRates ->\n                    val exchangeRate = exchangeRates[account.currencyCode.code]\n                    if (exchangeRate != null) {\n                        Single.just(exchangeRate)\n                    } else {\n                        exchangeRateRepository.getCryptoExchangeRate(account.currencyCode)\n                    }\n                }\n                .map { Triple(fee, user, it) }\n        }\n        .map { (fee, user, consumerNativeExchangeRate) ->\n            val accountCryptoBalance = account.balance\n            val availableUserFiatBalance = user.withdrawalLimit\n\n            // Total available balance across all accounts measured in the crypto being sent\n            // e.g. user is sending XRP, total available balance is $150 across all accounts,\n            // and the exchange rate is 3 XRP/$.\n            // The availableBalanceCryptoEquivalent = $150 * 3 XRP/$ = 450 XRP\n            val availableBalanceCryptoEquivalent = availableUserFiatBalance\n                .multiply(consumerNativeExchangeRate, MathContext.DECIMAL128)\n                .asBigInteger(account.decimals)\n\n            val (maxAmountCrypto, showWbl) = if (accountCryptoBalance > availableBalanceCryptoEquivalent) {\n                Pair(availableBalanceCryptoEquivalent, true)\n            } else {\n                Pair(accountCryptoBalance, false)\n            }\n\n            val maxAmountCryptoFormatted = currencyFormatter.formatToCrypto(\n                currencyCode = account.currencyCode,\n                decimals = account.decimals,\n                value = maxAmountCrypto,\n                maxDisplayDecimals = account.decimals\n            )\n\n            val transferAmount = when (amount) {\n                is TransferValue.EntireBalance -> {\n                    BigInteger.ZERO.max(maxAmountCrypto - fee.amount)\n                }\n                is TransferValue.Amount -> {\n                    if (amount.value > (maxAmountCrypto - fee.amount)) BigInteger.ZERO else amount.value\n                }\n            }\n\n            AvailableSendTransfer(\n                sendFee = fee.amount,\n                account = account,\n                transferAmount = transferAmount,\n                maxAmountCrypto = maxAmountCrypto,\n                maxAmountCryptoFormatted = maxAmountCryptoFormatted,\n                isWblLimited = showWbl,\n                email = user.email\n            ) to consumerNativeExchangeRate\n        }");
        return map2;
    }

    /* renamed from: getAvailableSendTransferAndExchangeRate$lambda-31 */
    public static final h.c.h0 m909getAvailableSendTransferAndExchangeRate$lambda31(final ConsumerTransferRepository this$0, final ConsumerAccount account, kotlin.o dstr$fee$user) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(account, "$account");
        kotlin.jvm.internal.m.g(dstr$fee$user, "$dstr$fee$user");
        final ConsumerSendFee consumerSendFee = (ConsumerSendFee) dstr$fee$user.a();
        final ConsumerUser consumerUser = (ConsumerUser) dstr$fee$user.b();
        return this$0.consumerAPI.getExchangeRates(consumerUser.getCurrencyCode()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.w1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.E(ConsumerAccount.this, this$0, (Map) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.h1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.q(ConsumerSendFee.this, consumerUser, (BigDecimal) obj);
            }
        });
    }

    /* renamed from: getAvailableSendTransferAndExchangeRate$lambda-31$lambda-29 */
    public static final h.c.h0 m910getAvailableSendTransferAndExchangeRate$lambda31$lambda29(ConsumerAccount account, ConsumerTransferRepository this$0, Map exchangeRates) {
        kotlin.jvm.internal.m.g(account, "$account");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(exchangeRates, "exchangeRates");
        BigDecimal bigDecimal = (BigDecimal) exchangeRates.get(account.getCurrencyCode().getCode());
        if (bigDecimal != null) {
            h.c.b0 just = h.c.b0.just(bigDecimal);
            kotlin.jvm.internal.m.f(just, "{\n                        Single.just(exchangeRate)\n                    }");
            return just;
        }
        return IExchangeRateRepository.DefaultImpls.getCryptoExchangeRate$default(this$0.exchangeRateRepository, account.getCurrencyCode(), null, 0, 6, null);
    }

    /* renamed from: getAvailableSendTransferAndExchangeRate$lambda-31$lambda-30 */
    public static final kotlin.t m911getAvailableSendTransferAndExchangeRate$lambda31$lambda30(ConsumerSendFee consumerSendFee, ConsumerUser consumerUser, BigDecimal it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new kotlin.t(consumerSendFee, consumerUser, it);
    }

    /* renamed from: getAvailableSendTransferAndExchangeRate$lambda-32 */
    public static final kotlin.o m912getAvailableSendTransferAndExchangeRate$lambda32(ConsumerAccount account, ConsumerTransferRepository this$0, TransferValue amount, kotlin.t dstr$fee$user$consumerNativeExchangeRate) {
        kotlin.o oVar;
        BigInteger value;
        kotlin.jvm.internal.m.g(account, "$account");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(amount, "$amount");
        kotlin.jvm.internal.m.g(dstr$fee$user$consumerNativeExchangeRate, "$dstr$fee$user$consumerNativeExchangeRate");
        ConsumerSendFee consumerSendFee = (ConsumerSendFee) dstr$fee$user$consumerNativeExchangeRate.a();
        ConsumerUser consumerUser = (ConsumerUser) dstr$fee$user$consumerNativeExchangeRate.b();
        BigDecimal bigDecimal = (BigDecimal) dstr$fee$user$consumerNativeExchangeRate.c();
        BigInteger balance = account.getBalance();
        BigDecimal multiply = consumerUser.getWithdrawalLimit().multiply(bigDecimal, MathContext.DECIMAL128);
        kotlin.jvm.internal.m.f(multiply, "availableUserFiatBalance\n                .multiply(consumerNativeExchangeRate, MathContext.DECIMAL128)");
        BigInteger asBigInteger = BigDecimal_CommonKt.asBigInteger(multiply, account.getDecimals());
        if (balance.compareTo(asBigInteger) > 0) {
            oVar = new kotlin.o(asBigInteger, Boolean.TRUE);
        } else {
            oVar = new kotlin.o(balance, Boolean.FALSE);
        }
        BigInteger bigInteger = (BigInteger) oVar.a();
        boolean booleanValue = ((Boolean) oVar.b()).booleanValue();
        String formatToCrypto$default = CurrencyFormatter.formatToCrypto$default(this$0.currencyFormatter, account.getCurrencyCode(), account.getDecimals(), bigInteger, false, account.getDecimals(), 0, 40, (Object) null);
        if (amount instanceof TransferValue.EntireBalance) {
            BigInteger bigInteger2 = BigInteger.ZERO;
            BigInteger subtract = bigInteger.subtract(consumerSendFee.getAmount());
            kotlin.jvm.internal.m.f(subtract, "this.subtract(other)");
            value = bigInteger2.max(subtract);
        } else if (amount instanceof TransferValue.Amount) {
            TransferValue.Amount amount2 = (TransferValue.Amount) amount;
            BigInteger value2 = amount2.getValue();
            BigInteger subtract2 = bigInteger.subtract(consumerSendFee.getAmount());
            kotlin.jvm.internal.m.f(subtract2, "this.subtract(other)");
            value = value2.compareTo(subtract2) > 0 ? BigInteger.ZERO : amount2.getValue();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        BigInteger transferAmount = value;
        BigInteger amount3 = consumerSendFee.getAmount();
        kotlin.jvm.internal.m.f(transferAmount, "transferAmount");
        return kotlin.u.a(new AvailableSendTransfer(amount3, account, transferAmount, bigInteger, formatToCrypto$default, booleanValue, consumerUser.getEmail()), bigDecimal);
    }

    /* renamed from: getAvailableTransfers$lambda-20 */
    public static final h.c.h0 m913getAvailableTransfers$lambda20(final ConsumerTransferRepository this$0, final TransferValue amount, String toAddress, final ConsumerAccount latestAccount) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(amount, "$amount");
        kotlin.jvm.internal.m.g(toAddress, "$toAddress");
        kotlin.jvm.internal.m.g(latestAccount, "latestAccount");
        h.c.b0 map = this$0.getAvailableSendTransferAndExchangeRate(latestAccount, amount, toAddress).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.a2
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.I(TransferValue.this, this$0, latestAccount, (kotlin.o) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.k1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.t(TransferValue.this, this$0, (List) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.d1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.m(ConsumerAccount.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "getAvailableSendTransferAndExchangeRate(latestAccount, amount, toAddress)\n                    .flatMap { (sendTransfer, consumerNativeExchangeRate) ->\n                        val fundedSendAmountStr = when (amount) {\n                            is TransferValue.EntireBalance -> {\n                                // Doesn't matter what the amount is, we call the funded send api to get buy limits\n                                val minSendAmount = BigDecimal(\"10.0\")\n                                    .toCrypto(consumerNativeExchangeRate, latestAccount)\n                                minSendAmount.plus(sendTransfer.maxAmountCrypto).toConsumerBuyAmount(latestAccount)\n                            }\n                            is TransferValue.Amount -> {\n                                amount.value.plus(sendTransfer.maxAmountCrypto).toConsumerBuyAmount(latestAccount)\n                            }\n                        }\n\n                        Singles\n                            .zip(\n                                paymentMethodsObservable.takeSingle(),\n                                consumerAPI.fundedSend(latestAccount, fundedSendAmountStr),\n                                consumerUserRepository.userObservable.unwrap().takeSingle(),\n                                featureFlagsRepository.value(FeatureFlag.ONRAMP_EU)\n                            )\n                            .logError()\n                            .flatMap { (paymentMethods, sendPreview, user, onrampEUEnabled) ->\n                                val buyOrderSingleList = createBuyOrders(\n                                    paymentMethods,\n                                    sendPreview,\n                                    user,\n                                    amount,\n                                    latestAccount,\n                                    sendTransfer,\n                                    onrampEUEnabled\n                                )\n\n                                buyOrderSingleList\n                                    .zipOrEmpty()\n                                    .map { buyOrders ->\n                                        convertBuyOrdersIntoBuyTransfers(\n                                            buyOrders,\n                                            latestAccount,\n                                            sendTransfer,\n                                            amount,\n                                            onrampEUEnabled\n                                        )\n                                    }\n                                    .map { (listOf(sendTransfer) + it) }\n                            }\n                    }\n                    .map { availableTransfers ->\n                        val comparator: Comparator<AvailableTransfer> = when (amount) {\n                            is TransferValue.EntireBalance -> {\n                                entireBalanceComparator\n                            }\n                            is TransferValue.Amount -> {\n                                amountComparator(amount)\n                            }\n                        }\n                        availableTransfers.sortedWith(comparator)\n                    }\n                    .map { ConsumerAvailableTransferContainer(it.first().transferAmount, it, latestAccount) }");
        return Single_AnalyticsKt.logError$default(map, null, null, 3, null);
    }

    /* renamed from: getAvailableTransfers$lambda-20$lambda-17 */
    public static final h.c.h0 m914getAvailableTransfers$lambda20$lambda17(final TransferValue amount, ConsumerTransferRepository this$0, final ConsumerAccount latestAccount, kotlin.o dstr$sendTransfer$consumerNativeExchangeRate) {
        String consumerBuyAmount;
        kotlin.jvm.internal.m.g(amount, "$amount");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(latestAccount, "$latestAccount");
        kotlin.jvm.internal.m.g(dstr$sendTransfer$consumerNativeExchangeRate, "$dstr$sendTransfer$consumerNativeExchangeRate");
        final AvailableSendTransfer availableSendTransfer = (AvailableSendTransfer) dstr$sendTransfer$consumerNativeExchangeRate.a();
        BigDecimal bigDecimal = (BigDecimal) dstr$sendTransfer$consumerNativeExchangeRate.b();
        if (amount instanceof TransferValue.EntireBalance) {
            BigInteger add = this$0.toCrypto(new BigDecimal("10.0"), bigDecimal, latestAccount).add(availableSendTransfer.getMaxAmountCrypto());
            kotlin.jvm.internal.m.f(add, "this.add(other)");
            consumerBuyAmount = this$0.toConsumerBuyAmount(add, latestAccount);
        } else if (amount instanceof TransferValue.Amount) {
            BigInteger add2 = ((TransferValue.Amount) amount).getValue().add(availableSendTransfer.getMaxAmountCrypto());
            kotlin.jvm.internal.m.f(add2, "this.add(other)");
            consumerBuyAmount = this$0.toConsumerBuyAmount(add2, latestAccount);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0 takeSingle = Observable_CoreKt.takeSingle(this$0.getPaymentMethodsObservable());
        h.c.b0<PreviewSendAmountResponse> fundedSend = this$0.consumerAPI.fundedSend(latestAccount, consumerBuyAmount);
        h.c.s<R> map = this$0.consumerUserRepository.getUserObservable().filter(new h.c.m0.p() { // from class: com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository$getAvailableTransfers$lambda-20$lambda-17$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository$getAvailableTransfers$lambda-20$lambda-17$$inlined$unwrap$2
            public final T apply(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        kotlin.jvm.internal.m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        return Single_AnalyticsKt.logError$default(Singles_CoreKt.zip(eVar, takeSingle, fundedSend, Observable_CoreKt.takeSingle(map), FeatureFlagsRepository.value$default(this$0.featureFlagsRepository, FeatureFlag.ONRAMP_EU, false, 0L, 6, null)), null, null, 3, null).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.f1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.o(ConsumerTransferRepository.this, amount, latestAccount, availableSendTransfer, (Four) obj);
            }
        });
    }

    /* renamed from: getAvailableTransfers$lambda-20$lambda-17$lambda-16 */
    public static final h.c.h0 m915getAvailableTransfers$lambda20$lambda17$lambda16(ConsumerTransferRepository this$0, final TransferValue amount, final ConsumerAccount latestAccount, final AvailableSendTransfer sendTransfer, Four dstr$paymentMethods$sendPreview$user$onrampEUEnabled) {
        h.c.b0 zip;
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(amount, "$amount");
        kotlin.jvm.internal.m.g(latestAccount, "$latestAccount");
        kotlin.jvm.internal.m.g(sendTransfer, "$sendTransfer");
        kotlin.jvm.internal.m.g(dstr$paymentMethods$sendPreview$user$onrampEUEnabled, "$dstr$paymentMethods$sendPreview$user$onrampEUEnabled");
        final boolean booleanValue = ((Boolean) dstr$paymentMethods$sendPreview$user$onrampEUEnabled.component4()).booleanValue();
        List<h.c.b0<kotlin.t<ConsumerBuyOrder, SendPaymentMethod, ConsumerPaymentMethod>>> createBuyOrders = this$0.createBuyOrders((List) dstr$paymentMethods$sendPreview$user$onrampEUEnabled.component1(), (PreviewSendAmountResponse) dstr$paymentMethods$sendPreview$user$onrampEUEnabled.component2(), (ConsumerUser) dstr$paymentMethods$sendPreview$user$onrampEUEnabled.component3(), amount, latestAccount, sendTransfer, booleanValue);
        h.c.t0.e eVar = h.c.t0.e.a;
        if (createBuyOrders.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(createBuyOrders, new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository$getAvailableTransfers$lambda-20$lambda-17$lambda-16$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it, "it");
                    if (it.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : it) {
                        if (obj instanceof kotlin.t) {
                            arrayList.add(obj);
                        }
                    }
                    return arrayList;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        return zip.map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.i1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.r(ConsumerTransferRepository.this, latestAccount, sendTransfer, amount, booleanValue, (List) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.s1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.B(AvailableSendTransfer.this, (List) obj);
            }
        });
    }

    /* renamed from: getAvailableTransfers$lambda-20$lambda-17$lambda-16$lambda-14 */
    public static final List m916getAvailableTransfers$lambda20$lambda17$lambda16$lambda14(ConsumerTransferRepository this$0, ConsumerAccount latestAccount, AvailableSendTransfer sendTransfer, TransferValue amount, boolean z, List buyOrders) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(latestAccount, "$latestAccount");
        kotlin.jvm.internal.m.g(sendTransfer, "$sendTransfer");
        kotlin.jvm.internal.m.g(amount, "$amount");
        kotlin.jvm.internal.m.g(buyOrders, "buyOrders");
        return this$0.convertBuyOrdersIntoBuyTransfers(buyOrders, latestAccount, sendTransfer, amount, z);
    }

    /* renamed from: getAvailableTransfers$lambda-20$lambda-17$lambda-16$lambda-15 */
    public static final List m917getAvailableTransfers$lambda20$lambda17$lambda16$lambda15(AvailableSendTransfer sendTransfer, List it) {
        List b2;
        List t0;
        kotlin.jvm.internal.m.g(sendTransfer, "$sendTransfer");
        kotlin.jvm.internal.m.g(it, "it");
        b2 = kotlin.a0.q.b(sendTransfer);
        t0 = kotlin.a0.z.t0(b2, it);
        return t0;
    }

    /* renamed from: getAvailableTransfers$lambda-20$lambda-18 */
    public static final List m918getAvailableTransfers$lambda20$lambda18(TransferValue amount, ConsumerTransferRepository this$0, List availableTransfers) {
        Comparator<AvailableTransfer> invoke;
        List B0;
        kotlin.jvm.internal.m.g(amount, "$amount");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(availableTransfers, "availableTransfers");
        if (amount instanceof TransferValue.EntireBalance) {
            invoke = this$0.entireBalanceComparator;
        } else if (amount instanceof TransferValue.Amount) {
            invoke = this$0.amountComparator.invoke(amount);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        B0 = kotlin.a0.z.B0(availableTransfers, invoke);
        return B0;
    }

    /* renamed from: getAvailableTransfers$lambda-20$lambda-19 */
    public static final ConsumerAvailableTransferContainer m919getAvailableTransfers$lambda20$lambda19(ConsumerAccount latestAccount, List it) {
        kotlin.jvm.internal.m.g(latestAccount, "$latestAccount");
        kotlin.jvm.internal.m.g(it, "it");
        return new ConsumerAvailableTransferContainer(((AvailableTransfer) kotlin.a0.p.Y(it)).getTransferAmount(), it, latestAccount);
    }

    private final h.c.b0<Optional<ConsumerBuyOrder>> getBuyQuote(String str, CurrencyCode currencyCode, ConsumerAccount consumerAccount, final ConsumerPaymentMethod consumerPaymentMethod, boolean z) {
        h.c.b0<Optional<ConsumerBuyOrder>> onErrorResumeNext = this.consumerAPI.buyQuote(consumerAccount.getId(), currencyCode, str, consumerPaymentMethod.getId(), z).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.j1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.s((ConsumerBuyOrder) obj);
            }
        }).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.z1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.H(ConsumerPaymentMethod.this, (Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorResumeNext, "consumerAPI\n            .buyQuote(\n                accountId = account.id,\n                currencyCode = currencyCode,\n                amount = amount,\n                paymentMethodId = paymentMethod.id,\n                isTotal = isTotal\n            )\n            .map { buyOrder -> buyOrder.toOptional() }\n            .onErrorResumeNext { throwable ->\n                val isFiatAccount = paymentMethod.type == ConsumerPaymentMethodType.FIAT_ACCOUNT.toString()\n                if (throwable is ConsumerException.BuyOverLimit || throwable is CoinbaseException && isFiatAccount) {\n                    Single.just(Optional(null))\n                } else {\n                    Single.error(throwable)\n                }\n            }");
        return onErrorResumeNext;
    }

    /* renamed from: getBuyQuote$lambda-38 */
    public static final Optional m920getBuyQuote$lambda38(ConsumerBuyOrder buyOrder) {
        kotlin.jvm.internal.m.g(buyOrder, "buyOrder");
        return OptionalKt.toOptional(buyOrder);
    }

    /* renamed from: getBuyQuote$lambda-39 */
    public static final h.c.h0 m921getBuyQuote$lambda39(ConsumerPaymentMethod paymentMethod, Throwable throwable) {
        kotlin.jvm.internal.m.g(paymentMethod, "$paymentMethod");
        kotlin.jvm.internal.m.g(throwable, "throwable");
        boolean c2 = kotlin.jvm.internal.m.c(paymentMethod.getType(), ConsumerPaymentMethodType.FIAT_ACCOUNT.toString());
        if (!(throwable instanceof ConsumerException.BuyOverLimit) && (!(throwable instanceof CoinbaseException) || !c2)) {
            return h.c.b0.error(throwable);
        }
        return h.c.b0.just(new Optional(null));
    }

    /* renamed from: getMaxTransfer$lambda-13 */
    public static final ConsumerAvailableTransferContainer m922getMaxTransfer$lambda13(ConsumerAvailableTransferContainer transfers) {
        kotlin.jvm.internal.m.g(transfers, "transfers");
        AvailableTransfer availableTransfer = (AvailableTransfer) kotlin.a0.p.a0(transfers.getAvailableTransfers());
        BigInteger maxTransferableAmount = availableTransfer == null ? null : availableTransfer.getTransferAmount();
        if (maxTransferableAmount == null) {
            maxTransferableAmount = BigInteger.ZERO;
        }
        kotlin.jvm.internal.m.f(maxTransferableAmount, "maxTransferableAmount");
        return new ConsumerAvailableTransferContainer(maxTransferableAmount, transfers.getAvailableTransfers(), transfers.getAccount());
    }

    private final h.c.a0 getRefreshScheduler() {
        return (h.c.a0) this.refreshScheduler$delegate.getValue();
    }

    public static /* synthetic */ h.c.h0 h(ConsumerTransferRepository consumerTransferRepository, ConsumerAccount consumerAccount, kotlin.o oVar) {
        return m909getAvailableSendTransferAndExchangeRate$lambda31(consumerTransferRepository, consumerAccount, oVar);
    }

    public static /* synthetic */ String i(String str, kotlin.x xVar) {
        return m937send$lambda26$lambda25(str, xVar);
    }

    public static /* synthetic */ h.c.h0 j(ConsumerTransferRepository consumerTransferRepository, kotlin.o oVar) {
        return m930refreshPaymentMethods$lambda11(consumerTransferRepository, oVar);
    }

    public static /* synthetic */ h.c.h0 k(ConsumerTransferRepository consumerTransferRepository, TransferValue transferValue, String str, ConsumerAccount consumerAccount) {
        return m913getAvailableTransfers$lambda20(consumerTransferRepository, transferValue, str, consumerAccount);
    }

    public static /* synthetic */ h.c.h0 l(ConsumerTransferRepository consumerTransferRepository, kotlin.o oVar) {
        return m928refreshPaymentMethods$lambda10(consumerTransferRepository, oVar);
    }

    public static /* synthetic */ ConsumerAvailableTransferContainer m(ConsumerAccount consumerAccount, List list) {
        return m919getAvailableTransfers$lambda20$lambda19(consumerAccount, list);
    }

    public static /* synthetic */ h.c.h0 n(ConsumerTransferRepository consumerTransferRepository, TransferValue transferValue, String str, ConsumerAccount consumerAccount) {
        return m907getAvailableSendTransfer$lambda22(consumerTransferRepository, transferValue, str, consumerAccount);
    }

    public static /* synthetic */ h.c.h0 o(ConsumerTransferRepository consumerTransferRepository, TransferValue transferValue, ConsumerAccount consumerAccount, AvailableSendTransfer availableSendTransfer, Four four) {
        return m915getAvailableTransfers$lambda20$lambda17$lambda16(consumerTransferRepository, transferValue, consumerAccount, availableSendTransfer, four);
    }

    public static /* synthetic */ kotlin.t q(ConsumerSendFee consumerSendFee, ConsumerUser consumerUser, BigDecimal bigDecimal) {
        return m911getAvailableSendTransferAndExchangeRate$lambda31$lambda30(consumerSendFee, consumerUser, bigDecimal);
    }

    public static /* synthetic */ List r(ConsumerTransferRepository consumerTransferRepository, ConsumerAccount consumerAccount, AvailableSendTransfer availableSendTransfer, TransferValue transferValue, boolean z, List list) {
        return m916getAvailableTransfers$lambda20$lambda17$lambda16$lambda14(consumerTransferRepository, consumerAccount, availableSendTransfer, transferValue, z, list);
    }

    /* renamed from: refreshAccountBalance$lambda-28 */
    public static final ConsumerAccount m923refreshAccountBalance$lambda28(ConsumerAccount account, Account latestAccount) {
        ConsumerAccount copy;
        kotlin.jvm.internal.m.g(account, "$account");
        kotlin.jvm.internal.m.g(latestAccount, "latestAccount");
        String amount = latestAccount.getBalance().getAmount();
        kotlin.jvm.internal.m.f(amount, "latestAccount.balance.amount");
        BigInteger asBigInteger = BigDecimal_CommonKt.asBigInteger(new BigDecimal(amount), account.getDecimals());
        String id = latestAccount.getId();
        kotlin.jvm.internal.m.f(id, "latestAccount.id");
        copy = account.copy((r22 & 1) != 0 ? account.getId() : id, (r22 & 2) != 0 ? account.name : null, (r22 & 4) != 0 ? account.balance : asBigInteger, (r22 & 8) != 0 ? account.currencyCode : null, (r22 & 16) != 0 ? account.currencyName : null, (r22 & 32) != 0 ? account.decimals : 0, (r22 & 64) != 0 ? account.type : null, (r22 & 128) != 0 ? account.imageUrl : null, (r22 & 256) != 0 ? account.destinationTagName : null, (r22 & 512) != 0 ? account.assetId : null);
        return copy;
    }

    /* renamed from: refreshBlocking$lambda-7$lambda-3 */
    public static final kotlin.x m924refreshBlocking$lambda7$lambda3(RefreshState refreshState, AtomicReference requestId) {
        kotlin.jvm.internal.m.g(refreshState, "$refreshState");
        kotlin.jvm.internal.m.g(requestId, "$requestId");
        refreshState.cancel();
        requestId.set(refreshState.start());
        return kotlin.x.a;
    }

    /* renamed from: refreshBlocking$lambda-7$lambda-4 */
    public static final h.c.h0 m925refreshBlocking$lambda7$lambda4(h.c.b0 refreshSingle, kotlin.x it) {
        kotlin.jvm.internal.m.g(refreshSingle, "$refreshSingle");
        kotlin.jvm.internal.m.g(it, "it");
        return refreshSingle;
    }

    /* renamed from: refreshBlocking$lambda-7$lambda-5 */
    public static final kotlin.x m926refreshBlocking$lambda7$lambda5(RefreshState refreshState, AtomicReference requestId, kotlin.x it) {
        kotlin.jvm.internal.m.g(refreshState, "$refreshState");
        kotlin.jvm.internal.m.g(requestId, "$requestId");
        kotlin.jvm.internal.m.g(it, "it");
        refreshState.completed((String) requestId.get());
        return kotlin.x.a;
    }

    /* renamed from: refreshBlocking$lambda-7$lambda-6 */
    public static final void m927refreshBlocking$lambda7$lambda6(RefreshState refreshState, AtomicReference requestId, Throwable th) {
        kotlin.jvm.internal.m.g(refreshState, "$refreshState");
        kotlin.jvm.internal.m.g(requestId, "$requestId");
        refreshState.failed((String) requestId.get());
    }

    /* renamed from: refreshPaymentMethods$lambda-10 */
    public static final h.c.h0 m928refreshPaymentMethods$lambda10(ConsumerTransferRepository this$0, kotlin.o dstr$paymentMethods$availablePaymentMethods) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$paymentMethods$availablePaymentMethods, "$dstr$paymentMethods$availablePaymentMethods");
        final List list = (List) dstr$paymentMethods$availablePaymentMethods.a();
        final List list2 = (List) dstr$paymentMethods$availablePaymentMethods.b();
        return h.c.t0.f.a(this$0.consumerPaymentMethodsDAO.deleteAll(), this$0.consumerAvailablePaymentMethodsDAO.deleteAll()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.n1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.w(list, list2, (kotlin.o) obj);
            }
        });
    }

    /* renamed from: refreshPaymentMethods$lambda-10$lambda-9 */
    public static final kotlin.o m929refreshPaymentMethods$lambda10$lambda9(List paymentMethods, List list, kotlin.o it) {
        kotlin.jvm.internal.m.g(paymentMethods, "$paymentMethods");
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.u.a(paymentMethods, list);
    }

    /* renamed from: refreshPaymentMethods$lambda-11 */
    public static final h.c.h0 m930refreshPaymentMethods$lambda11(ConsumerTransferRepository this$0, kotlin.o dstr$paymentMethods$availablePaymentMethods) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$paymentMethods$availablePaymentMethods, "$dstr$paymentMethods$availablePaymentMethods");
        List<ConsumerAvailablePaymentMethod> availablePaymentMethods = (List) dstr$paymentMethods$availablePaymentMethods.b();
        h.c.b0<List<ConsumerPaymentMethod>> save = this$0.consumerPaymentMethodsDAO.save((List) dstr$paymentMethods$availablePaymentMethods.a());
        ConsumerAvailablePaymentMethodsDAO consumerAvailablePaymentMethodsDAO = this$0.consumerAvailablePaymentMethodsDAO;
        kotlin.jvm.internal.m.f(availablePaymentMethods, "availablePaymentMethods");
        return h.c.t0.f.a(save, consumerAvailablePaymentMethodsDAO.save(availablePaymentMethods));
    }

    /* renamed from: refreshPaymentMethods$lambda-12 */
    public static final h.c.h0 m931refreshPaymentMethods$lambda12(h.c.b0 refreshSingle, ConsumerConnectionStatus connectStatus) {
        kotlin.jvm.internal.m.g(refreshSingle, "$refreshSingle");
        kotlin.jvm.internal.m.g(connectStatus, "connectStatus");
        if (connectStatus.getOnrampEnabled()) {
            return refreshSingle;
        }
        h.c.b0 just = h.c.b0.just(kotlin.x.a);
        kotlin.jvm.internal.m.f(just, "just(Unit)");
        return just;
    }

    /* renamed from: refreshPaymentMethods$lambda-8 */
    public static final h.c.h0 m932refreshPaymentMethods$lambda8(ConsumerTransferRepository this$0, ConsumerUser it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return h.c.t0.f.a(this$0.consumerAPI.paymentMethods(), this$0.consumerAPI.availablePaymentMethods());
    }

    private final h.c.k0.b refreshRepository(final Refreshable refreshable, final RefreshState refreshState, final boolean z) {
        h.c.k0.b c2 = getRefreshScheduler().c(new Runnable() { // from class: com.coinbase.wallet.consumer.repositories.o1
            @Override // java.lang.Runnable
            public final void run() {
                ConsumerTransferRepository.x(z, refreshState, refreshable);
            }
        });
        kotlin.jvm.internal.m.f(c2, "refreshScheduler.scheduleDirect {\n        if (isForced) refreshState.cancel()\n        if (!refreshState.canRefresh()) return@scheduleDirect\n        val requestId = refreshState.start()\n        val refreshSingle = if (repository is ConsumerTransferRepository) {\n            repository.refreshPaymentMethods()\n        } else {\n            repository.refresh(isForced)\n        }\n\n        refreshSingle\n            .subscribeBy(\n                onSuccess = { refreshState.completed(requestId) },\n                onError = { refreshState.failed(requestId) }\n            )\n            .addTo(refreshState.disposeBag)\n    }");
        return c2;
    }

    /* renamed from: refreshRepository$lambda-40 */
    public static final void m933refreshRepository$lambda40(boolean z, RefreshState refreshState, Refreshable repository) {
        h.c.b0<kotlin.x> refresh;
        kotlin.jvm.internal.m.g(refreshState, "$refreshState");
        kotlin.jvm.internal.m.g(repository, "$repository");
        if (z) {
            refreshState.cancel();
        }
        if (refreshState.canRefresh()) {
            String start = refreshState.start();
            if (repository instanceof ConsumerTransferRepository) {
                refresh = ((ConsumerTransferRepository) repository).refreshPaymentMethods();
            } else {
                refresh = repository.refresh(z);
            }
            h.c.t0.a.a(h.c.t0.g.f(refresh, new ConsumerTransferRepository$refreshRepository$1$1(refreshState, start), new ConsumerTransferRepository$refreshRepository$1$2(refreshState, start)), refreshState.getDisposeBag());
        }
    }

    public static /* synthetic */ Optional s(ConsumerBuyOrder consumerBuyOrder) {
        return m920getBuyQuote$lambda38(consumerBuyOrder);
    }

    /* renamed from: send$lambda-26 */
    public static final h.c.h0 m934send$lambda26(Blockchain blockchain, ConsumerAccount account, ConsumerTransferRepository this$0, final ReceivableWallet receiveWallet, final String txId) {
        h.c.b0 just;
        kotlin.jvm.internal.m.g(blockchain, "$blockchain");
        kotlin.jvm.internal.m.g(account, "$account");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(receiveWallet, "$receiveWallet");
        kotlin.jvm.internal.m.g(txId, "txId");
        if (kotlin.jvm.internal.m.c(blockchain, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)) && account.getAssetId() != null) {
            just = this$0.consumerAPI.getAsset(account.getAssetId()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.p1
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ConsumerTransferRepository.y(ConsumerTransferRepository.this, receiveWallet, (ConsumerAsset) obj);
                }
            });
        } else {
            just = h.c.b0.just(kotlin.x.a);
        }
        kotlin.jvm.internal.m.f(just, "if (blockchain == Blockchain.ETHEREUM && account.assetId != null) {\n                    consumerAPI\n                        .getAsset(assetID = account.assetId)\n                        .flatMap { asset ->\n                            val contractAddress = asset.contractAddress\n                            if (contractAddress != null) {\n                                erc20Owning\n                                    .takeOwnership(\n                                        receiveWallet.address,\n                                        receiveWallet.index,\n                                        contractAddress,\n                                        EthereumChain.ETHEREUM_MAINNET.asNetwork\n                                    )\n                                    .logError()\n                                    .onErrorReturn { Unit }\n                            } else {\n                                Single.just(Unit)\n                            }\n                        }\n                } else {\n                    Single.just(Unit)\n                }");
        return just.map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.z0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.i(txId, (kotlin.x) obj);
            }
        });
    }

    /* renamed from: send$lambda-26$lambda-24 */
    public static final h.c.h0 m935send$lambda26$lambda24(ConsumerTransferRepository this$0, ReceivableWallet receiveWallet, ConsumerAsset asset) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(receiveWallet, "$receiveWallet");
        kotlin.jvm.internal.m.g(asset, "asset");
        String contractAddress = asset.getContractAddress();
        if (contractAddress != null) {
            return Single_AnalyticsKt.logError$default(this$0.erc20Owning.takeOwnership(receiveWallet.getAddress(), receiveWallet.getIndex(), contractAddress, EthereumChain_EthereumKt.getAsNetwork(EthereumChain.ETHEREUM_MAINNET)), null, null, 3, null).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.s0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ConsumerTransferRepository.b((Throwable) obj);
                }
            });
        }
        return h.c.b0.just(kotlin.x.a);
    }

    /* renamed from: send$lambda-26$lambda-24$lambda-23 */
    public static final kotlin.x m936send$lambda26$lambda24$lambda23(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    /* renamed from: send$lambda-26$lambda-25 */
    public static final String m937send$lambda26$lambda25(String txId, kotlin.x it) {
        kotlin.jvm.internal.m.g(txId, "$txId");
        kotlin.jvm.internal.m.g(it, "it");
        return txId;
    }

    /* renamed from: send$lambda-27 */
    public static final kotlin.x m938send$lambda27(Blockchain blockchain, ReceivableWallet receiveWallet, ConsumerAccount account, CurrencyCode currencyCode, BigInteger amount, BigInteger estimatedFee, ConsumerTransferRepository this$0, String txId) {
        Map l2;
        kotlin.jvm.internal.m.g(blockchain, "$blockchain");
        kotlin.jvm.internal.m.g(receiveWallet, "$receiveWallet");
        kotlin.jvm.internal.m.g(account, "$account");
        kotlin.jvm.internal.m.g(currencyCode, "$currencyCode");
        kotlin.jvm.internal.m.g(amount, "$amount");
        kotlin.jvm.internal.m.g(estimatedFee, "$estimatedFee");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(txId, "txId");
        Network mainnetNetworkCode = Network_CommonKt.mainnetNetworkCode(blockchain);
        if (mainnetNetworkCode != null) {
            String uuid = UUID.randomUUID().toString();
            Date date = new Date();
            String address = receiveWallet.getAddress();
            TxMetadataKey.Companion companion = TxMetadataKey.Companion;
            l2 = kotlin.a0.m0.l(kotlin.u.a(TxMetadataKey_ConsumerConnectKt.getConsumerTxID(companion), txId), kotlin.u.a(TxMetadataKey_ConsumerConnectKt.getConsumerAccountID(companion), account.getId()));
            TxMetadata txMetadata = new TxMetadata(l2);
            TxState txState = TxState.PENDING;
            kotlin.jvm.internal.m.f(uuid, "toString()");
            this$0.submittedTxSubject.onNext(new Transaction(uuid, date, null, blockchain, currencyCode, currencyCode, address, null, amount, estimatedFee, null, txState, txMetadata, mainnetNetworkCode, null, false, 1024, null));
            return kotlin.x.a;
        }
        throw new NetworkException.MissingMainnetNetwork(blockchain);
    }

    public static /* synthetic */ List t(TransferValue transferValue, ConsumerTransferRepository consumerTransferRepository, List list) {
        return m918getAvailableTransfers$lambda20$lambda18(transferValue, consumerTransferRepository, list);
    }

    private final String toConsumerBuyAmount(BigInteger bigInteger, ConsumerAccount consumerAccount) {
        String plainString = BigInteger_CommonKt.asBigDecimal(bigInteger, consumerAccount.getDecimals()).setScale(consumerAccount.getTransferDecimals(), RoundingMode.UP).toPlainString();
        kotlin.jvm.internal.m.f(plainString, "asBigDecimal(account.decimals)\n            .setScale(account.transferDecimals, RoundingMode.UP)\n            .toPlainString()");
        return plainString;
    }

    private final String toConsumerSendAmount(BigInteger bigInteger, ConsumerAccount consumerAccount) {
        String plainString = BigInteger_CommonKt.asBigDecimal(bigInteger, consumerAccount.getDecimals()).setScale(consumerAccount.getTransferDecimals(), RoundingMode.DOWN).toPlainString();
        kotlin.jvm.internal.m.f(plainString, "asBigDecimal(account.decimals)\n            .setScale(account.transferDecimals, RoundingMode.DOWN)\n            .toPlainString()");
        return plainString;
    }

    private final BigInteger toCrypto(BigDecimal bigDecimal, BigDecimal bigDecimal2, ConsumerAccount consumerAccount) {
        BigDecimal multiply = bigDecimal.multiply(bigDecimal2, MathContext.DECIMAL128);
        kotlin.jvm.internal.m.f(multiply, "multiply(consumerNativeExchangeRate, MathContext.DECIMAL128)");
        return BigDecimal_CommonKt.asBigInteger(multiply, consumerAccount.getDecimals());
    }

    public static /* synthetic */ ConsumerAccount u(ConsumerAccount consumerAccount, Account account) {
        return m923refreshAccountBalance$lambda28(consumerAccount, account);
    }

    public static /* synthetic */ h.c.h0 v(ConsumerTransferRepository consumerTransferRepository, ConsumerUser consumerUser) {
        return m932refreshPaymentMethods$lambda8(consumerTransferRepository, consumerUser);
    }

    public static /* synthetic */ kotlin.o w(List list, List list2, kotlin.o oVar) {
        return m929refreshPaymentMethods$lambda10$lambda9(list, list2, oVar);
    }

    public static /* synthetic */ void x(boolean z, RefreshState refreshState, Refreshable refreshable) {
        m933refreshRepository$lambda40(z, refreshState, refreshable);
    }

    public static /* synthetic */ h.c.h0 y(ConsumerTransferRepository consumerTransferRepository, ReceivableWallet receivableWallet, ConsumerAsset consumerAsset) {
        return m935send$lambda26$lambda24(consumerTransferRepository, receivableWallet, consumerAsset);
    }

    public static /* synthetic */ void z(RefreshState refreshState, AtomicReference atomicReference, Throwable th) {
        m927refreshBlocking$lambda7$lambda6(refreshState, atomicReference, th);
    }

    public final h.c.b0<ConsumerBuyOrder> commitBuy(ConsumerAccount account, String buyOrderId) {
        kotlin.jvm.internal.m.g(account, "account");
        kotlin.jvm.internal.m.g(buyOrderId, "buyOrderId");
        return this.consumerAPI.commitBuy(account, buyOrderId);
    }

    public final h.c.b0<ConsumerBuyOrder> completeBuyOrderAfterSecure3DVerification(ConsumerAccount account, String buyOrderId, String redirectString) {
        kotlin.jvm.internal.m.g(account, "account");
        kotlin.jvm.internal.m.g(buyOrderId, "buyOrderId");
        kotlin.jvm.internal.m.g(redirectString, "redirectString");
        return this.consumerAPI.completeBuyOrder(account, buyOrderId, redirectString);
    }

    public final h.c.b0<kotlin.x> completeCardCDVVerification(String paymentMethodId, String amount1, String amount2) {
        kotlin.jvm.internal.m.g(paymentMethodId, "paymentMethodId");
        kotlin.jvm.internal.m.g(amount1, "amount1");
        kotlin.jvm.internal.m.g(amount2, "amount2");
        return this.consumerAPI.completeCardCDVVerification(paymentMethodId, amount1, amount2);
    }

    public final h.c.b0<kotlin.x> delete() {
        return Single_CoreKt.asUnit(h.c.t0.f.a(this.consumerPaymentMethodsDAO.deleteAll(), this.consumerAvailablePaymentMethodsDAO.deleteAll()));
    }

    public final h.c.s<List<ConsumerAvailablePaymentMethod>> getAvailablePaymentMethodsObservable() {
        return this.consumerAvailablePaymentMethodsDAO.observeAvailablePaymentMethods();
    }

    public final h.c.b0<ConsumerAvailableTransferContainer> getAvailableSendTransfer(ConsumerAccount account, final TransferValue amount, final String toAddress) {
        kotlin.o a;
        kotlin.jvm.internal.m.g(account, "account");
        kotlin.jvm.internal.m.g(amount, "amount");
        kotlin.jvm.internal.m.g(toAddress, "toAddress");
        UUID uuid = UUID.randomUUID();
        if (amount instanceof TransferValue.EntireBalance) {
            AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
            CurrencyCode currencyCode = account.getCurrencyCode();
            kotlin.jvm.internal.m.f(uuid, "uuid");
            a = kotlin.u.a(AnalyticsEvent_ConsumerKt.consumerMaxTransferStarted(companion, currencyCode, uuid, false), AnalyticsEvent_ConsumerKt.consumerMaxTransferCompleted(companion, account.getCurrencyCode(), uuid, false));
        } else if (amount instanceof TransferValue.Amount) {
            AnalyticsEvent.Companion companion2 = AnalyticsEvent.Companion;
            CurrencyCode currencyCode2 = account.getCurrencyCode();
            kotlin.jvm.internal.m.f(uuid, "uuid");
            a = kotlin.u.a(AnalyticsEvent_ConsumerKt.consumerAvailableTransferStarted(companion2, currencyCode2, uuid, false), AnalyticsEvent_ConsumerKt.consumerAvailableTransferCompleted(companion2, account.getCurrencyCode(), uuid, false));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        h.c.b0 onSubscribeTrack = Single_AnalyticsKt.onSubscribeTrack(refreshAccountBalance(account), (AnalyticsEvent) a.a());
        kotlin.jvm.internal.m.f(onSubscribeTrack, "refreshAccountBalance(account)\n            .onSubscribeTrack(startEvent)");
        h.c.b0<ConsumerAvailableTransferContainer> flatMap = Single_AnalyticsKt.onSuccessTrack(onSubscribeTrack, (AnalyticsEvent) a.b()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.e1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.n(ConsumerTransferRepository.this, amount, toAddress, (ConsumerAccount) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "refreshAccountBalance(account)\n            .onSubscribeTrack(startEvent)\n            .onSuccessTrack(endEvent)\n            .flatMap { latestAccount ->\n                getAvailableSendTransferAndExchangeRate(\n                    account = latestAccount,\n                    amount = amount,\n                    toAddress = toAddress\n                )\n                    .map { (transfer, _) ->\n                        ConsumerAvailableTransferContainer(transfer.transferAmount, listOf(transfer), latestAccount)\n                    }\n            }");
        return flatMap;
    }

    public final h.c.b0<ConsumerAvailableTransferContainer> getAvailableTransfers(ConsumerAccount account, final TransferValue amount, final String toAddress) {
        kotlin.o a;
        kotlin.jvm.internal.m.g(account, "account");
        kotlin.jvm.internal.m.g(amount, "amount");
        kotlin.jvm.internal.m.g(toAddress, "toAddress");
        UUID uuid = UUID.randomUUID();
        if (amount instanceof TransferValue.EntireBalance) {
            AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
            CurrencyCode currencyCode = account.getCurrencyCode();
            kotlin.jvm.internal.m.f(uuid, "uuid");
            a = kotlin.u.a(AnalyticsEvent_ConsumerKt.consumerMaxTransferStarted(companion, currencyCode, uuid, true), AnalyticsEvent_ConsumerKt.consumerMaxTransferCompleted(companion, account.getCurrencyCode(), uuid, true));
        } else if (amount instanceof TransferValue.Amount) {
            AnalyticsEvent.Companion companion2 = AnalyticsEvent.Companion;
            CurrencyCode currencyCode2 = account.getCurrencyCode();
            kotlin.jvm.internal.m.f(uuid, "uuid");
            a = kotlin.u.a(AnalyticsEvent_ConsumerKt.consumerAvailableTransferStarted(companion2, currencyCode2, uuid, true), AnalyticsEvent_ConsumerKt.consumerAvailableTransferCompleted(companion2, account.getCurrencyCode(), uuid, true));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        h.c.b0 onSubscribeTrack = Single_AnalyticsKt.onSubscribeTrack(refreshAccountBalance(account), (AnalyticsEvent) a.a());
        kotlin.jvm.internal.m.f(onSubscribeTrack, "refreshAccountBalance(account)\n            .onSubscribeTrack(startEvent)");
        h.c.b0<ConsumerAvailableTransferContainer> flatMap = Single_AnalyticsKt.onSuccessTrack(onSubscribeTrack, (AnalyticsEvent) a.b()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.b1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.k(ConsumerTransferRepository.this, amount, toAddress, (ConsumerAccount) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "refreshAccountBalance(account)\n            .onSubscribeTrack(startEvent)\n            .onSuccessTrack(endEvent)\n            .flatMap { latestAccount ->\n                getAvailableSendTransferAndExchangeRate(latestAccount, amount, toAddress)\n                    .flatMap { (sendTransfer, consumerNativeExchangeRate) ->\n                        val fundedSendAmountStr = when (amount) {\n                            is TransferValue.EntireBalance -> {\n                                // Doesn't matter what the amount is, we call the funded send api to get buy limits\n                                val minSendAmount = BigDecimal(\"10.0\")\n                                    .toCrypto(consumerNativeExchangeRate, latestAccount)\n                                minSendAmount.plus(sendTransfer.maxAmountCrypto).toConsumerBuyAmount(latestAccount)\n                            }\n                            is TransferValue.Amount -> {\n                                amount.value.plus(sendTransfer.maxAmountCrypto).toConsumerBuyAmount(latestAccount)\n                            }\n                        }\n\n                        Singles\n                            .zip(\n                                paymentMethodsObservable.takeSingle(),\n                                consumerAPI.fundedSend(latestAccount, fundedSendAmountStr),\n                                consumerUserRepository.userObservable.unwrap().takeSingle(),\n                                featureFlagsRepository.value(FeatureFlag.ONRAMP_EU)\n                            )\n                            .logError()\n                            .flatMap { (paymentMethods, sendPreview, user, onrampEUEnabled) ->\n                                val buyOrderSingleList = createBuyOrders(\n                                    paymentMethods,\n                                    sendPreview,\n                                    user,\n                                    amount,\n                                    latestAccount,\n                                    sendTransfer,\n                                    onrampEUEnabled\n                                )\n\n                                buyOrderSingleList\n                                    .zipOrEmpty()\n                                    .map { buyOrders ->\n                                        convertBuyOrdersIntoBuyTransfers(\n                                            buyOrders,\n                                            latestAccount,\n                                            sendTransfer,\n                                            amount,\n                                            onrampEUEnabled\n                                        )\n                                    }\n                                    .map { (listOf(sendTransfer) + it) }\n                            }\n                    }\n                    .map { availableTransfers ->\n                        val comparator: Comparator<AvailableTransfer> = when (amount) {\n                            is TransferValue.EntireBalance -> {\n                                entireBalanceComparator\n                            }\n                            is TransferValue.Amount -> {\n                                amountComparator(amount)\n                            }\n                        }\n                        availableTransfers.sortedWith(comparator)\n                    }\n                    .map { ConsumerAvailableTransferContainer(it.first().transferAmount, it, latestAccount) }\n                    .logError()\n            }");
        return flatMap;
    }

    public final h.c.b0<BuyStatus> getCommitBuyStatus(ConsumerAccount account, ConsumerBuyOrder buyOrder) {
        kotlin.jvm.internal.m.g(account, "account");
        kotlin.jvm.internal.m.g(buyOrder, "buyOrder");
        return this.consumerAPI.getCommitBuyStatus(account.getId(), buyOrder.getId());
    }

    public final h.c.b0<ConsumerSendFee> getFeeEstimate(ConsumerAccount account, String toAddress) {
        kotlin.jvm.internal.m.g(account, "account");
        kotlin.jvm.internal.m.g(toAddress, "toAddress");
        return this.consumerAPI.getFeeEstimate(account, toAddress);
    }

    public final h.c.b0<ConsumerAvailableTransferContainer> getMaxTransfer(ConsumerAccount account, String toAddress) {
        kotlin.jvm.internal.m.g(account, "account");
        kotlin.jvm.internal.m.g(toAddress, "toAddress");
        h.c.b0 map = getAvailableTransfers(account, TransferValue.EntireBalance.INSTANCE, toAddress).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.t0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.c((ConsumerAvailableTransferContainer) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "getAvailableTransfers(account, TransferValue.EntireBalance, toAddress)\n            .map { transfers ->\n                val maxTransferableAmount =\n                    transfers.availableTransfers.firstOrNull()?.transferAmount ?: BigInteger.ZERO\n                ConsumerAvailableTransferContainer(\n                    maxTransferableAmount,\n                    transfers.availableTransfers,\n                    transfers.account\n                )\n            }");
        return map;
    }

    public final h.c.s<List<ConsumerPaymentMethod>> getPaymentMethodsObservable() {
        return this.consumerPaymentMethodsDAO.observePaymentMethods();
    }

    public final h.c.s<Transaction> getSubmittedTxObservable() {
        return this.submittedTxObservable;
    }

    @Override // com.coinbase.wallet.core.interfaces.Refreshable
    public h.c.b0<kotlin.x> refresh(boolean z) {
        for (Map.Entry<Refreshable, RefreshState> entry : this.refreshableMap.entrySet()) {
            refreshRepository(entry.getKey(), entry.getValue(), z);
        }
        h.c.b0<kotlin.x> just = h.c.b0.just(kotlin.x.a);
        kotlin.jvm.internal.m.f(just, "just(Unit)");
        return just;
    }

    public final h.c.b0<ConsumerAccount> refreshAccountBalance(final ConsumerAccount account) {
        kotlin.jvm.internal.m.g(account, "account");
        h.c.b0<R> map = this.consumerAPI.getAccount(account.getId()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.l1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.u(ConsumerAccount.this, (Account) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "consumerAPI\n            .getAccount(id = account.id)\n            .map { latestAccount ->\n                val newBalance = latestAccount.balance.amount.toBigDecimal().asBigInteger(account.decimals)\n                account.copy(id = latestAccount.id, balance = newBalance)\n            }");
        return Single_AnalyticsKt.logError$default(map, null, null, 3, null);
    }

    public final h.c.b0<kotlin.x> refreshBlocking(List<? extends Refreshable> refreshables) {
        h.c.b0 zip;
        List g2;
        final h.c.b0<kotlin.x> refresh;
        kotlin.jvm.internal.m.g(refreshables, "refreshables");
        Map<Refreshable, RefreshState> map = this.refreshableMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Refreshable, RefreshState> entry : map.entrySet()) {
            if (refreshables.contains(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Refreshable refreshable = (Refreshable) entry2.getKey();
            final RefreshState refreshState = (RefreshState) entry2.getValue();
            if (refreshable instanceof ConsumerTransferRepository) {
                refresh = ((ConsumerTransferRepository) refreshable).refreshPaymentMethods();
            } else {
                refresh = refreshable.refresh(true);
            }
            final AtomicReference atomicReference = new AtomicReference();
            h.c.b0 doOnError = h.c.b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.consumer.repositories.y1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return ConsumerTransferRepository.G(RefreshState.this, atomicReference);
                }
            }).subscribeOn(getRefreshScheduler()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.v1
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    h.c.h0 m925refreshBlocking$lambda7$lambda4;
                    m925refreshBlocking$lambda7$lambda4 = ConsumerTransferRepository.m925refreshBlocking$lambda7$lambda4(h.c.b0.this, (kotlin.x) obj);
                    return m925refreshBlocking$lambda7$lambda4;
                }
            }).observeOn(getRefreshScheduler()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.u0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ConsumerTransferRepository.d(RefreshState.this, atomicReference, (kotlin.x) obj);
                }
            }).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.consumer.repositories.q1
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    ConsumerTransferRepository.z(RefreshState.this, atomicReference, (Throwable) obj);
                }
            });
            if (doOnError != null) {
                arrayList.add(doOnError);
            }
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository$refreshBlocking$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it, "it");
                    if (it.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int length = it.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = it[i2];
                        if (obj != null ? obj instanceof kotlin.x : true) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        return Single_CoreKt.asUnit(zip);
    }

    public final h.c.b0<kotlin.x> refreshPaymentMethods() {
        if (!this.consumerUserRepository.isAuthenticated()) {
            h.c.b0<kotlin.x> just = h.c.b0.just(kotlin.x.a);
            kotlin.jvm.internal.m.f(just, "just(Unit)");
            return just;
        }
        h.c.s<R> map = this.consumerUserRepository.getUserObservable().filter(new h.c.m0.p() { // from class: com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository$refreshPaymentMethods$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository$refreshPaymentMethods$$inlined$unwrap$2
            public final T apply(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        kotlin.jvm.internal.m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        h.c.b0 flatMap = Observable_CoreKt.takeSingle(map).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.m1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.v(ConsumerTransferRepository.this, (ConsumerUser) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.c1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.l(ConsumerTransferRepository.this, (kotlin.o) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.a1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.j(ConsumerTransferRepository.this, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "consumerUserRepository.userObservable\n            .unwrap()\n            .takeSingle()\n            .flatMap {\n                consumerAPI.paymentMethods()\n                    .zipWith(consumerAPI.availablePaymentMethods())\n            }\n            .flatMap { (paymentMethods, availablePaymentMethods) ->\n                consumerPaymentMethodsDAO\n                    .deleteAll()\n                    .zipWith(consumerAvailablePaymentMethodsDAO.deleteAll())\n                    .map { paymentMethods to availablePaymentMethods }\n            }\n            .flatMap { (paymentMethods, availablePaymentMethods) ->\n                consumerPaymentMethodsDAO.save(paymentMethods)\n                    .zipWith(consumerAvailablePaymentMethodsDAO.save(availablePaymentMethods))\n            }");
        final h.c.b0 logError$default = Single_AnalyticsKt.logError$default(Single_CoreKt.asUnit(flatMap), null, null, 3, null);
        h.c.b0 flatMap2 = this.consumerUserRepository.getConnectStatus(true).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.t1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                h.c.h0 m931refreshPaymentMethods$lambda12;
                m931refreshPaymentMethods$lambda12 = ConsumerTransferRepository.m931refreshPaymentMethods$lambda12(h.c.b0.this, (ConsumerConnectionStatus) obj);
                return m931refreshPaymentMethods$lambda12;
            }
        });
        kotlin.jvm.internal.m.f(flatMap2, "consumerUserRepository.getConnectStatus(requireRefresh = true)\n            .flatMap { connectStatus ->\n                if (connectStatus.onrampEnabled) refreshSingle else Single.just(Unit)\n            }");
        return flatMap2;
    }

    public final h.c.s<List<ConsumerTx>> reloadTransactions(String accountId) {
        kotlin.jvm.internal.m.g(accountId, "accountId");
        h.c.s<List<ConsumerTx>> observable = this.consumerAPI.getTransactions(accountId).toObservable();
        kotlin.jvm.internal.m.f(observable, "consumerAPI.getTransactions(accountId).toObservable()");
        return observable;
    }

    public final h.c.b0<kotlin.x> send(final ConsumerAccount account, final ReceivableWallet receiveWallet, final BigInteger amount, final BigInteger estimatedFee, final CurrencyCode currencyCode, final Blockchain blockchain, Boolean bool, String str) {
        kotlin.jvm.internal.m.g(account, "account");
        kotlin.jvm.internal.m.g(receiveWallet, "receiveWallet");
        kotlin.jvm.internal.m.g(amount, "amount");
        kotlin.jvm.internal.m.g(estimatedFee, "estimatedFee");
        kotlin.jvm.internal.m.g(currencyCode, "currencyCode");
        kotlin.jvm.internal.m.g(blockchain, "blockchain");
        String consumerSendAmount = toConsumerSendAmount(amount, account);
        String estimatedFeeString = BigInteger_CommonKt.asBigDecimal(estimatedFee, account.getDecimals()).toPlainString();
        ConsumerAPI consumerAPI = this.consumerAPI;
        String id = account.getId();
        String address = receiveWallet.getAddress();
        kotlin.jvm.internal.m.f(estimatedFeeString, "estimatedFeeString");
        h.c.b0<kotlin.x> map = consumerAPI.send(id, address, consumerSendAmount, estimatedFeeString, currencyCode, bool, str).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.x0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.g(Blockchain.this, account, this, receiveWallet, (String) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.v0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferRepository.e(Blockchain.this, receiveWallet, account, currencyCode, amount, estimatedFee, this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "consumerAPI\n            .send(\n                account.id,\n                receiveWallet.address,\n                amountStr,\n                estimatedFeeString,\n                currencyCode,\n                noDestinationTag,\n                twoFactor\n            )\n            .flatMap { txId ->\n                val takeOwnershipSingle = if (blockchain == Blockchain.ETHEREUM && account.assetId != null) {\n                    consumerAPI\n                        .getAsset(assetID = account.assetId)\n                        .flatMap { asset ->\n                            val contractAddress = asset.contractAddress\n                            if (contractAddress != null) {\n                                erc20Owning\n                                    .takeOwnership(\n                                        receiveWallet.address,\n                                        receiveWallet.index,\n                                        contractAddress,\n                                        EthereumChain.ETHEREUM_MAINNET.asNetwork\n                                    )\n                                    .logError()\n                                    .onErrorReturn { Unit }\n                            } else {\n                                Single.just(Unit)\n                            }\n                        }\n                } else {\n                    Single.just(Unit)\n                }\n\n                takeOwnershipSingle\n                    .map { txId }\n            }\n            .map { txId ->\n                val network = blockchain.mainnetNetworkCode()\n                    ?: throw NetworkException.MissingMainnetNetwork(blockchain)\n\n                val tx = Transaction(\n                    id = UUID.randomUUID().toString(),\n                    createdAt = Date(),\n                    confirmedAt = null,\n                    currencyCode = currencyCode,\n                    feeCurrencyCode = currencyCode,\n                    toAddress = receiveWallet.address,\n                    fromAddress = null,\n                    amount = amount,\n                    fee = estimatedFee,\n                    metadata = TxMetadata(\n                        mapOf(TxMetadataKey.consumerTxID to txId, TxMetadataKey.consumerAccountID to account.id)\n                    ),\n                    state = TxState.PENDING,\n                    network = network,\n                    txHash = null,\n                    isSent = false,\n                    blockchain = blockchain\n                )\n\n                submittedTxSubject.onNext(tx)\n            }");
        return map;
    }
}