package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: CompanionObjectMapping.kt */
/* loaded from: classes3.dex */
public final class CompanionObjectMapping {
    public static final CompanionObjectMapping INSTANCE = new CompanionObjectMapping();
    private static final Set<ClassId> classIds;

    static {
        int r;
        List u0;
        List u02;
        List<FqName> u03;
        Set<PrimitiveType> set = PrimitiveType.NUMBER_TYPES;
        StandardNames standardNames = StandardNames.INSTANCE;
        r = s.r(set, 10);
        ArrayList arrayList = new ArrayList(r);
        for (PrimitiveType primitiveType : set) {
            arrayList.add(StandardNames.getPrimitiveFqName(primitiveType));
        }
        FqName safe = StandardNames.FqNames.string.toSafe();
        m.f(safe, "string.toSafe()");
        u0 = z.u0(arrayList, safe);
        FqName safe2 = StandardNames.FqNames._boolean.toSafe();
        m.f(safe2, "_boolean.toSafe()");
        u02 = z.u0(u0, safe2);
        FqName safe3 = StandardNames.FqNames._enum.toSafe();
        m.f(safe3, "_enum.toSafe()");
        u03 = z.u0(u02, safe3);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (FqName fqName : u03) {
            linkedHashSet.add(ClassId.topLevel(fqName));
        }
        classIds = linkedHashSet;
    }

    private CompanionObjectMapping() {
    }

    public final Set<ClassId> allClassesWithIntrinsicCompanions() {
        return classIds;
    }

    public final Set<ClassId> getClassIds() {
        return classIds;
    }
}