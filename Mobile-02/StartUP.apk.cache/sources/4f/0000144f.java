package com.coinbase.wallet.common.extensions;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.wallets.models.ExchangeRate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.p;
import kotlin.jvm.internal.m;
import kotlin.l0.x;

/* compiled from: List+Wallets.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aC\u0010\n\u001a\u0004\u0018\u00010\t*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "Lcom/coinbase/wallet/wallets/models/ExchangeRate;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, ApiConstants.NAME, "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Ljava/math/BigDecimal;", "rateFor", "(Ljava/util/List;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Ljava/math/BigDecimal;", "wallets_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class List_WalletsKt {
    public static final BigDecimal rateFor(List<ExchangeRate> list, CurrencyCode currencyCode, String str, String str2, Integer num) {
        Object obj;
        boolean A;
        Object obj2;
        boolean z;
        Object obj3;
        boolean A2;
        Object obj4;
        boolean z2;
        m.g(list, "<this>");
        m.g(currencyCode, "currencyCode");
        if (m.c(currencyCode.getCode(), "MATIC") && str == null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj4 = null;
                    break;
                }
                obj4 = it.next();
                ExchangeRate exchangeRate = (ExchangeRate) obj4;
                if (m.c(exchangeRate.getCurrencyCode().getCode(), "MATIC") && exchangeRate.getContractAddress() == null) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
            ExchangeRate exchangeRate2 = (ExchangeRate) obj4;
            if (exchangeRate2 == null) {
                return null;
            }
            return exchangeRate2.getRate();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj5 : list) {
            if (m.c(((ExchangeRate) obj5).getCurrencyCode(), currencyCode)) {
                arrayList.add(obj5);
            }
        }
        if (arrayList.size() == 1) {
            return ((ExchangeRate) p.Y(arrayList)).getRate();
        }
        if (str != null) {
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj3 = null;
                    break;
                }
                obj3 = it2.next();
                String contractAddress = ((ExchangeRate) obj3).getContractAddress();
                if (contractAddress == null) {
                    A2 = false;
                    continue;
                } else {
                    A2 = x.A(contractAddress, str, true);
                    continue;
                }
                if (A2) {
                    break;
                }
            }
            ExchangeRate exchangeRate3 = (ExchangeRate) obj3;
            if (exchangeRate3 == null) {
                return null;
            }
            return exchangeRate3.getRate();
        } else if (num != null) {
            Iterator it3 = arrayList.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it3.next();
                ExchangeRate exchangeRate4 = (ExchangeRate) obj2;
                if (m.c(exchangeRate4.getCurrencyCode(), currencyCode) && m.c(exchangeRate4.getChainId(), num)) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            ExchangeRate exchangeRate5 = (ExchangeRate) obj2;
            if (exchangeRate5 == null) {
                return null;
            }
            return exchangeRate5.getRate();
        } else if (arrayList.size() > 0) {
            if (str2 == null) {
                str2 = currencyCode.getCode();
            }
            Iterator it4 = arrayList.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it4.next();
                A = x.A(((ExchangeRate) obj).getName(), str2, true);
                if (A) {
                    break;
                }
            }
            ExchangeRate exchangeRate6 = (ExchangeRate) obj;
            if (exchangeRate6 == null) {
                return null;
            }
            return exchangeRate6.getRate();
        } else {
            return null;
        }
    }

    public static /* synthetic */ BigDecimal rateFor$default(List list, CurrencyCode currencyCode, String str, String str2, Integer num, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        if ((i2 & 8) != 0) {
            num = null;
        }
        return rateFor(list, currencyCode, str, str2, num);
    }
}