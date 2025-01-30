package c.o.a;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.f0;
import androidx.lifecycle.o;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import c.e.h;
import c.o.a.a;
import c.o.b.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoaderManagerImpl.java */
/* loaded from: classes.dex */
public class b extends c.o.a.a {
    static boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final o f3153b;

    /* renamed from: c  reason: collision with root package name */
    private final c f3154c;

    /* compiled from: LoaderManagerImpl.java */
    /* loaded from: classes.dex */
    public static class a<D> extends u<D> implements b.InterfaceC0080b<D> {

        /* renamed from: k  reason: collision with root package name */
        private final int f3155k;

        /* renamed from: l  reason: collision with root package name */
        private final Bundle f3156l;
        private final c.o.b.b<D> m;
        private o n;
        private C0078b<D> o;
        private c.o.b.b<D> p;

        a(int i2, Bundle bundle, c.o.b.b<D> bVar, c.o.b.b<D> bVar2) {
            this.f3155k = i2;
            this.f3156l = bundle;
            this.m = bVar;
            this.p = bVar2;
            bVar.q(i2, this);
        }

        @Override // c.o.b.b.InterfaceC0080b
        public void a(c.o.b.b<D> bVar, D d2) {
            if (b.a) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                l(d2);
                return;
            }
            if (b.a) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            j(d2);
        }

