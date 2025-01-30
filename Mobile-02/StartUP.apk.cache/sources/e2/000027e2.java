package com.coinbase.wallet.user.apis;

import com.coinbase.wallet.common.exceptions.RPCException;
import com.coinbase.wallet.common.extensions.Throwable_CommonKt;
import com.coinbase.wallet.common.models.RPCResponse;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.user.dtos.CreateAccessTokenRequestDTO;
import com.coinbase.wallet.user.dtos.CreateAccessTokenResponseDTO;
import com.coinbase.wallet.user.dtos.CreateNonceResponseDTO;
import com.coinbase.wallet.user.dtos.CreateUserRequestDTO;
import com.coinbase.wallet.user.exceptions.AccessTokenException;
import com.coinbase.wallet.user.models.Signature;
import h.c.b0;
import h.c.h0;
import java.util.List;
import kotlin.Metadata;

/* compiled from: AccessTokenApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J9\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00022\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00150\u00022\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/user/apis/AccessTokenApi;", "", "Lh/c/b0;", "", "createNonce", "()Lh/c/b0;", "username", "", "isPublic", AdjustableMinerFeeArgs.NONCE, "", "Lcom/coinbase/wallet/user/models/Signature;", "signatures", "Lcom/coinbase/wallet/user/dtos/CreateAccessTokenResponseDTO;", "createUser", "(Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;)Lh/c/b0;", "address", "signature", "createAccessToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "refreshToken", "Lcom/coinbase/wallet/common/models/RPCResponse;", "refreshAccessToken", "(Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/user/apis/AccessTokenApiInterface;", "api", "Lcom/coinbase/wallet/user/apis/AccessTokenApiInterface;", "<init>", "(Lcom/coinbase/wallet/user/apis/AccessTokenApiInterface;)V", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class AccessTokenApi {
    private final AccessTokenApiInterface api;

    public AccessTokenApi(AccessTokenApiInterface api) {
        kotlin.jvm.internal.m.g(api, "api");
        this.api = api;
    }

    public static /* synthetic */ CreateNonceResponseDTO a(RPCResponse rPCResponse) {
        return m1793createNonce$lambda0(rPCResponse);
    }

    public static /* synthetic */ h0 b(Throwable th) {
        return m1791createAccessToken$lambda5(th);
    }

    public static /* synthetic */ CreateAccessTokenResponseDTO c(RPCResponse rPCResponse) {
        return m1795createUser$lambda3(rPCResponse);
    }

    /* renamed from: createAccessToken$lambda-5 */
    public static final h0 m1791createAccessToken$lambda5(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        RPCException asRPCException = Throwable_CommonKt.asRPCException(it);
        if (asRPCException != null) {
            it = asRPCException;
        }
        return b0.error(it);
    }

    /* renamed from: createAccessToken$lambda-6 */
    public static final CreateAccessTokenResponseDTO m1792createAccessToken$lambda6(RPCResponse it) {
        kotlin.jvm.internal.m.g(it, "it");
        CreateAccessTokenResponseDTO createAccessTokenResponseDTO = (CreateAccessTokenResponseDTO) it.getResult();
        if (createAccessTokenResponseDTO != null) {
            return createAccessTokenResponseDTO;
        }
        throw AccessTokenException.UnableToCreateAccessToken.INSTANCE;
    }

    /* renamed from: createNonce$lambda-0 */
    public static final CreateNonceResponseDTO m1793createNonce$lambda0(RPCResponse it) {
        kotlin.jvm.internal.m.g(it, "it");
        CreateNonceResponseDTO createNonceResponseDTO = (CreateNonceResponseDTO) it.getResult();
        if (createNonceResponseDTO != null) {
            return createNonceResponseDTO;
        }
        throw AccessTokenException.UnableToCreateNonce.INSTANCE;
    }

    /* renamed from: createNonce$lambda-1 */
    public static final String m1794createNonce$lambda1(CreateNonceResponseDTO it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.getNonce();
    }

    /* renamed from: createUser$lambda-3 */
    public static final CreateAccessTokenResponseDTO m1795createUser$lambda3(RPCResponse it) {
        kotlin.jvm.internal.m.g(it, "it");
        CreateAccessTokenResponseDTO createAccessTokenResponseDTO = (CreateAccessTokenResponseDTO) it.getResult();
        if (createAccessTokenResponseDTO != null) {
            return createAccessTokenResponseDTO;
        }
        throw AccessTokenException.UnableToCreateUser.INSTANCE;
    }

    public static /* synthetic */ String d(CreateNonceResponseDTO createNonceResponseDTO) {
        return m1794createNonce$lambda1(createNonceResponseDTO);
    }

    public static /* synthetic */ h0 e(Throwable th) {
        return m1796refreshAccessToken$lambda7(th);
    }

    public static /* synthetic */ CreateAccessTokenResponseDTO f(RPCResponse rPCResponse) {
        return m1792createAccessToken$lambda6(rPCResponse);
    }

    /* renamed from: refreshAccessToken$lambda-7 */
    public static final h0 m1796refreshAccessToken$lambda7(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        RPCException asRPCException = Throwable_CommonKt.asRPCException(it);
        if (asRPCException != null) {
            it = asRPCException;
        }
        return b0.error(it);
    }

    public final b0<CreateAccessTokenResponseDTO> createAccessToken(String nonce, String address, String signature) {
        kotlin.jvm.internal.m.g(nonce, "nonce");
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(signature, "signature");
        b0 map = this.api.createAccessToken(new CreateAccessTokenRequestDTO(nonce, address, signature)).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.user.apis.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccessTokenApi.b((Throwable) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.user.apis.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccessTokenApi.f((RPCResponse) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "CreateAccessTokenRequestDTO(nonce, address, signature)\n        .let { api.createAccessToken(it) }\n        .onErrorResumeNext { Single.error(it.asRPCException() ?: it) }\n        .map { it.result ?: throw AccessTokenException.UnableToCreateAccessToken }");
        return map;
    }

    public final b0<String> createNonce() {
        b0<String> map = this.api.createNonce().map(new h.c.m0.n() { // from class: com.coinbase.wallet.user.apis.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccessTokenApi.a((RPCResponse) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.user.apis.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccessTokenApi.d((CreateNonceResponseDTO) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "api.createNonce()\n        .map { it.result ?: throw AccessTokenException.UnableToCreateNonce }\n        .map { it.nonce }");
        return map;
    }

    public final b0<CreateAccessTokenResponseDTO> createUser(String username, boolean z, String nonce, List<Signature> signatures) {
        kotlin.jvm.internal.m.g(username, "username");
        kotlin.jvm.internal.m.g(nonce, "nonce");
        kotlin.jvm.internal.m.g(signatures, "signatures");
        b0 map = this.api.createUser(new CreateUserRequestDTO(username, z, nonce, signatures)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.user.apis.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccessTokenApi.c((RPCResponse) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "CreateUserRequestDTO(username, isPublic, nonce, signatures)\n        .let { api.createUser(it) }\n        .map { it.result ?: throw AccessTokenException.UnableToCreateUser }");
        return map;
    }

    public final b0<RPCResponse<CreateAccessTokenResponseDTO>> refreshAccessToken(String refreshToken) {
        kotlin.jvm.internal.m.g(refreshToken, "refreshToken");
        b0<RPCResponse<CreateAccessTokenResponseDTO>> onErrorResumeNext = this.api.refreshAccessToken(refreshToken).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.user.apis.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccessTokenApi.e((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorResumeNext, "api\n        .refreshAccessToken(refreshToken)\n        .onErrorResumeNext { Single.error(it.asRPCException() ?: it) }");
        return onErrorResumeNext;
    }
}