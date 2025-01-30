package com.coinbase.wallet.blockchains.dbconverters;

import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.core.util.AssertionException;
import com.coinbase.wallet.core.util.JSON;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import l.a.a;

/* compiled from: WalletAddressConverter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u0004\u0018\u00010\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/blockchains/dbconverters/WalletAddressConverter;", "", "", "value", "Lcom/coinbase/wallet/blockchains/models/WalletAddress;", "fromString", "(Ljava/lang/String;)Lcom/coinbase/wallet/blockchains/models/WalletAddress;", "toString", "(Lcom/coinbase/wallet/blockchains/models/WalletAddress;)Ljava/lang/String;", "", "fromStringToList", "(Ljava/lang/String;)Ljava/util/List;", "values", "toStringFromList", "(Ljava/util/List;)Ljava/lang/String;", "<init>", "()V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletAddressConverter {
    public final WalletAddress fromString(String str) {
        boolean z = false;
        if (str == null || str.length() == 0) {
            return null;
        }
        JSON json = JSON.INSTANCE;
        ReentrantReadWriteLock.ReadLock readLock = json.getMultiReadSingleWriteLock().readLock();
        readLock.lock();
        try {
            if (!(!e0.b(WalletAddress.class).getTypeParameters().isEmpty())) {
                z = true;
            }
            if (!z) {
                a.e(new AssertionException("Since " + ((Object) e0.b(WalletAddress.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
            }
            Object fromJson = json.getMoshi().adapter(WalletAddress.class).fromJson(str);
            readLock.unlock();
            return (WalletAddress) fromJson;
        } catch (Throwable th) {
            readLock.unlock();
            throw th;
        }
    }

    public final List<WalletAddress> fromStringToList(String str) {
        List<WalletAddress> g2;
        List<WalletAddress> g3;
        if (str == null) {
            g3 = r.g();
            return g3;
        }
        List<WalletAddress> list = (List) JSON.INSTANCE.parameterizedAdapter(List.class, WalletAddress.class).fromJson(str);
        if (list == null) {
            g2 = r.g();
            return g2;
        }
        return list;
    }

    public final String toString(WalletAddress walletAddress) {
        if (walletAddress == null) {
            return null;
        }
        JSON json = JSON.INSTANCE;
        ReentrantReadWriteLock.ReadLock readLock = json.getMultiReadSingleWriteLock().readLock();
        readLock.lock();
        try {
            String json2 = json.getMoshi().adapter(WalletAddress.class).toJson(walletAddress);
            m.f(json2, "adapter.toJson(instance)");
            return json2;
        } finally {
            readLock.unlock();
        }
    }

    public final String toStringFromList(List<WalletAddress> values) {
        m.g(values, "values");
        return JSON.INSTANCE.parameterizedAdapter(List.class, WalletAddress.class).toJson(values);
    }
}