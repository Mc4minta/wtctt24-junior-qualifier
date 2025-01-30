package androidx.lifecycle;

import androidx.lifecycle.b0;
import androidx.lifecycle.d0;

/* compiled from: ViewModelProvider.kt */
/* loaded from: classes.dex */
public final class c0<VM extends b0> implements kotlin.h<VM> {
    private VM a;

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.j0.d<VM> f1780b;

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.e0.c.a<f0> f1781c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.e0.c.a<d0.b> f1782d;

    /* JADX WARN: Multi-variable type inference failed */
    public c0(kotlin.j0.d<VM> viewModelClass, kotlin.e0.c.a<? extends f0> storeProducer, kotlin.e0.c.a<? extends d0.b> factoryProducer) {
        kotlin.jvm.internal.m.h(viewModelClass, "viewModelClass");
        kotlin.jvm.internal.m.h(storeProducer, "storeProducer");
        kotlin.jvm.internal.m.h(factoryProducer, "factoryProducer");
        this.f1780b = viewModelClass;
        this.f1781c = storeProducer;
        this.f1782d = factoryProducer;
    }

    @Override // kotlin.h
    /* renamed from: a */
    public VM getValue() {
        VM vm = this.a;
        if (vm == null) {
            VM vm2 = (VM) new d0(this.f1781c.invoke(), this.f1782d.invoke()).a(kotlin.e0.a.b(this.f1780b));
            this.a = vm2;
            kotlin.jvm.internal.m.d(vm2, "ViewModelProvider(store,…ed = it\n                }");
            return vm2;
        }
        return vm;
    }
}