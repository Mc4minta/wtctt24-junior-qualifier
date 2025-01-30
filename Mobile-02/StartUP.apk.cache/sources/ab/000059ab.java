package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.m;

/* compiled from: numbers.kt */
/* loaded from: classes3.dex */
public final class NumberWithRadix {
    private final String number;
    private final int radix;

    public NumberWithRadix(String number, int i2) {
        m.g(number, "number");
        this.number = number;
        this.radix = i2;
    }

    public final String component1() {
        return this.number;
    }

    public final int component2() {
        return this.radix;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NumberWithRadix) {
            NumberWithRadix numberWithRadix = (NumberWithRadix) obj;
            return m.c(this.number, numberWithRadix.number) && this.radix == numberWithRadix.radix;
        }
        return false;
    }

    public int hashCode() {
        return (this.number.hashCode() * 31) + this.radix;
    }

    public String toString() {
        return "NumberWithRadix(number=" + this.number + ", radix=" + this.radix + ')';
    }
}