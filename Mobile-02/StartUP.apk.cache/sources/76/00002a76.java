package com.coinbase.walletengine.services.btclike;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.m;

/* compiled from: BTCLikeService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"Lcom/coinbase/walletengine/services/btclike/UIntJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lkotlin/UInt;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value", "Lkotlin/x;", "toJson-FrkygD8", "(Lcom/squareup/moshi/JsonWriter;Lkotlin/UInt;)V", "toJson", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson-gbq4QnA", "(Lcom/squareup/moshi/JsonReader;)Lkotlin/UInt;", "fromJson", "<init>", "()V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class UIntJsonAdapter extends JsonAdapter<UInt> {
    @Override // com.squareup.moshi.JsonAdapter
    /* renamed from: fromJson-gbq4QnA  reason: not valid java name */
    public UInt fromJson(JsonReader reader) {
        m.g(reader, "reader");
        if (reader.peek() == JsonReader.Token.NULL) {
            return (UInt) reader.nextNull();
        }
        return UInt.h(UInt.s((int) reader.nextLong()));
    }

    @Override // com.squareup.moshi.JsonAdapter
    /* renamed from: toJson-FrkygD8  reason: not valid java name */
    public void toJson(JsonWriter writer, UInt uInt) {
        m.g(writer, "writer");
        if (uInt == null) {
            writer.nullValue();
        } else {
            writer.value(uInt.B() & 4294967295L);
        }
    }
}