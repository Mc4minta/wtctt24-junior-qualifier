package e.a.a.w.j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseAnimatableValue.java */
/* loaded from: classes.dex */
abstract class n<V, O> implements m<V, O> {
    final List<e.a.a.a0.a<V>> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(V v) {
        this(Collections.singletonList(new e.a.a.a0.a(v)));
    }

    @Override // e.a.a.w.j.m
    public List<e.a.a.a0.a<V>> b() {
        return this.a;
    }

    @Override // e.a.a.w.j.m
    public boolean isStatic() {
        return this.a.isEmpty() || (this.a.size() == 1 && this.a.get(0).h());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.a.toArray()));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(List<e.a.a.a0.a<V>> list) {
        this.a = list;
    }
}