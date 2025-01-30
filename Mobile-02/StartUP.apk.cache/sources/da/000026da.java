package com.coinbase.wallet.swap.models;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: SwapAssetInfoJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/swap/models/SwapAssetInfoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/swap/models/SwapAssetInfo;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/swap/models/SwapAssetInfo;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/swap/models/SwapAssetInfo;)V", "", "Lcom/coinbase/wallet/swap/models/Aggregator;", "listOfAggregatorAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "listOfSwapAssetAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapAssetInfoJsonAdapter extends JsonAdapter<SwapAssetInfo> {
    private final JsonAdapter<List<Aggregator>> listOfAggregatorAdapter;
    private final JsonAdapter<List<SwapAsset>> listOfSwapAssetAdapter;
    private final JsonReader.Options options;

    public SwapAssetInfoJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("aggregators", "supported", "unsupported");
        m.f(of, "of(\"aggregators\", \"supported\",\n      \"unsupported\")");
        this.options = of;
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, Aggregator.class);
        b2 = s0.b();
        JsonAdapter<List<Aggregator>> adapter = moshi.adapter(newParameterizedType, b2, "aggregators");
        m.f(adapter, "moshi.adapter(Types.newParameterizedType(List::class.java, Aggregator::class.java),\n      emptySet(), \"aggregators\")");
        this.listOfAggregatorAdapter = adapter;
        ParameterizedType newParameterizedType2 = Types.newParameterizedType(List.class, SwapAsset.class);
        b3 = s0.b();
        JsonAdapter<List<SwapAsset>> adapter2 = moshi.adapter(newParameterizedType2, b3, "supported");
        m.f(adapter2, "moshi.adapter(Types.newParameterizedType(List::class.java, SwapAsset::class.java), emptySet(),\n      \"supported\")");
        this.listOfSwapAssetAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(35);
        sb.append("GeneratedJsonAdapter(");
        sb.append("SwapAssetInfo");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public SwapAssetInfo fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        List<Aggregator> list = null;
        List<SwapAsset> list2 = null;
        List<SwapAsset> list3 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                list = this.listOfAggregatorAdapter.fromJson(reader);
                if (list == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("aggregators", "aggregators", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"aggregators\", \"aggregators\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                list2 = this.listOfSwapAssetAdapter.fromJson(reader);
                if (list2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("supported", "supported", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"supported\", \"supported\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (list3 = this.listOfSwapAssetAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("unsupported", "unsupported", reader);
                m.f(unexpectedNull3, "unexpectedNull(\"unsupported\", \"unsupported\", reader)");
                throw unexpectedNull3;
            }
        }
        reader.endObject();
        if (list == null) {
            JsonDataException missingProperty = Util.missingProperty("aggregators", "aggregators", reader);
            m.f(missingProperty, "missingProperty(\"aggregators\", \"aggregators\",\n            reader)");
            throw missingProperty;
        } else if (list2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("supported", "supported", reader);
            m.f(missingProperty2, "missingProperty(\"supported\", \"supported\", reader)");
            throw missingProperty2;
        } else if (list3 != null) {
            return new SwapAssetInfo(list, list2, list3);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("unsupported", "unsupported", reader);
            m.f(missingProperty3, "missingProperty(\"unsupported\", \"unsupported\",\n            reader)");
            throw missingProperty3;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, SwapAssetInfo swapAssetInfo) {
        m.g(writer, "writer");
        Objects.requireNonNull(swapAssetInfo, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("aggregators");
        this.listOfAggregatorAdapter.toJson(writer, (JsonWriter) swapAssetInfo.getAggregators());
        writer.name("supported");
        this.listOfSwapAssetAdapter.toJson(writer, (JsonWriter) swapAssetInfo.getSupported());
        writer.name("unsupported");
        this.listOfSwapAssetAdapter.toJson(writer, (JsonWriter) swapAssetInfo.getUnsupported());
        writer.endObject();
    }
}