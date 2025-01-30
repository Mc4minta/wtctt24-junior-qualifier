package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.a0.m0;
import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.u;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaPackageFragment.kt */
/* loaded from: classes3.dex */
public final class LazyJavaPackageFragment$binaryClasses$2 extends o implements a<Map<String, ? extends KotlinJvmBinaryClass>> {
    final /* synthetic */ LazyJavaPackageFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragment$binaryClasses$2(LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(0);
        this.this$0 = lazyJavaPackageFragment;
    }

    @Override // kotlin.e0.c.a
    public final Map<String, ? extends KotlinJvmBinaryClass> invoke() {
        LazyJavaResolverContext lazyJavaResolverContext;
        Map<String, ? extends KotlinJvmBinaryClass> r;
        LazyJavaResolverContext lazyJavaResolverContext2;
        lazyJavaResolverContext = this.this$0.f17398c;
        PackagePartProvider packagePartProvider = lazyJavaResolverContext.getComponents().getPackagePartProvider();
        String asString = this.this$0.getFqName().asString();
        m.f(asString, "fqName.asString()");
        List<String> findPackageParts = packagePartProvider.findPackageParts(asString);
        LazyJavaPackageFragment lazyJavaPackageFragment = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (String str : findPackageParts) {
            ClassId classId = ClassId.topLevel(JvmClassName.byInternalName(str).getFqNameForTopLevelClassMaybeWithDollars());
            m.f(classId, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
            lazyJavaResolverContext2 = lazyJavaPackageFragment.f17398c;
            KotlinJvmBinaryClass findKotlinClass = KotlinClassFinderKt.findKotlinClass(lazyJavaResolverContext2.getComponents().getKotlinClassFinder(), classId);
            kotlin.o a = findKotlinClass == null ? null : u.a(str, findKotlinClass);
            if (a != null) {
                arrayList.add(a);
            }
        }
        r = m0.r(arrayList);
        return r;
    }
}