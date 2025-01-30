package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.Set;
import kotlin.a0.n;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DescriptorRenderer.kt */
/* loaded from: classes3.dex */
public enum DescriptorRendererModifier {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true),
    CONST(true),
    LATEINIT(true),
    FUN(true),
    VALUE(true);
    
    public static final Set<DescriptorRendererModifier> ALL;
    public static final Set<DescriptorRendererModifier> ALL_EXCEPT_ANNOTATIONS;
    public static final Companion Companion = new Companion(null);
    private final boolean includeByDefault;

    /* compiled from: DescriptorRenderer.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Set<DescriptorRendererModifier> M0;
        Set<DescriptorRendererModifier> q0;
        DescriptorRendererModifier[] valuesCustom = valuesCustom();
        ArrayList arrayList = new ArrayList();
        for (DescriptorRendererModifier descriptorRendererModifier : valuesCustom) {
            if (descriptorRendererModifier.getIncludeByDefault()) {
                arrayList.add(descriptorRendererModifier);
            }
        }
        M0 = z.M0(arrayList);
        ALL_EXCEPT_ANNOTATIONS = M0;
        q0 = n.q0(valuesCustom());
        ALL = q0;
    }

    DescriptorRendererModifier(boolean z) {
        this.includeByDefault = z;
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static DescriptorRendererModifier[] valuesCustom() {
        DescriptorRendererModifier[] valuesCustom = values();
        DescriptorRendererModifier[] descriptorRendererModifierArr = new DescriptorRendererModifier[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, descriptorRendererModifierArr, 0, valuesCustom.length);
        return descriptorRendererModifierArr;
    }

    public final boolean getIncludeByDefault() {
        return this.includeByDefault;
    }
}