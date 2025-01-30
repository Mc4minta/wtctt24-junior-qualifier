package e.a.a.u.c;

import java.util.Collections;

/* compiled from: ValueCallbackKeyframeAnimation.java */
/* loaded from: classes.dex */
public class p<K, A> extends a<K, A> {

    /* renamed from: i  reason: collision with root package name */
    private final e.a.a.a0.b<A> f11728i;

    /* renamed from: j  reason: collision with root package name */
    private final A f11729j;

    public p(e.a.a.a0.c<A> cVar) {
        this(cVar, null);
    }

    @Override // e.a.a.u.c.a
    float c() {
        return 1.0f;
    }

    @Override // e.a.a.u.c.a
    public A h() {
        e.a.a.a0.c<A> cVar = this.f11695e;
        A a = this.f11729j;
        return cVar.b(0.0f, 0.0f, a, a, f(), f(), f());
    }

    @Override // e.a.a.u.c.a
    A i(e.a.a.a0.a<K> aVar, float f2) {
        return h();
    }

    @Override // e.a.a.u.c.a
    public void j() {
        if (this.f11695e != null) {
            super.j();
        }
    }

    @Override // e.a.a.u.c.a
    public void l(float f2) {
        this.f11694d = f2;
    }

    public p(e.a.a.a0.c<A> cVar, A a) {
        super(Collections.emptyList());
        this.f11728i = new e.a.a.a0.b<>();
        m(cVar);
        this.f11729j = a;
    }
}