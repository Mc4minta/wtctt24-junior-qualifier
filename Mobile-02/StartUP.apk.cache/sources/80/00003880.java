package com.google.api.services.drive.model;

import e.g.b.a.c.b;
import e.g.b.a.d.l;
import e.g.b.a.d.q;

/* loaded from: classes2.dex */
public final class TeamDrive extends b {
    @q
    private BackgroundImageFile backgroundImageFile;
    @q
    private String backgroundImageLink;
    @q
    private Capabilities capabilities;
    @q
    private String colorRgb;
    @q
    private l createdTime;
    @q
    private String id;
    @q
    private String kind;
    @q
    private String name;
    @q
    private Restrictions restrictions;
    @q
    private String themeId;

    public BackgroundImageFile getBackgroundImageFile() {
        return this.backgroundImageFile;
    }

    public String getBackgroundImageLink() {
        return this.backgroundImageLink;
    }

    public Capabilities getCapabilities() {
        return this.capabilities;
    }

    public String getColorRgb() {
        return this.colorRgb;
    }

    public l getCreatedTime() {
        return this.createdTime;
    }

    public String getId() {
        return this.id;
    }

    public String getKind() {
        return this.kind;
    }

    public String getName() {
        return this.name;
    }

    public Restrictions getRestrictions() {
        return this.restrictions;
    }

    public String getThemeId() {
        return this.themeId;
    }

    public TeamDrive setBackgroundImageFile(BackgroundImageFile backgroundImageFile) {
        this.backgroundImageFile = backgroundImageFile;
        return this;
    }

    public TeamDrive setBackgroundImageLink(String str) {
        this.backgroundImageLink = str;
        return this;
    }

