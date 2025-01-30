package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a0.s;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaPackageFragment.kt */
/* loaded from: classes3.dex */
public final class LazyJavaPackageFragment$subPackages$1 extends o implements a<List<? extends FqName>> {
    final /* synthetic */ LazyJavaPackageFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragment$subPackages$1(LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(0);
        this.this$0 = lazyJavaPackageFragment;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends FqName> invoke() {
        JavaPackage javaPackage;
        int r;
        javaPackage = this.this$0.jPackage;
        Collection<JavaPackage> subPackages = javaPackage.getSubPackages();
        r = s.r(subPackages, 10);
        ArrayList arrayList = new ArrayList(r);
        for (JavaPackage javaPackage2 : subPackages) {
            arrayList.add(javaPackage2.getFqName());
        }
        return arrayList;
    }
}