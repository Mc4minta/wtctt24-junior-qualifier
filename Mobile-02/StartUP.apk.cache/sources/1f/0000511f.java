package j;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* compiled from: BufferedSource.kt */
/* loaded from: classes3.dex */
public interface h extends e0, ReadableByteChannel {
    int C() throws IOException;

    String C0() throws IOException;

    int D0() throws IOException;

    byte[] E0(long j2) throws IOException;

    String G0() throws IOException;

    long H() throws IOException;

    byte[] J() throws IOException;

    long M(i iVar) throws IOException;

    long P0() throws IOException;

    boolean Q() throws IOException;

    long T0(c0 c0Var) throws IOException;

    void U(f fVar, long j2) throws IOException;

    short U0() throws IOException;

    long W(i iVar) throws IOException;

    long Y() throws IOException;

    String Z(long j2) throws IOException;

    void Z0(long j2) throws IOException;

    long e1() throws IOException;

    InputStream g1();

    f getBuffer();

    int h1(t tVar) throws IOException;

    f i();

    boolean j0(long j2, i iVar) throws IOException;

    String l0(Charset charset) throws IOException;

    byte m0() throws IOException;

    String p(long j2) throws IOException;

    h peek();

    void readFully(byte[] bArr) throws IOException;

    boolean request(long j2) throws IOException;

    i s(long j2) throws IOException;

    void skip(long j2) throws IOException;

    i v0() throws IOException;
}