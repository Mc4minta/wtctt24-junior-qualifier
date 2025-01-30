package com.coinbase.wallet.commonui.utilities;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.common.extensions.List_WalletsKt;
import com.coinbase.wallet.common.utilities.Locales;
import com.coinbase.wallet.commonui.exceptions.AmountsException;
import com.coinbase.wallet.commonui.views.NumberKeyboardDigit;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.models.ExchangeRate;
import h.c.b0;
import h.c.m0.n;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.l0.v;
import kotlin.l0.x;

/* compiled from: AmountPickerFormatter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b-\u0010.J?\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ?\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\rJ5\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u0010J5\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012JC\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00078B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020\n8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020&8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/AmountPickerFormatter;", "", "", "rawString", "", "Lcom/coinbase/wallet/wallets/models/ExchangeRate;", "exchangeRates", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "", "decimals", "convertCryptoToFiat", "(Ljava/lang/String;Ljava/util/List;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;I)Ljava/lang/String;", "convertFiatToCrypto", "Lh/c/b0;", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;I)Lh/c/b0;", "formatFiatAmount", "(Ljava/lang/String;)Ljava/lang/String;", "", "trimDigits", "showCode", "Ljava/util/Locale;", "cryptoLocale", "formatCryptoAmount", "(Ljava/lang/String;Ljava/lang/String;IZZLjava/util/Locale;)Ljava/lang/String;", "Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "currencyRepository", "Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "getLocalCurrency", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "localCurrency", "Ljava/text/DecimalFormat;", "getFiatFormatter", "()Ljava/text/DecimalFormat;", "fiatFormatter", "maxCryptoDecimals", "I", "Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;", "getDecimalSeparator", "()Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;", "decimalSeparator", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "<init>", "(Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AmountPickerFormatter {
    private final IFiatCurrencyRepository currencyRepository;
    private final IExchangeRateRepository exchangeRateRepository;
    private final int maxCryptoDecimals;

    public AmountPickerFormatter(IFiatCurrencyRepository currencyRepository, IExchangeRateRepository exchangeRateRepository) {
        m.g(currencyRepository, "currencyRepository");
        m.g(exchangeRateRepository, "exchangeRateRepository");
        this.currencyRepository = currencyRepository;
        this.exchangeRateRepository = exchangeRateRepository;
        this.maxCryptoDecimals = 8;
    }

    public static /* synthetic */ String a(AmountPickerFormatter amountPickerFormatter, String str, CurrencyCode currencyCode, String str2, int i2, List list) {
        return m805convertFiatToCrypto$lambda1(amountPickerFormatter, str, currencyCode, str2, i2, list);
    }

    public static /* synthetic */ String b(AmountPickerFormatter amountPickerFormatter, String str, CurrencyCode currencyCode, String str2, int i2, List list) {
        return m804convertCryptoToFiat$lambda2(amountPickerFormatter, str, currencyCode, str2, i2, list);
    }

    /* renamed from: convertCryptoToFiat$lambda-2 */
    public static final String m804convertCryptoToFiat$lambda2(AmountPickerFormatter this$0, String rawString, CurrencyCode currencyCode, String str, int i2, List it) {
        m.g(this$0, "this$0");
        m.g(rawString, "$rawString");
        m.g(currencyCode, "$currencyCode");
        m.g(it, "it");
        return this$0.convertCryptoToFiat(rawString, it, currencyCode, str, i2);
    }

    /* renamed from: convertFiatToCrypto$lambda-1 */
    public static final String m805convertFiatToCrypto$lambda1(AmountPickerFormatter this$0, String rawString, CurrencyCode currencyCode, String str, int i2, List exchangeRates) {
        m.g(this$0, "this$0");
        m.g(rawString, "$rawString");
        m.g(currencyCode, "$currencyCode");
        m.g(exchangeRates, "exchangeRates");
        return this$0.convertFiatToCrypto(rawString, exchangeRates, currencyCode, str, i2);
    }

    public static /* synthetic */ String formatCryptoAmount$default(AmountPickerFormatter amountPickerFormatter, String str, String str2, int i2, boolean z, boolean z2, Locale locale, int i3, Object obj) {
        Locale locale2;
        boolean z3 = (i3 & 8) != 0 ? false : z;
        boolean z4 = (i3 & 16) != 0 ? false : z2;
        if ((i3 & 32) != 0) {
            Locale US = Locale.US;
            m.f(US, "US");
            locale2 = US;
        } else {
            locale2 = locale;
        }
        return amountPickerFormatter.formatCryptoAmount(str, str2, i2, z3, z4, locale2);
    }

    private final NumberKeyboardDigit getDecimalSeparator() {
        return NumberKeyboardDigit.DecimalSeparator.localized(Locales.INSTANCE.getCurrent());
    }

    private final DecimalFormat getFiatFormatter() {
        NumberFormat currencyInstance = DecimalFormat.getCurrencyInstance(Locales.INSTANCE.getCurrent());
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

    private final CurrencyCode getLocalCurrency() {
        return this.currencyRepository.getActiveCurrency().getCode();
    }

    public final b0<String> convertCryptoToFiat(final String rawString, final CurrencyCode currencyCode, final String str, final int i2) {
        m.g(rawString, "rawString");
        m.g(currencyCode, "currencyCode");
        b0<String> firstOrError = this.exchangeRateRepository.getExchangeRateObservable().map(new n() { // from class: com.coinbase.wallet.commonui.utilities.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AmountPickerFormatter.b(AmountPickerFormatter.this, rawString, currencyCode, str, i2, (List) obj);
            }
        }).firstOrError();
        m.f(firstOrError, "exchangeRateRepository.exchangeRateObservable\n            .map { convertCryptoToFiat(rawString, it, currencyCode, contractAddress, decimals) }\n            .firstOrError()");
        return firstOrError;
    }

    public final b0<String> convertFiatToCrypto(final String rawString, final CurrencyCode currencyCode, final String str, final int i2) {
        m.g(rawString, "rawString");
        m.g(currencyCode, "currencyCode");
        b0<String> firstOrError = this.exchangeRateRepository.getExchangeRateObservable().map(new n() { // from class: com.coinbase.wallet.commonui.utilities.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AmountPickerFormatter.a(AmountPickerFormatter.this, rawString, currencyCode, str, i2, (List) obj);
            }
        }).firstOrError();
        m.f(firstOrError, "exchangeRateRepository.exchangeRateObservable\n            .map { exchangeRates ->\n                convertFiatToCrypto(\n                    rawString,\n                    exchangeRates,\n                    currencyCode,\n                    contractAddress,\n                    decimals\n                )\n            }.firstOrError()");
        return firstOrError;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0074, code lost:
        if (r12 != false) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String formatCryptoAmount(java.lang.String r10, java.lang.String r11, int r12, boolean r13, boolean r14, java.util.Locale r15) {
        /*
            r9 = this;
            java.lang.String r0 = "rawString"
            kotlin.jvm.internal.m.g(r10, r0)
            java.lang.String r0 = "currencyCode"
            kotlin.jvm.internal.m.g(r11, r0)
            java.lang.String r0 = "cryptoLocale"
            kotlin.jvm.internal.m.g(r15, r0)
            java.text.NumberFormat r15 = java.text.DecimalFormat.getNumberInstance(r15)
            java.lang.String r0 = "null cannot be cast to non-null type java.text.DecimalFormat"
            java.util.Objects.requireNonNull(r15, r0)
            java.text.DecimalFormat r15 = (java.text.DecimalFormat) r15
            if (r13 == 0) goto L1e
            int r12 = r9.maxCryptoDecimals
        L1e:
            r15.setMaximumFractionDigits(r12)
            java.math.RoundingMode r12 = java.math.RoundingMode.FLOOR
            r15.setRoundingMode(r12)
            int r12 = r10.length()
            r13 = 1
            r0 = 0
            if (r12 != 0) goto L30
            r12 = r13
            goto L31
        L30:
            r12 = r0
        L31:
            if (r12 == 0) goto L35
            java.lang.String r10 = "0"
        L35:
            com.coinbase.wallet.commonui.views.NumberKeyboardDigit r12 = com.coinbase.wallet.commonui.views.NumberKeyboardDigit.DecimalSeparator
            java.lang.String r1 = r12.getDescription()
            r7 = 2
            r8 = 0
            boolean r1 = kotlin.l0.o.V(r10, r1, r0, r7, r8)
            if (r1 == 0) goto L5f
            java.lang.String[] r2 = new java.lang.String[r13]
            java.lang.String r1 = r12.getDescription()
            r2[r0] = r1
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r1 = r10
            java.util.List r1 = kotlin.l0.o.K0(r1, r2, r3, r4, r5, r6)
            java.lang.Object r1 = kotlin.a0.p.j0(r1)
            java.lang.String r1 = (java.lang.String) r1
            int r1 = r1.length()
            goto L60
        L5f:
            r1 = r0
        L60:
            java.lang.String r2 = r12.getDescription()
            boolean r2 = kotlin.l0.o.V(r10, r2, r0, r7, r8)
            if (r2 == 0) goto L77
            if (r1 > 0) goto L78
            java.lang.String r12 = r12.getDescription()
            boolean r12 = kotlin.l0.o.z(r10, r12, r0, r7, r8)
            if (r12 == 0) goto L77
            goto L78
        L77:
            r13 = r0
        L78:
            r15.setDecimalSeparatorAlwaysShown(r13)
            int r12 = r15.getMaximumFractionDigits()
            int r12 = java.lang.Math.min(r1, r12)
            r15.setMinimumFractionDigits(r12)
            java.math.BigDecimal r12 = new java.math.BigDecimal
            r12.<init>(r10)
            java.lang.String r10 = r15.format(r12)
            if (r14 == 0) goto La6
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r10)
            r10 = 32
            r12.append(r10)
            r12.append(r11)
            java.lang.String r10 = r12.toString()
            goto Lab
        La6:
            java.lang.String r11 = "{\n            intermediateResult\n        }"
            kotlin.jvm.internal.m.f(r10, r11)
        Lab:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.commonui.utilities.AmountPickerFormatter.formatCryptoAmount(java.lang.String, java.lang.String, int, boolean, boolean, java.util.Locale):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0090, code lost:
        if (r0 != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String formatFiatAmount(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.commonui.utilities.AmountPickerFormatter.formatFiatAmount(java.lang.String):java.lang.String");
    }

    private final String convertCryptoToFiat(String str, List<ExchangeRate> list, CurrencyCode currencyCode, String str2, int i2) {
        boolean D;
        BigDecimal j2;
        BigDecimal scale;
        Locales locales = Locales.INSTANCE;
        NumberFormat currencyInstance = DecimalFormat.getCurrencyInstance(locales.getCurrent());
        currencyInstance.setCurrency(Currency.getInstance(getLocalCurrency().getRawValue()));
        Currency currency = currencyInstance.getCurrency();
        Integer valueOf = currency == null ? null : Integer.valueOf(currency.getDefaultFractionDigits());
        if (valueOf != null) {
            currencyInstance.setMaximumFractionDigits(valueOf.intValue());
            D = x.D(str);
            if (D) {
                scale = BigDecimal.ZERO;
            } else {
                BigDecimal rateFor$default = List_WalletsKt.rateFor$default(list, currencyCode, str2, null, null, 12, null);
                if (rateFor$default == null) {
                    rateFor$default = BigDecimal.ZERO;
                }
                j2 = v.j(str);
                BigDecimal scale2 = j2 != null ? j2.setScale(i2, RoundingMode.HALF_DOWN) : null;
                if (scale2 != null) {
                    if (scale2.compareTo(BigDecimal.ZERO) >= 0) {
                        scale = scale2.multiply(rateFor$default).setScale(currencyInstance.getMaximumFractionDigits(), RoundingMode.HALF_DOWN);
                        if (BigDecimal.ZERO.compareTo(scale) == 0) {
                            scale = BigDecimal.ZERO;
                        }
                    } else {
                        throw new AmountsException.InvalidAmount(str);
                    }
                } else {
                    throw new AmountsException.BigDecimalConversionFailed(str);
                }
            }
            BigDecimal stripTrailingZeros = scale.stripTrailingZeros();
            NumberFormat decimalFormat = DecimalFormat.getInstance(locales.getCurrent());
            Currency currency2 = currencyInstance.getCurrency();
            decimalFormat.setMaximumFractionDigits(currency2 == null ? 2 : currency2.getDefaultFractionDigits());
            decimalFormat.setMinimumFractionDigits(0);
            decimalFormat.setGroupingUsed(false);
            String format = decimalFormat.format(stripTrailingZeros);
            m.f(format, "decimalFormatter.format(bigDecimal)");
            return format;
        }
        throw new IllegalStateException("No currency found");
    }

    private final String convertFiatToCrypto(String str, List<ExchangeRate> list, CurrencyCode currencyCode, String str2, int i2) {
        boolean D;
        BigDecimal stripTrailingZeros;
        D = x.D(str);
        if (D) {
            stripTrailingZeros = BigDecimal.ZERO;
        } else {
            BigDecimal rateFor$default = List_WalletsKt.rateFor$default(list, currencyCode, str2, null, null, 12, null);
            DecimalFormat decimalFormat = new DecimalFormat("0.0", new DecimalFormatSymbols(Locales.INSTANCE.getCurrent()));
            decimalFormat.setParseBigDecimal(true);
            decimalFormat.setDecimalSeparatorAlwaysShown(true);
            Number parse = decimalFormat.parse(str);
            Objects.requireNonNull(parse, "null cannot be cast to non-null type java.math.BigDecimal");
            BigDecimal scale = ((BigDecimal) parse).setScale(i2, RoundingMode.HALF_DOWN);
            if (scale.compareTo(BigDecimal.ZERO) >= 0) {
                BigDecimal scale2 = scale.divide(rateFor$default, RoundingMode.HALF_DOWN).setScale(i2, RoundingMode.HALF_DOWN);
                if (BigDecimal.ZERO.compareTo(scale2) == 0) {
                    scale2 = BigDecimal.ZERO;
                }
                stripTrailingZeros = scale2.stripTrailingZeros();
            } else {
                throw new AmountsException.InvalidAmount(str);
            }
        }
        String plainString = stripTrailingZeros.toPlainString();
        m.f(plainString, "when {\n        rawString.isBlank() -> BigDecimal.ZERO\n        else -> {\n            val exchangeRate = exchangeRates.rateFor(\n                currencyCode = currencyCode,\n                contractAddress = contractAddress\n            )\n\n            val bigDecimalRepresentation = DecimalFormat(\n                \"0.0\",\n                DecimalFormatSymbols(Locales.current)\n            ).apply {\n                isParseBigDecimal = true\n                isDecimalSeparatorAlwaysShown = true\n            }.parse(rawString) as BigDecimal\n\n            val balanceValue = bigDecimalRepresentation.setScale(decimals, RoundingMode.HALF_DOWN)\n            if (balanceValue < BigDecimal.ZERO) throw AmountsException.InvalidAmount(rawString)\n\n            balanceValue.divide(exchangeRate, RoundingMode.HALF_DOWN)\n                .setScale(decimals, RoundingMode.HALF_DOWN)\n                .run { if (BigDecimal.ZERO.compareTo(this) == 0) BigDecimal.ZERO else this }\n                .stripTrailingZeros()\n        }\n    }.toPlainString()");
        return plainString;
    }
}