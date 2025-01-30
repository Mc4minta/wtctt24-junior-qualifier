package com.coinbase.wallet.common.utilities;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: BuildConfigWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0017\u001a\u0004\b\u0018\u0010\u000bR\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\f\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/coinbase/wallet/common/utilities/BuildConfigWrapper;", "", "", "component1", "()Z", "", "component2", "()I", "component3", "", "component4", "()Ljava/lang/String;", "isDebug", "sdkInt", "versionCode", "versionName", "copy", "(ZIILjava/lang/String;)Lcom/coinbase/wallet/common/utilities/BuildConfigWrapper;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getVersionName", "I", "getVersionCode", "getSdkInt", "Z", "<init>", "(ZIILjava/lang/String;)V", "common_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BuildConfigWrapper {
    private final boolean isDebug;
    private final int sdkInt;
    private final int versionCode;
    private final String versionName;

    public BuildConfigWrapper(boolean z, int i2, int i3, String versionName) {
        m.g(versionName, "versionName");
        this.isDebug = z;
        this.sdkInt = i2;
        this.versionCode = i3;
        this.versionName = versionName;
    }

    public static /* synthetic */ BuildConfigWrapper copy$default(BuildConfigWrapper buildConfigWrapper, boolean z, int i2, int i3, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = buildConfigWrapper.isDebug;
        }
        if ((i4 & 2) != 0) {
            i2 = buildConfigWrapper.sdkInt;
        }
        if ((i4 & 4) != 0) {
            i3 = buildConfigWrapper.versionCode;
        }
        if ((i4 & 8) != 0) {
            str = buildConfigWrapper.versionName;
        }
        return buildConfigWrapper.copy(z, i2, i3, str);
    }

    public final boolean component1() {
        return this.isDebug;
    }

    public final int component2() {
        return this.sdkInt;
    }

    public final int component3() {
        return this.versionCode;
    }

    public final String component4() {
        return this.versionName;
    }

    public final BuildConfigWrapper copy(boolean z, int i2, int i3, String versionName) {
        m.g(versionName, "versionName");
        return new BuildConfigWrapper(z, i2, i3, versionName);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BuildConfigWrapper) {
            BuildConfigWrapper buildConfigWrapper = (BuildConfigWrapper) obj;
            return this.isDebug == buildConfigWrapper.isDebug && this.sdkInt == buildConfigWrapper.sdkInt && this.versionCode == buildConfigWrapper.versionCode && m.c(this.versionName, buildConfigWrapper.versionName);
        }
        return false;
    }

    public final int getSdkInt() {
        return this.sdkInt;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.isDebug;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((r0 * 31) + this.sdkInt) * 31) + this.versionCode) * 31) + this.versionName.hashCode();
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    public String toString() {
        return "BuildConfigWrapper(isDebug=" + this.isDebug + ", sdkInt=" + this.sdkInt + ", versionCode=" + this.versionCode + ", versionName=" + this.versionName + ')';
    }
}