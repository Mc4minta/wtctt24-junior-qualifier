package com.coinbase.wallet.user.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: AddAddressesRequestDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/user/dtos/AddAddressesRequestDTO;", "", "", "component1", "()Ljava/lang/String;", "", "Lcom/coinbase/wallet/user/dtos/AddressWithIndexDTO;", "component2", "()Ljava/util/List;", "chain", ApiConstants.ADDRESSES, "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/coinbase/wallet/user/dtos/AddAddressesRequestDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getChain", "Ljava/util/List;", "getAddresses", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class AddAddressesRequestDTO {
    private final List<AddressWithIndexDTO> addresses;
    private final String chain;

    public AddAddressesRequestDTO(String chain, List<AddressWithIndexDTO> addresses) {
        m.g(chain, "chain");
        m.g(addresses, "addresses");
        this.chain = chain;
        this.addresses = addresses;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AddAddressesRequestDTO copy$default(AddAddressesRequestDTO addAddressesRequestDTO, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = addAddressesRequestDTO.chain;
        }
        if ((i2 & 2) != 0) {
            list = addAddressesRequestDTO.addresses;
        }
        return addAddressesRequestDTO.copy(str, list);
    }

    public final String component1() {
        return this.chain;
    }

    public final List<AddressWithIndexDTO> component2() {
        return this.addresses;
    }

    public final AddAddressesRequestDTO copy(String chain, List<AddressWithIndexDTO> addresses) {
        m.g(chain, "chain");
        m.g(addresses, "addresses");
        return new AddAddressesRequestDTO(chain, addresses);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AddAddressesRequestDTO) {
            AddAddressesRequestDTO addAddressesRequestDTO = (AddAddressesRequestDTO) obj;
            return m.c(this.chain, addAddressesRequestDTO.chain) && m.c(this.addresses, addAddressesRequestDTO.addresses);
        }
        return false;
    }

    public final List<AddressWithIndexDTO> getAddresses() {
        return this.addresses;
    }

    public final String getChain() {
        return this.chain;
    }

    public int hashCode() {
        return (this.chain.hashCode() * 31) + this.addresses.hashCode();
    }

    public String toString() {
        return "AddAddressesRequestDTO(chain=" + this.chain + ", addresses=" + this.addresses + ')';
    }
}