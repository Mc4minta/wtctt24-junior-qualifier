package com.bugsnag.android;

import android.content.Context;
import java.io.File;
import java.util.Comparator;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SessionStore.java */
/* loaded from: classes.dex */
public class x0 extends i0<w0> {

    /* renamed from: g  reason: collision with root package name */
    static final Comparator<File> f3729g = new a();

    /* compiled from: SessionStore.java */
    /* loaded from: classes.dex */
    static class a implements Comparator<File> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            if (file == null && file2 == null) {
                return 0;
            }
            if (file == null) {
                return 1;
            }
            if (file2 == null) {
                return -1;
            }
            return file.getName().compareTo(file2.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x0(s sVar, Context context) {
        super(sVar, context, "/bugsnag-sessions/", 128, f3729g);
    }

    @Override // com.bugsnag.android.i0
    String f(Object obj) {
        return String.format(Locale.US, "%s%s%d.json", this.f3655b, UUID.randomUUID().toString(), Long.valueOf(System.currentTimeMillis()));
    }
}