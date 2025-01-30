package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.List;
import kotlin.a0.x;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

/* compiled from: ClassifierNamePolicy.kt */
/* loaded from: classes3.dex */
public interface ClassifierNamePolicy {

    /* compiled from: ClassifierNamePolicy.kt */
    /* loaded from: classes3.dex */
    public static final class FULLY_QUALIFIED implements ClassifierNamePolicy {
        public static final FULLY_QUALIFIED INSTANCE = new FULLY_QUALIFIED();

        private FULLY_QUALIFIED() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor classifier, DescriptorRenderer renderer) {
            m.g(classifier, "classifier");
            m.g(renderer, "renderer");
            if (classifier instanceof TypeParameterDescriptor) {
                Name name = ((TypeParameterDescriptor) classifier).getName();
                m.f(name, "classifier.name");
                return renderer.renderName(name, false);
            }
            FqNameUnsafe fqName = DescriptorUtils.getFqName(classifier);
            m.f(fqName, "getFqName(classifier)");
            return renderer.renderFqName(fqName);
        }
    }

    /* compiled from: ClassifierNamePolicy.kt */
    /* loaded from: classes3.dex */
    public static final class SHORT implements ClassifierNamePolicy {
        public static final SHORT INSTANCE = new SHORT();

        private SHORT() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor classifier, DescriptorRenderer renderer) {
            boolean z;
            List H;
            m.g(classifier, "classifier");
            m.g(renderer, "renderer");
            if (classifier instanceof TypeParameterDescriptor) {
                Name name = ((TypeParameterDescriptor) classifier).getName();
                m.f(name, "classifier.name");
                return renderer.renderName(name, false);
            }
            ArrayList arrayList = new ArrayList();
            ClassifierDescriptor classifierDescriptor = classifier;
            do {
                arrayList.add(classifierDescriptor.getName());
                DeclarationDescriptor containingDeclaration = classifierDescriptor.getContainingDeclaration();
                z = containingDeclaration instanceof ClassDescriptor;
                classifierDescriptor = containingDeclaration;
            } while (z);
            H = x.H(arrayList);
            return RenderingUtilsKt.renderFqName(H);
        }
    }

    /* compiled from: ClassifierNamePolicy.kt */
    /* loaded from: classes3.dex */
    public static final class SOURCE_CODE_QUALIFIED implements ClassifierNamePolicy {
        public static final SOURCE_CODE_QUALIFIED INSTANCE = new SOURCE_CODE_QUALIFIED();

        private SOURCE_CODE_QUALIFIED() {
        }

        private final String qualifiedNameForSourceCode(ClassifierDescriptor classifierDescriptor) {
            Name name = classifierDescriptor.getName();
            m.f(name, "descriptor.name");
            String render = RenderingUtilsKt.render(name);
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                return render;
            }
            DeclarationDescriptor containingDeclaration = classifierDescriptor.getContainingDeclaration();
            m.f(containingDeclaration, "descriptor.containingDeclaration");
            String qualifierName = qualifierName(containingDeclaration);
            if (qualifierName == null || m.c(qualifierName, "")) {
                return render;
            }
            return ((Object) qualifierName) + '.' + render;
        }

        private final String qualifierName(DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor instanceof ClassDescriptor) {
                return qualifiedNameForSourceCode((ClassifierDescriptor) declarationDescriptor);
            }
            if (declarationDescriptor instanceof PackageFragmentDescriptor) {
                FqNameUnsafe unsafe = ((PackageFragmentDescriptor) declarationDescriptor).getFqName().toUnsafe();
                m.f(unsafe, "descriptor.fqName.toUnsafe()");
                return RenderingUtilsKt.render(unsafe);
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor classifier, DescriptorRenderer renderer) {
            m.g(classifier, "classifier");
            m.g(renderer, "renderer");
            return qualifiedNameForSourceCode(classifier);
        }
    }

    String renderClassifier(ClassifierDescriptor classifierDescriptor, DescriptorRenderer descriptorRenderer);
}