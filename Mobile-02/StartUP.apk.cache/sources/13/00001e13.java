package com.coinbase.wallet.features.commonui.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import c.h.k.g;
import com.google.android.material.card.MaterialCardView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: ExpandingCardView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108B\u0019\b\u0016\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u0010:\u001a\u000209¢\u0006\u0004\b7\u0010;B#\b\u0016\u0012\u0006\u00106\u001a\u000205\u0012\b\u0010:\u001a\u0004\u0018\u000109\u0012\u0006\u0010<\u001a\u00020\u0011¢\u0006\u0004\b7\u0010=J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\rJ'\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0018\u0010\u0004J\r\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\r\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u0004R\u0016\u0010\u001b\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001cR\u0016\u0010&\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u001f8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b(\u0010!R\u0016\u0010)\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010\u001cR\u0016\u0010-\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010'R\u0016\u0010.\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010\u001cR\u0016\u0010/\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010\u001cR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u00100R\u0016\u00101\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010'R\u0016\u00102\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010\u001cR\u0016\u00103\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010\u001cR\u0016\u00104\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010\u001c¨\u0006>"}, d2 = {"Lcom/coinbase/wallet/features/commonui/views/ExpandingCardView;", "Lcom/google/android/material/card/MaterialCardView;", "Lkotlin/x;", "setCollapsed", "()V", "setExpanded", "", "reversed", "Landroid/animation/AnimatorSet;", "animatorSet", "(Z)Landroid/animation/AnimatorSet;", "Landroid/animation/Animator;", "layoutParamsAnimator", "(Z)Landroid/animation/Animator;", "elevationAnimator", "cornerRadiusAnimator", "expandingViewAlphaAnimator", "", "collapsed", "expanded", "", "progress", "progressValue", "(IIF)I", "onFinishInflate", "collapse", "expand", "expandedMarginBottom", "I", "collapsedMarginStart", "expandedMarginEnd", "", "expandAnimDuration", "J", "Landroid/view/View;", "expandingView", "Landroid/view/View;", "collapsedMarginBottom", "collapsedElevation", "F", "fadeAnimDuration", "expandedElevation", "expandingViewId", "Ljava/lang/Integer;", "expandedMarginTop", "collapsedRadius", "collapsedMarginTop", "collapsedMarginEnd", "Landroid/animation/AnimatorSet;", "expandedRadius", "collapsedHeight", "expandedHeight", "expandedMarginStart", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ExpandingCardView extends MaterialCardView {
    private AnimatorSet animatorSet;
    private float collapsedElevation;
    private int collapsedHeight;
    private int collapsedMarginBottom;
    private int collapsedMarginEnd;
    private int collapsedMarginStart;
    private int collapsedMarginTop;
    private float collapsedRadius;
    private final long expandAnimDuration;
    private float expandedElevation;
    private int expandedHeight;
    private int expandedMarginBottom;
    private int expandedMarginEnd;
    private int expandedMarginStart;
    private int expandedMarginTop;
    private float expandedRadius;
    private View expandingView;
    private Integer expandingViewId;
    private final long fadeAnimDuration;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpandingCardView(Context context) {
        this(context, null, 0);
        m.g(context, "context");
    }

    public static final /* synthetic */ View access$getExpandingView$p(ExpandingCardView expandingCardView) {
        return expandingCardView.expandingView;
    }

    public static final /* synthetic */ void access$setCollapsed(ExpandingCardView expandingCardView) {
        expandingCardView.setCollapsed();
    }

    public static final /* synthetic */ void access$setCollapsedHeight$p(ExpandingCardView expandingCardView, int i2) {
        expandingCardView.collapsedHeight = i2;
    }

    public static final /* synthetic */ void access$setExpanded(ExpandingCardView expandingCardView) {
        expandingCardView.setExpanded();
    }

    public static final /* synthetic */ void access$setExpandedHeight$p(ExpandingCardView expandingCardView, int i2) {
        expandingCardView.expandedHeight = i2;
    }

    private final AnimatorSet animatorSet(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(layoutParamsAnimator(z), elevationAnimator(z), cornerRadiusAnimator(z), expandingViewAlphaAnimator(z));
        return animatorSet;
    }

    public static /* synthetic */ void c(ExpandingCardView expandingCardView) {
        m1260expand$lambda6(expandingCardView);
    }

    /* renamed from: collapse$lambda-4 */
    public static final void m1259collapse$lambda4(ExpandingCardView this$0) {
        m.g(this$0, "this$0");
        AnimatorSet animatorSet = this$0.animatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this$0.animatorSet(true);
        animatorSet2.start();
        x xVar = x.a;
        this$0.animatorSet = animatorSet2;
    }

    private final Animator cornerRadiusAnimator(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "radius", z ? this.collapsedRadius : this.expandedRadius);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(this.expandAnimDuration);
        m.f(ofFloat, "ofFloat(this, \"radius\", endRadius).apply {\n            interpolator = AccelerateDecelerateInterpolator()\n            duration = expandAnimDuration\n        }");
        return ofFloat;
    }

    public static /* synthetic */ void d(ValueAnimator valueAnimator, ExpandingCardView expandingCardView, ValueAnimator valueAnimator2) {
        m1261layoutParamsAnimator$lambda12$lambda11(valueAnimator, expandingCardView, valueAnimator2);
    }

    public static /* synthetic */ void e(ExpandingCardView expandingCardView) {
        m1259collapse$lambda4(expandingCardView);
    }

    private final Animator elevationAnimator(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "cardElevation", z ? this.collapsedElevation : this.expandedElevation);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(this.expandAnimDuration);
        m.f(ofFloat, "ofFloat(this, \"cardElevation\", endElevation).apply {\n            interpolator = AccelerateDecelerateInterpolator()\n            duration = expandAnimDuration\n        }");
        return ofFloat;
    }

    /* renamed from: expand$lambda-6 */
    public static final void m1260expand$lambda6(ExpandingCardView this$0) {
        m.g(this$0, "this$0");
        AnimatorSet animatorSet = this$0.animatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this$0.animatorSet(false);
        animatorSet2.start();
        x xVar = x.a;
        this$0.animatorSet = animatorSet2;
    }

    private final Animator expandingViewAlphaAnimator(final boolean z) {
        float f2 = z ? 0.0f : 1.0f;
        View view = this.expandingView;
        if (view == null) {
            return null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", f2);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(this.fadeAnimDuration);
        if (!z) {
            ofFloat.setStartDelay(this.fadeAnimDuration);
        }
        m.f(ofFloat, "");
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.coinbase.wallet.features.commonui.views.ExpandingCardView$expandingViewAlphaAnimator$lambda-18$lambda-17$$inlined$doOnStart$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                m.g(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                m.g(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                m.g(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View access$getExpandingView$p;
                m.g(animator, "animator");
                if (z || (access$getExpandingView$p = ExpandingCardView.access$getExpandingView$p(this)) == null) {
                    return;
                }
                access$getExpandingView$p.setVisibility(0);
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.coinbase.wallet.features.commonui.views.ExpandingCardView$expandingViewAlphaAnimator$lambda-18$lambda-17$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                m.g(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                View access$getExpandingView$p;
                m.g(animator, "animator");
                if (!z || (access$getExpandingView$p = ExpandingCardView.access$getExpandingView$p(this)) == null) {
                    return;
                }
                access$getExpandingView$p.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                m.g(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                m.g(animator, "animator");
            }
        });
        return ofFloat;
    }

    private final Animator layoutParamsAnimator(boolean z) {
        int i2 = this.collapsedHeight;
        float height = (getHeight() - i2) / (this.expandedHeight - i2);
        float f2 = z ? 0.0f : 1.0f;
        float f3 = z ? 0.0f : 1.0f;
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(height, f2);
        ofFloat.setInterpolator(new OvershootInterpolator(f3));
        ofFloat.setDuration(this.expandAnimDuration);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coinbase.wallet.features.commonui.views.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ExpandingCardView.d(ofFloat, this, valueAnimator);
            }
        });
        m.f(ofFloat, "ofFloat(start, end).apply {\n            interpolator = OvershootInterpolator(tension)\n            duration = expandAnimDuration\n            addUpdateListener {\n                val progress = animatedValue as Float\n                updateLayoutParams<MarginLayoutParams> {\n                    height = progressValue(collapsedHeight, expandedHeight, progress)\n                    topMargin = progressValue(collapsedMarginTop, expandedMarginTop, progress)\n                    bottomMargin = progressValue(collapsedMarginBottom, expandedMarginBottom, progress)\n                    marginStart = progressValue(collapsedMarginStart, expandedMarginStart, progress)\n                    marginEnd = progressValue(collapsedMarginEnd, expandedMarginEnd, progress)\n                }\n            }\n        }");
        return ofFloat;
    }

    /* renamed from: layoutParamsAnimator$lambda-12$lambda-11 */
    public static final void m1261layoutParamsAnimator$lambda12$lambda11(ValueAnimator valueAnimator, ExpandingCardView this$0, ValueAnimator valueAnimator2) {
        m.g(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        ViewGroup.LayoutParams layoutParams = this$0.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.height = this$0.progressValue(this$0.collapsedHeight, this$0.expandedHeight, floatValue);
        marginLayoutParams.topMargin = this$0.progressValue(this$0.collapsedMarginTop, this$0.expandedMarginTop, floatValue);
        marginLayoutParams.bottomMargin = this$0.progressValue(this$0.collapsedMarginBottom, this$0.expandedMarginBottom, floatValue);
        marginLayoutParams.setMarginStart(this$0.progressValue(this$0.collapsedMarginStart, this$0.expandedMarginStart, floatValue));
        marginLayoutParams.setMarginEnd(this$0.progressValue(this$0.collapsedMarginEnd, this$0.expandedMarginEnd, floatValue));
        this$0.setLayoutParams(marginLayoutParams);
    }

    private final int progressValue(int i2, int i3, float f2) {
        return i2 + ((int) ((i3 - i2) * f2));
    }

    public final void setCollapsed() {
        View view = this.expandingView;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.expandingView;
        if (view2 != null) {
            view2.setAlpha(0.0f);
        }
        setCardElevation(this.collapsedElevation);
        setRadius(this.collapsedRadius);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = this.collapsedMarginTop;
        marginLayoutParams.bottomMargin = this.collapsedMarginBottom;
        marginLayoutParams.setMarginStart(this.collapsedMarginStart);
        marginLayoutParams.setMarginEnd(this.collapsedMarginEnd);
        setLayoutParams(marginLayoutParams);
    }

    public final void setExpanded() {
        View view = this.expandingView;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.expandingView;
        if (view2 != null) {
            view2.setAlpha(1.0f);
        }
        setCardElevation(this.expandedElevation);
        setRadius(this.expandedRadius);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = this.expandedMarginTop;
        marginLayoutParams.bottomMargin = this.expandedMarginBottom;
        marginLayoutParams.setMarginStart(this.expandedMarginStart);
        marginLayoutParams.setMarginEnd(this.expandedMarginEnd);
        setLayoutParams(marginLayoutParams);
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final void collapse() {
        getRootView().post(new Runnable() { // from class: com.coinbase.wallet.features.commonui.views.c
            @Override // java.lang.Runnable
            public final void run() {
                ExpandingCardView.e(ExpandingCardView.this);
            }
        });
    }

    public final void expand() {
        getRootView().post(new Runnable() { // from class: com.coinbase.wallet.features.commonui.views.a
            @Override // java.lang.Runnable
            public final void run() {
                ExpandingCardView.c(ExpandingCardView.this);
            }
        });
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        Integer num = this.expandingViewId;
        this.expandingView = num == null ? null : findViewById(num.intValue());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        this.collapsedMarginTop = marginLayoutParams != null ? marginLayoutParams.topMargin : 0;
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? layoutParams2 : null;
        this.collapsedMarginBottom = marginLayoutParams2 != null ? marginLayoutParams2.bottomMargin : 0;
        ViewGroup.LayoutParams layoutParams3 = getLayoutParams();
        this.collapsedMarginStart = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? g.b((ViewGroup.MarginLayoutParams) layoutParams3) : 0;
        ViewGroup.LayoutParams layoutParams4 = getLayoutParams();
        this.collapsedMarginEnd = layoutParams4 instanceof ViewGroup.MarginLayoutParams ? g.a((ViewGroup.MarginLayoutParams) layoutParams4) : 0;
        this.collapsedElevation = getCardElevation();
        float radius = getRadius();
        this.collapsedRadius = radius;
        if (this.expandedMarginTop == -1) {
            this.expandedMarginTop = this.collapsedMarginTop;
        }
        if (this.expandedMarginBottom == -1) {
            this.expandedMarginBottom = this.collapsedMarginBottom;
        }
        if (this.expandedMarginStart == -1) {
            this.expandedMarginStart = this.collapsedMarginStart;
        }
        if (this.expandedMarginEnd == -1) {
            this.expandedMarginEnd = this.collapsedMarginEnd;
        }
        if (this.expandedElevation == -1.0f) {
            this.expandedElevation = this.collapsedElevation;
        }
        if (this.expandedRadius == -1.0f) {
            this.expandedRadius = radius;
        }
        setClickable(true);
        setFocusable(true);
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.coinbase.wallet.features.commonui.views.ExpandingCardView$onFinishInflate$$inlined$doOnNextLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                m.g(view, "view");
                view.removeOnLayoutChangeListener(this);
                ExpandingCardView.access$setExpanded(ExpandingCardView.this);
                ExpandingCardView.this.measure(0, 0);
                ExpandingCardView expandingCardView = ExpandingCardView.this;
                ExpandingCardView.access$setExpandedHeight$p(expandingCardView, expandingCardView.getHeight());
                ExpandingCardView.access$setCollapsed(ExpandingCardView.this);
                ExpandingCardView.this.measure(0, 0);
                ExpandingCardView expandingCardView2 = ExpandingCardView.this;
                ExpandingCardView.access$setCollapsedHeight$p(expandingCardView2, expandingCardView2.getMeasuredHeight());
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpandingCardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        m.g(context, "context");
        m.g(attrs, "attrs");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandingCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        m.g(context, "context");
        this.collapsedMarginTop = -1;
        this.collapsedMarginBottom = -1;
        this.collapsedMarginStart = -1;
        this.collapsedMarginEnd = -1;
        this.expandedMarginTop = -1;
        this.expandedMarginBottom = -1;
        this.expandedMarginStart = -1;
        this.expandedMarginEnd = -1;
        this.collapsedElevation = -1.0f;
        this.expandedElevation = -1.0f;
        this.collapsedRadius = -1.0f;
        this.expandedRadius = -1.0f;
        this.expandAnimDuration = 400L;
        this.fadeAnimDuration = 400 / 2;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, e.j.b.T, i2, 0);
        try {
            m.f(obtainStyledAttributes, "");
            this.expandingViewId = Integer.valueOf(androidx.core.content.d.g.b(obtainStyledAttributes, 6));
            this.expandedMarginTop = obtainStyledAttributes.getDimensionPixelSize(5, this.collapsedMarginTop);
            this.expandedMarginBottom = obtainStyledAttributes.getDimensionPixelSize(2, this.collapsedMarginBottom);
            this.expandedMarginStart = obtainStyledAttributes.getDimensionPixelSize(4, this.collapsedMarginStart);
            this.expandedMarginEnd = obtainStyledAttributes.getDimensionPixelSize(3, this.collapsedMarginEnd);
            this.expandedElevation = obtainStyledAttributes.getDimensionPixelSize(1, (int) this.collapsedElevation);
            this.expandedRadius = obtainStyledAttributes.getDimensionPixelSize(0, (int) this.collapsedRadius);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}