package kotlinx.coroutines;

/* compiled from: CancellableContinuationImpl.kt */
/* loaded from: classes3.dex */
final class o0 extends c {
    private final kotlin.e0.c.l<Throwable, kotlin.x> a;

    /* JADX WARN: Multi-variable type inference failed */
    public o0(kotlin.e0.c.l<? super Throwable, kotlin.x> lVar) {
        this.a = lVar;
    }

    @Override // kotlinx.coroutines.d
    public void a(Throwable th) {
        this.a.invoke(th);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
        a(th);
        return kotlin.x.a;
    }

    public String toString() {
        return "InvokeOnCancel[" + y.a(this.a) + '@' + y.b(this) + ']';
    }
}