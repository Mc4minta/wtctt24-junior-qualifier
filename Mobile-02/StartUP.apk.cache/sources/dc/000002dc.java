package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentStore.java */
/* loaded from: classes.dex */
public class t {
    private final ArrayList<Fragment> a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, s> f1676b = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        if (!this.a.contains(fragment)) {
            synchronized (this.a) {
                this.a.add(fragment);
            }
            fragment.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f1676b.values().removeAll(Collections.singleton(null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(String str) {
        return this.f1676b.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i2) {
        Iterator<Fragment> it = this.a.iterator();
        while (it.hasNext()) {
            s sVar = this.f1676b.get(it.next().mWho);
            if (sVar != null) {
                sVar.q(i2);
            }
        }
        for (s sVar2 : this.f1676b.values()) {
            if (sVar2 != null) {
                sVar2.q(i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f1676b.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments:");
            for (s sVar : this.f1676b.values()) {
                printWriter.print(str);
                if (sVar != null) {
                    Fragment i2 = sVar.i();
                    printWriter.println(i2);
                    i2.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i3 = 0; i3 < size; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.a.get(i3).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment f(String str) {
        s sVar = this.f1676b.get(str);
        if (sVar != null) {
            return sVar.i();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment g(int i2) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.a.get(size);
            if (fragment != null && fragment.mFragmentId == i2) {
                return fragment;
            }
        }
        for (s sVar : this.f1676b.values()) {
            if (sVar != null) {
                Fragment i3 = sVar.i();
                if (i3.mFragmentId == i2) {
                    return i3;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment h(String str) {
        if (str != null) {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str != null) {
            for (s sVar : this.f1676b.values()) {
                if (sVar != null) {
                    Fragment i2 = sVar.i();
                    if (str.equals(i2.mTag)) {
                        return i2;
                    }
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment i(String str) {
        Fragment findFragmentByWho;
        for (s sVar : this.f1676b.values()) {
            if (sVar != null && (findFragmentByWho = sVar.i().findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment j(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        View view = fragment.mView;
        if (viewGroup != null && view != null) {
            for (int indexOf = this.a.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                Fragment fragment2 = this.a.get(indexOf);
                if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Fragment> k() {
        ArrayList arrayList = new ArrayList();
        for (s sVar : this.f1676b.values()) {
            if (sVar != null) {
                arrayList.add(sVar.i());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s l(String str) {
        return this.f1676b.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Fragment> m() {
        ArrayList arrayList;
        if (this.a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.a) {
            arrayList = new ArrayList(this.a);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(s sVar) {
        this.f1676b.put(sVar.i().mWho, sVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(s sVar) {
        Fragment i2 = sVar.i();
        for (s sVar2 : this.f1676b.values()) {
            if (sVar2 != null) {
                Fragment i3 = sVar2.i();
                if (i2.mWho.equals(i3.mTargetWho)) {
                    i3.mTarget = i2;
                    i3.mTargetWho = null;
                }
            }
        }
        this.f1676b.put(i2.mWho, null);
        String str = i2.mTargetWho;
        if (str != null) {
            i2.mTarget = f(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(Fragment fragment) {
        synchronized (this.a) {
            this.a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        this.f1676b.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(List<String> list) {
        this.a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment f2 = f(str);
                if (f2 != null) {
                    if (m.r0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + f2);
                    }
                    a(f2);
                } else {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<r> s() {
        ArrayList<r> arrayList = new ArrayList<>(this.f1676b.size());
        for (s sVar : this.f1676b.values()) {
            if (sVar != null) {
                Fragment i2 = sVar.i();
                r o = sVar.o();
                arrayList.add(o);
                if (m.r0(2)) {
                    Log.v("FragmentManager", "Saved state of " + i2 + ": " + o.n);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> t() {
        synchronized (this.a) {
            if (this.a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.a.size());
            Iterator<Fragment> it = this.a.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.mWho);
                if (m.r0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.mWho + "): " + next);
                }
            }
            return arrayList;
        }
    }
}