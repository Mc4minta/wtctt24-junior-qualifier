package com.coinbase.wallet.features.ethereum.apis;

import com.coinbase.wallet.common.models.RPCResponse;
import com.coinbase.wallet.features.ethereum.dtos.GetCollectibleItemResponseDTO;
import com.coinbase.wallet.features.ethereum.dtos.GetCollectibleTypesResponseDTO;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.user.annotations.AuthenticatedRequest;
import h.c.b0;
import java.util.Map;
import kotlin.Metadata;
import retrofit2.z.t;
import retrofit2.z.u;

/* compiled from: CollectiblesApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\t\u0010\nJ1\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\u00062\u0014\b\u0001\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/coinbase/wallet/features/ethereum/apis/CollectiblesApiHttp;", "", "", "address", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lh/c/b0;", "Lcom/coinbase/wallet/common/models/RPCResponse;", "Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleTypesResponseDTO;", "getCollectibleTypesForAddress", "(Ljava/lang/String;I)Lh/c/b0;", "", "params", "Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleItemResponseDTO;", "getERC721Tokens", "(Ljava/util/Map;)Lh/c/b0;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface CollectiblesApiHttp {
    @retrofit2.z.f("rpc/v2/getCollectiblesOwnedByAddress")
    @AuthenticatedRequest
    b0<RPCResponse<GetCollectibleTypesResponseDTO>> getCollectibleTypesForAddress(@t("address") String str, @t("chainId") int i2);

    @retrofit2.z.f("rpc/v2/getCollectibleItemsOwnedByAddress")
    @AuthenticatedRequest
    b0<RPCResponse<GetCollectibleItemResponseDTO>> getERC721Tokens(@u Map<String, String> map);
}