package com.coinbase.wallet.features.settings.models;

import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.features.walletlink.models.WalletLinkCompleteArgs;
import com.coinbase.walletlink.models.Session;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.p;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.toshi.R;

/* compiled from: WalletLinkSettingRow.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/features/settings/models/WalletLinkSettingRow;", "", "<init>", "()V", "AllSessions", "DApp", "WalletLinkV1", "Lcom/coinbase/wallet/features/settings/models/WalletLinkSettingRow$AllSessions;", "Lcom/coinbase/wallet/features/settings/models/WalletLinkSettingRow$WalletLinkV1;", "Lcom/coinbase/wallet/features/settings/models/WalletLinkSettingRow$DApp;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class WalletLinkSettingRow {

    /* compiled from: WalletLinkSettingRow.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/features/settings/models/WalletLinkSettingRow$AllSessions;", "Lcom/coinbase/wallet/features/settings/models/WalletLinkSettingRow;", "", "component1", "()I", "sessionCount", "copy", "(I)Lcom/coinbase/wallet/features/settings/models/WalletLinkSettingRow$AllSessions;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", WalletLinkCompleteArgs.DAPP_NAME, "Ljava/lang/String;", "getDappName", "I", "getSessionCount", "<init>", "(I)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class AllSessions extends WalletLinkSettingRow {
        private final String dappName;
        private final int sessionCount;

        public AllSessions(int i2) {
            super(null);
            this.sessionCount = i2;
        }

        public static /* synthetic */ AllSessions copy$default(AllSessions allSessions, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i2 = allSessions.sessionCount;
            }
            return allSessions.copy(i2);
        }

        public final int component1() {
            return this.sessionCount;
        }

        public final AllSessions copy(int i2) {
            return new AllSessions(i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AllSessions) && this.sessionCount == ((AllSessions) obj).sessionCount;
        }

        public final String getDappName() {
            return this.dappName;
        }

        public final int getSessionCount() {
            return this.sessionCount;
        }

        public int hashCode() {
            return this.sessionCount;
        }

        public String toString() {
            return "AllSessions(sessionCount=" + this.sessionCount + ')';
        }
    }

    /* compiled from: WalletLinkSettingRow.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\t8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000bR\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/features/settings/models/WalletLinkSettingRow$DApp;", "Lcom/coinbase/wallet/features/settings/models/WalletLinkSettingRow;", "", "Lcom/coinbase/walletlink/models/Session;", "component1", "()Ljava/util/List;", "sessions", "copy", "(Ljava/util/List;)Lcom/coinbase/wallet/features/settings/models/WalletLinkSettingRow$DApp;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "getDappName", WalletLinkCompleteArgs.DAPP_NAME, "Ljava/util/List;", "getSessions", "<init>", "(Ljava/util/List;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DApp extends WalletLinkSettingRow {
        private final List<Session> sessions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DApp(List<Session> sessions) {
            super(null);
            m.g(sessions, "sessions");
            this.sessions = sessions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DApp copy$default(DApp dApp, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = dApp.sessions;
            }
            return dApp.copy(list);
        }

        public final List<Session> component1() {
            return this.sessions;
        }

        public final DApp copy(List<Session> sessions) {
            m.g(sessions, "sessions");
            return new DApp(sessions);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DApp) && m.c(this.sessions, ((DApp) obj).sessions);
        }

        public final String getDappName() {
            Session session = (Session) p.a0(this.sessions);
            if (session == null) {
                return null;
            }
            return session.getDappName();
        }

        public final List<Session> getSessions() {
            return this.sessions;
        }

        public int hashCode() {
            return this.sessions.hashCode();
        }

        public String toString() {
            return "DApp(sessions=" + this.sessions + ')';
        }
    }

    /* compiled from: WalletLinkSettingRow.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\t8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000bR\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/features/settings/models/WalletLinkSettingRow$WalletLinkV1;", "Lcom/coinbase/wallet/features/settings/models/WalletLinkSettingRow;", "", "Lcom/coinbase/walletlink/models/Session;", "component1", "()Ljava/util/List;", "sessions", "copy", "(Ljava/util/List;)Lcom/coinbase/wallet/features/settings/models/WalletLinkSettingRow$WalletLinkV1;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "getDappName", WalletLinkCompleteArgs.DAPP_NAME, "Ljava/util/List;", "getSessions", "<init>", "(Ljava/util/List;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class WalletLinkV1 extends WalletLinkSettingRow {
        private final List<Session> sessions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WalletLinkV1(List<Session> sessions) {
            super(null);
            m.g(sessions, "sessions");
            this.sessions = sessions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WalletLinkV1 copy$default(WalletLinkV1 walletLinkV1, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = walletLinkV1.sessions;
            }
            return walletLinkV1.copy(list);
        }

        public final List<Session> component1() {
            return this.sessions;
        }

        public final WalletLinkV1 copy(List<Session> sessions) {
            m.g(sessions, "sessions");
            return new WalletLinkV1(sessions);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WalletLinkV1) && m.c(this.sessions, ((WalletLinkV1) obj).sessions);
        }

        public final String getDappName() {
            return LocalizedStrings.INSTANCE.get(R.string.walletlink_v1_dapp_title);
        }

        public final List<Session> getSessions() {
            return this.sessions;
        }

        public int hashCode() {
            return this.sessions.hashCode();
        }

        public String toString() {
            return "WalletLinkV1(sessions=" + this.sessions + ')';
        }
    }

    private WalletLinkSettingRow() {
    }

    public /* synthetic */ WalletLinkSettingRow(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}