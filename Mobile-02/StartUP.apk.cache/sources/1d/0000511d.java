package j;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

/* compiled from: BufferedSink.kt */
/* loaded from: classes3.dex */
public interface g extends c0, WritableByteChannel {
    g D(int i2) throws IOException;

    g F(long j2) throws IOException;

    g K0(i iVar) throws IOException;

    g P(int i2) throws IOException;

    g R(int i2) throws IOException;

    g X() throws IOException;

    g a1(long j2) throws IOException;

    OutputStream c1();

    @Override // j.c0, java.io.Flushable
    void flush() throws IOException;

    f getBuffer();

    g h0(String str) throws IOException;

    f i();

    g q0(String str, int i2, int i3) throws IOException;

    long t0(e0 e0Var) throws IOException;

    g u0(long j2) throws IOException;

    g w() throws IOException;

    g write(byte[] bArr) throws IOException;

    g write(byte[] bArr, int i2, int i3) throws IOException;

    g x(int i2) throws IOException;
}