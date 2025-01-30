package com.coinbase.resources.paymentmethods;

import com.coinbase.CoinbaseResponse;
import com.coinbase.PagedResponse;
import com.coinbase.PaginationParams;
import com.coinbase.network.ApiCall;
import com.coinbase.resources.ExpandUtils;
import com.coinbase.resources.paymentmethods.models.PaymentMethod;
import h.c.b0;

/* loaded from: classes.dex */
public class PaymentMethodResource {
    private PaymentMethodsApi paymentMethodsApi;
    private PaymentMethodsApiRx paymentMethodsApiRx;

    public PaymentMethodResource(PaymentMethodsApi paymentMethodsApi, PaymentMethodsApiRx paymentMethodsApiRx) {
        this.paymentMethodsApi = paymentMethodsApi;
        this.paymentMethodsApiRx = paymentMethodsApiRx;
    }

    public ApiCall<CoinbaseResponse<Void>> deletePaymentMethod(String str) {
        return this.paymentMethodsApi.deletePaymentMethod(str);
    }

    public b0<CoinbaseResponse<Void>> deletePaymentMethodRx(String str) {
        return this.paymentMethodsApiRx.deletePaymentMethod(str);
    }

    public ApiCall<CoinbaseResponse<PaymentMethod>> getPaymentMethod(String str, PaymentMethod.ExpandField... expandFieldArr) {
        return this.paymentMethodsApi.getPaymentMethod(str, ExpandUtils.toValueSet(expandFieldArr));
    }

    public b0<CoinbaseResponse<PaymentMethod>> getPaymentMethodRx(String str, PaymentMethod.ExpandField... expandFieldArr) {
        return this.paymentMethodsApiRx.getPaymentMethod(str, ExpandUtils.toValueSet(expandFieldArr));
    }

    public ApiCall<PagedResponse<PaymentMethod>> getPaymentMethods(PaymentMethod.ExpandField... expandFieldArr) {
        return this.paymentMethodsApi.getPaymentMethods(ExpandUtils.toValueSet(expandFieldArr));
    }

    public b0<PagedResponse<PaymentMethod>> getPaymentMethodsRx(PaymentMethod.ExpandField... expandFieldArr) {
        return this.paymentMethodsApiRx.getPaymentMethods(ExpandUtils.toValueSet(expandFieldArr));
    }

    public ApiCall<PagedResponse<PaymentMethod>> getPaymentMethods(PaginationParams paginationParams, PaymentMethod.ExpandField... expandFieldArr) {
        if (paginationParams == null) {
            return getPaymentMethods(expandFieldArr);
        }
        return this.paymentMethodsApi.getPaymentMethods(ExpandUtils.toValueSet(expandFieldArr), paginationParams.toQueryMap());
    }

    public b0<PagedResponse<PaymentMethod>> getPaymentMethodsRx(PaginationParams paginationParams, PaymentMethod.ExpandField... expandFieldArr) {
        if (paginationParams == null) {
            return getPaymentMethodsRx(expandFieldArr);
        }
        return this.paymentMethodsApiRx.getPaymentMethods(ExpandUtils.toValueSet(expandFieldArr), paginationParams.toQueryMap());
    }
}