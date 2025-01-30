package com.coinbase.android.apiv3.generated.authed.card;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.a;
import com.squareup.wire.c;
import com.squareup.wire.g;
import com.squareup.wire.k;
import com.squareup.wire.l;
import com.squareup.wire.p;
import com.squareup.wire.q.b;
import j.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: ApplicationInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!BC\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJI\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u001a\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001c\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b\u001e\u0010\u000f¨\u0006\""}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/ApplicationInfo;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "street_address", "apartment_number", "zip_code", "city", ApiConstants.STATE, "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/card/ApplicationInfo;", "Ljava/lang/String;", "getState", "getStreet_address", "getApartment_number", "getZip_code", "getCity", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class ApplicationInfo extends a {
    public static final ProtoAdapter<ApplicationInfo> ADAPTER;
    public static final Parcelable.Creator<ApplicationInfo> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "apartmentNumber", tag = 2)
    private final String apartment_number;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    private final String city;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    private final String state;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "streetAddress", tag = 1)
    private final String street_address;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "zipCode", tag = 3)
    private final String zip_code;

    /* compiled from: ApplicationInfo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/ApplicationInfo$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/card/ApplicationInfo;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<ApplicationInfo> protoAdapter = new ProtoAdapter<ApplicationInfo>(c.LENGTH_DELIMITED, e0.b(ApplicationInfo.class), "type.googleapis.com/coinbase.public_api.authed.card.ApplicationInfo") { // from class: com.coinbase.android.apiv3.generated.authed.card.ApplicationInfo$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ApplicationInfo decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new ApplicationInfo(str, str2, str3, str4, str5, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 3) {
                        str3 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 4) {
                        str4 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 5) {
                        reader.m(g2);
                    } else {
                        str5 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, ApplicationInfo value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getStreet_address(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getStreet_address());
                }
                if (!m.c(value.getApartment_number(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getApartment_number());
                }
                if (!m.c(value.getZip_code(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getZip_code());
                }
                if (!m.c(value.getCity(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getCity());
                }
                if (!m.c(value.getState(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getState());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(ApplicationInfo value) {
                m.h(value, "value");
                if (m.c(value.getStreet_address(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getStreet_address());
                if (!m.c(value.getApartment_number(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getApartment_number());
                    if (!m.c(value.getZip_code(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getZip_code());
                        if (!m.c(value.getCity(), "")) {
                            r2 = (m.c(value.getState(), "") ? 0 : protoAdapter2.encodedSizeWithTag(5, value.getState()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(4, value.getCity());
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public ApplicationInfo redact(ApplicationInfo value) {
                m.h(value, "value");
                return ApplicationInfo.copy$default(value, null, null, null, null, null, i.a, 31, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public ApplicationInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ ApplicationInfo(String str, String str2, String str3, String str4, String str5, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) == 0 ? str5 : "", (i2 & 32) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ ApplicationInfo copy$default(ApplicationInfo applicationInfo, String str, String str2, String str3, String str4, String str5, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = applicationInfo.street_address;
        }
        if ((i2 & 2) != 0) {
            str2 = applicationInfo.apartment_number;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = applicationInfo.zip_code;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = applicationInfo.city;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = applicationInfo.state;
        }
        String str9 = str5;
        if ((i2 & 32) != 0) {
            iVar = applicationInfo.unknownFields();
        }
        return applicationInfo.copy(str, str6, str7, str8, str9, iVar);
    }

    public final ApplicationInfo copy(String street_address, String apartment_number, String zip_code, String city, String state, i unknownFields) {
        m.h(street_address, "street_address");
        m.h(apartment_number, "apartment_number");
        m.h(zip_code, "zip_code");
        m.h(city, "city");
        m.h(state, "state");
        m.h(unknownFields, "unknownFields");
        return new ApplicationInfo(street_address, apartment_number, zip_code, city, state, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ApplicationInfo) {
            ApplicationInfo applicationInfo = (ApplicationInfo) obj;
            return m.c(unknownFields(), applicationInfo.unknownFields()) && m.c(this.street_address, applicationInfo.street_address) && m.c(this.apartment_number, applicationInfo.apartment_number) && m.c(this.zip_code, applicationInfo.zip_code) && m.c(this.city, applicationInfo.city) && m.c(this.state, applicationInfo.state);
        }
        return false;
    }

    public final String getApartment_number() {
        return this.apartment_number;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getState() {
        return this.state;
    }

    public final String getStreet_address() {
        return this.street_address;
    }

    public final String getZip_code() {
        return this.zip_code;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((((unknownFields().hashCode() * 37) + this.street_address.hashCode()) * 37) + this.apartment_number.hashCode()) * 37) + this.zip_code.hashCode()) * 37) + this.city.hashCode()) * 37) + this.state.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m295newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("street_address=" + b.c(this.street_address));
        arrayList.add("apartment_number=" + b.c(this.apartment_number));
        arrayList.add("zip_code=" + b.c(this.zip_code));
        arrayList.add("city=" + b.c(this.city));
        arrayList.add("state=" + b.c(this.state));
        h0 = z.h0(arrayList, ", ", "ApplicationInfo{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationInfo(String street_address, String apartment_number, String zip_code, String city, String state, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(street_address, "street_address");
        m.h(apartment_number, "apartment_number");
        m.h(zip_code, "zip_code");
        m.h(city, "city");
        m.h(state, "state");
        m.h(unknownFields, "unknownFields");
        this.street_address = street_address;
        this.apartment_number = apartment_number;
        this.zip_code = zip_code;
        this.city = city;
        this.state = state;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m295newBuilder() {
        throw new AssertionError();
    }
}