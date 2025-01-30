package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ViewModelStore.java */
/* loaded from: classes.dex */
public class f0 {
    private final HashMap<String, b0> a = new HashMap<>();

    public final void a() {
        for (b0 b0Var : this.a.values()) {
            b0Var.clear();
        }
        this.a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final b0 b(String str) {
        return this.a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<String> c() {
        return new HashSet(this.a.keySet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(String str, b0 b0Var) {
        b0 put = this.a.put(str, b0Var);
        if (put != null) {
            put.onCleared();
        }
    }
}