package com.coinbase.wallet.ethereum.dtos;

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

/* compiled from: ERC20IconDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/ethereum/dtos/ERC20IconDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/ethereum/dtos/ERC20IconDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/ethereum/dtos/ERC20IconDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/ethereum/dtos/ERC20IconDTO;)V", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "", "intAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ERC20IconDTOJsonAdapter extends JsonAdapter<ERC20IconDTO> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ERC20IconDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("width", "height", "url");
        m.f(of, "of(\"width\", \"height\", \"url\")");
        this.options = of;
        Class cls = Integer.TYPE;
        b2 = s0.b();
        JsonAdapter<Integer> adapter = moshi.adapter(cls, b2, "width");
        m.f(adapter, "moshi.adapter(Int::class.java, emptySet(), \"width\")");
        this.intAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, b3, "url");
        m.f(adapter2, "moshi.adapter(String::class.java, emptySet(),\n      \"url\")");
        this.stringAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(34);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ERC20IconDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ERC20IconDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        Integer num = null;
        Integer num2 = null;
        String str = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                num = this.intAdapter.fromJson(reader);
                if (num == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("width", "width", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"width\", \"width\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                num2 = this.intAdapter.fromJson(reader);
                if (num2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("height", "height", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"height\", \"height\",\n            reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (str = this.stringAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("url", "url", reader);
                m.f(unexpectedNull3, "unexpectedNull(\"url\", \"url\", reader)");
                throw unexpectedNull3;
            }
        }
        reader.endObject();
        if (num != null) {
            int intValue = num.intValue();
            if (num2 != null) {
                int intValue2 = num2.intValue();
                if (str != null) {
                    return new ERC20IconDTO(intValue, intValue2, str);
                }
                JsonDataException missingProperty = Util.missingProperty("url", "url", reader);
                m.f(missingProperty, "missingProperty(\"url\", \"url\", reader)");
                throw missingProperty;
            }
            JsonDataException missingProperty2 = Util.missingProperty("height", "height", reader);
            m.f(missingProperty2, "missingProperty(\"height\", \"height\", reader)");
            throw missingProperty2;
        }
        JsonDataException missingProperty3 = Util.missingProperty("width", "width", reader);
        m.f(missingProperty3, "missingProperty(\"width\", \"width\", reader)");
        throw missingProperty3;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ERC20IconDTO eRC20IconDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(eRC20IconDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("width");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(eRC20IconDTO.getWidth()));
        writer.name("height");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(eRC20IconDTO.getHeight()));
        writer.name("url");
        this.stringAdapter.toJson(writer, (JsonWriter) eRC20IconDTO.getUrl());
        writer.endObject();
    }
}