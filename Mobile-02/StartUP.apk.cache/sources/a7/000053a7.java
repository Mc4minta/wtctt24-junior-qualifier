package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a0.e0;
import kotlin.a0.p;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;

/* compiled from: FunctionInvokeDescriptor.kt */
/* loaded from: classes3.dex */
public final class FunctionInvokeDescriptor extends SimpleFunctionDescriptorImpl {
    public static final Factory Factory = new Factory(null);

    /* compiled from: FunctionInvokeDescriptor.kt */
    /* loaded from: classes3.dex */
    public static final class Factory {
        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ValueParameterDescriptor createValueParameter(FunctionInvokeDescriptor functionInvokeDescriptor, int i2, TypeParameterDescriptor typeParameterDescriptor) {
            String lowerCase;
            String asString = typeParameterDescriptor.getName().asString();
            m.f(asString, "typeParameter.name.asString()");
            if (m.c(asString, "T")) {
                lowerCase = "instance";
            } else if (m.c(asString, "E")) {
                lowerCase = "receiver";
            } else {
                lowerCase = asString.toLowerCase();
                m.f(lowerCase, "(this as java.lang.String).toLowerCase()");
            }
            Annotations empty = Annotations.Companion.getEMPTY();
            Name identifier = Name.identifier(lowerCase);
            m.f(identifier, "identifier(name)");
            SimpleType defaultType = typeParameterDescriptor.getDefaultType();
            m.f(defaultType, "typeParameter.defaultType");
            SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
            m.f(NO_SOURCE, "NO_SOURCE");
            return new ValueParameterDescriptorImpl(functionInvokeDescriptor, null, i2, empty, identifier, defaultType, false, false, false, null, NO_SOURCE);
        }

        public final FunctionInvokeDescriptor create(FunctionClassDescriptor functionClass, boolean z) {
            List<? extends TypeParameterDescriptor> g2;
            Iterable<e0> P0;
            int r;
            m.g(functionClass, "functionClass");
            List<TypeParameterDescriptor> declaredTypeParameters = functionClass.getDeclaredTypeParameters();
            FunctionInvokeDescriptor functionInvokeDescriptor = new FunctionInvokeDescriptor(functionClass, null, CallableMemberDescriptor.Kind.DECLARATION, z, null);
            ReceiverParameterDescriptor thisAsReceiverParameter = functionClass.getThisAsReceiverParameter();
            g2 = r.g();
            ArrayList arrayList = new ArrayList();
            for (Object obj : declaredTypeParameters) {
                if (!(((TypeParameterDescriptor) obj).getVariance() == Variance.IN_VARIANCE)) {
                    break;
                }
                arrayList.add(obj);
            }
            P0 = z.P0(arrayList);
            r = s.r(P0, 10);
            ArrayList arrayList2 = new ArrayList(r);
            for (e0 e0Var : P0) {
                arrayList2.add(createValueParameter(functionInvokeDescriptor, e0Var.c(), (TypeParameterDescriptor) e0Var.d()));
            }
            functionInvokeDescriptor.initialize((ReceiverParameterDescriptor) null, thisAsReceiverParameter, g2, (List<ValueParameterDescriptor>) arrayList2, (KotlinType) ((TypeParameterDescriptor) p.j0(declaredTypeParameters)).getDefaultType(), Modality.ABSTRACT, DescriptorVisibilities.PUBLIC);
            functionInvokeDescriptor.setHasSynthesizedParameterNames(true);
            return functionInvokeDescriptor;
        }
    }

    private FunctionInvokeDescriptor(DeclarationDescriptor declarationDescriptor, FunctionInvokeDescriptor functionInvokeDescriptor, CallableMemberDescriptor.Kind kind, boolean z) {
        super(declarationDescriptor, functionInvokeDescriptor, Annotations.Companion.getEMPTY(), OperatorNameConventions.INVOKE, kind, SourceElement.NO_SOURCE);
        setOperator(true);
        setSuspend(z);
        setHasStableParameterNames(false);
    }

