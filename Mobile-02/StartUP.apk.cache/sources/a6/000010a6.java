package com.coinbase.resources.accounts;

import com.coinbase.ApiConstants;
import com.coinbase.CoinbaseResponse;
import com.coinbase.PagedResponse;
import h.c.b0;
import java.util.Map;
import retrofit2.z.a;
import retrofit2.z.b;
import retrofit2.z.f;
import retrofit2.z.o;
import retrofit2.z.p;
import retrofit2.z.s;
import retrofit2.z.u;

/* loaded from: classes.dex */
public interface AccountsApiRx {
    @b("accounts/{id}")
    b0<CoinbaseResponse<Void>> deleteAccount(@s("id") String str);

    @f(ApiConstants.ACCOUNTS)
    b0<PagedResponse<Account>> getAccounts();

    @f(ApiConstants.ACCOUNTS)
    b0<PagedResponse<Account>> getAccounts(@u Map<String, String> map);

    @o("accounts/{id}/primary")
    b0<CoinbaseResponse<Account>> setAccountPrimary(@s("id") String str);

    @f("accounts/{id}")
    b0<CoinbaseResponse<Account>> showAccount(@s("id") String str);

    @p("accounts/{id}")
    b0<CoinbaseResponse<Account>> updateAccount(@s("id") String str, @a UpdateAccountRequest updateAccountRequest);
}