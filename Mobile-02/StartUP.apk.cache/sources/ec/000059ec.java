package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class h extends s0<r0> {

    /* renamed from: e  reason: collision with root package name */
    public final f<?> f17435e;

    public h(r0 r0Var, f<?> fVar) {
        super(r0Var);
        this.f17435e = fVar;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
        q(th);
        return kotlin.x.a;
    }

    @Override // kotlinx.coroutines.p
    public void q(Throwable th) {
        f<?> fVar = this.f17435e;
        fVar.E(fVar.v(this.f17530d));
    }
}