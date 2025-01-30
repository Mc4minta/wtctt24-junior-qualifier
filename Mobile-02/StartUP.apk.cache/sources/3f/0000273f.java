package com.coinbase.wallet.txhistory.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: EtherscanApiResponseDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 \u001e*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001eB%\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ:\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0019\u0010\u0005R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/coinbase/wallet/txhistory/dtos/EtherscanApiResponseDTO;", "T", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/util/List;", "status", ApiConstants.MESSAGE, "result", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/coinbase/wallet/txhistory/dtos/EtherscanApiResponseDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMessage", "getStatus", "Ljava/util/List;", "getResult", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Companion", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class EtherscanApiResponseDTO<T> {
    public static final Companion Companion = new Companion(null);
    private final String message;
    private final List<T> result;
    private final String status;

    /* compiled from: EtherscanApiResponseDTO.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/txhistory/dtos/EtherscanApiResponseDTO$Companion;", "", "<init>", "()V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EtherscanApiResponseDTO(String status, String message, List<? extends T> result) {
        m.g(status, "status");
        m.g(message, "message");
        m.g(result, "result");
        this.status = status;
        this.message = message;
        this.result = result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EtherscanApiResponseDTO copy$default(EtherscanApiResponseDTO etherscanApiResponseDTO, String str, String str2, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = etherscanApiResponseDTO.status;
        }
        if ((i2 & 2) != 0) {
            str2 = etherscanApiResponseDTO.message;
        }
        if ((i2 & 4) != 0) {
            list = etherscanApiResponseDTO.result;
        }
        return etherscanApiResponseDTO.copy(str, str2, list);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.message;
    }

    public final List<T> component3() {
        return this.result;
    }

    public final EtherscanApiResponseDTO<T> copy(String status, String message, List<? extends T> result) {
        m.g(status, "status");
        m.g(message, "message");
        m.g(result, "result");
        return new EtherscanApiResponseDTO<>(status, message, result);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EtherscanApiResponseDTO) {
            EtherscanApiResponseDTO etherscanApiResponseDTO = (EtherscanApiResponseDTO) obj;
            return m.c(this.status, etherscanApiResponseDTO.status) && m.c(this.message, etherscanApiResponseDTO.message) && m.c(this.result, etherscanApiResponseDTO.result);
        }
        return false;
    }

    public final String getMessage() {
        return this.message;
    }

    public final List<T> getResult() {
        return this.result;
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((this.status.hashCode() * 31) + this.message.hashCode()) * 31) + this.result.hashCode();
    }

    public String toString() {
        return "EtherscanApiResponseDTO(status=" + this.status + ", message=" + this.message + ", result=" + this.result + ')';
    }
}