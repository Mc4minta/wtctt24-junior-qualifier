package com.coinbase.wallet.features.settings.models;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: UserProfileViewState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\n\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u000b\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/features/settings/models/UserProfileViewState;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "username", "isPublic", "isSwitchingPrivacySetting", "copy", "(Ljava/lang/String;ZZ)Lcom/coinbase/wallet/features/settings/models/UserProfileViewState;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/String;", "getUsername", "<init>", "(Ljava/lang/String;ZZ)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class UserProfileViewState {
    private final boolean isPublic;
    private final boolean isSwitchingPrivacySetting;
    private final String username;

    public UserProfileViewState(String username, boolean z, boolean z2) {
        m.g(username, "username");
        this.username = username;
        this.isPublic = z;
        this.isSwitchingPrivacySetting = z2;
    }

    public static /* synthetic */ UserProfileViewState copy$default(UserProfileViewState userProfileViewState, String str, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = userProfileViewState.username;
        }
        if ((i2 & 2) != 0) {
            z = userProfileViewState.isPublic;
        }
        if ((i2 & 4) != 0) {
            z2 = userProfileViewState.isSwitchingPrivacySetting;
        }
        return userProfileViewState.copy(str, z, z2);
    }

    public final String component1() {
        return this.username;
    }

    public final boolean component2() {
        return this.isPublic;
    }

    public final boolean component3() {
        return this.isSwitchingPrivacySetting;
    }

    public final UserProfileViewState copy(String username, boolean z, boolean z2) {
        m.g(username, "username");
        return new UserProfileViewState(username, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserProfileViewState) {
            UserProfileViewState userProfileViewState = (UserProfileViewState) obj;
            return m.c(this.username, userProfileViewState.username) && this.isPublic == userProfileViewState.isPublic && this.isSwitchingPrivacySetting == userProfileViewState.isSwitchingPrivacySetting;
        }
        return false;
    }

    public final String getUsername() {
        return this.username;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.username.hashCode() * 31;
        boolean z = this.isPublic;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        boolean z2 = this.isSwitchingPrivacySetting;
        return i3 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final boolean isSwitchingPrivacySetting() {
        return this.isSwitchingPrivacySetting;
    }

    public String toString() {
        return "UserProfileViewState(username=" + this.username + ", isPublic=" + this.isPublic + ", isSwitchingPrivacySetting=" + this.isSwitchingPrivacySetting + ')';
    }
}