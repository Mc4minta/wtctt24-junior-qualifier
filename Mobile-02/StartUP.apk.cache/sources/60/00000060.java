package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.s0;
import androidx.appcompat.widget.x;
import androidx.appcompat.widget.x0;
import androidx.appcompat.widget.y0;
import androidx.core.content.d.f;
import androidx.lifecycle.i;
import c.a.o.b;
import c.a.o.f;
import c.h.k.d0;
import c.h.k.e;
import c.h.k.v;
import c.h.k.z;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.lang.Thread;
import java.util.List;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppCompatDelegateImpl.java */
/* loaded from: classes.dex */
public class g extends androidx.appcompat.app.f implements g.a, LayoutInflater.Factory2 {

    /* renamed from: d  reason: collision with root package name */
    private static final c.e.g<String, Integer> f450d = new c.e.g<>();

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f451e;

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f452f;

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f453g;

    /* renamed from: h  reason: collision with root package name */
    private static final boolean f454h;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f455j;
    PopupWindow A;
    Runnable B;
    z C;
    private boolean D;
    private boolean E;
    ViewGroup F;
    private TextView G;
    private View H;
    private boolean I;
    private boolean J;
    boolean K;
    boolean L;
    boolean M;
    boolean N;
    boolean O;
    private boolean P;
    private t[] Q;
    private t R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    boolean W;
    private int X;
    private int Y;
    private boolean Z;
    private boolean a0;
    private m b0;
    private m c0;
    boolean d0;
    int e0;
    private final Runnable f0;
    private boolean g0;
    private Rect h0;
    private Rect i0;
    private androidx.appcompat.app.j j0;

    /* renamed from: k  reason: collision with root package name */
    final Object f456k;

    /* renamed from: l  reason: collision with root package name */
    final Context f457l;
    Window m;
    private k n;
    final androidx.appcompat.app.e p;
    androidx.appcompat.app.a q;
    MenuInflater t;
    private CharSequence u;
    private x v;
    private i w;
    private u x;
    c.a.o.b y;
    ActionBarContextView z;

    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    class a implements Thread.UncaughtExceptionHandler {
        final /* synthetic */ Thread.UncaughtExceptionHandler a;

        a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.a = uncaughtExceptionHandler;
        }

