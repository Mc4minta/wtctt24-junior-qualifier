package androidx.lifecycle;

import androidx.lifecycle.c;
import androidx.lifecycle.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements m {
    private final Object a;

    /* renamed from: b  reason: collision with root package name */
    private final c.a f1766b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.a = obj;
        this.f1766b = c.a.c(obj.getClass());
    }

    @Override // androidx.lifecycle.m
    public void c(o oVar, i.a aVar) {
        this.f1766b.a(oVar, aVar, this.a);
    }
}