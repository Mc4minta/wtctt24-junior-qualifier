package com.coinbase.wallet.wallets.dtos;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: FiatCurrenciesDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ.\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/wallets/dtos/FiatCurrencyDTO;", "", "Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "asFiatCurrency", "()Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "code", ApiConstants.NAME, "decimals", "copy", "(Ljava/lang/String;Ljava/lang/String;I)Lcom/coinbase/wallet/wallets/dtos/FiatCurrencyDTO;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCode", "getName", "I", "getDecimals", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class FiatCurrencyDTO {
    private final String code;
    private final int decimals;
    private final String name;

    public FiatCurrencyDTO(String code, String name, int i2) {
        m.g(code, "code");
        m.g(name, "name");
        this.code = code;
        this.name = name;
        this.decimals = i2;
    }

    public static /* synthetic */ FiatCurrencyDTO copy$default(FiatCurrencyDTO fiatCurrencyDTO, String str, String str2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = fiatCurrencyDTO.code;
        }
        if ((i3 & 2) != 0) {
            str2 = fiatCurrencyDTO.name;
        }
        if ((i3 & 4) != 0) {
            i2 = fiatCurrencyDTO.decimals;
        }
        return fiatCurrencyDTO.copy(str, str2, i2);
    }

    public final FiatCurrency asFiatCurrency() {
        return new FiatCurrency(new CurrencyCode(this.code), this.name, this.decimals);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.decimals;
    }

    public final FiatCurrencyDTO copy(String code, String name, int i2) {
        m.g(code, "code");
        m.g(name, "name");
        return new FiatCurrencyDTO(code, name, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FiatCurrencyDTO) {
            FiatCurrencyDTO fiatCurrencyDTO = (FiatCurrencyDTO) obj;
            return m.c(this.code, fiatCurrencyDTO.code) && m.c(this.name, fiatCurrencyDTO.name) && this.decimals == fiatCurrencyDTO.decimals;
        }
        return false;
    }

    public final String getCode() {
        return this.code;
    }

    public final int getDecimals() {
        return this.decimals;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((this.code.hashCode() * 31) + this.name.hashCode()) * 31) + this.decimals;
    }

    public String toString() {
        return "FiatCurrencyDTO(code=" + this.code + ", name=" + this.name + ", decimals=" + this.decimals + ')';
    }
}