package com.coinbase.wallet.commonui.viewmodels;

import androidx.lifecycle.b0;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.common.extensions.List_WalletsKt;
import com.coinbase.wallet.common.utilities.Locales;
import com.coinbase.wallet.commonui.exceptions.AmountsException;
import com.coinbase.wallet.commonui.views.NumberKeyboardDigit;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.models.ExchangeRate;
import h.c.m0.n;
import h.c.s;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.p;
import kotlin.a0.r;
import kotlin.a0.w;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.l0.a0;
import kotlin.l0.v;
import kotlin.x;

/* compiled from: AmountViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010v\u001a\u00020u\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b|\u0010}J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\fJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J9\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u001f2\u0006\u0010\u001e\u001a\u00020\b¢\u0006\u0004\b \u0010!J\u001f\u0010%\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\u0005¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u0012¢\u0006\u0004\b'\u0010\u0014J#\u0010+\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u0002¢\u0006\u0004\b+\u0010,J#\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020\b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u0002¢\u0006\u0004\b.\u0010,R\u0016\u0010/\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00100R\u001e\u00103\u001a\n 2*\u0004\u0018\u000101018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001f\u00108\u001a\b\u0012\u0004\u0012\u0002010\n8\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0016\u0010>\u001a\u0002018B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001f\u0010A\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0006@\u0006¢\u0006\f\n\u0004\bA\u00109\u001a\u0004\bB\u0010;R\u0016\u0010E\u001a\u00020\u00158B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020\"8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010MR\u0016\u0010O\u001a\u00020N8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010M\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020\b8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR$\u0010[\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010\b0\b0Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010]R\u001f\u0010^\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0006@\u0006¢\u0006\f\n\u0004\b^\u00109\u001a\u0004\b_\u0010;R$\u0010a\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00120\u00120`8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010d\u001a\u00020I8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bc\u0010KR$\u0010e\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00050\u00050Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010\\R\u001f\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0006@\u0006¢\u0006\f\n\u0004\bf\u00109\u001a\u0004\bg\u0010;R\u001f\u0010h\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0006@\u0006¢\u0006\f\n\u0004\bh\u00109\u001a\u0004\bi\u0010;R*\u0010\u001a\u001a\u00020\u00052\u0006\u0010j\u001a\u00020\u00058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010k\u001a\u0004\b\u001a\u0010l\"\u0004\bm\u0010nR$\u0010o\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010\b0\b0Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010\\R$\u0010p\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00150\u00150Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010\\R$\u0010r\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u000101010q8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR$\u0010t\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010\b0\b0Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010\\R\u0016\u0010v\u001a\u00020u8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u001f\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00150\n8\u0006@\u0006¢\u0006\f\n\u0004\bx\u00109\u001a\u0004\by\u0010;R\u001f\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00120\n8\u0006@\u0006¢\u0006\f\n\u0004\bz\u00109\u001a\u0004\b{\u0010;¨\u0006~"}, d2 = {"Lcom/coinbase/wallet/commonui/viewmodels/AmountViewModel;", "Landroidx/lifecycle/b0;", "", "", "rawAmount", "", "isValidEntry", "(Ljava/util/List;)Z", "", "rawFiatAmount", "Lh/c/s;", "calculateCryptoAmount", "(Ljava/lang/String;)Lh/c/s;", "rawCryptoAmount", "formatCryptoAmount", "(Ljava/lang/String;)Ljava/lang/String;", "calculateFiatAmount", "formatFiatAmount", "Lkotlin/x;", "didSetIsFiatSelected", "()V", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "", "decimals", "isFiatSelected", RouteActionKey.RouteActionKeys.CHAIN_ID, "setup", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;IZLjava/lang/Integer;)V", "string", "Lh/c/b0;", "updateCryptoAmount", "(Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;", "digit", "longPress", "updateAmount", "(Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;Z)V", "swapFields", "rawCryptoString", "Lcom/coinbase/wallet/wallets/models/ExchangeRate;", "exchangeRates", "convertCryptoToFiat", "(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;", "rawFiatString", "convertFiatToCrypto", "cryptoCurrencyCode", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "Ljava/util/Locale;", "kotlin.jvm.PlatformType", "cryptoLocale", "Ljava/util/Locale;", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "keyboardLocaleObservable", "Lh/c/s;", "getKeyboardLocaleObservable", "()Lh/c/s;", "getFiatLocale", "()Ljava/util/Locale;", "fiatLocale", "cryptoDecimals", "I", "primaryTextObservable", "getPrimaryTextObservable", "getLocalCurrency", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "localCurrency", "getDecimalSeparator", "()Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;", "decimalSeparator", "Ljava/text/DecimalFormat;", "getFiatFormatter", "()Ljava/text/DecimalFormat;", "fiatFormatter", "Ljava/util/List;", "Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "currencyRepository", "Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "cryptoCurrencyChainId", "Ljava/lang/Integer;", "getRawCryptoAmount", "()Ljava/util/List;", "setRawCryptoAmount", "(Ljava/util/List;)V", "getCryptoSuffix", "()Ljava/lang/String;", "cryptoSuffix", "Lh/c/v0/a;", "primaryTextSubject", "Lh/c/v0/a;", "Ljava/lang/String;", "cryptoAmountObservable", "getCryptoAmountObservable", "Lh/c/v0/b;", "textEntryErrorSubject", "Lh/c/v0/b;", "getCryptoFormatter", "cryptoFormatter", "secondaryTextVisibleSubject", "secondaryTextVisibleObservable", "getSecondaryTextVisibleObservable", "secondaryTextObservable", "getSecondaryTextObservable", "value", "Z", "()Z", "setFiatSelected", "(Z)V", "cryptoAmountSubject", "currencyCodeSubject", "Lh/c/v0/c;", "keyboardLocaleSubject", "Lh/c/v0/c;", "secondaryTextSubject", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "currencyCodeObservable", "getCurrencyCodeObservable", "textEntryErrorObservable", "getTextEntryErrorObservable", "<init>", "(Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AmountViewModel extends b0 {
    private String contractAddress;
    private final s<String> cryptoAmountObservable;
    private final h.c.v0.a<String> cryptoAmountSubject;
    private Integer cryptoCurrencyChainId;
    private CurrencyCode cryptoCurrencyCode;
    private int cryptoDecimals;
    private final Locale cryptoLocale;
    private final s<CurrencyCode> currencyCodeObservable;
    private final h.c.v0.a<CurrencyCode> currencyCodeSubject;
    private final CurrencyFormatter currencyFormatter;
    private final IFiatCurrencyRepository currencyRepository;
    private final IExchangeRateRepository exchangeRateRepository;
    private boolean isFiatSelected;
    private final s<Locale> keyboardLocaleObservable;
    private final h.c.v0.c<Locale> keyboardLocaleSubject;
    private final s<String> primaryTextObservable;
    private final h.c.v0.a<String> primaryTextSubject;
    private List<Character> rawCryptoAmount;
    private List<Character> rawFiatAmount;
    private final s<String> secondaryTextObservable;
    private final h.c.v0.a<String> secondaryTextSubject;
    private final s<Boolean> secondaryTextVisibleObservable;
    private final h.c.v0.a<Boolean> secondaryTextVisibleSubject;
    private final s<x> textEntryErrorObservable;
    private final h.c.v0.b<x> textEntryErrorSubject;

    /* compiled from: AmountViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NumberKeyboardDigit.values().length];
            iArr[NumberKeyboardDigit.DecimalSeparator.ordinal()] = 1;
            iArr[NumberKeyboardDigit.Zero.ordinal()] = 2;
            iArr[NumberKeyboardDigit.Delete.ordinal()] = 3;
            iArr[NumberKeyboardDigit.GroupSeparator.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AmountViewModel(IFiatCurrencyRepository currencyRepository, IExchangeRateRepository exchangeRateRepository, CurrencyFormatter currencyFormatter) {
        List<Character> g2;
        List<Character> g3;
        m.g(currencyRepository, "currencyRepository");
        m.g(exchangeRateRepository, "exchangeRateRepository");
        m.g(currencyFormatter, "currencyFormatter");
        this.currencyRepository = currencyRepository;
        this.exchangeRateRepository = exchangeRateRepository;
        this.currencyFormatter = currencyFormatter;
        this.cryptoLocale = Locale.US;
        h.c.v0.a<String> d2 = h.c.v0.a.d();
        m.f(d2, "create<String>()");
        this.primaryTextSubject = d2;
        h.c.v0.a<String> d3 = h.c.v0.a.d();
        m.f(d3, "create<String>()");
        this.secondaryTextSubject = d3;
        h.c.v0.a<Boolean> d4 = h.c.v0.a.d();
        m.f(d4, "create<Boolean>()");
        this.secondaryTextVisibleSubject = d4;
        h.c.v0.b<x> d5 = h.c.v0.b.d();
        m.f(d5, "create<Unit>()");
        this.textEntryErrorSubject = d5;
        h.c.v0.a<CurrencyCode> d6 = h.c.v0.a.d();
        m.f(d6, "create<CurrencyCode>()");
        this.currencyCodeSubject = d6;
        h.c.v0.c<Locale> d7 = h.c.v0.c.d(1);
        m.f(d7, "createWithSize<Locale>(1)");
        this.keyboardLocaleSubject = d7;
        h.c.v0.a<String> d8 = h.c.v0.a.d();
        m.f(d8, "create<String>()");
        this.cryptoAmountSubject = d8;
        g2 = r.g();
        this.rawFiatAmount = g2;
        g3 = r.g();
        this.rawCryptoAmount = g3;
        s<String> hide = d2.hide();
        m.f(hide, "primaryTextSubject.hide()");
        this.primaryTextObservable = hide;
        s<String> hide2 = d3.hide();
        m.f(hide2, "secondaryTextSubject.hide()");
        this.secondaryTextObservable = hide2;
        s<Boolean> hide3 = d4.hide();
        m.f(hide3, "secondaryTextVisibleSubject.hide()");
        this.secondaryTextVisibleObservable = hide3;
        s<x> hide4 = d5.hide();
        m.f(hide4, "textEntryErrorSubject.hide()");
        this.textEntryErrorObservable = hide4;
        s<CurrencyCode> hide5 = d6.hide();
        m.f(hide5, "currencyCodeSubject.hide()");
        this.currencyCodeObservable = hide5;
        s<Locale> hide6 = d7.hide();
        m.f(hide6, "keyboardLocaleSubject.hide()");
        this.keyboardLocaleObservable = hide6;
        s<String> hide7 = d8.hide();
        m.f(hide7, "cryptoAmountSubject.hide()");
        this.cryptoAmountObservable = hide7;
        this.isFiatSelected = true;
    }

    public static /* synthetic */ x a(AmountViewModel amountViewModel, String str) {
        return m811updateAmount$lambda5(amountViewModel, str);
    }

    public static /* synthetic */ String b(AmountViewModel amountViewModel, String str, List list) {
        return m808calculateCryptoAmount$lambda8(amountViewModel, str, list);
    }

    public static /* synthetic */ x c(AmountViewModel amountViewModel, String str) {
        return m812updateCryptoAmount$lambda2(amountViewModel, str);
    }

    private final s<String> calculateCryptoAmount(final String str) {
        s map = this.exchangeRateRepository.getExchangeRateObservable().map(new n() { // from class: com.coinbase.wallet.commonui.viewmodels.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AmountViewModel.b(AmountViewModel.this, str, (List) obj);
            }
        });
        m.f(map, "exchangeRateRepository.exchangeRateObservable\n            .map { exchangeRates -> convertFiatToCrypto(rawFiatAmount, exchangeRates) }");
        return map;
    }

    /* renamed from: calculateCryptoAmount$lambda-8 */
    public static final String m808calculateCryptoAmount$lambda8(AmountViewModel this$0, String rawFiatAmount, List exchangeRates) {
        m.g(this$0, "this$0");
        m.g(rawFiatAmount, "$rawFiatAmount");
        m.g(exchangeRates, "exchangeRates");
        return this$0.convertFiatToCrypto(rawFiatAmount, exchangeRates);
    }

    private final s<String> calculateFiatAmount(final String str) {
        s map = this.exchangeRateRepository.getExchangeRateObservable().map(new n() { // from class: com.coinbase.wallet.commonui.viewmodels.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AmountViewModel.e(AmountViewModel.this, str, (List) obj);
            }
        });
        m.f(map, "exchangeRateRepository.exchangeRateObservable\n        .map { exchangeRates ->\n            convertCryptoToFiat(rawCryptoAmount, exchangeRates)\n        }");
        return map;
    }

    /* renamed from: calculateFiatAmount$lambda-10 */
    public static final String m809calculateFiatAmount$lambda10(AmountViewModel this$0, String rawCryptoAmount, List exchangeRates) {
        m.g(this$0, "this$0");
        m.g(rawCryptoAmount, "$rawCryptoAmount");
        m.g(exchangeRates, "exchangeRates");
        return this$0.convertCryptoToFiat(rawCryptoAmount, exchangeRates);
    }

    public static /* synthetic */ x d(AmountViewModel amountViewModel, String str) {
        return m810updateAmount$lambda4(amountViewModel, str);
    }

    private final void didSetIsFiatSelected() {
        CurrencyCode currencyCode;
        List<Character> list = this.rawFiatAmount;
        boolean z = false;
        boolean z2 = list == null || list.isEmpty();
        String str = Strings.zero;
        String h0 = z2 ? Strings.zero : z.h0(this.rawFiatAmount, Strings_CoreKt.getEmpty(Strings.INSTANCE), null, null, 0, null, null, 62, null);
        List<Character> list2 = this.rawCryptoAmount;
        if (list2 == null || list2.isEmpty()) {
            z = true;
        }
        if (!z) {
            str = z.h0(this.rawCryptoAmount, Strings_CoreKt.getEmpty(Strings.INSTANCE), null, null, 0, null, null, 62, null);
        }
        String formatFiatAmount = formatFiatAmount(h0);
        String formatCryptoAmount = formatCryptoAmount(str);
        boolean z3 = this.isFiatSelected;
        String str2 = z3 ? formatFiatAmount : formatCryptoAmount;
        if (z3) {
            formatFiatAmount = formatCryptoAmount;
        }
        this.primaryTextSubject.onNext(str2);
        this.secondaryTextSubject.onNext(formatFiatAmount);
        h.c.v0.a<CurrencyCode> aVar = this.currencyCodeSubject;
        if (this.isFiatSelected) {
            currencyCode = getLocalCurrency();
        } else {
            currencyCode = this.cryptoCurrencyCode;
            if (currencyCode == null) {
                m.w("cryptoCurrencyCode");
                throw null;
            }
        }
        aVar.onNext(currencyCode);
        this.keyboardLocaleSubject.onNext(this.isFiatSelected ? getFiatLocale() : this.cryptoLocale);
    }

    public static /* synthetic */ String e(AmountViewModel amountViewModel, String str, List list) {
        return m809calculateFiatAmount$lambda10(amountViewModel, str, list);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0060, code lost:
        if (r4 != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String formatCryptoAmount(java.lang.String r12) {
        /*
            r11 = this;
            int r0 = r12.length()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto La
            r0 = r1
            goto Lb
        La:
            r0 = r2
        Lb:
            if (r0 == 0) goto Lf
            java.lang.String r12 = "0"
        Lf:
            com.coinbase.wallet.commonui.views.NumberKeyboardDigit r0 = r11.getDecimalSeparator()
            java.lang.String r0 = r0.getDescription()
            r9 = 2
            r10 = 0
            boolean r0 = kotlin.l0.o.V(r12, r0, r2, r9, r10)
            if (r0 == 0) goto L3f
            java.lang.String[] r4 = new java.lang.String[r1]
            com.coinbase.wallet.commonui.views.NumberKeyboardDigit r0 = r11.getDecimalSeparator()
            java.lang.String r0 = r0.getDescription()
            r4[r2] = r0
            r5 = 0
            r6 = 0
            r7 = 6
            r8 = 0
            r3 = r12
            java.util.List r0 = kotlin.l0.o.K0(r3, r4, r5, r6, r7, r8)
            java.lang.Object r0 = kotlin.a0.p.j0(r0)
            java.lang.String r0 = (java.lang.String) r0
            int r0 = r0.length()
            goto L40
        L3f:
            r0 = r2
        L40:
            java.text.DecimalFormat r3 = r11.getCryptoFormatter()
            com.coinbase.wallet.commonui.views.NumberKeyboardDigit r4 = r11.getDecimalSeparator()
            java.lang.String r4 = r4.getDescription()
            boolean r4 = kotlin.l0.o.V(r12, r4, r2, r9, r10)
            if (r4 == 0) goto L63
            if (r0 > 0) goto L64
            com.coinbase.wallet.commonui.views.NumberKeyboardDigit r4 = r11.getDecimalSeparator()
            java.lang.String r4 = r4.getDescription()
            boolean r4 = kotlin.l0.o.z(r12, r4, r2, r9, r10)
            if (r4 == 0) goto L63
            goto L64
        L63:
            r1 = r2
        L64:
            r3.setDecimalSeparatorAlwaysShown(r1)
            int r1 = r3.getMaximumFractionDigits()
            int r0 = java.lang.Math.min(r0, r1)
            r3.setMinimumFractionDigits(r0)
            java.math.BigDecimal r0 = new java.math.BigDecimal
            r0.<init>(r12)
            java.lang.String r12 = r3.format(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r12)
            r12 = 32
            r0.append(r12)
            java.lang.String r12 = r11.getCryptoSuffix()
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.CharSequence"
            java.util.Objects.requireNonNull(r12, r0)
            java.lang.CharSequence r12 = kotlin.l0.o.h1(r12)
            java.lang.String r12 = r12.toString()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.commonui.viewmodels.AmountViewModel.formatCryptoAmount(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0063, code lost:
        if (r5 != false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String formatFiatAmount(java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.commonui.viewmodels.AmountViewModel.formatFiatAmount(java.lang.String):java.lang.String");
    }

    private final DecimalFormat getCryptoFormatter() {
        NumberFormat numberInstance = DecimalFormat.getNumberInstance(this.cryptoLocale);
        Objects.requireNonNull(numberInstance, "null cannot be cast to non-null type java.text.DecimalFormat");
        DecimalFormat decimalFormat = (DecimalFormat) numberInstance;
        decimalFormat.setMaximumFractionDigits(this.cryptoDecimals);
        return decimalFormat;
    }

    private final String getCryptoSuffix() {
        if (this.isFiatSelected) {
            CurrencyCode currencyCode = this.cryptoCurrencyCode;
            if (currencyCode != null) {
                return currencyCode.getRawValue();
            }
            m.w("cryptoCurrencyCode");
            throw null;
        }
        return Strings_CoreKt.getEmpty(Strings.INSTANCE);
    }

    private final NumberKeyboardDigit getDecimalSeparator() {
        return NumberKeyboardDigit.DecimalSeparator;
    }

    private final DecimalFormat getFiatFormatter() {
        NumberFormat currencyInstance;
        if (this.isFiatSelected) {
            currencyInstance = DecimalFormat.getNumberInstance(getFiatLocale());
        } else {
            currencyInstance = DecimalFormat.getCurrencyInstance(getFiatLocale());
        }
        Objects.requireNonNull(currencyInstance, "null cannot be cast to non-null type java.text.DecimalFormat");
        DecimalFormat decimalFormat = (DecimalFormat) currencyInstance;
        decimalFormat.setCurrency(Currency.getInstance(getLocalCurrency().getRawValue()));
        Currency currency = decimalFormat.getCurrency();
        Integer valueOf = currency == null ? null : Integer.valueOf(currency.getDefaultFractionDigits());
        if (valueOf != null) {
            decimalFormat.setMaximumFractionDigits(valueOf.intValue());
            return decimalFormat;
        }
        throw new IllegalStateException("No currency found");
    }

    private final Locale getFiatLocale() {
        return Locales.INSTANCE.getCurrent();
    }

    private final CurrencyCode getLocalCurrency() {
        return this.currencyRepository.getActiveCurrency().getCode();
    }

    private final boolean isValidEntry(List<Character> list) {
        List v0;
        char p1;
        v0 = z.v0(list);
        p1 = a0.p1(getDecimalSeparator().getDescription());
        int indexOf = v0.indexOf(Character.valueOf(p1));
        if (this.isFiatSelected) {
            if (indexOf < getFiatFormatter().getMaximumFractionDigits()) {
                return true;
            }
        } else if (indexOf < getCryptoFormatter().getMaximumFractionDigits()) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ void updateAmount$default(AmountViewModel amountViewModel, NumberKeyboardDigit numberKeyboardDigit, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        amountViewModel.updateAmount(numberKeyboardDigit, z);
    }

    /* renamed from: updateAmount$lambda-4 */
    public static final x m810updateAmount$lambda4(AmountViewModel this$0, String it) {
        List<Character> v1;
        m.g(this$0, "this$0");
        m.g(it, "it");
        v1 = a0.v1(it);
        this$0.setRawCryptoAmount(v1);
        this$0.cryptoAmountSubject.onNext(it);
        this$0.secondaryTextSubject.onNext(this$0.formatCryptoAmount(it));
        return x.a;
    }

    /* renamed from: updateAmount$lambda-5 */
    public static final x m811updateAmount$lambda5(AmountViewModel this$0, String it) {
        List<Character> v1;
        m.g(this$0, "this$0");
        m.g(it, "it");
        v1 = a0.v1(it);
        this$0.rawFiatAmount = v1;
        this$0.secondaryTextSubject.onNext(this$0.formatFiatAmount(it));
        return x.a;
    }

    /* renamed from: updateCryptoAmount$lambda-2 */
    public static final x m812updateCryptoAmount$lambda2(AmountViewModel this$0, String it) {
        List<Character> v1;
        m.g(this$0, "this$0");
        m.g(it, "it");
        v1 = a0.v1(it);
        this$0.rawFiatAmount = v1;
        String formatFiatAmount = this$0.formatFiatAmount(it);
        if (this$0.isFiatSelected()) {
            this$0.primaryTextSubject.onNext(formatFiatAmount);
        } else {
            this$0.secondaryTextSubject.onNext(formatFiatAmount);
        }
        return x.a;
    }

    public final String convertCryptoToFiat(String rawCryptoString, List<ExchangeRate> exchangeRates) {
        boolean D;
        BigDecimal j2;
        BigDecimal scale;
        m.g(rawCryptoString, "rawCryptoString");
        m.g(exchangeRates, "exchangeRates");
        D = kotlin.l0.x.D(rawCryptoString);
        if (D) {
            scale = BigDecimal.ZERO;
        } else {
            CurrencyCode currencyCode = this.cryptoCurrencyCode;
            if (currencyCode != null) {
                BigDecimal rateFor$default = List_WalletsKt.rateFor$default(exchangeRates, currencyCode, null, null, this.cryptoCurrencyChainId, 4, null);
                j2 = v.j(rawCryptoString);
                BigDecimal scale2 = j2 != null ? j2.setScale(this.cryptoDecimals, RoundingMode.HALF_DOWN) : null;
                if (scale2 != null) {
                    if (scale2.compareTo(BigDecimal.ZERO) >= 0) {
                        scale = scale2.multiply(rateFor$default).setScale(getFiatFormatter().getMaximumFractionDigits(), RoundingMode.HALF_DOWN);
                        if (BigDecimal.ZERO.compareTo(scale) == 0) {
                            scale = BigDecimal.ZERO;
                        }
                    } else {
                        throw new AmountsException.InvalidAmount(rawCryptoString);
                    }
                } else {
                    throw new AmountsException.BigDecimalConversionFailed(rawCryptoString);
                }
            } else {
                m.w("cryptoCurrencyCode");
                throw null;
            }
        }
        String plainString = scale.toPlainString();
        m.f(plainString, "when {\n        rawCryptoString.isBlank() -> BigDecimal.ZERO\n        else -> {\n            val exchangeRate = exchangeRates.rateFor(\n                currencyCode = cryptoCurrencyCode,\n                contractAddress = null,\n                chainId = cryptoCurrencyChainId\n            )\n            val balanceValue = rawCryptoString.toBigDecimalOrNull()?.setScale(cryptoDecimals, RoundingMode.HALF_DOWN)\n                ?: throw AmountsException.BigDecimalConversionFailed(rawCryptoString)\n\n            if (balanceValue < BigDecimal.ZERO) throw AmountsException.InvalidAmount(rawCryptoString)\n\n            balanceValue.multiply(exchangeRate)\n                .setScale(fiatFormatter.maximumFractionDigits, RoundingMode.HALF_DOWN)\n                .run { if (BigDecimal.ZERO.compareTo(this) == 0) BigDecimal.ZERO else this }\n        }\n    }.toPlainString()");
        return plainString;
    }

    public final String convertFiatToCrypto(String rawFiatString, List<ExchangeRate> exchangeRates) {
        boolean D;
        BigDecimal j2;
        BigDecimal scale;
        m.g(rawFiatString, "rawFiatString");
        m.g(exchangeRates, "exchangeRates");
        D = kotlin.l0.x.D(rawFiatString);
        if (D) {
            scale = BigDecimal.ZERO;
        } else {
            CurrencyCode currencyCode = this.cryptoCurrencyCode;
            if (currencyCode != null) {
                BigDecimal rateFor$default = List_WalletsKt.rateFor$default(exchangeRates, currencyCode, null, null, this.cryptoCurrencyChainId, 4, null);
                j2 = v.j(rawFiatString);
                BigDecimal scale2 = j2 != null ? j2.setScale(this.cryptoDecimals, RoundingMode.HALF_DOWN) : null;
                if (scale2 != null) {
                    if (scale2.compareTo(BigDecimal.ZERO) >= 0) {
                        scale = scale2.divide(rateFor$default, RoundingMode.HALF_DOWN).setScale(this.cryptoDecimals, RoundingMode.HALF_DOWN);
                        if (BigDecimal.ZERO.compareTo(scale) == 0) {
                            scale = BigDecimal.ZERO;
                        }
                    } else {
                        throw new AmountsException.InvalidAmount(rawFiatString);
                    }
                } else {
                    throw new AmountsException.BigDecimalConversionFailed(rawFiatString);
                }
            } else {
                m.w("cryptoCurrencyCode");
                throw null;
            }
        }
        String plainString = scale.toPlainString();
        m.f(plainString, "when {\n        rawFiatString.isBlank() -> BigDecimal.ZERO\n        else -> {\n            val exchangeRate = exchangeRates.rateFor(\n                currencyCode = cryptoCurrencyCode,\n                contractAddress = null,\n                chainId = cryptoCurrencyChainId\n            )\n            val balanceValue = rawFiatString.toBigDecimalOrNull()?.setScale(cryptoDecimals, RoundingMode.HALF_DOWN)\n                ?: throw AmountsException.BigDecimalConversionFailed(rawFiatString)\n\n            if (balanceValue < BigDecimal.ZERO) throw AmountsException.InvalidAmount(rawFiatString)\n\n            balanceValue.divide(exchangeRate, RoundingMode.HALF_DOWN)\n                .setScale(cryptoDecimals, RoundingMode.HALF_DOWN)\n                .run { if (BigDecimal.ZERO.compareTo(this) == 0) BigDecimal.ZERO else this }\n        }\n    }.toPlainString()");
        return plainString;
    }

    public final s<String> getCryptoAmountObservable() {
        return this.cryptoAmountObservable;
    }

    public final s<CurrencyCode> getCurrencyCodeObservable() {
        return this.currencyCodeObservable;
    }

    public final s<Locale> getKeyboardLocaleObservable() {
        return this.keyboardLocaleObservable;
    }

    public final s<String> getPrimaryTextObservable() {
        return this.primaryTextObservable;
    }

    public final List<Character> getRawCryptoAmount() {
        return this.rawCryptoAmount;
    }

    public final s<String> getSecondaryTextObservable() {
        return this.secondaryTextObservable;
    }

    public final s<Boolean> getSecondaryTextVisibleObservable() {
        return this.secondaryTextVisibleObservable;
    }

    public final s<x> getTextEntryErrorObservable() {
        return this.textEntryErrorObservable;
    }

    public final boolean isFiatSelected() {
        return this.isFiatSelected;
    }

    public final void setFiatSelected(boolean z) {
        this.isFiatSelected = z;
        didSetIsFiatSelected();
    }

    public final void setRawCryptoAmount(List<Character> list) {
        m.g(list, "<set-?>");
        this.rawCryptoAmount = list;
    }

    public final void setup(CurrencyCode currencyCode, String str, int i2, boolean z, Integer num) {
        List<Character> v1;
        List<Character> v12;
        m.g(currencyCode, "currencyCode");
        CurrencyCode currencyCode2 = this.cryptoCurrencyCode;
        if (currencyCode2 == null) {
            currencyCode2 = null;
        } else if (currencyCode2 == null) {
            m.w("cryptoCurrencyCode");
            throw null;
        }
        this.cryptoCurrencyChainId = num;
        this.cryptoCurrencyCode = currencyCode;
        this.cryptoDecimals = i2;
        this.contractAddress = str;
        if (this.rawCryptoAmount.isEmpty() || !m.c(currencyCode2, currencyCode)) {
            boolean hasFiatRepresentation = this.currencyFormatter.hasFiatRepresentation(currencyCode, str, null);
            v1 = a0.v1(Strings.zero);
            this.rawCryptoAmount = v1;
            v12 = a0.v1(Strings.zero);
            this.rawFiatAmount = v12;
            h.c.v0.a<CurrencyCode> aVar = this.currencyCodeSubject;
            if (z) {
                currencyCode = getLocalCurrency();
            }
            aVar.onNext(currencyCode);
            setFiatSelected(z && hasFiatRepresentation);
            this.secondaryTextVisibleSubject.onNext(Boolean.valueOf(hasFiatRepresentation));
        }
        didSetIsFiatSelected();
    }

    public final void swapFields() {
        setFiatSelected(!this.isFiatSelected);
    }

    public final void updateAmount(NumberKeyboardDigit digit, boolean z) {
        List<Character> K0;
        char p1;
        char p12;
        char p13;
        char p14;
        String h0;
        String h02;
        char p15;
        char p16;
        int i2;
        char p17;
        char p18;
        m.g(digit, "digit");
        K0 = z.K0(this.isFiatSelected ? this.rawFiatAmount : this.rawCryptoAmount);
        w.D(K0, AmountViewModel$updateAmount$1.INSTANCE);
        int i3 = WhenMappings.$EnumSwitchMapping$0[digit.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                if (K0.size() == 1) {
                    char charValue = ((Character) p.Y(K0)).charValue();
                    p16 = a0.p1(digit.getDescription());
                    if (charValue == p16) {
                        this.textEntryErrorSubject.onNext(x.a);
                        return;
                    }
                }
                if (!isValidEntry(K0)) {
                    this.textEntryErrorSubject.onNext(x.a);
                    return;
                } else {
                    p15 = a0.p1(digit.getDescription());
                    K0.add(Character.valueOf(p15));
                }
            } else if (i3 != 3) {
                if (i3 != 4) {
                    if (K0.size() == 1) {
                        char charValue2 = ((Character) p.Y(K0)).charValue();
                        p18 = a0.p1(NumberKeyboardDigit.Zero.getDescription());
                        if (charValue2 == p18) {
                            K0.clear();
                        }
                    }
                    if (isValidEntry(K0)) {
                        p17 = a0.p1(digit.getDescription());
                        K0.add(Character.valueOf(p17));
                    } else {
                        this.textEntryErrorSubject.onNext(x.a);
                        return;
                    }
                } else {
                    this.textEntryErrorSubject.onNext(x.a);
                    return;
                }
            } else if (z) {
                K0.clear();
            } else if (K0.size() > 0) {
                i2 = r.i(K0);
                K0.remove(i2);
            }
        } else if (K0.isEmpty()) {
            p13 = a0.p1(NumberKeyboardDigit.Zero.getDescription());
            K0.add(Character.valueOf(p13));
            p14 = a0.p1(digit.getDescription());
            K0.add(Character.valueOf(p14));
        } else {
            p1 = a0.p1(digit.getDescription());
            if (K0.contains(Character.valueOf(p1))) {
                this.textEntryErrorSubject.onNext(x.a);
                return;
            } else {
                p12 = a0.p1(digit.getDescription());
                K0.add(Character.valueOf(p12));
            }
        }
        if (this.isFiatSelected) {
            this.rawFiatAmount = K0;
            h02 = z.h0(K0, Strings_CoreKt.getEmpty(Strings.INSTANCE), null, null, 0, null, null, 62, null);
            this.primaryTextSubject.onNext(formatFiatAmount(h02));
            Observable_CoreKt.takeSingle(calculateCryptoAmount(h02)).map(new n() { // from class: com.coinbase.wallet.commonui.viewmodels.d
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return AmountViewModel.d(AmountViewModel.this, (String) obj);
                }
            }).subscribe();
            return;
        }
        this.rawCryptoAmount = K0;
        h0 = z.h0(K0, Strings_CoreKt.getEmpty(Strings.INSTANCE), null, null, 0, null, null, 62, null);
        this.cryptoAmountSubject.onNext(h0);
        this.primaryTextSubject.onNext(formatCryptoAmount(h0));
        Observable_CoreKt.takeSingle(calculateFiatAmount(h0)).map(new n() { // from class: com.coinbase.wallet.commonui.viewmodels.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AmountViewModel.a(AmountViewModel.this, (String) obj);
            }
        }).subscribe();
    }

    public final h.c.b0<String> updateCryptoAmount(String string) {
        List<Character> v1;
        String h0;
        m.g(string, "string");
        v1 = a0.v1(string);
        this.rawCryptoAmount = v1;
        Observable_CoreKt.takeSingle(calculateFiatAmount(string)).map(new n() { // from class: com.coinbase.wallet.commonui.viewmodels.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AmountViewModel.c(AmountViewModel.this, (String) obj);
            }
        }).subscribe();
        String formatCryptoAmount = formatCryptoAmount(string);
        if (this.isFiatSelected) {
            this.secondaryTextSubject.onNext(formatCryptoAmount);
        } else {
            this.primaryTextSubject.onNext(formatCryptoAmount);
        }
        h0 = z.h0(this.rawCryptoAmount, "", null, null, 0, null, null, 62, null);
        h.c.b0<String> just = h.c.b0.just(h0);
        m.f(just, "just(rawCryptoString)");
        return just;
    }
}