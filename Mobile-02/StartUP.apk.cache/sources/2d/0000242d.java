package com.coinbase.wallet.lending.dtos;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.routing.models.RouteActionKey;
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
import kotlin.UInt;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: LendTokenDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00018\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u001e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/lending/dtos/LendTokenDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/lending/dtos/LendTokenDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/lending/dtos/LendTokenDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/lending/dtos/LendTokenDTO;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lkotlin/UInt;", "uIntAdapter", "Lcom/squareup/moshi/JsonAdapter;", "stringAdapter", "nullableStringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendTokenDTOJsonAdapter extends JsonAdapter<LendTokenDTO> {
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<UInt> uIntAdapter;

    public LendTokenDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", ApiConstants.NAME, "code", "decimals", "imageUrl", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "supplyBalance", "supplyInterestRate", "globalSuppliedAmount", "utilizationRate", "collateralRate", "providerId", "providerName", "providerWebsiteUrl", "providerImageUrl", "rateDecimals");
        m.f(of, "of(\"id\", \"name\", \"code\", \"decimals\",\n      \"imageUrl\", \"contractAddress\", \"supplyBalance\", \"supplyInterestRate\", \"globalSuppliedAmount\",\n      \"utilizationRate\", \"collateralRate\", \"providerId\", \"providerName\", \"providerWebsiteUrl\",\n      \"providerImageUrl\", \"rateDecimals\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "id");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<UInt> adapter2 = moshi.adapter(UInt.class, b3, "decimals");
        m.f(adapter2, "moshi.adapter(UInt::class.java, emptySet(),\n      \"decimals\")");
        this.uIntAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, b4, "imageUrl");
        m.f(adapter3, "moshi.adapter(String::class.java,\n      emptySet(), \"imageUrl\")");
        this.nullableStringAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(34);
        sb.append("GeneratedJsonAdapter(");
        sb.append("LendTokenDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public LendTokenDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        UInt uInt = null;
        UInt uInt2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        while (true) {
            String str15 = str10;
            String str16 = str5;
            String str17 = str4;
            UInt uInt3 = uInt2;
            String str18 = str11;
            String str19 = str9;
            String str20 = str8;
            String str21 = str7;
            String str22 = str6;
            UInt uInt4 = uInt;
            String str23 = str3;
            String str24 = str2;
            String str25 = str;
            if (reader.hasNext()) {
                switch (reader.selectName(this.options)) {
                    case -1:
                        reader.skipName();
                        reader.skipValue();
                        uInt2 = uInt3;
                        uInt = uInt4;
                        str10 = str15;
                        str5 = str16;
                        str4 = str17;
                        str11 = str18;
                        str9 = str19;
                        str8 = str20;
                        str7 = str21;
                        str6 = str22;
                        str3 = str23;
                        str2 = str24;
                        break;
                    case 0:
                        String fromJson = this.stringAdapter.fromJson(reader);
                        if (fromJson == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", reader);
                            m.f(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                            throw unexpectedNull;
                        }
                        str = fromJson;
                        uInt2 = uInt3;
                        uInt = uInt4;
                        str10 = str15;
                        str5 = str16;
                        str4 = str17;
                        str11 = str18;
                        str9 = str19;
                        str8 = str20;
                        str7 = str21;
                        str6 = str22;
                        str3 = str23;
                        str2 = str24;
                        continue;
                    case 1:
                        String fromJson2 = this.stringAdapter.fromJson(reader);
                        if (fromJson2 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull(ApiConstants.NAME, ApiConstants.NAME, reader);
                            m.f(unexpectedNull2, "unexpectedNull(\"name\", \"name\",\n            reader)");
                            throw unexpectedNull2;
                        }
                        str2 = fromJson2;
                        uInt2 = uInt3;
                        uInt = uInt4;
                        str10 = str15;
                        str5 = str16;
                        str4 = str17;
                        str11 = str18;
                        str9 = str19;
                        str8 = str20;
                        str7 = str21;
                        str6 = str22;
                        str3 = str23;
                        break;
                    case 2:
                        String fromJson3 = this.stringAdapter.fromJson(reader);
                        if (fromJson3 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("code", "code", reader);
                            m.f(unexpectedNull3, "unexpectedNull(\"code\", \"code\",\n            reader)");
                            throw unexpectedNull3;
                        }
                        str3 = fromJson3;
                        uInt2 = uInt3;
                        uInt = uInt4;
                        str10 = str15;
                        str5 = str16;
                        str4 = str17;
                        str11 = str18;
                        str9 = str19;
                        str8 = str20;
                        str7 = str21;
                        str6 = str22;
                        str2 = str24;
                        break;
                    case 3:
                        UInt fromJson4 = this.uIntAdapter.fromJson(reader);
                        if (fromJson4 == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull("decimals", "decimals", reader);
                            m.f(unexpectedNull4, "unexpectedNull(\"decimals\",\n            \"decimals\", reader)");
                            throw unexpectedNull4;
                        }
                        uInt = fromJson4;
                        uInt2 = uInt3;
                        str10 = str15;
                        str5 = str16;
                        str4 = str17;
                        str11 = str18;
                        str9 = str19;
                        str8 = str20;
                        str7 = str21;
                        str6 = str22;
                        str3 = str23;
                        str2 = str24;
                        break;
                    case 4:
                        str4 = this.nullableStringAdapter.fromJson(reader);
                        uInt2 = uInt3;
                        uInt = uInt4;
                        str10 = str15;
                        str5 = str16;
                        str11 = str18;
                        str9 = str19;
                        str8 = str20;
                        str7 = str21;
                        str6 = str22;
                        str3 = str23;
                        str2 = str24;
                        break;
                    case 5:
                        str5 = this.nullableStringAdapter.fromJson(reader);
                        uInt2 = uInt3;
                        uInt = uInt4;
                        str10 = str15;
                        str4 = str17;
                        str11 = str18;
                        str9 = str19;
                        str8 = str20;
                        str7 = str21;
                        str6 = str22;
                        str3 = str23;
                        str2 = str24;
                        break;
                    case 6:
                        String fromJson5 = this.stringAdapter.fromJson(reader);
                        if (fromJson5 == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull("supplyBalance", "supplyBalance", reader);
                            m.f(unexpectedNull5, "unexpectedNull(\"supplyBalance\", \"supplyBalance\", reader)");
                            throw unexpectedNull5;
                        }
                        str6 = fromJson5;
                        uInt2 = uInt3;
                        uInt = uInt4;
                        str10 = str15;
                        str5 = str16;
                        str4 = str17;
                        str11 = str18;
                        str9 = str19;
                        str8 = str20;
                        str7 = str21;
                        str3 = str23;
                        str2 = str24;
                        break;
                    case 7:
                        String fromJson6 = this.stringAdapter.fromJson(reader);
                        if (fromJson6 == null) {
                            JsonDataException unexpectedNull6 = Util.unexpectedNull("supplyInterestRate", "supplyInterestRate", reader);
                            m.f(unexpectedNull6, "unexpectedNull(\"supplyInterestRate\", \"supplyInterestRate\", reader)");
                            throw unexpectedNull6;
                        }
                        str7 = fromJson6;
                        uInt2 = uInt3;
                        uInt = uInt4;
                        str10 = str15;
                        str5 = str16;
                        str4 = str17;
                        str11 = str18;
                        str9 = str19;
                        str8 = str20;
                        str6 = str22;
                        str3 = str23;
                        str2 = str24;
                        break;
                    case 8:
                        String fromJson7 = this.stringAdapter.fromJson(reader);
                        if (fromJson7 == null) {
                            JsonDataException unexpectedNull7 = Util.unexpectedNull("globalSuppliedAmount", "globalSuppliedAmount", reader);
                            m.f(unexpectedNull7, "unexpectedNull(\"globalSuppliedAmount\", \"globalSuppliedAmount\", reader)");
                            throw unexpectedNull7;
                        }
                        str8 = fromJson7;
                        uInt2 = uInt3;
                        uInt = uInt4;
                        str10 = str15;
                        str5 = str16;
                        str4 = str17;
                        str11 = str18;
                        str9 = str19;
                        str7 = str21;
                        str6 = str22;
                        str3 = str23;
                        str2 = str24;
                        break;
                    case 9:
                        String fromJson8 = this.stringAdapter.fromJson(reader);
                        if (fromJson8 == null) {
                            JsonDataException unexpectedNull8 = Util.unexpectedNull("utilizationRate", "utilizationRate", reader);
                            m.f(unexpectedNull8, "unexpectedNull(\"utilizationRate\", \"utilizationRate\", reader)");
                            throw unexpectedNull8;
                        }
                        str9 = fromJson8;
                        uInt2 = uInt3;
                        uInt = uInt4;
                        str10 = str15;
                        str5 = str16;
                        str4 = str17;
                        str11 = str18;
                        str8 = str20;
                        str7 = str21;
                        str6 = str22;
                        str3 = str23;
                        str2 = str24;
                        break;
                    case 10:
                        str10 = this.nullableStringAdapter.fromJson(reader);
                        uInt2 = uInt3;
                        uInt = uInt4;
                        str5 = str16;
                        str4 = str17;
                        str11 = str18;
                        str9 = str19;
                        str8 = str20;
                        str7 = str21;
                        str6 = str22;
                        str3 = str23;
                        str2 = str24;
                        break;
                    case 11:
                        String fromJson9 = this.stringAdapter.fromJson(reader);
                        if (fromJson9 == null) {
                            JsonDataException unexpectedNull9 = Util.unexpectedNull("providerId", "providerId", reader);
                            m.f(unexpectedNull9, "unexpectedNull(\"providerId\",\n            \"providerId\", reader)");
                            throw unexpectedNull9;
                        }
                        str11 = fromJson9;
                        uInt2 = uInt3;
                        uInt = uInt4;
                        str10 = str15;
                        str5 = str16;
                        str4 = str17;
                        str9 = str19;
                        str8 = str20;
                        str7 = str21;
                        str6 = str22;
                        str3 = str23;
                        str2 = str24;
                        break;
                    case 12:
                        str12 = this.stringAdapter.fromJson(reader);
                        if (str12 == null) {
                            JsonDataException unexpectedNull10 = Util.unexpectedNull("providerName", "providerName", reader);
                            m.f(unexpectedNull10, "unexpectedNull(\"providerName\", \"providerName\", reader)");
                            throw unexpectedNull10;
                        }
                        uInt2 = uInt3;
                        uInt = uInt4;
                        str10 = str15;
                        str5 = str16;
                        str4 = str17;
                        str11 = str18;
                        str9 = str19;
                        str8 = str20;
                        str7 = str21;
                        str6 = str22;
                        str3 = str23;
                        str2 = str24;
                        break;
                    case 13:
                        str13 = this.stringAdapter.fromJson(reader);
                        if (str13 == null) {
                            JsonDataException unexpectedNull11 = Util.unexpectedNull("providerWebsiteUrl", "providerWebsiteUrl", reader);
                            m.f(unexpectedNull11, "unexpectedNull(\"providerWebsiteUrl\", \"providerWebsiteUrl\", reader)");
                            throw unexpectedNull11;
                        }
                        uInt2 = uInt3;
                        uInt = uInt4;
                        str10 = str15;
                        str5 = str16;
                        str4 = str17;
                        str11 = str18;
                        str9 = str19;
                        str8 = str20;
                        str7 = str21;
                        str6 = str22;
                        str3 = str23;
                        str2 = str24;
                        break;
                    case 14:
                        str14 = this.stringAdapter.fromJson(reader);
                        if (str14 == null) {
                            JsonDataException unexpectedNull12 = Util.unexpectedNull("providerImageUrl", "providerImageUrl", reader);
                            m.f(unexpectedNull12, "unexpectedNull(\"providerImageUrl\", \"providerImageUrl\", reader)");
                            throw unexpectedNull12;
                        }
                        uInt2 = uInt3;
                        uInt = uInt4;
                        str10 = str15;
                        str5 = str16;
                        str4 = str17;
                        str11 = str18;
                        str9 = str19;
                        str8 = str20;
                        str7 = str21;
                        str6 = str22;
                        str3 = str23;
                        str2 = str24;
                        break;
                    case 15:
                        uInt2 = this.uIntAdapter.fromJson(reader);
                        if (uInt2 == null) {
                            JsonDataException unexpectedNull13 = Util.unexpectedNull("rateDecimals", "rateDecimals", reader);
                            m.f(unexpectedNull13, "unexpectedNull(\"rateDecimals\", \"rateDecimals\", reader)");
                            throw unexpectedNull13;
                        }
                        uInt = uInt4;
                        str10 = str15;
                        str5 = str16;
                        str4 = str17;
                        str11 = str18;
                        str9 = str19;
                        str8 = str20;
                        str7 = str21;
                        str6 = str22;
                        str3 = str23;
                        str2 = str24;
                        break;
                    default:
                        uInt2 = uInt3;
                        uInt = uInt4;
                        str10 = str15;
                        str5 = str16;
                        str4 = str17;
                        str11 = str18;
                        str9 = str19;
                        str8 = str20;
                        str7 = str21;
                        str6 = str22;
                        str3 = str23;
                        str2 = str24;
                        break;
                }
                str = str25;
            } else {
                reader.endObject();
                if (str25 == null) {
                    JsonDataException missingProperty = Util.missingProperty("id", "id", reader);
                    m.f(missingProperty, "missingProperty(\"id\", \"id\", reader)");
                    throw missingProperty;
                } else if (str24 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty(ApiConstants.NAME, ApiConstants.NAME, reader);
                    m.f(missingProperty2, "missingProperty(\"name\", \"name\", reader)");
                    throw missingProperty2;
                } else if (str23 == null) {
                    JsonDataException missingProperty3 = Util.missingProperty("code", "code", reader);
                    m.f(missingProperty3, "missingProperty(\"code\", \"code\", reader)");
                    throw missingProperty3;
                } else if (uInt4 != null) {
                    int B = uInt4.B();
                    if (str22 == null) {
                        JsonDataException missingProperty4 = Util.missingProperty("supplyBalance", "supplyBalance", reader);
                        m.f(missingProperty4, "missingProperty(\"supplyBalance\",\n            \"supplyBalance\", reader)");
                        throw missingProperty4;
                    } else if (str21 == null) {
                        JsonDataException missingProperty5 = Util.missingProperty("supplyInterestRate", "supplyInterestRate", reader);
                        m.f(missingProperty5, "missingProperty(\"supplyInterestRate\",\n            \"supplyInterestRate\", reader)");
                        throw missingProperty5;
                    } else if (str20 == null) {
                        JsonDataException missingProperty6 = Util.missingProperty("globalSuppliedAmount", "globalSuppliedAmount", reader);
                        m.f(missingProperty6, "missingProperty(\"globalSuppliedAmount\", \"globalSuppliedAmount\", reader)");
                        throw missingProperty6;
                    } else if (str19 == null) {
                        JsonDataException missingProperty7 = Util.missingProperty("utilizationRate", "utilizationRate", reader);
                        m.f(missingProperty7, "missingProperty(\"utilizationRate\",\n            \"utilizationRate\", reader)");
                        throw missingProperty7;
                    } else if (str18 == null) {
                        JsonDataException missingProperty8 = Util.missingProperty("providerId", "providerId", reader);
                        m.f(missingProperty8, "missingProperty(\"providerId\", \"providerId\", reader)");
                        throw missingProperty8;
                    } else if (str12 == null) {
                        JsonDataException missingProperty9 = Util.missingProperty("providerName", "providerName", reader);
                        m.f(missingProperty9, "missingProperty(\"providerName\", \"providerName\",\n            reader)");
                        throw missingProperty9;
                    } else if (str13 == null) {
                        JsonDataException missingProperty10 = Util.missingProperty("providerWebsiteUrl", "providerWebsiteUrl", reader);
                        m.f(missingProperty10, "missingProperty(\"providerWebsiteUrl\",\n            \"providerWebsiteUrl\", reader)");
                        throw missingProperty10;
                    } else if (str14 == null) {
                        JsonDataException missingProperty11 = Util.missingProperty("providerImageUrl", "providerImageUrl", reader);
                        m.f(missingProperty11, "missingProperty(\"providerImageUrl\",\n            \"providerImageUrl\", reader)");
                        throw missingProperty11;
                    } else if (uInt3 != null) {
                        return new LendTokenDTO(str25, str24, str23, B, str17, str16, str22, str21, str20, str19, str15, str18, str12, str13, str14, uInt3.B(), null);
                    } else {
                        JsonDataException missingProperty12 = Util.missingProperty("rateDecimals", "rateDecimals", reader);
                        m.f(missingProperty12, "missingProperty(\"rateDecimals\", \"rateDecimals\",\n            reader)");
                        throw missingProperty12;
                    }
                } else {
                    JsonDataException missingProperty13 = Util.missingProperty("decimals", "decimals", reader);
                    m.f(missingProperty13, "missingProperty(\"decimals\", \"decimals\", reader)");
                    throw missingProperty13;
                }
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, LendTokenDTO lendTokenDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(lendTokenDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("id");
        this.stringAdapter.toJson(writer, (JsonWriter) lendTokenDTO.getId());
        writer.name(ApiConstants.NAME);
        this.stringAdapter.toJson(writer, (JsonWriter) lendTokenDTO.getName());
        writer.name("code");
        this.stringAdapter.toJson(writer, (JsonWriter) lendTokenDTO.getCode());
        writer.name("decimals");
        this.uIntAdapter.toJson(writer, (JsonWriter) UInt.h(lendTokenDTO.m1585getDecimalspVg5ArA()));
        writer.name("imageUrl");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) lendTokenDTO.getImageUrl());
        writer.name(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS);
        this.nullableStringAdapter.toJson(writer, (JsonWriter) lendTokenDTO.getContractAddress());
        writer.name("supplyBalance");
        this.stringAdapter.toJson(writer, (JsonWriter) lendTokenDTO.getSupplyBalance());
        writer.name("supplyInterestRate");
        this.stringAdapter.toJson(writer, (JsonWriter) lendTokenDTO.getSupplyInterestRate());
        writer.name("globalSuppliedAmount");
        this.stringAdapter.toJson(writer, (JsonWriter) lendTokenDTO.getGlobalSuppliedAmount());
        writer.name("utilizationRate");
        this.stringAdapter.toJson(writer, (JsonWriter) lendTokenDTO.getUtilizationRate());
        writer.name("collateralRate");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) lendTokenDTO.getCollateralRate());
        writer.name("providerId");
        this.stringAdapter.toJson(writer, (JsonWriter) lendTokenDTO.getProviderId());
        writer.name("providerName");
        this.stringAdapter.toJson(writer, (JsonWriter) lendTokenDTO.getProviderName());
        writer.name("providerWebsiteUrl");
        this.stringAdapter.toJson(writer, (JsonWriter) lendTokenDTO.getProviderWebsiteUrl());
        writer.name("providerImageUrl");
        this.stringAdapter.toJson(writer, (JsonWriter) lendTokenDTO.getProviderImageUrl());
        writer.name("rateDecimals");
        this.uIntAdapter.toJson(writer, (JsonWriter) UInt.h(lendTokenDTO.m1586getRateDecimalspVg5ArA()));
        writer.endObject();
    }
}