package com.coinbase.wallet.core.jsonadapters;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.ToJson;
import java.io.IOException;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: BigIntegerAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0017¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/coinbase/wallet/core/jsonadapters/BigIntegerAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Ljava/math/BigInteger;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Ljava/math/BigInteger;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Ljava/math/BigInteger;)V", "<init>", "()V", "core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BigIntegerAdapter extends JsonAdapter<BigInteger> {
    @Override // com.squareup.moshi.JsonAdapter
    @FromJson
    public BigInteger fromJson(JsonReader reader) throws IOException {
        m.g(reader, "reader");
        return reader.peek() == JsonReader.Token.NULL ? (BigInteger) reader.nextNull() : new BigInteger(reader.nextString());
    }

    @Override // com.squareup.moshi.JsonAdapter
    @ToJson
    public void toJson(JsonWriter writer, BigInteger bigInteger) {
        m.g(writer, "writer");
        if (bigInteger == null) {
            writer.value((String) null);
        } else {
            writer.value(bigInteger.toString());
        }
    }
}