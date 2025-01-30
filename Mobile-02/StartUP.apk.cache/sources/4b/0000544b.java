package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.a0.m0;
import kotlin.a0.n;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.u;

/* compiled from: KotlinTarget.kt */
/* loaded from: classes3.dex */
public enum KotlinTarget {
    CLASS("class", false, 2, null),
    ANNOTATION_CLASS("annotation class", false, 2, null),
    TYPE_PARAMETER("type parameter", false),
    PROPERTY("property", false, 2, null),
    FIELD("field", false, 2, null),
    LOCAL_VARIABLE("local variable", false, 2, null),
    VALUE_PARAMETER("value parameter", false, 2, null),
    CONSTRUCTOR("constructor", false, 2, null),
    FUNCTION("function", false, 2, null),
    PROPERTY_GETTER("getter", false, 2, null),
    PROPERTY_SETTER("setter", false, 2, null),
    TYPE("type usage", false),
    EXPRESSION("expression", false),
    FILE("file", false),
    TYPEALIAS("typealias", false),
    TYPE_PROJECTION("type projection", false),
    STAR_PROJECTION("star projection", false),
    PROPERTY_PARAMETER("property constructor parameter", false),
    CLASS_ONLY("class", false),
    OBJECT("object", false),
    COMPANION_OBJECT("companion object", false),
    INTERFACE("interface", false),
    ENUM_CLASS("enum class", false),
    ENUM_ENTRY("enum entry", false),
    LOCAL_CLASS("local class", false),
    LOCAL_FUNCTION("local function", false),
    MEMBER_FUNCTION("member function", false),
    TOP_LEVEL_FUNCTION("top level function", false),
    MEMBER_PROPERTY("member property", false),
    MEMBER_PROPERTY_WITH_BACKING_FIELD("member property with backing field", false),
    MEMBER_PROPERTY_WITH_DELEGATE("member property with delegate", false),
    MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("member property without backing field or delegate", false),
    TOP_LEVEL_PROPERTY("top level property", false),
    TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD("top level property with backing field", false),
    TOP_LEVEL_PROPERTY_WITH_DELEGATE("top level property with delegate", false),
    TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("top level property without backing field or delegate", false),
    INITIALIZER("initializer", false),
    DESTRUCTURING_DECLARATION("destructuring declaration", false),
    LAMBDA_EXPRESSION("lambda expression", false),
    ANONYMOUS_FUNCTION("anonymous function", false),
    OBJECT_LITERAL("object literal", false);
    
    private static final Set<KotlinTarget> ALL_TARGET_SET;
    private static final Set<KotlinTarget> DEFAULT_TARGET_SET;
    private static final Map<AnnotationUseSiteTarget, KotlinTarget> USE_SITE_MAPPING;
    private final String description;
    private final boolean isDefault;
    public static final Companion Companion = new Companion(null);
    private static final HashMap<String, KotlinTarget> map = new HashMap<>();

    /* compiled from: KotlinTarget.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Set<KotlinTarget> M0;
        Set<KotlinTarget> q0;
        Map<AnnotationUseSiteTarget, KotlinTarget> l2;
        KotlinTarget[] valuesCustom = valuesCustom();
        int length = valuesCustom.length;
        int i2 = 0;
        while (i2 < length) {
            KotlinTarget kotlinTarget = valuesCustom[i2];
            i2++;
            map.put(kotlinTarget.name(), kotlinTarget);
        }
        KotlinTarget[] valuesCustom2 = valuesCustom();
        ArrayList arrayList = new ArrayList();
        for (KotlinTarget kotlinTarget2 : valuesCustom2) {
            if (kotlinTarget2.isDefault()) {
                arrayList.add(kotlinTarget2);
            }
        }
        M0 = z.M0(arrayList);
        DEFAULT_TARGET_SET = M0;
        q0 = n.q0(valuesCustom());
        ALL_TARGET_SET = q0;
        AnnotationUseSiteTarget annotationUseSiteTarget = AnnotationUseSiteTarget.CONSTRUCTOR_PARAMETER;
        KotlinTarget kotlinTarget3 = VALUE_PARAMETER;
        AnnotationUseSiteTarget annotationUseSiteTarget2 = AnnotationUseSiteTarget.FIELD;
        KotlinTarget kotlinTarget4 = FIELD;
        l2 = m0.l(u.a(annotationUseSiteTarget, kotlinTarget3), u.a(annotationUseSiteTarget2, kotlinTarget4), u.a(AnnotationUseSiteTarget.PROPERTY, PROPERTY), u.a(AnnotationUseSiteTarget.FILE, FILE), u.a(AnnotationUseSiteTarget.PROPERTY_GETTER, PROPERTY_GETTER), u.a(AnnotationUseSiteTarget.PROPERTY_SETTER, PROPERTY_SETTER), u.a(AnnotationUseSiteTarget.RECEIVER, kotlinTarget3), u.a(AnnotationUseSiteTarget.SETTER_PARAMETER, kotlinTarget3), u.a(AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD, kotlinTarget4));
        USE_SITE_MAPPING = l2;
    }

    KotlinTarget(String str, boolean z) {
        this.description = str;
        this.isDefault = z;
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static KotlinTarget[] valuesCustom() {
        KotlinTarget[] valuesCustom = values();
        KotlinTarget[] kotlinTargetArr = new KotlinTarget[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, kotlinTargetArr, 0, valuesCustom.length);
        return kotlinTargetArr;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    /* synthetic */ KotlinTarget(String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? true : z);
    }
}