    public /* synthetic */ FunctionInvokeDescriptor(DeclarationDescriptor declarationDescriptor, FunctionInvokeDescriptor functionInvokeDescriptor, CallableMemberDescriptor.Kind kind, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(declarationDescriptor, functionInvokeDescriptor, kind, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration] */
    private final FunctionDescriptor replaceParameterNames(List<Name> list) {
        int r;
        boolean z;
        Name name;
        int size = getValueParameters().size() - list.size();
        boolean z2 = true;
        List<ValueParameterDescriptor> valueParameters = getValueParameters();
        m.f(valueParameters, "valueParameters");
        r = s.r(valueParameters, 10);
        ArrayList arrayList = new ArrayList(r);
        for (ValueParameterDescriptor valueParameterDescriptor : valueParameters) {
            Name name2 = valueParameterDescriptor.getName();
            m.f(name2, "it.name");
            int index = valueParameterDescriptor.getIndex();
            int i2 = index - size;
            if (i2 >= 0 && (name = list.get(i2)) != null) {
                name2 = name;
            }
            arrayList.add(valueParameterDescriptor.copy(this, name2, index));
        }
        FunctionDescriptorImpl.CopyConfiguration newCopyBuilder = newCopyBuilder(TypeSubstitutor.EMPTY);
        if (!list.isEmpty()) {
            for (Name name3 : list) {
                if (name3 == null) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
        }
        z2 = false;
        ?? original = newCopyBuilder.setHasSynthesizedParameterNames(z2).setValueParameters2((List<ValueParameterDescriptor>) arrayList).setOriginal((CallableMemberDescriptor) getOriginal());
        m.f(original, "newCopyBuilder(TypeSubstitutor.EMPTY)\n                .setHasSynthesizedParameterNames(parameterNames.any { it == null })\n                .setValueParameters(newValueParameters)\n                .setOriginal(original)");
        FunctionDescriptor doSubstitute = super.doSubstitute(original);
        m.e(doSubstitute);
        return doSubstitute;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor newOwner, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.Kind kind, Name name, Annotations annotations, SourceElement source) {
        m.g(newOwner, "newOwner");
        m.g(kind, "kind");
        m.g(annotations, "annotations");
        m.g(source, "source");
        return new FunctionInvokeDescriptor(newOwner, (FunctionInvokeDescriptor) functionDescriptor, kind, isSuspend());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public FunctionDescriptor doSubstitute(FunctionDescriptorImpl.CopyConfiguration configuration) {
        boolean z;
        int r;
        m.g(configuration, "configuration");
        FunctionInvokeDescriptor functionInvokeDescriptor = (FunctionInvokeDescriptor) super.doSubstitute(configuration);
        if (functionInvokeDescriptor == null) {
            return null;
        }
        List<ValueParameterDescriptor> valueParameters = functionInvokeDescriptor.getValueParameters();
        m.f(valueParameters, "substituted.valueParameters");
        boolean z2 = false;
        if (!(valueParameters instanceof Collection) || !valueParameters.isEmpty()) {
            for (ValueParameterDescriptor valueParameterDescriptor : valueParameters) {
                KotlinType type = valueParameterDescriptor.getType();
                m.f(type, "it.type");
                if (FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type) != null) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
        }
        z2 = true;
        if (z2) {
            return functionInvokeDescriptor;
        }
        List<ValueParameterDescriptor> valueParameters2 = functionInvokeDescriptor.getValueParameters();
        m.f(valueParameters2, "substituted.valueParameters");
        r = s.r(valueParameters2, 10);
        ArrayList arrayList = new ArrayList(r);
        for (ValueParameterDescriptor valueParameterDescriptor2 : valueParameters2) {
            KotlinType type2 = valueParameterDescriptor2.getType();
            m.f(type2, "it.type");
            arrayList.add(FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type2));
        }
        return functionInvokeDescriptor.replaceParameterNames(arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isTailrec() {
        return false;
    }
}