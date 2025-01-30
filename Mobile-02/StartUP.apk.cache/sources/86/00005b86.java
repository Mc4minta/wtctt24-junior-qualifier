package okhttp3.internal.ws;

import j.c0;
import j.f;
import j.i;
import j.j;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.io.a;
import kotlin.jvm.internal.m;

/* compiled from: MessageDeflater.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/ws/MessageDeflater;", "Ljava/io/Closeable;", "Lj/f;", "Lj/i;", "suffix", "", "endsWith", "(Lj/f;Lj/i;)Z", "buffer", "Lkotlin/x;", "deflate", "(Lj/f;)V", "close", "()V", "deflatedBytes", "Lj/f;", "noContextTakeover", "Z", "Ljava/util/zip/Deflater;", "deflater", "Ljava/util/zip/Deflater;", "Lj/j;", "deflaterSink", "Lj/j;", "<init>", "(Z)V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class MessageDeflater implements Closeable {
    private final f deflatedBytes;
    private final Deflater deflater;
    private final j deflaterSink;
    private final boolean noContextTakeover;

    public MessageDeflater(boolean z) {
        this.noContextTakeover = z;
        f fVar = new f();
        this.deflatedBytes = fVar;
        Deflater deflater = new Deflater(-1, true);
        this.deflater = deflater;
        this.deflaterSink = new j((c0) fVar, deflater);
    }

    private final boolean endsWith(f fVar, i iVar) {
        return fVar.j0(fVar.O0() - iVar.Q(), iVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.deflaterSink.close();
    }

    public final void deflate(f buffer) throws IOException {
        i iVar;
        m.h(buffer, "buffer");
        if (this.deflatedBytes.O0() == 0) {
            if (this.noContextTakeover) {
                this.deflater.reset();
            }
            this.deflaterSink.write(buffer, buffer.O0());
            this.deflaterSink.flush();
            f fVar = this.deflatedBytes;
            iVar = MessageDeflaterKt.EMPTY_DEFLATE_BLOCK;
            if (endsWith(fVar, iVar)) {
                long O0 = this.deflatedBytes.O0() - 4;
                f.a x0 = f.x0(this.deflatedBytes, null, 1, null);
                try {
                    x0.c(O0);
                    a.a(x0, null);
                } finally {
                }
            } else {
                this.deflatedBytes.R(0);
            }
            f fVar2 = this.deflatedBytes;
            buffer.write(fVar2, fVar2.O0());
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}