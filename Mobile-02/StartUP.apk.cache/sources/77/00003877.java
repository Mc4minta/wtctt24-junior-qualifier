package com.google.api.services.drive.model;

import e.g.b.a.c.b;
import e.g.b.a.d.q;
import java.util.List;

/* loaded from: classes2.dex */
public final class GeneratedIds extends b {
    @q
    private List<String> ids;
    @q
    private String kind;
    @q
    private String space;

    public List<String> getIds() {
        return this.ids;
    }

    public String getKind() {
        return this.kind;
    }

    public String getSpace() {
        return this.space;
    }

    public GeneratedIds setIds(List<String> list) {
        this.ids = list;
        return this;
    }

    public GeneratedIds setKind(String str) {
        this.kind = str;
        return this;
    }

    public GeneratedIds setSpace(String str) {
        this.space = str;
        return this;
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public GeneratedIds set(String str, Object obj) {
        return (GeneratedIds) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public GeneratedIds clone() {
        return (GeneratedIds) super.clone();
    }
}