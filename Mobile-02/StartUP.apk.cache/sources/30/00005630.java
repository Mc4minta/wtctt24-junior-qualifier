package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.a0.r;
import kotlin.jvm.internal.m;

/* compiled from: PackagePartProvider.kt */
/* loaded from: classes3.dex */
public interface PackagePartProvider {

    /* compiled from: PackagePartProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Empty implements PackagePartProvider {
        public static final Empty INSTANCE = new Empty();

        private Empty() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider
        public List<String> findPackageParts(String packageFqName) {
            List<String> g2;
            m.g(packageFqName, "packageFqName");
            g2 = r.g();
            return g2;
        }
    }

    List<String> findPackageParts(String str);
}