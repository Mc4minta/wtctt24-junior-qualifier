package okhttp3.internal.ws;

import j.f;
import j.g;
import j.i;
import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: WebSocketWriter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\"\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u00103\u001a\u00020\u0014\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b4\u00105J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\bJ\u001d\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0016R\u0016\u0010\"\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0016R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010%R\u0016\u00103\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010\u0016¨\u00066"}, d2 = {"Lokhttp3/internal/ws/WebSocketWriter;", "Ljava/io/Closeable;", "", "opcode", "Lj/i;", "payload", "Lkotlin/x;", "writeControlFrame", "(ILj/i;)V", "writePing", "(Lj/i;)V", "writePong", "code", "reason", "writeClose", "formatOpcode", "data", "writeMessageFrame", "close", "()V", "", "perMessageDeflate", "Z", "Ljava/util/Random;", "random", "Ljava/util/Random;", "getRandom", "()Ljava/util/Random;", "Lj/g;", "sink", "Lj/g;", "getSink", "()Lj/g;", "writerClosed", "isClient", "Lj/f;", "sinkBuffer", "Lj/f;", "Lj/f$a;", "maskCursor", "Lj/f$a;", "", "minimumDeflateSize", "J", "Lokhttp3/internal/ws/MessageDeflater;", "messageDeflater", "Lokhttp3/internal/ws/MessageDeflater;", "", "maskKey", "[B", "messageBuffer", "noContextTakeover", "<init>", "(ZLj/g;Ljava/util/Random;ZZJ)V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class WebSocketWriter implements Closeable {
    private final boolean isClient;
    private final f.a maskCursor;
    private final byte[] maskKey;
    private final f messageBuffer;
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;
    private final Random random;
    private final g sink;
    private final f sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean z, g sink, Random random, boolean z2, boolean z3, long j2) {
        m.h(sink, "sink");
        m.h(random, "random");
        this.isClient = z;
        this.sink = sink;
        this.random = random;
        this.perMessageDeflate = z2;
        this.noContextTakeover = z3;
        this.minimumDeflateSize = j2;
        this.messageBuffer = new f();
        this.sinkBuffer = sink.getBuffer();
        this.maskKey = z ? new byte[4] : null;
        this.maskCursor = z ? new f.a() : null;
    }

    private final void writeControlFrame(int i2, i iVar) throws IOException {
        if (!this.writerClosed) {
            int Q = iVar.Q();
            if (((long) Q) <= 125) {
                this.sinkBuffer.R(i2 | 128);
                if (this.isClient) {
                    this.sinkBuffer.R(Q | 128);
                    Random random = this.random;
                    byte[] bArr = this.maskKey;
                    if (bArr == null) {
                        m.q();
                    }
                    random.nextBytes(bArr);
                    this.sinkBuffer.write(this.maskKey);
                    if (Q > 0) {
                        long O0 = this.sinkBuffer.O0();
                        this.sinkBuffer.K0(iVar);
                        f fVar = this.sinkBuffer;
                        f.a aVar = this.maskCursor;
                        if (aVar == null) {
                            m.q();
                        }
                        fVar.r0(aVar);
                        this.maskCursor.d(O0);
                        WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                        this.maskCursor.close();
                    }
                } else {
                    this.sinkBuffer.R(Q);
                    this.sinkBuffer.K0(iVar);
                }
                this.sink.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        }
        throw new IOException("closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MessageDeflater messageDeflater = this.messageDeflater;
        if (messageDeflater != null) {
            messageDeflater.close();
        }
    }

    public final Random getRandom() {
        return this.random;
    }

    public final g getSink() {
        return this.sink;
    }

    public final void writeClose(int i2, i iVar) throws IOException {
        i iVar2 = i.a;
        if (i2 != 0 || iVar != null) {
            if (i2 != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(i2);
            }
            f fVar = new f();
            fVar.x(i2);
            if (iVar != null) {
                fVar.K0(iVar);
            }
            iVar2 = fVar.v0();
        }
        try {
            writeControlFrame(8, iVar2);
        } finally {
            this.writerClosed = true;
        }
    }

    public final void writeMessageFrame(int i2, i data) throws IOException {
        m.h(data, "data");
        if (!this.writerClosed) {
            this.messageBuffer.K0(data);
            int i3 = i2 | 128;
            if (this.perMessageDeflate && data.Q() >= this.minimumDeflateSize) {
                MessageDeflater messageDeflater = this.messageDeflater;
                if (messageDeflater == null) {
                    messageDeflater = new MessageDeflater(this.noContextTakeover);
                    this.messageDeflater = messageDeflater;
                }
                messageDeflater.deflate(this.messageBuffer);
                i3 |= 64;
            }
            long O0 = this.messageBuffer.O0();
            this.sinkBuffer.R(i3);
            int i4 = this.isClient ? 128 : 0;
            if (O0 <= 125) {
                this.sinkBuffer.R(((int) O0) | i4);
            } else if (O0 <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                this.sinkBuffer.R(i4 | 126);
                this.sinkBuffer.x((int) O0);
            } else {
                this.sinkBuffer.R(i4 | 127);
                this.sinkBuffer.n1(O0);
            }
            if (this.isClient) {
                Random random = this.random;
                byte[] bArr = this.maskKey;
                if (bArr == null) {
                    m.q();
                }
                random.nextBytes(bArr);
                this.sinkBuffer.write(this.maskKey);
                if (O0 > 0) {
                    f fVar = this.messageBuffer;
                    f.a aVar = this.maskCursor;
                    if (aVar == null) {
                        m.q();
                    }
                    fVar.r0(aVar);
                    this.maskCursor.d(0L);
                    WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            this.sinkBuffer.write(this.messageBuffer, O0);
            this.sink.w();
            return;
        }
        throw new IOException("closed");
    }

    public final void writePing(i payload) throws IOException {
        m.h(payload, "payload");
        writeControlFrame(9, payload);
    }

    public final void writePong(i payload) throws IOException {
        m.h(payload, "payload");
        writeControlFrame(10, payload);
    }
}