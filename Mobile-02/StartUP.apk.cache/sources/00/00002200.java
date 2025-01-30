package com.coinbase.wallet.features.swap.viewmodels;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.blockchains.models.AddressType;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.common.extensions.BigDecimal_CommonKt;
import com.coinbase.wallet.common.extensions.BigInteger_CommonKt;
import com.coinbase.wallet.common.extensions.SafeWhen_CommonKt;
import com.coinbase.wallet.common.extensions.String_CommonKt;
import com.coinbase.wallet.common.extensions.WalletRepository_CommonKt;
import com.coinbase.wallet.common.utilities.Locales;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.NumberKeyboardInputView_CommonKt;
import com.coinbase.wallet.commonui.extensions.RawStringResult;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.commonui.utilities.AmountPickerFormatter;
import com.coinbase.wallet.commonui.utilities.AmountText;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.commonui.views.NumberKeyboardDigit;
import com.coinbase.wallet.commonui.views.NumberKeyboardInputView;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.extensions.AddressKind_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.features.swap.models.SwapAmountPickerError;
import com.coinbase.wallet.features.swap.models.SwapAmountPickerEvent;
import com.coinbase.wallet.features.swap.models.SwapAmountPickerViewState;
import com.coinbase.wallet.features.swap.models.SwapAssetPickerArgs;
import com.coinbase.wallet.features.swap.models.SwapCurrencyType;
import com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel;
import com.coinbase.wallet.features.wallets.extensions.Wallet_ApplicationKt;
import com.coinbase.wallet.features.wallets.extensions.legacy.Network_ApplicationKt;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.swap.interfaces.ISwapRepository;
import com.coinbase.wallet.swap.models.Aggregator;
import com.coinbase.wallet.swap.models.AmountBase;
import com.coinbase.wallet.swap.models.SwapAsset;
import com.coinbase.wallet.swap.models.SwapAssetStats;
import com.coinbase.wallet.swap.models.SwapQuote;
import com.coinbase.wallet.swap.models.SwapQuoteException;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import com.toshi.model.local.authentication.AuthenticationMethod;
import io.reactivex.exceptions.CompositeException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.t0;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.toshi.R;

