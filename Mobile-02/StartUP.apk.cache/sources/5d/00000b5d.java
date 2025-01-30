package com.coinbase.android.apiv3.generated.authed;

import com.coinbase.android.apiv3.V3Error;
import com.coinbase.network.adapter.NetworkResponse;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.f;
import retrofit2.z.o;
import retrofit2.z.t;

/* compiled from: WatchedAssetsService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ+\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\rH'¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0010H'¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/WatchedAssetsService;", "", "Lcom/coinbase/android/apiv3/generated/authed/AddWatchedAssetRequest;", "request", "Lh/c/b0;", "Lcom/coinbase/network/adapter/NetworkResponse;", "Lcom/coinbase/android/apiv3/generated/authed/WatchedAssetsResponse;", "Lcom/coinbase/android/apiv3/V3Error;", "addWatchedAsset", "(Lcom/coinbase/android/apiv3/generated/authed/AddWatchedAssetRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/ListWatchedAssetsRequest;", "listWatchedAssets", "(Lcom/coinbase/android/apiv3/generated/authed/ListWatchedAssetsRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/RemoveWatchedAssetRequest;", "removeWatchedAsset", "(Lcom/coinbase/android/apiv3/generated/authed/RemoveWatchedAssetRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/ReorderWatchedAssetsRequest;", "reorderWatchedAssets", "(Lcom/coinbase/android/apiv3/generated/authed/ReorderWatchedAssetsRequest;)Lh/c/b0;", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface WatchedAssetsService {
    @o("coinbase.public_api.authed.WatchedAssetsService/AddWatchedAsset")
    b0<NetworkResponse<WatchedAssetsResponse, V3Error>> addWatchedAsset(@retrofit2.z.a AddWatchedAssetRequest addWatchedAssetRequest);

    @f("coinbase.public_api.authed.WatchedAssetsService/ListWatchedAssets")
    b0<NetworkResponse<WatchedAssetsResponse, V3Error>> listWatchedAssets(@t("q") ListWatchedAssetsRequest listWatchedAssetsRequest);

    @o("coinbase.public_api.authed.WatchedAssetsService/RemoveWatchedAsset")
    b0<NetworkResponse<WatchedAssetsResponse, V3Error>> removeWatchedAsset(@retrofit2.z.a RemoveWatchedAssetRequest removeWatchedAssetRequest);

    @o("coinbase.public_api.authed.WatchedAssetsService/ReorderWatchedAssets")
    b0<NetworkResponse<WatchedAssetsResponse, V3Error>> reorderWatchedAssets(@retrofit2.z.a ReorderWatchedAssetsRequest reorderWatchedAssetsRequest);
}