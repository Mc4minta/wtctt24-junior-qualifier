package com.coinbase.wallet.consumer.dtos;

import com.coinbase.wallet.consumer.models.BuyStatus;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: BuyStatusWrapperDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u000f\u001a\u00020\b\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b \u0010!J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ0\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0003\u0010\u000f\u001a\u00020\b2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001b\u0010\rR\u0019\u0010\u000f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007¨\u0006\""}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/BuyStatusDTO;", "", "Lcom/coinbase/wallet/consumer/models/BuyStatus;", "toBuyStatus", "()Lcom/coinbase/wallet/consumer/models/BuyStatus;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "Lcom/coinbase/wallet/consumer/dtos/Secure3DVerificationDTO;", "component3", "()Lcom/coinbase/wallet/consumer/dtos/Secure3DVerificationDTO;", "status", "requiresCompletionStep", "secure3DVerification", "copy", "(Ljava/lang/String;ZLcom/coinbase/wallet/consumer/dtos/Secure3DVerificationDTO;)Lcom/coinbase/wallet/consumer/dtos/BuyStatusDTO;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/consumer/dtos/Secure3DVerificationDTO;", "getSecure3DVerification", "Z", "getRequiresCompletionStep", "Ljava/lang/String;", "getStatus", "<init>", "(Ljava/lang/String;ZLcom/coinbase/wallet/consumer/dtos/Secure3DVerificationDTO;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BuyStatusDTO {
    private final boolean requiresCompletionStep;
    private final Secure3DVerificationDTO secure3DVerification;
    private final String status;

    public BuyStatusDTO(String status, @Json(name = "requires_completion_step") boolean z, @Json(name = "secure3d_verification") Secure3DVerificationDTO secure3DVerificationDTO) {
        m.g(status, "status");
        this.status = status;
        this.requiresCompletionStep = z;
        this.secure3DVerification = secure3DVerificationDTO;
    }

    public static /* synthetic */ BuyStatusDTO copy$default(BuyStatusDTO buyStatusDTO, String str, boolean z, Secure3DVerificationDTO secure3DVerificationDTO, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = buyStatusDTO.status;
        }
        if ((i2 & 2) != 0) {
            z = buyStatusDTO.requiresCompletionStep;
        }
        if ((i2 & 4) != 0) {
            secure3DVerificationDTO = buyStatusDTO.secure3DVerification;
        }
        return buyStatusDTO.copy(str, z, secure3DVerificationDTO);
    }

    public final String component1() {
        return this.status;
    }

    public final boolean component2() {
        return this.requiresCompletionStep;
    }

    public final Secure3DVerificationDTO component3() {
        return this.secure3DVerification;
    }

    public final BuyStatusDTO copy(String status, @Json(name = "requires_completion_step") boolean z, @Json(name = "secure3d_verification") Secure3DVerificationDTO secure3DVerificationDTO) {
        m.g(status, "status");
        return new BuyStatusDTO(status, z, secure3DVerificationDTO);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BuyStatusDTO) {
            BuyStatusDTO buyStatusDTO = (BuyStatusDTO) obj;
            return m.c(this.status, buyStatusDTO.status) && this.requiresCompletionStep == buyStatusDTO.requiresCompletionStep && m.c(this.secure3DVerification, buyStatusDTO.secure3DVerification);
        }
        return false;
    }

    public final boolean getRequiresCompletionStep() {
        return this.requiresCompletionStep;
    }

    public final Secure3DVerificationDTO getSecure3DVerification() {
        return this.secure3DVerification;
    }

    public final String getStatus() {
        return this.status;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.status.hashCode() * 31;
        boolean z = this.requiresCompletionStep;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        Secure3DVerificationDTO secure3DVerificationDTO = this.secure3DVerification;
        return i3 + (secure3DVerificationDTO == null ? 0 : secure3DVerificationDTO.hashCode());
    }

    public final BuyStatus toBuyStatus() {
        String str = this.status;
        boolean z = this.requiresCompletionStep;
        Secure3DVerificationDTO secure3DVerificationDTO = this.secure3DVerification;
        return new BuyStatus(str, z, secure3DVerificationDTO == null ? null : secure3DVerificationDTO.toSecure3DVerification());
    }

    public String toString() {
        return "BuyStatusDTO(status=" + this.status + ", requiresCompletionStep=" + this.requiresCompletionStep + ", secure3DVerification=" + this.secure3DVerification + ')';
    }
}