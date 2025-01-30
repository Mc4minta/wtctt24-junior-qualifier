package e.g.a.b;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* compiled from: SizeMap.java */
/* loaded from: classes2.dex */
class k {
    private final c.e.a<a, SortedSet<j>> a = new c.e.a<>();

    public boolean a(j jVar) {
        for (a aVar : this.a.keySet()) {
            if (aVar.A(jVar)) {
                SortedSet<j> sortedSet = this.a.get(aVar);
                if (sortedSet.contains(jVar)) {
                    return false;
                }
                sortedSet.add(jVar);
                return true;
            }
        }
        TreeSet treeSet = new TreeSet();
        treeSet.add(jVar);
        this.a.put(a.B(jVar.getWidth(), jVar.getHeight()), treeSet);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.a.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<a> d() {
        return this.a.keySet();
    }

    public void e(a aVar) {
        this.a.remove(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SortedSet<j> f(a aVar) {
        return this.a.get(aVar);
    }
}