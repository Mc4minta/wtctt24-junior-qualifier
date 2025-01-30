package com.google.api.services.drive.model;

import e.g.b.a.c.b;
import e.g.b.a.d.j;
import e.g.b.a.d.q;
import java.util.List;

/* loaded from: classes2.dex */
public final class FileList extends b {
    @q
    private List<File> files;
    @q
    private Boolean incompleteSearch;
    @q
    private String kind;
    @q
    private String nextPageToken;

    static {
        j.i(File.class);
    }

    public List<File> getFiles() {
        return this.files;
    }

    public Boolean getIncompleteSearch() {
        return this.incompleteSearch;
    }

    public String getKind() {
        return this.kind;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public FileList setFiles(List<File> list) {
        this.files = list;
        return this;
    }

    public FileList setIncompleteSearch(Boolean bool) {
        this.incompleteSearch = bool;
        return this;
    }

    public FileList setKind(String str) {
        this.kind = str;
        return this;
    }

    public FileList setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public FileList set(String str, Object obj) {
        return (FileList) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public FileList clone() {
        return (FileList) super.clone();
    }
}