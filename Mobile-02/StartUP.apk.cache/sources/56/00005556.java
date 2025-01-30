package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmPackageScope.kt */
/* loaded from: classes3.dex */
public final class JvmPackageScope$kotlinScopes$2 extends o implements a<MemberScope[]> {
    final /* synthetic */ JvmPackageScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmPackageScope$kotlinScopes$2(JvmPackageScope jvmPackageScope) {
        super(0);
        this.this$0 = jvmPackageScope;
    }

    @Override // kotlin.e0.c.a
    public final MemberScope[] invoke() {
        LazyJavaPackageFragment lazyJavaPackageFragment;
        LazyJavaResolverContext lazyJavaResolverContext;
        LazyJavaPackageFragment lazyJavaPackageFragment2;
        lazyJavaPackageFragment = this.this$0.packageFragment;
        Collection<KotlinJvmBinaryClass> values = lazyJavaPackageFragment.getBinaryClasses$descriptors_jvm().values();
        JvmPackageScope jvmPackageScope = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (KotlinJvmBinaryClass kotlinJvmBinaryClass : values) {
            lazyJavaResolverContext = jvmPackageScope.f17395c;
            DeserializedDescriptorResolver deserializedDescriptorResolver = lazyJavaResolverContext.getComponents().getDeserializedDescriptorResolver();
            lazyJavaPackageFragment2 = jvmPackageScope.packageFragment;
            MemberScope createKotlinPackagePartScope = deserializedDescriptorResolver.createKotlinPackagePartScope(lazyJavaPackageFragment2, kotlinJvmBinaryClass);
            if (createKotlinPackagePartScope != null) {
                arrayList.add(createKotlinPackagePartScope);
            }
        }
        Object[] array = ScopeUtilsKt.listOfNonEmptyScopes(arrayList).toArray(new MemberScope[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (MemberScope[]) array;
    }
}