package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.x;

/* compiled from: SupertypeLoopChecker.kt */
/* loaded from: classes3.dex */
public interface SupertypeLoopChecker {

    /* compiled from: SupertypeLoopChecker.kt */
    /* loaded from: classes3.dex */
    public static final class EMPTY implements SupertypeLoopChecker {
        public static final EMPTY INSTANCE = new EMPTY();

        private EMPTY() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker
        public Collection<KotlinType> findLoopsInSupertypesAndDisconnect(TypeConstructor currentTypeConstructor, Collection<? extends KotlinType> superTypes, l<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> neighbors, l<? super KotlinType, x> reportLoop) {
            m.g(currentTypeConstructor, "currentTypeConstructor");
            m.g(superTypes, "superTypes");
            m.g(neighbors, "neighbors");
            m.g(reportLoop, "reportLoop");
            return superTypes;
        }
    }

    Collection<KotlinType> findLoopsInSupertypesAndDisconnect(TypeConstructor typeConstructor, Collection<? extends KotlinType> collection, l<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> lVar, l<? super KotlinType, x> lVar2);
}