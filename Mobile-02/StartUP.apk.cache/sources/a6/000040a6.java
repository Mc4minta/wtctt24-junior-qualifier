package com.toshi.model.local.dapp;

import com.coinbase.ApiConstants;
import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: Dapp.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001-BU\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b+\u0010,J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJh\u0010\u0017\u001a\u00020\u00002\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b\"\u0010\u0007R\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b$\u0010\u000fR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b%\u0010\u0007R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b&\u0010\u0007R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010'\u001a\u0004\b(\u0010\u0004R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b)\u0010\u0007R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b*\u0010\u0007¨\u0006."}, d2 = {"Lcom/toshi/model/local/dapp/Dapp;", "Lcom/toshi/model/local/dapp/DappListItem;", "", "component1", "()Ljava/lang/Long;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "", "", "component7", "()Ljava/util/List;", "dappId", ApiConstants.NAME, "url", ApiConstants.DESCRIPTION, "icon", "cover", "categories", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/toshi/model/local/dapp/Dapp;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCover", "Ljava/util/List;", "getCategories", "getUrl", "getName", "Ljava/lang/Long;", "getDappId", "getIcon", "getDescription", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Dapp extends DappListItem {
    public static final Companion Companion = new Companion(null);
    public static final String URL = "url";
    private final List<Integer> categories;
    private final String cover;
    private final Long dappId;
    private final String description;
    private final String icon;
    private final String name;
    private final String url;

    /* compiled from: Dapp.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/toshi/model/local/dapp/Dapp$Companion;", "", "", "URL", "Ljava/lang/String;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ Dapp(java.lang.Long r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.util.List r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r9 = this;
            r0 = r17 & 64
            if (r0 == 0) goto La
            java.util.List r0 = kotlin.a0.p.g()
            r8 = r0
            goto Lc
        La:
            r8 = r16
        Lc:
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.toshi.model.local.dapp.Dapp.<init>(java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ Dapp copy$default(Dapp dapp, Long l2, String str, String str2, String str3, String str4, String str5, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            l2 = dapp.dappId;
        }
        if ((i2 & 2) != 0) {
            str = dapp.name;
        }
        String str6 = str;
        if ((i2 & 4) != 0) {
            str2 = dapp.url;
        }
        String str7 = str2;
        if ((i2 & 8) != 0) {
            str3 = dapp.description;
        }
        String str8 = str3;
        if ((i2 & 16) != 0) {
            str4 = dapp.icon;
        }
        String str9 = str4;
        if ((i2 & 32) != 0) {
            str5 = dapp.cover;
        }
        String str10 = str5;
        List<Integer> list2 = list;
        if ((i2 & 64) != 0) {
            list2 = dapp.categories;
        }
        return dapp.copy(l2, str6, str7, str8, str9, str10, list2);
    }

    public final Long component1() {
        return this.dappId;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.url;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.icon;
    }

    public final String component6() {
        return this.cover;
    }

    public final List<Integer> component7() {
        return this.categories;
    }

    public final Dapp copy(@Json(name = "dapp_id") Long l2, String str, String str2, String str3, String str4, String str5, List<Integer> categories) {
        m.g(categories, "categories");
        return new Dapp(l2, str, str2, str3, str4, str5, categories);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Dapp) {
            Dapp dapp = (Dapp) obj;
            return m.c(this.dappId, dapp.dappId) && m.c(this.name, dapp.name) && m.c(this.url, dapp.url) && m.c(this.description, dapp.description) && m.c(this.icon, dapp.icon) && m.c(this.cover, dapp.cover) && m.c(this.categories, dapp.categories);
        }
        return false;
    }

    public final List<Integer> getCategories() {
        return this.categories;
    }

    public final String getCover() {
        return this.cover;
    }

    public final Long getDappId() {
        return this.dappId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        Long l2 = this.dappId;
        int hashCode = (l2 == null ? 0 : l2.hashCode()) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.url;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.icon;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.cover;
        return ((hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.categories.hashCode();
    }

    public String toString() {
        return "Dapp(dappId=" + this.dappId + ", name=" + ((Object) this.name) + ", url=" + ((Object) this.url) + ", description=" + ((Object) this.description) + ", icon=" + ((Object) this.icon) + ", cover=" + ((Object) this.cover) + ", categories=" + this.categories + ')';
    }

    public Dapp(@Json(name = "dapp_id") Long l2, String str, String str2, String str3, String str4, String str5, List<Integer> categories) {
        m.g(categories, "categories");
        this.dappId = l2;
        this.name = str;
        this.url = str2;
        this.description = str3;
        this.icon = str4;
        this.cover = str5;
        this.categories = categories;
    }
}