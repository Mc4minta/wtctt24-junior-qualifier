package com.google.android.gms.tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d0 implements a<Void, g<List<g<?>>>> {
    private final /* synthetic */ Collection a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(Collection collection) {
        this.a = collection;
    }

    @Override // com.google.android.gms.tasks.a
    public final /* synthetic */ g<List<g<?>>> a(g<Void> gVar) throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.a);
        return j.e(arrayList);
    }
}