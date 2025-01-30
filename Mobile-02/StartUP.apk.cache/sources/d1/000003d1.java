package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.h;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* compiled from: AsyncListDiffer.java */
/* loaded from: classes.dex */
public class d<T> {
    private static final Executor a = new c();

    /* renamed from: b  reason: collision with root package name */
    private final n f2098b;

    /* renamed from: c  reason: collision with root package name */
    final androidx.recyclerview.widget.c<T> f2099c;

    /* renamed from: d  reason: collision with root package name */
    Executor f2100d;

    /* renamed from: f  reason: collision with root package name */
    private List<T> f2102f;

    /* renamed from: h  reason: collision with root package name */
    int f2104h;

    /* renamed from: e  reason: collision with root package name */
    private final List<b<T>> f2101e = new CopyOnWriteArrayList();

    /* renamed from: g  reason: collision with root package name */
    private List<T> f2103g = Collections.emptyList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AsyncListDiffer.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f2105b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2106c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Runnable f2107d;

        /* compiled from: AsyncListDiffer.java */
        /* renamed from: androidx.recyclerview.widget.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0039a extends h.b {
            C0039a() {
            }

            @Override // androidx.recyclerview.widget.h.b
            public boolean a(int i2, int i3) {
                Object obj = a.this.a.get(i2);
                Object obj2 = a.this.f2105b.get(i3);
                if (obj == null || obj2 == null) {
                    if (obj == null && obj2 == null) {
                        return true;
                    }
                    throw new AssertionError();
                }
                return d.this.f2099c.b().areContentsTheSame(obj, obj2);
            }

            @Override // androidx.recyclerview.widget.h.b
            public boolean b(int i2, int i3) {
                Object obj = a.this.a.get(i2);
                Object obj2 = a.this.f2105b.get(i3);
                if (obj == null || obj2 == null) {
                    return obj == null && obj2 == null;
                }
                return d.this.f2099c.b().areItemsTheSame(obj, obj2);
            }

            @Override // androidx.recyclerview.widget.h.b
            public Object c(int i2, int i3) {
                Object obj = a.this.a.get(i2);
                Object obj2 = a.this.f2105b.get(i3);
                if (obj != null && obj2 != null) {
                    return d.this.f2099c.b().getChangePayload(obj, obj2);
                }
                throw new AssertionError();
            }

            @Override // androidx.recyclerview.widget.h.b
            public int d() {
                return a.this.f2105b.size();
            }

            @Override // androidx.recyclerview.widget.h.b
            public int e() {
                return a.this.a.size();
            }
        }

        /* compiled from: AsyncListDiffer.java */
        /* loaded from: classes.dex */
        class b implements Runnable {
            final /* synthetic */ h.c a;

            b(h.c cVar) {
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                d dVar = d.this;
                if (dVar.f2104h == aVar.f2106c) {
                    dVar.c(aVar.f2105b, this.a, aVar.f2107d);
                }
            }
        }

        a(List list, List list2, int i2, Runnable runnable) {
            this.a = list;
            this.f2105b = list2;
            this.f2106c = i2;
            this.f2107d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f2100d.execute(new b(h.a(new C0039a())));
        }
    }

    /* compiled from: AsyncListDiffer.java */
    /* loaded from: classes.dex */
    public interface b<T> {
        void a(List<T> list, List<T> list2);
    }

    /* compiled from: AsyncListDiffer.java */
    /* loaded from: classes.dex */
    private static class c implements Executor {
        final Handler a = new Handler(Looper.getMainLooper());

        c() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.a.post(runnable);
        }
    }

    public d(n nVar, androidx.recyclerview.widget.c<T> cVar) {
        this.f2098b = nVar;
        this.f2099c = cVar;
        if (cVar.c() != null) {
            this.f2100d = cVar.c();
        } else {
            this.f2100d = a;
        }
    }

    private void d(List<T> list, Runnable runnable) {
        for (b<T> bVar : this.f2101e) {
            bVar.a(list, this.f2103g);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void a(b<T> bVar) {
        this.f2101e.add(bVar);
    }

    public List<T> b() {
        return this.f2103g;
    }

    void c(List<T> list, h.c cVar, Runnable runnable) {
        List<T> list2 = this.f2103g;
        this.f2102f = list;
        this.f2103g = Collections.unmodifiableList(list);
        cVar.d(this.f2098b);
        d(list2, runnable);
    }

    public void e(List<T> list) {
        f(list, null);
    }

    public void f(List<T> list, Runnable runnable) {
        int i2 = this.f2104h + 1;
        this.f2104h = i2;
        List<T> list2 = this.f2102f;
        if (list == list2) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        List<T> list3 = this.f2103g;
        if (list == null) {
            int size = list2.size();
            this.f2102f = null;
            this.f2103g = Collections.emptyList();
            this.f2098b.c(0, size);
            d(list3, runnable);
        } else if (list2 == null) {
            this.f2102f = list;
            this.f2103g = Collections.unmodifiableList(list);
            this.f2098b.b(0, list.size());
            d(list3, runnable);
        } else {
            this.f2099c.a().execute(new a(list2, list, i2, runnable));
        }
    }
}