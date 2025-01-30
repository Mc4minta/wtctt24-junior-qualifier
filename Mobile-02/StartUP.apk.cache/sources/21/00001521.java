package com.coinbase.wallet.compoundfinance.dtos;

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

/* compiled from: GetCTokenInfoDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/compoundfinance/dtos/GetCTokenInfoDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/compoundfinance/dtos/GetCTokenInfoDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/compoundfinance/dtos/GetCTokenInfoDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/compoundfinance/dtos/GetCTokenInfoDTO;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "", "Lcom/coinbase/wallet/compoundfinance/dtos/CTokenInfoDTO;", "listOfCTokenInfoDTOAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "compoundfinance_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GetCTokenInfoDTOJsonAdapter extends JsonAdapter<GetCTokenInfoDTO> {
    private final JsonAdapter<List<CTokenInfoDTO>> listOfCTokenInfoDTOAdapter;
    private final JsonReader.Options options;

    public GetCTokenInfoDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("cToken");
        m.f(of, "of(\"cToken\")");
        this.options = of;
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, CTokenInfoDTO.class);
        b2 = s0.b();
        JsonAdapter<List<CTokenInfoDTO>> adapter = moshi.adapter(newParameterizedType, b2, "tokens");
        m.f(adapter, "moshi.adapter(Types.newParameterizedType(List::class.java, CTokenInfoDTO::class.java),\n      emptySet(), \"tokens\")");
        this.listOfCTokenInfoDTOAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(38);
        sb.append("GeneratedJsonAdapter(");
        sb.append("GetCTokenInfoDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public GetCTokenInfoDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        List<CTokenInfoDTO> list = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0 && (list = this.listOfCTokenInfoDTOAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("tokens", "cToken", reader);
                m.f(unexpectedNull, "unexpectedNull(\"tokens\", \"cToken\", reader)");
                throw unexpectedNull;
            }
        }
        reader.endObject();
        if (list != null) {
            return new GetCTokenInfoDTO(list);
        }
        JsonDataException missingProperty = Util.missingProperty("tokens", "cToken", reader);
        m.f(missingProperty, "missingProperty(\"tokens\", \"cToken\", reader)");
        throw missingProperty;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, GetCTokenInfoDTO getCTokenInfoDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(getCTokenInfoDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("cToken");
        this.listOfCTokenInfoDTOAdapter.toJson(writer, (JsonWriter) getCTokenInfoDTO.getTokens());
        writer.endObject();
    }
}