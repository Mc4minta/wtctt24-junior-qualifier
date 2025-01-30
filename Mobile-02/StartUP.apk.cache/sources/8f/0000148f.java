package com.coinbase.wallet.commonui.extensions;

import android.text.Spannable;
import android.text.style.URLSpan;
import com.coinbase.wallet.common.extensions.String_CommonKt;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: CharSequence+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0011\u0010\u0004\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "buildTickerText", "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "", "doesContainLinks", "(Ljava/lang/CharSequence;)Z", "commonui_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CharSequence_CommonKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x000f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.CharSequence buildTickerText(java.lang.CharSequence r3) {
        /*
            r0 = 0
            if (r3 == 0) goto Lc
            boolean r1 = kotlin.l0.o.D(r3)
            if (r1 == 0) goto La
            goto Lc
        La:
            r1 = r0
            goto Ld
        Lc:
            r1 = 1
        Ld:
            if (r1 == 0) goto L12
            java.lang.String r3 = "???"
            return r3
        L12:
            int r1 = r3.length()
            r2 = 5
            if (r1 >= r2) goto L1d
            int r2 = r3.length()
        L1d:
            java.lang.CharSequence r3 = r3.subSequence(r0, r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.commonui.extensions.CharSequence_CommonKt.buildTickerText(java.lang.CharSequence):java.lang.CharSequence");
    }

    public static final boolean doesContainLinks(CharSequence charSequence) {
        m.g(charSequence, "<this>");
        Spannable spannable = (Spannable) String_CommonKt.fromHtmlCompat(charSequence.toString());
        Object[] spans = spannable.getSpans(0, spannable.length(), URLSpan.class);
        m.f(spans, "textSpan.getSpans(0, textSpan.length, URLSpan::class.java)");
        return !(((URLSpan[]) spans).length == 0);
    }
}