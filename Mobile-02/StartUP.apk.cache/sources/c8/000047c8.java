package e.g.a.c.i.x;

import android.util.SparseArray;
import e.g.a.c.d;
import java.util.EnumMap;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class a {
    private static SparseArray<d> a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private static EnumMap<d, Integer> f13073b;

    static {
        EnumMap<d, Integer> enumMap = new EnumMap<>(d.class);
        f13073b = enumMap;
        enumMap.put((EnumMap<d, Integer>) d.DEFAULT, (d) 0);
        f13073b.put((EnumMap<d, Integer>) d.VERY_LOW, (d) 1);
        f13073b.put((EnumMap<d, Integer>) d.HIGHEST, (d) 2);
        for (d dVar : f13073b.keySet()) {
            a.append(f13073b.get(dVar).intValue(), dVar);
        }
    }

    public static int a(d dVar) {
        Integer num = f13073b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + dVar);
    }

    public static d b(int i2) {
        d dVar = a.get(i2);
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i2);
    }
}