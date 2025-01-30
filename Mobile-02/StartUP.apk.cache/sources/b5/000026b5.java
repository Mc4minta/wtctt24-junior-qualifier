package com.coinbase.wallet.swap.dtos;

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

/* compiled from: SwapAPIErrorInfoDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/swap/dtos/SwapAPIErrorInfoDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/swap/dtos/SwapAPIErrorInfoDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/swap/dtos/SwapAPIErrorInfoDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/swap/dtos/SwapAPIErrorInfoDTO;)V", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapAPIErrorInfoDTOJsonAdapter extends JsonAdapter<SwapAPIErrorInfoDTO> {
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public SwapAPIErrorInfoDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(ApiConstants.MESSAGE, ApiConstants.DESCRIPTION, "code");
        m.f(of, "of(\"message\", \"description\", \"code\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, ApiConstants.MESSAGE);
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"message\")");
        this.stringAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(41);
        sb.append("GeneratedJsonAdapter(");
        sb.append("SwapAPIErrorInfoDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public SwapAPIErrorInfoDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull(ApiConstants.MESSAGE, ApiConstants.MESSAGE, reader);
                    m.f(unexpectedNull, "unexpectedNull(\"message\",\n            \"message\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(ApiConstants.DESCRIPTION, ApiConstants.DESCRIPTION, reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"description\", \"description\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (str3 = this.stringAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("code", "code", reader);
                m.f(unexpectedNull3, "unexpectedNull(\"code\", \"code\",\n            reader)");
                throw unexpectedNull3;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty(ApiConstants.MESSAGE, ApiConstants.MESSAGE, reader);
            m.f(missingProperty, "missingProperty(\"message\", \"message\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty(ApiConstants.DESCRIPTION, ApiConstants.DESCRIPTION, reader);
            m.f(missingProperty2, "missingProperty(\"description\", \"description\",\n            reader)");
            throw missingProperty2;
        } else if (str3 != null) {
            return new SwapAPIErrorInfoDTO(str, str2, str3);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("code", "code", reader);
            m.f(missingProperty3, "missingProperty(\"code\", \"code\", reader)");
            throw missingProperty3;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, SwapAPIErrorInfoDTO swapAPIErrorInfoDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(swapAPIErrorInfoDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name(ApiConstants.MESSAGE);
        this.stringAdapter.toJson(writer, (JsonWriter) swapAPIErrorInfoDTO.getMessage());
        writer.name(ApiConstants.DESCRIPTION);
        this.stringAdapter.toJson(writer, (JsonWriter) swapAPIErrorInfoDTO.getDescription());
        writer.name("code");
        this.stringAdapter.toJson(writer, (JsonWriter) swapAPIErrorInfoDTO.getCode());
        writer.endObject();
    }
}