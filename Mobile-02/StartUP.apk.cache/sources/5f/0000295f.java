package com.coinbase.wallet.wallets.dtos;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: FiatCurrenciesDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0081\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/wallets/dtos/FiatCurrenciesResultDTO;", "", "Lcom/coinbase/wallet/wallets/dtos/FiatCurrenciesDTO;", "component1", "()Lcom/coinbase/wallet/wallets/dtos/FiatCurrenciesDTO;", "result", "copy", "(Lcom/coinbase/wallet/wallets/dtos/FiatCurrenciesDTO;)Lcom/coinbase/wallet/wallets/dtos/FiatCurrenciesResultDTO;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/wallets/dtos/FiatCurrenciesDTO;", "getResult", "<init>", "(Lcom/coinbase/wallet/wallets/dtos/FiatCurrenciesDTO;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class FiatCurrenciesResultDTO {
    private final FiatCurrenciesDTO result;

    public FiatCurrenciesResultDTO(FiatCurrenciesDTO result) {
        m.g(result, "result");
        this.result = result;
    }

    public static /* synthetic */ FiatCurrenciesResultDTO copy$default(FiatCurrenciesResultDTO fiatCurrenciesResultDTO, FiatCurrenciesDTO fiatCurrenciesDTO, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            fiatCurrenciesDTO = fiatCurrenciesResultDTO.result;
        }
        return fiatCurrenciesResultDTO.copy(fiatCurrenciesDTO);
    }

    public final FiatCurrenciesDTO component1() {
        return this.result;
    }

    public final FiatCurrenciesResultDTO copy(FiatCurrenciesDTO result) {
        m.g(result, "result");
        return new FiatCurrenciesResultDTO(result);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FiatCurrenciesResultDTO) && m.c(this.result, ((FiatCurrenciesResultDTO) obj).result);
    }

    public final FiatCurrenciesDTO getResult() {
        return this.result;
    }

    public int hashCode() {
        return this.result.hashCode();
    }

    public String toString() {
        return "FiatCurrenciesResultDTO(result=" + this.result + ')';
    }
}