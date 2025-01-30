package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.a0.n;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: CapturedTypeConstructor.kt */
/* loaded from: classes3.dex */
public final class CapturedTypeConstructorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final TypeProjection createCapturedIfNeeded(TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor == null || typeProjection.getProjectionKind() == Variance.INVARIANT) {
            return typeProjection;
        }
        if (typeParameterDescriptor.getVariance() == typeProjection.getProjectionKind()) {
            if (typeProjection.isStarProjection()) {
                StorageManager NO_LOCKS = LockBasedStorageManager.NO_LOCKS;
                m.f(NO_LOCKS, "NO_LOCKS");
                return new TypeProjectionImpl(new LazyWrappedType(NO_LOCKS, new CapturedTypeConstructorKt$createCapturedIfNeeded$1(typeProjection)));
            }
            return new TypeProjectionImpl(typeProjection.getType());
        }
        return new TypeProjectionImpl(createCapturedType(typeProjection));
    }

    public static final KotlinType createCapturedType(TypeProjection typeProjection) {
        m.g(typeProjection, "typeProjection");
        return new CapturedType(typeProjection, null, false, null, 14, null);
    }

    public static final boolean isCaptured(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        return kotlinType.getConstructor() instanceof CapturedTypeConstructor;
    }

    public static final TypeSubstitution wrapWithCapturingSubstitution(final TypeSubstitution typeSubstitution, final boolean z) {
        List<o> s0;
        int r;
        m.g(typeSubstitution, "<this>");
        if (typeSubstitution instanceof IndexedParametersSubstitution) {
            IndexedParametersSubstitution indexedParametersSubstitution = (IndexedParametersSubstitution) typeSubstitution;
            TypeParameterDescriptor[] parameters = indexedParametersSubstitution.getParameters();
            s0 = n.s0(indexedParametersSubstitution.getArguments(), indexedParametersSubstitution.getParameters());
            r = s.r(s0, 10);
            ArrayList arrayList = new ArrayList(r);
            for (o oVar : s0) {
                arrayList.add(createCapturedIfNeeded((TypeProjection) oVar.c(), (TypeParameterDescriptor) oVar.d()));
            }
            Object[] array = arrayList.toArray(new TypeProjection[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return new IndexedParametersSubstitution(parameters, (TypeProjection[]) array, z);
        }
        return new DelegatedTypeSubstitution(z, typeSubstitution) { // from class: kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt$wrapWithCapturingSubstitution$2
            final /* synthetic */ boolean $needApproximation;
            final /* synthetic */ TypeSubstitution $this_wrapWithCapturingSubstitution;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(typeSubstitution);
                this.$this_wrapWithCapturingSubstitution = typeSubstitution;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution, kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            public boolean approximateContravariantCapturedTypes() {
                return this.$needApproximation;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution, kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            /* renamed from: get */
            public TypeProjection mo2219get(KotlinType key) {
                TypeProjection createCapturedIfNeeded;
                m.g(key, "key");
                TypeProjection mo2219get = super.mo2219get(key);
                if (mo2219get == null) {
                    return null;
                }
                ClassifierDescriptor mo2214getDeclarationDescriptor = key.getConstructor().mo2214getDeclarationDescriptor();
                createCapturedIfNeeded = CapturedTypeConstructorKt.createCapturedIfNeeded(mo2219get, mo2214getDeclarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) mo2214getDeclarationDescriptor : null);
                return createCapturedIfNeeded;
            }
        };
    }

    public static /* synthetic */ TypeSubstitution wrapWithCapturingSubstitution$default(TypeSubstitution typeSubstitution, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        return wrapWithCapturingSubstitution(typeSubstitution, z);
    }
}