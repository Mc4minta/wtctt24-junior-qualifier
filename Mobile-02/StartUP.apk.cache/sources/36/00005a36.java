package kotlinx.coroutines;

/* compiled from: CompletionState.kt */
/* loaded from: classes3.dex */
public final class o {
    public final Object a;

    /* renamed from: b  reason: collision with root package name */
    public final kotlin.e0.c.l<Throwable, kotlin.x> f17526b;

    /* JADX WARN: Multi-variable type inference failed */
    public o(Object obj, kotlin.e0.c.l<? super Throwable, kotlin.x> lVar) {
        this.a = obj;
        this.f17526b = lVar;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof o) {
                o oVar = (o) obj;
                return kotlin.jvm.internal.m.c(this.a, oVar.a) && kotlin.jvm.internal.m.c(this.f17526b, oVar.f17526b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object obj = this.a;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        kotlin.e0.c.l<Throwable, kotlin.x> lVar = this.f17526b;
        return hashCode + (lVar != null ? lVar.hashCode() : 0);
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.a + ", onCancellation=" + this.f17526b + ")";
    }
}