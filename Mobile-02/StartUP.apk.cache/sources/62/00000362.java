package androidx.navigation;

import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.f0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

/* compiled from: NavControllerViewModel.java */
/* loaded from: classes.dex */
class g extends b0 {
    private static final d0.b a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<UUID, f0> f1880b = new HashMap<>();

    /* compiled from: NavControllerViewModel.java */
    /* loaded from: classes.dex */
    class a implements d0.b {
        a() {
        }

        @Override // androidx.lifecycle.d0.b
        public <T extends b0> T create(Class<T> cls) {
            return new g();
        }
    }

    g() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g b(f0 f0Var) {
        return (g) new d0(f0Var, a).a(g.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(UUID uuid) {
        f0 remove = this.f1880b.remove(uuid);
        if (remove != null) {
            remove.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0 c(UUID uuid) {
        f0 f0Var = this.f1880b.get(uuid);
        if (f0Var == null) {
            f0 f0Var2 = new f0();
            this.f1880b.put(uuid, f0Var2);
            return f0Var2;
        }
        return f0Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.b0
    public void onCleared() {
        for (f0 f0Var : this.f1880b.values()) {
            f0Var.a();
        }
        this.f1880b.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NavControllerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} ViewModelStores (");
        Iterator<UUID> it = this.f1880b.keySet().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}