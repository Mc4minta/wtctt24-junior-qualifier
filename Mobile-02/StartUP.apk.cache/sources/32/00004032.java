package com.swmansion.rnscreens;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.u;
import com.facebook.react.modules.core.a;
import com.facebook.react.modules.core.g;
import com.swmansion.rnscreens.g;
import e.f.m.s;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: ScreenContainer.java */
/* loaded from: classes2.dex */
public class d<T extends g> extends ViewGroup {
    protected final ArrayList<T> a;

    /* renamed from: b  reason: collision with root package name */
    protected androidx.fragment.app.m f11017b;

    /* renamed from: c  reason: collision with root package name */
    private u f11018c;

    /* renamed from: d  reason: collision with root package name */
    private u f11019d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11020e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11021f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11022g;

    /* renamed from: h  reason: collision with root package name */
    private g f11023h;

    /* renamed from: j  reason: collision with root package name */
    private final a.AbstractC0115a f11024j;

    /* renamed from: k  reason: collision with root package name */
    private final a.AbstractC0115a f11025k;

    /* compiled from: ScreenContainer.java */
    /* loaded from: classes2.dex */
    class a extends a.AbstractC0115a {
        a() {
        }

        @Override // com.facebook.react.modules.core.a.AbstractC0115a
        public void a(long j2) {
            d.this.w();
        }
    }

    /* compiled from: ScreenContainer.java */
    /* loaded from: classes2.dex */
    class b extends a.AbstractC0115a {
        b() {
        }

        @Override // com.facebook.react.modules.core.a.AbstractC0115a
        public void a(long j2) {
            d.this.f11022g = false;
            d dVar = d.this;
            dVar.measure(View.MeasureSpec.makeMeasureSpec(dVar.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(d.this.getHeight(), 1073741824));
            d dVar2 = d.this;
            dVar2.layout(dVar2.getLeft(), d.this.getTop(), d.this.getRight(), d.this.getBottom());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScreenContainer.java */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        final /* synthetic */ u a;

        c(u uVar) {
            this.a = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f11019d == this.a) {
                d.this.f11019d = null;
            }
        }
    }

    public d(Context context) {
        super(context);
        this.a = new ArrayList<>();
        this.f11022g = false;
        this.f11023h = null;
        this.f11024j = new a();
        this.f11025k = new b();
    }

    private void g(g gVar) {
        getOrCreateTransaction().b(getId(), gVar);
    }

    private void h(g gVar) {
        getOrCreateTransaction().r(gVar);
    }

    private void n(g gVar) {
        u orCreateTransaction = getOrCreateTransaction();
        orCreateTransaction.r(gVar);
        orCreateTransaction.b(getId(), gVar);
    }

    private final void p() {
        this.f11017b.V();
        q();
    }

    private void s() {
        u j2 = this.f11017b.j();
        boolean z = false;
        for (Fragment fragment : this.f11017b.h0()) {
            if ((fragment instanceof g) && ((g) fragment).a.getContainer() == this) {
                j2.r(fragment);
                z = true;
            }
        }
        if (z) {
            j2.m();
        }
    }

    private void setFragmentManager(androidx.fragment.app.m mVar) {
        this.f11017b = mVar;
        w();
    }

