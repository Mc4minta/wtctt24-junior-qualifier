package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* compiled from: InvalidationLiveDataContainer.java */
/* loaded from: classes.dex */
class f {
    final Set<LiveData> a = Collections.newSetFromMap(new IdentityHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final j f2232b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(j jVar) {
        this.f2232b = jVar;
    }
}