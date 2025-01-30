package h.c.n0.e.d;

import h.c.s;
import h.c.z;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableConcatMapCompletable.java */
/* loaded from: classes3.dex */
public final class h<T> extends h.c.c {
    final s<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.f> f15414b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.n0.j.i f15415c;

    /* renamed from: d  reason: collision with root package name */
    final int f15416d;

    /* compiled from: ObservableConcatMapCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements z<T>, h.c.k0.b {
        final h.c.e a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.f> f15417b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.n0.j.i f15418c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.n0.j.c f15419d = new h.c.n0.j.c();

        /* renamed from: e  reason: collision with root package name */
        final C0369a f15420e = new C0369a(this);

        /* renamed from: f  reason: collision with root package name */
        final int f15421f;

        /* renamed from: g  reason: collision with root package name */
        h.c.n0.c.j<T> f15422g;

        /* renamed from: h  reason: collision with root package name */
        h.c.k0.b f15423h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f15424j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f15425k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f15426l;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableConcatMapCompletable.java */
        /* renamed from: h.c.n0.e.d.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0369a extends AtomicReference<h.c.k0.b> implements h.c.e {
            final a<?> a;

            C0369a(a<?> aVar) {
                this.a = aVar;
            }

            void a() {
                h.c.n0.a.c.h(this);
            }

            @Override // h.c.e
            public void onComplete() {
                this.a.b();
            }

            @Override // h.c.e
            public void onError(Throwable th) {
                this.a.c(th);
            }

            @Override // h.c.e
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.q(this, bVar);
            }
        }

        a(h.c.e eVar, h.c.m0.n<? super T, ? extends h.c.f> nVar, h.c.n0.j.i iVar, int i2) {
            this.a = eVar;
            this.f15417b = nVar;
            this.f15418c = iVar;
            this.f15421f = i2;
        }

        void a() {
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            h.c.n0.j.c cVar = this.f15419d;
            h.c.n0.j.i iVar = this.f15418c;
            while (!this.f15426l) {
                if (!this.f15424j) {
                    if (iVar == h.c.n0.j.i.BOUNDARY && cVar.get() != null) {
                        this.f15426l = true;
                        this.f15422g.clear();
                        this.a.onError(cVar.b());
                        return;
                    }
                    boolean z2 = this.f15425k;
                    h.c.f fVar = null;
                    try {
                        T poll = this.f15422g.poll();
                        if (poll != null) {
                            fVar = (h.c.f) h.c.n0.b.b.e(this.f15417b.apply(poll), "The mapper returned a null CompletableSource");
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z2 && z) {
                            this.f15426l = true;
                            Throwable b2 = cVar.b();
                            if (b2 != null) {
                                this.a.onError(b2);
                                return;
                            } else {
                                this.a.onComplete();
                                return;
                            }
                        } else if (!z) {
                            this.f15424j = true;
                            fVar.c(this.f15420e);
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.f15426l = true;
                        this.f15422g.clear();
                        this.f15423h.dispose();
                        cVar.a(th);
                        this.a.onError(cVar.b());
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.f15422g.clear();
        }

        void b() {
            this.f15424j = false;
            a();
        }

        void c(Throwable th) {
            if (this.f15419d.a(th)) {
                if (this.f15418c == h.c.n0.j.i.IMMEDIATE) {
                    this.f15426l = true;
                    this.f15423h.dispose();
                    Throwable b2 = this.f15419d.b();
                    if (b2 != h.c.n0.j.j.a) {
                        this.a.onError(b2);
                    }
                    if (getAndIncrement() == 0) {
                        this.f15422g.clear();
                        return;
                    }
                    return;
                }
                this.f15424j = false;
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15426l = true;
            this.f15423h.dispose();
            this.f15420e.a();
            if (getAndIncrement() == 0) {
                this.f15422g.clear();
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15426l;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f15425k = true;
            a();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15419d.a(th)) {
                if (this.f15418c == h.c.n0.j.i.IMMEDIATE) {
                    this.f15426l = true;
                    this.f15420e.a();
                    Throwable b2 = this.f15419d.b();
                    if (b2 != h.c.n0.j.j.a) {
                        this.a.onError(b2);
                    }
                    if (getAndIncrement() == 0) {
                        this.f15422g.clear();
                        return;
                    }
                    return;
                }
                this.f15425k = true;
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (t != null) {
                this.f15422g.offer(t);
            }
            a();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15423h, bVar)) {
                this.f15423h = bVar;
                if (bVar instanceof h.c.n0.c.e) {
                    h.c.n0.c.e eVar = (h.c.n0.c.e) bVar;
                    int n = eVar.n(3);
                    if (n == 1) {
                        this.f15422g = eVar;
                        this.f15425k = true;
                        this.a.onSubscribe(this);
                        a();
                        return;
                    } else if (n == 2) {
                        this.f15422g = eVar;
                        this.a.onSubscribe(this);
                        return;
                    }
                }
                this.f15422g = new h.c.n0.f.c(this.f15421f);
                this.a.onSubscribe(this);
            }
        }
    }

    public h(s<T> sVar, h.c.m0.n<? super T, ? extends h.c.f> nVar, h.c.n0.j.i iVar, int i2) {
        this.a = sVar;
        this.f15414b = nVar;
        this.f15415c = iVar;
        this.f15416d = i2;
    }

    @Override // h.c.c
    protected void t(h.c.e eVar) {
        if (n.a(this.a, this.f15414b, eVar)) {
            return;
        }
        this.a.subscribe(new a(eVar, this.f15414b, this.f15415c, this.f15416d));
    }
}