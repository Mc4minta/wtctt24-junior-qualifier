package com.coinbase.resources.addresses;

import com.coinbase.CoinbaseResponse;
import com.coinbase.PagedResponse;
import com.coinbase.PaginationParams;
import com.coinbase.network.ApiCall;
import com.coinbase.resources.transactions.Transaction;
import h.c.b0;

/* loaded from: classes.dex */
public class AddressResource {
    private final AddressesApi addressesApi;
    private final AddressesApiRx addressesApiRx;

    public AddressResource(AddressesApi addressesApi, AddressesApiRx addressesApiRx) {
        this.addressesApi = addressesApi;
        this.addressesApiRx = addressesApiRx;
    }

    public ApiCall<CoinbaseResponse<Address>> generateAddress(String str, String str2) {
        return this.addressesApi.generateAddress(str, new GenerateAddressRequest(str2));
    }

    public b0<CoinbaseResponse<Address>> generateAddressRx(String str, String str2) {
        return this.addressesApiRx.generateAddress(str, new GenerateAddressRequest(str2));
    }

    public ApiCall<PagedResponse<Transaction>> getAddressTransactions(String str, String str2) {
        return this.addressesApi.getAddressTransactions(str, str2);
    }

    public b0<PagedResponse<Transaction>> getAddressTransactionsRx(String str, String str2) {
        return this.addressesApiRx.getAddressTransactions(str, str2);
    }

    public ApiCall<PagedResponse<Address>> listAddresses(String str) {
        return this.addressesApi.listAddresses(str);
    }

    public b0<PagedResponse<Address>> listAddressesRx(String str) {
        return this.addressesApiRx.listAddresses(str);
    }

    public ApiCall<CoinbaseResponse<Address>> showAddress(String str, String str2) {
        return this.addressesApi.showAddress(str, str2);
    }

    public b0<CoinbaseResponse<Address>> showAddressRx(String str, String str2) {
        return this.addressesApiRx.showAddress(str, str2);
    }

    public ApiCall<PagedResponse<Transaction>> getAddressTransactions(String str, String str2, PaginationParams paginationParams) {
        if (paginationParams == null) {
            return getAddressTransactions(str, str2);
        }
        return this.addressesApi.getAddressTransactions(str, str2, paginationParams.toQueryMap());
    }

    public b0<PagedResponse<Transaction>> getAddressTransactionsRx(String str, String str2, PaginationParams paginationParams) {
        if (paginationParams == null) {
            return getAddressTransactionsRx(str, str2);
        }
        return this.addressesApiRx.getAddressTransactions(str, str2, paginationParams.toQueryMap());
    }

    public ApiCall<PagedResponse<Address>> listAddresses(String str, PaginationParams paginationParams) {
        if (paginationParams == null) {
            return listAddresses(str);
        }
        return this.addressesApi.listAddresses(str, paginationParams.toQueryMap());
    }

    public b0<PagedResponse<Address>> listAddressesRx(String str, PaginationParams paginationParams) {
        if (paginationParams == null) {
            return listAddressesRx(str);
        }
        return this.addressesApiRx.listAddresses(str, paginationParams.toQueryMap());
    }
}