package com.coinbase.walletengine.services.dogecoin;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: CoinSelectionJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/coinbase/walletengine/services/dogecoin/CoinSelectionJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletengine/services/dogecoin/CoinSelection;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletengine/services/dogecoin/CoinSelection;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletengine/services/dogecoin/CoinSelection;)V", "", "Lcom/coinbase/walletengine/services/dogecoin/Output;", "listOfOutputAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletengine/services/dogecoin/UTXO;", "listOfUTXOAdapter", "Ljava/math/BigInteger;", "bigIntegerAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CoinSelectionJsonAdapter extends JsonAdapter<CoinSelection> {
    private final JsonAdapter<BigInteger> bigIntegerAdapter;
    private final JsonAdapter<List<Output>> listOfOutputAdapter;
    private final JsonAdapter<List<UTXO>> listOfUTXOAdapter;
    private final JsonReader.Options options;

    public CoinSelectionJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("inputs", "outputs", ApiConstants.FEE);
        m.f(of, "of(\"inputs\", \"outputs\", \"fee\")");
        this.options = of;
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, UTXO.class);
        b2 = s0.b();
        JsonAdapter<List<UTXO>> adapter = moshi.adapter(newParameterizedType, b2, "inputs");
        m.f(adapter, "moshi.adapter(Types.newParameterizedType(List::class.java, UTXO::class.java), emptySet(),\n      \"inputs\")");
        this.listOfUTXOAdapter = adapter;
        ParameterizedType newParameterizedType2 = Types.newParameterizedType(List.class, Output.class);
        b3 = s0.b();
        JsonAdapter<List<Output>> adapter2 = moshi.adapter(newParameterizedType2, b3, "outputs");
        m.f(adapter2, "moshi.adapter(Types.newParameterizedType(List::class.java, Output::class.java), emptySet(),\n      \"outputs\")");
        this.listOfOutputAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<BigInteger> adapter3 = moshi.adapter(BigInteger.class, b4, ApiConstants.FEE);
        m.f(adapter3, "moshi.adapter(BigInteger::class.java,\n      emptySet(), \"fee\")");
        this.bigIntegerAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(35);
        sb.append("GeneratedJsonAdapter(");
        sb.append("CoinSelection");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public CoinSelection fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        List<UTXO> list = null;
        List<Output> list2 = null;
        BigInteger bigInteger = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                list = this.listOfUTXOAdapter.fromJson(reader);
                if (list == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("inputs", "inputs", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"inputs\",\n            \"inputs\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                list2 = this.listOfOutputAdapter.fromJson(reader);
                if (list2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("outputs", "outputs", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"outputs\",\n            \"outputs\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (bigInteger = this.bigIntegerAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull(ApiConstants.FEE, ApiConstants.FEE, reader);
                m.f(unexpectedNull3, "unexpectedNull(\"fee\", \"fee\",\n            reader)");
                throw unexpectedNull3;
            }
        }
        reader.endObject();
        if (list == null) {
            JsonDataException missingProperty = Util.missingProperty("inputs", "inputs", reader);
            m.f(missingProperty, "missingProperty(\"inputs\", \"inputs\", reader)");
            throw missingProperty;
        } else if (list2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("outputs", "outputs", reader);
            m.f(missingProperty2, "missingProperty(\"outputs\", \"outputs\", reader)");
            throw missingProperty2;
        } else if (bigInteger != null) {
            return new CoinSelection(list, list2, bigInteger);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty(ApiConstants.FEE, ApiConstants.FEE, reader);
            m.f(missingProperty3, "missingProperty(\"fee\", \"fee\", reader)");
            throw missingProperty3;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, CoinSelection coinSelection) {
        m.g(writer, "writer");
        Objects.requireNonNull(coinSelection, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("inputs");
        this.listOfUTXOAdapter.toJson(writer, (JsonWriter) coinSelection.getInputs());
        writer.name("outputs");
        this.listOfOutputAdapter.toJson(writer, (JsonWriter) coinSelection.getOutputs());
        writer.name(ApiConstants.FEE);
        this.bigIntegerAdapter.toJson(writer, (JsonWriter) coinSelection.getFee());
        writer.endObject();
    }
}