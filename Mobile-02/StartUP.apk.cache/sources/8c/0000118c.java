package com.coinbase.wallet.application.extensions;

import com.coinbase.wallet.analytics.models.EventProperty;
import com.coinbase.wallet.routing.models.SendDestinationPickerArgs;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: EventProperty+Application.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0003\b\u008d\u0001\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\t\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\"!\u0010\f\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\u0005\"!\u0010\u000f\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u0005\"!\u0010\u0012\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0005\"!\u0010\u0015\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u0005\"!\u0010\u0018\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u0005\"!\u0010\u001b\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\u0005\"!\u0010\u001e\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\u0005\"!\u0010!\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010\u0005\"!\u0010$\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\u0005\"!\u0010'\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0003\u001a\u0004\b&\u0010\u0005\"!\u0010*\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0003\u001a\u0004\b)\u0010\u0005\"!\u0010-\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0003\u001a\u0004\b,\u0010\u0005\"!\u00100\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0003\u001a\u0004\b/\u0010\u0005\"!\u00103\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0003\u001a\u0004\b2\u0010\u0005\"!\u00106\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0003\u001a\u0004\b5\u0010\u0005\"!\u00109\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u0003\u001a\u0004\b8\u0010\u0005\"!\u0010<\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0003\u001a\u0004\b;\u0010\u0005\"!\u0010?\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0003\u001a\u0004\b>\u0010\u0005\"!\u0010B\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0003\u001a\u0004\bA\u0010\u0005\"!\u0010E\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u0003\u001a\u0004\bD\u0010\u0005\"!\u0010H\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u0003\u001a\u0004\bG\u0010\u0005\"!\u0010K\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\u0003\u001a\u0004\bJ\u0010\u0005\"!\u0010N\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u0003\u001a\u0004\bM\u0010\u0005\"!\u0010Q\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\u0003\u001a\u0004\bP\u0010\u0005\"!\u0010T\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\u0003\u001a\u0004\bS\u0010\u0005\"!\u0010W\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u0003\u001a\u0004\bV\u0010\u0005\"!\u0010Z\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bX\u0010\u0003\u001a\u0004\bY\u0010\u0005\"!\u0010]\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\u0003\u001a\u0004\b\\\u0010\u0005\"!\u0010`\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b^\u0010\u0003\u001a\u0004\b_\u0010\u0005\"!\u0010c\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\ba\u0010\u0003\u001a\u0004\bb\u0010\u0005\"!\u0010f\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bd\u0010\u0003\u001a\u0004\be\u0010\u0005\"!\u0010i\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bg\u0010\u0003\u001a\u0004\bh\u0010\u0005\"!\u0010l\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bj\u0010\u0003\u001a\u0004\bk\u0010\u0005\"!\u0010o\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bm\u0010\u0003\u001a\u0004\bn\u0010\u0005\"!\u0010r\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bp\u0010\u0003\u001a\u0004\bq\u0010\u0005\"!\u0010u\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bs\u0010\u0003\u001a\u0004\bt\u0010\u0005\"!\u0010x\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bv\u0010\u0003\u001a\u0004\bw\u0010\u0005\"!\u0010{\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\by\u0010\u0003\u001a\u0004\bz\u0010\u0005\"!\u0010~\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b|\u0010\u0003\u001a\u0004\b}\u0010\u0005\"#\u0010\u0081\u0001\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\r\n\u0004\b\u007f\u0010\u0003\u001a\u0005\b\u0080\u0001\u0010\u0005\"$\u0010\u0084\u0001\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010\u0003\u001a\u0005\b\u0083\u0001\u0010\u0005\"$\u0010\u0087\u0001\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0085\u0001\u0010\u0003\u001a\u0005\b\u0086\u0001\u0010\u0005\"$\u0010\u008a\u0001\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0088\u0001\u0010\u0003\u001a\u0005\b\u0089\u0001\u0010\u0005\"$\u0010\u008d\u0001\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008b\u0001\u0010\u0003\u001a\u0005\b\u008c\u0001\u0010\u0005¨\u0006\u008e\u0001"}, d2 = {"Lcom/coinbase/wallet/analytics/models/EventProperty$Companion;", "Lcom/coinbase/wallet/analytics/models/EventProperty;", "AmountBase$delegate", "Lkotlin/h;", "getAmountBase", "(Lcom/coinbase/wallet/analytics/models/EventProperty$Companion;)Lcom/coinbase/wallet/analytics/models/EventProperty;", "AmountBase", "SendCount$delegate", "getSendCount", "SendCount", "SwapFromAssetFiatAmount$delegate", "getSwapFromAssetFiatAmount", "SwapFromAssetFiatAmount", "NormalPrice$delegate", "getNormalPrice", "NormalPrice", "SwapToAssetAmount$delegate", "getSwapToAssetAmount", "SwapToAssetAmount", "SwapAggregatorID$delegate", "getSwapAggregatorID", "SwapAggregatorID", "State$delegate", "getState", "State", "BackupService$delegate", "getBackupService", "BackupService", "NetworkIsTestNet$delegate", "getNetworkIsTestNet", "NetworkIsTestNet", "CollectibleType$delegate", "getCollectibleType", "CollectibleType", "CoinName$delegate", "getCoinName", "CoinName", "DomainResultsMatched$delegate", "getDomainResultsMatched", "DomainResultsMatched", "SlowPrice$delegate", "getSlowPrice", "SlowPrice", "Type$delegate", "getType", "Type", "ErrorMessage$delegate", "getErrorMessage", "ErrorMessage", "SwapFromAsset$delegate", "getSwapFromAsset", "SwapFromAsset", "GasLimitChangeDirection$delegate", "getGasLimitChangeDirection", "GasLimitChangeDirection", "ChainName$delegate", "getChainName", "ChainName", "SwapToAsset$delegate", "getSwapToAsset", "SwapToAsset", "WalletNumber$delegate", "getWalletNumber", "WalletNumber", "SwapToAssetContractAddress$delegate", "getSwapToAssetContractAddress", "SwapToAssetContractAddress", "FlowName$delegate", "getFlowName", "FlowName", "SwapFromAssetContractAddress$delegate", "getSwapFromAssetContractAddress", "SwapFromAssetContractAddress", "ChainId$delegate", "getChainId", "ChainId", "SwapFromAssetAmount$delegate", "getSwapFromAssetAmount", "SwapFromAssetAmount", "DomainSource$delegate", "getDomainSource", "DomainSource", "IsBiometricProtectionEnabled$delegate", "getIsBiometricProtectionEnabled", "IsBiometricProtectionEnabled", "IsNonceChanged$delegate", "getIsNonceChanged", "IsNonceChanged", "NonceChangeDirection$delegate", "getNonceChangeDirection", "NonceChangeDirection", "FastPrice$delegate", "getFastPrice", "FastPrice", "DappIcon$delegate", "getDappIcon", "DappIcon", "DappName$delegate", "getDappName", "DappName", "PresetName$delegate", "getPresetName", "PresetName", "AmountType$delegate", "getAmountType", "AmountType", "SwapEnabled$delegate", "getSwapEnabled", "SwapEnabled", "GasPriceChangeDirection$delegate", "getGasPriceChangeDirection", "GasPriceChangeDirection", "SendAmount$delegate", "getSendAmount", SendDestinationPickerArgs.SEND_AMOUNT, "Categories$delegate", "getCategories", "Categories", "TopLevelDomain$delegate", "getTopLevelDomain", "TopLevelDomain", "NetworkName$delegate", "getNetworkName", "NetworkName", "CurrencyCode$delegate", "getCurrencyCode", "CurrencyCode", "SwapFeeAmount$delegate", "getSwapFeeAmount", "SwapFeeAmount", "GasLimit$delegate", "getGasLimit", "GasLimit", "DappUrl$delegate", "getDappUrl", "DappUrl", "RecipientType$delegate", "getRecipientType", "RecipientType", "QueryLength$delegate", "getQueryLength", "QueryLength", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EventProperty_ApplicationKt {
    private static final h AmountBase$delegate;
    private static final h AmountType$delegate;
    private static final h BackupService$delegate;
    private static final h Categories$delegate;
    private static final h ChainId$delegate;
    private static final h ChainName$delegate;
    private static final h CoinName$delegate;
    private static final h CollectibleType$delegate;
    private static final h CurrencyCode$delegate;
    private static final h DappIcon$delegate;
    private static final h DappName$delegate;
    private static final h DappUrl$delegate;
    private static final h DomainResultsMatched$delegate;
    private static final h DomainSource$delegate;
    private static final h ErrorMessage$delegate;
    private static final h FastPrice$delegate;
    private static final h FlowName$delegate;
    private static final h GasLimit$delegate;
    private static final h GasLimitChangeDirection$delegate;
    private static final h GasPriceChangeDirection$delegate;
    private static final h IsBiometricProtectionEnabled$delegate;
    private static final h IsNonceChanged$delegate;
    private static final h NetworkIsTestNet$delegate;
    private static final h NetworkName$delegate;
    private static final h NonceChangeDirection$delegate;
    private static final h NormalPrice$delegate;
    private static final h PresetName$delegate;
    private static final h QueryLength$delegate;
    private static final h RecipientType$delegate;
    private static final h SendAmount$delegate;
    private static final h SendCount$delegate;
    private static final h SlowPrice$delegate;
    private static final h State$delegate;
    private static final h SwapAggregatorID$delegate;
    private static final h SwapEnabled$delegate;
    private static final h SwapFeeAmount$delegate;
    private static final h SwapFromAsset$delegate;
    private static final h SwapFromAssetAmount$delegate;
    private static final h SwapFromAssetContractAddress$delegate;
    private static final h SwapFromAssetFiatAmount$delegate;
    private static final h SwapToAsset$delegate;
    private static final h SwapToAssetAmount$delegate;
    private static final h SwapToAssetContractAddress$delegate;
    private static final h TopLevelDomain$delegate;
    private static final h Type$delegate;
    private static final h WalletNumber$delegate;

    static {
        h b2;
        h b3;
        h b4;
        h b5;
        h b6;
        h b7;
        h b8;
        h b9;
        h b10;
        h b11;
        h b12;
        h b13;
        h b14;
        h b15;
        h b16;
        h b17;
        h b18;
        h b19;
        h b20;
        h b21;
        h b22;
        h b23;
        h b24;
        h b25;
        h b26;
        h b27;
        h b28;
        h b29;
        h b30;
        h b31;
        h b32;
        h b33;
        h b34;
        h b35;
        h b36;
        h b37;
        h b38;
        h b39;
        h b40;
        h b41;
        h b42;
        h b43;
        h b44;
        h b45;
        h b46;
        h b47;
        b2 = k.b(EventProperty_ApplicationKt$CollectibleType$2.INSTANCE);
        CollectibleType$delegate = b2;
        b3 = k.b(EventProperty_ApplicationKt$DappName$2.INSTANCE);
        DappName$delegate = b3;
        b4 = k.b(EventProperty_ApplicationKt$DappUrl$2.INSTANCE);
        DappUrl$delegate = b4;
        b5 = k.b(EventProperty_ApplicationKt$DappIcon$2.INSTANCE);
        DappIcon$delegate = b5;
        b6 = k.b(EventProperty_ApplicationKt$CoinName$2.INSTANCE);
        CoinName$delegate = b6;
        b7 = k.b(EventProperty_ApplicationKt$BackupService$2.INSTANCE);
        BackupService$delegate = b7;
        b8 = k.b(EventProperty_ApplicationKt$Categories$2.INSTANCE);
        Categories$delegate = b8;
        b9 = k.b(EventProperty_ApplicationKt$State$2.INSTANCE);
        State$delegate = b9;
        b10 = k.b(EventProperty_ApplicationKt$WalletNumber$2.INSTANCE);
        WalletNumber$delegate = b10;
        b11 = k.b(EventProperty_ApplicationKt$NetworkName$2.INSTANCE);
        NetworkName$delegate = b11;
        b12 = k.b(EventProperty_ApplicationKt$NetworkIsTestNet$2.INSTANCE);
        NetworkIsTestNet$delegate = b12;
        b13 = k.b(EventProperty_ApplicationKt$QueryLength$2.INSTANCE);
        QueryLength$delegate = b13;
        b14 = k.b(EventProperty_ApplicationKt$RecipientType$2.INSTANCE);
        RecipientType$delegate = b14;
        b15 = k.b(EventProperty_ApplicationKt$TopLevelDomain$2.INSTANCE);
        TopLevelDomain$delegate = b15;
        b16 = k.b(EventProperty_ApplicationKt$DomainResultsMatched$2.INSTANCE);
        DomainResultsMatched$delegate = b16;
        b17 = k.b(EventProperty_ApplicationKt$DomainSource$2.INSTANCE);
        DomainSource$delegate = b17;
        b18 = k.b(EventProperty_ApplicationKt$SendCount$2.INSTANCE);
        SendCount$delegate = b18;
        b19 = k.b(EventProperty_ApplicationKt$SendAmount$2.INSTANCE);
        SendAmount$delegate = b19;
        b20 = k.b(EventProperty_ApplicationKt$AmountType$2.INSTANCE);
        AmountType$delegate = b20;
        b21 = k.b(EventProperty_ApplicationKt$IsBiometricProtectionEnabled$2.INSTANCE);
        IsBiometricProtectionEnabled$delegate = b21;
        b22 = k.b(EventProperty_ApplicationKt$SwapEnabled$2.INSTANCE);
        SwapEnabled$delegate = b22;
        b23 = k.b(EventProperty_ApplicationKt$Type$2.INSTANCE);
        Type$delegate = b23;
        b24 = k.b(EventProperty_ApplicationKt$AmountBase$2.INSTANCE);
        AmountBase$delegate = b24;
        b25 = k.b(EventProperty_ApplicationKt$SwapAggregatorID$2.INSTANCE);
        SwapAggregatorID$delegate = b25;
        b26 = k.b(EventProperty_ApplicationKt$SwapFromAsset$2.INSTANCE);
        SwapFromAsset$delegate = b26;
        b27 = k.b(EventProperty_ApplicationKt$SwapToAsset$2.INSTANCE);
        SwapToAsset$delegate = b27;
        b28 = k.b(EventProperty_ApplicationKt$SwapFromAssetContractAddress$2.INSTANCE);
        SwapFromAssetContractAddress$delegate = b28;
        b29 = k.b(EventProperty_ApplicationKt$SwapToAssetContractAddress$2.INSTANCE);
        SwapToAssetContractAddress$delegate = b29;
        b30 = k.b(EventProperty_ApplicationKt$SwapFromAssetAmount$2.INSTANCE);
        SwapFromAssetAmount$delegate = b30;
        b31 = k.b(EventProperty_ApplicationKt$SwapFromAssetFiatAmount$2.INSTANCE);
        SwapFromAssetFiatAmount$delegate = b31;
        b32 = k.b(EventProperty_ApplicationKt$SwapToAssetAmount$2.INSTANCE);
        SwapToAssetAmount$delegate = b32;
        b33 = k.b(EventProperty_ApplicationKt$SwapFeeAmount$2.INSTANCE);
        SwapFeeAmount$delegate = b33;
        b34 = k.b(EventProperty_ApplicationKt$PresetName$2.INSTANCE);
        PresetName$delegate = b34;
        b35 = k.b(EventProperty_ApplicationKt$GasPriceChangeDirection$2.INSTANCE);
        GasPriceChangeDirection$delegate = b35;
        b36 = k.b(EventProperty_ApplicationKt$GasLimitChangeDirection$2.INSTANCE);
        GasLimitChangeDirection$delegate = b36;
        b37 = k.b(EventProperty_ApplicationKt$IsNonceChanged$2.INSTANCE);
        IsNonceChanged$delegate = b37;
        b38 = k.b(EventProperty_ApplicationKt$NonceChangeDirection$2.INSTANCE);
        NonceChangeDirection$delegate = b38;
        b39 = k.b(EventProperty_ApplicationKt$ErrorMessage$2.INSTANCE);
        ErrorMessage$delegate = b39;
        b40 = k.b(EventProperty_ApplicationKt$ChainId$2.INSTANCE);
        ChainId$delegate = b40;
        b41 = k.b(EventProperty_ApplicationKt$ChainName$2.INSTANCE);
        ChainName$delegate = b41;
        b42 = k.b(EventProperty_ApplicationKt$FlowName$2.INSTANCE);
        FlowName$delegate = b42;
        b43 = k.b(EventProperty_ApplicationKt$CurrencyCode$2.INSTANCE);
        CurrencyCode$delegate = b43;
        b44 = k.b(EventProperty_ApplicationKt$SlowPrice$2.INSTANCE);
        SlowPrice$delegate = b44;
        b45 = k.b(EventProperty_ApplicationKt$NormalPrice$2.INSTANCE);
        NormalPrice$delegate = b45;
        b46 = k.b(EventProperty_ApplicationKt$FastPrice$2.INSTANCE);
        FastPrice$delegate = b46;
        b47 = k.b(EventProperty_ApplicationKt$GasLimit$2.INSTANCE);
        GasLimit$delegate = b47;
    }

    public static final EventProperty getAmountBase(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) AmountBase$delegate.getValue();
    }

    public static final EventProperty getAmountType(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) AmountType$delegate.getValue();
    }

    public static final EventProperty getBackupService(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) BackupService$delegate.getValue();
    }

    public static final EventProperty getCategories(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) Categories$delegate.getValue();
    }

    public static final EventProperty getChainId(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) ChainId$delegate.getValue();
    }

    public static final EventProperty getChainName(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) ChainName$delegate.getValue();
    }

    public static final EventProperty getCoinName(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) CoinName$delegate.getValue();
    }

    public static final EventProperty getCollectibleType(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) CollectibleType$delegate.getValue();
    }

    public static final EventProperty getCurrencyCode(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) CurrencyCode$delegate.getValue();
    }

    public static final EventProperty getDappIcon(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) DappIcon$delegate.getValue();
    }

    public static final EventProperty getDappName(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) DappName$delegate.getValue();
    }

    public static final EventProperty getDappUrl(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) DappUrl$delegate.getValue();
    }

    public static final EventProperty getDomainResultsMatched(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) DomainResultsMatched$delegate.getValue();
    }

    public static final EventProperty getDomainSource(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) DomainSource$delegate.getValue();
    }

    public static final EventProperty getErrorMessage(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) ErrorMessage$delegate.getValue();
    }

    public static final EventProperty getFastPrice(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) FastPrice$delegate.getValue();
    }

    public static final EventProperty getFlowName(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) FlowName$delegate.getValue();
    }

    public static final EventProperty getGasLimit(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) GasLimit$delegate.getValue();
    }

    public static final EventProperty getGasLimitChangeDirection(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) GasLimitChangeDirection$delegate.getValue();
    }

    public static final EventProperty getGasPriceChangeDirection(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) GasPriceChangeDirection$delegate.getValue();
    }

    public static final EventProperty getIsBiometricProtectionEnabled(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) IsBiometricProtectionEnabled$delegate.getValue();
    }

    public static final EventProperty getIsNonceChanged(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) IsNonceChanged$delegate.getValue();
    }

    public static final EventProperty getNetworkIsTestNet(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) NetworkIsTestNet$delegate.getValue();
    }

    public static final EventProperty getNetworkName(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) NetworkName$delegate.getValue();
    }

    public static final EventProperty getNonceChangeDirection(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) NonceChangeDirection$delegate.getValue();
    }

    public static final EventProperty getNormalPrice(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) NormalPrice$delegate.getValue();
    }

    public static final EventProperty getPresetName(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) PresetName$delegate.getValue();
    }

    public static final EventProperty getQueryLength(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) QueryLength$delegate.getValue();
    }

    public static final EventProperty getRecipientType(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) RecipientType$delegate.getValue();
    }

    public static final EventProperty getSendAmount(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) SendAmount$delegate.getValue();
    }

    public static final EventProperty getSendCount(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) SendCount$delegate.getValue();
    }

    public static final EventProperty getSlowPrice(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) SlowPrice$delegate.getValue();
    }

    public static final EventProperty getState(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) State$delegate.getValue();
    }

    public static final EventProperty getSwapAggregatorID(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) SwapAggregatorID$delegate.getValue();
    }

    public static final EventProperty getSwapEnabled(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) SwapEnabled$delegate.getValue();
    }

    public static final EventProperty getSwapFeeAmount(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) SwapFeeAmount$delegate.getValue();
    }

    public static final EventProperty getSwapFromAsset(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) SwapFromAsset$delegate.getValue();
    }

    public static final EventProperty getSwapFromAssetAmount(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) SwapFromAssetAmount$delegate.getValue();
    }

    public static final EventProperty getSwapFromAssetContractAddress(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) SwapFromAssetContractAddress$delegate.getValue();
    }

    public static final EventProperty getSwapFromAssetFiatAmount(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) SwapFromAssetFiatAmount$delegate.getValue();
    }

    public static final EventProperty getSwapToAsset(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) SwapToAsset$delegate.getValue();
    }

    public static final EventProperty getSwapToAssetAmount(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) SwapToAssetAmount$delegate.getValue();
    }

    public static final EventProperty getSwapToAssetContractAddress(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) SwapToAssetContractAddress$delegate.getValue();
    }

    public static final EventProperty getTopLevelDomain(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) TopLevelDomain$delegate.getValue();
    }

    public static final EventProperty getType(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) Type$delegate.getValue();
    }

    public static final EventProperty getWalletNumber(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) WalletNumber$delegate.getValue();
    }
}