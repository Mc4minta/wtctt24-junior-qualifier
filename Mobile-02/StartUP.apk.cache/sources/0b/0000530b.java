package kotlin.reflect.jvm.internal;

import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.j0.k;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.x;

/* compiled from: KProperty2Impl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00042\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005:\u0001\u001eB\u0019\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019B!\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u001a¢\u0006\u0004\b\u0018\u0010\u001dJ'\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR(\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\f8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eRH\u0010\u0012\u001a4\u00120\u0012.\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002 \u0011*\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\f0\f0\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lkotlin/reflect/jvm/internal/KMutableProperty2Impl;", "D", "E", "V", "Lkotlin/reflect/jvm/internal/KProperty2Impl;", "Lkotlin/j0/k;", "receiver1", "receiver2", "value", "Lkotlin/x;", "set", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "Lkotlin/reflect/jvm/internal/KMutableProperty2Impl$Setter;", "getSetter", "()Lkotlin/reflect/jvm/internal/KMutableProperty2Impl$Setter;", "setter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "kotlin.jvm.PlatformType", "_setter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "", ApiConstants.NAME, "signature", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;)V", "Setter", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KMutableProperty2Impl<D, E, V> extends KProperty2Impl<D, E, V> implements k<D, E, V> {
    private final ReflectProperties.LazyVal<Setter<D, E, V>> _setter;

    /* compiled from: KProperty2Impl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0003\u0010\u0001*\u0004\b\u0004\u0010\u0002*\u0004\b\u0005\u0010\u00032\b\u0012\u0004\u0012\u00028\u00050\u00042\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0005B!\u0012\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\f¢\u0006\u0004\b\u0011\u0010\u0012J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00028\u00032\u0006\u0010\u0007\u001a\u00028\u00042\u0006\u0010\b\u001a\u00028\u0005H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bR.\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lkotlin/reflect/jvm/internal/KMutableProperty2Impl$Setter;", "D", "E", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "Lkotlin/j0/k$a;", "receiver1", "receiver2", "value", "Lkotlin/x;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "Lkotlin/reflect/jvm/internal/KMutableProperty2Impl;", "property", "Lkotlin/reflect/jvm/internal/KMutableProperty2Impl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KMutableProperty2Impl;", "<init>", "(Lkotlin/reflect/jvm/internal/KMutableProperty2Impl;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public static final class Setter<D, E, V> extends KPropertyImpl.Setter<V> implements k.a<D, E, V> {
        private final KMutableProperty2Impl<D, E, V> property;

        public Setter(KMutableProperty2Impl<D, E, V> property) {
            m.g(property, "property");
            this.property = property;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.e0.c.q
        public /* bridge */ /* synthetic */ x invoke(Object obj, Object obj2, Object obj3) {
            invoke2((Setter<D, E, V>) obj, obj2, obj3);
            return x.a;
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Setter, kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.j0.m.a
        public KMutableProperty2Impl<D, E, V> getProperty() {
            return this.property;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public void invoke2(D d2, E e2, V v) {
            getProperty().set(d2, e2, v);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty2Impl(KDeclarationContainerImpl container, String name, String signature) {
        super(container, name, signature);
        m.g(container, "container");
        m.g(name, "name");
        m.g(signature, "signature");
        ReflectProperties.LazyVal<Setter<D, E, V>> lazy = ReflectProperties.lazy(new KMutableProperty2Impl$_setter$1(this));
        m.f(lazy, "ReflectProperties.lazy { Setter(this) }");
        this._setter = lazy;
    }

    public void set(D d2, E e2, V v) {
        getSetter().call(d2, e2, v);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty2Impl(KDeclarationContainerImpl container, PropertyDescriptor descriptor) {
        super(container, descriptor);
        m.g(container, "container");
        m.g(descriptor, "descriptor");
        ReflectProperties.LazyVal<Setter<D, E, V>> lazy = ReflectProperties.lazy(new KMutableProperty2Impl$_setter$1(this));
        m.f(lazy, "ReflectProperties.lazy { Setter(this) }");
        this._setter = lazy;
    }

    @Override // kotlin.j0.h
    public Setter<D, E, V> getSetter() {
        Setter<D, E, V> invoke = this._setter.invoke();
        m.f(invoke, "_setter()");
        return invoke;
    }
}