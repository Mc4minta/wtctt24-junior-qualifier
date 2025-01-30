package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.a0.m0;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* compiled from: TypeAliasExpansion.kt */
/* loaded from: classes3.dex */
public final class TypeAliasExpansion {
    public static final Companion Companion = new Companion(null);
    private final List<TypeProjection> arguments;
    private final TypeAliasDescriptor descriptor;
    private final Map<TypeParameterDescriptor, TypeProjection> mapping;
    private final TypeAliasExpansion parent;

    /* compiled from: TypeAliasExpansion.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TypeAliasExpansion create(TypeAliasExpansion typeAliasExpansion, TypeAliasDescriptor typeAliasDescriptor, List<? extends TypeProjection> arguments) {
            int r;
            List Q0;
            Map r2;
            m.g(typeAliasDescriptor, "typeAliasDescriptor");
            m.g(arguments, "arguments");
            List<TypeParameterDescriptor> parameters = typeAliasDescriptor.getTypeConstructor().getParameters();
            m.f(parameters, "typeAliasDescriptor.typeConstructor.parameters");
            r = s.r(parameters, 10);
            ArrayList arrayList = new ArrayList(r);
            for (TypeParameterDescriptor typeParameterDescriptor : parameters) {
                arrayList.add(typeParameterDescriptor.getOriginal());
            }
            Q0 = z.Q0(arrayList, arguments);
            r2 = m0.r(Q0);
            return new TypeAliasExpansion(typeAliasExpansion, typeAliasDescriptor, arguments, r2, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeAliasExpansion(TypeAliasExpansion typeAliasExpansion, TypeAliasDescriptor typeAliasDescriptor, List<? extends TypeProjection> list, Map<TypeParameterDescriptor, ? extends TypeProjection> map) {
        this.parent = typeAliasExpansion;
        this.descriptor = typeAliasDescriptor;
        this.arguments = list;
        this.mapping = map;
    }

    public /* synthetic */ TypeAliasExpansion(TypeAliasExpansion typeAliasExpansion, TypeAliasDescriptor typeAliasDescriptor, List list, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeAliasExpansion, typeAliasDescriptor, list, map);
    }

    public final List<TypeProjection> getArguments() {
        return this.arguments;
    }

    public final TypeAliasDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final TypeProjection getReplacement(TypeConstructor constructor) {
        m.g(constructor, "constructor");
        ClassifierDescriptor mo2214getDeclarationDescriptor = constructor.mo2214getDeclarationDescriptor();
        if (mo2214getDeclarationDescriptor instanceof TypeParameterDescriptor) {
            return this.mapping.get(mo2214getDeclarationDescriptor);
        }
        return null;
    }

    public final boolean isRecursion(TypeAliasDescriptor descriptor) {
        m.g(descriptor, "descriptor");
        if (!m.c(this.descriptor, descriptor)) {
            TypeAliasExpansion typeAliasExpansion = this.parent;
            if (!(typeAliasExpansion == null ? false : typeAliasExpansion.isRecursion(descriptor))) {
                return false;
            }
        }
        return true;
    }
}