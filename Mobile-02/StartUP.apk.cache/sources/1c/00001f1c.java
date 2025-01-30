package com.coinbase.wallet.features.networking.jwt;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.common.annotations.AppCoreScoped;
import com.coinbase.wallet.common.exceptions.RPCException;
import com.coinbase.wallet.common.models.RPCResponse;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.user.apis.AccessTokenApi;
import com.coinbase.wallet.user.dtos.CreateAccessTokenResponseDTO;
import com.coinbase.wallet.user.exceptions.AccessTokenException;
import com.coinbase.wallet.user.extensions.StoreKeys_UserKt;
import h.c.b0;
import h.c.h0;
import h.c.m0.f;
import h.c.m0.n;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: AccessTokenProvider.kt */
@AppCoreScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u000e\b\u0001\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0017¢\u0006\u0004\b\n\u0010\tR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/features/networking/jwt/AccessTokenProvider;", "Lcom/coinbase/wallet/features/networking/jwt/AccessTokenProviderInterface;", "Lcom/coinbase/wallet/user/dtos/CreateAccessTokenResponseDTO;", "result", "Lkotlin/x;", "setAccessTokens", "(Lcom/coinbase/wallet/user/dtos/CreateAccessTokenResponseDTO;)V", "", ApiConstants.TOKEN, "()Ljava/lang/String;", "refreshToken", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lh/c/b0;", "signInHandler", "Lh/c/b0;", "Lcom/coinbase/wallet/user/apis/AccessTokenApi;", "accessTokenApi", "Lcom/coinbase/wallet/user/apis/AccessTokenApi;", "<init>", "(Lh/c/b0;Lcom/coinbase/wallet/user/apis/AccessTokenApi;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AccessTokenProvider implements AccessTokenProviderInterface {
    private final AccessTokenApi accessTokenApi;
    private final b0<CreateAccessTokenResponseDTO> signInHandler;
    private final StoreInterface store;

    public AccessTokenProvider(b0<CreateAccessTokenResponseDTO> signInHandler, AccessTokenApi accessTokenApi, StoreInterface store) {
        m.g(signInHandler, "signInHandler");
        m.g(accessTokenApi, "accessTokenApi");
        m.g(store, "store");
        this.signInHandler = signInHandler;
        this.accessTokenApi = accessTokenApi;
        this.store = store;
    }

    public static /* synthetic */ h0 a(AccessTokenProvider accessTokenProvider, Throwable th) {
        return m1298refreshToken$lambda1(accessTokenProvider, th);
    }

    public static /* synthetic */ CreateAccessTokenResponseDTO b(RPCResponse rPCResponse) {
        return m1297refreshToken$lambda0(rPCResponse);
    }

    public static /* synthetic */ void c(AccessTokenProvider accessTokenProvider, CreateAccessTokenResponseDTO createAccessTokenResponseDTO) {
        accessTokenProvider.setAccessTokens(createAccessTokenResponseDTO);
    }

    public static /* synthetic */ String d(CreateAccessTokenResponseDTO createAccessTokenResponseDTO) {
        return m1299refreshToken$lambda2(createAccessTokenResponseDTO);
    }

    /* renamed from: refreshToken$lambda-0 */
    public static final CreateAccessTokenResponseDTO m1297refreshToken$lambda0(RPCResponse it) {
        m.g(it, "it");
        CreateAccessTokenResponseDTO createAccessTokenResponseDTO = (CreateAccessTokenResponseDTO) it.getResult();
        if (createAccessTokenResponseDTO != null) {
            return createAccessTokenResponseDTO;
        }
        throw AccessTokenException.UnableToRefreshAccessToken.INSTANCE;
    }

    /* renamed from: refreshToken$lambda-1 */
    public static final h0 m1298refreshToken$lambda1(AccessTokenProvider this$0, Throwable error) {
        m.g(this$0, "this$0");
        m.g(error, "error");
        RPCException rPCException = error instanceof RPCException ? (RPCException) error : null;
        if (rPCException != null) {
            if (m.c(rPCException.getCode(), RPCException.ErrorCodes.invalidParams)) {
                return this$0.signInHandler;
            }
            throw error;
        }
        throw error;
    }

    /* renamed from: refreshToken$lambda-2 */
    public static final String m1299refreshToken$lambda2(CreateAccessTokenResponseDTO it) {
        m.g(it, "it");
        return it.getToken();
    }

    public final void setAccessTokens(CreateAccessTokenResponseDTO createAccessTokenResponseDTO) {
        StoreInterface storeInterface = this.store;
        StoreKeys storeKeys = StoreKeys.INSTANCE;
        storeInterface.set(StoreKeys_UserKt.getAccessToken(storeKeys), createAccessTokenResponseDTO.getToken());
        this.store.set(StoreKeys_UserKt.getRefreshToken(storeKeys), createAccessTokenResponseDTO.getRefreshToken());
    }

    @Override // com.coinbase.wallet.features.networking.jwt.AccessTokenProviderInterface
    public String refreshToken() {
        b0<CreateAccessTokenResponseDTO> onErrorResumeNext;
        String str = (String) this.store.get(StoreKeys_UserKt.getRefreshToken(StoreKeys.INSTANCE));
        try {
            if (str == null) {
                onErrorResumeNext = this.signInHandler;
            } else {
                onErrorResumeNext = this.accessTokenApi.refreshAccessToken(str).subscribeOn(h.c.u0.a.c()).map(new n() { // from class: com.coinbase.wallet.features.networking.jwt.b
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return AccessTokenProvider.b((RPCResponse) obj);
                    }
                }).doOnSuccess(new f() { // from class: com.coinbase.wallet.features.networking.jwt.c
                    @Override // h.c.m0.f
                    public final void accept(Object obj) {
                        AccessTokenProvider.c(AccessTokenProvider.this, (CreateAccessTokenResponseDTO) obj);
                    }
                }).onErrorResumeNext(new n() { // from class: com.coinbase.wallet.features.networking.jwt.a
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return AccessTokenProvider.a(AccessTokenProvider.this, (Throwable) obj);
                    }
                });
                m.f(onErrorResumeNext, "{\n                accessTokenApi.refreshAccessToken(refreshToken)\n                    .subscribeOn(Schedulers.io())\n                    .map { it.result ?: throw AccessTokenException.UnableToRefreshAccessToken }\n                    .doOnSuccess(::setAccessTokens)\n                    .onErrorResumeNext { error ->\n                        val rpcError = error as? RPCException ?: throw error\n                        if (rpcError.code != RPCException.ErrorCodes.invalidParams) throw error\n\n                        signInHandler\n                    }\n            }");
            }
            return (String) onErrorResumeNext.map(new n() { // from class: com.coinbase.wallet.features.networking.jwt.d
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return AccessTokenProvider.d((CreateAccessTokenResponseDTO) obj);
                }
            }).blockingGet();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.coinbase.wallet.features.networking.jwt.AccessTokenProviderInterface
    public String token() {
        return (String) this.store.get(StoreKeys_UserKt.getAccessToken(StoreKeys.INSTANCE));
    }
}