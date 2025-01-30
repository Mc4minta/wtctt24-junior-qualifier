package c.h.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import c.h.i.f;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontRequestWorker.java */
/* loaded from: classes.dex */
public class e {
    static final c.e.e<String, Typeface> a = new c.e.e<>(16);

    /* renamed from: b  reason: collision with root package name */
    private static final ExecutorService f2959b = g.a("fonts-androidx", 10, 10000);

    /* renamed from: c  reason: collision with root package name */
    static final Object f2960c = new Object();

    /* renamed from: d  reason: collision with root package name */
    static final c.e.g<String, ArrayList<androidx.core.util.a<C0063e>>> f2961d = new c.e.g<>();

    /* compiled from: FontRequestWorker.java */
    /* loaded from: classes.dex */
    class a implements Callable<C0063e> {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f2962b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c.h.i.d f2963c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f2964d;

        a(String str, Context context, c.h.i.d dVar, int i2) {
            this.a = str;
            this.f2962b = context;
            this.f2963c = dVar;
            this.f2964d = i2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public C0063e call() {
            return e.c(this.a, this.f2962b, this.f2963c, this.f2964d);
        }
    }

    /* compiled from: FontRequestWorker.java */
    /* loaded from: classes.dex */
    class b implements androidx.core.util.a<C0063e> {
        final /* synthetic */ c.h.i.a a;

        b(c.h.i.a aVar) {
            this.a = aVar;
        }

        @Override // androidx.core.util.a
        /* renamed from: a */
        public void accept(C0063e c0063e) {
            this.a.b(c0063e);
        }
    }

    /* compiled from: FontRequestWorker.java */
    /* loaded from: classes.dex */
    class c implements Callable<C0063e> {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f2965b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c.h.i.d f2966c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f2967d;

        c(String str, Context context, c.h.i.d dVar, int i2) {
            this.a = str;
            this.f2965b = context;
            this.f2966c = dVar;
            this.f2967d = i2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public C0063e call() {
            return e.c(this.a, this.f2965b, this.f2966c, this.f2967d);
        }
    }

    /* compiled from: FontRequestWorker.java */
    /* loaded from: classes.dex */
    class d implements androidx.core.util.a<C0063e> {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        @Override // androidx.core.util.a
        /* renamed from: a */
        public void accept(C0063e c0063e) {
            synchronized (e.f2960c) {
                c.e.g<String, ArrayList<androidx.core.util.a<C0063e>>> gVar = e.f2961d;
                ArrayList<androidx.core.util.a<C0063e>> arrayList = gVar.get(this.a);
                if (arrayList == null) {
                    return;
                }
                gVar.remove(this.a);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    arrayList.get(i2).accept(c0063e);
                }
            }
        }
    }

    private static String a(c.h.i.d dVar, int i2) {
        return dVar.d() + "-" + i2;
    }

    @SuppressLint({"WrongConstant"})
    private static int b(f.a aVar) {
        int i2 = 1;
        if (aVar.c() != 0) {
            return aVar.c() != 1 ? -3 : -2;
        }
        f.b[] b2 = aVar.b();
        if (b2 != null && b2.length != 0) {
            i2 = 0;
            for (f.b bVar : b2) {
                int b3 = bVar.b();
                if (b3 != 0) {
                    if (b3 < 0) {
                        return -3;
                    }
                    return b3;
                }
            }
        }
        return i2;
    }

    static C0063e c(String str, Context context, c.h.i.d dVar, int i2) {
        c.e.e<String, Typeface> eVar = a;
        Typeface c2 = eVar.c(str);
        if (c2 != null) {
            return new C0063e(c2);
        }
        try {
            f.a d2 = c.h.i.c.d(context, dVar, null);
            int b2 = b(d2);
            if (b2 != 0) {
                return new C0063e(b2);
            }
            Typeface b3 = c.h.e.d.b(context, null, d2.b(), i2);
            if (b3 != null) {
                eVar.d(str, b3);
                return new C0063e(b3);
            }
            return new C0063e(-3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new C0063e(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface d(Context context, c.h.i.d dVar, int i2, Executor executor, c.h.i.a aVar) {
        String a2 = a(dVar, i2);
        Typeface c2 = a.c(a2);
        if (c2 != null) {
            aVar.b(new C0063e(c2));
            return c2;
        }
        b bVar = new b(aVar);
        synchronized (f2960c) {
            c.e.g<String, ArrayList<androidx.core.util.a<C0063e>>> gVar = f2961d;
            ArrayList<androidx.core.util.a<C0063e>> arrayList = gVar.get(a2);
            if (arrayList != null) {
                arrayList.add(bVar);
                return null;
            }
            ArrayList<androidx.core.util.a<C0063e>> arrayList2 = new ArrayList<>();
            arrayList2.add(bVar);
            gVar.put(a2, arrayList2);
            c cVar = new c(a2, context, dVar, i2);
            if (executor == null) {
                executor = f2959b;
            }
            g.b(executor, cVar, new d(a2));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface e(Context context, c.h.i.d dVar, c.h.i.a aVar, int i2, int i3) {
        String a2 = a(dVar, i2);
        Typeface c2 = a.c(a2);
        if (c2 != null) {
            aVar.b(new C0063e(c2));
            return c2;
        } else if (i3 == -1) {
            C0063e c3 = c(a2, context, dVar, i2);
            aVar.b(c3);
            return c3.a;
        } else {
            try {
                C0063e c0063e = (C0063e) g.c(f2959b, new a(a2, context, dVar, i2), i3);
                aVar.b(c0063e);
                return c0063e.a;
            } catch (InterruptedException unused) {
                aVar.b(new C0063e(-3));
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FontRequestWorker.java */
    /* renamed from: c.h.i.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0063e {
        final Typeface a;

        /* renamed from: b  reason: collision with root package name */
        final int f2968b;

        C0063e(int i2) {
            this.a = null;
            this.f2968b = i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @SuppressLint({"WrongConstant"})
        public boolean a() {
            return this.f2968b == 0;
        }

        @SuppressLint({"WrongConstant"})
        C0063e(Typeface typeface) {
            this.a = typeface;
            this.f2968b = 0;
        }
    }
}