        private boolean a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (a(th)) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                notFoundException.initCause(th.getCause());
                notFoundException.setStackTrace(th.getStackTrace());
                this.a.uncaughtException(thread, notFoundException);
                return;
            }
            this.a.uncaughtException(thread, th);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            if ((gVar.e0 & 1) != 0) {
                gVar.X(0);
            }
            g gVar2 = g.this;
            if ((gVar2.e0 & 4096) != 0) {
                gVar2.X(108);
            }
            g gVar3 = g.this;
            gVar3.d0 = false;
            gVar3.e0 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public class c implements c.h.k.q {
        c() {
        }

        @Override // c.h.k.q
        public d0 a(View view, d0 d0Var) {
            int l2 = d0Var.l();
            int N0 = g.this.N0(d0Var, null);
            if (l2 != N0) {
                d0Var = d0Var.p(d0Var.j(), N0, d0Var.k(), d0Var.i());
            }
            return v.Z(view, d0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public class d implements b0.a {
        d() {
        }

        @Override // androidx.appcompat.widget.b0.a
        public void a(Rect rect) {
            rect.top = g.this.N0(null, rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public class e implements ContentFrameLayout.a {
        e() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            g.this.V();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* compiled from: AppCompatDelegateImpl.java */
        /* loaded from: classes.dex */
        class a extends c.h.k.b0 {
            a() {
            }

            @Override // c.h.k.a0
            public void b(View view) {
                g.this.z.setAlpha(1.0f);
                g.this.C.f(null);
                g.this.C = null;
            }

            @Override // c.h.k.b0, c.h.k.a0
            public void c(View view) {
                g.this.z.setVisibility(0);
            }
        }

        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.A.showAtLocation(gVar.z, 55, 0, 0);
            g.this.Y();
            if (g.this.G0()) {
                g.this.z.setAlpha(0.0f);
                g gVar2 = g.this;
                gVar2.C = v.c(gVar2.z).a(1.0f);
                g.this.C.f(new a());
                return;
            }
            g.this.z.setAlpha(1.0f);
            g.this.z.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: androidx.appcompat.app.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0006g extends c.h.k.b0 {
        C0006g() {
        }

        @Override // c.h.k.a0
        public void b(View view) {
            g.this.z.setAlpha(1.0f);
            g.this.C.f(null);
            g.this.C = null;
        }

        @Override // c.h.k.b0, c.h.k.a0
        public void c(View view) {
            g.this.z.setVisibility(0);
            g.this.z.sendAccessibilityEvent(32);
            if (g.this.z.getParent() instanceof View) {
                v.h0((View) g.this.z.getParent());
            }
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    private class h implements androidx.appcompat.app.b {
        h() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public final class i implements m.a {
        i() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
            g.this.O(gVar);
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            Window.Callback i0 = g.this.i0();
            if (i0 != null) {
                i0.onMenuOpened(108, gVar);
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public class j implements b.a {
        private b.a a;

        /* compiled from: AppCompatDelegateImpl.java */
        /* loaded from: classes.dex */
        class a extends c.h.k.b0 {
            a() {
            }

            @Override // c.h.k.a0
            public void b(View view) {
                g.this.z.setVisibility(8);
                g gVar = g.this;
                PopupWindow popupWindow = gVar.A;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (gVar.z.getParent() instanceof View) {
                    v.h0((View) g.this.z.getParent());
                }
                g.this.z.removeAllViews();
                g.this.C.f(null);
                g gVar2 = g.this;
                gVar2.C = null;
                v.h0(gVar2.F);
            }
        }

        public j(b.a aVar) {
            this.a = aVar;
        }

        @Override // c.a.o.b.a
        public void a(c.a.o.b bVar) {
            this.a.a(bVar);
            g gVar = g.this;
            if (gVar.A != null) {
                gVar.m.getDecorView().removeCallbacks(g.this.B);
            }
            g gVar2 = g.this;
            if (gVar2.z != null) {
                gVar2.Y();
                g gVar3 = g.this;
                gVar3.C = v.c(gVar3.z).a(0.0f);
                g.this.C.f(new a());
            }
            g gVar4 = g.this;
            androidx.appcompat.app.e eVar = gVar4.p;
            if (eVar != null) {
                eVar.onSupportActionModeFinished(gVar4.y);
            }
            g gVar5 = g.this;
            gVar5.y = null;
            v.h0(gVar5.F);
        }

        @Override // c.a.o.b.a
        public boolean b(c.a.o.b bVar, Menu menu) {
            return this.a.b(bVar, menu);
        }

        @Override // c.a.o.b.a
        public boolean c(c.a.o.b bVar, Menu menu) {
            v.h0(g.this.F);
            return this.a.c(bVar, menu);
        }

        @Override // c.a.o.b.a
        public boolean d(c.a.o.b bVar, MenuItem menuItem) {
            return this.a.d(bVar, menuItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public class l extends m {

        /* renamed from: c  reason: collision with root package name */
        private final PowerManager f460c;

        l(Context context) {
            super();
            this.f460c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.g.m
        IntentFilter b() {
            if (Build.VERSION.SDK_INT >= 21) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            }
            return null;
        }

        @Override // androidx.appcompat.app.g.m
        public int c() {
            return (Build.VERSION.SDK_INT < 21 || !this.f460c.isPowerSaveMode()) ? 1 : 2;
        }

        @Override // androidx.appcompat.app.g.m
        public void d() {
            g.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public abstract class m {
        private BroadcastReceiver a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AppCompatDelegateImpl.java */
        /* loaded from: classes.dex */
        public class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                m.this.d();
            }
        }

        m() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.a;
            if (broadcastReceiver != null) {
                try {
                    g.this.f457l.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter b2 = b();
            if (b2 == null || b2.countActions() == 0) {
                return;
            }
            if (this.a == null) {
                this.a = new a();
            }
            g.this.f457l.registerReceiver(this.a, b2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public class n extends m {

        /* renamed from: c  reason: collision with root package name */
        private final androidx.appcompat.app.n f463c;

        n(androidx.appcompat.app.n nVar) {
            super();
            this.f463c = nVar;
        }

        @Override // androidx.appcompat.app.g.m
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.g.m
        public int c() {
            return this.f463c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.g.m
        public void d() {
            g.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public static class o {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i2 = configuration.densityDpi;
            int i3 = configuration2.densityDpi;
            if (i2 != i3) {
                configuration3.densityDpi = i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public static class p {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public static class q {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i2 = configuration.colorMode & 3;
            int i3 = configuration2.colorMode;
            if (i2 != (i3 & 3)) {
                configuration3.colorMode |= i3 & 3;
            }
            int i4 = configuration.colorMode & 12;
            int i5 = configuration2.colorMode;
            if (i4 != (i5 & 12)) {
                configuration3.colorMode |= i5 & 12;
            }
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    private static class r {
        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public class s extends ContentFrameLayout {
        public s(Context context) {
            super(context);
        }

        private boolean c(int i2, int i3) {
            return i2 < -5 || i3 < -5 || i2 > getWidth() + 5 || i3 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return g.this.W(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && c((int) motionEvent.getX(), (int) motionEvent.getY())) {
                g.this.Q(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i2) {
            setBackgroundDrawable(c.a.k.a.a.d(getContext(), i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public static final class t {
        int a;

        /* renamed from: b  reason: collision with root package name */
        int f466b;

        /* renamed from: c  reason: collision with root package name */
        int f467c;

        /* renamed from: d  reason: collision with root package name */
        int f468d;

        /* renamed from: e  reason: collision with root package name */
        int f469e;

        /* renamed from: f  reason: collision with root package name */
        int f470f;

        /* renamed from: g  reason: collision with root package name */
        ViewGroup f471g;

        /* renamed from: h  reason: collision with root package name */
        View f472h;

        /* renamed from: i  reason: collision with root package name */
        View f473i;

        /* renamed from: j  reason: collision with root package name */
        androidx.appcompat.view.menu.g f474j;

        /* renamed from: k  reason: collision with root package name */
        androidx.appcompat.view.menu.e f475k;

        /* renamed from: l  reason: collision with root package name */
        Context f476l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        t(int i2) {
            this.a = i2;
        }

        androidx.appcompat.view.menu.n a(m.a aVar) {
            if (this.f474j == null) {
                return null;
            }
            if (this.f475k == null) {
                androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(this.f476l, c.a.g.f2479j);
                this.f475k = eVar;
                eVar.g(aVar);
                this.f474j.b(this.f475k);
            }
            return this.f475k.h(this.f471g);
        }

        public boolean b() {
            if (this.f472h == null) {
                return false;
            }
            return this.f473i != null || this.f475k.a().getCount() > 0;
        }

        void c(androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.e eVar;
            androidx.appcompat.view.menu.g gVar2 = this.f474j;
            if (gVar == gVar2) {
                return;
            }
            if (gVar2 != null) {
                gVar2.Q(this.f475k);
            }
            this.f474j = gVar;
            if (gVar == null || (eVar = this.f475k) == null) {
                return;
            }
            gVar.b(eVar);
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(c.a.a.a, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                newTheme.applyStyle(i2, true);
            }
            newTheme.resolveAttribute(c.a.a.E, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                newTheme.applyStyle(i3, true);
            } else {
                newTheme.applyStyle(c.a.i.f2494c, true);
            }
            c.a.o.d dVar = new c.a.o.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.f476l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(c.a.j.z0);
            this.f466b = obtainStyledAttributes.getResourceId(c.a.j.C0, 0);
            this.f470f = obtainStyledAttributes.getResourceId(c.a.j.B0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public final class u implements m.a {
        u() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
            androidx.appcompat.view.menu.g F = gVar.F();
            boolean z2 = F != gVar;
            g gVar2 = g.this;
            if (z2) {
                gVar = F;
            }
            t b0 = gVar2.b0(gVar);
            if (b0 != null) {
                if (z2) {
                    g.this.N(b0.a, b0, F);
                    g.this.R(b0, true);
                    return;
                }
                g.this.R(b0, z);
            }
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            Window.Callback i0;
            if (gVar == gVar.F()) {
                g gVar2 = g.this;
                if (!gVar2.K || (i0 = gVar2.i0()) == null || g.this.W) {
                    return true;
                }
                i0.onMenuOpened(108, gVar);
                return true;
            }
            return true;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        boolean z = i2 < 21;
        f451e = z;
        f452f = new int[]{16842836};
        f453g = !"robolectric".equals(Build.FINGERPRINT);
        f454h = i2 >= 17;
        if (!z || f455j) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
        f455j = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Activity activity, androidx.appcompat.app.e eVar) {
        this(activity, null, eVar, activity);
    }

    private void A0(t tVar, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (tVar.o || this.W) {
            return;
        }
        if (tVar.a == 0) {
            if ((this.f457l.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback i0 = i0();
        if (i0 != null && !i0.onMenuOpened(tVar.a, tVar.f474j)) {
            R(tVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f457l.getSystemService("window");
        if (windowManager != null && D0(tVar, keyEvent)) {
            ViewGroup viewGroup = tVar.f471g;
            if (viewGroup != null && !tVar.q) {
                View view = tVar.f473i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i2 = -1;
                    tVar.n = false;
                    WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i2, -2, tVar.f468d, tVar.f469e, RNCWebViewManager.COMMAND_CLEAR_HISTORY, 8519680, -3);
                    layoutParams2.gravity = tVar.f467c;
                    layoutParams2.windowAnimations = tVar.f470f;
                    windowManager.addView(tVar.f471g, layoutParams2);
                    tVar.o = true;
                }
            } else {
                if (viewGroup == null) {
                    if (!l0(tVar) || tVar.f471g == null) {
                        return;
                    }
                } else if (tVar.q && viewGroup.getChildCount() > 0) {
                    tVar.f471g.removeAllViews();
                }
                if (k0(tVar) && tVar.b()) {
                    ViewGroup.LayoutParams layoutParams3 = tVar.f472h.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
                    }
                    tVar.f471g.setBackgroundResource(tVar.f466b);
                    ViewParent parent = tVar.f472h.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(tVar.f472h);
                    }
                    tVar.f471g.addView(tVar.f472h, layoutParams3);
                    if (!tVar.f472h.hasFocus()) {
                        tVar.f472h.requestFocus();
                    }
                } else {
                    tVar.q = true;
                    return;
                }
            }
            i2 = -2;
            tVar.n = false;
            WindowManager.LayoutParams layoutParams22 = new WindowManager.LayoutParams(i2, -2, tVar.f468d, tVar.f469e, RNCWebViewManager.COMMAND_CLEAR_HISTORY, 8519680, -3);
            layoutParams22.gravity = tVar.f467c;
            layoutParams22.windowAnimations = tVar.f470f;
            windowManager.addView(tVar.f471g, layoutParams22);
            tVar.o = true;
        }
    }

    private boolean C0(t tVar, int i2, KeyEvent keyEvent, int i3) {
        androidx.appcompat.view.menu.g gVar;
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((tVar.m || D0(tVar, keyEvent)) && (gVar = tVar.f474j) != null) {
            z = gVar.performShortcut(i2, keyEvent, i3);
        }
        if (z && (i3 & 1) == 0 && this.v == null) {
            R(tVar, true);
        }
        return z;
    }

    private boolean D0(t tVar, KeyEvent keyEvent) {
        x xVar;
        x xVar2;
        x xVar3;
        if (this.W) {
            return false;
        }
        if (tVar.m) {
            return true;
        }
        t tVar2 = this.R;
        if (tVar2 != null && tVar2 != tVar) {
            R(tVar2, false);
        }
        Window.Callback i0 = i0();
        if (i0 != null) {
            tVar.f473i = i0.onCreatePanelView(tVar.a);
        }
        int i2 = tVar.a;
        boolean z = i2 == 0 || i2 == 108;
        if (z && (xVar3 = this.v) != null) {
            xVar3.c();
        }
        if (tVar.f473i == null && (!z || !(B0() instanceof androidx.appcompat.app.l))) {
            androidx.appcompat.view.menu.g gVar = tVar.f474j;
            if (gVar == null || tVar.r) {
                if (gVar == null && (!m0(tVar) || tVar.f474j == null)) {
                    return false;
                }
                if (z && this.v != null) {
                    if (this.w == null) {
                        this.w = new i();
                    }
                    this.v.a(tVar.f474j, this.w);
                }
                tVar.f474j.h0();
                if (!i0.onCreatePanelMenu(tVar.a, tVar.f474j)) {
                    tVar.c(null);
                    if (z && (xVar = this.v) != null) {
                        xVar.a(null, this.w);
                    }
                    return false;
                }
                tVar.r = false;
            }
            tVar.f474j.h0();
            Bundle bundle = tVar.s;
            if (bundle != null) {
                tVar.f474j.R(bundle);
                tVar.s = null;
            }
            if (!i0.onPreparePanel(0, tVar.f473i, tVar.f474j)) {
                if (z && (xVar2 = this.v) != null) {
                    xVar2.a(null, this.w);
                }
                tVar.f474j.g0();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            tVar.p = z2;
            tVar.f474j.setQwertyMode(z2);
            tVar.f474j.g0();
        }
        tVar.m = true;
        tVar.n = false;
        this.R = tVar;
        return true;
    }

    private void E0(boolean z) {
        x xVar = this.v;
        if (xVar != null && xVar.d() && (!ViewConfiguration.get(this.f457l).hasPermanentMenuKey() || this.v.f())) {
            Window.Callback i0 = i0();
            if (this.v.b() && z) {
                this.v.g();
                if (this.W) {
                    return;
                }
                i0.onPanelClosed(108, g0(0, true).f474j);
                return;
            } else if (i0 == null || this.W) {
                return;
            } else {
                if (this.d0 && (this.e0 & 1) != 0) {
                    this.m.getDecorView().removeCallbacks(this.f0);
                    this.f0.run();
                }
                t g0 = g0(0, true);
                androidx.appcompat.view.menu.g gVar = g0.f474j;
                if (gVar == null || g0.r || !i0.onPreparePanel(0, g0.f473i, gVar)) {
                    return;
                }
                i0.onMenuOpened(108, g0.f474j);
                this.v.h();
                return;
            }
        }
        t g02 = g0(0, true);
        g02.q = true;
        R(g02, false);
        A0(g02, null);
    }

    private int F0(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i2 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        } else {
            return i2;
        }
    }

    private boolean H0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.m.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || v.Q((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private boolean J(boolean z) {
        if (this.W) {
            return false;
        }
        int M = M();
        boolean L0 = L0(q0(this.f457l, M), z);
        if (M == 0) {
            f0(this.f457l).e();
        } else {
            m mVar = this.b0;
            if (mVar != null) {
                mVar.a();
            }
        }
        if (M == 3) {
            e0(this.f457l).e();
        } else {
            m mVar2 = this.c0;
            if (mVar2 != null) {
                mVar2.a();
            }
        }
        return L0;
    }

    private void J0() {
        if (this.E) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void K() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.F.findViewById(16908290);
        View decorView = this.m.getDecorView();
        contentFrameLayout.b(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f457l.obtainStyledAttributes(c.a.j.z0);
        obtainStyledAttributes.getValue(c.a.j.L0, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(c.a.j.M0, contentFrameLayout.getMinWidthMinor());
        int i2 = c.a.j.J0;
        if (obtainStyledAttributes.hasValue(i2)) {
            obtainStyledAttributes.getValue(i2, contentFrameLayout.getFixedWidthMajor());
        }
        int i3 = c.a.j.K0;
        if (obtainStyledAttributes.hasValue(i3)) {
            obtainStyledAttributes.getValue(i3, contentFrameLayout.getFixedWidthMinor());
        }
        int i4 = c.a.j.H0;
        if (obtainStyledAttributes.hasValue(i4)) {
            obtainStyledAttributes.getValue(i4, contentFrameLayout.getFixedHeightMajor());
        }
        int i5 = c.a.j.I0;
        if (obtainStyledAttributes.hasValue(i5)) {
            obtainStyledAttributes.getValue(i5, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private androidx.appcompat.app.d K0() {
        for (Context context = this.f457l; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof androidx.appcompat.app.d) {
                return (androidx.appcompat.app.d) context;
            }
            if (!(context instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private void L(Window window) {
        if (this.m == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof k)) {
                k kVar = new k(callback);
                this.n = kVar;
                window.setCallback(kVar);
                s0 u2 = s0.u(this.f457l, null, f452f);
                Drawable h2 = u2.h(0);
                if (h2 != null) {
                    window.setBackgroundDrawable(h2);
                }
                u2.w();
                this.m = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean L0(int r7, boolean r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.f457l
            r1 = 0
            android.content.res.Configuration r0 = r6.S(r0, r7, r1)
            boolean r2 = r6.o0()
            android.content.Context r3 = r6.f457l
            android.content.res.Resources r3 = r3.getResources()
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.uiMode
            r3 = r3 & 48
            int r0 = r0.uiMode
            r0 = r0 & 48
            r4 = 1
            if (r3 == r0) goto L47
            if (r8 == 0) goto L47
            if (r2 != 0) goto L47
            boolean r8 = r6.T
            if (r8 == 0) goto L47
            boolean r8 = androidx.appcompat.app.g.f453g
            if (r8 != 0) goto L30
            boolean r8 = r6.U
            if (r8 == 0) goto L47
        L30:
            java.lang.Object r8 = r6.f456k
            boolean r5 = r8 instanceof android.app.Activity
            if (r5 == 0) goto L47
            android.app.Activity r8 = (android.app.Activity) r8
            boolean r8 = r8.isChild()
            if (r8 != 0) goto L47
            java.lang.Object r8 = r6.f456k
            android.app.Activity r8 = (android.app.Activity) r8
            androidx.core.app.a.q(r8)
            r8 = r4
            goto L48
        L47:
            r8 = 0
        L48:
            if (r8 != 0) goto L50
            if (r3 == r0) goto L50
            r6.M0(r0, r2, r1)
            goto L51
        L50:
            r4 = r8
        L51:
            if (r4 == 0) goto L5e
            java.lang.Object r8 = r6.f456k
            boolean r0 = r8 instanceof androidx.appcompat.app.d
            if (r0 == 0) goto L5e
            androidx.appcompat.app.d r8 = (androidx.appcompat.app.d) r8
            r8.onNightModeChanged(r7)
        L5e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.g.L0(int, boolean):boolean");
    }

    private int M() {
        int i2 = this.X;
        return i2 != -100 ? i2 : androidx.appcompat.app.f.j();
    }

    private void M0(int i2, boolean z, Configuration configuration) {
        Resources resources = this.f457l.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i2 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 26) {
            androidx.appcompat.app.k.a(resources);
        }
        int i4 = this.Y;
        if (i4 != 0) {
            this.f457l.setTheme(i4);
            if (i3 >= 23) {
                this.f457l.getTheme().applyStyle(this.Y, true);
            }
        }
        if (z) {
            Object obj = this.f456k;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.o) {
                    if (((androidx.lifecycle.o) activity).getLifecycle().b().h(i.b.STARTED)) {
                        activity.onConfigurationChanged(configuration2);
                    }
                } else if (this.V) {
                    activity.onConfigurationChanged(configuration2);
                }
            }
        }
    }

    private void O0(View view) {
        int d2;
        if ((v.J(view) & PKIFailureInfo.certRevoked) != 0) {
            d2 = androidx.core.content.a.d(this.f457l, c.a.c.f2431b);
        } else {
            d2 = androidx.core.content.a.d(this.f457l, c.a.c.a);
        }
        view.setBackgroundColor(d2);
    }

    private void P() {
        m mVar = this.b0;
        if (mVar != null) {
            mVar.a();
        }
        m mVar2 = this.c0;
        if (mVar2 != null) {
            mVar2.a();
        }
    }

    private Configuration S(Context context, int i2, Configuration configuration) {
        int i3;
        if (i2 != 1) {
            i3 = i2 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32;
        } else {
            i3 = 16;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    private ViewGroup T() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f457l.obtainStyledAttributes(c.a.j.z0);
        int i2 = c.a.j.E0;
        if (obtainStyledAttributes.hasValue(i2)) {
            if (obtainStyledAttributes.getBoolean(c.a.j.N0, false)) {
                A(1);
            } else if (obtainStyledAttributes.getBoolean(i2, false)) {
                A(108);
            }
            if (obtainStyledAttributes.getBoolean(c.a.j.F0, false)) {
                A(109);
            }
            if (obtainStyledAttributes.getBoolean(c.a.j.G0, false)) {
                A(10);
            }
            this.N = obtainStyledAttributes.getBoolean(c.a.j.A0, false);
            obtainStyledAttributes.recycle();
            a0();
            this.m.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f457l);
            if (!this.O) {
                if (this.N) {
                    viewGroup = (ViewGroup) from.inflate(c.a.g.f2475f, (ViewGroup) null);
                    this.L = false;
                    this.K = false;
                } else if (this.K) {
                    TypedValue typedValue = new TypedValue();
                    this.f457l.getTheme().resolveAttribute(c.a.a.f2424f, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        context = new c.a.o.d(this.f457l, typedValue.resourceId);
                    } else {
                        context = this.f457l;
                    }
                    viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(c.a.g.p, (ViewGroup) null);
                    x xVar = (x) viewGroup.findViewById(c.a.f.p);
                    this.v = xVar;
                    xVar.setWindowCallback(i0());
                    if (this.L) {
                        this.v.i(109);
                    }
                    if (this.I) {
                        this.v.i(2);
                    }
                    if (this.J) {
                        this.v.i(5);
                    }
                } else {
                    viewGroup = null;
                }
            } else {
                viewGroup = this.M ? (ViewGroup) from.inflate(c.a.g.o, (ViewGroup) null) : (ViewGroup) from.inflate(c.a.g.n, (ViewGroup) null);
            }
            if (viewGroup != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    v.w0(viewGroup, new c());
                } else if (viewGroup instanceof b0) {
                    ((b0) viewGroup).setOnFitSystemWindowsListener(new d());
                }
                if (this.v == null) {
                    this.G = (TextView) viewGroup.findViewById(c.a.f.M);
                }
                y0.c(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(c.a.f.f2460b);
                ViewGroup viewGroup2 = (ViewGroup) this.m.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground(null);
                    }
                }
                this.m.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new e());
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.K + ", windowActionBarOverlay: " + this.L + ", android:windowIsFloating: " + this.N + ", windowActionModeOverlay: " + this.M + ", windowNoTitle: " + this.O + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void Z() {
        if (this.E) {
            return;
        }
        this.F = T();
        CharSequence h0 = h0();
        if (!TextUtils.isEmpty(h0)) {
            x xVar = this.v;
            if (xVar != null) {
                xVar.setWindowTitle(h0);
            } else if (B0() != null) {
                B0().w(h0);
            } else {
                TextView textView = this.G;
                if (textView != null) {
                    textView.setText(h0);
                }
            }
        }
        K();
        z0(this.F);
        this.E = true;
        t g0 = g0(0, false);
        if (this.W) {
            return;
        }
        if (g0 == null || g0.f474j == null) {
            n0(108);
        }
    }

    private void a0() {
        if (this.m == null) {
            Object obj = this.f456k;
            if (obj instanceof Activity) {
                L(((Activity) obj).getWindow());
            }
        }
        if (this.m == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration c0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f2 = configuration.fontScale;
            float f3 = configuration2.fontScale;
            if (f2 != f3) {
                configuration3.fontScale = f3;
            }
            int i2 = configuration.mcc;
            int i3 = configuration2.mcc;
            if (i2 != i3) {
                configuration3.mcc = i3;
            }
            int i4 = configuration.mnc;
            int i5 = configuration2.mnc;
            if (i4 != i5) {
                configuration3.mnc = i5;
            }
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 24) {
                p.a(configuration, configuration2, configuration3);
            } else if (!androidx.core.util.d.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i7 = configuration.touchscreen;
            int i8 = configuration2.touchscreen;
            if (i7 != i8) {
                configuration3.touchscreen = i8;
            }
            int i9 = configuration.keyboard;
            int i10 = configuration2.keyboard;
            if (i9 != i10) {
                configuration3.keyboard = i10;
            }
            int i11 = configuration.keyboardHidden;
            int i12 = configuration2.keyboardHidden;
            if (i11 != i12) {
                configuration3.keyboardHidden = i12;
            }
            int i13 = configuration.navigation;
            int i14 = configuration2.navigation;
            if (i13 != i14) {
                configuration3.navigation = i14;
            }
            int i15 = configuration.navigationHidden;
            int i16 = configuration2.navigationHidden;
            if (i15 != i16) {
                configuration3.navigationHidden = i16;
            }
            int i17 = configuration.orientation;
            int i18 = configuration2.orientation;
            if (i17 != i18) {
                configuration3.orientation = i18;
            }
            int i19 = configuration.screenLayout & 15;
            int i20 = configuration2.screenLayout;
            if (i19 != (i20 & 15)) {
                configuration3.screenLayout |= i20 & 15;
            }
            int i21 = configuration.screenLayout & 192;
            int i22 = configuration2.screenLayout;
            if (i21 != (i22 & 192)) {
                configuration3.screenLayout |= i22 & 192;
            }
            int i23 = configuration.screenLayout & 48;
            int i24 = configuration2.screenLayout;
            if (i23 != (i24 & 48)) {
                configuration3.screenLayout |= i24 & 48;
            }
            int i25 = configuration.screenLayout & 768;
            int i26 = configuration2.screenLayout;
            if (i25 != (i26 & 768)) {
                configuration3.screenLayout |= i26 & 768;
            }
            if (i6 >= 26) {
                q.a(configuration, configuration2, configuration3);
            }
            int i27 = configuration.uiMode & 15;
            int i28 = configuration2.uiMode;
            if (i27 != (i28 & 15)) {
                configuration3.uiMode |= i28 & 15;
            }
            int i29 = configuration.uiMode & 48;
            int i30 = configuration2.uiMode;
            if (i29 != (i30 & 48)) {
                configuration3.uiMode |= i30 & 48;
            }
            int i31 = configuration.screenWidthDp;
            int i32 = configuration2.screenWidthDp;
            if (i31 != i32) {
                configuration3.screenWidthDp = i32;
            }
            int i33 = configuration.screenHeightDp;
            int i34 = configuration2.screenHeightDp;
            if (i33 != i34) {
                configuration3.screenHeightDp = i34;
            }
            int i35 = configuration.smallestScreenWidthDp;
            int i36 = configuration2.smallestScreenWidthDp;
            if (i35 != i36) {
                configuration3.smallestScreenWidthDp = i36;
            }
            if (i6 >= 17) {
                o.a(configuration, configuration2, configuration3);
            }
        }
        return configuration3;
    }

    private m e0(Context context) {
        if (this.c0 == null) {
            this.c0 = new l(context);
        }
        return this.c0;
    }

    private m f0(Context context) {
        if (this.b0 == null) {
            this.b0 = new n(androidx.appcompat.app.n.a(context));
        }
        return this.b0;
    }

    private void j0() {
        Z();
        if (this.K && this.q == null) {
            Object obj = this.f456k;
            if (obj instanceof Activity) {
                this.q = new androidx.appcompat.app.o((Activity) this.f456k, this.L);
            } else if (obj instanceof Dialog) {
                this.q = new androidx.appcompat.app.o((Dialog) this.f456k);
            }
            androidx.appcompat.app.a aVar = this.q;
            if (aVar != null) {
                aVar.r(this.g0);
            }
        }
    }

    private boolean k0(t tVar) {
        View view = tVar.f473i;
        if (view != null) {
            tVar.f472h = view;
            return true;
        } else if (tVar.f474j == null) {
            return false;
        } else {
            if (this.x == null) {
                this.x = new u();
            }
            View view2 = (View) tVar.a(this.x);
            tVar.f472h = view2;
            return view2 != null;
        }
    }

    private boolean l0(t tVar) {
        tVar.d(d0());
        tVar.f471g = new s(tVar.f476l);
        tVar.f467c = 81;
        return true;
    }

    private boolean m0(t tVar) {
        Context context = this.f457l;
        int i2 = tVar.a;
        if ((i2 == 0 || i2 == 108) && this.v != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(c.a.a.f2424f, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(c.a.a.f2425g, typedValue, true);
            } else {
                theme.resolveAttribute(c.a.a.f2425g, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                c.a.o.d dVar = new c.a.o.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
        gVar.V(this);
        tVar.c(gVar);
        return true;
    }

    private void n0(int i2) {
        this.e0 = (1 << i2) | this.e0;
        if (this.d0) {
            return;
        }
        v.c0(this.m.getDecorView(), this.f0);
        this.d0 = true;
    }

    private boolean o0() {
        if (!this.a0 && (this.f456k instanceof Activity)) {
            PackageManager packageManager = this.f457l.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                int i2 = Build.VERSION.SDK_INT;
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f457l, this.f456k.getClass()), i2 >= 29 ? 269221888 : i2 >= 24 ? 786432 : 0);
                this.Z = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.Z = false;
            }
        }
        this.a0 = true;
        return this.Z;
    }

    private boolean t0(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            t g0 = g0(i2, true);
            if (g0.o) {
                return false;
            }
            return D0(g0, keyEvent);
        }
        return false;
    }

    private boolean w0(int i2, KeyEvent keyEvent) {
        boolean z;
        x xVar;
        if (this.y != null) {
            return false;
        }
        boolean z2 = true;
        t g0 = g0(i2, true);
        if (i2 == 0 && (xVar = this.v) != null && xVar.d() && !ViewConfiguration.get(this.f457l).hasPermanentMenuKey()) {
            if (!this.v.b()) {
                if (!this.W && D0(g0, keyEvent)) {
                    z2 = this.v.h();
                }
                z2 = false;
            } else {
                z2 = this.v.g();
            }
        } else {
            boolean z3 = g0.o;
            if (!z3 && !g0.n) {
                if (g0.m) {
                    if (g0.r) {
                        g0.m = false;
                        z = D0(g0, keyEvent);
                    } else {
                        z = true;
                    }
                    if (z) {
                        A0(g0, keyEvent);
                    }
                }
                z2 = false;
            } else {
                R(g0, true);
                z2 = z3;
            }
        }
        if (z2) {
            AudioManager audioManager = (AudioManager) this.f457l.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z2;
    }

    @Override // androidx.appcompat.app.f
    public boolean A(int i2) {
        int F0 = F0(i2);
        if (this.O && F0 == 108) {
            return false;
        }
        if (this.K && F0 == 1) {
            this.K = false;
        }
        if (F0 == 1) {
            J0();
            this.O = true;
            return true;
        } else if (F0 == 2) {
            J0();
            this.I = true;
            return true;
        } else if (F0 == 5) {
            J0();
            this.J = true;
            return true;
        } else if (F0 == 10) {
            J0();
            this.M = true;
            return true;
        } else if (F0 == 108) {
            J0();
            this.K = true;
            return true;
        } else if (F0 != 109) {
            return this.m.requestFeature(F0);
        } else {
            J0();
            this.L = true;
            return true;
        }
    }

    @Override // androidx.appcompat.app.f
    public void B(int i2) {
        Z();
        ViewGroup viewGroup = (ViewGroup) this.F.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f457l).inflate(i2, viewGroup);
        this.n.a().onContentChanged();
    }

    final androidx.appcompat.app.a B0() {
        return this.q;
    }

    @Override // androidx.appcompat.app.f
    public void C(View view) {
        Z();
        ViewGroup viewGroup = (ViewGroup) this.F.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.n.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.f
    public void D(View view, ViewGroup.LayoutParams layoutParams) {
        Z();
        ViewGroup viewGroup = (ViewGroup) this.F.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.n.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.f
    public void E(Toolbar toolbar) {
        if (this.f456k instanceof Activity) {
            androidx.appcompat.app.a n2 = n();
            if (!(n2 instanceof androidx.appcompat.app.o)) {
                this.t = null;
                if (n2 != null) {
                    n2.n();
                }
                if (toolbar != null) {
                    androidx.appcompat.app.l lVar = new androidx.appcompat.app.l(toolbar, h0(), this.n);
                    this.q = lVar;
                    this.m.setCallback(lVar.z());
                } else {
                    this.q = null;
                    this.m.setCallback(this.n);
                }
                p();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    @Override // androidx.appcompat.app.f
    public void F(int i2) {
        this.Y = i2;
    }

    @Override // androidx.appcompat.app.f
    public final void G(CharSequence charSequence) {
        this.u = charSequence;
        x xVar = this.v;
        if (xVar != null) {
            xVar.setWindowTitle(charSequence);
        } else if (B0() != null) {
            B0().w(charSequence);
        } else {
            TextView textView = this.G;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    final boolean G0() {
        ViewGroup viewGroup;
        return this.E && (viewGroup = this.F) != null && v.S(viewGroup);
    }

    @Override // androidx.appcompat.app.f
    public c.a.o.b H(b.a aVar) {
        androidx.appcompat.app.e eVar;
        if (aVar != null) {
            c.a.o.b bVar = this.y;
            if (bVar != null) {
                bVar.c();
            }
            j jVar = new j(aVar);
            androidx.appcompat.app.a n2 = n();
            if (n2 != null) {
                c.a.o.b x = n2.x(jVar);
                this.y = x;
                if (x != null && (eVar = this.p) != null) {
                    eVar.onSupportActionModeStarted(x);
                }
            }
            if (this.y == null) {
                this.y = I0(jVar);
            }
            return this.y;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public boolean I() {
        return J(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    c.a.o.b I0(c.a.o.b.a r8) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.g.I0(c.a.o.b$a):c.a.o.b");
    }

    void N(int i2, t tVar, Menu menu) {
        if (menu == null) {
            if (tVar == null && i2 >= 0) {
                t[] tVarArr = this.Q;
                if (i2 < tVarArr.length) {
                    tVar = tVarArr[i2];
                }
            }
            if (tVar != null) {
                menu = tVar.f474j;
            }
        }
        if ((tVar == null || tVar.o) && !this.W) {
            this.n.a().onPanelClosed(i2, menu);
        }
    }

    final int N0(d0 d0Var, Rect rect) {
        int i2;
        boolean z;
        boolean z2;
        if (d0Var != null) {
            i2 = d0Var.l();
        } else {
            i2 = rect != null ? rect.top : 0;
        }
        ActionBarContextView actionBarContextView = this.z;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.z.getLayoutParams();
            if (this.z.isShown()) {
                if (this.h0 == null) {
                    this.h0 = new Rect();
                    this.i0 = new Rect();
                }
                Rect rect2 = this.h0;
                Rect rect3 = this.i0;
                if (d0Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(d0Var.j(), d0Var.l(), d0Var.k(), d0Var.i());
                }
                y0.a(this.F, rect2, rect3);
                int i3 = rect2.top;
                int i4 = rect2.left;
                int i5 = rect2.right;
                d0 F = v.F(this.F);
                int j2 = F == null ? 0 : F.j();
                int k2 = F == null ? 0 : F.k();
                if (marginLayoutParams.topMargin == i3 && marginLayoutParams.leftMargin == i4 && marginLayoutParams.rightMargin == i5) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i3;
                    marginLayoutParams.leftMargin = i4;
                    marginLayoutParams.rightMargin = i5;
                    z2 = true;
                }
                if (i3 > 0 && this.H == null) {
                    View view = new View(this.f457l);
                    this.H = view;
                    view.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = j2;
                    layoutParams.rightMargin = k2;
                    this.F.addView(this.H, -1, layoutParams);
                } else {
                    View view2 = this.H;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i6 = marginLayoutParams2.height;
                        int i7 = marginLayoutParams.topMargin;
                        if (i6 != i7 || marginLayoutParams2.leftMargin != j2 || marginLayoutParams2.rightMargin != k2) {
                            marginLayoutParams2.height = i7;
                            marginLayoutParams2.leftMargin = j2;
                            marginLayoutParams2.rightMargin = k2;
                            this.H.setLayoutParams(marginLayoutParams2);
                        }
                    }
                }
                View view3 = this.H;
                r5 = view3 != null;
                if (r5 && view3.getVisibility() != 0) {
                    O0(this.H);
                }
                if (!this.M && r5) {
                    i2 = 0;
                }
                z = r5;
                r5 = z2;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                r5 = false;
            }
            if (r5) {
                this.z.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.H;
        if (view4 != null) {
            view4.setVisibility(z ? 0 : 8);
        }
        return i2;
    }

    void O(androidx.appcompat.view.menu.g gVar) {
        if (this.P) {
            return;
        }
        this.P = true;
        this.v.j();
        Window.Callback i0 = i0();
        if (i0 != null && !this.W) {
            i0.onPanelClosed(108, gVar);
        }
        this.P = false;
    }

    void Q(int i2) {
        R(g0(i2, true), true);
    }

    void R(t tVar, boolean z) {
        ViewGroup viewGroup;
        x xVar;
        if (z && tVar.a == 0 && (xVar = this.v) != null && xVar.b()) {
            O(tVar.f474j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f457l.getSystemService("window");
        if (windowManager != null && tVar.o && (viewGroup = tVar.f471g) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                N(tVar.a, tVar, null);
            }
        }
        tVar.m = false;
        tVar.n = false;
        tVar.o = false;
        tVar.f472h = null;
        tVar.q = true;
        if (this.R == tVar) {
            this.R = null;
        }
    }

    public View U(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z = false;
        if (this.j0 == null) {
            String string = this.f457l.obtainStyledAttributes(c.a.j.z0).getString(c.a.j.D0);
            if (string == null) {
                this.j0 = new androidx.appcompat.app.j();
            } else {
                try {
                    this.j0 = (androidx.appcompat.app.j) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.j0 = new androidx.appcompat.app.j();
                }
            }
        }
        boolean z2 = f451e;
        if (z2) {
            if (attributeSet instanceof XmlPullParser) {
                if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    z = true;
                }
            } else {
                z = H0((ViewParent) view);
            }
        }
        return this.j0.createView(view, str, context, attributeSet, z, z2, true, x0.b());
    }

    void V() {
        androidx.appcompat.view.menu.g gVar;
        x xVar = this.v;
        if (xVar != null) {
            xVar.j();
        }
        if (this.A != null) {
            this.m.getDecorView().removeCallbacks(this.B);
            if (this.A.isShowing()) {
                try {
                    this.A.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.A = null;
        }
        Y();
        t g0 = g0(0, false);
        if (g0 == null || (gVar = g0.f474j) == null) {
            return;
        }
        gVar.close();
    }

    boolean W(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f456k;
        if (((obj instanceof e.a) || (obj instanceof androidx.appcompat.app.h)) && (decorView = this.m.getDecorView()) != null && c.h.k.e.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.n.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? s0(keyCode, keyEvent) : v0(keyCode, keyEvent);
    }

    void X(int i2) {
        t g0;
        t g02 = g0(i2, true);
        if (g02.f474j != null) {
            Bundle bundle = new Bundle();
            g02.f474j.T(bundle);
            if (bundle.size() > 0) {
                g02.s = bundle;
            }
            g02.f474j.h0();
            g02.f474j.clear();
        }
        g02.r = true;
        g02.q = true;
        if ((i2 != 108 && i2 != 0) || this.v == null || (g0 = g0(0, false)) == null) {
            return;
        }
        g0.m = false;
        D0(g0, null);
    }

    void Y() {
        z zVar = this.C;
        if (zVar != null) {
            zVar.b();
        }
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        t b0;
        Window.Callback i0 = i0();
        if (i0 == null || this.W || (b0 = b0(gVar.F())) == null) {
            return false;
        }
        return i0.onMenuItemSelected(b0.a, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void b(androidx.appcompat.view.menu.g gVar) {
        E0(true);
    }

    t b0(Menu menu) {
        t[] tVarArr = this.Q;
        int length = tVarArr != null ? tVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            t tVar = tVarArr[i2];
            if (tVar != null && tVar.f474j == menu) {
                return tVar;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.app.f
    public void d(View view, ViewGroup.LayoutParams layoutParams) {
        Z();
        ((ViewGroup) this.F.findViewById(16908290)).addView(view, layoutParams);
        this.n.a().onContentChanged();
    }

    final Context d0() {
        androidx.appcompat.app.a n2 = n();
        Context k2 = n2 != null ? n2.k() : null;
        return k2 == null ? this.f457l : k2;
    }

    @Override // androidx.appcompat.app.f
    public Context f(Context context) {
        this.T = true;
        int q0 = q0(context, M());
        if (f454h && (context instanceof ContextThemeWrapper)) {
            try {
                r.a((ContextThemeWrapper) context, S(context, q0, null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof c.a.o.d) {
            try {
                ((c.a.o.d) context).a(S(context, q0, null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f453g) {
            return super.f(context);
        }
        try {
            Configuration configuration = context.getPackageManager().getResourcesForApplication(context.getApplicationInfo()).getConfiguration();
            Configuration configuration2 = context.getResources().getConfiguration();
            Configuration S = S(context, q0, configuration.equals(configuration2) ? null : c0(configuration, configuration2));
            c.a.o.d dVar = new c.a.o.d(context, c.a.i.f2495d);
            dVar.a(S);
            boolean z = false;
            try {
                z = context.getTheme() != null;
            } catch (NullPointerException unused3) {
            }
            if (z) {
                f.b.a(dVar.getTheme());
            }
            return super.f(dVar);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Application failed to obtain resources from itself", e2);
        }
    }

    protected t g0(int i2, boolean z) {
        t[] tVarArr = this.Q;
        if (tVarArr == null || tVarArr.length <= i2) {
            t[] tVarArr2 = new t[i2 + 1];
            if (tVarArr != null) {
                System.arraycopy(tVarArr, 0, tVarArr2, 0, tVarArr.length);
            }
            this.Q = tVarArr2;
            tVarArr = tVarArr2;
        }
        t tVar = tVarArr[i2];
        if (tVar == null) {
            t tVar2 = new t(i2);
            tVarArr[i2] = tVar2;
            return tVar2;
        }
        return tVar;
    }

    final CharSequence h0() {
        Object obj = this.f456k;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.u;
    }

    @Override // androidx.appcompat.app.f
    public <T extends View> T i(int i2) {
        Z();
        return (T) this.m.findViewById(i2);
    }

    final Window.Callback i0() {
        return this.m.getCallback();
    }

    @Override // androidx.appcompat.app.f
    public final androidx.appcompat.app.b k() {
        return new h();
    }

    @Override // androidx.appcompat.app.f
    public int l() {
        return this.X;
    }

    @Override // androidx.appcompat.app.f
    public MenuInflater m() {
        if (this.t == null) {
            j0();
            androidx.appcompat.app.a aVar = this.q;
            this.t = new c.a.o.g(aVar != null ? aVar.k() : this.f457l);
        }
        return this.t;
    }

    @Override // androidx.appcompat.app.f
    public androidx.appcompat.app.a n() {
        j0();
        return this.q;
    }

    @Override // androidx.appcompat.app.f
    public void o() {
        LayoutInflater from = LayoutInflater.from(this.f457l);
        if (from.getFactory() == null) {
            c.h.k.f.b(from, this);
        } else if (from.getFactory2() instanceof g) {
        } else {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return U(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.f
    public void p() {
        androidx.appcompat.app.a n2 = n();
        if (n2 == null || !n2.l()) {
            n0(0);
        }
    }

    public boolean p0() {
        return this.D;
    }

    @Override // androidx.appcompat.app.f
    public void q(Configuration configuration) {
        androidx.appcompat.app.a n2;
        if (this.K && this.E && (n2 = n()) != null) {
            n2.m(configuration);
        }
        androidx.appcompat.widget.h.b().g(this.f457l);
        J(false);
    }

    int q0(Context context, int i2) {
        if (i2 != -100) {
            if (i2 != -1) {
                if (i2 == 0) {
                    if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() != 0) {
                        return f0(context).c();
                    }
                    return -1;
                } else if (i2 != 1 && i2 != 2) {
                    if (i2 == 3) {
                        return e0(context).c();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            }
            return i2;
        }
        return -1;
    }

    @Override // androidx.appcompat.app.f
    public void r(Bundle bundle) {
        this.T = true;
        J(false);
        a0();
        Object obj = this.f456k;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = androidx.core.app.h.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                androidx.appcompat.app.a B0 = B0();
                if (B0 == null) {
                    this.g0 = true;
                } else {
                    B0.r(true);
                }
            }
            androidx.appcompat.app.f.c(this);
        }
        this.U = true;
    }

    boolean r0() {
        c.a.o.b bVar = this.y;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        androidx.appcompat.app.a n2 = n();
        return n2 != null && n2.h();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
    @Override // androidx.appcompat.app.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void s() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f456k
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            androidx.appcompat.app.f.y(r3)
        L9:
            boolean r0 = r3.d0
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.m
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.f0
            r0.removeCallbacks(r1)
        L18:
            r0 = 0
            r3.V = r0
            r0 = 1
            r3.W = r0
            int r0 = r3.X
            r1 = -100
            if (r0 == r1) goto L48
            java.lang.Object r0 = r3.f456k
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L48
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L48
            c.e.g<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.g.f450d
            java.lang.Object r1 = r3.f456k
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.X
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L57
        L48:
            c.e.g<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.g.f450d
            java.lang.Object r1 = r3.f456k
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L57:
            androidx.appcompat.app.a r0 = r3.q
            if (r0 == 0) goto L5e
            r0.n()
        L5e:
            r3.P()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.g.s():void");
    }

    boolean s0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.S = (keyEvent.getFlags() & 128) != 0;
        } else if (i2 == 82) {
            t0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.f
    public void t(Bundle bundle) {
        Z();
    }

    @Override // androidx.appcompat.app.f
    public void u() {
        androidx.appcompat.app.a n2 = n();
        if (n2 != null) {
            n2.u(true);
        }
    }

    boolean u0(int i2, KeyEvent keyEvent) {
        androidx.appcompat.app.a n2 = n();
        if (n2 == null || !n2.o(i2, keyEvent)) {
            t tVar = this.R;
            if (tVar != null && C0(tVar, keyEvent.getKeyCode(), keyEvent, 1)) {
                t tVar2 = this.R;
                if (tVar2 != null) {
                    tVar2.n = true;
                }
                return true;
            }
            if (this.R == null) {
                t g0 = g0(0, true);
                D0(g0, keyEvent);
                boolean C0 = C0(g0, keyEvent.getKeyCode(), keyEvent, 1);
                g0.m = false;
                if (C0) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // androidx.appcompat.app.f
    public void v(Bundle bundle) {
    }

    boolean v0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z = this.S;
            this.S = false;
            t g0 = g0(0, false);
            if (g0 != null && g0.o) {
                if (!z) {
                    R(g0, true);
                }
                return true;
            } else if (r0()) {
                return true;
            }
        } else if (i2 == 82) {
            w0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.f
    public void w() {
        this.V = true;
        I();
    }

    @Override // androidx.appcompat.app.f
    public void x() {
        this.V = false;
        androidx.appcompat.app.a n2 = n();
        if (n2 != null) {
            n2.u(false);
        }
    }

    void x0(int i2) {
        androidx.appcompat.app.a n2;
        if (i2 != 108 || (n2 = n()) == null) {
            return;
        }
        n2.i(true);
    }

    void y0(int i2) {
        if (i2 == 108) {
            androidx.appcompat.app.a n2 = n();
            if (n2 != null) {
                n2.i(false);
            }
        } else if (i2 == 0) {
            t g0 = g0(i2, true);
            if (g0.o) {
                R(g0, false);
            }
        }
    }

    void z0(ViewGroup viewGroup) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Dialog dialog, androidx.appcompat.app.e eVar) {
        this(dialog.getContext(), dialog.getWindow(), eVar, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private g(Context context, Window window, androidx.appcompat.app.e eVar, Object obj) {
        c.e.g<String, Integer> gVar;
        Integer num;
        androidx.appcompat.app.d K0;
        this.C = null;
        this.D = true;
        this.X = -100;
        this.f0 = new b();
        this.f457l = context;
        this.p = eVar;
        this.f456k = obj;
        if (this.X == -100 && (obj instanceof Dialog) && (K0 = K0()) != null) {
            this.X = K0.getDelegate().l();
        }
        if (this.X == -100 && (num = (gVar = f450d).get(obj.getClass().getName())) != null) {
            this.X = num.intValue();
            gVar.remove(obj.getClass().getName());
        }
        if (window != null) {
            L(window);
        }
        androidx.appcompat.widget.h.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public class k extends c.a.o.i {
        k(Window.Callback callback) {
            super(callback);
        }

        final ActionMode b(ActionMode.Callback callback) {
            f.a aVar = new f.a(g.this.f457l, callback);
            c.a.o.b H = g.this.H(aVar);
            if (H != null) {
                return aVar.e(H);
            }
            return null;
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return g.this.W(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || g.this.u0(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i2, Menu menu) {
            if (i2 != 0 || (menu instanceof androidx.appcompat.view.menu.g)) {
                return super.onCreatePanelMenu(i2, menu);
            }
            return false;
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public boolean onMenuOpened(int i2, Menu menu) {
            super.onMenuOpened(i2, menu);
            g.this.x0(i2);
            return true;
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public void onPanelClosed(int i2, Menu menu) {
            super.onPanelClosed(i2, menu);
            g.this.y0(i2);
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public boolean onPreparePanel(int i2, View view, Menu menu) {
            androidx.appcompat.view.menu.g gVar = menu instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) menu : null;
            if (i2 == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.e0(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i2, view, menu);
            if (gVar != null) {
                gVar.e0(false);
            }
            return onPreparePanel;
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
            androidx.appcompat.view.menu.g gVar;
            t g0 = g.this.g0(0, true);
            if (g0 != null && (gVar = g0.f474j) != null) {
                super.onProvideKeyboardShortcuts(list, gVar, i2);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i2);
            }
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (g.this.p0()) {
                return b(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
            if (g.this.p0() && i2 == 0) {
                return b(callback);
            }
            return super.onWindowStartingActionMode(callback, i2);
        }
    }
}