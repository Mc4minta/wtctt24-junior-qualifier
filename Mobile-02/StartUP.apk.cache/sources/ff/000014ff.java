package com.coinbase.wallet.commonui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coinbase.wallet.commonui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ProgressBarButtonCircular.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R(\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/commonui/views/ProgressBarButtonCircular;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView", "", "value", "getProgressBarText", "()Ljava/lang/CharSequence;", "setProgressBarText", "(Ljava/lang/CharSequence;)V", "progressBarText", "", "getProgressBarIsVisible", "()Z", "setProgressBarIsVisible", "(Z)V", "progressBarIsVisible", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public class ProgressBarButtonCircular extends ConstraintLayout {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProgressBarButtonCircular(Context context) {
        this(context, null, 2, null);
        m.g(context, "context");
    }

    public /* synthetic */ ProgressBarButtonCircular(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final boolean getProgressBarIsVisible() {
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        m.f(progressBar, "progressBar");
        return progressBar.getVisibility() == 0;
    }

    public final CharSequence getProgressBarText() {
        return ((TextView) findViewById(R.id.text)).getText();
    }

    public final TextView getTextView() {
        return (TextView) findViewById(R.id.text);
    }

    public final void setProgressBarIsVisible(boolean z) {
        setEnabled(!z);
        TextView text = (TextView) findViewById(R.id.text);
        m.f(text, "text");
        text.setVisibility(z ^ true ? 0 : 8);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        m.f(progressBar, "progressBar");
        progressBar.setVisibility(z ? 0 : 8);
    }

    public final void setProgressBarText(CharSequence charSequence) {
        ((TextView) findViewById(R.id.text)).setText(charSequence);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressBarButtonCircular(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.g(context, "context");
        View.inflate(context, R.layout.view_progress_bar_button_no_margin_internal, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ProgressBarButton);
        m.f(obtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.ProgressBarButton)");
        setProgressBarText(obtainStyledAttributes.getText(R.styleable.ProgressBarButton_progressBarText));
        setProgressBarIsVisible(obtainStyledAttributes.getBoolean(R.styleable.ProgressBarButton_progressBarStartsVisible, false));
        obtainStyledAttributes.recycle();
    }
}