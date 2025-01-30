package com.coinbase.wallet.features.pushnotifications.dtos;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: SubscribeToNotificationsRequestDtoJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/features/pushnotifications/dtos/SubscribeToNotificationsRequestDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/features/pushnotifications/dtos/SubscribeToNotificationsRequestDto;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/features/pushnotifications/dtos/SubscribeToNotificationsRequestDto;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/features/pushnotifications/dtos/SubscribeToNotificationsRequestDto;)V", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SubscribeToNotificationsRequestDtoJsonAdapter extends JsonAdapter<SubscribeToNotificationsRequestDto> {
    private volatile Constructor<SubscribeToNotificationsRequestDto> constructorRef;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public SubscribeToNotificationsRequestDtoJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("fcmToken", "deviceId", "deviceType");
        m.f(of, "of(\"fcmToken\", \"deviceId\",\n      \"deviceType\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "fcmToken");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"fcmToken\")");
        this.stringAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(56);
        sb.append("GeneratedJsonAdapter(");
        sb.append("SubscribeToNotificationsRequestDto");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public SubscribeToNotificationsRequestDto fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        int i2 = -1;
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
                    JsonDataException unexpectedNull = Util.unexpectedNull("fcmToken", "fcmToken", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"fcmToken\",\n            \"fcmToken\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("deviceId", "deviceId", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"deviceId\",\n            \"deviceId\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str3 = this.stringAdapter.fromJson(reader);
                if (str3 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("deviceType", "deviceType", reader);
                    m.f(unexpectedNull3, "unexpectedNull(\"deviceType\",\n              \"deviceType\", reader)");
                    throw unexpectedNull3;
                }
                i2 &= -5;
            } else {
                continue;
            }
        }
        reader.endObject();
        if (i2 == -5) {
            if (str == null) {
                JsonDataException missingProperty = Util.missingProperty("fcmToken", "fcmToken", reader);
                m.f(missingProperty, "missingProperty(\"fcmToken\", \"fcmToken\", reader)");
                throw missingProperty;
            } else if (str2 != null) {
                Objects.requireNonNull(str3, "null cannot be cast to non-null type kotlin.String");
                return new SubscribeToNotificationsRequestDto(str, str2, str3);
            } else {
                JsonDataException missingProperty2 = Util.missingProperty("deviceId", "deviceId", reader);
                m.f(missingProperty2, "missingProperty(\"deviceId\", \"deviceId\", reader)");
                throw missingProperty2;
            }
        }
        Constructor<SubscribeToNotificationsRequestDto> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = SubscribeToNotificationsRequestDto.class.getDeclaredConstructor(String.class, String.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            m.f(constructor, "SubscribeToNotificationsRequestDto::class.java.getDeclaredConstructor(String::class.java,\n          String::class.java, String::class.java, Int::class.javaPrimitiveType,\n          Util.DEFAULT_CONSTRUCTOR_MARKER).also { this.constructorRef = it }");
        }
        Object[] objArr = new Object[5];
        if (str == null) {
            JsonDataException missingProperty3 = Util.missingProperty("fcmToken", "fcmToken", reader);
            m.f(missingProperty3, "missingProperty(\"fcmToken\", \"fcmToken\", reader)");
            throw missingProperty3;
        }
        objArr[0] = str;
        if (str2 == null) {
            JsonDataException missingProperty4 = Util.missingProperty("deviceId", "deviceId", reader);
            m.f(missingProperty4, "missingProperty(\"deviceId\", \"deviceId\", reader)");
            throw missingProperty4;
        }
        objArr[1] = str2;
        objArr[2] = str3;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = null;
        SubscribeToNotificationsRequestDto newInstance = constructor.newInstance(objArr);
        m.f(newInstance, "localConstructor.newInstance(\n          fcmToken ?: throw Util.missingProperty(\"fcmToken\", \"fcmToken\", reader),\n          deviceId ?: throw Util.missingProperty(\"deviceId\", \"deviceId\", reader),\n          deviceType,\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, SubscribeToNotificationsRequestDto subscribeToNotificationsRequestDto) {
        m.g(writer, "writer");
        Objects.requireNonNull(subscribeToNotificationsRequestDto, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("fcmToken");
        this.stringAdapter.toJson(writer, (JsonWriter) subscribeToNotificationsRequestDto.getFcmToken());
        writer.name("deviceId");
        this.stringAdapter.toJson(writer, (JsonWriter) subscribeToNotificationsRequestDto.getDeviceId());
        writer.name("deviceType");
        this.stringAdapter.toJson(writer, (JsonWriter) subscribeToNotificationsRequestDto.getDeviceType());
        writer.endObject();
    }
}