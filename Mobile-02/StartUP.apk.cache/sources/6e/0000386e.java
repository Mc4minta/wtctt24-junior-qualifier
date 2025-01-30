package com.google.api.services.drive.model;

import e.g.b.a.c.b;
import e.g.b.a.d.j;
import e.g.b.a.d.q;
import java.util.List;

/* loaded from: classes2.dex */
public final class CommentList extends b {
    @q
    private List<Comment> comments;
    @q
    private String kind;
    @q
    private String nextPageToken;

    static {
        j.i(Comment.class);
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    public String getKind() {
        return this.kind;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public CommentList setComments(List<Comment> list) {
        this.comments = list;
        return this;
    }

    public CommentList setKind(String str) {
        this.kind = str;
        return this;
    }

    public CommentList setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public CommentList set(String str, Object obj) {
        return (CommentList) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public CommentList clone() {
        return (CommentList) super.clone();
    }
}