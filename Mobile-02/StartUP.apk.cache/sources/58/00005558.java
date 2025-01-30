package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import kotlin.a0.m0;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.u;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaAnnotationDescriptor.kt */
/* loaded from: classes3.dex */
public final class LazyJavaAnnotationDescriptor$allValueArguments$2 extends o implements a<Map<Name, ? extends ConstantValue<?>>> {
    final /* synthetic */ LazyJavaAnnotationDescriptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaAnnotationDescriptor$allValueArguments$2(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        super(0);
        this.this$0 = lazyJavaAnnotationDescriptor;
    }

    @Override // kotlin.e0.c.a
    public final Map<Name, ? extends ConstantValue<?>> invoke() {
        JavaAnnotation javaAnnotation;
        Map<Name, ? extends ConstantValue<?>> r;
        ConstantValue resolveAnnotationArgument;
        javaAnnotation = this.this$0.javaAnnotation;
        Collection<JavaAnnotationArgument> arguments = javaAnnotation.getArguments();
        LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (JavaAnnotationArgument javaAnnotationArgument : arguments) {
            Name name = javaAnnotationArgument.getName();
            if (name == null) {
                name = JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME;
            }
            resolveAnnotationArgument = lazyJavaAnnotationDescriptor.resolveAnnotationArgument(javaAnnotationArgument);
            kotlin.o a = resolveAnnotationArgument == null ? null : u.a(name, resolveAnnotationArgument);
            if (a != null) {
                arrayList.add(a);
            }
        }
        r = m0.r(arrayList);
        return r;
    }
}