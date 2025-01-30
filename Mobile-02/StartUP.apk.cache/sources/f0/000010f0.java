package com.coinbase.resources.transactions;

import com.coinbase.CoinbaseResponse;
import com.coinbase.PagedResponse;
import h.c.b0;
import java.util.Map;
import java.util.Set;
import retrofit2.z.a;
import retrofit2.z.b;
import retrofit2.z.f;
import retrofit2.z.i;
import retrofit2.z.o;
import retrofit2.z.s;
import retrofit2.z.t;
import retrofit2.z.u;

/* loaded from: classes.dex */
public interface TransactionsApiRx {
    @b("accounts/{account_id}/transactions/{transaction_id}")
    b0<CoinbaseResponse<Void>> cancelMoneyRequest(@s("account_id") String str, @s("transaction_id") String str2);

    @o("accounts/{account_id}/transactions/{transaction_id}/complete")
    b0<CoinbaseResponse<Transaction>> completeMoneyRequest(@s("account_id") String str, @s("transaction_id") String str2, @t("expand[]") Set<String> set);

    @f("accounts/{account_id}/transactions")
    b0<PagedResponse<Transaction>> listTransactions(@s("account_id") String str, @t("expand[]") Set<String> set);

    @f("accounts/{account_id}/transactions")
    b0<PagedResponse<Transaction>> listTransactions(@s("account_id") String str, @t("expand[]") Set<String> set, @u Map<String, String> map);

    @o("accounts/{account_id}/transactions")
    b0<CoinbaseResponse<Transaction>> requestMoney(@s("account_id") String str, @a MoneyRequest moneyRequest, @t("expand[]") Set<String> set);

    @o("accounts/{account_id}/transactions/{transaction_id}/resend")
    b0<CoinbaseResponse<Transaction>> resendMoneyRequest(@s("account_id") String str, @s("transaction_id") String str2, @t("expand[]") Set<String> set);

    @o("accounts/{account_id}/transactions")
    b0<CoinbaseResponse<Transaction>> sendMoney(@s("account_id") String str, @i("CB-2FA-Token") String str2, @a SendMoneyRequest sendMoneyRequest, @t("expand[]") Set<String> set);

    @f("accounts/{account_id}/transactions/{transaction_id}")
    b0<CoinbaseResponse<Transaction>> showTransaction(@s("account_id") String str, @s("transaction_id") String str2, @t("expand[]") Set<String> set);
}