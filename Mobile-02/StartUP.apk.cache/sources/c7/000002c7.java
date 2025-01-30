package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.fragment.app.v;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.i;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
public abstract class m {
    private static boolean a;
    private ArrayList<androidx.fragment.app.a> A;
    private ArrayList<Boolean> B;
    private ArrayList<Fragment> C;
    private ArrayList<j> D;
    private p E;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1630c;

    /* renamed from: e  reason: collision with root package name */
    ArrayList<androidx.fragment.app.a> f1632e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<Fragment> f1633f;

    /* renamed from: h  reason: collision with root package name */
    private OnBackPressedDispatcher f1635h;

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<g> f1638k;
    androidx.fragment.app.j<?> p;
    androidx.fragment.app.f q;
    private Fragment r;
    Fragment s;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<h> f1629b = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final t f1631d = new t();

    /* renamed from: g  reason: collision with root package name */
    private final k f1634g = new k(this);

    /* renamed from: i  reason: collision with root package name */
    private final androidx.activity.b f1636i = new a(false);

    /* renamed from: j  reason: collision with root package name */
    private final AtomicInteger f1637j = new AtomicInteger();

    /* renamed from: l  reason: collision with root package name */
    private ConcurrentHashMap<Fragment, HashSet<androidx.core.os.c>> f1639l = new ConcurrentHashMap<>();
    private final v.g m = new b();
    private final l n = new l(this);
    int o = -1;
    private androidx.fragment.app.i t = null;
    private androidx.fragment.app.i u = new c();
    private Runnable F = new d();

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    class a extends androidx.activity.b {
        a(boolean z) {
            super(z);
        }

        @Override // androidx.activity.b
        public void b() {
            m.this.o0();
        }
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    class b implements v.g {
        b() {
        }

        @Override // androidx.fragment.app.v.g
        public void a(Fragment fragment, androidx.core.os.c cVar) {
            if (cVar.c()) {
                return;
            }
            m.this.N0(fragment, cVar);
        }

        @Override // androidx.fragment.app.v.g
        public void b(Fragment fragment, androidx.core.os.c cVar) {
            m.this.c(fragment, cVar);
        }
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    class c extends androidx.fragment.app.i {
        c() {
        }

        @Override // androidx.fragment.app.i
        public Fragment a(ClassLoader classLoader, String str) {
            androidx.fragment.app.j<?> jVar = m.this.p;
            return jVar.a(jVar.e(), str, null);
        }
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.R(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f1642b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Fragment f1643c;

        e(ViewGroup viewGroup, View view, Fragment fragment) {
            this.a = viewGroup;
            this.f1642b = view;
            this.f1643c = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.endViewTransition(this.f1642b);
            animator.removeListener(this);
            Fragment fragment = this.f1643c;
            View view = fragment.mView;
            if (view == null || !fragment.mHidden) {
                return;
            }
            view.setVisibility(8);
        }
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static abstract class f {
        public void onFragmentActivityCreated(m mVar, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentAttached(m mVar, Fragment fragment, Context context) {
        }

        public void onFragmentCreated(m mVar, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentDestroyed(m mVar, Fragment fragment) {
        }

        public void onFragmentDetached(m mVar, Fragment fragment) {
        }

        public void onFragmentPaused(m mVar, Fragment fragment) {
        }

        public void onFragmentPreAttached(m mVar, Fragment fragment, Context context) {
        }

        public void onFragmentPreCreated(m mVar, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentResumed(m mVar, Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(m mVar, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentStarted(m mVar, Fragment fragment) {
        }

        public void onFragmentStopped(m mVar, Fragment fragment) {
        }

        public void onFragmentViewCreated(m mVar, Fragment fragment, View view, Bundle bundle) {
        }

        public void onFragmentViewDestroyed(m mVar, Fragment fragment) {
        }
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public interface g {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public interface h {
        boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    private class i implements h {
        final String a;

        /* renamed from: b  reason: collision with root package name */
        final int f1645b;

        /* renamed from: c  reason: collision with root package name */
        final int f1646c;

        i(String str, int i2, int i3) {
            this.a = str;
            this.f1645b = i2;
            this.f1646c = i3;
        }

        @Override // androidx.fragment.app.m.h
        public boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = m.this.s;
            if (fragment == null || this.f1645b >= 0 || this.a != null || !fragment.getChildFragmentManager().I0()) {
                return m.this.K0(arrayList, arrayList2, this.a, this.f1645b, this.f1646c);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class j implements Fragment.e {
        final boolean a;

        /* renamed from: b  reason: collision with root package name */
        final androidx.fragment.app.a f1648b;

        /* renamed from: c  reason: collision with root package name */
        private int f1649c;

        j(androidx.fragment.app.a aVar, boolean z) {
            this.a = z;
            this.f1648b = aVar;
        }

        @Override // androidx.fragment.app.Fragment.e
        public void a() {
            this.f1649c++;
        }

        @Override // androidx.fragment.app.Fragment.e
        public void b() {
            int i2 = this.f1649c - 1;
            this.f1649c = i2;
            if (i2 != 0) {
                return;
            }
            this.f1648b.t.W0();
        }

        void c() {
            androidx.fragment.app.a aVar = this.f1648b;
            aVar.t.o(aVar, this.a, false, false);
        }

        void d() {
            boolean z = this.f1649c > 0;
            for (Fragment fragment : this.f1648b.t.h0()) {
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            androidx.fragment.app.a aVar = this.f1648b;
            aVar.t.o(aVar, this.a, !z, true);
        }

        public boolean e() {
            return this.f1649c == 0;
        }
    }

    private void D(Fragment fragment) {
        if (fragment == null || !fragment.equals(X(fragment.mWho))) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    private boolean J0(String str, int i2, int i3) {
        R(false);
        Q(true);
        Fragment fragment = this.s;
        if (fragment == null || i2 >= 0 || str != null || !fragment.getChildFragmentManager().I0()) {
            boolean K0 = K0(this.A, this.B, str, i2, i3);
            if (K0) {
                this.f1630c = true;
                try {
                    Q0(this.A, this.B);
                } finally {
                    n();
                }
            }
            e1();
            M();
            this.f1631d.b();
            return K0;
        }
        return true;
    }

    private void K(int i2) {
        try {
            this.f1630c = true;
            this.f1631d.d(i2);
            A0(i2, false);
            this.f1630c = false;
            R(true);
        } catch (Throwable th) {
            this.f1630c = false;
            throw th;
        }
    }

    private int L0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, c.e.b<Fragment> bVar) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            androidx.fragment.app.a aVar = arrayList.get(i5);
            boolean booleanValue = arrayList2.get(i5).booleanValue();
            if (aVar.M() && !aVar.K(arrayList, i5 + 1, i3)) {
                if (this.D == null) {
                    this.D = new ArrayList<>();
                }
                j jVar = new j(aVar, booleanValue);
                this.D.add(jVar);
                aVar.O(jVar);
                if (booleanValue) {
                    aVar.F();
                } else {
                    aVar.G(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, aVar);
                }
                a(bVar);
            }
        }
        return i4;
    }

    private void M() {
        if (this.z) {
            this.z = false;
            c1();
        }
    }

    private void O() {
        if (this.f1639l.isEmpty()) {
            return;
        }
        for (Fragment fragment : this.f1639l.keySet()) {
            k(fragment);
            C0(fragment, fragment.getStateAfterAnimating());
        }
    }

    private void Q(boolean z) {
        if (!this.f1630c) {
            if (this.p == null) {
                if (this.y) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            } else if (Looper.myLooper() == this.p.f().getLooper()) {
                if (!z) {
                    m();
                }
                if (this.A == null) {
                    this.A = new ArrayList<>();
                    this.B = new ArrayList<>();
                }
                this.f1630c = true;
                try {
                    W(null, null);
                    return;
                } finally {
                    this.f1630c = false;
                }
            } else {
                throw new IllegalStateException("Must be called from main thread of fragment host");
            }
        }
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    private void Q0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() == arrayList2.size()) {
            W(arrayList, arrayList2);
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                if (!arrayList.get(i2).r) {
                    if (i3 != i2) {
                        U(arrayList, arrayList2, i3, i2);
                    }
                    i3 = i2 + 1;
                    if (arrayList2.get(i2).booleanValue()) {
                        while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).r) {
                            i3++;
                        }
                    }
                    U(arrayList, arrayList2, i2, i3);
                    i2 = i3 - 1;
                }
                i2++;
            }
            if (i3 != size) {
                U(arrayList, arrayList2, i3, size);
                return;
            }
            return;
        }
        throw new IllegalStateException("Internal error with the back stack records");
    }

    private void S0() {
        if (this.f1638k != null) {
            for (int i2 = 0; i2 < this.f1638k.size(); i2++) {
                this.f1638k.get(i2).a();
            }
        }
    }

    private static void T(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            androidx.fragment.app.a aVar = arrayList.get(i2);
            if (arrayList2.get(i2).booleanValue()) {
                aVar.B(-1);
                aVar.G(i2 == i3 + (-1));
            } else {
                aVar.B(1);
                aVar.F();
            }
            i2++;
        }
    }

    private void U(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        int i4;
        int i5 = i2;
        boolean z = arrayList.get(i5).r;
        ArrayList<Fragment> arrayList3 = this.C;
        if (arrayList3 == null) {
            this.C = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.C.addAll(this.f1631d.m());
        Fragment l0 = l0();
        boolean z2 = false;
        for (int i6 = i5; i6 < i3; i6++) {
            androidx.fragment.app.a aVar = arrayList.get(i6);
            if (!arrayList2.get(i6).booleanValue()) {
                l0 = aVar.H(this.C, l0);
            } else {
                l0 = aVar.P(this.C, l0);
            }
            z2 = z2 || aVar.f1684i;
        }
        this.C.clear();
        if (!z) {
            v.B(this, arrayList, arrayList2, i2, i3, false, this.m);
        }
        T(arrayList, arrayList2, i2, i3);
        if (z) {
            c.e.b<Fragment> bVar = new c.e.b<>();
            a(bVar);
            int L0 = L0(arrayList, arrayList2, i2, i3, bVar);
            y0(bVar);
            i4 = L0;
        } else {
            i4 = i3;
        }
        if (i4 != i5 && z) {
            v.B(this, arrayList, arrayList2, i2, i4, true, this.m);
            A0(this.o, true);
        }
        while (i5 < i3) {
            androidx.fragment.app.a aVar2 = arrayList.get(i5);
            if (arrayList2.get(i5).booleanValue() && aVar2.v >= 0) {
                aVar2.v = -1;
            }
            aVar2.N();
            i5++;
        }
        if (z2) {
            S0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int U0(int i2) {
        if (i2 != 4097) {
            if (i2 != 4099) {
                return i2 != 8194 ? 0 : 4097;
            }
            return 4099;
        }
        return 8194;
    }

    private void W(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<j> arrayList3 = this.D;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            j jVar = this.D.get(i2);
            if (arrayList != null && !jVar.a && (indexOf2 = arrayList.indexOf(jVar.f1648b)) != -1 && arrayList2 != null && arrayList2.get(indexOf2).booleanValue()) {
                this.D.remove(i2);
                i2--;
                size--;
                jVar.c();
            } else if (jVar.e() || (arrayList != null && jVar.f1648b.K(arrayList, 0, arrayList.size()))) {
                this.D.remove(i2);
                i2--;
                size--;
                if (arrayList != null && !jVar.a && (indexOf = arrayList.indexOf(jVar.f1648b)) != -1 && arrayList2 != null && arrayList2.get(indexOf).booleanValue()) {
                    jVar.c();
                } else {
                    jVar.d();
                }
            }
            i2++;
        }
    }

    private void a(c.e.b<Fragment> bVar) {
        int i2 = this.o;
        if (i2 < 1) {
            return;
        }
        int min = Math.min(i2, 3);
        for (Fragment fragment : this.f1631d.m()) {
            if (fragment.mState < min) {
                C0(fragment, min);
                if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                    bVar.add(fragment);
                }
            }
        }
    }

    private void a1(Fragment fragment) {
        ViewGroup f0 = f0(fragment);
        if (f0 != null) {
            int i2 = c.l.b.f3136b;
            if (f0.getTag(i2) == null) {
                f0.setTag(i2, fragment);
            }
            ((Fragment) f0.getTag(i2)).setNextAnim(fragment.getNextAnim());
        }
    }

    private void b0() {
        if (this.D != null) {
            while (!this.D.isEmpty()) {
                this.D.remove(0).d();
            }
        }
    }

    private boolean c0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.f1629b) {
            if (this.f1629b.isEmpty()) {
                return false;
            }
            int size = this.f1629b.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                z |= this.f1629b.get(i2).a(arrayList, arrayList2);
            }
            this.f1629b.clear();
            this.p.f().removeCallbacks(this.F);
            return z;
        }
    }

    private void c1() {
        for (Fragment fragment : this.f1631d.k()) {
            if (fragment != null) {
                E0(fragment);
            }
        }
    }

    private p e0(Fragment fragment) {
        return this.E.d(fragment);
    }

    private void e1() {
        synchronized (this.f1629b) {
            boolean z = true;
            if (!this.f1629b.isEmpty()) {
                this.f1636i.f(true);
            } else {
                this.f1636i.f((d0() <= 0 || !t0(this.r)) ? false : false);
            }
        }
    }

    private ViewGroup f0(Fragment fragment) {
        if (fragment.mContainerId > 0 && this.q.c()) {
            View b2 = this.q.b(fragment.mContainerId);
            if (b2 instanceof ViewGroup) {
                return (ViewGroup) b2;
            }
        }
        return null;
    }

    private void k(Fragment fragment) {
        HashSet<androidx.core.os.c> hashSet = this.f1639l.get(fragment);
        if (hashSet != null) {
            Iterator<androidx.core.os.c> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            hashSet.clear();
            q(fragment);
            this.f1639l.remove(fragment);
        }
    }

    private void m() {
        if (v0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Fragment m0(View view) {
        Object tag = view.getTag(c.l.b.a);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    private void n() {
        this.f1630c = false;
        this.B.clear();
        this.A.clear();
    }

    private void p(Fragment fragment) {
        Animator animator;
        if (fragment.mView != null) {
            e.d b2 = androidx.fragment.app.e.b(this.p.e(), this.q, fragment, !fragment.mHidden);
            if (b2 != null && (animator = b2.f1616b) != null) {
                animator.setTarget(fragment.mView);
                if (fragment.mHidden) {
                    if (fragment.isHideReplaced()) {
                        fragment.setHideReplaced(false);
                    } else {
                        ViewGroup viewGroup = fragment.mContainer;
                        View view = fragment.mView;
                        viewGroup.startViewTransition(view);
                        b2.f1616b.addListener(new e(viewGroup, view, fragment));
                    }
                } else {
                    fragment.mView.setVisibility(0);
                }
                b2.f1616b.start();
            } else {
                if (b2 != null) {
                    fragment.mView.startAnimation(b2.a);
                    b2.a.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            }
        }
        if (fragment.mAdded && s0(fragment)) {
            this.v = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    private void q(Fragment fragment) {
        fragment.performDestroyView();
        this.n.n(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.l(null);
        fragment.mInLayout = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean r0(int i2) {
        return a || Log.isLoggable("FragmentManager", i2);
    }

    private boolean s0(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.l();
    }

    private void x0(s sVar) {
        Fragment i2 = sVar.i();
        if (this.f1631d.c(i2.mWho)) {
            if (r0(2)) {
                Log.v("FragmentManager", "Removed fragment from active set " + i2);
            }
            this.f1631d.o(sVar);
            R0(i2);
        }
    }

    private void y0(c.e.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment q = bVar.q(i2);
            if (!q.mAdded) {
                View requireView = q.requireView();
                q.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(boolean z) {
        for (Fragment fragment : this.f1631d.m()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A0(int i2, boolean z) {
        androidx.fragment.app.j<?> jVar;
        if (this.p == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i2 != this.o) {
            this.o = i2;
            for (Fragment fragment : this.f1631d.m()) {
                z0(fragment);
            }
            for (Fragment fragment2 : this.f1631d.k()) {
                if (fragment2 != null && !fragment2.mIsNewlyAdded) {
                    z0(fragment2);
                }
            }
            c1();
            if (this.v && (jVar = this.p) != null && this.o == 4) {
                jVar.o();
                this.v = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean B(MenuItem menuItem) {
        if (this.o < 1) {
            return false;
        }
        for (Fragment fragment : this.f1631d.m()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B0(Fragment fragment) {
        C0(fragment, this.o);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(Menu menu) {
        if (this.o < 1) {
            return;
        }
        for (Fragment fragment : this.f1631d.m()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
        if (r2 != 3) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void C0(androidx.fragment.app.Fragment r13, int r14) {
        /*
            Method dump skipped, instructions count: 552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.m.C0(androidx.fragment.app.Fragment, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D0() {
        if (this.p == null) {
            return;
        }
        this.w = false;
        this.x = false;
        for (Fragment fragment : this.f1631d.m()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E() {
        K(3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E0(Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.f1630c) {
                this.z = true;
                return;
            }
            fragment.mDeferStart = false;
            C0(fragment, this.o);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(boolean z) {
        for (Fragment fragment : this.f1631d.m()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    public void F0() {
        P(new i(null, -1, 0), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean G(Menu menu) {
        boolean z = false;
        if (this.o < 1) {
            return false;
        }
        for (Fragment fragment : this.f1631d.m()) {
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public void G0(int i2, int i3) {
        if (i2 >= 0) {
            P(new i(null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H() {
        e1();
        D(this.s);
    }

    public void H0(String str, int i2) {
        P(new i(str, -1, i2), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I() {
        this.w = false;
        this.x = false;
        K(4);
    }

    public boolean I0() {
        return J0(null, -1, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J() {
        this.w = false;
        this.x = false;
        K(3);
    }

    boolean K0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int i4;
        ArrayList<androidx.fragment.app.a> arrayList3 = this.f1632e;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f1632e.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i2 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    androidx.fragment.app.a aVar = this.f1632e.get(size2);
                    if ((str != null && str.equals(aVar.I())) || (i2 >= 0 && i2 == aVar.v)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        androidx.fragment.app.a aVar2 = this.f1632e.get(size2);
                        if (str == null || !str.equals(aVar2.I())) {
                            if (i2 < 0 || i2 != aVar2.v) {
                                break;
                            }
                        }
                    }
                }
                i4 = size2;
            } else {
                i4 = -1;
            }
            if (i4 == this.f1632e.size() - 1) {
                return false;
            }
            for (int size3 = this.f1632e.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.f1632e.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L() {
        this.x = true;
        K(2);
    }

    public void M0(f fVar, boolean z) {
        this.n.o(fVar, z);
    }

    public void N(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f1631d.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f1633f;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.f1633f.get(i2).toString());
            }
        }
        ArrayList<androidx.fragment.app.a> arrayList2 = this.f1632e;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                androidx.fragment.app.a aVar = this.f1632e.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.D(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f1637j.get());
        synchronized (this.f1629b) {
            int size3 = this.f1629b.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i4 = 0; i4 < size3; i4++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(this.f1629b.get(i4));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.p);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.q);
        if (this.r != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.r);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.o);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.w);
        printWriter.print(" mStopped=");
        printWriter.print(this.x);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.y);
        if (this.v) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.v);
        }
    }

    void N0(Fragment fragment, androidx.core.os.c cVar) {
        HashSet<androidx.core.os.c> hashSet = this.f1639l.get(fragment);
        if (hashSet != null && hashSet.remove(cVar) && hashSet.isEmpty()) {
            this.f1639l.remove(fragment);
            if (fragment.mState < 3) {
                q(fragment);
                C0(fragment, fragment.getStateAfterAnimating());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O0(Fragment fragment) {
        if (r0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            this.f1631d.p(fragment);
            if (s0(fragment)) {
                this.v = true;
            }
            fragment.mRemoving = true;
            a1(fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(h hVar, boolean z) {
        if (!z) {
            if (this.p == null) {
                if (this.y) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            m();
        }
        synchronized (this.f1629b) {
            if (this.p == null) {
                if (!z) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
                return;
            }
            this.f1629b.add(hVar);
            W0();
        }
    }

    public void P0(g gVar) {
        ArrayList<g> arrayList = this.f1638k;
        if (arrayList != null) {
            arrayList.remove(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean R(boolean z) {
        Q(z);
        boolean z2 = false;
        while (c0(this.A, this.B)) {
            this.f1630c = true;
            try {
                Q0(this.A, this.B);
                n();
                z2 = true;
            } catch (Throwable th) {
                n();
                throw th;
            }
        }
        e1();
        M();
        this.f1631d.b();
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R0(Fragment fragment) {
        if (v0()) {
            if (r0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.E.i(fragment) && r0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(h hVar, boolean z) {
        if (z && (this.p == null || this.y)) {
            return;
        }
        Q(z);
        if (hVar.a(this.A, this.B)) {
            this.f1630c = true;
            try {
                Q0(this.A, this.B);
            } finally {
                n();
            }
        }
        e1();
        M();
        this.f1631d.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T0(Parcelable parcelable) {
        s sVar;
        if (parcelable == null) {
            return;
        }
        o oVar = (o) parcelable;
        if (oVar.a == null) {
            return;
        }
        this.f1631d.q();
        Iterator<r> it = oVar.a.iterator();
        while (it.hasNext()) {
            r next = it.next();
            if (next != null) {
                Fragment c2 = this.E.c(next.f1664b);
                if (c2 != null) {
                    if (r0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + c2);
                    }
                    sVar = new s(this.n, c2, next);
                } else {
                    sVar = new s(this.n, this.p.e().getClassLoader(), g0(), next);
                }
                Fragment i2 = sVar.i();
                i2.mFragmentManager = this;
                if (r0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + i2.mWho + "): " + i2);
                }
                sVar.k(this.p.e().getClassLoader());
                this.f1631d.n(sVar);
                sVar.q(this.o);
            }
        }
        for (Fragment fragment : this.E.f()) {
            if (!this.f1631d.c(fragment.mWho)) {
                if (r0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + oVar.a);
                }
                C0(fragment, 1);
                fragment.mRemoving = true;
                C0(fragment, -1);
            }
        }
        this.f1631d.r(oVar.f1650b);
        if (oVar.f1651c != null) {
            this.f1632e = new ArrayList<>(oVar.f1651c.length);
            int i3 = 0;
            while (true) {
                androidx.fragment.app.b[] bVarArr = oVar.f1651c;
                if (i3 >= bVarArr.length) {
                    break;
                }
                androidx.fragment.app.a a2 = bVarArr[i3].a(this);
                if (r0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i3 + " (index " + a2.v + "): " + a2);
                    PrintWriter printWriter = new PrintWriter(new androidx.core.util.c("FragmentManager"));
                    a2.E("  ", printWriter, false);
                    printWriter.close();
                }
                this.f1632e.add(a2);
                i3++;
            }
        } else {
            this.f1632e = null;
        }
        this.f1637j.set(oVar.f1652d);
        String str = oVar.f1653e;
        if (str != null) {
            Fragment X = X(str);
            this.s = X;
            D(X);
        }
    }

    public boolean V() {
        boolean R = R(true);
        b0();
        return R;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parcelable V0() {
        int size;
        b0();
        O();
        R(true);
        this.w = true;
        ArrayList<r> s = this.f1631d.s();
        androidx.fragment.app.b[] bVarArr = null;
        if (s.isEmpty()) {
            if (r0(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<String> t = this.f1631d.t();
        ArrayList<androidx.fragment.app.a> arrayList = this.f1632e;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            bVarArr = new androidx.fragment.app.b[size];
            for (int i2 = 0; i2 < size; i2++) {
                bVarArr[i2] = new androidx.fragment.app.b(this.f1632e.get(i2));
                if (r0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f1632e.get(i2));
                }
            }
        }
        o oVar = new o();
        oVar.a = s;
        oVar.f1650b = t;
        oVar.f1651c = bVarArr;
        oVar.f1652d = this.f1637j.get();
        Fragment fragment = this.s;
        if (fragment != null) {
            oVar.f1653e = fragment.mWho;
        }
        return oVar;
    }

    void W0() {
        synchronized (this.f1629b) {
            ArrayList<j> arrayList = this.D;
            boolean z = (arrayList == null || arrayList.isEmpty()) ? false : true;
            boolean z2 = this.f1629b.size() == 1;
            if (z || z2) {
                this.p.f().removeCallbacks(this.F);
                this.p.f().post(this.F);
                e1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment X(String str) {
        return this.f1631d.f(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X0(Fragment fragment, boolean z) {
        ViewGroup f0 = f0(fragment);
        if (f0 == null || !(f0 instanceof androidx.fragment.app.g)) {
            return;
        }
        ((androidx.fragment.app.g) f0).setDrawDisappearingViewsLast(!z);
    }

    public Fragment Y(int i2) {
        return this.f1631d.g(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y0(Fragment fragment, i.b bVar) {
        if (fragment.equals(X(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public Fragment Z(String str) {
        return this.f1631d.h(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z0(Fragment fragment) {
        if (fragment != null && (!fragment.equals(X(fragment.mWho)) || (fragment.mHost != null && fragment.mFragmentManager != this))) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        Fragment fragment2 = this.s;
        this.s = fragment;
        D(fragment2);
        D(this.s);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment a0(String str) {
        return this.f1631d.i(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(androidx.fragment.app.a aVar) {
        if (this.f1632e == null) {
            this.f1632e = new ArrayList<>();
        }
        this.f1632e.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b1(Fragment fragment) {
        if (r0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    void c(Fragment fragment, androidx.core.os.c cVar) {
        if (this.f1639l.get(fragment) == null) {
            this.f1639l.put(fragment, new HashSet<>());
        }
        this.f1639l.get(fragment).add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Fragment fragment) {
        if (r0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        w0(fragment);
        if (fragment.mDetached) {
            return;
        }
        this.f1631d.a(fragment);
        fragment.mRemoving = false;
        if (fragment.mView == null) {
            fragment.mHiddenChanged = false;
        }
        if (s0(fragment)) {
            this.v = true;
        }
    }

    public int d0() {
        ArrayList<androidx.fragment.app.a> arrayList = this.f1632e;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void d1(f fVar) {
        this.n.p(fVar);
    }

    public void e(g gVar) {
        if (this.f1638k == null) {
            this.f1638k = new ArrayList<>();
        }
        this.f1638k.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Fragment fragment) {
        if (v0()) {
            if (r0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.E.a(fragment) && r0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f1637j.getAndIncrement();
    }

    public androidx.fragment.app.i g0() {
        androidx.fragment.app.i iVar = this.t;
        if (iVar != null) {
            return iVar;
        }
        Fragment fragment = this.r;
        if (fragment != null) {
            return fragment.mFragmentManager.g0();
        }
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(androidx.fragment.app.j<?> jVar, androidx.fragment.app.f fVar, Fragment fragment) {
        if (this.p == null) {
            this.p = jVar;
            this.q = fVar;
            this.r = fragment;
            if (fragment != null) {
                e1();
            }
            if (jVar instanceof androidx.activity.c) {
                androidx.activity.c cVar = (androidx.activity.c) jVar;
                OnBackPressedDispatcher onBackPressedDispatcher = cVar.getOnBackPressedDispatcher();
                this.f1635h = onBackPressedDispatcher;
                androidx.lifecycle.o oVar = cVar;
                if (fragment != null) {
                    oVar = fragment;
                }
                onBackPressedDispatcher.a(oVar, this.f1636i);
            }
            if (fragment != null) {
                this.E = fragment.mFragmentManager.e0(fragment);
                return;
            } else if (jVar instanceof g0) {
                this.E = p.e(((g0) jVar).getViewModelStore());
                return;
            } else {
                this.E = new p(false);
                return;
            }
        }
        throw new IllegalStateException("Already attached");
    }

    public List<Fragment> h0() {
        return this.f1631d.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Fragment fragment) {
        if (r0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.f1631d.a(fragment);
            if (r0(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (s0(fragment)) {
                this.v = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater.Factory2 i0() {
        return this.f1634g;
    }

    public u j() {
        return new androidx.fragment.app.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l j0() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment k0() {
        return this.r;
    }

    boolean l() {
        boolean z = false;
        for (Fragment fragment : this.f1631d.k()) {
            if (fragment != null) {
                z = s0(fragment);
                continue;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public Fragment l0() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0 n0(Fragment fragment) {
        return this.E.g(fragment);
    }

    void o(androidx.fragment.app.a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.G(z3);
        } else {
            aVar.F();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            v.B(this, arrayList, arrayList2, 0, 1, true, this.m);
        }
        if (z3) {
            A0(this.o, true);
        }
        for (Fragment fragment : this.f1631d.k()) {
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && aVar.J(fragment.mContainerId)) {
                float f2 = fragment.mPostponedAlpha;
                if (f2 > 0.0f) {
                    fragment.mView.setAlpha(f2);
                }
                if (z3) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    void o0() {
        R(true);
        if (this.f1636i.c()) {
            I0();
        } else {
            this.f1635h.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p0(Fragment fragment) {
        if (r0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        a1(fragment);
    }

    public boolean q0() {
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Fragment fragment) {
        if (r0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (r0(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.f1631d.p(fragment);
            if (s0(fragment)) {
                this.v = true;
            }
            a1(fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        this.w = false;
        this.x = false;
        K(2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(Configuration configuration) {
        for (Fragment fragment : this.f1631d.m()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        m mVar = fragment.mFragmentManager;
        return fragment.equals(mVar.l0()) && t0(mVar.r);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.r;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.r)));
            sb.append("}");
        } else {
            androidx.fragment.app.j<?> jVar = this.p;
            if (jVar != null) {
                sb.append(jVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.p)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u(MenuItem menuItem) {
        if (this.o < 1) {
            return false;
        }
        for (Fragment fragment : this.f1631d.m()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u0(int i2) {
        return this.o >= i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        this.w = false;
        this.x = false;
        K(1);
    }

    public boolean v0() {
        return this.w || this.x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w(Menu menu, MenuInflater menuInflater) {
        if (this.o < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.f1631d.m()) {
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.f1633f != null) {
            for (int i2 = 0; i2 < this.f1633f.size(); i2++) {
                Fragment fragment2 = this.f1633f.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f1633f = arrayList;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w0(Fragment fragment) {
        if (this.f1631d.c(fragment.mWho)) {
            return;
        }
        s sVar = new s(this.n, fragment);
        sVar.k(this.p.e().getClassLoader());
        this.f1631d.n(sVar);
        if (fragment.mRetainInstanceChangedWhileDetached) {
            if (fragment.mRetainInstance) {
                f(fragment);
            } else {
                R0(fragment);
            }
            fragment.mRetainInstanceChangedWhileDetached = false;
        }
        sVar.q(this.o);
        if (r0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x() {
        this.y = true;
        R(true);
        O();
        K(-1);
        this.p = null;
        this.q = null;
        this.r = null;
        if (this.f1635h != null) {
            this.f1636i.d();
            this.f1635h = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        K(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z() {
        for (Fragment fragment : this.f1631d.m()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z0(Fragment fragment) {
        if (!this.f1631d.c(fragment.mWho)) {
            if (r0(3)) {
                Log.d("FragmentManager", "Ignoring moving " + fragment + " to state " + this.o + "since it is not added to " + this);
                return;
            }
            return;
        }
        B0(fragment);
        if (fragment.mView != null) {
            Fragment j2 = this.f1631d.j(fragment);
            if (j2 != null) {
                View view = j2.mView;
                ViewGroup viewGroup = fragment.mContainer;
                int indexOfChild = viewGroup.indexOfChild(view);
                int indexOfChild2 = viewGroup.indexOfChild(fragment.mView);
                if (indexOfChild2 < indexOfChild) {
                    viewGroup.removeViewAt(indexOfChild2);
                    viewGroup.addView(fragment.mView, indexOfChild);
                }
            }
            if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                float f2 = fragment.mPostponedAlpha;
                if (f2 > 0.0f) {
                    fragment.mView.setAlpha(f2);
                }
                fragment.mPostponedAlpha = 0.0f;
                fragment.mIsNewlyAdded = false;
                e.d b2 = androidx.fragment.app.e.b(this.p.e(), this.q, fragment, true);
                if (b2 != null) {
                    Animation animation = b2.a;
                    if (animation != null) {
                        fragment.mView.startAnimation(animation);
                    } else {
                        b2.f1616b.setTarget(fragment.mView);
                        b2.f1616b.start();
                    }
                }
            }
        }
        if (fragment.mHiddenChanged) {
            p(fragment);
        }
    }
}