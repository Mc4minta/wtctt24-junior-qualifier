package com.toshi.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;

/* compiled from: NoSwipeViewPager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/toshi/view/custom/NoSwipeViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Lkotlin/x;", "a", "()V", "Landroid/view/MotionEvent;", "ev", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "onTouchEvent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class NoSwipeViewPager extends ViewPager {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoSwipeViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.m.g(context, "context");
        kotlin.jvm.internal.m.g(attributeSet, "attributeSet");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, e.j.b.U0, 0, 0);
        try {
            if (obtainStyledAttributes.getBoolean(0, false)) {
                return;
            }
            a();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private final void a() {
        setPageTransformer(false, new ViewPager.k() { // from class: com.toshi.view.custom.k
            @Override // androidx.viewpager.widget.ViewPager.k
            public final void a(View view, float f2) {
                NoSwipeViewPager.c(view, f2);
            }
        });
    }

    public static final void b(View page, float f2) {
        kotlin.jvm.internal.m.g(page, "page");
        page.setTranslationX(page.getWidth() * (-f2));
        if (f2 <= -1.0f || f2 >= 1.0f) {
            page.setAlpha(0.0f);
            return;
        }
        if (f2 == 0.0f) {
            page.setAlpha(1.0f);
        } else {
            page.setAlpha(1.0f - Math.abs(f2));
        }
    }

    public static /* synthetic */ void c(View view, float f2) {
        b(view, f2);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.m.g(ev, "ev");
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.m.g(ev, "ev");
        return false;
    }
}