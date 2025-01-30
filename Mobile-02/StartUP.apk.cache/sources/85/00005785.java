package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.l0.x;

/* compiled from: DescriptorRenderer.kt */
/* loaded from: classes3.dex */
public enum RenderingFormat {
    PLAIN { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.PLAIN
        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        public String escape(String string) {
            m.g(string, "string");
            return string;
        }
    },
    HTML { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.HTML
        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        public String escape(String string) {
            String K;
            String K2;
            m.g(string, "string");
            K = x.K(string, "<", "&lt;", false, 4, null);
            K2 = x.K(K, ">", "&gt;", false, 4, null);
            return K2;
        }
    };

    /* synthetic */ RenderingFormat(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static RenderingFormat[] valuesCustom() {
        RenderingFormat[] valuesCustom = values();
        RenderingFormat[] renderingFormatArr = new RenderingFormat[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, renderingFormatArr, 0, valuesCustom.length);
        return renderingFormatArr;
    }

    public abstract String escape(String str);
}