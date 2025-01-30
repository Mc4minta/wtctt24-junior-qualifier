package com.google.api.services.drive.model;

import e.g.b.a.c.b;
import e.g.b.a.d.j;
import e.g.b.a.d.q;
import java.util.List;

/* loaded from: classes2.dex */
public final class ChangeList extends b {
    @q
    private List<Change> changes;
    @q
    private String kind;
    @q
    private String newStartPageToken;
    @q
    private String nextPageToken;

    static {
        j.i(Change.class);
    }

    public List<Change> getChanges() {
        return this.changes;
    }

    public String getKind() {
        return this.kind;
    }

    public String getNewStartPageToken() {
        return this.newStartPageToken;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public ChangeList setChanges(List<Change> list) {
        this.changes = list;
        return this;
    }

    public ChangeList setKind(String str) {
        this.kind = str;
        return this;
    }

    public ChangeList setNewStartPageToken(String str) {
        this.newStartPageToken = str;
        return this;
    }

    public ChangeList setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public ChangeList set(String str, Object obj) {
        return (ChangeList) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public ChangeList clone() {
        return (ChangeList) super.clone();
    }
}