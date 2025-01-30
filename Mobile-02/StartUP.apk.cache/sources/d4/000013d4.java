package com.coinbase.wallet.blockchains.dbconverters;

import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.core.util.AssertionException;
import com.coinbase.wallet.core.util.JSON;
import com.squareup.moshi.JsonAdapter;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import l.a.a;

/* compiled from: TxMetadataKeyConverter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/blockchains/dbconverters/TxMetadataKeyConverter;", "", "", "value", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "fromString", "(Ljava/lang/String;)Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "toString", "(Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;)Ljava/lang/String;", "Lcom/squareup/moshi/JsonAdapter;", "adapter", "Lcom/squareup/moshi/JsonAdapter;", "<init>", "()V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxMetadataKeyConverter {
    private final JsonAdapter<TxMetadataKey> adapter;

    public TxMetadataKeyConverter() {
        JSON json = JSON.INSTANCE;
        if (!e0.b(TxMetadataKey.class).getTypeParameters().isEmpty()) {
            a.e(new AssertionException(m.o(e0.b(TxMetadataKey.class).getSimpleName(), " is parameterized. Please use `parameterizedAdapter` function.")));
        }
        JsonAdapter<TxMetadataKey> adapter = json.getMoshi().adapter(TxMetadataKey.class);
        m.f(adapter, "moshi.adapter(T::class.java)");
        this.adapter = adapter;
    }

    public final TxMetadataKey fromString(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        TxMetadataKey fromJson = this.adapter.fromJson(str);
        if (!m.c(fromJson == null ? null : fromJson.getClassName(), "kotlin.u")) {
            if (!m.c(fromJson == null ? null : fromJson.getClassName(), "kotlin.v")) {
                return fromJson;
            }
        }
        String name = UInt.class.getName();
        m.f(name, "UInt::class.java.name");
        return TxMetadataKey.copy$default(fromJson, null, name, 1, null);
    }

    public final String toString(TxMetadataKey txMetadataKey) {
        return this.adapter.toJson(txMetadataKey);
    }
}