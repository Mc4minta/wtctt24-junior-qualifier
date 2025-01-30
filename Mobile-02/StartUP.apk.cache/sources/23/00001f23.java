package com.coinbase.wallet.features.ofac.apis;

import com.coinbase.wallet.common.models.RPCResponse;
import com.coinbase.wallet.features.ofac.dtos.GeoAvailabilityDTO;
import h.c.b0;
import h.c.m0.n;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: OFACApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/features/ofac/apis/OFACApi;", "", "Lh/c/b0;", "", "checkIfOFACBanned", "()Lh/c/b0;", "Lcom/coinbase/wallet/features/ofac/apis/OFACApiHttp;", "api", "Lcom/coinbase/wallet/features/ofac/apis/OFACApiHttp;", "<init>", "(Lcom/coinbase/wallet/features/ofac/apis/OFACApiHttp;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class OFACApi {
    private final OFACApiHttp api;

    public OFACApi(OFACApiHttp api) {
        m.g(api, "api");
        this.api = api;
    }

    public static /* synthetic */ GeoAvailabilityDTO a(RPCResponse rPCResponse) {
        return m1300checkIfOFACBanned$lambda0(rPCResponse);
    }

    public static /* synthetic */ Boolean b(GeoAvailabilityDTO geoAvailabilityDTO) {
        return m1301checkIfOFACBanned$lambda1(geoAvailabilityDTO);
    }

    /* renamed from: checkIfOFACBanned$lambda-0 */
    public static final GeoAvailabilityDTO m1300checkIfOFACBanned$lambda0(RPCResponse it) {
        m.g(it, "it");
        GeoAvailabilityDTO geoAvailabilityDTO = (GeoAvailabilityDTO) it.getResult();
        if (geoAvailabilityDTO != null) {
            return geoAvailabilityDTO;
        }
        throw new Exception("Unable to check geo availability");
    }

    /* renamed from: checkIfOFACBanned$lambda-1 */
    public static final Boolean m1301checkIfOFACBanned$lambda1(GeoAvailabilityDTO it) {
        m.g(it, "it");
        return Boolean.valueOf(!it.getPermitted());
    }

    public final b0<Boolean> checkIfOFACBanned() {
        b0<Boolean> map = this.api.checkGeoAvailability().map(new n() { // from class: com.coinbase.wallet.features.ofac.apis.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return OFACApi.a((RPCResponse) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.features.ofac.apis.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return OFACApi.b((GeoAvailabilityDTO) obj);
            }
        });
        m.f(map, "api.checkGeoAvailability()\n            .map { it.result ?: throw Exception(\"Unable to check geo availability\") }\n            .map { !it.permitted }");
        return map;
    }
}