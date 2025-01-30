package com.coinbase.android.apiv3.generated.authed.addresses;

import com.coinbase.android.apiv3.V3Error;
import com.coinbase.network.adapter.NetworkResponse;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.a;
import retrofit2.z.f;
import retrofit2.z.o;
import retrofit2.z.t;

/* compiled from: Addresses.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0012H'¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0015H'¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0019H'¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/addresses/Addresses;", "", "Lcom/coinbase/android/apiv3/generated/authed/addresses/ClearDismissalsRequest;", "request", "Lh/c/b0;", "Lcom/coinbase/network/adapter/NetworkResponse;", "Lcom/coinbase/android/apiv3/generated/authed/addresses/ClearDismissalsResponse;", "Lcom/coinbase/android/apiv3/V3Error;", "clearDismissals", "(Lcom/coinbase/android/apiv3/generated/authed/addresses/ClearDismissalsRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/addresses/CreateAddressRequest;", "Lcom/coinbase/android/apiv3/generated/authed/addresses/AddressResponse;", "createAddress", "(Lcom/coinbase/android/apiv3/generated/authed/addresses/CreateAddressRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/addresses/DismissWarningRequest;", "Lcom/coinbase/android/apiv3/generated/authed/addresses/DismissWarningResponse;", "dismissWarning", "(Lcom/coinbase/android/apiv3/generated/authed/addresses/DismissWarningRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/addresses/GetDetailsForAddressRequest;", "getDetailsForAddress", "(Lcom/coinbase/android/apiv3/generated/authed/addresses/GetDetailsForAddressRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/addresses/ListAddressesForAccountRequest;", "Lcom/coinbase/android/apiv3/generated/authed/addresses/AddressesResponse;", "listAddressesForAccount", "(Lcom/coinbase/android/apiv3/generated/authed/addresses/ListAddressesForAccountRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/addresses/UpdateLabelForAddressRequest;", "updateLabelForAddress", "(Lcom/coinbase/android/apiv3/generated/authed/addresses/UpdateLabelForAddressRequest;)Lh/c/b0;", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface Addresses {
    @o("coinbase.public_api.authed.addresses.Addresses/ClearDismissals")
    b0<NetworkResponse<ClearDismissalsResponse, V3Error>> clearDismissals(@a ClearDismissalsRequest clearDismissalsRequest);

    @o("coinbase.public_api.authed.addresses.Addresses/CreateAddress")
    b0<NetworkResponse<AddressResponse, V3Error>> createAddress(@a CreateAddressRequest createAddressRequest);

    @o("coinbase.public_api.authed.addresses.Addresses/DismissWarning")
    b0<NetworkResponse<DismissWarningResponse, V3Error>> dismissWarning(@a DismissWarningRequest dismissWarningRequest);

    @f("coinbase.public_api.authed.addresses.Addresses/GetDetailsForAddress")
    b0<NetworkResponse<AddressResponse, V3Error>> getDetailsForAddress(@t("q") GetDetailsForAddressRequest getDetailsForAddressRequest);

    @f("coinbase.public_api.authed.addresses.Addresses/ListAddressesForAccount")
    b0<NetworkResponse<AddressesResponse, V3Error>> listAddressesForAccount(@t("q") ListAddressesForAccountRequest listAddressesForAccountRequest);

    @o("coinbase.public_api.authed.addresses.Addresses/UpdateLabelForAddress")
    b0<NetworkResponse<AddressResponse, V3Error>> updateLabelForAddress(@a UpdateLabelForAddressRequest updateLabelForAddressRequest);
}