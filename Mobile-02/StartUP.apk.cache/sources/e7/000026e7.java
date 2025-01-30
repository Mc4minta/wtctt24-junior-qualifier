package com.coinbase.wallet.swap.models;

import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: SwapQuoteJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0015R\u001e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0015¨\u0006&"}, d2 = {"Lcom/coinbase/wallet/swap/models/SwapQuoteJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/swap/models/SwapQuote;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/swap/models/SwapQuote;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/swap/models/SwapQuote;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "", "doubleAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "intAdapter", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "stringAdapter", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "swapAssetAdapter", "Ljava/math/BigInteger;", "bigIntegerAdapter", "", "nullableBooleanAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapQuoteJsonAdapter extends JsonAdapter<SwapQuote> {
    private final JsonAdapter<BigInteger> bigIntegerAdapter;
    private volatile Constructor<SwapQuote> constructorRef;
    private final JsonAdapter<Double> doubleAdapter;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<SwapAsset> swapAssetAdapter;

    public SwapQuoteJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        Set<? extends Annotation> b6;
        Set<? extends Annotation> b7;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("aggregatorID", "fromAsset", "toAsset", "fromAmount", "toAmount", "priceImpact", "highPriceImpact", RouteActionKey.RouteActionKeys.CHAIN_ID);
        m.f(of, "of(\"aggregatorID\", \"fromAsset\",\n      \"toAsset\", \"fromAmount\", \"toAmount\", \"priceImpact\", \"highPriceImpact\", \"chainId\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "aggregatorID");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"aggregatorID\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<SwapAsset> adapter2 = moshi.adapter(SwapAsset.class, b3, "fromAsset");
        m.f(adapter2, "moshi.adapter(SwapAsset::class.java,\n      emptySet(), \"fromAsset\")");
        this.swapAssetAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<BigInteger> adapter3 = moshi.adapter(BigInteger.class, b4, "fromAmount");
        m.f(adapter3, "moshi.adapter(BigInteger::class.java,\n      emptySet(), \"fromAmount\")");
        this.bigIntegerAdapter = adapter3;
        Class cls = Double.TYPE;
        b5 = s0.b();
        JsonAdapter<Double> adapter4 = moshi.adapter(cls, b5, "priceImpact");
        m.f(adapter4, "moshi.adapter(Double::class.java, emptySet(),\n      \"priceImpact\")");
        this.doubleAdapter = adapter4;
        b6 = s0.b();
        JsonAdapter<Boolean> adapter5 = moshi.adapter(Boolean.class, b6, "_highPriceImpact");
        m.f(adapter5, "moshi.adapter(Boolean::class.javaObjectType, emptySet(), \"_highPriceImpact\")");
        this.nullableBooleanAdapter = adapter5;
        Class cls2 = Integer.TYPE;
        b7 = s0.b();
        JsonAdapter<Integer> adapter6 = moshi.adapter(cls2, b7, RouteActionKey.RouteActionKeys.CHAIN_ID);
        m.f(adapter6, "moshi.adapter(Int::class.java, emptySet(), \"chainId\")");
        this.intAdapter = adapter6;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(31);
        sb.append("GeneratedJsonAdapter(");
        sb.append("SwapQuote");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public SwapQuote fromJson(JsonReader reader) {
        String str;
        m.g(reader, "reader");
        Integer num = 0;
        reader.beginObject();
        int i2 = -1;
        Double d2 = null;
        String str2 = null;
        SwapAsset swapAsset = null;
        SwapAsset swapAsset2 = null;
        BigInteger bigInteger = null;
        BigInteger bigInteger2 = null;
        Boolean bool = null;
        while (true) {
            Boolean bool2 = bool;
            Integer num2 = num;
            if (reader.hasNext()) {
                switch (reader.selectName(this.options)) {
                    case -1:
                        reader.skipName();
                        reader.skipValue();
                        bool = bool2;
                        break;
                    case 0:
                        str2 = this.stringAdapter.fromJson(reader);
                        if (str2 == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("aggregatorID", "aggregatorID", reader);
                            m.f(unexpectedNull, "unexpectedNull(\"aggregatorID\", \"aggregatorID\", reader)");
                            throw unexpectedNull;
                        }
                        bool = bool2;
                        break;
                    case 1:
                        swapAsset = this.swapAssetAdapter.fromJson(reader);
                        if (swapAsset == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("fromAsset", "fromAsset", reader);
                            m.f(unexpectedNull2, "unexpectedNull(\"fromAsset\",\n            \"fromAsset\", reader)");
                            throw unexpectedNull2;
                        }
                        bool = bool2;
                        break;
                    case 2:
                        swapAsset2 = this.swapAssetAdapter.fromJson(reader);
                        if (swapAsset2 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("toAsset", "toAsset", reader);
                            m.f(unexpectedNull3, "unexpectedNull(\"toAsset\",\n            \"toAsset\", reader)");
                            throw unexpectedNull3;
                        }
                        bool = bool2;
                        break;
                    case 3:
                        bigInteger = this.bigIntegerAdapter.fromJson(reader);
                        if (bigInteger == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull("fromAmount", "fromAmount", reader);
                            m.f(unexpectedNull4, "unexpectedNull(\"fromAmount\", \"fromAmount\", reader)");
                            throw unexpectedNull4;
                        }
                        bool = bool2;
                        break;
                    case 4:
                        bigInteger2 = this.bigIntegerAdapter.fromJson(reader);
                        if (bigInteger2 == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull("toAmount", "toAmount", reader);
                            m.f(unexpectedNull5, "unexpectedNull(\"toAmount\",\n            \"toAmount\", reader)");
                            throw unexpectedNull5;
                        }
                        bool = bool2;
                        break;
                    case 5:
                        d2 = this.doubleAdapter.fromJson(reader);
                        if (d2 == null) {
                            JsonDataException unexpectedNull6 = Util.unexpectedNull("priceImpact", "priceImpact", reader);
                            m.f(unexpectedNull6, "unexpectedNull(\"priceImpact\", \"priceImpact\", reader)");
                            throw unexpectedNull6;
                        }
                        bool = bool2;
                        break;
                    case 6:
                        bool = this.nullableBooleanAdapter.fromJson(reader);
                        break;
                    case 7:
                        num = this.intAdapter.fromJson(reader);
                        if (num == null) {
                            JsonDataException unexpectedNull7 = Util.unexpectedNull(RouteActionKey.RouteActionKeys.CHAIN_ID, RouteActionKey.RouteActionKeys.CHAIN_ID, reader);
                            m.f(unexpectedNull7, "unexpectedNull(\"chainId\", \"chainId\",\n              reader)");
                            throw unexpectedNull7;
                        }
                        i2 &= -129;
                        bool = bool2;
                        continue;
                    default:
                        bool = bool2;
                        break;
                }
                num = num2;
            } else {
                reader.endObject();
                if (i2 == -129) {
                    if (str2 == null) {
                        JsonDataException missingProperty = Util.missingProperty("aggregatorID", "aggregatorID", reader);
                        m.f(missingProperty, "missingProperty(\"aggregatorID\", \"aggregatorID\",\n              reader)");
                        throw missingProperty;
                    } else if (swapAsset == null) {
                        JsonDataException missingProperty2 = Util.missingProperty("fromAsset", "fromAsset", reader);
                        m.f(missingProperty2, "missingProperty(\"fromAsset\", \"fromAsset\", reader)");
                        throw missingProperty2;
                    } else if (swapAsset2 == null) {
                        JsonDataException missingProperty3 = Util.missingProperty("toAsset", "toAsset", reader);
                        m.f(missingProperty3, "missingProperty(\"toAsset\", \"toAsset\", reader)");
                        throw missingProperty3;
                    } else if (bigInteger == null) {
                        JsonDataException missingProperty4 = Util.missingProperty("fromAmount", "fromAmount", reader);
                        m.f(missingProperty4, "missingProperty(\"fromAmount\", \"fromAmount\", reader)");
                        throw missingProperty4;
                    } else if (bigInteger2 == null) {
                        JsonDataException missingProperty5 = Util.missingProperty("toAmount", "toAmount", reader);
                        m.f(missingProperty5, "missingProperty(\"toAmount\", \"toAmount\", reader)");
                        throw missingProperty5;
                    } else if (d2 != null) {
                        return new SwapQuote(str2, swapAsset, swapAsset2, bigInteger, bigInteger2, d2.doubleValue(), bool2, num2.intValue());
                    } else {
                        JsonDataException missingProperty6 = Util.missingProperty("priceImpact", "priceImpact", reader);
                        m.f(missingProperty6, "missingProperty(\"priceImpact\", \"priceImpact\",\n              reader)");
                        throw missingProperty6;
                    }
                }
                Constructor<SwapQuote> constructor = this.constructorRef;
                if (constructor == null) {
                    str = "missingProperty(\"toAsset\", \"toAsset\", reader)";
                    Class cls = Integer.TYPE;
                    constructor = SwapQuote.class.getDeclaredConstructor(String.class, SwapAsset.class, SwapAsset.class, BigInteger.class, BigInteger.class, Double.TYPE, Boolean.class, cls, cls, Util.DEFAULT_CONSTRUCTOR_MARKER);
                    this.constructorRef = constructor;
                    m.f(constructor, "SwapQuote::class.java.getDeclaredConstructor(String::class.java, SwapAsset::class.java,\n          SwapAsset::class.java, BigInteger::class.java, BigInteger::class.java,\n          Double::class.javaPrimitiveType, Boolean::class.javaObjectType,\n          Int::class.javaPrimitiveType, Int::class.javaPrimitiveType,\n          Util.DEFAULT_CONSTRUCTOR_MARKER).also { this.constructorRef = it }");
                } else {
                    str = "missingProperty(\"toAsset\", \"toAsset\", reader)";
                }
                Object[] objArr = new Object[10];
                if (str2 == null) {
                    JsonDataException missingProperty7 = Util.missingProperty("aggregatorID", "aggregatorID", reader);
                    m.f(missingProperty7, "missingProperty(\"aggregatorID\", \"aggregatorID\", reader)");
                    throw missingProperty7;
                }
                objArr[0] = str2;
                if (swapAsset == null) {
                    JsonDataException missingProperty8 = Util.missingProperty("fromAsset", "fromAsset", reader);
                    m.f(missingProperty8, "missingProperty(\"fromAsset\", \"fromAsset\", reader)");
                    throw missingProperty8;
                }
                objArr[1] = swapAsset;
                if (swapAsset2 == null) {
                    JsonDataException missingProperty9 = Util.missingProperty("toAsset", "toAsset", reader);
                    m.f(missingProperty9, str);
                    throw missingProperty9;
                }
                objArr[2] = swapAsset2;
                if (bigInteger == null) {
                    JsonDataException missingProperty10 = Util.missingProperty("fromAmount", "fromAmount", reader);
                    m.f(missingProperty10, "missingProperty(\"fromAmount\", \"fromAmount\", reader)");
                    throw missingProperty10;
                }
                objArr[3] = bigInteger;
                if (bigInteger2 == null) {
                    JsonDataException missingProperty11 = Util.missingProperty("toAmount", "toAmount", reader);
                    m.f(missingProperty11, "missingProperty(\"toAmount\", \"toAmount\", reader)");
                    throw missingProperty11;
                }
                objArr[4] = bigInteger2;
                if (d2 == null) {
                    JsonDataException missingProperty12 = Util.missingProperty("priceImpact", "priceImpact", reader);
                    m.f(missingProperty12, "missingProperty(\"priceImpact\", \"priceImpact\", reader)");
                    throw missingProperty12;
                }
                objArr[5] = Double.valueOf(d2.doubleValue());
                objArr[6] = bool2;
                objArr[7] = num2;
                objArr[8] = Integer.valueOf(i2);
                objArr[9] = null;
                SwapQuote newInstance = constructor.newInstance(objArr);
                m.f(newInstance, "localConstructor.newInstance(\n          aggregatorID ?: throw Util.missingProperty(\"aggregatorID\", \"aggregatorID\", reader),\n          fromAsset ?: throw Util.missingProperty(\"fromAsset\", \"fromAsset\", reader),\n          toAsset ?: throw Util.missingProperty(\"toAsset\", \"toAsset\", reader),\n          fromAmount ?: throw Util.missingProperty(\"fromAmount\", \"fromAmount\", reader),\n          toAmount ?: throw Util.missingProperty(\"toAmount\", \"toAmount\", reader),\n          priceImpact ?: throw Util.missingProperty(\"priceImpact\", \"priceImpact\", reader),\n          _highPriceImpact,\n          chainId,\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
                return newInstance;
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, SwapQuote swapQuote) {
        m.g(writer, "writer");
        Objects.requireNonNull(swapQuote, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("aggregatorID");
        this.stringAdapter.toJson(writer, (JsonWriter) swapQuote.getAggregatorID());
        writer.name("fromAsset");
        this.swapAssetAdapter.toJson(writer, (JsonWriter) swapQuote.getFromAsset());
        writer.name("toAsset");
        this.swapAssetAdapter.toJson(writer, (JsonWriter) swapQuote.getToAsset());
        writer.name("fromAmount");
        this.bigIntegerAdapter.toJson(writer, (JsonWriter) swapQuote.getFromAmount());
        writer.name("toAmount");
        this.bigIntegerAdapter.toJson(writer, (JsonWriter) swapQuote.getToAmount());
        writer.name("priceImpact");
        this.doubleAdapter.toJson(writer, (JsonWriter) Double.valueOf(swapQuote.getPriceImpact()));
        writer.name("highPriceImpact");
        this.nullableBooleanAdapter.toJson(writer, (JsonWriter) swapQuote.get_highPriceImpact());
        writer.name(RouteActionKey.RouteActionKeys.CHAIN_ID);
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(swapQuote.getChainId()));
        writer.endObject();
    }
}