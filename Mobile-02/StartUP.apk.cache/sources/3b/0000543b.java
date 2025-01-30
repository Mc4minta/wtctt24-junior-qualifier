package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: AnnotationUseSiteTarget.kt */
/* loaded from: classes3.dex */
public enum AnnotationUseSiteTarget {
    FIELD(null, 1, null),
    FILE(null, 1, null),
    PROPERTY(null, 1, null),
    PROPERTY_GETTER("get"),
    PROPERTY_SETTER("set"),
    RECEIVER(null, 1, null),
    CONSTRUCTOR_PARAMETER("param"),
    SETTER_PARAMETER("setparam"),
    PROPERTY_DELEGATE_FIELD("delegate");
    
    private final String renderName;

    AnnotationUseSiteTarget(String str) {
        if (str == null) {
            String name = name();
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            str = name.toLowerCase();
            m.f(str, "(this as java.lang.String).toLowerCase()");
        }
        this.renderName = str;
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static AnnotationUseSiteTarget[] valuesCustom() {
        AnnotationUseSiteTarget[] valuesCustom = values();
        AnnotationUseSiteTarget[] annotationUseSiteTargetArr = new AnnotationUseSiteTarget[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, annotationUseSiteTargetArr, 0, valuesCustom.length);
        return annotationUseSiteTargetArr;
    }

    public final String getRenderName() {
        return this.renderName;
    }

    /* synthetic */ AnnotationUseSiteTarget(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str);
    }
}