    private void u() {
        boolean z;
        boolean z2;
        ViewParent viewParent = this;
        while (true) {
            z = viewParent instanceof s;
            if (z || (viewParent instanceof com.swmansion.rnscreens.b) || viewParent.getParent() == null) {
                break;
            }
            viewParent = viewParent.getParent();
        }
        if (viewParent instanceof com.swmansion.rnscreens.b) {
            g fragment = ((com.swmansion.rnscreens.b) viewParent).getFragment();
            setFragmentManager(fragment.getChildFragmentManager());
            this.f11023h = fragment;
            fragment.l(this);
        } else if (z) {
            Context context = ((s) viewParent).getContext();
            while (true) {
                z2 = context instanceof androidx.fragment.app.d;
                if (z2 || !(context instanceof ContextWrapper)) {
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (z2) {
                setFragmentManager(((androidx.fragment.app.d) context).getSupportFragmentManager());
                return;
            }
            throw new IllegalStateException("In order to use RNScreens components your app's activity need to extend ReactFragmentActivity or ReactCompatActivity");
        } else {
            throw new IllegalStateException("ScreenContainer is not attached under ReactRootView");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.f11020e && this.f11021f && this.f11017b != null) {
            this.f11020e = false;
            p();
        }
    }

    protected T e(com.swmansion.rnscreens.b bVar) {
        return (T) new g(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.swmansion.rnscreens.b bVar, int i2) {
        T e2 = e(bVar);
        bVar.setFragment(e2);
        this.a.add(i2, e2);
        bVar.setContainer(this);
        m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public u getOrCreateTransaction() {
        if (this.f11018c == null) {
            u j2 = this.f11017b.j();
            this.f11018c = j2;
            j2.y(true);
        }
        return this.f11018c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getScreenCount() {
        return this.a.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.swmansion.rnscreens.b i(int i2) {
        return this.a.get(i2).h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j(g gVar) {
        return this.a.contains(gVar);
    }

    public boolean k() {
        return this.f11023h != null;
    }

    protected boolean l(g gVar) {
        return gVar.h().b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        if (this.f11020e) {
            return;
        }
        this.f11020e = true;
        com.facebook.react.modules.core.g.i().m(g.c.NATIVE_ANIMATED_MODULE, this.f11024j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f11021f = true;
        this.f11020e = true;
        u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        androidx.fragment.app.m mVar = this.f11017b;
        if (mVar != null && !mVar.q0()) {
            s();
            this.f11017b.V();
        }
        g gVar = this.f11023h;
        if (gVar != null) {
            gVar.m(this);
            this.f11023h = null;
        }
        super.onDetachedFromWindow();
        this.f11021f = false;
        removeAllViews();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6).layout(0, 0, getWidth(), getHeight());
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            getChildAt(i4).measure(i2, i3);
        }
    }

    protected void q() {
        HashSet hashSet = new HashSet(this.f11017b.h0());
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            T t = this.a.get(i2);
            if (!l(t) && t.isAdded()) {
                h(t);
            }
            hashSet.remove(t);
        }
        if (!hashSet.isEmpty()) {
            Object[] array = hashSet.toArray();
            for (int i3 = 0; i3 < array.length; i3++) {
                if ((array[i3] instanceof g) && ((g) array[i3]).h().getContainer() == null) {
                    h((g) array[i3]);
                }
            }
        }
        int size2 = this.a.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size2; i5++) {
            if (l(this.a.get(i5))) {
                i4++;
            }
        }
        boolean z = i4 > 1;
        int size3 = this.a.size();
        boolean z2 = false;
        for (int i6 = 0; i6 < size3; i6++) {
            T t2 = this.a.get(i6);
            boolean l2 = l(t2);
            if (l2 && !t2.isAdded()) {
                g(t2);
                z2 = true;
            } else if (l2 && z2) {
                n(t2);
            }
            t2.h().setTransitioning(z);
        }
        v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r() {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.a.get(i2).h().setContainer(null);
        }
        this.a.clear();
        m();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == getFocusedChild()) {
            ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 2);
        }
        super.removeView(view);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        if (this.f11022g || this.f11025k == null) {
            return;
        }
        this.f11022g = true;
        com.facebook.react.modules.core.g.i().m(g.c.NATIVE_ANIMATED_MODULE, this.f11025k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(int i2) {
        this.a.get(i2).h().setContainer(null);
        this.a.remove(i2);
        m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v() {
        u uVar = this.f11018c;
        if (uVar != null) {
            this.f11019d = uVar;
            uVar.u(new c(uVar));
            this.f11018c.k();
            this.f11018c = null;
        }
    }
}