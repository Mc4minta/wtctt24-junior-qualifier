package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.k0.h;
import kotlin.k0.k;
import kotlin.k0.p;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: Annotations.kt */
/* loaded from: classes3.dex */
public final class CompositeAnnotations implements Annotations {
    private final List<Annotations> delegates;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeAnnotations(List<? extends Annotations> delegates) {
        m.g(delegates, "delegates");
        this.delegates = delegates;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* renamed from: findAnnotation */
    public AnnotationDescriptor mo2207findAnnotation(FqName fqName) {
        h M;
        h w;
        m.g(fqName, "fqName");
        M = z.M(this.delegates);
        w = p.w(M, new CompositeAnnotations$findAnnotation$1(fqName));
        return (AnnotationDescriptor) k.p(w);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(FqName fqName) {
        h<Annotations> M;
        m.g(fqName, "fqName");
        M = z.M(this.delegates);
        for (Annotations annotations : M) {
            if (annotations.hasAnnotation(fqName)) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        List<Annotations> list = this.delegates;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        for (Annotations annotations : list) {
            if (!annotations.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        h M;
        h q;
        M = z.M(this.delegates);
        q = p.q(M, CompositeAnnotations$iterator$1.INSTANCE);
        return q.iterator();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CompositeAnnotations(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations... r2) {
        /*
            r1 = this;
            java.lang.String r0 = "delegates"
            kotlin.jvm.internal.m.g(r2, r0)
            java.util.List r2 = kotlin.a0.j.e0(r2)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations.<init>(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations[]):void");
    }
}