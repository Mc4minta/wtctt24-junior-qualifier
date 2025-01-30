package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import java.util.Set;
import kotlin.a0.q;
import kotlin.a0.s0;
import kotlin.e0.c.a;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmBuiltInClassDescriptorFactory.kt */
/* loaded from: classes3.dex */
public final class JvmBuiltInClassDescriptorFactory$cloneable$2 extends o implements a<ClassDescriptorImpl> {
    final /* synthetic */ StorageManager $storageManager;
    final /* synthetic */ JvmBuiltInClassDescriptorFactory this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltInClassDescriptorFactory$cloneable$2(JvmBuiltInClassDescriptorFactory jvmBuiltInClassDescriptorFactory, StorageManager storageManager) {
        super(0);
        this.this$0 = jvmBuiltInClassDescriptorFactory;
        this.$storageManager = storageManager;
    }

    @Override // kotlin.e0.c.a
    public final ClassDescriptorImpl invoke() {
        l lVar;
        ModuleDescriptor moduleDescriptor;
        Name name;
        ModuleDescriptor moduleDescriptor2;
        List b2;
        Set<ClassConstructorDescriptor> b3;
        lVar = this.this$0.computeContainingDeclaration;
        moduleDescriptor = this.this$0.moduleDescriptor;
        DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) lVar.invoke(moduleDescriptor);
        name = JvmBuiltInClassDescriptorFactory.CLONEABLE_NAME;
        Modality modality = Modality.ABSTRACT;
        ClassKind classKind = ClassKind.INTERFACE;
        moduleDescriptor2 = this.this$0.moduleDescriptor;
        b2 = q.b(moduleDescriptor2.getBuiltIns().getAnyType());
        ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl(declarationDescriptor, name, modality, classKind, b2, SourceElement.NO_SOURCE, false, this.$storageManager);
        CloneableClassScope cloneableClassScope = new CloneableClassScope(this.$storageManager, classDescriptorImpl);
        b3 = s0.b();
        classDescriptorImpl.initialize(cloneableClassScope, b3, null);
        return classDescriptorImpl;
    }
}