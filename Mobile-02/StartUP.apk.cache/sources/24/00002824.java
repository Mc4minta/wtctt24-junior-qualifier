package com.coinbase.wallet.user.models;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: LegacyUser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004JF\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001c\u0010\u0004R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u001d\u0010\u0004¨\u0006 "}, d2 = {"Lcom/coinbase/wallet/user/models/LegacyUser;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "toshiId", "paymentAddress", "avatar", "username", "displayName", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/user/models/LegacyUser;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAvatar", "getUsername", "getToshiId", "getPaymentAddress", "getDisplayName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class LegacyUser {
    private final String avatar;
    @Json(name = "display_name")
    private final String displayName;
    @Json(name = "payment_address")
    private final String paymentAddress;
    @Json(name = "toshi_id")
    private final String toshiId;
    private final String username;

    public LegacyUser(String toshiId, String paymentAddress, String str, String username, String str2) {
        m.g(toshiId, "toshiId");
        m.g(paymentAddress, "paymentAddress");
        m.g(username, "username");
        this.toshiId = toshiId;
        this.paymentAddress = paymentAddress;
        this.avatar = str;
        this.username = username;
        this.displayName = str2;
    }

    public static /* synthetic */ LegacyUser copy$default(LegacyUser legacyUser, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = legacyUser.toshiId;
        }
        if ((i2 & 2) != 0) {
            str2 = legacyUser.paymentAddress;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = legacyUser.avatar;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = legacyUser.username;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = legacyUser.displayName;
        }
        return legacyUser.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.toshiId;
    }

    public final String component2() {
        return this.paymentAddress;
    }

    public final String component3() {
        return this.avatar;
    }

    public final String component4() {
        return this.username;
    }

    public final String component5() {
        return this.displayName;
    }

    public final LegacyUser copy(String toshiId, String paymentAddress, String str, String username, String str2) {
        m.g(toshiId, "toshiId");
        m.g(paymentAddress, "paymentAddress");
        m.g(username, "username");
        return new LegacyUser(toshiId, paymentAddress, str, username, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LegacyUser) {
            LegacyUser legacyUser = (LegacyUser) obj;
            return m.c(this.toshiId, legacyUser.toshiId) && m.c(this.paymentAddress, legacyUser.paymentAddress) && m.c(this.avatar, legacyUser.avatar) && m.c(this.username, legacyUser.username) && m.c(this.displayName, legacyUser.displayName);
        }
        return false;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getPaymentAddress() {
        return this.paymentAddress;
    }

    public final String getToshiId() {
        return this.toshiId;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int hashCode = ((this.toshiId.hashCode() * 31) + this.paymentAddress.hashCode()) * 31;
        String str = this.avatar;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.username.hashCode()) * 31;
        String str2 = this.displayName;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "LegacyUser(toshiId=" + this.toshiId + ", paymentAddress=" + this.paymentAddress + ", avatar=" + ((Object) this.avatar) + ", username=" + this.username + ", displayName=" + ((Object) this.displayName) + ')';
    }
}