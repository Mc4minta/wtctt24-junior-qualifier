package kotlin.reflect.jvm.internal;

import com.coinbase.ApiConstants;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.h;
import kotlin.j0.p;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* compiled from: KProperty2Impl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0006\b\u0002\u0010\u0003 \u00012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00042\b\u0012\u0004\u0012\u00028\u00020\u0005:\u0001#B\u0019\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eB!\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010!\u001a\u00020\u001f¢\u0006\u0004\b\u001d\u0010\"J\u001f\u0010\b\u001a\u00028\u00022\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u000b\u0010\tJ \u0010\f\u001a\u00028\u00022\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\f\u0010\tRH\u0010\u0010\u001a4\u00120\u0012.\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002 \u000f*\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000e0\u000e0\r8\b@\bX\u0088\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R(\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty2Impl;", "D", "E", "V", "Lkotlin/j0/p;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "receiver1", "receiver2", "get", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "getDelegate", "invoke", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "kotlin.jvm.PlatformType", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/h;", "Ljava/lang/reflect/Field;", "delegateField", "Lkotlin/h;", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "getter", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "", ApiConstants.NAME, "signature", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;)V", "Getter", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public class KProperty2Impl<D, E, V> extends KPropertyImpl<V> implements p<D, E, V> {
    private final ReflectProperties.LazyVal<Getter<D, E, V>> _getter;
    private final h<Field> delegateField;

    /* compiled from: KProperty2Impl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0003\u0010\u0001*\u0004\b\u0004\u0010\u0002*\u0006\b\u0005\u0010\u0003 \u00012\b\u0012\u0004\u0012\u00028\u00050\u00042\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0005B!\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\n¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\b\u001a\u00028\u00052\u0006\u0010\u0006\u001a\u00028\u00032\u0006\u0010\u0007\u001a\u00028\u0004H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR.\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\n8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "D", "E", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/j0/p$a;", "receiver1", "receiver2", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/KProperty2Impl;", "property", "Lkotlin/reflect/jvm/internal/KProperty2Impl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty2Impl;", "<init>", "(Lkotlin/reflect/jvm/internal/KProperty2Impl;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public static final class Getter<D, E, V> extends KPropertyImpl.Getter<V> implements p.a<D, E, V> {
        private final KProperty2Impl<D, E, V> property;

        /* JADX WARN: Multi-variable type inference failed */
        public Getter(KProperty2Impl<D, E, ? extends V> property) {
            m.g(property, "property");
            this.property = property;
        }

        @Override // kotlin.e0.c.p
        public V invoke(D d2, E e2) {
            return getProperty().get(d2, e2);
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Getter, kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.j0.m.a
        public KProperty2Impl<D, E, V> getProperty() {
            return this.property;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty2Impl(KDeclarationContainerImpl container, String name, String signature) {
        super(container, name, signature, c.NO_RECEIVER);
        h<Field> a;
        m.g(container, "container");
        m.g(name, "name");
        m.g(signature, "signature");
        ReflectProperties.LazyVal<Getter<D, E, V>> lazy = ReflectProperties.lazy(new KProperty2Impl$_getter$1(this));
        m.f(lazy, "ReflectProperties.lazy { Getter(this) }");
        this._getter = lazy;
        a = k.a(kotlin.m.PUBLICATION, new KProperty2Impl$delegateField$1(this));
        this.delegateField = a;
    }

    public V get(D d2, E e2) {
        return getGetter().call(d2, e2);
    }

    public Object getDelegate(D d2, E e2) {
        return getDelegate(this.delegateField.getValue(), (Object) d2);
    }

    @Override // kotlin.e0.c.p
    public V invoke(D d2, E e2) {
        return get(d2, e2);
    }

    @Override // kotlin.reflect.jvm.internal.KPropertyImpl, kotlin.j0.m
    public Getter<D, E, V> getGetter() {
        Getter<D, E, V> invoke = this._getter.invoke();
        m.f(invoke, "_getter()");
        return invoke;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty2Impl(KDeclarationContainerImpl container, PropertyDescriptor descriptor) {
        super(container, descriptor);
        h<Field> a;
        m.g(container, "container");
        m.g(descriptor, "descriptor");
        ReflectProperties.LazyVal<Getter<D, E, V>> lazy = ReflectProperties.lazy(new KProperty2Impl$_getter$1(this));
        m.f(lazy, "ReflectProperties.lazy { Getter(this) }");
        this._getter = lazy;
        a = k.a(kotlin.m.PUBLICATION, new KProperty2Impl$delegateField$1(this));
        this.delegateField = a;
    }
}