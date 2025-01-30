package kotlin.reflect.jvm.internal;

import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.j0.j;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.x;

/* compiled from: KProperty1Impl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0001\u001eB\u0019\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017B+\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0016\u0010\u001dJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\b\u0010\tR\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR<\u0010\u0010\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u000f*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\n0\n0\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "T", "V", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "Lkotlin/j0/j;", "receiver", "value", "Lkotlin/x;", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "getSetter", "()Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "setter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "kotlin.jvm.PlatformType", "_setter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "", ApiConstants.NAME, "signature", "", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "Setter", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KMutableProperty1Impl<T, V> extends KProperty1Impl<T, V> implements j<T, V> {
    private final ReflectProperties.LazyVal<Setter<T, V>> _setter;

    /* compiled from: KProperty1Impl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\b\u0012\u0004\u0012\u00028\u00030\u00032\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004B\u001b\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00028\u00022\u0006\u0010\u0006\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR(\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "T", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "Lkotlin/j0/j$a;", "receiver", "value", "Lkotlin/x;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "property", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "<init>", "(Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public static final class Setter<T, V> extends KPropertyImpl.Setter<V> implements j.a<T, V> {
        private final KMutableProperty1Impl<T, V> property;

        public Setter(KMutableProperty1Impl<T, V> property) {
            m.g(property, "property");
            this.property = property;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.e0.c.p
        public /* bridge */ /* synthetic */ x invoke(Object obj, Object obj2) {
            invoke2((Setter<T, V>) obj, obj2);
            return x.a;
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Setter, kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.j0.m.a
        public KMutableProperty1Impl<T, V> getProperty() {
            return this.property;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public void invoke2(T t, V v) {
            getProperty().set(t, v);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty1Impl(KDeclarationContainerImpl container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        m.g(container, "container");
        m.g(name, "name");
        m.g(signature, "signature");
        ReflectProperties.LazyVal<Setter<T, V>> lazy = ReflectProperties.lazy(new KMutableProperty1Impl$_setter$1(this));
        m.f(lazy, "ReflectProperties.lazy { Setter(this) }");
        this._setter = lazy;
    }

    @Override // kotlin.j0.j
    public void set(T t, V v) {
        getSetter().call(t, v);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty1Impl(KDeclarationContainerImpl container, PropertyDescriptor descriptor) {
        super(container, descriptor);
        m.g(container, "container");
        m.g(descriptor, "descriptor");
        ReflectProperties.LazyVal<Setter<T, V>> lazy = ReflectProperties.lazy(new KMutableProperty1Impl$_setter$1(this));
        m.f(lazy, "ReflectProperties.lazy { Setter(this) }");
        this._setter = lazy;
    }

    @Override // kotlin.j0.j, kotlin.j0.h
    public Setter<T, V> getSetter() {
        Setter<T, V> invoke = this._setter.invoke();
        m.f(invoke, "_setter()");
        return invoke;
    }
}