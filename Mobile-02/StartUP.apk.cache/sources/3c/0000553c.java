package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: util.kt */
/* loaded from: classes3.dex */
public final class ValueParameterData {
    private final boolean hasDefaultValue;
    private final KotlinType type;

    public ValueParameterData(KotlinType type, boolean z) {
        m.g(type, "type");
        this.type = type;
        this.hasDefaultValue = z;
    }

    public final boolean getHasDefaultValue() {
        return this.hasDefaultValue;
    }

    public final KotlinType getType() {
        return this.type;
    }
}