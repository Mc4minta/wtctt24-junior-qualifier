package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.a0.s0;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: DescriptorRenderer.kt */
/* loaded from: classes3.dex */
public final class ExcludedTypeAnnotations {
    public static final ExcludedTypeAnnotations INSTANCE = new ExcludedTypeAnnotations();
    private static final Set<FqName> internalAnnotationsForResolve;

    static {
        Set<FqName> e2;
        e2 = s0.e(new FqName("kotlin.internal.NoInfer"), new FqName("kotlin.internal.Exact"));
        internalAnnotationsForResolve = e2;
    }

    private ExcludedTypeAnnotations() {
    }

    public final Set<FqName> getInternalAnnotationsForResolve() {
        return internalAnnotationsForResolve;
    }
}