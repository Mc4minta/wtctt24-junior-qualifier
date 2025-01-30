package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Arrays;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
/* loaded from: classes3.dex */
public final class CharValue extends IntegerValueConstant<Character> {
    public CharValue(char c2) {
        super(Character.valueOf(c2));
    }

    private final String getPrintablePart(char c2) {
        return c2 == '\b' ? "\\b" : c2 == '\t' ? "\\t" : c2 == '\n' ? "\\n" : c2 == '\f' ? "\\f" : c2 == '\r' ? "\\r" : isPrintableUnicode(c2) ? String.valueOf(c2) : "?";
    }

    private final boolean isPrintableUnicode(char c2) {
        byte type = (byte) Character.getType(c2);
        return (type == 0 || type == 13 || type == 14 || type == 15 || type == 16 || type == 18 || type == 19) ? false : true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        String format = String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(getValue().charValue()), getPrintablePart(getValue().charValue())}, 2));
        m.f(format, "java.lang.String.format(this, *args)");
        return format;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor module) {
        m.g(module, "module");
        SimpleType charType = module.getBuiltIns().getCharType();
        m.f(charType, "module.builtIns.charType");
        return charType;
    }
}