package kotlin.reflect.jvm.internal;

import com.coinbase.ApiConstants;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.h;
import kotlin.j0.o;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* compiled from: KProperty1Impl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004:\u0001\"B\u0019\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cB+\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\b\u0010 \u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001b\u0010!J\u0017\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0018\u0010\n\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\n\u0010\u0007R\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR<\u0010\u0011\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0010*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b0\u000b0\u000f8\b@\bX\u0088\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty1Impl;", "T", "V", "Lkotlin/j0/o;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "receiver", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "getDelegate", "invoke", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "kotlin.jvm.PlatformType", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/h;", "Ljava/lang/reflect/Field;", "delegateField", "Lkotlin/h;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "", ApiConstants.NAME, "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "Getter", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public class KProperty1Impl<T, V> extends KPropertyImpl<V> implements o<T, V> {
    private final ReflectProperties.LazyVal<Getter<T, V>> _getter;
    private final h<Field> delegateField;

    /* compiled from: KProperty1Impl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0006\b\u0003\u0010\u0002 \u00012\b\u0012\u0004\u0012\u00028\u00030\u00032\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004B\u001b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0006\u001a\u00028\u00032\u0006\u0010\u0005\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R(\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "T", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/j0/o$a;", "receiver", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "property", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty1Impl;", "<init>", "(Lkotlin/reflect/jvm/internal/KProperty1Impl;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public static final class Getter<T, V> extends KPropertyImpl.Getter<V> implements o.a<T, V> {
        private final KProperty1Impl<T, V> property;

        /* JADX WARN: Multi-variable type inference failed */
        public Getter(KProperty1Impl<T, ? extends V> property) {
            m.g(property, "property");
            this.property = property;
        }

        @Override // kotlin.e0.c.l
        public V invoke(T t) {
            return getProperty().get(t);
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Getter, kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.j0.m.a
        public KProperty1Impl<T, V> getProperty() {
            return this.property;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty1Impl(KDeclarationContainerImpl container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        h<Field> a;
        m.g(container, "container");
        m.g(name, "name");
        m.g(signature, "signature");
        ReflectProperties.LazyVal<Getter<T, V>> lazy = ReflectProperties.lazy(new KProperty1Impl$_getter$1(this));
        m.f(lazy, "ReflectProperties.lazy { Getter(this) }");
        this._getter = lazy;
        a = k.a(kotlin.m.PUBLICATION, new KProperty1Impl$delegateField$1(this));
        this.delegateField = a;
    }

    @Override // kotlin.j0.o
    public V get(T t) {
        return getGetter().call(t);
    }

    @Override // kotlin.j0.o
    public Object getDelegate(T t) {
        return getDelegate(this.delegateField.getValue(), t);
    }

    @Override // kotlin.e0.c.l
    public V invoke(T t) {
        return get(t);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty1Impl(KDeclarationContainerImpl container, PropertyDescriptor descriptor) {
        super(container, descriptor);
        h<Field> a;
        m.g(container, "container");
        m.g(descriptor, "descriptor");
        ReflectProperties.LazyVal<Getter<T, V>> lazy = ReflectProperties.lazy(new KProperty1Impl$_getter$1(this));
        m.f(lazy, "ReflectProperties.lazy { Getter(this) }");
        this._getter = lazy;
        a = k.a(kotlin.m.PUBLICATION, new KProperty1Impl$delegateField$1(this));
        this.delegateField = a;
    }

    @Override // kotlin.reflect.jvm.internal.KPropertyImpl, kotlin.j0.m
    public Getter<T, V> getGetter() {
        Getter<T, V> invoke = this._getter.invoke();
        m.f(invoke, "_getter()");
        return invoke;
    }
}