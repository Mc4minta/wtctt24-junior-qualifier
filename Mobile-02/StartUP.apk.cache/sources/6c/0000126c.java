package com.coinbase.wallet.application.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import org.toshi.R;

/* compiled from: RoundedCornerImageView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/application/view/custom/RoundedCornerImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RoundedCornerImageView extends AppCompatImageView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedCornerImageView(Context context) {
        super(context);
        m.g(context, "context");
        setBackground(getContext().getDrawable(R.drawable.rounded_rectangle_outline));
        setClipToOutline(true);
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedCornerImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m.g(context, "context");
        m.g(attrs, "attrs");
        setBackground(getContext().getDrawable(R.drawable.rounded_rectangle_outline));
        setClipToOutline(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedCornerImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        m.g(context, "context");
        setBackground(getContext().getDrawable(R.drawable.rounded_rectangle_outline));
        setClipToOutline(true);
    }
}