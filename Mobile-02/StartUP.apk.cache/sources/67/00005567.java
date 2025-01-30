package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaClassMemberScope.kt */
/* loaded from: classes3.dex */
public final class LazyJavaClassMemberScope$constructors$1 extends o implements a<List<? extends ClassConstructorDescriptor>> {
    final /* synthetic */ LazyJavaResolverContext $c;
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$constructors$1(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
        super(0);
        this.this$0 = lazyJavaClassMemberScope;
        this.$c = lazyJavaResolverContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    @Override // kotlin.e0.c.a
    public final List<? extends ClassConstructorDescriptor> invoke() {
        JavaClass javaClass;
        JavaClass javaClass2;
        List<? extends ClassConstructorDescriptor> I0;
        ClassConstructorDescriptor createDefaultConstructor;
        ?? k2;
        ClassConstructorDescriptor createDefaultRecordConstructor;
        JavaClass javaClass3;
        JavaClassConstructorDescriptor resolveConstructor;
        javaClass = this.this$0.jClass;
        Collection<JavaConstructor> constructors = javaClass.getConstructors();
        ArrayList<ClassConstructorDescriptor> arrayList = new ArrayList(constructors.size());
        for (JavaConstructor javaConstructor : constructors) {
            resolveConstructor = this.this$0.resolveConstructor(javaConstructor);
            arrayList.add(resolveConstructor);
        }
        javaClass2 = this.this$0.jClass;
        if (javaClass2.isRecord()) {
            createDefaultRecordConstructor = this.this$0.createDefaultRecordConstructor();
            boolean z = false;
            String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(createDefaultRecordConstructor, false, false, 2, null);
            if (!arrayList.isEmpty()) {
                for (ClassConstructorDescriptor classConstructorDescriptor : arrayList) {
                    if (m.c(MethodSignatureMappingKt.computeJvmDescriptor$default(classConstructorDescriptor, false, false, 2, null), computeJvmDescriptor$default)) {
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                arrayList.add(createDefaultRecordConstructor);
                JavaResolverCache javaResolverCache = this.$c.getComponents().getJavaResolverCache();
                javaClass3 = this.this$0.jClass;
                javaResolverCache.recordConstructor(javaClass3, createDefaultRecordConstructor);
            }
        }
        SignatureEnhancement signatureEnhancement = this.$c.getComponents().getSignatureEnhancement();
        LazyJavaResolverContext lazyJavaResolverContext = this.$c;
        LazyJavaClassMemberScope lazyJavaClassMemberScope = this.this$0;
        boolean isEmpty = arrayList.isEmpty();
        ArrayList arrayList2 = arrayList;
        if (isEmpty) {
            createDefaultConstructor = lazyJavaClassMemberScope.createDefaultConstructor();
            k2 = r.k(createDefaultConstructor);
            arrayList2 = k2;
        }
        I0 = z.I0(signatureEnhancement.enhanceSignatures(lazyJavaResolverContext, arrayList2));
        return I0;
    }
}