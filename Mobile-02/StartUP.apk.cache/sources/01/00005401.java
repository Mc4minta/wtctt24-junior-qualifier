package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.a0.p;
import kotlin.a0.z;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotFoundClasses.kt */
/* loaded from: classes3.dex */
public final class NotFoundClasses$classes$1 extends o implements l<NotFoundClasses.ClassRequest, ClassDescriptor> {
    final /* synthetic */ NotFoundClasses this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotFoundClasses$classes$1(NotFoundClasses notFoundClasses) {
        super(1);
        this.this$0 = notFoundClasses;
    }

    @Override // kotlin.e0.c.l
    public final ClassDescriptor invoke(NotFoundClasses.ClassRequest dstr$classId$typeParametersCount) {
        List<Integer> Q;
        DeclarationDescriptorWithSource declarationDescriptorWithSource;
        StorageManager storageManager;
        MemoizedFunctionToNotNull memoizedFunctionToNotNull;
        m.g(dstr$classId$typeParametersCount, "$dstr$classId$typeParametersCount");
        ClassId component1 = dstr$classId$typeParametersCount.component1();
        List<Integer> component2 = dstr$classId$typeParametersCount.component2();
        if (!component1.isLocal()) {
            ClassId outerClassId = component1.getOuterClassId();
            if (outerClassId == null) {
                declarationDescriptorWithSource = null;
            } else {
                NotFoundClasses notFoundClasses = this.this$0;
                Q = z.Q(component2, 1);
                declarationDescriptorWithSource = notFoundClasses.getClass(outerClassId, Q);
            }
            if (declarationDescriptorWithSource == null) {
                memoizedFunctionToNotNull = this.this$0.packageFragments;
                FqName packageFqName = component1.getPackageFqName();
                m.f(packageFqName, "classId.packageFqName");
                declarationDescriptorWithSource = (ClassOrPackageFragmentDescriptor) memoizedFunctionToNotNull.invoke(packageFqName);
            }
            DeclarationDescriptorWithSource declarationDescriptorWithSource2 = declarationDescriptorWithSource;
            boolean isNestedClass = component1.isNestedClass();
            storageManager = this.this$0.storageManager;
            Name shortClassName = component1.getShortClassName();
            m.f(shortClassName, "classId.shortClassName");
            Integer num = (Integer) p.a0(component2);
            return new NotFoundClasses.MockClassDescriptor(storageManager, declarationDescriptorWithSource2, shortClassName, isNestedClass, num == null ? 0 : num.intValue());
        }
        throw new UnsupportedOperationException(m.o("Unresolved local class: ", component1));
    }
}