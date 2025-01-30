package com.swmansion.rnscreens;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.swmansion.rnscreens.k;
import java.util.ArrayList;

/* compiled from: ScreenStackHeaderConfig.java */
/* loaded from: classes2.dex */
public class j extends ViewGroup {
    private final ArrayList<k> a;

    /* renamed from: b  reason: collision with root package name */
    private String f11036b;

    /* renamed from: c  reason: collision with root package name */
    private int f11037c;

    /* renamed from: d  reason: collision with root package name */
    private String f11038d;

    /* renamed from: e  reason: collision with root package name */
    private String f11039e;

    /* renamed from: f  reason: collision with root package name */
    private float f11040f;

    /* renamed from: g  reason: collision with root package name */
    private int f11041g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11042h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f11043j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f11044k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f11045l;
    private boolean m;
    private boolean n;
    private int p;
    private final Toolbar q;
    private boolean t;
    private int u;
    private int v;
    private View.OnClickListener w;

    /* compiled from: ScreenStackHeaderConfig.java */
    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i screenFragment = j.this.getScreenFragment();
            if (screenFragment != null) {
                h screenStack = j.this.getScreenStack();
                if (screenStack != null && screenStack.getRootScreen() == screenFragment.h()) {
                    Fragment parentFragment = screenFragment.getParentFragment();
                    if (parentFragment instanceof i) {
                        ((i) parentFragment).dismiss();
                        return;
                    }
                    return;
                }
                screenFragment.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScreenStackHeaderConfig.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[k.a.values().length];
            a = iArr;
            try {
                iArr[k.a.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[k.a.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[k.a.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public j(Context context) {
        super(context);
        this.a = new ArrayList<>(3);
        this.n = true;
        this.t = false;
        this.w = new a();
        setVisibility(8);
        Toolbar toolbar = new Toolbar(context);
        this.q = toolbar;
        this.u = toolbar.getContentInsetStart();
        this.v = toolbar.getContentInsetStartWithNavigation();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16843827, typedValue, true)) {
            toolbar.setBackgroundColor(typedValue.data);
        }
        toolbar.setClipChildren(false);
    }

    private void f() {
        if (getParent() == null || this.f11045l) {
            return;
        }
        g();
    }

    private com.swmansion.rnscreens.b getScreen() {
        ViewParent parent = getParent();
        if (parent instanceof com.swmansion.rnscreens.b) {
            return (com.swmansion.rnscreens.b) parent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getScreenFragment() {
        ViewParent parent = getParent();
        if (parent instanceof com.swmansion.rnscreens.b) {
            g fragment = ((com.swmansion.rnscreens.b) parent).getFragment();
            if (fragment instanceof i) {
                return (i) fragment;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h getScreenStack() {
        com.swmansion.rnscreens.b screen = getScreen();
        if (screen != null) {
            d container = screen.getContainer();
            if (container instanceof h) {
                return (h) container;
            }
            return null;
        }
        return null;
    }

    private TextView getTitleTextView() {
        int childCount = this.q.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.q.getChildAt(i2);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (textView.getText().equals(this.q.getTitle())) {
                    return textView;
                }
            }
        }
        return null;
    }

    public void c(k kVar, int i2) {
        this.a.add(i2, kVar);
        f();
    }

    public void d() {
        this.f11045l = true;
    }

    public k e(int i2) {
        return this.a.get(i2);
    }

    public void g() {
        androidx.appcompat.app.d dVar;
        Drawable navigationIcon;
        String str;
        com.swmansion.rnscreens.b bVar = (com.swmansion.rnscreens.b) getParent();
        h screenStack = getScreenStack();
        boolean z = screenStack == null || screenStack.getTopScreen() == bVar;
        if (!this.t || !z || this.f11045l || (dVar = (androidx.appcompat.app.d) getScreenFragment().getActivity()) == null) {
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17 && (str = this.f11039e) != null) {
            if (str.equals("rtl")) {
                this.q.setLayoutDirection(1);
            } else if (this.f11039e.equals("ltr")) {
                this.q.setLayoutDirection(0);
            }
        }
        if (this.f11042h) {
            if (this.q.getParent() != null) {
                getScreenFragment().r();
                return;
            }
            return;
        }
        if (this.q.getParent() == null) {
            getScreenFragment().s(this.q);
        }
        if (this.n) {
            if (i2 >= 23) {
                this.q.setPadding(0, getRootWindowInsets().getSystemWindowInsetTop(), 0, 0);
            } else {
                this.q.setPadding(0, (int) (getResources().getDisplayMetrics().density * 25.0f), 0, 0);
            }
        } else if (this.q.getPaddingTop() > 0) {
            this.q.setPadding(0, 0, 0, 0);
        }
        dVar.setSupportActionBar(this.q);
        androidx.appcompat.app.a supportActionBar = dVar.getSupportActionBar();
        this.q.setContentInsetStartWithNavigation(this.v);
        Toolbar toolbar = this.q;
        int i3 = this.u;
        toolbar.H(i3, i3);
        supportActionBar.s(getScreenFragment().n() && !this.f11043j);
        this.q.setNavigationOnClickListener(this.w);
        getScreenFragment().t(this.f11044k);
        supportActionBar.v(this.f11036b);
        if (TextUtils.isEmpty(this.f11036b)) {
            this.q.setContentInsetStartWithNavigation(0);
        }
        TextView titleTextView = getTitleTextView();
        int i4 = this.f11037c;
        if (i4 != 0) {
            this.q.setTitleTextColor(i4);
        }
        if (titleTextView != null) {
            if (this.f11038d != null) {
                titleTextView.setTypeface(com.facebook.react.views.text.i.c().e(this.f11038d, 0, getContext().getAssets()));
            }
            float f2 = this.f11040f;
            if (f2 > 0.0f) {
                titleTextView.setTextSize(f2);
            }
        }
        int i5 = this.f11041g;
        if (i5 != 0) {
            this.q.setBackgroundColor(i5);
        }
        if (this.p != 0 && (navigationIcon = this.q.getNavigationIcon()) != null) {
            navigationIcon.setColorFilter(this.p, PorterDuff.Mode.SRC_ATOP);
        }
        for (int childCount = this.q.getChildCount() - 1; childCount >= 0; childCount--) {
            if (this.q.getChildAt(childCount) instanceof k) {
                this.q.removeViewAt(childCount);
            }
        }
        int size = this.a.size();
        for (int i6 = 0; i6 < size; i6++) {
            k kVar = this.a.get(i6);
            k.a type = kVar.getType();
            if (type == k.a.BACK) {
                View childAt = kVar.getChildAt(0);
                if (childAt instanceof ImageView) {
                    supportActionBar.t(((ImageView) childAt).getDrawable());
                } else {
                    throw new JSApplicationIllegalArgumentException("Back button header config view should have Image as first child");
                }
            } else {
                Toolbar.e eVar = new Toolbar.e(-2, -1);
                int i7 = b.a[type.ordinal()];
                if (i7 == 1) {
                    if (!this.m) {
                        this.q.setNavigationIcon((Drawable) null);
                    }
                    this.q.setTitle((CharSequence) null);
                    eVar.a = 8388611;
                } else if (i7 == 2) {
                    eVar.a = 8388613;
                } else if (i7 == 3) {
                    ((ViewGroup.MarginLayoutParams) eVar).width = -1;
                    eVar.a = 1;
                    this.q.setTitle((CharSequence) null);
                }
                kVar.setLayoutParams(eVar);
                this.q.addView(kVar);
            }
        }
    }

    public int getConfigSubviewsCount() {
        return this.a.size();
    }

    public void h() {
        this.a.clear();
        f();
    }

    public void i(int i2) {
        this.a.remove(i2);
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.t = true;
        g();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.t = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    public void setBackButtonInCustomView(boolean z) {
        this.m = z;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        this.f11041g = i2;
    }

    public void setDirection(String str) {
        this.f11039e = str;
    }

    public void setHidden(boolean z) {
        this.f11042h = z;
    }

    public void setHideBackButton(boolean z) {
        this.f11043j = z;
    }

    public void setHideShadow(boolean z) {
        this.f11044k = z;
    }

    public void setTintColor(int i2) {
        this.p = i2;
    }

    public void setTitle(String str) {
        this.f11036b = str;
    }

    public void setTitleColor(int i2) {
        this.f11037c = i2;
    }

    public void setTitleFontFamily(String str) {
        this.f11038d = str;
    }

    public void setTitleFontSize(float f2) {
        this.f11040f = f2;
    }

    public void setTopInsetEnabled(boolean z) {
        this.n = z;
    }
}