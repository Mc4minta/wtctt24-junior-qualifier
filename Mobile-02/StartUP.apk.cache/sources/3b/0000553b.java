package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: util.kt */
/* loaded from: classes3.dex */
public final class UtilKt {
    public static final List<ValueParameterDescriptor> copyValueParameters(Collection<ValueParameterData> newValueParametersTypes, Collection<? extends ValueParameterDescriptor> oldValueParameters, CallableDescriptor newOwner) {
        List<o> Q0;
        int r;
        m.g(newValueParametersTypes, "newValueParametersTypes");
        m.g(oldValueParameters, "oldValueParameters");
        m.g(newOwner, "newOwner");
        newValueParametersTypes.size();
        oldValueParameters.size();
        Q0 = z.Q0(newValueParametersTypes, oldValueParameters);
        r = s.r(Q0, 10);
        ArrayList arrayList = new ArrayList(r);
        for (o oVar : Q0) {
            ValueParameterData valueParameterData = (ValueParameterData) oVar.a();
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) oVar.b();
            int index = valueParameterDescriptor.getIndex();
            Annotations annotations = valueParameterDescriptor.getAnnotations();
            Name name = valueParameterDescriptor.getName();
            m.f(name, "oldParameter.name");
            KotlinType type = valueParameterData.getType();
            boolean hasDefaultValue = valueParameterData.getHasDefaultValue();
            boolean isCrossinline = valueParameterDescriptor.isCrossinline();
            boolean isNoinline = valueParameterDescriptor.isNoinline();
            KotlinType arrayElementType = valueParameterDescriptor.getVarargElementType() != null ? DescriptorUtilsKt.getModule(newOwner).getBuiltIns().getArrayElementType(valueParameterData.getType()) : null;
            SourceElement source = valueParameterDescriptor.getSource();
            m.f(source, "oldParameter.source");
            arrayList.add(new ValueParameterDescriptorImpl(newOwner, null, index, annotations, name, type, hasDefaultValue, isCrossinline, isNoinline, arrayElementType, source));
        }
        return arrayList;
    }

    public static final AnnotationDefaultValue getDefaultValueFromAnnotation(ValueParameterDescriptor valueParameterDescriptor) {
        ConstantValue<?> firstArgument;
        StringValue stringValue;
        String value;
        m.g(valueParameterDescriptor, "<this>");
        Annotations annotations = valueParameterDescriptor.getAnnotations();
        FqName DEFAULT_VALUE_FQ_NAME = JvmAnnotationNames.DEFAULT_VALUE_FQ_NAME;
        m.f(DEFAULT_VALUE_FQ_NAME, "DEFAULT_VALUE_FQ_NAME");
        AnnotationDescriptor mo2207findAnnotation = annotations.mo2207findAnnotation(DEFAULT_VALUE_FQ_NAME);
        if (mo2207findAnnotation == null || (firstArgument = DescriptorUtilsKt.firstArgument(mo2207findAnnotation)) == null) {
            stringValue = null;
        } else {
            if (!(firstArgument instanceof StringValue)) {
                firstArgument = null;
            }
            stringValue = (StringValue) firstArgument;
        }
        if (stringValue == null || (value = stringValue.getValue()) == null) {
            Annotations annotations2 = valueParameterDescriptor.getAnnotations();
            FqName DEFAULT_NULL_FQ_NAME = JvmAnnotationNames.DEFAULT_NULL_FQ_NAME;
            m.f(DEFAULT_NULL_FQ_NAME, "DEFAULT_NULL_FQ_NAME");
            if (annotations2.hasAnnotation(DEFAULT_NULL_FQ_NAME)) {
                return NullDefaultValue.INSTANCE;
            }
            return null;
        }
        return new StringDefaultValue(value);
    }

    public static final LazyJavaStaticClassScope getParentJavaStaticClassScope(ClassDescriptor classDescriptor) {
        m.g(classDescriptor, "<this>");
        ClassDescriptor superClassNotAny = DescriptorUtilsKt.getSuperClassNotAny(classDescriptor);
        if (superClassNotAny == null) {
            return null;
        }
        MemberScope staticScope = superClassNotAny.getStaticScope();
        LazyJavaStaticClassScope lazyJavaStaticClassScope = staticScope instanceof LazyJavaStaticClassScope ? (LazyJavaStaticClassScope) staticScope : null;
        return lazyJavaStaticClassScope == null ? getParentJavaStaticClassScope(superClassNotAny) : lazyJavaStaticClassScope;
    }
}