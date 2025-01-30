package com.coinbase.wallet.features.send.models;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.toshi.R;

/* compiled from: AdjustableMinerFee1559ViewInfoState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001*B}\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\"\u001a\u00020\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b(\u0010)R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001c\u0010\u0015\u001a\u00020\u00148\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001e\u001a\u00020\u001d8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\rR\u0013\u0010'\u001a\u00020$8F@\u0006¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewInfoState;", "", "", ApiConstants.NAME, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "priorityFeeString", "getPriorityFeeString", "Ljava/math/BigInteger;", "maxFeePerGas", "Ljava/math/BigInteger;", "getMaxFeePerGas", "()Ljava/math/BigInteger;", "waitTime", "getWaitTime", "fiatRangeString", "getFiatRangeString", "baseFeePerGas", "getBaseFeePerGas", "", "dataLoaded", "Z", "getDataLoaded", "()Z", "cryptoRangeString", "getCryptoRangeString", "maxFeePerGasString", "getMaxFeePerGasString", "Lcom/coinbase/wallet/features/send/models/PresetSpeed;", "presetSpeed", "Lcom/coinbase/wallet/features/send/models/PresetSpeed;", "getPresetSpeed", "()Lcom/coinbase/wallet/features/send/models/PresetSpeed;", "priorityFee", "getPriorityFee", "", "getIcon", "()I", "icon", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/features/send/models/PresetSpeed;Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public class AdjustableMinerFee1559ViewInfoState {
    public static final Companion Companion = new Companion(null);
    private final BigInteger baseFeePerGas;
    private final String cryptoRangeString;
    private final boolean dataLoaded;
    private final String fiatRangeString;
    private final BigInteger maxFeePerGas;
    private final String maxFeePerGasString;
    private final String name;
    private final PresetSpeed presetSpeed;
    private final BigInteger priorityFee;
    private final String priorityFeeString;
    private final String waitTime;

    /* compiled from: AdjustableMinerFee1559ViewInfoState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewInfoState$Companion;", "", "Lcom/coinbase/wallet/features/send/models/PresetSpeed;", "preset", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewInfoState;", "loading", "(Lcom/coinbase/wallet/features/send/models/PresetSpeed;)Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewInfoState;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {

        /* compiled from: AdjustableMinerFee1559ViewInfoState.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PresetSpeed.values().length];
                iArr[PresetSpeed.CUSTOM.ordinal()] = 1;
                iArr[PresetSpeed.SLOW.ordinal()] = 2;
                iArr[PresetSpeed.NORMAL.ordinal()] = 3;
                iArr[PresetSpeed.FAST.ordinal()] = 4;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AdjustableMinerFee1559ViewInfoState loading(PresetSpeed preset) {
            m.g(preset, "preset");
            int i2 = WhenMappings.$EnumSwitchMapping$0[preset.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            return new AdjustableMinerFee1559ViewInfoState(LocalizedStrings.INSTANCE.get(R.string.fast), PresetSpeed.FAST, null, null, null, null, null, null, null, null, false, 1020, null);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return new AdjustableMinerFee1559ViewInfoState(LocalizedStrings.INSTANCE.get(R.string.normal), PresetSpeed.NORMAL, null, null, null, null, null, null, null, null, false, 1020, null);
                }
                return new AdjustableMinerFee1559ViewInfoState(LocalizedStrings.INSTANCE.get(R.string.slow), PresetSpeed.SLOW, null, null, null, null, null, null, null, null, false, 1020, null);
            }
            return new AdjustableMinerFee1559CustomViewInfoState(LocalizedStrings.INSTANCE.get(R.string.custom), PresetSpeed.CUSTOM, null, null, null, null, null, null, null, false, null, null, 0, false, 15868, null);
        }
    }

    /* compiled from: AdjustableMinerFee1559ViewInfoState.kt */
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

    public AdjustableMinerFee1559ViewInfoState(String name, PresetSpeed presetSpeed, String str, BigInteger maxFeePerGas, BigInteger baseFeePerGas, BigInteger priorityFee, String str2, String str3, String str4, String str5, boolean z) {
        m.g(name, "name");
        m.g(presetSpeed, "presetSpeed");
        m.g(maxFeePerGas, "maxFeePerGas");
        m.g(baseFeePerGas, "baseFeePerGas");
        m.g(priorityFee, "priorityFee");
        this.name = name;
        this.presetSpeed = presetSpeed;
        this.waitTime = str;
        this.maxFeePerGas = maxFeePerGas;
        this.baseFeePerGas = baseFeePerGas;
        this.priorityFee = priorityFee;
        this.fiatRangeString = str2;
        this.cryptoRangeString = str3;
        this.maxFeePerGasString = str4;
        this.priorityFeeString = str5;
        this.dataLoaded = z;
    }

    public BigInteger getBaseFeePerGas() {
        return this.baseFeePerGas;
    }

    public String getCryptoRangeString() {
        return this.cryptoRangeString;
    }

    public boolean getDataLoaded() {
        return this.dataLoaded;
    }

    public String getFiatRangeString() {
        return this.fiatRangeString;
    }

    public final int getIcon() {
        int i2 = WhenMappings.$EnumSwitchMapping$0[getPresetSpeed().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        return R.drawable.ic_adjustable_gas_custom;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return R.drawable.ic_adjustable_gas_fast;
            }
            return R.drawable.ic_adjustable_gas_normal;
        }
        return R.drawable.ic_adjustable_gas_slow;
    }

    public BigInteger getMaxFeePerGas() {
        return this.maxFeePerGas;
    }

    public String getMaxFeePerGasString() {
        return this.maxFeePerGasString;
    }

    public String getName() {
        return this.name;
    }

    public PresetSpeed getPresetSpeed() {
        return this.presetSpeed;
    }

    public BigInteger getPriorityFee() {
        return this.priorityFee;
    }

    public String getPriorityFeeString() {
        return this.priorityFeeString;
    }

    public String getWaitTime() {
        return this.waitTime;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ AdjustableMinerFee1559ViewInfoState(java.lang.String r16, com.coinbase.wallet.features.send.models.PresetSpeed r17, java.lang.String r18, java.math.BigInteger r19, java.math.BigInteger r20, java.math.BigInteger r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, boolean r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r15 = this;
            r0 = r27
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L9
            r6 = r2
            goto Lb
        L9:
            r6 = r18
        Lb:
            r1 = r0 & 8
            java.lang.String r3 = "ZERO"
            if (r1 == 0) goto L18
            java.math.BigInteger r1 = java.math.BigInteger.ZERO
            kotlin.jvm.internal.m.f(r1, r3)
            r7 = r1
            goto L1a
        L18:
            r7 = r19
        L1a:
            r1 = r0 & 16
            if (r1 == 0) goto L25
            java.math.BigInteger r1 = java.math.BigInteger.ZERO
            kotlin.jvm.internal.m.f(r1, r3)
            r8 = r1
            goto L27
        L25:
            r8 = r20
        L27:
            r1 = r0 & 32
            if (r1 == 0) goto L32
            java.math.BigInteger r1 = java.math.BigInteger.ZERO
            kotlin.jvm.internal.m.f(r1, r3)
            r9 = r1
            goto L34
        L32:
            r9 = r21
        L34:
            r1 = r0 & 64
            if (r1 == 0) goto L3a
            r10 = r2
            goto L3c
        L3a:
            r10 = r22
        L3c:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L42
            r11 = r2
            goto L44
        L42:
            r11 = r23
        L44:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L4a
            r12 = r2
            goto L4c
        L4a:
            r12 = r24
        L4c:
            r1 = r0 & 512(0x200, float:7.17E-43)
            if (r1 == 0) goto L52
            r13 = r2
            goto L54
        L52:
            r13 = r25
        L54:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L5b
            r0 = 1
            r14 = r0
            goto L5d
        L5b:
            r14 = r26
        L5d:
            r3 = r15
            r4 = r16
            r5 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.send.models.AdjustableMinerFee1559ViewInfoState.<init>(java.lang.String, com.coinbase.wallet.features.send.models.PresetSpeed, java.lang.String, java.math.BigInteger, java.math.BigInteger, java.math.BigInteger, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}