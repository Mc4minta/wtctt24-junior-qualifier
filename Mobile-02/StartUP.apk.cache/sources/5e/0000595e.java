package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: TypeSystemContext.kt */
/* loaded from: classes3.dex */
public final class TypeSystemContextKt {

    /* compiled from: TypeSystemContext.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.valuesCustom().length];
            iArr[Variance.INVARIANT.ordinal()] = 1;
            iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final TypeVariance convertVariance(Variance variance) {
        m.g(variance, "<this>");
        int i2 = WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return TypeVariance.OUT;
                }
                throw new NoWhenBranchMatchedException();
            }
            return TypeVariance.IN;
        }
        return TypeVariance.INV;
    }
}