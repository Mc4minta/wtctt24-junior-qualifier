package okhttp3.internal.cache2;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import j.e0;
import j.f;
import j.f0;
import j.i;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.x;
import okhttp3.internal.Util;

/* compiled from: Relay.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 E2\u00020\u0001:\u0002EFB5\b\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010%\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u00109\u001a\u00020\u0004¢\u0006\u0004\bC\u0010DJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010\u000bR\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0013\u00101\u001a\u00020*8F@\u0006¢\u0006\u0006\u001a\u0004\b1\u0010.R\u0019\u00103\u001a\u0002028\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0019\u00107\u001a\u0002028\u0006@\u0006¢\u0006\f\n\u0004\b7\u00104\u001a\u0004\b8\u00106R\u0019\u00109\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010&\u001a\u0004\b:\u0010(R\"\u0010<\u001a\u00020;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010B¨\u0006G"}, d2 = {"Lokhttp3/internal/cache2/Relay;", "", "Lj/i;", "prefix", "", "upstreamSize", "metadataSize", "Lkotlin/x;", "writeHeader", "(Lj/i;JJ)V", "writeMetadata", "(J)V", ApiConstants.COMMIT, SendConfirmationArgs.metadataKey, "()Lj/i;", "Lj/e0;", "newSource", "()Lj/e0;", "upstream", "Lj/e0;", "getUpstream", "setUpstream", "(Lj/e0;)V", "Ljava/io/RandomAccessFile;", "file", "Ljava/io/RandomAccessFile;", "getFile", "()Ljava/io/RandomAccessFile;", "setFile", "(Ljava/io/RandomAccessFile;)V", "Ljava/lang/Thread;", "upstreamReader", "Ljava/lang/Thread;", "getUpstreamReader", "()Ljava/lang/Thread;", "setUpstreamReader", "(Ljava/lang/Thread;)V", "upstreamPos", "J", "getUpstreamPos", "()J", "setUpstreamPos", "", ApiConstants.COMPLETE, "Z", "getComplete", "()Z", "setComplete", "(Z)V", "isClosed", "Lj/f;", "upstreamBuffer", "Lj/f;", "getUpstreamBuffer", "()Lj/f;", "buffer", "getBuffer", "bufferMaxSize", "getBufferMaxSize", "", "sourceCount", "I", "getSourceCount", "()I", "setSourceCount", "(I)V", "Lj/i;", "<init>", "(Ljava/io/RandomAccessFile;Lj/e0;JLj/i;J)V", "Companion", "RelaySource", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class Relay {
    public static final Companion Companion = new Companion(null);
    private static final long FILE_HEADER_SIZE = 32;
    public static final i PREFIX_CLEAN;
    public static final i PREFIX_DIRTY;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    private final f buffer;
    private final long bufferMaxSize;
    private boolean complete;
    private RandomAccessFile file;
    private final i metadata;
    private int sourceCount;
    private e0 upstream;
    private final f upstreamBuffer;
    private long upstreamPos;
    private Thread upstreamReader;

    /* compiled from: Relay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/cache2/Relay$Companion;", "", "Ljava/io/File;", "file", "Lj/e0;", "upstream", "Lj/i;", SendConfirmationArgs.metadataKey, "", "bufferMaxSize", "Lokhttp3/internal/cache2/Relay;", "edit", "(Ljava/io/File;Lj/e0;Lj/i;J)Lokhttp3/internal/cache2/Relay;", "read", "(Ljava/io/File;)Lokhttp3/internal/cache2/Relay;", "FILE_HEADER_SIZE", "J", "PREFIX_CLEAN", "Lj/i;", "PREFIX_DIRTY", "", "SOURCE_FILE", "I", "SOURCE_UPSTREAM", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public final Relay edit(File file, e0 upstream, i metadata, long j2) throws IOException {
            m.h(file, "file");
            m.h(upstream, "upstream");
            m.h(metadata, "metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, upstream, 0L, metadata, j2, null);
            randomAccessFile.setLength(0L);
            relay.writeHeader(Relay.PREFIX_DIRTY, -1L, -1L);
            return relay;
        }

        public final Relay read(File file) throws IOException {
            m.h(file, "file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            m.d(channel, "randomAccessFile.channel");
            FileOperator fileOperator = new FileOperator(channel);
            f fVar = new f();
            fileOperator.read(0L, fVar, Relay.FILE_HEADER_SIZE);
            i iVar = Relay.PREFIX_CLEAN;
            if (!(!m.c(fVar.s(iVar.Q()), iVar))) {
                long H = fVar.H();
                long H2 = fVar.H();
                f fVar2 = new f();
                fileOperator.read(H + Relay.FILE_HEADER_SIZE, fVar2, H2);
                return new Relay(randomAccessFile, null, H, fVar2.v0(), 0L, null);
            }
            throw new IOException("unreadable cache file");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Relay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/cache2/Relay$RelaySource;", "Lj/e0;", "Lj/f;", "sink", "", "byteCount", "read", "(Lj/f;J)J", "Lj/f0;", "timeout", "()Lj/f0;", "Lkotlin/x;", "close", "()V", "Lokhttp3/internal/cache2/FileOperator;", "fileOperator", "Lokhttp3/internal/cache2/FileOperator;", "Lj/f0;", "sourcePos", "J", "<init>", "(Lokhttp3/internal/cache2/Relay;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public final class RelaySource implements e0 {
        private FileOperator fileOperator;
        private long sourcePos;
        private final f0 timeout = new f0();

        public RelaySource() {
            RandomAccessFile file = Relay.this.getFile();
            if (file == null) {
                m.q();
            }
            FileChannel channel = file.getChannel();
            m.d(channel, "file!!.channel");
            this.fileOperator = new FileOperator(channel);
        }

        @Override // j.e0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (Relay.this) {
                Relay relay = Relay.this;
                relay.setSourceCount(relay.getSourceCount() - 1);
                if (Relay.this.getSourceCount() == 0) {
                    RandomAccessFile file = Relay.this.getFile();
                    Relay.this.setFile(null);
                    randomAccessFile = file;
                }
                x xVar = x.a;
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x008b, code lost:
            if (r4 != true) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x008d, code lost:
            r8 = java.lang.Math.min(r21, r19.this$0.getUpstreamPos() - r19.sourcePos);
            r2 = r19.fileOperator;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x009c, code lost:
            if (r2 != null) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x009e, code lost:
            kotlin.jvm.internal.m.q();
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00a1, code lost:
            r2.read(r19.sourcePos + okhttp3.internal.cache2.Relay.FILE_HEADER_SIZE, r20, r8);
            r19.sourcePos += r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00af, code lost:
            return r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00b1, code lost:
            r0 = r19.this$0.getUpstream();
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00b7, code lost:
            if (r0 != null) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00b9, code lost:
            kotlin.jvm.internal.m.q();
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00bc, code lost:
            r14 = r0.read(r19.this$0.getUpstreamBuffer(), r19.this$0.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00ce, code lost:
            if (r14 != (-1)) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00d0, code lost:
            r0 = r19.this$0;
            r0.commit(r0.getUpstreamPos());
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00d9, code lost:
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00db, code lost:
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00dc, code lost:
            r19.this$0.setUpstreamReader(null);
            r0 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00e3, code lost:
            if (r0 == null) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00e5, code lost:
            r0.notifyAll();
            r0 = kotlin.x.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00ea, code lost:
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00eb, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00f3, code lost:
            throw new kotlin.TypeCastException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00f7, code lost:
            r9 = java.lang.Math.min(r14, r21);
            r19.this$0.getUpstreamBuffer().f(r20, 0, r9);
            r19.sourcePos += r9;
            r13 = r19.fileOperator;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0111, code lost:
            if (r13 != null) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0113, code lost:
            kotlin.jvm.internal.m.q();
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0116, code lost:
            r13.write(r19.this$0.getUpstreamPos() + okhttp3.internal.cache2.Relay.FILE_HEADER_SIZE, r19.this$0.getUpstreamBuffer().clone(), r14);
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0130, code lost:
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0131, code lost:
            r19.this$0.getBuffer().write(r19.this$0.getUpstreamBuffer(), r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0152, code lost:
            if (r19.this$0.getBuffer().O0() <= r19.this$0.getBufferMaxSize()) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0154, code lost:
            r19.this$0.getBuffer().skip(r19.this$0.getBuffer().O0() - r19.this$0.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x016e, code lost:
            r0 = r19.this$0;
            r0.setUpstreamPos(r0.getUpstreamPos() + r14);
            r0 = kotlin.x.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x017a, code lost:
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x017b, code lost:
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x017d, code lost:
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x017e, code lost:
            r19.this$0.setUpstreamReader(null);
            r0 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0185, code lost:
            if (r0 == null) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x0187, code lost:
            r0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x018a, code lost:
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x018b, code lost:
            return r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0193, code lost:
            throw new kotlin.TypeCastException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x019a, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x019d, code lost:
            monitor-enter(r19.this$0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x019e, code lost:
            r19.this$0.setUpstreamReader(null);
            r3 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x01a5, code lost:
            if (r3 == null) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x01ae, code lost:
            throw new kotlin.TypeCastException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x01af, code lost:
            r3.notifyAll();
            r3 = kotlin.x.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x01b5, code lost:
            throw r0;
         */
        @Override // j.e0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long read(j.f r20, long r21) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 456
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(j.f, long):long");
        }

        @Override // j.e0
        public f0 timeout() {
            return this.timeout;
        }
    }

    static {
        i.a aVar = i.f17151b;
        PREFIX_CLEAN = aVar.d("OkHttp cache v1\n");
        PREFIX_DIRTY = aVar.d("OkHttp DIRTY :(\n");
    }

    private Relay(RandomAccessFile randomAccessFile, e0 e0Var, long j2, i iVar, long j3) {
        this.file = randomAccessFile;
        this.upstream = e0Var;
        this.upstreamPos = j2;
        this.metadata = iVar;
        this.bufferMaxSize = j3;
        this.upstreamBuffer = new f();
        this.complete = this.upstream == null;
        this.buffer = new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeHeader(i iVar, long j2, long j3) throws IOException {
        f fVar = new f();
        fVar.K0(iVar);
        fVar.n1(j2);
        fVar.n1(j3);
        if (fVar.O0() == FILE_HEADER_SIZE) {
            RandomAccessFile randomAccessFile = this.file;
            if (randomAccessFile == null) {
                m.q();
            }
            FileChannel channel = randomAccessFile.getChannel();
            m.d(channel, "file!!.channel");
            new FileOperator(channel).write(0L, fVar, FILE_HEADER_SIZE);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final void writeMetadata(long j2) throws IOException {
        f fVar = new f();
        fVar.K0(this.metadata);
        RandomAccessFile randomAccessFile = this.file;
        if (randomAccessFile == null) {
            m.q();
        }
        FileChannel channel = randomAccessFile.getChannel();
        m.d(channel, "file!!.channel");
        new FileOperator(channel).write(FILE_HEADER_SIZE + j2, fVar, this.metadata.Q());
    }

    public final void commit(long j2) throws IOException {
        writeMetadata(j2);
        RandomAccessFile randomAccessFile = this.file;
        if (randomAccessFile == null) {
            m.q();
        }
        randomAccessFile.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j2, this.metadata.Q());
        RandomAccessFile randomAccessFile2 = this.file;
        if (randomAccessFile2 == null) {
            m.q();
        }
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
            x xVar = x.a;
        }
        e0 e0Var = this.upstream;
        if (e0Var != null) {
            Util.closeQuietly(e0Var);
        }
        this.upstream = null;
    }

    public final f getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    public final e0 getUpstream() {
        return this.upstream;
    }

    public final f getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        return this.file == null;
    }

    public final i metadata() {
        return this.metadata;
    }

    public final e0 newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    public final void setComplete(boolean z) {
        this.complete = z;
    }

    public final void setFile(RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i2) {
        this.sourceCount = i2;
    }

    public final void setUpstream(e0 e0Var) {
        this.upstream = e0Var;
    }

    public final void setUpstreamPos(long j2) {
        this.upstreamPos = j2;
    }

    public final void setUpstreamReader(Thread thread) {
        this.upstreamReader = thread;
    }

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, e0 e0Var, long j2, i iVar, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(randomAccessFile, e0Var, j2, iVar, j3);
    }
}