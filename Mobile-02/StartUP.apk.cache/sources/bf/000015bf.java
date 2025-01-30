package com.coinbase.wallet.consumer.dtos;

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

/* compiled from: BuyStatusDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/BuyStatusDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/consumer/dtos/BuyStatusDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/consumer/dtos/BuyStatusDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/consumer/dtos/BuyStatusDTO;)V", "", "booleanAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/consumer/dtos/Secure3DVerificationDTO;", "nullableSecure3DVerificationDTOAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BuyStatusDTOJsonAdapter extends JsonAdapter<BuyStatusDTO> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<Secure3DVerificationDTO> nullableSecure3DVerificationDTOAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public BuyStatusDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("status", "requires_completion_step", "secure3d_verification");
        m.f(of, "of(\"status\",\n      \"requires_completion_step\", \"secure3d_verification\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "status");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"status\")");
        this.stringAdapter = adapter;
        Class cls = Boolean.TYPE;
        b3 = s0.b();
        JsonAdapter<Boolean> adapter2 = moshi.adapter(cls, b3, "requiresCompletionStep");
        m.f(adapter2, "moshi.adapter(Boolean::class.java, emptySet(),\n      \"requiresCompletionStep\")");
        this.booleanAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<Secure3DVerificationDTO> adapter3 = moshi.adapter(Secure3DVerificationDTO.class, b4, "secure3DVerification");
        m.f(adapter3, "moshi.adapter(Secure3DVerificationDTO::class.java, emptySet(), \"secure3DVerification\")");
        this.nullableSecure3DVerificationDTOAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(34);
        sb.append("GeneratedJsonAdapter(");
        sb.append("BuyStatusDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public BuyStatusDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        Boolean bool = null;
        Secure3DVerificationDTO secure3DVerificationDTO = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("status", "status", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"status\",\n            \"status\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                bool = this.booleanAdapter.fromJson(reader);
                if (bool == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("requiresCompletionStep", "requires_completion_step", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"requiresCompletionStep\", \"requires_completion_step\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                secure3DVerificationDTO = this.nullableSecure3DVerificationDTOAdapter.fromJson(reader);
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("status", "status", reader);
            m.f(missingProperty, "missingProperty(\"status\", \"status\", reader)");
            throw missingProperty;
        } else if (bool != null) {
            return new BuyStatusDTO(str, bool.booleanValue(), secure3DVerificationDTO);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("requiresCompletionStep", "requires_completion_step", reader);
            m.f(missingProperty2, "missingProperty(\"requiresCompletionStep\", \"requires_completion_step\",\n            reader)");
            throw missingProperty2;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, BuyStatusDTO buyStatusDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(buyStatusDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("status");
        this.stringAdapter.toJson(writer, (JsonWriter) buyStatusDTO.getStatus());
        writer.name("requires_completion_step");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(buyStatusDTO.getRequiresCompletionStep()));
        writer.name("secure3d_verification");
        this.nullableSecure3DVerificationDTOAdapter.toJson(writer, (JsonWriter) buyStatusDTO.getSecure3DVerification());
        writer.endObject();
    }
}