package com.coinbase.wallet.commonui.utilities;

import com.coinbase.wallet.common.extensions.String_CommonKt;
import com.coinbase.wallet.core.extensions.Strings;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: AmountPickerFormatter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004R\u0013\u0010\u0015\u001a\u00020\u000f8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/AmountText;", "", "", "component1", "()Ljava/lang/String;", "component2", "formattedAmount", "rawString", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/commonui/utilities/AmountText;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFormattedAmount", "getRawString", "isNotZero", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AmountText {
    public static final Companion Companion = new Companion(null);
    private static final AmountText zero = new AmountText(Strings.zero, Strings.zero);
    private final String formattedAmount;
    private final String rawString;

    /* compiled from: AmountPickerFormatter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/AmountText$Companion;", "", "Lcom/coinbase/wallet/commonui/utilities/AmountText;", "zero", "Lcom/coinbase/wallet/commonui/utilities/AmountText;", "getZero", "()Lcom/coinbase/wallet/commonui/utilities/AmountText;", "<init>", "()V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AmountText getZero() {
            return AmountText.zero;
        }
    }

    public AmountText(String formattedAmount, String rawString) {
        m.g(formattedAmount, "formattedAmount");
        m.g(rawString, "rawString");
        this.formattedAmount = formattedAmount;
        this.rawString = rawString;
    }

    public static /* synthetic */ AmountText copy$default(AmountText amountText, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = amountText.formattedAmount;
        }
        if ((i2 & 2) != 0) {
            str2 = amountText.rawString;
        }
        return amountText.copy(str, str2);
    }

    public final String component1() {
        return this.formattedAmount;
    }

    public final String component2() {
        return this.rawString;
    }

    public final AmountText copy(String formattedAmount, String rawString) {
        m.g(formattedAmount, "formattedAmount");
        m.g(rawString, "rawString");
        return new AmountText(formattedAmount, rawString);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AmountText) {
            AmountText amountText = (AmountText) obj;
            return m.c(this.formattedAmount, amountText.formattedAmount) && m.c(this.rawString, amountText.rawString);
        }
        return false;
    }

    public final String getFormattedAmount() {
        return this.formattedAmount;
    }

    public final String getRawString() {
        return this.rawString;
    }

    public int hashCode() {
        return (this.formattedAmount.hashCode() * 31) + this.rawString.hashCode();
    }

    public final boolean isNotZero() {
        if ((this.formattedAmount.length() > 0) && String_CommonKt.isNonZeroAmount(this.formattedAmount)) {
            if ((this.rawString.length() > 0) && String_CommonKt.isNonZeroAmount(this.rawString)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "AmountText(formattedAmount=" + this.formattedAmount + ", rawString=" + this.rawString + ')';
    }
}