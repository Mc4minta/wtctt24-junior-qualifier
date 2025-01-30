package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import com.coinbase.wallet.commonui.extensions.OnSingleClickListener;
import com.lwansbrough.RCTCamera.RCTCameraModule;

/* compiled from: TooltipCompatHandler.java */
/* loaded from: classes.dex */
class v0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    private static v0 a;

    /* renamed from: b  reason: collision with root package name */
    private static v0 f934b;

    /* renamed from: c  reason: collision with root package name */
    private final View f935c;

    /* renamed from: d  reason: collision with root package name */
    private final CharSequence f936d;

    /* renamed from: e  reason: collision with root package name */
    private final int f937e;

    /* renamed from: f  reason: collision with root package name */
    private final Runnable f938f = new a();

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f939g = new b();

    /* renamed from: h  reason: collision with root package name */
    private int f940h;

    /* renamed from: j  reason: collision with root package name */
    private int f941j;

    /* renamed from: k  reason: collision with root package name */
    private w0 f942k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f943l;

    /* compiled from: TooltipCompatHandler.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v0.this.g(false);
        }
    }

    /* compiled from: TooltipCompatHandler.java */
    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v0.this.c();
        }
    }

    private v0(View view, CharSequence charSequence) {
        this.f935c = view;
        this.f936d = charSequence;
        this.f937e = c.h.k.w.c(ViewConfiguration.get(view.getContext()));
        b();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void a() {
        this.f935c.removeCallbacks(this.f938f);
    }

    private void b() {
        this.f940h = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.f941j = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
    }

    private void d() {
        this.f935c.postDelayed(this.f938f, ViewConfiguration.getLongPressTimeout());
    }

    private static void e(v0 v0Var) {
        v0 v0Var2 = a;
        if (v0Var2 != null) {
            v0Var2.a();
        }
        a = v0Var;
        if (v0Var != null) {
            v0Var.d();
        }
    }

    public static void f(View view, CharSequence charSequence) {
        v0 v0Var = a;
        if (v0Var != null && v0Var.f935c == view) {
            e(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            v0 v0Var2 = f934b;
            if (v0Var2 != null && v0Var2.f935c == view) {
                v0Var2.c();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new v0(view, charSequence);
    }

    private boolean h(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f940h) > this.f937e || Math.abs(y - this.f941j) > this.f937e) {
            this.f940h = x;
            this.f941j = y;
            return true;
        }
        return false;
    }

    void c() {
        if (f934b == this) {
            f934b = null;
            w0 w0Var = this.f942k;
            if (w0Var != null) {
                w0Var.c();
                this.f942k = null;
                b();
                this.f935c.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (a == this) {
            e(null);
        }
        this.f935c.removeCallbacks(this.f939g);
    }

    void g(boolean z) {
        long j2;
        int longPressTimeout;
        long j3;
        if (c.h.k.v.Q(this.f935c)) {
            e(null);
            v0 v0Var = f934b;
            if (v0Var != null) {
                v0Var.c();
            }
            f934b = this;
            this.f943l = z;
            w0 w0Var = new w0(this.f935c.getContext());
            this.f942k = w0Var;
            w0Var.e(this.f935c, this.f940h, this.f941j, this.f943l, this.f936d);
            this.f935c.addOnAttachStateChangeListener(this);
            if (this.f943l) {
                j3 = OnSingleClickListener.LONG_DELAY_MS;
            } else {
                if ((c.h.k.v.J(this.f935c) & 1) == 1) {
                    j2 = 3000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                } else {
                    j2 = 15000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                }
                j3 = j2 - longPressTimeout;
            }
            this.f935c.removeCallbacks(this.f939g);
            this.f935c.postDelayed(this.f939g, j3);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f942k == null || !this.f943l) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.f935c.getContext().getSystemService("accessibility");
            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 7) {
                if (action == 10) {
                    b();
                    c();
                }
            } else if (this.f935c.isEnabled() && this.f942k == null && h(motionEvent)) {
                e(this);
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f940h = view.getWidth() / 2;
        this.f941j = view.getHeight() / 2;
        g(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        c();
    }
}