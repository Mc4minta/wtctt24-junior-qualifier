package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import androidx.fragment.app.u;
import androidx.lifecycle.i;
import java.io.PrintWriter;
import java.util.ArrayList;
import okhttp3.internal.cache.DiskLruCache;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackStackRecord.java */
/* loaded from: classes.dex */
public final class a extends u implements m.h {
    final m t;
    boolean u;
    int v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a(androidx.fragment.app.m r3) {
        /*
            r2 = this;
            androidx.fragment.app.i r0 = r3.g0()
            androidx.fragment.app.j<?> r1 = r3.p
            if (r1 == 0) goto L11
            android.content.Context r1 = r1.e()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            goto L12
        L11:
            r1 = 0
        L12:
            r2.<init>(r0, r1)
            r0 = -1
            r2.v = r0
            r2.t = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.a.<init>(androidx.fragment.app.m):void");
    }

    private static boolean L(u.a aVar) {
        Fragment fragment = aVar.f1688b;
        return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    @Override // androidx.fragment.app.u
    public u A(Fragment fragment) {
        m mVar = fragment.mFragmentManager;
        if (mVar != null && mVar != this.t) {
            throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.A(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(int i2) {
        u.a aVar;
        if (this.f1684i) {
            if (m.r0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            int size = this.f1678c.size();
            for (int i3 = 0; i3 < size; i3++) {
                Fragment fragment = this.f1678c.get(i3).f1688b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i2;
                    if (m.r0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f1688b + " to " + aVar.f1688b.mBackStackNesting);
                    }
                }
            }
        }
    }

    int C(boolean z) {
        if (!this.u) {
            if (m.r0(2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new androidx.core.util.c("FragmentManager"));
                D("  ", printWriter);
                printWriter.close();
            }
            this.u = true;
            if (this.f1684i) {
                this.v = this.t.g();
            } else {
                this.v = -1;
            }
            this.t.P(this, z);
            return this.v;
        }
        throw new IllegalStateException("commit already called");
    }

    public void D(String str, PrintWriter printWriter) {
        E(str, printWriter, true);
    }

    public void E(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1686k);
            printWriter.print(" mIndex=");
            printWriter.print(this.v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.u);
            if (this.f1683h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1683h));
            }
            if (this.f1679d != 0 || this.f1680e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1679d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1680e));
            }
            if (this.f1681f != 0 || this.f1682g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1681f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1682g));
            }
            if (this.f1687l != 0 || this.m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1687l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.m);
            }
            if (this.n != 0 || this.o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.o);
            }
        }
        if (this.f1678c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f1678c.size();
        for (int i2 = 0; i2 < size; i2++) {
            u.a aVar = this.f1678c.get(i2);
            switch (aVar.a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = DiskLruCache.REMOVE;
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i2);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f1688b);
            if (z) {
                if (aVar.f1689c != 0 || aVar.f1690d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f1689c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f1690d));
                }
                if (aVar.f1691e != 0 || aVar.f1692f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f1691e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f1692f));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F() {
        int size = this.f1678c.size();
        for (int i2 = 0; i2 < size; i2++) {
            u.a aVar = this.f1678c.get(i2);
            Fragment fragment = aVar.f1688b;
            if (fragment != null) {
                fragment.setNextTransition(this.f1683h);
            }
            switch (aVar.a) {
                case 1:
                    fragment.setNextAnim(aVar.f1689c);
                    this.t.X0(fragment, false);
                    this.t.d(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                case 3:
                    fragment.setNextAnim(aVar.f1690d);
                    this.t.O0(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.f1690d);
                    this.t.p0(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.f1689c);
                    this.t.X0(fragment, false);
                    this.t.b1(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.f1690d);
                    this.t.r(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.f1689c);
                    this.t.X0(fragment, false);
                    this.t.i(fragment);
                    break;
                case 8:
                    this.t.Z0(fragment);
                    break;
                case 9:
                    this.t.Z0(null);
                    break;
                case 10:
                    this.t.Y0(fragment, aVar.f1694h);
                    break;
            }
            if (!this.r && aVar.a != 1 && fragment != null) {
                this.t.z0(fragment);
            }
        }
        if (this.r) {
            return;
        }
        m mVar = this.t;
        mVar.A0(mVar.o, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(boolean z) {
        for (int size = this.f1678c.size() - 1; size >= 0; size--) {
            u.a aVar = this.f1678c.get(size);
            Fragment fragment = aVar.f1688b;
            if (fragment != null) {
                fragment.setNextTransition(m.U0(this.f1683h));
            }
            switch (aVar.a) {
                case 1:
                    fragment.setNextAnim(aVar.f1692f);
                    this.t.X0(fragment, true);
                    this.t.O0(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                case 3:
                    fragment.setNextAnim(aVar.f1691e);
                    this.t.d(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.f1691e);
                    this.t.b1(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.f1692f);
                    this.t.X0(fragment, true);
                    this.t.p0(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.f1691e);
                    this.t.i(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.f1692f);
                    this.t.X0(fragment, true);
                    this.t.r(fragment);
                    break;
                case 8:
                    this.t.Z0(null);
                    break;
                case 9:
                    this.t.Z0(fragment);
                    break;
                case 10:
                    this.t.Y0(fragment, aVar.f1693g);
                    break;
            }
            if (!this.r && aVar.a != 3 && fragment != null) {
                this.t.z0(fragment);
            }
        }
        if (this.r || !z) {
            return;
        }
        m mVar = this.t;
        mVar.A0(mVar.o, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment H(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i2 = 0;
        while (i2 < this.f1678c.size()) {
            u.a aVar = this.f1678c.get(i2);
            int i3 = aVar.a;
            if (i3 != 1) {
                if (i3 == 2) {
                    Fragment fragment3 = aVar.f1688b;
                    int i4 = fragment3.mContainerId;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList.get(size);
                        if (fragment4.mContainerId == i4) {
                            if (fragment4 == fragment3) {
                                z = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f1678c.add(i2, new u.a(9, fragment4));
                                    i2++;
                                    fragment2 = null;
                                }
                                u.a aVar2 = new u.a(3, fragment4);
                                aVar2.f1689c = aVar.f1689c;
                                aVar2.f1691e = aVar.f1691e;
                                aVar2.f1690d = aVar.f1690d;
                                aVar2.f1692f = aVar.f1692f;
                                this.f1678c.add(i2, aVar2);
                                arrayList.remove(fragment4);
                                i2++;
                            }
                        }
                    }
                    if (z) {
                        this.f1678c.remove(i2);
                        i2--;
                    } else {
                        aVar.a = 1;
                        arrayList.add(fragment3);
                    }
                } else if (i3 == 3 || i3 == 6) {
                    arrayList.remove(aVar.f1688b);
                    Fragment fragment5 = aVar.f1688b;
                    if (fragment5 == fragment2) {
                        this.f1678c.add(i2, new u.a(9, fragment5));
                        i2++;
                        fragment2 = null;
                    }
                } else if (i3 != 7) {
                    if (i3 == 8) {
                        this.f1678c.add(i2, new u.a(9, fragment2));
                        i2++;
                        fragment2 = aVar.f1688b;
                    }
                }
                i2++;
            }
            arrayList.add(aVar.f1688b);
            i2++;
        }
        return fragment2;
    }

    public String I() {
        return this.f1686k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J(int i2) {
        int size = this.f1678c.size();
        for (int i3 = 0; i3 < size; i3++) {
            Fragment fragment = this.f1678c.get(i3).f1688b;
            int i4 = fragment != null ? fragment.mContainerId : 0;
            if (i4 != 0 && i4 == i2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean K(ArrayList<a> arrayList, int i2, int i3) {
        if (i3 == i2) {
            return false;
        }
        int size = this.f1678c.size();
        int i4 = -1;
        for (int i5 = 0; i5 < size; i5++) {
            Fragment fragment = this.f1678c.get(i5).f1688b;
            int i6 = fragment != null ? fragment.mContainerId : 0;
            if (i6 != 0 && i6 != i4) {
                for (int i7 = i2; i7 < i3; i7++) {
                    a aVar = arrayList.get(i7);
                    int size2 = aVar.f1678c.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        Fragment fragment2 = aVar.f1678c.get(i8).f1688b;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i6) {
                            return true;
                        }
                    }
                }
                i4 = i6;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean M() {
        for (int i2 = 0; i2 < this.f1678c.size(); i2++) {
            if (L(this.f1678c.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public void N() {
        if (this.s != null) {
            for (int i2 = 0; i2 < this.s.size(); i2++) {
                this.s.get(i2).run();
            }
            this.s = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(Fragment.e eVar) {
        for (int i2 = 0; i2 < this.f1678c.size(); i2++) {
            u.a aVar = this.f1678c.get(i2);
            if (L(aVar)) {
                aVar.f1688b.setOnStartEnterTransitionListener(eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment P(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f1678c.size() - 1; size >= 0; size--) {
            u.a aVar = this.f1678c.get(size);
            int i2 = aVar.a;
            if (i2 != 1) {
                if (i2 != 3) {
                    switch (i2) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f1688b;
                            break;
                        case 10:
                            aVar.f1694h = aVar.f1693g;
                            break;
                    }
                }
                arrayList.add(aVar.f1688b);
            }
            arrayList.remove(aVar.f1688b);
        }
        return fragment;
    }

    @Override // androidx.fragment.app.m.h
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (m.r0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.f1684i) {
            this.t.b(this);
            return true;
        }
        return true;
    }

    @Override // androidx.fragment.app.u
    public int j() {
        return C(false);
    }

    @Override // androidx.fragment.app.u
    public int k() {
        return C(true);
    }

    @Override // androidx.fragment.app.u
    public void l() {
        o();
        this.t.S(this, false);
    }

    @Override // androidx.fragment.app.u
    public void m() {
        o();
        this.t.S(this, true);
    }

    @Override // androidx.fragment.app.u
    public u n(Fragment fragment) {
        m mVar = fragment.mFragmentManager;
        if (mVar != null && mVar != this.t) {
            throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.n(fragment);
    }

    @Override // androidx.fragment.app.u
    void p(int i2, Fragment fragment, String str, int i3) {
        super.p(i2, fragment, str, i3);
        fragment.mFragmentManager = this.t;
    }

    @Override // androidx.fragment.app.u
    public u q(Fragment fragment) {
        m mVar = fragment.mFragmentManager;
        if (mVar != null && mVar != this.t) {
            throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.q(fragment);
    }

    @Override // androidx.fragment.app.u
    public u r(Fragment fragment) {
        m mVar = fragment.mFragmentManager;
        if (mVar != null && mVar != this.t) {
            throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.r(fragment);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.v >= 0) {
            sb.append(" #");
            sb.append(this.v);
        }
        if (this.f1686k != null) {
            sb.append(" ");
            sb.append(this.f1686k);
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // androidx.fragment.app.u
    public u w(Fragment fragment, i.b bVar) {
        if (fragment.mFragmentManager == this.t) {
            i.b bVar2 = i.b.CREATED;
            if (bVar.h(bVar2)) {
                return super.w(fragment, bVar);
            }
            throw new IllegalArgumentException("Cannot set maximum Lifecycle below " + bVar2);
        }
        throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.t);
    }

    @Override // androidx.fragment.app.u
    public u x(Fragment fragment) {
        m mVar;
        if (fragment != null && (mVar = fragment.mFragmentManager) != null && mVar != this.t) {
            throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.x(fragment);
    }
}