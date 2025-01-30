package com.google.api.services.drive.model;

import e.g.b.a.c.b;
import e.g.b.a.d.q;

/* loaded from: classes2.dex */
public final class StartPageToken extends b {
    @q
    private String kind;
    @q
    private String startPageToken;

    public String getKind() {
        return this.kind;
    }

    public String getStartPageToken() {
        return this.startPageToken;
    }

    public StartPageToken setKind(String str) {
        this.kind = str;
        return this;
    }

    public StartPageToken setStartPageToken(String str) {
        this.startPageToken = str;
        return this;
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public StartPageToken set(String str, Object obj) {
        return (StartPageToken) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public StartPageToken clone() {
        return (StartPageToken) super.clone();
    }
}