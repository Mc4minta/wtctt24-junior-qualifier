package com.coinbase.wallet.commonui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.coinbase.wallet.commonui.extensions.Context_CommonKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: StatusBarSpace.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/coinbase/wallet/commonui/views/StatusBarSpace;", "Landroid/view/View;", "", "widthMeasureSpec", "heightMeasureSpec", "Lkotlin/x;", "onMeasure", "(II)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttribute", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public class StatusBarSpace extends View {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatusBarSpace(Context context) {
        this(context, null, 0, 6, null);
        m.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatusBarSpace(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        m.g(context, "context");
    }

    public /* synthetic */ StatusBarSpace(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        Context context = getContext();
        m.f(context, "context");
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(Context_CommonKt.getStatusBarHeight(context), 1073741824));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusBarSpace(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        m.g(context, "context");
    }
}