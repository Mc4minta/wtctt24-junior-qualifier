package kotlinx.coroutines;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CancellableContinuationImpl.kt */
/* loaded from: classes3.dex */
final class m {
    public final Object a;

    /* renamed from: b  reason: collision with root package name */
    public final c f17521b;

    /* renamed from: c  reason: collision with root package name */
    public final kotlin.e0.c.l<Throwable, kotlin.x> f17522c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f17523d;

    /* renamed from: e  reason: collision with root package name */
    public final Throwable f17524e;

    /* JADX WARN: Multi-variable type inference failed */
    public m(Object obj, c cVar, kotlin.e0.c.l<? super Throwable, kotlin.x> lVar, Object obj2, Throwable th) {
        this.a = obj;
        this.f17521b = cVar;
        this.f17522c = lVar;
        this.f17523d = obj2;
        this.f17524e = th;
    }

    public static /* synthetic */ m b(m mVar, Object obj, c cVar, kotlin.e0.c.l lVar, Object obj2, Throwable th, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            obj = mVar.a;
        }
        if ((i2 & 2) != 0) {
            cVar = mVar.f17521b;
        }
        c cVar2 = cVar;
        kotlin.e0.c.l<Throwable, kotlin.x> lVar2 = lVar;
        if ((i2 & 4) != 0) {
            lVar2 = mVar.f17522c;
        }
        kotlin.e0.c.l lVar3 = lVar2;
        if ((i2 & 8) != 0) {
            obj2 = mVar.f17523d;
        }
        Object obj4 = obj2;
        if ((i2 & 16) != 0) {
            th = mVar.f17524e;
        }
        return mVar.a(obj, cVar2, lVar3, obj4, th);
    }

    public final m a(Object obj, c cVar, kotlin.e0.c.l<? super Throwable, kotlin.x> lVar, Object obj2, Throwable th) {
        return new m(obj, cVar, lVar, obj2, th);
    }

    public final boolean c() {
        return this.f17524e != null;
    }

    public final void d(f<?> fVar, Throwable th) {
        c cVar = this.f17521b;
        if (cVar != null) {
            fVar.n(cVar, th);
        }
        kotlin.e0.c.l<Throwable, kotlin.x> lVar = this.f17522c;
        if (lVar != null) {
            fVar.o(lVar, th);
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof m) {
                m mVar = (m) obj;
                return kotlin.jvm.internal.m.c(this.a, mVar.a) && kotlin.jvm.internal.m.c(this.f17521b, mVar.f17521b) && kotlin.jvm.internal.m.c(this.f17522c, mVar.f17522c) && kotlin.jvm.internal.m.c(this.f17523d, mVar.f17523d) && kotlin.jvm.internal.m.c(this.f17524e, mVar.f17524e);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object obj = this.a;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        c cVar = this.f17521b;
        int hashCode2 = (hashCode + (cVar != null ? cVar.hashCode() : 0)) * 31;
        kotlin.e0.c.l<Throwable, kotlin.x> lVar = this.f17522c;
        int hashCode3 = (hashCode2 + (lVar != null ? lVar.hashCode() : 0)) * 31;
        Object obj2 = this.f17523d;
        int hashCode4 = (hashCode3 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Throwable th = this.f17524e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.a + ", cancelHandler=" + this.f17521b + ", onCancellation=" + this.f17522c + ", idempotentResume=" + this.f17523d + ", cancelCause=" + this.f17524e + ")";
    }

    public /* synthetic */ m(Object obj, c cVar, kotlin.e0.c.l lVar, Object obj2, Throwable th, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i2 & 2) != 0 ? null : cVar, (i2 & 4) != 0 ? null : lVar, (i2 & 8) != 0 ? null : obj2, (i2 & 16) != 0 ? null : th);
    }
}