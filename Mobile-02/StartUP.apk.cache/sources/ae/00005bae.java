package org.apache.commons.io.b;

import java.io.Serializable;
import java.io.Writer;

/* compiled from: StringBuilderWriter.java */
/* loaded from: classes3.dex */
public class b extends Writer implements Serializable {
    private final StringBuilder a;

    public b(int i2) {
        this.a = new StringBuilder(i2);
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public String toString() {
        return this.a.toString();
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str != null) {
            this.a.append(str);
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) {
        if (cArr != null) {
            this.a.append(cArr, i2, i3);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c2) {
        this.a.append(c2);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        this.a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i2, int i3) {
        this.a.append(charSequence, i2, i3);
        return this;
    }
}