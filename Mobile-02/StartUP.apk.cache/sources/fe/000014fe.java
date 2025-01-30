package com.coinbase.wallet.commonui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coinbase.wallet.commonui.R;
import com.coinbase.wallet.commonui.utilities.Colors;
import com.coinbase.wallet.commonui.utilities.ColorsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ProgressBarButton.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR(\u0010\u0012\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/commonui/views/ProgressBarButton;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "textAlwaysVisible", "Z", "getTextAlwaysVisible", "()Z", "setTextAlwaysVisible", "(Z)V", "value", "getProgressBarIsVisible", "setProgressBarIsVisible", "progressBarIsVisible", "", "getProgressBarText", "()Ljava/lang/CharSequence;", "setProgressBarText", "(Ljava/lang/CharSequence;)V", "progressBarText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public class ProgressBarButton extends ConstraintLayout {
    private boolean textAlwaysVisible;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProgressBarButton(Context context) {
        this(context, null, 2, null);
        m.g(context, "context");
    }

    public /* synthetic */ ProgressBarButton(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
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

    public final boolean getTextAlwaysVisible() {
        return this.textAlwaysVisible;
    }

    public final void setProgressBarIsVisible(boolean z) {
        setEnabled(!z);
        TextView text = (TextView) findViewById(R.id.text);
        m.f(text, "text");
        text.setVisibility(!z || this.textAlwaysVisible ? 0 : 8);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        m.f(progressBar, "progressBar");
        progressBar.setVisibility(z ? 0 : 8);
    }

    public final void setProgressBarText(CharSequence charSequence) {
        ((TextView) findViewById(R.id.text)).setText(charSequence);
    }

    public final void setTextAlwaysVisible(boolean z) {
        this.textAlwaysVisible = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressBarButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.g(context, "context");
        View.inflate(context, R.layout.view_progress_bar_button_internal, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ProgressBarButton);
        m.f(obtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.ProgressBarButton)");
        int color = obtainStyledAttributes.getColor(R.styleable.ProgressBarButton_textColor, ColorsKt.get(Colors.INSTANCE, R.color.white));
        setProgressBarText(obtainStyledAttributes.getText(R.styleable.ProgressBarButton_progressBarText));
        ((TextView) findViewById(R.id.text)).setTextColor(color);
        ((ProgressBar) findViewById(R.id.progressBar)).getIndeterminateDrawable().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        setProgressBarIsVisible(obtainStyledAttributes.getBoolean(R.styleable.ProgressBarButton_progressBarStartsVisible, false));
        this.textAlwaysVisible = obtainStyledAttributes.getBoolean(R.styleable.ProgressBarButton_textAlwaysVisible, false);
        obtainStyledAttributes.recycle();
    }
}