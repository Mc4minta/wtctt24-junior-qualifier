package kotlin.reflect.jvm.internal;

import com.coinbase.ApiConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.j0.g;
import kotlin.j0.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.x;
import kotlin.reflect.jvm.internal.FunctionWithAllInvokes;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.CallerKt;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.InlineClassManglingRulesKt;

/* compiled from: KFunctionImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u00020\u0005B\u0019\b\u0016\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\bA\u0010BB7\b\u0002\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u0010/\u001a\u00020\u001a\u0012\u0006\u00101\u001a\u00020\u001a\u0012\b\u0010C\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bA\u0010DB+\b\u0016\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u0010/\u001a\u00020\u001a\u0012\u0006\u00101\u001a\u00020\u001a\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bA\u0010EJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\nJ-\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u00102\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001d\u0010\u000f\u001a\u00020\u000e8V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00148V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R!\u0010*\u001a\u0006\u0012\u0002\b\u00030%8V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R#\u0010-\u001a\b\u0012\u0002\b\u0003\u0018\u00010%8V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b,\u0010)R\u0016\u0010/\u001a\u00020\u001a8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u001cR\u0016\u00100\u001a\u00020\u00148V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u0010$R\u0016\u00101\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u00148V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010$R\u0016\u00104\u001a\u00020\u00148V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010$R\u001c\u00106\u001a\u0002058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010\u00028B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020\u00148V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010$R\u0016\u0010?\u001a\u00020\u00178V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0019R\u0016\u0010@\u001a\u00020\u00148V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010$¨\u0006F"}, d2 = {"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/j0/g;", "Lkotlin/jvm/internal/i;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "Ljava/lang/reflect/Method;", "member", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "createStaticMethodCaller", "(Ljava/lang/reflect/Method;)Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "createJvmStaticInObjectCaller", "createInstanceMethodCaller", "Ljava/lang/reflect/Constructor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "descriptor", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "createConstructorCaller", "(Ljava/lang/reflect/Constructor;Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;)Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "rawBoundReceiver", "Ljava/lang/Object;", "isInline", "()Z", "Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller", "defaultCaller$delegate", "getDefaultCaller", "defaultCaller", "getName", ApiConstants.NAME, "isSuspend", "signature", "Ljava/lang/String;", "isInfix", "isBound", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getBoundReceiver", "()Ljava/lang/Object;", "boundReceiver", "isExternal", "getArity", "arity", "isOperator", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KFunctionImpl extends KCallableImpl<Object> implements i<Object>, g<Object>, FunctionWithAllInvokes {
    static final /* synthetic */ m[] $$delegatedProperties = {e0.h(new x(e0.b(KFunctionImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), e0.h(new x(e0.b(KFunctionImpl.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), e0.h(new x(e0.b(KFunctionImpl.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
    private final ReflectProperties.LazyVal caller$delegate;
    private final KDeclarationContainerImpl container;
    private final ReflectProperties.LazyVal defaultCaller$delegate;
    private final ReflectProperties.LazySoftVal descriptor$delegate;
    private final Object rawBoundReceiver;
    private final String signature;

    /* synthetic */ KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, FunctionDescriptor functionDescriptor, Object obj, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kDeclarationContainerImpl, str, str2, functionDescriptor, (i2 & 16) != 0 ? c.NO_RECEIVER : obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CallerImpl<Constructor<?>> createConstructorCaller(Constructor<?> constructor, FunctionDescriptor functionDescriptor) {
        if (InlineClassManglingRulesKt.shouldHideConstructorDueToInlineClassTypeValueParameters(functionDescriptor)) {
            if (isBound()) {
                return new CallerImpl.AccessorForHiddenBoundConstructor(constructor, getBoundReceiver());
            }
            return new CallerImpl.AccessorForHiddenConstructor(constructor);
        } else if (isBound()) {
            return new CallerImpl.BoundConstructor(constructor, getBoundReceiver());
        } else {
            return new CallerImpl.Constructor(constructor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CallerImpl.Method createInstanceMethodCaller(Method method) {
        return isBound() ? new CallerImpl.Method.BoundInstance(method, getBoundReceiver()) : new CallerImpl.Method.Instance(method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CallerImpl.Method createJvmStaticInObjectCaller(Method method) {
        return isBound() ? new CallerImpl.Method.BoundJvmStaticInObject(method) : new CallerImpl.Method.JvmStaticInObject(method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CallerImpl.Method createStaticMethodCaller(Method method) {
        return isBound() ? new CallerImpl.Method.BoundStatic(method, getBoundReceiver()) : new CallerImpl.Method.Static(method);
    }

    private final Object getBoundReceiver() {
        return InlineClassAwareCallerKt.coerceToExpectedReceiverType(this.rawBoundReceiver, getDescriptor());
    }

    public boolean equals(Object obj) {
        KFunctionImpl asKFunctionImpl = UtilKt.asKFunctionImpl(obj);
        return asKFunctionImpl != null && kotlin.jvm.internal.m.c(getContainer(), asKFunctionImpl.getContainer()) && kotlin.jvm.internal.m.c(getName(), asKFunctionImpl.getName()) && kotlin.jvm.internal.m.c(this.signature, asKFunctionImpl.signature) && kotlin.jvm.internal.m.c(this.rawBoundReceiver, asKFunctionImpl.rawBoundReceiver);
    }

    @Override // kotlin.jvm.internal.i
    public int getArity() {
        return CallerKt.getArity(getCaller());
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public Caller<?> getCaller() {
        return (Caller) this.caller$delegate.getValue(this, $$delegatedProperties[1]);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public Caller<?> getDefaultCaller() {
        return (Caller) this.defaultCaller$delegate.getValue(this, $$delegatedProperties[2]);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public FunctionDescriptor getDescriptor() {
        return (FunctionDescriptor) this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl, kotlin.j0.c
    public String getName() {
        String asString = getDescriptor().getName().asString();
        kotlin.jvm.internal.m.f(asString, "descriptor.name.asString()");
        return asString;
    }

    public int hashCode() {
        return (((getContainer().hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes, kotlin.e0.c.a
    public Object invoke() {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public boolean isBound() {
        return !kotlin.jvm.internal.m.c(this.rawBoundReceiver, c.NO_RECEIVER);
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

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderFunction(getDescriptor());
    }

    private KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, FunctionDescriptor functionDescriptor, Object obj) {
        this.container = kDeclarationContainerImpl;
        this.signature = str2;
        this.rawBoundReceiver = obj;
        this.descriptor$delegate = ReflectProperties.lazySoft(functionDescriptor, new KFunctionImpl$descriptor$2(this, str));
        this.caller$delegate = ReflectProperties.lazy(new KFunctionImpl$caller$2(this));
        this.defaultCaller$delegate = ReflectProperties.lazy(new KFunctionImpl$defaultCaller$2(this));
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes, kotlin.e0.c.l
    public Object invoke(Object obj) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj);
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes, kotlin.e0.c.p
    public Object invoke(Object obj, Object obj2) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2);
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes, kotlin.e0.c.q
    public Object invoke(Object obj, Object obj2, Object obj3) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3);
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes, kotlin.e0.c.r
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KFunctionImpl(KDeclarationContainerImpl container, String name, String signature, Object obj) {
        this(container, name, signature, null, obj);
        kotlin.jvm.internal.m.g(container, "container");
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(signature, "signature");
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public KFunctionImpl(kotlin.reflect.jvm.internal.KDeclarationContainerImpl r10, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r11) {
        /*
            r9 = this;
            java.lang.String r0 = "container"
            kotlin.jvm.internal.m.g(r10, r0)
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.m.g(r11, r0)
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r11.getName()
            java.lang.String r3 = r0.asString()
            java.lang.String r0 = "descriptor.name.asString()"
            kotlin.jvm.internal.m.f(r3, r0)
            kotlin.reflect.jvm.internal.RuntimeTypeMapper r0 = kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE
            kotlin.reflect.jvm.internal.JvmFunctionSignature r0 = r0.mapSignature(r11)
            java.lang.String r4 = r0.asString()
            r6 = 0
            r7 = 16
            r8 = 0
            r1 = r9
            r2 = r10
            r5 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KFunctionImpl.<init>(kotlin.reflect.jvm.internal.KDeclarationContainerImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor):void");
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18);
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19);
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21);
    }

    @Override // kotlin.reflect.jvm.internal.FunctionWithAllInvokes
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21, Object obj22) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }
}