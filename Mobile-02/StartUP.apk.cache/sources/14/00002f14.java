package com.facebook.react.uimanager.f1;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: OpacityAnimation.java */
/* loaded from: classes2.dex */
class l extends Animation {
    private final View a;

    /* renamed from: b  reason: collision with root package name */
    private final float f5107b;

    /* renamed from: c  reason: collision with root package name */
    private final float f5108c;

    /* compiled from: OpacityAnimation.java */
    /* loaded from: classes2.dex */
    static class a implements Animation.AnimationListener {
        private final View a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f5109b = false;

        public a(View view) {
            this.a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.f5109b) {
                this.a.setLayerType(0, null);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (this.a.hasOverlappingRendering() && this.a.getLayerType() == 0) {
                this.f5109b = true;
                this.a.setLayerType(2, null);
            }
        }
    }

    public l(View view, float f2, float f3) {
        this.a = view;
        this.f5107b = f2;
        this.f5108c = f3 - f2;
        setAnimationListener(new a(view));
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f2, Transformation transformation) {
        this.a.setAlpha(this.f5107b + (this.f5108c * f2));
    }

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return false;
    }
}