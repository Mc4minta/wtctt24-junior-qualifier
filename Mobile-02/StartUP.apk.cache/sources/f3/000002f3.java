package androidx.fragment.app;

import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import androidx.lifecycle.f0;

/* compiled from: FragmentViewModelLazy.kt */
/* loaded from: classes.dex */
public final class z {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentViewModelLazy.kt */
    /* loaded from: classes.dex */
    public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.a<d0.b> {
        final /* synthetic */ Fragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Fragment fragment) {
            super(0);
            this.a = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.e0.c.a
        public final d0.b invoke() {
            d0.b defaultViewModelProviderFactory = this.a.getDefaultViewModelProviderFactory();
            kotlin.jvm.internal.m.d(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    public static final <VM extends b0> kotlin.h<VM> a(Fragment createViewModelLazy, kotlin.j0.d<VM> viewModelClass, kotlin.e0.c.a<? extends f0> storeProducer, kotlin.e0.c.a<? extends d0.b> aVar) {
        kotlin.jvm.internal.m.h(createViewModelLazy, "$this$createViewModelLazy");
        kotlin.jvm.internal.m.h(viewModelClass, "viewModelClass");
        kotlin.jvm.internal.m.h(storeProducer, "storeProducer");
        if (aVar == null) {
            aVar = new a(createViewModelLazy);
        }
        return new c0(viewModelClass, storeProducer, aVar);
    }
}