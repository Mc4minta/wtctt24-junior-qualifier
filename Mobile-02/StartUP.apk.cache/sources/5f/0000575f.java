package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.NoWhenBranchMatchedException;
import kotlin.e0.c.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.x;

/* compiled from: DescriptorRenderer.kt */
/* loaded from: classes3.dex */
public abstract class DescriptorRenderer {
    public static final DescriptorRenderer COMPACT;
    public static final DescriptorRenderer COMPACT_WITHOUT_SUPERTYPES;
    public static final DescriptorRenderer COMPACT_WITH_MODIFIERS;
    public static final DescriptorRenderer COMPACT_WITH_SHORT_TYPES;
    public static final Companion Companion;
    public static final DescriptorRenderer DEBUG_TEXT;
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES;
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS;
    public static final DescriptorRenderer HTML;
    public static final DescriptorRenderer ONLY_NAMES_WITH_SHORT_TYPES;
    public static final DescriptorRenderer SHORT_NAMES_IN_TYPES;

    /* compiled from: DescriptorRenderer.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* compiled from: DescriptorRenderer.kt */
        /* loaded from: classes3.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ClassKind.values().length];
                iArr[ClassKind.CLASS.ordinal()] = 1;
                iArr[ClassKind.INTERFACE.ordinal()] = 2;
                iArr[ClassKind.ENUM_CLASS.ordinal()] = 3;
                iArr[ClassKind.OBJECT.ordinal()] = 4;
                iArr[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
                iArr[ClassKind.ENUM_ENTRY.ordinal()] = 6;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getClassifierKindPrefix(ClassifierDescriptorWithTypeParameters classifier) {
            m.g(classifier, "classifier");
            if (classifier instanceof TypeAliasDescriptor) {
                return "typealias";
            }
            if (classifier instanceof ClassDescriptor) {
                ClassDescriptor classDescriptor = (ClassDescriptor) classifier;
                if (classDescriptor.isCompanionObject()) {
                    return "companion object";
                }
                switch (WhenMappings.$EnumSwitchMapping$0[classDescriptor.getKind().ordinal()]) {
                    case 1:
                        return "class";
                    case 2:
                        return "interface";
                    case 3:
                        return "enum class";
                    case 4:
                        return "object";
                    case 5:
                        return "annotation class";
                    case 6:
                        return "enum entry";
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            throw new AssertionError(m.o("Unexpected classifier: ", classifier));
        }

        public final DescriptorRenderer withOptions(l<? super DescriptorRendererOptions, x> changeOptions) {
            m.g(changeOptions, "changeOptions");
            DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = new DescriptorRendererOptionsImpl();
            changeOptions.invoke(descriptorRendererOptionsImpl);
            descriptorRendererOptionsImpl.lock();
            return new DescriptorRendererImpl(descriptorRendererOptionsImpl);
        }
    }

    /* compiled from: DescriptorRenderer.kt */
    /* loaded from: classes3.dex */
    public interface ValueParametersHandler {

        /* compiled from: DescriptorRenderer.kt */
        /* loaded from: classes3.dex */
        public static final class DEFAULT implements ValueParametersHandler {
            public static final DEFAULT INSTANCE = new DEFAULT();

            private DEFAULT() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameter(ValueParameterDescriptor parameter, int i2, int i3, StringBuilder builder) {
                m.g(parameter, "parameter");
                m.g(builder, "builder");
                if (i2 != i3 - 1) {
                    builder.append(", ");
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameters(int i2, StringBuilder builder) {
                m.g(builder, "builder");
                builder.append(")");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameter(ValueParameterDescriptor parameter, int i2, int i3, StringBuilder builder) {
                m.g(parameter, "parameter");
                m.g(builder, "builder");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameters(int i2, StringBuilder builder) {
                m.g(builder, "builder");
                builder.append("(");
            }
        }

        void appendAfterValueParameter(ValueParameterDescriptor valueParameterDescriptor, int i2, int i3, StringBuilder sb);

        void appendAfterValueParameters(int i2, StringBuilder sb);

        void appendBeforeValueParameter(ValueParameterDescriptor valueParameterDescriptor, int i2, int i3, StringBuilder sb);

        void appendBeforeValueParameters(int i2, StringBuilder sb);
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        COMPACT_WITH_MODIFIERS = companion.withOptions(DescriptorRenderer$Companion$COMPACT_WITH_MODIFIERS$1.INSTANCE);
        COMPACT = companion.withOptions(DescriptorRenderer$Companion$COMPACT$1.INSTANCE);
        COMPACT_WITHOUT_SUPERTYPES = companion.withOptions(DescriptorRenderer$Companion$COMPACT_WITHOUT_SUPERTYPES$1.INSTANCE);
        COMPACT_WITH_SHORT_TYPES = companion.withOptions(DescriptorRenderer$Companion$COMPACT_WITH_SHORT_TYPES$1.INSTANCE);
        ONLY_NAMES_WITH_SHORT_TYPES = companion.withOptions(DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1.INSTANCE);
        FQ_NAMES_IN_TYPES = companion.withOptions(DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES$1.INSTANCE);
        FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS = companion.withOptions(DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$1.INSTANCE);
        SHORT_NAMES_IN_TYPES = companion.withOptions(DescriptorRenderer$Companion$SHORT_NAMES_IN_TYPES$1.INSTANCE);
        DEBUG_TEXT = companion.withOptions(DescriptorRenderer$Companion$DEBUG_TEXT$1.INSTANCE);
        HTML = companion.withOptions(DescriptorRenderer$Companion$HTML$1.INSTANCE);
    }

    public static /* synthetic */ String renderAnnotation$default(DescriptorRenderer descriptorRenderer, AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                annotationUseSiteTarget = null;
            }
            return descriptorRenderer.renderAnnotation(annotationDescriptor, annotationUseSiteTarget);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
    }

    public abstract String render(DeclarationDescriptor declarationDescriptor);

    public abstract String renderAnnotation(AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget);

    public abstract String renderFlexibleType(String str, String str2, KotlinBuiltIns kotlinBuiltIns);

    public abstract String renderFqName(FqNameUnsafe fqNameUnsafe);

    public abstract String renderName(Name name, boolean z);

    public abstract String renderType(KotlinType kotlinType);

    public abstract String renderTypeProjection(TypeProjection typeProjection);

    public final DescriptorRenderer withOptions(l<? super DescriptorRendererOptions, x> changeOptions) {
        m.g(changeOptions, "changeOptions");
        DescriptorRendererOptionsImpl copy = ((DescriptorRendererImpl) this).getOptions().copy();
        changeOptions.invoke(copy);
        copy.lock();
        return new DescriptorRendererImpl(copy);
    }
}