        @Override // androidx.lifecycle.LiveData
        protected void h() {
            if (b.a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.m.t();
        }

        @Override // androidx.lifecycle.LiveData
        protected void i() {
            if (b.a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.m.u();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void k(v<? super D> vVar) {
            super.k(vVar);
            this.n = null;
            this.o = null;
        }

        @Override // androidx.lifecycle.u, androidx.lifecycle.LiveData
        public void l(D d2) {
            super.l(d2);
            c.o.b.b<D> bVar = this.p;
            if (bVar != null) {
                bVar.r();
                this.p = null;
            }
        }

        c.o.b.b<D> m(boolean z) {
            if (b.a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.m.b();
            this.m.a();
            C0078b<D> c0078b = this.o;
            if (c0078b != null) {
                k(c0078b);
                if (z) {
                    c0078b.d();
                }
            }
            this.m.v(this);
            if ((c0078b != null && !c0078b.c()) || z) {
                this.m.r();
                return this.p;
            }
            return this.m;
        }

        public void n(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f3155k);
            printWriter.print(" mArgs=");
            printWriter.println(this.f3156l);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.m);
            c.o.b.b<D> bVar = this.m;
            bVar.g(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.o != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.o);
                C0078b<D> c0078b = this.o;
                c0078b.b(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(o().d(e()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(f());
        }

        c.o.b.b<D> o() {
            return this.m;
        }

        void p() {
            o oVar = this.n;
            C0078b<D> c0078b = this.o;
            if (oVar == null || c0078b == null) {
                return;
            }
            super.k(c0078b);
            g(oVar, c0078b);
        }

        c.o.b.b<D> q(o oVar, a.InterfaceC0077a<D> interfaceC0077a) {
            C0078b<D> c0078b = new C0078b<>(this.m, interfaceC0077a);
            g(oVar, c0078b);
            C0078b<D> c0078b2 = this.o;
            if (c0078b2 != null) {
                k(c0078b2);
            }
            this.n = oVar;
            this.o = c0078b;
            return this.m;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f3155k);
            sb.append(" : ");
            androidx.core.util.b.a(this.m, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: c.o.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0078b<D> implements v<D> {
        private final c.o.b.b<D> a;

        /* renamed from: b  reason: collision with root package name */
        private final a.InterfaceC0077a<D> f3157b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3158c = false;

        C0078b(c.o.b.b<D> bVar, a.InterfaceC0077a<D> interfaceC0077a) {
            this.a = bVar;
            this.f3157b = interfaceC0077a;
        }

        @Override // androidx.lifecycle.v
        public void a(D d2) {
            if (b.a) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.a + ": " + this.a.d(d2));
            }
            this.f3157b.a(this.a, d2);
            this.f3158c = true;
        }

        public void b(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f3158c);
        }

        boolean c() {
            return this.f3158c;
        }

        void d() {
            if (this.f3158c) {
                if (b.a) {
                    Log.v("LoaderManager", "  Resetting: " + this.a);
                }
                this.f3157b.c(this.a);
            }
        }

        public String toString() {
            return this.f3157b.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoaderManagerImpl.java */
    /* loaded from: classes.dex */
    public static class c extends b0 {
        private static final d0.b a = new a();

        /* renamed from: b  reason: collision with root package name */
        private h<a> f3159b = new h<>();

        /* renamed from: c  reason: collision with root package name */
        private boolean f3160c = false;

        /* compiled from: LoaderManagerImpl.java */
        /* loaded from: classes.dex */
        static class a implements d0.b {
            a() {
            }

            @Override // androidx.lifecycle.d0.b
            public <T extends b0> T create(Class<T> cls) {
                return new c();
            }
        }

        c() {
        }

        static c c(f0 f0Var) {
            return (c) new d0(f0Var, a).a(c.class);
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f3159b.p() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i2 = 0; i2 < this.f3159b.p(); i2++) {
                    a q = this.f3159b.q(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f3159b.k(i2));
                    printWriter.print(": ");
                    printWriter.println(q.toString());
                    q.n(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void b() {
            this.f3160c = false;
        }

        <D> a<D> d(int i2) {
            return this.f3159b.f(i2);
        }

        boolean e() {
            return this.f3160c;
        }

        void f() {
            int p = this.f3159b.p();
            for (int i2 = 0; i2 < p; i2++) {
                this.f3159b.q(i2).p();
            }
        }

        void g(int i2, a aVar) {
            this.f3159b.l(i2, aVar);
        }

        void h() {
            this.f3160c = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.b0
        public void onCleared() {
            super.onCleared();
            int p = this.f3159b.p();
            for (int i2 = 0; i2 < p; i2++) {
                this.f3159b.q(i2).m(true);
            }
            this.f3159b.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(o oVar, f0 f0Var) {
        this.f3153b = oVar;
        this.f3154c = c.c(f0Var);
    }

    private <D> c.o.b.b<D> e(int i2, Bundle bundle, a.InterfaceC0077a<D> interfaceC0077a, c.o.b.b<D> bVar) {
        try {
            this.f3154c.h();
            c.o.b.b<D> b2 = interfaceC0077a.b(i2, bundle);
            if (b2 != null) {
                if (b2.getClass().isMemberClass() && !Modifier.isStatic(b2.getClass().getModifiers())) {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + b2);
                }
                a aVar = new a(i2, bundle, b2, bVar);
                if (a) {
                    Log.v("LoaderManager", "  Created new loader " + aVar);
                }
                this.f3154c.g(i2, aVar);
                this.f3154c.b();
                return aVar.q(this.f3153b, interfaceC0077a);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th) {
            this.f3154c.b();
            throw th;
        }
    }

    @Override // c.o.a.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f3154c.a(str, fileDescriptor, printWriter, strArr);
    }

    @Override // c.o.a.a
    public <D> c.o.b.b<D> c(int i2, Bundle bundle, a.InterfaceC0077a<D> interfaceC0077a) {
        if (!this.f3154c.e()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                a<D> d2 = this.f3154c.d(i2);
                if (a) {
                    Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
                }
                if (d2 == null) {
                    return e(i2, bundle, interfaceC0077a, null);
                }
                if (a) {
                    Log.v("LoaderManager", "  Re-using existing loader " + d2);
                }
                return d2.q(this.f3153b, interfaceC0077a);
            }
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // c.o.a.a
    public void d() {
        this.f3154c.f();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        androidx.core.util.b.a(this.f3153b, sb);
        sb.append("}}");
        return sb.toString();
    }
}