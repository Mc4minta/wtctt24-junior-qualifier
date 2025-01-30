package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.s;
import kotlin.e0.c.a;
import kotlin.j0.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KFunctionImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/Caller;", "invoke", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KFunctionImpl$defaultCaller$2 extends o implements a<Caller<? extends Member>> {
    final /* synthetic */ KFunctionImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KFunctionImpl$defaultCaller$2(KFunctionImpl kFunctionImpl) {
        super(0);
        this.this$0 = kFunctionImpl;
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.reflect.Member, java.lang.Object] */
    @Override // kotlin.e0.c.a
    public final Caller<? extends Member> invoke() {
        GenericDeclaration genericDeclaration;
        int r;
        int r2;
        Caller caller;
        ?? mo2204getMember;
        JvmFunctionSignature mapSignature = RuntimeTypeMapper.INSTANCE.mapSignature(this.this$0.getDescriptor());
        if (mapSignature instanceof JvmFunctionSignature.KotlinFunction) {
            KDeclarationContainerImpl container = this.this$0.getContainer();
            JvmFunctionSignature.KotlinFunction kotlinFunction = (JvmFunctionSignature.KotlinFunction) mapSignature;
            String methodName = kotlinFunction.getMethodName();
            String methodDesc = kotlinFunction.getMethodDesc();
            m.e(this.this$0.getCaller().mo2204getMember());
            genericDeclaration = container.findDefaultMethod(methodName, methodDesc, !Modifier.isStatic(mo2204getMember.getModifiers()));
        } else if (mapSignature instanceof JvmFunctionSignature.KotlinConstructor) {
            if (this.this$0.isAnnotationConstructor()) {
                Class<?> jClass = this.this$0.getContainer().getJClass();
                List<l> parameters = this.this$0.getParameters();
                r2 = s.r(parameters, 10);
                ArrayList arrayList = new ArrayList(r2);
                for (l lVar : parameters) {
                    String name = lVar.getName();
                    m.e(name);
                    arrayList.add(name);
                }
                return new AnnotationConstructorCaller(jClass, arrayList, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
            }
            genericDeclaration = this.this$0.getContainer().findDefaultConstructor(((JvmFunctionSignature.KotlinConstructor) mapSignature).getConstructorDesc());
        } else if (mapSignature instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
            List<Method> methods = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) mapSignature).getMethods();
            Class<?> jClass2 = this.this$0.getContainer().getJClass();
            r = s.r(methods, 10);
            ArrayList arrayList2 = new ArrayList(r);
            for (Method it : methods) {
                m.f(it, "it");
                arrayList2.add(it.getName());
            }
            return new AnnotationConstructorCaller(jClass2, arrayList2, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.JAVA, methods);
        } else {
            genericDeclaration = null;
        }
        if (genericDeclaration instanceof Constructor) {
            KFunctionImpl kFunctionImpl = this.this$0;
            caller = kFunctionImpl.createConstructorCaller((Constructor) genericDeclaration, kFunctionImpl.getDescriptor());
        } else if (genericDeclaration instanceof Method) {
            if (this.this$0.getDescriptor().getAnnotations().mo2207findAnnotation(UtilKt.getJVM_STATIC()) != null) {
                DeclarationDescriptor containingDeclaration = this.this$0.getDescriptor().getContainingDeclaration();
                Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                if (!((ClassDescriptor) containingDeclaration).isCompanionObject()) {
                    caller = this.this$0.createJvmStaticInObjectCaller((Method) genericDeclaration);
                }
            }
            caller = this.this$0.createStaticMethodCaller((Method) genericDeclaration);
        } else {
            caller = null;
        }
        if (caller != null) {
            return InlineClassAwareCallerKt.createInlineClassAwareCallerIfNeeded(caller, this.this$0.getDescriptor(), true);
        }
        return null;
    }
}