package okhttp3.internal.cache;

import com.coinbase.ApiConstants;
import j.c0;
import j.e0;
import j.g;
import j.h;
import j.q;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.io.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.l0.k;
import kotlin.l0.y;
import kotlin.x;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import org.apache.http.message.TokenParser;

/* compiled from: DiskLruCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b*\u0001K\u0018\u0000 k2\u00020\u00012\u00020\u0002:\u0004klmnB9\b\u0000\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010Z\u001a\u00020Y\u0012\u0006\u0010f\u001a\u000208\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010U\u001a\u00020\u001a\u0012\u0006\u0010h\u001a\u00020g¢\u0006\u0004\bi\u0010jJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\fJ\r\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0015\u0010\u0005J\u001e\u0010\u0018\u001a\b\u0018\u00010\u0017R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001d\u001a\b\u0018\u00010\u001cR\u00020\u00002\u0006\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u001a¢\u0006\u0004\b\u001f\u0010 J#\u0010%\u001a\u00020\u00032\n\u0010!\u001a\u00060\u001cR\u00020\u00002\u0006\u0010\"\u001a\u00020\u000eH\u0000¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b&\u0010'J\u001b\u0010,\u001a\u00020\u000e2\n\u0010)\u001a\u00060(R\u00020\u0000H\u0000¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020\u0003H\u0016¢\u0006\u0004\b-\u0010\u0005J\r\u0010.\u001a\u00020\u000e¢\u0006\u0004\b.\u0010\u0010J\u000f\u0010/\u001a\u00020\u0003H\u0016¢\u0006\u0004\b/\u0010\u0005J\r\u00100\u001a\u00020\u0003¢\u0006\u0004\b0\u0010\u0005J\r\u00101\u001a\u00020\u0003¢\u0006\u0004\b1\u0010\u0005J\r\u00102\u001a\u00020\u0003¢\u0006\u0004\b2\u0010\u0005J\u0017\u00104\u001a\f\u0012\b\u0012\u00060\u0017R\u00020\u000003¢\u0006\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001c\u00109\u001a\u0002088\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00107R\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010AR,\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u00060(R\u00020\u00000C8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0018\u0010H\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010J\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u00107R\u0016\u0010L\u001a\u00020K8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u001c\u0010O\u001a\u00020N8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u00107R*\u0010U\u001a\u00020\u001a2\u0006\u0010T\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010A\u001a\u0004\bV\u0010 \"\u0004\bW\u0010XR\u0019\u0010Z\u001a\u00020Y8\u0006@\u0006¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u0016\u0010^\u001a\u00020Y8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010[R\u0016\u0010_\u001a\u00020Y8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010[R\u0016\u0010`\u001a\u00020Y8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010[R\u0016\u0010a\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010:R\"\u0010b\u001a\u00020\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bb\u00107\u001a\u0004\bc\u0010\u0010\"\u0004\bd\u0010eR\u0016\u0010f\u001a\u0002088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010:¨\u0006o"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "Lkotlin/x;", "readJournal", "()V", "Lj/g;", "newJournalWriter", "()Lj/g;", "", "line", "readJournalLine", "(Ljava/lang/String;)V", "processJournal", "", "journalRebuildRequired", "()Z", "checkNotClosed", "key", "validateKey", "initialize", "rebuildJournal$okhttp", "rebuildJournal", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "get", "(Ljava/lang/String;)Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "", "expectedSequenceNumber", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "edit", "(Ljava/lang/String;J)Lokhttp3/internal/cache/DiskLruCache$Editor;", "size", "()J", "editor", "success", "completeEdit$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;Z)V", "completeEdit", "remove", "(Ljava/lang/String;)Z", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "entry", "removeEntry$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Entry;)Z", "removeEntry", "flush", "isClosed", "close", "trimToSize", "delete", "evictAll", "", "snapshots", "()Ljava/util/Iterator;", "mostRecentRebuildFailed", "Z", "", "valueCount", "I", "getValueCount$okhttp", "()I", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "nextSequenceNumber", "J", "initialized", "Ljava/util/LinkedHashMap;", "lruEntries", "Ljava/util/LinkedHashMap;", "getLruEntries$okhttp", "()Ljava/util/LinkedHashMap;", "journalWriter", "Lj/g;", "hasJournalErrors", "okhttp3/internal/cache/DiskLruCache$cleanupTask$1", "cleanupTask", "Lokhttp3/internal/cache/DiskLruCache$cleanupTask$1;", "Lokhttp3/internal/io/FileSystem;", "fileSystem", "Lokhttp3/internal/io/FileSystem;", "getFileSystem$okhttp", "()Lokhttp3/internal/io/FileSystem;", "mostRecentTrimFailed", "value", "maxSize", "getMaxSize", "setMaxSize", "(J)V", "Ljava/io/File;", "directory", "Ljava/io/File;", "getDirectory", "()Ljava/io/File;", "journalFile", "journalFileTmp", "journalFileBackup", "redundantOpCount", "closed", "getClosed$okhttp", "setClosed$okhttp", "(Z)V", "appVersion", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "<init>", "(Lokhttp3/internal/io/FileSystem;Ljava/io/File;IIJLokhttp3/internal/concurrent/TaskRunner;)V", "Companion", "Editor", "Entry", "Snapshot", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class DiskLruCache implements Closeable, Flushable {
    private final int appVersion;
    private final TaskQueue cleanupQueue;
    private final DiskLruCache$cleanupTask$1 cleanupTask;
    private boolean closed;
    private final File directory;
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private g journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;
    public static final Companion Companion = new Companion(null);
    public static final String JOURNAL_FILE = JOURNAL_FILE;
    public static final String JOURNAL_FILE = JOURNAL_FILE;
    public static final String JOURNAL_FILE_TEMP = JOURNAL_FILE_TEMP;
    public static final String JOURNAL_FILE_TEMP = JOURNAL_FILE_TEMP;
    public static final String JOURNAL_FILE_BACKUP = JOURNAL_FILE_BACKUP;
    public static final String JOURNAL_FILE_BACKUP = JOURNAL_FILE_BACKUP;
    public static final String MAGIC = MAGIC;
    public static final String MAGIC = MAGIC;
    public static final String VERSION_1 = VERSION_1;
    public static final String VERSION_1 = VERSION_1;
    public static final long ANY_SEQUENCE_NUMBER = -1;
    public static final k LEGAL_KEY_PATTERN = new k("[a-z0-9_-]{1,120}");
    public static final String CLEAN = CLEAN;
    public static final String CLEAN = CLEAN;
    public static final String DIRTY = DIRTY;
    public static final String DIRTY = DIRTY;
    public static final String REMOVE = REMOVE;
    public static final String REMOVE = REMOVE;
    public static final String READ = READ;
    public static final String READ = READ;

    /* compiled from: DiskLruCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0016\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0016\u0010\u0010\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0016\u0010\u0011\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0016\u0010\u0012\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\b\u0012\u0010\u0007¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Companion;", "", "", "ANY_SEQUENCE_NUMBER", "J", "", DiskLruCache.CLEAN, "Ljava/lang/String;", DiskLruCache.DIRTY, "JOURNAL_FILE", "JOURNAL_FILE_BACKUP", "JOURNAL_FILE_TEMP", "Lkotlin/l0/k;", "LEGAL_KEY_PATTERN", "Lkotlin/l0/k;", "MAGIC", DiskLruCache.READ, DiskLruCache.REMOVE, "VERSION_1", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: DiskLruCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\n\u0010\u0012\u001a\u00060\u0010R\u00020\u0011¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\r\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0004R \u0010\u0012\u001a\u00060\u0010R\u00020\u00118\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "Lkotlin/x;", "detach$okhttp", "()V", "detach", "", "index", "Lj/e0;", "newSource", "(I)Lj/e0;", "Lj/c0;", "newSink", "(I)Lj/c0;", ApiConstants.COMMIT, "abort", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "Lokhttp3/internal/cache/DiskLruCache;", "entry", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "getEntry$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Entry;", "", "done", "Z", "", "written", "[Z", "getWritten$okhttp", "()[Z", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Lokhttp3/internal/cache/DiskLruCache$Entry;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public final class Editor {
        private boolean done;
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;
        private final boolean[] written;

        public Editor(DiskLruCache diskLruCache, Entry entry) {
            m.h(entry, "entry");
            this.this$0 = diskLruCache;
            this.entry = entry;
            this.written = entry.getReadable$okhttp() ? null : new boolean[diskLruCache.getValueCount$okhttp()];
        }

        public final void abort() throws IOException {
            synchronized (this.this$0) {
                if (!this.done) {
                    if (m.c(this.entry.getCurrentEditor$okhttp(), this)) {
                        this.this$0.completeEdit$okhttp(this, false);
                    }
                    this.done = true;
                    x xVar = x.a;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        public final void commit() throws IOException {
            synchronized (this.this$0) {
                if (!this.done) {
                    if (m.c(this.entry.getCurrentEditor$okhttp(), this)) {
                        this.this$0.completeEdit$okhttp(this, true);
                    }
                    this.done = true;
                    x xVar = x.a;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        public final void detach$okhttp() {
            if (m.c(this.entry.getCurrentEditor$okhttp(), this)) {
                int valueCount$okhttp = this.this$0.getValueCount$okhttp();
                for (int i2 = 0; i2 < valueCount$okhttp; i2++) {
                    try {
                        this.this$0.getFileSystem$okhttp().delete(this.entry.getDirtyFiles$okhttp().get(i2));
                    } catch (IOException unused) {
                    }
                }
                this.entry.setCurrentEditor$okhttp(null);
            }
        }

        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        public final c0 newSink(int i2) {
            synchronized (this.this$0) {
                if (!this.done) {
                    if (!m.c(this.entry.getCurrentEditor$okhttp(), this)) {
                        return q.b();
                    }
                    if (!this.entry.getReadable$okhttp()) {
                        boolean[] zArr = this.written;
                        if (zArr == null) {
                            m.q();
                        }
                        zArr[i2] = true;
                    }
                    try {
                        return new FaultHidingSink(this.this$0.getFileSystem$okhttp().sink(this.entry.getDirtyFiles$okhttp().get(i2)), new DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1(this, i2));
                    } catch (FileNotFoundException unused) {
                        return q.b();
                    }
                }
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        public final e0 newSource(int i2) {
            synchronized (this.this$0) {
                if (!this.done) {
                    e0 e0Var = null;
                    if (!this.entry.getReadable$okhttp() || (!m.c(this.entry.getCurrentEditor$okhttp(), this))) {
                        return null;
                    }
                    try {
                        e0Var = this.this$0.getFileSystem$okhttp().source(this.entry.getCleanFiles$okhttp().get(i2));
                    } catch (FileNotFoundException unused) {
                    }
                    return e0Var;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
        }
    }

    /* compiled from: DiskLruCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010*\u001a\u00020\u0003¢\u0006\u0004\b<\u0010=J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0015\u001a\b\u0018\u00010\u0011R\u00020\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0017\u001a\u00020\u00168\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010 R\u001c\u0010*\u001a\u00020\u00038\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R(\u00106\u001a\b\u0018\u000105R\u00020\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Entry;", "", "", "", "strings", "Ljava/io/IOException;", "invalidLengths", "(Ljava/util/List;)Ljava/io/IOException;", "Lkotlin/x;", "setLengths$okhttp", "(Ljava/util/List;)V", "setLengths", "Lj/g;", "writer", "writeLengths$okhttp", "(Lj/g;)V", "writeLengths", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "snapshot$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "snapshot", "", "lengths", "[J", "getLengths$okhttp", "()[J", "", "Ljava/io/File;", "dirtyFiles", "Ljava/util/List;", "getDirtyFiles$okhttp", "()Ljava/util/List;", "", "sequenceNumber", "J", "getSequenceNumber$okhttp", "()J", "setSequenceNumber$okhttp", "(J)V", "cleanFiles", "getCleanFiles$okhttp", "key", "Ljava/lang/String;", "getKey$okhttp", "()Ljava/lang/String;", "", "readable", "Z", "getReadable$okhttp", "()Z", "setReadable$okhttp", "(Z)V", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "currentEditor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "getCurrentEditor$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "setCurrentEditor$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public final class Entry {
        private final List<File> cleanFiles;
        private Editor currentEditor;
        private final List<File> dirtyFiles;
        private final String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;

        public Entry(DiskLruCache diskLruCache, String key) {
            m.h(key, "key");
            this.this$0 = diskLruCache;
            this.key = key;
            this.lengths = new long[diskLruCache.getValueCount$okhttp()];
            this.cleanFiles = new ArrayList();
            this.dirtyFiles = new ArrayList();
            StringBuilder sb = new StringBuilder(key);
            sb.append('.');
            int length = sb.length();
            int valueCount$okhttp = diskLruCache.getValueCount$okhttp();
            for (int i2 = 0; i2 < valueCount$okhttp; i2++) {
                sb.append(i2);
                this.cleanFiles.add(new File(diskLruCache.getDirectory(), sb.toString()));
                sb.append(".tmp");
                this.dirtyFiles.add(new File(diskLruCache.getDirectory(), sb.toString()));
                sb.setLength(length);
            }
        }

        private final IOException invalidLengths(List<String> list) throws IOException {
            throw new IOException("unexpected journal line: " + list);
        }

        public final List<File> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        public final List<File> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        public final String getKey$okhttp() {
            return this.key;
        }

        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final void setCurrentEditor$okhttp(Editor editor) {
            this.currentEditor = editor;
        }

        public final void setLengths$okhttp(List<String> strings) throws IOException {
            m.h(strings, "strings");
            if (strings.size() == this.this$0.getValueCount$okhttp()) {
                try {
                    int size = strings.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        this.lengths[i2] = Long.parseLong(strings.get(i2));
                    }
                    return;
                } catch (NumberFormatException unused) {
                    throw invalidLengths(strings);
                }
            }
            throw invalidLengths(strings);
        }

        public final void setReadable$okhttp(boolean z) {
            this.readable = z;
        }

        public final void setSequenceNumber$okhttp(long j2) {
            this.sequenceNumber = j2;
        }

        public final Snapshot snapshot$okhttp() {
            DiskLruCache diskLruCache = this.this$0;
            if (Util.assertionsEnabled && !Thread.holdsLock(diskLruCache)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                m.d(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST hold lock on ");
                sb.append(diskLruCache);
                throw new AssertionError(sb.toString());
            }
            ArrayList<e0> arrayList = new ArrayList();
            long[] jArr = (long[]) this.lengths.clone();
            try {
                int valueCount$okhttp = this.this$0.getValueCount$okhttp();
                for (int i2 = 0; i2 < valueCount$okhttp; i2++) {
                    arrayList.add(this.this$0.getFileSystem$okhttp().source(this.cleanFiles.get(i2)));
                }
                return new Snapshot(this.this$0, this.key, this.sequenceNumber, arrayList, jArr);
            } catch (FileNotFoundException unused) {
                for (e0 e0Var : arrayList) {
                    Util.closeQuietly(e0Var);
                }
                try {
                    this.this$0.removeEntry$okhttp(this);
                    return null;
                } catch (IOException unused2) {
                    return null;
                }
            }
        }

        public final void writeLengths$okhttp(g writer) throws IOException {
            m.h(writer, "writer");
            for (long j2 : this.lengths) {
                writer.R(32).a1(j2);
            }
        }
    }

    /* compiled from: DiskLruCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B/\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0007\u001a\b\u0018\u00010\u0005R\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001c¨\u0006\u001f"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Ljava/io/Closeable;", "", "key", "()Ljava/lang/String;", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "edit", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "index", "Lj/e0;", "getSource", "(I)Lj/e0;", "", "getLength", "(I)J", "Lkotlin/x;", "close", "()V", "sequenceNumber", "J", "", "sources", "Ljava/util/List;", "", "lengths", "[J", "Ljava/lang/String;", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;JLjava/util/List;[J)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final List<e0> sources;
        final /* synthetic */ DiskLruCache this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public Snapshot(DiskLruCache diskLruCache, String key, long j2, List<? extends e0> sources, long[] lengths) {
            m.h(key, "key");
            m.h(sources, "sources");
            m.h(lengths, "lengths");
            this.this$0 = diskLruCache;
            this.key = key;
            this.sequenceNumber = j2;
            this.sources = sources;
            this.lengths = lengths;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (e0 e0Var : this.sources) {
                Util.closeQuietly(e0Var);
            }
        }

        public final Editor edit() throws IOException {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public final long getLength(int i2) {
            return this.lengths[i2];
        }

        public final e0 getSource(int i2) {
            return this.sources.get(i2);
        }

        public final String key() {
            return this.key;
        }
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [okhttp3.internal.cache.DiskLruCache$cleanupTask$1] */
    public DiskLruCache(FileSystem fileSystem, File directory, int i2, int i3, long j2, TaskRunner taskRunner) {
        m.h(fileSystem, "fileSystem");
        m.h(directory, "directory");
        m.h(taskRunner, "taskRunner");
        this.fileSystem = fileSystem;
        this.directory = directory;
        this.appVersion = i2;
        this.valueCount = i3;
        this.maxSize = j2;
        this.lruEntries = new LinkedHashMap<>(0, 0.75f, true);
        this.cleanupQueue = taskRunner.newQueue();
        this.cleanupTask = new Task(Util.okHttpName + " Cache") { // from class: okhttp3.internal.cache.DiskLruCache$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                synchronized (DiskLruCache.this) {
                    if (!DiskLruCache.access$getInitialized$p(DiskLruCache.this) || DiskLruCache.this.getClosed$okhttp()) {
                        return -1L;
                    }
                    try {
                        DiskLruCache.this.trimToSize();
                    } catch (IOException unused) {
                        DiskLruCache.access$setMostRecentTrimFailed$p(DiskLruCache.this, true);
                    }
                    try {
                        if (DiskLruCache.access$journalRebuildRequired(DiskLruCache.this)) {
                            DiskLruCache.this.rebuildJournal$okhttp();
                            DiskLruCache.access$setRedundantOpCount$p(DiskLruCache.this, 0);
                        }
                    } catch (IOException unused2) {
                        DiskLruCache.access$setMostRecentRebuildFailed$p(DiskLruCache.this, true);
                        DiskLruCache.access$setJournalWriter$p(DiskLruCache.this, q.c(q.b()));
                    }
                    return -1L;
                }
            }
        };
        if (!(j2 > 0)) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        if (i3 > 0) {
            this.journalFile = new File(directory, JOURNAL_FILE);
            this.journalFileTmp = new File(directory, JOURNAL_FILE_TEMP);
            this.journalFileBackup = new File(directory, JOURNAL_FILE_BACKUP);
            return;
        }
        throw new IllegalArgumentException("valueCount <= 0".toString());
    }

    public static final /* synthetic */ boolean access$getInitialized$p(DiskLruCache diskLruCache) {
        return diskLruCache.initialized;
    }

    public static final /* synthetic */ boolean access$journalRebuildRequired(DiskLruCache diskLruCache) {
        return diskLruCache.journalRebuildRequired();
    }

    public static final /* synthetic */ void access$setJournalWriter$p(DiskLruCache diskLruCache, g gVar) {
        diskLruCache.journalWriter = gVar;
    }

    public static final /* synthetic */ void access$setMostRecentRebuildFailed$p(DiskLruCache diskLruCache, boolean z) {
        diskLruCache.mostRecentRebuildFailed = z;
    }

    public static final /* synthetic */ void access$setMostRecentTrimFailed$p(DiskLruCache diskLruCache, boolean z) {
        diskLruCache.mostRecentTrimFailed = z;
    }

    public static final /* synthetic */ void access$setRedundantOpCount$p(DiskLruCache diskLruCache, int i2) {
        diskLruCache.redundantOpCount = i2;
    }

    private final synchronized void checkNotClosed() {
        if (!(!this.closed)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache diskLruCache, String str, long j2, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            j2 = ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache.edit(str, j2);
    }

    public final boolean journalRebuildRequired() {
        int i2 = this.redundantOpCount;
        return i2 >= 2000 && i2 >= this.lruEntries.size();
    }

    private final g newJournalWriter() throws FileNotFoundException {
        return q.c(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new DiskLruCache$newJournalWriter$faultHidingSink$1(this)));
    }

    private final void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            m.d(next, "i.next()");
            Entry entry = next;
            int i2 = 0;
            if (entry.getCurrentEditor$okhttp() == null) {
                int i3 = this.valueCount;
                while (i2 < i3) {
                    this.size += entry.getLengths$okhttp()[i2];
                    i2++;
                }
            } else {
                entry.setCurrentEditor$okhttp(null);
                int i4 = this.valueCount;
                while (i2 < i4) {
                    this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i2));
                    this.fileSystem.delete(entry.getDirtyFiles$okhttp().get(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    private final void readJournal() throws IOException {
        h d2 = q.d(this.fileSystem.source(this.journalFile));
        try {
            String C0 = d2.C0();
            String C02 = d2.C0();
            String C03 = d2.C0();
            String C04 = d2.C0();
            String C05 = d2.C0();
            if (!(!m.c(MAGIC, C0)) && !(!m.c(VERSION_1, C02)) && !(!m.c(String.valueOf(this.appVersion), C03)) && !(!m.c(String.valueOf(this.valueCount), C04))) {
                int i2 = 0;
                if (!(C05.length() > 0)) {
                    while (true) {
                        try {
                            readJournalLine(d2.C0());
                            i2++;
                        } catch (EOFException unused) {
                            this.redundantOpCount = i2 - this.lruEntries.size();
                            if (!d2.Q()) {
                                rebuildJournal$okhttp();
                            } else {
                                this.journalWriter = newJournalWriter();
                            }
                            x xVar = x.a;
                            a.a(d2, null);
                            return;
                        }
                    }
                }
            }
            throw new IOException("unexpected journal header: [" + C0 + ", " + C02 + ", " + C04 + ", " + C05 + ']');
        } finally {
        }
    }

    private final void readJournalLine(String str) throws IOException {
        int h0;
        int h02;
        String substring;
        boolean Q;
        boolean Q2;
        boolean Q3;
        List<String> J0;
        boolean Q4;
        h0 = y.h0(str, TokenParser.SP, 0, false, 6, null);
        if (h0 != -1) {
            int i2 = h0 + 1;
            h02 = y.h0(str, TokenParser.SP, i2, false, 4, null);
            if (h02 == -1) {
                if (str != null) {
                    substring = str.substring(i2);
                    m.d(substring, "(this as java.lang.String).substring(startIndex)");
                    String str2 = REMOVE;
                    if (h0 == str2.length()) {
                        Q4 = kotlin.l0.x.Q(str, str2, false, 2, null);
                        if (Q4) {
                            this.lruEntries.remove(substring);
                            return;
                        }
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            } else if (str != null) {
                substring = str.substring(i2, h02);
                m.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            Entry entry = this.lruEntries.get(substring);
            if (entry == null) {
                entry = new Entry(this, substring);
                this.lruEntries.put(substring, entry);
            }
            if (h02 != -1) {
                String str3 = CLEAN;
                if (h0 == str3.length()) {
                    Q3 = kotlin.l0.x.Q(str, str3, false, 2, null);
                    if (Q3) {
                        int i3 = h02 + 1;
                        if (str != null) {
                            String substring2 = str.substring(i3);
                            m.d(substring2, "(this as java.lang.String).substring(startIndex)");
                            J0 = y.J0(substring2, new char[]{TokenParser.SP}, false, 0, 6, null);
                            entry.setReadable$okhttp(true);
                            entry.setCurrentEditor$okhttp(null);
                            entry.setLengths$okhttp(J0);
                            return;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                }
            }
            if (h02 == -1) {
                String str4 = DIRTY;
                if (h0 == str4.length()) {
                    Q2 = kotlin.l0.x.Q(str, str4, false, 2, null);
                    if (Q2) {
                        entry.setCurrentEditor$okhttp(new Editor(this, entry));
                        return;
                    }
                }
            }
            if (h02 == -1) {
                String str5 = READ;
                if (h0 == str5.length()) {
                    Q = kotlin.l0.x.Q(str, str5, false, 2, null);
                    if (Q) {
                        return;
                    }
                }
            }
            throw new IOException("unexpected journal line: " + str);
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private final void validateKey(String str) {
        if (LEGAL_KEY_PATTERN.d(str)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + TokenParser.DQUOTE).toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Entry[] entryArr;
        if (this.initialized && !this.closed) {
            Collection<Entry> values = this.lruEntries.values();
            m.d(values, "lruEntries.values");
            Object[] array = values.toArray(new Entry[0]);
            if (array != null) {
                for (Entry entry : (Entry[]) array) {
                    if (entry.getCurrentEditor$okhttp() != null) {
                        Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
                        if (currentEditor$okhttp == null) {
                            m.q();
                        }
                        currentEditor$okhttp.abort();
                    }
                }
                trimToSize();
                g gVar = this.journalWriter;
                if (gVar == null) {
                    m.q();
                }
                gVar.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        this.closed = true;
    }

    public final synchronized void completeEdit$okhttp(Editor editor, boolean z) throws IOException {
        m.h(editor, "editor");
        Entry entry$okhttp = editor.getEntry$okhttp();
        if (m.c(entry$okhttp.getCurrentEditor$okhttp(), editor)) {
            if (z && !entry$okhttp.getReadable$okhttp()) {
                int i2 = this.valueCount;
                for (int i3 = 0; i3 < i2; i3++) {
                    boolean[] written$okhttp = editor.getWritten$okhttp();
                    if (written$okhttp == null) {
                        m.q();
                    }
                    if (written$okhttp[i3]) {
                        if (!this.fileSystem.exists(entry$okhttp.getDirtyFiles$okhttp().get(i3))) {
                            editor.abort();
                            return;
                        }
                    } else {
                        editor.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i3);
                    }
                }
            }
            int i4 = this.valueCount;
            for (int i5 = 0; i5 < i4; i5++) {
                File file = entry$okhttp.getDirtyFiles$okhttp().get(i5);
                if (z) {
                    if (this.fileSystem.exists(file)) {
                        File file2 = entry$okhttp.getCleanFiles$okhttp().get(i5);
                        this.fileSystem.rename(file, file2);
                        long j2 = entry$okhttp.getLengths$okhttp()[i5];
                        long size = this.fileSystem.size(file2);
                        entry$okhttp.getLengths$okhttp()[i5] = size;
                        this.size = (this.size - j2) + size;
                    }
                } else {
                    this.fileSystem.delete(file);
                }
            }
            this.redundantOpCount++;
            entry$okhttp.setCurrentEditor$okhttp(null);
            g gVar = this.journalWriter;
            if (gVar == null) {
                m.q();
            }
            if (!entry$okhttp.getReadable$okhttp() && !z) {
                this.lruEntries.remove(entry$okhttp.getKey$okhttp());
                gVar.h0(REMOVE).R(32);
                gVar.h0(entry$okhttp.getKey$okhttp());
                gVar.R(10);
                gVar.flush();
                if (this.size <= this.maxSize || journalRebuildRequired()) {
                    TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
                }
                return;
            }
            entry$okhttp.setReadable$okhttp(true);
            gVar.h0(CLEAN).R(32);
            gVar.h0(entry$okhttp.getKey$okhttp());
            entry$okhttp.writeLengths$okhttp(gVar);
            gVar.R(10);
            if (z) {
                long j3 = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j3;
                entry$okhttp.setSequenceNumber$okhttp(j3);
            }
            gVar.flush();
            if (this.size <= this.maxSize) {
            }
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public final Editor edit(String str) throws IOException {
        return edit$default(this, str, 0L, 2, null);
    }

    public final synchronized Editor edit(String key, long j2) throws IOException {
        m.h(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (j2 == ANY_SEQUENCE_NUMBER || (entry != null && entry.getSequenceNumber$okhttp() == j2)) {
            if ((entry != null ? entry.getCurrentEditor$okhttp() : null) != null) {
                return null;
            }
            if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
                g gVar = this.journalWriter;
                if (gVar == null) {
                    m.q();
                }
                gVar.h0(DIRTY).R(32).h0(key).R(10);
                gVar.flush();
                if (this.hasJournalErrors) {
                    return null;
                }
                if (entry == null) {
                    entry = new Entry(this, key);
                    this.lruEntries.put(key, entry);
                }
                Editor editor = new Editor(this, entry);
                entry.setCurrentEditor$okhttp(editor);
                return editor;
            }
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            return null;
        }
        return null;
    }

    public final synchronized void evictAll() throws IOException {
        Entry[] entryArr;
        initialize();
        Collection<Entry> values = this.lruEntries.values();
        m.d(values, "lruEntries.values");
        Object[] array = values.toArray(new Entry[0]);
        if (array != null) {
            for (Entry entry : (Entry[]) array) {
                m.d(entry, "entry");
                removeEntry$okhttp(entry);
            }
            this.mostRecentTrimFailed = false;
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            g gVar = this.journalWriter;
            if (gVar == null) {
                m.q();
            }
            gVar.flush();
        }
    }

    public final synchronized Snapshot get(String key) throws IOException {
        m.h(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (entry != null) {
            m.d(entry, "lruEntries[key] ?: return null");
            if (entry.getReadable$okhttp()) {
                Snapshot snapshot$okhttp = entry.snapshot$okhttp();
                if (snapshot$okhttp != null) {
                    this.redundantOpCount++;
                    g gVar = this.journalWriter;
                    if (gVar == null) {
                        m.q();
                    }
                    gVar.h0(READ).R(32).h0(key).R(10);
                    if (journalRebuildRequired()) {
                        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
                    }
                    return snapshot$okhttp;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    public final File getDirectory() {
        return this.directory;
    }

    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final synchronized void initialize() throws IOException {
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            m.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        if (this.initialized) {
            return;
        }
        if (this.fileSystem.exists(this.journalFileBackup)) {
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.delete(this.journalFileBackup);
            } else {
                this.fileSystem.rename(this.journalFileBackup, this.journalFile);
            }
        }
        if (this.fileSystem.exists(this.journalFile)) {
            try {
                readJournal();
                processJournal();
                this.initialized = true;
                return;
            } catch (IOException e2) {
                Platform platform = Platform.Companion.get();
                platform.log("DiskLruCache " + this.directory + " is corrupt: " + e2.getMessage() + ", removing", 5, e2);
                delete();
                this.closed = false;
            }
        }
        rebuildJournal$okhttp();
        this.initialized = true;
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    public final synchronized void rebuildJournal$okhttp() throws IOException {
        g gVar = this.journalWriter;
        if (gVar != null) {
            gVar.close();
        }
        g c2 = q.c(this.fileSystem.sink(this.journalFileTmp));
        c2.h0(MAGIC).R(10);
        c2.h0(VERSION_1).R(10);
        c2.a1(this.appVersion).R(10);
        c2.a1(this.valueCount).R(10);
        c2.R(10);
        for (Entry entry : this.lruEntries.values()) {
            if (entry.getCurrentEditor$okhttp() != null) {
                c2.h0(DIRTY).R(32);
                c2.h0(entry.getKey$okhttp());
                c2.R(10);
            } else {
                c2.h0(CLEAN).R(32);
                c2.h0(entry.getKey$okhttp());
                entry.writeLengths$okhttp(c2);
                c2.R(10);
            }
        }
        x xVar = x.a;
        a.a(c2, null);
        if (this.fileSystem.exists(this.journalFile)) {
            this.fileSystem.rename(this.journalFile, this.journalFileBackup);
        }
        this.fileSystem.rename(this.journalFileTmp, this.journalFile);
        this.fileSystem.delete(this.journalFileBackup);
        this.journalWriter = newJournalWriter();
        this.hasJournalErrors = false;
        this.mostRecentRebuildFailed = false;
    }

    public final synchronized boolean remove(String key) throws IOException {
        m.h(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (entry != null) {
            m.d(entry, "lruEntries[key] ?: return false");
            boolean removeEntry$okhttp = removeEntry$okhttp(entry);
            if (removeEntry$okhttp && this.size <= this.maxSize) {
                this.mostRecentTrimFailed = false;
            }
            return removeEntry$okhttp;
        }
        return false;
    }

    public final boolean removeEntry$okhttp(Entry entry) throws IOException {
        m.h(entry, "entry");
        Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
        if (currentEditor$okhttp != null) {
            currentEditor$okhttp.detach$okhttp();
        }
        int i2 = this.valueCount;
        for (int i3 = 0; i3 < i2; i3++) {
            this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i3));
            this.size -= entry.getLengths$okhttp()[i3];
            entry.getLengths$okhttp()[i3] = 0;
        }
        this.redundantOpCount++;
        g gVar = this.journalWriter;
        if (gVar == null) {
            m.q();
        }
        gVar.h0(REMOVE).R(32).h0(entry.getKey$okhttp()).R(10);
        this.lruEntries.remove(entry.getKey$okhttp());
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return true;
    }

    public final void setClosed$okhttp(boolean z) {
        this.closed = z;
    }

    public final synchronized void setMaxSize(long j2) {
        this.maxSize = j2;
        if (this.initialized) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
    }

    public final synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    public final synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new DiskLruCache$snapshots$1(this);
    }

    public final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            Entry next = this.lruEntries.values().iterator().next();
            m.d(next, "lruEntries.values.iterator().next()");
            removeEntry$okhttp(next);
        }
        this.mostRecentTrimFailed = false;
    }
}