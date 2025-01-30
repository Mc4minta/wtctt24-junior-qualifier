package com.coinbase.wallet.lending.dtos;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: LendProviderDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/lending/dtos/LendProviderResultDTO;", "", "Lcom/coinbase/wallet/lending/dtos/ProviderDTO;", "provider", "Lcom/coinbase/wallet/lending/dtos/ProviderDTO;", "getProvider", "()Lcom/coinbase/wallet/lending/dtos/ProviderDTO;", "<init>", "(Lcom/coinbase/wallet/lending/dtos/ProviderDTO;)V", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendProviderResultDTO {
    private final ProviderDTO provider;

    public LendProviderResultDTO(ProviderDTO provider) {
        m.g(provider, "provider");
        this.provider = provider;
    }

    public final ProviderDTO getProvider() {
        return this.provider;
    }
}