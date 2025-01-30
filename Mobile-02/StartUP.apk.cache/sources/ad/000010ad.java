package com.coinbase.resources.addresses;

import com.coinbase.CoinbaseResponse;
import com.coinbase.PagedResponse;
import com.coinbase.network.ApiCall;
import com.coinbase.resources.transactions.Transaction;
import java.util.Map;
import retrofit2.z.a;
import retrofit2.z.f;
import retrofit2.z.o;
import retrofit2.z.s;
import retrofit2.z.u;

/* loaded from: classes.dex */
public interface AddressesApi {
    @o("accounts/{account_id}/addresses")
    ApiCall<CoinbaseResponse<Address>> generateAddress(@s("account_id") String str, @a GenerateAddressRequest generateAddressRequest);

    @f("accounts/{account_id}/addresses/{address_id}/transactions")
    ApiCall<PagedResponse<Transaction>> getAddressTransactions(@s("account_id") String str, @s("address_id") String str2);

    @f("accounts/{account_id}/addresses/{address_id}/transactions")
    ApiCall<PagedResponse<Transaction>> getAddressTransactions(@s("account_id") String str, @s("address_id") String str2, @u Map<String, String> map);

    @f("accounts/{account_id}/addresses")
    ApiCall<PagedResponse<Address>> listAddresses(@s("account_id") String str);

    @f("accounts/{account_id}/addresses")
    ApiCall<PagedResponse<Address>> listAddresses(@s("account_id") String str, @u Map<String, String> map);

    @f("accounts/{account_id}/addresses/{address_id}")
    ApiCall<CoinbaseResponse<Address>> showAddress(@s("account_id") String str, @s("address_id") String str2);
}