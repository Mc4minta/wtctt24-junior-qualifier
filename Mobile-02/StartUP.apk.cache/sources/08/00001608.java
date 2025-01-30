package com.coinbase.wallet.consumer.dtos;

import com.coinbase.ApiConstants;
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

/* compiled from: PutConsumerWalletAddressRequestDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/PutConsumerWalletAddressRequestDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/consumer/dtos/PutConsumerWalletAddressRequestDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/consumer/dtos/PutConsumerWalletAddressRequestDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/consumer/dtos/PutConsumerWalletAddressRequestDTO;)V", "", "Lcom/coinbase/wallet/consumer/dtos/ConsumerWalletAddressDTO;", "listOfConsumerWalletAddressDTOAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerAppInfoDTO;", "consumerAppInfoDTOAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class PutConsumerWalletAddressRequestDTOJsonAdapter extends JsonAdapter<PutConsumerWalletAddressRequestDTO> {
    private final JsonAdapter<ConsumerAppInfoDTO> consumerAppInfoDTOAdapter;
    private final JsonAdapter<List<ConsumerWalletAddressDTO>> listOfConsumerWalletAddressDTOAdapter;
    private final JsonReader.Options options;

    public PutConsumerWalletAddressRequestDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("app_info", ApiConstants.ADDRESSES);
        m.f(of, "of(\"app_info\", \"addresses\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<ConsumerAppInfoDTO> adapter = moshi.adapter(ConsumerAppInfoDTO.class, b2, "appInfo");
        m.f(adapter, "moshi.adapter(ConsumerAppInfoDTO::class.java, emptySet(), \"appInfo\")");
        this.consumerAppInfoDTOAdapter = adapter;
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, ConsumerWalletAddressDTO.class);
        b3 = s0.b();
        JsonAdapter<List<ConsumerWalletAddressDTO>> adapter2 = moshi.adapter(newParameterizedType, b3, ApiConstants.ADDRESSES);
        m.f(adapter2, "moshi.adapter(Types.newParameterizedType(List::class.java,\n      ConsumerWalletAddressDTO::class.java), emptySet(), \"addresses\")");
        this.listOfConsumerWalletAddressDTOAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(56);
        sb.append("GeneratedJsonAdapter(");
        sb.append("PutConsumerWalletAddressRequestDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public PutConsumerWalletAddressRequestDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        ConsumerAppInfoDTO consumerAppInfoDTO = null;
        List<ConsumerWalletAddressDTO> list = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                consumerAppInfoDTO = this.consumerAppInfoDTOAdapter.fromJson(reader);
                if (consumerAppInfoDTO == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("appInfo", "app_info", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"appInfo\", \"app_info\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (list = this.listOfConsumerWalletAddressDTOAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull(ApiConstants.ADDRESSES, ApiConstants.ADDRESSES, reader);
                m.f(unexpectedNull2, "unexpectedNull(\"addresses\", \"addresses\", reader)");
                throw unexpectedNull2;
            }
        }
        reader.endObject();
        if (consumerAppInfoDTO == null) {
            JsonDataException missingProperty = Util.missingProperty("appInfo", "app_info", reader);
            m.f(missingProperty, "missingProperty(\"appInfo\", \"app_info\", reader)");
            throw missingProperty;
        } else if (list != null) {
            return new PutConsumerWalletAddressRequestDTO(consumerAppInfoDTO, list);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty(ApiConstants.ADDRESSES, ApiConstants.ADDRESSES, reader);
            m.f(missingProperty2, "missingProperty(\"addresses\", \"addresses\", reader)");
            throw missingProperty2;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, PutConsumerWalletAddressRequestDTO putConsumerWalletAddressRequestDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(putConsumerWalletAddressRequestDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("app_info");
        this.consumerAppInfoDTOAdapter.toJson(writer, (JsonWriter) putConsumerWalletAddressRequestDTO.getAppInfo());
        writer.name(ApiConstants.ADDRESSES);
        this.listOfConsumerWalletAddressDTOAdapter.toJson(writer, (JsonWriter) putConsumerWalletAddressRequestDTO.getAddresses());
        writer.endObject();
    }
}