/* compiled from: SwapAmountPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\b\u0098\u0001\u0099\u0001\u009a\u0001\u009b\u0001BA\b\u0007\u0012\b\u0010\u0095\u0001\u001a\u00030\u0094\u0001\u0012\u0006\u0010o\u001a\u00020n\u0012\u0006\u0010~\u001a\u00020}\u0012\u0006\u0010U\u001a\u00020T\u0012\u0006\u0010v\u001a\u00020u\u0012\n\b\u0001\u0010\u008c\u0001\u001a\u00030\u008b\u0001¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0015J3\u0010\u001b\u001a\u00020\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ-\u0010 \u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u0012H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\u0012H\u0002¢\u0006\u0004\b#\u0010$J\u001f\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0002H\u0002¢\u0006\u0004\b(\u0010\u0004J\u001f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+2\b\u0010*\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0004\b-\u0010.J%\u00103\u001a\u000202*\u00020\u00062\u0006\u0010/\u001a\u00020\u00192\b\b\u0002\u00101\u001a\u000200H\u0002¢\u0006\u0004\b3\u00104J\u001b\u00106\u001a\u00020\u0019*\u00020\u00062\u0006\u00105\u001a\u000202H\u0002¢\u0006\u0004\b6\u00107J\u0013\u0010:\u001a\u000209*\u000208H\u0002¢\u0006\u0004\b:\u0010;J\u0013\u0010<\u001a\u00020\u0012*\u000208H\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0002H\u0014¢\u0006\u0004\b>\u0010\u0004J\u0015\u0010A\u001a\u00020\u00022\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bA\u0010BJ\u0015\u0010E\u001a\u00020\u00022\u0006\u0010D\u001a\u00020C¢\u0006\u0004\bE\u0010FJ\u001d\u0010G\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\bG\u0010\u0015J\r\u0010H\u001a\u00020\u0002¢\u0006\u0004\bH\u0010\u0004J\u0015\u0010J\u001a\u00020\u00022\u0006\u0010I\u001a\u000209¢\u0006\u0004\bJ\u0010KJ\u0015\u0010M\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u0006¢\u0006\u0004\bM\u0010\tJ\u0015\u0010N\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u0006¢\u0006\u0004\bN\u0010\tJ\r\u0010O\u001a\u00020\u0002¢\u0006\u0004\bO\u0010\u0004J\r\u0010P\u001a\u00020\u0002¢\u0006\u0004\bP\u0010\u0004J\r\u0010Q\u001a\u00020\u0002¢\u0006\u0004\bQ\u0010\u0004R\u0016\u0010R\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010U\u001a\u00020T8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010X\u001a\u00020W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00020[0Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R$\u0010`\u001a\u00020^2\u0006\u0010_\u001a\u00020^8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001f\u0010f\u001a\b\u0012\u0004\u0012\u00020e0d8\u0006@\u0006¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010iR\u001c\u0010j\u001a\b\u0012\u0004\u0012\u00020e0Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010]R\u001a\u0010m\u001a\u00020\u0019*\u00020\u00068B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bk\u0010lR\u0016\u0010o\u001a\u00020n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010q\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u001f\u0010s\u001a\b\u0012\u0004\u0012\u00020^0d8\u0006@\u0006¢\u0006\f\n\u0004\bs\u0010g\u001a\u0004\bt\u0010iR\u0016\u0010v\u001a\u00020u8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u001c\u0010y\u001a\b\u0012\u0004\u0012\u00020^0x8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u001a\u0010{\u001a\u00020\u0012*\u00020\u00068B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b{\u0010|R\u0016\u0010~\u001a\u00020}8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001a\u0010\u0081\u0001\u001a\u00030\u0080\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001f\u0010\u0084\u0001\u001a\t\u0012\u0005\u0012\u00030\u0083\u00010Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010]R9\u0010\u0087\u0001\u001a\n\u0012\u0005\u0012\u00030\u0086\u00010\u0085\u00012\u000e\u0010_\u001a\n\u0012\u0005\u0012\u00030\u0086\u00010\u0085\u00018\u0002@BX\u0082\u000e¢\u0006\u0010\n\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001a\u0010\u008c\u0001\u001a\u00030\u008b\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001f\u0010\u008f\u0001\u001a\t\u0012\u0005\u0012\u00030\u008e\u00010Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010]R#\u0010\u0090\u0001\u001a\t\u0012\u0005\u0012\u00030\u008e\u00010d8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0090\u0001\u0010g\u001a\u0005\b\u0091\u0001\u0010iR\"\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020[0d8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0092\u0001\u0010g\u001a\u0005\b\u0093\u0001\u0010i¨\u0006\u009c\u0001"}, d2 = {"Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel;", "Landroidx/lifecycle/b0;", "Lkotlin/x;", "setup", "()V", "preselectAsset", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "swapAsset", "populateAggregatorsForTarget", "(Lcom/coinbase/wallet/swap/models/SwapAsset;)V", "sourceAsset", "populateAggregatorsForSource", Payload.SOURCE, "target", "onAssetChanged", "(Lcom/coinbase/wallet/swap/models/SwapAsset;Lcom/coinbase/wallet/swap/models/SwapAsset;)V", "Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;", "digit", "", "isLongPress", "handleCryptoInput", "(Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;Z)V", "handleSourceInput", "handleTargetInput", "handleFiatInput", "", "fiat", "updateInputs", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "excludeTarget", "excludeSource", "excludeFiat", "resetViewState", "(ZZZ)V", "checkBalance", "ensureAssetsSelected", "()Z", "newSourceAmount", "updateSourceFromTarget", "(Ljava/lang/String;Lcom/coinbase/wallet/swap/models/SwapAsset;)V", "updateErrorState", "Lcom/coinbase/wallet/ethereum/models/ContractAddress;", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "walletSingle", "(Lcom/coinbase/wallet/ethereum/models/ContractAddress;)Lh/c/b0;", "rawString", "Ljava/util/Locale;", ApiConstants.LOCALE, "Ljava/math/BigInteger;", "toBigInteger", "(Lcom/coinbase/wallet/swap/models/SwapAsset;Ljava/lang/String;Ljava/util/Locale;)Ljava/math/BigInteger;", "amount", "toAmountString", "(Lcom/coinbase/wallet/swap/models/SwapAsset;Ljava/math/BigInteger;)Ljava/lang/String;", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel$InputField;", "Lcom/coinbase/wallet/swap/models/AmountBase;", "asAmountBase", "(Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel$InputField;)Lcom/coinbase/wallet/swap/models/AmountBase;", "isFiatOrSource", "(Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel$InputField;)Z", "onCleared", "Lcom/coinbase/wallet/features/swap/models/SwapCurrencyType;", "type", "switchCurrencyType", "(Lcom/coinbase/wallet/features/swap/models/SwapCurrencyType;)V", "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerViewState$CryptoField;", "inputField", "selectInput", "(Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerViewState$CryptoField;)V", "keyTapped", "presentPriceImpactWarning", "amountBase", "selectAsset", "(Lcom/coinbase/wallet/swap/models/AmountBase;)V", "asset", "onSourceAssetSelected", "onTargetAssetSelected", "convertAll", "proceedToConfirmTx", "refreshQuote", "shouldConvertAll", "Z", "Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "fiatCurrencyRepository", "Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "Lcom/coinbase/wallet/commonui/utilities/AmountText;", "fiatZeroAmountText", "Lcom/coinbase/wallet/commonui/utilities/AmountText;", "Lh/c/v0/b;", "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerEvent;", "eventSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerViewState;", "value", ApiConstants.STATE, "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerViewState;", "setState", "(Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerViewState;)V", "Lh/c/s;", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "navigationObservable", "Lh/c/s;", "getNavigationObservable", "()Lh/c/s;", "navigationSubject", "getZeroString", "(Lcom/coinbase/wallet/swap/models/SwapAsset;)Ljava/lang/String;", "zeroString", "Lcom/coinbase/wallet/swap/interfaces/ISwapRepository;", "swapRepository", "Lcom/coinbase/wallet/swap/interfaces/ISwapRepository;", "lastEditedInput", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel$InputField;", "stateObservable", "getStateObservable", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "Lh/c/v0/a;", "stateSubject", "Lh/c/v0/a;", "isETH", "(Lcom/coinbase/wallet/swap/models/SwapAsset;)Z", "Lcom/coinbase/wallet/commonui/utilities/AmountPickerFormatter;", "amountPickerFormatter", "Lcom/coinbase/wallet/commonui/utilities/AmountPickerFormatter;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel$QuoteRequest;", "quoteSubject", "", "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerError;", "errorSet", "Ljava/util/Set;", "setErrorSet", "(Ljava/util/Set;)V", "Landroidx/lifecycle/z;", "savedStateHandle", "Landroidx/lifecycle/z;", "Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "promptSubject", "promptObservable", "getPromptObservable", "eventObservable", "getEventObservable", "Lcom/coinbase/wallet/application/repository/interfaces/AppLockRepositoryInterface;", "appLockRepository", "<init>", "(Lcom/coinbase/wallet/application/repository/interfaces/AppLockRepositoryInterface;Lcom/coinbase/wallet/swap/interfaces/ISwapRepository;Lcom/coinbase/wallet/commonui/utilities/AmountPickerFormatter;Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Landroidx/lifecycle/z;)V", "AssetAndBalance", "Factory", "InputField", "QuoteRequest", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAmountPickerViewModel extends androidx.lifecycle.b0 {
    private final AmountPickerFormatter amountPickerFormatter;
    private final h.c.k0.a disposeBag;
    private Set<? extends SwapAmountPickerError> errorSet;
    private final h.c.s<SwapAmountPickerEvent> eventObservable;
    private final h.c.v0.b<SwapAmountPickerEvent> eventSubject;
    private final IFiatCurrencyRepository fiatCurrencyRepository;
    private AmountText fiatZeroAmountText;
    private InputField lastEditedInput;
    private final h.c.s<ViewModelNavRoute> navigationObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigationSubject;
    private final h.c.s<PromptDialogHelper.Properties> promptObservable;
    private final h.c.v0.b<PromptDialogHelper.Properties> promptSubject;
    private final h.c.v0.b<QuoteRequest> quoteSubject;
    private final androidx.lifecycle.z savedStateHandle;
    private boolean shouldConvertAll;
    private SwapAmountPickerViewState state;
    private final h.c.s<SwapAmountPickerViewState> stateObservable;
    private final h.c.v0.a<SwapAmountPickerViewState> stateSubject;
    private final ISwapRepository swapRepository;
    private final IWalletRepository walletRepository;

    /* compiled from: SwapAmountPickerViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel$AssetAndBalance;", "", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "component1", "()Lcom/coinbase/wallet/swap/models/SwapAsset;", "Ljava/math/BigInteger;", "component2", "()Ljava/math/BigInteger;", "asset", "balanceInFiat", "copy", "(Lcom/coinbase/wallet/swap/models/SwapAsset;Ljava/math/BigInteger;)Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel$AssetAndBalance;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "getAsset", "Ljava/math/BigInteger;", "getBalanceInFiat", "<init>", "(Lcom/coinbase/wallet/swap/models/SwapAsset;Ljava/math/BigInteger;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class AssetAndBalance {
        private final SwapAsset asset;
        private final BigInteger balanceInFiat;

        public AssetAndBalance(SwapAsset asset, BigInteger balanceInFiat) {
            kotlin.jvm.internal.m.g(asset, "asset");
            kotlin.jvm.internal.m.g(balanceInFiat, "balanceInFiat");
            this.asset = asset;
            this.balanceInFiat = balanceInFiat;
        }

        public static /* synthetic */ AssetAndBalance copy$default(AssetAndBalance assetAndBalance, SwapAsset swapAsset, BigInteger bigInteger, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                swapAsset = assetAndBalance.asset;
            }
            if ((i2 & 2) != 0) {
                bigInteger = assetAndBalance.balanceInFiat;
            }
            return assetAndBalance.copy(swapAsset, bigInteger);
        }

        public final SwapAsset component1() {
            return this.asset;
        }

        public final BigInteger component2() {
            return this.balanceInFiat;
        }

        public final AssetAndBalance copy(SwapAsset asset, BigInteger balanceInFiat) {
            kotlin.jvm.internal.m.g(asset, "asset");
            kotlin.jvm.internal.m.g(balanceInFiat, "balanceInFiat");
            return new AssetAndBalance(asset, balanceInFiat);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AssetAndBalance) {
                AssetAndBalance assetAndBalance = (AssetAndBalance) obj;
                return kotlin.jvm.internal.m.c(this.asset, assetAndBalance.asset) && kotlin.jvm.internal.m.c(this.balanceInFiat, assetAndBalance.balanceInFiat);
            }
            return false;
        }

        public final SwapAsset getAsset() {
            return this.asset;
        }

        public final BigInteger getBalanceInFiat() {
            return this.balanceInFiat;
        }

        public int hashCode() {
            return (this.asset.hashCode() * 31) + this.balanceInFiat.hashCode();
        }

        public String toString() {
            return "AssetAndBalance(asset=" + this.asset + ", balanceInFiat=" + this.balanceInFiat + ')';
        }
    }

    /* compiled from: SwapAmountPickerViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel$Factory;", "", "Landroidx/lifecycle/z;", "savedStateHandle", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel;", "create", "(Landroidx/lifecycle/z;)Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Factory {
        SwapAmountPickerViewModel create(androidx.lifecycle.z zVar);
    }

    /* compiled from: SwapAmountPickerViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel$InputField;", "", "<init>", "(Ljava/lang/String;I)V", "FIAT", "SOURCE", "TARGET", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public enum InputField {
        FIAT,
        SOURCE,
        TARGET
    }

    /* compiled from: SwapAmountPickerViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel$QuoteRequest;", "", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "component1", "()Lcom/coinbase/wallet/swap/models/SwapAsset;", "component2", "Ljava/math/BigInteger;", "component3", "()Ljava/math/BigInteger;", "Lcom/coinbase/wallet/swap/models/AmountBase;", "component4", "()Lcom/coinbase/wallet/swap/models/AmountBase;", Payload.SOURCE, "target", "amount", "amountBase", "copy", "(Lcom/coinbase/wallet/swap/models/SwapAsset;Lcom/coinbase/wallet/swap/models/SwapAsset;Ljava/math/BigInteger;Lcom/coinbase/wallet/swap/models/AmountBase;)Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel$QuoteRequest;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/swap/models/AmountBase;", "getAmountBase", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "getTarget", "Ljava/math/BigInteger;", "getAmount", "getSource", "<init>", "(Lcom/coinbase/wallet/swap/models/SwapAsset;Lcom/coinbase/wallet/swap/models/SwapAsset;Ljava/math/BigInteger;Lcom/coinbase/wallet/swap/models/AmountBase;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class QuoteRequest {
        private final BigInteger amount;
        private final AmountBase amountBase;
        private final SwapAsset source;
        private final SwapAsset target;

        public QuoteRequest(SwapAsset source, SwapAsset target, BigInteger amount, AmountBase amountBase) {
            kotlin.jvm.internal.m.g(source, "source");
            kotlin.jvm.internal.m.g(target, "target");
            kotlin.jvm.internal.m.g(amount, "amount");
            kotlin.jvm.internal.m.g(amountBase, "amountBase");
            this.source = source;
            this.target = target;
            this.amount = amount;
            this.amountBase = amountBase;
        }

        public static /* synthetic */ QuoteRequest copy$default(QuoteRequest quoteRequest, SwapAsset swapAsset, SwapAsset swapAsset2, BigInteger bigInteger, AmountBase amountBase, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                swapAsset = quoteRequest.source;
            }
            if ((i2 & 2) != 0) {
                swapAsset2 = quoteRequest.target;
            }
            if ((i2 & 4) != 0) {
                bigInteger = quoteRequest.amount;
            }
            if ((i2 & 8) != 0) {
                amountBase = quoteRequest.amountBase;
            }
            return quoteRequest.copy(swapAsset, swapAsset2, bigInteger, amountBase);
        }

        public final SwapAsset component1() {
            return this.source;
        }

        public final SwapAsset component2() {
            return this.target;
        }

        public final BigInteger component3() {
            return this.amount;
        }

        public final AmountBase component4() {
            return this.amountBase;
        }

        public final QuoteRequest copy(SwapAsset source, SwapAsset target, BigInteger amount, AmountBase amountBase) {
            kotlin.jvm.internal.m.g(source, "source");
            kotlin.jvm.internal.m.g(target, "target");
            kotlin.jvm.internal.m.g(amount, "amount");
            kotlin.jvm.internal.m.g(amountBase, "amountBase");
            return new QuoteRequest(source, target, amount, amountBase);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof QuoteRequest) {
                QuoteRequest quoteRequest = (QuoteRequest) obj;
                return kotlin.jvm.internal.m.c(this.source, quoteRequest.source) && kotlin.jvm.internal.m.c(this.target, quoteRequest.target) && kotlin.jvm.internal.m.c(this.amount, quoteRequest.amount) && kotlin.jvm.internal.m.c(this.amountBase, quoteRequest.amountBase);
            }
            return false;
        }

        public final BigInteger getAmount() {
            return this.amount;
        }

        public final AmountBase getAmountBase() {
            return this.amountBase;
        }

        public final SwapAsset getSource() {
            return this.source;
        }

        public final SwapAsset getTarget() {
            return this.target;
        }

        public int hashCode() {
            return (((((this.source.hashCode() * 31) + this.target.hashCode()) * 31) + this.amount.hashCode()) * 31) + this.amountBase.hashCode();
        }

        public String toString() {
            return "QuoteRequest(source=" + this.source + ", target=" + this.target + ", amount=" + this.amount + ", amountBase=" + this.amountBase + ')';
        }
    }

    /* compiled from: SwapAmountPickerViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[AuthenticationMethod.values().length];
            iArr[AuthenticationMethod.PIN.ordinal()] = 1;
            iArr[AuthenticationMethod.BIOMETRIC.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SwapAmountPickerViewState.CryptoField.values().length];
            iArr2[SwapAmountPickerViewState.CryptoField.SOURCE.ordinal()] = 1;
            iArr2[SwapAmountPickerViewState.CryptoField.TARGET.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[SwapCurrencyType.values().length];
            iArr3[SwapCurrencyType.CRYPTO.ordinal()] = 1;
            iArr3[SwapCurrencyType.FIAT.ordinal()] = 2;
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[InputField.values().length];
            iArr4[InputField.SOURCE.ordinal()] = 1;
            iArr4[InputField.FIAT.ordinal()] = 2;
            iArr4[InputField.TARGET.ordinal()] = 3;
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    public SwapAmountPickerViewModel(AppLockRepositoryInterface appLockRepository, ISwapRepository swapRepository, AmountPickerFormatter amountPickerFormatter, IFiatCurrencyRepository fiatCurrencyRepository, IWalletRepository walletRepository, androidx.lifecycle.z savedStateHandle) {
        Set<? extends SwapAmountPickerError> b2;
        String str;
        SwapAmountPickerViewState copy;
        kotlin.jvm.internal.m.g(appLockRepository, "appLockRepository");
        kotlin.jvm.internal.m.g(swapRepository, "swapRepository");
        kotlin.jvm.internal.m.g(amountPickerFormatter, "amountPickerFormatter");
        kotlin.jvm.internal.m.g(fiatCurrencyRepository, "fiatCurrencyRepository");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(savedStateHandle, "savedStateHandle");
        this.swapRepository = swapRepository;
        this.amountPickerFormatter = amountPickerFormatter;
        this.fiatCurrencyRepository = fiatCurrencyRepository;
        this.walletRepository = walletRepository;
        this.savedStateHandle = savedStateHandle;
        h.c.k0.a aVar = new h.c.k0.a();
        this.disposeBag = aVar;
        h.c.v0.b<QuoteRequest> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create()");
        this.quoteSubject = d2;
        h.c.v0.b<SwapAmountPickerEvent> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create()");
        this.eventSubject = d3;
        h.c.v0.b<ViewModelNavRoute> d4 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d4, "create()");
        this.navigationSubject = d4;
        h.c.v0.a<SwapAmountPickerViewState> d5 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d5, "create()");
        this.stateSubject = d5;
        h.c.v0.b<PromptDialogHelper.Properties> d6 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d6, "create()");
        this.promptSubject = d6;
        this.lastEditedInput = InputField.SOURCE;
        b2 = kotlin.a0.s0.b();
        this.errorSet = b2;
        this.state = new SwapAmountPickerViewState(false, null, null, null, null, null, false, null, AmountText.Companion.getZero(), null, null, null, null, null, false, 32511, null);
        h.c.s<SwapAmountPickerEvent> hide = d3.hide();
        kotlin.jvm.internal.m.f(hide, "eventSubject.hide()");
        this.eventObservable = hide;
        h.c.s<SwapAmountPickerViewState> hide2 = d5.hide();
        kotlin.jvm.internal.m.f(hide2, "stateSubject.hide()");
        this.stateObservable = hide2;
        h.c.s<ViewModelNavRoute> hide3 = d4.hide();
        kotlin.jvm.internal.m.f(hide3, "navigationSubject.hide()");
        this.navigationObservable = hide3;
        h.c.s<PromptDialogHelper.Properties> hide4 = d6.hide();
        kotlin.jvm.internal.m.f(hide4, "promptSubject.hide()");
        this.promptObservable = hide4;
        h.c.k0.b subscribe = swapRepository.refresh(true).subscribe();
        kotlin.jvm.internal.m.f(subscribe, "swapRepository.refresh(isForced = true)\n            .subscribe()");
        h.c.t0.a.a(subscribe, aVar);
        this.fiatZeroAmountText = new AmountText(amountPickerFormatter.formatFiatAmount(Strings.zero), Strings.zero);
        AuthenticationMethod authenticationMethod = appLockRepository.getAuthenticationMethod();
        int i2 = authenticationMethod == null ? -1 : WhenMappings.$EnumSwitchMapping$0[authenticationMethod.ordinal()];
        if (i2 == 1) {
            str = LocalizedStrings.INSTANCE.get(R.string.swap_amount_picker_pin);
        } else if (i2 != 2) {
            str = LocalizedStrings.INSTANCE.get(R.string.next);
        } else {
            str = LocalizedStrings.INSTANCE.get(R.string.swap_amount_picker_biometrics);
        }
        String str2 = str;
        SwapAsset swapAsset = (SwapAsset) savedStateHandle.b("sourceAsset");
        AmountText amountText = this.fiatZeroAmountText;
        setState(new SwapAmountPickerViewState(false, null, null, swapAsset, null, null, false, str2, amountText, null, null, amountText.getFormattedAmount(), null, null, false, 30327, null));
        SwapAsset swapAsset2 = (SwapAsset) savedStateHandle.b("targetAsset");
        if (swapAsset2 != null) {
            populateAggregatorsForTarget(swapAsset2);
        }
        if (swapAsset != null) {
            populateAggregatorsForSource(swapAsset);
            copy = r3.copy((r32 & 1) != 0 ? r3.isInitialized : true, (r32 & 2) != 0 ? r3.pickerItems : null, (r32 & 4) != 0 ? r3.activeCurrencyCard : null, (r32 & 8) != 0 ? r3.sourceSwapAsset : null, (r32 & 16) != 0 ? r3.targetSwapAsset : null, (r32 & 32) != 0 ? r3.error : null, (r32 & 64) != 0 ? r3.isLoading : false, (r32 & 128) != 0 ? r3.nextButtonTitle : null, (r32 & 256) != 0 ? r3.fiatAmountText : null, (r32 & 512) != 0 ? r3.equivalentAmountInCrypto : getZeroString(swapAsset), (r32 & 1024) != 0 ? r3.focusedCryptoInputField : null, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r3.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? r3.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r3.cryptoTargetAmount : null, (r32 & 16384) != 0 ? this.state.isTargetFieldDisabled : false);
            setState(copy);
        } else {
            preselectAsset();
        }
        setup();
    }

    public static /* synthetic */ boolean a(QuoteRequest quoteRequest) {
        return m1472setup$lambda5(quoteRequest);
    }

    public final AmountBase asAmountBase(InputField inputField) {
        int i2 = WhenMappings.$EnumSwitchMapping$3[inputField.ordinal()];
        if (i2 == 1 || i2 == 2) {
            return AmountBase.Source.INSTANCE;
        }
        if (i2 == 3) {
            return AmountBase.Target.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ void b(SwapAmountPickerViewModel swapAmountPickerViewModel, QuoteRequest quoteRequest, Throwable th) {
        m1475setup$lambda8$lambda7(swapAmountPickerViewModel, quoteRequest, th);
    }

    public static /* synthetic */ Map c(List list) {
        return m1467preselectAsset$lambda10(list);
    }

    public final void checkBalance() {
        SwapAsset sourceSwapAsset = this.state.getSourceSwapAsset();
        if (sourceSwapAsset == null) {
            return;
        }
        BigInteger bigInteger$default = toBigInteger$default(this, sourceSwapAsset, this.state.getCryptoSourceAmount().getRawString(), null, 2, null);
        h.c.b0<Wallet> observeOn = walletSingle(sourceSwapAsset.getContractAddress()).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "walletSingle(source.contractAddress)\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.i(observeOn, null, new SwapAmountPickerViewModel$checkBalance$1(bigInteger$default, this), 1, null), this.disposeBag);
    }

    /* renamed from: convertAll$lambda-3 */
    public static final h.c.h0 m1464convertAll$lambda3(SwapAsset source, SwapAmountPickerViewModel this$0, Wallet wallet) {
        kotlin.jvm.internal.m.g(source, "$source");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(wallet, "wallet");
        String bigDecimal = BigInteger_CommonKt.asBigDecimal(Wallet_ApplicationKt.maximumAvailableBalance(wallet), source.getDecimals()).toString();
        kotlin.jvm.internal.m.f(bigDecimal, "wallet.maximumAvailableBalance().asBigDecimal(source.decimals).toString()");
        AmountPickerFormatter amountPickerFormatter = this$0.amountPickerFormatter;
        CurrencyCode currencyCode = source.getCurrencyCode();
        ContractAddress contractAddress = source.getContractAddress();
        h.c.b0<String> convertCryptoToFiat = amountPickerFormatter.convertCryptoToFiat(bigDecimal, currencyCode, contractAddress == null ? null : contractAddress.getRawValue(), source.getDecimals());
        h.c.b0 just = h.c.b0.just(bigDecimal);
        kotlin.jvm.internal.m.f(just, "just(sourceAmountString)");
        return h.c.t0.f.a(just, convertCryptoToFiat);
    }

    public static /* synthetic */ SwapAsset d(SwapAsset swapAsset, List list) {
        return m1466populateAggregatorsForTarget$lambda19(swapAsset, list);
    }

    public static /* synthetic */ SwapAsset e(SwapAsset swapAsset, List list) {
        return m1465populateAggregatorsForSource$lambda21(swapAsset, list);
    }

    private final boolean ensureAssetsSelected() {
        if (this.state.getSourceSwapAsset() == null) {
            this.eventSubject.onNext(SwapAmountPickerEvent.NoSourceSelected.INSTANCE);
            return false;
        } else if (this.state.getTargetSwapAsset() == null) {
            this.eventSubject.onNext(SwapAmountPickerEvent.NoTargetSelected.INSTANCE);
            return false;
        } else {
            return true;
        }
    }

    public static /* synthetic */ AssetAndBalance f(SwapAsset swapAsset, SwapAmountPickerViewModel swapAmountPickerViewModel, String str) {
        return m1469preselectAsset$lambda16$lambda15$lambda14(swapAsset, swapAmountPickerViewModel, str);
    }

    public static /* synthetic */ h.c.h0 g(TransferValue transferValue, SwapAmountPickerViewModel swapAmountPickerViewModel, SwapAsset swapAsset, SwapAsset swapAsset2, kotlin.o oVar) {
        return m1471proceedToConfirmTx$lambda4(transferValue, swapAmountPickerViewModel, swapAsset, swapAsset2, oVar);
    }

    public final String getZeroString(SwapAsset swapAsset) {
        return kotlin.jvm.internal.m.o("0 ", swapAsset.getCurrencyCode().getCode());
    }

    public static /* synthetic */ h.c.h0 h(SwapAsset swapAsset, SwapAmountPickerViewModel swapAmountPickerViewModel, Wallet wallet) {
        return m1464convertAll$lambda3(swapAsset, swapAmountPickerViewModel, wallet);
    }

    private final void handleCryptoInput(NumberKeyboardDigit numberKeyboardDigit, boolean z) {
        kotlin.x xVar;
        int i2 = WhenMappings.$EnumSwitchMapping$1[this.state.getFocusedCryptoInputField().ordinal()];
        if (i2 == 1) {
            handleSourceInput(numberKeyboardDigit, z);
            xVar = kotlin.x.a;
        } else if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            handleTargetInput(numberKeyboardDigit, z);
            xVar = kotlin.x.a;
        }
        SafeWhen_CommonKt.getSafe(xVar);
    }

    private final void handleFiatInput(NumberKeyboardDigit numberKeyboardDigit, boolean z) {
        Object obj;
        SwapAmountPickerViewState copy;
        SwapAsset sourceSwapAsset = this.state.getSourceSwapAsset();
        if (sourceSwapAsset == null) {
            return;
        }
        RawStringResult updatedFiatAmount = NumberKeyboardInputView_CommonKt.getUpdatedFiatAmount(NumberKeyboardInputView.Companion, this.state.getFiatAmountText().getRawString(), numberKeyboardDigit, z);
        if (updatedFiatAmount instanceof RawStringResult.Success) {
            this.lastEditedInput = InputField.FIAT;
            this.shouldConvertAll = false;
            copy = r4.copy((r32 & 1) != 0 ? r4.isInitialized : false, (r32 & 2) != 0 ? r4.pickerItems : null, (r32 & 4) != 0 ? r4.activeCurrencyCard : null, (r32 & 8) != 0 ? r4.sourceSwapAsset : null, (r32 & 16) != 0 ? r4.targetSwapAsset : null, (r32 & 32) != 0 ? r4.error : null, (r32 & 64) != 0 ? r4.isLoading : false, (r32 & 128) != 0 ? r4.nextButtonTitle : null, (r32 & 256) != 0 ? r4.fiatAmountText : null, (r32 & 512) != 0 ? r4.equivalentAmountInCrypto : null, (r32 & 1024) != 0 ? r4.focusedCryptoInputField : SwapAmountPickerViewState.CryptoField.SOURCE, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r4.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? r4.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r4.cryptoTargetAmount : null, (r32 & 16384) != 0 ? this.state.isTargetFieldDisabled : false);
            setState(copy);
            AmountPickerFormatter amountPickerFormatter = this.amountPickerFormatter;
            String rawString = ((RawStringResult.Success) updatedFiatAmount).getRawString();
            CurrencyCode currencyCode = sourceSwapAsset.getCurrencyCode();
            ContractAddress contractAddress = sourceSwapAsset.getContractAddress();
            h.c.b0<String> observeOn = amountPickerFormatter.convertFiatToCrypto(rawString, currencyCode, contractAddress == null ? null : contractAddress.getRawValue(), sourceSwapAsset.getDecimals()).observeOn(h.c.j0.c.a.b());
            kotlin.jvm.internal.m.f(observeOn, "amountPickerFormatter\n                    .convertFiatToCrypto(\n                        rawString = newAmount.rawString,\n                        currencyCode = source.currencyCode,\n                        contractAddress = source.contractAddress?.rawValue,\n                        decimals = source.decimals\n                    )\n                    .observeOn(AndroidSchedulers.mainThread())");
            obj = h.c.t0.a.a(h.c.t0.g.f(observeOn, new SwapAmountPickerViewModel$handleFiatInput$1(this, sourceSwapAsset), new SwapAmountPickerViewModel$handleFiatInput$2(this, updatedFiatAmount)), this.disposeBag);
        } else if (!(updatedFiatAmount instanceof RawStringResult.Error)) {
            throw new NoWhenBranchMatchedException();
        } else {
            this.eventSubject.onNext(SwapAmountPickerEvent.InvalidFiatInput.INSTANCE);
            obj = kotlin.x.a;
        }
        SafeWhen_CommonKt.getSafe(obj);
    }

    private final void handleSourceInput(NumberKeyboardDigit numberKeyboardDigit, boolean z) {
        SwapAsset sourceSwapAsset = this.state.getSourceSwapAsset();
        if (sourceSwapAsset == null) {
            return;
        }
        RawStringResult updatedCryptoAmount = NumberKeyboardInputView_CommonKt.getUpdatedCryptoAmount(NumberKeyboardInputView.Companion, this.state.getCryptoSourceAmount().getRawString(), numberKeyboardDigit, sourceSwapAsset.getDecimals(), z);
        if (updatedCryptoAmount instanceof RawStringResult.Success) {
            this.lastEditedInput = InputField.SOURCE;
            this.shouldConvertAll = false;
            AmountPickerFormatter amountPickerFormatter = this.amountPickerFormatter;
            RawStringResult.Success success = (RawStringResult.Success) updatedCryptoAmount;
            String rawString = success.getRawString();
            CurrencyCode currencyCode = sourceSwapAsset.getCurrencyCode();
            ContractAddress contractAddress = sourceSwapAsset.getContractAddress();
            h.c.b0<String> observeOn = amountPickerFormatter.convertCryptoToFiat(rawString, currencyCode, contractAddress == null ? null : contractAddress.getRawValue(), sourceSwapAsset.getDecimals()).observeOn(h.c.j0.c.a.b());
            kotlin.jvm.internal.m.f(observeOn, "amountPickerFormatter\n                    .convertCryptoToFiat(\n                        rawString = newAmount.rawString,\n                        currencyCode = source.currencyCode,\n                        contractAddress = source.contractAddress?.rawValue,\n                        decimals = source.decimals\n                    )\n                    .observeOn(AndroidSchedulers.mainThread())");
            h.c.t0.a.a(h.c.t0.g.f(observeOn, new SwapAmountPickerViewModel$handleSourceInput$1(this, sourceSwapAsset), new SwapAmountPickerViewModel$handleSourceInput$2(this, updatedCryptoAmount)), this.disposeBag);
            if (String_CommonKt.isNonZeroAmount(success.getRawString())) {
                refreshQuote();
            } else {
                resetViewState$default(this, false, true, false, 5, null);
            }
        } else if (!(updatedCryptoAmount instanceof RawStringResult.Error)) {
            throw new NoWhenBranchMatchedException();
        } else {
            this.eventSubject.onNext(SwapAmountPickerEvent.InvalidCryptoSourceInput.INSTANCE);
        }
        SafeWhen_CommonKt.getSafe(kotlin.x.a);
    }

    private final void handleTargetInput(NumberKeyboardDigit numberKeyboardDigit, boolean z) {
        SwapAsset targetSwapAsset = this.state.getTargetSwapAsset();
        if (targetSwapAsset == null) {
            return;
        }
        RawStringResult updatedCryptoAmount = NumberKeyboardInputView_CommonKt.getUpdatedCryptoAmount(NumberKeyboardInputView.Companion, this.state.getCryptoTargetAmount().getRawString(), numberKeyboardDigit, targetSwapAsset.getDecimals(), z);
        if (updatedCryptoAmount instanceof RawStringResult.Success) {
            this.lastEditedInput = InputField.TARGET;
            this.shouldConvertAll = false;
            RawStringResult.Success success = (RawStringResult.Success) updatedCryptoAmount;
            updateInputs$default(this, null, null, success.getRawString(), 3, null);
            if (String_CommonKt.isNonZeroAmount(success.getRawString())) {
                refreshQuote();
            } else {
                resetViewState$default(this, true, false, false, 6, null);
            }
        } else if (!(updatedCryptoAmount instanceof RawStringResult.Error)) {
            throw new NoWhenBranchMatchedException();
        } else {
            this.eventSubject.onNext(SwapAmountPickerEvent.InvalidCryptoTargetInput.INSTANCE);
        }
        SafeWhen_CommonKt.getSafe(kotlin.x.a);
    }

    public static /* synthetic */ SwapAsset i(kotlin.o oVar) {
        return m1470preselectAsset$lambda17(oVar);
    }

    private final boolean isETH(SwapAsset swapAsset) {
        return kotlin.jvm.internal.m.c(swapAsset.getCurrencyCode(), CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion)) && swapAsset.getContractAddress() == null;
    }

    private final boolean isFiatOrSource(InputField inputField) {
        return inputField == InputField.FIAT || inputField == InputField.SOURCE;
    }

    public static /* synthetic */ h.c.x j(SwapAmountPickerViewModel swapAmountPickerViewModel, kotlin.o oVar) {
        return m1473setup$lambda8(swapAmountPickerViewModel, oVar);
    }

    public static /* synthetic */ h.c.h0 k(SwapAmountPickerViewModel swapAmountPickerViewModel, kotlin.o oVar) {
        return m1468preselectAsset$lambda16(swapAmountPickerViewModel, oVar);
    }

    public static /* synthetic */ kotlin.o l(QuoteRequest quoteRequest, SwapQuote swapQuote) {
        return m1474setup$lambda8$lambda6(quoteRequest, swapQuote);
    }

    public final void onAssetChanged(SwapAsset swapAsset, SwapAsset swapAsset2) {
        Set d0;
        List<String> I0;
        checkBalance();
        refreshQuote();
        d0 = kotlin.a0.z.d0(swapAsset.getAggregatorIDs(), swapAsset2.getAggregatorIDs());
        I0 = kotlin.a0.z.I0(d0);
        h.c.b0<List<Aggregator>> observeOn = this.swapRepository.getAggregators(I0).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "swapRepository\n            .getAggregators(aggregatorIdList)\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.i(observeOn, null, new SwapAmountPickerViewModel$onAssetChanged$1(this, swapAsset, swapAsset2), 1, null), this.disposeBag);
    }

    private final void populateAggregatorsForSource(final SwapAsset swapAsset) {
        h.c.b0 observeOn = Observable_CoreKt.takeSingle(this.swapRepository.getSwapAssetListObservable()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapAmountPickerViewModel.e(SwapAsset.this, (List) obj);
            }
        }).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "swapRepository.swapAssetListObservable\n            .takeSingle()\n            .map { assets ->\n                assets.first { it.contractAddress == sourceAsset.contractAddress && it.swappable }\n            }\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.i(observeOn, null, new SwapAmountPickerViewModel$populateAggregatorsForSource$2(this), 1, null), this.disposeBag);
    }

    /* renamed from: populateAggregatorsForSource$lambda-21 */
    public static final SwapAsset m1465populateAggregatorsForSource$lambda21(SwapAsset sourceAsset, List assets) {
        boolean z;
        kotlin.jvm.internal.m.g(sourceAsset, "$sourceAsset");
        kotlin.jvm.internal.m.g(assets, "assets");
        Iterator it = assets.iterator();
        while (it.hasNext()) {
            SwapAsset swapAsset = (SwapAsset) it.next();
            if (kotlin.jvm.internal.m.c(swapAsset.getContractAddress(), sourceAsset.getContractAddress()) && swapAsset.getSwappable()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                return swapAsset;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final void populateAggregatorsForTarget(final SwapAsset swapAsset) {
        h.c.b0 observeOn = Observable_CoreKt.takeSingle(this.swapRepository.getSwapAssetListObservable()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapAmountPickerViewModel.d(SwapAsset.this, (List) obj);
            }
        }).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "swapRepository.swapAssetListObservable\n            .takeSingle()\n            .map { assets ->\n                assets.first { it.contractAddress == swapAsset.contractAddress && it.swappable }\n            }\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.i(observeOn, null, new SwapAmountPickerViewModel$populateAggregatorsForTarget$2(this), 1, null), this.disposeBag);
    }

    /* renamed from: populateAggregatorsForTarget$lambda-19 */
    public static final SwapAsset m1466populateAggregatorsForTarget$lambda19(SwapAsset swapAsset, List assets) {
        boolean z;
        kotlin.jvm.internal.m.g(swapAsset, "$swapAsset");
        kotlin.jvm.internal.m.g(assets, "assets");
        Iterator it = assets.iterator();
        while (it.hasNext()) {
            SwapAsset swapAsset2 = (SwapAsset) it.next();
            if (kotlin.jvm.internal.m.c(swapAsset2.getContractAddress(), swapAsset.getContractAddress()) && swapAsset2.getSwappable()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                return swapAsset2;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final void preselectAsset() {
        h.c.h0 map = this.swapRepository.getSwapAssetStats().map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapAmountPickerViewModel.c((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "swapRepository.getSwapAssetStats()\n            .map<Map<ContractAddress?, Int>> { assetStatsList ->\n                assetStatsList.reduceIntoMap { mutableMap, assetStat ->\n                    mutableMap[assetStat.contractAddress] = assetStat.selectedCount\n                }\n            }");
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0 flatMap = eVar.a(Observable_CoreKt.takeSingle(this.walletRepository.observeWallets(true)), Observable_CoreKt.takeSingle(this.swapRepository.getSwapAssetListObservable())).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapAmountPickerViewModel.k(SwapAmountPickerViewModel.this, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "Singles\n            .zip(\n                walletRepository.observeWallets(true).takeSingle(),\n                swapRepository.swapAssetListObservable.takeSingle()\n            )\n            .flatMap { (walletList, assetList) ->\n                val filteredWalletList = walletList.filter {\n                    it.maximumAvailableBalance() > BigInteger.ZERO && it.blockchain == Blockchain.ETHEREUM\n                }\n                val filteredAssetList = assetList.filter { it.swappable }\n\n                val walletBalanceMap = HashMap<String?, BigInteger>()\n                filteredWalletList.forEach { walletBalanceMap[it.contractAddress] = it.maximumAvailableBalance() }\n\n                val assetAndBalanceSingleList = filteredAssetList.mapNotNull { asset ->\n                    val balance = walletBalanceMap[asset.contractAddress?.rawValue] ?: return@mapNotNull null\n\n                    amountPickerFormatter\n                        .convertCryptoToFiat(\n                            asset.toAmountString(balance),\n                            asset.currencyCode,\n                            asset.contractAddress?.rawValue,\n                            asset.decimals\n                        )\n                        .map { AssetAndBalance(asset, asset.toBigInteger(it, Locales.current)) }\n                }\n\n                Singles.zipOrEmpty(assetAndBalanceSingleList)\n            }");
        h.c.b0 observeOn = eVar.a(flatMap, map).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapAmountPickerViewModel.i((kotlin.o) obj);
            }
        }).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "Singles.zip(assetAndBalanceListSingle, selectionCountSingle)\n            .map { (assetAndBalanceList, selectionCountMap) ->\n                assetAndBalanceList\n                    .sortedWith(\n                        compareBy(\n                            { it.balanceInFiat > BigInteger.ZERO },\n                            { selectionCountMap[it.asset.contractAddress] ?: 0 },\n                            {\n                                if (selectionCountMap.isEmpty()) {\n                                    it.balanceInFiat\n                                } else {\n                                    0\n                                }\n                            }\n                        )\n                    )\n                    .last()\n                    .asset\n            }\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.i(observeOn, null, new SwapAmountPickerViewModel$preselectAsset$2(this), 1, null), this.disposeBag);
    }

    /* renamed from: preselectAsset$lambda-10 */
    public static final Map m1467preselectAsset$lambda10(List assetStatsList) {
        kotlin.jvm.internal.m.g(assetStatsList, "assetStatsList");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = assetStatsList.iterator();
        while (it.hasNext()) {
            SwapAssetStats swapAssetStats = (SwapAssetStats) it.next();
            linkedHashMap.put(swapAssetStats.getContractAddress(), Integer.valueOf(swapAssetStats.getSelectedCount()));
        }
        return linkedHashMap;
    }

    /* renamed from: preselectAsset$lambda-16 */
    public static final h.c.h0 m1468preselectAsset$lambda16(final SwapAmountPickerViewModel this$0, kotlin.o dstr$walletList$assetList) {
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$walletList$assetList, "$dstr$walletList$assetList");
        List walletList = (List) dstr$walletList$assetList.a();
        List assetList = (List) dstr$walletList$assetList.b();
        kotlin.jvm.internal.m.f(walletList, "walletList");
        ArrayList<Wallet> arrayList = new ArrayList();
        for (Object obj : walletList) {
            Wallet wallet = (Wallet) obj;
            if (Wallet_ApplicationKt.maximumAvailableBalance(wallet).compareTo(BigInteger.ZERO) > 0 && kotlin.jvm.internal.m.c(wallet.getBlockchain(), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion))) {
                arrayList.add(obj);
            }
        }
        kotlin.jvm.internal.m.f(assetList, "assetList");
        ArrayList<SwapAsset> arrayList2 = new ArrayList();
        for (Object obj2 : assetList) {
            if (((SwapAsset) obj2).getSwappable()) {
                arrayList2.add(obj2);
            }
        }
        HashMap hashMap = new HashMap();
        for (Wallet wallet2 : arrayList) {
            hashMap.put(wallet2.getContractAddress(), Wallet_ApplicationKt.maximumAvailableBalance(wallet2));
        }
        ArrayList arrayList3 = new ArrayList();
        for (final SwapAsset swapAsset : arrayList2) {
            ContractAddress contractAddress = swapAsset.getContractAddress();
            h.c.b0 b0Var = null;
            BigInteger bigInteger = (BigInteger) hashMap.get(contractAddress == null ? null : contractAddress.getRawValue());
            if (bigInteger != null) {
                AmountPickerFormatter amountPickerFormatter = this$0.amountPickerFormatter;
                String amountString = this$0.toAmountString(swapAsset, bigInteger);
                CurrencyCode currencyCode = swapAsset.getCurrencyCode();
                ContractAddress contractAddress2 = swapAsset.getContractAddress();
                b0Var = amountPickerFormatter.convertCryptoToFiat(amountString, currencyCode, contractAddress2 != null ? contractAddress2.getRawValue() : null, swapAsset.getDecimals()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.f
                    @Override // h.c.m0.n
                    public final Object apply(Object obj3) {
                        return SwapAmountPickerViewModel.f(SwapAsset.this, this$0, (String) obj3);
                    }
                });
            }
            if (b0Var != null) {
                arrayList3.add(b0Var);
            }
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList3.isEmpty()) {
            g2 = kotlin.a0.r.g();
            h.c.b0 just = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(just, "just(emptyList())");
            return just;
        }
        h.c.b0 zip = h.c.b0.zip(arrayList3, new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel$preselectAsset$lambda-16$$inlined$zipOrEmpty$1
            @Override // h.c.m0.n
            public final List<T> apply(Object[] it) {
                List<T> g3;
                kotlin.jvm.internal.m.g(it, "it");
                if (it.length == 0) {
                    g3 = kotlin.a0.r.g();
                    return g3;
                }
                ArrayList arrayList4 = new ArrayList();
                int length = it.length;
                for (int i2 = 0; i2 < length; i2++) {
                    Object obj3 = it[i2];
                    if (obj3 != null ? obj3 instanceof SwapAmountPickerViewModel.AssetAndBalance : true) {
                        arrayList4.add(obj3);
                    }
                }
                return arrayList4;
            }
        });
        kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        return zip;
    }

    /* renamed from: preselectAsset$lambda-16$lambda-15$lambda-14 */
    public static final AssetAndBalance m1469preselectAsset$lambda16$lambda15$lambda14(SwapAsset asset, SwapAmountPickerViewModel this$0, String it) {
        kotlin.jvm.internal.m.g(asset, "$asset");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return new AssetAndBalance(asset, this$0.toBigInteger(asset, it, Locales.INSTANCE.getCurrent()));
    }

    /* renamed from: preselectAsset$lambda-17 */
    public static final SwapAsset m1470preselectAsset$lambda17(kotlin.o dstr$assetAndBalanceList$selectionCountMap) {
        Comparator b2;
        List B0;
        kotlin.jvm.internal.m.g(dstr$assetAndBalanceList$selectionCountMap, "$dstr$assetAndBalanceList$selectionCountMap");
        List assetAndBalanceList = (List) dstr$assetAndBalanceList$selectionCountMap.a();
        Map map = (Map) dstr$assetAndBalanceList$selectionCountMap.b();
        kotlin.jvm.internal.m.f(assetAndBalanceList, "assetAndBalanceList");
        b2 = kotlin.b0.b.b(SwapAmountPickerViewModel$preselectAsset$1$1.INSTANCE, new SwapAmountPickerViewModel$preselectAsset$1$2(map), new SwapAmountPickerViewModel$preselectAsset$1$3(map));
        B0 = kotlin.a0.z.B0(assetAndBalanceList, b2);
        return ((AssetAndBalance) kotlin.a0.p.j0(B0)).getAsset();
    }

    /* renamed from: proceedToConfirmTx$lambda-4 */
    public static final h.c.h0 m1471proceedToConfirmTx$lambda4(TransferValue transferAmount, SwapAmountPickerViewModel this$0, SwapAsset source, SwapAsset target, kotlin.o dstr$ethWallet$sourceWallet) {
        BigInteger value;
        kotlin.jvm.internal.m.g(transferAmount, "$transferAmount");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(source, "$source");
        kotlin.jvm.internal.m.g(target, "$target");
        kotlin.jvm.internal.m.g(dstr$ethWallet$sourceWallet, "$dstr$ethWallet$sourceWallet");
        Wallet wallet = (Wallet) dstr$ethWallet$sourceWallet.a();
        Wallet sourceWallet = (Wallet) dstr$ethWallet$sourceWallet.b();
        AddressType ethereum = AddressKind_EthereumKt.getEthereum(AddressType.Companion);
        String primaryAddress = wallet.getPrimaryAddress();
        Integer selectedIndex = wallet.getSelectedIndex();
        if (selectedIndex != null) {
            WalletAddress walletAddress = new WalletAddress(ethereum, primaryAddress, selectedIndex.intValue());
            if (kotlin.jvm.internal.m.c(transferAmount, TransferValue.EntireBalance.INSTANCE)) {
                kotlin.jvm.internal.m.f(sourceWallet, "sourceWallet");
                value = Wallet_ApplicationKt.maximumAvailableBalance(sourceWallet);
            } else if (!(transferAmount instanceof TransferValue.Amount)) {
                throw new NoWhenBranchMatchedException();
            } else {
                value = ((TransferValue.Amount) transferAmount).getValue();
            }
            return this$0.swapRepository.getTrade(walletAddress, source, target, value, this$0.asAmountBase(this$0.lastEditedInput), Network_ApplicationKt.asChainId(wallet.getNetwork()));
        }
        throw new Exception("ETH wallet index should not be null");
    }

    private final void resetViewState(boolean z, boolean z2, boolean z3) {
        String zeroString;
        SwapAmountPickerViewState copy;
        Set<? extends SwapAmountPickerError> b2;
        SwapAsset sourceSwapAsset = this.state.getSourceSwapAsset();
        if (sourceSwapAsset == null) {
            zeroString = LocalizedStrings.INSTANCE.get(R.string.swap_main_equivalent_to_placeholder);
        } else {
            zeroString = getZeroString(sourceSwapAsset);
        }
        AmountText zero = !z2 ? AmountText.Companion.getZero() : this.state.getCryptoSourceAmount();
        AmountText zero2 = !z ? AmountText.Companion.getZero() : this.state.getCryptoTargetAmount();
        AmountText fiatAmountText = !z3 ? this.fiatZeroAmountText : this.state.getFiatAmountText();
        if (z2) {
            zeroString = this.state.getEquivalentAmountInCrypto();
        }
        copy = r3.copy((r32 & 1) != 0 ? r3.isInitialized : false, (r32 & 2) != 0 ? r3.pickerItems : null, (r32 & 4) != 0 ? r3.activeCurrencyCard : null, (r32 & 8) != 0 ? r3.sourceSwapAsset : null, (r32 & 16) != 0 ? r3.targetSwapAsset : null, (r32 & 32) != 0 ? r3.error : null, (r32 & 64) != 0 ? r3.isLoading : false, (r32 & 128) != 0 ? r3.nextButtonTitle : null, (r32 & 256) != 0 ? r3.fiatAmountText : fiatAmountText, (r32 & 512) != 0 ? r3.equivalentAmountInCrypto : zeroString, (r32 & 1024) != 0 ? r3.focusedCryptoInputField : null, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r3.equivalentAmountInFiat : this.fiatZeroAmountText.getFormattedAmount(), (r32 & 4096) != 0 ? r3.cryptoSourceAmount : zero, (r32 & PKIFailureInfo.certRevoked) != 0 ? r3.cryptoTargetAmount : zero2, (r32 & 16384) != 0 ? this.state.isTargetFieldDisabled : false);
        setState(copy);
        b2 = kotlin.a0.s0.b();
        setErrorSet(b2);
        this.shouldConvertAll = false;
    }

    public static /* synthetic */ void resetViewState$default(SwapAmountPickerViewModel swapAmountPickerViewModel, boolean z, boolean z2, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            z3 = false;
        }
        swapAmountPickerViewModel.resetViewState(z, z2, z3);
    }

    public final void setErrorSet(Set<? extends SwapAmountPickerError> set) {
        this.errorSet = set;
        updateErrorState();
    }

    public final void setState(SwapAmountPickerViewState swapAmountPickerViewState) {
        this.state = swapAmountPickerViewState;
        this.stateSubject.onNext(swapAmountPickerViewState);
    }

    private final void setup() {
        h.c.s<FiatCurrency> observeOn = this.fiatCurrencyRepository.getActiveCurrencyObservable().observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "fiatCurrencyRepository.activeCurrencyObservable\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.h(observeOn, null, null, new SwapAmountPickerViewModel$setup$1(this), 3, null), this.disposeBag);
        h.c.x map = WalletRepository_CommonKt.observeWallet(this.walletRepository, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), (ContractAddress) null).filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel$setup$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel$setup$$inlined$unwrap$2
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
        h.c.s<QuoteRequest> filter = this.quoteSubject.filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.swap.viewmodels.a
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return SwapAmountPickerViewModel.a((SwapAmountPickerViewModel.QuoteRequest) obj);
            }
        });
        kotlin.jvm.internal.m.f(filter, "quoteSubject\n            .filter { it.amount > BigInteger.ZERO }");
        h.c.s switchMap = h.c.t0.d.a(filter, map).observeOn(h.c.u0.a.c()).throttleLatest(100L, TimeUnit.MILLISECONDS).switchMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapAmountPickerViewModel.j(SwapAmountPickerViewModel.this, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(switchMap, "quoteSubject\n            .filter { it.amount > BigInteger.ZERO }\n            .zipWith(ethereumWalletSingle)\n            .observeOn(Schedulers.io())\n            .throttleLatest(100, TimeUnit.MILLISECONDS)\n            .switchMap { (request, ethWallet) ->\n                swapRepository\n                    .getFastQuote(\n                        source = request.source,\n                        target = request.target,\n                        amount = request.amount,\n                        amountBase = lastEditedInput.asAmountBase(),\n                        chainId = ethWallet.network.asChainId()\n                    )\n                    .retry(2)\n                    .map { Pair(request.amountBase, it) }\n                    .observeOn(AndroidSchedulers.mainThread())\n                    .toObservable()\n                    .logError()\n                    .doOnError { error ->\n                        val exceptions = (error as? CompositeException)?.exceptions\n                        errorSet = if (exceptions != null && exceptions.contains(SwapQuoteException.LowLiquidity)) {\n                            errorSet + LowLiquidity\n                        } else {\n                            Analytics.log(\n                                AnalyticsEvent.swapAmountPickerGenericError(\n                                    error = error.message,\n                                    source = request.source.currencyCode.code,\n                                    target = request.target.currencyCode.code\n                                )\n                            )\n                            errorSet + GenericError\n                        }\n                    }\n                    .onErrorResumeNext(Observable.empty())\n            }");
        h.c.t0.a.a(h.c.t0.g.h(switchMap, null, null, new SwapAmountPickerViewModel$setup$4(this), 3, null), this.disposeBag);
    }

    /* renamed from: setup$lambda-5 */
    public static final boolean m1472setup$lambda5(QuoteRequest it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.getAmount().compareTo(BigInteger.ZERO) > 0;
    }

    /* renamed from: setup$lambda-8 */
    public static final h.c.x m1473setup$lambda8(SwapAmountPickerViewModel this$0, kotlin.o dstr$request$ethWallet) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$request$ethWallet, "$dstr$request$ethWallet");
        final QuoteRequest quoteRequest = (QuoteRequest) dstr$request$ethWallet.a();
        h.c.s observable = this$0.swapRepository.getFastQuote(quoteRequest.getSource(), quoteRequest.getTarget(), quoteRequest.getAmount(), this$0.asAmountBase(this$0.lastEditedInput), Network_ApplicationKt.asChainId(((Wallet) dstr$request$ethWallet.b()).getNetwork())).retry(2L).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.l
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapAmountPickerViewModel.l(SwapAmountPickerViewModel.QuoteRequest.this, (SwapQuote) obj);
            }
        }).observeOn(h.c.j0.c.a.b()).toObservable();
        kotlin.jvm.internal.m.f(observable, "swapRepository\n                    .getFastQuote(\n                        source = request.source,\n                        target = request.target,\n                        amount = request.amount,\n                        amountBase = lastEditedInput.asAmountBase(),\n                        chainId = ethWallet.network.asChainId()\n                    )\n                    .retry(2)\n                    .map { Pair(request.amountBase, it) }\n                    .observeOn(AndroidSchedulers.mainThread())\n                    .toObservable()");
        return Observable_AnalyticsKt.logError$default(observable, null, null, 3, null).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.features.swap.viewmodels.b
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                SwapAmountPickerViewModel.b(SwapAmountPickerViewModel.this, quoteRequest, (Throwable) obj);
            }
        }).onErrorResumeNext(h.c.s.empty());
    }

    /* renamed from: setup$lambda-8$lambda-6 */
    public static final kotlin.o m1474setup$lambda8$lambda6(QuoteRequest quoteRequest, SwapQuote it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new kotlin.o(quoteRequest.getAmountBase(), it);
    }

    /* renamed from: setup$lambda-8$lambda-7 */
    public static final void m1475setup$lambda8$lambda7(SwapAmountPickerViewModel this$0, QuoteRequest quoteRequest, Throwable th) {
        Set<? extends SwapAmountPickerError> i2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        CompositeException compositeException = th instanceof CompositeException ? (CompositeException) th : null;
        List<Throwable> b2 = compositeException != null ? compositeException.b() : null;
        if (b2 != null && b2.contains(SwapQuoteException.LowLiquidity.INSTANCE)) {
            i2 = t0.i(this$0.errorSet, SwapAmountPickerError.LowLiquidity);
        } else {
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.swapAmountPickerGenericError(AnalyticsEvent.Companion, th.getMessage(), quoteRequest.getSource().getCurrencyCode().getCode(), quoteRequest.getTarget().getCurrencyCode().getCode()));
            i2 = t0.i(this$0.errorSet, SwapAmountPickerError.GenericError);
        }
        this$0.setErrorSet(i2);
    }

    public final String toAmountString(SwapAsset swapAsset, BigInteger bigInteger) {
        String bigDecimal = BigInteger_CommonKt.asBigDecimal(bigInteger, swapAsset.getDecimals()).toString();
        kotlin.jvm.internal.m.f(bigDecimal, "amount.asBigDecimal(this.decimals).toString()");
        return bigDecimal;
    }

    private final BigInteger toBigInteger(SwapAsset swapAsset, String str, Locale locale) {
        if (str.length() == 0) {
            BigInteger bigInteger = BigInteger.ZERO;
            kotlin.jvm.internal.m.f(bigInteger, "{\n            BigInteger.ZERO\n        }");
            return bigInteger;
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.0", new DecimalFormatSymbols(locale));
        decimalFormat.setParseBigDecimal(true);
        decimalFormat.setDecimalSeparatorAlwaysShown(true);
        Number parse = decimalFormat.parse(str);
        Objects.requireNonNull(parse, "null cannot be cast to non-null type java.math.BigDecimal");
        return BigDecimal_CommonKt.asBigInteger((BigDecimal) parse, swapAsset.getDecimals());
    }

    static /* synthetic */ BigInteger toBigInteger$default(SwapAmountPickerViewModel swapAmountPickerViewModel, SwapAsset swapAsset, String str, Locale US, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            US = Locale.US;
            kotlin.jvm.internal.m.f(US, "US");
        }
        return swapAmountPickerViewModel.toBigInteger(swapAsset, str, US);
    }

    private final void updateErrorState() {
        SwapAmountPickerViewState copy;
        CurrencyCode currencyCode;
        CurrencyCode currencyCode2;
        CurrencyCode currencyCode3;
        CurrencyCode currencyCode4;
        Set<? extends SwapAmountPickerError> set = this.errorSet;
        SwapAmountPickerError swapAmountPickerError = SwapAmountPickerError.InsufficientBalance;
        String str = null;
        if (set.contains(swapAmountPickerError)) {
            Analytics analytics = Analytics.INSTANCE;
            AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
            SwapAsset sourceSwapAsset = this.state.getSourceSwapAsset();
            String code = (sourceSwapAsset == null || (currencyCode3 = sourceSwapAsset.getCurrencyCode()) == null) ? null : currencyCode3.getCode();
            SwapAsset targetSwapAsset = this.state.getTargetSwapAsset();
            if (targetSwapAsset != null && (currencyCode4 = targetSwapAsset.getCurrencyCode()) != null) {
                str = currencyCode4.getCode();
            }
            analytics.log(AnalyticsEvent_ApplicationKt.swapAmountPickerInsufficientBalance(companion, code, str));
            copy = r2.copy((r32 & 1) != 0 ? r2.isInitialized : false, (r32 & 2) != 0 ? r2.pickerItems : null, (r32 & 4) != 0 ? r2.activeCurrencyCard : null, (r32 & 8) != 0 ? r2.sourceSwapAsset : null, (r32 & 16) != 0 ? r2.targetSwapAsset : null, (r32 & 32) != 0 ? r2.error : swapAmountPickerError, (r32 & 64) != 0 ? r2.isLoading : false, (r32 & 128) != 0 ? r2.nextButtonTitle : null, (r32 & 256) != 0 ? r2.fiatAmountText : null, (r32 & 512) != 0 ? r2.equivalentAmountInCrypto : null, (r32 & 1024) != 0 ? r2.focusedCryptoInputField : null, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r2.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? r2.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r2.cryptoTargetAmount : null, (r32 & 16384) != 0 ? this.state.isTargetFieldDisabled : false);
        } else {
            Set<? extends SwapAmountPickerError> set2 = this.errorSet;
            SwapAmountPickerError swapAmountPickerError2 = SwapAmountPickerError.LowLiquidity;
            if (set2.contains(swapAmountPickerError2)) {
                Analytics analytics2 = Analytics.INSTANCE;
                AnalyticsEvent.Companion companion2 = AnalyticsEvent.Companion;
                SwapAsset sourceSwapAsset2 = this.state.getSourceSwapAsset();
                String code2 = (sourceSwapAsset2 == null || (currencyCode = sourceSwapAsset2.getCurrencyCode()) == null) ? null : currencyCode.getCode();
                SwapAsset targetSwapAsset2 = this.state.getTargetSwapAsset();
                if (targetSwapAsset2 != null && (currencyCode2 = targetSwapAsset2.getCurrencyCode()) != null) {
                    str = currencyCode2.getCode();
                }
                analytics2.log(AnalyticsEvent_ApplicationKt.swapAmountPickerLiquidityError(companion2, code2, str));
                copy = r3.copy((r32 & 1) != 0 ? r3.isInitialized : false, (r32 & 2) != 0 ? r3.pickerItems : null, (r32 & 4) != 0 ? r3.activeCurrencyCard : null, (r32 & 8) != 0 ? r3.sourceSwapAsset : null, (r32 & 16) != 0 ? r3.targetSwapAsset : null, (r32 & 32) != 0 ? r3.error : swapAmountPickerError2, (r32 & 64) != 0 ? r3.isLoading : false, (r32 & 128) != 0 ? r3.nextButtonTitle : null, (r32 & 256) != 0 ? r3.fiatAmountText : null, (r32 & 512) != 0 ? r3.equivalentAmountInCrypto : null, (r32 & 1024) != 0 ? r3.focusedCryptoInputField : null, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r3.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? r3.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r3.cryptoTargetAmount : null, (r32 & 16384) != 0 ? this.state.isTargetFieldDisabled : false);
            } else {
                Set<? extends SwapAmountPickerError> set3 = this.errorSet;
                SwapAmountPickerError swapAmountPickerError3 = SwapAmountPickerError.HighPriceImpact;
                if (set3.contains(swapAmountPickerError3)) {
                    copy = r2.copy((r32 & 1) != 0 ? r2.isInitialized : false, (r32 & 2) != 0 ? r2.pickerItems : null, (r32 & 4) != 0 ? r2.activeCurrencyCard : null, (r32 & 8) != 0 ? r2.sourceSwapAsset : null, (r32 & 16) != 0 ? r2.targetSwapAsset : null, (r32 & 32) != 0 ? r2.error : swapAmountPickerError3, (r32 & 64) != 0 ? r2.isLoading : false, (r32 & 128) != 0 ? r2.nextButtonTitle : null, (r32 & 256) != 0 ? r2.fiatAmountText : null, (r32 & 512) != 0 ? r2.equivalentAmountInCrypto : null, (r32 & 1024) != 0 ? r2.focusedCryptoInputField : null, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r2.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? r2.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r2.cryptoTargetAmount : null, (r32 & 16384) != 0 ? this.state.isTargetFieldDisabled : false);
                } else {
                    Set<? extends SwapAmountPickerError> set4 = this.errorSet;
                    SwapAmountPickerError swapAmountPickerError4 = SwapAmountPickerError.GenericError;
                    copy = set4.contains(swapAmountPickerError4) ? r2.copy((r32 & 1) != 0 ? r2.isInitialized : false, (r32 & 2) != 0 ? r2.pickerItems : null, (r32 & 4) != 0 ? r2.activeCurrencyCard : null, (r32 & 8) != 0 ? r2.sourceSwapAsset : null, (r32 & 16) != 0 ? r2.targetSwapAsset : null, (r32 & 32) != 0 ? r2.error : swapAmountPickerError4, (r32 & 64) != 0 ? r2.isLoading : false, (r32 & 128) != 0 ? r2.nextButtonTitle : null, (r32 & 256) != 0 ? r2.fiatAmountText : null, (r32 & 512) != 0 ? r2.equivalentAmountInCrypto : null, (r32 & 1024) != 0 ? r2.focusedCryptoInputField : null, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r2.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? r2.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r2.cryptoTargetAmount : null, (r32 & 16384) != 0 ? this.state.isTargetFieldDisabled : false) : r2.copy((r32 & 1) != 0 ? r2.isInitialized : false, (r32 & 2) != 0 ? r2.pickerItems : null, (r32 & 4) != 0 ? r2.activeCurrencyCard : null, (r32 & 8) != 0 ? r2.sourceSwapAsset : null, (r32 & 16) != 0 ? r2.targetSwapAsset : null, (r32 & 32) != 0 ? r2.error : null, (r32 & 64) != 0 ? r2.isLoading : false, (r32 & 128) != 0 ? r2.nextButtonTitle : null, (r32 & 256) != 0 ? r2.fiatAmountText : null, (r32 & 512) != 0 ? r2.equivalentAmountInCrypto : null, (r32 & 1024) != 0 ? r2.focusedCryptoInputField : null, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r2.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? r2.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r2.cryptoTargetAmount : null, (r32 & 16384) != 0 ? this.state.isTargetFieldDisabled : false);
                }
            }
        }
        setState(copy);
    }

    private final void updateInputs(String str, String str2, String str3) {
        SwapAsset targetSwapAsset;
        String str4;
        AmountText amountText;
        String str5;
        SwapAmountPickerViewState copy;
        SwapAsset sourceSwapAsset = this.state.getSourceSwapAsset();
        if (sourceSwapAsset == null || (targetSwapAsset = this.state.getTargetSwapAsset()) == null) {
            return;
        }
        AmountText amountText2 = null;
        AmountText amountText3 = str3 != null ? new AmountText(AmountPickerFormatter.formatCryptoAmount$default(this.amountPickerFormatter, str3, targetSwapAsset.getCurrencyCode().getCode(), targetSwapAsset.getDecimals(), false, false, null, 56, null), str3) : null;
        if (str2 != null) {
            amountText = new AmountText(AmountPickerFormatter.formatCryptoAmount$default(this.amountPickerFormatter, str2, sourceSwapAsset.getCurrencyCode().getCode(), sourceSwapAsset.getDecimals(), false, false, null, 56, null), str2);
            str4 = AmountPickerFormatter.formatCryptoAmount$default(this.amountPickerFormatter, str2, sourceSwapAsset.getCurrencyCode().getCode(), sourceSwapAsset.getDecimals(), true, true, null, 32, null);
        } else {
            str4 = null;
            amountText = null;
        }
        if (str != null) {
            String formatFiatAmount = this.amountPickerFormatter.formatFiatAmount(str);
            str5 = formatFiatAmount;
            amountText2 = new AmountText(formatFiatAmount, str);
        } else {
            str5 = null;
        }
        SwapAmountPickerViewState swapAmountPickerViewState = this.state;
        if (amountText2 == null) {
            amountText2 = swapAmountPickerViewState.getFiatAmountText();
        }
        AmountText amountText4 = amountText2;
        if (str4 == null) {
            str4 = this.state.getEquivalentAmountInCrypto();
        }
        String str6 = str4;
        if (str5 == null) {
            str5 = this.state.getEquivalentAmountInFiat();
        }
        String str7 = str5;
        if (amountText == null) {
            amountText = this.state.getCryptoSourceAmount();
        }
        AmountText amountText5 = amountText;
        if (amountText3 == null) {
            amountText3 = this.state.getCryptoTargetAmount();
        }
        copy = swapAmountPickerViewState.copy((r32 & 1) != 0 ? swapAmountPickerViewState.isInitialized : false, (r32 & 2) != 0 ? swapAmountPickerViewState.pickerItems : null, (r32 & 4) != 0 ? swapAmountPickerViewState.activeCurrencyCard : null, (r32 & 8) != 0 ? swapAmountPickerViewState.sourceSwapAsset : null, (r32 & 16) != 0 ? swapAmountPickerViewState.targetSwapAsset : null, (r32 & 32) != 0 ? swapAmountPickerViewState.error : null, (r32 & 64) != 0 ? swapAmountPickerViewState.isLoading : false, (r32 & 128) != 0 ? swapAmountPickerViewState.nextButtonTitle : null, (r32 & 256) != 0 ? swapAmountPickerViewState.fiatAmountText : amountText4, (r32 & 512) != 0 ? swapAmountPickerViewState.equivalentAmountInCrypto : str6, (r32 & 1024) != 0 ? swapAmountPickerViewState.focusedCryptoInputField : null, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? swapAmountPickerViewState.equivalentAmountInFiat : str7, (r32 & 4096) != 0 ? swapAmountPickerViewState.cryptoSourceAmount : amountText5, (r32 & PKIFailureInfo.certRevoked) != 0 ? swapAmountPickerViewState.cryptoTargetAmount : amountText3, (r32 & 16384) != 0 ? swapAmountPickerViewState.isTargetFieldDisabled : false);
        setState(copy);
    }

    public static /* synthetic */ void updateInputs$default(SwapAmountPickerViewModel swapAmountPickerViewModel, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        swapAmountPickerViewModel.updateInputs(str, str2, str3);
    }

    public final void updateSourceFromTarget(String str, SwapAsset swapAsset) {
        AmountPickerFormatter amountPickerFormatter = this.amountPickerFormatter;
        CurrencyCode currencyCode = swapAsset.getCurrencyCode();
        ContractAddress contractAddress = swapAsset.getContractAddress();
        h.c.b0<String> observeOn = amountPickerFormatter.convertCryptoToFiat(str, currencyCode, contractAddress == null ? null : contractAddress.getRawValue(), swapAsset.getDecimals()).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "amountPickerFormatter\n            .convertCryptoToFiat(\n                newSourceAmount,\n                source.currencyCode,\n                source.contractAddress?.rawValue,\n                source.decimals\n            )\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.f(observeOn, new SwapAmountPickerViewModel$updateSourceFromTarget$1(this, swapAsset), new SwapAmountPickerViewModel$updateSourceFromTarget$2(this, str)), this.disposeBag);
    }

    private final h.c.b0<Wallet> walletSingle(ContractAddress contractAddress) {
        h.c.s<R> map = WalletRepository_CommonKt.observeWallet(this.walletRepository, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), contractAddress).filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel$walletSingle$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel$walletSingle$$inlined$unwrap$2
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
        return Observable_CoreKt.takeSingle(map);
    }

    public final void convertAll() {
        final SwapAsset sourceSwapAsset;
        CurrencyCode currencyCode;
        if (!ensureAssetsSelected() || (sourceSwapAsset = this.state.getSourceSwapAsset()) == null || isETH(sourceSwapAsset)) {
            return;
        }
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        String code = sourceSwapAsset.getCurrencyCode().getCode();
        SwapAsset targetSwapAsset = this.state.getTargetSwapAsset();
        String str = null;
        if (targetSwapAsset != null && (currencyCode = targetSwapAsset.getCurrencyCode()) != null) {
            str = currencyCode.getCode();
        }
        analytics.log(AnalyticsEvent_ApplicationKt.swapAmountPickerConvertAll(companion, code, str));
        h.c.s<R> map = WalletRepository_CommonKt.observeWallet(this.walletRepository, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), sourceSwapAsset.getContractAddress()).filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel$convertAll$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel$convertAll$$inlined$unwrap$2
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
        h.c.s observeOn = map.flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapAmountPickerViewModel.h(SwapAsset.this, this, (Wallet) obj);
            }
        }).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "walletRepository\n            .observeWallet(blockchain = Blockchain.ETHEREUM, contractAddress = source.contractAddress)\n            .unwrap()\n            .flatMapSingle { wallet ->\n                val sourceAmountString = wallet.maximumAvailableBalance().asBigDecimal(source.decimals).toString()\n                val fiatAmountSingle = amountPickerFormatter.convertCryptoToFiat(\n                    sourceAmountString,\n                    source.currencyCode,\n                    source.contractAddress?.rawValue,\n                    source.decimals\n                )\n\n                Single.just(sourceAmountString).zipWith(fiatAmountSingle)\n            }\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.h(observeOn, null, null, new SwapAmountPickerViewModel$convertAll$2(this), 3, null), this.disposeBag);
    }

    public final h.c.s<SwapAmountPickerEvent> getEventObservable() {
        return this.eventObservable;
    }

    public final h.c.s<ViewModelNavRoute> getNavigationObservable() {
        return this.navigationObservable;
    }

    public final h.c.s<PromptDialogHelper.Properties> getPromptObservable() {
        return this.promptObservable;
    }

    public final h.c.s<SwapAmountPickerViewState> getStateObservable() {
        return this.stateObservable;
    }

    public final void keyTapped(NumberKeyboardDigit digit, boolean z) {
        kotlin.x xVar;
        kotlin.jvm.internal.m.g(digit, "digit");
        if (ensureAssetsSelected()) {
            int i2 = WhenMappings.$EnumSwitchMapping$2[this.state.getActiveCurrencyCard().ordinal()];
            if (i2 == 1) {
                handleCryptoInput(digit, z);
                xVar = kotlin.x.a;
            } else if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                handleFiatInput(digit, z);
                xVar = kotlin.x.a;
            }
            SafeWhen_CommonKt.getSafe(xVar);
        }
    }

    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        this.disposeBag.d();
    }

    public final void onSourceAssetSelected(SwapAsset asset) {
        SwapAmountPickerViewState copy;
        SwapAmountPickerViewState copy2;
        SwapAmountPickerViewState copy3;
        kotlin.jvm.internal.m.g(asset, "asset");
        if (kotlin.jvm.internal.m.c(this.state.getTargetSwapAsset(), asset)) {
            copy3 = r12.copy((r32 & 1) != 0 ? r12.isInitialized : false, (r32 & 2) != 0 ? r12.pickerItems : null, (r32 & 4) != 0 ? r12.activeCurrencyCard : null, (r32 & 8) != 0 ? r12.sourceSwapAsset : null, (r32 & 16) != 0 ? r12.targetSwapAsset : null, (r32 & 32) != 0 ? r12.error : null, (r32 & 64) != 0 ? r12.isLoading : false, (r32 & 128) != 0 ? r12.nextButtonTitle : null, (r32 & 256) != 0 ? r12.fiatAmountText : null, (r32 & 512) != 0 ? r12.equivalentAmountInCrypto : null, (r32 & 1024) != 0 ? r12.focusedCryptoInputField : null, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r12.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? r12.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r12.cryptoTargetAmount : null, (r32 & 16384) != 0 ? this.state.isTargetFieldDisabled : false);
            setState(copy3);
            resetViewState$default(this, false, false, false, 7, null);
        }
        copy = r7.copy((r32 & 1) != 0 ? r7.isInitialized : false, (r32 & 2) != 0 ? r7.pickerItems : null, (r32 & 4) != 0 ? r7.activeCurrencyCard : null, (r32 & 8) != 0 ? r7.sourceSwapAsset : asset, (r32 & 16) != 0 ? r7.targetSwapAsset : null, (r32 & 32) != 0 ? r7.error : null, (r32 & 64) != 0 ? r7.isLoading : false, (r32 & 128) != 0 ? r7.nextButtonTitle : null, (r32 & 256) != 0 ? r7.fiatAmountText : null, (r32 & 512) != 0 ? r7.equivalentAmountInCrypto : null, (r32 & 1024) != 0 ? r7.focusedCryptoInputField : null, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r7.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? r7.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r7.cryptoTargetAmount : null, (r32 & 16384) != 0 ? this.state.isTargetFieldDisabled : false);
        setState(copy);
        SwapAsset targetSwapAsset = this.state.getTargetSwapAsset();
        if (targetSwapAsset == null) {
            copy2 = r7.copy((r32 & 1) != 0 ? r7.isInitialized : false, (r32 & 2) != 0 ? r7.pickerItems : null, (r32 & 4) != 0 ? r7.activeCurrencyCard : null, (r32 & 8) != 0 ? r7.sourceSwapAsset : null, (r32 & 16) != 0 ? r7.targetSwapAsset : null, (r32 & 32) != 0 ? r7.error : null, (r32 & 64) != 0 ? r7.isLoading : false, (r32 & 128) != 0 ? r7.nextButtonTitle : null, (r32 & 256) != 0 ? r7.fiatAmountText : null, (r32 & 512) != 0 ? r7.equivalentAmountInCrypto : getZeroString(asset), (r32 & 1024) != 0 ? r7.focusedCryptoInputField : null, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r7.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? r7.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r7.cryptoTargetAmount : null, (r32 & 16384) != 0 ? this.state.isTargetFieldDisabled : false);
            setState(copy2);
        } else if (isETH(asset)) {
            resetViewState$default(this, false, false, false, 7, null);
        } else if (this.shouldConvertAll) {
            convertAll();
        } else if (this.state.getActiveCurrencyCard() == SwapCurrencyType.FIAT) {
            this.lastEditedInput = InputField.FIAT;
            String rawString = this.state.getFiatAmountText().getRawString();
            ContractAddress contractAddress = asset.getContractAddress();
            h.c.b0<String> observeOn = this.amountPickerFormatter.convertFiatToCrypto(rawString, asset.getCurrencyCode(), contractAddress == null ? null : contractAddress.getRawValue(), asset.getDecimals()).observeOn(h.c.j0.c.a.b());
            kotlin.jvm.internal.m.f(observeOn, "amountPickerFormatter\n                .convertFiatToCrypto(\n                    rawString = state.fiatAmountText.rawString,\n                    contractAddress = asset.contractAddress?.rawValue,\n                    currencyCode = asset.currencyCode,\n                    decimals = asset.decimals\n                )\n                .observeOn(AndroidSchedulers.mainThread())");
            h.c.t0.a.a(h.c.t0.g.i(observeOn, null, new SwapAmountPickerViewModel$onSourceAssetSelected$1(this, asset), 1, null), this.disposeBag);
        } else if (this.lastEditedInput == InputField.TARGET) {
            SwapAsset targetSwapAsset2 = this.state.getTargetSwapAsset();
            if (targetSwapAsset2 == null) {
                return;
            }
            onAssetChanged(asset, targetSwapAsset2);
        } else {
            this.lastEditedInput = InputField.SOURCE;
            AmountPickerFormatter amountPickerFormatter = this.amountPickerFormatter;
            String rawString2 = this.state.getCryptoSourceAmount().getRawString();
            CurrencyCode currencyCode = asset.getCurrencyCode();
            ContractAddress contractAddress2 = asset.getContractAddress();
            h.c.b0<String> observeOn2 = amountPickerFormatter.convertCryptoToFiat(rawString2, currencyCode, contractAddress2 == null ? null : contractAddress2.getRawValue(), asset.getDecimals()).observeOn(h.c.j0.c.a.b());
            kotlin.jvm.internal.m.f(observeOn2, "amountPickerFormatter\n                    .convertCryptoToFiat(\n                        rawString = state.cryptoSourceAmount.rawString,\n                        currencyCode = asset.currencyCode,\n                        contractAddress = asset.contractAddress?.rawValue,\n                        decimals = asset.decimals\n                    )\n                    .observeOn(AndroidSchedulers.mainThread())");
            h.c.t0.a.a(h.c.t0.g.i(observeOn2, null, new SwapAmountPickerViewModel$onSourceAssetSelected$3(this, asset, targetSwapAsset), 1, null), this.disposeBag);
        }
    }

    public final void onTargetAssetSelected(SwapAsset asset) {
        SwapAmountPickerViewState copy;
        SwapAmountPickerViewState copy2;
        kotlin.jvm.internal.m.g(asset, "asset");
        if (kotlin.jvm.internal.m.c(this.state.getSourceSwapAsset(), asset)) {
            copy2 = r13.copy((r32 & 1) != 0 ? r13.isInitialized : false, (r32 & 2) != 0 ? r13.pickerItems : null, (r32 & 4) != 0 ? r13.activeCurrencyCard : null, (r32 & 8) != 0 ? r13.sourceSwapAsset : null, (r32 & 16) != 0 ? r13.targetSwapAsset : null, (r32 & 32) != 0 ? r13.error : null, (r32 & 64) != 0 ? r13.isLoading : false, (r32 & 128) != 0 ? r13.nextButtonTitle : null, (r32 & 256) != 0 ? r13.fiatAmountText : null, (r32 & 512) != 0 ? r13.equivalentAmountInCrypto : null, (r32 & 1024) != 0 ? r13.focusedCryptoInputField : null, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r13.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? r13.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r13.cryptoTargetAmount : null, (r32 & 16384) != 0 ? this.state.isTargetFieldDisabled : false);
            setState(copy2);
            resetViewState$default(this, false, false, false, 7, null);
        }
        copy = r7.copy((r32 & 1) != 0 ? r7.isInitialized : false, (r32 & 2) != 0 ? r7.pickerItems : null, (r32 & 4) != 0 ? r7.activeCurrencyCard : null, (r32 & 8) != 0 ? r7.sourceSwapAsset : null, (r32 & 16) != 0 ? r7.targetSwapAsset : asset, (r32 & 32) != 0 ? r7.error : null, (r32 & 64) != 0 ? r7.isLoading : false, (r32 & 128) != 0 ? r7.nextButtonTitle : null, (r32 & 256) != 0 ? r7.fiatAmountText : null, (r32 & 512) != 0 ? r7.equivalentAmountInCrypto : null, (r32 & 1024) != 0 ? r7.focusedCryptoInputField : null, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r7.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? r7.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r7.cryptoTargetAmount : null, (r32 & 16384) != 0 ? this.state.isTargetFieldDisabled : false);
        setState(copy);
        if (this.state.getActiveCurrencyCard() == SwapCurrencyType.FIAT) {
            this.lastEditedInput = InputField.FIAT;
        } else if (this.lastEditedInput == InputField.FIAT) {
            this.lastEditedInput = InputField.TARGET;
        }
        SwapAsset sourceSwapAsset = this.state.getSourceSwapAsset();
        if (sourceSwapAsset == null) {
            return;
        }
        onAssetChanged(sourceSwapAsset, asset);
    }

    public final void presentPriceImpactWarning() {
        List b2;
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        b2 = kotlin.a0.q.b(new PromptDialogHelper.Action(localizedStrings.get(R.string.ok), ActionStyle.POSITIVE, SwapAmountPickerViewModel$presentPriceImpactWarning$actions$1.INSTANCE));
        this.promptSubject.onNext(new PromptDialogHelper.Properties(null, localizedStrings.get(R.string.prompt_high_price_impact_title), localizedStrings.get(R.string.prompt_high_price_impact_message), null, Integer.valueOf((int) R.drawable.ic_dex_prompt_warning), b2, null, false, null, null, SwapAmountPickerViewModel$presentPriceImpactWarning$promptProperties$1.INSTANCE, null, null, false, 15305, null));
    }

    public final void proceedToConfirmTx() {
        final SwapAsset targetSwapAsset;
        kotlin.o oVar;
        final TransferValue amount;
        SwapAmountPickerViewState copy;
        Set<? extends SwapAmountPickerError> i2;
        final SwapAsset sourceSwapAsset = this.state.getSourceSwapAsset();
        if (sourceSwapAsset == null || (targetSwapAsset = this.state.getTargetSwapAsset()) == null) {
            return;
        }
        if (isFiatOrSource(this.lastEditedInput)) {
            oVar = new kotlin.o(AmountBase.Source.INSTANCE, toBigInteger$default(this, sourceSwapAsset, this.state.getCryptoSourceAmount().getRawString(), null, 2, null));
        } else {
            oVar = new kotlin.o(AmountBase.Target.INSTANCE, toBigInteger$default(this, targetSwapAsset, this.state.getCryptoTargetAmount().getRawString(), null, 2, null));
        }
        AmountBase amountBase = (AmountBase) oVar.a();
        BigInteger bigInteger = (BigInteger) oVar.b();
        if (bigInteger.compareTo(BigInteger.ZERO) <= 0) {
            i2 = t0.i(this.errorSet, SwapAmountPickerError.GenericError);
            setErrorSet(i2);
            return;
        }
        if (this.shouldConvertAll) {
            amount = TransferValue.EntireBalance.INSTANCE;
        } else {
            amount = new TransferValue.Amount(bigInteger);
        }
        IWalletRepository iWalletRepository = this.walletRepository;
        Blockchain.Companion companion = Blockchain.Companion;
        h.c.s<R> map = WalletRepository_CommonKt.observeWallet(iWalletRepository, Blockchain_EthereumKt.getETHEREUM(companion), (ContractAddress) null).filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel$proceedToConfirmTx$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel$proceedToConfirmTx$$inlined$unwrap$2
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
        h.c.b0 takeSingle = Observable_CoreKt.takeSingle(map);
        h.c.s<R> map2 = WalletRepository_CommonKt.observeWallet(this.walletRepository, Blockchain_EthereumKt.getETHEREUM(companion), sourceSwapAsset.getContractAddress()).filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel$proceedToConfirmTx$$inlined$unwrap$3
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel$proceedToConfirmTx$$inlined$unwrap$4
            public final T apply(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        kotlin.jvm.internal.m.f(map2, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        h.c.b0 takeSingle2 = Observable_CoreKt.takeSingle(map2);
        copy = r9.copy((r32 & 1) != 0 ? r9.isInitialized : false, (r32 & 2) != 0 ? r9.pickerItems : null, (r32 & 4) != 0 ? r9.activeCurrencyCard : null, (r32 & 8) != 0 ? r9.sourceSwapAsset : null, (r32 & 16) != 0 ? r9.targetSwapAsset : null, (r32 & 32) != 0 ? r9.error : null, (r32 & 64) != 0 ? r9.isLoading : true, (r32 & 128) != 0 ? r9.nextButtonTitle : null, (r32 & 256) != 0 ? r9.fiatAmountText : null, (r32 & 512) != 0 ? r9.equivalentAmountInCrypto : null, (r32 & 1024) != 0 ? r9.focusedCryptoInputField : null, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r9.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? r9.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r9.cryptoTargetAmount : null, (r32 & 16384) != 0 ? this.state.isTargetFieldDisabled : false);
        setState(copy);
        h.c.b0 flatMap = h.c.t0.e.a.a(takeSingle, takeSingle2).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapAmountPickerViewModel.g(TransferValue.this, this, sourceSwapAsset, targetSwapAsset, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "Singles.zip(ethereumWalletSingle, sourceWalletSingle)\n            .flatMap { (ethWallet, sourceWallet) ->\n                val walletAddress = WalletAddress(\n                    type = AddressType.Ethereum,\n                    address = ethWallet.primaryAddress,\n                    index = ethWallet.selectedIndex ?: throw Exception(\"ETH wallet index should not be null\")\n                )\n\n                val amountLocal = when (transferAmount) {\n                    TransferValue.EntireBalance -> sourceWallet.maximumAvailableBalance()\n                    is TransferValue.Amount -> transferAmount.value\n                }\n                swapRepository.getTrade(\n                    address = walletAddress,\n                    source = source,\n                    target = target,\n                    amount = amountLocal,\n                    amountBase = lastEditedInput.asAmountBase(),\n                    chainId = ethWallet.network.asChainId()\n                )\n            }");
        h.c.b0 observeOn = Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "Singles.zip(ethereumWalletSingle, sourceWalletSingle)\n            .flatMap { (ethWallet, sourceWallet) ->\n                val walletAddress = WalletAddress(\n                    type = AddressType.Ethereum,\n                    address = ethWallet.primaryAddress,\n                    index = ethWallet.selectedIndex ?: throw Exception(\"ETH wallet index should not be null\")\n                )\n\n                val amountLocal = when (transferAmount) {\n                    TransferValue.EntireBalance -> sourceWallet.maximumAvailableBalance()\n                    is TransferValue.Amount -> transferAmount.value\n                }\n                swapRepository.getTrade(\n                    address = walletAddress,\n                    source = source,\n                    target = target,\n                    amount = amountLocal,\n                    amountBase = lastEditedInput.asAmountBase(),\n                    chainId = ethWallet.network.asChainId()\n                )\n            }\n            .logError()\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.f(observeOn, new SwapAmountPickerViewModel$proceedToConfirmTx$2(this, sourceSwapAsset, targetSwapAsset), new SwapAmountPickerViewModel$proceedToConfirmTx$3(this, amountBase, sourceSwapAsset, targetSwapAsset, amount)), this.disposeBag);
    }

    public final void refreshQuote() {
        SwapAsset targetSwapAsset;
        BigInteger bigInteger$default;
        SwapAsset sourceSwapAsset = this.state.getSourceSwapAsset();
        if (sourceSwapAsset == null || (targetSwapAsset = this.state.getTargetSwapAsset()) == null) {
            return;
        }
        if (kotlin.jvm.internal.m.c(asAmountBase(this.lastEditedInput), AmountBase.Source.INSTANCE)) {
            bigInteger$default = toBigInteger$default(this, sourceSwapAsset, this.state.getCryptoSourceAmount().getRawString(), null, 2, null);
        } else {
            bigInteger$default = toBigInteger$default(this, targetSwapAsset, this.state.getCryptoTargetAmount().getRawString(), null, 2, null);
        }
        this.quoteSubject.onNext(new QuoteRequest(sourceSwapAsset, targetSwapAsset, bigInteger$default, asAmountBase(this.lastEditedInput)));
    }

    public final void selectAsset(AmountBase amountBase) {
        kotlin.jvm.internal.m.g(amountBase, "amountBase");
        this.navigationSubject.onNext(new ViewModelNavRoute(R.id.action_swapAmountPickerFragment_to_swapAssetPickerFragment, SwapAssetPickerArgs.INSTANCE.createArguments(amountBase), Fragment_CommonKt.getVerticalNavOptions(this)));
    }

    public final void selectInput(SwapAmountPickerViewState.CryptoField inputField) {
        SwapAmountPickerViewState copy;
        kotlin.x xVar;
        SwapAmountPickerViewState copy2;
        kotlin.jvm.internal.m.g(inputField, "inputField");
        int i2 = WhenMappings.$EnumSwitchMapping$1[inputField.ordinal()];
        if (i2 == 1) {
            if (this.state.getSourceSwapAsset() == null) {
                selectAsset(AmountBase.Source.INSTANCE);
            } else {
                copy = r2.copy((r32 & 1) != 0 ? r2.isInitialized : false, (r32 & 2) != 0 ? r2.pickerItems : null, (r32 & 4) != 0 ? r2.activeCurrencyCard : null, (r32 & 8) != 0 ? r2.sourceSwapAsset : null, (r32 & 16) != 0 ? r2.targetSwapAsset : null, (r32 & 32) != 0 ? r2.error : null, (r32 & 64) != 0 ? r2.isLoading : false, (r32 & 128) != 0 ? r2.nextButtonTitle : null, (r32 & 256) != 0 ? r2.fiatAmountText : null, (r32 & 512) != 0 ? r2.equivalentAmountInCrypto : null, (r32 & 1024) != 0 ? r2.focusedCryptoInputField : inputField, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r2.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? r2.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r2.cryptoTargetAmount : null, (r32 & 16384) != 0 ? this.state.isTargetFieldDisabled : false);
                setState(copy);
            }
            xVar = kotlin.x.a;
        } else if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            if (this.state.getTargetSwapAsset() == null) {
                selectAsset(AmountBase.Target.INSTANCE);
            } else if (this.state.isTargetFieldDisabled()) {
                return;
            } else {
                copy2 = r2.copy((r32 & 1) != 0 ? r2.isInitialized : false, (r32 & 2) != 0 ? r2.pickerItems : null, (r32 & 4) != 0 ? r2.activeCurrencyCard : null, (r32 & 8) != 0 ? r2.sourceSwapAsset : null, (r32 & 16) != 0 ? r2.targetSwapAsset : null, (r32 & 32) != 0 ? r2.error : null, (r32 & 64) != 0 ? r2.isLoading : false, (r32 & 128) != 0 ? r2.nextButtonTitle : null, (r32 & 256) != 0 ? r2.fiatAmountText : null, (r32 & 512) != 0 ? r2.equivalentAmountInCrypto : null, (r32 & 1024) != 0 ? r2.focusedCryptoInputField : inputField, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r2.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? r2.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r2.cryptoTargetAmount : null, (r32 & 16384) != 0 ? this.state.isTargetFieldDisabled : false);
                setState(copy2);
            }
            xVar = kotlin.x.a;
        }
        SafeWhen_CommonKt.getSafe(xVar);
    }

    public final void switchCurrencyType(SwapCurrencyType type) {
        SwapAmountPickerViewState copy;
        kotlin.jvm.internal.m.g(type, "type");
        if (this.state.getActiveCurrencyCard() != type) {
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.swapAmountPickerCardSelected(AnalyticsEvent.Companion, type.getAnalyticsName()));
            copy = r1.copy((r32 & 1) != 0 ? r1.isInitialized : false, (r32 & 2) != 0 ? r1.pickerItems : null, (r32 & 4) != 0 ? r1.activeCurrencyCard : type, (r32 & 8) != 0 ? r1.sourceSwapAsset : null, (r32 & 16) != 0 ? r1.targetSwapAsset : null, (r32 & 32) != 0 ? r1.error : null, (r32 & 64) != 0 ? r1.isLoading : false, (r32 & 128) != 0 ? r1.nextButtonTitle : null, (r32 & 256) != 0 ? r1.fiatAmountText : null, (r32 & 512) != 0 ? r1.equivalentAmountInCrypto : null, (r32 & 1024) != 0 ? r1.focusedCryptoInputField : null, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r1.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? r1.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r1.cryptoTargetAmount : null, (r32 & 16384) != 0 ? this.state.isTargetFieldDisabled : false);
            setState(copy);
        }
    }
}