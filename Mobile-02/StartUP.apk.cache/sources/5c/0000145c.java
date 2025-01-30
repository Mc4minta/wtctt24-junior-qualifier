package com.coinbase.wallet.common.extensions;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import com.coinbase.ciphercore.ByteArray_CipherCoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.l0.y;

/* compiled from: String+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a+\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\f\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\f\u0010\b\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\t*\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u000b\"\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"", "", "charactersAtFront", "charactersAtEnd", "truncationString", "truncateMiddle", "(Ljava/lang/String;IILjava/lang/String;)Ljava/lang/String;", "toUnformattedDecimalValueOrEmpty", "(Ljava/lang/String;)Ljava/lang/String;", "", "isScientificNotation", "(Ljava/lang/String;)Z", "toHexEncodedString", "Landroid/text/Spanned;", "fromHtmlCompat", "(Ljava/lang/String;)Landroid/text/Spanned;", "isNonZeroAmount", "Lkotlin/l0/k;", "scientificNotationRegex$delegate", "Lkotlin/h;", "getScientificNotationRegex", "()Lkotlin/l0/k;", "scientificNotationRegex", "common_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class String_CommonKt {
    private static final h scientificNotationRegex$delegate;

    static {
        h b2;
        b2 = k.b(String_CommonKt$scientificNotationRegex$2.INSTANCE);
        scientificNotationRegex$delegate = b2;
    }

    public static final Spanned fromHtmlCompat(String str) {
        m.g(str, "<this>");
        if (Build.VERSION.SDK_INT >= 24) {
            Spanned fromHtml = Html.fromHtml(str, 0);
            m.f(fromHtml, "{\n        Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)\n    }");
            return fromHtml;
        }
        Spanned fromHtml2 = Html.fromHtml(str);
        m.f(fromHtml2, "{\n        Html.fromHtml(this)\n    }");
        return fromHtml2;
    }

    private static final kotlin.l0.k getScientificNotationRegex() {
        return (kotlin.l0.k) scientificNotationRegex$delegate.getValue();
    }

    public static final boolean isNonZeroAmount(String str) {
        m.g(str, "<this>");
        return new kotlin.l0.k("[^1-9]").e(str, "").length() > 0;
    }

    public static final boolean isScientificNotation(String str) {
        m.g(str, "<this>");
        try {
            new BigDecimal(str);
            return getScientificNotationRegex().d(str);
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static final String toHexEncodedString(String str) {
        m.g(str, "<this>");
        byte[] bytes = str.getBytes(kotlin.l0.d.a);
        m.f(bytes, "(this as java.lang.String).getBytes(charset)");
        return ByteArray_CipherCoreKt.toHexEncodedString$default(bytes, false, 1, null);
    }

    public static final String toUnformattedDecimalValueOrEmpty(String str) {
        m.g(str, "<this>");
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (Character.isDigit(charAt) || charAt == '.') {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        m.f(sb2, "filterTo(StringBuilder(), predicate).toString()");
        return sb2;
    }

    public static final String truncateMiddle(String str, int i2, int i3, String truncationString) {
        CharSequence h1;
        int c0;
        m.g(str, "<this>");
        m.g(truncationString, "truncationString");
        h1 = y.h1(str);
        String obj = h1.toString();
        if (obj.length() <= i2 + i3 + truncationString.length()) {
            return str;
        }
        c0 = y.c0(obj);
        String substring = obj.substring(0, i2);
        m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String substring2 = obj.substring((c0 - i3) + 1);
        m.f(substring2, "(this as java.lang.String).substring(startIndex)");
        return substring + truncationString + substring2;
    }

    public static /* synthetic */ String truncateMiddle$default(String str, int i2, int i3, String str2, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            str2 = Strings_CoreKt.getEllipsis(Strings.INSTANCE);
        }
        return truncateMiddle(str, i2, i3, str2);
    }
}