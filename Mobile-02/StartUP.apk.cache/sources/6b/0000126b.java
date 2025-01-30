package com.coinbase.wallet.application.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.toshi.R;

/* compiled from: ProgressBarButtonWithSubtitle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018R(\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R(\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R$\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/application/view/custom/ProgressBarButtonWithSubtitle;", "Landroid/widget/FrameLayout;", "", "value", "getSubtitleText", "()Ljava/lang/CharSequence;", "setSubtitleText", "(Ljava/lang/CharSequence;)V", "subtitleText", "getTitleText", "setTitleText", "titleText", "", "progressWillBeVisible", "getProgressBarIsVisible", "()Z", "setProgressBarIsVisible", "(Z)V", "progressBarIsVisible", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ProgressBarButtonWithSubtitle extends FrameLayout {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProgressBarButtonWithSubtitle(Context context) {
        this(context, null, 2, null);
        m.g(context, "context");
    }

    public /* synthetic */ ProgressBarButtonWithSubtitle(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final boolean getProgressBarIsVisible() {
        ProgressBar buttonProgressBar = (ProgressBar) findViewById(e.j.a.buttonProgressBar);
        m.f(buttonProgressBar, "buttonProgressBar");
        return buttonProgressBar.getVisibility() == 0;
    }

    public final CharSequence getSubtitleText() {
        return ((TextView) findViewById(e.j.a.buttonSubtitle)).getText();
    }

    public final CharSequence getTitleText() {
        return ((TextView) findViewById(e.j.a.buttonTitle)).getText();
    }

    public final void setProgressBarIsVisible(boolean z) {
        Group buttonTextGroup = (Group) findViewById(e.j.a.buttonTextGroup);
        m.f(buttonTextGroup, "buttonTextGroup");
        buttonTextGroup.setVisibility(z ^ true ? 0 : 8);
        ProgressBar buttonProgressBar = (ProgressBar) findViewById(e.j.a.buttonProgressBar);
        m.f(buttonProgressBar, "buttonProgressBar");
        buttonProgressBar.setVisibility(z ? 0 : 8);
        float f2 = z ? 0.8f : 1.0f;
        ConstraintLayout container = (ConstraintLayout) findViewById(e.j.a.T0);
        m.f(container, "container");
        View_CommonKt.animateOpacity$default(container, f2, 150L, null, 4, null);
    }

    public final void setSubtitleText(CharSequence charSequence) {
        ((TextView) findViewById(e.j.a.buttonSubtitle)).setText(charSequence);
    }

    public final void setTitleText(CharSequence charSequence) {
        ((TextView) findViewById(e.j.a.buttonTitle)).setText(charSequence);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressBarButtonWithSubtitle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.g(context, "context");
        View.inflate(context, R.layout.view_progress_bar_button_subtitle, this).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.j.b.c1);
        CharSequence text = obtainStyledAttributes.getText(1);
        setTitleText(text == null ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : text);
        CharSequence text2 = obtainStyledAttributes.getText(0);
        setSubtitleText(text2 == null ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : text2);
        obtainStyledAttributes.recycle();
    }
}