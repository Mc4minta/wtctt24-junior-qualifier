package com.coinbase.wallet.features.networking.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: WatchAddressesRequestDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/features/networking/dtos/WatchAddressesRequestDTO;", "", "", "", "component1", "()Ljava/util/List;", "component2", "()Ljava/lang/String;", ApiConstants.ADDRESSES, "chain", "copy", "(Ljava/util/List;Ljava/lang/String;)Lcom/coinbase/wallet/features/networking/dtos/WatchAddressesRequestDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getChain", "Ljava/util/List;", "getAddresses", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WatchAddressesRequestDTO {
    private final List<String> addresses;
    private final String chain;

    public WatchAddressesRequestDTO(List<String> addresses, String chain) {
        m.g(addresses, "addresses");
        m.g(chain, "chain");
        this.addresses = addresses;
        this.chain = chain;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WatchAddressesRequestDTO copy$default(WatchAddressesRequestDTO watchAddressesRequestDTO, List list, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = watchAddressesRequestDTO.addresses;
        }
        if ((i2 & 2) != 0) {
            str = watchAddressesRequestDTO.chain;
        }
        return watchAddressesRequestDTO.copy(list, str);
    }

    public final List<String> component1() {
        return this.addresses;
    }

    public final String component2() {
        return this.chain;
    }

    public final WatchAddressesRequestDTO copy(List<String> addresses, String chain) {
        m.g(addresses, "addresses");
        m.g(chain, "chain");
        return new WatchAddressesRequestDTO(addresses, chain);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WatchAddressesRequestDTO) {
            WatchAddressesRequestDTO watchAddressesRequestDTO = (WatchAddressesRequestDTO) obj;
            return m.c(this.addresses, watchAddressesRequestDTO.addresses) && m.c(this.chain, watchAddressesRequestDTO.chain);
        }
        return false;
    }

    public final List<String> getAddresses() {
        return this.addresses;
    }

    public final String getChain() {
        return this.chain;
    }

    public int hashCode() {
        return (this.addresses.hashCode() * 31) + this.chain.hashCode();
    }

    public String toString() {
        return "WatchAddressesRequestDTO(addresses=" + this.addresses + ", chain=" + this.chain + ')';
    }
}