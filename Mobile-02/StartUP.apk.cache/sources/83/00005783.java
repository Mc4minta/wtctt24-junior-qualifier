package kotlin.reflect.jvm.internal.impl.renderer;

/* compiled from: DescriptorRenderer.kt */
/* loaded from: classes3.dex */
public enum ParameterNameRenderingPolicy {
    ALL,
    ONLY_NON_SYNTHESIZED,
    NONE;

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static ParameterNameRenderingPolicy[] valuesCustom() {
        ParameterNameRenderingPolicy[] valuesCustom = values();
        ParameterNameRenderingPolicy[] parameterNameRenderingPolicyArr = new ParameterNameRenderingPolicy[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, parameterNameRenderingPolicyArr, 0, valuesCustom.length);
        return parameterNameRenderingPolicyArr;
    }
}