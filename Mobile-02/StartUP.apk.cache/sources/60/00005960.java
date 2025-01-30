package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* compiled from: TypeSystemContext.kt */
/* loaded from: classes3.dex */
public interface TypeSystemInferenceExtensionContext extends TypeSystemCommonSuperTypesContext, TypeSystemContext {

    /* compiled from: TypeSystemContext.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static TypeArgumentMarker get(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, TypeArgumentListMarker typeArgumentListMarker, int i2) {
            return TypeSystemContext.DefaultImpls.get(typeSystemInferenceExtensionContext, typeArgumentListMarker, i2);
        }

        public static boolean isMarkedNullable(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemContext.DefaultImpls.isMarkedNullable(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }

        public static SimpleTypeMarker lowerBoundIfFlexible(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemContext.DefaultImpls.lowerBoundIfFlexible(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }

        public static int size(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, TypeArgumentListMarker typeArgumentListMarker) {
            return TypeSystemContext.DefaultImpls.size(typeSystemInferenceExtensionContext, typeArgumentListMarker);
        }

        public static TypeConstructorMarker typeConstructor(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemContext.DefaultImpls.typeConstructor(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }

        public static SimpleTypeMarker upperBoundIfFlexible(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemContext.DefaultImpls.upperBoundIfFlexible(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }
    }
}