package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: TypeSubstitution.kt */
/* loaded from: classes3.dex */
public abstract class TypeSubstitution {
    public static final Companion Companion = new Companion(null);
    public static final TypeSubstitution EMPTY = new TypeSubstitution() { // from class: kotlin.reflect.jvm.internal.impl.types.TypeSubstitution$Companion$EMPTY$1
        public Void get(KotlinType key) {
            m.g(key, "key");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
        /* renamed from: get  reason: collision with other method in class */
        public /* bridge */ /* synthetic */ TypeProjection mo2219get(KotlinType kotlinType) {
            return (TypeProjection) get(kotlinType);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
        public boolean isEmpty() {
            return true;
        }

        public String toString() {
            return "Empty TypeSubstitution";
        }
    };

    /* compiled from: TypeSubstitution.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public boolean approximateCapturedTypes() {
        return false;
    }

    public boolean approximateContravariantCapturedTypes() {
        return false;
    }

    public final TypeSubstitutor buildSubstitutor() {
        TypeSubstitutor create = TypeSubstitutor.create(this);
        m.f(create, "create(this)");
        return create;
    }

    public Annotations filterAnnotations(Annotations annotations) {
        m.g(annotations, "annotations");
        return annotations;
    }

    /* renamed from: get */
    public abstract TypeProjection mo2219get(KotlinType kotlinType);

    public boolean isEmpty() {
        return false;
    }

    public KotlinType prepareTopLevelType(KotlinType topLevelType, Variance position) {
        m.g(topLevelType, "topLevelType");
        m.g(position, "position");
        return topLevelType;
    }
}