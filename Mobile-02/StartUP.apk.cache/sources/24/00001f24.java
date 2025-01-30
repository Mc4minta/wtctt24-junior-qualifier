package com.coinbase.wallet.features.ofac.apis;

import com.coinbase.wallet.common.models.RPCResponse;
import com.coinbase.wallet.features.ofac.dtos.GeoAvailabilityDTO;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.f;

/* compiled from: OFACApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/features/ofac/apis/OFACApiHttp;", "", "Lh/c/b0;", "Lcom/coinbase/wallet/common/models/RPCResponse;", "Lcom/coinbase/wallet/features/ofac/dtos/GeoAvailabilityDTO;", "checkGeoAvailability", "()Lh/c/b0;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface OFACApiHttp {
    @f("rpc/v2/checkGeoAvailability")
    b0<RPCResponse<GeoAvailabilityDTO>> checkGeoAvailability();
}