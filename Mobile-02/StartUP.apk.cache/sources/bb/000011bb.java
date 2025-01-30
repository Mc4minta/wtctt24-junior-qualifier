package com.coinbase.wallet.application.extensions;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.store.models.MemoryStoreKey;
import com.coinbase.wallet.store.models.SharedPrefsStoreKey;
import com.coinbase.wallet.store.models.StoreKeys;
import java.math.BigInteger;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: StoreKeys+Application.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u001a\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\u0005\u001a'\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0003*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000e\"'\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"'\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/store/models/StoreKeys;", "", "notificationId", "Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "lastNotificationAction", "(Lcom/coinbase/wallet/store/models/StoreKeys;Ljava/lang/String;)Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "", "lastNotificationSession", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Ljava/math/BigInteger;", "balance", "(Lcom/coinbase/wallet/store/models/StoreKeys;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;)Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "Lcom/coinbase/wallet/store/models/MemoryStoreKey;", "", "isAppUnlocked$delegate", "Lkotlin/h;", "isAppUnlocked", "(Lcom/coinbase/wallet/store/models/StoreKeys;)Lcom/coinbase/wallet/store/models/MemoryStoreKey;", "activeMnemonicHash$delegate", "getActiveMnemonicHash", "(Lcom/coinbase/wallet/store/models/StoreKeys;)Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "activeMnemonicHash", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class StoreKeys_ApplicationKt {
    private static final h activeMnemonicHash$delegate;
    private static final h isAppUnlocked$delegate;

    static {
        h b2;
        h b3;
        b2 = k.b(StoreKeys_ApplicationKt$isAppUnlocked$2.INSTANCE);
        isAppUnlocked$delegate = b2;
        b3 = k.b(StoreKeys_ApplicationKt$activeMnemonicHash$2.INSTANCE);
        activeMnemonicHash$delegate = b3;
    }

    public static final SharedPrefsStoreKey<BigInteger> balance(StoreKeys storeKeys, Blockchain blockchain, CurrencyCode currencyCode) {
        List j2;
        String h0;
        m.g(storeKeys, "<this>");
        m.g(blockchain, "blockchain");
        m.g(currencyCode, "currencyCode");
        j2 = r.j(blockchain.getRawValue(), currencyCode.getRawValue());
        h0 = z.h0(j2, "/", null, null, 0, null, null, 62, null);
        return new SharedPrefsStoreKey<>("balance", h0, false, BigInteger.class, 4, null);
    }

    public static final SharedPrefsStoreKey<String> getActiveMnemonicHash(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return (SharedPrefsStoreKey) activeMnemonicHash$delegate.getValue();
    }

    public static final MemoryStoreKey<Boolean> isAppUnlocked(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return (MemoryStoreKey) isAppUnlocked$delegate.getValue();
    }

    public static final SharedPrefsStoreKey<String> lastNotificationAction(StoreKeys storeKeys, String notificationId) {
        m.g(storeKeys, "<this>");
        m.g(notificationId, "notificationId");
        return new SharedPrefsStoreKey<>(m.o("lastNotificationAction/", notificationId), null, false, String.class, 6, null);
    }

    public static final SharedPrefsStoreKey<Integer> lastNotificationSession(StoreKeys storeKeys, String notificationId) {
        m.g(storeKeys, "<this>");
        m.g(notificationId, "notificationId");
        return new SharedPrefsStoreKey<>(m.o("lastNotificationSession/", notificationId), null, false, Integer.TYPE, 6, null);
    }
}