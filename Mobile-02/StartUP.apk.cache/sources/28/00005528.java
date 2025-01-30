package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.u;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JavaAnnotationMapper.kt */
/* loaded from: classes3.dex */
public final class JavaRetentionAnnotationDescriptor$allValueArguments$2 extends o implements a<Map<Name, ? extends ConstantValue<?>>> {
    final /* synthetic */ JavaRetentionAnnotationDescriptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaRetentionAnnotationDescriptor$allValueArguments$2(JavaRetentionAnnotationDescriptor javaRetentionAnnotationDescriptor) {
        super(0);
        this.this$0 = javaRetentionAnnotationDescriptor;
    }

    @Override // kotlin.e0.c.a
    public final Map<Name, ? extends ConstantValue<?>> invoke() {
        Map<Name, ? extends ConstantValue<?>> i2;
        ConstantValue<?> mapJavaRetentionArgument$descriptors_jvm = JavaAnnotationTargetMapper.INSTANCE.mapJavaRetentionArgument$descriptors_jvm(this.this$0.getFirstArgument());
        Map<Name, ? extends ConstantValue<?>> e2 = mapJavaRetentionArgument$descriptors_jvm == null ? null : l0.e(u.a(JavaAnnotationMapper.INSTANCE.getRETENTION_ANNOTATION_VALUE$descriptors_jvm(), mapJavaRetentionArgument$descriptors_jvm));
        if (e2 != null) {
            return e2;
        }
        i2 = m0.i();
        return i2;
    }
}