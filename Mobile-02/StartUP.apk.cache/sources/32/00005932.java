package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: NewCapturedType.kt */
/* loaded from: classes3.dex */
public final class NewCapturedTypeKt {
    private static final List<TypeProjection> captureArguments(UnwrappedType unwrappedType, CaptureStatus captureStatus) {
        boolean z;
        List<o> Q0;
        int r;
        if (unwrappedType.getArguments().size() != unwrappedType.getConstructor().getParameters().size()) {
            return null;
        }
        List<TypeProjection> arguments = unwrappedType.getArguments();
        int i2 = 0;
        boolean z2 = true;
        if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
            Iterator<T> it = arguments.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((TypeProjection) it.next()).getProjectionKind() == Variance.INVARIANT) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    z2 = false;
                    break;
                }
            }
        }
        if (z2) {
            return null;
        }
        List<TypeParameterDescriptor> parameters = unwrappedType.getConstructor().getParameters();
        m.f(parameters, "type.constructor.parameters");
        Q0 = z.Q0(arguments, parameters);
        r = s.r(Q0, 10);
        ArrayList arrayList = new ArrayList(r);
        for (o oVar : Q0) {
            TypeProjection typeProjection = (TypeProjection) oVar.a();
            TypeParameterDescriptor parameter = (TypeParameterDescriptor) oVar.b();
            if (typeProjection.getProjectionKind() != Variance.INVARIANT) {
                UnwrappedType unwrap = (typeProjection.isStarProjection() || typeProjection.getProjectionKind() != Variance.IN_VARIANCE) ? null : typeProjection.getType().unwrap();
                m.f(parameter, "parameter");
                typeProjection = TypeUtilsKt.asTypeProjection(new NewCapturedType(captureStatus, unwrap, typeProjection, parameter));
            }
            arrayList.add(typeProjection);
        }
        TypeSubstitutor buildSubstitutor = TypeConstructorSubstitution.Companion.create(unwrappedType.getConstructor(), arrayList).buildSubstitutor();
        int size = arguments.size() - 1;
        if (size >= 0) {
            while (true) {
                int i3 = i2 + 1;
                TypeProjection typeProjection2 = arguments.get(i2);
                TypeProjection typeProjection3 = (TypeProjection) arrayList.get(i2);
                if (typeProjection2.getProjectionKind() != Variance.INVARIANT) {
                    List<KotlinType> upperBounds = unwrappedType.getConstructor().getParameters().get(i2).getUpperBounds();
                    m.f(upperBounds, "type.constructor.parameters[index].upperBounds");
                    ArrayList arrayList2 = new ArrayList();
                    for (KotlinType kotlinType : upperBounds) {
                        arrayList2.add(NewKotlinTypeChecker.Companion.getDefault().transformToNewType(buildSubstitutor.safeSubstitute(kotlinType, Variance.INVARIANT).unwrap()));
                    }
                    if (!typeProjection2.isStarProjection() && typeProjection2.getProjectionKind() == Variance.OUT_VARIANCE) {
                        arrayList2.add(NewKotlinTypeChecker.Companion.getDefault().transformToNewType(typeProjection2.getType().unwrap()));
                    }
                    ((NewCapturedType) typeProjection3.getType()).getConstructor().initializeSupertypes(arrayList2);
                }
                if (i3 > size) {
                    break;
                }
                i2 = i3;
            }
        }
        return arrayList;
    }

    public static final SimpleType captureFromArguments(SimpleType type, CaptureStatus status) {
        m.g(type, "type");
        m.g(status, "status");
        List<TypeProjection> captureArguments = captureArguments(type, status);
        if (captureArguments == null) {
            return null;
        }
        return replaceArguments(type, captureArguments);
    }

    private static final SimpleType replaceArguments(UnwrappedType unwrappedType, List<? extends TypeProjection> list) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        return KotlinTypeFactory.simpleType$default(unwrappedType.getAnnotations(), unwrappedType.getConstructor(), list, unwrappedType.isMarkedNullable(), null, 16, null);
    }
}