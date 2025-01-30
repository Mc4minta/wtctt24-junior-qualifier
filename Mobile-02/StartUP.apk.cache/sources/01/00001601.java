package com.coinbase.wallet.consumer.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: ConsumerWBLInfoDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerWBLInfoDTO;", "", "", "component1", "()Ljava/lang/String;", "component2", MessageBundle.TITLE_ENTRY, ApiConstants.DESCRIPTION, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/dtos/ConsumerWBLInfoDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerWBLInfoDTO {
    private final String description;
    private final String title;

    public ConsumerWBLInfoDTO(String title, String description) {
        m.g(title, "title");
        m.g(description, "description");
        this.title = title;
        this.description = description;
    }

    public static /* synthetic */ ConsumerWBLInfoDTO copy$default(ConsumerWBLInfoDTO consumerWBLInfoDTO, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consumerWBLInfoDTO.title;
        }
        if ((i2 & 2) != 0) {
            str2 = consumerWBLInfoDTO.description;
        }
        return consumerWBLInfoDTO.copy(str, str2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.description;
    }

    public final ConsumerWBLInfoDTO copy(String title, String description) {
        m.g(title, "title");
        m.g(description, "description");
        return new ConsumerWBLInfoDTO(title, description);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerWBLInfoDTO) {
            ConsumerWBLInfoDTO consumerWBLInfoDTO = (ConsumerWBLInfoDTO) obj;
            return m.c(this.title, consumerWBLInfoDTO.title) && m.c(this.description, consumerWBLInfoDTO.description);
        }
        return false;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.description.hashCode();
    }

    public String toString() {
        return "ConsumerWBLInfoDTO(title=" + this.title + ", description=" + this.description + ')';
    }
}