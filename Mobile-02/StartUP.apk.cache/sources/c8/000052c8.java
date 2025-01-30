package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* compiled from: RuntimeTypeMapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/reflect/Method;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
final class JvmFunctionSignature$FakeJavaAnnotationConstructor$asString$1 extends o implements l<Method, CharSequence> {
    public static final JvmFunctionSignature$FakeJavaAnnotationConstructor$asString$1 INSTANCE = new JvmFunctionSignature$FakeJavaAnnotationConstructor$asString$1();

    JvmFunctionSignature$FakeJavaAnnotationConstructor$asString$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final CharSequence invoke(Method it) {
        m.f(it, "it");
        Class<?> returnType = it.getReturnType();
        m.f(returnType, "it.returnType");
        return ReflectClassUtilKt.getDesc(returnType);
    }
}