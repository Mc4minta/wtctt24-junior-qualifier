package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

/* compiled from: DeserializedContainerSource.kt */
/* loaded from: classes3.dex */
public enum DeserializedContainerAbiStability {
    STABLE,
    FIR_UNSTABLE,
    IR_UNSTABLE;

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static DeserializedContainerAbiStability[] valuesCustom() {
        DeserializedContainerAbiStability[] valuesCustom = values();
        DeserializedContainerAbiStability[] deserializedContainerAbiStabilityArr = new DeserializedContainerAbiStability[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, deserializedContainerAbiStabilityArr, 0, valuesCustom.length);
        return deserializedContainerAbiStabilityArr;
    }
}