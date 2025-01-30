package com.google.api.services.drive.model;

import e.g.b.a.c.b;
import e.g.b.a.d.j;
import e.g.b.a.d.l;
import e.g.b.a.d.q;
import java.util.List;

/* loaded from: classes2.dex */
public final class Permission extends b {
    @q
    private Boolean allowFileDiscovery;
    @q
    private Boolean deleted;
    @q
    private String displayName;
    @q
    private String domain;
    @q
    private String emailAddress;
    @q
    private l expirationTime;
    @q
    private String id;
    @q
    private String kind;
    @q
    private String photoLink;
    @q
    private String role;
    @q
    private List<TeamDrivePermissionDetails> teamDrivePermissionDetails;
    @q
    private String type;

    static {
        j.i(TeamDrivePermissionDetails.class);
    }

    public Boolean getAllowFileDiscovery() {
        return this.allowFileDiscovery;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public l getExpirationTime() {
        return this.expirationTime;
    }

    public String getId() {
        return this.id;
    }

    public String getKind() {
        return this.kind;
    }

    public String getPhotoLink() {
        return this.photoLink;
    }

    public String getRole() {
        return this.role;
    }

    public List<TeamDrivePermissionDetails> getTeamDrivePermissionDetails() {
        return this.teamDrivePermissionDetails;
    }

    public String getType() {
        return this.type;
    }

    public Permission setAllowFileDiscovery(Boolean bool) {
        this.allowFileDiscovery = bool;
        return this;
    }

    public Permission setDeleted(Boolean bool) {
        this.deleted = bool;
        return this;
    }

    public Permission setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public Permission setDomain(String str) {
        this.domain = str;
        return this;
    }

    public Permission setEmailAddress(String str) {
        this.emailAddress = str;
        return this;
    }

    public Permission setExpirationTime(l lVar) {
        this.expirationTime = lVar;
        return this;
    }

    public Permission setId(String str) {
        this.id = str;
        return this;
    }

    public Permission setKind(String str) {
        this.kind = str;
        return this;
    }

    public Permission setPhotoLink(String str) {
        this.photoLink = str;
        return this;
    }

    public Permission setRole(String str) {
        this.role = str;
        return this;
    }

    public Permission setTeamDrivePermissionDetails(List<TeamDrivePermissionDetails> list) {
        this.teamDrivePermissionDetails = list;
        return this;
    }

    public Permission setType(String str) {
        this.type = str;
        return this;
    }

    /* loaded from: classes2.dex */
    public static final class TeamDrivePermissionDetails extends b {
        @q
        private Boolean inherited;
        @q
        private String inheritedFrom;
        @q
        private String role;
        @q
        private String teamDrivePermissionType;

        public Boolean getInherited() {
            return this.inherited;
        }

        public String getInheritedFrom() {
            return this.inheritedFrom;
        }

        public String getRole() {
            return this.role;
        }

        public String getTeamDrivePermissionType() {
            return this.teamDrivePermissionType;
        }

        public TeamDrivePermissionDetails setInherited(Boolean bool) {
            this.inherited = bool;
            return this;
        }

        public TeamDrivePermissionDetails setInheritedFrom(String str) {
            this.inheritedFrom = str;
            return this;
        }

        public TeamDrivePermissionDetails setRole(String str) {
            this.role = str;
            return this;
        }

        public TeamDrivePermissionDetails setTeamDrivePermissionType(String str) {
            this.teamDrivePermissionType = str;
            return this;
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n
        public TeamDrivePermissionDetails set(String str, Object obj) {
            return (TeamDrivePermissionDetails) super.set(str, obj);
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
        public TeamDrivePermissionDetails clone() {
            return (TeamDrivePermissionDetails) super.clone();
        }
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public Permission set(String str, Object obj) {
        return (Permission) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public Permission clone() {
        return (Permission) super.clone();
    }
}