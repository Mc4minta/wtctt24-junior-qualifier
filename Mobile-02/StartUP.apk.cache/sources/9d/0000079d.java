package com.bugsnag.android;

import android.content.Context;
import com.bugsnag.android.o0;
import com.bugsnag.android.o0.a;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileStore.java */
/* loaded from: classes.dex */
public abstract class i0<T extends o0.a> {
    protected final s a;

    /* renamed from: b  reason: collision with root package name */
    final String f3655b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3656c;

    /* renamed from: d  reason: collision with root package name */
    private final Comparator<File> f3657d;

    /* renamed from: e  reason: collision with root package name */
    final Lock f3658e = new ReentrantLock();

    /* renamed from: f  reason: collision with root package name */
    final Collection<File> f3659f = new ConcurrentSkipListSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0(s sVar, Context context, String str, int i2, Comparator<File> comparator) {
        this.a = sVar;
        this.f3656c = i2;
        this.f3657d = comparator;
        String str2 = null;
        try {
            String str3 = context.getCacheDir().getAbsolutePath() + str;
            File file = new File(str3);
            file.mkdirs();
            if (file.exists()) {
                str2 = str3;
            } else {
                q0.d("Could not prepare file storage directory");
            }
        } catch (Exception e2) {
            q0.e("Could not prepare file storage directory", e2);
        }
        this.f3655b = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Collection<File> collection) {
        this.f3658e.lock();
        if (collection != null) {
            try {
                this.f3659f.removeAll(collection);
            } finally {
                this.f3658e.unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Collection<File> collection) {
        this.f3658e.lock();
        if (collection != null) {
            try {
                this.f3659f.removeAll(collection);
                for (File file : collection) {
                    if (!file.delete()) {
                        file.deleteOnExit();
                    }
                }
            } finally {
                this.f3658e.unlock();
            }
        }
    }

    void c() {
        File[] listFiles;
        File file = new File(this.f3655b);
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length < this.f3656c) {
            return;
        }
        Arrays.sort(listFiles, this.f3657d);
        for (int i2 = 0; i2 < listFiles.length && listFiles.length >= this.f3656c; i2++) {
            File file2 = listFiles[i2];
            if (!this.f3659f.contains(file2)) {
                q0.d(String.format("Discarding oldest error as stored error limit reached (%s)", file2.getPath()));
                b(Collections.singleton(file2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        String format;
        if (this.f3655b == null) {
            return;
        }
        String f2 = f(str);
        c();
        this.f3658e.lock();
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f2), "UTF-8"));
                try {
                    bufferedWriter2.write(str);
                } catch (Exception e2) {
                    e = e2;
                    bufferedWriter = bufferedWriter2;
                    q0.e(String.format("Couldn't save unsent payload to disk (%s) ", f2), e);
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (Exception e3) {
                            e = e3;
                            format = String.format("Failed to close unsent payload writer (%s) ", f2);
                            q0.e(format, e);
                            this.f3658e.unlock();
                        }
                    }
                    this.f3658e.unlock();
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (Exception e4) {
                            q0.e(String.format("Failed to close unsent payload writer (%s) ", f2), e4);
                        }
                    }
                    this.f3658e.unlock();
                    throw th;
                }
                try {
                    bufferedWriter2.close();
                } catch (Exception e5) {
                    e = e5;
                    format = String.format("Failed to close unsent payload writer (%s) ", f2);
                    q0.e(format, e);
                    this.f3658e.unlock();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
        this.f3658e.unlock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<File> e() {
        File[] listFiles;
        this.f3658e.lock();
        try {
            ArrayList arrayList = new ArrayList();
            if (this.f3655b != null) {
                File file = new File(this.f3655b);
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        if (file2.isFile() && !this.f3659f.contains(file2)) {
                            arrayList.add(file2);
                        }
                    }
                }
            }
            this.f3659f.addAll(arrayList);
            return arrayList;
        } finally {
            this.f3658e.unlock();
        }
    }

    abstract String f(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g(o0.a aVar) {
        o0 o0Var;
        o0 o0Var2 = null;
        if (this.f3655b == null) {
            return null;
        }
        c();
        String f2 = f(aVar);
        this.f3658e.lock();
        try {
            o0Var = new o0(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f2), "UTF-8")));
        } catch (Exception e2) {
            e = e2;
            o0Var = null;
        } catch (Throwable th) {
            th = th;
            l0.b(o0Var2);
            this.f3658e.unlock();
            throw th;
        }
        try {
            try {
                o0Var.n0(aVar);
                q0.b(String.format("Saved unsent payload to disk (%s) ", f2));
                l0.b(o0Var);
                this.f3658e.unlock();
                return f2;
            } catch (Throwable th2) {
                th = th2;
                o0Var2 = o0Var;
                l0.b(o0Var2);
                this.f3658e.unlock();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            q0.e(String.format("Couldn't save unsent payload to disk (%s) ", f2), e);
            l0.b(o0Var);
            this.f3658e.unlock();
            return null;
        }
    }
}