package kotlin.reflect.jvm.internal.impl.renderer;

/* compiled from: DescriptorRenderer.kt */
/* loaded from: classes3.dex */
public enum OverrideRenderingPolicy {
    RENDER_OVERRIDE,
    RENDER_OPEN,
    RENDER_OPEN_OVERRIDE;

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static OverrideRenderingPolicy[] valuesCustom() {
        OverrideRenderingPolicy[] valuesCustom = values();
        OverrideRenderingPolicy[] overrideRenderingPolicyArr = new OverrideRenderingPolicy[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, overrideRenderingPolicyArr, 0, valuesCustom.length);
        return overrideRenderingPolicyArr;
    }
}