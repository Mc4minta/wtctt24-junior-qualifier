package c.s;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import c.s.a;
import c.s.y;

/* compiled from: Visibility.java */
/* loaded from: classes.dex */
public abstract class w0 extends y {
    private static final String[] a = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: b  reason: collision with root package name */
    private int f3376b = 3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Visibility.java */
    /* loaded from: classes.dex */
    public class a extends z {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f3377b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f3378c;

        a(ViewGroup viewGroup, View view, View view2) {
            this.a = viewGroup;
            this.f3377b = view;
            this.f3378c = view2;
        }

        @Override // c.s.z, c.s.y.g
        public void b(y yVar) {
            k0.b(this.a).d(this.f3377b);
        }

        @Override // c.s.y.g
        public void c(y yVar) {
            this.f3378c.setTag(s.f3353e, null);
            k0.b(this.a).d(this.f3377b);
            yVar.removeListener(this);
        }

        @Override // c.s.z, c.s.y.g
        public void e(y yVar) {
            if (this.f3377b.getParent() == null) {
                k0.b(this.a).c(this.f3377b);
            } else {
                w0.this.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Visibility.java */
    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter implements y.g, a.InterfaceC0088a {
        private final View a;

        /* renamed from: b  reason: collision with root package name */
        private final int f3380b;

        /* renamed from: c  reason: collision with root package name */
        private final ViewGroup f3381c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f3382d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f3383e;

        /* renamed from: f  reason: collision with root package name */
        boolean f3384f = false;

        b(View view, int i2, boolean z) {
            this.a = view;
            this.f3380b = i2;
            this.f3381c = (ViewGroup) view.getParent();
            this.f3382d = z;
            g(true);
        }

        private void f() {
            if (!this.f3384f) {
                p0.i(this.a, this.f3380b);
                ViewGroup viewGroup = this.f3381c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        private void g(boolean z) {
            ViewGroup viewGroup;
            if (!this.f3382d || this.f3383e == z || (viewGroup = this.f3381c) == null) {
                return;
            }
            this.f3383e = z;
            k0.d(viewGroup, z);
        }

        @Override // c.s.y.g
        public void a(y yVar) {
        }

        @Override // c.s.y.g
        public void b(y yVar) {
            g(false);
        }

        @Override // c.s.y.g
        public void c(y yVar) {
            f();
            yVar.removeListener(this);
        }

        @Override // c.s.y.g
        public void d(y yVar) {
        }

        @Override // c.s.y.g
        public void e(y yVar) {
            g(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3384f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, c.s.a.InterfaceC0088a
        public void onAnimationPause(Animator animator) {
            if (this.f3384f) {
                return;
            }
            p0.i(this.a, this.f3380b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, c.s.a.InterfaceC0088a
        public void onAnimationResume(Animator animator) {
            if (this.f3384f) {
                return;
            }
            p0.i(this.a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Visibility.java */
    /* loaded from: classes.dex */
    public static class c {
        boolean a;

        /* renamed from: b  reason: collision with root package name */
        boolean f3385b;

        /* renamed from: c  reason: collision with root package name */
        int f3386c;

        /* renamed from: d  reason: collision with root package name */
        int f3387d;

        /* renamed from: e  reason: collision with root package name */
        ViewGroup f3388e;

        /* renamed from: f  reason: collision with root package name */
        ViewGroup f3389f;

        c() {
        }
    }

    private c b(e0 e0Var, e0 e0Var2) {
        c cVar = new c();
        cVar.a = false;
        cVar.f3385b = false;
        if (e0Var != null && e0Var.a.containsKey("android:visibility:visibility")) {
            cVar.f3386c = ((Integer) e0Var.a.get("android:visibility:visibility")).intValue();
            cVar.f3388e = (ViewGroup) e0Var.a.get("android:visibility:parent");
        } else {
            cVar.f3386c = -1;
            cVar.f3388e = null;
        }
        if (e0Var2 != null && e0Var2.a.containsKey("android:visibility:visibility")) {
            cVar.f3387d = ((Integer) e0Var2.a.get("android:visibility:visibility")).intValue();
            cVar.f3389f = (ViewGroup) e0Var2.a.get("android:visibility:parent");
        } else {
            cVar.f3387d = -1;
            cVar.f3389f = null;
        }
        if (e0Var != null && e0Var2 != null) {
            int i2 = cVar.f3386c;
            int i3 = cVar.f3387d;
            if (i2 == i3 && cVar.f3388e == cVar.f3389f) {
                return cVar;
            }
            if (i2 != i3) {
                if (i2 == 0) {
                    cVar.f3385b = false;
                    cVar.a = true;
                } else if (i3 == 0) {
                    cVar.f3385b = true;
                    cVar.a = true;
                }
            } else if (cVar.f3389f == null) {
                cVar.f3385b = false;
                cVar.a = true;
            } else if (cVar.f3388e == null) {
                cVar.f3385b = true;
                cVar.a = true;
            }
        } else if (e0Var == null && cVar.f3387d == 0) {
            cVar.f3385b = true;
            cVar.a = true;
        } else if (e0Var2 == null && cVar.f3386c == 0) {
            cVar.f3385b = false;
            cVar.a = true;
        }
        return cVar;
    }

    private void captureValues(e0 e0Var) {
        e0Var.a.put("android:visibility:visibility", Integer.valueOf(e0Var.f3289b.getVisibility()));
        e0Var.a.put("android:visibility:parent", e0Var.f3289b.getParent());
        int[] iArr = new int[2];
        e0Var.f3289b.getLocationOnScreen(iArr);
        e0Var.a.put("android:visibility:screenLocation", iArr);
    }

    public abstract Animator c(ViewGroup viewGroup, View view, e0 e0Var, e0 e0Var2);

    @Override // c.s.y
    public void captureEndValues(e0 e0Var) {
        captureValues(e0Var);
    }

    @Override // c.s.y
    public void captureStartValues(e0 e0Var) {
        captureValues(e0Var);
    }

    @Override // c.s.y
    public Animator createAnimator(ViewGroup viewGroup, e0 e0Var, e0 e0Var2) {
        c b2 = b(e0Var, e0Var2);
        if (b2.a) {
            if (b2.f3388e == null && b2.f3389f == null) {
                return null;
            }
            if (b2.f3385b) {
                return d(viewGroup, e0Var, b2.f3386c, e0Var2, b2.f3387d);
            }
            return f(viewGroup, e0Var, b2.f3386c, e0Var2, b2.f3387d);
        }
        return null;
    }

    public Animator d(ViewGroup viewGroup, e0 e0Var, int i2, e0 e0Var2, int i3) {
        if ((this.f3376b & 1) != 1 || e0Var2 == null) {
            return null;
        }
        if (e0Var == null) {
            View view = (View) e0Var2.f3289b.getParent();
            if (b(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).a) {
                return null;
            }
        }
        return c(viewGroup, e0Var2.f3289b, e0Var, e0Var2);
    }

    public abstract Animator e(ViewGroup viewGroup, View view, e0 e0Var, e0 e0Var2);

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0089, code lost:
        if (r17.mCanRemoveViews != false) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.animation.Animator f(android.view.ViewGroup r18, c.s.e0 r19, int r20, c.s.e0 r21, int r22) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.s.w0.f(android.view.ViewGroup, c.s.e0, int, c.s.e0, int):android.animation.Animator");
    }

    @Override // c.s.y
    public String[] getTransitionProperties() {
        return a;
    }

    public void h(int i2) {
        if ((i2 & (-4)) == 0) {
            this.f3376b = i2;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    @Override // c.s.y
    public boolean isTransitionRequired(e0 e0Var, e0 e0Var2) {
        if (e0Var == null && e0Var2 == null) {
            return false;
        }
        if (e0Var == null || e0Var2 == null || e0Var2.a.containsKey("android:visibility:visibility") == e0Var.a.containsKey("android:visibility:visibility")) {
            c b2 = b(e0Var, e0Var2);
            if (b2.a) {
                return b2.f3386c == 0 || b2.f3387d == 0;
            }
            return false;
        }
        return false;
    }
}