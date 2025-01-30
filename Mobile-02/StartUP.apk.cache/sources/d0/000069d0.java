package retrofit2;

import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.p;

/* compiled from: KotlinExtensions.kt */
/* loaded from: classes3.dex */
public final class l {

    /* compiled from: KotlinExtensions.kt */
    /* loaded from: classes3.dex */
    static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {
        final /* synthetic */ retrofit2.d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(retrofit2.d dVar) {
            super(1);
            this.a = dVar;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
            invoke2(th);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            this.a.cancel();
        }
    }

    /* compiled from: KotlinExtensions.kt */
    /* loaded from: classes3.dex */
    static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {
        final /* synthetic */ retrofit2.d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(retrofit2.d dVar) {
            super(1);
            this.a = dVar;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
            invoke2(th);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            this.a.cancel();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: KotlinExtensions.kt */
    /* loaded from: classes3.dex */
    public static final class c<T> implements retrofit2.f<T> {
        final /* synthetic */ kotlinx.coroutines.e a;

        c(kotlinx.coroutines.e eVar) {
            this.a = eVar;
        }

        @Override // retrofit2.f
        public void onFailure(retrofit2.d<T> call, Throwable t) {
            kotlin.jvm.internal.m.h(call, "call");
            kotlin.jvm.internal.m.h(t, "t");
            kotlinx.coroutines.e eVar = this.a;
            p.a aVar = kotlin.p.a;
            eVar.b(kotlin.p.a(kotlin.q.a(t)));
        }

        @Override // retrofit2.f
        public void onResponse(retrofit2.d<T> call, s<T> response) {
            kotlin.jvm.internal.m.h(call, "call");
            kotlin.jvm.internal.m.h(response, "response");
            if (response.e()) {
                T a = response.a();
                if (a == null) {
                    Object tag = call.request().tag(k.class);
                    if (tag == null) {
                        kotlin.jvm.internal.m.q();
                    }
                    kotlin.jvm.internal.m.d(tag, "call.request().tag(Invocation::class.java)!!");
                    Method method = ((k) tag).a();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Response from ");
                    kotlin.jvm.internal.m.d(method, "method");
                    Class<?> declaringClass = method.getDeclaringClass();
                    kotlin.jvm.internal.m.d(declaringClass, "method.declaringClass");
                    sb.append(declaringClass.getName());
                    sb.append('.');
                    sb.append(method.getName());
                    sb.append(" was null but response body type was declared as non-null");
                    KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb.toString());
                    kotlinx.coroutines.e eVar = this.a;
                    p.a aVar = kotlin.p.a;
                    eVar.b(kotlin.p.a(kotlin.q.a(kotlinNullPointerException)));
                    return;
                }
                kotlinx.coroutines.e eVar2 = this.a;
                p.a aVar2 = kotlin.p.a;
                eVar2.b(kotlin.p.a(a));
                return;
            }
            kotlinx.coroutines.e eVar3 = this.a;
            HttpException httpException = new HttpException(response);
            p.a aVar3 = kotlin.p.a;
            eVar3.b(kotlin.p.a(kotlin.q.a(httpException)));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: KotlinExtensions.kt */
    /* loaded from: classes3.dex */
    public static final class d<T> implements retrofit2.f<T> {
        final /* synthetic */ kotlinx.coroutines.e a;

        d(kotlinx.coroutines.e eVar) {
            this.a = eVar;
        }

        @Override // retrofit2.f
        public void onFailure(retrofit2.d<T> call, Throwable t) {
            kotlin.jvm.internal.m.h(call, "call");
            kotlin.jvm.internal.m.h(t, "t");
            kotlinx.coroutines.e eVar = this.a;
            p.a aVar = kotlin.p.a;
            eVar.b(kotlin.p.a(kotlin.q.a(t)));
        }

        @Override // retrofit2.f
        public void onResponse(retrofit2.d<T> call, s<T> response) {
            kotlin.jvm.internal.m.h(call, "call");
            kotlin.jvm.internal.m.h(response, "response");
            if (response.e()) {
                kotlinx.coroutines.e eVar = this.a;
                T a = response.a();
                p.a aVar = kotlin.p.a;
                eVar.b(kotlin.p.a(a));
                return;
            }
            kotlinx.coroutines.e eVar2 = this.a;
            HttpException httpException = new HttpException(response);
            p.a aVar2 = kotlin.p.a;
            eVar2.b(kotlin.p.a(kotlin.q.a(httpException)));
        }
    }

    /* compiled from: KotlinExtensions.kt */
    /* loaded from: classes3.dex */
    static final class e extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {
        final /* synthetic */ retrofit2.d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(retrofit2.d dVar) {
            super(1);
            this.a = dVar;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
            invoke2(th);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            this.a.cancel();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: KotlinExtensions.kt */
    /* loaded from: classes3.dex */
    public static final class f<T> implements retrofit2.f<T> {
        final /* synthetic */ kotlinx.coroutines.e a;

        f(kotlinx.coroutines.e eVar) {
            this.a = eVar;
        }

        @Override // retrofit2.f
        public void onFailure(retrofit2.d<T> call, Throwable t) {
            kotlin.jvm.internal.m.h(call, "call");
            kotlin.jvm.internal.m.h(t, "t");
            kotlinx.coroutines.e eVar = this.a;
            p.a aVar = kotlin.p.a;
            eVar.b(kotlin.p.a(kotlin.q.a(t)));
        }

        @Override // retrofit2.f
        public void onResponse(retrofit2.d<T> call, s<T> response) {
            kotlin.jvm.internal.m.h(call, "call");
            kotlin.jvm.internal.m.h(response, "response");
            kotlinx.coroutines.e eVar = this.a;
            p.a aVar = kotlin.p.a;
            eVar.b(kotlin.p.a(response));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KotlinExtensions.kt */
    /* loaded from: classes3.dex */
    public static final class g implements Runnable {
        final /* synthetic */ kotlin.c0.d a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Exception f17914b;

        g(kotlin.c0.d dVar, Exception exc) {
            this.a = dVar;
            this.f17914b = exc;
        }

        @Override // java.lang.Runnable
        public final void run() {
            kotlin.c0.d b2;
            b2 = kotlin.c0.h.c.b(this.a);
            Exception exc = this.f17914b;
            p.a aVar = kotlin.p.a;
            b2.b(kotlin.p.a(kotlin.q.a(exc)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KotlinExtensions.kt */
    @kotlin.c0.i.a.e(c = "retrofit2.KotlinExtensions", f = "KotlinExtensions.kt", l = {113}, m = "suspendAndThrow")
    /* loaded from: classes3.dex */
    public static final class h extends kotlin.c0.i.a.c {

        /* renamed from: d  reason: collision with root package name */
        /* synthetic */ Object f17915d;

        /* renamed from: e  reason: collision with root package name */
        int f17916e;

        /* renamed from: f  reason: collision with root package name */
        Object f17917f;

        h(kotlin.c0.d dVar) {
            super(dVar);
        }

        @Override // kotlin.c0.i.a.a
        public final Object h(Object obj) {
            this.f17915d = obj;
            this.f17916e |= Integer.MIN_VALUE;
            return l.d(null, this);
        }
    }

    public static final <T> Object a(retrofit2.d<T> dVar, kotlin.c0.d<? super T> dVar2) {
        kotlin.c0.d b2;
        Object c2;
        b2 = kotlin.c0.h.c.b(dVar2);
        kotlinx.coroutines.f fVar = new kotlinx.coroutines.f(b2, 1);
        fVar.c(new a(dVar));
        dVar.d0(new c(fVar));
        Object x = fVar.x();
        c2 = kotlin.c0.h.d.c();
        if (x == c2) {
            kotlin.c0.i.a.g.c(dVar2);
        }
        return x;
    }

    public static final <T> Object b(retrofit2.d<T> dVar, kotlin.c0.d<? super T> dVar2) {
        kotlin.c0.d b2;
        Object c2;
        b2 = kotlin.c0.h.c.b(dVar2);
        kotlinx.coroutines.f fVar = new kotlinx.coroutines.f(b2, 1);
        fVar.c(new b(dVar));
        dVar.d0(new d(fVar));
        Object x = fVar.x();
        c2 = kotlin.c0.h.d.c();
        if (x == c2) {
            kotlin.c0.i.a.g.c(dVar2);
        }
        return x;
    }

    public static final <T> Object c(retrofit2.d<T> dVar, kotlin.c0.d<? super s<T>> dVar2) {
        kotlin.c0.d b2;
        Object c2;
        b2 = kotlin.c0.h.c.b(dVar2);
        kotlinx.coroutines.f fVar = new kotlinx.coroutines.f(b2, 1);
        fVar.c(new e(dVar));
        dVar.d0(new f(fVar));
        Object x = fVar.x();
        c2 = kotlin.c0.h.d.c();
        if (x == c2) {
            kotlin.c0.i.a.g.c(dVar2);
        }
        return x;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object d(java.lang.Exception r4, kotlin.c0.d<?> r5) {
        /*
            boolean r0 = r5 instanceof retrofit2.l.h
            if (r0 == 0) goto L13
            r0 = r5
            retrofit2.l$h r0 = (retrofit2.l.h) r0
            int r1 = r0.f17916e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f17916e = r1
            goto L18
        L13:
            retrofit2.l$h r0 = new retrofit2.l$h
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f17915d
            java.lang.Object r1 = kotlin.c0.h.b.c()
            int r2 = r0.f17916e
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f17917f
            java.lang.Exception r4 = (java.lang.Exception) r4
            kotlin.q.b(r5)
            goto L5c
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.q.b(r5)
            r0.f17917f = r4
            r0.f17916e = r3
            kotlinx.coroutines.t r5 = kotlinx.coroutines.c0.a()
            kotlin.c0.f r2 = r0.e()
            retrofit2.l$g r3 = new retrofit2.l$g
            r3.<init>(r0, r4)
            r5.A(r2, r3)
            java.lang.Object r4 = kotlin.c0.h.b.c()
            java.lang.Object r5 = kotlin.c0.h.b.c()
            if (r4 != r5) goto L59
            kotlin.c0.i.a.g.c(r0)
        L59:
            if (r4 != r1) goto L5c
            return r1
        L5c:
            kotlin.x r4 = kotlin.x.a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.l.d(java.lang.Exception, kotlin.c0.d):java.lang.Object");
    }
}