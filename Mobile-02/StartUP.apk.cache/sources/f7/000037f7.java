package com.google.api.client.googleapis.json;

import com.google.api.client.http.r;
import e.g.b.a.c.b;
import e.g.b.a.c.c;
import e.g.b.a.c.e;
import e.g.b.a.d.j;
import e.g.b.a.d.q;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class GoogleJsonError extends b {
    @q
    private int code;
    @q
    private List<ErrorInfo> errors;
    @q
    private String message;

    static {
        j.i(ErrorInfo.class);
    }

    public static GoogleJsonError parse(c cVar, r rVar) throws IOException {
        return (GoogleJsonError) new e.a(cVar).b(Collections.singleton("error")).a().a(rVar.c(), rVar.d(), GoogleJsonError.class);
    }

    public final int getCode() {
        return this.code;
    }

    public final List<ErrorInfo> getErrors() {
        return this.errors;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setCode(int i2) {
        this.code = i2;
    }

    public final void setErrors(List<ErrorInfo> list) {
        this.errors = list;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    /* loaded from: classes2.dex */
    public static class ErrorInfo extends b {
        @q
        private String domain;
        @q
        private String location;
        @q
        private String locationType;
        @q
        private String message;
        @q
        private String reason;

        public final String getDomain() {
            return this.domain;
        }

        public final String getLocation() {
            return this.location;
        }

        public final String getLocationType() {
            return this.locationType;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getReason() {
            return this.reason;
        }

        public final void setDomain(String str) {
            this.domain = str;
        }

        public final void setLocation(String str) {
            this.location = str;
        }

        public final void setLocationType(String str) {
            this.locationType = str;
        }

        public final void setMessage(String str) {
            this.message = str;
        }

        public final void setReason(String str) {
            this.reason = str;
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n
        public ErrorInfo set(String str, Object obj) {
            return (ErrorInfo) super.set(str, obj);
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
        public ErrorInfo clone() {
            return (ErrorInfo) super.clone();
        }
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public GoogleJsonError set(String str, Object obj) {
        return (GoogleJsonError) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public GoogleJsonError clone() {
        return (GoogleJsonError) super.clone();
    }
}