package com.coinbase.wallet.consumer.dtos;

import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
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

/* compiled from: ConsumerWalletAddressDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerWalletAddressDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerWalletAddressDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/consumer/dtos/ConsumerWalletAddressDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/consumer/dtos/ConsumerWalletAddressDTO;)V", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "nullableStringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerWalletAddressDTOJsonAdapter extends JsonAdapter<ConsumerWalletAddressDTO> {
    private volatile Constructor<ConsumerWalletAddressDTO> constructorRef;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ConsumerWalletAddressDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("asset_uuid", "address", "signature", AdjustableMinerFeeArgs.NONCE);
        m.f(of, "of(\"asset_uuid\", \"address\",\n      \"signature\", \"nonce\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "assetUuid");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"assetUuid\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, b3, "address");
        m.f(adapter2, "moshi.adapter(String::class.java,\n      emptySet(), \"address\")");
        this.nullableStringAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(46);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ConsumerWalletAddressDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ConsumerWalletAddressDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        int i2 = -1;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("assetUuid", "asset_uuid", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"assetUuid\",\n            \"asset_uuid\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.nullableStringAdapter.fromJson(reader);
                i2 &= -3;
            } else if (selectName == 2) {
                str3 = this.nullableStringAdapter.fromJson(reader);
                i2 &= -5;
            } else if (selectName == 3) {
                str4 = this.nullableStringAdapter.fromJson(reader);
                i2 &= -9;
            }
        }
        reader.endObject();
        if (i2 == -15) {
            if (str != null) {
                return new ConsumerWalletAddressDTO(str, str2, str3, str4);
            }
            JsonDataException missingProperty = Util.missingProperty("assetUuid", "asset_uuid", reader);
            m.f(missingProperty, "missingProperty(\"assetUuid\", \"asset_uuid\", reader)");
            throw missingProperty;
        }
        Constructor<ConsumerWalletAddressDTO> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = ConsumerWalletAddressDTO.class.getDeclaredConstructor(String.class, String.class, String.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            m.f(constructor, "ConsumerWalletAddressDTO::class.java.getDeclaredConstructor(String::class.java,\n          String::class.java, String::class.java, String::class.java, Int::class.javaPrimitiveType,\n          Util.DEFAULT_CONSTRUCTOR_MARKER).also { this.constructorRef = it }");
        }
        Object[] objArr = new Object[6];
        if (str == null) {
            JsonDataException missingProperty2 = Util.missingProperty("assetUuid", "asset_uuid", reader);
            m.f(missingProperty2, "missingProperty(\"assetUuid\", \"asset_uuid\", reader)");
            throw missingProperty2;
        }
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = str3;
        objArr[3] = str4;
        objArr[4] = Integer.valueOf(i2);
        objArr[5] = null;
        ConsumerWalletAddressDTO newInstance = constructor.newInstance(objArr);
        m.f(newInstance, "localConstructor.newInstance(\n          assetUuid ?: throw Util.missingProperty(\"assetUuid\", \"asset_uuid\", reader),\n          address,\n          signature,\n          nonce,\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ConsumerWalletAddressDTO consumerWalletAddressDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(consumerWalletAddressDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("asset_uuid");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerWalletAddressDTO.getAssetUuid());
        writer.name("address");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) consumerWalletAddressDTO.getAddress());
        writer.name("signature");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) consumerWalletAddressDTO.getSignature());
        writer.name(AdjustableMinerFeeArgs.NONCE);
        this.nullableStringAdapter.toJson(writer, (JsonWriter) consumerWalletAddressDTO.getNonce());
        writer.endObject();
    }
}