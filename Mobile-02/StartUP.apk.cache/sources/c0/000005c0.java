package c.h.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat.java */
/* loaded from: classes.dex */
public final class z {
    private WeakReference<View> a;

    /* renamed from: b  reason: collision with root package name */
    Runnable f3072b = null;

    /* renamed from: c  reason: collision with root package name */
    Runnable f3073c = null;

    /* renamed from: d  reason: collision with root package name */
    int f3074d = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        final /* synthetic */ a0 a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f3075b;

        a(a0 a0Var, View view) {
            this.a = a0Var;
            this.f3075b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a.a(this.f3075b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.b(this.f3075b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.c(this.f3075b);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* loaded from: classes.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ c0 a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f3077b;

        b(c0 c0Var, View view) {
            this.a = c0Var;
            this.f3077b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.a(this.f3077b);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* loaded from: classes.dex */
    static class c implements a0 {
        z a;

        /* renamed from: b  reason: collision with root package name */
        boolean f3079b;

        c(z zVar) {
            this.a = zVar;
        }

        @Override // c.h.k.a0
        public void a(View view) {
            Object tag = view.getTag(2113929216);
            a0 a0Var = tag instanceof a0 ? (a0) tag : null;
            if (a0Var != null) {
                a0Var.a(view);
            }
        }

        @Override // c.h.k.a0
        @SuppressLint({"WrongConstant"})
        public void b(View view) {
            int i2 = this.a.f3074d;
            if (i2 > -1) {
                view.setLayerType(i2, null);
                this.a.f3074d = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f3079b) {
                z zVar = this.a;
                Runnable runnable = zVar.f3073c;
                if (runnable != null) {
                    zVar.f3073c = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                a0 a0Var = tag instanceof a0 ? (a0) tag : null;
                if (a0Var != null) {
                    a0Var.b(view);
                }
                this.f3079b = true;
            }
        }

        @Override // c.h.k.a0
        public void c(View view) {
            this.f3079b = false;
            if (this.a.f3074d > -1) {
                view.setLayerType(2, null);
            }
            z zVar = this.a;
            Runnable runnable = zVar.f3072b;
            if (runnable != null) {
                zVar.f3072b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            a0 a0Var = tag instanceof a0 ? (a0) tag : null;
            if (a0Var != null) {
                a0Var.c(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(View view) {
        this.a = new WeakReference<>(view);
    }

    private void g(View view, a0 a0Var) {
        if (a0Var != null) {
            view.animate().setListener(new a(a0Var, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public z a(float f2) {
        View view = this.a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public void b() {
        View view = this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long c() {
        View view = this.a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public z d(long j2) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
        return this;
    }

    public z e(Interpolator interpolator) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public z f(a0 a0Var) {
        View view = this.a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                g(view, a0Var);
            } else {
                view.setTag(2113929216, a0Var);
                g(view, new c(this));
            }
        }
        return this;
    }

    public z h(long j2) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setStartDelay(j2);
        }
        return this;
    }

    public z i(c0 c0Var) {
        View view = this.a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(c0Var != null ? new b(c0Var, view) : null);
        }
        return this;
    }

    public void j() {
        View view = this.a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public z k(float f2) {
        View view = this.a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }
}