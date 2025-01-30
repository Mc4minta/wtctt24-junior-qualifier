package com.coinbase.wallet.features.ethereum.apis;

import com.coinbase.wallet.common.exceptions.RPCException;
import com.coinbase.wallet.common.extensions.Throwable_CommonKt;
import com.coinbase.wallet.common.models.RPCResponse;
import com.coinbase.wallet.features.ethereum.dtos.GetCollectibleItemResponseDTO;
import com.coinbase.wallet.features.ethereum.dtos.GetCollectibleTypesResponseDTO;
import com.coinbase.wallet.features.ethereum.exceptions.CollectiblesException;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.reactnativecommunity.webview.RNCWebViewManager;
import h.c.b0;
import h.c.h0;
import h.c.m0.n;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: CollectiblesApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJE\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/features/ethereum/apis/CollectiblesApi;", "", "", "address", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lh/c/b0;", "", "Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleTypesResponseDTO$CollectibleTypeDetail;", "getCollectibleTypes", "(Ljava/lang/String;I)Lh/c/b0;", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "page", "perPage", "Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleItemResponseDTO$CollectibleItemDetail;", "getERC721Tokens", "(Ljava/lang/String;ILjava/lang/String;II)Lh/c/b0;", "Lcom/coinbase/wallet/features/ethereum/apis/CollectiblesApiHttp;", "api", "Lcom/coinbase/wallet/features/ethereum/apis/CollectiblesApiHttp;", "<init>", "(Lcom/coinbase/wallet/features/ethereum/apis/CollectiblesApiHttp;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CollectiblesApi {
    private final CollectiblesApiHttp api;

    public CollectiblesApi(CollectiblesApiHttp api) {
        m.g(api, "api");
        this.api = api;
    }

    public static /* synthetic */ h0 a(Throwable th) {
        return m1262getCollectibleTypes$lambda0(th);
    }

    public static /* synthetic */ GetCollectibleTypesResponseDTO b(RPCResponse rPCResponse) {
        return m1263getCollectibleTypes$lambda1(rPCResponse);
    }

    public static /* synthetic */ List c(GetCollectibleTypesResponseDTO getCollectibleTypesResponseDTO) {
        return m1264getCollectibleTypes$lambda2(getCollectibleTypesResponseDTO);
    }

    public static /* synthetic */ GetCollectibleItemResponseDTO d(RPCResponse rPCResponse) {
        return m1266getERC721Tokens$lambda4(rPCResponse);
    }

    public static /* synthetic */ h0 e(Throwable th) {
        return m1265getERC721Tokens$lambda3(th);
    }

    public static /* synthetic */ List f(GetCollectibleItemResponseDTO getCollectibleItemResponseDTO) {
        return m1267getERC721Tokens$lambda6(getCollectibleItemResponseDTO);
    }

    /* renamed from: getCollectibleTypes$lambda-0 */
    public static final h0 m1262getCollectibleTypes$lambda0(Throwable it) {
        m.g(it, "it");
        RPCException asRPCException = Throwable_CommonKt.asRPCException(it);
        if (asRPCException != null) {
            it = asRPCException;
        }
        return b0.error(it);
    }

    /* renamed from: getCollectibleTypes$lambda-1 */
    public static final GetCollectibleTypesResponseDTO m1263getCollectibleTypes$lambda1(RPCResponse it) {
        m.g(it, "it");
        GetCollectibleTypesResponseDTO getCollectibleTypesResponseDTO = (GetCollectibleTypesResponseDTO) it.getResult();
        if (getCollectibleTypesResponseDTO != null) {
            return getCollectibleTypesResponseDTO;
        }
        throw CollectiblesException.UnableToGetCollectibleTypes.INSTANCE;
    }

    /* renamed from: getCollectibleTypes$lambda-2 */
    public static final List m1264getCollectibleTypes$lambda2(GetCollectibleTypesResponseDTO it) {
        m.g(it, "it");
        return it.getCollectibles();
    }

    public static /* synthetic */ b0 getERC721Tokens$default(CollectiblesApi collectiblesApi, String str, int i2, String str2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i3 = 1;
        }
        int i6 = i3;
        if ((i5 & 16) != 0) {
            i4 = RNCWebViewManager.COMMAND_CLEAR_FORM_DATA;
        }
        return collectiblesApi.getERC721Tokens(str, i2, str2, i6, i4);
    }

    /* renamed from: getERC721Tokens$lambda-3 */
    public static final h0 m1265getERC721Tokens$lambda3(Throwable it) {
        m.g(it, "it");
        RPCException asRPCException = Throwable_CommonKt.asRPCException(it);
        if (asRPCException != null) {
            it = asRPCException;
        }
        return b0.error(it);
    }

    /* renamed from: getERC721Tokens$lambda-4 */
    public static final GetCollectibleItemResponseDTO m1266getERC721Tokens$lambda4(RPCResponse it) {
        m.g(it, "it");
        GetCollectibleItemResponseDTO getCollectibleItemResponseDTO = (GetCollectibleItemResponseDTO) it.getResult();
        if (getCollectibleItemResponseDTO != null) {
            return getCollectibleItemResponseDTO;
        }
        throw CollectiblesException.UnableToGetErc721Tokens.INSTANCE;
    }

    /* renamed from: getERC721Tokens$lambda-6 */
    public static final List m1267getERC721Tokens$lambda6(GetCollectibleItemResponseDTO it) {
        List B0;
        m.g(it, "it");
        B0 = z.B0(it.getItems(), new Comparator<T>() { // from class: com.coinbase.wallet.features.ethereum.apis.CollectiblesApi$getERC721Tokens$lambda-6$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int c2;
                c2 = kotlin.b0.b.c(((GetCollectibleItemResponseDTO.CollectibleItemDetail) t).getName(), ((GetCollectibleItemResponseDTO.CollectibleItemDetail) t2).getName());
                return c2;
            }
        });
        return B0;
    }

    public final b0<List<GetCollectibleTypesResponseDTO.CollectibleTypeDetail>> getCollectibleTypes(String address, int i2) {
        m.g(address, "address");
        b0<List<GetCollectibleTypesResponseDTO.CollectibleTypeDetail>> map = this.api.getCollectibleTypesForAddress(address, i2).onErrorResumeNext(new n() { // from class: com.coinbase.wallet.features.ethereum.apis.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CollectiblesApi.a((Throwable) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.features.ethereum.apis.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CollectiblesApi.b((RPCResponse) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.features.ethereum.apis.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CollectiblesApi.c((GetCollectibleTypesResponseDTO) obj);
            }
        });
        m.f(map, "api.getCollectibleTypesForAddress(address, chainId)\n            .onErrorResumeNext { Single.error(it.asRPCException() ?: it) }\n            .map { it.result ?: throw CollectiblesException.UnableToGetCollectibleTypes }\n            .map { it.collectibles }");
        return map;
    }

    public final b0<List<GetCollectibleItemResponseDTO.CollectibleItemDetail>> getERC721Tokens(String address, int i2, String contractAddress, int i3, int i4) {
        Map<String, String> l2;
        m.g(address, "address");
        m.g(contractAddress, "contractAddress");
        l2 = m0.l(u.a("address", address), u.a(RouteActionKey.RouteActionKeys.CHAIN_ID, String.valueOf(i2)), u.a(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, contractAddress), u.a("page", String.valueOf(i3)), u.a("perPage", String.valueOf(i4)));
        b0<List<GetCollectibleItemResponseDTO.CollectibleItemDetail>> map = this.api.getERC721Tokens(l2).onErrorResumeNext(new n() { // from class: com.coinbase.wallet.features.ethereum.apis.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CollectiblesApi.e((Throwable) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.features.ethereum.apis.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CollectiblesApi.d((RPCResponse) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.features.ethereum.apis.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CollectiblesApi.f((GetCollectibleItemResponseDTO) obj);
            }
        });
        m.f(map, "api.getERC721Tokens(params)\n            .onErrorResumeNext { Single.error(it.asRPCException() ?: it) }\n            .map { it.result ?: throw CollectiblesException.UnableToGetErc721Tokens }\n            .map { it.items.sortedBy { it.name } }");
        return map;
    }
}