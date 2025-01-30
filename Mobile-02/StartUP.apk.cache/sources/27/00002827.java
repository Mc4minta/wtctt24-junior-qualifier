package com.coinbase.wallet.user.models;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: User.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\r\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/user/models/User;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "", "component3", "()Ljava/lang/Boolean;", "id", "username", "isPublic", "copy", "(ILjava/lang/String;Ljava/lang/Boolean;)Lcom/coinbase/wallet/user/models/User;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getId", "Ljava/lang/String;", "getUsername", "Ljava/lang/Boolean;", "<init>", "(ILjava/lang/String;Ljava/lang/Boolean;)V", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class User {
    private final int id;
    private final Boolean isPublic;
    private final String username;

    public User(int i2, String username, Boolean bool) {
        m.g(username, "username");
        this.id = i2;
        this.username = username;
        this.isPublic = bool;
    }

    public static /* synthetic */ User copy$default(User user, int i2, String str, Boolean bool, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = user.id;
        }
        if ((i3 & 2) != 0) {
            str = user.username;
        }
        if ((i3 & 4) != 0) {
            bool = user.isPublic;
        }
        return user.copy(i2, str, bool);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.username;
    }

    public final Boolean component3() {
        return this.isPublic;
    }

    public final User copy(int i2, String username, Boolean bool) {
        m.g(username, "username");
        return new User(i2, username, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof User) {
            User user = (User) obj;
            return this.id == user.id && m.c(this.username, user.username) && m.c(this.isPublic, user.isPublic);
        }
        return false;
    }

    public final int getId() {
        return this.id;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int hashCode = ((this.id * 31) + this.username.hashCode()) * 31;
        Boolean bool = this.isPublic;
        return hashCode + (bool == null ? 0 : bool.hashCode());
    }

    public final Boolean isPublic() {
        return this.isPublic;
    }

    public String toString() {
        return "User(id=" + this.id + ", username=" + this.username + ", isPublic=" + this.isPublic + ')';
    }

    public /* synthetic */ User(int i2, String str, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, str, (i3 & 4) != 0 ? null : bool);
    }
}