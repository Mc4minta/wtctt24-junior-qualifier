package com.coinbase.wallet.features.send.models;

import com.coinbase.ApiConstants;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: AdjustableMinerFee1559ViewInfoState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010&\u001a\u00020\r\u0012\b\b\u0002\u0010\u001f\u001a\u00020\r\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b,\u0010-R\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\f\u0010\u000bR\u001c\u0010\u000e\u001a\u00020\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0017\u001a\u00020\u00168\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001b\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u00020\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011R\u0019\u0010\"\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u00020\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010\u000f\u001a\u0004\b'\u0010\u0011R\u001e\u0010(\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006R\u001e\u0010*\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006¨\u0006."}, d2 = {"Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559CustomViewInfoState;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewInfoState;", "", "warningMessage", "Ljava/lang/String;", "getWarningMessage", "()Ljava/lang/String;", "", "dataLoaded", "Z", "getDataLoaded", "()Z", "isValid", "Ljava/math/BigInteger;", "maxFeePerGas", "Ljava/math/BigInteger;", "getMaxFeePerGas", "()Ljava/math/BigInteger;", "maxFeePerGasString", "getMaxFeePerGasString", ApiConstants.NAME, "getName", "Lcom/coinbase/wallet/features/send/models/PresetSpeed;", "presetSpeed", "Lcom/coinbase/wallet/features/send/models/PresetSpeed;", "getPresetSpeed", "()Lcom/coinbase/wallet/features/send/models/PresetSpeed;", "gasLimit", "getGasLimit", "priorityFeeString", "getPriorityFeeString", "priorityFee", "getPriorityFee", "", AdjustableMinerFeeArgs.NONCE, "I", "getNonce", "()I", "baseFeePerGas", "getBaseFeePerGas", "fiatRangeString", "getFiatRangeString", "cryptoRangeString", "getCryptoRangeString", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/features/send/models/PresetSpeed;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/math/BigInteger;Ljava/lang/String;IZ)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFee1559CustomViewInfoState extends AdjustableMinerFee1559ViewInfoState {
    private final BigInteger baseFeePerGas;
    private final String cryptoRangeString;
    private final boolean dataLoaded;
    private final String fiatRangeString;
    private final BigInteger gasLimit;
    private final boolean isValid;
    private final BigInteger maxFeePerGas;
    private final String maxFeePerGasString;
    private final String name;
    private final int nonce;
    private final PresetSpeed presetSpeed;
    private final BigInteger priorityFee;
    private final String priorityFeeString;
    private final String warningMessage;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ AdjustableMinerFee1559CustomViewInfoState(java.lang.String r19, com.coinbase.wallet.features.send.models.PresetSpeed r20, java.math.BigInteger r21, java.math.BigInteger r22, java.math.BigInteger r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, boolean r28, java.math.BigInteger r29, java.lang.String r30, int r31, boolean r32, int r33, kotlin.jvm.internal.DefaultConstructorMarker r34) {
        /*
            r18 = this;
            r0 = r33
            r1 = r0 & 4
            java.lang.String r2 = "ZERO"
            if (r1 == 0) goto Lf
            java.math.BigInteger r1 = java.math.BigInteger.ZERO
            kotlin.jvm.internal.m.f(r1, r2)
            r6 = r1
            goto L11
        Lf:
            r6 = r21
        L11:
            r1 = r0 & 8
            if (r1 == 0) goto L1c
            java.math.BigInteger r1 = java.math.BigInteger.ZERO
            kotlin.jvm.internal.m.f(r1, r2)
            r7 = r1
            goto L1e
        L1c:
            r7 = r22
        L1e:
            r1 = r0 & 16
            if (r1 == 0) goto L29
            java.math.BigInteger r1 = java.math.BigInteger.ZERO
            kotlin.jvm.internal.m.f(r1, r2)
            r8 = r1
            goto L2b
        L29:
            r8 = r23
        L2b:
            r1 = r0 & 32
            r3 = 0
            if (r1 == 0) goto L32
            r9 = r3
            goto L34
        L32:
            r9 = r24
        L34:
            r1 = r0 & 64
            if (r1 == 0) goto L3a
            r10 = r3
            goto L3c
        L3a:
            r10 = r25
        L3c:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L42
            r11 = r3
            goto L44
        L42:
            r11 = r26
        L44:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L4a
            r12 = r3
            goto L4c
        L4a:
            r12 = r27
        L4c:
            r1 = r0 & 512(0x200, float:7.17E-43)
            r4 = 1
            if (r1 == 0) goto L53
            r13 = r4
            goto L55
        L53:
            r13 = r28
        L55:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L60
            java.math.BigInteger r1 = java.math.BigInteger.ZERO
            kotlin.jvm.internal.m.f(r1, r2)
            r14 = r1
            goto L62
        L60:
            r14 = r29
        L62:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L68
            r15 = r3
            goto L6a
        L68:
            r15 = r30
        L6a:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L72
            r1 = 0
            r16 = r1
            goto L74
        L72:
            r16 = r31
        L74:
            r0 = r0 & 8192(0x2000, float:1.148E-41)
            if (r0 == 0) goto L7b
            r17 = r4
            goto L7d
        L7b:
            r17 = r32
        L7d:
            r3 = r18
            r4 = r19
            r5 = r20
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.send.models.AdjustableMinerFee1559CustomViewInfoState.<init>(java.lang.String, com.coinbase.wallet.features.send.models.PresetSpeed, java.math.BigInteger, java.math.BigInteger, java.math.BigInteger, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.math.BigInteger, java.lang.String, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // com.coinbase.wallet.features.send.models.AdjustableMinerFee1559ViewInfoState
    public BigInteger getBaseFeePerGas() {
        return this.baseFeePerGas;
    }

    @Override // com.coinbase.wallet.features.send.models.AdjustableMinerFee1559ViewInfoState
    public String getCryptoRangeString() {
        return this.cryptoRangeString;
    }

    @Override // com.coinbase.wallet.features.send.models.AdjustableMinerFee1559ViewInfoState
    public boolean getDataLoaded() {
        return this.dataLoaded;
    }

    @Override // com.coinbase.wallet.features.send.models.AdjustableMinerFee1559ViewInfoState
    public String getFiatRangeString() {
        return this.fiatRangeString;
    }

    public final BigInteger getGasLimit() {
        return this.gasLimit;
    }

    @Override // com.coinbase.wallet.features.send.models.AdjustableMinerFee1559ViewInfoState
    public BigInteger getMaxFeePerGas() {
        return this.maxFeePerGas;
    }

    @Override // com.coinbase.wallet.features.send.models.AdjustableMinerFee1559ViewInfoState
    public String getMaxFeePerGasString() {
        return this.maxFeePerGasString;
    }

    @Override // com.coinbase.wallet.features.send.models.AdjustableMinerFee1559ViewInfoState
    public String getName() {
        return this.name;
    }

    public final int getNonce() {
        return this.nonce;
    }

    @Override // com.coinbase.wallet.features.send.models.AdjustableMinerFee1559ViewInfoState
    public PresetSpeed getPresetSpeed() {
        return this.presetSpeed;
    }

    @Override // com.coinbase.wallet.features.send.models.AdjustableMinerFee1559ViewInfoState
    public BigInteger getPriorityFee() {
        return this.priorityFee;
    }

    @Override // com.coinbase.wallet.features.send.models.AdjustableMinerFee1559ViewInfoState
    public String getPriorityFeeString() {
        return this.priorityFeeString;
    }

    public final String getWarningMessage() {
        return this.warningMessage;
    }

    public final boolean isValid() {
        return this.isValid;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdjustableMinerFee1559CustomViewInfoState(String name, PresetSpeed presetSpeed, BigInteger maxFeePerGas, BigInteger baseFeePerGas, BigInteger priorityFee, String str, String str2, String str3, String str4, boolean z, BigInteger gasLimit, String str5, int i2, boolean z2) {
        super(name, presetSpeed, null, maxFeePerGas, baseFeePerGas, priorityFee, str, str2, str3, str4, z, 4, null);
        m.g(name, "name");
        m.g(presetSpeed, "presetSpeed");
        m.g(maxFeePerGas, "maxFeePerGas");
        m.g(baseFeePerGas, "baseFeePerGas");
        m.g(priorityFee, "priorityFee");
        m.g(gasLimit, "gasLimit");
        this.name = name;
        this.presetSpeed = presetSpeed;
        this.maxFeePerGas = maxFeePerGas;
        this.baseFeePerGas = baseFeePerGas;
        this.priorityFee = priorityFee;
        this.fiatRangeString = str;
        this.cryptoRangeString = str2;
        this.maxFeePerGasString = str3;
        this.priorityFeeString = str4;
        this.dataLoaded = z;
        this.gasLimit = gasLimit;
        this.warningMessage = str5;
        this.nonce = i2;
        this.isValid = z2;
    }
}