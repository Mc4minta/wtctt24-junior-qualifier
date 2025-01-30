package com.coinbase.wallet.features.ethereum.dtos;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.ethereum.dtos.GetCollectibleTypesResponseDTO;
import com.coinbase.wallet.routing.models.RouteActionKey;
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

/* compiled from: GetCollectibleTypesResponseDTO_CollectibleTypeDetailJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleTypesResponseDTO_CollectibleTypeDetailJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleTypesResponseDTO$CollectibleTypeDetail;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleTypesResponseDTO$CollectibleTypeDetail;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleTypesResponseDTO$CollectibleTypeDetail;)V", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "nullableStringAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "", "nullableIntAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GetCollectibleTypesResponseDTO_CollectibleTypeDetailJsonAdapter extends JsonAdapter<GetCollectibleTypesResponseDTO.CollectibleTypeDetail> {
    private final JsonAdapter<Integer> nullableIntAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public GetCollectibleTypesResponseDTO_CollectibleTypeDetailJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(ApiConstants.NAME, RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "count", "imageUrl");
        m.f(of, "of(\"name\", \"contractAddress\",\n      \"count\", \"imageUrl\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, ApiConstants.NAME);
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"name\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<Integer> adapter2 = moshi.adapter(Integer.class, b3, "count");
        m.f(adapter2, "moshi.adapter(Int::class.javaObjectType,\n      emptySet(), \"count\")");
        this.nullableIntAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, b4, "imageUrl");
        m.f(adapter3, "moshi.adapter(String::class.java,\n      emptySet(), \"imageUrl\")");
        this.nullableStringAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(74);
        sb.append("GeneratedJsonAdapter(");
        sb.append("GetCollectibleTypesResponseDTO.CollectibleTypeDetail");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public GetCollectibleTypesResponseDTO.CollectibleTypeDetail fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        String str2 = null;
        Integer num = null;
        String str3 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull(ApiConstants.NAME, ApiConstants.NAME, reader);
                    m.f(unexpectedNull, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"contractAddress\", \"contractAddress\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                num = this.nullableIntAdapter.fromJson(reader);
            } else if (selectName == 3) {
                str3 = this.nullableStringAdapter.fromJson(reader);
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty(ApiConstants.NAME, ApiConstants.NAME, reader);
            m.f(missingProperty, "missingProperty(\"name\", \"name\", reader)");
            throw missingProperty;
        } else if (str2 != null) {
            return new GetCollectibleTypesResponseDTO.CollectibleTypeDetail(str, str2, num, str3);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, reader);
            m.f(missingProperty2, "missingProperty(\"contractAddress\",\n            \"contractAddress\", reader)");
            throw missingProperty2;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, GetCollectibleTypesResponseDTO.CollectibleTypeDetail collectibleTypeDetail) {
        m.g(writer, "writer");
        Objects.requireNonNull(collectibleTypeDetail, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name(ApiConstants.NAME);
        this.stringAdapter.toJson(writer, (JsonWriter) collectibleTypeDetail.getName());
        writer.name(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS);
        this.stringAdapter.toJson(writer, (JsonWriter) collectibleTypeDetail.getContractAddress());
        writer.name("count");
        this.nullableIntAdapter.toJson(writer, (JsonWriter) collectibleTypeDetail.getCount());
        writer.name("imageUrl");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) collectibleTypeDetail.getImageUrl());
        writer.endObject();
    }
}