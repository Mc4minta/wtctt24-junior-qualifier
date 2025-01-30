package com.coinbase.wallet.user.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: CreateAccessTokenResponseDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/user/dtos/CreateAccessTokenResponseDTO;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", ApiConstants.TOKEN, "expiresIn", "refreshToken", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/user/dtos/CreateAccessTokenResponseDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getToken", "getRefreshToken", "getExpiresIn", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CreateAccessTokenResponseDTO {
    private final String expiresIn;
    private final String refreshToken;
    private final String token;

    public CreateAccessTokenResponseDTO(String token, String expiresIn, String refreshToken) {
        m.g(token, "token");
        m.g(expiresIn, "expiresIn");
        m.g(refreshToken, "refreshToken");
        this.token = token;
        this.expiresIn = expiresIn;
        this.refreshToken = refreshToken;
    }

    public static /* synthetic */ CreateAccessTokenResponseDTO copy$default(CreateAccessTokenResponseDTO createAccessTokenResponseDTO, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = createAccessTokenResponseDTO.token;
        }
        if ((i2 & 2) != 0) {
            str2 = createAccessTokenResponseDTO.expiresIn;
        }
        if ((i2 & 4) != 0) {
            str3 = createAccessTokenResponseDTO.refreshToken;
        }
        return createAccessTokenResponseDTO.copy(str, str2, str3);
    }

    public final String component1() {
        return this.token;
    }

    public final String component2() {
        return this.expiresIn;
    }

    public final String component3() {
        return this.refreshToken;
    }

    public final CreateAccessTokenResponseDTO copy(String token, String expiresIn, String refreshToken) {
        m.g(token, "token");
        m.g(expiresIn, "expiresIn");
        m.g(refreshToken, "refreshToken");
        return new CreateAccessTokenResponseDTO(token, expiresIn, refreshToken);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CreateAccessTokenResponseDTO) {
            CreateAccessTokenResponseDTO createAccessTokenResponseDTO = (CreateAccessTokenResponseDTO) obj;
            return m.c(this.token, createAccessTokenResponseDTO.token) && m.c(this.expiresIn, createAccessTokenResponseDTO.expiresIn) && m.c(this.refreshToken, createAccessTokenResponseDTO.refreshToken);
        }
        return false;
    }

    public final String getExpiresIn() {
        return this.expiresIn;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        return (((this.token.hashCode() * 31) + this.expiresIn.hashCode()) * 31) + this.refreshToken.hashCode();
    }

    public String toString() {
        return "CreateAccessTokenResponseDTO(token=" + this.token + ", expiresIn=" + this.expiresIn + ", refreshToken=" + this.refreshToken + ')';
    }
}