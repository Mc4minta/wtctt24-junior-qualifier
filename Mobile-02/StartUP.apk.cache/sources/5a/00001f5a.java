package com.coinbase.wallet.features.send.apis;

import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.common.exceptions.RPCException;
import com.coinbase.wallet.common.extensions.Throwable_CommonKt;
import com.coinbase.wallet.common.models.RPCResponse;
import com.coinbase.wallet.features.send.dtos.GetUserAddressDTO;
import com.coinbase.wallet.features.send.dtos.SearchUsernamesDTO;
import h.c.b0;
import h.c.h0;
import h.c.m0.n;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: RecipientAPI.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\f\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00020\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/coinbase/wallet/features/send/apis/RecipientAPI;", "", "", "query", "Lh/c/b0;", "", "search", "(Ljava/lang/String;)Lh/c/b0;", "username", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "chain", "kotlin.jvm.PlatformType", "getUserAddress", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Blockchain;)Lh/c/b0;", "Lcom/coinbase/wallet/features/send/apis/RecipientAPIHttp;", "api", "Lcom/coinbase/wallet/features/send/apis/RecipientAPIHttp;", "<init>", "(Lcom/coinbase/wallet/features/send/apis/RecipientAPIHttp;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RecipientAPI {
    private final RecipientAPIHttp api;

    public RecipientAPI(RecipientAPIHttp api) {
        m.g(api, "api");
        this.api = api;
    }

    public static /* synthetic */ h0 a(Throwable th) {
        return m1324getUserAddress$lambda3(th);
    }

    public static /* synthetic */ SearchUsernamesDTO b(RPCResponse rPCResponse) {
        return m1328search$lambda1(rPCResponse);
    }

    public static /* synthetic */ h0 c(Throwable th) {
        return m1327search$lambda0(th);
    }

    public static /* synthetic */ GetUserAddressDTO d(RPCResponse rPCResponse) {
        return m1325getUserAddress$lambda4(rPCResponse);
    }

    public static /* synthetic */ List e(SearchUsernamesDTO searchUsernamesDTO) {
        return m1329search$lambda2(searchUsernamesDTO);
    }

    public static /* synthetic */ String f(GetUserAddressDTO getUserAddressDTO) {
        return m1326getUserAddress$lambda5(getUserAddressDTO);
    }

    /* renamed from: getUserAddress$lambda-3 */
    public static final h0 m1324getUserAddress$lambda3(Throwable it) {
        m.g(it, "it");
        RPCException asRPCException = Throwable_CommonKt.asRPCException(it);
        if (asRPCException != null) {
            it = asRPCException;
        }
        return b0.error(it);
    }

    /* renamed from: getUserAddress$lambda-4 */
    public static final GetUserAddressDTO m1325getUserAddress$lambda4(RPCResponse it) {
        m.g(it, "it");
        GetUserAddressDTO getUserAddressDTO = (GetUserAddressDTO) it.getResult();
        if (getUserAddressDTO != null) {
            return getUserAddressDTO;
        }
        throw new IllegalStateException("No result and no error");
    }

    /* renamed from: getUserAddress$lambda-5 */
    public static final String m1326getUserAddress$lambda5(GetUserAddressDTO it) {
        m.g(it, "it");
        return it.getAddress();
    }

    /* renamed from: search$lambda-0 */
    public static final h0 m1327search$lambda0(Throwable it) {
        m.g(it, "it");
        RPCException asRPCException = Throwable_CommonKt.asRPCException(it);
        if (asRPCException != null) {
            it = asRPCException;
        }
        return b0.error(it);
    }

    /* renamed from: search$lambda-1 */
    public static final SearchUsernamesDTO m1328search$lambda1(RPCResponse it) {
        m.g(it, "it");
        SearchUsernamesDTO searchUsernamesDTO = (SearchUsernamesDTO) it.getResult();
        if (searchUsernamesDTO != null) {
            return searchUsernamesDTO;
        }
        throw new IllegalStateException("No result and no error");
    }

    /* renamed from: search$lambda-2 */
    public static final List m1329search$lambda2(SearchUsernamesDTO it) {
        m.g(it, "it");
        return it.getUsernames();
    }

    public final b0<String> getUserAddress(String username, Blockchain chain) {
        m.g(username, "username");
        m.g(chain, "chain");
        RecipientAPIHttp recipientAPIHttp = this.api;
        String rawValue = chain.getRawValue();
        Locale US = Locale.US;
        m.f(US, "US");
        Objects.requireNonNull(rawValue, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = rawValue.toLowerCase(US);
        m.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        b0<String> map = recipientAPIHttp.getUserAddress(username, lowerCase).onErrorResumeNext(new n() { // from class: com.coinbase.wallet.features.send.apis.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return RecipientAPI.a((Throwable) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.features.send.apis.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return RecipientAPI.d((RPCResponse) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.features.send.apis.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return RecipientAPI.f((GetUserAddressDTO) obj);
            }
        });
        m.f(map, "api.getUserAddress(username, chain.rawValue.toLowerCase(Locale.US))\n        .onErrorResumeNext { Single.error(it.asRPCException() ?: it) }\n        .map { it.result ?: throw IllegalStateException(\"No result and no error\") }\n        .map { it.address }");
        return map;
    }

    public final b0<List<String>> search(String query) {
        m.g(query, "query");
        b0<List<String>> map = this.api.search(query).onErrorResumeNext(new n() { // from class: com.coinbase.wallet.features.send.apis.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return RecipientAPI.c((Throwable) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.features.send.apis.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return RecipientAPI.b((RPCResponse) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.features.send.apis.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return RecipientAPI.e((SearchUsernamesDTO) obj);
            }
        });
        m.f(map, "api.search(query)\n        .onErrorResumeNext { Single.error(it.asRPCException() ?: it) }\n        .map { it.result ?: throw IllegalStateException(\"No result and no error\") }\n        .map { it.usernames }");
        return map;
    }
}