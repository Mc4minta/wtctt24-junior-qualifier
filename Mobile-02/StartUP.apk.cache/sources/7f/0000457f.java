package e.f.e;

/* compiled from: BaseDataSubscriber.java */
/* loaded from: classes2.dex */
public abstract class b<T> implements e<T> {
    @Override // e.f.e.e
    public void a(c<T> cVar) {
    }

    @Override // e.f.e.e
    public void b(c<T> cVar) {
        try {
            e(cVar);
        } finally {
            cVar.close();
        }
    }

    @Override // e.f.e.e
    public void c(c<T> cVar) {
        boolean b2 = cVar.b();
        try {
            f(cVar);
        } finally {
            if (b2) {
                cVar.close();
            }
        }
    }

    @Override // e.f.e.e
    public void d(c<T> cVar) {
    }

    protected abstract void e(c<T> cVar);

    protected abstract void f(c<T> cVar);
}