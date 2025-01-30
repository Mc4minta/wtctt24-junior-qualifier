package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RawType.kt */
/* loaded from: classes3.dex */
public final class RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2 extends o implements l<KotlinTypeRefiner, SimpleType> {
    final /* synthetic */ JavaTypeAttributes $attr;
    final /* synthetic */ ClassDescriptor $declaration;
    final /* synthetic */ SimpleType $type;
    final /* synthetic */ RawSubstitution this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2(ClassDescriptor classDescriptor, RawSubstitution rawSubstitution, SimpleType simpleType, JavaTypeAttributes javaTypeAttributes) {
        super(1);
        this.$declaration = classDescriptor;
        this.this$0 = rawSubstitution;
        this.$type = simpleType;
        this.$attr = javaTypeAttributes;
    }

    @Override // kotlin.e0.c.l
    public final SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
        ClassDescriptor findClassAcrossModuleDependencies;
        kotlin.o eraseInflexibleBasedOnClassDescriptor;
        m.g(kotlinTypeRefiner, "kotlinTypeRefiner");
        ClassDescriptor classDescriptor = this.$declaration;
        if (!(classDescriptor instanceof ClassDescriptor)) {
            classDescriptor = null;
        }
        ClassId classId = classDescriptor == null ? null : DescriptorUtilsKt.getClassId(classDescriptor);
        if (classId == null || (findClassAcrossModuleDependencies = kotlinTypeRefiner.findClassAcrossModuleDependencies(classId)) == null || m.c(findClassAcrossModuleDependencies, this.$declaration)) {
            return null;
        }
        eraseInflexibleBasedOnClassDescriptor = this.this$0.eraseInflexibleBasedOnClassDescriptor(this.$type, findClassAcrossModuleDependencies, this.$attr);
        return (SimpleType) eraseInflexibleBasedOnClassDescriptor.c();
    }
}