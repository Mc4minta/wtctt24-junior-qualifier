package com.coinbase.android.apiv3.generated.common;

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

/* compiled from: Button.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B9\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ?\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b\u001a\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001f\u0010\u000f¨\u0006#"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/Button;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/common/ButtonStyle;", "style", "icon_url", "label", "url", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/common/ButtonStyle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/common/Button;", "Ljava/lang/String;", "getLabel", "getUrl", "Lcom/coinbase/android/apiv3/generated/common/ButtonStyle;", "getStyle", "()Lcom/coinbase/android/apiv3/generated/common/ButtonStyle;", "getIcon_url", "<init>", "(Lcom/coinbase/android/apiv3/generated/common/ButtonStyle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Button extends a {
    public static final ProtoAdapter<Button> ADAPTER;
    public static final Parcelable.Creator<Button> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "iconUrl", tag = 2)
    private final String icon_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String label;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.ButtonStyle#ADAPTER", tag = 1)
    private final ButtonStyle style;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    private final String url;

    /* compiled from: Button.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/Button$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/common/Button;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<Button> protoAdapter = new ProtoAdapter<Button>(c.LENGTH_DELIMITED, e0.b(Button.class), "type.googleapis.com/coinbase.public_api.common.Button") { // from class: com.coinbase.android.apiv3.generated.common.Button$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Button decode(k reader) {
                m.h(reader, "reader");
                ButtonStyle buttonStyle = ButtonStyle.PRIMARY;
                long d2 = reader.d();
                ButtonStyle buttonStyle2 = buttonStyle;
                String str = "";
                String str2 = str;
                String str3 = str2;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new Button(buttonStyle2, str, str2, str3, reader.e(d2));
                    }
                    if (g2 == 1) {
                        try {
                            buttonStyle2 = ButtonStyle.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                            reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                        }
                    } else if (g2 == 2) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 3) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 4) {
                        reader.m(g2);
                    } else {
                        str3 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, Button value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getStyle() != ButtonStyle.PRIMARY) {
                    ButtonStyle.ADAPTER.encodeWithTag(writer, 1, value.getStyle());
                }
                if (!m.c(value.getIcon_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getIcon_url());
                }
                if (!m.c(value.getLabel(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getLabel());
                }
                if (!m.c(value.getUrl(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getUrl());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Button value) {
                m.h(value, "value");
                if (value.getStyle() == ButtonStyle.PRIMARY) {
                    return 0;
                }
                int encodedSizeWithTag = ButtonStyle.ADAPTER.encodedSizeWithTag(1, value.getStyle());
                if (!m.c(value.getIcon_url(), "")) {
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getIcon_url());
                    if (!m.c(value.getLabel(), "")) {
                        r2 = (m.c(value.getUrl(), "") ? 0 : protoAdapter2.encodedSizeWithTag(4, value.getUrl()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(3, value.getLabel());
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Button redact(Button value) {
                m.h(value, "value");
                return Button.copy$default(value, null, null, null, null, i.a, 15, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public Button() {
        this(null, null, null, null, null, 31, null);
    }

    public /* synthetic */ Button(ButtonStyle buttonStyle, String str, String str2, String str3, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? ButtonStyle.PRIMARY : buttonStyle, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) == 0 ? str3 : "", (i2 & 16) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ Button copy$default(Button button, ButtonStyle buttonStyle, String str, String str2, String str3, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            buttonStyle = button.style;
        }
        if ((i2 & 2) != 0) {
            str = button.icon_url;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            str2 = button.label;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            str3 = button.url;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            iVar = button.unknownFields();
        }
        return button.copy(buttonStyle, str4, str5, str6, iVar);
    }

    public final Button copy(ButtonStyle style, String icon_url, String label, String url, i unknownFields) {
        m.h(style, "style");
        m.h(icon_url, "icon_url");
        m.h(label, "label");
        m.h(url, "url");
        m.h(unknownFields, "unknownFields");
        return new Button(style, icon_url, label, url, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Button) {
            Button button = (Button) obj;
            return m.c(unknownFields(), button.unknownFields()) && this.style == button.style && m.c(this.icon_url, button.icon_url) && m.c(this.label, button.label) && m.c(this.url, button.url);
        }
        return false;
    }

    public final String getIcon_url() {
        return this.icon_url;
    }

    public final String getLabel() {
        return this.label;
    }

    public final ButtonStyle getStyle() {
        return this.style;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((unknownFields().hashCode() * 37) + this.style.hashCode()) * 37) + this.icon_url.hashCode()) * 37) + this.label.hashCode()) * 37) + this.url.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m505newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("style=" + this.style);
        arrayList.add("icon_url=" + b.c(this.icon_url));
        arrayList.add("label=" + b.c(this.label));
        arrayList.add("url=" + b.c(this.url));
        h0 = z.h0(arrayList, ", ", "Button{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m505newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Button(ButtonStyle style, String icon_url, String label, String url, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(style, "style");
        m.h(icon_url, "icon_url");
        m.h(label, "label");
        m.h(url, "url");
        m.h(unknownFields, "unknownFields");
        this.style = style;
        this.icon_url = icon_url;
        this.label = label;
        this.url = url;
    }
}