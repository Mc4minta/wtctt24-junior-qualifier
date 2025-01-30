package kotlin.j0.b0;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.a0.p;
import kotlin.j0.e;
import kotlin.j0.q;
import kotlin.j0.r;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;

/* compiled from: KTypesJvm.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final kotlin.j0.d<?> a(e jvmErasure) {
        Object obj;
        kotlin.j0.d<?> b2;
        boolean z;
        m.g(jvmErasure, "$this$jvmErasure");
        if (jvmErasure instanceof kotlin.j0.d) {
            return (kotlin.j0.d) jvmErasure;
        }
        if (jvmErasure instanceof r) {
            List<q> upperBounds = ((r) jvmErasure).getUpperBounds();
            Iterator<T> it = upperBounds.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                q qVar = (q) next;
                Objects.requireNonNull(qVar, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                Object mo2214getDeclarationDescriptor = ((KTypeImpl) qVar).getType().getConstructor().mo2214getDeclarationDescriptor();
                ClassDescriptor classDescriptor = (ClassDescriptor) (mo2214getDeclarationDescriptor instanceof ClassDescriptor ? mo2214getDeclarationDescriptor : null);
                if (classDescriptor == null || classDescriptor.getKind() == ClassKind.INTERFACE || classDescriptor.getKind() == ClassKind.ANNOTATION_CLASS) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    obj = next;
                    break;
                }
            }
            q qVar2 = (q) obj;
            if (qVar2 == null) {
                qVar2 = (q) p.a0(upperBounds);
            }
            return (qVar2 == null || (b2 = b(qVar2)) == null) ? e0.b(Object.class) : b2;
        }
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + jvmErasure);
    }

    public static final kotlin.j0.d<?> b(q jvmErasure) {
        kotlin.j0.d<?> a;
        m.g(jvmErasure, "$this$jvmErasure");
        e classifier = jvmErasure.getClassifier();
        if (classifier == null || (a = a(classifier)) == null) {
            throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + jvmErasure);
        }
        return a;
    }
}