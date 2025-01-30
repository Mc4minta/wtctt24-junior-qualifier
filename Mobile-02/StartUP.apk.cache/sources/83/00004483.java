package e.a.a.u.c;

import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseKeyframeAnimation.java */
/* loaded from: classes.dex */
public abstract class a<K, A> {

    /* renamed from: c  reason: collision with root package name */
    private final d<K> f11693c;

    /* renamed from: e  reason: collision with root package name */
    protected e.a.a.a0.c<A> f11695e;
    final List<b> a = new ArrayList(1);

    /* renamed from: b  reason: collision with root package name */
    private boolean f11692b = false;

    /* renamed from: d  reason: collision with root package name */
    protected float f11694d = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    private A f11696f = null;

    /* renamed from: g  reason: collision with root package name */
    private float f11697g = -1.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f11698h = -1.0f;

    /* compiled from: BaseKeyframeAnimation.java */
    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseKeyframeAnimation.java */
    /* loaded from: classes.dex */
    public static final class c<T> implements d<T> {
        private c() {
        }

        @Override // e.a.a.u.c.a.d
        public boolean a(float f2) {
            throw new IllegalStateException("not implemented");
        }

        @Override // e.a.a.u.c.a.d
        public e.a.a.a0.a<T> b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // e.a.a.u.c.a.d
        public boolean c(float f2) {
            return false;
        }

        @Override // e.a.a.u.c.a.d
        public float d() {
            return 1.0f;
        }

        @Override // e.a.a.u.c.a.d
        public float e() {
            return 0.0f;
        }

        @Override // e.a.a.u.c.a.d
        public boolean isEmpty() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseKeyframeAnimation.java */
    /* loaded from: classes.dex */
    public interface d<T> {
        boolean a(float f2);

        e.a.a.a0.a<T> b();

        boolean c(float f2);

        float d();

        float e();

        boolean isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseKeyframeAnimation.java */
    /* loaded from: classes.dex */
    public static final class e<T> implements d<T> {
        private final List<? extends e.a.a.a0.a<T>> a;

        /* renamed from: c  reason: collision with root package name */
        private e.a.a.a0.a<T> f11700c = null;

        /* renamed from: d  reason: collision with root package name */
        private float f11701d = -1.0f;

        /* renamed from: b  reason: collision with root package name */
        private e.a.a.a0.a<T> f11699b = f(0.0f);

        e(List<? extends e.a.a.a0.a<T>> list) {
            this.a = list;
        }

        private e.a.a.a0.a<T> f(float f2) {
            List<? extends e.a.a.a0.a<T>> list = this.a;
            e.a.a.a0.a<T> aVar = list.get(list.size() - 1);
            if (f2 >= aVar.e()) {
                return aVar;
            }
            for (int size = this.a.size() - 2; size >= 1; size--) {
                e.a.a.a0.a<T> aVar2 = this.a.get(size);
                if (this.f11699b != aVar2 && aVar2.a(f2)) {
                    return aVar2;
                }
            }
            return this.a.get(0);
        }

        @Override // e.a.a.u.c.a.d
        public boolean a(float f2) {
            e.a.a.a0.a<T> aVar = this.f11700c;
            e.a.a.a0.a<T> aVar2 = this.f11699b;
            if (aVar == aVar2 && this.f11701d == f2) {
                return true;
            }
            this.f11700c = aVar2;
            this.f11701d = f2;
            return false;
        }

        @Override // e.a.a.u.c.a.d
        public e.a.a.a0.a<T> b() {
            return this.f11699b;
        }

        @Override // e.a.a.u.c.a.d
        public boolean c(float f2) {
            if (this.f11699b.a(f2)) {
                return !this.f11699b.h();
            }
            this.f11699b = f(f2);
            return true;
        }

        @Override // e.a.a.u.c.a.d
        public float d() {
            List<? extends e.a.a.a0.a<T>> list = this.a;
            return list.get(list.size() - 1).b();
        }

        @Override // e.a.a.u.c.a.d
        public float e() {
            return this.a.get(0).e();
        }

        @Override // e.a.a.u.c.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseKeyframeAnimation.java */
    /* loaded from: classes.dex */
    public static final class f<T> implements d<T> {
        private final e.a.a.a0.a<T> a;

        /* renamed from: b  reason: collision with root package name */
        private float f11702b = -1.0f;

        f(List<? extends e.a.a.a0.a<T>> list) {
            this.a = list.get(0);
        }

        @Override // e.a.a.u.c.a.d
        public boolean a(float f2) {
            if (this.f11702b == f2) {
                return true;
            }
            this.f11702b = f2;
            return false;
        }

        @Override // e.a.a.u.c.a.d
        public e.a.a.a0.a<T> b() {
            return this.a;
        }

        @Override // e.a.a.u.c.a.d
        public boolean c(float f2) {
            return !this.a.h();
        }

        @Override // e.a.a.u.c.a.d
        public float d() {
            return this.a.b();
        }

        @Override // e.a.a.u.c.a.d
        public float e() {
            return this.a.e();
        }

        @Override // e.a.a.u.c.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends e.a.a.a0.a<K>> list) {
        this.f11693c = n(list);
    }

    private float g() {
        if (this.f11697g == -1.0f) {
            this.f11697g = this.f11693c.e();
        }
        return this.f11697g;
    }

    private static <T> d<T> n(List<? extends e.a.a.a0.a<T>> list) {
        if (list.isEmpty()) {
            return new c();
        }
        if (list.size() == 1) {
            return new f(list);
        }
        return new e(list);
    }

    public void a(b bVar) {
        this.a.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e.a.a.a0.a<K> b() {
        e.a.a.c.a("BaseKeyframeAnimation#getCurrentKeyframe");
        e.a.a.a0.a<K> b2 = this.f11693c.b();
        e.a.a.c.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return b2;
    }

    float c() {
        if (this.f11698h == -1.0f) {
            this.f11698h = this.f11693c.d();
        }
        return this.f11698h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float d() {
        e.a.a.a0.a<K> b2 = b();
        if (b2.h()) {
            return 0.0f;
        }
        return b2.f11475d.getInterpolation(e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        if (this.f11692b) {
            return 0.0f;
        }
        e.a.a.a0.a<K> b2 = b();
        if (b2.h()) {
            return 0.0f;
        }
        return (this.f11694d - b2.e()) / (b2.b() - b2.e());
    }

    public float f() {
        return this.f11694d;
    }

    public A h() {
        float d2 = d();
        if (this.f11695e == null && this.f11693c.a(d2)) {
            return this.f11696f;
        }
        A i2 = i(b(), d2);
        this.f11696f = i2;
        return i2;
    }

    abstract A i(e.a.a.a0.a<K> aVar, float f2);

    public void j() {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).a();
        }
    }

    public void k() {
        this.f11692b = true;
    }

    public void l(float f2) {
        if (this.f11693c.isEmpty()) {
            return;
        }
        if (f2 < g()) {
            f2 = g();
        } else if (f2 > c()) {
            f2 = c();
        }
        if (f2 == this.f11694d) {
            return;
        }
        this.f11694d = f2;
        if (this.f11693c.c(f2)) {
            j();
        }
    }

    public void m(e.a.a.a0.c<A> cVar) {
        e.a.a.a0.c<A> cVar2 = this.f11695e;
        if (cVar2 != null) {
            cVar2.c(null);
        }
        this.f11695e = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}