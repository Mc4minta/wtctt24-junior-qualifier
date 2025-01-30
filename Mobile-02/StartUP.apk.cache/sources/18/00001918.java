package com.coinbase.wallet.core.jsonadapters;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.ToJson;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.m;
import kotlin.l0.b0;

/* compiled from: UIntAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0017ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0017ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/core/jsonadapters/UIntAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lkotlin/UInt;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson-gbq4QnA", "(Lcom/squareup/moshi/JsonReader;)Lkotlin/UInt;", "fromJson", "Lcom/squareup/moshi/JsonWriter;", "writer", "value", "Lkotlin/x;", "toJson-FrkygD8", "(Lcom/squareup/moshi/JsonWriter;Lkotlin/UInt;)V", "toJson", "<init>", "()V", "core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class UIntAdapter extends JsonAdapter<UInt> {
    @Override // com.squareup.moshi.JsonAdapter
    @FromJson
    /* renamed from: fromJson-gbq4QnA  reason: not valid java name */
    public UInt fromJson(JsonReader reader) throws IOException {
        m.g(reader, "reader");
        if (reader.peek() == JsonReader.Token.NULL) {
            return (UInt) reader.nextNull();
        }
        String nextString = reader.nextString();
        m.f(nextString, "reader.nextString()");
        return UInt.h(b0.a(nextString));
    }

    @Override // com.squareup.moshi.JsonAdapter
    @ToJson
    /* renamed from: toJson-FrkygD8  reason: not valid java name */
    public void toJson(JsonWriter writer, UInt uInt) {
        m.g(writer, "writer");
        if (uInt == null) {
            writer.value((String) null);
        } else {
            writer.value(UInt.A(uInt.B()));
        }
    }
}