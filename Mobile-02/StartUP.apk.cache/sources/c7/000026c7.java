package com.coinbase.wallet.swap.dtos;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.swap.models.ApproveTx;
import com.coinbase.wallet.swap.models.SwapFee;
import com.coinbase.wallet.swap.models.SwapQuote;
import com.coinbase.wallet.swap.models.SwapTx;
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

/* compiled from: SwapTxResultDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0012¨\u0006 "}, d2 = {"Lcom/coinbase/wallet/swap/dtos/SwapTxResultDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/swap/dtos/SwapTxResultDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/swap/dtos/SwapTxResultDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/swap/dtos/SwapTxResultDTO;)V", "Lcom/coinbase/wallet/swap/models/ApproveTx;", "nullableApproveTxAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/swap/models/SwapFee;", "swapFeeAdapter", "Lcom/coinbase/wallet/swap/models/SwapTx;", "swapTxAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/coinbase/wallet/swap/models/SwapQuote;", "swapQuoteAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapTxResultDTOJsonAdapter extends JsonAdapter<SwapTxResultDTO> {
    private final JsonAdapter<ApproveTx> nullableApproveTxAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<SwapFee> swapFeeAdapter;
    private final JsonAdapter<SwapQuote> swapQuoteAdapter;
    private final JsonAdapter<SwapTx> swapTxAdapter;

    public SwapTxResultDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("tx", "approveTx", ApiConstants.QUOTE, ApiConstants.FEE);
        m.f(of, "of(\"tx\", \"approveTx\", \"quote\", \"fee\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<SwapTx> adapter = moshi.adapter(SwapTx.class, b2, "tx");
        m.f(adapter, "moshi.adapter(SwapTx::class.java, emptySet(),\n      \"tx\")");
        this.swapTxAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<ApproveTx> adapter2 = moshi.adapter(ApproveTx.class, b3, "approveTx");
        m.f(adapter2, "moshi.adapter(ApproveTx::class.java, emptySet(), \"approveTx\")");
        this.nullableApproveTxAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<SwapQuote> adapter3 = moshi.adapter(SwapQuote.class, b4, ApiConstants.QUOTE);
        m.f(adapter3, "moshi.adapter(SwapQuote::class.java,\n      emptySet(), \"quote\")");
        this.swapQuoteAdapter = adapter3;
        b5 = s0.b();
        JsonAdapter<SwapFee> adapter4 = moshi.adapter(SwapFee.class, b5, ApiConstants.FEE);
        m.f(adapter4, "moshi.adapter(SwapFee::class.java, emptySet(),\n      \"fee\")");
        this.swapFeeAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(37);
        sb.append("GeneratedJsonAdapter(");
        sb.append("SwapTxResultDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public SwapTxResultDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        SwapTx swapTx = null;
        ApproveTx approveTx = null;
        SwapQuote swapQuote = null;
        SwapFee swapFee = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                swapTx = this.swapTxAdapter.fromJson(reader);
                if (swapTx == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("tx", "tx", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"tx\", \"tx\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                approveTx = this.nullableApproveTxAdapter.fromJson(reader);
            } else if (selectName == 2) {
                swapQuote = this.swapQuoteAdapter.fromJson(reader);
                if (swapQuote == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(ApiConstants.QUOTE, ApiConstants.QUOTE, reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"quote\",\n            \"quote\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 3 && (swapFee = this.swapFeeAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull(ApiConstants.FEE, ApiConstants.FEE, reader);
                m.f(unexpectedNull3, "unexpectedNull(\"fee\", \"fee\",\n            reader)");
                throw unexpectedNull3;
            }
        }
        reader.endObject();
        if (swapTx == null) {
            JsonDataException missingProperty = Util.missingProperty("tx", "tx", reader);
            m.f(missingProperty, "missingProperty(\"tx\", \"tx\", reader)");
            throw missingProperty;
        } else if (swapQuote == null) {
            JsonDataException missingProperty2 = Util.missingProperty(ApiConstants.QUOTE, ApiConstants.QUOTE, reader);
            m.f(missingProperty2, "missingProperty(\"quote\", \"quote\", reader)");
            throw missingProperty2;
        } else if (swapFee != null) {
            return new SwapTxResultDTO(swapTx, approveTx, swapQuote, swapFee);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty(ApiConstants.FEE, ApiConstants.FEE, reader);
            m.f(missingProperty3, "missingProperty(\"fee\", \"fee\", reader)");
            throw missingProperty3;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, SwapTxResultDTO swapTxResultDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(swapTxResultDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("tx");
        this.swapTxAdapter.toJson(writer, (JsonWriter) swapTxResultDTO.getTx$swap_release());
        writer.name("approveTx");
        this.nullableApproveTxAdapter.toJson(writer, (JsonWriter) swapTxResultDTO.getApproveTx$swap_release());
        writer.name(ApiConstants.QUOTE);
        this.swapQuoteAdapter.toJson(writer, (JsonWriter) swapTxResultDTO.getQuote$swap_release());
        writer.name(ApiConstants.FEE);
        this.swapFeeAdapter.toJson(writer, (JsonWriter) swapTxResultDTO.getFee$swap_release());
        writer.endObject();
    }
}