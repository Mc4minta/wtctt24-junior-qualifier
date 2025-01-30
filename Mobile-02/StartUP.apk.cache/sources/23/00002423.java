package com.coinbase.wallet.lending.dtos;

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

/* compiled from: LendInterestDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/lending/dtos/LendInterestDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/lending/dtos/LendInterestDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/lending/dtos/LendInterestDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/lending/dtos/LendInterestDTO;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "", "intAdapter", "Lcom/squareup/moshi/JsonAdapter;", "stringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendInterestDTOJsonAdapter extends JsonAdapter<LendInterestDTO> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public LendInterestDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("code", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "interestEarned", "decimals");
        m.f(of, "of(\"code\", \"contractAddress\",\n      \"interestEarned\", \"decimals\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "code");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"code\")");
        this.stringAdapter = adapter;
        Class cls = Integer.TYPE;
        b3 = s0.b();
        JsonAdapter<Integer> adapter2 = moshi.adapter(cls, b3, "decimals");
        m.f(adapter2, "moshi.adapter(Int::class.java, emptySet(), \"decimals\")");
        this.intAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(37);
        sb.append("GeneratedJsonAdapter(");
        sb.append("LendInterestDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public LendInterestDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        Integer num = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("code", "code", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"code\", \"code\",\n            reader)");
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
                str3 = this.stringAdapter.fromJson(reader);
                if (str3 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("interestEarned", "interestEarned", reader);
                    m.f(unexpectedNull3, "unexpectedNull(\"interestEarned\", \"interestEarned\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3 && (num = this.intAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull4 = Util.unexpectedNull("decimals", "decimals", reader);
                m.f(unexpectedNull4, "unexpectedNull(\"decimals\",\n            \"decimals\", reader)");
                throw unexpectedNull4;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("code", "code", reader);
            m.f(missingProperty, "missingProperty(\"code\", \"code\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, reader);
            m.f(missingProperty2, "missingProperty(\"contractAddress\",\n            \"contractAddress\", reader)");
            throw missingProperty2;
        } else if (str3 == null) {
            JsonDataException missingProperty3 = Util.missingProperty("interestEarned", "interestEarned", reader);
            m.f(missingProperty3, "missingProperty(\"interestEarned\",\n            \"interestEarned\", reader)");
            throw missingProperty3;
        } else if (num != null) {
            return new LendInterestDTO(str, str2, str3, num.intValue());
        } else {
            JsonDataException missingProperty4 = Util.missingProperty("decimals", "decimals", reader);
            m.f(missingProperty4, "missingProperty(\"decimals\", \"decimals\", reader)");
            throw missingProperty4;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, LendInterestDTO lendInterestDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(lendInterestDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("code");
        this.stringAdapter.toJson(writer, (JsonWriter) lendInterestDTO.getCode());
        writer.name(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS);
        this.stringAdapter.toJson(writer, (JsonWriter) lendInterestDTO.getContractAddress());
        writer.name("interestEarned");
        this.stringAdapter.toJson(writer, (JsonWriter) lendInterestDTO.getInterestEarned());
        writer.name("decimals");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(lendInterestDTO.getDecimals()));
        writer.endObject();
    }
}