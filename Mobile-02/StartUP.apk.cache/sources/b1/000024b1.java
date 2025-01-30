package com.coinbase.wallet.libraries.databases.model;

import android.content.Context;
import androidx.room.s.a;
import com.coinbase.wallet.libraries.databases.interfaces.StorageOptions;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: DiskOptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B?\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012JT\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00032\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\b\b\u0002\u0010\u0015\u001a\u00020\t2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u0017\u001a\u00020\u0010HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u000bJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!R\u0019\u0010\u0015\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b#\u0010\u000bR\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b%\u0010\bR\u0019\u0010\u0017\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010\u0012R\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010\u000fR\u0019\u0010\u0013\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b+\u0010\u0005¨\u0006."}, d2 = {"Lcom/coinbase/wallet/libraries/databases/model/DiskOptions;", "T", "Lcom/coinbase/wallet/libraries/databases/interfaces/StorageOptions;", "Landroid/content/Context;", "component1", "()Landroid/content/Context;", "Ljava/lang/Class;", "component2", "()Ljava/lang/Class;", "", "component3", "()Ljava/lang/String;", "", "Landroidx/room/s/a;", "component4", "()Ljava/util/List;", "", "component5", "()Z", "context", "providerClass", "dbName", "migrations", "destructiveFallback", "copy", "(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;Ljava/util/List;Z)Lcom/coinbase/wallet/libraries/databases/model/DiskOptions;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDbName", "Ljava/lang/Class;", "getProviderClass", "Z", "getDestructiveFallback", "Ljava/util/List;", "getMigrations", "Landroid/content/Context;", "getContext", "<init>", "(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;Ljava/util/List;Z)V", "database_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class DiskOptions<T> implements StorageOptions {
    private final Context context;
    private final String dbName;
    private final boolean destructiveFallback;
    private final List<a> migrations;
    private final Class<T> providerClass;

    /* JADX WARN: Multi-variable type inference failed */
    public DiskOptions(Context context, Class<T> providerClass, String dbName, List<? extends a> migrations, boolean z) {
        m.g(context, "context");
        m.g(providerClass, "providerClass");
        m.g(dbName, "dbName");
        m.g(migrations, "migrations");
        this.context = context;
        this.providerClass = providerClass;
        this.dbName = dbName;
        this.migrations = migrations;
        this.destructiveFallback = z;
    }

    public static /* synthetic */ DiskOptions copy$default(DiskOptions diskOptions, Context context, Class cls, String str, List list, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = diskOptions.context;
        }
        Class<T> cls2 = cls;
        if ((i2 & 2) != 0) {
            cls2 = diskOptions.providerClass;
        }
        Class cls3 = cls2;
        if ((i2 & 4) != 0) {
            str = diskOptions.dbName;
        }
        String str2 = str;
        List<a> list2 = list;
        if ((i2 & 8) != 0) {
            list2 = diskOptions.migrations;
        }
        List list3 = list2;
        if ((i2 & 16) != 0) {
            z = diskOptions.destructiveFallback;
        }
        return diskOptions.copy(context, cls3, str2, list3, z);
    }

    public final Context component1() {
        return this.context;
    }

    public final Class<T> component2() {
        return this.providerClass;
    }

    public final String component3() {
        return this.dbName;
    }

    public final List<a> component4() {
        return this.migrations;
    }

    public final boolean component5() {
        return this.destructiveFallback;
    }

    public final DiskOptions<T> copy(Context context, Class<T> providerClass, String dbName, List<? extends a> migrations, boolean z) {
        m.g(context, "context");
        m.g(providerClass, "providerClass");
        m.g(dbName, "dbName");
        m.g(migrations, "migrations");
        return new DiskOptions<>(context, providerClass, dbName, migrations, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DiskOptions) {
            DiskOptions diskOptions = (DiskOptions) obj;
            return m.c(this.context, diskOptions.context) && m.c(this.providerClass, diskOptions.providerClass) && m.c(this.dbName, diskOptions.dbName) && m.c(this.migrations, diskOptions.migrations) && this.destructiveFallback == diskOptions.destructiveFallback;
        }
        return false;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getDbName() {
        return this.dbName;
    }

    public final boolean getDestructiveFallback() {
        return this.destructiveFallback;
    }

    public final List<a> getMigrations() {
        return this.migrations;
    }

    public final Class<T> getProviderClass() {
        return this.providerClass;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.context.hashCode() * 31) + this.providerClass.hashCode()) * 31) + this.dbName.hashCode()) * 31) + this.migrations.hashCode()) * 31;
        boolean z = this.destructiveFallback;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public String toString() {
        return "DiskOptions(context=" + this.context + ", providerClass=" + this.providerClass + ", dbName=" + this.dbName + ", migrations=" + this.migrations + ", destructiveFallback=" + this.destructiveFallback + ')';
    }

    public /* synthetic */ DiskOptions(Context context, Class cls, String str, List list, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, cls, str, (i2 & 8) != 0 ? r.g() : list, (i2 & 16) != 0 ? false : z);
    }
}