package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.f0;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentManagerViewModel.java */
/* loaded from: classes.dex */
public final class p extends b0 {
    private static final d0.b a = new a();

    /* renamed from: e  reason: collision with root package name */
    private final boolean f1657e;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Fragment> f1654b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, p> f1655c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, f0> f1656d = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private boolean f1658f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1659g = false;

    /* compiled from: FragmentManagerViewModel.java */
    /* loaded from: classes.dex */
    static class a implements d0.b {
        a() {
        }

        @Override // androidx.lifecycle.d0.b
        public <T extends b0> T create(Class<T> cls) {
            return new p(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(boolean z) {
        this.f1657e = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p e(f0 f0Var) {
        return (p) new d0(f0Var, a).a(p.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Fragment fragment) {
        if (this.f1654b.containsKey(fragment.mWho)) {
            return false;
        }
        this.f1654b.put(fragment.mWho, fragment);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Fragment fragment) {
        if (m.r0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        p pVar = this.f1655c.get(fragment.mWho);
        if (pVar != null) {
            pVar.onCleared();
            this.f1655c.remove(fragment.mWho);
        }
        f0 f0Var = this.f1656d.get(fragment.mWho);
        if (f0Var != null) {
            f0Var.a();
            this.f1656d.remove(fragment.mWho);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment c(String str) {
        return this.f1654b.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p d(Fragment fragment) {
        p pVar = this.f1655c.get(fragment.mWho);
        if (pVar == null) {
            p pVar2 = new p(this.f1657e);
            this.f1655c.put(fragment.mWho, pVar2);
            return pVar2;
        }
        return pVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        return this.f1654b.equals(pVar.f1654b) && this.f1655c.equals(pVar.f1655c) && this.f1656d.equals(pVar.f1656d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<Fragment> f() {
        return this.f1654b.values();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0 g(Fragment fragment) {
        f0 f0Var = this.f1656d.get(fragment.mWho);
        if (f0Var == null) {
            f0 f0Var2 = new f0();
            this.f1656d.put(fragment.mWho, f0Var2);
            return f0Var2;
        }
        return f0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.f1658f;
    }

    public int hashCode() {
        return (((this.f1654b.hashCode() * 31) + this.f1655c.hashCode()) * 31) + this.f1656d.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(Fragment fragment) {
        return this.f1654b.remove(fragment.mWho) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j(Fragment fragment) {
        if (this.f1654b.containsKey(fragment.mWho)) {
            if (this.f1657e) {
                return this.f1658f;
            }
            return !this.f1659g;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.b0
    public void onCleared() {
        if (m.r0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f1658f = true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f1654b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f1655c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f1656d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}