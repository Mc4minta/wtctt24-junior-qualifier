package com.google.api.services.drive.model;

import e.g.b.a.c.b;
import e.g.b.a.d.j;
import e.g.b.a.d.q;
import java.util.List;

/* loaded from: classes2.dex */
public final class ReplyList extends b {
    @q
    private String kind;
    @q
    private String nextPageToken;
    @q
    private List<Reply> replies;

    static {
        j.i(Reply.class);
    }

    public String getKind() {
        return this.kind;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public List<Reply> getReplies() {
        return this.replies;
    }

    public ReplyList setKind(String str) {
        this.kind = str;
        return this;
    }

    public ReplyList setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public ReplyList setReplies(List<Reply> list) {
        this.replies = list;
        return this;
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public ReplyList set(String str, Object obj) {
        return (ReplyList) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public ReplyList clone() {
        return (ReplyList) super.clone();
    }
}