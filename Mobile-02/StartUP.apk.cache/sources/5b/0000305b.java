package com.facebook.soloader;

import android.content.Context;
import com.facebook.soloader.n;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: ExtractFromZipSoSource.java */
/* loaded from: classes2.dex */
public class f extends n {

    /* renamed from: g  reason: collision with root package name */
    protected final File f5621g;

    /* renamed from: h  reason: collision with root package name */
    protected final String f5622h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ExtractFromZipSoSource.java */
    /* loaded from: classes2.dex */
    public static final class b extends n.b implements Comparable {

        /* renamed from: c  reason: collision with root package name */
        final ZipEntry f5623c;

        /* renamed from: d  reason: collision with root package name */
        final int f5624d;

        b(String str, ZipEntry zipEntry, int i2) {
            super(str, h(zipEntry));
            this.f5623c = zipEntry;
            this.f5624d = i2;
        }

        private static String h(ZipEntry zipEntry) {
            return String.format("pseudo-zip-hash-1-%s-%s-%s-%s", zipEntry.getName(), Long.valueOf(zipEntry.getSize()), Long.valueOf(zipEntry.getCompressedSize()), Long.valueOf(zipEntry.getCrc()));
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.a.compareTo(((b) obj).a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: ExtractFromZipSoSource.java */
    /* loaded from: classes2.dex */
    public class c extends n.f {
        private b[] a;

        /* renamed from: b  reason: collision with root package name */
        private final ZipFile f5625b;

        /* renamed from: c  reason: collision with root package name */
        private final n f5626c;

        /* compiled from: ExtractFromZipSoSource.java */
        /* loaded from: classes2.dex */
        private final class a extends n.e {
            private int a;

            private a() {
            }

            @Override // com.facebook.soloader.n.e
            public boolean a() {
                c.this.e();
                return this.a < c.this.a.length;
            }

            @Override // com.facebook.soloader.n.e
            public n.d b() throws IOException {
                c.this.e();
                b[] bVarArr = c.this.a;
                int i2 = this.a;
                this.a = i2 + 1;
                b bVar = bVarArr[i2];
                InputStream inputStream = c.this.f5625b.getInputStream(bVar.f5623c);
                try {
                    return new n.d(bVar, inputStream);
                } catch (Throwable th) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(n nVar) throws IOException {
            this.f5625b = new ZipFile(f.this.f5621g);
            this.f5626c = nVar;
        }

        @Override // com.facebook.soloader.n.f
        protected final n.c a() throws IOException {
            return new n.c(e());
        }

        @Override // com.facebook.soloader.n.f
        protected final n.e b() throws IOException {
            return new a();
        }

        @Override // com.facebook.soloader.n.f, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f5625b.close();
        }

        final b[] e() {
            if (this.a == null) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                HashMap hashMap = new HashMap();
                Pattern compile = Pattern.compile(f.this.f5622h);
                String[] g2 = SysUtil.g();
                Enumeration<? extends ZipEntry> entries = this.f5625b.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    Matcher matcher = compile.matcher(nextElement.getName());
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        String group2 = matcher.group(2);
                        int d2 = SysUtil.d(g2, group);
                        if (d2 >= 0) {
                            linkedHashSet.add(group);
                            b bVar = (b) hashMap.get(group2);
                            if (bVar == null || d2 < bVar.f5624d) {
                                hashMap.put(group2, new b(group2, nextElement, d2));
                            }
                        }
                    }
                }
                this.f5626c.q((String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]));
                b[] bVarArr = (b[]) hashMap.values().toArray(new b[hashMap.size()]);
                Arrays.sort(bVarArr);
                int i2 = 0;
                for (int i3 = 0; i3 < bVarArr.length; i3++) {
                    b bVar2 = bVarArr[i3];
                    if (f(bVar2.f5623c, bVar2.a)) {
                        i2++;
                    } else {
                        bVarArr[i3] = null;
                    }
                }
                b[] bVarArr2 = new b[i2];
                int i4 = 0;
                for (b bVar3 : bVarArr) {
                    if (bVar3 != null) {
                        bVarArr2[i4] = bVar3;
                        i4++;
                    }
                }
                this.a = bVarArr2;
            }
            return this.a;
        }

        protected boolean f(ZipEntry zipEntry, String str) {
            throw null;
        }
    }

    public f(Context context, String str, File file, String str2) {
        super(context, str);
        this.f5621g = file;
        this.f5622h = str2;
    }
}