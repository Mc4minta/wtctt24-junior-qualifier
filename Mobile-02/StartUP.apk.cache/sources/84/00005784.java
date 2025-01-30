package kotlin.reflect.jvm.internal.impl.renderer;

/* compiled from: DescriptorRenderer.kt */
/* loaded from: classes3.dex */
public enum PropertyAccessorRenderingPolicy {
    PRETTY,
    DEBUG,
    NONE;

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static PropertyAccessorRenderingPolicy[] valuesCustom() {
        PropertyAccessorRenderingPolicy[] valuesCustom = values();
        PropertyAccessorRenderingPolicy[] propertyAccessorRenderingPolicyArr = new PropertyAccessorRenderingPolicy[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, propertyAccessorRenderingPolicyArr, 0, valuesCustom.length);
        return propertyAccessorRenderingPolicyArr;
    }
}