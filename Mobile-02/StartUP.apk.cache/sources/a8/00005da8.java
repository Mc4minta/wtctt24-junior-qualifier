package org.apache.http.impl.conn;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.logging.a;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.message.TokenParser;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes3.dex */
public class Wire {
    private final String id;
    private final a log;

    public Wire(a aVar, String str) {
        this.log = aVar;
        this.id = str;
    }

    private void wire(String str, InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                break;
            } else if (read == 13) {
                sb.append("[\\r]");
            } else if (read == 10) {
                sb.append("[\\n]\"");
                sb.insert(0, "\"");
                sb.insert(0, str);
                a aVar = this.log;
                aVar.a(this.id + " " + sb.toString());
                sb.setLength(0);
            } else if (read >= 32 && read <= 127) {
                sb.append((char) read);
            } else {
                sb.append("[0x");
                sb.append(Integer.toHexString(read));
                sb.append("]");
            }
        }
        if (sb.length() > 0) {
            sb.append(TokenParser.DQUOTE);
            sb.insert(0, TokenParser.DQUOTE);
            sb.insert(0, str);
            a aVar2 = this.log;
            aVar2.a(this.id + " " + sb.toString());
        }
    }

    public boolean enabled() {
        return this.log.d();
    }

    public void input(InputStream inputStream) throws IOException {
        Args.notNull(inputStream, "Input");
        wire("<< ", inputStream);
    }

    public void output(InputStream inputStream) throws IOException {
        Args.notNull(inputStream, "Output");
        wire(">> ", inputStream);
    }

    public void input(byte[] bArr, int i2, int i3) throws IOException {
        Args.notNull(bArr, "Input");
        wire("<< ", new ByteArrayInputStream(bArr, i2, i3));
    }

    public void output(byte[] bArr, int i2, int i3) throws IOException {
        Args.notNull(bArr, "Output");
        wire(">> ", new ByteArrayInputStream(bArr, i2, i3));
    }

    public Wire(a aVar) {
        this(aVar, "");
    }

    public void input(byte[] bArr) throws IOException {
        Args.notNull(bArr, "Input");
        wire("<< ", new ByteArrayInputStream(bArr));
    }

    public void output(byte[] bArr) throws IOException {
        Args.notNull(bArr, "Output");
        wire(">> ", new ByteArrayInputStream(bArr));
    }

    public void input(int i2) throws IOException {
        input(new byte[]{(byte) i2});
    }

    public void output(int i2) throws IOException {
        output(new byte[]{(byte) i2});
    }

    public void input(String str) throws IOException {
        Args.notNull(str, "Input");
        input(str.getBytes());
    }

    public void output(String str) throws IOException {
        Args.notNull(str, "Output");
        output(str.getBytes());
    }
}