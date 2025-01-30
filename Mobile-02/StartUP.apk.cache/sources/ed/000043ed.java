package com.uber.autodispose;

import h.c.b0;

/* compiled from: AutoDispose.java */
/* loaded from: classes2.dex */
public final class d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: AutoDispose.java */
    /* loaded from: classes2.dex */
    public class a<T> implements g<T> {
        final /* synthetic */ h.c.f a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AutoDispose.java */
        /* renamed from: com.uber.autodispose.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0249a implements s {
            final /* synthetic */ h.c.c a;

            C0249a(h.c.c cVar) {
                this.a = cVar;
            }

            @Override // com.uber.autodispose.s
            public h.c.k0.b b(h.c.m0.a aVar, h.c.m0.f<? super Throwable> fVar) {
                return new f(this.a, a.this.a).b(aVar, fVar);
            }

            @Override // com.uber.autodispose.s
            public h.c.k0.b d(h.c.m0.a aVar) {
                return new f(this.a, a.this.a).d(aVar);
            }

            @Override // com.uber.autodispose.s
            public h.c.k0.b subscribe() {
                return new f(this.a, a.this.a).subscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AutoDispose.java */
        /* loaded from: classes2.dex */
        public class b implements u<T> {
            final /* synthetic */ h.c.h a;

            b(h.c.h hVar) {
                this.a = hVar;
            }

            @Override // com.uber.autodispose.u
            public h.c.k0.b subscribe(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar) {
                return new i(this.a, a.this.a).subscribe(fVar, fVar2, aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AutoDispose.java */
        /* loaded from: classes2.dex */
        public class c implements x<T> {
            final /* synthetic */ h.c.s a;

            c(h.c.s sVar) {
                this.a = sVar;
            }

            @Override // com.uber.autodispose.x
            public h.c.k0.b subscribe() {
                return new j(this.a, a.this.a).subscribe();
            }

            @Override // com.uber.autodispose.x
            public h.c.k0.b subscribe(h.c.m0.f<? super T> fVar) {
                return new j(this.a, a.this.a).subscribe(fVar);
            }

            @Override // com.uber.autodispose.x
            public h.c.k0.b subscribe(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2) {
                return new j(this.a, a.this.a).subscribe(fVar, fVar2);
            }

            @Override // com.uber.autodispose.x
            public h.c.k0.b subscribe(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar) {
                return new j(this.a, a.this.a).subscribe(fVar, fVar2, aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AutoDispose.java */
        /* renamed from: com.uber.autodispose.d$a$d  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0250d implements a0<T> {
            final /* synthetic */ b0 a;

            C0250d(b0 b0Var) {
                this.a = b0Var;
            }

            @Override // com.uber.autodispose.a0
            public h.c.k0.b subscribe() {
                return new l(this.a, a.this.a).subscribe();
            }

            @Override // com.uber.autodispose.a0
            public h.c.k0.b subscribe(h.c.m0.f<? super T> fVar) {
                return new l(this.a, a.this.a).subscribe(fVar);
            }

            @Override // com.uber.autodispose.a0
            public h.c.k0.b subscribe(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2) {
                return new l(this.a, a.this.a).subscribe(fVar, fVar2);
            }
        }

        a(h.c.f fVar) {
            this.a = fVar;
        }

        @Override // h.c.d
        /* renamed from: c */
        public s b(h.c.c cVar) {
            if (!k.f11434c) {
                return new f(cVar, this.a);
            }
            return new C0249a(cVar);
        }

        @Override // h.c.i
        /* renamed from: d */
        public u<T> apply(h.c.h<T> hVar) {
            if (!k.f11434c) {
                return new i(hVar, this.a);
            }
            return new b(hVar);
        }

        @Override // h.c.t
        /* renamed from: e */
        public x<T> apply(h.c.s<T> sVar) {
            if (!k.f11434c) {
                return new j(sVar, this.a);
            }
            return new c(sVar);
        }

        @Override // h.c.c0
        /* renamed from: f */
        public a0<T> a(b0<T> b0Var) {
            if (!k.f11434c) {
                return new l(b0Var, this.a);
            }
            return new C0250d(b0Var);
        }
    }

    public static <T> g<T> a(y yVar) {
        m.a(yVar, "provider == null");
        return b(z.a(yVar));
    }

    public static <T> g<T> b(h.c.f fVar) {
        m.a(fVar, "scope == null");
        return new a(fVar);
    }
}