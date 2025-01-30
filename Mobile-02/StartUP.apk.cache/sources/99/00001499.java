package com.coinbase.wallet.commonui.extensions;

import com.coinbase.wallet.common.utilities.Locales;
import com.coinbase.wallet.commonui.extensions.RawStringResult;
import com.coinbase.wallet.commonui.views.NumberKeyboardDigit;
import com.coinbase.wallet.commonui.views.NumberKeyboardInputView;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.p;
import kotlin.a0.r;
import kotlin.a0.w;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.l0.a0;

/* compiled from: NumberKeyboardInputView+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u001a+\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001a3\u0010\f\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\r\u001a=\u0010\u0010\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a-\u0010\u0014\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/commonui/views/NumberKeyboardInputView$Companion;", "", "currentAmountString", "Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;", "digit", "", "longPress", "Lcom/coinbase/wallet/commonui/extensions/RawStringResult;", "getUpdatedFiatAmount", "(Lcom/coinbase/wallet/commonui/views/NumberKeyboardInputView$Companion;Ljava/lang/String;Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;Z)Lcom/coinbase/wallet/commonui/extensions/RawStringResult;", "", "maximumFractionDigits", "getUpdatedCryptoAmount", "(Lcom/coinbase/wallet/commonui/views/NumberKeyboardInputView$Companion;Ljava/lang/String;Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;IZ)Lcom/coinbase/wallet/commonui/extensions/RawStringResult;", "", "separator", "getUpdatedAmount", "(Lcom/coinbase/wallet/commonui/views/NumberKeyboardInputView$Companion;Ljava/lang/String;Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;IZC)Lcom/coinbase/wallet/commonui/extensions/RawStringResult;", "", "rawAmount", "isValidEntry", "(Ljava/util/List;IC)Z", "commonui_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class NumberKeyboardInputView_CommonKt {

    /* compiled from: NumberKeyboardInputView+Common.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NumberKeyboardDigit.values().length];
            iArr[NumberKeyboardDigit.DecimalSeparator.ordinal()] = 1;
            iArr[NumberKeyboardDigit.Zero.ordinal()] = 2;
            iArr[NumberKeyboardDigit.Delete.ordinal()] = 3;
            iArr[NumberKeyboardDigit.GroupSeparator.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final RawStringResult getUpdatedAmount(NumberKeyboardInputView.Companion companion, String str, NumberKeyboardDigit numberKeyboardDigit, int i2, boolean z, char c2) {
        List<Character> w1;
        char p1;
        String h0;
        char p12;
        char p13;
        int i3;
        char p14;
        char p15;
        w1 = a0.w1(str);
        w.D(w1, new NumberKeyboardInputView_CommonKt$getUpdatedAmount$1(c2));
        int i4 = WhenMappings.$EnumSwitchMapping$0[numberKeyboardDigit.ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                if (w1.size() == 1) {
                    char charValue = ((Character) p.Y(w1)).charValue();
                    p13 = a0.p1(numberKeyboardDigit.getDescription());
                    if (charValue == p13) {
                        return RawStringResult.Error.INSTANCE;
                    }
                }
                if (!isValidEntry(w1, i2, c2)) {
                    return RawStringResult.Error.INSTANCE;
                }
                p12 = a0.p1(numberKeyboardDigit.getDescription());
                w1.add(Character.valueOf(p12));
            } else if (i4 != 3) {
                if (i4 != 4) {
                    if (w1.size() == 1) {
                        char charValue2 = ((Character) p.Y(w1)).charValue();
                        p15 = a0.p1(NumberKeyboardDigit.Zero.getDescription());
                        if (charValue2 == p15) {
                            w1.clear();
                        }
                    }
                    if (isValidEntry(w1, i2, c2)) {
                        p14 = a0.p1(numberKeyboardDigit.getDescription());
                        w1.add(Character.valueOf(p14));
                    } else {
                        return RawStringResult.Error.INSTANCE;
                    }
                } else {
                    return RawStringResult.Error.INSTANCE;
                }
            } else if (z) {
                w1.clear();
            } else if (w1.size() > 0) {
                i3 = r.i(w1);
                w1.remove(i3);
            }
        } else if (w1.isEmpty()) {
            p1 = a0.p1(NumberKeyboardDigit.Zero.getDescription());
            w1.add(Character.valueOf(p1));
            w1.add(Character.valueOf(c2));
        } else if (w1.contains(Character.valueOf(c2))) {
            return RawStringResult.Error.INSTANCE;
        } else {
            w1.add(Character.valueOf(c2));
        }
        h0 = z.h0(w1, "", null, null, 0, null, null, 62, null);
        return new RawStringResult.Success(h0);
    }

    static /* synthetic */ RawStringResult getUpdatedAmount$default(NumberKeyboardInputView.Companion companion, String str, NumberKeyboardDigit numberKeyboardDigit, int i2, boolean z, char c2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z = false;
        }
        return getUpdatedAmount(companion, str, numberKeyboardDigit, i2, z, c2);
    }

    public static final RawStringResult getUpdatedCryptoAmount(NumberKeyboardInputView.Companion companion, String currentAmountString, NumberKeyboardDigit digit, int i2, boolean z) {
        char p1;
        m.g(companion, "<this>");
        m.g(currentAmountString, "currentAmountString");
        m.g(digit, "digit");
        p1 = a0.p1(NumberKeyboardDigit.DecimalSeparator.getDescription());
        return getUpdatedAmount(companion, currentAmountString, digit, i2, z, p1);
    }

    public static /* synthetic */ RawStringResult getUpdatedCryptoAmount$default(NumberKeyboardInputView.Companion companion, String str, NumberKeyboardDigit numberKeyboardDigit, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z = false;
        }
        return getUpdatedCryptoAmount(companion, str, numberKeyboardDigit, i2, z);
    }

    public static final RawStringResult getUpdatedFiatAmount(NumberKeyboardInputView.Companion companion, String currentAmountString, NumberKeyboardDigit digit, boolean z) {
        char p1;
        m.g(companion, "<this>");
        m.g(currentAmountString, "currentAmountString");
        m.g(digit, "digit");
        p1 = a0.p1(NumberKeyboardDigit.DecimalSeparator.localized(Locales.INSTANCE.getCurrent()).getDescription());
        return getUpdatedAmount(companion, currentAmountString, digit, 2, z, p1);
    }

    public static /* synthetic */ RawStringResult getUpdatedFiatAmount$default(NumberKeyboardInputView.Companion companion, String str, NumberKeyboardDigit numberKeyboardDigit, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return getUpdatedFiatAmount(companion, str, numberKeyboardDigit, z);
    }

    private static final boolean isValidEntry(List<Character> list, int i2, char c2) {
        List v0;
        v0 = z.v0(list);
        return v0.indexOf(Character.valueOf(c2)) < i2;
    }
}