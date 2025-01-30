package kotlin.reflect.jvm.internal;

import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.j0.i;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.x;

/* compiled from: KProperty0Impl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u001cB\u0019\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015B+\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0014\u0010\u001bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R0\u0010\u000b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \n*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\t0\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\t8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "V", "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "Lkotlin/j0/i;", "value", "Lkotlin/x;", "set", "(Ljava/lang/Object;)V", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "kotlin.jvm.PlatformType", "_setter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getSetter", "()Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "setter", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "", ApiConstants.NAME, "signature", "", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "Setter", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KMutableProperty0Impl<V> extends KProperty0Impl<V> implements i<V> {
    private final ReflectProperties.LazyVal<Setter<V>> _setter;

    /* compiled from: KProperty0Impl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "Lkotlin/j0/i$a;", "value", "Lkotlin/x;", "invoke", "(Ljava/lang/Object;)V", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "property", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "<init>", "(Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public static final class Setter<R> extends KPropertyImpl.Setter<R> implements i.a<R> {
        private final KMutableProperty0Impl<R> property;

        public Setter(KMutableProperty0Impl<R> property) {
            m.g(property, "property");
            this.property = property;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(Object obj) {
            invoke2((Setter<R>) obj);
            return x.a;
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Setter, kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.j0.m.a
        public KMutableProperty0Impl<R> getProperty() {
            return this.property;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public void invoke2(R r) {
            getProperty().set(r);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty0Impl(KDeclarationContainerImpl container, PropertyDescriptor descriptor) {
        super(container, descriptor);
        m.g(container, "container");
        m.g(descriptor, "descriptor");
        ReflectProperties.LazyVal<Setter<V>> lazy = ReflectProperties.lazy(new KMutableProperty0Impl$_setter$1(this));
        m.f(lazy, "ReflectProperties.lazy { Setter(this) }");
        this._setter = lazy;
    }

    public void set(V v) {
        getSetter().call(v);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty0Impl(KDeclarationContainerImpl container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        m.g(container, "container");
        m.g(name, "name");
        m.g(signature, "signature");
        ReflectProperties.LazyVal<Setter<V>> lazy = ReflectProperties.lazy(new KMutableProperty0Impl$_setter$1(this));
        m.f(lazy, "ReflectProperties.lazy { Setter(this) }");
        this._setter = lazy;
    }

    @Override // kotlin.j0.i, kotlin.j0.h
    public Setter<V> getSetter() {
        Setter<V> invoke = this._setter.invoke();
        m.f(invoke, "_setter()");
        return invoke;
    }
}