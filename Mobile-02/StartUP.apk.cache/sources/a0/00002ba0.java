package com.coinbase.walletlink.dtos;

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

/* compiled from: GetEventsDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00160\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/coinbase/walletlink/dtos/GetEventsDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletlink/dtos/GetEventsDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletlink/dtos/GetEventsDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletlink/dtos/GetEventsDTO;)V", "", "longAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "", "Lcom/coinbase/walletlink/dtos/EventDTO;", "nullableListOfEventDTOAdapter", "nullableStringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GetEventsDTOJsonAdapter extends JsonAdapter<GetEventsDTO> {
    private final JsonAdapter<Long> longAdapter;
    private final JsonAdapter<List<EventDTO>> nullableListOfEventDTOAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;

    public GetEventsDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("events", "timestamp", "error");
        m.f(of, "of(\"events\", \"timestamp\", \"error\")");
        this.options = of;
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, EventDTO.class);
        b2 = s0.b();
        JsonAdapter<List<EventDTO>> adapter = moshi.adapter(newParameterizedType, b2, "events");
        m.f(adapter, "moshi.adapter(Types.newParameterizedType(List::class.java, EventDTO::class.java), emptySet(),\n      \"events\")");
        this.nullableListOfEventDTOAdapter = adapter;
        Class cls = Long.TYPE;
        b3 = s0.b();
        JsonAdapter<Long> adapter2 = moshi.adapter(cls, b3, "timestamp");
        m.f(adapter2, "moshi.adapter(Long::class.java, emptySet(),\n      \"timestamp\")");
        this.longAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, b4, "error");
        m.f(adapter3, "moshi.adapter(String::class.java,\n      emptySet(), \"error\")");
        this.nullableStringAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(34);
        sb.append("GeneratedJsonAdapter(");
        sb.append("GetEventsDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public GetEventsDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        List<EventDTO> list = null;
        Long l2 = null;
        String str = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                list = this.nullableListOfEventDTOAdapter.fromJson(reader);
            } else if (selectName == 1) {
                l2 = this.longAdapter.fromJson(reader);
                if (l2 == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("timestamp", "timestamp", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"timestamp\",\n            \"timestamp\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 2) {
                str = this.nullableStringAdapter.fromJson(reader);
            }
        }
        reader.endObject();
        if (l2 != null) {
            return new GetEventsDTO(list, l2.longValue(), str);
        }
        JsonDataException missingProperty = Util.missingProperty("timestamp", "timestamp", reader);
        m.f(missingProperty, "missingProperty(\"timestamp\", \"timestamp\", reader)");
        throw missingProperty;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, GetEventsDTO getEventsDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(getEventsDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("events");
        this.nullableListOfEventDTOAdapter.toJson(writer, (JsonWriter) getEventsDTO.getEvents());
        writer.name("timestamp");
        this.longAdapter.toJson(writer, (JsonWriter) Long.valueOf(getEventsDTO.getTimestamp()));
        writer.name("error");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) getEventsDTO.getError());
        writer.endObject();
    }
}