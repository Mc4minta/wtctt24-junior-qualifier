package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.lang.reflect.Method;

/* compiled from: ListPopupWindow.java */
/* loaded from: classes.dex */
public class e0 implements androidx.appcompat.view.menu.p {
    private static Method a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f788b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f789c;
    private Drawable A;
    private AdapterView.OnItemClickListener B;
    private AdapterView.OnItemSelectedListener C;
    final g D;
    private final f E;
    private final e F;
    private final c G;
    private Runnable H;
    final Handler I;
    private final Rect J;
    private Rect K;
    private boolean L;
    PopupWindow M;

    /* renamed from: d  reason: collision with root package name */
    private Context f790d;

    /* renamed from: e  reason: collision with root package name */
    private ListAdapter f791e;

    /* renamed from: f  reason: collision with root package name */
    a0 f792f;

    /* renamed from: g  reason: collision with root package name */
    private int f793g;

    /* renamed from: h  reason: collision with root package name */
    private int f794h;

    /* renamed from: j  reason: collision with root package name */
    private int f795j;

    /* renamed from: k  reason: collision with root package name */
    private int f796k;

    /* renamed from: l  reason: collision with root package name */
    private int f797l;
    private boolean m;
    private boolean n;
    private boolean p;
    private int q;
    private boolean t;
    private boolean u;
    int v;
    private View w;
    private int x;
    private DataSetObserver y;
    private View z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View t = e0.this.t();
            if (t == null || t.getWindowToken() == null) {
                return;
            }
            e0.this.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
            a0 a0Var;
            if (i2 == -1 || (a0Var = e0.this.f792f) == null) {
                return;
            }
            a0Var.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.r();
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    private class d extends DataSetObserver {
        d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (e0.this.a()) {
                e0.this.h();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            e0.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class e implements AbsListView.OnScrollListener {
        e() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 != 1 || e0.this.w() || e0.this.M.getContentView() == null) {
                return;
            }
            e0 e0Var = e0.this;
            e0Var.I.removeCallbacks(e0Var.D);
            e0.this.D.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class f implements View.OnTouchListener {
        f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = e0.this.M) != null && popupWindow.isShowing() && x >= 0 && x < e0.this.M.getWidth() && y >= 0 && y < e0.this.M.getHeight()) {
                e0 e0Var = e0.this;
                e0Var.I.postDelayed(e0Var.D, 250L);
                return false;
            } else if (action == 1) {
                e0 e0Var2 = e0.this;
                e0Var2.I.removeCallbacks(e0Var2.D);
                return false;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a0 a0Var = e0.this.f792f;
            if (a0Var == null || !c.h.k.v.Q(a0Var) || e0.this.f792f.getCount() <= e0.this.f792f.getChildCount()) {
                return;
            }
            int childCount = e0.this.f792f.getChildCount();
            e0 e0Var = e0.this;
            if (childCount <= e0Var.v) {
                e0Var.M.setInputMethodMode(2);
                e0.this.h();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f789c = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                f788b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public e0(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    private void J(boolean z) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = a;
            if (method != null) {
                try {
                    method.invoke(this.M, Boolean.valueOf(z));
                    return;
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                    return;
                }
            }
            return;
        }
        this.M.setIsClippedToScreen(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int q() {
        int i2;
        int i3;
        int makeMeasureSpec;
        int i4;
        if (this.f792f == null) {
            Context context = this.f790d;
            this.H = new a();
            a0 s = s(context, !this.L);
            this.f792f = s;
            Drawable drawable = this.A;
            if (drawable != null) {
                s.setSelector(drawable);
            }
            this.f792f.setAdapter(this.f791e);
            this.f792f.setOnItemClickListener(this.B);
            this.f792f.setFocusable(true);
            this.f792f.setFocusableInTouchMode(true);
            this.f792f.setOnItemSelectedListener(new b());
            this.f792f.setOnScrollListener(this.F);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.C;
            if (onItemSelectedListener != null) {
                this.f792f.setOnItemSelectedListener(onItemSelectedListener);
            }
            a0 a0Var = this.f792f;
            View view = this.w;
            if (view != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i5 = this.x;
                if (i5 == 0) {
                    linearLayout.addView(view);
                    linearLayout.addView(a0Var, layoutParams);
                } else if (i5 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.x);
                } else {
                    linearLayout.addView(a0Var, layoutParams);
                    linearLayout.addView(view);
                }
                int i6 = this.f794h;
                if (i6 >= 0) {
                    i4 = Integer.MIN_VALUE;
                } else {
                    i6 = 0;
                    i4 = 0;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec(i6, i4), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                i2 = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                a0Var = linearLayout;
            } else {
                i2 = 0;
            }
            this.M.setContentView(a0Var);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.M.getContentView();
            View view2 = this.w;
            if (view2 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i2 = view2.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i2 = 0;
            }
        }
        Drawable background = this.M.getBackground();
        if (background != null) {
            background.getPadding(this.J);
            Rect rect = this.J;
            int i7 = rect.top;
            i3 = rect.bottom + i7;
            if (!this.m) {
                this.f796k = -i7;
            }
        } else {
            this.J.setEmpty();
            i3 = 0;
        }
        int u = u(t(), this.f796k, this.M.getInputMethodMode() == 2);
        if (this.t || this.f793g == -1) {
            return u + i3;
        }
        int i8 = this.f794h;
        if (i8 == -2) {
            int i9 = this.f790d.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.J;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i8 != -1) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
        } else {
            int i10 = this.f790d.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.J;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10 - (rect3.left + rect3.right), 1073741824);
        }
        int d2 = this.f792f.d(makeMeasureSpec, 0, -1, u - i2, -1);
        if (d2 > 0) {
            i2 += i3 + this.f792f.getPaddingTop() + this.f792f.getPaddingBottom();
        }
        return d2 + i2;
    }

    private int u(View view, int i2, boolean z) {
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = f788b;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(this.M, view, Integer.valueOf(i2), Boolean.valueOf(z))).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            return this.M.getMaxAvailableHeight(view, i2);
        }
        return this.M.getMaxAvailableHeight(view, i2, z);
    }

