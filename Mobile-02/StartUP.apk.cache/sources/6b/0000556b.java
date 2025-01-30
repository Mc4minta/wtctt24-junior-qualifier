package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Map;
import java.util.Set;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaClassMemberScope.kt */
/* loaded from: classes3.dex */
public final class LazyJavaClassMemberScope$nestedClasses$1 extends o implements l<Name, ClassDescriptorBase> {
    final /* synthetic */ LazyJavaResolverContext $c;
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$nestedClasses$1(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
        super(1);
        this.this$0 = lazyJavaClassMemberScope;
        this.$c = lazyJavaResolverContext;
    }

    @Override // kotlin.e0.c.l
    public final ClassDescriptorBase invoke(Name name) {
        NotNullLazyValue notNullLazyValue;
        JavaClass javaClass;
        NotNullLazyValue notNullLazyValue2;
        m.g(name, "name");
        notNullLazyValue = this.this$0.nestedClassIndex;
        if (!((Set) notNullLazyValue.invoke()).contains(name)) {
            notNullLazyValue2 = this.this$0.enumEntryIndex;
            JavaField javaField = (JavaField) ((Map) notNullLazyValue2.invoke()).get(name);
            if (javaField != null) {
                return EnumEntrySyntheticClassDescriptor.create(this.$c.getStorageManager(), this.this$0.getOwnerDescriptor(), name, this.$c.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1(this.this$0)), LazyJavaAnnotationsKt.resolveAnnotations(this.$c, javaField), this.$c.getComponents().getSourceElementFactory().source(javaField));
            }
            return null;
        }
        JavaClassFinder finder = this.$c.getComponents().getFinder();
        ClassId classId = DescriptorUtilsKt.getClassId(this.this$0.getOwnerDescriptor());
        m.e(classId);
        ClassId createNestedClassId = classId.createNestedClassId(name);
        m.f(createNestedClassId, "ownerDescriptor.classId!!.createNestedClassId(name)");
        javaClass = this.this$0.jClass;
        JavaClass findClass = finder.findClass(new JavaClassFinder.Request(createNestedClassId, null, javaClass, 2, null));
        if (findClass == null) {
            return null;
        }
        LazyJavaResolverContext lazyJavaResolverContext = this.$c;
        LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(lazyJavaResolverContext, this.this$0.getOwnerDescriptor(), findClass, null, 8, null);
        lazyJavaResolverContext.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
        return lazyJavaClassDescriptor;
    }
}