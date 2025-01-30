package kotlin.reflect.jvm.internal.impl.types;

/* compiled from: Variance.kt */
/* loaded from: classes3.dex */
public enum Variance {
    INVARIANT("", true, true, 0),
    IN_VARIANCE("in", true, false, -1),
    OUT_VARIANCE("out", false, true, 1);
    
    private final boolean allowsInPosition;
    private final boolean allowsOutPosition;
    private final String label;
    private final int superpositionFactor;

    Variance(String str, boolean z, boolean z2, int i2) {
        this.label = str;
        this.allowsInPosition = z;
        this.allowsOutPosition = z2;
        this.superpositionFactor = i2;
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static Variance[] valuesCustom() {
        Variance[] valuesCustom = values();
        Variance[] varianceArr = new Variance[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, varianceArr, 0, valuesCustom.length);
        return varianceArr;
    }

    public final boolean getAllowsOutPosition() {
        return this.allowsOutPosition;
    }

    public final String getLabel() {
        return this.label;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.label;
    }
}