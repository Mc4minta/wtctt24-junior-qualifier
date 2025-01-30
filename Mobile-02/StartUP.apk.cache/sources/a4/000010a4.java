package com.coinbase.resources.accounts;

import com.coinbase.CoinbaseResponse;
import com.coinbase.PagedResponse;
import com.coinbase.PaginationParams;
import com.coinbase.network.ApiCall;
import h.c.b0;

/* loaded from: classes.dex */
public class AccountResource {
    private final AccountsApi accountsApi;
    private final AccountsApiRx accountsApiRx;

    public AccountResource(AccountsApi accountsApi, AccountsApiRx accountsApiRx) {
        this.accountsApi = accountsApi;
        this.accountsApiRx = accountsApiRx;
    }

    public ApiCall<CoinbaseResponse<Void>> deleteAccount(String str) {
        return this.accountsApi.deleteAccount(str);
    }

    public b0<CoinbaseResponse<Void>> deleteAccountRx(String str) {
        return this.accountsApiRx.deleteAccount(str);
    }

    public ApiCall<PagedResponse<Account>> getAccounts() {
        return this.accountsApi.getAccounts();
    }

    public b0<PagedResponse<Account>> getAccountsRx() {
        return this.accountsApiRx.getAccounts();
    }

    public ApiCall<CoinbaseResponse<Account>> setAccountPrimary(String str) {
        return this.accountsApi.setAccountPrimary(str);
    }

    public b0<CoinbaseResponse<Account>> setAccountPrimaryRx(String str) {
        return this.accountsApiRx.setAccountPrimary(str);
    }

    public ApiCall<CoinbaseResponse<Account>> showAccount(String str) {
        return this.accountsApi.showAccount(str);
    }

    public b0<CoinbaseResponse<Account>> showAccountRx(String str) {
        return this.accountsApiRx.showAccount(str);
    }

    public ApiCall<CoinbaseResponse<Account>> updateAccount(String str, String str2) {
        return this.accountsApi.updateAccount(str, new UpdateAccountRequest(str2));
    }

    public b0<CoinbaseResponse<Account>> updateAccountRx(String str, String str2) {
        return this.accountsApiRx.updateAccount(str, new UpdateAccountRequest(str2));
    }

    public ApiCall<PagedResponse<Account>> getAccounts(PaginationParams paginationParams) {
        if (paginationParams == null) {
            return getAccounts();
        }
        return this.accountsApi.getAccounts(paginationParams.toQueryMap());
    }

    public b0<PagedResponse<Account>> getAccountsRx(PaginationParams paginationParams) {
        if (paginationParams == null) {
            return getAccountsRx();
        }
        return this.accountsApiRx.getAccounts(paginationParams.toQueryMap());
    }
}