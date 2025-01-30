package com.coinbase.wallet.features.ethereum.dtos;

import com.coinbase.wallet.features.ethereum.dtos.GetCollectibleItemResponseDTO;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: GetCollectibleItemResponseDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleItemResponseDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleItemResponseDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleItemResponseDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleItemResponseDTO;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "", "Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleItemResponseDTO$CollectibleItemDetail;", "listOfCollectibleItemDetailAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GetCollectibleItemResponseDTOJsonAdapter extends JsonAdapter<GetCollectibleItemResponseDTO> {
    private volatile Constructor<GetCollectibleItemResponseDTO> constructorRef;
    private final JsonAdapter<List<GetCollectibleItemResponseDTO.CollectibleItemDetail>> listOfCollectibleItemDetailAdapter;
    private final JsonReader.Options options;

    public GetCollectibleItemResponseDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("items");
        m.f(of, "of(\"items\")");
        this.options = of;
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, GetCollectibleItemResponseDTO.CollectibleItemDetail.class);
        b2 = s0.b();
        JsonAdapter<List<GetCollectibleItemResponseDTO.CollectibleItemDetail>> adapter = moshi.adapter(newParameterizedType, b2, "items");
        m.f(adapter, "moshi.adapter(Types.newParameterizedType(List::class.java,\n      GetCollectibleItemResponseDTO.CollectibleItemDetail::class.java), emptySet(), \"items\")");
        this.listOfCollectibleItemDetailAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(51);
        sb.append("GeneratedJsonAdapter(");
        sb.append("GetCollectibleItemResponseDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public GetCollectibleItemResponseDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        int i2 = -1;
        List<GetCollectibleItemResponseDTO.CollectibleItemDetail> list = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                list = this.listOfCollectibleItemDetailAdapter.fromJson(reader);
                if (list == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("items", "items", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"items\", \"items\", reader)");
                    throw unexpectedNull;
                }
                i2 &= -2;
            } else {
                continue;
            }
        }
        reader.endObject();
        if (i2 == -2) {
            Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.List<com.coinbase.wallet.features.ethereum.dtos.GetCollectibleItemResponseDTO.CollectibleItemDetail>");
            return new GetCollectibleItemResponseDTO(list);
        }
        Constructor<GetCollectibleItemResponseDTO> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = GetCollectibleItemResponseDTO.class.getDeclaredConstructor(List.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            m.f(constructor, "GetCollectibleItemResponseDTO::class.java.getDeclaredConstructor(List::class.java,\n          Int::class.javaPrimitiveType, Util.DEFAULT_CONSTRUCTOR_MARKER).also {\n          this.constructorRef = it }");
        }
        GetCollectibleItemResponseDTO newInstance = constructor.newInstance(list, Integer.valueOf(i2), null);
        m.f(newInstance, "localConstructor.newInstance(\n          items,\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, GetCollectibleItemResponseDTO getCollectibleItemResponseDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(getCollectibleItemResponseDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("items");
        this.listOfCollectibleItemDetailAdapter.toJson(writer, (JsonWriter) getCollectibleItemResponseDTO.getItems());
        writer.endObject();
    }
}