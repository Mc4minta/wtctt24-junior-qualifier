package com.google.api.services.drive;

import com.caverock.androidsvg.SVGParser;
import com.google.api.client.http.a0;
import com.google.api.client.http.g;
import com.google.api.client.http.o;
import com.google.api.client.http.q;
import com.google.api.client.http.r;
import com.google.api.client.http.u;
import com.google.api.services.drive.model.ChangeList;
import com.google.api.services.drive.model.Channel;
import com.google.api.services.drive.model.Comment;
import com.google.api.services.drive.model.CommentList;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.drive.model.GeneratedIds;
import com.google.api.services.drive.model.Permission;
import com.google.api.services.drive.model.PermissionList;
import com.google.api.services.drive.model.Reply;
import com.google.api.services.drive.model.ReplyList;
import com.google.api.services.drive.model.Revision;
import com.google.api.services.drive.model.RevisionList;
import com.google.api.services.drive.model.StartPageToken;
import com.google.api.services.drive.model.TeamDrive;
import com.google.api.services.drive.model.TeamDriveList;
import e.g.b.a.b.f.b;
import e.g.b.a.b.f.d;
import e.g.b.a.b.f.e.a;
import e.g.b.a.c.c;
import e.g.b.a.d.j;
import e.g.b.a.d.y;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;

/* loaded from: classes2.dex */
public class Drive extends a {
    public static final String DEFAULT_BASE_URL = "https://www.googleapis.com/drive/v3/";
    public static final String DEFAULT_BATCH_PATH = "batch/drive/v3";
    public static final String DEFAULT_ROOT_URL = "https://www.googleapis.com/";
    public static final String DEFAULT_SERVICE_PATH = "drive/v3/";

    /* loaded from: classes2.dex */
    public class About {

        /* loaded from: classes2.dex */
        public class Get extends DriveRequest<com.google.api.services.drive.model.About> {
            private static final String REST_PATH = "about";

            protected Get() {
                super(Drive.this, HttpGet.METHOD_NAME, REST_PATH, null, com.google.api.services.drive.model.About.class);
            }

