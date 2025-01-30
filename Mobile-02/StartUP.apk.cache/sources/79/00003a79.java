package com.google.firebase.crashlytics.c.l;

import com.coinbase.ApiConstants;
import com.google.firebase.crashlytics.c.g.n;
import com.google.firebase.crashlytics.c.i.v;
import com.google.firebase.crashlytics.c.i.w;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class g {
    private static final Charset a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    private static final int f8980b = 15;

    /* renamed from: c  reason: collision with root package name */
    private static final com.google.firebase.crashlytics.c.i.x.h f8981c = new com.google.firebase.crashlytics.c.i.x.h();

    /* renamed from: d  reason: collision with root package name */
    private static final Comparator<? super File> f8982d = e.a();

    /* renamed from: e  reason: collision with root package name */
    private static final FilenameFilter f8983e = f.a();

    /* renamed from: f  reason: collision with root package name */
    private final AtomicInteger f8984f = new AtomicInteger(0);

    /* renamed from: g  reason: collision with root package name */
    private final File f8985g;

    /* renamed from: h  reason: collision with root package name */
    private final File f8986h;

    /* renamed from: i  reason: collision with root package name */
    private final File f8987i;

    /* renamed from: j  reason: collision with root package name */
    private final File f8988j;

    /* renamed from: k  reason: collision with root package name */
    private final com.google.firebase.crashlytics.c.p.e f8989k;

    public g(File file, com.google.firebase.crashlytics.c.p.e eVar) {
        File file2 = new File(file, "report-persistence");
        this.f8985g = new File(file2, "sessions");
        this.f8986h = new File(file2, "priority-reports");
        this.f8987i = new File(file2, "reports");
        this.f8988j = new File(file2, "native-reports");
        this.f8989k = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int A(File file, File file2) {
        return o(file.getName()).compareTo(o(file2.getName()));
    }

    private static File E(File file) throws IOException {
        if (z(file)) {
            return file;
        }
        throw new IOException("Could not create directory " + file);
    }

    private static String F(File file) throws IOException {
        byte[] bArr = new byte[PKIFailureInfo.certRevoked];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray(), a);
                    a(null, fileInputStream);
                    return str;
                }
            } finally {
            }
        }
    }

    private static void G(File file) {
        if (file == null) {
            return;
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                G(file2);
            }
        }
        file.delete();
    }

    private static List<File> H(List<File>... listArr) {
        for (List<File> list : listArr) {
            Collections.sort(list, f8982d);
        }
        return g(listArr);
    }

    private static void I(File file, File file2, v.c cVar, String str) {
        try {
            com.google.firebase.crashlytics.c.i.x.h hVar = f8981c;
            M(new File(E(file2), str), hVar.F(hVar.E(F(file)).n(cVar)));
        } catch (IOException e2) {
            com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
            f2.c("Could not synthesize final native report file for " + file, e2);
        }
    }

    private void J(File file, long j2) {
        boolean z;
        List<File> q = q(file, f8983e);
        if (q.isEmpty()) {
            return;
        }
        Collections.sort(q);
        ArrayList arrayList = new ArrayList();
        loop0: while (true) {
            z = false;
            for (File file2 : q) {
                try {
                    arrayList.add(f8981c.i(F(file2)));
                } catch (IOException e2) {
                    com.google.firebase.crashlytics.c.b.f().c("Could not add event to report for " + file2, e2);
                }
                if (z || s(file2.getName())) {
                    z = true;
                }
            }
        }
        String str = null;
        try {
            str = F(new File(file, ApiConstants.USER));
        } catch (IOException e3) {
            com.google.firebase.crashlytics.c.b.f().c("Could not read user ID file in " + file.getName(), e3);
        }
        K(new File(file, "report"), z ? this.f8986h : this.f8987i, arrayList, j2, z, str);
    }

    private static void K(File file, File file2, List<v.d.AbstractC0173d> list, long j2, boolean z, String str) {
        try {
            com.google.firebase.crashlytics.c.i.x.h hVar = f8981c;
            v m = hVar.E(F(file)).o(j2, z, str).m(w.h(list));
            v.d j3 = m.j();
            if (j3 == null) {
                return;
            }
            M(new File(E(file2), j3.h()), hVar.F(m));
        } catch (IOException e2) {
            com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
            f2.c("Could not synthesize final report file for " + file, e2);
        }
    }

    private static int L(File file, int i2) {
        List<File> q = q(file, c.a());
        Collections.sort(q, d.a());
        return e(q, i2);
    }

    private static void M(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), a);
        try {
            outputStreamWriter.write(str);
            a(null, outputStreamWriter);
        } finally {
        }
    }

    private static /* synthetic */ void a(Throwable th, AutoCloseable autoCloseable) {
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable unused) {
        }
    }

    private List<File> d(String str) {
        List<File> p = p(this.f8985g, b.a(str));
        Collections.sort(p, f8982d);
        if (p.size() <= 8) {
            return p;
        }
        for (File file : p.subList(8, p.size())) {
            G(file);
        }
        return p.subList(0, 8);
    }

    private static int e(List<File> list, int i2) {
        int size = list.size();
        for (File file : list) {
            if (size <= i2) {
                return size;
            }
            G(file);
            size--;
        }
        return size;
    }

    private void f() {
        int i2 = this.f8989k.b().b().f9056b;
        List<File> n = n();
        int size = n.size();
        if (size <= i2) {
            return;
        }
        for (File file : n.subList(i2, size)) {
            file.delete();
        }
    }

    private static List<File> g(List<File>... listArr) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (List<File> list : listArr) {
            i2 += list.size();
        }
        arrayList.ensureCapacity(i2);
        for (List<File> list2 : listArr) {
            arrayList.addAll(list2);
        }
        return arrayList;
    }

    private static String l(int i2, boolean z) {
        String format = String.format(Locale.US, "%010d", Integer.valueOf(i2));
        String str = z ? "_" : "";
        return "event" + format + str;
    }

    private static List<File> m(File file) {
        return p(file, null);
    }

    private List<File> n() {
        return H(g(m(this.f8986h), m(this.f8988j)), m(this.f8987i));
    }

    private static String o(String str) {
        return str.substring(0, f8980b);
    }

    private static List<File> p(File file, FileFilter fileFilter) {
        if (!file.isDirectory()) {
            return Collections.emptyList();
        }
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        return listFiles != null ? Arrays.asList(listFiles) : Collections.emptyList();
    }

    private static List<File> q(File file, FilenameFilter filenameFilter) {
        if (!file.isDirectory()) {
            return Collections.emptyList();
        }
        File[] listFiles = filenameFilter == null ? file.listFiles() : file.listFiles(filenameFilter);
        return listFiles != null ? Arrays.asList(listFiles) : Collections.emptyList();
    }

    private File r(String str) {
        return new File(this.f8985g, str);
    }

    private static boolean s(String str) {
        return str.startsWith("event") && str.endsWith("_");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean t(File file, String str) {
        return str.startsWith("event") && !str.endsWith("_");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean u(String str, File file) {
        return file.isDirectory() && !file.getName().equals(str);
    }

    private static boolean z(File file) {
        return file.exists() || file.mkdirs();
    }

    public void B(v.d.AbstractC0173d abstractC0173d, String str, boolean z) {
        int i2 = this.f8989k.b().b().a;
        File r = r(str);
        try {
            M(new File(r, l(this.f8984f.getAndIncrement(), z)), f8981c.j(abstractC0173d));
        } catch (IOException e2) {
            com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
            f2.c("Could not persist event for session " + str, e2);
        }
        L(r, i2);
    }

    public void C(v vVar) {
        v.d j2 = vVar.j();
        if (j2 == null) {
            com.google.firebase.crashlytics.c.b.f().b("Could not get session for report");
            return;
        }
        String h2 = j2.h();
        try {
            File E = E(r(h2));
            M(new File(E, "report"), f8981c.F(vVar));
        } catch (IOException e2) {
            com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
            f2.c("Could not persist report for session " + h2, e2);
        }
    }

    public void D(String str, String str2) {
        try {
            M(new File(r(str2), ApiConstants.USER), str);
        } catch (IOException e2) {
            com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
            f2.c("Could not persist user ID for session " + str2, e2);
        }
    }

    public void h() {
        for (File file : n()) {
            file.delete();
        }
    }

    public void i(String str) {
        FilenameFilter a2 = a.a(str);
        for (File file : g(q(this.f8986h, a2), q(this.f8988j, a2), q(this.f8987i, a2))) {
            file.delete();
        }
    }

    public void j(String str, long j2) {
        for (File file : d(str)) {
            J(file, j2);
            G(file);
        }
        f();
    }

    public void k(String str, v.c cVar) {
        I(new File(r(str), "report"), this.f8988j, cVar, str);
    }

    public List<n> y() {
        List<File> n = n();
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(n.size());
        for (File file : n()) {
            try {
                arrayList.add(n.a(f8981c.E(F(file)), file.getName()));
            } catch (IOException e2) {
                com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
                f2.c("Could not load report file " + file + "; deleting", e2);
                file.delete();
            }
        }
        return arrayList;
    }
}