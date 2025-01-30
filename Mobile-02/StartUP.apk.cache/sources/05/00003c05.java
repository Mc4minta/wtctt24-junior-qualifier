package com.google.gson;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* compiled from: TypeAdapter.java */
/* loaded from: classes2.dex */
public abstract class s<T> {

    /* compiled from: TypeAdapter.java */
    /* loaded from: classes2.dex */
    class a extends s<T> {
        a() {
        }

        @Override // com.google.gson.s
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            return (T) s.this.read(aVar);
        }

        @Override // com.google.gson.s
        public void write(com.google.gson.stream.c cVar, T t) throws IOException {
            if (t == null) {
                cVar.A();
            } else {
                s.this.write(cVar, t);
            }
        }
    }

    public final T fromJson(Reader reader) throws IOException {
        return read(new com.google.gson.stream.a(reader));
    }

    public final T fromJsonTree(l lVar) {
        try {
            return read(new com.google.gson.u.n.e(lVar));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public final s<T> nullSafe() {
        return new a();
    }

    public abstract T read(com.google.gson.stream.a aVar) throws IOException;

    public final void toJson(Writer writer, T t) throws IOException {
        write(new com.google.gson.stream.c(writer), t);
    }

    public final l toJsonTree(T t) {
        try {
            com.google.gson.u.n.f fVar = new com.google.gson.u.n.f();
            write(fVar, t);
            return fVar.y0();
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public abstract void write(com.google.gson.stream.c cVar, T t) throws IOException;

    public final T fromJson(String str) throws IOException {
        return fromJson(new StringReader(str));
    }

    public final String toJson(T t) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}