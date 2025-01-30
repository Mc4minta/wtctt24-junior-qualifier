package com.google.api.services.drive.model;

import e.g.b.a.c.b;
import e.g.b.a.d.j;
import e.g.b.a.d.q;
import java.util.List;

/* loaded from: classes2.dex */
public final class TeamDriveList extends b {
    @q
    private String kind;
    @q
    private String nextPageToken;
    @q
    private List<TeamDrive> teamDrives;

    static {
        j.i(TeamDrive.class);
    }

    public String getKind() {
        return this.kind;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public List<TeamDrive> getTeamDrives() {
        return this.teamDrives;
    }

    public TeamDriveList setKind(String str) {
        this.kind = str;
        return this;
    }

    public TeamDriveList setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public TeamDriveList setTeamDrives(List<TeamDrive> list) {
        this.teamDrives = list;
        return this;
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public TeamDriveList set(String str, Object obj) {
        return (TeamDriveList) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public TeamDriveList clone() {
        return (TeamDriveList) super.clone();
    }
}