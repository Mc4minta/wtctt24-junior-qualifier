package com.coinbase.wallet.commonui.extensions;

import android.view.View;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import c.h.k.v;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Fragment+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/coinbase/wallet/commonui/extensions/Fragment_CommonKt$fixOnCreateAnimation$1", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "Lkotlin/x;", "onAnimationStart", "(Landroid/view/animation/Animation;)V", "onAnimationEnd", "onAnimationRepeat", "", "startZ", "F", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Fragment_CommonKt$fixOnCreateAnimation$1 implements Animation.AnimationListener {
    final /* synthetic */ Fragment $this_fixOnCreateAnimation;
    private float startZ;

    public Fragment_CommonKt$fixOnCreateAnimation$1(Fragment fragment) {
        this.$this_fixOnCreateAnimation = fragment;
    }

    public static /* synthetic */ void a(View view, Fragment_CommonKt$fixOnCreateAnimation$1 fragment_CommonKt$fixOnCreateAnimation$1) {
        m797onAnimationEnd$lambda2$lambda1(view, fragment_CommonKt$fixOnCreateAnimation$1);
    }

    /* renamed from: onAnimationEnd$lambda-2$lambda-1 */
    public static final void m797onAnimationEnd$lambda2$lambda1(View this_apply, Fragment_CommonKt$fixOnCreateAnimation$1 this$0) {
        m.g(this_apply, "$this_apply");
        m.g(this$0, "this$0");
        v.B0(this_apply, this$0.startZ);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        m.g(animation, "animation");
        final View view = this.$this_fixOnCreateAnimation.getView();
        if (view == null) {
            return;
        }
        view.postDelayed(new Runnable() { // from class: com.coinbase.wallet.commonui.extensions.c
            @Override // java.lang.Runnable
            public final void run() {
                Fragment_CommonKt$fixOnCreateAnimation$1.a(view, this);
            }
        }, 100L);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        m.g(animation, "animation");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        m.g(animation, "animation");
        View view = this.$this_fixOnCreateAnimation.getView();
        if (view == null) {
            return;
        }
        this.startZ = v.I(view);
        v.B0(view, 1.0f);
    }
}