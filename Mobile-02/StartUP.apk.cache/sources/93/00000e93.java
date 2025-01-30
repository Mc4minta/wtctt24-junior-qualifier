package com.coinbase.android.apiv3.generated.common;

import android.os.Parcelable;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.a;
import com.squareup.wire.c;
import com.squareup.wire.g;
import com.squareup.wire.k;
import com.squareup.wire.l;
import com.squareup.wire.p;
import j.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: ConsentDataItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B+\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/ConsentDataItem;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/common/ConsentRegion;", "region", "", "Lcom/coinbase/android/apiv3/generated/common/ConsentValue;", "values", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/common/ConsentRegion;Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/common/ConsentDataItem;", "Lcom/coinbase/android/apiv3/generated/common/ConsentRegion;", "getRegion", "()Lcom/coinbase/android/apiv3/generated/common/ConsentRegion;", "Ljava/util/List;", "getValues", "()Ljava/util/List;", "<init>", "(Lcom/coinbase/android/apiv3/generated/common/ConsentRegion;Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class ConsentDataItem extends a {
    public static final ProtoAdapter<ConsentDataItem> ADAPTER;
    public static final Parcelable.Creator<ConsentDataItem> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.ConsentRegion#ADAPTER", tag = 1)
    private final ConsentRegion region;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.ConsentValue#ADAPTER", label = p.a.REPEATED, tag = 2)
    private final List<ConsentValue> values;

    /* compiled from: ConsentDataItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/ConsentDataItem$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/common/ConsentDataItem;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<ConsentDataItem> protoAdapter = new ProtoAdapter<ConsentDataItem>(c.LENGTH_DELIMITED, e0.b(ConsentDataItem.class), "type.googleapis.com/coinbase.public_api.common.ConsentDataItem") { // from class: com.coinbase.android.apiv3.generated.common.ConsentDataItem$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ConsentDataItem decode(k reader) {
                ConsentRegion consentRegion;
                ProtoAdapter.EnumConstantNotFoundException e2;
                m.h(reader, "reader");
                ConsentRegion consentRegion2 = ConsentRegion.DEFAULT;
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new ConsentDataItem(consentRegion2, arrayList, reader.e(d2));
                    }
                    if (g2 == 1) {
                        try {
                            consentRegion = ConsentRegion.ADAPTER.decode(reader);
                            try {
                                x xVar = x.a;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                                e2 = e3;
                                reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                                x xVar2 = x.a;
                                consentRegion2 = consentRegion;
                            }
                        } catch (ProtoAdapter.EnumConstantNotFoundException e4) {
                            consentRegion = consentRegion2;
                            e2 = e4;
                        }
                        consentRegion2 = consentRegion;
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        try {
                            arrayList.add(ConsentValue.ADAPTER.decode(reader));
                        } catch (ProtoAdapter.EnumConstantNotFoundException e5) {
                            reader.a(g2, c.VARINT, Long.valueOf(e5.a));
                            x xVar3 = x.a;
                        }
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, ConsentDataItem value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getRegion() != ConsentRegion.DEFAULT) {
                    ConsentRegion.ADAPTER.encodeWithTag(writer, 1, value.getRegion());
                }
                ConsentValue.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.getValues());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(ConsentDataItem value) {
                m.h(value, "value");
                if (value.getRegion() == ConsentRegion.DEFAULT) {
                    return 0;
                }
                return value.unknownFields().Q() + ConsentRegion.ADAPTER.encodedSizeWithTag(1, value.getRegion()) + ConsentValue.ADAPTER.asRepeated().encodedSizeWithTag(2, value.getValues());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public ConsentDataItem redact(ConsentDataItem value) {
                m.h(value, "value");
                return ConsentDataItem.copy$default(value, null, null, i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public ConsentDataItem() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ ConsentDataItem(ConsentRegion consentRegion, List list, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? ConsentRegion.DEFAULT : consentRegion, (i2 & 2) != 0 ? r.g() : list, (i2 & 4) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConsentDataItem copy$default(ConsentDataItem consentDataItem, ConsentRegion consentRegion, List list, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            consentRegion = consentDataItem.region;
        }
        if ((i2 & 2) != 0) {
            list = consentDataItem.values;
        }
        if ((i2 & 4) != 0) {
            iVar = consentDataItem.unknownFields();
        }
        return consentDataItem.copy(consentRegion, list, iVar);
    }

    public final ConsentDataItem copy(ConsentRegion region, List<? extends ConsentValue> values, i unknownFields) {
        m.h(region, "region");
        m.h(values, "values");
        m.h(unknownFields, "unknownFields");
        return new ConsentDataItem(region, values, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ConsentDataItem) {
            ConsentDataItem consentDataItem = (ConsentDataItem) obj;
            return m.c(unknownFields(), consentDataItem.unknownFields()) && this.region == consentDataItem.region && m.c(this.values, consentDataItem.values);
        }
        return false;
    }

    public final ConsentRegion getRegion() {
        return this.region;
    }

    public final List<ConsentValue> getValues() {
        return this.values;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + this.region.hashCode()) * 37) + this.values.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m506newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("region=" + this.region);
        if (!this.values.isEmpty()) {
            arrayList.add("values=" + this.values);
        }
        h0 = z.h0(arrayList, ", ", "ConsentDataItem{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m506newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ConsentDataItem(ConsentRegion region, List<? extends ConsentValue> values, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(region, "region");
        m.h(values, "values");
        m.h(unknownFields, "unknownFields");
        this.region = region;
        this.values = values;
    }
}