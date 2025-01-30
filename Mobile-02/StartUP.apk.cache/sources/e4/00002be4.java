package com.coinbase.walletlink.models;

import android.net.Uri;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.features.walletlink.models.WalletLinkCompleteArgs;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.apache.http.cookie.ClientCookie;

/* compiled from: HostRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u001a\u001b\u001c\u001d\u001e\u001f B\u0011\b\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0005\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0007\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000e\u001a\u00020\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0010\u001a\u00020\u000f8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\u0015\u001a\u00020\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\rR\u0013\u0010\u0017\u001a\u00020\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\r\u0082\u0001\u0007!\"#$%&'¨\u0006("}, d2 = {"Lcom/coinbase/walletlink/models/HostRequest;", "", "Landroid/net/Uri;", "getDappUrl", "()Landroid/net/Uri;", "dappUrl", "Lcom/coinbase/walletlink/models/HostRequestId;", "hostRequestId", "Lcom/coinbase/walletlink/models/HostRequestId;", "getHostRequestId", "()Lcom/coinbase/walletlink/models/HostRequestId;", "", "getEventId", "()Ljava/lang/String;", WalletLinkPushNotification.eventIdKey, "", "isAutoApproveDappPermission", "()Z", "getDappName", WalletLinkCompleteArgs.DAPP_NAME, "getRequestId", "requestId", "getSessionId", WalletLinkPushNotification.sessionIdKey, "<init>", "(Lcom/coinbase/walletlink/models/HostRequestId;)V", "ChildRequestEthereumAccounts", "RequestCanceled", "RequestEthereumAccounts", "SignAndSubmitTx", "SignMessage", "SubmitSignedTx", "SwitchEthereumChain", "Lcom/coinbase/walletlink/models/HostRequest$SignMessage;", "Lcom/coinbase/walletlink/models/HostRequest$SignAndSubmitTx;", "Lcom/coinbase/walletlink/models/HostRequest$SubmitSignedTx;", "Lcom/coinbase/walletlink/models/HostRequest$ChildRequestEthereumAccounts;", "Lcom/coinbase/walletlink/models/HostRequest$RequestEthereumAccounts;", "Lcom/coinbase/walletlink/models/HostRequest$SwitchEthereumChain;", "Lcom/coinbase/walletlink/models/HostRequest$RequestCanceled;", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class HostRequest {
    private final HostRequestId hostRequestId;

    /* compiled from: HostRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J:\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001b\u0010\u0007R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001e\u0010\u0007¨\u0006!"}, d2 = {"Lcom/coinbase/walletlink/models/HostRequest$ChildRequestEthereumAccounts;", "Lcom/coinbase/walletlink/models/HostRequest;", "Lcom/coinbase/walletlink/models/HostRequestId;", "component1", "()Lcom/coinbase/walletlink/models/HostRequestId;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "hostRequestId", "childSessionId", "childSessionSecret", ClientCookie.VERSION_ATTR, "copy", "(Lcom/coinbase/walletlink/models/HostRequestId;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/walletlink/models/HostRequest$ChildRequestEthereumAccounts;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getChildSessionSecret", "getChildSessionId", "Lcom/coinbase/walletlink/models/HostRequestId;", "getHostRequestId", "getVersion", "<init>", "(Lcom/coinbase/walletlink/models/HostRequestId;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class ChildRequestEthereumAccounts extends HostRequest {
        private final String childSessionId;
        private final String childSessionSecret;
        private final HostRequestId hostRequestId;
        private final String version;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChildRequestEthereumAccounts(HostRequestId hostRequestId, String childSessionId, String childSessionSecret, String str) {
            super(hostRequestId, null);
            m.g(hostRequestId, "hostRequestId");
            m.g(childSessionId, "childSessionId");
            m.g(childSessionSecret, "childSessionSecret");
            this.hostRequestId = hostRequestId;
            this.childSessionId = childSessionId;
            this.childSessionSecret = childSessionSecret;
            this.version = str;
        }

        public static /* synthetic */ ChildRequestEthereumAccounts copy$default(ChildRequestEthereumAccounts childRequestEthereumAccounts, HostRequestId hostRequestId, String str, String str2, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                hostRequestId = childRequestEthereumAccounts.getHostRequestId();
            }
            if ((i2 & 2) != 0) {
                str = childRequestEthereumAccounts.childSessionId;
            }
            if ((i2 & 4) != 0) {
                str2 = childRequestEthereumAccounts.childSessionSecret;
            }
            if ((i2 & 8) != 0) {
                str3 = childRequestEthereumAccounts.version;
            }
            return childRequestEthereumAccounts.copy(hostRequestId, str, str2, str3);
        }

        public final HostRequestId component1() {
            return getHostRequestId();
        }

        public final String component2() {
            return this.childSessionId;
        }

        public final String component3() {
            return this.childSessionSecret;
        }

        public final String component4() {
            return this.version;
        }

        public final ChildRequestEthereumAccounts copy(HostRequestId hostRequestId, String childSessionId, String childSessionSecret, String str) {
            m.g(hostRequestId, "hostRequestId");
            m.g(childSessionId, "childSessionId");
            m.g(childSessionSecret, "childSessionSecret");
            return new ChildRequestEthereumAccounts(hostRequestId, childSessionId, childSessionSecret, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ChildRequestEthereumAccounts) {
                ChildRequestEthereumAccounts childRequestEthereumAccounts = (ChildRequestEthereumAccounts) obj;
                return m.c(getHostRequestId(), childRequestEthereumAccounts.getHostRequestId()) && m.c(this.childSessionId, childRequestEthereumAccounts.childSessionId) && m.c(this.childSessionSecret, childRequestEthereumAccounts.childSessionSecret) && m.c(this.version, childRequestEthereumAccounts.version);
            }
            return false;
        }

        public final String getChildSessionId() {
            return this.childSessionId;
        }

        public final String getChildSessionSecret() {
            return this.childSessionSecret;
        }

        @Override // com.coinbase.walletlink.models.HostRequest
        public HostRequestId getHostRequestId() {
            return this.hostRequestId;
        }

        public final String getVersion() {
            return this.version;
        }

        public int hashCode() {
            int hashCode = ((((getHostRequestId().hashCode() * 31) + this.childSessionId.hashCode()) * 31) + this.childSessionSecret.hashCode()) * 31;
            String str = this.version;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ChildRequestEthereumAccounts(hostRequestId=" + getHostRequestId() + ", childSessionId=" + this.childSessionId + ", childSessionSecret=" + this.childSessionSecret + ", version=" + ((Object) this.version) + ')';
        }
    }

    /* compiled from: HostRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/walletlink/models/HostRequest$RequestCanceled;", "Lcom/coinbase/walletlink/models/HostRequest;", "Lcom/coinbase/walletlink/models/HostRequestId;", "component1", "()Lcom/coinbase/walletlink/models/HostRequestId;", "hostRequestId", "copy", "(Lcom/coinbase/walletlink/models/HostRequestId;)Lcom/coinbase/walletlink/models/HostRequest$RequestCanceled;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/walletlink/models/HostRequestId;", "getHostRequestId", "<init>", "(Lcom/coinbase/walletlink/models/HostRequestId;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class RequestCanceled extends HostRequest {
        private final HostRequestId hostRequestId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestCanceled(HostRequestId hostRequestId) {
            super(hostRequestId, null);
            m.g(hostRequestId, "hostRequestId");
            this.hostRequestId = hostRequestId;
        }

        public static /* synthetic */ RequestCanceled copy$default(RequestCanceled requestCanceled, HostRequestId hostRequestId, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                hostRequestId = requestCanceled.getHostRequestId();
            }
            return requestCanceled.copy(hostRequestId);
        }

        public final HostRequestId component1() {
            return getHostRequestId();
        }

        public final RequestCanceled copy(HostRequestId hostRequestId) {
            m.g(hostRequestId, "hostRequestId");
            return new RequestCanceled(hostRequestId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RequestCanceled) && m.c(getHostRequestId(), ((RequestCanceled) obj).getHostRequestId());
        }

        @Override // com.coinbase.walletlink.models.HostRequest
        public HostRequestId getHostRequestId() {
            return this.hostRequestId;
        }

        public int hashCode() {
            return getHostRequestId().hashCode();
        }

        public String toString() {
            return "RequestCanceled(hostRequestId=" + getHostRequestId() + ')';
        }
    }

    /* compiled from: HostRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\t\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/coinbase/walletlink/models/HostRequest$RequestEthereumAccounts;", "Lcom/coinbase/walletlink/models/HostRequest;", "Lcom/coinbase/walletlink/models/HostRequestId;", "component1", "()Lcom/coinbase/walletlink/models/HostRequestId;", "", "component2", "()Z", "hostRequestId", "isParent", "copy", "(Lcom/coinbase/walletlink/models/HostRequestId;Z)Lcom/coinbase/walletlink/models/HostRequest$RequestEthereumAccounts;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/walletlink/models/HostRequestId;", "getHostRequestId", "Z", "<init>", "(Lcom/coinbase/walletlink/models/HostRequestId;Z)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class RequestEthereumAccounts extends HostRequest {
        private final HostRequestId hostRequestId;
        private final boolean isParent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestEthereumAccounts(HostRequestId hostRequestId, boolean z) {
            super(hostRequestId, null);
            m.g(hostRequestId, "hostRequestId");
            this.hostRequestId = hostRequestId;
            this.isParent = z;
        }

        public static /* synthetic */ RequestEthereumAccounts copy$default(RequestEthereumAccounts requestEthereumAccounts, HostRequestId hostRequestId, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                hostRequestId = requestEthereumAccounts.getHostRequestId();
            }
            if ((i2 & 2) != 0) {
                z = requestEthereumAccounts.isParent;
            }
            return requestEthereumAccounts.copy(hostRequestId, z);
        }

        public final HostRequestId component1() {
            return getHostRequestId();
        }

        public final boolean component2() {
            return this.isParent;
        }

        public final RequestEthereumAccounts copy(HostRequestId hostRequestId, boolean z) {
            m.g(hostRequestId, "hostRequestId");
            return new RequestEthereumAccounts(hostRequestId, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RequestEthereumAccounts) {
                RequestEthereumAccounts requestEthereumAccounts = (RequestEthereumAccounts) obj;
                return m.c(getHostRequestId(), requestEthereumAccounts.getHostRequestId()) && this.isParent == requestEthereumAccounts.isParent;
            }
            return false;
        }

        @Override // com.coinbase.walletlink.models.HostRequest
        public HostRequestId getHostRequestId() {
            return this.hostRequestId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = getHostRequestId().hashCode() * 31;
            boolean z = this.isParent;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            return hashCode + i2;
        }

        public final boolean isParent() {
            return this.isParent;
        }

        public String toString() {
            return "RequestEthereumAccounts(hostRequestId=" + getHostRequestId() + ", isParent=" + this.isParent + ')';
        }
    }

    /* compiled from: HostRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001e\u001a\u00020\t\u0012\u0006\u0010\u001f\u001a\u00020\f\u0012\b\u0010 \u001a\u0004\u0018\u00010\u000f\u0012\b\u0010!\u001a\u0004\u0018\u00010\t\u0012\b\u0010\"\u001a\u0004\u0018\u00010\t\u0012\b\u0010#\u001a\u0004\u0018\u00010\t\u0012\b\u0010$\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010%\u001a\u00020\u000f\u0012\u0006\u0010&\u001a\u00020\u0018¢\u0006\u0004\bB\u0010CJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000bJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000bJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000bJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000bJ\u0010\u0010\u0016\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0094\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001e\u001a\u00020\t2\b\b\u0002\u0010\u001f\u001a\u00020\f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u0018HÆ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b)\u0010\u0007J\u0010\u0010*\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b*\u0010\u0017J\u001a\u0010-\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010+HÖ\u0003¢\u0006\u0004\b-\u0010.R\u0019\u0010\u001c\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b0\u0010\u0007R\u001b\u0010\"\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00101\u001a\u0004\b2\u0010\u000bR\u001b\u0010!\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b!\u00101\u001a\u0004\b3\u0010\u000bR\u0019\u0010\u001f\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00104\u001a\u0004\b5\u0010\u000eR\u0019\u0010%\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b%\u00106\u001a\u0004\b7\u0010\u0017R\u001b\u0010 \u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b \u00108\u001a\u0004\b9\u0010\u0011R\u001c\u0010\u001b\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010:\u001a\u0004\b;\u0010\u0004R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010/\u001a\u0004\b<\u0010\u0007R\u0019\u0010\u001e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00101\u001a\u0004\b=\u0010\u000bR\u001b\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b#\u00101\u001a\u0004\b>\u0010\u000bR\u0019\u0010&\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010?\u001a\u0004\b@\u0010\u001aR\u001b\u0010$\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b$\u00101\u001a\u0004\bA\u0010\u000b¨\u0006D"}, d2 = {"Lcom/coinbase/walletlink/models/HostRequest$SignAndSubmitTx;", "Lcom/coinbase/walletlink/models/HostRequest;", "Lcom/coinbase/walletlink/models/HostRequestId;", "component1", "()Lcom/coinbase/walletlink/models/HostRequestId;", "", "component2", "()Ljava/lang/String;", "component3", "Ljava/math/BigInteger;", "component4", "()Ljava/math/BigInteger;", "", "component5", "()[B", "", "component6", "()Ljava/lang/Integer;", "component7", "component8", "component9", "component10", "component11", "()I", "", "component12", "()Z", "hostRequestId", "fromAddress", "toAddress", "weiValue", "data", AdjustableMinerFeeArgs.NONCE, "gasPrice", "maxFeePerGas", "maxPriorityFeePerGas", "gasLimit", RouteActionKey.RouteActionKeys.CHAIN_ID, "shouldSubmit", "copy", "(Lcom/coinbase/walletlink/models/HostRequestId;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;[BLjava/lang/Integer;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;IZ)Lcom/coinbase/walletlink/models/HostRequest$SignAndSubmitTx;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFromAddress", "Ljava/math/BigInteger;", "getMaxFeePerGas", "getGasPrice", "[B", "getData", "I", "getChainId", "Ljava/lang/Integer;", "getNonce", "Lcom/coinbase/walletlink/models/HostRequestId;", "getHostRequestId", "getToAddress", "getWeiValue", "getMaxPriorityFeePerGas", "Z", "getShouldSubmit", "getGasLimit", "<init>", "(Lcom/coinbase/walletlink/models/HostRequestId;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;[BLjava/lang/Integer;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;IZ)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class SignAndSubmitTx extends HostRequest {
        private final int chainId;
        private final byte[] data;
        private final String fromAddress;
        private final BigInteger gasLimit;
        private final BigInteger gasPrice;
        private final HostRequestId hostRequestId;
        private final BigInteger maxFeePerGas;
        private final BigInteger maxPriorityFeePerGas;
        private final Integer nonce;
        private final boolean shouldSubmit;
        private final String toAddress;
        private final BigInteger weiValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SignAndSubmitTx(HostRequestId hostRequestId, String fromAddress, String str, BigInteger weiValue, byte[] data, Integer num, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i2, boolean z) {
            super(hostRequestId, null);
            m.g(hostRequestId, "hostRequestId");
            m.g(fromAddress, "fromAddress");
            m.g(weiValue, "weiValue");
            m.g(data, "data");
            this.hostRequestId = hostRequestId;
            this.fromAddress = fromAddress;
            this.toAddress = str;
            this.weiValue = weiValue;
            this.data = data;
            this.nonce = num;
            this.gasPrice = bigInteger;
            this.maxFeePerGas = bigInteger2;
            this.maxPriorityFeePerGas = bigInteger3;
            this.gasLimit = bigInteger4;
            this.chainId = i2;
            this.shouldSubmit = z;
        }

        public final HostRequestId component1() {
            return getHostRequestId();
        }

        public final BigInteger component10() {
            return this.gasLimit;
        }

        public final int component11() {
            return this.chainId;
        }

        public final boolean component12() {
            return this.shouldSubmit;
        }

        public final String component2() {
            return this.fromAddress;
        }

        public final String component3() {
            return this.toAddress;
        }

        public final BigInteger component4() {
            return this.weiValue;
        }

        public final byte[] component5() {
            return this.data;
        }

        public final Integer component6() {
            return this.nonce;
        }

        public final BigInteger component7() {
            return this.gasPrice;
        }

        public final BigInteger component8() {
            return this.maxFeePerGas;
        }

        public final BigInteger component9() {
            return this.maxPriorityFeePerGas;
        }

        public final SignAndSubmitTx copy(HostRequestId hostRequestId, String fromAddress, String str, BigInteger weiValue, byte[] data, Integer num, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i2, boolean z) {
            m.g(hostRequestId, "hostRequestId");
            m.g(fromAddress, "fromAddress");
            m.g(weiValue, "weiValue");
            m.g(data, "data");
            return new SignAndSubmitTx(hostRequestId, fromAddress, str, weiValue, data, num, bigInteger, bigInteger2, bigInteger3, bigInteger4, i2, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SignAndSubmitTx) {
                SignAndSubmitTx signAndSubmitTx = (SignAndSubmitTx) obj;
                return m.c(getHostRequestId(), signAndSubmitTx.getHostRequestId()) && m.c(this.fromAddress, signAndSubmitTx.fromAddress) && m.c(this.toAddress, signAndSubmitTx.toAddress) && m.c(this.weiValue, signAndSubmitTx.weiValue) && m.c(this.data, signAndSubmitTx.data) && m.c(this.nonce, signAndSubmitTx.nonce) && m.c(this.gasPrice, signAndSubmitTx.gasPrice) && m.c(this.maxFeePerGas, signAndSubmitTx.maxFeePerGas) && m.c(this.maxPriorityFeePerGas, signAndSubmitTx.maxPriorityFeePerGas) && m.c(this.gasLimit, signAndSubmitTx.gasLimit) && this.chainId == signAndSubmitTx.chainId && this.shouldSubmit == signAndSubmitTx.shouldSubmit;
            }
            return false;
        }

        public final int getChainId() {
            return this.chainId;
        }

        public final byte[] getData() {
            return this.data;
        }

        public final String getFromAddress() {
            return this.fromAddress;
        }

        public final BigInteger getGasLimit() {
            return this.gasLimit;
        }

        public final BigInteger getGasPrice() {
            return this.gasPrice;
        }

        @Override // com.coinbase.walletlink.models.HostRequest
        public HostRequestId getHostRequestId() {
            return this.hostRequestId;
        }

        public final BigInteger getMaxFeePerGas() {
            return this.maxFeePerGas;
        }

        public final BigInteger getMaxPriorityFeePerGas() {
            return this.maxPriorityFeePerGas;
        }

        public final Integer getNonce() {
            return this.nonce;
        }

        public final boolean getShouldSubmit() {
            return this.shouldSubmit;
        }

        public final String getToAddress() {
            return this.toAddress;
        }

        public final BigInteger getWeiValue() {
            return this.weiValue;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((getHostRequestId().hashCode() * 31) + this.fromAddress.hashCode()) * 31;
            String str = this.toAddress;
            int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.weiValue.hashCode()) * 31) + Arrays.hashCode(this.data)) * 31;
            Integer num = this.nonce;
            int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            BigInteger bigInteger = this.gasPrice;
            int hashCode4 = (hashCode3 + (bigInteger == null ? 0 : bigInteger.hashCode())) * 31;
            BigInteger bigInteger2 = this.maxFeePerGas;
            int hashCode5 = (hashCode4 + (bigInteger2 == null ? 0 : bigInteger2.hashCode())) * 31;
            BigInteger bigInteger3 = this.maxPriorityFeePerGas;
            int hashCode6 = (hashCode5 + (bigInteger3 == null ? 0 : bigInteger3.hashCode())) * 31;
            BigInteger bigInteger4 = this.gasLimit;
            int hashCode7 = (((hashCode6 + (bigInteger4 != null ? bigInteger4.hashCode() : 0)) * 31) + this.chainId) * 31;
            boolean z = this.shouldSubmit;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            return hashCode7 + i2;
        }

        public String toString() {
            return "SignAndSubmitTx(hostRequestId=" + getHostRequestId() + ", fromAddress=" + this.fromAddress + ", toAddress=" + ((Object) this.toAddress) + ", weiValue=" + this.weiValue + ", data=" + Arrays.toString(this.data) + ", nonce=" + this.nonce + ", gasPrice=" + this.gasPrice + ", maxFeePerGas=" + this.maxFeePerGas + ", maxPriorityFeePerGas=" + this.maxPriorityFeePerGas + ", gasLimit=" + this.gasLimit + ", chainId=" + this.chainId + ", shouldSubmit=" + this.shouldSubmit + ')';
        }
    }

    /* compiled from: HostRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007JD\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b\u0010\u0010\u000bR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b \u0010\u0007R\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/coinbase/walletlink/models/HostRequest$SignMessage;", "Lcom/coinbase/walletlink/models/HostRequest;", "Lcom/coinbase/walletlink/models/HostRequestId;", "component1", "()Lcom/coinbase/walletlink/models/HostRequestId;", "", "component2", "()Ljava/lang/String;", "component3", "", "component4", "()Z", "component5", "hostRequestId", "address", ApiConstants.MESSAGE, "isPrefixed", "typedDataJson", "copy", "(Lcom/coinbase/walletlink/models/HostRequestId;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lcom/coinbase/walletlink/models/HostRequest$SignMessage;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMessage", "getAddress", "Z", "getTypedDataJson", "Lcom/coinbase/walletlink/models/HostRequestId;", "getHostRequestId", "<init>", "(Lcom/coinbase/walletlink/models/HostRequestId;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class SignMessage extends HostRequest {
        private final String address;
        private final HostRequestId hostRequestId;
        private final boolean isPrefixed;
        private final String message;
        private final String typedDataJson;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SignMessage(HostRequestId hostRequestId, String address, String message, boolean z, String str) {
            super(hostRequestId, null);
            m.g(hostRequestId, "hostRequestId");
            m.g(address, "address");
            m.g(message, "message");
            this.hostRequestId = hostRequestId;
            this.address = address;
            this.message = message;
            this.isPrefixed = z;
            this.typedDataJson = str;
        }

        public static /* synthetic */ SignMessage copy$default(SignMessage signMessage, HostRequestId hostRequestId, String str, String str2, boolean z, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                hostRequestId = signMessage.getHostRequestId();
            }
            if ((i2 & 2) != 0) {
                str = signMessage.address;
            }
            String str4 = str;
            if ((i2 & 4) != 0) {
                str2 = signMessage.message;
            }
            String str5 = str2;
            if ((i2 & 8) != 0) {
                z = signMessage.isPrefixed;
            }
            boolean z2 = z;
            if ((i2 & 16) != 0) {
                str3 = signMessage.typedDataJson;
            }
            return signMessage.copy(hostRequestId, str4, str5, z2, str3);
        }

        public final HostRequestId component1() {
            return getHostRequestId();
        }

        public final String component2() {
            return this.address;
        }

        public final String component3() {
            return this.message;
        }

        public final boolean component4() {
            return this.isPrefixed;
        }

        public final String component5() {
            return this.typedDataJson;
        }

        public final SignMessage copy(HostRequestId hostRequestId, String address, String message, boolean z, String str) {
            m.g(hostRequestId, "hostRequestId");
            m.g(address, "address");
            m.g(message, "message");
            return new SignMessage(hostRequestId, address, message, z, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SignMessage) {
                SignMessage signMessage = (SignMessage) obj;
                return m.c(getHostRequestId(), signMessage.getHostRequestId()) && m.c(this.address, signMessage.address) && m.c(this.message, signMessage.message) && this.isPrefixed == signMessage.isPrefixed && m.c(this.typedDataJson, signMessage.typedDataJson);
            }
            return false;
        }

        public final String getAddress() {
            return this.address;
        }

        @Override // com.coinbase.walletlink.models.HostRequest
        public HostRequestId getHostRequestId() {
            return this.hostRequestId;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getTypedDataJson() {
            return this.typedDataJson;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((getHostRequestId().hashCode() * 31) + this.address.hashCode()) * 31) + this.message.hashCode()) * 31;
            boolean z = this.isPrefixed;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            int i3 = (hashCode + i2) * 31;
            String str = this.typedDataJson;
            return i3 + (str == null ? 0 : str.hashCode());
        }

        public final boolean isPrefixed() {
            return this.isPrefixed;
        }

        public String toString() {
            return "SignMessage(hostRequestId=" + getHostRequestId() + ", address=" + this.address + ", message=" + this.message + ", isPrefixed=" + this.isPrefixed + ", typedDataJson=" + ((Object) this.typedDataJson) + ')';
        }
    }

    /* compiled from: HostRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\nJ\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007¨\u0006!"}, d2 = {"Lcom/coinbase/walletlink/models/HostRequest$SubmitSignedTx;", "Lcom/coinbase/walletlink/models/HostRequest;", "Lcom/coinbase/walletlink/models/HostRequestId;", "component1", "()Lcom/coinbase/walletlink/models/HostRequestId;", "", "component2", "()[B", "", "component3", "()I", "hostRequestId", "signedTx", RouteActionKey.RouteActionKeys.CHAIN_ID, "copy", "(Lcom/coinbase/walletlink/models/HostRequestId;[BI)Lcom/coinbase/walletlink/models/HostRequest$SubmitSignedTx;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getChainId", "Lcom/coinbase/walletlink/models/HostRequestId;", "getHostRequestId", "[B", "getSignedTx", "<init>", "(Lcom/coinbase/walletlink/models/HostRequestId;[BI)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class SubmitSignedTx extends HostRequest {
        private final int chainId;
        private final HostRequestId hostRequestId;
        private final byte[] signedTx;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubmitSignedTx(HostRequestId hostRequestId, byte[] signedTx, int i2) {
            super(hostRequestId, null);
            m.g(hostRequestId, "hostRequestId");
            m.g(signedTx, "signedTx");
            this.hostRequestId = hostRequestId;
            this.signedTx = signedTx;
            this.chainId = i2;
        }

        public static /* synthetic */ SubmitSignedTx copy$default(SubmitSignedTx submitSignedTx, HostRequestId hostRequestId, byte[] bArr, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                hostRequestId = submitSignedTx.getHostRequestId();
            }
            if ((i3 & 2) != 0) {
                bArr = submitSignedTx.signedTx;
            }
            if ((i3 & 4) != 0) {
                i2 = submitSignedTx.chainId;
            }
            return submitSignedTx.copy(hostRequestId, bArr, i2);
        }

        public final HostRequestId component1() {
            return getHostRequestId();
        }

        public final byte[] component2() {
            return this.signedTx;
        }

        public final int component3() {
            return this.chainId;
        }

        public final SubmitSignedTx copy(HostRequestId hostRequestId, byte[] signedTx, int i2) {
            m.g(hostRequestId, "hostRequestId");
            m.g(signedTx, "signedTx");
            return new SubmitSignedTx(hostRequestId, signedTx, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SubmitSignedTx) {
                SubmitSignedTx submitSignedTx = (SubmitSignedTx) obj;
                return m.c(getHostRequestId(), submitSignedTx.getHostRequestId()) && m.c(this.signedTx, submitSignedTx.signedTx) && this.chainId == submitSignedTx.chainId;
            }
            return false;
        }

        public final int getChainId() {
            return this.chainId;
        }

        @Override // com.coinbase.walletlink.models.HostRequest
        public HostRequestId getHostRequestId() {
            return this.hostRequestId;
        }

        public final byte[] getSignedTx() {
            return this.signedTx;
        }

        public int hashCode() {
            return (((getHostRequestId().hashCode() * 31) + Arrays.hashCode(this.signedTx)) * 31) + this.chainId;
        }

        public String toString() {
            return "SubmitSignedTx(hostRequestId=" + getHostRequestId() + ", signedTx=" + Arrays.toString(this.signedTx) + ", chainId=" + this.chainId + ')';
        }
    }

    /* compiled from: HostRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/coinbase/walletlink/models/HostRequest$SwitchEthereumChain;", "Lcom/coinbase/walletlink/models/HostRequest;", "Lcom/coinbase/walletlink/models/HostRequestId;", "component1", "()Lcom/coinbase/walletlink/models/HostRequestId;", "", "component2", "()I", "hostRequestId", RouteActionKey.RouteActionKeys.CHAIN_ID, "copy", "(Lcom/coinbase/walletlink/models/HostRequestId;I)Lcom/coinbase/walletlink/models/HostRequest$SwitchEthereumChain;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getChainId", "Lcom/coinbase/walletlink/models/HostRequestId;", "getHostRequestId", "<init>", "(Lcom/coinbase/walletlink/models/HostRequestId;I)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class SwitchEthereumChain extends HostRequest {
        private final int chainId;
        private final HostRequestId hostRequestId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SwitchEthereumChain(HostRequestId hostRequestId, int i2) {
            super(hostRequestId, null);
            m.g(hostRequestId, "hostRequestId");
            this.hostRequestId = hostRequestId;
            this.chainId = i2;
        }

        public static /* synthetic */ SwitchEthereumChain copy$default(SwitchEthereumChain switchEthereumChain, HostRequestId hostRequestId, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                hostRequestId = switchEthereumChain.getHostRequestId();
            }
            if ((i3 & 2) != 0) {
                i2 = switchEthereumChain.chainId;
            }
            return switchEthereumChain.copy(hostRequestId, i2);
        }

        public final HostRequestId component1() {
            return getHostRequestId();
        }

        public final int component2() {
            return this.chainId;
        }

        public final SwitchEthereumChain copy(HostRequestId hostRequestId, int i2) {
            m.g(hostRequestId, "hostRequestId");
            return new SwitchEthereumChain(hostRequestId, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SwitchEthereumChain) {
                SwitchEthereumChain switchEthereumChain = (SwitchEthereumChain) obj;
                return m.c(getHostRequestId(), switchEthereumChain.getHostRequestId()) && this.chainId == switchEthereumChain.chainId;
            }
            return false;
        }

        public final int getChainId() {
            return this.chainId;
        }

        @Override // com.coinbase.walletlink.models.HostRequest
        public HostRequestId getHostRequestId() {
            return this.hostRequestId;
        }

        public int hashCode() {
            return (getHostRequestId().hashCode() * 31) + this.chainId;
        }

        public String toString() {
            return "SwitchEthereumChain(hostRequestId=" + getHostRequestId() + ", chainId=" + this.chainId + ')';
        }
    }

    private HostRequest(HostRequestId hostRequestId) {
        this.hostRequestId = hostRequestId;
    }

    public /* synthetic */ HostRequest(HostRequestId hostRequestId, DefaultConstructorMarker defaultConstructorMarker) {
        this(hostRequestId);
    }

    public final String getDappName() {
        return getHostRequestId().getDappName();
    }

    public final Uri getDappUrl() {
        return getHostRequestId().getDappURL();
    }

    public final String getEventId() {
        return getHostRequestId().getEventId();
    }

    public HostRequestId getHostRequestId() {
        return this.hostRequestId;
    }

    public final String getRequestId() {
        return getHostRequestId().getId();
    }

    public final String getSessionId() {
        return getHostRequestId().getSessionId();
    }

    public final boolean isAutoApproveDappPermission() {
        if (!(this instanceof SignMessage ? true : this instanceof SignAndSubmitTx ? true : this instanceof SubmitSignedTx ? true : this instanceof RequestCanceled ? true : this instanceof SwitchEthereumChain)) {
            if (this instanceof ChildRequestEthereumAccounts) {
                return true;
            }
            if (!(this instanceof RequestEthereumAccounts)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!((RequestEthereumAccounts) this).isParent()) {
                return true;
            }
        }
        return false;
    }
}