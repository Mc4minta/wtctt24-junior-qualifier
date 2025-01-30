package com.coinbase.resources.paymentmethods;

import com.coinbase.ApiConstants;
import com.coinbase.CoinbaseResponse;
import com.coinbase.PagedResponse;
import com.coinbase.resources.paymentmethods.models.PaymentMethod;
import h.c.b0;
import java.util.Map;
import java.util.Set;
import retrofit2.z.b;
import retrofit2.z.f;
import retrofit2.z.s;
import retrofit2.z.t;
import retrofit2.z.u;

/* loaded from: classes.dex */
public interface PaymentMethodsApiRx {
    @b("payment-methods/{id}")
    b0<CoinbaseResponse<Void>> deletePaymentMethod(@s("id") String str);

    @f("payment-methods/{id}")
    b0<CoinbaseResponse<PaymentMethod>> getPaymentMethod(@s("id") String str, @t("expand[]") Set<String> set);

    @f(ApiConstants.PAYMENT_METHODS)
    b0<PagedResponse<PaymentMethod>> getPaymentMethods(@t("expand[]") Set<String> set);

    @f(ApiConstants.PAYMENT_METHODS)
    b0<PagedResponse<PaymentMethod>> getPaymentMethods(@t("expand[]") Set<String> set, @u Map<String, String> map);
}