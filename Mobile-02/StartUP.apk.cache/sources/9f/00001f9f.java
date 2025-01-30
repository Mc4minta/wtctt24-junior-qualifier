package com.coinbase.wallet.features.send.models;

import com.coinbase.ApiConstants;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: AdjustableMinerFeeViewInfoState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\b\b\u0002\u0010 \u001a\u00020\u0015¢\u0006\u0004\b(\u0010)R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u00020\u000e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u00158\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u0019\u0010\u001e\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012R\u0019\u0010 \u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0017\u001a\u0004\b \u0010\u0019R\u001b\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u0019\u0010$\u001a\u00020#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeCustomViewInfoState;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewInfoState;", "", "gasString", "Ljava/lang/String;", "getGasString", "()Ljava/lang/String;", "cryptoFee", "getCryptoFee", "Lcom/coinbase/wallet/features/send/models/PresetSpeed;", "presetSpeed", "Lcom/coinbase/wallet/features/send/models/PresetSpeed;", "getPresetSpeed", "()Lcom/coinbase/wallet/features/send/models/PresetSpeed;", "Ljava/math/BigInteger;", "gasPrice", "Ljava/math/BigInteger;", "getGasPrice", "()Ljava/math/BigInteger;", "fiatFee", "getFiatFee", "", "dataLoaded", "Z", "getDataLoaded", "()Z", ApiConstants.NAME, "getName", "waitTime", "getWaitTime", "gasLimit", "getGasLimit", "isValid", "warningMessage", "getWarningMessage", "", AdjustableMinerFeeArgs.NONCE, "I", "getNonce", "()I", "<init>", "(Ljava/lang/String;Ljava/math/BigInteger;Ljava/lang/String;Lcom/coinbase/wallet/features/send/models/PresetSpeed;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/math/BigInteger;Ljava/lang/String;IZ)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFeeCustomViewInfoState extends AdjustableMinerFeeViewInfoState {
    private final String cryptoFee;
    private final boolean dataLoaded;
    private final String fiatFee;
    private final BigInteger gasLimit;
    private final BigInteger gasPrice;
    private final String gasString;
    private final boolean isValid;
    private final String name;
    private final int nonce;
    private final PresetSpeed presetSpeed;
    private final String waitTime;
    private final String warningMessage;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ AdjustableMinerFeeCustomViewInfoState(java.lang.String r17, java.math.BigInteger r18, java.lang.String r19, com.coinbase.wallet.features.send.models.PresetSpeed r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, boolean r24, java.math.BigInteger r25, java.lang.String r26, int r27, boolean r28, int r29, kotlin.jvm.internal.DefaultConstructorMarker r30) {
        /*
            r16 = this;
            r0 = r29
            r1 = r0 & 2
            java.lang.String r2 = "ZERO"
            if (r1 == 0) goto Lf
            java.math.BigInteger r1 = java.math.BigInteger.ZERO
            kotlin.jvm.internal.m.f(r1, r2)
            r5 = r1
            goto L11
        Lf:
            r5 = r18
        L11:
            r1 = r0 & 4
            r3 = 0
            if (r1 == 0) goto L18
            r6 = r3
            goto L1a
        L18:
            r6 = r19
        L1a:
            r1 = r0 & 16
            if (r1 == 0) goto L20
            r8 = r3
            goto L22
        L20:
            r8 = r21
        L22:
            r1 = r0 & 32
            if (r1 == 0) goto L28
            r9 = r3
            goto L2a
        L28:
            r9 = r22
        L2a:
            r1 = r0 & 64
            if (r1 == 0) goto L30
            r10 = r3
            goto L32
        L30:
            r10 = r23
        L32:
            r1 = r0 & 128(0x80, float:1.8E-43)
            r4 = 1
            if (r1 == 0) goto L39
            r11 = r4
            goto L3b
        L39:
            r11 = r24
        L3b:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L46
            java.math.BigInteger r1 = java.math.BigInteger.ZERO
            kotlin.jvm.internal.m.f(r1, r2)
            r12 = r1
            goto L48
        L46:
            r12 = r25
        L48:
            r1 = r0 & 512(0x200, float:7.17E-43)
            if (r1 == 0) goto L4e
            r13 = r3
            goto L50
        L4e:
            r13 = r26
        L50:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L57
            r1 = 0
            r14 = r1
            goto L59
        L57:
            r14 = r27
        L59:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L5f
            r15 = r4
            goto L61
        L5f:
            r15 = r28
        L61:
            r3 = r16
            r4 = r17
            r7 = r20
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.send.models.AdjustableMinerFeeCustomViewInfoState.<init>(java.lang.String, java.math.BigInteger, java.lang.String, com.coinbase.wallet.features.send.models.PresetSpeed, java.lang.String, java.lang.String, java.lang.String, boolean, java.math.BigInteger, java.lang.String, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // com.coinbase.wallet.features.send.models.AdjustableMinerFeeViewInfoState
    public String getCryptoFee() {
        return this.cryptoFee;
    }

    @Override // com.coinbase.wallet.features.send.models.AdjustableMinerFeeViewInfoState
    public boolean getDataLoaded() {
        return this.dataLoaded;
    }

    @Override // com.coinbase.wallet.features.send.models.AdjustableMinerFeeViewInfoState
    public String getFiatFee() {
        return this.fiatFee;
    }

    public final BigInteger getGasLimit() {
        return this.gasLimit;
    }

    @Override // com.coinbase.wallet.features.send.models.AdjustableMinerFeeViewInfoState
    public BigInteger getGasPrice() {
        return this.gasPrice;
    }

    @Override // com.coinbase.wallet.features.send.models.AdjustableMinerFeeViewInfoState
    public String getGasString() {
        return this.gasString;
    }

    @Override // com.coinbase.wallet.features.send.models.AdjustableMinerFeeViewInfoState
    public String getName() {
        return this.name;
    }

    public final int getNonce() {
        return this.nonce;
    }

    @Override // com.coinbase.wallet.features.send.models.AdjustableMinerFeeViewInfoState
    public PresetSpeed getPresetSpeed() {
        return this.presetSpeed;
    }

    @Override // com.coinbase.wallet.features.send.models.AdjustableMinerFeeViewInfoState
    public String getWaitTime() {
        return this.waitTime;
    }

    public final String getWarningMessage() {
        return this.warningMessage;
    }

    public final boolean isValid() {
        return this.isValid;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdjustableMinerFeeCustomViewInfoState(String name, BigInteger gasPrice, String str, PresetSpeed presetSpeed, String str2, String str3, String str4, boolean z, BigInteger gasLimit, String str5, int i2, boolean z2) {
        super(name, gasPrice, str, presetSpeed, str2, str3, str4, z);
        m.g(name, "name");
        m.g(gasPrice, "gasPrice");
        m.g(presetSpeed, "presetSpeed");
        m.g(gasLimit, "gasLimit");
        this.name = name;
        this.gasPrice = gasPrice;
        this.waitTime = str;
        this.presetSpeed = presetSpeed;
        this.fiatFee = str2;
        this.cryptoFee = str3;
        this.gasString = str4;
        this.dataLoaded = z;
        this.gasLimit = gasLimit;
        this.warningMessage = str5;
        this.nonce = i2;
        this.isValid = z2;
    }
}