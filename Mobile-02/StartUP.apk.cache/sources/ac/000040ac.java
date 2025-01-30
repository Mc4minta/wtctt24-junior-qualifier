package com.toshi.model.local.room;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: Bookmark.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\t\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/toshi/model/local/room/Bookmark;", "", "", "isValidBookmark", "()Z", "", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", MessageBundle.TITLE_ENTRY, "getTitle", "setTitle", "(Ljava/lang/String;)V", "", "createdAt", "J", "getCreatedAt", "()J", "setCreatedAt", "(J)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Bookmark {
    private long createdAt;
    private String title;
    private final String url;

    public Bookmark(String url, String title, long j2) {
        m.g(url, "url");
        m.g(title, "title");
        this.url = url;
        this.title = title;
        this.createdAt = j2;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean isValidBookmark() {
        return !(this.url.length() == 0);
    }

    public final void setCreatedAt(long j2) {
        this.createdAt = j2;
    }

    public final void setTitle(String str) {
        m.g(str, "<set-?>");
        this.title = str;
    }
}