package okhttp3.internal.cache2;

import com.appsflyer.internal.referrer.Payload;
import j.f;
import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: FileOperator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\tR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/cache2/FileOperator;", "", "", "pos", "Lj/f;", Payload.SOURCE, "byteCount", "Lkotlin/x;", "write", "(JLj/f;J)V", "sink", "read", "Ljava/nio/channels/FileChannel;", "fileChannel", "Ljava/nio/channels/FileChannel;", "<init>", "(Ljava/nio/channels/FileChannel;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel) {
        m.h(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    public final void read(long j2, f sink, long j3) {
        m.h(sink, "sink");
        if (j3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j3 > 0) {
            long transferTo = this.fileChannel.transferTo(j2, j3, sink);
            j2 += transferTo;
            j3 -= transferTo;
        }
    }

    public final void write(long j2, f source, long j3) throws IOException {
        m.h(source, "source");
        if (j3 < 0 || j3 > source.O0()) {
            throw new IndexOutOfBoundsException();
        }
        while (j3 > 0) {
            long transferFrom = this.fileChannel.transferFrom(source, j2, j3);
            j2 += transferFrom;
            j3 -= transferFrom;
        }
    }
}