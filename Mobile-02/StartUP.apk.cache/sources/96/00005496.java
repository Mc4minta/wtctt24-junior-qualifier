package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a0.s;
import kotlin.e0.c.a;
import kotlin.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* compiled from: ValueParameterDescriptorImpl.kt */
/* loaded from: classes3.dex */
public class ValueParameterDescriptorImpl extends VariableDescriptorImpl implements ValueParameterDescriptor {
    public static final Companion Companion = new Companion(null);
    private final boolean declaresDefaultValue;
    private final int index;
    private final boolean isCrossinline;
    private final boolean isNoinline;
    private final ValueParameterDescriptor original;
    private final KotlinType varargElementType;

    /* compiled from: ValueParameterDescriptorImpl.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ValueParameterDescriptorImpl createWithDestructuringDeclarations(CallableDescriptor containingDeclaration, ValueParameterDescriptor valueParameterDescriptor, int i2, Annotations annotations, Name name, KotlinType outType, boolean z, boolean z2, boolean z3, KotlinType kotlinType, SourceElement source, a<? extends List<? extends VariableDescriptor>> aVar) {
            m.g(containingDeclaration, "containingDeclaration");
            m.g(annotations, "annotations");
            m.g(name, "name");
            m.g(outType, "outType");
            m.g(source, "source");
            if (aVar == null) {
                return new ValueParameterDescriptorImpl(containingDeclaration, valueParameterDescriptor, i2, annotations, name, outType, z, z2, z3, kotlinType, source);
            }
            return new WithDestructuringDeclaration(containingDeclaration, valueParameterDescriptor, i2, annotations, name, outType, z, z2, z3, kotlinType, source, aVar);
        }
    }

    /* compiled from: ValueParameterDescriptorImpl.kt */
    /* loaded from: classes3.dex */
    public static final class WithDestructuringDeclaration extends ValueParameterDescriptorImpl {
        private final h destructuringVariables$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WithDestructuringDeclaration(CallableDescriptor containingDeclaration, ValueParameterDescriptor valueParameterDescriptor, int i2, Annotations annotations, Name name, KotlinType outType, boolean z, boolean z2, boolean z3, KotlinType kotlinType, SourceElement source, a<? extends List<? extends VariableDescriptor>> destructuringVariables) {
            super(containingDeclaration, valueParameterDescriptor, i2, annotations, name, outType, z, z2, z3, kotlinType, source);
            h b2;
            m.g(containingDeclaration, "containingDeclaration");
            m.g(annotations, "annotations");
            m.g(name, "name");
            m.g(outType, "outType");
            m.g(source, "source");
            m.g(destructuringVariables, "destructuringVariables");
            b2 = k.b(destructuringVariables);
            this.destructuringVariables$delegate = b2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
        public ValueParameterDescriptor copy(CallableDescriptor newOwner, Name newName, int i2) {
            m.g(newOwner, "newOwner");
            m.g(newName, "newName");
            Annotations annotations = getAnnotations();
            m.f(annotations, "annotations");
            KotlinType type = getType();
            m.f(type, "type");
            boolean declaresDefaultValue = declaresDefaultValue();
            boolean isCrossinline = isCrossinline();
            boolean isNoinline = isNoinline();
            KotlinType varargElementType = getVarargElementType();
            SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
            m.f(NO_SOURCE, "NO_SOURCE");
            return new WithDestructuringDeclaration(newOwner, null, i2, annotations, newName, type, declaresDefaultValue, isCrossinline, isNoinline, varargElementType, NO_SOURCE, new ValueParameterDescriptorImpl$WithDestructuringDeclaration$copy$1(this));
        }

        public final List<VariableDescriptor> getDestructuringVariables() {
            return (List) this.destructuringVariables$delegate.getValue();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ValueParameterDescriptorImpl(CallableDescriptor containingDeclaration, ValueParameterDescriptor valueParameterDescriptor, int i2, Annotations annotations, Name name, KotlinType outType, boolean z, boolean z2, boolean z3, KotlinType kotlinType, SourceElement source) {
        super(containingDeclaration, annotations, name, outType, source);
        m.g(containingDeclaration, "containingDeclaration");
        m.g(annotations, "annotations");
        m.g(name, "name");
        m.g(outType, "outType");
        m.g(source, "source");
        this.index = i2;
        this.declaresDefaultValue = z;
        this.isCrossinline = z2;
        this.isNoinline = z3;
        this.varargElementType = kotlinType;
        this.original = valueParameterDescriptor == null ? this : valueParameterDescriptor;
    }

    public static final ValueParameterDescriptorImpl createWithDestructuringDeclarations(CallableDescriptor callableDescriptor, ValueParameterDescriptor valueParameterDescriptor, int i2, Annotations annotations, Name name, KotlinType kotlinType, boolean z, boolean z2, boolean z3, KotlinType kotlinType2, SourceElement sourceElement, a<? extends List<? extends VariableDescriptor>> aVar) {
        return Companion.createWithDestructuringDeclarations(callableDescriptor, valueParameterDescriptor, i2, annotations, name, kotlinType, z, z2, z3, kotlinType2, sourceElement, aVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> visitor, D d2) {
        m.g(visitor, "visitor");
        return visitor.visitValueParameterDescriptor(this, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public ValueParameterDescriptor copy(CallableDescriptor newOwner, Name newName, int i2) {
        m.g(newOwner, "newOwner");
        m.g(newName, "newName");
        Annotations annotations = getAnnotations();
        m.f(annotations, "annotations");
        KotlinType type = getType();
        m.f(type, "type");
        boolean declaresDefaultValue = declaresDefaultValue();
        boolean isCrossinline = isCrossinline();
        boolean isNoinline = isNoinline();
        KotlinType varargElementType = getVarargElementType();
        SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
        m.f(NO_SOURCE, "NO_SOURCE");
        return new ValueParameterDescriptorImpl(newOwner, null, i2, annotations, newName, type, declaresDefaultValue, isCrossinline, isNoinline, varargElementType, NO_SOURCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public boolean declaresDefaultValue() {
        return this.declaresDefaultValue && ((CallableMemberDescriptor) getContainingDeclaration()).getKind().isReal();
    }

    public Void getCompileTimeInitializer() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    /* renamed from: getCompileTimeInitializer  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ ConstantValue mo2208getCompileTimeInitializer() {
        return (ConstantValue) getCompileTimeInitializer();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public int getIndex() {
        return this.index;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public Collection<ValueParameterDescriptor> getOverriddenDescriptors() {
        int r;
        Collection<? extends CallableDescriptor> overriddenDescriptors = getContainingDeclaration().getOverriddenDescriptors();
        m.f(overriddenDescriptors, "containingDeclaration.overriddenDescriptors");
        r = s.r(overriddenDescriptors, 10);
        ArrayList arrayList = new ArrayList(r);
        for (CallableDescriptor callableDescriptor : overriddenDescriptors) {
            arrayList.add(callableDescriptor.getValueParameters().get(getIndex()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public KotlinType getVarargElementType() {
        return this.varargElementType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility LOCAL = DescriptorVisibilities.LOCAL;
        m.f(LOCAL, "LOCAL");
        return LOCAL;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public boolean isCrossinline() {
        return this.isCrossinline;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isLateInit() {
        return ValueParameterDescriptor.DefaultImpls.isLateInit(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public boolean isNoinline() {
        return this.isNoinline;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isVar() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public CallableDescriptor getContainingDeclaration() {
        return (CallableDescriptor) super.getContainingDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public ValueParameterDescriptor substitute(TypeSubstitutor substitutor) {
        m.g(substitutor, "substitutor");
        if (substitutor.isEmpty()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public ValueParameterDescriptor getOriginal() {
        ValueParameterDescriptor valueParameterDescriptor = this.original;
        return valueParameterDescriptor == this ? this : valueParameterDescriptor.getOriginal();
    }
}