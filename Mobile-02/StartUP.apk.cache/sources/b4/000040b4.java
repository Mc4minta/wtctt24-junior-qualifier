package com.toshi.model.network;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

/* compiled from: MinimumSupportBuild.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/toshi/model/network/MinimumSupportBuild;", "", "", "component1", "()I", "component2", "android", "ios", "copy", "(II)Lcom/toshi/model/network/MinimumSupportBuild;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getAndroid", "getIos", "<init>", "(II)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class MinimumSupportBuild {

    /* renamed from: android  reason: collision with root package name */
    private final int f11105android;
    private final int ios;

    public MinimumSupportBuild(int i2, int i3) {
        this.f11105android = i2;
        this.ios = i3;
    }

    public static /* synthetic */ MinimumSupportBuild copy$default(MinimumSupportBuild minimumSupportBuild, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = minimumSupportBuild.f11105android;
        }
        if ((i4 & 2) != 0) {
            i3 = minimumSupportBuild.ios;
        }
        return minimumSupportBuild.copy(i2, i3);
    }

    public final int component1() {
        return this.f11105android;
    }

    public final int component2() {
        return this.ios;
    }

    public final MinimumSupportBuild copy(int i2, int i3) {
        return new MinimumSupportBuild(i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MinimumSupportBuild) {
            MinimumSupportBuild minimumSupportBuild = (MinimumSupportBuild) obj;
            return this.f11105android == minimumSupportBuild.f11105android && this.ios == minimumSupportBuild.ios;
        }
        return false;
    }

    public final int getAndroid() {
        return this.f11105android;
    }

    public final int getIos() {
        return this.ios;
    }

    public int hashCode() {
        return (this.f11105android * 31) + this.ios;
    }

    public String toString() {
        return "MinimumSupportBuild(android=" + this.f11105android + ", ios=" + this.ios + ')';
    }
}