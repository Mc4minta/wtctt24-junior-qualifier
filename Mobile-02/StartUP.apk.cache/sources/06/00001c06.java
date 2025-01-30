package com.coinbase.wallet.ethereum.dtos;

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
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: GetERC20IconsDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR.\u0010\u0013\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/ethereum/dtos/GetERC20IconsDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/ethereum/dtos/GetERC20IconsDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/ethereum/dtos/GetERC20IconsDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/ethereum/dtos/GetERC20IconsDTO;)V", "", "", "Lcom/coinbase/wallet/ethereum/dtos/ERC20IconDTO;", "mapOfStringListOfERC20IconDTOAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GetERC20IconsDTOJsonAdapter extends JsonAdapter<GetERC20IconsDTO> {
    private final JsonAdapter<Map<String, List<ERC20IconDTO>>> mapOfStringListOfERC20IconDTOAdapter;
    private final JsonReader.Options options;

    public GetERC20IconsDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("icons");
        m.f(of, "of(\"icons\")");
        this.options = of;
        ParameterizedType newParameterizedType = Types.newParameterizedType(Map.class, String.class, Types.newParameterizedType(List.class, ERC20IconDTO.class));
        b2 = s0.b();
        JsonAdapter<Map<String, List<ERC20IconDTO>>> adapter = moshi.adapter(newParameterizedType, b2, "icons");
        m.f(adapter, "moshi.adapter(Types.newParameterizedType(Map::class.java, String::class.java,\n      Types.newParameterizedType(List::class.java, ERC20IconDTO::class.java)), emptySet(), \"icons\")");
        this.mapOfStringListOfERC20IconDTOAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(38);
        sb.append("GeneratedJsonAdapter(");
        sb.append("GetERC20IconsDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public GetERC20IconsDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        Map<String, List<ERC20IconDTO>> map = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0 && (map = this.mapOfStringListOfERC20IconDTOAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("icons", "icons", reader);
                m.f(unexpectedNull, "unexpectedNull(\"icons\", \"icons\", reader)");
                throw unexpectedNull;
            }
        }
        reader.endObject();
        if (map != null) {
            return new GetERC20IconsDTO(map);
        }
        JsonDataException missingProperty = Util.missingProperty("icons", "icons", reader);
        m.f(missingProperty, "missingProperty(\"icons\", \"icons\", reader)");
        throw missingProperty;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, GetERC20IconsDTO getERC20IconsDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(getERC20IconsDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("icons");
        this.mapOfStringListOfERC20IconDTOAdapter.toJson(writer, (JsonWriter) getERC20IconsDTO.getIcons());
        writer.endObject();
    }
}