package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.ApiConstants;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.CurrencyDecimal;
import com.coinbase.wallet.common.extensions.SavedStateHandle_CommonKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.ethereum.extensions.CurrencyDecimal_EthereumKt;
import com.coinbase.wallet.features.send.extensions.BigInteger_SendKt;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeCustomViewInfoState;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeCustomWaitTime;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeInfos;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeLegacySelection;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeViewInfoState;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeViewState;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeWaitTime;
import com.coinbase.wallet.features.send.models.PresetSpeed;
import com.coinbase.wallet.features.send.repositories.AdjustableMinerFeeRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.toshi.R;

/* compiled from: AdjustableMinerFeeViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001OB+\b\u0007\u0012\u0006\u0010K\u001a\u00020J\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u00105\u001a\u000204\u0012\b\b\u0001\u0010@\u001a\u00020?¢\u0006\u0004\bM\u0010NJ3\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010 \u001a\u0010\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u001e0\u001e0\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R<\u0010%\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020$ \u001f*\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020$\u0018\u00010#0#0\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R$\u0010(\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001e8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b(\u0010)\"\u0004\b*\u0010+R+\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020$0#0,8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bB\u0010CR\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010CR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u001f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001e0,8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010.\u001a\u0004\bI\u00100R\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010L¨\u0006P"}, d2 = {"Lcom/coinbase/wallet/features/send/viewmodels/AdjustableMinerFeeViewModel;", "Landroidx/lifecycle/b0;", "Ljava/math/BigInteger;", "inputWei", "", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeWaitTime;", "waitTimes", "presets", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeCustomWaitTime;", "calculateWaitTime", "(Ljava/math/BigInteger;Ljava/util/List;Ljava/util/List;)Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeCustomWaitTime;", "waitTime", "", "warningText", "formatWaitTime", "(Ljava/math/BigInteger;Ljava/lang/String;)Ljava/lang/String;", "Lh/c/b0;", "Lkotlin/x;", "setup", "()Lh/c/b0;", "gasPriceString", "gasLimitString", "nonceString", "customValueChanged", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/features/send/models/PresetSpeed;", "speed", "presetSelected", "(Lcom/coinbase/wallet/features/send/models/PresetSpeed;)Lh/c/b0;", "Lh/c/v0/a;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewState;", "kotlin.jvm.PlatformType", "stateSubject", "Lh/c/v0/a;", "Lh/c/v0/b;", "Lkotlin/o;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeLegacySelection;", "dismissSubject", "Lh/c/v0/b;", "value", ApiConstants.STATE, "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewState;", "setState", "(Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewState;)V", "Lh/c/s;", "dismissObservable", "Lh/c/s;", "getDismissObservable", "()Lh/c/s;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "baseCurrencyCode", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "Lcom/coinbase/wallet/features/send/repositories/AdjustableMinerFeeRepository;", "adjustableMinerFeeRepository", "Lcom/coinbase/wallet/features/send/repositories/AdjustableMinerFeeRepository;", "fromAddress", "Ljava/lang/String;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeCustomViewInfoState;", "startingValues", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeCustomViewInfoState;", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "Landroidx/lifecycle/z;", "savedStateHandle", "Landroidx/lifecycle/z;", "gasPricePresets", "Ljava/util/List;", "currentWaitTimes", "Lcom/coinbase/ciphercore/ethereum/EthereumChain;", "ethereumChain", "Lcom/coinbase/ciphercore/ethereum/EthereumChain;", "stateObservable", "getStateObservable", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "<init>", "(Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;Lcom/coinbase/wallet/features/send/repositories/AdjustableMinerFeeRepository;Landroidx/lifecycle/z;)V", "Factory", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFeeViewModel extends androidx.lifecycle.b0 {
    private final AdjustableMinerFeeRepository adjustableMinerFeeRepository;
    private final CurrencyCode baseCurrencyCode;
    private final CurrencyFormatter currencyFormatter;
    private List<AdjustableMinerFeeWaitTime> currentWaitTimes;
    private final h.c.s<kotlin.o<String, AdjustableMinerFeeLegacySelection>> dismissObservable;
    private final h.c.v0.b<kotlin.o<String, AdjustableMinerFeeLegacySelection>> dismissSubject;
    private final EthereumChain ethereumChain;
    private final IExchangeRateRepository exchangeRateRepository;
    private final String fromAddress;
    private List<? extends BigInteger> gasPricePresets;
    private final androidx.lifecycle.z savedStateHandle;
    private AdjustableMinerFeeCustomViewInfoState startingValues;
    private AdjustableMinerFeeViewState state;
    private final h.c.s<AdjustableMinerFeeViewState> stateObservable;
    private final h.c.v0.a<AdjustableMinerFeeViewState> stateSubject;

    /* compiled from: AdjustableMinerFeeViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/features/send/viewmodels/AdjustableMinerFeeViewModel$Factory;", "", "Landroidx/lifecycle/z;", "savedStateHandle", "Lcom/coinbase/wallet/features/send/viewmodels/AdjustableMinerFeeViewModel;", "create", "(Landroidx/lifecycle/z;)Lcom/coinbase/wallet/features/send/viewmodels/AdjustableMinerFeeViewModel;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Factory {
        AdjustableMinerFeeViewModel create(androidx.lifecycle.z zVar);
    }

    /* compiled from: AdjustableMinerFeeViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PresetSpeed.values().length];
            iArr[PresetSpeed.SLOW.ordinal()] = 1;
            iArr[PresetSpeed.NORMAL.ordinal()] = 2;
            iArr[PresetSpeed.FAST.ordinal()] = 3;
            iArr[PresetSpeed.CUSTOM.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AdjustableMinerFeeViewModel(CurrencyFormatter currencyFormatter, IExchangeRateRepository exchangeRateRepository, AdjustableMinerFeeRepository adjustableMinerFeeRepository, androidx.lifecycle.z savedStateHandle) {
        List<AdjustableMinerFeeWaitTime> g2;
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        kotlin.jvm.internal.m.g(exchangeRateRepository, "exchangeRateRepository");
        kotlin.jvm.internal.m.g(adjustableMinerFeeRepository, "adjustableMinerFeeRepository");
        kotlin.jvm.internal.m.g(savedStateHandle, "savedStateHandle");
        this.currencyFormatter = currencyFormatter;
        this.exchangeRateRepository = exchangeRateRepository;
        this.adjustableMinerFeeRepository = adjustableMinerFeeRepository;
        this.savedStateHandle = savedStateHandle;
        h.c.v0.a<AdjustableMinerFeeViewState> e2 = h.c.v0.a.e(new AdjustableMinerFeeViewState(null, null, null, null, null, 31, null));
        kotlin.jvm.internal.m.f(e2, "createDefault(AdjustableMinerFeeViewState())");
        this.stateSubject = e2;
        h.c.v0.b<kotlin.o<String, AdjustableMinerFeeLegacySelection>> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<Pair<String, AdjustableMinerFeeLegacySelection>>()");
        this.dismissSubject = d2;
        this.state = new AdjustableMinerFeeViewState(null, null, null, null, null, 31, null);
        this.fromAddress = (String) SavedStateHandle_CommonKt.require(savedStateHandle, AdjustableMinerFeeArgs.FROM_ADDRESS);
        EthereumChain ethereumChain = (EthereumChain) SavedStateHandle_CommonKt.require(savedStateHandle, AdjustableMinerFeeArgs.ETHEREUM_CHAIN);
        this.ethereumChain = ethereumChain;
        String baseAssetCurrencyCode = ethereumChain.getBaseAssetCurrencyCode();
        this.baseCurrencyCode = new CurrencyCode(baseAssetCurrencyCode == null ? "ETH" : baseAssetCurrencyCode);
        g2 = kotlin.a0.r.g();
        this.currentWaitTimes = g2;
        h.c.s<AdjustableMinerFeeViewState> hide = e2.hide();
        kotlin.jvm.internal.m.f(hide, "stateSubject.hide()");
        this.stateObservable = hide;
        h.c.s<kotlin.o<String, AdjustableMinerFeeLegacySelection>> hide2 = d2.hide();
        kotlin.jvm.internal.m.f(hide2, "dismissSubject.hide()");
        this.dismissObservable = hide2;
    }

    public static /* synthetic */ kotlin.x a(BigInteger bigInteger, AdjustableMinerFeeViewModel adjustableMinerFeeViewModel, BigInteger bigInteger2, BigInteger bigInteger3, int i2, BigDecimal bigDecimal) {
        return m1356customValueChanged$lambda2(bigInteger, adjustableMinerFeeViewModel, bigInteger2, bigInteger3, i2, bigDecimal);
    }

    public static /* synthetic */ kotlin.x b(AdjustableMinerFeeViewInfoState adjustableMinerFeeViewInfoState, PresetSpeed presetSpeed, AdjustableMinerFeeViewModel adjustableMinerFeeViewModel, Integer num) {
        return m1357presetSelected$lambda3(adjustableMinerFeeViewInfoState, presetSpeed, adjustableMinerFeeViewModel, num);
    }

    public static /* synthetic */ kotlin.x c(AdjustableMinerFeeViewModel adjustableMinerFeeViewModel, BigInteger bigInteger, kotlin.o oVar) {
        return m1358setup$lambda1(adjustableMinerFeeViewModel, bigInteger, oVar);
    }

    private final AdjustableMinerFeeCustomWaitTime calculateWaitTime(BigInteger bigInteger, List<AdjustableMinerFeeWaitTime> list, List<? extends BigInteger> list2) {
        Object obj;
        Object next;
        Object next2;
        kotlin.o oVar;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (kotlin.jvm.internal.m.c(((AdjustableMinerFeeWaitTime) obj).getPrice(), bigInteger)) {
                break;
            }
        }
        AdjustableMinerFeeWaitTime adjustableMinerFeeWaitTime = (AdjustableMinerFeeWaitTime) obj;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next3 = it2.next();
            if (((AdjustableMinerFeeWaitTime) next3).getPrice().compareTo(bigInteger) < 0) {
                arrayList.add(next3);
            }
        }
        Iterator it3 = arrayList.iterator();
        if (it3.hasNext()) {
            next = it3.next();
            if (it3.hasNext()) {
                BigInteger price = ((AdjustableMinerFeeWaitTime) next).getPrice();
                do {
                    Object next4 = it3.next();
                    BigInteger price2 = ((AdjustableMinerFeeWaitTime) next4).getPrice();
                    if (price.compareTo(price2) < 0) {
                        next = next4;
                        price = price2;
                    }
                } while (it3.hasNext());
            }
        } else {
            next = null;
        }
        AdjustableMinerFeeWaitTime adjustableMinerFeeWaitTime2 = (AdjustableMinerFeeWaitTime) next;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list) {
            if (((AdjustableMinerFeeWaitTime) obj2).getPrice().compareTo(bigInteger) > 0) {
                arrayList2.add(obj2);
            }
        }
        Iterator it4 = arrayList2.iterator();
        if (it4.hasNext()) {
            next2 = it4.next();
            if (it4.hasNext()) {
                BigInteger price3 = ((AdjustableMinerFeeWaitTime) next2).getPrice();
                do {
                    Object next5 = it4.next();
                    BigInteger price4 = ((AdjustableMinerFeeWaitTime) next5).getPrice();
                    if (price3.compareTo(price4) > 0) {
                        next2 = next5;
                        price3 = price4;
                    }
                } while (it4.hasNext());
            }
        } else {
            next2 = null;
        }
        AdjustableMinerFeeWaitTime adjustableMinerFeeWaitTime3 = (AdjustableMinerFeeWaitTime) next2;
        BigInteger valueOf = BigInteger.valueOf(2);
        kotlin.jvm.internal.m.f(valueOf, "BigInteger.valueOf(this.toLong())");
        BigInteger divide = bigInteger.divide(valueOf);
        kotlin.jvm.internal.m.f(divide, "this.divide(other)");
        if (divide.compareTo((BigInteger) kotlin.a0.p.j0(list2)) > 0) {
            LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
            oVar = new kotlin.o(localizedStrings.get(R.string.gas_set_too_high_explanation), localizedStrings.get(R.string.gas_set_too_high));
        } else if (bigInteger.compareTo((BigInteger) kotlin.a0.p.Y(list2)) < 0) {
            LocalizedStrings localizedStrings2 = LocalizedStrings.INSTANCE;
            oVar = new kotlin.o(localizedStrings2.get(R.string.gas_set_too_low_explanation), localizedStrings2.get(R.string.gas_set_too_low));
        } else {
            oVar = new kotlin.o(null, null);
        }
        String str = (String) oVar.a();
        String str2 = (String) oVar.b();
        if (adjustableMinerFeeWaitTime != null) {
            return new AdjustableMinerFeeCustomWaitTime(formatWaitTime(adjustableMinerFeeWaitTime.getWaitTime(), str2), str);
        }
        if (adjustableMinerFeeWaitTime3 == null || adjustableMinerFeeWaitTime2 == null) {
            if (adjustableMinerFeeWaitTime2 != null) {
                return new AdjustableMinerFeeCustomWaitTime(formatWaitTime(adjustableMinerFeeWaitTime2.getWaitTime(), str2), str);
            }
            if (adjustableMinerFeeWaitTime3 != null) {
                return new AdjustableMinerFeeCustomWaitTime(formatWaitTime(adjustableMinerFeeWaitTime3.getWaitTime(), str2), str);
            }
            throw new IllegalStateException("Un-logical outcome while processing gas wait times");
        }
        BigInteger subtract = adjustableMinerFeeWaitTime3.getWaitTime().subtract(adjustableMinerFeeWaitTime2.getWaitTime());
        kotlin.jvm.internal.m.f(subtract, "this.subtract(other)");
        BigDecimal bigDecimal = new BigDecimal(subtract);
        BigInteger subtract2 = adjustableMinerFeeWaitTime3.getPrice().subtract(adjustableMinerFeeWaitTime2.getPrice());
        kotlin.jvm.internal.m.f(subtract2, "this.subtract(other)");
        BigDecimal bigDecimal2 = new BigDecimal(subtract2);
        BigInteger subtract3 = bigInteger.subtract(adjustableMinerFeeWaitTime2.getPrice());
        kotlin.jvm.internal.m.f(subtract3, "this.subtract(other)");
        BigDecimal percentage = new BigDecimal(subtract3).divide(bigDecimal2, 2, RoundingMode.HALF_UP);
        BigDecimal bigDecimal3 = new BigDecimal(adjustableMinerFeeWaitTime2.getWaitTime());
        kotlin.jvm.internal.m.f(percentage, "percentage");
        BigDecimal multiply = bigDecimal.multiply(percentage);
        kotlin.jvm.internal.m.f(multiply, "this.multiply(other)");
        BigDecimal add = bigDecimal3.add(multiply);
        kotlin.jvm.internal.m.f(add, "this.add(other)");
        BigInteger bigInteger2 = add.toBigInteger();
        kotlin.jvm.internal.m.f(bigInteger2, "rawWaitTime.toBigInteger()");
        return new AdjustableMinerFeeCustomWaitTime(formatWaitTime(bigInteger2, str2), str);
    }

    public static /* synthetic */ h.c.b0 customValueChanged$default(AdjustableMinerFeeViewModel adjustableMinerFeeViewModel, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        return adjustableMinerFeeViewModel.customValueChanged(str, str2, str3);
    }

    /* renamed from: customValueChanged$lambda-2 */
    public static final kotlin.x m1356customValueChanged$lambda2(BigInteger weiFee, AdjustableMinerFeeViewModel this$0, BigInteger gasPrice, BigInteger gasLimit, int i2, BigDecimal rate) {
        kotlin.jvm.internal.m.g(weiFee, "$weiFee");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(gasPrice, "$gasPrice");
        kotlin.jvm.internal.m.g(gasLimit, "$gasLimit");
        kotlin.jvm.internal.m.g(rate, "rate");
        BigDecimal ethBasedFee = new BigDecimal(weiFee).movePointLeft(CurrencyDecimal_EthereumKt.getETH(CurrencyDecimal.INSTANCE));
        kotlin.jvm.internal.m.f(ethBasedFee, "ethBasedFee");
        BigDecimal multiply = rate.multiply(ethBasedFee);
        kotlin.jvm.internal.m.f(multiply, "this.multiply(other)");
        String fiatValueString$default = CurrencyFormatter.fiatValueString$default(this$0.currencyFormatter, multiply, false, 2, null);
        String formatToCrypto$default = CurrencyFormatter.formatToCrypto$default(this$0.currencyFormatter, this$0.baseCurrencyCode, 18, weiFee, false, 0, 0, 56, (Object) null);
        List<AdjustableMinerFeeWaitTime> list = this$0.currentWaitTimes;
        List<? extends BigInteger> list2 = this$0.gasPricePresets;
        if (list2 != null) {
            AdjustableMinerFeeCustomWaitTime calculateWaitTime = this$0.calculateWaitTime(gasPrice, list, list2);
            String str = LocalizedStrings.INSTANCE.get(R.string.custom);
            PresetSpeed presetSpeed = PresetSpeed.CUSTOM;
            this$0.setState(AdjustableMinerFeeViewState.copy$default(this$0.state, null, null, null, new AdjustableMinerFeeCustomViewInfoState(str, gasPrice, calculateWaitTime.getWaitTimeString(), presetSpeed, fiatValueString$default, formatToCrypto$default, BigInteger_SendKt.toGwei(gasPrice).toString(), true, gasLimit, calculateWaitTime.getWarningText(), i2, gasPrice.compareTo(BigInteger.ZERO) > 0 && gasLimit.compareTo(new BigInteger("21000")) >= 0), null, 23, null));
            return kotlin.x.a;
        }
        kotlin.jvm.internal.m.w("gasPricePresets");
        throw null;
    }

    private final String formatWaitTime(BigInteger bigInteger, String str) {
        String valueOf;
        if (str == null) {
            BigInteger valueOf2 = BigInteger.valueOf(60);
            kotlin.jvm.internal.m.f(valueOf2, "BigInteger.valueOf(this.toLong())");
            if (bigInteger.compareTo(valueOf2) < 0) {
                return LocalizedStrings.INSTANCE.get(R.string.time_unit_second, bigInteger);
            }
            BigDecimal divide = new BigDecimal(bigInteger).divide(new BigDecimal(60), 0, RoundingMode.CEILING);
            if (divide.compareTo(new BigDecimal(30)) > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(divide);
                sb.append('+');
                valueOf = sb.toString();
            } else {
                valueOf = String.valueOf(divide);
            }
            return LocalizedStrings.INSTANCE.get(R.string.time_unit_minute, valueOf);
        }
        return str;
    }

    static /* synthetic */ String formatWaitTime$default(AdjustableMinerFeeViewModel adjustableMinerFeeViewModel, BigInteger bigInteger, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return adjustableMinerFeeViewModel.formatWaitTime(bigInteger, str);
    }

    /* renamed from: presetSelected$lambda-3 */
    public static final kotlin.x m1357presetSelected$lambda3(AdjustableMinerFeeViewInfoState selection, PresetSpeed speed, AdjustableMinerFeeViewModel this$0, Integer calculatedNonce) {
        String changeDirectionFrom;
        String changeDirectionFrom2;
        String changeDirectionFrom3;
        kotlin.jvm.internal.m.g(selection, "$selection");
        kotlin.jvm.internal.m.g(speed, "$speed");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(calculatedNonce, "calculatedNonce");
        AdjustableMinerFeeCustomViewInfoState adjustableMinerFeeCustomViewInfoState = (AdjustableMinerFeeCustomViewInfoState) selection;
        boolean z = calculatedNonce.intValue() != adjustableMinerFeeCustomViewInfoState.getNonce();
        Integer valueOf = (z && speed == PresetSpeed.CUSTOM) ? Integer.valueOf(adjustableMinerFeeCustomViewInfoState.getNonce()) : null;
        if (speed != PresetSpeed.CUSTOM) {
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.adjustableMinerFeePresetSelected(AnalyticsEvent.Companion, selection.getName()));
        } else {
            BigInteger gasPrice = selection.getGasPrice();
            AdjustableMinerFeeCustomViewInfoState adjustableMinerFeeCustomViewInfoState2 = this$0.startingValues;
            if (adjustableMinerFeeCustomViewInfoState2 != null) {
                changeDirectionFrom = AdjustableMinerFeeViewModelKt.changeDirectionFrom(gasPrice, adjustableMinerFeeCustomViewInfoState2.getGasPrice());
                AdjustableMinerFeeCustomViewInfoState adjustableMinerFeeCustomViewInfoState3 = (AdjustableMinerFeeCustomViewInfoState) selection;
                BigInteger gasLimit = adjustableMinerFeeCustomViewInfoState3.getGasLimit();
                AdjustableMinerFeeCustomViewInfoState adjustableMinerFeeCustomViewInfoState4 = this$0.startingValues;
                if (adjustableMinerFeeCustomViewInfoState4 != null) {
                    changeDirectionFrom2 = AdjustableMinerFeeViewModelKt.changeDirectionFrom(gasLimit, adjustableMinerFeeCustomViewInfoState4.getGasLimit());
                    int nonce = adjustableMinerFeeCustomViewInfoState3.getNonce();
                    AdjustableMinerFeeCustomViewInfoState adjustableMinerFeeCustomViewInfoState5 = this$0.startingValues;
                    if (adjustableMinerFeeCustomViewInfoState5 != null) {
                        changeDirectionFrom3 = AdjustableMinerFeeViewModelKt.changeDirectionFrom(nonce, adjustableMinerFeeCustomViewInfoState5.getNonce());
                        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.adjustableMinerFeeCustomValueSelected(AnalyticsEvent.Companion, changeDirectionFrom, changeDirectionFrom2, z, changeDirectionFrom3));
                    } else {
                        kotlin.jvm.internal.m.w("startingValues");
                        throw null;
                    }
                } else {
                    kotlin.jvm.internal.m.w("startingValues");
                    throw null;
                }
            } else {
                kotlin.jvm.internal.m.w("startingValues");
                throw null;
            }
        }
        this$0.dismissSubject.onNext(kotlin.u.a(AdjustableMinerFeeArgs.INSTANCE.getResultKey(), new AdjustableMinerFeeLegacySelection(selection.getGasPrice(), ((AdjustableMinerFeeCustomViewInfoState) selection).getGasLimit(), valueOf)));
        return kotlin.x.a;
    }

    private final void setState(AdjustableMinerFeeViewState adjustableMinerFeeViewState) {
        this.state = adjustableMinerFeeViewState;
        this.stateSubject.onNext(adjustableMinerFeeViewState);
    }

    /* renamed from: setup$lambda-1 */
    public static final kotlin.x m1358setup$lambda1(AdjustableMinerFeeViewModel this$0, BigInteger minerFeeLimit, kotlin.o dstr$minerFeesResult$nonce) {
        List<? extends BigInteger> j2;
        int r;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(minerFeeLimit, "$minerFeeLimit");
        kotlin.jvm.internal.m.g(dstr$minerFeesResult$nonce, "$dstr$minerFeesResult$nonce");
        AdjustableMinerFeeInfos adjustableMinerFeeInfos = (AdjustableMinerFeeInfos) dstr$minerFeesResult$nonce.a();
        Integer nonce = (Integer) dstr$minerFeesResult$nonce.b();
        this$0.startingValues = this$0.state.getCustomPresetInfo();
        j2 = kotlin.a0.r.j(adjustableMinerFeeInfos.getSlow().getGasPrice(), adjustableMinerFeeInfos.getNormal().getGasPrice(), adjustableMinerFeeInfos.getFast().getGasPrice());
        this$0.gasPricePresets = j2;
        this$0.currentWaitTimes = adjustableMinerFeeInfos.getWaitTimes();
        List<? extends BigInteger> list = this$0.gasPricePresets;
        if (list != null) {
            r = kotlin.a0.s.r(list, 10);
            ArrayList arrayList = new ArrayList(r);
            for (BigInteger bigInteger : list) {
                List<AdjustableMinerFeeWaitTime> waitTimes = adjustableMinerFeeInfos.getWaitTimes();
                List<? extends BigInteger> list2 = this$0.gasPricePresets;
                if (list2 != null) {
                    arrayList.add(this$0.calculateWaitTime(bigInteger, waitTimes, list2).getWaitTimeString());
                } else {
                    kotlin.jvm.internal.m.w("gasPricePresets");
                    throw null;
                }
            }
            LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
            AdjustableMinerFeeViewInfoState adjustableMinerFeeViewInfoState = new AdjustableMinerFeeViewInfoState(localizedStrings.get(R.string.slow), adjustableMinerFeeInfos.getSlow().getGasPrice(), (String) arrayList.get(0), PresetSpeed.SLOW, adjustableMinerFeeInfos.getSlow().getFiatFee(), adjustableMinerFeeInfos.getSlow().getCryptoFee(), null, false, 192, null);
            AdjustableMinerFeeViewInfoState adjustableMinerFeeViewInfoState2 = new AdjustableMinerFeeViewInfoState(localizedStrings.get(R.string.normal), adjustableMinerFeeInfos.getNormal().getGasPrice(), (String) arrayList.get(1), PresetSpeed.NORMAL, adjustableMinerFeeInfos.getNormal().getFiatFee(), adjustableMinerFeeInfos.getNormal().getCryptoFee(), null, false, 192, null);
            AdjustableMinerFeeViewInfoState adjustableMinerFeeViewInfoState3 = new AdjustableMinerFeeViewInfoState(localizedStrings.get(R.string.fast), adjustableMinerFeeInfos.getFast().getGasPrice(), (String) arrayList.get(2), PresetSpeed.FAST, adjustableMinerFeeInfos.getFast().getFiatFee(), adjustableMinerFeeInfos.getFast().getCryptoFee(), null, false, 192, null);
            String str = localizedStrings.get(R.string.custom);
            PresetSpeed presetSpeed = PresetSpeed.CUSTOM;
            String str2 = (String) arrayList.get(1);
            BigInteger gasPrice = adjustableMinerFeeInfos.getNormal().getGasPrice();
            String bigDecimal = BigInteger_SendKt.toGwei(adjustableMinerFeeInfos.getNormal().getGasPrice()).toString();
            String fiatFee = adjustableMinerFeeInfos.getNormal().getFiatFee();
            String cryptoFee = adjustableMinerFeeInfos.getNormal().getCryptoFee();
            kotlin.jvm.internal.m.f(nonce, "nonce");
            this$0.setState(AdjustableMinerFeeViewState.copy$default(this$0.state, adjustableMinerFeeViewInfoState, adjustableMinerFeeViewInfoState2, adjustableMinerFeeViewInfoState3, new AdjustableMinerFeeCustomViewInfoState(str, gasPrice, str2, presetSpeed, fiatFee, cryptoFee, bigDecimal, false, minerFeeLimit, null, nonce.intValue(), false, 2688, null), null, 16, null));
            return kotlin.x.a;
        }
        kotlin.jvm.internal.m.w("gasPricePresets");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0006, code lost:
        r1 = kotlin.l0.v.j(r14);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final h.c.b0<kotlin.x> customValueChanged(java.lang.String r14, java.lang.String r15, java.lang.String r16) {
        /*
            r13 = this;
            r6 = r13
            r0 = 0
            if (r14 != 0) goto L6
        L4:
            r1 = r0
            goto L11
        L6:
            java.math.BigDecimal r1 = kotlin.l0.o.j(r14)
            if (r1 != 0) goto Ld
            goto L4
        Ld:
            java.math.BigInteger r1 = com.coinbase.wallet.features.send.extensions.BigDecimal_SendKt.toWei(r1)
        L11:
            if (r1 != 0) goto L1d
            com.coinbase.wallet.features.send.models.AdjustableMinerFeeViewState r1 = r6.state
            com.coinbase.wallet.features.send.models.AdjustableMinerFeeCustomViewInfoState r1 = r1.getCustomPresetInfo()
            java.math.BigInteger r1 = r1.getGasPrice()
        L1d:
            r3 = r1
            if (r15 != 0) goto L22
            r1 = r0
            goto L26
        L22:
            java.math.BigInteger r1 = kotlin.l0.o.k(r15)
        L26:
            if (r1 != 0) goto L32
            com.coinbase.wallet.features.send.models.AdjustableMinerFeeViewState r1 = r6.state
            com.coinbase.wallet.features.send.models.AdjustableMinerFeeCustomViewInfoState r1 = r1.getCustomPresetInfo()
            java.math.BigInteger r1 = r1.getGasLimit()
        L32:
            r4 = r1
            if (r16 != 0) goto L36
            goto L3a
        L36:
            java.lang.Integer r0 = kotlin.l0.o.q(r16)
        L3a:
            if (r0 != 0) goto L47
            com.coinbase.wallet.features.send.models.AdjustableMinerFeeViewState r0 = r6.state
            com.coinbase.wallet.features.send.models.AdjustableMinerFeeCustomViewInfoState r0 = r0.getCustomPresetInfo()
            int r0 = r0.getNonce()
            goto L4b
        L47:
            int r0 = r0.intValue()
        L4b:
            r5 = r0
            java.math.BigInteger r1 = r4.multiply(r3)
            java.lang.String r0 = "this.multiply(other)"
            kotlin.jvm.internal.m.f(r1, r0)
            com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository r7 = r6.exchangeRateRepository
            com.coinbase.wallet.blockchains.models.CurrencyCode r8 = r6.baseCurrencyCode
            r9 = 0
            r10 = 0
            r11 = 6
            r12 = 0
            h.c.b0 r0 = com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository.DefaultImpls.getCryptoExchangeRate$default(r7, r8, r9, r10, r11, r12)
            h.c.a0 r2 = h.c.j0.c.a.b()
            h.c.b0 r7 = r0.observeOn(r2)
            com.coinbase.wallet.features.send.viewmodels.c r8 = new com.coinbase.wallet.features.send.viewmodels.c
            r0 = r8
            r2 = r13
            r0.<init>()
            h.c.b0 r0 = r7.map(r8)
            java.lang.String r1 = "exchangeRateRepository.getCryptoExchangeRate(baseCurrencyCode)\n            .observeOn(AndroidSchedulers.mainThread())\n            .map { rate ->\n                val ethBasedFee = weiFee.toBigDecimal().movePointLeft(CurrencyDecimal.ETH)\n                val fiatFee = rate * ethBasedFee\n                val fiatString = currencyFormatter.fiatValueString(fiatFee)\n                val cryptoString = currencyFormatter.formatToCrypto(baseCurrencyCode, 18, weiFee)\n                val customWaitTime = calculateWaitTime(\n                    inputWei = gasPrice,\n                    waitTimes = currentWaitTimes,\n                    presets = gasPricePresets\n                )\n\n                val customMinerFeeViewInfo = AdjustableMinerFeeCustomViewInfoState(\n                    name = LocalizedStrings[R.string.custom],\n                    presetSpeed = PresetSpeed.CUSTOM,\n                    waitTime = customWaitTime.waitTimeString,\n                    warningMessage = customWaitTime.warningText,\n                    gasPrice = gasPrice,\n                    gasLimit = gasLimit,\n                    gasString = gasPrice.toGwei().toString(),\n                    fiatFee = fiatString,\n                    cryptoFee = cryptoString,\n                    nonce = nonce,\n                    dataLoaded = true,\n                    isValid = gasPrice > BigInteger.ZERO && gasLimit >= BigInteger(\"21000\")\n                )\n\n                state = state.copy(\n                    customPresetInfo = customMinerFeeViewInfo\n                )\n            }"
            kotlin.jvm.internal.m.f(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFeeViewModel.customValueChanged(java.lang.String, java.lang.String, java.lang.String):h.c.b0");
    }

    public final h.c.s<kotlin.o<String, AdjustableMinerFeeLegacySelection>> getDismissObservable() {
        return this.dismissObservable;
    }

    public final h.c.s<AdjustableMinerFeeViewState> getStateObservable() {
        return this.stateObservable;
    }

    public final h.c.b0<kotlin.x> presetSelected(final PresetSpeed speed) {
        final AdjustableMinerFeeViewInfoState slowPresetInfo;
        kotlin.jvm.internal.m.g(speed, "speed");
        int i2 = WhenMappings.$EnumSwitchMapping$0[speed.ordinal()];
        if (i2 == 1) {
            slowPresetInfo = this.state.getSlowPresetInfo();
        } else if (i2 == 2) {
            slowPresetInfo = this.state.getNormalPresetInfo();
        } else if (i2 == 3) {
            slowPresetInfo = this.state.getFastPresetInfo();
        } else if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            slowPresetInfo = this.state.getCustomPresetInfo();
        }
        if (!(slowPresetInfo instanceof AdjustableMinerFeeCustomViewInfoState)) {
            this.dismissSubject.onNext(kotlin.u.a(AdjustableMinerFeeArgs.INSTANCE.getResultKey(), new AdjustableMinerFeeLegacySelection(slowPresetInfo.getGasPrice(), null, null, 6, null)));
            h.c.b0<kotlin.x> just = h.c.b0.just(kotlin.x.a);
            kotlin.jvm.internal.m.f(just, "just(Unit)");
            return just;
        }
        h.c.b0 map = this.adjustableMinerFeeRepository.calculateNonce(this.ethereumChain, this.fromAddress).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AdjustableMinerFeeViewModel.b(AdjustableMinerFeeViewInfoState.this, speed, this, (Integer) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "adjustableMinerFeeRepository.calculateNonce(ethereumChain = ethereumChain, fromAddress = fromAddress)\n            .observeOn(AndroidSchedulers.mainThread())\n            .map { calculatedNonce ->\n                val nonceChanged = calculatedNonce != selection.nonce\n                val nonce = if (nonceChanged && speed == PresetSpeed.CUSTOM) {\n                    selection.nonce\n                } else {\n                    null\n                }\n\n                if (speed != PresetSpeed.CUSTOM) {\n                    Analytics.log(\n                        AnalyticsEvent.adjustableMinerFeePresetSelected(\n                            presetName = selection.name\n                        )\n                    )\n                } else {\n                    val gasPriceChangeDirection = selection.gasPrice.changeDirectionFrom(startingValues.gasPrice)\n                    val gasLimitChangeDirection = selection.gasLimit.changeDirectionFrom(startingValues.gasLimit)\n                    val nonceChangeDirection = selection.nonce.changeDirectionFrom(startingValues.nonce)\n\n                    Analytics.log(\n                        AnalyticsEvent.adjustableMinerFeeCustomValueSelected(\n                            gasPriceChangeDirection = gasPriceChangeDirection,\n                            gasLimitChangeDirection = gasLimitChangeDirection,\n                            isNonceChanged = nonceChanged,\n                            nonceChangeDirection = nonceChangeDirection\n                        )\n                    )\n                }\n                val result = AdjustableMinerFeeLegacySelection(\n                    gasPrice = selection.gasPrice,\n                    gasLimit = selection.gasLimit,\n                    nonce = nonce\n                )\n                dismissSubject.onNext(AdjustableMinerFeeArgs.resultKey to result)\n            }");
        return map;
    }

    public final h.c.b0<kotlin.x> setup() {
        h.c.b0<Integer> just;
        String str = (String) SavedStateHandle_CommonKt.require(this.savedStateHandle, AdjustableMinerFeeArgs.FLOW_NAME);
        final BigInteger bigInteger = (BigInteger) SavedStateHandle_CommonKt.require(this.savedStateHandle, AdjustableMinerFeeArgs.MINER_FEE_LIMIT);
        BigInteger bigInteger2 = (BigInteger) this.savedStateHandle.b(AdjustableMinerFeeArgs.RECOMMENDED_GAS_PRICE);
        Integer num = (Integer) this.savedStateHandle.b(AdjustableMinerFeeArgs.NONCE);
        if (num == null) {
            just = this.adjustableMinerFeeRepository.calculateNonce(this.ethereumChain, this.fromAddress);
        } else {
            just = h.c.b0.just(num);
            kotlin.jvm.internal.m.f(just, "{\n            Single.just(nonce)\n        }");
        }
        h.c.b0<kotlin.x> map = h.c.t0.e.a.a(this.adjustableMinerFeeRepository.getMinerFeesLegacy(bigInteger, bigInteger2), just).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AdjustableMinerFeeViewModel.c(AdjustableMinerFeeViewModel.this, bigInteger, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "Singles.zip(minerFeesSingle, nonceSingle)\n            .observeOn(AndroidSchedulers.mainThread())\n            .map { (minerFeesResult, nonce) ->\n                startingValues = state.customPresetInfo\n                gasPricePresets = listOf(\n                    minerFeesResult.slow.gasPrice,\n                    minerFeesResult.normal.gasPrice,\n                    minerFeesResult.fast.gasPrice\n                )\n                currentWaitTimes = minerFeesResult.waitTimes\n                val waitTimeStrings = gasPricePresets.map {\n                    calculateWaitTime(\n                        inputWei = it,\n                        waitTimes = minerFeesResult.waitTimes,\n                        presets = gasPricePresets\n                    ).waitTimeString\n                }\n\n                val slow = AdjustableMinerFeeViewInfoState(\n                    name = LocalizedStrings[R.string.slow],\n                    presetSpeed = PresetSpeed.SLOW,\n                    waitTime = waitTimeStrings[0],\n                    gasPrice = minerFeesResult.slow.gasPrice,\n                    fiatFee = minerFeesResult.slow.fiatFee,\n                    cryptoFee = minerFeesResult.slow.cryptoFee\n                )\n\n                val normal = AdjustableMinerFeeViewInfoState(\n                    name = LocalizedStrings[R.string.normal],\n                    presetSpeed = PresetSpeed.NORMAL,\n                    waitTime = waitTimeStrings[1],\n                    gasPrice = minerFeesResult.normal.gasPrice,\n                    fiatFee = minerFeesResult.normal.fiatFee,\n                    cryptoFee = minerFeesResult.normal.cryptoFee\n                )\n\n                val fast = AdjustableMinerFeeViewInfoState(\n                    name = LocalizedStrings[R.string.fast],\n                    presetSpeed = PresetSpeed.FAST,\n                    waitTime = waitTimeStrings[2],\n                    gasPrice = minerFeesResult.fast.gasPrice,\n                    fiatFee = minerFeesResult.fast.fiatFee,\n                    cryptoFee = minerFeesResult.fast.cryptoFee\n                )\n\n                val custom = AdjustableMinerFeeCustomViewInfoState(\n                    name = LocalizedStrings[R.string.custom],\n                    presetSpeed = PresetSpeed.CUSTOM,\n                    waitTime = waitTimeStrings[1],\n                    gasPrice = minerFeesResult.normal.gasPrice,\n                    gasLimit = minerFeeLimit,\n                    gasString = minerFeesResult.normal.gasPrice.toGwei().toString(),\n                    fiatFee = minerFeesResult.normal.fiatFee,\n                    cryptoFee = minerFeesResult.normal.cryptoFee,\n                    nonce = nonce\n                )\n\n                state = state.copy(\n                    slowPresetInfo = slow,\n                    normalPresetInfo = normal,\n                    fastPresetInfo = fast,\n                    customPresetInfo = custom\n                )\n            }");
        return map;
    }
}