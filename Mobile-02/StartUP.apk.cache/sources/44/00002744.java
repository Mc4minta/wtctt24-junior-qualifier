package com.coinbase.wallet.txhistory.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: GetERC20TokensResultDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/txhistory/dtos/GetERC20TokensResultDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/txhistory/dtos/GetERC20TokensResultDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/txhistory/dtos/GetERC20TokensResultDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/txhistory/dtos/GetERC20TokensResultDTO;)V", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GetERC20TokensResultDTOJsonAdapter extends JsonAdapter<GetERC20TokensResultDTO> {
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public GetERC20TokensResultDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(ApiConstants.FROM, ApiConstants.TO, "gasUsed", "gasPrice", "hash", "value", "timeStamp", "tokenSymbol");
        m.f(of, "of(\"from\", \"to\", \"gasUsed\",\n      \"gasPrice\", \"hash\", \"value\", \"timeStamp\", \"tokenSymbol\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, ApiConstants.FROM);
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"from\")");
        this.stringAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(45);
        sb.append("GeneratedJsonAdapter(");
        sb.append("GetERC20TokensResultDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public GetERC20TokensResultDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        while (true) {
            String str9 = str8;
            String str10 = str7;
            String str11 = str6;
            String str12 = str5;
            if (reader.hasNext()) {
                switch (reader.selectName(this.options)) {
                    case -1:
                        reader.skipName();
                        reader.skipValue();
                        str8 = str9;
                        str7 = str10;
                        str6 = str11;
                        break;
                    case 0:
                        str = this.stringAdapter.fromJson(reader);
                        if (str == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull(ApiConstants.FROM, ApiConstants.FROM, reader);
                            m.f(unexpectedNull, "unexpectedNull(\"from\", \"from\",\n            reader)");
                            throw unexpectedNull;
                        }
                        str8 = str9;
                        str7 = str10;
                        str6 = str11;
                        break;
                    case 1:
                        str2 = this.stringAdapter.fromJson(reader);
                        if (str2 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull(ApiConstants.TO, ApiConstants.TO, reader);
                            m.f(unexpectedNull2, "unexpectedNull(\"to\", \"to\", reader)");
                            throw unexpectedNull2;
                        }
                        str8 = str9;
                        str7 = str10;
                        str6 = str11;
                        break;
                    case 2:
                        str3 = this.stringAdapter.fromJson(reader);
                        if (str3 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("gasUsed", "gasUsed", reader);
                            m.f(unexpectedNull3, "unexpectedNull(\"gasUsed\",\n            \"gasUsed\", reader)");
                            throw unexpectedNull3;
                        }
                        str8 = str9;
                        str7 = str10;
                        str6 = str11;
                        break;
                    case 3:
                        str4 = this.stringAdapter.fromJson(reader);
                        if (str4 == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull("gasPrice", "gasPrice", reader);
                            m.f(unexpectedNull4, "unexpectedNull(\"gasPrice\",\n            \"gasPrice\", reader)");
                            throw unexpectedNull4;
                        }
                        str8 = str9;
                        str7 = str10;
                        str6 = str11;
                        break;
                    case 4:
                        str5 = this.stringAdapter.fromJson(reader);
                        if (str5 == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull("hash", "hash", reader);
                            m.f(unexpectedNull5, "unexpectedNull(\"hash\", \"hash\",\n            reader)");
                            throw unexpectedNull5;
                        }
                        str8 = str9;
                        str7 = str10;
                        str6 = str11;
                        continue;
                    case 5:
                        str6 = this.stringAdapter.fromJson(reader);
                        if (str6 == null) {
                            JsonDataException unexpectedNull6 = Util.unexpectedNull("value__", "value", reader);
                            m.f(unexpectedNull6, "unexpectedNull(\"value__\",\n            \"value\", reader)");
                            throw unexpectedNull6;
                        }
                        str8 = str9;
                        str7 = str10;
                        break;
                    case 6:
                        str7 = this.stringAdapter.fromJson(reader);
                        if (str7 == null) {
                            JsonDataException unexpectedNull7 = Util.unexpectedNull("timeStamp", "timeStamp", reader);
                            m.f(unexpectedNull7, "unexpectedNull(\"timeStamp\",\n            \"timeStamp\", reader)");
                            throw unexpectedNull7;
                        }
                        str8 = str9;
                        str6 = str11;
                        break;
                    case 7:
                        str8 = this.stringAdapter.fromJson(reader);
                        if (str8 == null) {
                            JsonDataException unexpectedNull8 = Util.unexpectedNull("tokenSymbol", "tokenSymbol", reader);
                            m.f(unexpectedNull8, "unexpectedNull(\"tokenSymbol\", \"tokenSymbol\", reader)");
                            throw unexpectedNull8;
                        }
                        str7 = str10;
                        str6 = str11;
                        break;
                    default:
                        str8 = str9;
                        str7 = str10;
                        str6 = str11;
                        break;
                }
                str5 = str12;
            } else {
                reader.endObject();
                if (str == null) {
                    JsonDataException missingProperty = Util.missingProperty(ApiConstants.FROM, ApiConstants.FROM, reader);
                    m.f(missingProperty, "missingProperty(\"from\", \"from\", reader)");
                    throw missingProperty;
                } else if (str2 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty(ApiConstants.TO, ApiConstants.TO, reader);
                    m.f(missingProperty2, "missingProperty(\"to\", \"to\", reader)");
                    throw missingProperty2;
                } else if (str3 == null) {
                    JsonDataException missingProperty3 = Util.missingProperty("gasUsed", "gasUsed", reader);
                    m.f(missingProperty3, "missingProperty(\"gasUsed\", \"gasUsed\", reader)");
                    throw missingProperty3;
                } else if (str4 == null) {
                    JsonDataException missingProperty4 = Util.missingProperty("gasPrice", "gasPrice", reader);
                    m.f(missingProperty4, "missingProperty(\"gasPrice\", \"gasPrice\", reader)");
                    throw missingProperty4;
                } else if (str12 == null) {
                    JsonDataException missingProperty5 = Util.missingProperty("hash", "hash", reader);
                    m.f(missingProperty5, "missingProperty(\"hash\", \"hash\", reader)");
                    throw missingProperty5;
                } else if (str11 == null) {
                    JsonDataException missingProperty6 = Util.missingProperty("value__", "value", reader);
                    m.f(missingProperty6, "missingProperty(\"value__\", \"value\", reader)");
                    throw missingProperty6;
                } else if (str10 == null) {
                    JsonDataException missingProperty7 = Util.missingProperty("timeStamp", "timeStamp", reader);
                    m.f(missingProperty7, "missingProperty(\"timeStamp\", \"timeStamp\", reader)");
                    throw missingProperty7;
                } else if (str9 != null) {
                    return new GetERC20TokensResultDTO(str, str2, str3, str4, str12, str11, str10, str9);
                } else {
                    JsonDataException missingProperty8 = Util.missingProperty("tokenSymbol", "tokenSymbol", reader);
                    m.f(missingProperty8, "missingProperty(\"tokenSymbol\", \"tokenSymbol\",\n            reader)");
                    throw missingProperty8;
                }
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, GetERC20TokensResultDTO getERC20TokensResultDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(getERC20TokensResultDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name(ApiConstants.FROM);
        this.stringAdapter.toJson(writer, (JsonWriter) getERC20TokensResultDTO.getFrom());
        writer.name(ApiConstants.TO);
        this.stringAdapter.toJson(writer, (JsonWriter) getERC20TokensResultDTO.getTo());
        writer.name("gasUsed");
        this.stringAdapter.toJson(writer, (JsonWriter) getERC20TokensResultDTO.getGasUsed());
        writer.name("gasPrice");
        this.stringAdapter.toJson(writer, (JsonWriter) getERC20TokensResultDTO.getGasPrice());
        writer.name("hash");
        this.stringAdapter.toJson(writer, (JsonWriter) getERC20TokensResultDTO.getHash());
        writer.name("value");
        this.stringAdapter.toJson(writer, (JsonWriter) getERC20TokensResultDTO.getValue());
        writer.name("timeStamp");
        this.stringAdapter.toJson(writer, (JsonWriter) getERC20TokensResultDTO.getTimeStamp());
        writer.name("tokenSymbol");
        this.stringAdapter.toJson(writer, (JsonWriter) getERC20TokensResultDTO.getTokenSymbol());
        writer.endObject();
    }
}