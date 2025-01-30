package com.coinbase.wallet.blockchains.dbconverters;

import com.coinbase.wallet.blockchains.models.TxMetadata;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.core.util.JSON;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.squareup.moshi.JsonAdapter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.a0.m0;
import kotlin.jvm.internal.m;
import kotlin.l0.b0;
import kotlin.u;
import l.a.a;

/* compiled from: TxMetadataConverter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR(\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\r0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/coinbase/wallet/blockchains/dbconverters/TxMetadataConverter;", "", "", SendConfirmationArgs.metadataKey, "Lcom/coinbase/wallet/blockchains/models/TxMetadata;", "fromString", "(Ljava/lang/String;)Lcom/coinbase/wallet/blockchains/models/TxMetadata;", "toString", "(Lcom/coinbase/wallet/blockchains/models/TxMetadata;)Ljava/lang/String;", "Lcom/coinbase/wallet/blockchains/dbconverters/TxMetadataKeyConverter;", "keyAdapter", "Lcom/coinbase/wallet/blockchains/dbconverters/TxMetadataKeyConverter;", "Lcom/squareup/moshi/JsonAdapter;", "", "adapter", "Lcom/squareup/moshi/JsonAdapter;", "<init>", "()V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxMetadataConverter {
    private final JsonAdapter<Map<String, String>> adapter = JSON.INSTANCE.parameterizedAdapter(Map.class, String.class, String.class);
    private final TxMetadataKeyConverter keyAdapter = new TxMetadataKeyConverter();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r7v14, types: [java.lang.Float] */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r7v18, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r7v20, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v9, types: [kotlin.UInt] */
    public final TxMetadata fromString(String metadata) {
        Map r;
        m.g(metadata, "metadata");
        Map<String, String> fromJson = this.adapter.fromJson(metadata);
        if (fromJson == null) {
            r = null;
        } else {
            ArrayList arrayList = new ArrayList(fromJson.size());
            for (Map.Entry<String, String> entry : fromJson.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                TxMetadataKey fromString = this.keyAdapter.fromString(key);
                if (fromString != null) {
                    String className = fromString.getClassName();
                    if (!m.c(className, String.class.getName())) {
                        if (m.c(className, Integer.class.getName())) {
                            value = Integer.valueOf(Integer.parseInt(value));
                        } else if (m.c(className, Long.class.getName())) {
                            value = Long.valueOf(Long.parseLong(value));
                        } else if (m.c(className, Double.class.getName())) {
                            value = Double.valueOf(Double.parseDouble(value));
                        } else if (m.c(className, Float.class.getName())) {
                            value = Float.valueOf(Float.parseFloat(value));
                        } else if (m.c(className, Boolean.class.getName())) {
                            value = Boolean.valueOf(Boolean.parseBoolean(value));
                        } else if (m.c(className, BigInteger.class.getName())) {
                            value = new BigInteger(value);
                        } else if (m.c(className, UInt.class.getName())) {
                            value = UInt.h(b0.a(value));
                        } else {
                            a.d("Unknown class type " + fromString.getClassName() + " supported types are %s %s %s %s %s %s %s %s", String.class.getName(), Integer.class.getName(), Long.class.getName(), Double.class.getName(), Float.class.getName(), Boolean.class.getName(), BigInteger.class.getName(), UInt.class.getName());
                        }
                    }
                    arrayList.add(u.a(fromString, value));
                } else {
                    throw new IllegalStateException("Couldn't convert " + key + " to tx key");
                }
            }
            r = m0.r(arrayList);
        }
        if (r == null) {
            r = m0.i();
        }
        return new TxMetadata(r);
    }

    public final String toString(TxMetadata metadata) {
        Map<String, String> r;
        m.g(metadata, "metadata");
        Map<TxMetadataKey, Object> map = metadata.toMap();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<TxMetadataKey, Object> entry : map.entrySet()) {
            TxMetadataKey key = entry.getKey();
            Object value = entry.getValue();
            String name = value.getClass().getName();
            if (m.c(key.getClassName(), name)) {
                String txMetadataKeyConverter = this.keyAdapter.toString(key);
                if (txMetadataKeyConverter != null) {
                    arrayList.add(u.a(txMetadataKeyConverter, value.toString()));
                } else {
                    throw new IllegalStateException("Couldn't convert " + key + " to string");
                }
            } else {
                throw new IllegalStateException(key.getRawValue() + " expected type " + key.getClassName() + ", got " + ((Object) name));
            }
        }
        r = m0.r(arrayList);
        String json = this.adapter.toJson(r);
        m.f(json, "adapter.toJson(convertedMetadata)");
        return json;
    }
}