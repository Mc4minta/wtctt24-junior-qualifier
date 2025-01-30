package com.coinbase.android.apiv3.generated.authed.sends;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.common.Amount;
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
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: PreviewSendAmountResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*BK\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJQ\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0010\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b'\u0010\u000f¨\u0006+"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/sends/PreviewSendAmountResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "sufficient_funds", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "additional_amount_required", MessageBundle.TITLE_ENTRY, ApiConstants.DESCRIPTION, "", "Lcom/coinbase/android/apiv3/generated/authed/sends/SendPaymentMethod;", "payment_methods", "Lj/i;", "unknownFields", "copy", "(ZLcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/sends/PreviewSendAmountResponse;", "Ljava/util/List;", "getPayment_methods", "()Ljava/util/List;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getAdditional_amount_required", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "Z", "getSufficient_funds", "()Z", "Ljava/lang/String;", "getTitle", "getDescription", "<init>", "(ZLcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PreviewSendAmountResponse extends a {
    public static final ProtoAdapter<PreviewSendAmountResponse> ADAPTER;
    public static final Parcelable.Creator<PreviewSendAmountResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "additionalAmountRequired", tag = 2)
    private final Amount additional_amount_required;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    private final String description;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.sends.SendPaymentMethod#ADAPTER", jsonName = "paymentMethods", label = p.a.REPEATED, tag = 5)
    private final List<SendPaymentMethod> payment_methods;
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "sufficientFunds", tag = 1)
    private final boolean sufficient_funds;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String title;

    /* compiled from: PreviewSendAmountResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/sends/PreviewSendAmountResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/sends/PreviewSendAmountResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(PreviewSendAmountResponse.class);
        ProtoAdapter<PreviewSendAmountResponse> protoAdapter = new ProtoAdapter<PreviewSendAmountResponse>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.sends.PreviewSendAmountResponse") { // from class: com.coinbase.android.apiv3.generated.authed.sends.PreviewSendAmountResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PreviewSendAmountResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                String str = "";
                boolean z = false;
                Amount amount = null;
                String str2 = str;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new PreviewSendAmountResponse(z, amount, str2, str, arrayList, reader.e(d2));
                    }
                    if (g2 == 1) {
                        z = ProtoAdapter.BOOL.decode(reader).booleanValue();
                    } else if (g2 == 2) {
                        amount = Amount.ADAPTER.decode(reader);
                    } else if (g2 == 3) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 4) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 5) {
                        reader.m(g2);
                    } else {
                        arrayList.add(SendPaymentMethod.ADAPTER.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, PreviewSendAmountResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getSufficient_funds()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 1, Boolean.valueOf(value.getSufficient_funds()));
                }
                if (value.getAdditional_amount_required() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 2, value.getAdditional_amount_required());
                }
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getTitle());
                }
                if (!m.c(value.getDescription(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getDescription());
                }
                SendPaymentMethod.ADAPTER.asRepeated().encodeWithTag(writer, 5, value.getPayment_methods());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(PreviewSendAmountResponse value) {
                m.h(value, "value");
                if (value.getSufficient_funds()) {
                    int encodedSizeWithTag = ProtoAdapter.BOOL.encodedSizeWithTag(1, Boolean.valueOf(value.getSufficient_funds()));
                    if (value.getAdditional_amount_required() != null) {
                        int encodedSizeWithTag2 = Amount.ADAPTER.encodedSizeWithTag(2, value.getAdditional_amount_required());
                        if (!m.c(value.getTitle(), "")) {
                            ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                            r1 = (m.c(value.getDescription(), "") ? 0 : protoAdapter2.encodedSizeWithTag(4, value.getDescription()) + SendPaymentMethod.ADAPTER.asRepeated().encodedSizeWithTag(5, value.getPayment_methods()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(3, value.getTitle());
                        }
                        r1 += encodedSizeWithTag2;
                    }
                    return r1 + encodedSizeWithTag;
                }
                return 0;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public PreviewSendAmountResponse redact(PreviewSendAmountResponse value) {
                m.h(value, "value");
                Amount additional_amount_required = value.getAdditional_amount_required();
                return PreviewSendAmountResponse.copy$default(value, false, additional_amount_required != null ? Amount.ADAPTER.redact(additional_amount_required) : null, null, null, b.a(value.getPayment_methods(), SendPaymentMethod.ADAPTER), i.a, 13, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public PreviewSendAmountResponse() {
        this(false, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ PreviewSendAmountResponse(boolean z, Amount amount, String str, String str2, List list, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? null : amount, (i2 & 4) != 0 ? "" : str, (i2 & 8) == 0 ? str2 : "", (i2 & 16) != 0 ? r.g() : list, (i2 & 32) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ PreviewSendAmountResponse copy$default(PreviewSendAmountResponse previewSendAmountResponse, boolean z, Amount amount, String str, String str2, List list, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = previewSendAmountResponse.sufficient_funds;
        }
        if ((i2 & 2) != 0) {
            amount = previewSendAmountResponse.additional_amount_required;
        }
        Amount amount2 = amount;
        if ((i2 & 4) != 0) {
            str = previewSendAmountResponse.title;
        }
        String str3 = str;
        if ((i2 & 8) != 0) {
            str2 = previewSendAmountResponse.description;
        }
        String str4 = str2;
        List<SendPaymentMethod> list2 = list;
        if ((i2 & 16) != 0) {
            list2 = previewSendAmountResponse.payment_methods;
        }
        List list3 = list2;
        if ((i2 & 32) != 0) {
            iVar = previewSendAmountResponse.unknownFields();
        }
        return previewSendAmountResponse.copy(z, amount2, str3, str4, list3, iVar);
    }

    public final PreviewSendAmountResponse copy(boolean z, Amount amount, String title, String description, List<SendPaymentMethod> payment_methods, i unknownFields) {
        m.h(title, "title");
        m.h(description, "description");
        m.h(payment_methods, "payment_methods");
        m.h(unknownFields, "unknownFields");
        return new PreviewSendAmountResponse(z, amount, title, description, payment_methods, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PreviewSendAmountResponse) {
            PreviewSendAmountResponse previewSendAmountResponse = (PreviewSendAmountResponse) obj;
            return m.c(unknownFields(), previewSendAmountResponse.unknownFields()) && this.sufficient_funds == previewSendAmountResponse.sufficient_funds && m.c(this.additional_amount_required, previewSendAmountResponse.additional_amount_required) && m.c(this.title, previewSendAmountResponse.title) && m.c(this.description, previewSendAmountResponse.description) && m.c(this.payment_methods, previewSendAmountResponse.payment_methods);
        }
        return false;
    }

    public final Amount getAdditional_amount_required() {
        return this.additional_amount_required;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<SendPaymentMethod> getPayment_methods() {
        return this.payment_methods;
    }

    public final boolean getSufficient_funds() {
        return this.sufficient_funds;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + com.coinbase.android.apiv3.generated.authed.a.a(this.sufficient_funds)) * 37;
            Amount amount = this.additional_amount_required;
            int hashCode2 = ((((((hashCode + (amount != null ? amount.hashCode() : 0)) * 37) + this.title.hashCode()) * 37) + this.description.hashCode()) * 37) + this.payment_methods.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m465newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("sufficient_funds=" + this.sufficient_funds);
        if (this.additional_amount_required != null) {
            arrayList.add("additional_amount_required=" + this.additional_amount_required);
        }
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("description=" + b.c(this.description));
        if (!this.payment_methods.isEmpty()) {
            arrayList.add("payment_methods=" + this.payment_methods);
        }
        h0 = z.h0(arrayList, ", ", "PreviewSendAmountResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m465newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewSendAmountResponse(boolean z, Amount amount, String title, String description, List<SendPaymentMethod> payment_methods, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(title, "title");
        m.h(description, "description");
        m.h(payment_methods, "payment_methods");
        m.h(unknownFields, "unknownFields");
        this.sufficient_funds = z;
        this.additional_amount_required = amount;
        this.title = title;
        this.description = description;
        this.payment_methods = payment_methods;
    }
}