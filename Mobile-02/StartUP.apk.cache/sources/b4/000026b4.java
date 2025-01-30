package com.coinbase.wallet.swap.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SwapAPIErrorDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/swap/dtos/SwapAPIErrorInfoDTO;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", ApiConstants.MESSAGE, ApiConstants.DESCRIPTION, "code", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/swap/dtos/SwapAPIErrorInfoDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCode", "getDescription", "getMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapAPIErrorInfoDTO {
    private final String code;
    private final String description;
    private final String message;

    public SwapAPIErrorInfoDTO(String message, String description, String code) {
        m.g(message, "message");
        m.g(description, "description");
        m.g(code, "code");
        this.message = message;
        this.description = description;
        this.code = code;
    }

    public static /* synthetic */ SwapAPIErrorInfoDTO copy$default(SwapAPIErrorInfoDTO swapAPIErrorInfoDTO, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = swapAPIErrorInfoDTO.message;
        }
        if ((i2 & 2) != 0) {
            str2 = swapAPIErrorInfoDTO.description;
        }
        if ((i2 & 4) != 0) {
            str3 = swapAPIErrorInfoDTO.code;
        }
        return swapAPIErrorInfoDTO.copy(str, str2, str3);
    }

    public final String component1() {
        return this.message;
    }

    public final String component2() {
        return this.description;
    }

    public final String component3() {
        return this.code;
    }

    public final SwapAPIErrorInfoDTO copy(String message, String description, String code) {
        m.g(message, "message");
        m.g(description, "description");
        m.g(code, "code");
        return new SwapAPIErrorInfoDTO(message, description, code);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SwapAPIErrorInfoDTO) {
            SwapAPIErrorInfoDTO swapAPIErrorInfoDTO = (SwapAPIErrorInfoDTO) obj;
            return m.c(this.message, swapAPIErrorInfoDTO.message) && m.c(this.description, swapAPIErrorInfoDTO.description) && m.c(this.code, swapAPIErrorInfoDTO.code);
        }
        return false;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (((this.message.hashCode() * 31) + this.description.hashCode()) * 31) + this.code.hashCode();
    }

    public String toString() {
        return "SwapAPIErrorInfoDTO(message=" + this.message + ", description=" + this.description + ", code=" + this.code + ')';
    }
}