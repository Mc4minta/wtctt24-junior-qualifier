package kotlin.reflect.jvm.internal.impl.types.model;

/* compiled from: TypeSystemContext.kt */
/* loaded from: classes3.dex */
public enum CaptureStatus {
    FOR_SUBTYPING,
    FOR_INCORPORATION,
    FROM_EXPRESSION;

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static CaptureStatus[] valuesCustom() {
        CaptureStatus[] valuesCustom = values();
        CaptureStatus[] captureStatusArr = new CaptureStatus[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, captureStatusArr, 0, valuesCustom.length);
        return captureStatusArr;
    }
}