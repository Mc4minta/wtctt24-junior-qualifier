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

/* compiled from: FeeDetails.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B1\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0019\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u001d\u0010\u000f¨\u0006!"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/FeeDetails;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", ApiConstants.NAME, "help_link_url", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "amount", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lj/i;)Lcom/coinbase/android/apiv3/generated/common/FeeDetails;", "Ljava/lang/String;", "getHelp_link_url", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getAmount", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class FeeDetails extends a {
    public static final ProtoAdapter<FeeDetails> ADAPTER;
    public static final Parcelable.Creator<FeeDetails> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 3)
    private final Amount amount;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "helpLinkUrl", tag = 2)
    private final String help_link_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String name;

    /* compiled from: FeeDetails.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/FeeDetails$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/common/FeeDetails;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<FeeDetails> protoAdapter = new ProtoAdapter<FeeDetails>(c.LENGTH_DELIMITED, e0.b(FeeDetails.class), "type.googleapis.com/coinbase.public_api.common.FeeDetails") { // from class: com.coinbase.android.apiv3.generated.common.FeeDetails$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public FeeDetails decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                Amount amount = null;
                String str2 = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new FeeDetails(str, str2, amount, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        amount = Amount.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, FeeDetails value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getName(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getName());
                }
                if (!m.c(value.getHelp_link_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getHelp_link_url());
                }
                if (value.getAmount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 3, value.getAmount());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(FeeDetails value) {
                m.h(value, "value");
                if (m.c(value.getName(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getName());
                if (!m.c(value.getHelp_link_url(), "")) {
                    r2 = (value.getAmount() != null ? Amount.ADAPTER.encodedSizeWithTag(3, value.getAmount()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(2, value.getHelp_link_url());
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public FeeDetails redact(FeeDetails value) {
                m.h(value, "value");
                Amount amount = value.getAmount();
                return FeeDetails.copy$default(value, null, null, amount != null ? Amount.ADAPTER.redact(amount) : null, i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public FeeDetails() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ FeeDetails(String str, String str2, Amount amount, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? null : amount, (i2 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ FeeDetails copy$default(FeeDetails feeDetails, String str, String str2, Amount amount, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = feeDetails.name;
        }
        if ((i2 & 2) != 0) {
            str2 = feeDetails.help_link_url;
        }
        if ((i2 & 4) != 0) {
            amount = feeDetails.amount;
        }
        if ((i2 & 8) != 0) {
            iVar = feeDetails.unknownFields();
        }
        return feeDetails.copy(str, str2, amount, iVar);
    }

    public final FeeDetails copy(String name, String help_link_url, Amount amount, i unknownFields) {
        m.h(name, "name");
        m.h(help_link_url, "help_link_url");
        m.h(unknownFields, "unknownFields");
        return new FeeDetails(name, help_link_url, amount, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FeeDetails) {
            FeeDetails feeDetails = (FeeDetails) obj;
            return m.c(unknownFields(), feeDetails.unknownFields()) && m.c(this.name, feeDetails.name) && m.c(this.help_link_url, feeDetails.help_link_url) && m.c(this.amount, feeDetails.amount);
        }
        return false;
    }

    public final Amount getAmount() {
        return this.amount;
    }

    public final String getHelp_link_url() {
        return this.help_link_url;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + this.name.hashCode()) * 37) + this.help_link_url.hashCode()) * 37;
            Amount amount = this.amount;
            int hashCode2 = hashCode + (amount != null ? amount.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m508newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("name=" + b.c(this.name));
        arrayList.add("help_link_url=" + b.c(this.help_link_url));
        if (this.amount != null) {
            arrayList.add("amount=" + this.amount);
        }
        h0 = z.h0(arrayList, ", ", "FeeDetails{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeeDetails(String name, String help_link_url, Amount amount, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(name, "name");
        m.h(help_link_url, "help_link_url");
        m.h(unknownFields, "unknownFields");
        this.name = name;
        this.help_link_url = help_link_url;
        this.amount = amount;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m508newBuilder() {
        throw new AssertionError();
    }
}