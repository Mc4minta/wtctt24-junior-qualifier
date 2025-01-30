package e.j.n;

import com.toshi.model.local.room.Bookmark;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DappsViewModel.kt */
/* loaded from: classes2.dex */
public abstract class c2 {

    /* compiled from: DappsViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a extends c2 {
        public static final a a = new a();

        private a() {
            super(null);
        }
    }

    /* compiled from: DappsViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class b extends c2 {
        private final Bookmark a;

        /* renamed from: b  reason: collision with root package name */
        private final c f13811b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Bookmark bookmark, c status) {
            super(null);
            kotlin.jvm.internal.m.g(status, "status");
            this.a = bookmark;
            this.f13811b = status;
        }

        public final Bookmark a() {
            return this.a;
        }

        public final c b() {
            return this.f13811b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return kotlin.jvm.internal.m.c(this.a, bVar.a) && this.f13811b == bVar.f13811b;
            }
            return false;
        }

        public int hashCode() {
            Bookmark bookmark = this.a;
            return ((bookmark == null ? 0 : bookmark.hashCode()) * 31) + this.f13811b.hashCode();
        }

        public String toString() {
            return "BookmarkBannerVisible(bookmark=" + this.a + ", status=" + this.f13811b + ')';
        }
    }

    /* compiled from: DappsViewModel.kt */
    /* loaded from: classes2.dex */
    public enum c {
        BOOKMARK_ADDED,
        BOOKMARK_REMOVED
    }

    private c2() {
    }

    public /* synthetic */ c2(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}