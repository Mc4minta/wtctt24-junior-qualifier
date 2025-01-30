package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.List;
import kotlin.a0.z;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaScope.kt */
/* loaded from: classes3.dex */
public final class LazyJavaScope$properties$1 extends o implements l<Name, List<? extends PropertyDescriptor>> {
    final /* synthetic */ LazyJavaScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaScope$properties$1(LazyJavaScope lazyJavaScope) {
        super(1);
        this.this$0 = lazyJavaScope;
    }

    @Override // kotlin.e0.c.l
    public final List<PropertyDescriptor> invoke(Name name) {
        MemoizedFunctionToNullable memoizedFunctionToNullable;
        List<PropertyDescriptor> I0;
        List<PropertyDescriptor> I02;
        m.g(name, "name");
        ArrayList arrayList = new ArrayList();
        memoizedFunctionToNullable = this.this$0.declaredField;
        CollectionsKt.addIfNotNull(arrayList, memoizedFunctionToNullable.invoke(name));
        this.this$0.computeNonDeclaredProperties(name, arrayList);
        if (DescriptorUtils.isAnnotationClass(this.this$0.getOwnerDescriptor())) {
            I02 = z.I0(arrayList);
            return I02;
        }
        I0 = z.I0(this.this$0.getC().getComponents().getSignatureEnhancement().enhanceSignatures(this.this$0.getC(), arrayList));
        return I0;
    }
}