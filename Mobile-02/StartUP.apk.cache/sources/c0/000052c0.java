package kotlin.reflect.full;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.r;
import kotlin.j0.e;
import kotlin.j0.q;
import kotlin.j0.s;
import kotlin.j0.u;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.KClassifierImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionBase;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: KClassifiers.kt */
/* loaded from: classes3.dex */
public final class c {
    private static final SimpleType a(Annotations annotations, TypeConstructor typeConstructor, List<s> list, boolean z) {
        int r;
        TypeProjectionBase typeProjectionImpl;
        List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
        m.f(parameters, "typeConstructor.parameters");
        r = kotlin.a0.s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                r.q();
            }
            s sVar = (s) obj;
            KTypeImpl kTypeImpl = (KTypeImpl) sVar.c();
            KotlinType type = kTypeImpl != null ? kTypeImpl.getType() : null;
            u d2 = sVar.d();
            if (d2 == null) {
                TypeParameterDescriptor typeParameterDescriptor = parameters.get(i2);
                m.f(typeParameterDescriptor, "parameters[index]");
                typeProjectionImpl = new StarProjectionImpl(typeParameterDescriptor);
            } else {
                int i4 = b.a[d2.ordinal()];
                if (i4 == 1) {
                    Variance variance = Variance.INVARIANT;
                    m.e(type);
                    typeProjectionImpl = new TypeProjectionImpl(variance, type);
                } else if (i4 == 2) {
                    Variance variance2 = Variance.IN_VARIANCE;
                    m.e(type);
                    typeProjectionImpl = new TypeProjectionImpl(variance2, type);
                } else if (i4 == 3) {
                    Variance variance3 = Variance.OUT_VARIANCE;
                    m.e(type);
                    typeProjectionImpl = new TypeProjectionImpl(variance3, type);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            arrayList.add(typeProjectionImpl);
            i2 = i3;
        }
        return KotlinTypeFactory.simpleType$default(annotations, typeConstructor, arrayList, z, null, 16, null);
    }

    public static final q b(e createType, List<s> arguments, boolean z, List<? extends Annotation> annotations) {
        ClassifierDescriptor descriptor;
        m.g(createType, "$this$createType");
        m.g(arguments, "arguments");
        m.g(annotations, "annotations");
        KClassifierImpl kClassifierImpl = (KClassifierImpl) (!(createType instanceof KClassifierImpl) ? null : createType);
        if (kClassifierImpl != null && (descriptor = kClassifierImpl.getDescriptor()) != null) {
            TypeConstructor typeConstructor = descriptor.getTypeConstructor();
            m.f(typeConstructor, "descriptor.typeConstructor");
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            m.f(parameters, "typeConstructor.parameters");
            if (parameters.size() == arguments.size()) {
                return new KTypeImpl(a(annotations.isEmpty() ? Annotations.Companion.getEMPTY() : Annotations.Companion.getEMPTY(), typeConstructor, arguments, z), null, 2, null);
            }
            throw new IllegalArgumentException("Class declares " + parameters.size() + " type parameters, but " + arguments.size() + " were provided.");
        }
        throw new KotlinReflectionInternalError("Cannot create type for an unsupported classifier: " + createType + " (" + createType.getClass() + ')');
    }
}