            @Override // e.g.b.a.b.f.b
            public o buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // e.g.b.a.b.f.b
            public r executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<com.google.api.services.drive.model.About> setAlt2(String str) {
                return (Get) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<com.google.api.services.drive.model.About> setFields2(String str) {
                return (Get) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<com.google.api.services.drive.model.About> setKey2(String str) {
                return (Get) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<com.google.api.services.drive.model.About> setOauthToken2(String str) {
                return (Get) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<com.google.api.services.drive.model.About> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<com.google.api.services.drive.model.About> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<com.google.api.services.drive.model.About> setUserIp2(String str) {
                return (Get) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public About() {
        }

        public Get get() throws IOException {
            Get get = new Get();
            Drive.this.initialize(get);
            return get;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends a.AbstractC0310a {
        public Builder(u uVar, c cVar, q qVar) {
            super(uVar, cVar, Drive.DEFAULT_ROOT_URL, Drive.DEFAULT_SERVICE_PATH, qVar, false);
            setBatchPath(Drive.DEFAULT_BATCH_PATH);
        }

        public Builder setDriveRequestInitializer(DriveRequestInitializer driveRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer((d) driveRequestInitializer);
        }

        @Override // e.g.b.a.b.f.a.AbstractC0308a
        public Builder setBatchPath(String str) {
            return (Builder) super.setBatchPath(str);
        }

        @Override // e.g.b.a.b.f.e.a.AbstractC0310a, e.g.b.a.b.f.a.AbstractC0308a
        public Drive build() {
            return new Drive(this);
        }

        @Override // e.g.b.a.b.f.e.a.AbstractC0310a, e.g.b.a.b.f.a.AbstractC0308a
        public Builder setApplicationName(String str) {
            return (Builder) super.setApplicationName(str);
        }

        @Override // e.g.b.a.b.f.e.a.AbstractC0310a, e.g.b.a.b.f.a.AbstractC0308a
        public Builder setGoogleClientRequestInitializer(d dVar) {
            return (Builder) super.setGoogleClientRequestInitializer(dVar);
        }

        @Override // e.g.b.a.b.f.e.a.AbstractC0310a, e.g.b.a.b.f.a.AbstractC0308a
        public Builder setHttpRequestInitializer(q qVar) {
            return (Builder) super.setHttpRequestInitializer(qVar);
        }

        @Override // e.g.b.a.b.f.e.a.AbstractC0310a, e.g.b.a.b.f.a.AbstractC0308a
        public Builder setRootUrl(String str) {
            return (Builder) super.setRootUrl(str);
        }

        @Override // e.g.b.a.b.f.e.a.AbstractC0310a, e.g.b.a.b.f.a.AbstractC0308a
        public Builder setServicePath(String str) {
            return (Builder) super.setServicePath(str);
        }

        @Override // e.g.b.a.b.f.e.a.AbstractC0310a, e.g.b.a.b.f.a.AbstractC0308a
        public Builder setSuppressAllChecks(boolean z) {
            return (Builder) super.setSuppressAllChecks(z);
        }

        @Override // e.g.b.a.b.f.e.a.AbstractC0310a, e.g.b.a.b.f.a.AbstractC0308a
        public Builder setSuppressPatternChecks(boolean z) {
            return (Builder) super.setSuppressPatternChecks(z);
        }

        @Override // e.g.b.a.b.f.e.a.AbstractC0310a, e.g.b.a.b.f.a.AbstractC0308a
        public Builder setSuppressRequiredParameterChecks(boolean z) {
            return (Builder) super.setSuppressRequiredParameterChecks(z);
        }
    }

    /* loaded from: classes2.dex */
    public class Changes {

        /* loaded from: classes2.dex */
        public class GetStartPageToken extends DriveRequest<StartPageToken> {
            private static final String REST_PATH = "changes/startPageToken";
            @e.g.b.a.d.q
            private Boolean supportsTeamDrives;
            @e.g.b.a.d.q
            private String teamDriveId;

            protected GetStartPageToken() {
                super(Drive.this, HttpGet.METHOD_NAME, REST_PATH, null, StartPageToken.class);
            }

            @Override // e.g.b.a.b.f.b
            public o buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // e.g.b.a.b.f.b
            public r executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public GetStartPageToken setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public GetStartPageToken setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<StartPageToken> setAlt2(String str) {
                return (GetStartPageToken) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<StartPageToken> setFields2(String str) {
                return (GetStartPageToken) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<StartPageToken> setKey2(String str) {
                return (GetStartPageToken) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<StartPageToken> setOauthToken2(String str) {
                return (GetStartPageToken) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<StartPageToken> setPrettyPrint2(Boolean bool) {
                return (GetStartPageToken) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<StartPageToken> setQuotaUser2(String str) {
                return (GetStartPageToken) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<StartPageToken> setUserIp2(String str) {
                return (GetStartPageToken) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public GetStartPageToken set(String str, Object obj) {
                return (GetStartPageToken) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class List extends DriveRequest<ChangeList> {
            private static final String REST_PATH = "changes";
            @e.g.b.a.d.q
            private Boolean includeCorpusRemovals;
            @e.g.b.a.d.q
            private Boolean includeRemoved;
            @e.g.b.a.d.q
            private Boolean includeTeamDriveItems;
            @e.g.b.a.d.q
            private Integer pageSize;
            @e.g.b.a.d.q
            private String pageToken;
            @e.g.b.a.d.q
            private Boolean restrictToMyDrive;
            @e.g.b.a.d.q
            private String spaces;
            @e.g.b.a.d.q
            private Boolean supportsTeamDrives;
            @e.g.b.a.d.q
            private String teamDriveId;

            protected List(String str) {
                super(Drive.this, HttpGet.METHOD_NAME, REST_PATH, null, ChangeList.class);
                this.pageToken = (String) y.e(str, "Required parameter pageToken must be specified.");
            }

            @Override // e.g.b.a.b.f.b
            public o buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // e.g.b.a.b.f.b
            public r executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public Boolean getIncludeCorpusRemovals() {
                return this.includeCorpusRemovals;
            }

            public Boolean getIncludeRemoved() {
                return this.includeRemoved;
            }

            public Boolean getIncludeTeamDriveItems() {
                return this.includeTeamDriveItems;
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public Boolean getRestrictToMyDrive() {
                return this.restrictToMyDrive;
            }

            public String getSpaces() {
                return this.spaces;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public boolean isIncludeCorpusRemovals() {
                Boolean bool = this.includeCorpusRemovals;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isIncludeRemoved() {
                Boolean bool = this.includeRemoved;
                if (bool == null || bool == j.a) {
                    return true;
                }
                return bool.booleanValue();
            }

            public boolean isIncludeTeamDriveItems() {
                Boolean bool = this.includeTeamDriveItems;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isRestrictToMyDrive() {
                Boolean bool = this.restrictToMyDrive;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public List setIncludeCorpusRemovals(Boolean bool) {
                this.includeCorpusRemovals = bool;
                return this;
            }

            public List setIncludeRemoved(Boolean bool) {
                this.includeRemoved = bool;
                return this;
            }

            public List setIncludeTeamDriveItems(Boolean bool) {
                this.includeTeamDriveItems = bool;
                return this;
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public List setRestrictToMyDrive(Boolean bool) {
                this.restrictToMyDrive = bool;
                return this;
            }

            public List setSpaces(String str) {
                this.spaces = str;
                return this;
            }

            public List setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public List setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<ChangeList> setAlt2(String str) {
                return (List) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<ChangeList> setFields2(String str) {
                return (List) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<ChangeList> setKey2(String str) {
                return (List) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<ChangeList> setOauthToken2(String str) {
                return (List) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<ChangeList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<ChangeList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<ChangeList> setUserIp2(String str) {
                return (List) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class Watch extends DriveRequest<Channel> {
            private static final String REST_PATH = "changes/watch";
            @e.g.b.a.d.q
            private Boolean includeCorpusRemovals;
            @e.g.b.a.d.q
            private Boolean includeRemoved;
            @e.g.b.a.d.q
            private Boolean includeTeamDriveItems;
            @e.g.b.a.d.q
            private Integer pageSize;
            @e.g.b.a.d.q
            private String pageToken;
            @e.g.b.a.d.q
            private Boolean restrictToMyDrive;
            @e.g.b.a.d.q
            private String spaces;
            @e.g.b.a.d.q
            private Boolean supportsTeamDrives;
            @e.g.b.a.d.q
            private String teamDriveId;

            protected Watch(String str, Channel channel) {
                super(Drive.this, HttpPost.METHOD_NAME, REST_PATH, channel, Channel.class);
                this.pageToken = (String) y.e(str, "Required parameter pageToken must be specified.");
            }

            public Boolean getIncludeCorpusRemovals() {
                return this.includeCorpusRemovals;
            }

            public Boolean getIncludeRemoved() {
                return this.includeRemoved;
            }

            public Boolean getIncludeTeamDriveItems() {
                return this.includeTeamDriveItems;
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public Boolean getRestrictToMyDrive() {
                return this.restrictToMyDrive;
            }

            public String getSpaces() {
                return this.spaces;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public boolean isIncludeCorpusRemovals() {
                Boolean bool = this.includeCorpusRemovals;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isIncludeRemoved() {
                Boolean bool = this.includeRemoved;
                if (bool == null || bool == j.a) {
                    return true;
                }
                return bool.booleanValue();
            }

            public boolean isIncludeTeamDriveItems() {
                Boolean bool = this.includeTeamDriveItems;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isRestrictToMyDrive() {
                Boolean bool = this.restrictToMyDrive;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Watch setIncludeCorpusRemovals(Boolean bool) {
                this.includeCorpusRemovals = bool;
                return this;
            }

            public Watch setIncludeRemoved(Boolean bool) {
                this.includeRemoved = bool;
                return this;
            }

            public Watch setIncludeTeamDriveItems(Boolean bool) {
                this.includeTeamDriveItems = bool;
                return this;
            }

            public Watch setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            public Watch setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public Watch setRestrictToMyDrive(Boolean bool) {
                this.restrictToMyDrive = bool;
                return this;
            }

            public Watch setSpaces(String str) {
                this.spaces = str;
                return this;
            }

            public Watch setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public Watch setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Channel> setAlt2(String str) {
                return (Watch) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Channel> setFields2(String str) {
                return (Watch) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Channel> setKey2(String str) {
                return (Watch) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Channel> setOauthToken2(String str) {
                return (Watch) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Channel> setPrettyPrint2(Boolean bool) {
                return (Watch) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Channel> setQuotaUser2(String str) {
                return (Watch) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Channel> setUserIp2(String str) {
                return (Watch) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Watch set(String str, Object obj) {
                return (Watch) super.set(str, obj);
            }
        }

        public Changes() {
        }

        public GetStartPageToken getStartPageToken() throws IOException {
            GetStartPageToken getStartPageToken = new GetStartPageToken();
            Drive.this.initialize(getStartPageToken);
            return getStartPageToken;
        }

        public List list(String str) throws IOException {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }

        public Watch watch(String str, Channel channel) throws IOException {
            Watch watch = new Watch(str, channel);
            Drive.this.initialize(watch);
            return watch;
        }
    }

    /* loaded from: classes2.dex */
    public class Channels {

        /* loaded from: classes2.dex */
        public class Stop extends DriveRequest<Void> {
            private static final String REST_PATH = "channels/stop";

            protected Stop(Channel channel) {
                super(Drive.this, HttpPost.METHOD_NAME, REST_PATH, channel, Void.class);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Stop) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Stop) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Stop) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Stop) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Stop) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Stop) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Stop) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Stop set(String str, Object obj) {
                return (Stop) super.set(str, obj);
            }
        }

        public Channels() {
        }

        public Stop stop(Channel channel) throws IOException {
            Stop stop = new Stop(channel);
            Drive.this.initialize(stop);
            return stop;
        }
    }

    /* loaded from: classes2.dex */
    public class Comments {

        /* loaded from: classes2.dex */
        public class Create extends DriveRequest<Comment> {
            private static final String REST_PATH = "files/{fileId}/comments";
            @e.g.b.a.d.q
            private String fileId;

            protected Create(String str, Comment comment) {
                super(Drive.this, HttpPost.METHOD_NAME, REST_PATH, comment, Comment.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
                checkRequiredParameter(comment, "content");
                checkRequiredParameter(comment.getContent(), "Comment.getContent()");
            }

            public String getFileId() {
                return this.fileId;
            }

            public Create setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Comment> setAlt2(String str) {
                return (Create) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Comment> setFields2(String str) {
                return (Create) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Comment> setKey2(String str) {
                return (Create) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Comment> setOauthToken2(String str) {
                return (Create) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Comment> setPrettyPrint2(Boolean bool) {
                return (Create) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Comment> setQuotaUser2(String str) {
                return (Create) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Comment> setUserIp2(String str) {
                return (Create) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Create set(String str, Object obj) {
                return (Create) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}";
            @e.g.b.a.d.q
            private String commentId;
            @e.g.b.a.d.q
            private String fileId;

            protected Delete(String str, String str2) {
                super(Drive.this, HttpDelete.METHOD_NAME, REST_PATH, null, Void.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
                this.commentId = (String) y.e(str2, "Required parameter commentId must be specified.");
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Delete setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class Get extends DriveRequest<Comment> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}";
            @e.g.b.a.d.q
            private String commentId;
            @e.g.b.a.d.q
            private String fileId;
            @e.g.b.a.d.q
            private Boolean includeDeleted;

            protected Get(String str, String str2) {
                super(Drive.this, HttpGet.METHOD_NAME, REST_PATH, null, Comment.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
                this.commentId = (String) y.e(str2, "Required parameter commentId must be specified.");
            }

            @Override // e.g.b.a.b.f.b
            public o buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // e.g.b.a.b.f.b
            public r executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public boolean isIncludeDeleted() {
                Boolean bool = this.includeDeleted;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Get setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Get setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Comment> setAlt2(String str) {
                return (Get) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Comment> setFields2(String str) {
                return (Get) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Comment> setKey2(String str) {
                return (Get) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Comment> setOauthToken2(String str) {
                return (Get) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Comment> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Comment> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Comment> setUserIp2(String str) {
                return (Get) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class List extends DriveRequest<CommentList> {
            private static final String REST_PATH = "files/{fileId}/comments";
            @e.g.b.a.d.q
            private String fileId;
            @e.g.b.a.d.q
            private Boolean includeDeleted;
            @e.g.b.a.d.q
            private Integer pageSize;
            @e.g.b.a.d.q
            private String pageToken;
            @e.g.b.a.d.q
            private String startModifiedTime;

            protected List(String str) {
                super(Drive.this, HttpGet.METHOD_NAME, REST_PATH, null, CommentList.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
            }

            @Override // e.g.b.a.b.f.b
            public o buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // e.g.b.a.b.f.b
            public r executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public String getStartModifiedTime() {
                return this.startModifiedTime;
            }

            public boolean isIncludeDeleted() {
                Boolean bool = this.includeDeleted;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public List setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public List setStartModifiedTime(String str) {
                this.startModifiedTime = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<CommentList> setAlt2(String str) {
                return (List) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<CommentList> setFields2(String str) {
                return (List) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<CommentList> setKey2(String str) {
                return (List) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<CommentList> setOauthToken2(String str) {
                return (List) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<CommentList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<CommentList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<CommentList> setUserIp2(String str) {
                return (List) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class Update extends DriveRequest<Comment> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}";
            @e.g.b.a.d.q
            private String commentId;
            @e.g.b.a.d.q
            private String fileId;

            protected Update(String str, String str2, Comment comment) {
                super(Drive.this, HttpPatch.METHOD_NAME, REST_PATH, comment, Comment.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
                this.commentId = (String) y.e(str2, "Required parameter commentId must be specified.");
                checkRequiredParameter(comment, "content");
                checkRequiredParameter(comment.getContent(), "Comment.getContent()");
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Update setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Comment> setAlt2(String str) {
                return (Update) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Comment> setFields2(String str) {
                return (Update) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Comment> setKey2(String str) {
                return (Update) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Comment> setOauthToken2(String str) {
                return (Update) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Comment> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Comment> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Comment> setUserIp2(String str) {
                return (Update) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }

        public Comments() {
        }

        public Create create(String str, Comment comment) throws IOException {
            Create create = new Create(str, comment);
            Drive.this.initialize(create);
            return create;
        }

        public Delete delete(String str, String str2) throws IOException {
            Delete delete = new Delete(str, str2);
            Drive.this.initialize(delete);
            return delete;
        }

        public Get get(String str, String str2) throws IOException {
            Get get = new Get(str, str2);
            Drive.this.initialize(get);
            return get;
        }

        public List list(String str) throws IOException {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }

        public Update update(String str, String str2, Comment comment) throws IOException {
            Update update = new Update(str, str2, comment);
            Drive.this.initialize(update);
            return update;
        }
    }

    /* loaded from: classes2.dex */
    public class Permissions {

        /* loaded from: classes2.dex */
        public class Create extends DriveRequest<Permission> {
            private static final String REST_PATH = "files/{fileId}/permissions";
            @e.g.b.a.d.q
            private String emailMessage;
            @e.g.b.a.d.q
            private String fileId;
            @e.g.b.a.d.q
            private Boolean sendNotificationEmail;
            @e.g.b.a.d.q
            private Boolean supportsTeamDrives;
            @e.g.b.a.d.q
            private Boolean transferOwnership;
            @e.g.b.a.d.q
            private Boolean useDomainAdminAccess;

            protected Create(String str, Permission permission) {
                super(Drive.this, HttpPost.METHOD_NAME, REST_PATH, permission, Permission.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
                checkRequiredParameter(permission, "content");
                checkRequiredParameter(permission.getRole(), "Permission.getRole()");
                checkRequiredParameter(permission, "content");
                checkRequiredParameter(permission.getType(), "Permission.getType()");
            }

            public String getEmailMessage() {
                return this.emailMessage;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getSendNotificationEmail() {
                return this.sendNotificationEmail;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Boolean getTransferOwnership() {
                return this.transferOwnership;
            }

            public Boolean getUseDomainAdminAccess() {
                return this.useDomainAdminAccess;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isTransferOwnership() {
                Boolean bool = this.transferOwnership;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isUseDomainAdminAccess() {
                Boolean bool = this.useDomainAdminAccess;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Create setEmailMessage(String str) {
                this.emailMessage = str;
                return this;
            }

            public Create setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Create setSendNotificationEmail(Boolean bool) {
                this.sendNotificationEmail = bool;
                return this;
            }

            public Create setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public Create setTransferOwnership(Boolean bool) {
                this.transferOwnership = bool;
                return this;
            }

            public Create setUseDomainAdminAccess(Boolean bool) {
                this.useDomainAdminAccess = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Permission> setAlt2(String str) {
                return (Create) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Permission> setFields2(String str) {
                return (Create) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Permission> setKey2(String str) {
                return (Create) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Permission> setOauthToken2(String str) {
                return (Create) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Permission> setPrettyPrint2(Boolean bool) {
                return (Create) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Permission> setQuotaUser2(String str) {
                return (Create) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Permission> setUserIp2(String str) {
                return (Create) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Create set(String str, Object obj) {
                return (Create) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/permissions/{permissionId}";
            @e.g.b.a.d.q
            private String fileId;
            @e.g.b.a.d.q
            private String permissionId;
            @e.g.b.a.d.q
            private Boolean supportsTeamDrives;
            @e.g.b.a.d.q
            private Boolean useDomainAdminAccess;

            protected Delete(String str, String str2) {
                super(Drive.this, HttpDelete.METHOD_NAME, REST_PATH, null, Void.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
                this.permissionId = (String) y.e(str2, "Required parameter permissionId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getPermissionId() {
                return this.permissionId;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Boolean getUseDomainAdminAccess() {
                return this.useDomainAdminAccess;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isUseDomainAdminAccess() {
                Boolean bool = this.useDomainAdminAccess;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Delete setPermissionId(String str) {
                this.permissionId = str;
                return this;
            }

            public Delete setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public Delete setUseDomainAdminAccess(Boolean bool) {
                this.useDomainAdminAccess = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class Get extends DriveRequest<Permission> {
            private static final String REST_PATH = "files/{fileId}/permissions/{permissionId}";
            @e.g.b.a.d.q
            private String fileId;
            @e.g.b.a.d.q
            private String permissionId;
            @e.g.b.a.d.q
            private Boolean supportsTeamDrives;
            @e.g.b.a.d.q
            private Boolean useDomainAdminAccess;

            protected Get(String str, String str2) {
                super(Drive.this, HttpGet.METHOD_NAME, REST_PATH, null, Permission.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
                this.permissionId = (String) y.e(str2, "Required parameter permissionId must be specified.");
            }

            @Override // e.g.b.a.b.f.b
            public o buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // e.g.b.a.b.f.b
            public r executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getPermissionId() {
                return this.permissionId;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Boolean getUseDomainAdminAccess() {
                return this.useDomainAdminAccess;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isUseDomainAdminAccess() {
                Boolean bool = this.useDomainAdminAccess;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Get setPermissionId(String str) {
                this.permissionId = str;
                return this;
            }

            public Get setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public Get setUseDomainAdminAccess(Boolean bool) {
                this.useDomainAdminAccess = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Permission> setAlt2(String str) {
                return (Get) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Permission> setFields2(String str) {
                return (Get) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Permission> setKey2(String str) {
                return (Get) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Permission> setOauthToken2(String str) {
                return (Get) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Permission> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Permission> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Permission> setUserIp2(String str) {
                return (Get) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class List extends DriveRequest<PermissionList> {
            private static final String REST_PATH = "files/{fileId}/permissions";
            @e.g.b.a.d.q
            private String fileId;
            @e.g.b.a.d.q
            private Integer pageSize;
            @e.g.b.a.d.q
            private String pageToken;
            @e.g.b.a.d.q
            private Boolean supportsTeamDrives;
            @e.g.b.a.d.q
            private Boolean useDomainAdminAccess;

            protected List(String str) {
                super(Drive.this, HttpGet.METHOD_NAME, REST_PATH, null, PermissionList.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
            }

            @Override // e.g.b.a.b.f.b
            public o buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // e.g.b.a.b.f.b
            public r executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public String getFileId() {
                return this.fileId;
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Boolean getUseDomainAdminAccess() {
                return this.useDomainAdminAccess;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isUseDomainAdminAccess() {
                Boolean bool = this.useDomainAdminAccess;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public List setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public List setUseDomainAdminAccess(Boolean bool) {
                this.useDomainAdminAccess = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<PermissionList> setAlt2(String str) {
                return (List) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<PermissionList> setFields2(String str) {
                return (List) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<PermissionList> setKey2(String str) {
                return (List) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<PermissionList> setOauthToken2(String str) {
                return (List) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<PermissionList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<PermissionList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<PermissionList> setUserIp2(String str) {
                return (List) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class Update extends DriveRequest<Permission> {
            private static final String REST_PATH = "files/{fileId}/permissions/{permissionId}";
            @e.g.b.a.d.q
            private String fileId;
            @e.g.b.a.d.q
            private String permissionId;
            @e.g.b.a.d.q
            private Boolean removeExpiration;
            @e.g.b.a.d.q
            private Boolean supportsTeamDrives;
            @e.g.b.a.d.q
            private Boolean transferOwnership;
            @e.g.b.a.d.q
            private Boolean useDomainAdminAccess;

            protected Update(String str, String str2, Permission permission) {
                super(Drive.this, HttpPatch.METHOD_NAME, REST_PATH, permission, Permission.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
                this.permissionId = (String) y.e(str2, "Required parameter permissionId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getPermissionId() {
                return this.permissionId;
            }

            public Boolean getRemoveExpiration() {
                return this.removeExpiration;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Boolean getTransferOwnership() {
                return this.transferOwnership;
            }

            public Boolean getUseDomainAdminAccess() {
                return this.useDomainAdminAccess;
            }

            public boolean isRemoveExpiration() {
                Boolean bool = this.removeExpiration;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isTransferOwnership() {
                Boolean bool = this.transferOwnership;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isUseDomainAdminAccess() {
                Boolean bool = this.useDomainAdminAccess;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Update setPermissionId(String str) {
                this.permissionId = str;
                return this;
            }

            public Update setRemoveExpiration(Boolean bool) {
                this.removeExpiration = bool;
                return this;
            }

            public Update setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public Update setTransferOwnership(Boolean bool) {
                this.transferOwnership = bool;
                return this;
            }

            public Update setUseDomainAdminAccess(Boolean bool) {
                this.useDomainAdminAccess = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Permission> setAlt2(String str) {
                return (Update) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Permission> setFields2(String str) {
                return (Update) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Permission> setKey2(String str) {
                return (Update) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Permission> setOauthToken2(String str) {
                return (Update) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Permission> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Permission> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Permission> setUserIp2(String str) {
                return (Update) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }

        public Permissions() {
        }

        public Create create(String str, Permission permission) throws IOException {
            Create create = new Create(str, permission);
            Drive.this.initialize(create);
            return create;
        }

        public Delete delete(String str, String str2) throws IOException {
            Delete delete = new Delete(str, str2);
            Drive.this.initialize(delete);
            return delete;
        }

        public Get get(String str, String str2) throws IOException {
            Get get = new Get(str, str2);
            Drive.this.initialize(get);
            return get;
        }

        public List list(String str) throws IOException {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }

        public Update update(String str, String str2, Permission permission) throws IOException {
            Update update = new Update(str, str2, permission);
            Drive.this.initialize(update);
            return update;
        }
    }

    /* loaded from: classes2.dex */
    public class Replies {

        /* loaded from: classes2.dex */
        public class Create extends DriveRequest<Reply> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies";
            @e.g.b.a.d.q
            private String commentId;
            @e.g.b.a.d.q
            private String fileId;

            protected Create(String str, String str2, Reply reply) {
                super(Drive.this, HttpPost.METHOD_NAME, REST_PATH, reply, Reply.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
                this.commentId = (String) y.e(str2, "Required parameter commentId must be specified.");
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Create setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Create setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Reply> setAlt2(String str) {
                return (Create) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Reply> setFields2(String str) {
                return (Create) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Reply> setKey2(String str) {
                return (Create) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Reply> setOauthToken2(String str) {
                return (Create) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Reply> setPrettyPrint2(Boolean bool) {
                return (Create) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Reply> setQuotaUser2(String str) {
                return (Create) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Reply> setUserIp2(String str) {
                return (Create) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Create set(String str, Object obj) {
                return (Create) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies/{replyId}";
            @e.g.b.a.d.q
            private String commentId;
            @e.g.b.a.d.q
            private String fileId;
            @e.g.b.a.d.q
            private String replyId;

            protected Delete(String str, String str2, String str3) {
                super(Drive.this, HttpDelete.METHOD_NAME, REST_PATH, null, Void.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
                this.commentId = (String) y.e(str2, "Required parameter commentId must be specified.");
                this.replyId = (String) y.e(str3, "Required parameter replyId must be specified.");
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getReplyId() {
                return this.replyId;
            }

            public Delete setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Delete setReplyId(String str) {
                this.replyId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class Get extends DriveRequest<Reply> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies/{replyId}";
            @e.g.b.a.d.q
            private String commentId;
            @e.g.b.a.d.q
            private String fileId;
            @e.g.b.a.d.q
            private Boolean includeDeleted;
            @e.g.b.a.d.q
            private String replyId;

            protected Get(String str, String str2, String str3) {
                super(Drive.this, HttpGet.METHOD_NAME, REST_PATH, null, Reply.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
                this.commentId = (String) y.e(str2, "Required parameter commentId must be specified.");
                this.replyId = (String) y.e(str3, "Required parameter replyId must be specified.");
            }

            @Override // e.g.b.a.b.f.b
            public o buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // e.g.b.a.b.f.b
            public r executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public String getReplyId() {
                return this.replyId;
            }

            public boolean isIncludeDeleted() {
                Boolean bool = this.includeDeleted;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Get setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Get setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public Get setReplyId(String str) {
                this.replyId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Reply> setAlt2(String str) {
                return (Get) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Reply> setFields2(String str) {
                return (Get) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Reply> setKey2(String str) {
                return (Get) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Reply> setOauthToken2(String str) {
                return (Get) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Reply> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Reply> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Reply> setUserIp2(String str) {
                return (Get) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class List extends DriveRequest<ReplyList> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies";
            @e.g.b.a.d.q
            private String commentId;
            @e.g.b.a.d.q
            private String fileId;
            @e.g.b.a.d.q
            private Boolean includeDeleted;
            @e.g.b.a.d.q
            private Integer pageSize;
            @e.g.b.a.d.q
            private String pageToken;

            protected List(String str, String str2) {
                super(Drive.this, HttpGet.METHOD_NAME, REST_PATH, null, ReplyList.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
                this.commentId = (String) y.e(str2, "Required parameter commentId must be specified.");
            }

            @Override // e.g.b.a.b.f.b
            public o buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // e.g.b.a.b.f.b
            public r executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public boolean isIncludeDeleted() {
                Boolean bool = this.includeDeleted;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public List setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public List setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<ReplyList> setAlt2(String str) {
                return (List) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<ReplyList> setFields2(String str) {
                return (List) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<ReplyList> setKey2(String str) {
                return (List) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<ReplyList> setOauthToken2(String str) {
                return (List) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<ReplyList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<ReplyList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<ReplyList> setUserIp2(String str) {
                return (List) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class Update extends DriveRequest<Reply> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies/{replyId}";
            @e.g.b.a.d.q
            private String commentId;
            @e.g.b.a.d.q
            private String fileId;
            @e.g.b.a.d.q
            private String replyId;

            protected Update(String str, String str2, String str3, Reply reply) {
                super(Drive.this, HttpPatch.METHOD_NAME, REST_PATH, reply, Reply.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
                this.commentId = (String) y.e(str2, "Required parameter commentId must be specified.");
                this.replyId = (String) y.e(str3, "Required parameter replyId must be specified.");
                checkRequiredParameter(reply, "content");
                checkRequiredParameter(reply.getContent(), "Reply.getContent()");
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getReplyId() {
                return this.replyId;
            }

            public Update setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Update setReplyId(String str) {
                this.replyId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Reply> setAlt2(String str) {
                return (Update) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Reply> setFields2(String str) {
                return (Update) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Reply> setKey2(String str) {
                return (Update) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Reply> setOauthToken2(String str) {
                return (Update) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Reply> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Reply> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Reply> setUserIp2(String str) {
                return (Update) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }

        public Replies() {
        }

        public Create create(String str, String str2, Reply reply) throws IOException {
            Create create = new Create(str, str2, reply);
            Drive.this.initialize(create);
            return create;
        }

        public Delete delete(String str, String str2, String str3) throws IOException {
            Delete delete = new Delete(str, str2, str3);
            Drive.this.initialize(delete);
            return delete;
        }

        public Get get(String str, String str2, String str3) throws IOException {
            Get get = new Get(str, str2, str3);
            Drive.this.initialize(get);
            return get;
        }

        public List list(String str, String str2) throws IOException {
            List list = new List(str, str2);
            Drive.this.initialize(list);
            return list;
        }

        public Update update(String str, String str2, String str3, Reply reply) throws IOException {
            Update update = new Update(str, str2, str3, reply);
            Drive.this.initialize(update);
            return update;
        }
    }

    /* loaded from: classes2.dex */
    public class Revisions {

        /* loaded from: classes2.dex */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/revisions/{revisionId}";
            @e.g.b.a.d.q
            private String fileId;
            @e.g.b.a.d.q
            private String revisionId;

            protected Delete(String str, String str2) {
                super(Drive.this, HttpDelete.METHOD_NAME, REST_PATH, null, Void.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
                this.revisionId = (String) y.e(str2, "Required parameter revisionId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getRevisionId() {
                return this.revisionId;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Delete setRevisionId(String str) {
                this.revisionId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class Get extends DriveRequest<Revision> {
            private static final String REST_PATH = "files/{fileId}/revisions/{revisionId}";
            @e.g.b.a.d.q
            private Boolean acknowledgeAbuse;
            @e.g.b.a.d.q
            private String fileId;
            @e.g.b.a.d.q
            private String revisionId;

            protected Get(String str, String str2) {
                super(Drive.this, HttpGet.METHOD_NAME, REST_PATH, null, Revision.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
                this.revisionId = (String) y.e(str2, "Required parameter revisionId must be specified.");
                initializeMediaDownload();
            }

            @Override // e.g.b.a.b.f.b
            public g buildHttpRequestUrl() {
                String baseUrl;
                if (SVGParser.XML_STYLESHEET_ATTR_MEDIA.equals(get("alt")) && getMediaHttpUploader() == null) {
                    baseUrl = Drive.this.getRootUrl() + "download/" + Drive.this.getServicePath();
                } else {
                    baseUrl = Drive.this.getBaseUrl();
                }
                return new g(a0.b(baseUrl, getUriTemplate(), this, true));
            }

            @Override // e.g.b.a.b.f.b
            public o buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // e.g.b.a.b.f.b
            public r executeMedia() throws IOException {
                return super.executeMedia();
            }

            @Override // e.g.b.a.b.f.b
            public void executeMediaAndDownloadTo(OutputStream outputStream) throws IOException {
                super.executeMediaAndDownloadTo(outputStream);
            }

            @Override // e.g.b.a.b.f.b
            public InputStream executeMediaAsInputStream() throws IOException {
                return super.executeMediaAsInputStream();
            }

            @Override // e.g.b.a.b.f.b
            public r executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public Boolean getAcknowledgeAbuse() {
                return this.acknowledgeAbuse;
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getRevisionId() {
                return this.revisionId;
            }

            public boolean isAcknowledgeAbuse() {
                Boolean bool = this.acknowledgeAbuse;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Get setAcknowledgeAbuse(Boolean bool) {
                this.acknowledgeAbuse = bool;
                return this;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Get setRevisionId(String str) {
                this.revisionId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Revision> setAlt2(String str) {
                return (Get) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Revision> setFields2(String str) {
                return (Get) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Revision> setKey2(String str) {
                return (Get) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Revision> setOauthToken2(String str) {
                return (Get) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Revision> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Revision> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Revision> setUserIp2(String str) {
                return (Get) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class List extends DriveRequest<RevisionList> {
            private static final String REST_PATH = "files/{fileId}/revisions";
            @e.g.b.a.d.q
            private String fileId;
            @e.g.b.a.d.q
            private Integer pageSize;
            @e.g.b.a.d.q
            private String pageToken;

            protected List(String str) {
                super(Drive.this, HttpGet.METHOD_NAME, REST_PATH, null, RevisionList.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
            }

            @Override // e.g.b.a.b.f.b
            public o buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // e.g.b.a.b.f.b
            public r executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public String getFileId() {
                return this.fileId;
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<RevisionList> setAlt2(String str) {
                return (List) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<RevisionList> setFields2(String str) {
                return (List) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<RevisionList> setKey2(String str) {
                return (List) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<RevisionList> setOauthToken2(String str) {
                return (List) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<RevisionList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<RevisionList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<RevisionList> setUserIp2(String str) {
                return (List) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class Update extends DriveRequest<Revision> {
            private static final String REST_PATH = "files/{fileId}/revisions/{revisionId}";
            @e.g.b.a.d.q
            private String fileId;
            @e.g.b.a.d.q
            private String revisionId;

            protected Update(String str, String str2, Revision revision) {
                super(Drive.this, HttpPatch.METHOD_NAME, REST_PATH, revision, Revision.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
                this.revisionId = (String) y.e(str2, "Required parameter revisionId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getRevisionId() {
                return this.revisionId;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Update setRevisionId(String str) {
                this.revisionId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Revision> setAlt2(String str) {
                return (Update) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Revision> setFields2(String str) {
                return (Update) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Revision> setKey2(String str) {
                return (Update) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Revision> setOauthToken2(String str) {
                return (Update) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Revision> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Revision> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Revision> setUserIp2(String str) {
                return (Update) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }

        public Revisions() {
        }

        public Delete delete(String str, String str2) throws IOException {
            Delete delete = new Delete(str, str2);
            Drive.this.initialize(delete);
            return delete;
        }

        public Get get(String str, String str2) throws IOException {
            Get get = new Get(str, str2);
            Drive.this.initialize(get);
            return get;
        }

        public List list(String str) throws IOException {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }

        public Update update(String str, String str2, Revision revision) throws IOException {
            Update update = new Update(str, str2, revision);
            Drive.this.initialize(update);
            return update;
        }
    }

    /* loaded from: classes2.dex */
    public class Teamdrives {

        /* loaded from: classes2.dex */
        public class Create extends DriveRequest<TeamDrive> {
            private static final String REST_PATH = "teamdrives";
            @e.g.b.a.d.q
            private String requestId;

            protected Create(String str, TeamDrive teamDrive) {
                super(Drive.this, HttpPost.METHOD_NAME, REST_PATH, teamDrive, TeamDrive.class);
                this.requestId = (String) y.e(str, "Required parameter requestId must be specified.");
            }

            public String getRequestId() {
                return this.requestId;
            }

            public Create setRequestId(String str) {
                this.requestId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<TeamDrive> setAlt2(String str) {
                return (Create) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<TeamDrive> setFields2(String str) {
                return (Create) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<TeamDrive> setKey2(String str) {
                return (Create) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<TeamDrive> setOauthToken2(String str) {
                return (Create) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<TeamDrive> setPrettyPrint2(Boolean bool) {
                return (Create) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<TeamDrive> setQuotaUser2(String str) {
                return (Create) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<TeamDrive> setUserIp2(String str) {
                return (Create) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Create set(String str, Object obj) {
                return (Create) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "teamdrives/{teamDriveId}";
            @e.g.b.a.d.q
            private String teamDriveId;

            protected Delete(String str) {
                super(Drive.this, HttpDelete.METHOD_NAME, REST_PATH, null, Void.class);
                this.teamDriveId = (String) y.e(str, "Required parameter teamDriveId must be specified.");
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public Delete setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class Get extends DriveRequest<TeamDrive> {
            private static final String REST_PATH = "teamdrives/{teamDriveId}";
            @e.g.b.a.d.q
            private String teamDriveId;
            @e.g.b.a.d.q
            private Boolean useDomainAdminAccess;

            protected Get(String str) {
                super(Drive.this, HttpGet.METHOD_NAME, REST_PATH, null, TeamDrive.class);
                this.teamDriveId = (String) y.e(str, "Required parameter teamDriveId must be specified.");
            }

            @Override // e.g.b.a.b.f.b
            public o buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // e.g.b.a.b.f.b
            public r executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public Boolean getUseDomainAdminAccess() {
                return this.useDomainAdminAccess;
            }

            public boolean isUseDomainAdminAccess() {
                Boolean bool = this.useDomainAdminAccess;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Get setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            public Get setUseDomainAdminAccess(Boolean bool) {
                this.useDomainAdminAccess = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<TeamDrive> setAlt2(String str) {
                return (Get) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<TeamDrive> setFields2(String str) {
                return (Get) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<TeamDrive> setKey2(String str) {
                return (Get) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<TeamDrive> setOauthToken2(String str) {
                return (Get) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<TeamDrive> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<TeamDrive> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<TeamDrive> setUserIp2(String str) {
                return (Get) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class List extends DriveRequest<TeamDriveList> {
            private static final String REST_PATH = "teamdrives";
            @e.g.b.a.d.q
            private Integer pageSize;
            @e.g.b.a.d.q
            private String pageToken;
            @e.g.b.a.d.q
            private String q;
            @e.g.b.a.d.q
            private Boolean useDomainAdminAccess;

            protected List() {
                super(Drive.this, HttpGet.METHOD_NAME, REST_PATH, null, TeamDriveList.class);
            }

            @Override // e.g.b.a.b.f.b
            public o buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // e.g.b.a.b.f.b
            public r executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public String getQ() {
                return this.q;
            }

            public Boolean getUseDomainAdminAccess() {
                return this.useDomainAdminAccess;
            }

            public boolean isUseDomainAdminAccess() {
                Boolean bool = this.useDomainAdminAccess;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public List setQ(String str) {
                this.q = str;
                return this;
            }

            public List setUseDomainAdminAccess(Boolean bool) {
                this.useDomainAdminAccess = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<TeamDriveList> setAlt2(String str) {
                return (List) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<TeamDriveList> setFields2(String str) {
                return (List) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<TeamDriveList> setKey2(String str) {
                return (List) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<TeamDriveList> setOauthToken2(String str) {
                return (List) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<TeamDriveList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<TeamDriveList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<TeamDriveList> setUserIp2(String str) {
                return (List) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class Update extends DriveRequest<TeamDrive> {
            private static final String REST_PATH = "teamdrives/{teamDriveId}";
            @e.g.b.a.d.q
            private String teamDriveId;
            @e.g.b.a.d.q
            private Boolean useDomainAdminAccess;

            protected Update(String str, TeamDrive teamDrive) {
                super(Drive.this, HttpPatch.METHOD_NAME, REST_PATH, teamDrive, TeamDrive.class);
                this.teamDriveId = (String) y.e(str, "Required parameter teamDriveId must be specified.");
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public Boolean getUseDomainAdminAccess() {
                return this.useDomainAdminAccess;
            }

            public boolean isUseDomainAdminAccess() {
                Boolean bool = this.useDomainAdminAccess;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Update setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            public Update setUseDomainAdminAccess(Boolean bool) {
                this.useDomainAdminAccess = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<TeamDrive> setAlt2(String str) {
                return (Update) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<TeamDrive> setFields2(String str) {
                return (Update) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<TeamDrive> setKey2(String str) {
                return (Update) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<TeamDrive> setOauthToken2(String str) {
                return (Update) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<TeamDrive> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<TeamDrive> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<TeamDrive> setUserIp2(String str) {
                return (Update) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }

        public Teamdrives() {
        }

        public Create create(String str, TeamDrive teamDrive) throws IOException {
            Create create = new Create(str, teamDrive);
            Drive.this.initialize(create);
            return create;
        }

        public Delete delete(String str) throws IOException {
            Delete delete = new Delete(str);
            Drive.this.initialize(delete);
            return delete;
        }

        public Get get(String str) throws IOException {
            Get get = new Get(str);
            Drive.this.initialize(get);
            return get;
        }

        public List list() throws IOException {
            List list = new List();
            Drive.this.initialize(list);
            return list;
        }

        public Update update(String str, TeamDrive teamDrive) throws IOException {
            Update update = new Update(str, teamDrive);
            Drive.this.initialize(update);
            return update;
        }
    }

    static {
        y.h(e.g.b.a.b.a.a.intValue() == 1 && e.g.b.a.b.a.f13338b.intValue() >= 15, "You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.25.0 of the Drive API library.", e.g.b.a.b.a.f13340d);
    }

    public Drive(u uVar, c cVar, q qVar) {
        this(new Builder(uVar, cVar, qVar));
    }

    public About about() {
        return new About();
    }

    public Changes changes() {
        return new Changes();
    }

    public Channels channels() {
        return new Channels();
    }

    public Comments comments() {
        return new Comments();
    }

    public Files files() {
        return new Files();
    }

    @Override // e.g.b.a.b.f.a
    protected void initialize(b<?> bVar) throws IOException {
        super.initialize(bVar);
    }

    public Permissions permissions() {
        return new Permissions();
    }

    public Replies replies() {
        return new Replies();
    }

    public Revisions revisions() {
        return new Revisions();
    }

    public Teamdrives teamdrives() {
        return new Teamdrives();
    }

    /* loaded from: classes2.dex */
    public class Files {

        /* loaded from: classes2.dex */
        public class Copy extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}/copy";
            @e.g.b.a.d.q
            private String fileId;
            @e.g.b.a.d.q
            private Boolean ignoreDefaultVisibility;
            @e.g.b.a.d.q
            private Boolean keepRevisionForever;
            @e.g.b.a.d.q
            private String ocrLanguage;
            @e.g.b.a.d.q
            private Boolean supportsTeamDrives;

            protected Copy(String str, File file) {
                super(Drive.this, HttpPost.METHOD_NAME, REST_PATH, file, File.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getIgnoreDefaultVisibility() {
                return this.ignoreDefaultVisibility;
            }

            public Boolean getKeepRevisionForever() {
                return this.keepRevisionForever;
            }

            public String getOcrLanguage() {
                return this.ocrLanguage;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public boolean isIgnoreDefaultVisibility() {
                Boolean bool = this.ignoreDefaultVisibility;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isKeepRevisionForever() {
                Boolean bool = this.keepRevisionForever;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Copy setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Copy setIgnoreDefaultVisibility(Boolean bool) {
                this.ignoreDefaultVisibility = bool;
                return this;
            }

            public Copy setKeepRevisionForever(Boolean bool) {
                this.keepRevisionForever = bool;
                return this;
            }

            public Copy setOcrLanguage(String str) {
                this.ocrLanguage = str;
                return this;
            }

            public Copy setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Copy) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Copy) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Copy) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Copy) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Copy) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Copy) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<File> setUserIp2(String str) {
                return (Copy) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Copy set(String str, Object obj) {
                return (Copy) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class Create extends DriveRequest<File> {
            private static final String REST_PATH = "files";
            @e.g.b.a.d.q
            private Boolean ignoreDefaultVisibility;
            @e.g.b.a.d.q
            private Boolean keepRevisionForever;
            @e.g.b.a.d.q
            private String ocrLanguage;
            @e.g.b.a.d.q
            private Boolean supportsTeamDrives;
            @e.g.b.a.d.q
            private Boolean useContentAsIndexableText;

            protected Create(File file) {
                super(Drive.this, HttpPost.METHOD_NAME, REST_PATH, file, File.class);
            }

            public Boolean getIgnoreDefaultVisibility() {
                return this.ignoreDefaultVisibility;
            }

            public Boolean getKeepRevisionForever() {
                return this.keepRevisionForever;
            }

            public String getOcrLanguage() {
                return this.ocrLanguage;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Boolean getUseContentAsIndexableText() {
                return this.useContentAsIndexableText;
            }

            public boolean isIgnoreDefaultVisibility() {
                Boolean bool = this.ignoreDefaultVisibility;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isKeepRevisionForever() {
                Boolean bool = this.keepRevisionForever;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isUseContentAsIndexableText() {
                Boolean bool = this.useContentAsIndexableText;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Create setIgnoreDefaultVisibility(Boolean bool) {
                this.ignoreDefaultVisibility = bool;
                return this;
            }

            public Create setKeepRevisionForever(Boolean bool) {
                this.keepRevisionForever = bool;
                return this;
            }

            public Create setOcrLanguage(String str) {
                this.ocrLanguage = str;
                return this;
            }

            public Create setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public Create setUseContentAsIndexableText(Boolean bool) {
                this.useContentAsIndexableText = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Create) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Create) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Create) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Create) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Create) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Create) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<File> setUserIp2(String str) {
                return (Create) super.setUserIp(str);
            }

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            protected Create(com.google.api.services.drive.model.File r8, com.google.api.client.http.b r9) {
                /*
                    r6 = this;
                    com.google.api.services.drive.Drive.Files.this = r7
                    com.google.api.services.drive.Drive r1 = com.google.api.services.drive.Drive.this
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "/upload/"
                    r0.append(r2)
                    com.google.api.services.drive.Drive r7 = com.google.api.services.drive.Drive.this
                    java.lang.String r7 = r7.getServicePath()
                    r0.append(r7)
                    java.lang.String r7 = "files"
                    r0.append(r7)
                    java.lang.String r3 = r0.toString()
                    java.lang.Class<com.google.api.services.drive.model.File> r5 = com.google.api.services.drive.model.File.class
                    java.lang.String r2 = "POST"
                    r0 = r6
                    r4 = r8
                    r0.<init>(r1, r2, r3, r4, r5)
                    r6.initializeMediaUpload(r9)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.api.services.drive.Drive.Files.Create.<init>(com.google.api.services.drive.Drive$Files, com.google.api.services.drive.model.File, com.google.api.client.http.b):void");
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Create set(String str, Object obj) {
                return (Create) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}";
            @e.g.b.a.d.q
            private String fileId;
            @e.g.b.a.d.q
            private Boolean supportsTeamDrives;

            protected Delete(String str) {
                super(Drive.this, HttpDelete.METHOD_NAME, REST_PATH, null, Void.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Delete setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class EmptyTrash extends DriveRequest<Void> {
            private static final String REST_PATH = "files/trash";

            protected EmptyTrash() {
                super(Drive.this, HttpDelete.METHOD_NAME, REST_PATH, null, Void.class);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (EmptyTrash) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (EmptyTrash) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (EmptyTrash) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (EmptyTrash) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (EmptyTrash) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (EmptyTrash) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (EmptyTrash) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public EmptyTrash set(String str, Object obj) {
                return (EmptyTrash) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class Export extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/export";
            @e.g.b.a.d.q
            private String fileId;
            @e.g.b.a.d.q
            private String mimeType;

            protected Export(String str, String str2) {
                super(Drive.this, HttpGet.METHOD_NAME, REST_PATH, null, Void.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
                this.mimeType = (String) y.e(str2, "Required parameter mimeType must be specified.");
                initializeMediaDownload();
            }

            @Override // e.g.b.a.b.f.b
            public o buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // e.g.b.a.b.f.b
            public r executeMedia() throws IOException {
                return super.executeMedia();
            }

            @Override // e.g.b.a.b.f.b
            public void executeMediaAndDownloadTo(OutputStream outputStream) throws IOException {
                super.executeMediaAndDownloadTo(outputStream);
            }

            @Override // e.g.b.a.b.f.b
            public InputStream executeMediaAsInputStream() throws IOException {
                return super.executeMediaAsInputStream();
            }

            @Override // e.g.b.a.b.f.b
            public r executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getMimeType() {
                return this.mimeType;
            }

            public Export setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Export setMimeType(String str) {
                this.mimeType = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Export) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Export) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Export) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Export) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Export) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Export) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Export) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Export set(String str, Object obj) {
                return (Export) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class GenerateIds extends DriveRequest<GeneratedIds> {
            private static final String REST_PATH = "files/generateIds";
            @e.g.b.a.d.q
            private Integer count;
            @e.g.b.a.d.q
            private String space;

            protected GenerateIds() {
                super(Drive.this, HttpGet.METHOD_NAME, REST_PATH, null, GeneratedIds.class);
            }

            @Override // e.g.b.a.b.f.b
            public o buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // e.g.b.a.b.f.b
            public r executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public Integer getCount() {
                return this.count;
            }

            public String getSpace() {
                return this.space;
            }

            public GenerateIds setCount(Integer num) {
                this.count = num;
                return this;
            }

            public GenerateIds setSpace(String str) {
                this.space = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<GeneratedIds> setAlt2(String str) {
                return (GenerateIds) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<GeneratedIds> setFields2(String str) {
                return (GenerateIds) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<GeneratedIds> setKey2(String str) {
                return (GenerateIds) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<GeneratedIds> setOauthToken2(String str) {
                return (GenerateIds) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<GeneratedIds> setPrettyPrint2(Boolean bool) {
                return (GenerateIds) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<GeneratedIds> setQuotaUser2(String str) {
                return (GenerateIds) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<GeneratedIds> setUserIp2(String str) {
                return (GenerateIds) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public GenerateIds set(String str, Object obj) {
                return (GenerateIds) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class Get extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}";
            @e.g.b.a.d.q
            private Boolean acknowledgeAbuse;
            @e.g.b.a.d.q
            private String fileId;
            @e.g.b.a.d.q
            private Boolean supportsTeamDrives;

            protected Get(String str) {
                super(Drive.this, HttpGet.METHOD_NAME, REST_PATH, null, File.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
                initializeMediaDownload();
            }

            @Override // e.g.b.a.b.f.b
            public g buildHttpRequestUrl() {
                String baseUrl;
                if (SVGParser.XML_STYLESHEET_ATTR_MEDIA.equals(get("alt")) && getMediaHttpUploader() == null) {
                    baseUrl = Drive.this.getRootUrl() + "download/" + Drive.this.getServicePath();
                } else {
                    baseUrl = Drive.this.getBaseUrl();
                }
                return new g(a0.b(baseUrl, getUriTemplate(), this, true));
            }

            @Override // e.g.b.a.b.f.b
            public o buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // e.g.b.a.b.f.b
            public r executeMedia() throws IOException {
                return super.executeMedia();
            }

            @Override // e.g.b.a.b.f.b
            public void executeMediaAndDownloadTo(OutputStream outputStream) throws IOException {
                super.executeMediaAndDownloadTo(outputStream);
            }

            @Override // e.g.b.a.b.f.b
            public InputStream executeMediaAsInputStream() throws IOException {
                return super.executeMediaAsInputStream();
            }

            @Override // e.g.b.a.b.f.b
            public r executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public Boolean getAcknowledgeAbuse() {
                return this.acknowledgeAbuse;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public boolean isAcknowledgeAbuse() {
                Boolean bool = this.acknowledgeAbuse;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Get setAcknowledgeAbuse(Boolean bool) {
                this.acknowledgeAbuse = bool;
                return this;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Get setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Get) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Get) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Get) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Get) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<File> setUserIp2(String str) {
                return (Get) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class List extends DriveRequest<FileList> {
            private static final String REST_PATH = "files";
            @e.g.b.a.d.q
            private String corpora;
            @e.g.b.a.d.q
            private String corpus;
            @e.g.b.a.d.q
            private Boolean includeTeamDriveItems;
            @e.g.b.a.d.q
            private String orderBy;
            @e.g.b.a.d.q
            private Integer pageSize;
            @e.g.b.a.d.q
            private String pageToken;
            @e.g.b.a.d.q
            private String q;
            @e.g.b.a.d.q
            private String spaces;
            @e.g.b.a.d.q
            private Boolean supportsTeamDrives;
            @e.g.b.a.d.q
            private String teamDriveId;

            protected List() {
                super(Drive.this, HttpGet.METHOD_NAME, REST_PATH, null, FileList.class);
            }

            @Override // e.g.b.a.b.f.b
            public o buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // e.g.b.a.b.f.b
            public r executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public String getCorpora() {
                return this.corpora;
            }

            public String getCorpus() {
                return this.corpus;
            }

            public Boolean getIncludeTeamDriveItems() {
                return this.includeTeamDriveItems;
            }

            public String getOrderBy() {
                return this.orderBy;
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public String getQ() {
                return this.q;
            }

            public String getSpaces() {
                return this.spaces;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public boolean isIncludeTeamDriveItems() {
                Boolean bool = this.includeTeamDriveItems;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public List setCorpora(String str) {
                this.corpora = str;
                return this;
            }

            public List setCorpus(String str) {
                this.corpus = str;
                return this;
            }

            public List setIncludeTeamDriveItems(Boolean bool) {
                this.includeTeamDriveItems = bool;
                return this;
            }

            public List setOrderBy(String str) {
                this.orderBy = str;
                return this;
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public List setQ(String str) {
                this.q = str;
                return this;
            }

            public List setSpaces(String str) {
                this.spaces = str;
                return this;
            }

            public List setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public List setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<FileList> setAlt2(String str) {
                return (List) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<FileList> setFields2(String str) {
                return (List) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<FileList> setKey2(String str) {
                return (List) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<FileList> setOauthToken2(String str) {
                return (List) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<FileList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<FileList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<FileList> setUserIp2(String str) {
                return (List) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class Update extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}";
            @e.g.b.a.d.q
            private String addParents;
            @e.g.b.a.d.q
            private String fileId;
            @e.g.b.a.d.q
            private Boolean keepRevisionForever;
            @e.g.b.a.d.q
            private String ocrLanguage;
            @e.g.b.a.d.q
            private String removeParents;
            @e.g.b.a.d.q
            private Boolean supportsTeamDrives;
            @e.g.b.a.d.q
            private Boolean useContentAsIndexableText;

            protected Update(String str, File file) {
                super(Drive.this, HttpPatch.METHOD_NAME, REST_PATH, file, File.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
            }

            public String getAddParents() {
                return this.addParents;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getKeepRevisionForever() {
                return this.keepRevisionForever;
            }

            public String getOcrLanguage() {
                return this.ocrLanguage;
            }

            public String getRemoveParents() {
                return this.removeParents;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Boolean getUseContentAsIndexableText() {
                return this.useContentAsIndexableText;
            }

            public boolean isKeepRevisionForever() {
                Boolean bool = this.keepRevisionForever;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isUseContentAsIndexableText() {
                Boolean bool = this.useContentAsIndexableText;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Update setAddParents(String str) {
                this.addParents = str;
                return this;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Update setKeepRevisionForever(Boolean bool) {
                this.keepRevisionForever = bool;
                return this;
            }

            public Update setOcrLanguage(String str) {
                this.ocrLanguage = str;
                return this;
            }

            public Update setRemoveParents(String str) {
                this.removeParents = str;
                return this;
            }

            public Update setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public Update setUseContentAsIndexableText(Boolean bool) {
                this.useContentAsIndexableText = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Update) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Update) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Update) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Update) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<File> setUserIp2(String str) {
                return (Update) super.setUserIp(str);
            }

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            protected Update(java.lang.String r8, com.google.api.services.drive.model.File r9, com.google.api.client.http.b r10) {
                /*
                    r6 = this;
                    com.google.api.services.drive.Drive.Files.this = r7
                    com.google.api.services.drive.Drive r1 = com.google.api.services.drive.Drive.this
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "/upload/"
                    r0.append(r2)
                    com.google.api.services.drive.Drive r7 = com.google.api.services.drive.Drive.this
                    java.lang.String r7 = r7.getServicePath()
                    r0.append(r7)
                    java.lang.String r7 = "files/{fileId}"
                    r0.append(r7)
                    java.lang.String r3 = r0.toString()
                    java.lang.Class<com.google.api.services.drive.model.File> r5 = com.google.api.services.drive.model.File.class
                    java.lang.String r2 = "PATCH"
                    r0 = r6
                    r4 = r9
                    r0.<init>(r1, r2, r3, r4, r5)
                    java.lang.String r7 = "Required parameter fileId must be specified."
                    java.lang.Object r7 = e.g.b.a.d.y.e(r8, r7)
                    java.lang.String r7 = (java.lang.String) r7
                    r6.fileId = r7
                    r6.initializeMediaUpload(r10)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.api.services.drive.Drive.Files.Update.<init>(com.google.api.services.drive.Drive$Files, java.lang.String, com.google.api.services.drive.model.File, com.google.api.client.http.b):void");
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class Watch extends DriveRequest<Channel> {
            private static final String REST_PATH = "files/{fileId}/watch";
            @e.g.b.a.d.q
            private Boolean acknowledgeAbuse;
            @e.g.b.a.d.q
            private String fileId;
            @e.g.b.a.d.q
            private Boolean supportsTeamDrives;

            protected Watch(String str, Channel channel) {
                super(Drive.this, HttpPost.METHOD_NAME, REST_PATH, channel, Channel.class);
                this.fileId = (String) y.e(str, "Required parameter fileId must be specified.");
                initializeMediaDownload();
            }

            @Override // e.g.b.a.b.f.b
            public g buildHttpRequestUrl() {
                String baseUrl;
                if (SVGParser.XML_STYLESHEET_ATTR_MEDIA.equals(get("alt")) && getMediaHttpUploader() == null) {
                    baseUrl = Drive.this.getRootUrl() + "download/" + Drive.this.getServicePath();
                } else {
                    baseUrl = Drive.this.getBaseUrl();
                }
                return new g(a0.b(baseUrl, getUriTemplate(), this, true));
            }

            @Override // e.g.b.a.b.f.b
            public r executeMedia() throws IOException {
                return super.executeMedia();
            }

            @Override // e.g.b.a.b.f.b
            public void executeMediaAndDownloadTo(OutputStream outputStream) throws IOException {
                super.executeMediaAndDownloadTo(outputStream);
            }

            @Override // e.g.b.a.b.f.b
            public InputStream executeMediaAsInputStream() throws IOException {
                return super.executeMediaAsInputStream();
            }

            public Boolean getAcknowledgeAbuse() {
                return this.acknowledgeAbuse;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public boolean isAcknowledgeAbuse() {
                Boolean bool = this.acknowledgeAbuse;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == j.a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Watch setAcknowledgeAbuse(Boolean bool) {
                this.acknowledgeAbuse = bool;
                return this;
            }

            public Watch setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Watch setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Channel> setAlt2(String str) {
                return (Watch) super.setAlt(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Channel> setFields2(String str) {
                return (Watch) super.setFields(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Channel> setKey2(String str) {
                return (Watch) super.setKey(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Channel> setOauthToken2(String str) {
                return (Watch) super.setOauthToken(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Channel> setPrettyPrint2(Boolean bool) {
                return (Watch) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Channel> setQuotaUser2(String str) {
                return (Watch) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Channel> setUserIp2(String str) {
                return (Watch) super.setUserIp(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
            public Watch set(String str, Object obj) {
                return (Watch) super.set(str, obj);
            }
        }

        public Files() {
        }

        public Copy copy(String str, File file) throws IOException {
            Copy copy = new Copy(str, file);
            Drive.this.initialize(copy);
            return copy;
        }

        public Create create(File file) throws IOException {
            Create create = new Create(file);
            Drive.this.initialize(create);
            return create;
        }

        public Delete delete(String str) throws IOException {
            Delete delete = new Delete(str);
            Drive.this.initialize(delete);
            return delete;
        }

        public EmptyTrash emptyTrash() throws IOException {
            EmptyTrash emptyTrash = new EmptyTrash();
            Drive.this.initialize(emptyTrash);
            return emptyTrash;
        }

        public Export export(String str, String str2) throws IOException {
            Export export = new Export(str, str2);
            Drive.this.initialize(export);
            return export;
        }

        public GenerateIds generateIds() throws IOException {
            GenerateIds generateIds = new GenerateIds();
            Drive.this.initialize(generateIds);
            return generateIds;
        }

        public Get get(String str) throws IOException {
            Get get = new Get(str);
            Drive.this.initialize(get);
            return get;
        }

        public List list() throws IOException {
            List list = new List();
            Drive.this.initialize(list);
            return list;
        }

        public Update update(String str, File file) throws IOException {
            Update update = new Update(str, file);
            Drive.this.initialize(update);
            return update;
        }

        public Watch watch(String str, Channel channel) throws IOException {
            Watch watch = new Watch(str, channel);
            Drive.this.initialize(watch);
            return watch;
        }

        public Create create(File file, com.google.api.client.http.b bVar) throws IOException {
            Create create = new Create(file, bVar);
            Drive.this.initialize(create);
            return create;
        }

        public Update update(String str, File file, com.google.api.client.http.b bVar) throws IOException {
            Update update = new Update(str, file, bVar);
            Drive.this.initialize(update);
            return update;
        }
    }

    Drive(Builder builder) {
        super(builder);
    }
}