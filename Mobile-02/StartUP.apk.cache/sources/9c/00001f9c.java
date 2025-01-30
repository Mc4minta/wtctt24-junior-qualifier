package com.coinbase.wallet.features.send.models;

import f.c.d;
import java.math.BigInteger;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AdjustableMinerFee1559ViewInfoState_Factory implements d<AdjustableMinerFee1559ViewInfoState> {
    private final Provider<BigInteger> baseFeePerGasProvider;
    private final Provider<String> cryptoRangeStringProvider;
    private final Provider<Boolean> dataLoadedProvider;
    private final Provider<String> fiatRangeStringProvider;
    private final Provider<BigInteger> maxFeePerGasProvider;
    private final Provider<String> maxFeePerGasStringProvider;
    private final Provider<String> nameProvider;
    private final Provider<PresetSpeed> presetSpeedProvider;
    private final Provider<BigInteger> priorityFeeProvider;
    private final Provider<String> priorityFeeStringProvider;
    private final Provider<String> waitTimeProvider;

    public AdjustableMinerFee1559ViewInfoState_Factory(Provider<String> provider, Provider<PresetSpeed> provider2, Provider<String> provider3, Provider<BigInteger> provider4, Provider<BigInteger> provider5, Provider<BigInteger> provider6, Provider<String> provider7, Provider<String> provider8, Provider<String> provider9, Provider<String> provider10, Provider<Boolean> provider11) {
        this.nameProvider = provider;
        this.presetSpeedProvider = provider2;
        this.waitTimeProvider = provider3;
        this.maxFeePerGasProvider = provider4;
        this.baseFeePerGasProvider = provider5;
        this.priorityFeeProvider = provider6;
        this.fiatRangeStringProvider = provider7;
        this.cryptoRangeStringProvider = provider8;
        this.maxFeePerGasStringProvider = provider9;
        this.priorityFeeStringProvider = provider10;
        this.dataLoadedProvider = provider11;
    }

    public static AdjustableMinerFee1559ViewInfoState_Factory create(Provider<String> provider, Provider<PresetSpeed> provider2, Provider<String> provider3, Provider<BigInteger> provider4, Provider<BigInteger> provider5, Provider<BigInteger> provider6, Provider<String> provider7, Provider<String> provider8, Provider<String> provider9, Provider<String> provider10, Provider<Boolean> provider11) {
        return new AdjustableMinerFee1559ViewInfoState_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static AdjustableMinerFee1559ViewInfoState newInstance(String str, PresetSpeed presetSpeed, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, String str3, String str4, String str5, String str6, boolean z) {
        return new AdjustableMinerFee1559ViewInfoState(str, presetSpeed, str2, bigInteger, bigInteger2, bigInteger3, str3, str4, str5, str6, z);
    }

    @Override // javax.inject.Provider
    public AdjustableMinerFee1559ViewInfoState get() {
        return newInstance(this.nameProvider.get(), this.presetSpeedProvider.get(), this.waitTimeProvider.get(), this.maxFeePerGasProvider.get(), this.baseFeePerGasProvider.get(), this.priorityFeeProvider.get(), this.fiatRangeStringProvider.get(), this.cryptoRangeStringProvider.get(), this.maxFeePerGasStringProvider.get(), this.priorityFeeStringProvider.get(), this.dataLoadedProvider.get().booleanValue());
    }
}