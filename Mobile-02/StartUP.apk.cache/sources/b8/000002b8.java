package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.os.c;
import androidx.fragment.app.v;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentAnim.java */
/* loaded from: classes.dex */
public class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentAnim.java */
    /* loaded from: classes.dex */
    public static class a implements c.a {
        final /* synthetic */ Fragment a;

        a(Fragment fragment) {
            this.a = fragment;
        }

        @Override // androidx.core.os.c.a
        public void a() {
            if (this.a.getAnimatingAway() != null) {
                View animatingAway = this.a.getAnimatingAway();
                this.a.setAnimatingAway(null);
                animatingAway.clearAnimation();
            }
            this.a.setAnimator(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentAnim.java */
    /* loaded from: classes.dex */
    public static class b implements Animation.AnimationListener {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Fragment f1609b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ v.g f1610c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ androidx.core.os.c f1611d;

        /* compiled from: FragmentAnim.java */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f1609b.getAnimatingAway() != null) {
                    b.this.f1609b.setAnimatingAway(null);
                    b bVar = b.this;
                    bVar.f1610c.a(bVar.f1609b, bVar.f1611d);
                }
            }
        }

        b(ViewGroup viewGroup, Fragment fragment, v.g gVar, androidx.core.os.c cVar) {
            this.a = viewGroup;
            this.f1609b = fragment;
            this.f1610c = gVar;
            this.f1611d = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentAnim.java */
    /* loaded from: classes.dex */
    public static class c extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f1612b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Fragment f1613c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ v.g f1614d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ androidx.core.os.c f1615e;

        c(ViewGroup viewGroup, View view, Fragment fragment, v.g gVar, androidx.core.os.c cVar) {
            this.a = viewGroup;
            this.f1612b = view;
            this.f1613c = fragment;
            this.f1614d = gVar;
            this.f1615e = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.endViewTransition(this.f1612b);
            Animator animator2 = this.f1613c.getAnimator();
            this.f1613c.setAnimator(null);
            if (animator2 == null || this.a.indexOfChild(this.f1612b) >= 0) {
                return;
            }
            this.f1614d.a(this.f1613c, this.f1615e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Fragment fragment, d dVar, v.g gVar) {
        View view = fragment.mView;
        ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        androidx.core.os.c cVar = new androidx.core.os.c();
        cVar.d(new a(fragment));
        gVar.b(fragment, cVar);
        if (dVar.a != null) {
            RunnableC0032e runnableC0032e = new RunnableC0032e(dVar.a, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            runnableC0032e.setAnimationListener(new b(viewGroup, fragment, gVar, cVar));
            fragment.mView.startAnimation(runnableC0032e);
            return;
        }
        Animator animator = dVar.f1616b;
        fragment.setAnimator(animator);
        animator.addListener(new c(viewGroup, view, fragment, gVar, cVar));
        animator.setTarget(fragment.mView);
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d b(Context context, f fVar, Fragment fragment, boolean z) {
        int c2;
        int nextTransition = fragment.getNextTransition();
        int nextAnim = fragment.getNextAnim();
        boolean z2 = false;
        fragment.setNextAnim(0);
        View b2 = fVar.b(fragment.mContainerId);
        if (b2 != null) {
            int i2 = c.l.b.f3136b;
            if (b2.getTag(i2) != null) {
                b2.setTag(i2, null);
            }
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null || viewGroup.getLayoutTransition() == null) {
            Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z, nextAnim);
            if (onCreateAnimation != null) {
                return new d(onCreateAnimation);
            }
            Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z, nextAnim);
            if (onCreateAnimator != null) {
                return new d(onCreateAnimator);
            }
            if (nextAnim != 0) {
                boolean equals = "anim".equals(context.getResources().getResourceTypeName(nextAnim));
                if (equals) {
                    try {
                        Animation loadAnimation = AnimationUtils.loadAnimation(context, nextAnim);
                        if (loadAnimation != null) {
                            return new d(loadAnimation);
                        }
                        z2 = true;
                    } catch (Resources.NotFoundException e2) {
                        throw e2;
                    } catch (RuntimeException unused) {
                    }
                }
                if (!z2) {
                    try {
                        Animator loadAnimator = AnimatorInflater.loadAnimator(context, nextAnim);
                        if (loadAnimator != null) {
                            return new d(loadAnimator);
                        }
                    } catch (RuntimeException e3) {
                        if (!equals) {
                            Animation loadAnimation2 = AnimationUtils.loadAnimation(context, nextAnim);
                            if (loadAnimation2 != null) {
                                return new d(loadAnimation2);
                            }
                        } else {
                            throw e3;
                        }
                    }
                }
            }
            if (nextTransition != 0 && (c2 = c(nextTransition, z)) >= 0) {
                return new d(AnimationUtils.loadAnimation(context, c2));
            }
            return null;
        }
        return null;
    }

    private static int c(int i2, boolean z) {
        if (i2 == 4097) {
            return z ? c.l.a.f3134e : c.l.a.f3135f;
        } else if (i2 == 4099) {
            return z ? c.l.a.f3132c : c.l.a.f3133d;
        } else if (i2 != 8194) {
            return -1;
        } else {
            return z ? c.l.a.a : c.l.a.f3131b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentAnim.java */
    /* loaded from: classes.dex */
    public static class d {
        public final Animation a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f1616b;

        d(Animation animation) {
            this.a = animation;
            this.f1616b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        d(Animator animator) {
            this.a = null;
            this.f1616b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FragmentAnim.java */
    /* renamed from: androidx.fragment.app.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0032e extends AnimationSet implements Runnable {
        private final ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        private final View f1617b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1618c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1619d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1620e;

        RunnableC0032e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f1620e = true;
            this.a = viewGroup;
            this.f1617b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j2, Transformation transformation) {
            this.f1620e = true;
            if (this.f1618c) {
                return !this.f1619d;
            }
            if (!super.getTransformation(j2, transformation)) {
                this.f1618c = true;
                c.h.k.s.a(this.a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f1618c && this.f1620e) {
                this.f1620e = false;
                this.a.post(this);
                return;
            }
            this.a.endViewTransition(this.f1617b);
            this.f1619d = true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j2, Transformation transformation, float f2) {
            this.f1620e = true;
            if (this.f1618c) {
                return !this.f1619d;
            }
            if (!super.getTransformation(j2, transformation, f2)) {
                this.f1618c = true;
                c.h.k.s.a(this.a, this);
            }
            return true;
        }
    }
}