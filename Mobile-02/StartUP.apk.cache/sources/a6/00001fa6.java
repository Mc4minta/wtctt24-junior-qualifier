package com.coinbase.wallet.features.send.models;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.toshi.R;

/* compiled from: AdjustableMinerFeeViewInfoState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u0000 $2\u00020\u0001:\u0001$B[\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\"\u0010#R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\n\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u00020\u00148\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001c\u001a\u00020\u001b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006¨\u0006%"}, d2 = {"Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewInfoState;", "", "", "cryptoFee", "Ljava/lang/String;", "getCryptoFee", "()Ljava/lang/String;", "", "getIcon", "()I", "icon", "gasString", "getGasString", ApiConstants.NAME, "getName", "Lcom/coinbase/wallet/features/send/models/PresetSpeed;", "presetSpeed", "Lcom/coinbase/wallet/features/send/models/PresetSpeed;", "getPresetSpeed", "()Lcom/coinbase/wallet/features/send/models/PresetSpeed;", "Ljava/math/BigInteger;", "gasPrice", "Ljava/math/BigInteger;", "getGasPrice", "()Ljava/math/BigInteger;", "fiatFee", "getFiatFee", "", "dataLoaded", "Z", "getDataLoaded", "()Z", "waitTime", "getWaitTime", "<init>", "(Ljava/lang/String;Ljava/math/BigInteger;Ljava/lang/String;Lcom/coinbase/wallet/features/send/models/PresetSpeed;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public class AdjustableMinerFeeViewInfoState {
    public static final Companion Companion = new Companion(null);
    private final String cryptoFee;
    private final boolean dataLoaded;
    private final String fiatFee;
    private final BigInteger gasPrice;
    private final String gasString;
    private final String name;
    private final PresetSpeed presetSpeed;
    private final String waitTime;

    /* compiled from: AdjustableMinerFeeViewInfoState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewInfoState$Companion;", "", "Lcom/coinbase/wallet/features/send/models/PresetSpeed;", "preset", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewInfoState;", "loading", "(Lcom/coinbase/wallet/features/send/models/PresetSpeed;)Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewInfoState;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {

        /* compiled from: AdjustableMinerFeeViewInfoState.kt */
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

        public final AdjustableMinerFeeViewInfoState loading(PresetSpeed preset) {
            m.g(preset, "preset");
            int i2 = WhenMappings.$EnumSwitchMapping$0[preset.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            return new AdjustableMinerFeeViewInfoState(LocalizedStrings.INSTANCE.get(R.string.fast), null, null, PresetSpeed.FAST, null, null, null, false, 118, null);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return new AdjustableMinerFeeViewInfoState(LocalizedStrings.INSTANCE.get(R.string.normal), null, null, PresetSpeed.NORMAL, null, null, null, false, 118, null);
                }
                return new AdjustableMinerFeeViewInfoState(LocalizedStrings.INSTANCE.get(R.string.slow), null, null, PresetSpeed.SLOW, null, null, null, false, 118, null);
            }
            return new AdjustableMinerFeeCustomViewInfoState(LocalizedStrings.INSTANCE.get(R.string.custom), null, null, PresetSpeed.CUSTOM, null, null, null, false, null, null, 0, false, 3958, null);
        }
    }

    /* compiled from: AdjustableMinerFeeViewInfoState.kt */
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

    public AdjustableMinerFeeViewInfoState(String name, BigInteger gasPrice, String str, PresetSpeed presetSpeed, String str2, String str3, String str4, boolean z) {
        m.g(name, "name");
        m.g(gasPrice, "gasPrice");
        m.g(presetSpeed, "presetSpeed");
        this.name = name;
        this.gasPrice = gasPrice;
        this.waitTime = str;
        this.presetSpeed = presetSpeed;
        this.fiatFee = str2;
        this.cryptoFee = str3;
        this.gasString = str4;
        this.dataLoaded = z;
    }

    public String getCryptoFee() {
        return this.cryptoFee;
    }

    public boolean getDataLoaded() {
        return this.dataLoaded;
    }

    public String getFiatFee() {
        return this.fiatFee;
    }

    public BigInteger getGasPrice() {
        return this.gasPrice;
    }

    public String getGasString() {
        return this.gasString;
    }

    public final int getIcon() {
        int i2 = WhenMappings.$EnumSwitchMapping$0[getPresetSpeed().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        return R.drawable.ic_adjustable_gas_fast;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return R.drawable.ic_adjustable_gas_normal;
            }
            return R.drawable.ic_adjustable_gas_slow;
        }
        return R.drawable.ic_adjustable_gas_custom;
    }

    public String getName() {
        return this.name;
    }

    public PresetSpeed getPresetSpeed() {
        return this.presetSpeed;
    }

    public String getWaitTime() {
        return this.waitTime;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ AdjustableMinerFeeViewInfoState(java.lang.String r13, java.math.BigInteger r14, java.lang.String r15, com.coinbase.wallet.features.send.models.PresetSpeed r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, boolean r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 2
            if (r1 == 0) goto Lf
            java.math.BigInteger r1 = java.math.BigInteger.ZERO
            java.lang.String r2 = "ZERO"
            kotlin.jvm.internal.m.f(r1, r2)
            r5 = r1
            goto L10
        Lf:
            r5 = r14
        L10:
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L17
            r6 = r2
            goto L18
        L17:
            r6 = r15
        L18:
            r1 = r0 & 16
            if (r1 == 0) goto L1e
            r8 = r2
            goto L20
        L1e:
            r8 = r17
        L20:
            r1 = r0 & 32
            if (r1 == 0) goto L26
            r9 = r2
            goto L28
        L26:
            r9 = r18
        L28:
            r1 = r0 & 64
            if (r1 == 0) goto L2e
            r10 = r2
            goto L30
        L2e:
            r10 = r19
        L30:
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L37
            r0 = 1
            r11 = r0
            goto L39
        L37:
            r11 = r20
        L39:
            r3 = r12
            r4 = r13
            r7 = r16
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.send.models.AdjustableMinerFeeViewInfoState.<init>(java.lang.String, java.math.BigInteger, java.lang.String, com.coinbase.wallet.features.send.models.PresetSpeed, java.lang.String, java.lang.String, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}