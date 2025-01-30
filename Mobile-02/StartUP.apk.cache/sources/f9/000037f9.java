package com.google.api.client.googleapis.json;

import e.g.b.a.c.b;
import e.g.b.a.d.q;

/* loaded from: classes2.dex */
public class GoogleJsonErrorContainer extends b {
    @q
    private GoogleJsonError error;

    public final GoogleJsonError getError() {
        return this.error;
    }

    public final void setError(GoogleJsonError googleJsonError) {
        this.error = googleJsonError;
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public GoogleJsonErrorContainer set(String str, Object obj) {
        return (GoogleJsonErrorContainer) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public GoogleJsonErrorContainer clone() {
        return (GoogleJsonErrorContainer) super.clone();
    }
}