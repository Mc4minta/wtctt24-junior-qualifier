package kotlin.m0;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.m;

/* compiled from: DurationUnitJvm.kt */
/* loaded from: classes3.dex */
class c {
    public static final double a(double d2, TimeUnit sourceUnit, TimeUnit targetUnit) {
        m.g(sourceUnit, "sourceUnit");
        m.g(targetUnit, "targetUnit");
        long convert = targetUnit.convert(1L, sourceUnit);
        return convert > 0 ? d2 * convert : d2 / sourceUnit.convert(1L, targetUnit);
    }

    public static final long b(long j2, TimeUnit sourceUnit, TimeUnit targetUnit) {
        m.g(sourceUnit, "sourceUnit");
        m.g(targetUnit, "targetUnit");
        return targetUnit.convert(j2, sourceUnit);
    }

    public static final long c(long j2, TimeUnit sourceUnit, TimeUnit targetUnit) {
        m.g(sourceUnit, "sourceUnit");
        m.g(targetUnit, "targetUnit");
        return targetUnit.convert(j2, sourceUnit);
    }
}