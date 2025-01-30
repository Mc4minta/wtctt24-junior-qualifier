package com.coinbase.wallet.features.cloudbackup.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: BackupPayload.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JV\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b&\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b'\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b(\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b)\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b*\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010$\u001a\u0004\b+\u0010\u0004¨\u0006."}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/models/BackupPayload;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "salt", "iv", "cipherText", "authTag", "hash", "timestamp", "username", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/features/cloudbackup/models/BackupPayload;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getHash", "getTimestamp", "getCipherText", "getAuthTag", "getUsername", "getSalt", "getIv", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BackupPayload implements Parcelable {
    public static final Parcelable.Creator<BackupPayload> CREATOR = new Creator();
    private final String authTag;
    private final String cipherText;
    private final String hash;
    private final String iv;
    private final String salt;
    private final String timestamp;
    private final String username;

    /* compiled from: BackupPayload.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<BackupPayload> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BackupPayload createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new BackupPayload(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BackupPayload[] newArray(int i2) {
            return new BackupPayload[i2];
        }
    }

    public BackupPayload(String salt, String iv, String cipherText, String authTag, String hash, String timestamp, String username) {
        m.g(salt, "salt");
        m.g(iv, "iv");
        m.g(cipherText, "cipherText");
        m.g(authTag, "authTag");
        m.g(hash, "hash");
        m.g(timestamp, "timestamp");
        m.g(username, "username");
        this.salt = salt;
        this.iv = iv;
        this.cipherText = cipherText;
        this.authTag = authTag;
        this.hash = hash;
        this.timestamp = timestamp;
        this.username = username;
    }

    public static /* synthetic */ BackupPayload copy$default(BackupPayload backupPayload, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = backupPayload.salt;
        }
        if ((i2 & 2) != 0) {
            str2 = backupPayload.iv;
        }
        String str8 = str2;
        if ((i2 & 4) != 0) {
            str3 = backupPayload.cipherText;
        }
        String str9 = str3;
        if ((i2 & 8) != 0) {
            str4 = backupPayload.authTag;
        }
        String str10 = str4;
        if ((i2 & 16) != 0) {
            str5 = backupPayload.hash;
        }
        String str11 = str5;
        if ((i2 & 32) != 0) {
            str6 = backupPayload.timestamp;
        }
        String str12 = str6;
        if ((i2 & 64) != 0) {
            str7 = backupPayload.username;
        }
        return backupPayload.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.salt;
    }

    public final String component2() {
        return this.iv;
    }

    public final String component3() {
        return this.cipherText;
    }

    public final String component4() {
        return this.authTag;
    }

    public final String component5() {
        return this.hash;
    }

    public final String component6() {
        return this.timestamp;
    }

    public final String component7() {
        return this.username;
    }

    public final BackupPayload copy(String salt, String iv, String cipherText, String authTag, String hash, String timestamp, String username) {
        m.g(salt, "salt");
        m.g(iv, "iv");
        m.g(cipherText, "cipherText");
        m.g(authTag, "authTag");
        m.g(hash, "hash");
        m.g(timestamp, "timestamp");
        m.g(username, "username");
        return new BackupPayload(salt, iv, cipherText, authTag, hash, timestamp, username);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BackupPayload) {
            BackupPayload backupPayload = (BackupPayload) obj;
            return m.c(this.salt, backupPayload.salt) && m.c(this.iv, backupPayload.iv) && m.c(this.cipherText, backupPayload.cipherText) && m.c(this.authTag, backupPayload.authTag) && m.c(this.hash, backupPayload.hash) && m.c(this.timestamp, backupPayload.timestamp) && m.c(this.username, backupPayload.username);
        }
        return false;
    }

    public final String getAuthTag() {
        return this.authTag;
    }

    public final String getCipherText() {
        return this.cipherText;
    }

    public final String getHash() {
        return this.hash;
    }

    public final String getIv() {
        return this.iv;
    }

    public final String getSalt() {
        return this.salt;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return (((((((((((this.salt.hashCode() * 31) + this.iv.hashCode()) * 31) + this.cipherText.hashCode()) * 31) + this.authTag.hashCode()) * 31) + this.hash.hashCode()) * 31) + this.timestamp.hashCode()) * 31) + this.username.hashCode();
    }

    public String toString() {
        return "BackupPayload(salt=" + this.salt + ", iv=" + this.iv + ", cipherText=" + this.cipherText + ", authTag=" + this.authTag + ", hash=" + this.hash + ", timestamp=" + this.timestamp + ", username=" + this.username + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(this.salt);
        out.writeString(this.iv);
        out.writeString(this.cipherText);
        out.writeString(this.authTag);
        out.writeString(this.hash);
        out.writeString(this.timestamp);
        out.writeString(this.username);
    }
}