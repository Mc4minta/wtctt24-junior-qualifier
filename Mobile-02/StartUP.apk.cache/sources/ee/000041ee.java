package com.toshi.view.custom;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import e.j.f.y;
import kotlin.Metadata;
import kotlin.l0.a0;
import org.toshi.R;

/* compiled from: CollapsingTextView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/toshi/view/custom/CollapsingTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "value", "Lkotlin/x;", "setCollapsedText", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CollapsingTextView extends AppCompatTextView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollapsingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.m.g(context, "context");
    }

    public final void setCollapsedText(String value) {
        String t1;
        kotlin.jvm.internal.m.g(value, "value");
        if (value.length() <= 10) {
            setText(value);
            return;
        }
        StringBuilder sb = new StringBuilder();
        String substring = value.substring(0, 5);
        kotlin.jvm.internal.m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb.append(substring);
        sb.append("..");
        t1 = a0.t1(value, 5);
        sb.append(t1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb.toString());
        spannableStringBuilder.setSpan(new ForegroundColorSpan(y.b(this, R.color.textColorSecondary)), 5, 7, 18);
        setText(spannableStringBuilder);
    }
}