package com.coinbase.android.apiv3.generated.authed.sends;

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
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: ToDetails.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(BM\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJS\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0016\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b%\u0010\u000f¨\u0006)"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/sends/ToDetails;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "display_value", "actual_value", "destination_tag", "image_url", "Lcom/coinbase/android/apiv3/generated/authed/sends/RecipientType;", "type", "coinbase_account", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/sends/RecipientType;ZLj/i;)Lcom/coinbase/android/apiv3/generated/authed/sends/ToDetails;", "Ljava/lang/String;", "getDisplay_value", "getImage_url", "getDestination_tag", "Lcom/coinbase/android/apiv3/generated/authed/sends/RecipientType;", "getType", "()Lcom/coinbase/android/apiv3/generated/authed/sends/RecipientType;", "Z", "getCoinbase_account", "()Z", "getActual_value", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/sends/RecipientType;ZLj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class ToDetails extends a {
    public static final ProtoAdapter<ToDetails> ADAPTER;
    public static final Parcelable.Creator<ToDetails> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "actualValue", tag = 2)
    private final String actual_value;
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "coinbaseAccount", tag = 6)
    private final boolean coinbase_account;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "destinationTag", tag = 3)
    private final String destination_tag;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "displayValue", tag = 1)
    private final String display_value;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "imageUrl", tag = 4)
    private final String image_url;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.sends.RecipientType#ADAPTER", tag = 5)
    private final RecipientType type;

    /* compiled from: ToDetails.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/sends/ToDetails$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/sends/ToDetails;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<ToDetails> protoAdapter = new ProtoAdapter<ToDetails>(c.LENGTH_DELIMITED, e0.b(ToDetails.class), "type.googleapis.com/coinbase.public_api.authed.sends.ToDetails") { // from class: com.coinbase.android.apiv3.generated.authed.sends.ToDetails$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ToDetails decode(k reader) {
                m.h(reader, "reader");
                RecipientType recipientType = RecipientType.ADDRESS;
                long d2 = reader.d();
                RecipientType recipientType2 = recipientType;
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                boolean z = false;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new ToDetails(str, str2, str3, str4, recipientType2, z, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            try {
                                recipientType2 = RecipientType.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                                break;
                            }
                        case 6:
                            z = ProtoAdapter.BOOL.decode(reader).booleanValue();
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, ToDetails value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getDisplay_value(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getDisplay_value());
                }
                if (!m.c(value.getActual_value(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getActual_value());
                }
                if (!m.c(value.getDestination_tag(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getDestination_tag());
                }
                if (!m.c(value.getImage_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getImage_url());
                }
                if (value.getType() != RecipientType.ADDRESS) {
                    RecipientType.ADAPTER.encodeWithTag(writer, 5, value.getType());
                }
                if (value.getCoinbase_account()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 6, Boolean.valueOf(value.getCoinbase_account()));
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(ToDetails value) {
                m.h(value, "value");
                if (m.c(value.getDisplay_value(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getDisplay_value());
                if (!m.c(value.getActual_value(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getActual_value());
                    if (!m.c(value.getDestination_tag(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getDestination_tag());
                        if (!m.c(value.getImage_url(), "")) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getImage_url());
                            if (value.getType() != RecipientType.ADDRESS) {
                                r2 = (value.getCoinbase_account() ? ProtoAdapter.BOOL.encodedSizeWithTag(6, Boolean.valueOf(value.getCoinbase_account())) + value.unknownFields().Q() : 0) + RecipientType.ADAPTER.encodedSizeWithTag(5, value.getType());
                            }
                            r2 += encodedSizeWithTag4;
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public ToDetails redact(ToDetails value) {
                m.h(value, "value");
                return ToDetails.copy$default(value, null, null, null, null, null, false, i.a, 63, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public ToDetails() {
        this(null, null, null, null, null, false, null, 127, null);
    }

    public /* synthetic */ ToDetails(String str, String str2, String str3, String str4, RecipientType recipientType, boolean z, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) == 0 ? str4 : "", (i2 & 16) != 0 ? RecipientType.ADDRESS : recipientType, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ ToDetails copy$default(ToDetails toDetails, String str, String str2, String str3, String str4, RecipientType recipientType, boolean z, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = toDetails.display_value;
        }
        if ((i2 & 2) != 0) {
            str2 = toDetails.actual_value;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = toDetails.destination_tag;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = toDetails.image_url;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            recipientType = toDetails.type;
        }
        RecipientType recipientType2 = recipientType;
        if ((i2 & 32) != 0) {
            z = toDetails.coinbase_account;
        }
        boolean z2 = z;
        if ((i2 & 64) != 0) {
            iVar = toDetails.unknownFields();
        }
        return toDetails.copy(str, str5, str6, str7, recipientType2, z2, iVar);
    }

    public final ToDetails copy(String display_value, String actual_value, String destination_tag, String image_url, RecipientType type, boolean z, i unknownFields) {
        m.h(display_value, "display_value");
        m.h(actual_value, "actual_value");
        m.h(destination_tag, "destination_tag");
        m.h(image_url, "image_url");
        m.h(type, "type");
        m.h(unknownFields, "unknownFields");
        return new ToDetails(display_value, actual_value, destination_tag, image_url, type, z, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ToDetails) {
            ToDetails toDetails = (ToDetails) obj;
            return m.c(unknownFields(), toDetails.unknownFields()) && m.c(this.display_value, toDetails.display_value) && m.c(this.actual_value, toDetails.actual_value) && m.c(this.destination_tag, toDetails.destination_tag) && m.c(this.image_url, toDetails.image_url) && this.type == toDetails.type && this.coinbase_account == toDetails.coinbase_account;
        }
        return false;
    }

    public final String getActual_value() {
        return this.actual_value;
    }

    public final boolean getCoinbase_account() {
        return this.coinbase_account;
    }

    public final String getDestination_tag() {
        return this.destination_tag;
    }

    public final String getDisplay_value() {
        return this.display_value;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final RecipientType getType() {
        return this.type;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((((((unknownFields().hashCode() * 37) + this.display_value.hashCode()) * 37) + this.actual_value.hashCode()) * 37) + this.destination_tag.hashCode()) * 37) + this.image_url.hashCode()) * 37) + this.type.hashCode()) * 37) + com.coinbase.android.apiv3.generated.authed.a.a(this.coinbase_account);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m470newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("display_value=" + b.c(this.display_value));
        arrayList.add("actual_value=" + b.c(this.actual_value));
        arrayList.add("destination_tag=" + b.c(this.destination_tag));
        arrayList.add("image_url=" + b.c(this.image_url));
        arrayList.add("type=" + this.type);
        arrayList.add("coinbase_account=" + this.coinbase_account);
        h0 = z.h0(arrayList, ", ", "ToDetails{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m470newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToDetails(String display_value, String actual_value, String destination_tag, String image_url, RecipientType type, boolean z, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(display_value, "display_value");
        m.h(actual_value, "actual_value");
        m.h(destination_tag, "destination_tag");
        m.h(image_url, "image_url");
        m.h(type, "type");
        m.h(unknownFields, "unknownFields");
        this.display_value = display_value;
        this.actual_value = actual_value;
        this.destination_tag = destination_tag;
        this.image_url = image_url;
        this.type = type;
        this.coinbase_account = z;
    }
}