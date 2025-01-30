package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.a0.r;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n0.a;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: Annotations.kt */
/* loaded from: classes3.dex */
public interface Annotations extends Iterable<AnnotationDescriptor>, a {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Annotations.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Annotations EMPTY = new Annotations() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion$EMPTY$1
            public Void findAnnotation(FqName fqName) {
                m.g(fqName, "fqName");
                return null;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
            /* renamed from: findAnnotation  reason: collision with other method in class */
            public /* bridge */ /* synthetic */ AnnotationDescriptor mo2207findAnnotation(FqName fqName) {
                return (AnnotationDescriptor) findAnnotation(fqName);
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
            public boolean hasAnnotation(FqName fqName) {
                return Annotations.DefaultImpls.hasAnnotation(this, fqName);
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
            public boolean isEmpty() {
                return true;
            }

            @Override // java.lang.Iterable
            public Iterator<AnnotationDescriptor> iterator() {
                List g2;
                g2 = r.g();
                return g2.iterator();
            }

            public String toString() {
                return "EMPTY";
            }
        };

        private Companion() {
        }

        public final Annotations create(List<? extends AnnotationDescriptor> annotations) {
            m.g(annotations, "annotations");
            return annotations.isEmpty() ? EMPTY : new AnnotationsImpl(annotations);
        }

        public final Annotations getEMPTY() {
            return EMPTY;
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static AnnotationDescriptor findAnnotation(Annotations annotations, FqName fqName) {
            AnnotationDescriptor annotationDescriptor;
            m.g(annotations, "this");
            m.g(fqName, "fqName");
            Iterator<AnnotationDescriptor> it = annotations.iterator();
            while (true) {
                if (!it.hasNext()) {
                    annotationDescriptor = null;
                    break;
                }
                annotationDescriptor = it.next();
                if (m.c(annotationDescriptor.getFqName(), fqName)) {
                    break;
                }
            }
            return annotationDescriptor;
        }

        public static boolean hasAnnotation(Annotations annotations, FqName fqName) {
            m.g(annotations, "this");
            m.g(fqName, "fqName");
            return annotations.mo2207findAnnotation(fqName) != null;
        }
    }

    /* renamed from: findAnnotation */
    AnnotationDescriptor mo2207findAnnotation(FqName fqName);

    boolean hasAnnotation(FqName fqName);

    boolean isEmpty();
}