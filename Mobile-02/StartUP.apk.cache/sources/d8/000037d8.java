package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.h.k.v;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e.g.a.f.f;
import e.g.a.f.l.h;
import e.g.a.f.l.i;
import e.g.a.f.l.j;
import e.g.a.f.n.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c  reason: collision with root package name */
    private final Rect f8288c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f8289d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f8290e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f8291f;

    /* loaded from: classes2.dex */
    class a extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f8292b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f8293c;

        a(boolean z, View view, View view2) {
            this.a = z;
            this.f8292b = view;
            this.f8293c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            this.f8292b.setVisibility(4);
            this.f8293c.setAlpha(1.0f);
            this.f8293c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.a) {
                this.f8292b.setVisibility(0);
                this.f8293c.setAlpha(0.0f);
                this.f8293c.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ View a;

        b(View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends AnimatorListenerAdapter {
        final /* synthetic */ e.g.a.f.n.d a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Drawable f8296b;

        c(e.g.a.f.n.d dVar, Drawable drawable) {
            this.a = dVar;
            this.f8296b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.setCircularRevealOverlayDrawable(this.f8296b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d extends AnimatorListenerAdapter {
        final /* synthetic */ e.g.a.f.n.d a;

        d(e.g.a.f.n.d dVar) {
            this.a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.e revealInfo = this.a.getRevealInfo();
            revealInfo.f13326c = Float.MAX_VALUE;
            this.a.setRevealInfo(revealInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class e {
        public h a;

        /* renamed from: b  reason: collision with root package name */
        public j f8299b;
    }

    public FabTransformationBehavior() {
        this.f8288c = new Rect();
        this.f8289d = new RectF();
        this.f8290e = new RectF();
        this.f8291f = new int[2];
    }

    private ViewGroup J(View view) {
        View findViewById = view.findViewById(f.f13259g);
        if (findViewById != null) {
            return b0(findViewById);
        }
        if (!(view instanceof com.google.android.material.transformation.b) && !(view instanceof com.google.android.material.transformation.a)) {
            return b0(view);
        }
        return b0(((ViewGroup) view).getChildAt(0));
    }

    private void K(View view, e eVar, i iVar, i iVar2, float f2, float f3, float f4, float f5, RectF rectF) {
        float P = P(eVar, iVar, f2, f4);
        float P2 = P(eVar, iVar2, f3, f5);
        Rect rect = this.f8288c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f8289d;
        rectF2.set(rect);
        RectF rectF3 = this.f8290e;
        Q(view, rectF3);
        rectF3.offset(P, P2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private float L(View view, View view2, j jVar) {
        RectF rectF = this.f8289d;
        RectF rectF2 = this.f8290e;
        Q(view, rectF);
        Q(view2, rectF2);
        rectF2.offset(-N(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float M(View view, View view2, j jVar) {
        RectF rectF = this.f8289d;
        RectF rectF2 = this.f8290e;
        Q(view, rectF);
        Q(view2, rectF2);
        rectF2.offset(0.0f, -O(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private float N(View view, View view2, j jVar) {
        float centerX;
        float centerX2;
        float f2;
        RectF rectF = this.f8289d;
        RectF rectF2 = this.f8290e;
        Q(view, rectF);
        Q(view2, rectF2);
        int i2 = jVar.a & 7;
        if (i2 == 1) {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        } else if (i2 == 3) {
            centerX = rectF2.left;
            centerX2 = rectF.left;
        } else if (i2 == 5) {
            centerX = rectF2.right;
            centerX2 = rectF.right;
        } else {
            f2 = 0.0f;
            return f2 + jVar.f13303b;
        }
        f2 = centerX - centerX2;
        return f2 + jVar.f13303b;
    }

    private float O(View view, View view2, j jVar) {
        float centerY;
        float centerY2;
        float f2;
        RectF rectF = this.f8289d;
        RectF rectF2 = this.f8290e;
        Q(view, rectF);
        Q(view2, rectF2);
        int i2 = jVar.a & 112;
        if (i2 == 16) {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        } else if (i2 == 48) {
            centerY = rectF2.top;
            centerY2 = rectF.top;
        } else if (i2 == 80) {
            centerY = rectF2.bottom;
            centerY2 = rectF.bottom;
        } else {
            f2 = 0.0f;
            return f2 + jVar.f13304c;
        }
        f2 = centerY - centerY2;
        return f2 + jVar.f13304c;
    }

    private float P(e eVar, i iVar, float f2, float f3) {
        long c2 = iVar.c();
        long d2 = iVar.d();
        i d3 = eVar.a.d("expansion");
        return e.g.a.f.l.a.a(f2, f3, iVar.e().getInterpolation(((float) (((d3.c() + d3.d()) + 17) - c2)) / ((float) d2)));
    }

    private void Q(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.f8291f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void R(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup J;
        ObjectAnimator ofFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof e.g.a.f.n.d) && e.g.a.f.n.c.a == 0) || (J = J(view2)) == null) {
                return;
            }
            if (z) {
                if (!z2) {
                    e.g.a.f.l.d.a.set(J, Float.valueOf(0.0f));
                }
                ofFloat = ObjectAnimator.ofFloat(J, e.g.a.f.l.d.a, 1.0f);
            } else {
                ofFloat = ObjectAnimator.ofFloat(J, e.g.a.f.l.d.a, 0.0f);
            }
            eVar.a.d("contentFade").a(ofFloat);
            list.add(ofFloat);
        }
    }

    private void S(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if (view2 instanceof e.g.a.f.n.d) {
            e.g.a.f.n.d dVar = (e.g.a.f.n.d) view2;
            int Z = Z(view);
            int i2 = 16777215 & Z;
            if (z) {
                if (!z2) {
                    dVar.setCircularRevealScrimColor(Z);
                }
                ofInt = ObjectAnimator.ofInt(dVar, d.C0305d.a, i2);
            } else {
                ofInt = ObjectAnimator.ofInt(dVar, d.C0305d.a, Z);
            }
            ofInt.setEvaluator(e.g.a.f.l.c.b());
            eVar.a.d("color").a(ofInt);
            list.add(ofInt);
        }
    }

    @TargetApi(21)
    private void T(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        float t = v.t(view2) - v.t(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-t);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -t);
        }
        eVar.a.d("elevation").a(ofFloat);
        list.add(ofFloat);
    }

    private void U(View view, View view2, boolean z, boolean z2, e eVar, float f2, float f3, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animator;
        if (view2 instanceof e.g.a.f.n.d) {
            e.g.a.f.n.d dVar = (e.g.a.f.n.d) view2;
            float L = L(view, view2, eVar.f8299b);
            float M = M(view, view2, eVar.f8299b);
            ((FloatingActionButton) view).h(this.f8288c);
            float width = this.f8288c.width() / 2.0f;
            i d2 = eVar.a.d("expansion");
            if (z) {
                if (!z2) {
                    dVar.setRevealInfo(new d.e(L, M, width));
                }
                if (z2) {
                    width = dVar.getRevealInfo().f13326c;
                }
                animator = e.g.a.f.n.a.a(dVar, L, M, e.g.a.f.p.a.b(L, M, 0.0f, 0.0f, f2, f3));
                animator.addListener(new d(dVar));
                X(view2, d2.c(), (int) L, (int) M, width, list);
            } else {
                float f4 = dVar.getRevealInfo().f13326c;
                Animator a2 = e.g.a.f.n.a.a(dVar, L, M, width);
                int i2 = (int) L;
                int i3 = (int) M;
                X(view2, d2.c(), i2, i3, f4, list);
                W(view2, d2.c(), d2.d(), eVar.a.e(), i2, i3, width, list);
                animator = a2;
            }
            d2.a(animator);
            list.add(animator);
            list2.add(e.g.a.f.n.a.b(dVar));
        }
    }

    private void V(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if ((view2 instanceof e.g.a.f.n.d) && (view instanceof ImageView)) {
            e.g.a.f.n.d dVar = (e.g.a.f.n.d) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z) {
                if (!z2) {
                    drawable.setAlpha(255);
                }
                ofInt = ObjectAnimator.ofInt(drawable, e.g.a.f.l.e.a, 0);
            } else {
                ofInt = ObjectAnimator.ofInt(drawable, e.g.a.f.l.e.a, 255);
            }
            ofInt.addUpdateListener(new b(view2));
            eVar.a.d("iconFade").a(ofInt);
            list.add(ofInt);
            list2.add(new c(dVar, drawable));
        }
    }

    private void W(View view, long j2, long j3, long j4, int i2, int i3, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j5 = j2 + j3;
            if (j5 < j4) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
                createCircularReveal.setStartDelay(j5);
                createCircularReveal.setDuration(j4 - j5);
                list.add(createCircularReveal);
            }
        }
    }

    private void X(View view, long j2, int i2, int i3, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT < 21 || j2 <= 0) {
            return;
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
        createCircularReveal.setStartDelay(0L);
        createCircularReveal.setDuration(j2);
        list.add(createCircularReveal);
    }

    private void Y(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        i d2;
        i d3;
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        int i2;
        float N = N(view, view2, eVar.f8299b);
        float O = O(view, view2, eVar.f8299b);
        if (N == 0.0f || O == 0.0f) {
            d2 = eVar.a.d("translationXLinear");
            d3 = eVar.a.d("translationYLinear");
        } else if ((z && O < 0.0f) || (!z && i2 > 0)) {
            d2 = eVar.a.d("translationXCurveUpwards");
            d3 = eVar.a.d("translationYCurveUpwards");
        } else {
            d2 = eVar.a.d("translationXCurveDownwards");
            d3 = eVar.a.d("translationYCurveDownwards");
        }
        i iVar = d2;
        i iVar2 = d3;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-N);
                view2.setTranslationY(-O);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f);
            K(view2, eVar, iVar, iVar2, -N, -O, 0.0f, 0.0f, rectF);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, -N);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, -O);
        }
        iVar.a(ofFloat);
        iVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    private int Z(View view) {
        ColorStateList p = v.p(view);
        if (p != null) {
            return p.getColorForState(view.getDrawableState(), p.getDefaultColor());
        }
        return 0;
    }

    private ViewGroup b0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet I(View view, View view2, boolean z, boolean z2) {
        e a0 = a0(view2.getContext(), z);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            T(view, view2, z, z2, a0, arrayList, arrayList2);
        }
        RectF rectF = this.f8289d;
        Y(view, view2, z, z2, a0, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        V(view, view2, z, z2, a0, arrayList, arrayList2);
        U(view, view2, z, z2, a0, width, height, arrayList, arrayList2);
        S(view, view2, z, z2, a0, arrayList, arrayList2);
        R(view, view2, z, z2, a0, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        e.g.a.f.l.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z, view2, view));
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            animatorSet.addListener(arrayList2.get(i2));
        }
        return animatorSet;
    }

    protected abstract e a0(Context context, boolean z);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() != 8) {
            if (view2 instanceof FloatingActionButton) {
                int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
                return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
            }
            return false;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f fVar) {
        if (fVar.f1371h == 0) {
            fVar.f1371h = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8288c = new Rect();
        this.f8289d = new RectF();
        this.f8290e = new RectF();
        this.f8291f = new int[2];
    }
}