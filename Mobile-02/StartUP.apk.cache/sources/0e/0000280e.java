package com.coinbase.wallet.user.dtos;

import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.user.models.Signature;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: CreateUserRequestDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ>\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u000e\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001d\u0010\u0004R\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\f¨\u0006\""}, d2 = {"Lcom/coinbase/wallet/user/dtos/CreateUserRequestDTO;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "", "Lcom/coinbase/wallet/user/models/Signature;", "component4", "()Ljava/util/List;", "username", "isPublic", AdjustableMinerFeeArgs.NONCE, "ethereumAddresses", "copy", "(Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;)Lcom/coinbase/wallet/user/dtos/CreateUserRequestDTO;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/String;", "getUsername", "getNonce", "Ljava/util/List;", "getEthereumAddresses", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;)V", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CreateUserRequestDTO {
    private final List<Signature> ethereumAddresses;
    private final boolean isPublic;
    private final String nonce;
    private final String username;

    public CreateUserRequestDTO(String username, boolean z, String nonce, List<Signature> ethereumAddresses) {
        m.g(username, "username");
        m.g(nonce, "nonce");
        m.g(ethereumAddresses, "ethereumAddresses");
        this.username = username;
        this.isPublic = z;
        this.nonce = nonce;
        this.ethereumAddresses = ethereumAddresses;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreateUserRequestDTO copy$default(CreateUserRequestDTO createUserRequestDTO, String str, boolean z, String str2, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = createUserRequestDTO.username;
        }
        if ((i2 & 2) != 0) {
            z = createUserRequestDTO.isPublic;
        }
        if ((i2 & 4) != 0) {
            str2 = createUserRequestDTO.nonce;
        }
        if ((i2 & 8) != 0) {
            list = createUserRequestDTO.ethereumAddresses;
        }
        return createUserRequestDTO.copy(str, z, str2, list);
    }

    public final String component1() {
        return this.username;
    }

    public final boolean component2() {
        return this.isPublic;
    }

    public final String component3() {
        return this.nonce;
    }

    public final List<Signature> component4() {
        return this.ethereumAddresses;
    }

    public final CreateUserRequestDTO copy(String username, boolean z, String nonce, List<Signature> ethereumAddresses) {
        m.g(username, "username");
        m.g(nonce, "nonce");
        m.g(ethereumAddresses, "ethereumAddresses");
        return new CreateUserRequestDTO(username, z, nonce, ethereumAddresses);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CreateUserRequestDTO) {
            CreateUserRequestDTO createUserRequestDTO = (CreateUserRequestDTO) obj;
            return m.c(this.username, createUserRequestDTO.username) && this.isPublic == createUserRequestDTO.isPublic && m.c(this.nonce, createUserRequestDTO.nonce) && m.c(this.ethereumAddresses, createUserRequestDTO.ethereumAddresses);
        }
        return false;
    }

    public final List<Signature> getEthereumAddresses() {
        return this.ethereumAddresses;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final String getUsername() {
        return this.username;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.username.hashCode() * 31;
        boolean z = this.isPublic;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return ((((hashCode + i2) * 31) + this.nonce.hashCode()) * 31) + this.ethereumAddresses.hashCode();
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public String toString() {
        return "CreateUserRequestDTO(username=" + this.username + ", isPublic=" + this.isPublic + ", nonce=" + this.nonce + ", ethereumAddresses=" + this.ethereumAddresses + ')';
    }
}