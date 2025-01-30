package com.bugsnag.android;

import com.bugsnag.android.NativeInterface;
import com.bugsnag.android.o0;
import java.io.IOException;
import java.util.Observable;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Breadcrumbs extends Observable implements o0.a {
    private static final int MAX_PAYLOAD_SIZE = 4096;
    private final s configuration;
    final Queue<Breadcrumb> store = new ConcurrentLinkedQueue();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Breadcrumbs(s sVar) {
        this.configuration = sVar;
    }

    private void addToStore(Breadcrumb breadcrumb) {
        try {
            if (breadcrumb.payloadSize() > 4096) {
                q0.d("Dropping breadcrumb because payload exceeds 4KB limit");
                return;
            }
            this.store.add(breadcrumb);
            pruneBreadcrumbs();
            setChanged();
            notifyObservers(new NativeInterface.b(NativeInterface.c.ADD_BREADCRUMB, breadcrumb));
        } catch (IOException e2) {
            q0.e("Dropping breadcrumb because it could not be serialized", e2);
        }
    }

    private void pruneBreadcrumbs() {
        int s = this.configuration.s();
        while (this.store.size() > s) {
            this.store.poll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void add(Breadcrumb breadcrumb) {
        addToStore(breadcrumb);
    }

    void clear() {
        this.store.clear();
        setChanged();
        notifyObservers(new NativeInterface.b(NativeInterface.c.CLEAR_BREADCRUMBS, null));
    }

    @Override // com.bugsnag.android.o0.a
    public void toStream(o0 o0Var) throws IOException {
        pruneBreadcrumbs();
        o0Var.c();
        for (Breadcrumb breadcrumb : this.store) {
            breadcrumb.toStream(o0Var);
        }
        o0Var.f();
    }
}