package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;

/* compiled from: JsonElement.java */
/* loaded from: classes2.dex */
public abstract class l {
    public i h() {
        if (m()) {
            return (i) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public n i() {
        if (p()) {
            return (n) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public o k() {
        if (q()) {
            return (o) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public String l() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean m() {
        return this instanceof i;
    }

    public boolean o() {
        return this instanceof m;
    }

    public boolean p() {
        return this instanceof n;
    }

    public boolean q() {
        return this instanceof o;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            com.google.gson.stream.c cVar = new com.google.gson.stream.c(stringWriter);
            cVar.d0(true);
            com.google.gson.u.l.b(this, cVar);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}