package kotlin.reflect.jvm.internal;

import com.coinbase.ApiConstants;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.j0.g;
import kotlin.j0.h;
import kotlin.j0.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.x;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;

/* compiled from: KPropertyImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\b \u0018\u0000 F*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0004GFHIB\u0019\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010@\u001a\u00020(¢\u0006\u0004\bA\u0010BB5\b\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010%\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\b\u0010C\u001a\u0004\u0018\u00010(\u0012\b\u0010,\u001a\u0004\u0018\u00010\b¢\u0006\u0004\bA\u0010DB+\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010%\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\b\u00108\u001a\u0004\u0018\u00010\b¢\u0006\u0004\bA\u0010EJ\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0004¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\r8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0015R\u001c\u0010\u001c\u001a\u00020\u001b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\r8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0017R\u001a\u0010$\u001a\u0006\u0012\u0002\b\u00030!8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001c\u0010%\u001a\u00020\u00138\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010\u0015R$\u0010*\u001a\u0010\u0012\f\u0012\n )*\u0004\u0018\u00010(0(0'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0015\u0010/\u001a\u0004\u0018\u00010\u00048F@\u0006¢\u0006\u0006\u001a\u0004\b.\u0010\u0006R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00028\u0000008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0016\u00104\u001a\u00020\r8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0017R\u0016\u00105\u001a\u00020\r8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0017R\u0015\u00108\u001a\u0004\u0018\u00010\b8F@\u0006¢\u0006\u0006\u001a\u0004\b6\u00107R\u001e\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001c\u0010=\u001a\b\u0012\u0002\b\u0003\u0018\u00010!8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010#R\u0016\u0010@\u001a\u00020(8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006J"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "V", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/j0/m;", "Ljava/lang/reflect/Field;", "computeDelegateField", "()Ljava/lang/reflect/Field;", "field", "", "receiver", "getDelegate", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)Ljava/lang/Object;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "isSuspend", "()Z", "signature", "Ljava/lang/String;", "getSignature", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "isBound", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller", ApiConstants.NAME, "getName", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin.jvm.PlatformType", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "rawBoundReceiver", "Ljava/lang/Object;", "getJavaField", "javaField", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getter", "isLateinit", "isConst", "getBoundReceiver", "()Ljava/lang/Object;", "boundReceiver", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "_javaField", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getDefaultCaller", "defaultCaller", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "descriptorInitialValue", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "Companion", "Accessor", "Getter", "Setter", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public abstract class KPropertyImpl<V> extends KCallableImpl<V> implements m<V> {
    public static final Companion Companion = new Companion(null);
    private static final Object EXTENSION_PROPERTY_DELEGATE = new Object();
    private final ReflectProperties.LazySoftVal<PropertyDescriptor> _descriptor;
    private final ReflectProperties.LazyVal<Field> _javaField;
    private final KDeclarationContainerImpl container;
    private final String name;
    private final Object rawBoundReceiver;
    private final String signature;

    /* compiled from: KPropertyImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0001*\u0006\b\u0002\u0010\u0002 \u00012\b\u0012\u0004\u0012\u00028\u00020\u00032\b\u0012\u0004\u0012\u00028\u00010\u00042\b\u0012\u0004\u0012\u00028\u00020\u0005B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\t\u001a\u00020\u00068V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\n8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\n8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000f8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\n8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\fR\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\n8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\fR\u0016\u0010\u0019\u001a\u00020\n8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\fR\u0016\u0010\u001d\u001a\u00020\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/j0/m$a;", "Lkotlin/j0/g;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "", "isOperator", "()Z", "isInfix", "isExternal", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "defaultCaller", "isBound", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "property", "isSuspend", "isInline", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "descriptor", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public static abstract class Accessor<PropertyType, ReturnType> extends KCallableImpl<ReturnType> implements g<ReturnType>, m.a<PropertyType> {
        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public KDeclarationContainerImpl getContainer() {
            return getProperty().getContainer();
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public Caller<?> getDefaultCaller() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public abstract PropertyAccessorDescriptor getDescriptor();

        @Override // kotlin.reflect.jvm.internal.KCallableImpl, kotlin.j0.c
        public abstract /* synthetic */ String getName();

        public abstract /* synthetic */ m<V> getProperty();

        @Override // kotlin.j0.m.a
        public abstract KPropertyImpl<PropertyType> getProperty();

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public boolean isBound() {
            return getProperty().isBound();
        }

        @Override // kotlin.j0.g
        public boolean isExternal() {
            return getDescriptor().isExternal();
        }

        @Override // kotlin.j0.g
        public boolean isInfix() {
            return getDescriptor().isInfix();
        }

        @Override // kotlin.j0.g
        public boolean isInline() {
            return getDescriptor().isInline();
        }

        @Override // kotlin.j0.g
        public boolean isOperator() {
            return getDescriptor().isOperator();
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl, kotlin.j0.c
        public boolean isSuspend() {
            return getDescriptor().isSuspend();
        }
    }

    /* compiled from: KPropertyImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Companion;", "", "EXTENSION_PROPERTY_DELEGATE", "Ljava/lang/Object;", "getEXTENSION_PROPERTY_DELEGATE", "()Ljava/lang/Object;", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public final Object getEXTENSION_PROPERTY_DELEGATE() {
            return KPropertyImpl.EXTENSION_PROPERTY_DELEGATE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: KPropertyImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\t\u001a\u00020\u00048V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR!\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\n8V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/j0/m$b;", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor", "Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller", "", "getName", "()Ljava/lang/String;", ApiConstants.NAME, "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public static abstract class Getter<V> extends Accessor<V, V> implements m.b<V> {
        static final /* synthetic */ m[] $$delegatedProperties = {e0.h(new x(e0.b(Getter.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), e0.h(new x(e0.b(Getter.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        private final ReflectProperties.LazySoftVal descriptor$delegate = ReflectProperties.lazySoft(new KPropertyImpl$Getter$descriptor$2(this));
        private final ReflectProperties.LazyVal caller$delegate = ReflectProperties.lazy(new KPropertyImpl$Getter$caller$2(this));

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public Caller<?> getCaller() {
            return (Caller) this.caller$delegate.getValue(this, $$delegatedProperties[1]);
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.jvm.internal.KCallableImpl
        public PropertyGetterDescriptor getDescriptor() {
            return (PropertyGetterDescriptor) this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.jvm.internal.KCallableImpl, kotlin.j0.c
        public String getName() {
            return "<get-" + getProperty().getName() + '>';
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.j0.m.a
        public abstract /* synthetic */ m<V> getProperty();
    }

    /* compiled from: KPropertyImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00010\u0004B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R!\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00058V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\u00020\u000f8V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/x;", "Lkotlin/j0/h$a;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller", "", "getName", "()Ljava/lang/String;", ApiConstants.NAME, "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public static abstract class Setter<V> extends Accessor<V, kotlin.x> implements h.a<V> {
        static final /* synthetic */ m[] $$delegatedProperties = {e0.h(new x(e0.b(Setter.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), e0.h(new x(e0.b(Setter.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        private final ReflectProperties.LazySoftVal descriptor$delegate = ReflectProperties.lazySoft(new KPropertyImpl$Setter$descriptor$2(this));
        private final ReflectProperties.LazyVal caller$delegate = ReflectProperties.lazy(new KPropertyImpl$Setter$caller$2(this));

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public Caller<?> getCaller() {
            return (Caller) this.caller$delegate.getValue(this, $$delegatedProperties[1]);
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.jvm.internal.KCallableImpl
        public PropertySetterDescriptor getDescriptor() {
            return (PropertySetterDescriptor) this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.jvm.internal.KCallableImpl, kotlin.j0.c
        public String getName() {
            return "<set-" + getProperty().getName() + '>';
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.j0.m.a
        public abstract /* synthetic */ m<V> getProperty();
    }

    private KPropertyImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, PropertyDescriptor propertyDescriptor, Object obj) {
        this.container = kDeclarationContainerImpl;
        this.name = str;
        this.signature = str2;
        this.rawBoundReceiver = obj;
        ReflectProperties.LazyVal<Field> lazy = ReflectProperties.lazy(new KPropertyImpl$_javaField$1(this));
        kotlin.jvm.internal.m.f(lazy, "ReflectProperties.lazy {…y -> null\n        }\n    }");
        this._javaField = lazy;
        ReflectProperties.LazySoftVal<PropertyDescriptor> lazySoft = ReflectProperties.lazySoft(propertyDescriptor, new KPropertyImpl$_descriptor$1(this));
        kotlin.jvm.internal.m.f(lazySoft, "ReflectProperties.lazySo…or(name, signature)\n    }");
        this._descriptor = lazySoft;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Field computeDelegateField() {
        if (getDescriptor().isDelegated()) {
            return getJavaField();
        }
        return null;
    }

    public boolean equals(Object obj) {
        KPropertyImpl<?> asKPropertyImpl = UtilKt.asKPropertyImpl(obj);
        return asKPropertyImpl != null && kotlin.jvm.internal.m.c(getContainer(), asKPropertyImpl.getContainer()) && kotlin.jvm.internal.m.c(getName(), asKPropertyImpl.getName()) && kotlin.jvm.internal.m.c(this.signature, asKPropertyImpl.signature) && kotlin.jvm.internal.m.c(this.rawBoundReceiver, asKPropertyImpl.rawBoundReceiver);
    }

    public final Object getBoundReceiver() {
        return InlineClassAwareCallerKt.coerceToExpectedReceiverType(this.rawBoundReceiver, getDescriptor());
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public Caller<?> getCaller() {
        return getGetter().getCaller();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public Caller<?> getDefaultCaller() {
        return getGetter().getDefaultCaller();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
        return r2.get(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getDelegate(java.lang.reflect.Field r2, java.lang.Object r3) {
        /*
            r1 = this;
            java.lang.Object r0 = kotlin.reflect.jvm.internal.KPropertyImpl.EXTENSION_PROPERTY_DELEGATE     // Catch: java.lang.IllegalAccessException -> L39
            if (r3 != r0) goto L30
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r0 = r1.getDescriptor()     // Catch: java.lang.IllegalAccessException -> L39
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r0 = r0.getExtensionReceiverParameter()     // Catch: java.lang.IllegalAccessException -> L39
            if (r0 == 0) goto Lf
            goto L30
        Lf:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch: java.lang.IllegalAccessException -> L39
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.IllegalAccessException -> L39
            r3.<init>()     // Catch: java.lang.IllegalAccessException -> L39
            r0 = 39
            r3.append(r0)     // Catch: java.lang.IllegalAccessException -> L39
            r3.append(r1)     // Catch: java.lang.IllegalAccessException -> L39
            java.lang.String r0 = "' is not an extension property and thus getExtensionDelegate() "
            r3.append(r0)     // Catch: java.lang.IllegalAccessException -> L39
            java.lang.String r0 = "is not going to work, use getDelegate() instead"
            r3.append(r0)     // Catch: java.lang.IllegalAccessException -> L39
            java.lang.String r3 = r3.toString()     // Catch: java.lang.IllegalAccessException -> L39
            r2.<init>(r3)     // Catch: java.lang.IllegalAccessException -> L39
            throw r2     // Catch: java.lang.IllegalAccessException -> L39
        L30:
            if (r2 == 0) goto L37
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.IllegalAccessException -> L39
            goto L38
        L37:
            r2 = 0
        L38:
            return r2
        L39:
            r2 = move-exception
            kotlin.reflect.full.IllegalPropertyDelegateAccessException r3 = new kotlin.reflect.full.IllegalPropertyDelegateAccessException
            r3.<init>(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KPropertyImpl.getDelegate(java.lang.reflect.Field, java.lang.Object):java.lang.Object");
    }

    public abstract /* synthetic */ m.b<V> getGetter();

    public abstract Getter<V> getGetter();

    public final Field getJavaField() {
        return this._javaField.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl, kotlin.j0.c
    public String getName() {
        return this.name;
    }

    public final String getSignature() {
        return this.signature;
    }

    public int hashCode() {
        return (((getContainer().hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public boolean isBound() {
        return !kotlin.jvm.internal.m.c(this.rawBoundReceiver, c.NO_RECEIVER);
    }

    @Override // kotlin.j0.m
    public boolean isConst() {
        return getDescriptor().isConst();
    }

    @Override // kotlin.j0.m
    public boolean isLateinit() {
        return getDescriptor().isLateInit();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl, kotlin.j0.c
    public boolean isSuspend() {
        return false;
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderProperty(getDescriptor());
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public PropertyDescriptor getDescriptor() {
        PropertyDescriptor invoke = this._descriptor.invoke();
        kotlin.jvm.internal.m.f(invoke, "_descriptor()");
        return invoke;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KPropertyImpl(KDeclarationContainerImpl container, String name, String signature, Object obj) {
        this(container, name, signature, null, obj);
        kotlin.jvm.internal.m.g(container, "container");
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(signature, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public KPropertyImpl(kotlin.reflect.jvm.internal.KDeclarationContainerImpl r8, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r9) {
        /*
            r7 = this;
            java.lang.String r0 = "container"
            kotlin.jvm.internal.m.g(r8, r0)
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.m.g(r9, r0)
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r9.getName()
            java.lang.String r3 = r0.asString()
            java.lang.String r0 = "descriptor.name.asString()"
            kotlin.jvm.internal.m.f(r3, r0)
            kotlin.reflect.jvm.internal.RuntimeTypeMapper r0 = kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE
            kotlin.reflect.jvm.internal.JvmPropertySignature r0 = r0.mapPropertySignature(r9)
            java.lang.String r4 = r0.asString()
            java.lang.Object r6 = kotlin.jvm.internal.c.NO_RECEIVER
            r1 = r7
            r2 = r8
            r5 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KPropertyImpl.<init>(kotlin.reflect.jvm.internal.KDeclarationContainerImpl, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor):void");
    }
}