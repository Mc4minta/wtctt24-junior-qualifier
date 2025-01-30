package com.coinbase.wallet.features.send.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView;
import kotlin.Metadata;

/* compiled from: MemoTypeSpinner.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/coinbase/wallet/features/send/views/MemoTypeSpinner;", "Landroidx/appcompat/widget/s;", "", "position", "Lkotlin/x;", "setSelection", "(I)V", "Landroid/widget/AdapterView$OnItemSelectedListener;", "onItemSelectedListener", "Landroid/widget/AdapterView$OnItemSelectedListener;", "getOnItemSelectedListener$app_productionRelease", "()Landroid/widget/AdapterView$OnItemSelectedListener;", "setOnItemSelectedListener$app_productionRelease", "(Landroid/widget/AdapterView$OnItemSelectedListener;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MemoTypeSpinner extends androidx.appcompat.widget.s {
    private AdapterView.OnItemSelectedListener onItemSelectedListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemoTypeSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.m.g(context, "context");
        kotlin.jvm.internal.m.g(attrs, "attrs");
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final AdapterView.OnItemSelectedListener getOnItemSelectedListener$app_productionRelease() {
        return this.onItemSelectedListener;
    }

    public final void setOnItemSelectedListener$app_productionRelease(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }

    @Override // android.widget.AbsSpinner, android.widget.AdapterView
    public void setSelection(int i2) {
        super.setSelection(i2);
        AdapterView.OnItemSelectedListener onItemSelectedListener = this.onItemSelectedListener;
        if (onItemSelectedListener == null) {
            return;
        }
        onItemSelectedListener.onItemSelected(null, null, i2, 0L);
    }
}