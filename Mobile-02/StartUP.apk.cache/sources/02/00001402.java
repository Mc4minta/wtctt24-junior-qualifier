package com.coinbase.wallet.blockchains.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.p;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.l0.y;

/* compiled from: Network.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000fJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\t\u0010\u0007R\u0019\u0010\u001e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u0004¨\u0006#"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Network;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "uuid", "isTestnet", "copy", "(Ljava/lang/String;Z)Lcom/coinbase/wallet/blockchains/models/Network;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getUuid", "Z", "rawValue", "getRawValue", "<init>", "(Ljava/lang/String;Z)V", "Companion", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Network implements Parcelable {
    private final boolean isTestnet;
    private final String rawValue;
    private final String uuid;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<Network> CREATOR = new Creator();

    /* compiled from: Network.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Network$Companion;", "", "", "isTestnet", "Lcom/coinbase/wallet/blockchains/models/Network;", "createTestnetNetwork", "(Z)Lcom/coinbase/wallet/blockchains/models/Network;", "", "rawValue", "create", "(Ljava/lang/String;)Lcom/coinbase/wallet/blockchains/models/Network;", "<init>", "()V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Network create(String rawValue) {
            List K0;
            String str;
            String str2;
            List j2;
            m.g(rawValue, "rawValue");
            K0 = y.K0(rawValue, new String[]{"/"}, false, 0, 6, null);
            if (K0.size() != 2 || (str = (String) p.b0(K0, 0)) == null || (str2 = (String) p.b0(K0, 1)) == null) {
                return null;
            }
            j2 = r.j("true", "false");
            if (j2.contains(str2)) {
                return new Network(str, Boolean.parseBoolean(str2));
            }
            return null;
        }

        public final Network createTestnetNetwork(boolean z) {
            return new Network("TESTNET", z);
        }
    }

    /* compiled from: Network.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<Network> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Network createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new Network(parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Network[] newArray(int i2) {
            return new Network[i2];
        }
    }

    public Network(String uuid, boolean z) {
        List j2;
        String h0;
        m.g(uuid, "uuid");
        this.uuid = uuid;
        this.isTestnet = z;
        j2 = r.j(uuid, String.valueOf(z));
        h0 = z.h0(j2, "/", null, null, 0, null, null, 62, null);
        this.rawValue = h0;
    }

    public static /* synthetic */ Network copy$default(Network network, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = network.uuid;
        }
        if ((i2 & 2) != 0) {
            z = network.isTestnet;
        }
        return network.copy(str, z);
    }

    public final String component1() {
        return this.uuid;
    }

    public final boolean component2() {
        return this.isTestnet;
    }

    public final Network copy(String uuid, boolean z) {
        m.g(uuid, "uuid");
        return new Network(uuid, z);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Network) {
            Network network = (Network) obj;
            return m.c(this.uuid, network.uuid) && this.isTestnet == network.isTestnet;
        }
        return false;
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    public final String getUuid() {
        return this.uuid;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.uuid.hashCode() * 31;
        boolean z = this.isTestnet;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public final boolean isTestnet() {
        return this.isTestnet;
    }

    public String toString() {
        return "Network(uuid=" + this.uuid + ", isTestnet=" + this.isTestnet + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(this.uuid);
        out.writeInt(this.isTestnet ? 1 : 0);
    }
}