package com.google.api.services.drive.model;

import e.g.b.a.c.b;
import e.g.b.a.c.h;
import e.g.b.a.d.j;
import e.g.b.a.d.q;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class About extends b {
    @q
    private Boolean appInstalled;
    @q
    private Boolean canCreateTeamDrives;
    @q
    private Map<String, List<String>> exportFormats;
    @q
    private List<String> folderColorPalette;
    @q
    private Map<String, List<String>> importFormats;
    @q
    private String kind;
    @h
    @q
    private Map<String, Long> maxImportSizes;
    @h
    @q
    private Long maxUploadSize;
    @q
    private StorageQuota storageQuota;
    @q
    private List<TeamDriveThemes> teamDriveThemes;
    @q
    private User user;

    static {
        j.i(TeamDriveThemes.class);
    }

    public Boolean getAppInstalled() {
        return this.appInstalled;
    }

    public Boolean getCanCreateTeamDrives() {
        return this.canCreateTeamDrives;
    }

    public Map<String, List<String>> getExportFormats() {
        return this.exportFormats;
    }

    public List<String> getFolderColorPalette() {
        return this.folderColorPalette;
    }

    public Map<String, List<String>> getImportFormats() {
        return this.importFormats;
    }

    public String getKind() {
        return this.kind;
    }

    public Map<String, Long> getMaxImportSizes() {
        return this.maxImportSizes;
    }

    public Long getMaxUploadSize() {
        return this.maxUploadSize;
    }

    public StorageQuota getStorageQuota() {
        return this.storageQuota;
    }

    public List<TeamDriveThemes> getTeamDriveThemes() {
        return this.teamDriveThemes;
    }

    public User getUser() {
        return this.user;
    }

    public About setAppInstalled(Boolean bool) {
        this.appInstalled = bool;
        return this;
    }

    public About setCanCreateTeamDrives(Boolean bool) {
        this.canCreateTeamDrives = bool;
        return this;
    }

    public About setExportFormats(Map<String, List<String>> map) {
        this.exportFormats = map;
        return this;
    }

    public About setFolderColorPalette(List<String> list) {
        this.folderColorPalette = list;
        return this;
    }

    public About setImportFormats(Map<String, List<String>> map) {
        this.importFormats = map;
        return this;
    }

    public About setKind(String str) {
        this.kind = str;
        return this;
    }

    public About setMaxImportSizes(Map<String, Long> map) {
        this.maxImportSizes = map;
        return this;
    }

    public About setMaxUploadSize(Long l2) {
        this.maxUploadSize = l2;
        return this;
    }

    public About setStorageQuota(StorageQuota storageQuota) {
        this.storageQuota = storageQuota;
        return this;
    }

    public About setTeamDriveThemes(List<TeamDriveThemes> list) {
        this.teamDriveThemes = list;
        return this;
    }

    public About setUser(User user) {
        this.user = user;
        return this;
    }

    /* loaded from: classes2.dex */
    public static final class StorageQuota extends b {
        @h
        @q
        private Long limit;
        @h
        @q
        private Long usage;
        @h
        @q
        private Long usageInDrive;
        @h
        @q
        private Long usageInDriveTrash;

        public Long getLimit() {
            return this.limit;
        }

        public Long getUsage() {
            return this.usage;
        }

        public Long getUsageInDrive() {
            return this.usageInDrive;
        }

        public Long getUsageInDriveTrash() {
            return this.usageInDriveTrash;
        }

        public StorageQuota setLimit(Long l2) {
            this.limit = l2;
            return this;
        }

        public StorageQuota setUsage(Long l2) {
            this.usage = l2;
            return this;
        }

        public StorageQuota setUsageInDrive(Long l2) {
            this.usageInDrive = l2;
            return this;
        }

        public StorageQuota setUsageInDriveTrash(Long l2) {
            this.usageInDriveTrash = l2;
            return this;
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n
        public StorageQuota set(String str, Object obj) {
            return (StorageQuota) super.set(str, obj);
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
        public StorageQuota clone() {
            return (StorageQuota) super.clone();
        }
    }

    /* loaded from: classes2.dex */
    public static final class TeamDriveThemes extends b {
        @q
        private String backgroundImageLink;
        @q
        private String colorRgb;
        @q
        private String id;

        public String getBackgroundImageLink() {
            return this.backgroundImageLink;
        }

        public String getColorRgb() {
            return this.colorRgb;
        }

        public String getId() {
            return this.id;
        }

        public TeamDriveThemes setBackgroundImageLink(String str) {
            this.backgroundImageLink = str;
            return this;
        }

        public TeamDriveThemes setColorRgb(String str) {
            this.colorRgb = str;
            return this;
        }

        public TeamDriveThemes setId(String str) {
            this.id = str;
            return this;
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n
        public TeamDriveThemes set(String str, Object obj) {
            return (TeamDriveThemes) super.set(str, obj);
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
        public TeamDriveThemes clone() {
            return (TeamDriveThemes) super.clone();
        }
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public About set(String str, Object obj) {
        return (About) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public About clone() {
        return (About) super.clone();
    }
}