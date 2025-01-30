package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a0.h0;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.a0.p;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.i0.c;
import kotlin.i0.f;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.BooleanValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.CharValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.DoubleValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.FloatValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: AnnotationDeserializer.kt */
/* loaded from: classes3.dex */
public final class AnnotationDeserializer {
    private final ModuleDescriptor module;
    private final NotFoundClasses notFoundClasses;

    /* compiled from: AnnotationDeserializer.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProtoBuf.Annotation.Argument.Value.Type.values().length];
            iArr[ProtoBuf.Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.CHAR.ordinal()] = 2;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.SHORT.ordinal()] = 3;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.INT.ordinal()] = 4;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.LONG.ordinal()] = 5;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.FLOAT.ordinal()] = 6;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.DOUBLE.ordinal()] = 7;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN.ordinal()] = 8;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.STRING.ordinal()] = 9;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.CLASS.ordinal()] = 10;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.ENUM.ordinal()] = 11;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION.ordinal()] = 12;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.ARRAY.ordinal()] = 13;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AnnotationDeserializer(ModuleDescriptor module, NotFoundClasses notFoundClasses) {
        m.g(module, "module");
        m.g(notFoundClasses, "notFoundClasses");
        this.module = module;
        this.notFoundClasses = notFoundClasses;
    }

    private final boolean doesValueConformToExpectedType(ConstantValue<?> constantValue, KotlinType kotlinType, ProtoBuf.Annotation.Argument.Value value) {
        c h2;
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        int i2 = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i2 == 10) {
            ClassifierDescriptor mo2214getDeclarationDescriptor = kotlinType.getConstructor().mo2214getDeclarationDescriptor();
            ClassDescriptor classDescriptor = mo2214getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) mo2214getDeclarationDescriptor : null;
            if (classDescriptor != null && !KotlinBuiltIns.isKClass(classDescriptor)) {
                return false;
            }
        } else if (i2 != 13) {
            return m.c(constantValue.getType(this.module), kotlinType);
        } else {
            if ((constantValue instanceof ArrayValue) && ((ArrayValue) constantValue).getValue().size() == value.getArrayElementList().size()) {
                KotlinType arrayElementType = getBuiltIns().getArrayElementType(kotlinType);
                m.f(arrayElementType, "builtIns.getArrayElementType(expectedType)");
                ArrayValue arrayValue = (ArrayValue) constantValue;
                h2 = r.h(arrayValue.getValue());
                if (!(h2 instanceof Collection) || !((Collection) h2).isEmpty()) {
                    Iterator<Integer> it = h2.iterator();
                    while (it.hasNext()) {
                        int c2 = ((h0) it).c();
                        ProtoBuf.Annotation.Argument.Value arrayElement = value.getArrayElement(c2);
                        m.f(arrayElement, "value.getArrayElement(i)");
                        if (!doesValueConformToExpectedType(arrayValue.getValue().get(c2), arrayElementType, arrayElement)) {
                            return false;
                        }
                    }
                }
            } else {
                throw new IllegalStateException(m.o("Deserialized ArrayValue should have the same number of elements as the original array value: ", constantValue).toString());
            }
        }
        return true;
    }

    private final KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    private final o<Name, ConstantValue<?>> resolveArgument(ProtoBuf.Annotation.Argument argument, Map<Name, ? extends ValueParameterDescriptor> map, NameResolver nameResolver) {
        ValueParameterDescriptor valueParameterDescriptor = map.get(NameResolverUtilKt.getName(nameResolver, argument.getNameId()));
        if (valueParameterDescriptor == null) {
            return null;
        }
        Name name = NameResolverUtilKt.getName(nameResolver, argument.getNameId());
        KotlinType type = valueParameterDescriptor.getType();
        m.f(type, "parameter.type");
        ProtoBuf.Annotation.Argument.Value value = argument.getValue();
        m.f(value, "proto.value");
        return new o<>(name, resolveValueAndCheckExpectedType(type, value, nameResolver));
    }

    private final ClassDescriptor resolveClass(ClassId classId) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, classId, this.notFoundClasses);
    }

    private final ConstantValue<?> resolveValueAndCheckExpectedType(KotlinType kotlinType, ProtoBuf.Annotation.Argument.Value value, NameResolver nameResolver) {
        ConstantValue<?> resolveValue = resolveValue(kotlinType, value, nameResolver);
        if (!doesValueConformToExpectedType(resolveValue, kotlinType, value)) {
            resolveValue = null;
        }
        if (resolveValue == null) {
            ErrorValue.Companion companion = ErrorValue.Companion;
            return companion.create("Unexpected argument value: actual type " + value.getType() + " != expected type " + kotlinType);
        }
        return resolveValue;
    }

    public final AnnotationDescriptor deserializeAnnotation(ProtoBuf.Annotation proto, NameResolver nameResolver) {
        Map i2;
        int r;
        int d2;
        int b2;
        m.g(proto, "proto");
        m.g(nameResolver, "nameResolver");
        ClassDescriptor resolveClass = resolveClass(NameResolverUtilKt.getClassId(nameResolver, proto.getId()));
        i2 = m0.i();
        if (proto.getArgumentCount() != 0 && !ErrorUtils.isError(resolveClass) && DescriptorUtils.isAnnotationClass(resolveClass)) {
            Collection<ClassConstructorDescriptor> constructors = resolveClass.getConstructors();
            m.f(constructors, "annotationClass.constructors");
            ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) p.y0(constructors);
            if (classConstructorDescriptor != null) {
                List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
                m.f(valueParameters, "constructor.valueParameters");
                r = s.r(valueParameters, 10);
                d2 = l0.d(r);
                b2 = f.b(d2, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
                for (Object obj : valueParameters) {
                    linkedHashMap.put(((ValueParameterDescriptor) obj).getName(), obj);
                }
                List<ProtoBuf.Annotation.Argument> argumentList = proto.getArgumentList();
                m.f(argumentList, "proto.argumentList");
                ArrayList arrayList = new ArrayList();
                for (ProtoBuf.Annotation.Argument it : argumentList) {
                    m.f(it, "it");
                    o<Name, ConstantValue<?>> resolveArgument = resolveArgument(it, linkedHashMap, nameResolver);
                    if (resolveArgument != null) {
                        arrayList.add(resolveArgument);
                    }
                }
                i2 = m0.r(arrayList);
            }
        }
        return new AnnotationDescriptorImpl(resolveClass.getDefaultType(), i2, SourceElement.NO_SOURCE);
    }

    public final ConstantValue<?> resolveValue(KotlinType expectedType, ProtoBuf.Annotation.Argument.Value value, NameResolver nameResolver) {
        ConstantValue<?> byteValue;
        int r;
        m.g(expectedType, "expectedType");
        m.g(value, "value");
        m.g(nameResolver, "nameResolver");
        Boolean bool = Flags.IS_UNSIGNED.get(value.getFlags());
        m.f(bool, "IS_UNSIGNED.get(value.flags)");
        boolean booleanValue = bool.booleanValue();
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                byte intValue = (byte) value.getIntValue();
                if (booleanValue) {
                    byteValue = new UByteValue(intValue);
                    break;
                } else {
                    byteValue = new ByteValue(intValue);
                    break;
                }
            case 2:
                return new CharValue((char) value.getIntValue());
            case 3:
                short intValue2 = (short) value.getIntValue();
                if (booleanValue) {
                    byteValue = new UShortValue(intValue2);
                    break;
                } else {
                    byteValue = new ShortValue(intValue2);
                    break;
                }
            case 4:
                int intValue3 = (int) value.getIntValue();
                if (booleanValue) {
                    byteValue = new UIntValue(intValue3);
                    break;
                } else {
                    byteValue = new IntValue(intValue3);
                    break;
                }
            case 5:
                long intValue4 = value.getIntValue();
                return booleanValue ? new ULongValue(intValue4) : new LongValue(intValue4);
            case 6:
                return new FloatValue(value.getFloatValue());
            case 7:
                return new DoubleValue(value.getDoubleValue());
            case 8:
                return new BooleanValue(value.getIntValue() != 0);
            case 9:
                return new StringValue(nameResolver.getString(value.getStringValue()));
            case 10:
                return new KClassValue(NameResolverUtilKt.getClassId(nameResolver, value.getClassId()), value.getArrayDimensionCount());
            case 11:
                return new EnumValue(NameResolverUtilKt.getClassId(nameResolver, value.getClassId()), NameResolverUtilKt.getName(nameResolver, value.getEnumValueId()));
            case 12:
                ProtoBuf.Annotation annotation = value.getAnnotation();
                m.f(annotation, "value.annotation");
                return new AnnotationValue(deserializeAnnotation(annotation, nameResolver));
            case 13:
                ConstantValueFactory constantValueFactory = ConstantValueFactory.INSTANCE;
                List<ProtoBuf.Annotation.Argument.Value> arrayElementList = value.getArrayElementList();
                m.f(arrayElementList, "value.arrayElementList");
                r = s.r(arrayElementList, 10);
                ArrayList arrayList = new ArrayList(r);
                for (ProtoBuf.Annotation.Argument.Value it : arrayElementList) {
                    SimpleType anyType = getBuiltIns().getAnyType();
                    m.f(anyType, "builtIns.anyType");
                    m.f(it, "it");
                    arrayList.add(resolveValue(anyType, it, nameResolver));
                }
                return constantValueFactory.createArrayValue(arrayList, expectedType);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + value.getType() + " (expected " + expectedType + ')').toString());
        }
        return byteValue;
    }
}