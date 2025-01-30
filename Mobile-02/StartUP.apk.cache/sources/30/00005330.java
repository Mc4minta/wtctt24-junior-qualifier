package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.JvmPropertySignature;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.DescriptorsJvmAbiUtil;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KPropertyImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"V", "Ljava/lang/reflect/Field;", "invoke", "()Ljava/lang/reflect/Field;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KPropertyImpl$_javaField$1 extends o implements a<Field> {
    final /* synthetic */ KPropertyImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPropertyImpl$_javaField$1(KPropertyImpl kPropertyImpl) {
        super(0);
        this.this$0 = kPropertyImpl;
    }

    @Override // kotlin.e0.c.a
    public final Field invoke() {
        Class<?> enclosingClass;
        JvmPropertySignature mapPropertySignature = RuntimeTypeMapper.INSTANCE.mapPropertySignature(this.this$0.getDescriptor());
        if (mapPropertySignature instanceof JvmPropertySignature.KotlinProperty) {
            JvmPropertySignature.KotlinProperty kotlinProperty = (JvmPropertySignature.KotlinProperty) mapPropertySignature;
            PropertyDescriptor descriptor = kotlinProperty.getDescriptor();
            JvmMemberSignature.Field jvmFieldSignature$default = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.INSTANCE, kotlinProperty.getProto(), kotlinProperty.getNameResolver(), kotlinProperty.getTypeTable(), false, 8, null);
            if (jvmFieldSignature$default != null) {
                if (!DescriptorsJvmAbiUtil.isPropertyWithBackingFieldInOuterClass(descriptor) && !JvmProtoBufUtil.isMovedFromInterfaceCompanion(kotlinProperty.getProto())) {
                    DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
                    enclosingClass = containingDeclaration instanceof ClassDescriptor ? UtilKt.toJavaClass((ClassDescriptor) containingDeclaration) : this.this$0.getContainer().getJClass();
                } else {
                    enclosingClass = this.this$0.getContainer().getJClass().getEnclosingClass();
                }
                if (enclosingClass != null) {
                    try {
                        return enclosingClass.getDeclaredField(jvmFieldSignature$default.getName());
                    } catch (NoSuchFieldException unused) {
                        return null;
                    }
                }
                return null;
            }
            return null;
        } else if (mapPropertySignature instanceof JvmPropertySignature.JavaField) {
            return ((JvmPropertySignature.JavaField) mapPropertySignature).getField();
        } else {
            if ((mapPropertySignature instanceof JvmPropertySignature.JavaMethodProperty) || (mapPropertySignature instanceof JvmPropertySignature.MappedKotlinProperty)) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}