package androidx.core.util;

import android.util.Log;
import java.io.Writer;

/* compiled from: LogWriter.java */
@Deprecated
/* loaded from: classes.dex */
public class c extends Writer {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private StringBuilder f1540b = new StringBuilder(128);

    public c(String str) {
        this.a = str;
    }

    private void a() {
        if (this.f1540b.length() > 0) {
            Log.d(this.a, this.f1540b.toString());
            StringBuilder sb = this.f1540b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            char c2 = cArr[i2 + i4];
            if (c2 == '\n') {
                a();
            } else {
                this.f1540b.append(c2);
            }
        }
    }
}