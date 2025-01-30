package com.coinbase.walletengine.services.litecoin;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.a0.s0;

/* compiled from: UTXOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00018\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/coinbase/walletengine/services/litecoin/UTXOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletengine/services/litecoin/UTXO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletengine/services/litecoin/UTXO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletengine/services/litecoin/UTXO;)V", "Ljava/math/BigInteger;", "bigIntegerAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "", "byteArrayAdapter", "Lkotlin/UInt;", "uIntAdapter", "stringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class UTXOJsonAdapter extends JsonAdapter<UTXO> {
    private final JsonAdapter<BigInteger> bigIntegerAdapter;
    private final JsonAdapter<byte[]> byteArrayAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<UInt> uIntAdapter;

    public UTXOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        kotlin.jvm.internal.m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("address", "hash", "index", "value", "script");
        kotlin.jvm.internal.m.f(of, "of(\"address\", \"hash\", \"index\",\n      \"value\", \"script\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "address");
        kotlin.jvm.internal.m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"address\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<UInt> adapter2 = moshi.adapter(UInt.class, b3, "index");
        kotlin.jvm.internal.m.f(adapter2, "moshi.adapter(UInt::class.java, emptySet(), \"index\")");
        this.uIntAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<BigInteger> adapter3 = moshi.adapter(BigInteger.class, b4, "value");
        kotlin.jvm.internal.m.f(adapter3, "moshi.adapter(BigInteger::class.java,\n      emptySet(), \"value\")");
        this.bigIntegerAdapter = adapter3;
        b5 = s0.b();
        JsonAdapter<byte[]> adapter4 = moshi.adapter(byte[].class, b5, "script");
        kotlin.jvm.internal.m.f(adapter4, "moshi.adapter(ByteArray::class.java,\n      emptySet(), \"script\")");
        this.byteArrayAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(26);
        sb.append("GeneratedJsonAdapter(");
        sb.append("UTXO");
        sb.append(')');
        String sb2 = sb.toString();
        kotlin.jvm.internal.m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public UTXO fromJson(JsonReader reader) {
        kotlin.jvm.internal.m.g(reader, "reader");
        reader.beginObject();
        UInt uInt = null;
        String str = null;
        String str2 = null;
        BigInteger bigInteger = null;
        byte[] bArr = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("address", "address", reader);
                    kotlin.jvm.internal.m.f(unexpectedNull, "unexpectedNull(\"address\",\n            \"address\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("hash", "hash", reader);
                    kotlin.jvm.internal.m.f(unexpectedNull2, "unexpectedNull(\"hash\", \"hash\",\n            reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                uInt = this.uIntAdapter.fromJson(reader);
                if (uInt == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("index", "index", reader);
                    kotlin.jvm.internal.m.f(unexpectedNull3, "unexpectedNull(\"index\", \"index\",\n            reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                bigInteger = this.bigIntegerAdapter.fromJson(reader);
                if (bigInteger == null) {
                    JsonDataException unexpectedNull4 = Util.unexpectedNull("value__", "value", reader);
                    kotlin.jvm.internal.m.f(unexpectedNull4, "unexpectedNull(\"value__\",\n            \"value\", reader)");
                    throw unexpectedNull4;
                }
            } else if (selectName == 4 && (bArr = this.byteArrayAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull5 = Util.unexpectedNull("script", "script", reader);
                kotlin.jvm.internal.m.f(unexpectedNull5, "unexpectedNull(\"script\",\n            \"script\", reader)");
                throw unexpectedNull5;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("address", "address", reader);
            kotlin.jvm.internal.m.f(missingProperty, "missingProperty(\"address\", \"address\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("hash", "hash", reader);
            kotlin.jvm.internal.m.f(missingProperty2, "missingProperty(\"hash\", \"hash\", reader)");
            throw missingProperty2;
        } else if (uInt != null) {
            int B = uInt.B();
            if (bigInteger == null) {
                JsonDataException missingProperty3 = Util.missingProperty("value__", "value", reader);
                kotlin.jvm.internal.m.f(missingProperty3, "missingProperty(\"value__\", \"value\", reader)");
                throw missingProperty3;
            } else if (bArr != null) {
                return new UTXO(str, str2, B, bigInteger, bArr, null);
            } else {
                JsonDataException missingProperty4 = Util.missingProperty("script", "script", reader);
                kotlin.jvm.internal.m.f(missingProperty4, "missingProperty(\"script\", \"script\", reader)");
                throw missingProperty4;
            }
        } else {
            JsonDataException missingProperty5 = Util.missingProperty("index", "index", reader);
            kotlin.jvm.internal.m.f(missingProperty5, "missingProperty(\"index\", \"index\", reader)");
            throw missingProperty5;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, UTXO utxo) {
        kotlin.jvm.internal.m.g(writer, "writer");
        Objects.requireNonNull(utxo, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("address");
        this.stringAdapter.toJson(writer, (JsonWriter) utxo.getAddress());
        writer.name("hash");
        this.stringAdapter.toJson(writer, (JsonWriter) utxo.getHash());
        writer.name("index");
        this.uIntAdapter.toJson(writer, (JsonWriter) UInt.h(utxo.m2070getIndexpVg5ArA()));
        writer.name("value");
        this.bigIntegerAdapter.toJson(writer, (JsonWriter) utxo.getValue());
        writer.name("script");
        this.byteArrayAdapter.toJson(writer, (JsonWriter) utxo.getScript());
        writer.endObject();
    }
}