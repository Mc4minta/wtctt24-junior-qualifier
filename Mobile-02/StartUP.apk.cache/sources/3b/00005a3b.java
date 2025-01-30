package kotlinx.coroutines;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class q0 extends v0<r0> {

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.e0.c.l<Throwable, kotlin.x> f17529e;

    /* JADX WARN: Multi-variable type inference failed */
    public q0(r0 r0Var, kotlin.e0.c.l<? super Throwable, kotlin.x> lVar) {
        super(r0Var);
        this.f17529e = lVar;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
        q(th);
        return kotlin.x.a;
    }

    @Override // kotlinx.coroutines.p
    public void q(Throwable th) {
        this.f17529e.invoke(th);
    }
}