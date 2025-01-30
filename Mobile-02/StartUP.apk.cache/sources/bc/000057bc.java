package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.ArrayList;
import java.util.List;
import kotlin.a0.n;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: ConstantValueFactory.kt */
/* loaded from: classes3.dex */
public final class ConstantValueFactory {
    public static final ConstantValueFactory INSTANCE = new ConstantValueFactory();

    private ConstantValueFactory() {
    }

    public final ArrayValue createArrayValue(List<? extends ConstantValue<?>> value, KotlinType type) {
        m.g(value, "value");
        m.g(type, "type");
        return new ArrayValue(value, new ConstantValueFactory$createArrayValue$1(type));
    }

    public final ConstantValue<?> createConstantValue(Object obj) {
        List<Boolean> g0;
        List<Double> a0;
        List<Float> b0;
        List<Character> Z;
        List<Long> d0;
        List<Integer> c0;
        List<Short> f0;
        List<Byte> Y;
        if (obj instanceof Byte) {
            return new ByteValue(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new ShortValue(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new IntValue(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new LongValue(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new CharValue(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new FloatValue(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new DoubleValue(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new BooleanValue(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new StringValue((String) obj);
        }
        if (obj instanceof byte[]) {
            Y = n.Y((byte[]) obj);
            return createArrayValue(Y, PrimitiveType.BYTE);
        } else if (obj instanceof short[]) {
            f0 = n.f0((short[]) obj);
            return createArrayValue(f0, PrimitiveType.SHORT);
        } else if (obj instanceof int[]) {
            c0 = n.c0((int[]) obj);
            return createArrayValue(c0, PrimitiveType.INT);
        } else if (obj instanceof long[]) {
            d0 = n.d0((long[]) obj);
            return createArrayValue(d0, PrimitiveType.LONG);
        } else if (obj instanceof char[]) {
            Z = n.Z((char[]) obj);
            return createArrayValue(Z, PrimitiveType.CHAR);
        } else if (obj instanceof float[]) {
            b0 = n.b0((float[]) obj);
            return createArrayValue(b0, PrimitiveType.FLOAT);
        } else if (obj instanceof double[]) {
            a0 = n.a0((double[]) obj);
            return createArrayValue(a0, PrimitiveType.DOUBLE);
        } else if (obj instanceof boolean[]) {
            g0 = n.g0((boolean[]) obj);
            return createArrayValue(g0, PrimitiveType.BOOLEAN);
        } else if (obj == null) {
            return new NullValue();
        } else {
            return null;
        }
    }

    private final ArrayValue createArrayValue(List<?> list, PrimitiveType primitiveType) {
        List<Object> I0;
        I0 = z.I0(list);
        ArrayList arrayList = new ArrayList();
        for (Object obj : I0) {
            ConstantValue<?> createConstantValue = createConstantValue(obj);
            if (createConstantValue != null) {
                arrayList.add(createConstantValue);
            }
        }
        return new ArrayValue(arrayList, new ConstantValueFactory$createArrayValue$3(primitiveType));
    }
}