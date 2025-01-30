package com.coinbase.android.apiv3.generated.authed;

import com.coinbase.android.apiv3.V3Error;
import com.coinbase.network.adapter.NetworkResponse;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.f;
import retrofit2.z.t;

/* compiled from: Tax.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/Tax;", "", "Lcom/coinbase/android/apiv3/generated/authed/PayeeDataRequest;", "request", "Lh/c/b0;", "Lcom/coinbase/network/adapter/NetworkResponse;", "Lcom/coinbase/android/apiv3/generated/authed/PayeeDataResponse;", "Lcom/coinbase/android/apiv3/V3Error;", "getPayeeData", "(Lcom/coinbase/android/apiv3/generated/authed/PayeeDataRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/UserTaxInfoRequest;", "Lcom/coinbase/android/apiv3/generated/authed/UserTaxInfoResponse;", "getUserTaxInfo", "(Lcom/coinbase/android/apiv3/generated/authed/UserTaxInfoRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/UserTaxUrlRequest;", "Lcom/coinbase/android/apiv3/generated/authed/UserTaxUrlResponse;", "getUserTaxUrl", "(Lcom/coinbase/android/apiv3/generated/authed/UserTaxUrlRequest;)Lh/c/b0;", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface Tax {
    @f("coinbase.public_api.authed.Tax/GetPayeeData")
    b0<NetworkResponse<PayeeDataResponse, V3Error>> getPayeeData(@t("q") PayeeDataRequest payeeDataRequest);

    @f("coinbase.public_api.authed.Tax/GetUserTaxInfo")
    b0<NetworkResponse<UserTaxInfoResponse, V3Error>> getUserTaxInfo(@t("q") UserTaxInfoRequest userTaxInfoRequest);

    @f("coinbase.public_api.authed.Tax/GetUserTaxUrl")
    b0<NetworkResponse<UserTaxUrlResponse, V3Error>> getUserTaxUrl(@t("q") UserTaxUrlRequest userTaxUrlRequest);
}