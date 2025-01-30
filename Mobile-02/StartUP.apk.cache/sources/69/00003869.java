package com.google.api.services.drive.model;

import e.g.b.a.c.b;
import e.g.b.a.d.l;
import e.g.b.a.d.q;

/* loaded from: classes2.dex */
public final class Change extends b {
    @q
    private File file;
    @q
    private String fileId;
    @q
    private String kind;
    @q
    private Boolean removed;
    @q
    private TeamDrive teamDrive;
    @q
    private String teamDriveId;
    @q
    private l time;
    @q
    private String type;

    public File getFile() {
        return this.file;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getKind() {
        return this.kind;
    }

    public Boolean getRemoved() {
        return this.removed;
    }

    public TeamDrive getTeamDrive() {
        return this.teamDrive;
    }

    public String getTeamDriveId() {
        return this.teamDriveId;
    }

    public l getTime() {
        return this.time;
    }

    public String getType() {
        return this.type;
    }

    public Change setFile(File file) {
        this.file = file;
        return this;
    }

    public Change setFileId(String str) {
        this.fileId = str;
        return this;
    }

    public Change setKind(String str) {
        this.kind = str;
        return this;
    }

    public Change setRemoved(Boolean bool) {
        this.removed = bool;
        return this;
    }

    public Change setTeamDrive(TeamDrive teamDrive) {
        this.teamDrive = teamDrive;
        return this;
    }

    public Change setTeamDriveId(String str) {
        this.teamDriveId = str;
        return this;
    }

    public Change setTime(l lVar) {
        this.time = lVar;
        return this;
    }

    public Change setType(String str) {
        this.type = str;
        return this;
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public Change set(String str, Object obj) {
        return (Change) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public Change clone() {
        return (Change) super.clone();
    }
}