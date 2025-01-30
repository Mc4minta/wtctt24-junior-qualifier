package com.toshi.view.activity.webView;

import com.appsflyer.share.Constants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;
import com.toshi.model.local.room.Bookmark;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: JSBookmark.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB'\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aB\u0011\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u0019\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001c\u0010\u0015\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0017\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\u0018\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\f\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/toshi/view/activity/webView/JSBookmark;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/lang/String;", "e", MessageBundle.TITLE_ENTRY, "Ljava/util/Date;", "f", "Ljava/util/Date;", Constants.URL_CAMPAIGN, "()Ljava/util/Date;", "createdAt", "b", "address", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V", "Lcom/toshi/model/local/room/Bookmark;", "bookmark", "(Lcom/toshi/model/local/room/Bookmark;)V", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class JSBookmark {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private static final Moshi f11140b = new Moshi.Builder().add(Date.class, new Rfc3339DateJsonAdapter()).build();
    @Json(name = "id")

    /* renamed from: c  reason: collision with root package name */
    private final String f11141c;
    @Json(name = MessageBundle.TITLE_ENTRY)

    /* renamed from: d  reason: collision with root package name */
    private final String f11142d;
    @Json(name = "address")

    /* renamed from: e  reason: collision with root package name */
    private final String f11143e;
    @Json(name = "createdAt")

    /* renamed from: f  reason: collision with root package name */
    private final Date f11144f;

    /* compiled from: JSBookmark.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(List<JSBookmark> list) {
            m.g(list, "list");
            String json = JSBookmark.f11140b.adapter(Types.newParameterizedType(List.class, JSBookmark.class)).toJson(list);
            m.f(json, "adapter.toJson(list)");
            return json;
        }
    }

    public JSBookmark(String id, String title, String address, Date createdAt) {
        m.g(id, "id");
        m.g(title, "title");
        m.g(address, "address");
        m.g(createdAt, "createdAt");
        this.f11141c = id;
        this.f11142d = title;
        this.f11143e = address;
        this.f11144f = createdAt;
    }

    public final String b() {
        return this.f11143e;
    }

    public final Date c() {
        return this.f11144f;
    }

    public final String d() {
        return this.f11141c;
    }

    public final String e() {
        return this.f11142d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JSBookmark) {
            JSBookmark jSBookmark = (JSBookmark) obj;
            return m.c(this.f11141c, jSBookmark.f11141c) && m.c(this.f11142d, jSBookmark.f11142d) && m.c(this.f11143e, jSBookmark.f11143e) && m.c(this.f11144f, jSBookmark.f11144f);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f11141c.hashCode() * 31) + this.f11142d.hashCode()) * 31) + this.f11143e.hashCode()) * 31) + this.f11144f.hashCode();
    }

    public String toString() {
        return "JSBookmark(id=" + this.f11141c + ", title=" + this.f11142d + ", address=" + this.f11143e + ", createdAt=" + this.f11144f + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSBookmark(Bookmark bookmark) {
        this(bookmark.getUrl(), bookmark.getTitle(), bookmark.getUrl(), new Date(bookmark.getCreatedAt()));
        m.g(bookmark, "bookmark");
    }
}