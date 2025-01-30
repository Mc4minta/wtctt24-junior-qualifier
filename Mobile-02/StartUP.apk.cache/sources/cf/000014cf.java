package com.coinbase.wallet.commonui.utilities.animation;

import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import kotlin.Metadata;

/* compiled from: ShakeAnimation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroid/view/animation/Animation;", "shakeAnimation", "()Landroid/view/animation/Animation;", "commonui_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ShakeAnimationKt {
    public static final Animation shakeAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 20.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setInterpolator(new CycleInterpolator(3.0f));
        return translateAnimation;
    }
}