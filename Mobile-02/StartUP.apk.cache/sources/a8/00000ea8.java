package com.coinbase.android.apiv3.generated.common;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.PageOptions;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.a;
import com.squareup.wire.b;
import com.squareup.wire.c;
import com.squareup.wire.g;
import com.squareup.wire.k;
import com.squareup.wire.l;
import com.squareup.wire.o;
import com.squareup.wire.p;
import j.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: PageOptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002!\"B/\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0010\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u0019\u0010\fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/PageOptions;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "size", "cursor", "Lcom/coinbase/android/apiv3/generated/common/PageOptions$Direction;", "direction", "Lj/i;", "unknownFields", "copy", "(ILjava/lang/String;Lcom/coinbase/android/apiv3/generated/common/PageOptions$Direction;Lj/i;)Lcom/coinbase/android/apiv3/generated/common/PageOptions;", "I", "getSize", "Ljava/lang/String;", "getCursor", "Lcom/coinbase/android/apiv3/generated/common/PageOptions$Direction;", "getDirection", "()Lcom/coinbase/android/apiv3/generated/common/PageOptions$Direction;", "<init>", "(ILjava/lang/String;Lcom/coinbase/android/apiv3/generated/common/PageOptions$Direction;Lj/i;)V", "Companion", "Direction", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PageOptions extends a {
    public static final ProtoAdapter<PageOptions> ADAPTER;
    public static final Parcelable.Creator<PageOptions> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String cursor;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.PageOptions$Direction#ADAPTER", tag = 3)
    private final Direction direction;
    @p(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    private final int size;

    /* compiled from: PageOptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/PageOptions$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/common/PageOptions;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PageOptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/PageOptions$Direction;", "", "Lcom/squareup/wire/o;", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "FORWARD", "BACKWARD", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public enum Direction implements o {
        FORWARD(0),
        BACKWARD(1);
        
        private final int value;
        public static final Companion Companion = new Companion(null);
        public static final ProtoAdapter<Direction> ADAPTER = new b<Direction>(e0.b(Direction.class)) { // from class: com.coinbase.android.apiv3.generated.common.PageOptions$Direction$Companion$ADAPTER$1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.b
            public PageOptions.Direction fromValue(int i2) {
                return PageOptions.Direction.Companion.fromValue(i2);
            }
        };

        /* compiled from: PageOptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/PageOptions$Direction$Companion;", "", "", "value", "Lcom/coinbase/android/apiv3/generated/common/PageOptions$Direction;", "fromValue", "(I)Lcom/coinbase/android/apiv3/generated/common/PageOptions$Direction;", "Lcom/squareup/wire/ProtoAdapter;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public final Direction fromValue(int i2) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        return null;
                    }
                    return Direction.BACKWARD;
                }
                return Direction.FORWARD;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        Direction(int i2) {
            this.value = i2;
        }

        public static final Direction fromValue(int i2) {
            return Companion.fromValue(i2);
        }

        @Override // com.squareup.wire.o
        public int getValue() {
            return this.value;
        }
    }

    static {
        ProtoAdapter<PageOptions> protoAdapter = new ProtoAdapter<PageOptions>(c.LENGTH_DELIMITED, e0.b(PageOptions.class), "type.googleapis.com/coinbase.public_api.common.PageOptions") { // from class: com.coinbase.android.apiv3.generated.common.PageOptions$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PageOptions decode(k reader) {
                m.h(reader, "reader");
                PageOptions.Direction direction = PageOptions.Direction.FORWARD;
                long d2 = reader.d();
                int i2 = 0;
                String str = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new PageOptions(i2, str, direction, reader.e(d2));
                    }
                    if (g2 == 1) {
                        i2 = ProtoAdapter.UINT32.decode(reader).intValue();
                    } else if (g2 == 2) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        try {
                            direction = PageOptions.Direction.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                            reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                        }
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, PageOptions value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getSize() != 0) {
                    ProtoAdapter.UINT32.encodeWithTag(writer, 1, Integer.valueOf(value.getSize()));
                }
                if (!m.c(value.getCursor(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getCursor());
                }
                if (value.getDirection() != PageOptions.Direction.FORWARD) {
                    PageOptions.Direction.ADAPTER.encodeWithTag(writer, 3, value.getDirection());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(PageOptions value) {
                m.h(value, "value");
                if (value.getSize() == 0) {
                    return 0;
                }
                int encodedSizeWithTag = ProtoAdapter.UINT32.encodedSizeWithTag(1, Integer.valueOf(value.getSize()));
                if (!m.c(value.getCursor(), "")) {
                    r1 = (value.getDirection() != PageOptions.Direction.FORWARD ? PageOptions.Direction.ADAPTER.encodedSizeWithTag(3, value.getDirection()) + value.unknownFields().Q() : 0) + ProtoAdapter.STRING.encodedSizeWithTag(2, value.getCursor());
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public PageOptions redact(PageOptions value) {
                m.h(value, "value");
                return PageOptions.copy$default(value, 0, null, null, i.a, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public PageOptions() {
        this(0, null, null, null, 15, null);
    }

    public /* synthetic */ PageOptions(int i2, String str, Direction direction, i iVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? Direction.FORWARD : direction, (i3 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ PageOptions copy$default(PageOptions pageOptions, int i2, String str, Direction direction, i iVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = pageOptions.size;
        }
        if ((i3 & 2) != 0) {
            str = pageOptions.cursor;
        }
        if ((i3 & 4) != 0) {
            direction = pageOptions.direction;
        }
        if ((i3 & 8) != 0) {
            iVar = pageOptions.unknownFields();
        }
        return pageOptions.copy(i2, str, direction, iVar);
    }

    public final PageOptions copy(int i2, String cursor, Direction direction, i unknownFields) {
        m.h(cursor, "cursor");
        m.h(direction, "direction");
        m.h(unknownFields, "unknownFields");
        return new PageOptions(i2, cursor, direction, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PageOptions) {
            PageOptions pageOptions = (PageOptions) obj;
            return m.c(unknownFields(), pageOptions.unknownFields()) && this.size == pageOptions.size && m.c(this.cursor, pageOptions.cursor) && this.direction == pageOptions.direction;
        }
        return false;
    }

    public final String getCursor() {
        return this.cursor;
    }

    public final Direction getDirection() {
        return this.direction;
    }

    public final int getSize() {
        return this.size;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((unknownFields().hashCode() * 37) + this.size) * 37) + this.cursor.hashCode()) * 37) + this.direction.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m511newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("size=" + this.size);
        arrayList.add("cursor=" + com.squareup.wire.q.b.c(this.cursor));
        arrayList.add("direction=" + this.direction);
        h0 = z.h0(arrayList, ", ", "PageOptions{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m511newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageOptions(int i2, String cursor, Direction direction, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(cursor, "cursor");
        m.h(direction, "direction");
        m.h(unknownFields, "unknownFields");
        this.size = i2;
        this.cursor = cursor;
        this.direction = direction;
    }
}