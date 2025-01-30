package com.coinbase.android.apiv3.generated.resources;

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

/* compiled from: Bank.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB9\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0019\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u001a\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u001c\u0010\u000f¨\u0006 "}, d2 = {"Lcom/coinbase/android/apiv3/generated/resources/Bank;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "code", ApiConstants.NAME, "subtitle", "icon_url", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/resources/Bank;", "Ljava/lang/String;", "getName", "getIcon_url", "getCode", "getSubtitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Bank extends a {
    public static final ProtoAdapter<Bank> ADAPTER;
    public static final Parcelable.Creator<Bank> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String code;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "iconUrl", tag = 4)
    private final String icon_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String name;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String subtitle;

    /* compiled from: Bank.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/resources/Bank$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/resources/Bank;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<Bank> protoAdapter = new ProtoAdapter<Bank>(c.LENGTH_DELIMITED, e0.b(Bank.class), "type.googleapis.com/coinbase.public_api.resources.Bank") { // from class: com.coinbase.android.apiv3.generated.resources.Bank$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Bank decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new Bank(str, str2, str3, str4, reader.e(d2));
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
                        str4 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, Bank value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getCode(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getCode());
                }
                if (!m.c(value.getName(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getName());
                }
                if (!m.c(value.getSubtitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getSubtitle());
                }
                if (!m.c(value.getIcon_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getIcon_url());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Bank value) {
                m.h(value, "value");
                if (m.c(value.getCode(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getCode());
                if (!m.c(value.getName(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getName());
                    if (!m.c(value.getSubtitle(), "")) {
                        r2 = (m.c(value.getIcon_url(), "") ? 0 : protoAdapter2.encodedSizeWithTag(4, value.getIcon_url()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(3, value.getSubtitle());
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Bank redact(Bank value) {
                m.h(value, "value");
                return Bank.copy$default(value, null, null, null, null, i.a, 15, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public Bank() {
        this(null, null, null, null, null, 31, null);
    }

    public /* synthetic */ Bank(String str, String str2, String str3, String str4, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) == 0 ? str4 : "", (i2 & 16) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ Bank copy$default(Bank bank, String str, String str2, String str3, String str4, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bank.code;
        }
        if ((i2 & 2) != 0) {
            str2 = bank.name;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = bank.subtitle;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = bank.icon_url;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            iVar = bank.unknownFields();
        }
        return bank.copy(str, str5, str6, str7, iVar);
    }

    public final Bank copy(String code, String name, String subtitle, String icon_url, i unknownFields) {
        m.h(code, "code");
        m.h(name, "name");
        m.h(subtitle, "subtitle");
        m.h(icon_url, "icon_url");
        m.h(unknownFields, "unknownFields");
        return new Bank(code, name, subtitle, icon_url, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Bank) {
            Bank bank = (Bank) obj;
            return m.c(unknownFields(), bank.unknownFields()) && m.c(this.code, bank.code) && m.c(this.name, bank.name) && m.c(this.subtitle, bank.subtitle) && m.c(this.icon_url, bank.icon_url);
        }
        return false;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getIcon_url() {
        return this.icon_url;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((unknownFields().hashCode() * 37) + this.code.hashCode()) * 37) + this.name.hashCode()) * 37) + this.subtitle.hashCode()) * 37) + this.icon_url.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m525newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("code=" + b.c(this.code));
        arrayList.add("name=" + b.c(this.name));
        arrayList.add("subtitle=" + b.c(this.subtitle));
        arrayList.add("icon_url=" + b.c(this.icon_url));
        h0 = z.h0(arrayList, ", ", "Bank{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Bank(String code, String name, String subtitle, String icon_url, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(code, "code");
        m.h(name, "name");
        m.h(subtitle, "subtitle");
        m.h(icon_url, "icon_url");
        m.h(unknownFields, "unknownFields");
        this.code = code;
        this.name = name;
        this.subtitle = subtitle;
        this.icon_url = icon_url;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m525newBuilder() {
        throw new AssertionError();
    }
}