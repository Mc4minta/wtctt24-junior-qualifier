package com.coinbase.wallet.commonui.extensions;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.widget.TextView;
import com.coinbase.wallet.common.extensions.String_CommonKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import kotlin.l0.y;

/* compiled from: TextView+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/widget/TextView;", "", "textStr", "Lkotlin/x;", "addLinkifiedText", "(Landroid/widget/TextView;Ljava/lang/String;)V", "commonui_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TextView_CommonKt {
    public static final void addLinkifiedText(TextView textView, String textStr) {
        List<String> K0;
        int r;
        m.g(textView, "<this>");
        m.g(textStr, "textStr");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        K0 = y.K0(textStr, new String[]{"\n"}, false, 0, 6, null);
        r = s.r(K0, 10);
        ArrayList arrayList = new ArrayList(r);
        for (String str : K0) {
            Spannable spannable = (Spannable) String_CommonKt.fromHtmlCompat(str);
            Object[] spans = spannable.getSpans(0, spannable.length(), URLSpan.class);
            m.f(spans, "textSpan.getSpans(0, textSpan.length, URLSpan::class.java)");
            URLSpan[] uRLSpanArr = (URLSpan[]) spans;
            int length = uRLSpanArr.length;
            int i2 = 0;
            while (i2 < length) {
                URLSpan uRLSpan = uRLSpanArr[i2];
                i2++;
                int spanStart = spannable.getSpanStart(uRLSpan);
                int spanEnd = spannable.getSpanEnd(uRLSpan);
                spannable.removeSpan(uRLSpan);
                spannable.setSpan(new URLSpan(uRLSpan.getURL()) { // from class: com.coinbase.wallet.commonui.extensions.TextView_CommonKt$addLinkifiedText$reducedSpans$1$newSpan$1
                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint ds) {
                        m.g(ds, "ds");
                        super.updateDrawState(ds);
                        ds.setUnderlineText(false);
                    }
                }, spanStart, spanEnd, 0);
            }
            arrayList.add(spannable);
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            while (it.hasNext()) {
                CharSequence concat = TextUtils.concat((Spannable) next, "\n", (Spannable) it.next());
                m.f(concat, "concat(acc, \"\\n\", spannable)");
                next = SpannableString.valueOf(concat);
                m.f(next, "SpannableString.valueOf(this)");
            }
            textView.setText((Spannable) next);
            return;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }
}