package com.coinbase.wallet.consumer.dtos;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: CompleteCDVRequestDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0001\u0010\b\u001a\u00020\u0002\u0012\b\b\u0003\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0003\u0010\u0007\u001a\u00020\u00022\b\b\u0003\u0010\b\u001a\u00020\u00022\b\b\u0003\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/CompleteCDVRequestDTO;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "amount_1", "amount_2", "verificationMethod", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/dtos/CompleteCDVRequestDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAmount_1", "getAmount_2", "getVerificationMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CompleteCDVRequestDTO {
    private final String amount_1;
    private final String amount_2;
    private final String verificationMethod;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CompleteCDVRequestDTO(@Json(name = "amount_1") String amount_1, @Json(name = "amount_2") String amount_2) {
        this(amount_1, amount_2, null, 4, null);
        m.g(amount_1, "amount_1");
        m.g(amount_2, "amount_2");
    }

    public CompleteCDVRequestDTO(@Json(name = "amount_1") String amount_1, @Json(name = "amount_2") String amount_2, @Json(name = "verification_method") String verificationMethod) {
        m.g(amount_1, "amount_1");
        m.g(amount_2, "amount_2");
        m.g(verificationMethod, "verificationMethod");
        this.amount_1 = amount_1;
        this.amount_2 = amount_2;
        this.verificationMethod = verificationMethod;
    }

    public static /* synthetic */ CompleteCDVRequestDTO copy$default(CompleteCDVRequestDTO completeCDVRequestDTO, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = completeCDVRequestDTO.amount_1;
        }
        if ((i2 & 2) != 0) {
            str2 = completeCDVRequestDTO.amount_2;
        }
        if ((i2 & 4) != 0) {
            str3 = completeCDVRequestDTO.verificationMethod;
        }
        return completeCDVRequestDTO.copy(str, str2, str3);
    }

    public final String component1() {
        return this.amount_1;
    }

    public final String component2() {
        return this.amount_2;
    }

    public final String component3() {
        return this.verificationMethod;
    }

    public final CompleteCDVRequestDTO copy(@Json(name = "amount_1") String amount_1, @Json(name = "amount_2") String amount_2, @Json(name = "verification_method") String verificationMethod) {
        m.g(amount_1, "amount_1");
        m.g(amount_2, "amount_2");
        m.g(verificationMethod, "verificationMethod");
        return new CompleteCDVRequestDTO(amount_1, amount_2, verificationMethod);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CompleteCDVRequestDTO) {
            CompleteCDVRequestDTO completeCDVRequestDTO = (CompleteCDVRequestDTO) obj;
            return m.c(this.amount_1, completeCDVRequestDTO.amount_1) && m.c(this.amount_2, completeCDVRequestDTO.amount_2) && m.c(this.verificationMethod, completeCDVRequestDTO.verificationMethod);
        }
        return false;
    }

    public final String getAmount_1() {
        return this.amount_1;
    }

    public final String getAmount_2() {
        return this.amount_2;
    }

    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    public int hashCode() {
        return (((this.amount_1.hashCode() * 31) + this.amount_2.hashCode()) * 31) + this.verificationMethod.hashCode();
    }

    public String toString() {
        return "CompleteCDVRequestDTO(amount_1=" + this.amount_1 + ", amount_2=" + this.amount_2 + ", verificationMethod=" + this.verificationMethod + ')';
    }

    public /* synthetic */ CompleteCDVRequestDTO(String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? "cdv" : str3);
    }
}