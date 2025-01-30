package com.google.gson.u.n;

import com.google.gson.o;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonTreeWriter.java */
/* loaded from: classes2.dex */
public final class f extends com.google.gson.stream.c {
    private static final Writer m = new a();
    private static final o n = new o("closed");
    private final List<com.google.gson.l> p;
    private String q;
    private com.google.gson.l t;

    /* compiled from: JsonTreeWriter.java */
    /* loaded from: classes2.dex */
    static class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) {
            throw new AssertionError();
        }
    }

    public f() {
        super(m);
        this.p = new ArrayList();
        this.t = com.google.gson.m.a;
    }

    private void I0(com.google.gson.l lVar) {
        if (this.q != null) {
            if (!lVar.o() || j()) {
                ((com.google.gson.n) z0()).r(this.q, lVar);
            }
            this.q = null;
        } else if (this.p.isEmpty()) {
            this.t = lVar;
        } else {
            com.google.gson.l z0 = z0();
            if (z0 instanceof com.google.gson.i) {
                ((com.google.gson.i) z0).r(lVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    private com.google.gson.l z0() {
        List<com.google.gson.l> list = this.p;
        return list.get(list.size() - 1);
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c A() throws IOException {
        I0(com.google.gson.m.a);
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c c() throws IOException {
        com.google.gson.i iVar = new com.google.gson.i();
        I0(iVar);
        this.p.add(iVar);
        return this;
    }

    @Override // com.google.gson.stream.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.p.isEmpty()) {
            this.p.add(n);
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c d() throws IOException {
        com.google.gson.n nVar = new com.google.gson.n();
        I0(nVar);
        this.p.add(nVar);
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c f() throws IOException {
        if (!this.p.isEmpty() && this.q == null) {
            if (z0() instanceof com.google.gson.i) {
                List<com.google.gson.l> list = this.p;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.c, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c g() throws IOException {
        if (!this.p.isEmpty() && this.q == null) {
            if (z0() instanceof com.google.gson.n) {
                List<com.google.gson.l> list = this.p;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c k0(double d2) throws IOException {
        if (!n() && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d2);
        }
        I0(new o(Double.valueOf(d2)));
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c n0(long j2) throws IOException {
        I0(new o(Long.valueOf(j2)));
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c o0(Boolean bool) throws IOException {
        if (bool == null) {
            return A();
        }
        I0(new o(bool));
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c r0(Number number) throws IOException {
        if (number == null) {
            return A();
        }
        if (!n()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        I0(new o(number));
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c s0(String str) throws IOException {
        if (str == null) {
            return A();
        }
        I0(new o(str));
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c v(String str) throws IOException {
        if (!this.p.isEmpty() && this.q == null) {
            if (z0() instanceof com.google.gson.n) {
                this.q = str;
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c w0(boolean z) throws IOException {
        I0(new o(Boolean.valueOf(z)));
        return this;
    }

    public com.google.gson.l y0() {
        if (this.p.isEmpty()) {
            return this.t;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.p);
    }
}