package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.ApiConstants;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.extensions.SavedStateHandle_CommonKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.features.send.extensions.BigInteger_SendKt;
import com.coinbase.wallet.features.send.models.AdjustableMinerFee1559CustomViewInfoState;
import com.coinbase.wallet.features.send.models.AdjustableMinerFee1559Infos;
import com.coinbase.wallet.features.send.models.AdjustableMinerFee1559ViewInfoState;
import com.coinbase.wallet.features.send.models.AdjustableMinerFee1559ViewState;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.features.send.models.MinerFee1559Data;
import com.coinbase.wallet.features.send.models.PresetSpeed;
import com.coinbase.wallet.features.send.repositories.AdjustableMinerFeeRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.toshi.R;

/* compiled from: AdjustableMinerFee1559ViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001DB#\b\u0007\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u0010=\u001a\u00020<\u0012\b\b\u0001\u0010\"\u001a\u00020!¢\u0006\u0004\bB\u0010CJ'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\n\u001a\u00020\u0006*\u00020\f2\u0006\u0010\t\u001a\u00020\fH\u0002¢\u0006\u0004\b\n\u0010\rJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J=\u0010\u0016\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\u001c8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R<\u00102\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u000200 1*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u000200\u0018\u00010/0/0.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R+\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002000/0$8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010&\u001a\u0004\b8\u0010(R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R$\u0010@\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u00010\u001c0\u001c0?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006E"}, d2 = {"Lcom/coinbase/wallet/features/send/viewmodels/AdjustableMinerFee1559ViewModel;", "Landroidx/lifecycle/b0;", "Ljava/math/BigInteger;", "maxFeePerGas", "maxPriorityFee", "gasLimit", "", "createWarningMessage", "(Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;)Ljava/lang/String;", "value", "changeDirectionFrom", "(Ljava/math/BigInteger;Ljava/math/BigInteger;)Ljava/lang/String;", "", "(II)Ljava/lang/String;", "Lh/c/b0;", "Lkotlin/x;", "setup", "()Lh/c/b0;", "maxPriorityFeeString", "maxFeePerGasString", "nonceString", "gasLimitString", "customValueChanged", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/coinbase/wallet/features/send/models/PresetSpeed;", "speed", "presetSelected", "(Lcom/coinbase/wallet/features/send/models/PresetSpeed;)Lh/c/b0;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewState;", ApiConstants.STATE, "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewState;", "setState", "(Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewState;)V", "Landroidx/lifecycle/z;", "savedStateHandle", "Landroidx/lifecycle/z;", "Lh/c/s;", "stateObservable", "Lh/c/s;", "getStateObservable", "()Lh/c/s;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559CustomViewInfoState;", "startingValues", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559CustomViewInfoState;", "fromAddress", "Ljava/lang/String;", "Lh/c/v0/b;", "Lkotlin/o;", "Lcom/coinbase/wallet/features/send/models/MinerFee1559Data;", "kotlin.jvm.PlatformType", "dismissSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "dismissObservable", "getDismissObservable", "Lcom/coinbase/ciphercore/ethereum/EthereumChain;", "ethereumChain", "Lcom/coinbase/ciphercore/ethereum/EthereumChain;", "Lcom/coinbase/wallet/features/send/repositories/AdjustableMinerFeeRepository;", "adjustableMinerFeeRepository", "Lcom/coinbase/wallet/features/send/repositories/AdjustableMinerFeeRepository;", "Lh/c/v0/a;", "stateSubject", "Lh/c/v0/a;", "<init>", "(Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Lcom/coinbase/wallet/features/send/repositories/AdjustableMinerFeeRepository;Landroidx/lifecycle/z;)V", "Factory", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFee1559ViewModel extends androidx.lifecycle.b0 {
    private final AdjustableMinerFeeRepository adjustableMinerFeeRepository;
    private final CurrencyFormatter currencyFormatter;
    private final h.c.s<kotlin.o<String, MinerFee1559Data>> dismissObservable;
    private final h.c.v0.b<kotlin.o<String, MinerFee1559Data>> dismissSubject;
    private final EthereumChain ethereumChain;
    private final String fromAddress;
    private final androidx.lifecycle.z savedStateHandle;
    private AdjustableMinerFee1559CustomViewInfoState startingValues;
    private AdjustableMinerFee1559ViewState state;
    private final h.c.s<AdjustableMinerFee1559ViewState> stateObservable;
    private final h.c.v0.a<AdjustableMinerFee1559ViewState> stateSubject;

    /* compiled from: AdjustableMinerFee1559ViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/features/send/viewmodels/AdjustableMinerFee1559ViewModel$Factory;", "", "Landroidx/lifecycle/z;", "savedStateHandle", "Lcom/coinbase/wallet/features/send/viewmodels/AdjustableMinerFee1559ViewModel;", "create", "(Landroidx/lifecycle/z;)Lcom/coinbase/wallet/features/send/viewmodels/AdjustableMinerFee1559ViewModel;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Factory {
        AdjustableMinerFee1559ViewModel create(androidx.lifecycle.z zVar);
    }

    /* compiled from: AdjustableMinerFee1559ViewModel.kt */
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

    public AdjustableMinerFee1559ViewModel(CurrencyFormatter currencyFormatter, AdjustableMinerFeeRepository adjustableMinerFeeRepository, androidx.lifecycle.z savedStateHandle) {
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        kotlin.jvm.internal.m.g(adjustableMinerFeeRepository, "adjustableMinerFeeRepository");
        kotlin.jvm.internal.m.g(savedStateHandle, "savedStateHandle");
        this.currencyFormatter = currencyFormatter;
        this.adjustableMinerFeeRepository = adjustableMinerFeeRepository;
        this.savedStateHandle = savedStateHandle;
        h.c.v0.a<AdjustableMinerFee1559ViewState> e2 = h.c.v0.a.e(new AdjustableMinerFee1559ViewState(null, null, null, null, 15, null));
        kotlin.jvm.internal.m.f(e2, "createDefault(AdjustableMinerFee1559ViewState())");
        this.stateSubject = e2;
        h.c.v0.b<kotlin.o<String, MinerFee1559Data>> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<Pair<String, MinerFee1559Data>>()");
        this.dismissSubject = d2;
        this.state = new AdjustableMinerFee1559ViewState(null, null, null, null, 15, null);
        this.fromAddress = (String) SavedStateHandle_CommonKt.require(savedStateHandle, AdjustableMinerFeeArgs.FROM_ADDRESS);
        this.ethereumChain = (EthereumChain) SavedStateHandle_CommonKt.require(savedStateHandle, AdjustableMinerFeeArgs.ETHEREUM_CHAIN);
        h.c.s<AdjustableMinerFee1559ViewState> hide = e2.hide();
        kotlin.jvm.internal.m.f(hide, "stateSubject.hide()");
        this.stateObservable = hide;
        h.c.s<kotlin.o<String, MinerFee1559Data>> hide2 = d2.hide();
        kotlin.jvm.internal.m.f(hide2, "dismissSubject.hide()");
        this.dismissObservable = hide2;
    }

    public static /* synthetic */ kotlin.x a(AdjustableMinerFee1559ViewInfoState adjustableMinerFee1559ViewInfoState, PresetSpeed presetSpeed, AdjustableMinerFee1559ViewModel adjustableMinerFee1559ViewModel, Integer num) {
        return m1354presetSelected$lambda1(adjustableMinerFee1559ViewInfoState, presetSpeed, adjustableMinerFee1559ViewModel, num);
    }

    public static /* synthetic */ kotlin.x b(AdjustableMinerFee1559ViewModel adjustableMinerFee1559ViewModel, BigInteger bigInteger, kotlin.o oVar) {
        return m1355setup$lambda0(adjustableMinerFee1559ViewModel, bigInteger, oVar);
    }

    private final String changeDirectionFrom(int i2, int i3) {
        return i2 > i3 ? "Up" : i2 < i3 ? "Down" : "None";
    }

    private final String changeDirectionFrom(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.compareTo(bigInteger2) > 0 ? "Up" : bigInteger.compareTo(bigInteger2) < 0 ? "Down" : "None";
    }

    private final String createWarningMessage(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        CharSequence h1;
        if (this.state.getCustomPresetInfo().getDataLoaded()) {
            BigInteger baseFeePerGas = this.state.getSlowPresetInfo().getBaseFeePerGas();
            StringBuilder sb = new StringBuilder();
            if (bigInteger.compareTo(baseFeePerGas) < 0) {
                sb.append(LocalizedStrings.INSTANCE.get(R.string.max_fee_low, BigInteger_SendKt.toGwei(this.state.getSlowPresetInfo().getMaxFeePerGas())));
                kotlin.jvm.internal.m.f(sb, "append(value)");
                sb.append('\n');
                kotlin.jvm.internal.m.f(sb, "append('\\n')");
            }
            if (bigInteger2.compareTo(this.state.getSlowPresetInfo().getPriorityFee()) < 0) {
                sb.append(LocalizedStrings.INSTANCE.get(R.string.priority_fee_low, BigInteger_SendKt.toGwei(this.state.getSlowPresetInfo().getPriorityFee())));
                kotlin.jvm.internal.m.f(sb, "append(value)");
                sb.append('\n');
                kotlin.jvm.internal.m.f(sb, "append('\\n')");
            }
            AdjustableMinerFee1559CustomViewInfoState adjustableMinerFee1559CustomViewInfoState = this.startingValues;
            if (adjustableMinerFee1559CustomViewInfoState != null) {
                if (bigInteger3.compareTo(adjustableMinerFee1559CustomViewInfoState.getGasLimit()) < 0) {
                    LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
                    Object[] objArr = new Object[1];
                    AdjustableMinerFee1559CustomViewInfoState adjustableMinerFee1559CustomViewInfoState2 = this.startingValues;
                    if (adjustableMinerFee1559CustomViewInfoState2 == null) {
                        kotlin.jvm.internal.m.w("startingValues");
                        throw null;
                    }
                    objArr[0] = adjustableMinerFee1559CustomViewInfoState2.getGasLimit();
                    sb.append(localizedStrings.get(R.string.gas_limit_low, objArr));
                    kotlin.jvm.internal.m.f(sb, "append(value)");
                    sb.append('\n');
                    kotlin.jvm.internal.m.f(sb, "append('\\n')");
                }
                String sb2 = sb.toString();
                kotlin.jvm.internal.m.f(sb2, "strBuilder.toString()");
                h1 = kotlin.l0.y.h1(sb2);
                return h1.toString();
            }
            kotlin.jvm.internal.m.w("startingValues");
            throw null;
        }
        return Strings_CoreKt.getEmpty(Strings.INSTANCE);
    }

    public static /* synthetic */ void customValueChanged$default(AdjustableMinerFee1559ViewModel adjustableMinerFee1559ViewModel, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        if ((i2 & 8) != 0) {
            str4 = null;
        }
        adjustableMinerFee1559ViewModel.customValueChanged(str, str2, str3, str4);
    }

    /* renamed from: presetSelected$lambda-1 */
    public static final kotlin.x m1354presetSelected$lambda1(AdjustableMinerFee1559ViewInfoState selection, PresetSpeed speed, AdjustableMinerFee1559ViewModel this$0, Integer calculatedNonce) {
        kotlin.jvm.internal.m.g(selection, "$selection");
        kotlin.jvm.internal.m.g(speed, "$speed");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(calculatedNonce, "calculatedNonce");
        AdjustableMinerFee1559CustomViewInfoState adjustableMinerFee1559CustomViewInfoState = (AdjustableMinerFee1559CustomViewInfoState) selection;
        boolean z = calculatedNonce.intValue() != adjustableMinerFee1559CustomViewInfoState.getNonce();
        Integer valueOf = (z && speed == PresetSpeed.CUSTOM) ? Integer.valueOf(adjustableMinerFee1559CustomViewInfoState.getNonce()) : null;
        BigInteger maxFeePerGas = selection.getMaxFeePerGas();
        AdjustableMinerFee1559CustomViewInfoState adjustableMinerFee1559CustomViewInfoState2 = this$0.startingValues;
        if (adjustableMinerFee1559CustomViewInfoState2 != null) {
            String changeDirectionFrom = this$0.changeDirectionFrom(maxFeePerGas, adjustableMinerFee1559CustomViewInfoState2.getMaxFeePerGas());
            AdjustableMinerFee1559CustomViewInfoState adjustableMinerFee1559CustomViewInfoState3 = (AdjustableMinerFee1559CustomViewInfoState) selection;
            BigInteger gasLimit = adjustableMinerFee1559CustomViewInfoState3.getGasLimit();
            AdjustableMinerFee1559CustomViewInfoState adjustableMinerFee1559CustomViewInfoState4 = this$0.startingValues;
            if (adjustableMinerFee1559CustomViewInfoState4 != null) {
                String changeDirectionFrom2 = this$0.changeDirectionFrom(gasLimit, adjustableMinerFee1559CustomViewInfoState4.getGasLimit());
                int nonce = adjustableMinerFee1559CustomViewInfoState3.getNonce();
                AdjustableMinerFee1559CustomViewInfoState adjustableMinerFee1559CustomViewInfoState5 = this$0.startingValues;
                if (adjustableMinerFee1559CustomViewInfoState5 != null) {
                    Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.adjustableMinerFeeCustomValueSelected(AnalyticsEvent.Companion, changeDirectionFrom, changeDirectionFrom2, z, this$0.changeDirectionFrom(nonce, adjustableMinerFee1559CustomViewInfoState5.getNonce())));
                    this$0.dismissSubject.onNext(kotlin.u.a(AdjustableMinerFeeArgs.INSTANCE.getResultKey(), new MinerFee1559Data(selection.getMaxFeePerGas(), selection.getBaseFeePerGas(), selection.getPriorityFee(), adjustableMinerFee1559CustomViewInfoState3.getGasLimit(), valueOf)));
                    return kotlin.x.a;
                }
                kotlin.jvm.internal.m.w("startingValues");
                throw null;
            }
            kotlin.jvm.internal.m.w("startingValues");
            throw null;
        }
        kotlin.jvm.internal.m.w("startingValues");
        throw null;
    }

    private final void setState(AdjustableMinerFee1559ViewState adjustableMinerFee1559ViewState) {
        this.state = adjustableMinerFee1559ViewState;
        this.stateSubject.onNext(adjustableMinerFee1559ViewState);
    }

    /* renamed from: setup$lambda-0 */
    public static final kotlin.x m1355setup$lambda0(AdjustableMinerFee1559ViewModel this$0, BigInteger minerFeeLimit, kotlin.o dstr$minerFeesResult$nonce) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(minerFeeLimit, "$minerFeeLimit");
        kotlin.jvm.internal.m.g(dstr$minerFeesResult$nonce, "$dstr$minerFeesResult$nonce");
        AdjustableMinerFee1559Infos adjustableMinerFee1559Infos = (AdjustableMinerFee1559Infos) dstr$minerFeesResult$nonce.a();
        Integer nonce = (Integer) dstr$minerFeesResult$nonce.b();
        this$0.startingValues = this$0.state.getCustomPresetInfo();
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        AdjustableMinerFee1559ViewInfoState adjustableMinerFee1559ViewInfoState = new AdjustableMinerFee1559ViewInfoState(localizedStrings.get(R.string.slow), PresetSpeed.SLOW, localizedStrings.get(R.string.slow_wait_time), adjustableMinerFee1559Infos.getSlow().getMaxFeePerGas(), adjustableMinerFee1559Infos.getNormal().getBaseFeePerGas(), adjustableMinerFee1559Infos.getSlow().getMaxPriorityFeePerGas(), adjustableMinerFee1559Infos.getSlow().getFiatRangeString(), adjustableMinerFee1559Infos.getSlow().getCryptoRangeString(), null, null, false, 1792, null);
        AdjustableMinerFee1559ViewInfoState adjustableMinerFee1559ViewInfoState2 = new AdjustableMinerFee1559ViewInfoState(localizedStrings.get(R.string.normal), PresetSpeed.NORMAL, localizedStrings.get(R.string.normal_wait_time), adjustableMinerFee1559Infos.getNormal().getMaxFeePerGas(), adjustableMinerFee1559Infos.getNormal().getBaseFeePerGas(), adjustableMinerFee1559Infos.getNormal().getMaxPriorityFeePerGas(), adjustableMinerFee1559Infos.getNormal().getFiatRangeString(), adjustableMinerFee1559Infos.getNormal().getCryptoRangeString(), null, null, false, 1792, null);
        AdjustableMinerFee1559ViewInfoState adjustableMinerFee1559ViewInfoState3 = new AdjustableMinerFee1559ViewInfoState(localizedStrings.get(R.string.fast), PresetSpeed.FAST, localizedStrings.get(R.string.fast_wait_time), adjustableMinerFee1559Infos.getFast().getMaxFeePerGas(), adjustableMinerFee1559Infos.getNormal().getBaseFeePerGas(), adjustableMinerFee1559Infos.getFast().getMaxPriorityFeePerGas(), adjustableMinerFee1559Infos.getFast().getFiatRangeString(), adjustableMinerFee1559Infos.getFast().getCryptoRangeString(), null, null, false, 1792, null);
        String str = localizedStrings.get(R.string.custom);
        PresetSpeed presetSpeed = PresetSpeed.CUSTOM;
        BigInteger maxFeePerGas = adjustableMinerFee1559Infos.getNormal().getMaxFeePerGas();
        BigInteger baseFeePerGas = adjustableMinerFee1559Infos.getNormal().getBaseFeePerGas();
        BigInteger maxPriorityFeePerGas = adjustableMinerFee1559Infos.getNormal().getMaxPriorityFeePerGas();
        String bigDecimal = BigInteger_SendKt.toGwei(adjustableMinerFee1559Infos.getNormal().getMaxFeePerGas()).toString();
        String bigDecimal2 = BigInteger_SendKt.toGwei(adjustableMinerFee1559Infos.getNormal().getMaxPriorityFeePerGas()).toString();
        String fiatRangeString = adjustableMinerFee1559Infos.getNormal().getFiatRangeString();
        String cryptoRangeString = adjustableMinerFee1559Infos.getNormal().getCryptoRangeString();
        kotlin.jvm.internal.m.f(nonce, "nonce");
        this$0.setState(this$0.state.copy(adjustableMinerFee1559ViewInfoState, adjustableMinerFee1559ViewInfoState2, adjustableMinerFee1559ViewInfoState3, new AdjustableMinerFee1559CustomViewInfoState(str, presetSpeed, maxFeePerGas, baseFeePerGas, maxPriorityFeePerGas, fiatRangeString, cryptoRangeString, bigDecimal, bigDecimal2, false, minerFeeLimit, null, nonce.intValue(), false, 10752, null)));
        return kotlin.x.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0007, code lost:
        r2 = kotlin.l0.v.j(r27);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0023, code lost:
        r2 = kotlin.l0.v.j(r28);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void customValueChanged(java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFee1559ViewModel.customValueChanged(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final h.c.s<kotlin.o<String, MinerFee1559Data>> getDismissObservable() {
        return this.dismissObservable;
    }

    public final h.c.s<AdjustableMinerFee1559ViewState> getStateObservable() {
        return this.stateObservable;
    }

    public final h.c.b0<kotlin.x> presetSelected(final PresetSpeed speed) {
        final AdjustableMinerFee1559ViewInfoState slowPresetInfo;
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
        if (!(slowPresetInfo instanceof AdjustableMinerFee1559CustomViewInfoState)) {
            MinerFee1559Data minerFee1559Data = new MinerFee1559Data(slowPresetInfo.getMaxFeePerGas(), slowPresetInfo.getBaseFeePerGas(), slowPresetInfo.getPriorityFee(), null, null, 24, null);
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.adjustableMinerFeePresetSelected(AnalyticsEvent.Companion, slowPresetInfo.getName()));
            this.dismissSubject.onNext(kotlin.u.a(AdjustableMinerFeeArgs.INSTANCE.getResultKey(), minerFee1559Data));
            h.c.b0<kotlin.x> just = h.c.b0.just(kotlin.x.a);
            kotlin.jvm.internal.m.f(just, "just(Unit)");
            return just;
        }
        h.c.b0 map = this.adjustableMinerFeeRepository.calculateNonce(this.ethereumChain, this.fromAddress).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AdjustableMinerFee1559ViewModel.a(AdjustableMinerFee1559ViewInfoState.this, speed, this, (Integer) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "adjustableMinerFeeRepository.calculateNonce(ethereumChain = ethereumChain, fromAddress = fromAddress)\n            .observeOn(AndroidSchedulers.mainThread())\n            .map { calculatedNonce ->\n                val nonceChanged = calculatedNonce != selection.nonce\n                val nonce = if (nonceChanged && speed == PresetSpeed.CUSTOM) {\n                    selection.nonce\n                } else {\n                    null\n                }\n\n                val gasPriceChangeDirection = selection.maxFeePerGas.changeDirectionFrom(\n                    startingValues.maxFeePerGas\n                )\n                val gasLimitChangeDirection = selection.gasLimit.changeDirectionFrom(startingValues.gasLimit)\n                val nonceChangeDirection = selection.nonce.changeDirectionFrom(startingValues.nonce)\n                Analytics.log(\n                    AnalyticsEvent.adjustableMinerFeeCustomValueSelected(\n                        gasPriceChangeDirection = gasPriceChangeDirection,\n                        gasLimitChangeDirection = gasLimitChangeDirection,\n                        isNonceChanged = nonceChanged,\n                        nonceChangeDirection = nonceChangeDirection\n                    )\n                )\n\n                val result = MinerFee1559Data(\n                    maxFeePerGas = selection.maxFeePerGas,\n                    baseFeePerGas = selection.baseFeePerGas,\n                    maxPriorityFee = selection.priorityFee,\n                    gasLimit = selection.gasLimit,\n                    nonce = nonce\n                )\n                dismissSubject.onNext(AdjustableMinerFeeArgs.resultKey to result)\n            }");
        return map;
    }

    public final h.c.b0<kotlin.x> setup() {
        h.c.b0<Integer> just;
        String str = (String) SavedStateHandle_CommonKt.require(this.savedStateHandle, AdjustableMinerFeeArgs.FLOW_NAME);
        final BigInteger bigInteger = (BigInteger) SavedStateHandle_CommonKt.require(this.savedStateHandle, AdjustableMinerFeeArgs.MINER_FEE_LIMIT);
        Integer num = (Integer) this.savedStateHandle.b(AdjustableMinerFeeArgs.NONCE);
        if (num == null) {
            just = this.adjustableMinerFeeRepository.calculateNonce(this.ethereumChain, this.fromAddress);
        } else {
            just = h.c.b0.just(num);
            kotlin.jvm.internal.m.f(just, "{\n            Single.just(nonce)\n        }");
        }
        h.c.b0<AdjustableMinerFee1559Infos> subscribeOn = this.adjustableMinerFeeRepository.getMinerFees1559(bigInteger).subscribeOn(h.c.u0.a.c());
        kotlin.jvm.internal.m.f(subscribeOn, "adjustableMinerFeeRepository.getMinerFees1559(minerFeeLimit).subscribeOn(Schedulers.io())");
        h.c.b0<kotlin.x> map = h.c.t0.e.a.a(subscribeOn, just).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AdjustableMinerFee1559ViewModel.b(AdjustableMinerFee1559ViewModel.this, bigInteger, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "Singles.zip(minerFeesSingle, nonceSingle)\n            .observeOn(AndroidSchedulers.mainThread())\n            .map { (minerFeesResult, nonce) ->\n                startingValues = state.customPresetInfo\n\n                val slow = AdjustableMinerFee1559ViewInfoState(\n                    name = LocalizedStrings[R.string.slow],\n                    presetSpeed = PresetSpeed.SLOW,\n                    waitTime = LocalizedStrings[R.string.slow_wait_time],\n                    maxFeePerGas = minerFeesResult.slow.maxFeePerGas,\n                    baseFeePerGas = minerFeesResult.normal.baseFeePerGas,\n                    priorityFee = minerFeesResult.slow.maxPriorityFeePerGas,\n                    fiatRangeString = minerFeesResult.slow.fiatRangeString,\n                    cryptoRangeString = minerFeesResult.slow.cryptoRangeString\n                )\n\n                val normal = AdjustableMinerFee1559ViewInfoState(\n                    name = LocalizedStrings[R.string.normal],\n                    presetSpeed = PresetSpeed.NORMAL,\n                    waitTime = LocalizedStrings[R.string.normal_wait_time],\n                    maxFeePerGas = minerFeesResult.normal.maxFeePerGas,\n                    baseFeePerGas = minerFeesResult.normal.baseFeePerGas,\n                    priorityFee = minerFeesResult.normal.maxPriorityFeePerGas,\n                    fiatRangeString = minerFeesResult.normal.fiatRangeString,\n                    cryptoRangeString = minerFeesResult.normal.cryptoRangeString\n                )\n\n                val fast = AdjustableMinerFee1559ViewInfoState(\n                    name = LocalizedStrings[R.string.fast],\n                    presetSpeed = PresetSpeed.FAST,\n                    waitTime = LocalizedStrings[R.string.fast_wait_time],\n                    maxFeePerGas = minerFeesResult.fast.maxFeePerGas,\n                    baseFeePerGas = minerFeesResult.normal.baseFeePerGas,\n                    priorityFee = minerFeesResult.fast.maxPriorityFeePerGas,\n                    fiatRangeString = minerFeesResult.fast.fiatRangeString,\n                    cryptoRangeString = minerFeesResult.fast.cryptoRangeString\n                )\n\n                val custom = AdjustableMinerFee1559CustomViewInfoState(\n                    name = LocalizedStrings[R.string.custom],\n                    presetSpeed = PresetSpeed.CUSTOM,\n                    maxFeePerGas = minerFeesResult.normal.maxFeePerGas,\n                    baseFeePerGas = minerFeesResult.normal.baseFeePerGas,\n                    priorityFee = minerFeesResult.normal.maxPriorityFeePerGas,\n                    gasLimit = minerFeeLimit,\n                    maxFeePerGasString = minerFeesResult.normal.maxFeePerGas.toGwei().toString(),\n                    priorityFeeString = minerFeesResult.normal.maxPriorityFeePerGas.toGwei().toString(),\n                    fiatRangeString = minerFeesResult.normal.fiatRangeString,\n                    cryptoRangeString = minerFeesResult.normal.cryptoRangeString,\n                    nonce = nonce\n                )\n\n                state = state.copy(\n                    slowPresetInfo = slow,\n                    normalPresetInfo = normal,\n                    fastPresetInfo = fast,\n                    customPresetInfo = custom\n                )\n            }");
        return map;
    }
}