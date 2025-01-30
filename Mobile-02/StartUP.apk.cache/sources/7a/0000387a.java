package com.google.api.services.drive.model;

import e.g.b.a.c.b;
import e.g.b.a.d.j;
import e.g.b.a.d.q;
import java.util.List;

/* loaded from: classes2.dex */
public final class PermissionList extends b {
    @q
    private String kind;
    @q
    private String nextPageToken;
    @q
    private List<Permission> permissions;

    static {
        j.i(Permission.class);
    }

    public String getKind() {
        return this.kind;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public List<Permission> getPermissions() {
        return this.permissions;
    }

    public PermissionList setKind(String str) {
        this.kind = str;
        return this;
    }

    public PermissionList setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public PermissionList setPermissions(List<Permission> list) {
        this.permissions = list;
        return this;
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public PermissionList set(String str, Object obj) {
        return (PermissionList) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public PermissionList clone() {
        return (PermissionList) super.clone();
    }
}