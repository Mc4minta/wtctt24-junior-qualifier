package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaAnnotationDescriptor.kt */
/* loaded from: classes3.dex */
public final class LazyJavaAnnotationDescriptor$fqName$2 extends o implements a<FqName> {
    final /* synthetic */ LazyJavaAnnotationDescriptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaAnnotationDescriptor$fqName$2(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        super(0);
        this.this$0 = lazyJavaAnnotationDescriptor;
    }

    @Override // kotlin.e0.c.a
    public final FqName invoke() {
        JavaAnnotation javaAnnotation;
        javaAnnotation = this.this$0.javaAnnotation;
        ClassId classId = javaAnnotation.getClassId();
        if (classId == null) {
            return null;
        }
        return classId.asSingleFqName();
    }
}