package kotlin.reflect.jvm.internal.impl.types;

import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: SpecialTypes.kt */
/* loaded from: classes3.dex */
public final class LazyWrappedType extends WrappedType {
    private final a<KotlinType> computation;
    private final NotNullLazyValue<KotlinType> lazyValue;
    private final StorageManager storageManager;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyWrappedType(StorageManager storageManager, a<? extends KotlinType> computation) {
        m.g(storageManager, "storageManager");
        m.g(computation, "computation");
        this.storageManager = storageManager;
        this.computation = computation;
        this.lazyValue = storageManager.createLazyValue(computation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.WrappedType
    protected KotlinType getDelegate() {
        return (KotlinType) this.lazyValue.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.WrappedType
    public boolean isComputed() {
        return this.lazyValue.isComputed();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public LazyWrappedType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        m.g(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new LazyWrappedType(this.storageManager, new LazyWrappedType$refine$1(kotlinTypeRefiner, this));
    }
}