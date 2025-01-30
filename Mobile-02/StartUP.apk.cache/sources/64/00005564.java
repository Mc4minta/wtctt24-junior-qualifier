package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.e0.c.l;
import kotlin.j0.f;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaClassMemberScope.kt */
/* loaded from: classes3.dex */
/* synthetic */ class LazyJavaClassMemberScope$computeNonDeclaredFunctions$4 extends j implements l<Name, Collection<? extends SimpleFunctionDescriptor>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LazyJavaClassMemberScope$computeNonDeclaredFunctions$4(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(1, lazyJavaClassMemberScope);
    }

    @Override // kotlin.jvm.internal.c, kotlin.j0.c
    public final String getName() {
        return "searchMethodsInSupertypesWithoutBuiltinMagic";
    }

    @Override // kotlin.jvm.internal.c
    public final f getOwner() {
        return e0.b(LazyJavaClassMemberScope.class);
    }

    @Override // kotlin.jvm.internal.c
    public final String getSignature() {
        return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
    }

    @Override // kotlin.e0.c.l
    public final Collection<SimpleFunctionDescriptor> invoke(Name p0) {
        Collection<SimpleFunctionDescriptor> searchMethodsInSupertypesWithoutBuiltinMagic;
        m.g(p0, "p0");
        searchMethodsInSupertypesWithoutBuiltinMagic = ((LazyJavaClassMemberScope) this.receiver).searchMethodsInSupertypesWithoutBuiltinMagic(p0);
        return searchMethodsInSupertypesWithoutBuiltinMagic;
    }
}