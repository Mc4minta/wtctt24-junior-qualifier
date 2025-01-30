package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import com.google.android.material.internal.j;
import java.util.ArrayList;

/* compiled from: FloatingActionButtonImplLollipop.java */
/* loaded from: classes2.dex */
class b extends a {
    private InsetDrawable I;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(j jVar, e.g.a.f.s.b bVar) {
        super(jVar, bVar);
    }

    private Animator R(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.B, "elevation", f2).setDuration(0L)).with(ObjectAnimator.ofFloat(this.B, View.TRANSLATION_Z, f3).setDuration(100L));
        animatorSet.setInterpolator(a.a);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.a
    boolean C() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.a
    public void K(ColorStateList colorStateList) {
        Drawable drawable = this.r;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(e.g.a.f.r.a.a(colorStateList));
        } else {
            super.K(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public float j() {
        return this.B.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void m(Rect rect) {
        if (this.C.c()) {
            float d2 = this.C.d();
            float j2 = j() + this.w;
            int ceil = (int) Math.ceil(e.g.a.f.s.a.c(j2, d2, false));
            int ceil2 = (int) Math.ceil(e.g.a.f.s.a.d(j2, d2, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.a
    public void s() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.a
    public void u() {
        Q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.a
    public void w(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (this.B.isEnabled()) {
                this.B.setElevation(this.u);
                if (this.B.isPressed()) {
                    this.B.setTranslationZ(this.w);
                    return;
                } else if (!this.B.isFocused() && !this.B.isHovered()) {
                    this.B.setTranslationZ(0.0f);
                    return;
                } else {
                    this.B.setTranslationZ(this.v);
                    return;
                }
            }
            this.B.setElevation(0.0f);
            this.B.setTranslationZ(0.0f);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void x(float f2, float f3, float f4) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 21) {
            this.B.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(a.f8153b, R(f2, f4));
            stateListAnimator.addState(a.f8154c, R(f2, f3));
            stateListAnimator.addState(a.f8155d, R(f2, f3));
            stateListAnimator.addState(a.f8156e, R(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.B, "elevation", f2).setDuration(0L));
            if (i2 >= 22 && i2 <= 24) {
                j jVar = this.B;
                arrayList.add(ObjectAnimator.ofFloat(jVar, View.TRANSLATION_Z, jVar.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.B, View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(a.a);
            stateListAnimator.addState(a.f8157f, animatorSet);
            stateListAnimator.addState(a.f8158g, R(0.0f, 0.0f));
            this.B.setStateListAnimator(stateListAnimator);
        }
        if (this.C.c()) {
            Q();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void y(Rect rect) {
        if (this.C.c()) {
            InsetDrawable insetDrawable = new InsetDrawable(this.r, rect.left, rect.top, rect.right, rect.bottom);
            this.I = insetDrawable;
            this.C.b(insetDrawable);
            return;
        }
        this.C.b(this.r);
    }
}