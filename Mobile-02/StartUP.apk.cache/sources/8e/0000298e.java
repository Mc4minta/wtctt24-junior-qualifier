package com.coinbase.wallet.wallets.formatters;

import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.common.extensions.List_WalletsKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.core.interfaces.Destroyable;
import com.coinbase.wallet.core.interfaces.Startable;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.wallets.extensions.StoreKeys_WalletsKt;
import com.coinbase.wallet.wallets.models.ExchangeRate;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import h.c.a0;
import h.c.b0;
import h.c.k0.a;
import h.c.s;
import h.c.t0.g;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.p;
import kotlin.a0.r;
import kotlin.i0.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.l0.i;
import kotlin.l0.k;
import kotlin.l0.y;
import org.apache.http.message.TokenParser;

/* compiled from: CurrencyFormatter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB#\u0012\u0006\u0010=\u001a\u00020<\u0012\u0012\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060509¢\u0006\u0004\bB\u0010CJ\u0017\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006JI\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012JS\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0015\u0010\u0016J]\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0019\u0010\u001aJC\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\u00132\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010 JC\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020!2\b\b\u0002\u0010\u001c\u001a\u00020\u00132\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010\"JM\u0010#\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\u00132\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b#\u0010$J)\u0010%\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b%\u0010&J\u001f\u0010(\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020!2\b\b\u0002\u0010'\u001a\u00020\u0013¢\u0006\u0004\b(\u0010)JG\u0010*\u001a\u0004\u0018\u00010!2\u0006\u0010\u001b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.J\u0015\u00100\u001a\b\u0012\u0004\u0012\u00020\u00130/H\u0016¢\u0006\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001c\u00107\u001a\b\u0012\u0004\u0012\u000206058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020605098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006E"}, d2 = {"Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Ljava/util/Currency;", "kotlin.jvm.PlatformType", "getActiveCurrency", "()Ljava/util/Currency;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "fromCurrencyCode", "", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "", "decimals", "Ljava/math/BigInteger;", "value", ApiConstants.NAME, RouteActionKey.RouteActionKeys.CHAIN_ID, "formatToAbbreviatedFiat", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;ILjava/math/BigInteger;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "", "isAbbreviated", "formatToFiat", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;ILjava/math/BigInteger;ZLjava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "lowerBoundValue", "upperBoundValue", "formatToFiatRange", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;ILjava/math/BigInteger;Ljava/math/BigInteger;ZLjava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", AppsFlyerProperties.CURRENCY_CODE, "includeCode", "maxDisplayDecimals", "minDisplayDecimals", "formatToCrypto", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ILjava/math/BigInteger;ZII)Ljava/lang/String;", "Ljava/math/BigDecimal;", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ILjava/math/BigDecimal;ZII)Ljava/lang/String;", "formatToCryptoRange", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ILjava/math/BigInteger;Ljava/math/BigInteger;ZII)Ljava/lang/String;", "hasFiatRepresentation", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;Ljava/lang/Integer;)Z", "showCurrencySymbol", "fiatValueString", "(Ljava/math/BigDecimal;Z)Ljava/lang/String;", "fiatValue", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;ILjava/math/BigInteger;Ljava/lang/String;Ljava/lang/Integer;)Ljava/math/BigDecimal;", "Lkotlin/x;", "start", "()V", "Lh/c/b0;", "destroy", "()Lh/c/b0;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "", "Lcom/coinbase/wallet/wallets/models/ExchangeRate;", "exchangeRates", "Ljava/util/List;", "Lh/c/s;", "exchangeRateObservable", "Lh/c/s;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lh/c/a0;", "concurrentScheduler", "Lh/c/a0;", "<init>", "(Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lh/c/s;)V", "Companion", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CurrencyFormatter implements Startable, Destroyable {
    public static final Companion Companion = new Companion(null);
    public static final int defaultMaxDecimalDisplay = 8;
    public static final int defaultMaxDecimalDisplayForRanges = 4;
    private final a0 concurrentScheduler;
    private final a disposeBag;
    private final s<List<ExchangeRate>> exchangeRateObservable;
    private List<ExchangeRate> exchangeRates;
    private final StoreInterface store;

    /* compiled from: CurrencyFormatter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter$Companion;", "", "", "defaultMaxDecimalDisplay", "I", "defaultMaxDecimalDisplayForRanges", "<init>", "()V", "wallets_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CurrencyFormatter(StoreInterface store, s<List<ExchangeRate>> exchangeRateObservable) {
        List<ExchangeRate> g2;
        m.g(store, "store");
        m.g(exchangeRateObservable, "exchangeRateObservable");
        this.store = store;
        this.exchangeRateObservable = exchangeRateObservable;
        this.disposeBag = new a();
        g2 = r.g();
        this.exchangeRates = g2;
        a0 c2 = h.c.u0.a.c();
        m.f(c2, "io()");
        this.concurrentScheduler = c2;
    }

    public static /* synthetic */ BigDecimal fiatValue$default(CurrencyFormatter currencyFormatter, CurrencyCode currencyCode, String str, int i2, BigInteger bigInteger, String str2, Integer num, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            str2 = null;
        }
        return currencyFormatter.fiatValue(currencyCode, str, i2, bigInteger, str2, num);
    }

    public static /* synthetic */ String fiatValueString$default(CurrencyFormatter currencyFormatter, BigDecimal bigDecimal, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return currencyFormatter.fiatValueString(bigDecimal, z);
    }

    private final String formatToAbbreviatedFiat(CurrencyCode currencyCode, String str, int i2, BigInteger bigInteger, String str2, Integer num) {
        List J0;
        String k1;
        List j2;
        String t1;
        c d2;
        char decimalSeparator = DecimalFormatSymbols.getInstance().getDecimalSeparator();
        if (m.c(bigInteger, BigInteger.ZERO)) {
            return Strings.zero;
        }
        BigDecimal fiatValue = fiatValue(currencyCode, str, i2, bigInteger, str2, num);
        if (fiatValue == null) {
            return null;
        }
        String decimalString = fiatValue.toPlainString();
        m.f(decimalString, "decimalString");
        J0 = y.J0(decimalString, new char[]{'.'}, false, 0, 6, null);
        String str3 = (String) p.a0(J0);
        if (str3 != null) {
            decimalString = str3;
        }
        int length = decimalString.length() / 3;
        if (length == 0) {
            return decimalString;
        }
        int length2 = decimalString.length() % 3;
        m.f(decimalString, "decimalString");
        k1 = kotlin.l0.a0.k1(decimalString, decimalString.length() - length2);
        j2 = r.j("K", "M", "B", "T", "P", "E");
        String str4 = (String) p.b0(j2, length - 1);
        if (str4 == null) {
            str4 = Strings_CoreKt.getEllipsis(Strings.INSTANCE);
        }
        m.f(decimalString, "decimalString");
        t1 = kotlin.l0.a0.t1(decimalString, decimalString.length() - length2);
        k kVar = new k("(^[1-9]{1})");
        m.f(decimalString, "decimalString");
        i b2 = k.b(kVar, decimalString, 0, 2, null);
        if (b2 != null && (d2 = b2.d()) != null) {
            t1 = y.S0(t1, d2);
        }
        if (t1.length() > 0) {
            t1 = decimalSeparator + t1;
        }
        return k1 + t1 + str4;
    }

    static /* synthetic */ String formatToAbbreviatedFiat$default(CurrencyFormatter currencyFormatter, CurrencyCode currencyCode, String str, int i2, BigInteger bigInteger, String str2, Integer num, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            str2 = null;
        }
        return currencyFormatter.formatToAbbreviatedFiat(currencyCode, str, i2, bigInteger, str2, num);
    }

    public static /* synthetic */ String formatToCrypto$default(CurrencyFormatter currencyFormatter, CurrencyCode currencyCode, int i2, BigInteger bigInteger, boolean z, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i5 & 16) != 0) {
            i3 = 8;
        }
        int i6 = i3;
        if ((i5 & 32) != 0) {
            i4 = 0;
        }
        return currencyFormatter.formatToCrypto(currencyCode, i2, bigInteger, z2, i6, i4);
    }

    public static /* synthetic */ String formatToFiat$default(CurrencyFormatter currencyFormatter, CurrencyCode currencyCode, String str, int i2, BigInteger bigInteger, boolean z, String str2, Integer num, int i3, Object obj) {
        return currencyFormatter.formatToFiat(currencyCode, str, i2, bigInteger, (i3 & 16) != 0 ? false : z, (i3 & 32) != 0 ? null : str2, (i3 & 64) != 0 ? null : num);
    }

    private final Currency getActiveCurrency() {
        try {
            FiatCurrency fiatCurrency = (FiatCurrency) this.store.get(StoreKeys_WalletsKt.getActiveCurrency(StoreKeys.INSTANCE));
            CurrencyCode code = fiatCurrency == null ? null : fiatCurrency.getCode();
            if (code == null) {
                code = FiatCurrency.Companion.getUSD().getCode();
            }
            return Currency.getInstance(code.getRawValue());
        } catch (IllegalArgumentException unused) {
            return Currency.getInstance(FiatCurrency.Companion.getUSD().getCode().getRawValue());
        }
    }

    @Override // com.coinbase.wallet.core.interfaces.Destroyable
    public b0<Boolean> destroy() {
        this.disposeBag.d();
        b0<Boolean> just = b0.just(Boolean.TRUE);
        m.f(just, "just(true)");
        return just;
    }

    public final BigDecimal fiatValue(CurrencyCode currencyCode, String str, int i2, BigInteger value, String str2, Integer num) {
        m.g(currencyCode, "currencyCode");
        m.g(value, "value");
        BigDecimal rateFor = List_WalletsKt.rateFor(this.exchangeRates, currencyCode, str, str2, num);
        if (rateFor == null) {
            return null;
        }
        return rateFor.multiply(new BigDecimal(value)).movePointLeft(i2);
    }

    public final String fiatValueString(BigDecimal value, boolean z) {
        m.g(value, "value");
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        currencyInstance.setMaximumFractionDigits(2);
        currencyInstance.setCurrency(getActiveCurrency());
        if (!z) {
            DecimalFormat decimalFormat = (DecimalFormat) currencyInstance;
            DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
            decimalFormatSymbols.setCurrencySymbol("");
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        }
        String format = currencyInstance.format(value);
        m.f(format, "formatter.format(value)");
        return format;
    }

    public final String formatToCrypto(CurrencyCode currencyCode, int i2, BigInteger value, boolean z, int i3, int i4) {
        CharSequence h1;
        m.g(currencyCode, "currencyCode");
        m.g(value, "value");
        BigDecimal movePointLeft = new BigDecimal(value).movePointLeft(i2);
        if (!(movePointLeft.compareTo(BigDecimal.ONE.movePointLeft(i3)) < 0)) {
            i2 = i3;
        }
        NumberFormat decimalFormat = DecimalFormat.getInstance(Locale.US);
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        decimalFormat.setMaximumFractionDigits(i2);
        decimalFormat.setMinimumFractionDigits(i4);
        decimalFormat.setMinimumIntegerDigits(1);
        String format = decimalFormat.format(movePointLeft);
        StringBuilder sb = new StringBuilder();
        sb.append((Object) format);
        sb.append(TokenParser.SP);
        sb.append(z ? currencyCode.getRawValue() : "");
        String sb2 = sb.toString();
        Objects.requireNonNull(sb2, "null cannot be cast to non-null type kotlin.CharSequence");
        h1 = y.h1(sb2);
        return h1.toString();
    }

    public final String formatToCryptoRange(CurrencyCode currencyCode, int i2, BigInteger bigInteger, BigInteger upperBoundValue, boolean z, int i3, int i4) {
        m.g(currencyCode, "currencyCode");
        m.g(upperBoundValue, "upperBoundValue");
        if (bigInteger == null) {
            bigInteger = upperBoundValue;
        }
        String formatToCrypto = formatToCrypto(currencyCode, i2, bigInteger, false, i3, i4);
        String formatToCrypto2 = formatToCrypto(currencyCode, i2, upperBoundValue, z, i3, i4);
        if (upperBoundValue.compareTo(bigInteger) <= 0 || m.c(formatToCrypto2, formatToCrypto)) {
            return formatToCrypto2;
        }
        return formatToCrypto + " - " + formatToCrypto2;
    }

    public final String formatToFiat(CurrencyCode fromCurrencyCode, String str, int i2, BigInteger value, boolean z, String str2, Integer num) {
        m.g(fromCurrencyCode, "fromCurrencyCode");
        m.g(value, "value");
        if (z) {
            return formatToAbbreviatedFiat(fromCurrencyCode, str, i2, value, str2, num);
        }
        if (m.c(value, BigInteger.ZERO)) {
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
            currencyInstance.setCurrency(getActiveCurrency());
            return currencyInstance.format(BigDecimal.ZERO);
        }
        BigDecimal fiatValue = fiatValue(fromCurrencyCode, str, i2, value, str2, num);
        if (fiatValue == null) {
            return null;
        }
        return fiatValueString$default(this, fiatValue, false, 2, null);
    }

    public final String formatToFiatRange(CurrencyCode fromCurrencyCode, String str, int i2, BigInteger bigInteger, BigInteger upperBoundValue, boolean z, String str2, Integer num) {
        m.g(fromCurrencyCode, "fromCurrencyCode");
        m.g(upperBoundValue, "upperBoundValue");
        BigInteger bigInteger2 = bigInteger == null ? upperBoundValue : bigInteger;
        String formatToFiat = formatToFiat(fromCurrencyCode, str, i2, bigInteger2, z, str2, num);
        String formatToFiat2 = formatToFiat(fromCurrencyCode, str, i2, upperBoundValue, z, str2, num);
        if (upperBoundValue.compareTo(bigInteger2) <= 0 || m.c(formatToFiat2, formatToFiat)) {
            return formatToFiat2;
        }
        return ((Object) formatToFiat) + " - " + ((Object) formatToFiat2);
    }

    public final boolean hasFiatRepresentation(CurrencyCode currencyCode, String str, Integer num) {
        m.g(currencyCode, "currencyCode");
        return List_WalletsKt.rateFor$default(this.exchangeRates, currencyCode, str, null, num, 4, null) != null;
    }

    @Override // com.coinbase.wallet.core.interfaces.Startable
    public void start() {
        s<List<ExchangeRate>> subscribeOn = this.exchangeRateObservable.subscribeOn(this.concurrentScheduler);
        m.f(subscribeOn, "exchangeRateObservable\n            .subscribeOn(concurrentScheduler)");
        h.c.t0.a.a(g.h(subscribeOn, null, null, new CurrencyFormatter$start$1(this), 3, null), this.disposeBag);
    }

    public static /* synthetic */ String formatToCrypto$default(CurrencyFormatter currencyFormatter, CurrencyCode currencyCode, int i2, BigDecimal bigDecimal, boolean z, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i5 & 16) != 0) {
            i3 = 8;
        }
        int i6 = i3;
        if ((i5 & 32) != 0) {
            i4 = 0;
        }
        return currencyFormatter.formatToCrypto(currencyCode, i2, bigDecimal, z2, i6, i4);
    }

    public final String formatToCrypto(CurrencyCode currencyCode, int i2, BigDecimal value, boolean z, int i3, int i4) {
        CharSequence h1;
        m.g(currencyCode, "currencyCode");
        m.g(value, "value");
        BigDecimal movePointLeft = value.movePointLeft(i2);
        if (!(movePointLeft.compareTo(BigDecimal.ONE.movePointLeft(i3)) < 0)) {
            i2 = i3;
        }
        NumberFormat decimalFormat = DecimalFormat.getInstance(Locale.US);
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        decimalFormat.setMaximumFractionDigits(i2);
        decimalFormat.setMinimumFractionDigits(i4);
        decimalFormat.setMinimumIntegerDigits(1);
        String format = decimalFormat.format(movePointLeft);
        StringBuilder sb = new StringBuilder();
        sb.append((Object) format);
        sb.append(TokenParser.SP);
        sb.append(z ? currencyCode.getRawValue() : "");
        String sb2 = sb.toString();
        Objects.requireNonNull(sb2, "null cannot be cast to non-null type kotlin.CharSequence");
        h1 = y.h1(sb2);
        return h1.toString();
    }
}