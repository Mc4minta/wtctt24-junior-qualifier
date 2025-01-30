package com.coinbase.android.apiv3.generated.common;

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
import org.spongycastle.i18n.MessageBundle;

/* compiled from: Tooltip.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B/\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u001c\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001d\u0010\u000f¨\u0006!"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/Tooltip;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/common/TooltipStyle;", "style", MessageBundle.TITLE_ENTRY, ApiConstants.DESCRIPTION, "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/common/TooltipStyle;Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/common/Tooltip;", "Lcom/coinbase/android/apiv3/generated/common/TooltipStyle;", "getStyle", "()Lcom/coinbase/android/apiv3/generated/common/TooltipStyle;", "Ljava/lang/String;", "getTitle", "getDescription", "<init>", "(Lcom/coinbase/android/apiv3/generated/common/TooltipStyle;Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Tooltip extends a {
    public static final ProtoAdapter<Tooltip> ADAPTER;
    public static final Parcelable.Creator<Tooltip> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String description;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.TooltipStyle#ADAPTER", tag = 1)
    private final TooltipStyle style;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String title;

    /* compiled from: Tooltip.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/Tooltip$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/common/Tooltip;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<Tooltip> protoAdapter = new ProtoAdapter<Tooltip>(c.LENGTH_DELIMITED, e0.b(Tooltip.class), "type.googleapis.com/coinbase.public_api.common.Tooltip") { // from class: com.coinbase.android.apiv3.generated.common.Tooltip$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Tooltip decode(k reader) {
                m.h(reader, "reader");
                TooltipStyle tooltipStyle = TooltipStyle.STANDARD;
                long d2 = reader.d();
                String str = "";
                String str2 = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new Tooltip(tooltipStyle, str, str2, reader.e(d2));
                    }
                    if (g2 == 1) {
                        try {
                            tooltipStyle = TooltipStyle.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                            reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                        }
                    } else if (g2 == 2) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, Tooltip value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getStyle() != TooltipStyle.STANDARD) {
                    TooltipStyle.ADAPTER.encodeWithTag(writer, 1, value.getStyle());
                }
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getTitle());
                }
                if (!m.c(value.getDescription(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getDescription());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Tooltip value) {
                m.h(value, "value");
                if (value.getStyle() == TooltipStyle.STANDARD) {
                    return 0;
                }
                int encodedSizeWithTag = TooltipStyle.ADAPTER.encodedSizeWithTag(1, value.getStyle());
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    r2 = (m.c(value.getDescription(), "") ? 0 : protoAdapter2.encodedSizeWithTag(3, value.getDescription()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(2, value.getTitle());
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Tooltip redact(Tooltip value) {
                m.h(value, "value");
                return Tooltip.copy$default(value, null, null, null, i.a, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public Tooltip() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ Tooltip(TooltipStyle tooltipStyle, String str, String str2, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? TooltipStyle.STANDARD : tooltipStyle, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ Tooltip copy$default(Tooltip tooltip, TooltipStyle tooltipStyle, String str, String str2, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            tooltipStyle = tooltip.style;
        }
        if ((i2 & 2) != 0) {
            str = tooltip.title;
        }
        if ((i2 & 4) != 0) {
            str2 = tooltip.description;
        }
        if ((i2 & 8) != 0) {
            iVar = tooltip.unknownFields();
        }
        return tooltip.copy(tooltipStyle, str, str2, iVar);
    }

    public final Tooltip copy(TooltipStyle style, String title, String description, i unknownFields) {
        m.h(style, "style");
        m.h(title, "title");
        m.h(description, "description");
        m.h(unknownFields, "unknownFields");
        return new Tooltip(style, title, description, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Tooltip) {
            Tooltip tooltip = (Tooltip) obj;
            return m.c(unknownFields(), tooltip.unknownFields()) && this.style == tooltip.style && m.c(this.title, tooltip.title) && m.c(this.description, tooltip.description);
        }
        return false;
    }

    public final String getDescription() {
        return this.description;
    }

    public final TooltipStyle getStyle() {
        return this.style;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((unknownFields().hashCode() * 37) + this.style.hashCode()) * 37) + this.title.hashCode()) * 37) + this.description.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m518newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("style=" + this.style);
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("description=" + b.c(this.description));
        h0 = z.h0(arrayList, ", ", "Tooltip{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m518newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Tooltip(TooltipStyle style, String title, String description, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(style, "style");
        m.h(title, "title");
        m.h(description, "description");
        m.h(unknownFields, "unknownFields");
        this.style = style;
        this.title = title;
        this.description = description;
    }
}