package com.facebook.react.views.image;

import android.graphics.Bitmap;
import java.util.LinkedList;
import java.util.List;

/* compiled from: MultiPostprocessor.java */
/* loaded from: classes2.dex */
public class e implements com.facebook.imagepipeline.request.c {
    private final List<com.facebook.imagepipeline.request.c> a;

    private e(List<com.facebook.imagepipeline.request.c> list) {
        this.a = new LinkedList(list);
    }

    public static com.facebook.imagepipeline.request.c d(List<com.facebook.imagepipeline.request.c> list) {
        int size = list.size();
        if (size != 0) {
            if (size != 1) {
                return new e(list);
            }
            return list.get(0);
        }
        return null;
    }

    @Override // com.facebook.imagepipeline.request.c
    public com.facebook.common.references.a<Bitmap> b(Bitmap bitmap, e.f.j.c.f fVar) {
        com.facebook.common.references.a<Bitmap> aVar = null;
        try {
            com.facebook.common.references.a<Bitmap> aVar2 = null;
            for (com.facebook.imagepipeline.request.c cVar : this.a) {
                aVar = cVar.b(aVar2 != null ? aVar2.n() : bitmap, fVar);
                com.facebook.common.references.a.f(aVar2);
                aVar2 = aVar.clone();
            }
            return aVar.clone();
        } finally {
            com.facebook.common.references.a.f(aVar);
        }
    }

    @Override // com.facebook.imagepipeline.request.c
    public e.f.b.a.d c() {
        LinkedList linkedList = new LinkedList();
        for (com.facebook.imagepipeline.request.c cVar : this.a) {
            linkedList.push(cVar.c());
        }
        return new e.f.b.a.f(linkedList);
    }

    @Override // com.facebook.imagepipeline.request.c
    public String getName() {
        StringBuilder sb = new StringBuilder();
        for (com.facebook.imagepipeline.request.c cVar : this.a) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(cVar.getName());
        }
        sb.insert(0, "MultiPostProcessor (");
        sb.append(")");
        return sb.toString();
    }
}