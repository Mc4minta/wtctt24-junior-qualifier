package com.coinbase.wallet.commonui.extensions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import c.h.k.v;
import com.coinbase.wallet.commonui.utilities.animation.AnimatorListener;
import h.c.b0;
import h.c.d0;
import h.c.f0;
import java.util.Objects;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.e0.c.p;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: View+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a-\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\t\u001a7\u0010\f\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n¢\u0006\u0004\b\f\u0010\r\u001a7\u0010\u000e\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n¢\u0006\u0004\b\u000e\u0010\r\u001a/\u0010\u0012\u001a\u00020\u0007*\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00032\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001b\u0010\u0016\u001a\u00020\u0007*\u00020\u00002\b\b\u0001\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001b\u0010\u0019\u001a\u00020\u0014*\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001d\u001a\u00020\u0007*\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u001d\u0010\u001e\u001a'\u0010\u001f\u001a\u00020\u0007*\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u001f\u0010\u001e\u001aA\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070#*\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\u000b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\"\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b$\u0010%\u001a+\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070#*\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b&\u0010'\u001a/\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070#*\u00020\u00002\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b)\u0010*\u001a\u0011\u0010+\u001a\u00020\u0007*\u00020\u0000¢\u0006\u0004\b+\u0010,\u001a)\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b0\u00101\"\u0017\u00104\u001a\u00020\u0014*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b2\u00103\"\u0017\u00106\u001a\u00020\u0014*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b5\u00103¨\u00067"}, d2 = {"Landroid/view/View;", "", "toAlpha", "", "duration", "Landroid/animation/AnimatorListenerAdapter;", "listener", "Lkotlin/x;", "animateOpacity", "(Landroid/view/View;FJLandroid/animation/AnimatorListenerAdapter;)V", "Lkotlin/Function2;", "", "fadeOut", "(Landroid/view/View;JLkotlin/e0/c/p;)V", "fadeIn", "delayMs", "Lkotlin/Function1;", "l", "setOnSingleClickListener", "(Landroid/view/View;JLkotlin/e0/c/l;)V", "", "bottom", "setPaddingBottom", "(Landroid/view/View;I)V", "id", "getPxSize", "(Landroid/view/View;I)I", "radius", "rippleColor", "setRippleBackground", "(Landroid/view/View;ILjava/lang/Integer;)V", "setRippleForeground", "animated", "overrideTargetHeight", "initialHeight", "Lh/c/b0;", "expand", "(Landroid/view/View;ZLjava/lang/Integer;IJ)Lh/c/b0;", "collapse", "(Landroid/view/View;ZJ)Lh/c/b0;", "targetHeight", "animateView", "(Landroid/view/View;IIJ)Lh/c/b0;", "forceMeasure", "(Landroid/view/View;)V", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "createRippleDrawable", "(Landroid/content/Context;ILjava/lang/Integer;)Landroid/graphics/drawable/Drawable;", "getPaddingEndCompat", "(Landroid/view/View;)I", "paddingEndCompat", "getPaddingStartCompat", "paddingStartCompat", "commonui_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class View_CommonKt {
    public static /* synthetic */ x a(View view) {
        return m800collapse$lambda2(view);
    }

    public static final void animateOpacity(View view, float f2, long j2, AnimatorListenerAdapter animatorListenerAdapter) {
        m.g(view, "<this>");
        view.animate().alpha(f2).setDuration(j2).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(animatorListenerAdapter).start();
    }

    public static /* synthetic */ void animateOpacity$default(View view, float f2, long j2, AnimatorListenerAdapter animatorListenerAdapter, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            animatorListenerAdapter = null;
        }
        animateOpacity(view, f2, j2, animatorListenerAdapter);
    }

    public static final b0<x> animateView(final View view, final int i2, final int i3, final long j2) {
        m.g(view, "<this>");
        b0<x> create = b0.create(new f0() { // from class: com.coinbase.wallet.commonui.extensions.i
            @Override // h.c.f0
            public final void subscribe(d0 d0Var) {
                View_CommonKt.d(view, i2, i3, j2, d0Var);
            }
        });
        m.f(create, "create { emitter ->\n        layoutParams.height = initialHeight\n        visibility = View.VISIBLE\n        val valueAnimator = ValueAnimator.ofInt(initialHeight, targetHeight)\n        valueAnimator.addUpdateListener { animation ->\n            this.layoutParams.height = animation.animatedValue as Int\n            this.requestLayout()\n        }\n        valueAnimator.addListener(object : Animator.AnimatorListener {\n            override fun onAnimationEnd(animation: Animator) {\n                this@animateView.layoutParams.height = targetHeight\n                if (targetHeight <= 1) this@animateView.visibility = View.INVISIBLE\n                emitter.onSuccess(Unit)\n            }\n\n            override fun onAnimationStart(animation: Animator) {}\n            override fun onAnimationCancel(animation: Animator) {}\n            override fun onAnimationRepeat(animation: Animator) {}\n        })\n        valueAnimator.duration = duration\n        valueAnimator.interpolator = AccelerateDecelerateInterpolator()\n        valueAnimator.start()\n    }");
        return create;
    }

    /* renamed from: animateView$lambda-4 */
    public static final void m798animateView$lambda4(final View this_animateView, int i2, final int i3, long j2, final d0 emitter) {
        m.g(this_animateView, "$this_animateView");
        m.g(emitter, "emitter");
        this_animateView.getLayoutParams().height = i2;
        this_animateView.setVisibility(0);
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coinbase.wallet.commonui.extensions.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                View_CommonKt.b(this_animateView, valueAnimator);
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.coinbase.wallet.commonui.extensions.View_CommonKt$animateView$1$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                m.g(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                m.g(animation, "animation");
                ViewGroup.LayoutParams layoutParams = this_animateView.getLayoutParams();
                int i4 = i3;
                layoutParams.height = i4;
                if (i4 <= 1) {
                    this_animateView.setVisibility(4);
                }
                emitter.onSuccess(x.a);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                m.g(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                m.g(animation, "animation");
            }
        });
        ofInt.setDuration(j2);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.start();
    }

    /* renamed from: animateView$lambda-4$lambda-3 */
    public static final void m799animateView$lambda4$lambda3(View this_animateView, ValueAnimator valueAnimator) {
        m.g(this_animateView, "$this_animateView");
        ViewGroup.LayoutParams layoutParams = this_animateView.getLayoutParams();
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = ((Integer) animatedValue).intValue();
        this_animateView.requestLayout();
    }

    public static /* synthetic */ void b(View view, ValueAnimator valueAnimator) {
        m799animateView$lambda4$lambda3(view, valueAnimator);
    }

    public static /* synthetic */ x c(View view, Integer num) {
        return m801expand$lambda1(view, num);
    }

    public static final b0<x> collapse(final View view, boolean z, long j2) {
        m.g(view, "<this>");
        if (!z) {
            b0<x> fromCallable = b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.commonui.extensions.f
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return View_CommonKt.a(view);
                }
            });
            m.f(fromCallable, "{\n        Single.fromCallable {\n            layoutParams.height = 1\n            isInvisible = true\n            Unit\n        }\n    }");
            return fromCallable;
        }
        return animateView(view, view.getMeasuredHeight(), 1, j2);
    }

    public static /* synthetic */ b0 collapse$default(View view, boolean z, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            j2 = 300;
        }
        return collapse(view, z, j2);
    }

    /* renamed from: collapse$lambda-2 */
    public static final x m800collapse$lambda2(View this_collapse) {
        m.g(this_collapse, "$this_collapse");
        this_collapse.getLayoutParams().height = 1;
        this_collapse.setVisibility(4);
        return x.a;
    }

    private static final Drawable createRippleDrawable(Context context, int i2, Integer num) {
        int i3;
        if (num != null) {
            i3 = num.intValue();
        } else {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16843820, typedValue, false);
            i3 = typedValue.data;
        }
        int color = context.getColor(i3);
        float[] fArr = new float[8];
        for (int i4 = 0; i4 < 8; i4++) {
            fArr[i4] = i2;
        }
        return new RippleDrawable(ColorStateList.valueOf(color), null, new ShapeDrawable(new RoundRectShape(fArr, null, null)));
    }

    public static /* synthetic */ void d(View view, int i2, int i3, long j2, d0 d0Var) {
        m798animateView$lambda4(view, i2, i3, j2, d0Var);
    }

    public static final b0<x> expand(final View view, boolean z, final Integer num, int i2, long j2) {
        m.g(view, "<this>");
        forceMeasure(view);
        if (!z) {
            b0<x> fromCallable = b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.commonui.extensions.h
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return View_CommonKt.c(view, num);
                }
            });
            m.f(fromCallable, "{\n        Single.fromCallable {\n            isVisible = true\n            overrideTargetHeight?.let { this.layoutParams.height = it }\n            Unit\n        }\n    }");
            return fromCallable;
        }
        return animateView(view, i2, num == null ? view.getMeasuredHeight() : num.intValue(), j2);
    }

    public static /* synthetic */ b0 expand$default(View view, boolean z, Integer num, int i2, long j2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = true;
        }
        if ((i3 & 2) != 0) {
            num = null;
        }
        if ((i3 & 4) != 0) {
            i2 = 1;
        }
        if ((i3 & 8) != 0) {
            j2 = 300;
        }
        return expand(view, z, num, i2, j2);
    }

    /* renamed from: expand$lambda-1 */
    public static final x m801expand$lambda1(View this_expand, Integer num) {
        m.g(this_expand, "$this_expand");
        this_expand.setVisibility(0);
        if (num != null) {
            this_expand.getLayoutParams().height = num.intValue();
        }
        return x.a;
    }

    public static final void fadeIn(View view, long j2, p<? super View, ? super Boolean, x> pVar) {
        m.g(view, "<this>");
        AnimatorListener listener = AnimatorListener.Companion.getListener(view, pVar);
        view.setVisibility(0);
        view.setAlpha(0.0f);
        animateOpacity(view, 1.0f, j2, listener);
    }

    public static /* synthetic */ void fadeIn$default(View view, long j2, p pVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            pVar = null;
        }
        fadeIn(view, j2, pVar);
    }

    public static final void fadeOut(View view, long j2, p<? super View, ? super Boolean, x> pVar) {
        m.g(view, "<this>");
        animateOpacity(view, 0.0f, j2, AnimatorListener.Companion.getListener(view, pVar));
    }

    public static /* synthetic */ void fadeOut$default(View view, long j2, p pVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            pVar = null;
        }
        fadeOut(view, j2, pVar);
    }

    public static final void forceMeasure(View view) {
        m.g(view, "<this>");
        ViewParent parent = view.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.View");
        view.measure(View.MeasureSpec.makeMeasureSpec(((View) parent).getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    public static final int getPaddingEndCompat(View view) {
        m.g(view, "<this>");
        return v.C(view);
    }

    public static final int getPaddingStartCompat(View view) {
        m.g(view, "<this>");
        return v.D(view);
    }

    public static final int getPxSize(View view, int i2) {
        m.g(view, "<this>");
        return view.getResources().getDimensionPixelSize(i2);
    }

    public static final void setOnSingleClickListener(View view, long j2, l<? super View, x> l2) {
        m.g(view, "<this>");
        m.g(l2, "l");
        view.setOnClickListener(new OnSingleClickListener(l2, j2) { // from class: com.coinbase.wallet.commonui.extensions.View_CommonKt$setOnSingleClickListener$1
            final /* synthetic */ long $delayMs;
            final /* synthetic */ l<View, x> $l;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(j2);
                this.$delayMs = j2;
            }

            @Override // com.coinbase.wallet.commonui.extensions.OnSingleClickListener
            public void onSingleClick(View v) {
                m.g(v, "v");
                this.$l.invoke(v);
            }
        });
    }

    public static /* synthetic */ void setOnSingleClickListener$default(View view, long j2, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 500;
        }
        setOnSingleClickListener(view, j2, lVar);
    }

    public static final void setPaddingBottom(View view, int i2) {
        m.g(view, "<this>");
        v.x0(view, getPaddingStartCompat(view), view.getPaddingTop(), getPaddingEndCompat(view), i2);
    }

    public static final void setRippleBackground(View view, int i2, Integer num) {
        m.g(view, "<this>");
        Context context = view.getContext();
        m.f(context, "context");
        view.setBackground(createRippleDrawable(context, i2, num));
    }

    public static /* synthetic */ void setRippleBackground$default(View view, int i2, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            num = null;
        }
        setRippleBackground(view, i2, num);
    }

    public static final void setRippleForeground(View view, int i2, Integer num) {
        m.g(view, "<this>");
        Context context = view.getContext();
        m.f(context, "context");
        view.setForeground(createRippleDrawable(context, i2, num));
    }

    public static /* synthetic */ void setRippleForeground$default(View view, int i2, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            num = null;
        }
        setRippleForeground(view, i2, num);
    }
}