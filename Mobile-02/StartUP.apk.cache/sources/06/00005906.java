package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.a0.m0;
import kotlin.a0.p;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* compiled from: TypeSubstitution.kt */
/* loaded from: classes3.dex */
public abstract class TypeConstructorSubstitution extends TypeSubstitution {
    public static final Companion Companion = new Companion(null);

    /* compiled from: TypeSubstitution.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ TypeConstructorSubstitution createByConstructorsMap$default(Companion companion, Map map, boolean z, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            return companion.createByConstructorsMap(map, z);
        }

        public final TypeSubstitution create(KotlinType kotlinType) {
            m.g(kotlinType, "kotlinType");
            return create(kotlinType.getConstructor(), kotlinType.getArguments());
        }

        public final TypeConstructorSubstitution createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> map) {
            m.g(map, "map");
            return createByConstructorsMap$default(this, map, false, 2, null);
        }

        public final TypeConstructorSubstitution createByConstructorsMap(final Map<TypeConstructor, ? extends TypeProjection> map, final boolean z) {
            m.g(map, "map");
            return new TypeConstructorSubstitution() { // from class: kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution$Companion$createByConstructorsMap$1
                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
                public boolean approximateCapturedTypes() {
                    return z;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution
                public TypeProjection get(TypeConstructor key) {
                    m.g(key, "key");
                    return map.get(key);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
                public boolean isEmpty() {
                    return map.isEmpty();
                }
            };
        }

        public final TypeSubstitution create(TypeConstructor typeConstructor, List<? extends TypeProjection> arguments) {
            int r;
            List Q0;
            Map r2;
            m.g(typeConstructor, "typeConstructor");
            m.g(arguments, "arguments");
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            m.f(parameters, "typeConstructor.parameters");
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) p.l0(parameters);
            if (m.c(typeParameterDescriptor == null ? null : Boolean.valueOf(typeParameterDescriptor.isCapturedFromOuterDeclaration()), Boolean.TRUE)) {
                List<TypeParameterDescriptor> parameters2 = typeConstructor.getParameters();
                m.f(parameters2, "typeConstructor.parameters");
                r = s.r(parameters2, 10);
                ArrayList arrayList = new ArrayList(r);
                for (TypeParameterDescriptor typeParameterDescriptor2 : parameters2) {
                    arrayList.add(typeParameterDescriptor2.getTypeConstructor());
                }
                Q0 = z.Q0(arrayList, arguments);
                r2 = m0.r(Q0);
                return createByConstructorsMap$default(this, r2, false, 2, null);
            }
            return new IndexedParametersSubstitution(parameters, arguments);
        }
    }

    public static final TypeSubstitution create(TypeConstructor typeConstructor, List<? extends TypeProjection> list) {
        return Companion.create(typeConstructor, list);
    }

    public static final TypeConstructorSubstitution createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> map) {
        return Companion.createByConstructorsMap(map);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* renamed from: get */
    public TypeProjection mo2219get(KotlinType key) {
        m.g(key, "key");
        return get(key.getConstructor());
    }

    public abstract TypeProjection get(TypeConstructor typeConstructor);
}