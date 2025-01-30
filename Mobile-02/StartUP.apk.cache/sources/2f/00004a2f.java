package e.j.l;

import androidx.lifecycle.o;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.m;

/* compiled from: SingleLiveEvent.kt */
/* loaded from: classes2.dex */
public final class k<T> extends u<T> {

    /* renamed from: k */
    private final AtomicBoolean f13709k = new AtomicBoolean(false);

    public static /* synthetic */ void m(k kVar, v vVar, Object obj) {
        n(kVar, vVar, obj);
    }

    public static final void n(k this$0, v observer, Object obj) {
        m.g(this$0, "this$0");
        m.g(observer, "$observer");
        if (this$0.f13709k.compareAndSet(true, false)) {
            observer.a(obj);
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void g(o owner, final v<? super T> observer) {
        m.g(owner, "owner");
        m.g(observer, "observer");
        if (f()) {
            l.a.a.i("Multiple observers registered but only one will be notified of changes.", new Object[0]);
        }
        super.g(owner, new v() { // from class: e.j.l.e
            @Override // androidx.lifecycle.v
            public final void a(Object obj) {
                k.m(k.this, observer, obj);
            }
        });
    }

    @Override // androidx.lifecycle.u, androidx.lifecycle.LiveData
    public void l(T t) {
        this.f13709k.set(true);
        super.l(t);
    }
}