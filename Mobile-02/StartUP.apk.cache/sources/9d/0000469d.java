package e.f.j.l;

import java.util.Map;

/* compiled from: StatefulProducerRunnable.java */
/* loaded from: classes2.dex */
public abstract class q0<T> extends e.f.d.b.d<T> {

    /* renamed from: b  reason: collision with root package name */
    private final k<T> f12721b;

    /* renamed from: c  reason: collision with root package name */
    private final m0 f12722c;

    /* renamed from: d  reason: collision with root package name */
    private final String f12723d;

    /* renamed from: e  reason: collision with root package name */
    private final String f12724e;

    public q0(k<T> kVar, m0 m0Var, String str, String str2) {
        this.f12721b = kVar;
        this.f12722c = m0Var;
        this.f12723d = str;
        this.f12724e = str2;
        m0Var.b(str2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.f.d.b.d
    public void d() {
        m0 m0Var = this.f12722c;
        String str = this.f12724e;
        m0Var.d(str, this.f12723d, m0Var.f(str) ? g() : null);
        this.f12721b.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.f.d.b.d
    public void e(Exception exc) {
        m0 m0Var = this.f12722c;
        String str = this.f12724e;
        m0Var.j(str, this.f12723d, exc, m0Var.f(str) ? h(exc) : null);
        this.f12721b.onFailure(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.f.d.b.d
    public void f(T t) {
        m0 m0Var = this.f12722c;
        String str = this.f12724e;
        m0Var.i(str, this.f12723d, m0Var.f(str) ? i(t) : null);
        this.f12721b.c(t, 1);
    }

    protected Map<String, String> g() {
        return null;
    }

    protected Map<String, String> h(Exception exc) {
        return null;
    }

    protected Map<String, String> i(T t) {
        return null;
    }
}