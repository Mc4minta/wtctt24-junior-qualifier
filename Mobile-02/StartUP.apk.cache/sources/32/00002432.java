package com.coinbase.wallet.lending.dtos;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: LendTokenListDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\b\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/lending/dtos/OptionalRateDTO;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "isApplicable", "value", "copy", "(ZLjava/lang/String;)Lcom/coinbase/wallet/lending/dtos/OptionalRateDTO;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/String;", "getValue", "<init>", "(ZLjava/lang/String;)V", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class OptionalRateDTO {
    private final boolean isApplicable;
    private final String value;

    public OptionalRateDTO(boolean z, String str) {
        this.isApplicable = z;
        this.value = str;
    }

    public static /* synthetic */ OptionalRateDTO copy$default(OptionalRateDTO optionalRateDTO, boolean z, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = optionalRateDTO.isApplicable;
        }
        if ((i2 & 2) != 0) {
            str = optionalRateDTO.value;
        }
        return optionalRateDTO.copy(z, str);
    }

    public final boolean component1() {
        return this.isApplicable;
    }

    public final String component2() {
        return this.value;
    }

    public final OptionalRateDTO copy(boolean z, String str) {
        return new OptionalRateDTO(z, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OptionalRateDTO) {
            OptionalRateDTO optionalRateDTO = (OptionalRateDTO) obj;
            return this.isApplicable == optionalRateDTO.isApplicable && m.c(this.value, optionalRateDTO.value);
        }
        return false;
    }

    public final String getValue() {
        return this.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.isApplicable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i2 = r0 * 31;
        String str = this.value;
        return i2 + (str == null ? 0 : str.hashCode());
    }

    public final boolean isApplicable() {
        return this.isApplicable;
    }

    public String toString() {
        return "OptionalRateDTO(isApplicable=" + this.isApplicable + ", value=" + ((Object) this.value) + ')';
    }
}