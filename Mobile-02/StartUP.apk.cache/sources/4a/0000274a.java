package com.coinbase.wallet.txhistory.dtos;

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
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: GetHdWalletTxsResponseJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/txhistory/dtos/GetHdWalletTxsResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/txhistory/dtos/GetHdWalletTxsResponse;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/txhistory/dtos/GetHdWalletTxsResponse;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/txhistory/dtos/GetHdWalletTxsResponse;)V", "", "doubleAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "", "Lcom/coinbase/wallet/txhistory/dtos/GetHdWalletTxsInputOutput;", "listOfGetHdWalletTxsInputOutputAdapter", "stringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GetHdWalletTxsResponseJsonAdapter extends JsonAdapter<GetHdWalletTxsResponse> {
    private final JsonAdapter<Double> doubleAdapter;
    private final JsonAdapter<List<GetHdWalletTxsInputOutput>> listOfGetHdWalletTxsInputOutputAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public GetHdWalletTxsResponseJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("hash", "height", "block", "confirmations", ApiConstants.TIME, "inputs", "outputs");
        m.f(of, "of(\"hash\", \"height\", \"block\",\n      \"confirmations\", \"time\", \"inputs\", \"outputs\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "hash");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"hash\")");
        this.stringAdapter = adapter;
        Class cls = Double.TYPE;
        b3 = s0.b();
        JsonAdapter<Double> adapter2 = moshi.adapter(cls, b3, "height");
        m.f(adapter2, "moshi.adapter(Double::class.java, emptySet(),\n      \"height\")");
        this.doubleAdapter = adapter2;
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, GetHdWalletTxsInputOutput.class);
        b4 = s0.b();
        JsonAdapter<List<GetHdWalletTxsInputOutput>> adapter3 = moshi.adapter(newParameterizedType, b4, "inputs");
        m.f(adapter3, "moshi.adapter(Types.newParameterizedType(List::class.java,\n      GetHdWalletTxsInputOutput::class.java), emptySet(), \"inputs\")");
        this.listOfGetHdWalletTxsInputOutputAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(44);
        sb.append("GeneratedJsonAdapter(");
        sb.append("GetHdWalletTxsResponse");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public GetHdWalletTxsResponse fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        Double d2 = null;
        Double d3 = null;
        String str = null;
        Double d4 = null;
        String str2 = null;
        List<GetHdWalletTxsInputOutput> list = null;
        List<GetHdWalletTxsInputOutput> list2 = null;
        while (true) {
            List<GetHdWalletTxsInputOutput> list3 = list2;
            if (reader.hasNext()) {
                switch (reader.selectName(this.options)) {
                    case -1:
                        reader.skipName();
                        reader.skipValue();
                        break;
                    case 0:
                        str = this.stringAdapter.fromJson(reader);
                        if (str == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("hash", "hash", reader);
                            m.f(unexpectedNull, "unexpectedNull(\"hash\", \"hash\",\n            reader)");
                            throw unexpectedNull;
                        }
                        break;
                    case 1:
                        d2 = this.doubleAdapter.fromJson(reader);
                        if (d2 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("height", "height", reader);
                            m.f(unexpectedNull2, "unexpectedNull(\"height\",\n            \"height\", reader)");
                            throw unexpectedNull2;
                        }
                        break;
                    case 2:
                        str2 = this.stringAdapter.fromJson(reader);
                        if (str2 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("block", "block", reader);
                            m.f(unexpectedNull3, "unexpectedNull(\"block\", \"block\",\n            reader)");
                            throw unexpectedNull3;
                        }
                        break;
                    case 3:
                        d3 = this.doubleAdapter.fromJson(reader);
                        if (d3 == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull("confirmations", "confirmations", reader);
                            m.f(unexpectedNull4, "unexpectedNull(\"confirmations\", \"confirmations\", reader)");
                            throw unexpectedNull4;
                        }
                        break;
                    case 4:
                        d4 = this.doubleAdapter.fromJson(reader);
                        if (d4 == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull(ApiConstants.TIME, ApiConstants.TIME, reader);
                            m.f(unexpectedNull5, "unexpectedNull(\"time\", \"time\",\n            reader)");
                            throw unexpectedNull5;
                        }
                        break;
                    case 5:
                        list = this.listOfGetHdWalletTxsInputOutputAdapter.fromJson(reader);
                        if (list == null) {
                            JsonDataException unexpectedNull6 = Util.unexpectedNull("inputs", "inputs", reader);
                            m.f(unexpectedNull6, "unexpectedNull(\"inputs\", \"inputs\", reader)");
                            throw unexpectedNull6;
                        }
                        break;
                    case 6:
                        list2 = this.listOfGetHdWalletTxsInputOutputAdapter.fromJson(reader);
                        if (list2 == null) {
                            JsonDataException unexpectedNull7 = Util.unexpectedNull("outputs", "outputs", reader);
                            m.f(unexpectedNull7, "unexpectedNull(\"outputs\", \"outputs\", reader)");
                            throw unexpectedNull7;
                        }
                        continue;
                }
                list2 = list3;
            } else {
                reader.endObject();
                if (str == null) {
                    JsonDataException missingProperty = Util.missingProperty("hash", "hash", reader);
                    m.f(missingProperty, "missingProperty(\"hash\", \"hash\", reader)");
                    throw missingProperty;
                } else if (d2 != null) {
                    double doubleValue = d2.doubleValue();
                    if (str2 == null) {
                        JsonDataException missingProperty2 = Util.missingProperty("block", "block", reader);
                        m.f(missingProperty2, "missingProperty(\"block\", \"block\", reader)");
                        throw missingProperty2;
                    } else if (d3 != null) {
                        double doubleValue2 = d3.doubleValue();
                        if (d4 != null) {
                            double doubleValue3 = d4.doubleValue();
                            if (list == null) {
                                JsonDataException missingProperty3 = Util.missingProperty("inputs", "inputs", reader);
                                m.f(missingProperty3, "missingProperty(\"inputs\", \"inputs\", reader)");
                                throw missingProperty3;
                            } else if (list3 != null) {
                                return new GetHdWalletTxsResponse(str, doubleValue, str2, doubleValue2, doubleValue3, list, list3);
                            } else {
                                JsonDataException missingProperty4 = Util.missingProperty("outputs", "outputs", reader);
                                m.f(missingProperty4, "missingProperty(\"outputs\", \"outputs\", reader)");
                                throw missingProperty4;
                            }
                        }
                        JsonDataException missingProperty5 = Util.missingProperty(ApiConstants.TIME, ApiConstants.TIME, reader);
                        m.f(missingProperty5, "missingProperty(\"time\", \"time\", reader)");
                        throw missingProperty5;
                    } else {
                        JsonDataException missingProperty6 = Util.missingProperty("confirmations", "confirmations", reader);
                        m.f(missingProperty6, "missingProperty(\"confirmations\",\n            \"confirmations\", reader)");
                        throw missingProperty6;
                    }
                } else {
                    JsonDataException missingProperty7 = Util.missingProperty("height", "height", reader);
                    m.f(missingProperty7, "missingProperty(\"height\", \"height\", reader)");
                    throw missingProperty7;
                }
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, GetHdWalletTxsResponse getHdWalletTxsResponse) {
        m.g(writer, "writer");
        Objects.requireNonNull(getHdWalletTxsResponse, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("hash");
        this.stringAdapter.toJson(writer, (JsonWriter) getHdWalletTxsResponse.getHash());
        writer.name("height");
        this.doubleAdapter.toJson(writer, (JsonWriter) Double.valueOf(getHdWalletTxsResponse.getHeight()));
        writer.name("block");
        this.stringAdapter.toJson(writer, (JsonWriter) getHdWalletTxsResponse.getBlock());
        writer.name("confirmations");
        this.doubleAdapter.toJson(writer, (JsonWriter) Double.valueOf(getHdWalletTxsResponse.getConfirmations()));
        writer.name(ApiConstants.TIME);
        this.doubleAdapter.toJson(writer, (JsonWriter) Double.valueOf(getHdWalletTxsResponse.getTime()));
        writer.name("inputs");
        this.listOfGetHdWalletTxsInputOutputAdapter.toJson(writer, (JsonWriter) getHdWalletTxsResponse.getInputs());
        writer.name("outputs");
        this.listOfGetHdWalletTxsInputOutputAdapter.toJson(writer, (JsonWriter) getHdWalletTxsResponse.getOutputs());
        writer.endObject();
    }
}