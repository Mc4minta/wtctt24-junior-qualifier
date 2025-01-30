package h.c.n0.a;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: ArrayCompositeDisposable.java */
/* loaded from: classes.dex */
public final class a extends AtomicReferenceArray<h.c.k0.b> implements h.c.k0.b {
    public a(int i2) {
        super(i2);
    }

    public boolean a(int i2, h.c.k0.b bVar) {
        h.c.k0.b bVar2;
        do {
            bVar2 = get(i2);
            if (bVar2 == c.DISPOSED) {
                bVar.dispose();
                return false;
            }
        } while (!compareAndSet(i2, bVar2, bVar));
        if (bVar2 != null) {
            bVar2.dispose();
            return true;
        }
        return true;
    }

    @Override // h.c.k0.b
    public void dispose() {
        h.c.k0.b andSet;
        if (get(0) != c.DISPOSED) {
            int length = length();
            for (int i2 = 0; i2 < length; i2++) {
                h.c.k0.b bVar = get(i2);
                c cVar = c.DISPOSED;
                if (bVar != cVar && (andSet = getAndSet(i2, cVar)) != cVar && andSet != null) {
                    andSet.dispose();
                }
            }
        }
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return get(0) == c.DISPOSED;
    }
}