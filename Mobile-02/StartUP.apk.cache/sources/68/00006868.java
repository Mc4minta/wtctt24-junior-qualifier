package org.spongycastle.math.field;

import java.math.BigInteger;

/* loaded from: classes3.dex */
class PrimeField implements FiniteField {
    protected final BigInteger characteristic;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PrimeField(BigInteger bigInteger) {
        this.characteristic = bigInteger;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PrimeField) {
            return this.characteristic.equals(((PrimeField) obj).characteristic);
        }
        return false;
    }

    @Override // org.spongycastle.math.field.FiniteField
    public BigInteger getCharacteristic() {
        return this.characteristic;
    }

    @Override // org.spongycastle.math.field.FiniteField
    public int getDimension() {
        return 1;
    }

    public int hashCode() {
        return this.characteristic.hashCode();
    }
}