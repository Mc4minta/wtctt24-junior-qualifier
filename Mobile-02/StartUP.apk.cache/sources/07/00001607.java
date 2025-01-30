package com.coinbase.wallet.consumer.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: PutConsumerWalletAddressRequestDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/PutConsumerWalletAddressRequestDTO;", "", "Lcom/coinbase/wallet/consumer/dtos/ConsumerAppInfoDTO;", "component1", "()Lcom/coinbase/wallet/consumer/dtos/ConsumerAppInfoDTO;", "", "Lcom/coinbase/wallet/consumer/dtos/ConsumerWalletAddressDTO;", "component2", "()Ljava/util/List;", "appInfo", ApiConstants.ADDRESSES, "copy", "(Lcom/coinbase/wallet/consumer/dtos/ConsumerAppInfoDTO;Ljava/util/List;)Lcom/coinbase/wallet/consumer/dtos/PutConsumerWalletAddressRequestDTO;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getAddresses", "Lcom/coinbase/wallet/consumer/dtos/ConsumerAppInfoDTO;", "getAppInfo", "<init>", "(Lcom/coinbase/wallet/consumer/dtos/ConsumerAppInfoDTO;Ljava/util/List;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class PutConsumerWalletAddressRequestDTO {
    private final List<ConsumerWalletAddressDTO> addresses;
    private final ConsumerAppInfoDTO appInfo;

    public PutConsumerWalletAddressRequestDTO(@Json(name = "app_info") ConsumerAppInfoDTO appInfo, List<ConsumerWalletAddressDTO> addresses) {
        m.g(appInfo, "appInfo");
        m.g(addresses, "addresses");
        this.appInfo = appInfo;
        this.addresses = addresses;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PutConsumerWalletAddressRequestDTO copy$default(PutConsumerWalletAddressRequestDTO putConsumerWalletAddressRequestDTO, ConsumerAppInfoDTO consumerAppInfoDTO, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            consumerAppInfoDTO = putConsumerWalletAddressRequestDTO.appInfo;
        }
        if ((i2 & 2) != 0) {
            list = putConsumerWalletAddressRequestDTO.addresses;
        }
        return putConsumerWalletAddressRequestDTO.copy(consumerAppInfoDTO, list);
    }

    public final ConsumerAppInfoDTO component1() {
        return this.appInfo;
    }

    public final List<ConsumerWalletAddressDTO> component2() {
        return this.addresses;
    }

    public final PutConsumerWalletAddressRequestDTO copy(@Json(name = "app_info") ConsumerAppInfoDTO appInfo, List<ConsumerWalletAddressDTO> addresses) {
        m.g(appInfo, "appInfo");
        m.g(addresses, "addresses");
        return new PutConsumerWalletAddressRequestDTO(appInfo, addresses);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PutConsumerWalletAddressRequestDTO) {
            PutConsumerWalletAddressRequestDTO putConsumerWalletAddressRequestDTO = (PutConsumerWalletAddressRequestDTO) obj;
            return m.c(this.appInfo, putConsumerWalletAddressRequestDTO.appInfo) && m.c(this.addresses, putConsumerWalletAddressRequestDTO.addresses);
        }
        return false;
    }

    public final List<ConsumerWalletAddressDTO> getAddresses() {
        return this.addresses;
    }

    public final ConsumerAppInfoDTO getAppInfo() {
        return this.appInfo;
    }

    public int hashCode() {
        return (this.appInfo.hashCode() * 31) + this.addresses.hashCode();
    }

    public String toString() {
        return "PutConsumerWalletAddressRequestDTO(appInfo=" + this.appInfo + ", addresses=" + this.addresses + ')';
    }
}