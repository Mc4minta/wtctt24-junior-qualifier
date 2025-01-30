package com.coinbase.wallet.features.send.dtos;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GetUserAddressDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/coinbase/wallet/features/send/dtos/GetUserAddressDTO;", "", "", "component1", "()Ljava/lang/String;", "address", "copy", "(Ljava/lang/String;)Lcom/coinbase/wallet/features/send/dtos/GetUserAddressDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAddress", "<init>", "(Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GetUserAddressDTO {
    private final String address;

    public GetUserAddressDTO(String address) {
        m.g(address, "address");
        this.address = address;
    }

    public static /* synthetic */ GetUserAddressDTO copy$default(GetUserAddressDTO getUserAddressDTO, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = getUserAddressDTO.address;
        }
        return getUserAddressDTO.copy(str);
    }

    public final String component1() {
        return this.address;
    }

    public final GetUserAddressDTO copy(String address) {
        m.g(address, "address");
        return new GetUserAddressDTO(address);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetUserAddressDTO) && m.c(this.address, ((GetUserAddressDTO) obj).address);
    }

    public final String getAddress() {
        return this.address;
    }

    public int hashCode() {
        return this.address.hashCode();
    }

    public String toString() {
        return "GetUserAddressDTO(address=" + this.address + ')';
    }
}