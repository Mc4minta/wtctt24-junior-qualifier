package okhttp3.internal.cache;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n0.a;
import kotlin.x;
import okhttp3.internal.cache.DiskLruCache;

/* compiled from: DiskLruCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001J\u0010\u0010\u0005\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0007\u001a\u00060\u0002R\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR(\u0010\f\u001a\b\u0018\u00010\u0002R\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\u0010R/\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012 \u0012*\b\u0018\u00010\u0011R\u00020\u00030\u0011R\u00020\u00030\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R(\u0010\u0017\u001a\b\u0018\u00010\u0002R\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\u0010¨\u0006\u001a"}, d2 = {"okhttp3/internal/cache/DiskLruCache$snapshots$1", "", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "", "hasNext", "()Z", "next", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lkotlin/x;", "remove", "()V", "nextSnapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "getNextSnapshot", "setNextSnapshot", "(Lokhttp3/internal/cache/DiskLruCache$Snapshot;)V", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "kotlin.jvm.PlatformType", "delegate", "Ljava/util/Iterator;", "getDelegate", "()Ljava/util/Iterator;", "removeSnapshot", "getRemoveSnapshot", "setRemoveSnapshot", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class DiskLruCache$snapshots$1 implements Iterator<DiskLruCache.Snapshot>, a {
    private final Iterator<DiskLruCache.Entry> delegate;
    private DiskLruCache.Snapshot nextSnapshot;
    private DiskLruCache.Snapshot removeSnapshot;
    final /* synthetic */ DiskLruCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DiskLruCache$snapshots$1(DiskLruCache diskLruCache) {
        this.this$0 = diskLruCache;
        Iterator<DiskLruCache.Entry> it = new ArrayList(diskLruCache.getLruEntries$okhttp().values()).iterator();
        m.d(it, "ArrayList(lruEntries.values).iterator()");
        this.delegate = it;
    }

    public final Iterator<DiskLruCache.Entry> getDelegate() {
        return this.delegate;
    }

    public final DiskLruCache.Snapshot getNextSnapshot() {
        return this.nextSnapshot;
    }

    public final DiskLruCache.Snapshot getRemoveSnapshot() {
        return this.removeSnapshot;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        DiskLruCache.Snapshot snapshot$okhttp;
        if (this.nextSnapshot != null) {
            return true;
        }
        synchronized (this.this$0) {
            if (this.this$0.getClosed$okhttp()) {
                return false;
            }
            while (this.delegate.hasNext()) {
                DiskLruCache.Entry next = this.delegate.next();
                if (next != null && next.getReadable$okhttp() && (snapshot$okhttp = next.snapshot$okhttp()) != null) {
                    this.nextSnapshot = snapshot$okhttp;
                    return true;
                }
            }
            x xVar = x.a;
            return false;
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        DiskLruCache.Snapshot snapshot = this.removeSnapshot;
        if (snapshot != null) {
            try {
                this.this$0.remove(snapshot.key());
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.removeSnapshot = null;
                throw th;
            }
            this.removeSnapshot = null;
            return;
        }
        throw new IllegalStateException("remove() before next()".toString());
    }

    public final void setNextSnapshot(DiskLruCache.Snapshot snapshot) {
        this.nextSnapshot = snapshot;
    }

    public final void setRemoveSnapshot(DiskLruCache.Snapshot snapshot) {
        this.removeSnapshot = snapshot;
    }

    @Override // java.util.Iterator
    public DiskLruCache.Snapshot next() {
        if (hasNext()) {
            DiskLruCache.Snapshot snapshot = this.nextSnapshot;
            this.removeSnapshot = snapshot;
            this.nextSnapshot = null;
            if (snapshot == null) {
                m.q();
            }
            return snapshot;
        }
        throw new NoSuchElementException();
    }
}