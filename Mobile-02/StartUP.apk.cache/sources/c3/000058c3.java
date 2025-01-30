package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractTypeConstructor.kt */
/* loaded from: classes3.dex */
public final class AbstractTypeConstructor$supertypes$3 extends o implements l<AbstractTypeConstructor.Supertypes, x> {
    final /* synthetic */ AbstractTypeConstructor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractTypeConstructor.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends o implements l<TypeConstructor, Iterable<? extends KotlinType>> {
        final /* synthetic */ AbstractTypeConstructor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(AbstractTypeConstructor abstractTypeConstructor) {
            super(1);
            this.this$0 = abstractTypeConstructor;
        }

        @Override // kotlin.e0.c.l
        public final Iterable<KotlinType> invoke(TypeConstructor it) {
            Collection computeNeighbours;
            m.g(it, "it");
            computeNeighbours = this.this$0.computeNeighbours(it, true);
            return computeNeighbours;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractTypeConstructor.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass3 extends o implements l<KotlinType, x> {
        final /* synthetic */ AbstractTypeConstructor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(AbstractTypeConstructor abstractTypeConstructor) {
            super(1);
            this.this$0 = abstractTypeConstructor;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(KotlinType kotlinType) {
            invoke2(kotlinType);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(KotlinType it) {
            m.g(it, "it");
            this.this$0.reportScopesLoopError(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTypeConstructor$supertypes$3(AbstractTypeConstructor abstractTypeConstructor) {
        super(1);
        this.this$0 = abstractTypeConstructor;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(AbstractTypeConstructor.Supertypes supertypes) {
        invoke2(supertypes);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(AbstractTypeConstructor.Supertypes supertypes) {
        m.g(supertypes, "supertypes");
        Collection<KotlinType> findLoopsInSupertypesAndDisconnect = this.this$0.getSupertypeLoopChecker().findLoopsInSupertypesAndDisconnect(this.this$0, supertypes.getAllSupertypes(), new AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1(this.this$0), new AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2(this.this$0));
        if (findLoopsInSupertypesAndDisconnect.isEmpty()) {
            KotlinType defaultSupertypeIfEmpty = this.this$0.defaultSupertypeIfEmpty();
            findLoopsInSupertypesAndDisconnect = defaultSupertypeIfEmpty == null ? null : q.b(defaultSupertypeIfEmpty);
            if (findLoopsInSupertypesAndDisconnect == null) {
                findLoopsInSupertypesAndDisconnect = r.g();
            }
        }
        if (this.this$0.getShouldReportCyclicScopeWithCompanionWarning()) {
            SupertypeLoopChecker supertypeLoopChecker = this.this$0.getSupertypeLoopChecker();
            AbstractTypeConstructor abstractTypeConstructor = this.this$0;
            supertypeLoopChecker.findLoopsInSupertypesAndDisconnect(abstractTypeConstructor, findLoopsInSupertypesAndDisconnect, new AnonymousClass2(abstractTypeConstructor), new AnonymousClass3(this.this$0));
        }
        AbstractTypeConstructor abstractTypeConstructor2 = this.this$0;
        List<KotlinType> list = findLoopsInSupertypesAndDisconnect instanceof List ? (List) findLoopsInSupertypesAndDisconnect : null;
        if (list == null) {
            list = z.I0(findLoopsInSupertypesAndDisconnect);
        }
        supertypes.setSupertypesWithoutCycles(abstractTypeConstructor2.processSupertypesWithoutCycles(list));
    }
}