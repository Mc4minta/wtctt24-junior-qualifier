package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* compiled from: RuntimeTypeMapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/Class;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Class;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
final class JvmFunctionSignature$JavaConstructor$asString$1 extends o implements l<Class<?>, CharSequence> {
    public static final JvmFunctionSignature$JavaConstructor$asString$1 INSTANCE = new JvmFunctionSignature$JavaConstructor$asString$1();

    JvmFunctionSignature$JavaConstructor$asString$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final CharSequence invoke(Class<?> it) {
        m.f(it, "it");
        return ReflectClassUtilKt.getDesc(it);
    }
}