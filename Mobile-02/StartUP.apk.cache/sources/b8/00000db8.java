package com.coinbase.android.apiv3.generated.authed.personalized_assets;

import android.os.Parcelable;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: GetPersonalizedAssetsResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'BS\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJY\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001c\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010\u0017\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u001c\u001a\u0004\b \u0010\u000fR\u001c\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b!\u0010\u000fR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/personalized_assets/GetPersonalizedAssetsResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", MessageBundle.TITLE_ENTRY, "", "Lcom/coinbase/android/apiv3/generated/authed/personalized_assets/PersonalizedAsset;", "personalized_assets", "carousel_type", "carousel_request_id", "split_test", "treatment_group", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/personalized_assets/GetPersonalizedAssetsResponse;", "Ljava/lang/String;", "getTitle", "getCarousel_type", "getSplit_test", "getTreatment_group", "getCarousel_request_id", "Ljava/util/List;", "getPersonalized_assets", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetPersonalizedAssetsResponse extends a {
    public static final ProtoAdapter<GetPersonalizedAssetsResponse> ADAPTER;
    public static final Parcelable.Creator<GetPersonalizedAssetsResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "carouselRequestId", tag = 4)
    private final String carousel_request_id;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "carouselType", tag = 3)
    private final String carousel_type;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.personalized_assets.PersonalizedAsset#ADAPTER", jsonName = "personalizedAssets", label = p.a.REPEATED, tag = 2)
    private final List<PersonalizedAsset> personalized_assets;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "splitTest", tag = 5)
    private final String split_test;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String title;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "treatmentGroup", tag = 6)
    private final String treatment_group;

    /* compiled from: GetPersonalizedAssetsResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/personalized_assets/GetPersonalizedAssetsResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/personalized_assets/GetPersonalizedAssetsResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetPersonalizedAssetsResponse> protoAdapter = new ProtoAdapter<GetPersonalizedAssetsResponse>(c.LENGTH_DELIMITED, e0.b(GetPersonalizedAssetsResponse.class), "type.googleapis.com/coinbase.public_api.authed.personalized_assets.GetPersonalizedAssetsResponse") { // from class: com.coinbase.android.apiv3.generated.authed.personalized_assets.GetPersonalizedAssetsResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetPersonalizedAssetsResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                String str = "";
                String str2 = "";
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetPersonalizedAssetsResponse(str, arrayList, str2, str3, str4, str5, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            arrayList.add(PersonalizedAsset.ADAPTER.decode(reader));
                            break;
                        case 3:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetPersonalizedAssetsResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getTitle());
                }
                PersonalizedAsset.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.getPersonalized_assets());
                if (!m.c(value.getCarousel_type(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getCarousel_type());
                }
                if (!m.c(value.getCarousel_request_id(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getCarousel_request_id());
                }
                if (!m.c(value.getSplit_test(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getSplit_test());
                }
                if (!m.c(value.getTreatment_group(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getTreatment_group());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetPersonalizedAssetsResponse value) {
                m.h(value, "value");
                if (m.c(value.getTitle(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getTitle()) + PersonalizedAsset.ADAPTER.asRepeated().encodedSizeWithTag(2, value.getPersonalized_assets());
                if (!m.c(value.getCarousel_type(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(3, value.getCarousel_type());
                    if (!m.c(value.getCarousel_request_id(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(4, value.getCarousel_request_id());
                        if (!m.c(value.getSplit_test(), "")) {
                            r2 = (m.c(value.getTreatment_group(), "") ? 0 : protoAdapter2.encodedSizeWithTag(6, value.getTreatment_group()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(5, value.getSplit_test());
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetPersonalizedAssetsResponse redact(GetPersonalizedAssetsResponse value) {
                m.h(value, "value");
                return GetPersonalizedAssetsResponse.copy$default(value, null, b.a(value.getPersonalized_assets(), PersonalizedAsset.ADAPTER), null, null, null, null, i.a, 61, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetPersonalizedAssetsResponse() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public /* synthetic */ GetPersonalizedAssetsResponse(String str, List list, String str2, String str3, String str4, String str5, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? r.g() : list, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) == 0 ? str5 : "", (i2 & 64) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetPersonalizedAssetsResponse copy$default(GetPersonalizedAssetsResponse getPersonalizedAssetsResponse, String str, List list, String str2, String str3, String str4, String str5, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = getPersonalizedAssetsResponse.title;
        }
        List<PersonalizedAsset> list2 = list;
        if ((i2 & 2) != 0) {
            list2 = getPersonalizedAssetsResponse.personalized_assets;
        }
        List list3 = list2;
        if ((i2 & 4) != 0) {
            str2 = getPersonalizedAssetsResponse.carousel_type;
        }
        String str6 = str2;
        if ((i2 & 8) != 0) {
            str3 = getPersonalizedAssetsResponse.carousel_request_id;
        }
        String str7 = str3;
        if ((i2 & 16) != 0) {
            str4 = getPersonalizedAssetsResponse.split_test;
        }
        String str8 = str4;
        if ((i2 & 32) != 0) {
            str5 = getPersonalizedAssetsResponse.treatment_group;
        }
        String str9 = str5;
        if ((i2 & 64) != 0) {
            iVar = getPersonalizedAssetsResponse.unknownFields();
        }
        return getPersonalizedAssetsResponse.copy(str, list3, str6, str7, str8, str9, iVar);
    }

    public final GetPersonalizedAssetsResponse copy(String title, List<PersonalizedAsset> personalized_assets, String carousel_type, String carousel_request_id, String split_test, String treatment_group, i unknownFields) {
        m.h(title, "title");
        m.h(personalized_assets, "personalized_assets");
        m.h(carousel_type, "carousel_type");
        m.h(carousel_request_id, "carousel_request_id");
        m.h(split_test, "split_test");
        m.h(treatment_group, "treatment_group");
        m.h(unknownFields, "unknownFields");
        return new GetPersonalizedAssetsResponse(title, personalized_assets, carousel_type, carousel_request_id, split_test, treatment_group, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetPersonalizedAssetsResponse) {
            GetPersonalizedAssetsResponse getPersonalizedAssetsResponse = (GetPersonalizedAssetsResponse) obj;
            return m.c(unknownFields(), getPersonalizedAssetsResponse.unknownFields()) && m.c(this.title, getPersonalizedAssetsResponse.title) && m.c(this.personalized_assets, getPersonalizedAssetsResponse.personalized_assets) && m.c(this.carousel_type, getPersonalizedAssetsResponse.carousel_type) && m.c(this.carousel_request_id, getPersonalizedAssetsResponse.carousel_request_id) && m.c(this.split_test, getPersonalizedAssetsResponse.split_test) && m.c(this.treatment_group, getPersonalizedAssetsResponse.treatment_group);
        }
        return false;
    }

    public final String getCarousel_request_id() {
        return this.carousel_request_id;
    }

    public final String getCarousel_type() {
        return this.carousel_type;
    }

    public final List<PersonalizedAsset> getPersonalized_assets() {
        return this.personalized_assets;
    }

    public final String getSplit_test() {
        return this.split_test;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTreatment_group() {
        return this.treatment_group;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((((((unknownFields().hashCode() * 37) + this.title.hashCode()) * 37) + this.personalized_assets.hashCode()) * 37) + this.carousel_type.hashCode()) * 37) + this.carousel_request_id.hashCode()) * 37) + this.split_test.hashCode()) * 37) + this.treatment_group.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m441newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("title=" + b.c(this.title));
        if (!this.personalized_assets.isEmpty()) {
            arrayList.add("personalized_assets=" + this.personalized_assets);
        }
        arrayList.add("carousel_type=" + b.c(this.carousel_type));
        arrayList.add("carousel_request_id=" + b.c(this.carousel_request_id));
        arrayList.add("split_test=" + b.c(this.split_test));
        arrayList.add("treatment_group=" + b.c(this.treatment_group));
        h0 = z.h0(arrayList, ", ", "GetPersonalizedAssetsResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m441newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetPersonalizedAssetsResponse(String title, List<PersonalizedAsset> personalized_assets, String carousel_type, String carousel_request_id, String split_test, String treatment_group, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(title, "title");
        m.h(personalized_assets, "personalized_assets");
        m.h(carousel_type, "carousel_type");
        m.h(carousel_request_id, "carousel_request_id");
        m.h(split_test, "split_test");
        m.h(treatment_group, "treatment_group");
        m.h(unknownFields, "unknownFields");
        this.title = title;
        this.personalized_assets = personalized_assets;
        this.carousel_type = carousel_type;
        this.carousel_request_id = carousel_request_id;
        this.split_test = split_test;
        this.treatment_group = treatment_group;
    }
}