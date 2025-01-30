package com.coinbase.android.apiv3.generated.authed.user_privacy;

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
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: UpdatePrivacySettingsRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u001b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0010\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/user_privacy/UpdatePrivacySettingsRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "crypto_address_discoverable", "Lj/i;", "unknownFields", "copy", "(ZLj/i;)Lcom/coinbase/android/apiv3/generated/authed/user_privacy/UpdatePrivacySettingsRequest;", "Z", "getCrypto_address_discoverable", "()Z", "<init>", "(ZLj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class UpdatePrivacySettingsRequest extends a {
    public static final ProtoAdapter<UpdatePrivacySettingsRequest> ADAPTER;
    public static final Parcelable.Creator<UpdatePrivacySettingsRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "cryptoAddressDiscoverable", tag = 1)
    private final boolean crypto_address_discoverable;

    /* compiled from: UpdatePrivacySettingsRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/user_privacy/UpdatePrivacySettingsRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/user_privacy/UpdatePrivacySettingsRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<UpdatePrivacySettingsRequest> protoAdapter = new ProtoAdapter<UpdatePrivacySettingsRequest>(c.LENGTH_DELIMITED, e0.b(UpdatePrivacySettingsRequest.class), "type.googleapis.com/coinbase.public_api.authed.user_privacy.UpdatePrivacySettingsRequest") { // from class: com.coinbase.android.apiv3.generated.authed.user_privacy.UpdatePrivacySettingsRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UpdatePrivacySettingsRequest decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                boolean z = false;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new UpdatePrivacySettingsRequest(z, reader.e(d2));
                    }
                    if (g2 != 1) {
                        reader.m(g2);
                    } else {
                        z = ProtoAdapter.BOOL.decode(reader).booleanValue();
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, UpdatePrivacySettingsRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getCrypto_address_discoverable()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 1, Boolean.valueOf(value.getCrypto_address_discoverable()));
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(UpdatePrivacySettingsRequest value) {
                m.h(value, "value");
                if (value.getCrypto_address_discoverable()) {
                    return value.unknownFields().Q() + ProtoAdapter.BOOL.encodedSizeWithTag(1, Boolean.valueOf(value.getCrypto_address_discoverable()));
                }
                return 0;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public UpdatePrivacySettingsRequest redact(UpdatePrivacySettingsRequest value) {
                m.h(value, "value");
                return UpdatePrivacySettingsRequest.copy$default(value, false, i.a, 1, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public UpdatePrivacySettingsRequest() {
        this(false, null, 3, null);
    }

    public /* synthetic */ UpdatePrivacySettingsRequest(boolean z, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ UpdatePrivacySettingsRequest copy$default(UpdatePrivacySettingsRequest updatePrivacySettingsRequest, boolean z, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = updatePrivacySettingsRequest.crypto_address_discoverable;
        }
        if ((i2 & 2) != 0) {
            iVar = updatePrivacySettingsRequest.unknownFields();
        }
        return updatePrivacySettingsRequest.copy(z, iVar);
    }

    public final UpdatePrivacySettingsRequest copy(boolean z, i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new UpdatePrivacySettingsRequest(z, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof UpdatePrivacySettingsRequest) {
            UpdatePrivacySettingsRequest updatePrivacySettingsRequest = (UpdatePrivacySettingsRequest) obj;
            return m.c(unknownFields(), updatePrivacySettingsRequest.unknownFields()) && this.crypto_address_discoverable == updatePrivacySettingsRequest.crypto_address_discoverable;
        }
        return false;
    }

    public final boolean getCrypto_address_discoverable() {
        return this.crypto_address_discoverable;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + com.coinbase.android.apiv3.generated.authed.a.a(this.crypto_address_discoverable);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m489newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("crypto_address_discoverable=" + this.crypto_address_discoverable);
        h0 = z.h0(arrayList, ", ", "UpdatePrivacySettingsRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdatePrivacySettingsRequest(boolean z, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
        this.crypto_address_discoverable = z;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m489newBuilder() {
        throw new AssertionError();
    }
}