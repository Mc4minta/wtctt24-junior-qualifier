package com.coinbase.wallet.consumer.dtos;

import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerAssetDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerAssetsWrapperDTO;", "", "", "Lcom/coinbase/wallet/consumer/dtos/ConsumerAssetDTO;", "component1", "()Ljava/util/List;", "data", "copy", "(Ljava/util/List;)Lcom/coinbase/wallet/consumer/dtos/ConsumerAssetsWrapperDTO;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getData", "<init>", "(Ljava/util/List;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAssetsWrapperDTO {
    private final List<ConsumerAssetDTO> data;

    public ConsumerAssetsWrapperDTO(List<ConsumerAssetDTO> data) {
        m.g(data, "data");
        this.data = data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConsumerAssetsWrapperDTO copy$default(ConsumerAssetsWrapperDTO consumerAssetsWrapperDTO, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = consumerAssetsWrapperDTO.data;
        }
        return consumerAssetsWrapperDTO.copy(list);
    }

    public final List<ConsumerAssetDTO> component1() {
        return this.data;
    }

    public final ConsumerAssetsWrapperDTO copy(List<ConsumerAssetDTO> data) {
        m.g(data, "data");
        return new ConsumerAssetsWrapperDTO(data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConsumerAssetsWrapperDTO) && m.c(this.data, ((ConsumerAssetsWrapperDTO) obj).data);
    }

    public final List<ConsumerAssetDTO> getData() {
        return this.data;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "ConsumerAssetsWrapperDTO(data=" + this.data + ')';
    }
}