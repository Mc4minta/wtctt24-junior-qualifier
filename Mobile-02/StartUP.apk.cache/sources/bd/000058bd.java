package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: AbstractTypeConstructor.kt */
/* loaded from: classes3.dex */
public abstract class AbstractTypeConstructor implements TypeConstructor {
    private final boolean shouldReportCyclicScopeWithCompanionWarning;
    private final NotNullLazyValue<Supertypes> supertypes;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractTypeConstructor.kt */
    /* loaded from: classes3.dex */
    public final class ModuleViewTypeConstructor implements TypeConstructor {
        private final KotlinTypeRefiner kotlinTypeRefiner;
        private final h refinedSupertypes$delegate;
        final /* synthetic */ AbstractTypeConstructor this$0;

        public ModuleViewTypeConstructor(AbstractTypeConstructor this$0, KotlinTypeRefiner kotlinTypeRefiner) {
            h a;
            m.g(this$0, "this$0");
            m.g(kotlinTypeRefiner, "kotlinTypeRefiner");
            this.this$0 = this$0;
            this.kotlinTypeRefiner = kotlinTypeRefiner;
            a = k.a(kotlin.m.PUBLICATION, new AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2(this, this$0));
            this.refinedSupertypes$delegate = a;
        }

        private final List<KotlinType> getRefinedSupertypes() {
            return (List) this.refinedSupertypes$delegate.getValue();
        }

        public boolean equals(Object obj) {
            return this.this$0.equals(obj);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns builtIns = this.this$0.getBuiltIns();
            m.f(builtIns, "this@AbstractTypeConstructor.builtIns");
            return builtIns;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* renamed from: getDeclarationDescriptor */
        public ClassifierDescriptor mo2214getDeclarationDescriptor() {
            return this.this$0.mo2214getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> parameters = this.this$0.getParameters();
            m.f(parameters, "this@AbstractTypeConstructor.parameters");
            return parameters;
        }

        public int hashCode() {
            return this.this$0.hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return this.this$0.isDenotable();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
            m.g(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this.this$0.refine(kotlinTypeRefiner);
        }

        public String toString() {
            return this.this$0.toString();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* renamed from: getSupertypes */
        public List<KotlinType> mo2215getSupertypes() {
            return getRefinedSupertypes();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractTypeConstructor.kt */
    /* loaded from: classes3.dex */
    public static final class Supertypes {
        private final Collection<KotlinType> allSupertypes;
        private List<? extends KotlinType> supertypesWithoutCycles;

        /* JADX WARN: Multi-variable type inference failed */
        public Supertypes(Collection<? extends KotlinType> allSupertypes) {
            List<? extends KotlinType> b2;
            m.g(allSupertypes, "allSupertypes");
            this.allSupertypes = allSupertypes;
            b2 = q.b(ErrorUtils.ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES);
            this.supertypesWithoutCycles = b2;
        }

        public final Collection<KotlinType> getAllSupertypes() {
            return this.allSupertypes;
        }

        public final List<KotlinType> getSupertypesWithoutCycles() {
            return this.supertypesWithoutCycles;
        }

        public final void setSupertypesWithoutCycles(List<? extends KotlinType> list) {
            m.g(list, "<set-?>");
            this.supertypesWithoutCycles = list;
        }
    }

    public AbstractTypeConstructor(StorageManager storageManager) {
        m.g(storageManager, "storageManager");
        this.supertypes = storageManager.createLazyValueWithPostCompute(new AbstractTypeConstructor$supertypes$1(this), AbstractTypeConstructor$supertypes$2.INSTANCE, new AbstractTypeConstructor$supertypes$3(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<KotlinType> computeNeighbours(TypeConstructor typeConstructor, boolean z) {
        AbstractTypeConstructor abstractTypeConstructor = typeConstructor instanceof AbstractTypeConstructor ? (AbstractTypeConstructor) typeConstructor : null;
        List t0 = abstractTypeConstructor != null ? z.t0(((Supertypes) abstractTypeConstructor.supertypes.invoke()).getAllSupertypes(), abstractTypeConstructor.getAdditionalNeighboursInSupertypeGraph(z)) : null;
        if (t0 == null) {
            Collection<KotlinType> supertypes = typeConstructor.mo2215getSupertypes();
            m.f(supertypes, "supertypes");
            return supertypes;
        }
        return t0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Collection<KotlinType> computeSupertypes();

    /* JADX INFO: Access modifiers changed from: protected */
    public KotlinType defaultSupertypeIfEmpty() {
        return null;
    }

    protected Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean z) {
        List g2;
        g2 = r.g();
        return g2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getDeclarationDescriptor */
    public abstract ClassifierDescriptor mo2214getDeclarationDescriptor();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getShouldReportCyclicScopeWithCompanionWarning() {
        return this.shouldReportCyclicScopeWithCompanionWarning;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract SupertypeLoopChecker getSupertypeLoopChecker();

    /* JADX INFO: Access modifiers changed from: protected */
    public List<KotlinType> processSupertypesWithoutCycles(List<KotlinType> supertypes) {
        m.g(supertypes, "supertypes");
        return supertypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        m.g(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new ModuleViewTypeConstructor(this, kotlinTypeRefiner);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportScopesLoopError(KotlinType type) {
        m.g(type, "type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportSupertypeLoopError(KotlinType type) {
        m.g(type, "type");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getSupertypes */
    public List<KotlinType> mo2215getSupertypes() {
        return ((Supertypes) this.supertypes.invoke()).getSupertypesWithoutCycles();
    }
}