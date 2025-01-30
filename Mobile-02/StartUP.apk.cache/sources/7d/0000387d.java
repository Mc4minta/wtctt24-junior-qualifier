package com.google.api.services.drive.model;

import e.g.b.a.c.b;
import e.g.b.a.c.h;
import e.g.b.a.d.l;
import e.g.b.a.d.q;

/* loaded from: classes2.dex */
public final class Revision extends b {
    @q
    private String id;
    @q
    private Boolean keepForever;
    @q
    private String kind;
    @q
    private User lastModifyingUser;
    @q
    private String md5Checksum;
    @q
    private String mimeType;
    @q
    private l modifiedTime;
    @q
    private String originalFilename;
    @q
    private Boolean publishAuto;
    @q
    private Boolean published;
    @q
    private Boolean publishedOutsideDomain;
    @h
    @q
    private Long size;

    public String getId() {
        return this.id;
    }

    public Boolean getKeepForever() {
        return this.keepForever;
    }

    public String getKind() {
        return this.kind;
    }

    public User getLastModifyingUser() {
        return this.lastModifyingUser;
    }

    public String getMd5Checksum() {
        return this.md5Checksum;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public l getModifiedTime() {
        return this.modifiedTime;
    }

    public String getOriginalFilename() {
        return this.originalFilename;
    }

    public Boolean getPublishAuto() {
        return this.publishAuto;
    }

    public Boolean getPublished() {
        return this.published;
    }

    public Boolean getPublishedOutsideDomain() {
        return this.publishedOutsideDomain;
    }

    public Long getSize() {
        return this.size;
    }

    public Revision setId(String str) {
        this.id = str;
        return this;
    }

    public Revision setKeepForever(Boolean bool) {
        this.keepForever = bool;
        return this;
    }

    public Revision setKind(String str) {
        this.kind = str;
        return this;
    }

    public Revision setLastModifyingUser(User user) {
        this.lastModifyingUser = user;
        return this;
    }

    public Revision setMd5Checksum(String str) {
        this.md5Checksum = str;
        return this;
    }

    public Revision setMimeType(String str) {
        this.mimeType = str;
        return this;
    }

    public Revision setModifiedTime(l lVar) {
        this.modifiedTime = lVar;
        return this;
    }

    public Revision setOriginalFilename(String str) {
        this.originalFilename = str;
        return this;
    }

    public Revision setPublishAuto(Boolean bool) {
        this.publishAuto = bool;
        return this;
    }

    public Revision setPublished(Boolean bool) {
        this.published = bool;
        return this;
    }

    public Revision setPublishedOutsideDomain(Boolean bool) {
        this.publishedOutsideDomain = bool;
        return this;
    }

    public Revision setSize(Long l2) {
        this.size = l2;
        return this;
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public Revision set(String str, Object obj) {
        return (Revision) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public Revision clone() {
        return (Revision) super.clone();
    }
}