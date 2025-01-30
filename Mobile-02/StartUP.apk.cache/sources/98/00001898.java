package com.coinbase.wallet.consumer.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;

/* compiled from: CustomReactRootView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fB\u0019\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000e\u0010\u0012B#\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u000e\u0010\u0015J\u001b\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0004\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/consumer/views/CustomReactRootView;", "Le/f/m/s;", "Lkotlin/Function0;", "Lkotlin/x;", "loadedListener", "setLoadedListener", "(Lkotlin/e0/c/a;)V", "Landroid/view/View;", "child", "onViewAdded", "(Landroid/view/View;)V", "Lkotlin/e0/c/a;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CustomReactRootView extends e.f.m.s {
    private kotlin.e0.c.a<kotlin.x> loadedListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomReactRootView(Context context) {
        super(context);
        kotlin.jvm.internal.m.g(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Override // e.f.m.s, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        kotlin.e0.c.a<kotlin.x> aVar = this.loadedListener;
        if (aVar != null) {
            aVar.invoke();
        } else {
            kotlin.jvm.internal.m.w("loadedListener");
            throw null;
        }
    }

    public final void setLoadedListener(kotlin.e0.c.a<kotlin.x> loadedListener) {
        kotlin.jvm.internal.m.g(loadedListener, "loadedListener");
        this.loadedListener = loadedListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomReactRootView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.m.g(context, "context");
        kotlin.jvm.internal.m.g(attrs, "attrs");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomReactRootView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.m.g(context, "context");
    }
}