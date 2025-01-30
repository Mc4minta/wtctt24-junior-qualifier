package com.google.api.services.drive.model;

import e.g.b.a.c.b;
import e.g.b.a.c.h;
import e.g.b.a.d.e;
import e.g.b.a.d.l;
import e.g.b.a.d.q;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class File extends b {
    @q
    private Map<String, String> appProperties;
    @q
    private Capabilities capabilities;
    @q
    private ContentHints contentHints;
    @q
    private Boolean copyRequiresWriterPermission;
    @q
    private l createdTime;
    @q
    private String description;
    @q
    private Boolean explicitlyTrashed;
    @q
    private String fileExtension;
    @q
    private String folderColorRgb;
    @q
    private String fullFileExtension;
    @q
    private Boolean hasAugmentedPermissions;
    @q
    private Boolean hasThumbnail;
    @q
    private String headRevisionId;
    @q
    private String iconLink;
    @q
    private String id;
    @q
    private ImageMediaMetadata imageMediaMetadata;
    @q
    private Boolean isAppAuthorized;
    @q
    private String kind;
    @q
    private User lastModifyingUser;
    @q
    private String md5Checksum;
    @q
    private String mimeType;
    @q
    private Boolean modifiedByMe;
    @q
    private l modifiedByMeTime;
    @q
    private l modifiedTime;
    @q
    private String name;
    @q
    private String originalFilename;
    @q
    private Boolean ownedByMe;
    @q
    private List<User> owners;
    @q
    private List<String> parents;
    @q
    private List<String> permissionIds;
    @q
    private List<Permission> permissions;
    @q
    private Map<String, String> properties;
    @h
    @q
    private Long quotaBytesUsed;
    @q
    private Boolean shared;
    @q
    private l sharedWithMeTime;
    @q
    private User sharingUser;
    @h
    @q
    private Long size;
    @q
    private List<String> spaces;
    @q
    private Boolean starred;
    @q
    private String teamDriveId;
    @q
    private String thumbnailLink;
    @h
    @q
    private Long thumbnailVersion;
    @q
    private Boolean trashed;
    @q
    private l trashedTime;
    @q
    private User trashingUser;
    @h
    @q
    private Long version;
    @q
    private VideoMediaMetadata videoMediaMetadata;
    @q
    private Boolean viewedByMe;
    @q
    private l viewedByMeTime;
    @q
    private Boolean viewersCanCopyContent;
    @q
    private String webContentLink;
    @q
    private String webViewLink;
    @q
    private Boolean writersCanShare;

    /* loaded from: classes2.dex */
    public static final class ContentHints extends b {
        @q
        private String indexableText;
        @q
        private Thumbnail thumbnail;

        public String getIndexableText() {
            return this.indexableText;
        }

        public Thumbnail getThumbnail() {
            return this.thumbnail;
        }

        public ContentHints setIndexableText(String str) {
            this.indexableText = str;
            return this;
        }

        public ContentHints setThumbnail(Thumbnail thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        /* loaded from: classes2.dex */
        public static final class Thumbnail extends b {
            @q
            private String image;
            @q
            private String mimeType;

            public byte[] decodeImage() {
                return e.a(this.image);
            }

            public Thumbnail encodeImage(byte[] bArr) {
                this.image = e.b(bArr);
                return this;
            }

            public String getImage() {
                return this.image;
            }

            public String getMimeType() {
                return this.mimeType;
            }

            public Thumbnail setImage(String str) {
                this.image = str;
                return this;
            }

            public Thumbnail setMimeType(String str) {
                this.mimeType = str;
                return this;
            }

            @Override // e.g.b.a.c.b, e.g.b.a.d.n
            public Thumbnail set(String str, Object obj) {
                return (Thumbnail) super.set(str, obj);
            }

            @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
            public Thumbnail clone() {
                return (Thumbnail) super.clone();
            }
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n
        public ContentHints set(String str, Object obj) {
            return (ContentHints) super.set(str, obj);
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
        public ContentHints clone() {
            return (ContentHints) super.clone();
        }
    }

    /* loaded from: classes2.dex */
    public static final class ImageMediaMetadata extends b {
        @q
        private Float aperture;
        @q
        private String cameraMake;
        @q
        private String cameraModel;
        @q
        private String colorSpace;
        @q
        private Float exposureBias;
        @q
        private String exposureMode;
        @q
        private Float exposureTime;
        @q
        private Boolean flashUsed;
        @q
        private Float focalLength;
        @q
        private Integer height;
        @q
        private Integer isoSpeed;
        @q
        private String lens;
        @q
        private Location location;
        @q
        private Float maxApertureValue;
        @q
        private String meteringMode;
        @q
        private Integer rotation;
        @q
        private String sensor;
        @q
        private Integer subjectDistance;
        @q
        private String time;
        @q
        private String whiteBalance;
        @q
        private Integer width;

        public Float getAperture() {
            return this.aperture;
        }

        public String getCameraMake() {
            return this.cameraMake;
        }

        public String getCameraModel() {
            return this.cameraModel;
        }

        public String getColorSpace() {
            return this.colorSpace;
        }

        public Float getExposureBias() {
            return this.exposureBias;
        }

        public String getExposureMode() {
            return this.exposureMode;
        }

        public Float getExposureTime() {
            return this.exposureTime;
        }

        public Boolean getFlashUsed() {
            return this.flashUsed;
        }

        public Float getFocalLength() {
            return this.focalLength;
        }

        public Integer getHeight() {
            return this.height;
        }

        public Integer getIsoSpeed() {
            return this.isoSpeed;
        }

        public String getLens() {
            return this.lens;
        }

        public Location getLocation() {
            return this.location;
        }

        public Float getMaxApertureValue() {
            return this.maxApertureValue;
        }

        public String getMeteringMode() {
            return this.meteringMode;
        }

        public Integer getRotation() {
            return this.rotation;
        }

        public String getSensor() {
            return this.sensor;
        }

        public Integer getSubjectDistance() {
            return this.subjectDistance;
        }

        public String getTime() {
            return this.time;
        }

        public String getWhiteBalance() {
            return this.whiteBalance;
        }

        public Integer getWidth() {
            return this.width;
        }

        public ImageMediaMetadata setAperture(Float f2) {
            this.aperture = f2;
            return this;
        }

        public ImageMediaMetadata setCameraMake(String str) {
            this.cameraMake = str;
            return this;
        }

        public ImageMediaMetadata setCameraModel(String str) {
            this.cameraModel = str;
            return this;
        }

        public ImageMediaMetadata setColorSpace(String str) {
            this.colorSpace = str;
            return this;
        }

        public ImageMediaMetadata setExposureBias(Float f2) {
            this.exposureBias = f2;
            return this;
        }

        public ImageMediaMetadata setExposureMode(String str) {
            this.exposureMode = str;
            return this;
        }

        public ImageMediaMetadata setExposureTime(Float f2) {
            this.exposureTime = f2;
            return this;
        }

        public ImageMediaMetadata setFlashUsed(Boolean bool) {
            this.flashUsed = bool;
            return this;
        }

        public ImageMediaMetadata setFocalLength(Float f2) {
            this.focalLength = f2;
            return this;
        }

        public ImageMediaMetadata setHeight(Integer num) {
            this.height = num;
            return this;
        }

        public ImageMediaMetadata setIsoSpeed(Integer num) {
            this.isoSpeed = num;
            return this;
        }

        public ImageMediaMetadata setLens(String str) {
            this.lens = str;
            return this;
        }

        public ImageMediaMetadata setLocation(Location location) {
            this.location = location;
            return this;
        }

        public ImageMediaMetadata setMaxApertureValue(Float f2) {
            this.maxApertureValue = f2;
            return this;
        }

        public ImageMediaMetadata setMeteringMode(String str) {
            this.meteringMode = str;
            return this;
        }

        public ImageMediaMetadata setRotation(Integer num) {
            this.rotation = num;
            return this;
        }

        public ImageMediaMetadata setSensor(String str) {
            this.sensor = str;
            return this;
        }

        public ImageMediaMetadata setSubjectDistance(Integer num) {
            this.subjectDistance = num;
            return this;
        }

        public ImageMediaMetadata setTime(String str) {
            this.time = str;
            return this;
        }

        public ImageMediaMetadata setWhiteBalance(String str) {
            this.whiteBalance = str;
            return this;
        }

        public ImageMediaMetadata setWidth(Integer num) {
            this.width = num;
            return this;
        }

        /* loaded from: classes2.dex */
        public static final class Location extends b {
            @q
            private Double altitude;
            @q
            private Double latitude;
            @q
            private Double longitude;

            public Double getAltitude() {
                return this.altitude;
            }

            public Double getLatitude() {
                return this.latitude;
            }

            public Double getLongitude() {
                return this.longitude;
            }

            public Location setAltitude(Double d2) {
                this.altitude = d2;
                return this;
            }

            public Location setLatitude(Double d2) {
                this.latitude = d2;
                return this;
            }

            public Location setLongitude(Double d2) {
                this.longitude = d2;
                return this;
            }

            @Override // e.g.b.a.c.b, e.g.b.a.d.n
            public Location set(String str, Object obj) {
                return (Location) super.set(str, obj);
            }

            @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
            public Location clone() {
                return (Location) super.clone();
            }
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n
        public ImageMediaMetadata set(String str, Object obj) {
            return (ImageMediaMetadata) super.set(str, obj);
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
        public ImageMediaMetadata clone() {
            return (ImageMediaMetadata) super.clone();
        }
    }

    public Map<String, String> getAppProperties() {
        return this.appProperties;
    }

    public Capabilities getCapabilities() {
        return this.capabilities;
    }

    public ContentHints getContentHints() {
        return this.contentHints;
    }

    public Boolean getCopyRequiresWriterPermission() {
        return this.copyRequiresWriterPermission;
    }

    public l getCreatedTime() {
        return this.createdTime;
    }

    public String getDescription() {
        return this.description;
    }

    public Boolean getExplicitlyTrashed() {
        return this.explicitlyTrashed;
    }

    public String getFileExtension() {
        return this.fileExtension;
    }

    public String getFolderColorRgb() {
        return this.folderColorRgb;
    }

    public String getFullFileExtension() {
        return this.fullFileExtension;
    }

    public Boolean getHasAugmentedPermissions() {
        return this.hasAugmentedPermissions;
    }

    public Boolean getHasThumbnail() {
        return this.hasThumbnail;
    }

    public String getHeadRevisionId() {
        return this.headRevisionId;
    }

    public String getIconLink() {
        return this.iconLink;
    }

    public String getId() {
        return this.id;
    }

    public ImageMediaMetadata getImageMediaMetadata() {
        return this.imageMediaMetadata;
    }

    public Boolean getIsAppAuthorized() {
        return this.isAppAuthorized;
    }

    public String getKind() {
        return this.kind;
    }

    public User getLastModifyingUser() {
        return this.lastModifyingUser;
    }

    public String getMd5Checksum() {
        return this.md5Checksum;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Boolean getModifiedByMe() {
        return this.modifiedByMe;
    }

    public l getModifiedByMeTime() {
        return this.modifiedByMeTime;
    }

    public l getModifiedTime() {
        return this.modifiedTime;
    }

    public String getName() {
        return this.name;
    }

    public String getOriginalFilename() {
        return this.originalFilename;
    }

    public Boolean getOwnedByMe() {
        return this.ownedByMe;
    }

    public List<User> getOwners() {
        return this.owners;
    }

    public List<String> getParents() {
        return this.parents;
    }

    public List<String> getPermissionIds() {
        return this.permissionIds;
    }

    public List<Permission> getPermissions() {
        return this.permissions;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public Long getQuotaBytesUsed() {
        return this.quotaBytesUsed;
    }

    public Boolean getShared() {
        return this.shared;
    }

    public l getSharedWithMeTime() {
        return this.sharedWithMeTime;
    }

    public User getSharingUser() {
        return this.sharingUser;
    }

    public Long getSize() {
        return this.size;
    }

    public List<String> getSpaces() {
        return this.spaces;
    }

    public Boolean getStarred() {
        return this.starred;
    }

    public String getTeamDriveId() {
        return this.teamDriveId;
    }

    public String getThumbnailLink() {
        return this.thumbnailLink;
    }

    public Long getThumbnailVersion() {
        return this.thumbnailVersion;
    }

    public Boolean getTrashed() {
        return this.trashed;
    }

    public l getTrashedTime() {
        return this.trashedTime;
    }

    public User getTrashingUser() {
        return this.trashingUser;
    }

    public Long getVersion() {
        return this.version;
    }

    public VideoMediaMetadata getVideoMediaMetadata() {
        return this.videoMediaMetadata;
    }

    public Boolean getViewedByMe() {
        return this.viewedByMe;
    }

    public l getViewedByMeTime() {
        return this.viewedByMeTime;
    }

    public Boolean getViewersCanCopyContent() {
        return this.viewersCanCopyContent;
    }

    public String getWebContentLink() {
        return this.webContentLink;
    }

    public String getWebViewLink() {
        return this.webViewLink;
    }

    public Boolean getWritersCanShare() {
        return this.writersCanShare;
    }

    public File setAppProperties(Map<String, String> map) {
        this.appProperties = map;
        return this;
    }

    public File setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
        return this;
    }

    public File setContentHints(ContentHints contentHints) {
        this.contentHints = contentHints;
        return this;
    }

    public File setCopyRequiresWriterPermission(Boolean bool) {
        this.copyRequiresWriterPermission = bool;
        return this;
    }

    public File setCreatedTime(l lVar) {
        this.createdTime = lVar;
        return this;
    }

    public File setDescription(String str) {
        this.description = str;
        return this;
    }

    public File setExplicitlyTrashed(Boolean bool) {
        this.explicitlyTrashed = bool;
        return this;
    }

    public File setFileExtension(String str) {
        this.fileExtension = str;
        return this;
    }

    public File setFolderColorRgb(String str) {
        this.folderColorRgb = str;
        return this;
    }

    public File setFullFileExtension(String str) {
        this.fullFileExtension = str;
        return this;
    }

    public File setHasAugmentedPermissions(Boolean bool) {
        this.hasAugmentedPermissions = bool;
        return this;
    }

    public File setHasThumbnail(Boolean bool) {
        this.hasThumbnail = bool;
        return this;
    }

    public File setHeadRevisionId(String str) {
        this.headRevisionId = str;
        return this;
    }

    public File setIconLink(String str) {
        this.iconLink = str;
        return this;
    }

    public File setId(String str) {
        this.id = str;
        return this;
    }

    public File setImageMediaMetadata(ImageMediaMetadata imageMediaMetadata) {
        this.imageMediaMetadata = imageMediaMetadata;
        return this;
    }

    public File setIsAppAuthorized(Boolean bool) {
        this.isAppAuthorized = bool;
        return this;
    }

    public File setKind(String str) {
        this.kind = str;
        return this;
    }

    public File setLastModifyingUser(User user) {
        this.lastModifyingUser = user;
        return this;
    }

    public File setMd5Checksum(String str) {
        this.md5Checksum = str;
        return this;
    }

    public File setMimeType(String str) {
        this.mimeType = str;
        return this;
    }

    public File setModifiedByMe(Boolean bool) {
        this.modifiedByMe = bool;
        return this;
    }

    public File setModifiedByMeTime(l lVar) {
        this.modifiedByMeTime = lVar;
        return this;
    }

    public File setModifiedTime(l lVar) {
        this.modifiedTime = lVar;
        return this;
    }

    public File setName(String str) {
        this.name = str;
        return this;
    }

    public File setOriginalFilename(String str) {
        this.originalFilename = str;
        return this;
    }

    public File setOwnedByMe(Boolean bool) {
        this.ownedByMe = bool;
        return this;
    }

    public File setOwners(List<User> list) {
        this.owners = list;
        return this;
    }

    public File setParents(List<String> list) {
        this.parents = list;
        return this;
    }

    public File setPermissionIds(List<String> list) {
        this.permissionIds = list;
        return this;
    }

    public File setPermissions(List<Permission> list) {
        this.permissions = list;
        return this;
    }

    public File setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public File setQuotaBytesUsed(Long l2) {
        this.quotaBytesUsed = l2;
        return this;
    }

    public File setShared(Boolean bool) {
        this.shared = bool;
        return this;
    }

    public File setSharedWithMeTime(l lVar) {
        this.sharedWithMeTime = lVar;
        return this;
    }

    public File setSharingUser(User user) {
        this.sharingUser = user;
        return this;
    }

    public File setSize(Long l2) {
        this.size = l2;
        return this;
    }

    public File setSpaces(List<String> list) {
        this.spaces = list;
        return this;
    }

    public File setStarred(Boolean bool) {
        this.starred = bool;
        return this;
    }

    public File setTeamDriveId(String str) {
        this.teamDriveId = str;
        return this;
    }

    public File setThumbnailLink(String str) {
        this.thumbnailLink = str;
        return this;
    }

    public File setThumbnailVersion(Long l2) {
        this.thumbnailVersion = l2;
        return this;
    }

    public File setTrashed(Boolean bool) {
        this.trashed = bool;
        return this;
    }

    public File setTrashedTime(l lVar) {
        this.trashedTime = lVar;
        return this;
    }

    public File setTrashingUser(User user) {
        this.trashingUser = user;
        return this;
    }

    public File setVersion(Long l2) {
        this.version = l2;
        return this;
    }

    public File setVideoMediaMetadata(VideoMediaMetadata videoMediaMetadata) {
        this.videoMediaMetadata = videoMediaMetadata;
        return this;
    }

    public File setViewedByMe(Boolean bool) {
        this.viewedByMe = bool;
        return this;
    }

    public File setViewedByMeTime(l lVar) {
        this.viewedByMeTime = lVar;
        return this;
    }

    public File setViewersCanCopyContent(Boolean bool) {
        this.viewersCanCopyContent = bool;
        return this;
    }

    public File setWebContentLink(String str) {
        this.webContentLink = str;
        return this;
    }

    public File setWebViewLink(String str) {
        this.webViewLink = str;
        return this;
    }

    public File setWritersCanShare(Boolean bool) {
        this.writersCanShare = bool;
        return this;
    }

    /* loaded from: classes2.dex */
    public static final class Capabilities extends b {
        @q
        private Boolean canAddChildren;
        @q
        private Boolean canChangeCopyRequiresWriterPermission;
        @q
        private Boolean canChangeViewersCanCopyContent;
        @q
        private Boolean canComment;
        @q
        private Boolean canCopy;
        @q
        private Boolean canDelete;
        @q
        private Boolean canDeleteChildren;
        @q
        private Boolean canDownload;
        @q
        private Boolean canEdit;
        @q
        private Boolean canListChildren;
        @q
        private Boolean canMoveChildrenOutOfTeamDrive;
        @q
        private Boolean canMoveChildrenWithinTeamDrive;
        @q
        private Boolean canMoveItemIntoTeamDrive;
        @q
        private Boolean canMoveItemOutOfTeamDrive;
        @q
        private Boolean canMoveItemWithinTeamDrive;
        @q
        private Boolean canMoveTeamDriveItem;
        @q
        private Boolean canReadRevisions;
        @q
        private Boolean canReadTeamDrive;
        @q
        private Boolean canRemoveChildren;
        @q
        private Boolean canRename;
        @q
        private Boolean canShare;
        @q
        private Boolean canTrash;
        @q
        private Boolean canTrashChildren;
        @q
        private Boolean canUntrash;

        public Boolean getCanAddChildren() {
            return this.canAddChildren;
        }

        public Boolean getCanChangeCopyRequiresWriterPermission() {
            return this.canChangeCopyRequiresWriterPermission;
        }

        public Boolean getCanChangeViewersCanCopyContent() {
            return this.canChangeViewersCanCopyContent;
        }

        public Boolean getCanComment() {
            return this.canComment;
        }

        public Boolean getCanCopy() {
            return this.canCopy;
        }

        public Boolean getCanDelete() {
            return this.canDelete;
        }

        public Boolean getCanDeleteChildren() {
            return this.canDeleteChildren;
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

        public Boolean getCanMoveChildrenOutOfTeamDrive() {
            return this.canMoveChildrenOutOfTeamDrive;
        }

        public Boolean getCanMoveChildrenWithinTeamDrive() {
            return this.canMoveChildrenWithinTeamDrive;
        }

        public Boolean getCanMoveItemIntoTeamDrive() {
            return this.canMoveItemIntoTeamDrive;
        }

        public Boolean getCanMoveItemOutOfTeamDrive() {
            return this.canMoveItemOutOfTeamDrive;
        }

        public Boolean getCanMoveItemWithinTeamDrive() {
            return this.canMoveItemWithinTeamDrive;
        }

        public Boolean getCanMoveTeamDriveItem() {
            return this.canMoveTeamDriveItem;
        }

        public Boolean getCanReadRevisions() {
            return this.canReadRevisions;
        }

        public Boolean getCanReadTeamDrive() {
            return this.canReadTeamDrive;
        }

        public Boolean getCanRemoveChildren() {
            return this.canRemoveChildren;
        }

        public Boolean getCanRename() {
            return this.canRename;
        }

        public Boolean getCanShare() {
            return this.canShare;
        }

        public Boolean getCanTrash() {
            return this.canTrash;
        }

        public Boolean getCanTrashChildren() {
            return this.canTrashChildren;
        }

        public Boolean getCanUntrash() {
            return this.canUntrash;
        }

        public Capabilities setCanAddChildren(Boolean bool) {
            this.canAddChildren = bool;
            return this;
        }

        public Capabilities setCanChangeCopyRequiresWriterPermission(Boolean bool) {
            this.canChangeCopyRequiresWriterPermission = bool;
            return this;
        }

        public Capabilities setCanChangeViewersCanCopyContent(Boolean bool) {
            this.canChangeViewersCanCopyContent = bool;
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

        public Capabilities setCanDelete(Boolean bool) {
            this.canDelete = bool;
            return this;
        }

        public Capabilities setCanDeleteChildren(Boolean bool) {
            this.canDeleteChildren = bool;
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

        public Capabilities setCanMoveChildrenOutOfTeamDrive(Boolean bool) {
            this.canMoveChildrenOutOfTeamDrive = bool;
            return this;
        }

        public Capabilities setCanMoveChildrenWithinTeamDrive(Boolean bool) {
            this.canMoveChildrenWithinTeamDrive = bool;
            return this;
        }

        public Capabilities setCanMoveItemIntoTeamDrive(Boolean bool) {
            this.canMoveItemIntoTeamDrive = bool;
            return this;
        }

        public Capabilities setCanMoveItemOutOfTeamDrive(Boolean bool) {
            this.canMoveItemOutOfTeamDrive = bool;
            return this;
        }

        public Capabilities setCanMoveItemWithinTeamDrive(Boolean bool) {
            this.canMoveItemWithinTeamDrive = bool;
            return this;
        }

        public Capabilities setCanMoveTeamDriveItem(Boolean bool) {
            this.canMoveTeamDriveItem = bool;
            return this;
        }

        public Capabilities setCanReadRevisions(Boolean bool) {
            this.canReadRevisions = bool;
            return this;
        }

        public Capabilities setCanReadTeamDrive(Boolean bool) {
            this.canReadTeamDrive = bool;
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

        public Capabilities setCanShare(Boolean bool) {
            this.canShare = bool;
            return this;
        }

        public Capabilities setCanTrash(Boolean bool) {
            this.canTrash = bool;
            return this;
        }

        public Capabilities setCanTrashChildren(Boolean bool) {
            this.canTrashChildren = bool;
            return this;
        }

        public Capabilities setCanUntrash(Boolean bool) {
            this.canUntrash = bool;
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
    public static final class VideoMediaMetadata extends b {
        @h
        @q
        private Long durationMillis;
        @q
        private Integer height;
        @q
        private Integer width;

        public Long getDurationMillis() {
            return this.durationMillis;
        }

        public Integer getHeight() {
            return this.height;
        }

        public Integer getWidth() {
            return this.width;
        }

        public VideoMediaMetadata setDurationMillis(Long l2) {
            this.durationMillis = l2;
            return this;
        }

        public VideoMediaMetadata setHeight(Integer num) {
            this.height = num;
            return this;
        }

        public VideoMediaMetadata setWidth(Integer num) {
            this.width = num;
            return this;
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n
        public VideoMediaMetadata set(String str, Object obj) {
            return (VideoMediaMetadata) super.set(str, obj);
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
        public VideoMediaMetadata clone() {
            return (VideoMediaMetadata) super.clone();
        }
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public File set(String str, Object obj) {
        return (File) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public File clone() {
        return (File) super.clone();
    }
}