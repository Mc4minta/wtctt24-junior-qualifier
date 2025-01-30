package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.utils.ReportLevel;

/* compiled from: context.kt */
/* loaded from: classes3.dex */
public final class ContextKt {
    public static final LazyJavaResolverContext child(LazyJavaResolverContext lazyJavaResolverContext, TypeParameterResolver typeParameterResolver) {
        m.g(lazyJavaResolverContext, "<this>");
        m.g(typeParameterResolver, "typeParameterResolver");
        return new LazyJavaResolverContext(lazyJavaResolverContext.getComponents(), typeParameterResolver, lazyJavaResolverContext.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    public static final LazyJavaResolverContext childForClassOrPackage(LazyJavaResolverContext lazyJavaResolverContext, ClassOrPackageFragmentDescriptor containingDeclaration, JavaTypeParameterListOwner javaTypeParameterListOwner, int i2) {
        h a;
        m.g(lazyJavaResolverContext, "<this>");
        m.g(containingDeclaration, "containingDeclaration");
        a = k.a(kotlin.m.NONE, new ContextKt$childForClassOrPackage$1(lazyJavaResolverContext, containingDeclaration));
        return child(lazyJavaResolverContext, containingDeclaration, javaTypeParameterListOwner, i2, a);
    }

    public static /* synthetic */ LazyJavaResolverContext childForClassOrPackage$default(LazyJavaResolverContext lazyJavaResolverContext, ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            javaTypeParameterListOwner = null;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return childForClassOrPackage(lazyJavaResolverContext, classOrPackageFragmentDescriptor, javaTypeParameterListOwner, i2);
    }

    public static final LazyJavaResolverContext childForMethod(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor containingDeclaration, JavaTypeParameterListOwner typeParameterOwner, int i2) {
        m.g(lazyJavaResolverContext, "<this>");
        m.g(containingDeclaration, "containingDeclaration");
        m.g(typeParameterOwner, "typeParameterOwner");
        return child(lazyJavaResolverContext, containingDeclaration, typeParameterOwner, i2, lazyJavaResolverContext.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    public static /* synthetic */ LazyJavaResolverContext childForMethod$default(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor declarationDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return childForMethod(lazyJavaResolverContext, declarationDescriptor, javaTypeParameterListOwner, i2);
    }

    public static final JavaTypeQualifiersByElementType computeNewDefaultTypeQualifiers(LazyJavaResolverContext lazyJavaResolverContext, Annotations additionalAnnotations) {
        EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers> defaultQualifiers;
        m.g(lazyJavaResolverContext, "<this>");
        m.g(additionalAnnotations, "additionalAnnotations");
        if (lazyJavaResolverContext.getComponents().getJavaTypeEnhancementState().getDisabledDefaultAnnotations()) {
            return lazyJavaResolverContext.getDefaultTypeQualifiers();
        }
        ArrayList<JavaDefaultQualifiers> arrayList = new ArrayList();
        Iterator<AnnotationDescriptor> it = additionalAnnotations.iterator();
        while (it.hasNext()) {
            JavaDefaultQualifiers extractDefaultNullabilityQualifier = extractDefaultNullabilityQualifier(lazyJavaResolverContext, it.next());
            if (extractDefaultNullabilityQualifier != null) {
                arrayList.add(extractDefaultNullabilityQualifier);
            }
        }
        if (arrayList.isEmpty()) {
            return lazyJavaResolverContext.getDefaultTypeQualifiers();
        }
        JavaTypeQualifiersByElementType defaultTypeQualifiers = lazyJavaResolverContext.getDefaultTypeQualifiers();
        EnumMap enumMap = null;
        if (defaultTypeQualifiers != null && (defaultQualifiers = defaultTypeQualifiers.getDefaultQualifiers()) != null) {
            enumMap = new EnumMap((EnumMap) defaultQualifiers);
        }
        if (enumMap == null) {
            enumMap = new EnumMap(AnnotationQualifierApplicabilityType.class);
        }
        boolean z = false;
        for (JavaDefaultQualifiers javaDefaultQualifiers : arrayList) {
            for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : javaDefaultQualifiers.getQualifierApplicabilityTypes()) {
                enumMap.put((EnumMap) annotationQualifierApplicabilityType, (AnnotationQualifierApplicabilityType) javaDefaultQualifiers);
                z = true;
            }
        }
        return !z ? lazyJavaResolverContext.getDefaultTypeQualifiers() : new JavaTypeQualifiersByElementType(enumMap);
    }

    public static final LazyJavaResolverContext copyWithNewDefaultTypeQualifiers(LazyJavaResolverContext lazyJavaResolverContext, Annotations additionalAnnotations) {
        h a;
        m.g(lazyJavaResolverContext, "<this>");
        m.g(additionalAnnotations, "additionalAnnotations");
        if (additionalAnnotations.isEmpty()) {
            return lazyJavaResolverContext;
        }
        JavaResolverComponents components = lazyJavaResolverContext.getComponents();
        TypeParameterResolver typeParameterResolver = lazyJavaResolverContext.getTypeParameterResolver();
        a = k.a(kotlin.m.NONE, new ContextKt$copyWithNewDefaultTypeQualifiers$1(lazyJavaResolverContext, additionalAnnotations));
        return new LazyJavaResolverContext(components, typeParameterResolver, a);
    }

    private static final JavaDefaultQualifiers extractDefaultNullabilityQualifier(LazyJavaResolverContext lazyJavaResolverContext, AnnotationDescriptor annotationDescriptor) {
        AnnotationTypeQualifierResolver annotationTypeQualifierResolver = lazyJavaResolverContext.getComponents().getAnnotationTypeQualifierResolver();
        JavaDefaultQualifiers resolveQualifierBuiltInDefaultAnnotation = annotationTypeQualifierResolver.resolveQualifierBuiltInDefaultAnnotation(annotationDescriptor);
        if (resolveQualifierBuiltInDefaultAnnotation == null) {
            AnnotationTypeQualifierResolver.TypeQualifierWithApplicability resolveTypeQualifierDefaultAnnotation = annotationTypeQualifierResolver.resolveTypeQualifierDefaultAnnotation(annotationDescriptor);
            if (resolveTypeQualifierDefaultAnnotation == null) {
                return null;
            }
            AnnotationDescriptor component1 = resolveTypeQualifierDefaultAnnotation.component1();
            List<AnnotationQualifierApplicabilityType> component2 = resolveTypeQualifierDefaultAnnotation.component2();
            ReportLevel resolveJsr305CustomState = annotationTypeQualifierResolver.resolveJsr305CustomState(annotationDescriptor);
            if (resolveJsr305CustomState == null) {
                resolveJsr305CustomState = annotationTypeQualifierResolver.resolveJsr305AnnotationState(component1);
            }
            if (resolveJsr305CustomState.isIgnore()) {
                return null;
            }
            NullabilityQualifierWithMigrationStatus extractNullability = lazyJavaResolverContext.getComponents().getSignatureEnhancement().extractNullability(component1, lazyJavaResolverContext.getComponents().getSettings().getTypeEnhancementImprovements(), false);
            NullabilityQualifierWithMigrationStatus copy$default = extractNullability == null ? null : NullabilityQualifierWithMigrationStatus.copy$default(extractNullability, null, resolveJsr305CustomState.isWarning(), 1, null);
            if (copy$default == null) {
                return null;
            }
            return new JavaDefaultQualifiers(copy$default, component2, false, 4, null);
        }
        return resolveQualifierBuiltInDefaultAnnotation;
    }

    public static final LazyJavaResolverContext replaceComponents(LazyJavaResolverContext lazyJavaResolverContext, JavaResolverComponents components) {
        m.g(lazyJavaResolverContext, "<this>");
        m.g(components, "components");
        return new LazyJavaResolverContext(components, lazyJavaResolverContext.getTypeParameterResolver(), lazyJavaResolverContext.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    private static final LazyJavaResolverContext child(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor declarationDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i2, h<JavaTypeQualifiersByElementType> hVar) {
        JavaResolverComponents components = lazyJavaResolverContext.getComponents();
        LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver = javaTypeParameterListOwner == null ? null : new LazyJavaTypeParameterResolver(lazyJavaResolverContext, declarationDescriptor, javaTypeParameterListOwner, i2);
        if (lazyJavaTypeParameterResolver == null) {
            lazyJavaTypeParameterResolver = lazyJavaResolverContext.getTypeParameterResolver();
        }
        return new LazyJavaResolverContext(components, lazyJavaTypeParameterResolver, hVar);
    }
}