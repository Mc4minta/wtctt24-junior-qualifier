package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: CloneableClassScope.kt */
/* loaded from: classes3.dex */
public final class CloneableClassScope extends GivenFunctionsMemberScope {
    private static final Name CLONE_NAME;
    public static final Companion Companion = new Companion(null);

    /* compiled from: CloneableClassScope.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Name getCLONE_NAME() {
            return CloneableClassScope.CLONE_NAME;
        }
    }

    static {
        Name identifier = Name.identifier("clone");
        m.f(identifier, "identifier(\"clone\")");
        CLONE_NAME = identifier;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloneableClassScope(StorageManager storageManager, ClassDescriptor containingClass) {
        super(storageManager, containingClass);
        m.g(storageManager, "storageManager");
        m.g(containingClass, "containingClass");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope
    public List<FunctionDescriptor> computeDeclaredFunctions() {
        List<? extends TypeParameterDescriptor> g2;
        List<ValueParameterDescriptor> g3;
        List<FunctionDescriptor> b2;
        SimpleFunctionDescriptorImpl create = SimpleFunctionDescriptorImpl.create(getContainingClass(), Annotations.Companion.getEMPTY(), Companion.getCLONE_NAME(), CallableMemberDescriptor.Kind.DECLARATION, SourceElement.NO_SOURCE);
        ReceiverParameterDescriptor thisAsReceiverParameter = getContainingClass().getThisAsReceiverParameter();
        g2 = r.g();
        g3 = r.g();
        create.initialize((ReceiverParameterDescriptor) null, thisAsReceiverParameter, g2, g3, (KotlinType) DescriptorUtilsKt.getBuiltIns(getContainingClass()).getAnyType(), Modality.OPEN, DescriptorVisibilities.PROTECTED);
        b2 = q.b(create);
        return b2;
    }
}