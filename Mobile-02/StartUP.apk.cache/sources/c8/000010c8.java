package com.coinbase.resources.paymentmethods;

import com.coinbase.ApiConstants;
import com.coinbase.CoinbaseResponse;
import com.coinbase.PagedResponse;
import com.coinbase.network.ApiCall;
import com.coinbase.resources.paymentmethods.models.PaymentMethod;
import java.util.Map;
import java.util.Set;
import retrofit2.z.b;
import retrofit2.z.f;
import retrofit2.z.s;
import retrofit2.z.t;
import retrofit2.z.u;

/* loaded from: classes.dex */
public interface PaymentMethodsApi {
    @b("payment-methods/{id}")
    ApiCall<CoinbaseResponse<Void>> deletePaymentMethod(@s("id") String str);

    @f("payment-methods/{id}")
    ApiCall<CoinbaseResponse<PaymentMethod>> getPaymentMethod(@s("id") String str, @t("expand[]") Set<String> set);

    @f(ApiConstants.PAYMENT_METHODS)
    ApiCall<PagedResponse<PaymentMethod>> getPaymentMethods(@t("expand[]") Set<String> set);

    @f(ApiConstants.PAYMENT_METHODS)
    ApiCall<PagedResponse<PaymentMethod>> getPaymentMethods(@t("expand[]") Set<String> set, @u Map<String, String> map);
}