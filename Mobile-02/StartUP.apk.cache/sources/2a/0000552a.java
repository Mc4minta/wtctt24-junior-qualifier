package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.List;
import java.util.Map;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.a0.q;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.u;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JavaAnnotationMapper.kt */
/* loaded from: classes3.dex */
public final class JavaTargetAnnotationDescriptor$allValueArguments$2 extends o implements a<Map<Name, ? extends ConstantValue<? extends Object>>> {
    final /* synthetic */ JavaTargetAnnotationDescriptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaTargetAnnotationDescriptor$allValueArguments$2(JavaTargetAnnotationDescriptor javaTargetAnnotationDescriptor) {
        super(0);
        this.this$0 = javaTargetAnnotationDescriptor;
    }

    @Override // kotlin.e0.c.a
    public final Map<Name, ? extends ConstantValue<? extends Object>> invoke() {
        ConstantValue<?> constantValue;
        List<? extends JavaAnnotationArgument> b2;
        Map<Name, ? extends ConstantValue<? extends Object>> i2;
        JavaAnnotationArgument firstArgument = this.this$0.getFirstArgument();
        if (firstArgument instanceof JavaArrayAnnotationArgument) {
            constantValue = JavaAnnotationTargetMapper.INSTANCE.mapJavaTargetArguments$descriptors_jvm(((JavaArrayAnnotationArgument) this.this$0.getFirstArgument()).getElements());
        } else if (firstArgument instanceof JavaEnumValueAnnotationArgument) {
            JavaAnnotationTargetMapper javaAnnotationTargetMapper = JavaAnnotationTargetMapper.INSTANCE;
            b2 = q.b(this.this$0.getFirstArgument());
            constantValue = javaAnnotationTargetMapper.mapJavaTargetArguments$descriptors_jvm(b2);
        } else {
            constantValue = null;
        }
        Map<Name, ? extends ConstantValue<? extends Object>> e2 = constantValue != null ? l0.e(u.a(JavaAnnotationMapper.INSTANCE.getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm(), constantValue)) : null;
        if (e2 != null) {
            return e2;
        }
        i2 = m0.i();
        return i2;
    }
}