package com.coinbase.wallet.blockchains.models;

import com.coinbase.ApiConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: RefreshContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0017B-\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/RefreshContext;", "", "Lcom/coinbase/wallet/blockchains/models/RefreshContext$Mode;", "mode", "Lcom/coinbase/wallet/blockchains/models/RefreshContext$Mode;", "getMode", "()Lcom/coinbase/wallet/blockchains/models/RefreshContext$Mode;", "", "isForced", "Z", "()Z", "", "index", "Ljava/lang/Integer;", "getIndex", "()Ljava/lang/Integer;", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "()Lcom/coinbase/wallet/blockchains/models/Network;", "<init>", "(Lcom/coinbase/wallet/blockchains/models/Network;Ljava/lang/Integer;Lcom/coinbase/wallet/blockchains/models/RefreshContext$Mode;Z)V", "Mode", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public class RefreshContext {
    private final Integer index;
    private final boolean isForced;
    private final Mode mode;
    private final Network network;

    /* compiled from: RefreshContext.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/RefreshContext$Mode;", "", "<init>", "()V", "Full", "Quick", "Subset", "Lcom/coinbase/wallet/blockchains/models/RefreshContext$Mode$Quick;", "Lcom/coinbase/wallet/blockchains/models/RefreshContext$Mode$Subset;", "Lcom/coinbase/wallet/blockchains/models/RefreshContext$Mode$Full;", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static abstract class Mode {

        /* compiled from: RefreshContext.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/RefreshContext$Mode$Full;", "Lcom/coinbase/wallet/blockchains/models/RefreshContext$Mode;", "<init>", "()V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes.dex */
        public static final class Full extends Mode {
            public static final Full INSTANCE = new Full();

            private Full() {
                super(null);
            }
        }

        /* compiled from: RefreshContext.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/RefreshContext$Mode$Quick;", "Lcom/coinbase/wallet/blockchains/models/RefreshContext$Mode;", "<init>", "()V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes.dex */
        public static final class Quick extends Mode {
            public static final Quick INSTANCE = new Quick();

            private Quick() {
                super(null);
            }
        }

        /* compiled from: RefreshContext.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/RefreshContext$Mode$Subset;", "Lcom/coinbase/wallet/blockchains/models/RefreshContext$Mode;", "", "", "component1", "()Ljava/util/List;", ApiConstants.ADDRESSES, "copy", "(Ljava/util/List;)Lcom/coinbase/wallet/blockchains/models/RefreshContext$Mode$Subset;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getAddresses", "<init>", "(Ljava/util/List;)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes.dex */
        public static final class Subset extends Mode {
            private final List<String> addresses;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Subset(List<String> addresses) {
                super(null);
                m.g(addresses, "addresses");
                this.addresses = addresses;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Subset copy$default(Subset subset, List list, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    list = subset.addresses;
                }
                return subset.copy(list);
            }

            public final List<String> component1() {
                return this.addresses;
            }

            public final Subset copy(List<String> addresses) {
                m.g(addresses, "addresses");
                return new Subset(addresses);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Subset) && m.c(this.addresses, ((Subset) obj).addresses);
            }

            public final List<String> getAddresses() {
                return this.addresses;
            }

            public int hashCode() {
                return this.addresses.hashCode();
            }

            public String toString() {
                return "Subset(addresses=" + this.addresses + ')';
            }
        }

        private Mode() {
        }

        public /* synthetic */ Mode(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RefreshContext(Network network, Integer num, Mode mode, boolean z) {
        m.g(network, "network");
        m.g(mode, "mode");
        this.network = network;
        this.index = num;
        this.mode = mode;
        this.isForced = z;
    }

    public final Integer getIndex() {
        return this.index;
    }

    public final Mode getMode() {
        return this.mode;
    }

    public final Network getNetwork() {
        return this.network;
    }

    public final boolean isForced() {
        return this.isForced;
    }

    public /* synthetic */ RefreshContext(Network network, Integer num, Mode mode, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(network, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? Mode.Full.INSTANCE : mode, z);
    }
}