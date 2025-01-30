package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.apache.http.message.TokenParser;

/* compiled from: constantValues.kt */
/* loaded from: classes3.dex */
public final class StringValue extends ConstantValue<String> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringValue(String value) {
        super(value);
        m.g(value, "value");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        return TokenParser.DQUOTE + getValue() + TokenParser.DQUOTE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor module) {
        m.g(module, "module");
        SimpleType stringType = module.getBuiltIns().getStringType();
        m.f(stringType, "module.builtIns.stringType");
        return stringType;
    }
}