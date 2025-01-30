package kotlin.reflect.jvm.internal;

import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.h;
import kotlin.j0.n;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* compiled from: KProperty0Impl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u001fB\u0019\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019B+\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0018\u0010\u001eJ\u000f\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\b\u0010\u0005R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\t8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR0\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u000e*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\t0\r8\b@\bX\u0088\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty0Impl;", "V", "Lkotlin/j0/n;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "get", "()Ljava/lang/Object;", "", "getDelegate", "invoke", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "kotlin.jvm.PlatformType", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/h;", "delegateFieldValue", "Lkotlin/h;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "", ApiConstants.NAME, "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "Getter", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public class KProperty0Impl<V> extends KPropertyImpl<V> implements n<V> {
    private final ReflectProperties.LazyVal<Getter<V>> _getter;
    private final h<Object> delegateFieldValue;

    /* compiled from: KProperty0Impl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0004\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/j0/n$a;", "invoke", "()Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "property", "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty0Impl;", "<init>", "(Lkotlin/reflect/jvm/internal/KProperty0Impl;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public static final class Getter<R> extends KPropertyImpl.Getter<R> implements n.a<R> {
        private final KProperty0Impl<R> property;

        /* JADX WARN: Multi-variable type inference failed */
        public Getter(KProperty0Impl<? extends R> property) {
            m.g(property, "property");
            this.property = property;
        }

        @Override // kotlin.e0.c.a
        public R invoke() {
            return getProperty().get();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Getter, kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.j0.m.a
        public KProperty0Impl<R> getProperty() {
            return this.property;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty0Impl(KDeclarationContainerImpl container, PropertyDescriptor descriptor) {
        super(container, descriptor);
        h<Object> a;
        m.g(container, "container");
        m.g(descriptor, "descriptor");
        ReflectProperties.LazyVal<Getter<V>> lazy = ReflectProperties.lazy(new KProperty0Impl$_getter$1(this));
        m.f(lazy, "ReflectProperties.lazy { Getter(this) }");
        this._getter = lazy;
        a = k.a(kotlin.m.PUBLICATION, new KProperty0Impl$delegateFieldValue$1(this));
        this.delegateFieldValue = a;
    }

    @Override // kotlin.j0.n
    public V get() {
        return getGetter().call(new Object[0]);
    }

    @Override // kotlin.j0.n
    public Object getDelegate() {
        return this.delegateFieldValue.getValue();
    }

    @Override // kotlin.e0.c.a
    public V invoke() {
        return get();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty0Impl(KDeclarationContainerImpl container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        h<Object> a;
        m.g(container, "container");
        m.g(name, "name");
        m.g(signature, "signature");
        ReflectProperties.LazyVal<Getter<V>> lazy = ReflectProperties.lazy(new KProperty0Impl$_getter$1(this));
        m.f(lazy, "ReflectProperties.lazy { Getter(this) }");
        this._getter = lazy;
        a = k.a(kotlin.m.PUBLICATION, new KProperty0Impl$delegateFieldValue$1(this));
        this.delegateFieldValue = a;
    }

    @Override // kotlin.reflect.jvm.internal.KPropertyImpl, kotlin.j0.m
    public Getter<V> getGetter() {
        Getter<V> invoke = this._getter.invoke();
        m.f(invoke, "_getter()");
        return invoke;
    }
}