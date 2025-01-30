package com.coinbase.wallet.commonui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.LinearLayout;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: KeyboardInsetsLinearLayout.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/commonui/views/KeyboardInsetsLinearLayout;", "Landroid/widget/LinearLayout;", "Lcom/coinbase/wallet/commonui/views/KeyboardInsetting;", "Landroid/view/WindowInsets;", "insets", "onApplyWindowInsets", "(Landroid/view/WindowInsets;)Landroid/view/WindowInsets;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class KeyboardInsetsLinearLayout extends LinearLayout implements KeyboardInsetting {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KeyboardInsetsLinearLayout(Context context) {
        this(context, null, 2, null);
        m.g(context, "context");
    }

    public /* synthetic */ KeyboardInsetsLinearLayout(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        m.g(insets, "insets");
        View_CommonKt.setPaddingBottom(this, insets.getSystemWindowInsetBottom());
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(insets);
        m.f(onApplyWindowInsets, "super.onApplyWindowInsets(insets)");
        return onApplyWindowInsets;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardInsetsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.g(context, "context");
    }
}