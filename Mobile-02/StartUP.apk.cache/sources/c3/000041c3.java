package com.toshi.view.activity.webView;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: CbWalletJavascriptInterface.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\b\u0081\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R!\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\f\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/toshi/view/activity/webView/DappInfo;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "b", ApiConstants.NAME, "", "Ljava/util/List;", "()Ljava/util/List;", "categories", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class DappInfo {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f11139b;

    public DappInfo() {
        this(null, null, 3, null);
    }

    public DappInfo(String str, List<String> list) {
        this.a = str;
        this.f11139b = list;
    }

    public final List<String> a() {
        return this.f11139b;
    }

    public final String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DappInfo) {
            DappInfo dappInfo = (DappInfo) obj;
            return m.c(this.a, dappInfo.a) && m.c(this.f11139b, dappInfo.f11139b);
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.f11139b;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "DappInfo(name=" + ((Object) this.a) + ", categories=" + this.f11139b + ')';
    }

    public /* synthetic */ DappInfo(String str, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? r.g() : list);
    }
}