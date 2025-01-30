package com.coinbase.wallet.wallets.dtos;

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

/* compiled from: WatchAddressParamsDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00150\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/wallets/dtos/WatchAddressParamsDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/wallets/dtos/WatchAddressParamsDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/wallets/dtos/WatchAddressParamsDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/wallets/dtos/WatchAddressParamsDTO;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "listOfStringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WatchAddressParamsDTOJsonAdapter extends JsonAdapter<WatchAddressParamsDTO> {
    private final JsonAdapter<List<String>> listOfStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public WatchAddressParamsDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(ApiConstants.ADDRESSES, "chain");
        m.f(of, "of(\"addresses\", \"chain\")");
        this.options = of;
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, String.class);
        b2 = s0.b();
        JsonAdapter<List<String>> adapter = moshi.adapter(newParameterizedType, b2, ApiConstants.ADDRESSES);
        m.f(adapter, "moshi.adapter(Types.newParameterizedType(List::class.java, String::class.java), emptySet(),\n      \"addresses\")");
        this.listOfStringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, b3, "chain");
        m.f(adapter2, "moshi.adapter(String::class.java, emptySet(),\n      \"chain\")");
        this.stringAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(43);
        sb.append("GeneratedJsonAdapter(");
        sb.append("WatchAddressParamsDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public WatchAddressParamsDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        List<String> list = null;
        String str = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                list = this.listOfStringAdapter.fromJson(reader);
                if (list == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull(ApiConstants.ADDRESSES, ApiConstants.ADDRESSES, reader);
                    m.f(unexpectedNull, "unexpectedNull(\"addresses\", \"addresses\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (str = this.stringAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("chain", "chain", reader);
                m.f(unexpectedNull2, "unexpectedNull(\"chain\", \"chain\",\n            reader)");
                throw unexpectedNull2;
            }
        }
        reader.endObject();
        if (list == null) {
            JsonDataException missingProperty = Util.missingProperty(ApiConstants.ADDRESSES, ApiConstants.ADDRESSES, reader);
            m.f(missingProperty, "missingProperty(\"addresses\", \"addresses\", reader)");
            throw missingProperty;
        } else if (str != null) {
            return new WatchAddressParamsDTO(list, str);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("chain", "chain", reader);
            m.f(missingProperty2, "missingProperty(\"chain\", \"chain\", reader)");
            throw missingProperty2;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, WatchAddressParamsDTO watchAddressParamsDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(watchAddressParamsDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name(ApiConstants.ADDRESSES);
        this.listOfStringAdapter.toJson(writer, (JsonWriter) watchAddressParamsDTO.getAddresses());
        writer.name("chain");
        this.stringAdapter.toJson(writer, (JsonWriter) watchAddressParamsDTO.getChain());
        writer.endObject();
    }
}