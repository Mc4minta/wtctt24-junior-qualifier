package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import kotlin.a0.q;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmBuiltInsCustomizer.kt */
/* loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer$notConsideredDeprecation$2 extends o implements a<Annotations> {
    final /* synthetic */ JvmBuiltInsCustomizer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltInsCustomizer$notConsideredDeprecation$2(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        super(0);
        this.this$0 = jvmBuiltInsCustomizer;
    }

    @Override // kotlin.e0.c.a
    public final Annotations invoke() {
        ModuleDescriptor moduleDescriptor;
        List<? extends AnnotationDescriptor> b2;
        moduleDescriptor = this.this$0.moduleDescriptor;
        AnnotationDescriptor createDeprecatedAnnotation$default = AnnotationUtilKt.createDeprecatedAnnotation$default(moduleDescriptor.getBuiltIns(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, 6, null);
        Annotations.Companion companion = Annotations.Companion;
        b2 = q.b(createDeprecatedAnnotation$default);
        return companion.create(b2);
    }
}