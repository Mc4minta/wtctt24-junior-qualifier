package com.google.api.services.drive.model;

import e.g.b.a.c.b;
import e.g.b.a.d.j;
import e.g.b.a.d.q;
import java.util.List;

/* loaded from: classes2.dex */
public final class RevisionList extends b {
    @q
    private String kind;
    @q
    private String nextPageToken;
    @q
    private List<Revision> revisions;

    static {
        j.i(Revision.class);
    }

    public String getKind() {
        return this.kind;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public List<Revision> getRevisions() {
        return this.revisions;
    }

    public RevisionList setKind(String str) {
        this.kind = str;
        return this;
    }

    public RevisionList setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public RevisionList setRevisions(List<Revision> list) {
        this.revisions = list;
        return this;
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public RevisionList set(String str, Object obj) {
        return (RevisionList) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public RevisionList clone() {
        return (RevisionList) super.clone();
    }
}