package com.coinbase.wallet.commonui.utilities.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import c.s.e0;
import c.s.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: TranslateTransition.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/animation/TranslateTransition;", "Lc/s/y;", "Lc/s/e0;", "values", "Lkotlin/x;", "captureValues", "(Lc/s/e0;)V", "transitionValues", "captureStartValues", "captureEndValues", "Landroid/view/ViewGroup;", "sceneRoot", "startValues", "endValues", "Landroid/animation/Animator;", "createAnimator", "(Landroid/view/ViewGroup;Lc/s/e0;Lc/s/e0;)Landroid/animation/Animator;", "<init>", "()V", "Companion", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TranslateTransition extends y {
    public static final Companion Companion = new Companion(null);
    private static final String viewDimensionsKey = "viewDimensions";

    /* compiled from: TranslateTransition.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/animation/TranslateTransition$Companion;", "", "", "viewDimensionsKey", "Ljava/lang/String;", "<init>", "()V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void captureValues(e0 e0Var) {
        View view = e0Var.f3289b;
        if (view != null && view.isLaidOut()) {
            Map<String, Object> map = e0Var.a;
            m.f(map, "values.values");
            map.put(viewDimensionsKey, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        }
    }

    @Override // c.s.y
    public void captureEndValues(e0 transitionValues) {
        m.g(transitionValues, "transitionValues");
        captureValues(transitionValues);
    }

    @Override // c.s.y
    public void captureStartValues(e0 transitionValues) {
        m.g(transitionValues, "transitionValues");
        captureValues(transitionValues);
    }

    @Override // c.s.y
    public Animator createAnimator(ViewGroup sceneRoot, e0 e0Var, e0 e0Var2) {
        m.g(sceneRoot, "sceneRoot");
        if (e0Var != null && e0Var2 != null) {
            Object obj = e0Var.a.get(viewDimensionsKey);
            Rect rect = obj instanceof Rect ? (Rect) obj : null;
            Object obj2 = e0Var2.a.get(viewDimensionsKey);
            Rect rect2 = obj2 instanceof Rect ? (Rect) obj2 : null;
            if (rect != null && rect2 != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(e0Var2.f3289b, "translationX", rect.exactCenterX() - rect2.exactCenterX(), 0.0f);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(e0Var2.f3289b, "translationY", rect.exactCenterY() - rect2.exactCenterY(), 0.0f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ofFloat, ofFloat2);
                return animatorSet;
            }
        }
        return null;
    }
}