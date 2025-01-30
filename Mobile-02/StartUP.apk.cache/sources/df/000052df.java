package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.a0.n;
import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KClassImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "T", "Ljava/lang/reflect/Type;", "invoke", "()Ljava/lang/reflect/Type;", "kotlin/reflect/jvm/internal/KClassImpl$Data$supertypes$2$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KClassImpl$Data$supertypes$2$$special$$inlined$mapTo$lambda$1 extends o implements a<Type> {
    final /* synthetic */ KotlinType $kotlinType;
    final /* synthetic */ KClassImpl$Data$supertypes$2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$supertypes$2$$special$$inlined$mapTo$lambda$1(KotlinType kotlinType, KClassImpl$Data$supertypes$2 kClassImpl$Data$supertypes$2) {
        super(0);
        this.$kotlinType = kotlinType;
        this.this$0 = kClassImpl$Data$supertypes$2;
    }

    @Override // kotlin.e0.c.a
    public final Type invoke() {
        int F;
        ClassifierDescriptor mo2214getDeclarationDescriptor = this.$kotlinType.getConstructor().mo2214getDeclarationDescriptor();
        if (mo2214getDeclarationDescriptor instanceof ClassDescriptor) {
            Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) mo2214getDeclarationDescriptor);
            if (javaClass != null) {
                if (m.c(KClassImpl.this.getJClass().getSuperclass(), javaClass)) {
                    Type genericSuperclass = KClassImpl.this.getJClass().getGenericSuperclass();
                    m.f(genericSuperclass, "jClass.genericSuperclass");
                    return genericSuperclass;
                }
                Class<?>[] interfaces = KClassImpl.this.getJClass().getInterfaces();
                m.f(interfaces, "jClass.interfaces");
                F = n.F(interfaces, javaClass);
                if (F >= 0) {
                    Type type = KClassImpl.this.getJClass().getGenericInterfaces()[F];
                    m.f(type, "jClass.genericInterfaces[index]");
                    return type;
                }
                throw new KotlinReflectionInternalError("No superclass of " + this.this$0.this$0 + " in Java reflection for " + mo2214getDeclarationDescriptor);
            }
            throw new KotlinReflectionInternalError("Unsupported superclass of " + this.this$0.this$0 + ": " + mo2214getDeclarationDescriptor);
        }
        throw new KotlinReflectionInternalError("Supertype not a class: " + mo2214getDeclarationDescriptor);
    }
}