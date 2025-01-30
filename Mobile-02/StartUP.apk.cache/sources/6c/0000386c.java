package com.google.api.services.drive.model;

import e.g.b.a.c.b;
import e.g.b.a.d.l;
import e.g.b.a.d.q;
import java.util.List;

/* loaded from: classes2.dex */
public final class Comment extends b {
    @q
    private String anchor;
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
    @q
    private QuotedFileContent quotedFileContent;
    @q
    private List<Reply> replies;
    @q
    private Boolean resolved;

    public String getAnchor() {
        return this.anchor;
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

    public QuotedFileContent getQuotedFileContent() {
        return this.quotedFileContent;
    }

    public List<Reply> getReplies() {
        return this.replies;
    }

    public Boolean getResolved() {
        return this.resolved;
    }

    public Comment setAnchor(String str) {
        this.anchor = str;
        return this;
    }

    public Comment setAuthor(User user) {
        this.author = user;
        return this;
    }

    public Comment setContent(String str) {
        this.content = str;
        return this;
    }

    public Comment setCreatedTime(l lVar) {
        this.createdTime = lVar;
        return this;
    }

    public Comment setDeleted(Boolean bool) {
        this.deleted = bool;
        return this;
    }

    public Comment setHtmlContent(String str) {
        this.htmlContent = str;
        return this;
    }

    public Comment setId(String str) {
        this.id = str;
        return this;
    }

    public Comment setKind(String str) {
        this.kind = str;
        return this;
    }

    public Comment setModifiedTime(l lVar) {
        this.modifiedTime = lVar;
        return this;
    }

    public Comment setQuotedFileContent(QuotedFileContent quotedFileContent) {
        this.quotedFileContent = quotedFileContent;
        return this;
    }

    public Comment setReplies(List<Reply> list) {
        this.replies = list;
        return this;
    }

    public Comment setResolved(Boolean bool) {
        this.resolved = bool;
        return this;
    }

    /* loaded from: classes2.dex */
    public static final class QuotedFileContent extends b {
        @q
        private String mimeType;
        @q
        private String value;

        public String getMimeType() {
            return this.mimeType;
        }

        public String getValue() {
            return this.value;
        }

        public QuotedFileContent setMimeType(String str) {
            this.mimeType = str;
            return this;
        }

        public QuotedFileContent setValue(String str) {
            this.value = str;
            return this;
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n
        public QuotedFileContent set(String str, Object obj) {
            return (QuotedFileContent) super.set(str, obj);
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
        public QuotedFileContent clone() {
            return (QuotedFileContent) super.clone();
        }
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public Comment set(String str, Object obj) {
        return (Comment) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public Comment clone() {
        return (Comment) super.clone();
    }
}