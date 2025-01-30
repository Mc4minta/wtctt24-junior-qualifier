package com.coinbase.wallet.swap.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.core.util.JSON;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.ToJson;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SwapAsset.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0017¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0013\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/swap/models/SwapAssetJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/swap/models/SwapAsset;", "Lcom/squareup/moshi/JsonWriter;", "writer", "asset", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/swap/models/SwapAsset;)V", "", "", "stringListAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "kotlin.jvm.PlatformType", "options", "Lcom/squareup/moshi/JsonReader$Options;", "<init>", "()V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapAssetJsonAdapter extends JsonAdapter<SwapAsset> {
    private final JsonReader.Options options = JsonReader.Options.of(ApiConstants.NAME, AppsFlyerProperties.CURRENCY_CODE, "address", "decimals", "imageURL", "swappable", "aggregators");
    private final JsonAdapter<List<String>> stringListAdapter = JSON.INSTANCE.parameterizedAdapter(List.class, String.class);

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    @FromJson
    public SwapAsset fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        Integer num = null;
        Boolean bool = null;
        String str = null;
        CurrencyCode currencyCode = null;
        ContractAddress contractAddress = null;
        URL url = null;
        List<String> list = null;
        while (reader.hasNext()) {
            switch (reader.selectName(this.options)) {
                case 0:
                    str = reader.nextString();
                    break;
                case 1:
                    String nextString = reader.nextString();
                    m.f(nextString, "reader.nextString()");
                    currencyCode = new CurrencyCode(nextString);
                    break;
                case 2:
                    if (reader.peek() == JsonReader.Token.NULL) {
                        reader.skipValue();
                        break;
                    } else {
                        String nextString2 = reader.nextString();
                        m.f(nextString2, "reader.nextString()");
                        contractAddress = new ContractAddress(nextString2);
                        break;
                    }
                case 3:
                    num = Integer.valueOf(reader.nextInt());
                    break;
                case 4:
                    if (reader.peek() == JsonReader.Token.NULL) {
                        reader.skipValue();
                        break;
                    } else {
                        url = new URL(reader.nextString());
                        break;
                    }
                case 5:
                    bool = Boolean.valueOf(reader.nextBoolean());
                    break;
                case 6:
                    list = this.stringListAdapter.fromJson(reader);
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        if (str != null) {
            if (currencyCode != null) {
                if (num != null) {
                    int intValue = num.intValue();
                    if (bool != null) {
                        boolean booleanValue = bool.booleanValue();
                        if (list != null) {
                            return new SwapAsset(str, currencyCode, contractAddress, intValue, url, booleanValue, list);
                        }
                        throw new JsonDataException();
                    }
                    throw new JsonDataException();
                }
                throw new JsonDataException();
            }
            throw new JsonDataException();
        }
        throw new JsonDataException();
    }

    @Override // com.squareup.moshi.JsonAdapter
    @ToJson
    public void toJson(JsonWriter writer, SwapAsset swapAsset) {
        m.g(writer, "writer");
        if (swapAsset == null) {
            writer.nullValue();
            return;
        }
        writer.beginObject();
        writer.name(ApiConstants.NAME);
        writer.value(swapAsset.getName());
        writer.name(AppsFlyerProperties.CURRENCY_CODE);
        writer.value(swapAsset.getCurrencyCode().getRawValue());
        writer.name("address");
        if (swapAsset.getContractAddress() == null) {
            writer.nullValue();
        } else {
            writer.value(swapAsset.getContractAddress().getRawValue());
        }
        writer.name("decimals");
        writer.value(Integer.valueOf(swapAsset.getDecimals()));
        writer.name("imageURL");
        if (swapAsset.getImageURL() == null) {
            writer.nullValue();
        } else {
            writer.value(swapAsset.getImageURL().toString());
        }
        writer.name("swappable");
        writer.value(swapAsset.getSwappable());
        writer.name("aggregators");
        writer.value(this.stringListAdapter.toJson(swapAsset.getAggregatorIDs()));
        writer.endObject();
    }
}