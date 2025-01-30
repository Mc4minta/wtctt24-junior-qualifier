package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.s;
import kotlin.e0.c.a;
import kotlin.j0.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KFunctionImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003 \u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/Caller;", "kotlin.jvm.PlatformType", "invoke", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KFunctionImpl$caller$2 extends o implements a<Caller<? extends Member>> {
    final /* synthetic */ KFunctionImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KFunctionImpl$caller$2(KFunctionImpl kFunctionImpl) {
        super(0);
        this.this$0 = kFunctionImpl;
    }

    @Override // kotlin.e0.c.a
    public final Caller<? extends Member> invoke() {
        int r;
        Object constructor;
        Caller createInstanceMethodCaller;
        int r2;
        JvmFunctionSignature mapSignature = RuntimeTypeMapper.INSTANCE.mapSignature(this.this$0.getDescriptor());
        if (mapSignature instanceof JvmFunctionSignature.KotlinConstructor) {
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
                return new AnnotationConstructorCaller(jClass, arrayList, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
            }
            constructor = this.this$0.getContainer().findConstructorBySignature(((JvmFunctionSignature.KotlinConstructor) mapSignature).getConstructorDesc());
        } else if (mapSignature instanceof JvmFunctionSignature.KotlinFunction) {
            JvmFunctionSignature.KotlinFunction kotlinFunction = (JvmFunctionSignature.KotlinFunction) mapSignature;
            constructor = this.this$0.getContainer().findMethodBySignature(kotlinFunction.getMethodName(), kotlinFunction.getMethodDesc());
        } else if (mapSignature instanceof JvmFunctionSignature.JavaMethod) {
            constructor = ((JvmFunctionSignature.JavaMethod) mapSignature).getMethod();
        } else if (!(mapSignature instanceof JvmFunctionSignature.JavaConstructor)) {
            if (mapSignature instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
                List<Method> methods = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) mapSignature).getMethods();
                Class<?> jClass2 = this.this$0.getContainer().getJClass();
                r = s.r(methods, 10);
                ArrayList arrayList2 = new ArrayList(r);
                for (Method it : methods) {
                    m.f(it, "it");
                    arrayList2.add(it.getName());
                }
                return new AnnotationConstructorCaller(jClass2, arrayList2, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.JAVA, methods);
            }
            throw new NoWhenBranchMatchedException();
        } else {
            constructor = ((JvmFunctionSignature.JavaConstructor) mapSignature).getConstructor();
        }
        if (constructor instanceof Constructor) {
            KFunctionImpl kFunctionImpl = this.this$0;
            createInstanceMethodCaller = kFunctionImpl.createConstructorCaller((Constructor) constructor, kFunctionImpl.getDescriptor());
        } else if (constructor instanceof Method) {
            Method method = (Method) constructor;
            createInstanceMethodCaller = !Modifier.isStatic(method.getModifiers()) ? this.this$0.createInstanceMethodCaller(method) : this.this$0.getDescriptor().getAnnotations().mo2207findAnnotation(UtilKt.getJVM_STATIC()) != null ? this.this$0.createJvmStaticInObjectCaller(method) : this.this$0.createStaticMethodCaller(method);
        } else {
            throw new KotlinReflectionInternalError("Could not compute caller for function: " + this.this$0.getDescriptor() + " (member = " + constructor + ')');
        }
        return InlineClassAwareCallerKt.createInlineClassAwareCallerIfNeeded$default(createInstanceMethodCaller, this.this$0.getDescriptor(), false, 2, null);
    }
}