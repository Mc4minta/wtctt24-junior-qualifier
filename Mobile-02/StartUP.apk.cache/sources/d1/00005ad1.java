package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;
import okhttp3.internal.cache.DiskLruCache;

/* compiled from: DiskLruCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ljava/io/IOException;", "it", "Lkotlin/x;", "invoke", "(Ljava/io/IOException;)V", "okhttp3/internal/cache/DiskLruCache$Editor$newSink$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes3.dex */
final class DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1 extends o implements l<IOException, x> {
    final /* synthetic */ int $index$inlined;
    final /* synthetic */ DiskLruCache.Editor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1(DiskLruCache.Editor editor, int i2) {
        super(1);
        this.this$0 = editor;
        this.$index$inlined = i2;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(IOException iOException) {
        invoke2(iOException);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(IOException it) {
        m.h(it, "it");
        synchronized (this.this$0.this$0) {
            this.this$0.detach$okhttp();
            x xVar = x.a;
        }
    }
}