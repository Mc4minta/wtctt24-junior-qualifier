package com.coinbase.wallet.user.apis;

import com.coinbase.wallet.common.models.RPCResponse;
import com.coinbase.wallet.user.dtos.CreateAccessTokenRequestDTO;
import com.coinbase.wallet.user.dtos.CreateAccessTokenResponseDTO;
import com.coinbase.wallet.user.dtos.CreateNonceResponseDTO;
import com.coinbase.wallet.user.dtos.CreateUserRequestDTO;
import h.c.b0;
import kotlin.Metadata;

/* compiled from: AccessTokenApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00030\u00022\b\b\u0001\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00030\u00022\b\b\u0001\u0010\b\u001a\u00020\fH'¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00030\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/coinbase/wallet/user/apis/AccessTokenApiInterface;", "", "Lh/c/b0;", "Lcom/coinbase/wallet/common/models/RPCResponse;", "Lcom/coinbase/wallet/user/dtos/CreateNonceResponseDTO;", "createNonce", "()Lh/c/b0;", "Lcom/coinbase/wallet/user/dtos/CreateUserRequestDTO;", "rpcParams", "Lcom/coinbase/wallet/user/dtos/CreateAccessTokenResponseDTO;", "createUser", "(Lcom/coinbase/wallet/user/dtos/CreateUserRequestDTO;)Lh/c/b0;", "Lcom/coinbase/wallet/user/dtos/CreateAccessTokenRequestDTO;", "createAccessToken", "(Lcom/coinbase/wallet/user/dtos/CreateAccessTokenRequestDTO;)Lh/c/b0;", "", "refreshToken", "refreshAccessToken", "(Ljava/lang/String;)Lh/c/b0;", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface AccessTokenApiInterface {
    @retrofit2.z.o("rpc/v2/createAccessToken")
    b0<RPCResponse<CreateAccessTokenResponseDTO>> createAccessToken(@retrofit2.z.a CreateAccessTokenRequestDTO createAccessTokenRequestDTO);

    @retrofit2.z.o("rpc/v2/createNonce")
    b0<RPCResponse<CreateNonceResponseDTO>> createNonce();

    @retrofit2.z.o("rpc/v2/createUser")
    b0<RPCResponse<CreateAccessTokenResponseDTO>> createUser(@retrofit2.z.a CreateUserRequestDTO createUserRequestDTO);

    @retrofit2.z.o("rpc/v2/refreshAccessToken")
    b0<RPCResponse<CreateAccessTokenResponseDTO>> refreshAccessToken(@retrofit2.z.a String str);
}