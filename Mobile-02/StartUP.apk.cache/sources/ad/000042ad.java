package com.toshi.view.fragment.coin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ScrollButtonBehavior.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ?\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ?\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/toshi/view/fragment/coin/ScrollButtonBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$c;", "Landroid/widget/Button;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "coordinatorLayout", "child", "Landroid/view/View;", "directTargetChild", "target", "", "axes", "type", "", "E", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/widget/Button;Landroid/view/View;Landroid/view/View;II)Z", "", "velocityX", "velocityY", "consumed", "D", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/widget/Button;Landroid/view/View;FFZ)Z", "b", "Z", "isFirstFling", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ScrollButtonBehavior extends CoordinatorLayout.c<Button> {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private boolean f11304b;

    /* compiled from: ScrollButtonBehavior.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollButtonBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.m.g(context, "context");
        kotlin.jvm.internal.m.g(attrs, "attrs");
        this.f11304b = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: D */
    public boolean n(CoordinatorLayout coordinatorLayout, Button child, View target, float f2, float f3, boolean z) {
        kotlin.jvm.internal.m.g(coordinatorLayout, "coordinatorLayout");
        kotlin.jvm.internal.m.g(child, "child");
        kotlin.jvm.internal.m.g(target, "target");
        if (f3 < 3000.0f) {
            return false;
        }
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        child.animate().translationY(child.getHeight() + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) layoutParams)).bottomMargin).setInterpolator(new LinearInterpolator()).setDuration(500L).start();
        this.f11304b = false;
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: E */
    public boolean z(CoordinatorLayout coordinatorLayout, Button child, View directTargetChild, View target, int i2, int i3) {
        kotlin.jvm.internal.m.g(coordinatorLayout, "coordinatorLayout");
        kotlin.jvm.internal.m.g(child, "child");
        kotlin.jvm.internal.m.g(directTargetChild, "directTargetChild");
        kotlin.jvm.internal.m.g(target, "target");
        return i2 == 2 && this.f11304b;
    }
}