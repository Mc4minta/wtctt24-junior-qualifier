package com.coinbase.wallet.blockchains.models;

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

/* compiled from: WalletAddressJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/WalletAddressJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/blockchains/models/WalletAddress;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/blockchains/models/WalletAddress;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/blockchains/models/WalletAddress;)V", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "addressTypeAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "", "intAdapter", "stringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletAddressJsonAdapter extends JsonAdapter<WalletAddress> {
    private final JsonAdapter<AddressType> addressTypeAdapter;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public WalletAddressJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("type", "address", "index");
        m.f(of, "of(\"type\", \"address\", \"index\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<AddressType> adapter = moshi.adapter(AddressType.class, b2, "type");
        m.f(adapter, "moshi.adapter(AddressType::class.java,\n      emptySet(), \"type\")");
        this.addressTypeAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, b3, "address");
        m.f(adapter2, "moshi.adapter(String::class.java, emptySet(),\n      \"address\")");
        this.stringAdapter = adapter2;
        Class cls = Integer.TYPE;
        b4 = s0.b();
        JsonAdapter<Integer> adapter3 = moshi.adapter(cls, b4, "index");
        m.f(adapter3, "moshi.adapter(Int::class.java, emptySet(), \"index\")");
        this.intAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(35);
        sb.append("GeneratedJsonAdapter(");
        sb.append("WalletAddress");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public WalletAddress fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        AddressType addressType = null;
        String str = null;
        Integer num = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                addressType = this.addressTypeAdapter.fromJson(reader);
                if (addressType == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("type", "type", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"type\", \"type\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("address", "address", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"address\",\n            \"address\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (num = this.intAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("index", "index", reader);
                m.f(unexpectedNull3, "unexpectedNull(\"index\", \"index\",\n            reader)");
                throw unexpectedNull3;
            }
        }
        reader.endObject();
        if (addressType == null) {
            JsonDataException missingProperty = Util.missingProperty("type", "type", reader);
            m.f(missingProperty, "missingProperty(\"type\", \"type\", reader)");
            throw missingProperty;
        } else if (str == null) {
            JsonDataException missingProperty2 = Util.missingProperty("address", "address", reader);
            m.f(missingProperty2, "missingProperty(\"address\", \"address\", reader)");
            throw missingProperty2;
        } else if (num != null) {
            return new WalletAddress(addressType, str, num.intValue());
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("index", "index", reader);
            m.f(missingProperty3, "missingProperty(\"index\", \"index\", reader)");
            throw missingProperty3;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, WalletAddress walletAddress) {
        m.g(writer, "writer");
        Objects.requireNonNull(walletAddress, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("type");
        this.addressTypeAdapter.toJson(writer, (JsonWriter) walletAddress.getType());
        writer.name("address");
        this.stringAdapter.toJson(writer, (JsonWriter) walletAddress.getAddress());
        writer.name("index");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(walletAddress.getIndex()));
        writer.endObject();
    }
}