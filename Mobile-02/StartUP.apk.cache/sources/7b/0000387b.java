package com.google.api.services.drive.model;

import e.g.b.a.c.b;
import e.g.b.a.d.l;
import e.g.b.a.d.q;

/* loaded from: classes2.dex */
public final class Reply extends b {
    @q
    private String action;
    @q
    private User author;
    @q
    private String content;
    @q
    private l createdTime;
    @q
    private Boolean deleted;
    @q
    private String htmlContent;
    @q
    private String id;
    @q
    private String kind;
    @q
    private l modifiedTime;

    public String getAction() {
        return this.action;
    }

    public User getAuthor() {
        return this.author;
    }

    public String getContent() {
        return this.content;
    }

    public l getCreatedTime() {
        return this.createdTime;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public String getHtmlContent() {
        return this.htmlContent;
    }

    public String getId() {
        return this.id;
    }

    public String getKind() {
        return this.kind;
    }

    public l getModifiedTime() {
        return this.modifiedTime;
    }

    public Reply setAction(String str) {
        this.action = str;
        return this;
    }

    public Reply setAuthor(User user) {
        this.author = user;
        return this;
    }

    public Reply setContent(String str) {
        this.content = str;
        return this;
    }

    public Reply setCreatedTime(l lVar) {
        this.createdTime = lVar;
        return this;
    }

    public Reply setDeleted(Boolean bool) {
        this.deleted = bool;
        return this;
    }

    public Reply setHtmlContent(String str) {
        this.htmlContent = str;
        return this;
    }

    public Reply setId(String str) {
        this.id = str;
        return this;
    }

    public Reply setKind(String str) {
        this.kind = str;
        return this;
    }

    public Reply setModifiedTime(l lVar) {
        this.modifiedTime = lVar;
        return this;
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public Reply set(String str, Object obj) {
        return (Reply) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public Reply clone() {
        return (Reply) super.clone();
    }
}