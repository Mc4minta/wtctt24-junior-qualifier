package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.List;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: KotlinTypeRefiner.kt */
/* loaded from: classes3.dex */
public final class KotlinTypeRefinerKt {
    private static final ModuleCapability<Ref<KotlinTypeRefiner>> REFINER_CAPABILITY = new ModuleCapability<>("KotlinTypeRefiner");

    public static final ModuleCapability<Ref<KotlinTypeRefiner>> getREFINER_CAPABILITY() {
        return REFINER_CAPABILITY;
    }

    public static final List<KotlinType> refineTypes(KotlinTypeRefiner kotlinTypeRefiner, Iterable<? extends KotlinType> types) {
        int r;
        m.g(kotlinTypeRefiner, "<this>");
        m.g(types, "types");
        r = s.r(types, 10);
        ArrayList arrayList = new ArrayList(r);
        for (KotlinType kotlinType : types) {
            arrayList.add(kotlinTypeRefiner.refineType(kotlinType));
        }
        return arrayList;
    }
}