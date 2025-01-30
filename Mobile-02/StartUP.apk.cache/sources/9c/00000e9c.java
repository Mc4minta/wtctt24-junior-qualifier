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
import org.spongycastle.i18n.TextBundle;

/* compiled from: ErrorDetail.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B1\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0019\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u001d\u0010\u000f¨\u0006!"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/ErrorDetail;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "id", TextBundle.TEXT_ENTRY, "Lcom/coinbase/android/apiv3/generated/common/AdditionalInformation;", "additional_information", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/AdditionalInformation;Lj/i;)Lcom/coinbase/android/apiv3/generated/common/ErrorDetail;", "Ljava/lang/String;", "getText", "Lcom/coinbase/android/apiv3/generated/common/AdditionalInformation;", "getAdditional_information", "()Lcom/coinbase/android/apiv3/generated/common/AdditionalInformation;", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/AdditionalInformation;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class ErrorDetail extends a {
    public static final ProtoAdapter<ErrorDetail> ADAPTER;
    public static final Parcelable.Creator<ErrorDetail> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.AdditionalInformation#ADAPTER", jsonName = "additionalInformation", tag = 3)
    private final AdditionalInformation additional_information;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String id;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String text;

    /* compiled from: ErrorDetail.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/ErrorDetail$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/common/ErrorDetail;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<ErrorDetail> protoAdapter = new ProtoAdapter<ErrorDetail>(c.LENGTH_DELIMITED, e0.b(ErrorDetail.class), "type.googleapis.com/coinbase.public_api.common.ErrorDetail") { // from class: com.coinbase.android.apiv3.generated.common.ErrorDetail$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ErrorDetail decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                AdditionalInformation additionalInformation = null;
                String str2 = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new ErrorDetail(str, str2, additionalInformation, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        additionalInformation = AdditionalInformation.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, ErrorDetail value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getId(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getId());
                }
                if (!m.c(value.getText(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getText());
                }
                if (value.getAdditional_information() != null) {
                    AdditionalInformation.ADAPTER.encodeWithTag(writer, 3, value.getAdditional_information());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(ErrorDetail value) {
                m.h(value, "value");
                if (m.c(value.getId(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getId());
                if (!m.c(value.getText(), "")) {
                    r2 = (value.getAdditional_information() != null ? AdditionalInformation.ADAPTER.encodedSizeWithTag(3, value.getAdditional_information()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(2, value.getText());
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public ErrorDetail redact(ErrorDetail value) {
                m.h(value, "value");
                AdditionalInformation additional_information = value.getAdditional_information();
                return ErrorDetail.copy$default(value, null, null, additional_information != null ? AdditionalInformation.ADAPTER.redact(additional_information) : null, i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public ErrorDetail() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ ErrorDetail(String str, String str2, AdditionalInformation additionalInformation, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? null : additionalInformation, (i2 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ ErrorDetail copy$default(ErrorDetail errorDetail, String str, String str2, AdditionalInformation additionalInformation, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = errorDetail.id;
        }
        if ((i2 & 2) != 0) {
            str2 = errorDetail.text;
        }
        if ((i2 & 4) != 0) {
            additionalInformation = errorDetail.additional_information;
        }
        if ((i2 & 8) != 0) {
            iVar = errorDetail.unknownFields();
        }
        return errorDetail.copy(str, str2, additionalInformation, iVar);
    }

    public final ErrorDetail copy(String id, String text, AdditionalInformation additionalInformation, i unknownFields) {
        m.h(id, "id");
        m.h(text, "text");
        m.h(unknownFields, "unknownFields");
        return new ErrorDetail(id, text, additionalInformation, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ErrorDetail) {
            ErrorDetail errorDetail = (ErrorDetail) obj;
            return m.c(unknownFields(), errorDetail.unknownFields()) && m.c(this.id, errorDetail.id) && m.c(this.text, errorDetail.text) && m.c(this.additional_information, errorDetail.additional_information);
        }
        return false;
    }

    public final AdditionalInformation getAdditional_information() {
        return this.additional_information;
    }

    public final String getId() {
        return this.id;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37) + this.text.hashCode()) * 37;
            AdditionalInformation additionalInformation = this.additional_information;
            int hashCode2 = hashCode + (additionalInformation != null ? additionalInformation.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m507newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("id=" + b.c(this.id));
        arrayList.add("text=" + b.c(this.text));
        if (this.additional_information != null) {
            arrayList.add("additional_information=" + this.additional_information);
        }
        h0 = z.h0(arrayList, ", ", "ErrorDetail{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorDetail(String id, String text, AdditionalInformation additionalInformation, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(id, "id");
        m.h(text, "text");
        m.h(unknownFields, "unknownFields");
        this.id = id;
        this.text = text;
        this.additional_information = additionalInformation;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m507newBuilder() {
        throw new AssertionError();
    }
}