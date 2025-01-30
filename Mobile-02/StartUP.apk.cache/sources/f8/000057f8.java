package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: LazyScopeAdapter.kt */
/* loaded from: classes3.dex */
public final class LazyScopeAdapter extends AbstractScopeAdapter {
    private final NotNullLazyValue<MemberScope> lazyScope;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LazyScopeAdapter(a<? extends MemberScope> getScope) {
        this(null, getScope, 1, null);
        m.g(getScope, "getScope");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ LazyScopeAdapter(kotlin.reflect.jvm.internal.impl.storage.StorageManager r1, kotlin.e0.c.a r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 1
            if (r3 == 0) goto Lb
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r1 = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NO_LOCKS
            java.lang.String r3 = "NO_LOCKS"
            kotlin.jvm.internal.m.f(r1, r3)
        Lb:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter.<init>(kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.e0.c.a, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter
    protected MemberScope getWorkerScope() {
        return (MemberScope) this.lazyScope.invoke();
    }

    public LazyScopeAdapter(StorageManager storageManager, a<? extends MemberScope> getScope) {
        m.g(storageManager, "storageManager");
        m.g(getScope, "getScope");
        this.lazyScope = storageManager.createLazyValue(new LazyScopeAdapter$lazyScope$1(getScope));
    }
}