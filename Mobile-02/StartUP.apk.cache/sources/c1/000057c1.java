package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.x;

/* compiled from: constantValues.kt */
/* loaded from: classes3.dex */
public abstract class ErrorValue extends ConstantValue<x> {
    public static final Companion Companion = new Companion(null);

    /* compiled from: constantValues.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ErrorValue create(String message) {
            m.g(message, "message");
            return new ErrorValueWithMessage(message);
        }
    }

    /* compiled from: constantValues.kt */
    /* loaded from: classes3.dex */
    public static final class ErrorValueWithMessage extends ErrorValue {
        private final String message;

        public ErrorValueWithMessage(String message) {
            m.g(message, "message");
            this.message = message;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
        public String toString() {
            return this.message;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
        public SimpleType getType(ModuleDescriptor module) {
            m.g(module, "module");
            SimpleType createErrorType = ErrorUtils.createErrorType(this.message);
            m.f(createErrorType, "createErrorType(message)");
            return createErrorType;
        }
    }

    public ErrorValue() {
        super(x.a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public x getValue() {
        throw new UnsupportedOperationException();
    }
}