    private void y() {
        View view = this.w;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.w);
            }
        }
    }

    public void A(int i2) {
        this.M.setAnimationStyle(i2);
    }

    public void B(int i2) {
        Drawable background = this.M.getBackground();
        if (background != null) {
            background.getPadding(this.J);
            Rect rect = this.J;
            this.f794h = rect.left + rect.right + i2;
            return;
        }
        M(i2);
    }

    public void C(int i2) {
        this.q = i2;
    }

    public void D(Rect rect) {
        this.K = rect != null ? new Rect(rect) : null;
    }

    public void E(int i2) {
        this.M.setInputMethodMode(i2);
    }

    public void F(boolean z) {
        this.L = z;
        this.M.setFocusable(z);
    }

    public void G(PopupWindow.OnDismissListener onDismissListener) {
        this.M.setOnDismissListener(onDismissListener);
    }

    public void H(AdapterView.OnItemClickListener onItemClickListener) {
        this.B = onItemClickListener;
    }

    public void I(boolean z) {
        this.p = true;
        this.n = z;
    }

    public void K(int i2) {
        this.x = i2;
    }

    public void L(int i2) {
        a0 a0Var = this.f792f;
        if (!a() || a0Var == null) {
            return;
        }
        a0Var.setListSelectionHidden(false);
        a0Var.setSelection(i2);
        if (a0Var.getChoiceMode() != 0) {
            a0Var.setItemChecked(i2, true);
        }
    }

    public void M(int i2) {
        this.f794h = i2;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean a() {
        return this.M.isShowing();
    }

    public void b(Drawable drawable) {
        this.M.setBackgroundDrawable(drawable);
    }

    public int c() {
        return this.f795j;
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        this.M.dismiss();
        y();
        this.M.setContentView(null);
        this.f792f = null;
        this.I.removeCallbacks(this.D);
    }

    public void e(int i2) {
        this.f795j = i2;
    }

    @Override // androidx.appcompat.view.menu.p
    public void h() {
        int q = q();
        boolean w = w();
        androidx.core.widget.h.b(this.M, this.f797l);
        boolean z = true;
        if (this.M.isShowing()) {
            if (c.h.k.v.Q(t())) {
                int i2 = this.f794h;
                if (i2 == -1) {
                    i2 = -1;
                } else if (i2 == -2) {
                    i2 = t().getWidth();
                }
                int i3 = this.f793g;
                if (i3 == -1) {
                    if (!w) {
                        q = -1;
                    }
                    if (w) {
                        this.M.setWidth(this.f794h == -1 ? -1 : 0);
                        this.M.setHeight(0);
                    } else {
                        this.M.setWidth(this.f794h == -1 ? -1 : 0);
                        this.M.setHeight(-1);
                    }
                } else if (i3 != -2) {
                    q = i3;
                }
                PopupWindow popupWindow = this.M;
                if (this.u || this.t) {
                    z = false;
                }
                popupWindow.setOutsideTouchable(z);
                this.M.update(t(), this.f795j, this.f796k, i2 < 0 ? -1 : i2, q < 0 ? -1 : q);
                return;
            }
            return;
        }
        int i4 = this.f794h;
        if (i4 == -1) {
            i4 = -1;
        } else if (i4 == -2) {
            i4 = t().getWidth();
        }
        int i5 = this.f793g;
        if (i5 == -1) {
            q = -1;
        } else if (i5 != -2) {
            q = i5;
        }
        this.M.setWidth(i4);
        this.M.setHeight(q);
        J(true);
        this.M.setOutsideTouchable((this.u || this.t) ? false : true);
        this.M.setTouchInterceptor(this.E);
        if (this.p) {
            androidx.core.widget.h.a(this.M, this.n);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f789c;
            if (method != null) {
                try {
                    method.invoke(this.M, this.K);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            this.M.setEpicenterBounds(this.K);
        }
        androidx.core.widget.h.c(this.M, t(), this.f795j, this.f796k, this.q);
        this.f792f.setSelection(-1);
        if (!this.L || this.f792f.isInTouchMode()) {
            r();
        }
        if (this.L) {
            return;
        }
        this.I.post(this.G);
    }

    public Drawable i() {
        return this.M.getBackground();
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView k() {
        return this.f792f;
    }

    public void l(int i2) {
        this.f796k = i2;
        this.m = true;
    }

    public int o() {
        if (this.m) {
            return this.f796k;
        }
        return 0;
    }

    public void p(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.y;
        if (dataSetObserver == null) {
            this.y = new d();
        } else {
            ListAdapter listAdapter2 = this.f791e;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f791e = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.y);
        }
        a0 a0Var = this.f792f;
        if (a0Var != null) {
            a0Var.setAdapter(this.f791e);
        }
    }

    public void r() {
        a0 a0Var = this.f792f;
        if (a0Var != null) {
            a0Var.setListSelectionHidden(true);
            a0Var.requestLayout();
        }
    }

    a0 s(Context context, boolean z) {
        return new a0(context, z);
    }

    public View t() {
        return this.z;
    }

    public int v() {
        return this.f794h;
    }

    public boolean w() {
        return this.M.getInputMethodMode() == 2;
    }

    public boolean x() {
        return this.L;
    }

    public void z(View view) {
        this.z = view;
    }

    public e0(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f793g = -2;
        this.f794h = -2;
        this.f797l = RNCWebViewManager.COMMAND_CLEAR_HISTORY;
        this.q = 0;
        this.t = false;
        this.u = false;
        this.v = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.x = 0;
        this.D = new g();
        this.E = new f();
        this.F = new e();
        this.G = new c();
        this.J = new Rect();
        this.f790d = context;
        this.I = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.j.o1, i2, i3);
        this.f795j = obtainStyledAttributes.getDimensionPixelOffset(c.a.j.p1, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(c.a.j.q1, 0);
        this.f796k = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.m = true;
        }
        obtainStyledAttributes.recycle();
        m mVar = new m(context, attributeSet, i2, i3);
        this.M = mVar;
        mVar.setInputMethodMode(1);
    }
}