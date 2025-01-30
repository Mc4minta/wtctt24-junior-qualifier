package com.coinbase.wallet.commonui.views;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.core.extensions.Strings;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.m;
import okhttp3.internal.cache.DiskLruCache;

/* compiled from: NumberKeyboardDigit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\t\u001a\u00020\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;", "", "Ljava/util/Locale;", ApiConstants.LOCALE, "localized", "(Ljava/util/Locale;)Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;", "", "getDescription", "()Ljava/lang/String;", ApiConstants.DESCRIPTION, "<init>", "(Ljava/lang/String;I)V", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "DecimalSeparator", "Zero", "Delete", "GroupSeparator", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public enum NumberKeyboardDigit {
    One,
    Two,
    Three,
    Four,
    Five,
    Six,
    Seven,
    Eight,
    Nine,
    DecimalSeparator,
    Zero,
    Delete,
    GroupSeparator;

    /* compiled from: NumberKeyboardDigit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NumberKeyboardDigit.values().length];
            iArr[NumberKeyboardDigit.One.ordinal()] = 1;
            iArr[NumberKeyboardDigit.Two.ordinal()] = 2;
            iArr[NumberKeyboardDigit.Three.ordinal()] = 3;
            iArr[NumberKeyboardDigit.Four.ordinal()] = 4;
            iArr[NumberKeyboardDigit.Five.ordinal()] = 5;
            iArr[NumberKeyboardDigit.Six.ordinal()] = 6;
            iArr[NumberKeyboardDigit.Seven.ordinal()] = 7;
            iArr[NumberKeyboardDigit.Eight.ordinal()] = 8;
            iArr[NumberKeyboardDigit.Nine.ordinal()] = 9;
            iArr[NumberKeyboardDigit.DecimalSeparator.ordinal()] = 10;
            iArr[NumberKeyboardDigit.Zero.ordinal()] = 11;
            iArr[NumberKeyboardDigit.Delete.ordinal()] = 12;
            iArr[NumberKeyboardDigit.GroupSeparator.ordinal()] = 13;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final String getDescription() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return DiskLruCache.VERSION_1;
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return ".";
            case 11:
                return Strings.zero;
            case 12:
                return "‹";
            case 13:
                return ",";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final NumberKeyboardDigit localized(Locale locale) {
        m.g(locale, "locale");
        NumberKeyboardDigit numberKeyboardDigit = DecimalSeparator;
        return this == numberKeyboardDigit ? m.c(String.valueOf(new DecimalFormatSymbols(locale).getDecimalSeparator()), getDescription()) ? numberKeyboardDigit : GroupSeparator : this;
    }
}