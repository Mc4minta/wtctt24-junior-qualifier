package com.coinbase.wallet.swap.models;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: SwapFeeJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/swap/models/SwapFeeJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/swap/models/SwapFee;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/swap/models/SwapFee;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/swap/models/SwapFee;)V", "Ljava/math/BigDecimal;", "bigDecimalAdapter", "Lcom/squareup/moshi/JsonAdapter;", "stringAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "swapAssetAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapFeeJsonAdapter extends JsonAdapter<SwapFee> {
    private final JsonAdapter<BigDecimal> bigDecimalAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<SwapAsset> swapAssetAdapter;

    public SwapFeeJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("amount", "percentage", "baseAsset");
        m.f(of, "of(\"amount\", \"percentage\",\n      \"baseAsset\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<BigDecimal> adapter = moshi.adapter(BigDecimal.class, b2, "amount");
        m.f(adapter, "moshi.adapter(BigDecimal::class.java,\n      emptySet(), \"amount\")");
        this.bigDecimalAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, b3, "displayPercentage");
        m.f(adapter2, "moshi.adapter(String::class.java, emptySet(),\n      \"displayPercentage\")");
        this.stringAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<SwapAsset> adapter3 = moshi.adapter(SwapAsset.class, b4, "baseAsset");
        m.f(adapter3, "moshi.adapter(SwapAsset::class.java,\n      emptySet(), \"baseAsset\")");
        this.swapAssetAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(29);
        sb.append("GeneratedJsonAdapter(");
        sb.append("SwapFee");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public SwapFee fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        BigDecimal bigDecimal = null;
        String str = null;
        SwapAsset swapAsset = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                bigDecimal = this.bigDecimalAdapter.fromJson(reader);
                if (bigDecimal == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("amount", "amount", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"amount\",\n            \"amount\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("displayPercentage", "percentage", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"displayPercentage\", \"percentage\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (swapAsset = this.swapAssetAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("baseAsset", "baseAsset", reader);
                m.f(unexpectedNull3, "unexpectedNull(\"baseAsset\",\n            \"baseAsset\", reader)");
                throw unexpectedNull3;
            }
        }
        reader.endObject();
        if (bigDecimal == null) {
            JsonDataException missingProperty = Util.missingProperty("amount", "amount", reader);
            m.f(missingProperty, "missingProperty(\"amount\", \"amount\", reader)");
            throw missingProperty;
        } else if (str == null) {
            JsonDataException missingProperty2 = Util.missingProperty("displayPercentage", "percentage", reader);
            m.f(missingProperty2, "missingProperty(\"displayPercentage\",\n            \"percentage\", reader)");
            throw missingProperty2;
        } else if (swapAsset != null) {
            return new SwapFee(bigDecimal, str, swapAsset);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("baseAsset", "baseAsset", reader);
            m.f(missingProperty3, "missingProperty(\"baseAsset\", \"baseAsset\", reader)");
            throw missingProperty3;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, SwapFee swapFee) {
        m.g(writer, "writer");
        Objects.requireNonNull(swapFee, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("amount");
        this.bigDecimalAdapter.toJson(writer, (JsonWriter) swapFee.getAmount());
        writer.name("percentage");
        this.stringAdapter.toJson(writer, (JsonWriter) swapFee.getDisplayPercentage());
        writer.name("baseAsset");
        this.swapAssetAdapter.toJson(writer, (JsonWriter) swapFee.getBaseAsset());
        writer.endObject();
    }
}