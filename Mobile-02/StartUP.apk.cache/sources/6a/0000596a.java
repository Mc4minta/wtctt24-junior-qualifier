package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.m;

/* compiled from: CapturedTypeApproximation.kt */
/* loaded from: classes3.dex */
public final class ApproximationBounds<T> {
    private final T lower;
    private final T upper;

    public ApproximationBounds(T t, T t2) {
        this.lower = t;
        this.upper = t2;
    }

    public final T component1() {
        return this.lower;
    }

    public final T component2() {
        return this.upper;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ApproximationBounds) {
            ApproximationBounds approximationBounds = (ApproximationBounds) obj;
            return m.c(this.lower, approximationBounds.lower) && m.c(this.upper, approximationBounds.upper);
        }
        return false;
    }

    public final T getLower() {
        return this.lower;
    }

    public final T getUpper() {
        return this.upper;
    }

    public int hashCode() {
        T t = this.lower;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.upper;
        return hashCode + (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "ApproximationBounds(lower=" + this.lower + ", upper=" + this.upper + ')';
    }
}