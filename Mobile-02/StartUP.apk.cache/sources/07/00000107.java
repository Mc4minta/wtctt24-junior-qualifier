package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* compiled from: ForwardingListener.java */
/* loaded from: classes.dex */
public abstract class c0 implements View.OnTouchListener, View.OnAttachStateChangeListener {
    private final float a;

    /* renamed from: b  reason: collision with root package name */
    private final int f762b;

    /* renamed from: c  reason: collision with root package name */
    private final int f763c;

    /* renamed from: d  reason: collision with root package name */
    final View f764d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f765e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f766f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f767g;

    /* renamed from: h  reason: collision with root package name */
    private int f768h;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f769j = new int[2];

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ForwardingListener.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = c0.this.f764d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ForwardingListener.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.e();
        }
    }

    public c0(View view) {
        this.f764d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f762b = tapTimeout;
        this.f763c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.f766f;
        if (runnable != null) {
            this.f764d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f765e;
        if (runnable2 != null) {
            this.f764d.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) {
        a0 a0Var;
        View view = this.f764d;
        androidx.appcompat.view.menu.p b2 = b();
        if (b2 == null || !b2.a() || (a0Var = (a0) b2.k()) == null || !a0Var.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, obtainNoHistory);
        j(a0Var, obtainNoHistory);
        boolean e2 = a0Var.e(obtainNoHistory, this.f768h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return e2 && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
        if (r1 != 3) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f764d
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L41
            r3 = 1
            if (r1 == r3) goto L3d
            r4 = 2
            if (r1 == r4) goto L1a
            r6 = 3
            if (r1 == r6) goto L3d
            goto L6d
        L1a:
            int r1 = r5.f768h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.a
            boolean r6 = h(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.a()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.f768h = r6
            java.lang.Runnable r6 = r5.f765e
            if (r6 != 0) goto L52
            androidx.appcompat.widget.c0$a r6 = new androidx.appcompat.widget.c0$a
            r6.<init>()
            r5.f765e = r6
        L52:
            java.lang.Runnable r6 = r5.f765e
            int r1 = r5.f762b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f766f
            if (r6 != 0) goto L65
            androidx.appcompat.widget.c0$b r6 = new androidx.appcompat.widget.c0$b
            r6.<init>()
            r5.f766f = r6
        L65:
            java.lang.Runnable r6 = r5.f766f
            int r1 = r5.f763c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.c0.g(android.view.MotionEvent):boolean");
    }

    private static boolean h(View view, float f2, float f3, float f4) {
        float f5 = -f4;
        return f2 >= f5 && f3 >= f5 && f2 < ((float) (view.getRight() - view.getLeft())) + f4 && f3 < ((float) (view.getBottom() - view.getTop())) + f4;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        int[] iArr = this.f769j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(iArr[0], iArr[1]);
        return true;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        int[] iArr = this.f769j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(-iArr[0], -iArr[1]);
        return true;
    }

    public abstract androidx.appcompat.view.menu.p b();

    protected abstract boolean c();

    protected boolean d() {
        androidx.appcompat.view.menu.p b2 = b();
        if (b2 == null || !b2.a()) {
            return true;
        }
        b2.dismiss();
        return true;
    }

    void e() {
        a();
        View view = this.f764d;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f767g = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f767g;
        if (z2) {
            z = f(motionEvent) || !d();
        } else {
            z = g(motionEvent) && c();
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f764d.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f767g = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f767g = false;
        this.f768h = -1;
        Runnable runnable = this.f765e;
        if (runnable != null) {
            this.f764d.removeCallbacks(runnable);
        }
    }
}