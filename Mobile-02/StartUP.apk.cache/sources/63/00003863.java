package com.google.api.services.drive;

import com.google.api.client.http.l;
import e.g.b.a.b.f.e.b;
import e.g.b.a.d.q;

/* loaded from: classes2.dex */
public abstract class DriveRequest<T> extends b<T> {
    @q
    private String alt;
    @q
    private String fields;
    @q
    private String key;
    @q("oauth_token")
    private String oauthToken;
    @q
    private Boolean prettyPrint;
    @q
    private String quotaUser;
    @q
    private String userIp;

    public DriveRequest(Drive drive, String str, String str2, Object obj, Class<T> cls) {
        super(drive, str, str2, obj, cls);
    }

    public String getAlt() {
        return this.alt;
    }

    public String getFields() {
        return this.fields;
    }

    public String getKey() {
        return this.key;
    }

    public String getOauthToken() {
        return this.oauthToken;
    }

    public Boolean getPrettyPrint() {
        return this.prettyPrint;
    }

    public String getQuotaUser() {
        return this.quotaUser;
    }

    public String getUserIp() {
        return this.userIp;
    }

    public DriveRequest<T> setAlt(String str) {
        this.alt = str;
        return this;
    }

    public DriveRequest<T> setFields(String str) {
        this.fields = str;
        return this;
    }

    public DriveRequest<T> setKey(String str) {
        this.key = str;
        return this;
    }

    public DriveRequest<T> setOauthToken(String str) {
        this.oauthToken = str;
        return this;
    }

    public DriveRequest<T> setPrettyPrint(Boolean bool) {
        this.prettyPrint = bool;
        return this;
    }

    public DriveRequest<T> setQuotaUser(String str) {
        this.quotaUser = str;
        return this;
    }

    public DriveRequest<T> setUserIp(String str) {
        this.userIp = str;
        return this;
    }

    @Override // e.g.b.a.b.f.e.b, e.g.b.a.b.f.b
    public final Drive getAbstractGoogleClient() {
        return (Drive) super.getAbstractGoogleClient();
    }

    @Override // e.g.b.a.b.f.e.b, e.g.b.a.b.f.b
    public DriveRequest<T> setDisableGZipContent(boolean z) {
        return (DriveRequest) super.setDisableGZipContent(z);
    }

    @Override // e.g.b.a.b.f.e.b, e.g.b.a.b.f.b
    public DriveRequest<T> setRequestHeaders(l lVar) {
        return (DriveRequest) super.setRequestHeaders(lVar);
    }

    @Override // e.g.b.a.b.f.e.b, e.g.b.a.b.f.b, e.g.b.a.d.n
    public DriveRequest<T> set(String str, Object obj) {
        return (DriveRequest) super.set(str, obj);
    }
}