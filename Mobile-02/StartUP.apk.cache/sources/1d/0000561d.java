package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.m;
import kotlin.l0.y;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.spongycastle.pqc.math.linearalgebra.Matrix;

/* compiled from: methodSignatureMapping.kt */
/* loaded from: classes3.dex */
final class JvmTypeFactoryImpl implements JvmTypeFactory<JvmType> {
    public static final JvmTypeFactoryImpl INSTANCE = new JvmTypeFactoryImpl();

    /* compiled from: methodSignatureMapping.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PrimitiveType.valuesCustom().length];
            iArr[PrimitiveType.BOOLEAN.ordinal()] = 1;
            iArr[PrimitiveType.CHAR.ordinal()] = 2;
            iArr[PrimitiveType.BYTE.ordinal()] = 3;
            iArr[PrimitiveType.SHORT.ordinal()] = 4;
            iArr[PrimitiveType.INT.ordinal()] = 5;
            iArr[PrimitiveType.FLOAT.ordinal()] = 6;
            iArr[PrimitiveType.LONG.ordinal()] = 7;
            iArr[PrimitiveType.DOUBLE.ordinal()] = 8;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private JvmTypeFactoryImpl() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public JvmType boxType(JvmType possiblyPrimitiveType) {
        m.g(possiblyPrimitiveType, "possiblyPrimitiveType");
        if (possiblyPrimitiveType instanceof JvmType.Primitive) {
            JvmType.Primitive primitive = (JvmType.Primitive) possiblyPrimitiveType;
            if (primitive.getJvmPrimitiveType() != null) {
                String internalName = JvmClassName.byFqNameWithoutInnerClasses(primitive.getJvmPrimitiveType().getWrapperFqName()).getInternalName();
                m.f(internalName, "byFqNameWithoutInnerClasses(possiblyPrimitiveType.jvmPrimitiveType.wrapperFqName).internalName");
                return createObjectType(internalName);
            }
            return possiblyPrimitiveType;
        }
        return possiblyPrimitiveType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public JvmType createFromString(String representation) {
        JvmPrimitiveType jvmPrimitiveType;
        JvmType object;
        m.g(representation, "representation");
        representation.length();
        char charAt = representation.charAt(0);
        JvmPrimitiveType[] values = JvmPrimitiveType.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                jvmPrimitiveType = null;
                break;
            }
            jvmPrimitiveType = values[i2];
            if (jvmPrimitiveType.getDesc().charAt(0) == charAt) {
                break;
            }
            i2++;
        }
        if (jvmPrimitiveType == null) {
            if (charAt == 'V') {
                return new JvmType.Primitive(null);
            }
            if (charAt == '[') {
                String substring = representation.substring(1);
                m.f(substring, "(this as java.lang.String).substring(startIndex)");
                object = new JvmType.Array(createFromString(substring));
            } else {
                if (charAt == 'L') {
                    y.Y(representation, ';', false, 2, null);
                }
                String substring2 = representation.substring(1, representation.length() - 1);
                m.f(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                object = new JvmType.Object(substring2);
            }
            return object;
        }
        return new JvmType.Primitive(jvmPrimitiveType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public JvmType createObjectType(String internalName) {
        m.g(internalName, "internalName");
        return new JvmType.Object(internalName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public JvmType createPrimitiveType(PrimitiveType primitiveType) {
        m.g(primitiveType, "primitiveType");
        switch (WhenMappings.$EnumSwitchMapping$0[primitiveType.ordinal()]) {
            case 1:
                return JvmType.Companion.getBOOLEAN$descriptors_jvm();
            case 2:
                return JvmType.Companion.getCHAR$descriptors_jvm();
            case 3:
                return JvmType.Companion.getBYTE$descriptors_jvm();
            case 4:
                return JvmType.Companion.getSHORT$descriptors_jvm();
            case 5:
                return JvmType.Companion.getINT$descriptors_jvm();
            case 6:
                return JvmType.Companion.getFLOAT$descriptors_jvm();
            case 7:
                return JvmType.Companion.getLONG$descriptors_jvm();
            case 8:
                return JvmType.Companion.getDOUBLE$descriptors_jvm();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public JvmType getJavaLangClassType() {
        return createObjectType("java/lang/Class");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public String toString(JvmType type) {
        String desc;
        m.g(type, "type");
        if (type instanceof JvmType.Array) {
            return m.o("[", toString(((JvmType.Array) type).getElementType()));
        }
        if (type instanceof JvmType.Primitive) {
            JvmPrimitiveType jvmPrimitiveType = ((JvmType.Primitive) type).getJvmPrimitiveType();
            return (jvmPrimitiveType == null || (desc = jvmPrimitiveType.getDesc()) == null) ? "V" : desc;
        } else if (type instanceof JvmType.Object) {
            return Matrix.MATRIX_TYPE_RANDOM_LT + ((JvmType.Object) type).getInternalName() + ';';
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}