    public TeamDrive setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
        return this;
    }

    public TeamDrive setColorRgb(String str) {
        this.colorRgb = str;
        return this;
    }

    public TeamDrive setCreatedTime(l lVar) {
        this.createdTime = lVar;
        return this;
    }

    public TeamDrive setId(String str) {
        this.id = str;
        return this;
    }

    public TeamDrive setKind(String str) {
        this.kind = str;
        return this;
    }

    public TeamDrive setName(String str) {
        this.name = str;
        return this;
    }

    public TeamDrive setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
        return this;
    }

    public TeamDrive setThemeId(String str) {
        this.themeId = str;
        return this;
    }

    /* loaded from: classes2.dex */
    public static final class BackgroundImageFile extends b {
        @q
        private String id;
        @q
        private Float width;
        @q
        private Float xCoordinate;
        @q
        private Float yCoordinate;

        public String getId() {
            return this.id;
        }

        public Float getWidth() {
            return this.width;
        }

        public Float getXCoordinate() {
            return this.xCoordinate;
        }

        public Float getYCoordinate() {
            return this.yCoordinate;
        }

        public BackgroundImageFile setId(String str) {
            this.id = str;
            return this;
        }

        public BackgroundImageFile setWidth(Float f2) {
            this.width = f2;
            return this;
        }

        public BackgroundImageFile setXCoordinate(Float f2) {
            this.xCoordinate = f2;
            return this;
        }

        public BackgroundImageFile setYCoordinate(Float f2) {
            this.yCoordinate = f2;
            return this;
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n
        public BackgroundImageFile set(String str, Object obj) {
            return (BackgroundImageFile) super.set(str, obj);
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
        public BackgroundImageFile clone() {
            return (BackgroundImageFile) super.clone();
        }
    }

    /* loaded from: classes2.dex */
    public static final class Capabilities extends b {
        @q
        private Boolean canAddChildren;
        @q
        private Boolean canChangeCopyRequiresWriterPermissionRestriction;
        @q
        private Boolean canChangeDomainUsersOnlyRestriction;
        @q
        private Boolean canChangeTeamDriveBackground;
        @q
        private Boolean canChangeTeamMembersOnlyRestriction;
        @q
        private Boolean canComment;
        @q
        private Boolean canCopy;
        @q
        private Boolean canDeleteChildren;
        @q
        private Boolean canDeleteTeamDrive;
        @q
        private Boolean canDownload;
        @q
        private Boolean canEdit;
        @q
        private Boolean canListChildren;
        @q
        private Boolean canManageMembers;
        @q
        private Boolean canReadRevisions;
        @q
        private Boolean canRemoveChildren;
        @q
        private Boolean canRename;
        @q
        private Boolean canRenameTeamDrive;
        @q
        private Boolean canShare;
        @q
        private Boolean canTrashChildren;

        public Boolean getCanAddChildren() {
            return this.canAddChildren;
        }

        public Boolean getCanChangeCopyRequiresWriterPermissionRestriction() {
            return this.canChangeCopyRequiresWriterPermissionRestriction;
        }

        public Boolean getCanChangeDomainUsersOnlyRestriction() {
            return this.canChangeDomainUsersOnlyRestriction;
        }

        public Boolean getCanChangeTeamDriveBackground() {
            return this.canChangeTeamDriveBackground;
        }

        public Boolean getCanChangeTeamMembersOnlyRestriction() {
            return this.canChangeTeamMembersOnlyRestriction;
        }

        public Boolean getCanComment() {
            return this.canComment;
        }

        public Boolean getCanCopy() {
            return this.canCopy;
        }

        public Boolean getCanDeleteChildren() {
            return this.canDeleteChildren;
        }

        public Boolean getCanDeleteTeamDrive() {
            return this.canDeleteTeamDrive;
        }

        public Boolean getCanDownload() {
            return this.canDownload;
        }

        public Boolean getCanEdit() {
            return this.canEdit;
        }

        public Boolean getCanListChildren() {
            return this.canListChildren;
        }

        public Boolean getCanManageMembers() {
            return this.canManageMembers;
        }

        public Boolean getCanReadRevisions() {
            return this.canReadRevisions;
        }

        public Boolean getCanRemoveChildren() {
            return this.canRemoveChildren;
        }

        public Boolean getCanRename() {
            return this.canRename;
        }

        public Boolean getCanRenameTeamDrive() {
            return this.canRenameTeamDrive;
        }

        public Boolean getCanShare() {
            return this.canShare;
        }

        public Boolean getCanTrashChildren() {
            return this.canTrashChildren;
        }

        public Capabilities setCanAddChildren(Boolean bool) {
            this.canAddChildren = bool;
            return this;
        }

        public Capabilities setCanChangeCopyRequiresWriterPermissionRestriction(Boolean bool) {
            this.canChangeCopyRequiresWriterPermissionRestriction = bool;
            return this;
        }

        public Capabilities setCanChangeDomainUsersOnlyRestriction(Boolean bool) {
            this.canChangeDomainUsersOnlyRestriction = bool;
            return this;
        }

        public Capabilities setCanChangeTeamDriveBackground(Boolean bool) {
            this.canChangeTeamDriveBackground = bool;
            return this;
        }

        public Capabilities setCanChangeTeamMembersOnlyRestriction(Boolean bool) {
            this.canChangeTeamMembersOnlyRestriction = bool;
            return this;
        }

        public Capabilities setCanComment(Boolean bool) {
            this.canComment = bool;
            return this;
        }

        public Capabilities setCanCopy(Boolean bool) {
            this.canCopy = bool;
            return this;
        }

        public Capabilities setCanDeleteChildren(Boolean bool) {
            this.canDeleteChildren = bool;
            return this;
        }

        public Capabilities setCanDeleteTeamDrive(Boolean bool) {
            this.canDeleteTeamDrive = bool;
            return this;
        }

        public Capabilities setCanDownload(Boolean bool) {
            this.canDownload = bool;
            return this;
        }

        public Capabilities setCanEdit(Boolean bool) {
            this.canEdit = bool;
            return this;
        }

        public Capabilities setCanListChildren(Boolean bool) {
            this.canListChildren = bool;
            return this;
        }

        public Capabilities setCanManageMembers(Boolean bool) {
            this.canManageMembers = bool;
            return this;
        }

        public Capabilities setCanReadRevisions(Boolean bool) {
            this.canReadRevisions = bool;
            return this;
        }

        public Capabilities setCanRemoveChildren(Boolean bool) {
            this.canRemoveChildren = bool;
            return this;
        }

        public Capabilities setCanRename(Boolean bool) {
            this.canRename = bool;
            return this;
        }

        public Capabilities setCanRenameTeamDrive(Boolean bool) {
            this.canRenameTeamDrive = bool;
            return this;
        }

        public Capabilities setCanShare(Boolean bool) {
            this.canShare = bool;
            return this;
        }

        public Capabilities setCanTrashChildren(Boolean bool) {
            this.canTrashChildren = bool;
            return this;
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n
        public Capabilities set(String str, Object obj) {
            return (Capabilities) super.set(str, obj);
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
        public Capabilities clone() {
            return (Capabilities) super.clone();
        }
    }

    /* loaded from: classes2.dex */
    public static final class Restrictions extends b {
        @q
        private Boolean adminManagedRestrictions;
        @q
        private Boolean copyRequiresWriterPermission;
        @q
        private Boolean domainUsersOnly;
        @q
        private Boolean teamMembersOnly;

        public Boolean getAdminManagedRestrictions() {
            return this.adminManagedRestrictions;
        }

        public Boolean getCopyRequiresWriterPermission() {
            return this.copyRequiresWriterPermission;
        }

        public Boolean getDomainUsersOnly() {
            return this.domainUsersOnly;
        }

        public Boolean getTeamMembersOnly() {
            return this.teamMembersOnly;
        }

        public Restrictions setAdminManagedRestrictions(Boolean bool) {
            this.adminManagedRestrictions = bool;
            return this;
        }

        public Restrictions setCopyRequiresWriterPermission(Boolean bool) {
            this.copyRequiresWriterPermission = bool;
            return this;
        }

        public Restrictions setDomainUsersOnly(Boolean bool) {
            this.domainUsersOnly = bool;
            return this;
        }

        public Restrictions setTeamMembersOnly(Boolean bool) {
            this.teamMembersOnly = bool;
            return this;
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n
        public Restrictions set(String str, Object obj) {
            return (Restrictions) super.set(str, obj);
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
        public Restrictions clone() {
            return (Restrictions) super.clone();
        }
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public TeamDrive set(String str, Object obj) {
        return (TeamDrive) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public TeamDrive clone() {
        return (TeamDrive) super.clone();
    }
}