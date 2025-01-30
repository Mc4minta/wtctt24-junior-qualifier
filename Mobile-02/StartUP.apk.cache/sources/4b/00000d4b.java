package com.coinbase.android.apiv3.generated.authed.loyalty;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Button;
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

/* compiled from: LoyaltyCardModal.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B?\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001b\u0010\u000fR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b \u0010\u000f¨\u0006$"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardModal;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", MessageBundle.TITLE_ENTRY, "body", "image_url", "", "Lcom/coinbase/android/apiv3/generated/common/Button;", "buttons", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardModal;", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getButtons", "()Ljava/util/List;", "getBody", "getImage_url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class LoyaltyCardModal extends a {
    public static final ProtoAdapter<LoyaltyCardModal> ADAPTER;
    public static final Parcelable.Creator<LoyaltyCardModal> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String body;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Button#ADAPTER", label = p.a.REPEATED, tag = 4)
    private final List<Button> buttons;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "imageUrl", tag = 3)
    private final String image_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String title;

    /* compiled from: LoyaltyCardModal.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardModal$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardModal;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<LoyaltyCardModal> protoAdapter = new ProtoAdapter<LoyaltyCardModal>(c.LENGTH_DELIMITED, e0.b(LoyaltyCardModal.class), "type.googleapis.com/coinbase.public_api.authed.loyalty.LoyaltyCardModal") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyCardModal$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LoyaltyCardModal decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                String str = "";
                String str2 = "";
                String str3 = str2;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new LoyaltyCardModal(str, str2, str3, arrayList, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 3) {
                        str3 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 4) {
                        reader.m(g2);
                    } else {
                        arrayList.add(Button.ADAPTER.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, LoyaltyCardModal value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getTitle());
                }
                if (!m.c(value.getBody(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getBody());
                }
                if (!m.c(value.getImage_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getImage_url());
                }
                Button.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.getButtons());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(LoyaltyCardModal value) {
                m.h(value, "value");
                if (m.c(value.getTitle(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getTitle());
                if (!m.c(value.getBody(), "")) {
                    r2 = (m.c(value.getImage_url(), "") ? 0 : protoAdapter2.encodedSizeWithTag(3, value.getImage_url()) + Button.ADAPTER.asRepeated().encodedSizeWithTag(4, value.getButtons()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(2, value.getBody());
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public LoyaltyCardModal redact(LoyaltyCardModal value) {
                m.h(value, "value");
                return LoyaltyCardModal.copy$default(value, null, null, null, b.a(value.getButtons(), Button.ADAPTER), i.a, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public LoyaltyCardModal() {
        this(null, null, null, null, null, 31, null);
    }

    public /* synthetic */ LoyaltyCardModal(String str, String str2, String str3, List list, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) == 0 ? str3 : "", (i2 & 8) != 0 ? r.g() : list, (i2 & 16) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ LoyaltyCardModal copy$default(LoyaltyCardModal loyaltyCardModal, String str, String str2, String str3, List list, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = loyaltyCardModal.title;
        }
        if ((i2 & 2) != 0) {
            str2 = loyaltyCardModal.body;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = loyaltyCardModal.image_url;
        }
        String str5 = str3;
        List<Button> list2 = list;
        if ((i2 & 8) != 0) {
            list2 = loyaltyCardModal.buttons;
        }
        List list3 = list2;
        if ((i2 & 16) != 0) {
            iVar = loyaltyCardModal.unknownFields();
        }
        return loyaltyCardModal.copy(str, str4, str5, list3, iVar);
    }

    public final LoyaltyCardModal copy(String title, String body, String image_url, List<Button> buttons, i unknownFields) {
        m.h(title, "title");
        m.h(body, "body");
        m.h(image_url, "image_url");
        m.h(buttons, "buttons");
        m.h(unknownFields, "unknownFields");
        return new LoyaltyCardModal(title, body, image_url, buttons, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LoyaltyCardModal) {
            LoyaltyCardModal loyaltyCardModal = (LoyaltyCardModal) obj;
            return m.c(unknownFields(), loyaltyCardModal.unknownFields()) && m.c(this.title, loyaltyCardModal.title) && m.c(this.body, loyaltyCardModal.body) && m.c(this.image_url, loyaltyCardModal.image_url) && m.c(this.buttons, loyaltyCardModal.buttons);
        }
        return false;
    }

    public final String getBody() {
        return this.body;
    }

    public final List<Button> getButtons() {
        return this.buttons;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((unknownFields().hashCode() * 37) + this.title.hashCode()) * 37) + this.body.hashCode()) * 37) + this.image_url.hashCode()) * 37) + this.buttons.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m413newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("body=" + b.c(this.body));
        arrayList.add("image_url=" + b.c(this.image_url));
        if (!this.buttons.isEmpty()) {
            arrayList.add("buttons=" + this.buttons);
        }
        h0 = z.h0(arrayList, ", ", "LoyaltyCardModal{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m413newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoyaltyCardModal(String title, String body, String image_url, List<Button> buttons, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(title, "title");
        m.h(body, "body");
        m.h(image_url, "image_url");
        m.h(buttons, "buttons");
        m.h(unknownFields, "unknownFields");
        this.title = title;
        this.body = body;
        this.image_url = image_url;
        this.buttons = buttons;
    }
}