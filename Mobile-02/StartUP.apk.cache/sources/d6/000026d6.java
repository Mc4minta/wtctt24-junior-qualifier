package com.coinbase.wallet.swap.models;

import com.coinbase.ApiConstants;
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

/* compiled from: ApproveTxJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/swap/models/ApproveTxJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/swap/models/ApproveTx;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/swap/models/ApproveTx;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/swap/models/ApproveTx;)V", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ApproveTxJsonAdapter extends JsonAdapter<ApproveTx> {
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ApproveTxJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(ApiConstants.FROM, ApiConstants.TO, "gas", "gasPrice", "data");
        m.f(of, "of(\"from\", \"to\", \"gas\", \"gasPrice\",\n      \"data\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, ApiConstants.FROM);
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"from\")");
        this.stringAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(31);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ApproveTx");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ApproveTx fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull(ApiConstants.FROM, ApiConstants.FROM, reader);
                    m.f(unexpectedNull, "unexpectedNull(\"from\", \"from\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(ApiConstants.TO, ApiConstants.TO, reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"to\", \"to\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str3 = this.stringAdapter.fromJson(reader);
                if (str3 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("gas", "gas", reader);
                    m.f(unexpectedNull3, "unexpectedNull(\"gas\", \"gas\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                str4 = this.stringAdapter.fromJson(reader);
                if (str4 == null) {
                    JsonDataException unexpectedNull4 = Util.unexpectedNull("gasPrice", "gasPrice", reader);
                    m.f(unexpectedNull4, "unexpectedNull(\"gasPrice\",\n            \"gasPrice\", reader)");
                    throw unexpectedNull4;
                }
            } else if (selectName == 4 && (str5 = this.stringAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull5 = Util.unexpectedNull("data_", "data", reader);
                m.f(unexpectedNull5, "unexpectedNull(\"data_\", \"data\",\n            reader)");
                throw unexpectedNull5;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty(ApiConstants.FROM, ApiConstants.FROM, reader);
            m.f(missingProperty, "missingProperty(\"from\", \"from\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty(ApiConstants.TO, ApiConstants.TO, reader);
            m.f(missingProperty2, "missingProperty(\"to\", \"to\", reader)");
            throw missingProperty2;
        } else if (str3 == null) {
            JsonDataException missingProperty3 = Util.missingProperty("gas", "gas", reader);
            m.f(missingProperty3, "missingProperty(\"gas\", \"gas\", reader)");
            throw missingProperty3;
        } else if (str4 == null) {
            JsonDataException missingProperty4 = Util.missingProperty("gasPrice", "gasPrice", reader);
            m.f(missingProperty4, "missingProperty(\"gasPrice\", \"gasPrice\", reader)");
            throw missingProperty4;
        } else if (str5 != null) {
            return new ApproveTx(str, str2, str3, str4, str5);
        } else {
            JsonDataException missingProperty5 = Util.missingProperty("data_", "data", reader);
            m.f(missingProperty5, "missingProperty(\"data_\", \"data\", reader)");
            throw missingProperty5;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ApproveTx approveTx) {
        m.g(writer, "writer");
        Objects.requireNonNull(approveTx, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name(ApiConstants.FROM);
        this.stringAdapter.toJson(writer, (JsonWriter) approveTx.getFrom$swap_release());
        writer.name(ApiConstants.TO);
        this.stringAdapter.toJson(writer, (JsonWriter) approveTx.getTo$swap_release());
        writer.name("gas");
        this.stringAdapter.toJson(writer, (JsonWriter) approveTx.getGas$swap_release());
        writer.name("gasPrice");
        this.stringAdapter.toJson(writer, (JsonWriter) approveTx.getGasPrice$swap_release());
        writer.name("data");
        this.stringAdapter.toJson(writer, (JsonWriter) approveTx.getData$swap_release());
        writer.endObject();
    }
}