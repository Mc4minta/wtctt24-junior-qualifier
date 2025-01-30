package com.coinbase.wallet.user.dtos;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: AddressWithIndexDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\r\u0010\u0007J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/user/dtos/AddressWithIndexDTO;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "address", "index", "copy", "(Ljava/lang/String;I)Lcom/coinbase/wallet/user/dtos/AddressWithIndexDTO;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getIndex", "Ljava/lang/String;", "getAddress", "<init>", "(Ljava/lang/String;I)V", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class AddressWithIndexDTO {
    private final String address;
    private final int index;

    public AddressWithIndexDTO(String address, int i2) {
        m.g(address, "address");
        this.address = address;
        this.index = i2;
    }

    public static /* synthetic */ AddressWithIndexDTO copy$default(AddressWithIndexDTO addressWithIndexDTO, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = addressWithIndexDTO.address;
        }
        if ((i3 & 2) != 0) {
            i2 = addressWithIndexDTO.index;
        }
        return addressWithIndexDTO.copy(str, i2);
    }

    public final String component1() {
        return this.address;
    }

    public final int component2() {
        return this.index;
    }

    public final AddressWithIndexDTO copy(String address, int i2) {
        m.g(address, "address");
        return new AddressWithIndexDTO(address, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AddressWithIndexDTO) {
            AddressWithIndexDTO addressWithIndexDTO = (AddressWithIndexDTO) obj;
            return m.c(this.address, addressWithIndexDTO.address) && this.index == addressWithIndexDTO.index;
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final int getIndex() {
        return this.index;
    }

    public int hashCode() {
        return (this.address.hashCode() * 31) + this.index;
    }

    public String toString() {
        return "AddressWithIndexDTO(address=" + this.address + ", index=" + this.index + ')';
    }
}