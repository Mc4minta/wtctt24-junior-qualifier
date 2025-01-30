package com.coinbase.wallet.user.dtos;

import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.user.models.Signature;
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

/* compiled from: CreateUserRequestDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\"\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/user/dtos/CreateUserRequestDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/user/dtos/CreateUserRequestDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/user/dtos/CreateUserRequestDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/user/dtos/CreateUserRequestDTO;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "booleanAdapter", "", "Lcom/coinbase/wallet/user/models/Signature;", "listOfSignatureAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CreateUserRequestDTOJsonAdapter extends JsonAdapter<CreateUserRequestDTO> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<List<Signature>> listOfSignatureAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public CreateUserRequestDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("username", "isPublic", AdjustableMinerFeeArgs.NONCE, "ethereumAddresses");
        m.f(of, "of(\"username\", \"isPublic\", \"nonce\",\n      \"ethereumAddresses\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "username");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"username\")");
        this.stringAdapter = adapter;
        Class cls = Boolean.TYPE;
        b3 = s0.b();
        JsonAdapter<Boolean> adapter2 = moshi.adapter(cls, b3, "isPublic");
        m.f(adapter2, "moshi.adapter(Boolean::class.java, emptySet(),\n      \"isPublic\")");
        this.booleanAdapter = adapter2;
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, Signature.class);
        b4 = s0.b();
        JsonAdapter<List<Signature>> adapter3 = moshi.adapter(newParameterizedType, b4, "ethereumAddresses");
        m.f(adapter3, "moshi.adapter(Types.newParameterizedType(List::class.java, Signature::class.java), emptySet(),\n      \"ethereumAddresses\")");
        this.listOfSignatureAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(42);
        sb.append("GeneratedJsonAdapter(");
        sb.append("CreateUserRequestDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public CreateUserRequestDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        Boolean bool = null;
        String str2 = null;
        List<Signature> list = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("username", "username", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"username\",\n            \"username\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                bool = this.booleanAdapter.fromJson(reader);
                if (bool == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("isPublic", "isPublic", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"isPublic\",\n            \"isPublic\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull(AdjustableMinerFeeArgs.NONCE, AdjustableMinerFeeArgs.NONCE, reader);
                    m.f(unexpectedNull3, "unexpectedNull(\"nonce\", \"nonce\",\n            reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3 && (list = this.listOfSignatureAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull4 = Util.unexpectedNull("ethereumAddresses", "ethereumAddresses", reader);
                m.f(unexpectedNull4, "unexpectedNull(\"ethereumAddresses\", \"ethereumAddresses\", reader)");
                throw unexpectedNull4;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("username", "username", reader);
            m.f(missingProperty, "missingProperty(\"username\", \"username\", reader)");
            throw missingProperty;
        } else if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (str2 == null) {
                JsonDataException missingProperty2 = Util.missingProperty(AdjustableMinerFeeArgs.NONCE, AdjustableMinerFeeArgs.NONCE, reader);
                m.f(missingProperty2, "missingProperty(\"nonce\", \"nonce\", reader)");
                throw missingProperty2;
            } else if (list != null) {
                return new CreateUserRequestDTO(str, booleanValue, str2, list);
            } else {
                JsonDataException missingProperty3 = Util.missingProperty("ethereumAddresses", "ethereumAddresses", reader);
                m.f(missingProperty3, "missingProperty(\"ethereumAddresses\",\n            \"ethereumAddresses\", reader)");
                throw missingProperty3;
            }
        } else {
            JsonDataException missingProperty4 = Util.missingProperty("isPublic", "isPublic", reader);
            m.f(missingProperty4, "missingProperty(\"isPublic\", \"isPublic\", reader)");
            throw missingProperty4;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, CreateUserRequestDTO createUserRequestDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(createUserRequestDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("username");
        this.stringAdapter.toJson(writer, (JsonWriter) createUserRequestDTO.getUsername());
        writer.name("isPublic");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(createUserRequestDTO.isPublic()));
        writer.name(AdjustableMinerFeeArgs.NONCE);
        this.stringAdapter.toJson(writer, (JsonWriter) createUserRequestDTO.getNonce());
        writer.name("ethereumAddresses");
        this.listOfSignatureAdapter.toJson(writer, (JsonWriter) createUserRequestDTO.getEthereumAddresses());
        writer.endObject();
    }
}