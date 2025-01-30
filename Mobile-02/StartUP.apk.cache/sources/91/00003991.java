package com.google.firebase.crashlytics.c.g;

import android.os.Looper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public final class h0 {
    private static final FilenameFilter a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final ExecutorService f8695b = t.c("awaitEvenIfOnMainThread task continuation executor");

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return true;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    class b<T> implements com.google.android.gms.tasks.a<T, Void> {
        final /* synthetic */ com.google.android.gms.tasks.h a;

        b(com.google.android.gms.tasks.h hVar) {
            this.a = hVar;
        }

        @Override // com.google.android.gms.tasks.a
        /* renamed from: b */
        public Void a(com.google.android.gms.tasks.g<T> gVar) throws Exception {
            if (gVar.q()) {
                this.a.e(gVar.m());
                return null;
            }
            this.a.d(gVar.l());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        final /* synthetic */ Callable a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.android.gms.tasks.h f8696b;

        /* JADX INFO: Add missing generic type declarations: [T] */
        /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
        /* loaded from: classes2.dex */
        class a<T> implements com.google.android.gms.tasks.a<T, Void> {
            a() {
            }

            @Override // com.google.android.gms.tasks.a
            /* renamed from: b */
            public Void a(com.google.android.gms.tasks.g<T> gVar) throws Exception {
                if (gVar.q()) {
                    c.this.f8696b.c(gVar.m());
                    return null;
                }
                c.this.f8696b.b(gVar.l());
                return null;
            }
        }

        c(Callable callable, com.google.android.gms.tasks.h hVar) {
            this.a = callable;
            this.f8696b = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ((com.google.android.gms.tasks.g) this.a.call()).h(new a());
            } catch (Exception e2) {
                this.f8696b.b(e2);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    class d<T> implements com.google.android.gms.tasks.a<T, Object> {
        final /* synthetic */ CountDownLatch a;

        d(CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        @Override // com.google.android.gms.tasks.a
        public Object a(com.google.android.gms.tasks.g<T> gVar) throws Exception {
            this.a.countDown();
            return null;
        }
    }

    public static <T> T a(com.google.android.gms.tasks.g<T> gVar) throws InterruptedException, TimeoutException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        gVar.i(f8695b, new d(countDownLatch));
        if (Looper.getMainLooper() == Looper.myLooper()) {
            countDownLatch.await(4L, TimeUnit.SECONDS);
        } else {
            countDownLatch.await();
        }
        if (gVar.p()) {
            return gVar.m();
        }
        throw new TimeoutException();
    }

    public static <T> com.google.android.gms.tasks.g<T> b(Executor executor, Callable<com.google.android.gms.tasks.g<T>> callable) {
        com.google.android.gms.tasks.h hVar = new com.google.android.gms.tasks.h();
        executor.execute(new c(callable, hVar));
        return hVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(File file, int i2, Comparator<File> comparator) {
        return d(file, a, i2, comparator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(File file, FilenameFilter filenameFilter, int i2, Comparator<File> comparator) {
        File[] listFiles = file.listFiles(filenameFilter);
        if (listFiles == null) {
            return 0;
        }
        return e(Arrays.asList(listFiles), i2, comparator);
    }

    static int e(List<File> list, int i2, Comparator<File> comparator) {
        int size = list.size();
        Collections.sort(list, comparator);
        for (File file : list) {
            if (size <= i2) {
                return size;
            }
            h(file);
            size--;
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(File file, File file2, int i2, Comparator<File> comparator) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        File[] listFiles2 = file2.listFiles(a);
        if (listFiles == null) {
            listFiles = new File[0];
        }
        if (listFiles2 == null) {
            listFiles2 = new File[0];
        }
        arrayList.addAll(Arrays.asList(listFiles));
        arrayList.addAll(Arrays.asList(listFiles2));
        return e(arrayList, i2, comparator);
    }

    public static <T> com.google.android.gms.tasks.g<T> g(com.google.android.gms.tasks.g<T> gVar, com.google.android.gms.tasks.g<T> gVar2) {
        com.google.android.gms.tasks.h hVar = new com.google.android.gms.tasks.h();
        b bVar = new b(hVar);
        gVar.h(bVar);
        gVar2.h(bVar);
        return hVar.a();
    }

    private static void h(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                h(file2);
            }
        }
        file.delete();
    }
}