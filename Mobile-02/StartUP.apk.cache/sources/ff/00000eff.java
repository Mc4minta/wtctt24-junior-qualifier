package com.coinbase.android.apiv3.generated.resources;

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
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: PaymentMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!BC\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJI\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001a\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u001c\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u001e\u0010\u000f¨\u0006\""}, d2 = {"Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "id", "type", MessageBundle.TITLE_ENTRY, "subtitle", "image_url", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "Ljava/lang/String;", "getTitle", "getType", "getImage_url", "getSubtitle", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PaymentMethod extends a {
    public static final ProtoAdapter<PaymentMethod> ADAPTER;
    public static final Parcelable.Creator<PaymentMethod> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String id;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "imageUrl", tag = 5)
    private final String image_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    private final String subtitle;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String title;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String type;

    /* compiled from: PaymentMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        final c cVar = c.LENGTH_DELIMITED;
        final d b2 = e0.b(PaymentMethod.class);
        ProtoAdapter<PaymentMethod> protoAdapter = new ProtoAdapter<PaymentMethod>(cVar, b2, "type.googleapis.com/coinbase.public_api.resources.PaymentMethod") { // from class: com.coinbase.android.apiv3.generated.resources.PaymentMethod$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PaymentMethod decode(k reader) {
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
                        return new PaymentMethod(str, str2, str3, str4, str5, reader.e(d2));
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
            public void encode(l writer, PaymentMethod value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getId(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getId());
                }
                if (!m.c(value.getType(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getType());
                }
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getTitle());
                }
                if (!m.c(value.getSubtitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getSubtitle());
                }
                if (!m.c(value.getImage_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getImage_url());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(PaymentMethod value) {
                m.h(value, "value");
                if (m.c(value.getId(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getId());
                if (!m.c(value.getType(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getType());
                    if (!m.c(value.getTitle(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getTitle());
                        if (!m.c(value.getSubtitle(), "")) {
                            r2 = (m.c(value.getImage_url(), "") ? 0 : protoAdapter2.encodedSizeWithTag(5, value.getImage_url()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(4, value.getSubtitle());
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public PaymentMethod redact(PaymentMethod value) {
                m.h(value, "value");
                return PaymentMethod.copy$default(value, null, null, null, null, null, i.a, 31, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public PaymentMethod() {
        this(null, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ PaymentMethod(String str, String str2, String str3, String str4, String str5, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) == 0 ? str5 : "", (i2 & 32) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ PaymentMethod copy$default(PaymentMethod paymentMethod, String str, String str2, String str3, String str4, String str5, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = paymentMethod.id;
        }
        if ((i2 & 2) != 0) {
            str2 = paymentMethod.type;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = paymentMethod.title;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = paymentMethod.subtitle;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = paymentMethod.image_url;
        }
        String str9 = str5;
        if ((i2 & 32) != 0) {
            iVar = paymentMethod.unknownFields();
        }
        return paymentMethod.copy(str, str6, str7, str8, str9, iVar);
    }

    public final PaymentMethod copy(String id, String type, String title, String subtitle, String image_url, i unknownFields) {
        m.h(id, "id");
        m.h(type, "type");
        m.h(title, "title");
        m.h(subtitle, "subtitle");
        m.h(image_url, "image_url");
        m.h(unknownFields, "unknownFields");
        return new PaymentMethod(id, type, title, subtitle, image_url, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PaymentMethod) {
            PaymentMethod paymentMethod = (PaymentMethod) obj;
            return m.c(unknownFields(), paymentMethod.unknownFields()) && m.c(this.id, paymentMethod.id) && m.c(this.type, paymentMethod.type) && m.c(this.title, paymentMethod.title) && m.c(this.subtitle, paymentMethod.subtitle) && m.c(this.image_url, paymentMethod.image_url);
        }
        return false;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37) + this.type.hashCode()) * 37) + this.title.hashCode()) * 37) + this.subtitle.hashCode()) * 37) + this.image_url.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m534newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("id=" + b.c(this.id));
        arrayList.add("type=" + b.c(this.type));
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("subtitle=" + b.c(this.subtitle));
        arrayList.add("image_url=" + b.c(this.image_url));
        h0 = z.h0(arrayList, ", ", "PaymentMethod{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentMethod(String id, String type, String title, String subtitle, String image_url, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(id, "id");
        m.h(type, "type");
        m.h(title, "title");
        m.h(subtitle, "subtitle");
        m.h(image_url, "image_url");
        m.h(unknownFields, "unknownFields");
        this.id = id;
        this.type = type;
        this.title = title;
        this.subtitle = subtitle;
        this.image_url = image_url;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m534newBuilder() {
        throw new AssertionError();
    }
}