package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import java.util.Objects;
import kotlin.a0.r;
import kotlin.e0.c.a;
import kotlin.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.k;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: NewCapturedType.kt */
/* loaded from: classes3.dex */
public final class NewCapturedTypeConstructor implements CapturedTypeConstructor {
    private final h _supertypes$delegate;
    private final NewCapturedTypeConstructor original;
    private final TypeProjection projection;
    private a<? extends List<? extends UnwrappedType>> supertypesComputation;
    private final TypeParameterDescriptor typeParameter;

    /* compiled from: NewCapturedType.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final class AnonymousClass1 extends o implements a<List<? extends UnwrappedType>> {
        final /* synthetic */ List<UnwrappedType> $supertypes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(List<? extends UnwrappedType> list) {
            super(0);
            this.$supertypes = list;
        }

        @Override // kotlin.e0.c.a
        public final List<? extends UnwrappedType> invoke() {
            return this.$supertypes;
        }
    }

    public NewCapturedTypeConstructor(TypeProjection projection, a<? extends List<? extends UnwrappedType>> aVar, NewCapturedTypeConstructor newCapturedTypeConstructor, TypeParameterDescriptor typeParameterDescriptor) {
        h a;
        m.g(projection, "projection");
        this.projection = projection;
        this.supertypesComputation = aVar;
        this.original = newCapturedTypeConstructor;
        this.typeParameter = typeParameterDescriptor;
        a = k.a(kotlin.m.PUBLICATION, new NewCapturedTypeConstructor$_supertypes$2(this));
        this._supertypes$delegate = a;
    }

    private final List<UnwrappedType> get_supertypes() {
        return (List) this._supertypes$delegate.getValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (m.c(NewCapturedTypeConstructor.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
            NewCapturedTypeConstructor newCapturedTypeConstructor = (NewCapturedTypeConstructor) obj;
            NewCapturedTypeConstructor newCapturedTypeConstructor2 = this.original;
            if (newCapturedTypeConstructor2 == null) {
                newCapturedTypeConstructor2 = this;
            }
            NewCapturedTypeConstructor newCapturedTypeConstructor3 = newCapturedTypeConstructor.original;
            if (newCapturedTypeConstructor3 != null) {
                newCapturedTypeConstructor = newCapturedTypeConstructor3;
            }
            return newCapturedTypeConstructor2 == newCapturedTypeConstructor;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinType type = getProjection().getType();
        m.f(type, "projection.type");
        return TypeUtilsKt.getBuiltIns(type);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getDeclarationDescriptor */
    public ClassifierDescriptor mo2214getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        List<TypeParameterDescriptor> g2;
        g2 = r.g();
        return g2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor
    public TypeProjection getProjection() {
        return this.projection;
    }

    public int hashCode() {
        NewCapturedTypeConstructor newCapturedTypeConstructor = this.original;
        return newCapturedTypeConstructor == null ? super.hashCode() : newCapturedTypeConstructor.hashCode();
    }

    public final void initializeSupertypes(List<? extends UnwrappedType> supertypes) {
        m.g(supertypes, "supertypes");
        a<? extends List<? extends UnwrappedType>> aVar = this.supertypesComputation;
        this.supertypesComputation = new NewCapturedTypeConstructor$initializeSupertypes$2(supertypes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    public String toString() {
        return "CapturedType(" + getProjection() + ')';
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getSupertypes */
    public List<UnwrappedType> mo2215getSupertypes() {
        List<UnwrappedType> g2;
        List<UnwrappedType> list = get_supertypes();
        if (list == null) {
            g2 = r.g();
            return g2;
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public NewCapturedTypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        m.g(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection refine = getProjection().refine(kotlinTypeRefiner);
        m.f(refine, "projection.refine(kotlinTypeRefiner)");
        NewCapturedTypeConstructor$refine$1$1 newCapturedTypeConstructor$refine$1$1 = this.supertypesComputation == null ? null : new NewCapturedTypeConstructor$refine$1$1(this, kotlinTypeRefiner);
        NewCapturedTypeConstructor newCapturedTypeConstructor = this.original;
        if (newCapturedTypeConstructor == null) {
            newCapturedTypeConstructor = this;
        }
        return new NewCapturedTypeConstructor(refine, newCapturedTypeConstructor$refine$1$1, newCapturedTypeConstructor, this.typeParameter);
    }

    public /* synthetic */ NewCapturedTypeConstructor(TypeProjection typeProjection, a aVar, NewCapturedTypeConstructor newCapturedTypeConstructor, TypeParameterDescriptor typeParameterDescriptor, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeProjection, (i2 & 2) != 0 ? null : aVar, (i2 & 4) != 0 ? null : newCapturedTypeConstructor, (i2 & 8) != 0 ? null : typeParameterDescriptor);
    }

    public /* synthetic */ NewCapturedTypeConstructor(TypeProjection typeProjection, List list, NewCapturedTypeConstructor newCapturedTypeConstructor, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeProjection, list, (i2 & 4) != 0 ? null : newCapturedTypeConstructor);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewCapturedTypeConstructor(TypeProjection projection, List<? extends UnwrappedType> supertypes, NewCapturedTypeConstructor newCapturedTypeConstructor) {
        this(projection, new AnonymousClass1(supertypes), newCapturedTypeConstructor, null, 8, null);
        m.g(projection, "projection");
        m.g(supertypes, "supertypes");
    }
}