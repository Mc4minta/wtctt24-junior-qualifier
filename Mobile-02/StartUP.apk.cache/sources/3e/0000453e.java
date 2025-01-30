package e.f.b.b;

import e.f.b.b.d;

/* compiled from: DefaultEntryEvictionComparatorSupplier.java */
/* loaded from: classes2.dex */
public class b implements h {

    /* compiled from: DefaultEntryEvictionComparatorSupplier.java */
    /* loaded from: classes2.dex */
    class a implements g {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d.a aVar, d.a aVar2) {
            long a = aVar.a();
            long a2 = aVar2.a();
            if (a < a2) {
                return -1;
            }
            return a2 == a ? 0 : 1;
        }
    }

    @Override // e.f.b.b.h
    public g get() {
        return new a();
    }
}