package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.List;
import kotlin.a0.r;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticScopeForKotlinEnum.kt */
/* loaded from: classes3.dex */
public final class StaticScopeForKotlinEnum$functions$2 extends o implements a<List<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ StaticScopeForKotlinEnum this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticScopeForKotlinEnum$functions$2(StaticScopeForKotlinEnum staticScopeForKotlinEnum) {
        super(0);
        this.this$0 = staticScopeForKotlinEnum;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends SimpleFunctionDescriptor> invoke() {
        ClassDescriptor classDescriptor;
        ClassDescriptor classDescriptor2;
        List<? extends SimpleFunctionDescriptor> j2;
        classDescriptor = this.this$0.containingClass;
        classDescriptor2 = this.this$0.containingClass;
        j2 = r.j(DescriptorFactory.createEnumValueOfMethod(classDescriptor), DescriptorFactory.createEnumValuesMethod(classDescriptor2));
        return j2;
    }
}