package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.t0;
import com.google.android.gms.internal.measurement.w0;
import com.google.android.gms.internal.measurement.x0;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public class j9 implements z5 {
    private static volatile j9 a;

    /* renamed from: b  reason: collision with root package name */
    private w4 f7686b;

    /* renamed from: c  reason: collision with root package name */
    private e4 f7687c;

    /* renamed from: d  reason: collision with root package name */
    private e f7688d;

    /* renamed from: e  reason: collision with root package name */
    private i4 f7689e;

    /* renamed from: f  reason: collision with root package name */
    private e9 f7690f;

    /* renamed from: g  reason: collision with root package name */
    private aa f7691g;

    /* renamed from: h  reason: collision with root package name */
    private final r9 f7692h;

    /* renamed from: i  reason: collision with root package name */
    private m7 f7693i;

    /* renamed from: j  reason: collision with root package name */
    private final b5 f7694j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f7695k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f7696l;
    private long m;
    private List<Runnable> n;
    private int o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private FileLock t;
    private FileChannel u;
    private List<Long> v;
    private List<Long> w;
    private long x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public class a implements g {
        com.google.android.gms.internal.measurement.x0 a;

        /* renamed from: b  reason: collision with root package name */
        List<Long> f7697b;

        /* renamed from: c  reason: collision with root package name */
        List<com.google.android.gms.internal.measurement.t0> f7698c;

        /* renamed from: d  reason: collision with root package name */
        private long f7699d;

        private a() {
        }

        private static long c(com.google.android.gms.internal.measurement.t0 t0Var) {
            return ((t0Var.V() / 1000) / 60) / 60;
        }

        @Override // com.google.android.gms.measurement.internal.g
        public final void a(com.google.android.gms.internal.measurement.x0 x0Var) {
            com.google.android.gms.common.internal.t.k(x0Var);
            this.a = x0Var;
        }

        @Override // com.google.android.gms.measurement.internal.g
        public final boolean b(long j2, com.google.android.gms.internal.measurement.t0 t0Var) {
            com.google.android.gms.common.internal.t.k(t0Var);
            if (this.f7698c == null) {
                this.f7698c = new ArrayList();
            }
            if (this.f7697b == null) {
                this.f7697b = new ArrayList();
            }
            if (this.f7698c.size() <= 0 || c(this.f7698c.get(0)) == c(t0Var)) {
                long i2 = this.f7699d + t0Var.i();
                if (i2 >= Math.max(0, r.f7838j.a(null).intValue())) {
                    return false;
                }
                this.f7699d = i2;
                this.f7698c.add(t0Var);
                this.f7697b.add(Long.valueOf(j2));
                return this.f7698c.size() < Math.max(1, r.f7839k.a(null).intValue());
            }
            return false;
        }

        /* synthetic */ a(j9 j9Var, m9 m9Var) {
            this();
        }
    }

    private j9(p9 p9Var) {
        this(p9Var, null);
    }

    private final boolean C(int i2, FileChannel fileChannel) {
        i0();
        if (fileChannel != null && fileChannel.isOpen()) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(i2);
            allocate.flip();
            try {
                fileChannel.truncate(0L);
                if (this.f7694j.y().u(r.C0) && Build.VERSION.SDK_INT <= 19) {
                    fileChannel.position(0L);
                }
                fileChannel.write(allocate);
                fileChannel.force(true);
                if (fileChannel.size() != 4) {
                    this.f7694j.f().H().b("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
                }
                return true;
            } catch (IOException e2) {
                this.f7694j.f().H().b("Failed to write to channel", e2);
                return false;
            }
        }
        this.f7694j.f().H().a("Bad channel to read from");
        return false;
    }

    private final boolean D(t0.a aVar, t0.a aVar2) {
        com.google.android.gms.common.internal.t.a("_e".equals(aVar.I()));
        Y();
        com.google.android.gms.internal.measurement.v0 A = r9.A((com.google.android.gms.internal.measurement.t0) ((com.google.android.gms.internal.measurement.n4) aVar.j()), "_sc");
        String S = A == null ? null : A.S();
        Y();
        com.google.android.gms.internal.measurement.v0 A2 = r9.A((com.google.android.gms.internal.measurement.t0) ((com.google.android.gms.internal.measurement.n4) aVar2.j()), "_pc");
        String S2 = A2 != null ? A2.S() : null;
        if (S2 == null || !S2.equals(S)) {
            return false;
        }
        J(aVar, aVar2);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0256 A[Catch: all -> 0x0f36, TryCatch #6 {all -> 0x0f36, blocks: (B:3:0x000d, B:21:0x0082, B:93:0x0246, B:95:0x024a, B:101:0x0256, B:102:0x027d, B:105:0x0295, B:108:0x02bb, B:110:0x02f2, B:116:0x0308, B:118:0x0312, B:300:0x088e, B:120:0x0338, B:123:0x0350, B:152:0x03b3, B:155:0x03bd, B:157:0x03cb, B:162:0x0418, B:158:0x03ea, B:160:0x03f9, B:166:0x0425, B:169:0x045e, B:171:0x048f, B:173:0x04c3, B:175:0x04c9, B:178:0x04d5, B:180:0x050a, B:181:0x0527, B:183:0x052d, B:185:0x053b, B:189:0x054f, B:186:0x0544, B:192:0x0556, B:194:0x055c, B:195:0x057a, B:197:0x0595, B:198:0x05a1, B:201:0x05ab, B:207:0x05ce, B:204:0x05bd, B:210:0x05d4, B:212:0x05e0, B:214:0x05ec, B:230:0x063b, B:233:0x0658, B:235:0x066c, B:237:0x0679, B:240:0x068c, B:242:0x069e, B:244:0x06ac, B:289:0x0813, B:291:0x081d, B:293:0x0823, B:294:0x083d, B:296:0x0851, B:297:0x086b, B:299:0x0874, B:249:0x06d2, B:251:0x06e2, B:254:0x06f7, B:256:0x0709, B:258:0x0717, B:261:0x072a, B:263:0x0742, B:265:0x074e, B:268:0x0761, B:270:0x0775, B:272:0x07c0, B:274:0x07c7, B:276:0x07cd, B:278:0x07d8, B:280:0x07df, B:282:0x07e5, B:284:0x07f0, B:285:0x0801, B:218:0x060d, B:222:0x0621, B:224:0x0627, B:227:0x0632, B:130:0x0372, B:133:0x037c, B:136:0x0386, B:305:0x08a8, B:307:0x08b6, B:309:0x08bf, B:320:0x08f1, B:310:0x08c7, B:312:0x08d0, B:314:0x08d6, B:317:0x08e2, B:319:0x08ec, B:323:0x08f8, B:324:0x0904, B:326:0x090a, B:332:0x0923, B:333:0x092e, B:338:0x093b, B:342:0x0962, B:344:0x0981, B:346:0x098f, B:348:0x0995, B:350:0x099f, B:351:0x09d1, B:353:0x09d7, B:355:0x09e5, B:359:0x09f0, B:356:0x09ea, B:360:0x09f3, B:362:0x0a05, B:363:0x0a08, B:371:0x0a78, B:373:0x0a94, B:374:0x0aa5, B:376:0x0aa9, B:378:0x0ab5, B:379:0x0abe, B:381:0x0ac2, B:383:0x0ac8, B:384:0x0ad7, B:385:0x0ae2, B:391:0x0b22, B:392:0x0b2a, B:394:0x0b30, B:396:0x0b42, B:398:0x0b50, B:400:0x0b54, B:402:0x0b5e, B:404:0x0b62, B:410:0x0b78, B:413:0x0b8e, B:339:0x0940, B:341:0x0946, B:44:0x011a, B:58:0x01b0, B:66:0x01e8, B:73:0x0205, B:78:0x021c, B:92:0x0243, B:37:0x00d5, B:47:0x0123), top: B:550:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0595 A[Catch: all -> 0x0f36, TryCatch #6 {all -> 0x0f36, blocks: (B:3:0x000d, B:21:0x0082, B:93:0x0246, B:95:0x024a, B:101:0x0256, B:102:0x027d, B:105:0x0295, B:108:0x02bb, B:110:0x02f2, B:116:0x0308, B:118:0x0312, B:300:0x088e, B:120:0x0338, B:123:0x0350, B:152:0x03b3, B:155:0x03bd, B:157:0x03cb, B:162:0x0418, B:158:0x03ea, B:160:0x03f9, B:166:0x0425, B:169:0x045e, B:171:0x048f, B:173:0x04c3, B:175:0x04c9, B:178:0x04d5, B:180:0x050a, B:181:0x0527, B:183:0x052d, B:185:0x053b, B:189:0x054f, B:186:0x0544, B:192:0x0556, B:194:0x055c, B:195:0x057a, B:197:0x0595, B:198:0x05a1, B:201:0x05ab, B:207:0x05ce, B:204:0x05bd, B:210:0x05d4, B:212:0x05e0, B:214:0x05ec, B:230:0x063b, B:233:0x0658, B:235:0x066c, B:237:0x0679, B:240:0x068c, B:242:0x069e, B:244:0x06ac, B:289:0x0813, B:291:0x081d, B:293:0x0823, B:294:0x083d, B:296:0x0851, B:297:0x086b, B:299:0x0874, B:249:0x06d2, B:251:0x06e2, B:254:0x06f7, B:256:0x0709, B:258:0x0717, B:261:0x072a, B:263:0x0742, B:265:0x074e, B:268:0x0761, B:270:0x0775, B:272:0x07c0, B:274:0x07c7, B:276:0x07cd, B:278:0x07d8, B:280:0x07df, B:282:0x07e5, B:284:0x07f0, B:285:0x0801, B:218:0x060d, B:222:0x0621, B:224:0x0627, B:227:0x0632, B:130:0x0372, B:133:0x037c, B:136:0x0386, B:305:0x08a8, B:307:0x08b6, B:309:0x08bf, B:320:0x08f1, B:310:0x08c7, B:312:0x08d0, B:314:0x08d6, B:317:0x08e2, B:319:0x08ec, B:323:0x08f8, B:324:0x0904, B:326:0x090a, B:332:0x0923, B:333:0x092e, B:338:0x093b, B:342:0x0962, B:344:0x0981, B:346:0x098f, B:348:0x0995, B:350:0x099f, B:351:0x09d1, B:353:0x09d7, B:355:0x09e5, B:359:0x09f0, B:356:0x09ea, B:360:0x09f3, B:362:0x0a05, B:363:0x0a08, B:371:0x0a78, B:373:0x0a94, B:374:0x0aa5, B:376:0x0aa9, B:378:0x0ab5, B:379:0x0abe, B:381:0x0ac2, B:383:0x0ac8, B:384:0x0ad7, B:385:0x0ae2, B:391:0x0b22, B:392:0x0b2a, B:394:0x0b30, B:396:0x0b42, B:398:0x0b50, B:400:0x0b54, B:402:0x0b5e, B:404:0x0b62, B:410:0x0b78, B:413:0x0b8e, B:339:0x0940, B:341:0x0946, B:44:0x011a, B:58:0x01b0, B:66:0x01e8, B:73:0x0205, B:78:0x021c, B:92:0x0243, B:37:0x00d5, B:47:0x0123), top: B:550:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x066c A[Catch: all -> 0x0f36, TryCatch #6 {all -> 0x0f36, blocks: (B:3:0x000d, B:21:0x0082, B:93:0x0246, B:95:0x024a, B:101:0x0256, B:102:0x027d, B:105:0x0295, B:108:0x02bb, B:110:0x02f2, B:116:0x0308, B:118:0x0312, B:300:0x088e, B:120:0x0338, B:123:0x0350, B:152:0x03b3, B:155:0x03bd, B:157:0x03cb, B:162:0x0418, B:158:0x03ea, B:160:0x03f9, B:166:0x0425, B:169:0x045e, B:171:0x048f, B:173:0x04c3, B:175:0x04c9, B:178:0x04d5, B:180:0x050a, B:181:0x0527, B:183:0x052d, B:185:0x053b, B:189:0x054f, B:186:0x0544, B:192:0x0556, B:194:0x055c, B:195:0x057a, B:197:0x0595, B:198:0x05a1, B:201:0x05ab, B:207:0x05ce, B:204:0x05bd, B:210:0x05d4, B:212:0x05e0, B:214:0x05ec, B:230:0x063b, B:233:0x0658, B:235:0x066c, B:237:0x0679, B:240:0x068c, B:242:0x069e, B:244:0x06ac, B:289:0x0813, B:291:0x081d, B:293:0x0823, B:294:0x083d, B:296:0x0851, B:297:0x086b, B:299:0x0874, B:249:0x06d2, B:251:0x06e2, B:254:0x06f7, B:256:0x0709, B:258:0x0717, B:261:0x072a, B:263:0x0742, B:265:0x074e, B:268:0x0761, B:270:0x0775, B:272:0x07c0, B:274:0x07c7, B:276:0x07cd, B:278:0x07d8, B:280:0x07df, B:282:0x07e5, B:284:0x07f0, B:285:0x0801, B:218:0x060d, B:222:0x0621, B:224:0x0627, B:227:0x0632, B:130:0x0372, B:133:0x037c, B:136:0x0386, B:305:0x08a8, B:307:0x08b6, B:309:0x08bf, B:320:0x08f1, B:310:0x08c7, B:312:0x08d0, B:314:0x08d6, B:317:0x08e2, B:319:0x08ec, B:323:0x08f8, B:324:0x0904, B:326:0x090a, B:332:0x0923, B:333:0x092e, B:338:0x093b, B:342:0x0962, B:344:0x0981, B:346:0x098f, B:348:0x0995, B:350:0x099f, B:351:0x09d1, B:353:0x09d7, B:355:0x09e5, B:359:0x09f0, B:356:0x09ea, B:360:0x09f3, B:362:0x0a05, B:363:0x0a08, B:371:0x0a78, B:373:0x0a94, B:374:0x0aa5, B:376:0x0aa9, B:378:0x0ab5, B:379:0x0abe, B:381:0x0ac2, B:383:0x0ac8, B:384:0x0ad7, B:385:0x0ae2, B:391:0x0b22, B:392:0x0b2a, B:394:0x0b30, B:396:0x0b42, B:398:0x0b50, B:400:0x0b54, B:402:0x0b5e, B:404:0x0b62, B:410:0x0b78, B:413:0x0b8e, B:339:0x0940, B:341:0x0946, B:44:0x011a, B:58:0x01b0, B:66:0x01e8, B:73:0x0205, B:78:0x021c, B:92:0x0243, B:37:0x00d5, B:47:0x0123), top: B:550:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0807  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0813 A[Catch: all -> 0x0f36, TryCatch #6 {all -> 0x0f36, blocks: (B:3:0x000d, B:21:0x0082, B:93:0x0246, B:95:0x024a, B:101:0x0256, B:102:0x027d, B:105:0x0295, B:108:0x02bb, B:110:0x02f2, B:116:0x0308, B:118:0x0312, B:300:0x088e, B:120:0x0338, B:123:0x0350, B:152:0x03b3, B:155:0x03bd, B:157:0x03cb, B:162:0x0418, B:158:0x03ea, B:160:0x03f9, B:166:0x0425, B:169:0x045e, B:171:0x048f, B:173:0x04c3, B:175:0x04c9, B:178:0x04d5, B:180:0x050a, B:181:0x0527, B:183:0x052d, B:185:0x053b, B:189:0x054f, B:186:0x0544, B:192:0x0556, B:194:0x055c, B:195:0x057a, B:197:0x0595, B:198:0x05a1, B:201:0x05ab, B:207:0x05ce, B:204:0x05bd, B:210:0x05d4, B:212:0x05e0, B:214:0x05ec, B:230:0x063b, B:233:0x0658, B:235:0x066c, B:237:0x0679, B:240:0x068c, B:242:0x069e, B:244:0x06ac, B:289:0x0813, B:291:0x081d, B:293:0x0823, B:294:0x083d, B:296:0x0851, B:297:0x086b, B:299:0x0874, B:249:0x06d2, B:251:0x06e2, B:254:0x06f7, B:256:0x0709, B:258:0x0717, B:261:0x072a, B:263:0x0742, B:265:0x074e, B:268:0x0761, B:270:0x0775, B:272:0x07c0, B:274:0x07c7, B:276:0x07cd, B:278:0x07d8, B:280:0x07df, B:282:0x07e5, B:284:0x07f0, B:285:0x0801, B:218:0x060d, B:222:0x0621, B:224:0x0627, B:227:0x0632, B:130:0x0372, B:133:0x037c, B:136:0x0386, B:305:0x08a8, B:307:0x08b6, B:309:0x08bf, B:320:0x08f1, B:310:0x08c7, B:312:0x08d0, B:314:0x08d6, B:317:0x08e2, B:319:0x08ec, B:323:0x08f8, B:324:0x0904, B:326:0x090a, B:332:0x0923, B:333:0x092e, B:338:0x093b, B:342:0x0962, B:344:0x0981, B:346:0x098f, B:348:0x0995, B:350:0x099f, B:351:0x09d1, B:353:0x09d7, B:355:0x09e5, B:359:0x09f0, B:356:0x09ea, B:360:0x09f3, B:362:0x0a05, B:363:0x0a08, B:371:0x0a78, B:373:0x0a94, B:374:0x0aa5, B:376:0x0aa9, B:378:0x0ab5, B:379:0x0abe, B:381:0x0ac2, B:383:0x0ac8, B:384:0x0ad7, B:385:0x0ae2, B:391:0x0b22, B:392:0x0b2a, B:394:0x0b30, B:396:0x0b42, B:398:0x0b50, B:400:0x0b54, B:402:0x0b5e, B:404:0x0b62, B:410:0x0b78, B:413:0x0b8e, B:339:0x0940, B:341:0x0946, B:44:0x011a, B:58:0x01b0, B:66:0x01e8, B:73:0x0205, B:78:0x021c, B:92:0x0243, B:37:0x00d5, B:47:0x0123), top: B:550:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0823 A[Catch: all -> 0x0f36, TryCatch #6 {all -> 0x0f36, blocks: (B:3:0x000d, B:21:0x0082, B:93:0x0246, B:95:0x024a, B:101:0x0256, B:102:0x027d, B:105:0x0295, B:108:0x02bb, B:110:0x02f2, B:116:0x0308, B:118:0x0312, B:300:0x088e, B:120:0x0338, B:123:0x0350, B:152:0x03b3, B:155:0x03bd, B:157:0x03cb, B:162:0x0418, B:158:0x03ea, B:160:0x03f9, B:166:0x0425, B:169:0x045e, B:171:0x048f, B:173:0x04c3, B:175:0x04c9, B:178:0x04d5, B:180:0x050a, B:181:0x0527, B:183:0x052d, B:185:0x053b, B:189:0x054f, B:186:0x0544, B:192:0x0556, B:194:0x055c, B:195:0x057a, B:197:0x0595, B:198:0x05a1, B:201:0x05ab, B:207:0x05ce, B:204:0x05bd, B:210:0x05d4, B:212:0x05e0, B:214:0x05ec, B:230:0x063b, B:233:0x0658, B:235:0x066c, B:237:0x0679, B:240:0x068c, B:242:0x069e, B:244:0x06ac, B:289:0x0813, B:291:0x081d, B:293:0x0823, B:294:0x083d, B:296:0x0851, B:297:0x086b, B:299:0x0874, B:249:0x06d2, B:251:0x06e2, B:254:0x06f7, B:256:0x0709, B:258:0x0717, B:261:0x072a, B:263:0x0742, B:265:0x074e, B:268:0x0761, B:270:0x0775, B:272:0x07c0, B:274:0x07c7, B:276:0x07cd, B:278:0x07d8, B:280:0x07df, B:282:0x07e5, B:284:0x07f0, B:285:0x0801, B:218:0x060d, B:222:0x0621, B:224:0x0627, B:227:0x0632, B:130:0x0372, B:133:0x037c, B:136:0x0386, B:305:0x08a8, B:307:0x08b6, B:309:0x08bf, B:320:0x08f1, B:310:0x08c7, B:312:0x08d0, B:314:0x08d6, B:317:0x08e2, B:319:0x08ec, B:323:0x08f8, B:324:0x0904, B:326:0x090a, B:332:0x0923, B:333:0x092e, B:338:0x093b, B:342:0x0962, B:344:0x0981, B:346:0x098f, B:348:0x0995, B:350:0x099f, B:351:0x09d1, B:353:0x09d7, B:355:0x09e5, B:359:0x09f0, B:356:0x09ea, B:360:0x09f3, B:362:0x0a05, B:363:0x0a08, B:371:0x0a78, B:373:0x0a94, B:374:0x0aa5, B:376:0x0aa9, B:378:0x0ab5, B:379:0x0abe, B:381:0x0ac2, B:383:0x0ac8, B:384:0x0ad7, B:385:0x0ae2, B:391:0x0b22, B:392:0x0b2a, B:394:0x0b30, B:396:0x0b42, B:398:0x0b50, B:400:0x0b54, B:402:0x0b5e, B:404:0x0b62, B:410:0x0b78, B:413:0x0b8e, B:339:0x0940, B:341:0x0946, B:44:0x011a, B:58:0x01b0, B:66:0x01e8, B:73:0x0205, B:78:0x021c, B:92:0x0243, B:37:0x00d5, B:47:0x0123), top: B:550:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:294:0x083d A[Catch: all -> 0x0f36, TryCatch #6 {all -> 0x0f36, blocks: (B:3:0x000d, B:21:0x0082, B:93:0x0246, B:95:0x024a, B:101:0x0256, B:102:0x027d, B:105:0x0295, B:108:0x02bb, B:110:0x02f2, B:116:0x0308, B:118:0x0312, B:300:0x088e, B:120:0x0338, B:123:0x0350, B:152:0x03b3, B:155:0x03bd, B:157:0x03cb, B:162:0x0418, B:158:0x03ea, B:160:0x03f9, B:166:0x0425, B:169:0x045e, B:171:0x048f, B:173:0x04c3, B:175:0x04c9, B:178:0x04d5, B:180:0x050a, B:181:0x0527, B:183:0x052d, B:185:0x053b, B:189:0x054f, B:186:0x0544, B:192:0x0556, B:194:0x055c, B:195:0x057a, B:197:0x0595, B:198:0x05a1, B:201:0x05ab, B:207:0x05ce, B:204:0x05bd, B:210:0x05d4, B:212:0x05e0, B:214:0x05ec, B:230:0x063b, B:233:0x0658, B:235:0x066c, B:237:0x0679, B:240:0x068c, B:242:0x069e, B:244:0x06ac, B:289:0x0813, B:291:0x081d, B:293:0x0823, B:294:0x083d, B:296:0x0851, B:297:0x086b, B:299:0x0874, B:249:0x06d2, B:251:0x06e2, B:254:0x06f7, B:256:0x0709, B:258:0x0717, B:261:0x072a, B:263:0x0742, B:265:0x074e, B:268:0x0761, B:270:0x0775, B:272:0x07c0, B:274:0x07c7, B:276:0x07cd, B:278:0x07d8, B:280:0x07df, B:282:0x07e5, B:284:0x07f0, B:285:0x0801, B:218:0x060d, B:222:0x0621, B:224:0x0627, B:227:0x0632, B:130:0x0372, B:133:0x037c, B:136:0x0386, B:305:0x08a8, B:307:0x08b6, B:309:0x08bf, B:320:0x08f1, B:310:0x08c7, B:312:0x08d0, B:314:0x08d6, B:317:0x08e2, B:319:0x08ec, B:323:0x08f8, B:324:0x0904, B:326:0x090a, B:332:0x0923, B:333:0x092e, B:338:0x093b, B:342:0x0962, B:344:0x0981, B:346:0x098f, B:348:0x0995, B:350:0x099f, B:351:0x09d1, B:353:0x09d7, B:355:0x09e5, B:359:0x09f0, B:356:0x09ea, B:360:0x09f3, B:362:0x0a05, B:363:0x0a08, B:371:0x0a78, B:373:0x0a94, B:374:0x0aa5, B:376:0x0aa9, B:378:0x0ab5, B:379:0x0abe, B:381:0x0ac2, B:383:0x0ac8, B:384:0x0ad7, B:385:0x0ae2, B:391:0x0b22, B:392:0x0b2a, B:394:0x0b30, B:396:0x0b42, B:398:0x0b50, B:400:0x0b54, B:402:0x0b5e, B:404:0x0b62, B:410:0x0b78, B:413:0x0b8e, B:339:0x0940, B:341:0x0946, B:44:0x011a, B:58:0x01b0, B:66:0x01e8, B:73:0x0205, B:78:0x021c, B:92:0x0243, B:37:0x00d5, B:47:0x0123), top: B:550:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:526:0x0f19  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0243 A[Catch: all -> 0x0f36, TRY_ENTER, TryCatch #6 {all -> 0x0f36, blocks: (B:3:0x000d, B:21:0x0082, B:93:0x0246, B:95:0x024a, B:101:0x0256, B:102:0x027d, B:105:0x0295, B:108:0x02bb, B:110:0x02f2, B:116:0x0308, B:118:0x0312, B:300:0x088e, B:120:0x0338, B:123:0x0350, B:152:0x03b3, B:155:0x03bd, B:157:0x03cb, B:162:0x0418, B:158:0x03ea, B:160:0x03f9, B:166:0x0425, B:169:0x045e, B:171:0x048f, B:173:0x04c3, B:175:0x04c9, B:178:0x04d5, B:180:0x050a, B:181:0x0527, B:183:0x052d, B:185:0x053b, B:189:0x054f, B:186:0x0544, B:192:0x0556, B:194:0x055c, B:195:0x057a, B:197:0x0595, B:198:0x05a1, B:201:0x05ab, B:207:0x05ce, B:204:0x05bd, B:210:0x05d4, B:212:0x05e0, B:214:0x05ec, B:230:0x063b, B:233:0x0658, B:235:0x066c, B:237:0x0679, B:240:0x068c, B:242:0x069e, B:244:0x06ac, B:289:0x0813, B:291:0x081d, B:293:0x0823, B:294:0x083d, B:296:0x0851, B:297:0x086b, B:299:0x0874, B:249:0x06d2, B:251:0x06e2, B:254:0x06f7, B:256:0x0709, B:258:0x0717, B:261:0x072a, B:263:0x0742, B:265:0x074e, B:268:0x0761, B:270:0x0775, B:272:0x07c0, B:274:0x07c7, B:276:0x07cd, B:278:0x07d8, B:280:0x07df, B:282:0x07e5, B:284:0x07f0, B:285:0x0801, B:218:0x060d, B:222:0x0621, B:224:0x0627, B:227:0x0632, B:130:0x0372, B:133:0x037c, B:136:0x0386, B:305:0x08a8, B:307:0x08b6, B:309:0x08bf, B:320:0x08f1, B:310:0x08c7, B:312:0x08d0, B:314:0x08d6, B:317:0x08e2, B:319:0x08ec, B:323:0x08f8, B:324:0x0904, B:326:0x090a, B:332:0x0923, B:333:0x092e, B:338:0x093b, B:342:0x0962, B:344:0x0981, B:346:0x098f, B:348:0x0995, B:350:0x099f, B:351:0x09d1, B:353:0x09d7, B:355:0x09e5, B:359:0x09f0, B:356:0x09ea, B:360:0x09f3, B:362:0x0a05, B:363:0x0a08, B:371:0x0a78, B:373:0x0a94, B:374:0x0aa5, B:376:0x0aa9, B:378:0x0ab5, B:379:0x0abe, B:381:0x0ac2, B:383:0x0ac8, B:384:0x0ad7, B:385:0x0ae2, B:391:0x0b22, B:392:0x0b2a, B:394:0x0b30, B:396:0x0b42, B:398:0x0b50, B:400:0x0b54, B:402:0x0b5e, B:404:0x0b62, B:410:0x0b78, B:413:0x0b8e, B:339:0x0940, B:341:0x0946, B:44:0x011a, B:58:0x01b0, B:66:0x01e8, B:73:0x0205, B:78:0x021c, B:92:0x0243, B:37:0x00d5, B:47:0x0123), top: B:550:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x024a A[Catch: all -> 0x0f36, TryCatch #6 {all -> 0x0f36, blocks: (B:3:0x000d, B:21:0x0082, B:93:0x0246, B:95:0x024a, B:101:0x0256, B:102:0x027d, B:105:0x0295, B:108:0x02bb, B:110:0x02f2, B:116:0x0308, B:118:0x0312, B:300:0x088e, B:120:0x0338, B:123:0x0350, B:152:0x03b3, B:155:0x03bd, B:157:0x03cb, B:162:0x0418, B:158:0x03ea, B:160:0x03f9, B:166:0x0425, B:169:0x045e, B:171:0x048f, B:173:0x04c3, B:175:0x04c9, B:178:0x04d5, B:180:0x050a, B:181:0x0527, B:183:0x052d, B:185:0x053b, B:189:0x054f, B:186:0x0544, B:192:0x0556, B:194:0x055c, B:195:0x057a, B:197:0x0595, B:198:0x05a1, B:201:0x05ab, B:207:0x05ce, B:204:0x05bd, B:210:0x05d4, B:212:0x05e0, B:214:0x05ec, B:230:0x063b, B:233:0x0658, B:235:0x066c, B:237:0x0679, B:240:0x068c, B:242:0x069e, B:244:0x06ac, B:289:0x0813, B:291:0x081d, B:293:0x0823, B:294:0x083d, B:296:0x0851, B:297:0x086b, B:299:0x0874, B:249:0x06d2, B:251:0x06e2, B:254:0x06f7, B:256:0x0709, B:258:0x0717, B:261:0x072a, B:263:0x0742, B:265:0x074e, B:268:0x0761, B:270:0x0775, B:272:0x07c0, B:274:0x07c7, B:276:0x07cd, B:278:0x07d8, B:280:0x07df, B:282:0x07e5, B:284:0x07f0, B:285:0x0801, B:218:0x060d, B:222:0x0621, B:224:0x0627, B:227:0x0632, B:130:0x0372, B:133:0x037c, B:136:0x0386, B:305:0x08a8, B:307:0x08b6, B:309:0x08bf, B:320:0x08f1, B:310:0x08c7, B:312:0x08d0, B:314:0x08d6, B:317:0x08e2, B:319:0x08ec, B:323:0x08f8, B:324:0x0904, B:326:0x090a, B:332:0x0923, B:333:0x092e, B:338:0x093b, B:342:0x0962, B:344:0x0981, B:346:0x098f, B:348:0x0995, B:350:0x099f, B:351:0x09d1, B:353:0x09d7, B:355:0x09e5, B:359:0x09f0, B:356:0x09ea, B:360:0x09f3, B:362:0x0a05, B:363:0x0a08, B:371:0x0a78, B:373:0x0a94, B:374:0x0aa5, B:376:0x0aa9, B:378:0x0ab5, B:379:0x0abe, B:381:0x0ac2, B:383:0x0ac8, B:384:0x0ad7, B:385:0x0ae2, B:391:0x0b22, B:392:0x0b2a, B:394:0x0b30, B:396:0x0b42, B:398:0x0b50, B:400:0x0b54, B:402:0x0b5e, B:404:0x0b62, B:410:0x0b78, B:413:0x0b8e, B:339:0x0940, B:341:0x0946, B:44:0x011a, B:58:0x01b0, B:66:0x01e8, B:73:0x0205, B:78:0x021c, B:92:0x0243, B:37:0x00d5, B:47:0x0123), top: B:550:0x000d, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean E(java.lang.String r44, long r45) {
        /*
            Method dump skipped, instructions count: 3905
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.j9.E(java.lang.String, long):boolean");
    }

    private final void F() {
        i0();
        if (!this.q && !this.r && !this.s) {
            this.f7694j.f().P().a("Stopping uploading service(s)");
            List<Runnable> list = this.n;
            if (list == null) {
                return;
            }
            for (Runnable runnable : list) {
                runnable.run();
            }
            this.n.clear();
            return;
        }
        this.f7694j.f().P().d("Not stopping services. fetch, network, upload", Boolean.valueOf(this.q), Boolean.valueOf(this.r), Boolean.valueOf(this.s));
    }

    private final boolean G() {
        FileLock fileLock;
        i0();
        if (this.f7694j.y().u(r.p0) && (fileLock = this.t) != null && fileLock.isValid()) {
            this.f7694j.f().P().a("Storage concurrent access okay");
            return true;
        }
        try {
            FileChannel channel = new RandomAccessFile(new File(this.f7694j.h().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.u = channel;
            FileLock tryLock = channel.tryLock();
            this.t = tryLock;
            if (tryLock != null) {
                this.f7694j.f().P().a("Storage concurrent access okay");
                return true;
            }
            this.f7694j.f().H().a("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e2) {
            this.f7694j.f().H().b("Failed to acquire storage lock", e2);
            return false;
        } catch (IOException e3) {
            this.f7694j.f().H().b("Failed to access storage lock file", e3);
            return false;
        } catch (OverlappingFileLockException e4) {
            this.f7694j.f().K().b("Storage lock already acquired", e4);
            return false;
        }
    }

    private final Boolean I(f4 f4Var) {
        try {
            if (f4Var.V() != -2147483648L) {
                if (f4Var.V() == com.google.android.gms.common.n.c.a(this.f7694j.h()).e(f4Var.t(), 0).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = com.google.android.gms.common.n.c.a(this.f7694j.h()).e(f4Var.t(), 0).versionName;
                if (f4Var.T() != null && f4Var.T().equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final void J(t0.a aVar, t0.a aVar2) {
        com.google.android.gms.common.internal.t.a("_e".equals(aVar.I()));
        Y();
        com.google.android.gms.internal.measurement.v0 A = r9.A((com.google.android.gms.internal.measurement.t0) ((com.google.android.gms.internal.measurement.n4) aVar.j()), "_et");
        if (!A.V() || A.W() <= 0) {
            return;
        }
        long W = A.W();
        Y();
        com.google.android.gms.internal.measurement.v0 A2 = r9.A((com.google.android.gms.internal.measurement.t0) ((com.google.android.gms.internal.measurement.n4) aVar2.j()), "_et");
        if (A2 != null && A2.W() > 0) {
            W += A2.W();
        }
        Y().J(aVar2, "_et", Long.valueOf(W));
        Y().J(aVar, "_fr", 1L);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:96|(1:98)(1:294)|99|(2:101|(1:103)(6:104|105|106|(1:108)|109|(0)))|286|287|288|289|105|106|(0)|109|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0355, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0357, code lost:
        r7.f().H().c("Error pruning currencies. appId", com.google.android.gms.measurement.internal.x3.y(r15), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0958, code lost:
        r11 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x038d A[Catch: all -> 0x09e9, TryCatch #1 {all -> 0x09e9, blocks: (B:48:0x01e7, B:50:0x01f0, B:54:0x0201, B:58:0x020f, B:60:0x0219, B:65:0x0225, B:72:0x0237, B:75:0x0243, B:77:0x025a, B:82:0x0273, B:84:0x027d, B:86:0x028b, B:91:0x02bc, B:93:0x02c2, B:95:0x02d0, B:97:0x02d8, B:99:0x02e2, B:101:0x02ed, B:104:0x02f4, B:113:0x0383, B:115:0x038d, B:119:0x03c4, B:123:0x03d6, B:125:0x03ea, B:127:0x03fa, B:129:0x040b, B:131:0x043d, B:133:0x0442, B:134:0x045b, B:138:0x046c, B:140:0x0480, B:142:0x0485, B:143:0x049e, B:147:0x04c1, B:151:0x04e6, B:152:0x04ff, B:155:0x050e, B:158:0x0531, B:159:0x054d, B:161:0x0557, B:163:0x0563, B:165:0x0569, B:166:0x0574, B:168:0x0580, B:169:0x0597, B:171:0x05c1, B:174:0x05da, B:177:0x061d, B:179:0x0644, B:181:0x067e, B:182:0x0683, B:184:0x068b, B:185:0x0690, B:187:0x0698, B:188:0x069d, B:190:0x06a6, B:191:0x06aa, B:193:0x06b7, B:194:0x06bc, B:196:0x06c2, B:198:0x06d2, B:200:0x06dc, B:202:0x06e4, B:203:0x06e9, B:205:0x06f3, B:207:0x06fd, B:209:0x0705, B:215:0x0722, B:217:0x072a, B:218:0x072d, B:220:0x0742, B:222:0x074c, B:223:0x074f, B:225:0x075d, B:227:0x0767, B:229:0x076b, B:231:0x0776, B:243:0x07e2, B:245:0x082a, B:246:0x082f, B:248:0x0837, B:250:0x0840, B:251:0x0845, B:253:0x0851, B:255:0x08b5, B:256:0x08ba, B:257:0x08c6, B:259:0x08d0, B:260:0x08d7, B:262:0x08e1, B:263:0x08e8, B:264:0x08f3, B:266:0x08f9, B:268:0x092a, B:269:0x093a, B:271:0x0942, B:272:0x0946, B:274:0x094c, B:283:0x0994, B:285:0x099a, B:288:0x09b6, B:277:0x095a, B:279:0x097f, B:287:0x099e, B:232:0x0780, B:234:0x0792, B:236:0x0796, B:238:0x07a8, B:242:0x07df, B:239:0x07c2, B:241:0x07c8, B:210:0x070b, B:212:0x0715, B:214:0x071d, B:178:0x0636, B:106:0x031c, B:107:0x033a, B:112:0x0368, B:111:0x0357, B:98:0x02dd, B:89:0x0295, B:90:0x02b2), top: B:296:0x01e7, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03c4 A[Catch: all -> 0x09e9, TRY_LEAVE, TryCatch #1 {all -> 0x09e9, blocks: (B:48:0x01e7, B:50:0x01f0, B:54:0x0201, B:58:0x020f, B:60:0x0219, B:65:0x0225, B:72:0x0237, B:75:0x0243, B:77:0x025a, B:82:0x0273, B:84:0x027d, B:86:0x028b, B:91:0x02bc, B:93:0x02c2, B:95:0x02d0, B:97:0x02d8, B:99:0x02e2, B:101:0x02ed, B:104:0x02f4, B:113:0x0383, B:115:0x038d, B:119:0x03c4, B:123:0x03d6, B:125:0x03ea, B:127:0x03fa, B:129:0x040b, B:131:0x043d, B:133:0x0442, B:134:0x045b, B:138:0x046c, B:140:0x0480, B:142:0x0485, B:143:0x049e, B:147:0x04c1, B:151:0x04e6, B:152:0x04ff, B:155:0x050e, B:158:0x0531, B:159:0x054d, B:161:0x0557, B:163:0x0563, B:165:0x0569, B:166:0x0574, B:168:0x0580, B:169:0x0597, B:171:0x05c1, B:174:0x05da, B:177:0x061d, B:179:0x0644, B:181:0x067e, B:182:0x0683, B:184:0x068b, B:185:0x0690, B:187:0x0698, B:188:0x069d, B:190:0x06a6, B:191:0x06aa, B:193:0x06b7, B:194:0x06bc, B:196:0x06c2, B:198:0x06d2, B:200:0x06dc, B:202:0x06e4, B:203:0x06e9, B:205:0x06f3, B:207:0x06fd, B:209:0x0705, B:215:0x0722, B:217:0x072a, B:218:0x072d, B:220:0x0742, B:222:0x074c, B:223:0x074f, B:225:0x075d, B:227:0x0767, B:229:0x076b, B:231:0x0776, B:243:0x07e2, B:245:0x082a, B:246:0x082f, B:248:0x0837, B:250:0x0840, B:251:0x0845, B:253:0x0851, B:255:0x08b5, B:256:0x08ba, B:257:0x08c6, B:259:0x08d0, B:260:0x08d7, B:262:0x08e1, B:263:0x08e8, B:264:0x08f3, B:266:0x08f9, B:268:0x092a, B:269:0x093a, B:271:0x0942, B:272:0x0946, B:274:0x094c, B:283:0x0994, B:285:0x099a, B:288:0x09b6, B:277:0x095a, B:279:0x097f, B:287:0x099e, B:232:0x0780, B:234:0x0792, B:236:0x0796, B:238:0x07a8, B:242:0x07df, B:239:0x07c2, B:241:0x07c8, B:210:0x070b, B:212:0x0715, B:214:0x071d, B:178:0x0636, B:106:0x031c, B:107:0x033a, B:112:0x0368, B:111:0x0357, B:98:0x02dd, B:89:0x0295, B:90:0x02b2), top: B:296:0x01e7, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03ea A[Catch: all -> 0x09e9, TryCatch #1 {all -> 0x09e9, blocks: (B:48:0x01e7, B:50:0x01f0, B:54:0x0201, B:58:0x020f, B:60:0x0219, B:65:0x0225, B:72:0x0237, B:75:0x0243, B:77:0x025a, B:82:0x0273, B:84:0x027d, B:86:0x028b, B:91:0x02bc, B:93:0x02c2, B:95:0x02d0, B:97:0x02d8, B:99:0x02e2, B:101:0x02ed, B:104:0x02f4, B:113:0x0383, B:115:0x038d, B:119:0x03c4, B:123:0x03d6, B:125:0x03ea, B:127:0x03fa, B:129:0x040b, B:131:0x043d, B:133:0x0442, B:134:0x045b, B:138:0x046c, B:140:0x0480, B:142:0x0485, B:143:0x049e, B:147:0x04c1, B:151:0x04e6, B:152:0x04ff, B:155:0x050e, B:158:0x0531, B:159:0x054d, B:161:0x0557, B:163:0x0563, B:165:0x0569, B:166:0x0574, B:168:0x0580, B:169:0x0597, B:171:0x05c1, B:174:0x05da, B:177:0x061d, B:179:0x0644, B:181:0x067e, B:182:0x0683, B:184:0x068b, B:185:0x0690, B:187:0x0698, B:188:0x069d, B:190:0x06a6, B:191:0x06aa, B:193:0x06b7, B:194:0x06bc, B:196:0x06c2, B:198:0x06d2, B:200:0x06dc, B:202:0x06e4, B:203:0x06e9, B:205:0x06f3, B:207:0x06fd, B:209:0x0705, B:215:0x0722, B:217:0x072a, B:218:0x072d, B:220:0x0742, B:222:0x074c, B:223:0x074f, B:225:0x075d, B:227:0x0767, B:229:0x076b, B:231:0x0776, B:243:0x07e2, B:245:0x082a, B:246:0x082f, B:248:0x0837, B:250:0x0840, B:251:0x0845, B:253:0x0851, B:255:0x08b5, B:256:0x08ba, B:257:0x08c6, B:259:0x08d0, B:260:0x08d7, B:262:0x08e1, B:263:0x08e8, B:264:0x08f3, B:266:0x08f9, B:268:0x092a, B:269:0x093a, B:271:0x0942, B:272:0x0946, B:274:0x094c, B:283:0x0994, B:285:0x099a, B:288:0x09b6, B:277:0x095a, B:279:0x097f, B:287:0x099e, B:232:0x0780, B:234:0x0792, B:236:0x0796, B:238:0x07a8, B:242:0x07df, B:239:0x07c2, B:241:0x07c8, B:210:0x070b, B:212:0x0715, B:214:0x071d, B:178:0x0636, B:106:0x031c, B:107:0x033a, B:112:0x0368, B:111:0x0357, B:98:0x02dd, B:89:0x0295, B:90:0x02b2), top: B:296:0x01e7, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x043d A[Catch: all -> 0x09e9, TryCatch #1 {all -> 0x09e9, blocks: (B:48:0x01e7, B:50:0x01f0, B:54:0x0201, B:58:0x020f, B:60:0x0219, B:65:0x0225, B:72:0x0237, B:75:0x0243, B:77:0x025a, B:82:0x0273, B:84:0x027d, B:86:0x028b, B:91:0x02bc, B:93:0x02c2, B:95:0x02d0, B:97:0x02d8, B:99:0x02e2, B:101:0x02ed, B:104:0x02f4, B:113:0x0383, B:115:0x038d, B:119:0x03c4, B:123:0x03d6, B:125:0x03ea, B:127:0x03fa, B:129:0x040b, B:131:0x043d, B:133:0x0442, B:134:0x045b, B:138:0x046c, B:140:0x0480, B:142:0x0485, B:143:0x049e, B:147:0x04c1, B:151:0x04e6, B:152:0x04ff, B:155:0x050e, B:158:0x0531, B:159:0x054d, B:161:0x0557, B:163:0x0563, B:165:0x0569, B:166:0x0574, B:168:0x0580, B:169:0x0597, B:171:0x05c1, B:174:0x05da, B:177:0x061d, B:179:0x0644, B:181:0x067e, B:182:0x0683, B:184:0x068b, B:185:0x0690, B:187:0x0698, B:188:0x069d, B:190:0x06a6, B:191:0x06aa, B:193:0x06b7, B:194:0x06bc, B:196:0x06c2, B:198:0x06d2, B:200:0x06dc, B:202:0x06e4, B:203:0x06e9, B:205:0x06f3, B:207:0x06fd, B:209:0x0705, B:215:0x0722, B:217:0x072a, B:218:0x072d, B:220:0x0742, B:222:0x074c, B:223:0x074f, B:225:0x075d, B:227:0x0767, B:229:0x076b, B:231:0x0776, B:243:0x07e2, B:245:0x082a, B:246:0x082f, B:248:0x0837, B:250:0x0840, B:251:0x0845, B:253:0x0851, B:255:0x08b5, B:256:0x08ba, B:257:0x08c6, B:259:0x08d0, B:260:0x08d7, B:262:0x08e1, B:263:0x08e8, B:264:0x08f3, B:266:0x08f9, B:268:0x092a, B:269:0x093a, B:271:0x0942, B:272:0x0946, B:274:0x094c, B:283:0x0994, B:285:0x099a, B:288:0x09b6, B:277:0x095a, B:279:0x097f, B:287:0x099e, B:232:0x0780, B:234:0x0792, B:236:0x0796, B:238:0x07a8, B:242:0x07df, B:239:0x07c2, B:241:0x07c8, B:210:0x070b, B:212:0x0715, B:214:0x071d, B:178:0x0636, B:106:0x031c, B:107:0x033a, B:112:0x0368, B:111:0x0357, B:98:0x02dd, B:89:0x0295, B:90:0x02b2), top: B:296:0x01e7, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0237 A[Catch: all -> 0x09e9, TRY_LEAVE, TryCatch #1 {all -> 0x09e9, blocks: (B:48:0x01e7, B:50:0x01f0, B:54:0x0201, B:58:0x020f, B:60:0x0219, B:65:0x0225, B:72:0x0237, B:75:0x0243, B:77:0x025a, B:82:0x0273, B:84:0x027d, B:86:0x028b, B:91:0x02bc, B:93:0x02c2, B:95:0x02d0, B:97:0x02d8, B:99:0x02e2, B:101:0x02ed, B:104:0x02f4, B:113:0x0383, B:115:0x038d, B:119:0x03c4, B:123:0x03d6, B:125:0x03ea, B:127:0x03fa, B:129:0x040b, B:131:0x043d, B:133:0x0442, B:134:0x045b, B:138:0x046c, B:140:0x0480, B:142:0x0485, B:143:0x049e, B:147:0x04c1, B:151:0x04e6, B:152:0x04ff, B:155:0x050e, B:158:0x0531, B:159:0x054d, B:161:0x0557, B:163:0x0563, B:165:0x0569, B:166:0x0574, B:168:0x0580, B:169:0x0597, B:171:0x05c1, B:174:0x05da, B:177:0x061d, B:179:0x0644, B:181:0x067e, B:182:0x0683, B:184:0x068b, B:185:0x0690, B:187:0x0698, B:188:0x069d, B:190:0x06a6, B:191:0x06aa, B:193:0x06b7, B:194:0x06bc, B:196:0x06c2, B:198:0x06d2, B:200:0x06dc, B:202:0x06e4, B:203:0x06e9, B:205:0x06f3, B:207:0x06fd, B:209:0x0705, B:215:0x0722, B:217:0x072a, B:218:0x072d, B:220:0x0742, B:222:0x074c, B:223:0x074f, B:225:0x075d, B:227:0x0767, B:229:0x076b, B:231:0x0776, B:243:0x07e2, B:245:0x082a, B:246:0x082f, B:248:0x0837, B:250:0x0840, B:251:0x0845, B:253:0x0851, B:255:0x08b5, B:256:0x08ba, B:257:0x08c6, B:259:0x08d0, B:260:0x08d7, B:262:0x08e1, B:263:0x08e8, B:264:0x08f3, B:266:0x08f9, B:268:0x092a, B:269:0x093a, B:271:0x0942, B:272:0x0946, B:274:0x094c, B:283:0x0994, B:285:0x099a, B:288:0x09b6, B:277:0x095a, B:279:0x097f, B:287:0x099e, B:232:0x0780, B:234:0x0792, B:236:0x0796, B:238:0x07a8, B:242:0x07df, B:239:0x07c2, B:241:0x07c8, B:210:0x070b, B:212:0x0715, B:214:0x071d, B:178:0x0636, B:106:0x031c, B:107:0x033a, B:112:0x0368, B:111:0x0357, B:98:0x02dd, B:89:0x0295, B:90:0x02b2), top: B:296:0x01e7, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void K(com.google.android.gms.measurement.internal.p r31, com.google.android.gms.measurement.internal.z9 r32) {
        /*
            Method dump skipped, instructions count: 2547
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.j9.K(com.google.android.gms.measurement.internal.p, com.google.android.gms.measurement.internal.z9):void");
    }

    private static void L(k9 k9Var) {
        if (k9Var != null) {
            if (k9Var.t()) {
                return;
            }
            String valueOf = String.valueOf(k9Var.getClass());
            StringBuilder sb = new StringBuilder(valueOf.length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
        throw new IllegalStateException("Upload Component not created");
    }

    private final boolean V(z9 z9Var) {
        return (com.google.android.gms.internal.measurement.ka.b() && this.f7694j.y().D(z9Var.a, r.r0)) ? (TextUtils.isEmpty(z9Var.f7972b) && TextUtils.isEmpty(z9Var.z) && TextUtils.isEmpty(z9Var.v)) ? false : true : (TextUtils.isEmpty(z9Var.f7972b) && TextUtils.isEmpty(z9Var.v)) ? false : true;
    }

    private final int a(FileChannel fileChannel) {
        i0();
        if (fileChannel != null && fileChannel.isOpen()) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0L);
                int read = fileChannel.read(allocate);
                if (read == 4) {
                    allocate.flip();
                    return allocate.getInt();
                }
                if (read != -1) {
                    this.f7694j.f().K().b("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            } catch (IOException e2) {
                this.f7694j.f().H().b("Failed to read from channel", e2);
                return 0;
            }
        }
        this.f7694j.f().H().a("Bad channel to read from");
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x018d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.android.gms.measurement.internal.f4 b(com.google.android.gms.measurement.internal.z9 r8, com.google.android.gms.measurement.internal.f4 r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.j9.b(com.google.android.gms.measurement.internal.z9, com.google.android.gms.measurement.internal.f4, java.lang.String):com.google.android.gms.measurement.internal.f4");
    }

    public static j9 c(Context context) {
        com.google.android.gms.common.internal.t.k(context);
        com.google.android.gms.common.internal.t.k(context.getApplicationContext());
        if (a == null) {
            synchronized (j9.class) {
                if (a == null) {
                    a = new j9(new p9(context));
                }
            }
        }
        return a;
    }

    private final z9 d(String str) {
        f4 k0 = U().k0(str);
        if (k0 != null && !TextUtils.isEmpty(k0.T())) {
            Boolean I = I(k0);
            if (I != null && !I.booleanValue()) {
                this.f7694j.f().H().b("App version does not match; dropping. appId", x3.y(str));
                return null;
            }
            return new z9(str, k0.A(), k0.T(), k0.V(), k0.X(), k0.Z(), k0.b0(), (String) null, k0.e0(), false, k0.M(), k0.k(), 0L, 0, k0.l(), k0.m(), false, k0.D(), k0.n(), k0.d0(), k0.o(), (com.google.android.gms.internal.measurement.ka.b() && this.f7694j.y().D(str, r.r0)) ? k0.G() : null);
        }
        this.f7694j.f().O().b("No app data available; dropping", str);
        return null;
    }

    private final i4 g0() {
        i4 i4Var = this.f7689e;
        if (i4Var != null) {
            return i4Var;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final e9 h0() {
        L(this.f7690f);
        return this.f7690f;
    }

    private final void i0() {
        this.f7694j.l().d();
    }

    private final long j0() {
        long a2 = this.f7694j.i().a();
        k4 B = this.f7694j.B();
        B.q();
        B.d();
        long a3 = B.f7709j.a();
        if (a3 == 0) {
            a3 = 1 + B.m().G0().nextInt(86400000);
            B.f7709j.b(a3);
        }
        return ((((a2 + a3) / 1000) / 60) / 60) / 24;
    }

    private static void k(t0.a aVar, int i2, String str) {
        List<com.google.android.gms.internal.measurement.v0> D = aVar.D();
        for (int i3 = 0; i3 < D.size(); i3++) {
            if ("_err".equals(D.get(i3).M())) {
                return;
            }
        }
        aVar.y((com.google.android.gms.internal.measurement.v0) ((com.google.android.gms.internal.measurement.n4) com.google.android.gms.internal.measurement.v0.c0().A("_err").w(Long.valueOf(i2).longValue()).j())).y((com.google.android.gms.internal.measurement.v0) ((com.google.android.gms.internal.measurement.n4) com.google.android.gms.internal.measurement.v0.c0().A("_ev").C(str).j()));
    }

    private final boolean k0() {
        i0();
        b0();
        return U().G0() || !TextUtils.isEmpty(U().z());
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void l0() {
        /*
            Method dump skipped, instructions count: 626
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.j9.l0():void");
    }

    private static void m(t0.a aVar, String str) {
        List<com.google.android.gms.internal.measurement.v0> D = aVar.D();
        for (int i2 = 0; i2 < D.size(); i2++) {
            if (str.equals(D.get(i2).M())) {
                aVar.F(i2);
                return;
            }
        }
    }

    private static void n(x0.a aVar) {
        aVar.J(Long.MAX_VALUE).Q(Long.MIN_VALUE);
        for (int i2 = 0; i2 < aVar.H(); i2++) {
            com.google.android.gms.internal.measurement.t0 I = aVar.I(i2);
            if (I.V() < aVar.f0()) {
                aVar.J(I.V());
            }
            if (I.V() > aVar.l0()) {
                aVar.Q(I.V());
            }
        }
    }

    private final void o(x0.a aVar, long j2, boolean z) {
        s9 s9Var;
        String str = z ? "_se" : "_lte";
        s9 p0 = U().p0(aVar.D0(), str);
        if (p0 != null && p0.f7863e != null) {
            s9Var = new s9(aVar.D0(), "auto", str, this.f7694j.i().a(), Long.valueOf(((Long) p0.f7863e).longValue() + j2));
        } else {
            s9Var = new s9(aVar.D0(), "auto", str, this.f7694j.i().a(), Long.valueOf(j2));
        }
        com.google.android.gms.internal.measurement.b1 b1Var = (com.google.android.gms.internal.measurement.b1) ((com.google.android.gms.internal.measurement.n4) com.google.android.gms.internal.measurement.b1.X().x(str).w(this.f7694j.i().a()).A(((Long) s9Var.f7863e).longValue()).j());
        boolean z2 = false;
        int x = r9.x(aVar, str);
        if (x >= 0) {
            aVar.w(x, b1Var);
            z2 = true;
        }
        if (!z2) {
            aVar.C(b1Var);
        }
        if (j2 > 0) {
            U().U(s9Var);
            this.f7694j.f().P().c("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", s9Var.f7863e);
        }
    }

    private final void r(f4 f4Var) {
        c.e.a aVar;
        i0();
        if (com.google.android.gms.internal.measurement.ka.b() && this.f7694j.y().D(f4Var.t(), r.r0)) {
            if (TextUtils.isEmpty(f4Var.A()) && TextUtils.isEmpty(f4Var.G()) && TextUtils.isEmpty(f4Var.D())) {
                A(f4Var.t(), HttpStatus.SC_NO_CONTENT, null, null, null);
                return;
            }
        } else if (TextUtils.isEmpty(f4Var.A()) && TextUtils.isEmpty(f4Var.D())) {
            A(f4Var.t(), HttpStatus.SC_NO_CONTENT, null, null, null);
            return;
        }
        String s = this.f7694j.y().s(f4Var);
        try {
            URL url = new URL(s);
            this.f7694j.f().P().b("Fetching remote configuration", f4Var.t());
            com.google.android.gms.internal.measurement.o0 x = R().x(f4Var.t());
            String C = R().C(f4Var.t());
            if (x == null || TextUtils.isEmpty(C)) {
                aVar = null;
            } else {
                c.e.a aVar2 = new c.e.a();
                aVar2.put(HttpHeaders.IF_MODIFIED_SINCE, C);
                aVar = aVar2;
            }
            this.q = true;
            e4 S = S();
            String t = f4Var.t();
            o9 o9Var = new o9(this);
            S.d();
            S.u();
            com.google.android.gms.common.internal.t.k(url);
            com.google.android.gms.common.internal.t.k(o9Var);
            S.l().D(new j4(S, t, url, null, aVar, o9Var));
        } catch (MalformedURLException unused) {
            this.f7694j.f().H().c("Failed to parse config URL. Not fetching. appId", x3.y(f4Var.t()), s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(p9 p9Var) {
        this.f7694j.l().d();
        e eVar = new e(this);
        eVar.v();
        this.f7688d = eVar;
        this.f7694j.y().t(this.f7686b);
        aa aaVar = new aa(this);
        aaVar.v();
        this.f7691g = aaVar;
        m7 m7Var = new m7(this);
        m7Var.v();
        this.f7693i = m7Var;
        e9 e9Var = new e9(this);
        e9Var.v();
        this.f7690f = e9Var;
        this.f7689e = new i4(this);
        if (this.o != this.p) {
            this.f7694j.f().H().c("Not all upload components initialized", Integer.valueOf(this.o), Integer.valueOf(this.p));
        }
        this.f7695k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b0, code lost:
        r6.f7694j.B().f7707h.b(r6.f7694j.i().a());
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013a A[Catch: all -> 0x018d, TryCatch #2 {all -> 0x0196, blocks: (B:4:0x000c, B:5:0x000e, B:64:0x0180, B:43:0x00f6, B:50:0x0117, B:6:0x0029, B:15:0x0045, B:63:0x0179, B:20:0x0061, B:27:0x00b0, B:28:0x00c5, B:31:0x00cd, B:34:0x00d9, B:36:0x00df, B:41:0x00ec, B:53:0x0124, B:55:0x013a, B:57:0x0162, B:59:0x016c, B:61:0x0172, B:62:0x0176, B:56:0x014a, B:46:0x0103, B:48:0x010d), top: B:73:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014a A[Catch: all -> 0x018d, TryCatch #2 {all -> 0x0196, blocks: (B:4:0x000c, B:5:0x000e, B:64:0x0180, B:43:0x00f6, B:50:0x0117, B:6:0x0029, B:15:0x0045, B:63:0x0179, B:20:0x0061, B:27:0x00b0, B:28:0x00c5, B:31:0x00cd, B:34:0x00d9, B:36:0x00df, B:41:0x00ec, B:53:0x0124, B:55:0x013a, B:57:0x0162, B:59:0x016c, B:61:0x0172, B:62:0x0176, B:56:0x014a, B:46:0x0103, B:48:0x010d), top: B:73:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.j9.A(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void B(boolean z) {
        l0();
    }

    public final ka H() {
        return this.f7694j.y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void M(q9 q9Var, z9 z9Var) {
        i0();
        b0();
        if (V(z9Var)) {
            if (!z9Var.f7978h) {
                Q(z9Var);
            } else if ("_npa".equals(q9Var.f7823b) && z9Var.w != null) {
                this.f7694j.f().O().a("Falling back to manifest metadata value for ad personalization");
                v(new q9("_npa", this.f7694j.i().a(), Long.valueOf(z9Var.w.booleanValue() ? 1L : 0L), "auto"), z9Var);
            } else {
                this.f7694j.f().O().b("Removing user property", this.f7694j.I().B(q9Var.f7823b));
                U().w0();
                try {
                    Q(z9Var);
                    U().m0(z9Var.a, q9Var.f7823b);
                    U().x();
                    this.f7694j.f().O().b("User property removed", this.f7694j.I().B(q9Var.f7823b));
                } finally {
                    U().B0();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:94|95|(2:97|(8:99|(3:101|(2:103|(1:105))(1:124)|106)(1:125)|107|(1:109)(1:123)|110|111|112|(4:114|(1:116)|117|(1:119))))|126|111|112|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x039a, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x039b, code lost:
        r21.f7694j.f().H().c("Application info is null, first open report might be inaccurate. appId", com.google.android.gms.measurement.internal.x3.y(r22.a), r0);
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03b3 A[Catch: all -> 0x04b5, TryCatch #1 {all -> 0x04b5, blocks: (B:24:0x009f, B:26:0x00ad, B:44:0x010f, B:46:0x011b, B:48:0x0132, B:49:0x015a, B:51:0x01a4, B:54:0x01b7, B:57:0x01cb, B:59:0x01d6, B:64:0x01e5, B:66:0x01ed, B:68:0x01f3, B:72:0x0202, B:74:0x0205, B:76:0x0229, B:78:0x022e, B:84:0x024e, B:87:0x0261, B:89:0x0284, B:90:0x0292, B:92:0x02c5, B:94:0x02cd, B:96:0x02d1, B:97:0x02d4, B:99:0x02f5, B:138:0x03cf, B:139:0x03d2, B:150:0x0443, B:152:0x0453, B:154:0x046d, B:155:0x0474, B:159:0x04a6, B:101:0x030e, B:106:0x0339, B:108:0x0341, B:110:0x0349, B:114:0x035d, B:118:0x036b, B:122:0x0376, B:125:0x0388, B:128:0x039b, B:130:0x03b3, B:132:0x03b9, B:133:0x03be, B:135:0x03c4, B:115:0x0363, B:104:0x0321, B:142:0x03ea, B:144:0x0420, B:146:0x0428, B:148:0x042c, B:149:0x042f, B:156:0x0489, B:158:0x048d, B:81:0x023e, B:30:0x00bc, B:32:0x00c0, B:36:0x00d1, B:38:0x00eb, B:40:0x00f5, B:43:0x00ff), top: B:167:0x009f, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0489 A[Catch: all -> 0x04b5, TryCatch #1 {all -> 0x04b5, blocks: (B:24:0x009f, B:26:0x00ad, B:44:0x010f, B:46:0x011b, B:48:0x0132, B:49:0x015a, B:51:0x01a4, B:54:0x01b7, B:57:0x01cb, B:59:0x01d6, B:64:0x01e5, B:66:0x01ed, B:68:0x01f3, B:72:0x0202, B:74:0x0205, B:76:0x0229, B:78:0x022e, B:84:0x024e, B:87:0x0261, B:89:0x0284, B:90:0x0292, B:92:0x02c5, B:94:0x02cd, B:96:0x02d1, B:97:0x02d4, B:99:0x02f5, B:138:0x03cf, B:139:0x03d2, B:150:0x0443, B:152:0x0453, B:154:0x046d, B:155:0x0474, B:159:0x04a6, B:101:0x030e, B:106:0x0339, B:108:0x0341, B:110:0x0349, B:114:0x035d, B:118:0x036b, B:122:0x0376, B:125:0x0388, B:128:0x039b, B:130:0x03b3, B:132:0x03b9, B:133:0x03be, B:135:0x03c4, B:115:0x0363, B:104:0x0321, B:142:0x03ea, B:144:0x0420, B:146:0x0428, B:148:0x042c, B:149:0x042f, B:156:0x0489, B:158:0x048d, B:81:0x023e, B:30:0x00bc, B:32:0x00c0, B:36:0x00d1, B:38:0x00eb, B:40:0x00f5, B:43:0x00ff), top: B:167:0x009f, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011b A[Catch: all -> 0x04b5, TryCatch #1 {all -> 0x04b5, blocks: (B:24:0x009f, B:26:0x00ad, B:44:0x010f, B:46:0x011b, B:48:0x0132, B:49:0x015a, B:51:0x01a4, B:54:0x01b7, B:57:0x01cb, B:59:0x01d6, B:64:0x01e5, B:66:0x01ed, B:68:0x01f3, B:72:0x0202, B:74:0x0205, B:76:0x0229, B:78:0x022e, B:84:0x024e, B:87:0x0261, B:89:0x0284, B:90:0x0292, B:92:0x02c5, B:94:0x02cd, B:96:0x02d1, B:97:0x02d4, B:99:0x02f5, B:138:0x03cf, B:139:0x03d2, B:150:0x0443, B:152:0x0453, B:154:0x046d, B:155:0x0474, B:159:0x04a6, B:101:0x030e, B:106:0x0339, B:108:0x0341, B:110:0x0349, B:114:0x035d, B:118:0x036b, B:122:0x0376, B:125:0x0388, B:128:0x039b, B:130:0x03b3, B:132:0x03b9, B:133:0x03be, B:135:0x03c4, B:115:0x0363, B:104:0x0321, B:142:0x03ea, B:144:0x0420, B:146:0x0428, B:148:0x042c, B:149:0x042f, B:156:0x0489, B:158:0x048d, B:81:0x023e, B:30:0x00bc, B:32:0x00c0, B:36:0x00d1, B:38:0x00eb, B:40:0x00f5, B:43:0x00ff), top: B:167:0x009f, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01cb A[Catch: all -> 0x04b5, TryCatch #1 {all -> 0x04b5, blocks: (B:24:0x009f, B:26:0x00ad, B:44:0x010f, B:46:0x011b, B:48:0x0132, B:49:0x015a, B:51:0x01a4, B:54:0x01b7, B:57:0x01cb, B:59:0x01d6, B:64:0x01e5, B:66:0x01ed, B:68:0x01f3, B:72:0x0202, B:74:0x0205, B:76:0x0229, B:78:0x022e, B:84:0x024e, B:87:0x0261, B:89:0x0284, B:90:0x0292, B:92:0x02c5, B:94:0x02cd, B:96:0x02d1, B:97:0x02d4, B:99:0x02f5, B:138:0x03cf, B:139:0x03d2, B:150:0x0443, B:152:0x0453, B:154:0x046d, B:155:0x0474, B:159:0x04a6, B:101:0x030e, B:106:0x0339, B:108:0x0341, B:110:0x0349, B:114:0x035d, B:118:0x036b, B:122:0x0376, B:125:0x0388, B:128:0x039b, B:130:0x03b3, B:132:0x03b9, B:133:0x03be, B:135:0x03c4, B:115:0x0363, B:104:0x0321, B:142:0x03ea, B:144:0x0420, B:146:0x0428, B:148:0x042c, B:149:0x042f, B:156:0x0489, B:158:0x048d, B:81:0x023e, B:30:0x00bc, B:32:0x00c0, B:36:0x00d1, B:38:0x00eb, B:40:0x00f5, B:43:0x00ff), top: B:167:0x009f, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0205 A[Catch: all -> 0x04b5, TryCatch #1 {all -> 0x04b5, blocks: (B:24:0x009f, B:26:0x00ad, B:44:0x010f, B:46:0x011b, B:48:0x0132, B:49:0x015a, B:51:0x01a4, B:54:0x01b7, B:57:0x01cb, B:59:0x01d6, B:64:0x01e5, B:66:0x01ed, B:68:0x01f3, B:72:0x0202, B:74:0x0205, B:76:0x0229, B:78:0x022e, B:84:0x024e, B:87:0x0261, B:89:0x0284, B:90:0x0292, B:92:0x02c5, B:94:0x02cd, B:96:0x02d1, B:97:0x02d4, B:99:0x02f5, B:138:0x03cf, B:139:0x03d2, B:150:0x0443, B:152:0x0453, B:154:0x046d, B:155:0x0474, B:159:0x04a6, B:101:0x030e, B:106:0x0339, B:108:0x0341, B:110:0x0349, B:114:0x035d, B:118:0x036b, B:122:0x0376, B:125:0x0388, B:128:0x039b, B:130:0x03b3, B:132:0x03b9, B:133:0x03be, B:135:0x03c4, B:115:0x0363, B:104:0x0321, B:142:0x03ea, B:144:0x0420, B:146:0x0428, B:148:0x042c, B:149:0x042f, B:156:0x0489, B:158:0x048d, B:81:0x023e, B:30:0x00bc, B:32:0x00c0, B:36:0x00d1, B:38:0x00eb, B:40:0x00f5, B:43:0x00ff), top: B:167:0x009f, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x022e A[Catch: all -> 0x04b5, TryCatch #1 {all -> 0x04b5, blocks: (B:24:0x009f, B:26:0x00ad, B:44:0x010f, B:46:0x011b, B:48:0x0132, B:49:0x015a, B:51:0x01a4, B:54:0x01b7, B:57:0x01cb, B:59:0x01d6, B:64:0x01e5, B:66:0x01ed, B:68:0x01f3, B:72:0x0202, B:74:0x0205, B:76:0x0229, B:78:0x022e, B:84:0x024e, B:87:0x0261, B:89:0x0284, B:90:0x0292, B:92:0x02c5, B:94:0x02cd, B:96:0x02d1, B:97:0x02d4, B:99:0x02f5, B:138:0x03cf, B:139:0x03d2, B:150:0x0443, B:152:0x0453, B:154:0x046d, B:155:0x0474, B:159:0x04a6, B:101:0x030e, B:106:0x0339, B:108:0x0341, B:110:0x0349, B:114:0x035d, B:118:0x036b, B:122:0x0376, B:125:0x0388, B:128:0x039b, B:130:0x03b3, B:132:0x03b9, B:133:0x03be, B:135:0x03c4, B:115:0x0363, B:104:0x0321, B:142:0x03ea, B:144:0x0420, B:146:0x0428, B:148:0x042c, B:149:0x042f, B:156:0x0489, B:158:0x048d, B:81:0x023e, B:30:0x00bc, B:32:0x00c0, B:36:0x00d1, B:38:0x00eb, B:40:0x00f5, B:43:0x00ff), top: B:167:0x009f, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x024e A[Catch: all -> 0x04b5, TRY_LEAVE, TryCatch #1 {all -> 0x04b5, blocks: (B:24:0x009f, B:26:0x00ad, B:44:0x010f, B:46:0x011b, B:48:0x0132, B:49:0x015a, B:51:0x01a4, B:54:0x01b7, B:57:0x01cb, B:59:0x01d6, B:64:0x01e5, B:66:0x01ed, B:68:0x01f3, B:72:0x0202, B:74:0x0205, B:76:0x0229, B:78:0x022e, B:84:0x024e, B:87:0x0261, B:89:0x0284, B:90:0x0292, B:92:0x02c5, B:94:0x02cd, B:96:0x02d1, B:97:0x02d4, B:99:0x02f5, B:138:0x03cf, B:139:0x03d2, B:150:0x0443, B:152:0x0453, B:154:0x046d, B:155:0x0474, B:159:0x04a6, B:101:0x030e, B:106:0x0339, B:108:0x0341, B:110:0x0349, B:114:0x035d, B:118:0x036b, B:122:0x0376, B:125:0x0388, B:128:0x039b, B:130:0x03b3, B:132:0x03b9, B:133:0x03be, B:135:0x03c4, B:115:0x0363, B:104:0x0321, B:142:0x03ea, B:144:0x0420, B:146:0x0428, B:148:0x042c, B:149:0x042f, B:156:0x0489, B:158:0x048d, B:81:0x023e, B:30:0x00bc, B:32:0x00c0, B:36:0x00d1, B:38:0x00eb, B:40:0x00f5, B:43:0x00ff), top: B:167:0x009f, inners: #0, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void N(com.google.android.gms.measurement.internal.z9 r22) {
        /*
            Method dump skipped, instructions count: 1214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.j9.N(com.google.android.gms.measurement.internal.z9):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void O(ia iaVar) {
        z9 d2 = d(iaVar.a);
        if (d2 != null) {
            P(iaVar, d2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void P(ia iaVar, z9 z9Var) {
        com.google.android.gms.common.internal.t.k(iaVar);
        com.google.android.gms.common.internal.t.g(iaVar.a);
        com.google.android.gms.common.internal.t.k(iaVar.f7654c);
        com.google.android.gms.common.internal.t.g(iaVar.f7654c.f7823b);
        i0();
        b0();
        if (V(z9Var)) {
            if (!z9Var.f7978h) {
                Q(z9Var);
                return;
            }
            U().w0();
            try {
                Q(z9Var);
                ia q0 = U().q0(iaVar.a, iaVar.f7654c.f7823b);
                if (q0 != null) {
                    this.f7694j.f().O().c("Removing conditional user property", iaVar.a, this.f7694j.I().B(iaVar.f7654c.f7823b));
                    U().s0(iaVar.a, iaVar.f7654c.f7823b);
                    if (q0.f7656e) {
                        U().m0(iaVar.a, iaVar.f7654c.f7823b);
                    }
                    p pVar = iaVar.f7662l;
                    if (pVar != null) {
                        o oVar = pVar.f7790b;
                        Bundle l1 = oVar != null ? oVar.l1() : null;
                        v9 H = this.f7694j.H();
                        String str = iaVar.a;
                        p pVar2 = iaVar.f7662l;
                        K(H.F(str, pVar2.a, l1, q0.f7653b, pVar2.f7792d, true, false), z9Var);
                    }
                } else {
                    this.f7694j.f().K().c("Conditional user property doesn't exist", x3.y(iaVar.a), this.f7694j.I().B(iaVar.f7654c.f7823b));
                }
                U().x();
            } finally {
                U().B0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final f4 Q(z9 z9Var) {
        i0();
        b0();
        com.google.android.gms.common.internal.t.k(z9Var);
        com.google.android.gms.common.internal.t.g(z9Var.a);
        f4 k0 = U().k0(z9Var.a);
        String y = this.f7694j.B().y(z9Var.a);
        if (com.google.android.gms.internal.measurement.s9.b() && this.f7694j.y().u(r.x0)) {
            if (k0 == null) {
                k0 = new f4(this.f7694j, z9Var.a);
                k0.c(this.f7694j.H().M0());
                k0.C(y);
            } else if (!y.equals(k0.J())) {
                k0.C(y);
                k0.c(this.f7694j.H().M0());
            }
            k0.r(z9Var.f7972b);
            k0.v(z9Var.v);
            if (com.google.android.gms.internal.measurement.ka.b() && this.f7694j.y().D(k0.t(), r.r0)) {
                k0.z(z9Var.z);
            }
            if (!TextUtils.isEmpty(z9Var.f7981l)) {
                k0.F(z9Var.f7981l);
            }
            long j2 = z9Var.f7975e;
            if (j2 != 0) {
                k0.y(j2);
            }
            if (!TextUtils.isEmpty(z9Var.f7973c)) {
                k0.I(z9Var.f7973c);
            }
            k0.u(z9Var.f7980k);
            String str = z9Var.f7974d;
            if (str != null) {
                k0.L(str);
            }
            k0.B(z9Var.f7976f);
            k0.e(z9Var.f7978h);
            if (!TextUtils.isEmpty(z9Var.f7977g)) {
                k0.O(z9Var.f7977g);
            }
            if (!this.f7694j.y().u(r.Q0)) {
                k0.c0(z9Var.m);
            }
            k0.s(z9Var.q);
            k0.w(z9Var.t);
            k0.b(z9Var.w);
            k0.E(z9Var.x);
            if (k0.f()) {
                U().P(k0);
            }
            return k0;
        }
        return b(z9Var, k0, y);
    }

    public final w4 R() {
        L(this.f7686b);
        return this.f7686b;
    }

    public final e4 S() {
        L(this.f7687c);
        return this.f7687c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String T(z9 z9Var) {
        try {
            return (String) this.f7694j.l().x(new n9(this, z9Var)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            this.f7694j.f().H().c("Failed to get app instance id. appId", x3.y(z9Var.a), e2);
            return null;
        }
    }

    public final e U() {
        L(this.f7688d);
        return this.f7688d;
    }

    public final aa W() {
        L(this.f7691g);
        return this.f7691g;
    }

    public final m7 X() {
        L(this.f7693i);
        return this.f7693i;
    }

    public final r9 Y() {
        L(this.f7692h);
        return this.f7692h;
    }

    public final v3 Z() {
        return this.f7694j.I();
    }

    public final v9 a0() {
        return this.f7694j.H();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b0() {
        if (!this.f7695k) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c0() {
        f4 k0;
        String str;
        i0();
        b0();
        this.s = true;
        try {
            this.f7694j.g();
            Boolean b0 = this.f7694j.Q().b0();
            if (b0 == null) {
                this.f7694j.f().K().a("Upload data called on the client side before use of service was decided");
            } else if (b0.booleanValue()) {
                this.f7694j.f().H().a("Upload called in the client side when service should be used");
            } else if (this.m > 0) {
                l0();
            } else {
                i0();
                if (this.v != null) {
                    this.f7694j.f().P().a("Uploading requested multiple times");
                } else if (!S().A()) {
                    this.f7694j.f().P().a("Network not connected, ignoring upload request");
                    l0();
                } else {
                    long a2 = this.f7694j.i().a();
                    int w = this.f7694j.y().w(null, r.R);
                    long O = a2 - ka.O();
                    for (int i2 = 0; i2 < w && E(null, O); i2++) {
                    }
                    long a3 = this.f7694j.B().f7705f.a();
                    if (a3 != 0) {
                        this.f7694j.f().O().b("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(a2 - a3)));
                    }
                    String z = U().z();
                    if (!TextUtils.isEmpty(z)) {
                        if (this.x == -1) {
                            this.x = U().Z();
                        }
                        List<Pair<com.google.android.gms.internal.measurement.x0, Long>> K = U().K(z, this.f7694j.y().w(z, r.f7836h), Math.max(0, this.f7694j.y().w(z, r.f7837i)));
                        if (!K.isEmpty()) {
                            Iterator<Pair<com.google.android.gms.internal.measurement.x0, Long>> it = K.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    str = null;
                                    break;
                                }
                                com.google.android.gms.internal.measurement.x0 x0Var = (com.google.android.gms.internal.measurement.x0) it.next().first;
                                if (!TextUtils.isEmpty(x0Var.b0())) {
                                    str = x0Var.b0();
                                    break;
                                }
                            }
                            if (str != null) {
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= K.size()) {
                                        break;
                                    }
                                    com.google.android.gms.internal.measurement.x0 x0Var2 = (com.google.android.gms.internal.measurement.x0) K.get(i3).first;
                                    if (!TextUtils.isEmpty(x0Var2.b0()) && !x0Var2.b0().equals(str)) {
                                        K = K.subList(0, i3);
                                        break;
                                    }
                                    i3++;
                                }
                            }
                            w0.a F = com.google.android.gms.internal.measurement.w0.F();
                            int size = K.size();
                            ArrayList arrayList = new ArrayList(K.size());
                            boolean F2 = this.f7694j.y().F(z);
                            for (int i4 = 0; i4 < size; i4++) {
                                x0.a x = ((com.google.android.gms.internal.measurement.x0) K.get(i4).first).x();
                                arrayList.add((Long) K.get(i4).second);
                                x0.a x2 = x.n0(this.f7694j.y().E()).x(a2);
                                this.f7694j.g();
                                x2.M(false);
                                if (!F2) {
                                    x.N0();
                                }
                                if (this.f7694j.y().D(z, r.a0)) {
                                    x.H0(Y().y(((com.google.android.gms.internal.measurement.x0) ((com.google.android.gms.internal.measurement.n4) x.j())).l()));
                                }
                                F.u(x);
                            }
                            String E = this.f7694j.f().D(2) ? Y().E((com.google.android.gms.internal.measurement.w0) ((com.google.android.gms.internal.measurement.n4) F.j())) : null;
                            Y();
                            byte[] l2 = ((com.google.android.gms.internal.measurement.w0) ((com.google.android.gms.internal.measurement.n4) F.j())).l();
                            String a4 = r.r.a(null);
                            try {
                                URL url = new URL(a4);
                                com.google.android.gms.common.internal.t.a(!arrayList.isEmpty());
                                if (this.v != null) {
                                    this.f7694j.f().H().a("Set uploading progress before finishing the previous upload");
                                } else {
                                    this.v = new ArrayList(arrayList);
                                }
                                this.f7694j.B().f7706g.b(a2);
                                this.f7694j.f().P().d("Uploading data. app, uncompressed size, data", size > 0 ? F.v(0).M2() : "?", Integer.valueOf(l2.length), E);
                                this.r = true;
                                e4 S = S();
                                l9 l9Var = new l9(this, z);
                                S.d();
                                S.u();
                                com.google.android.gms.common.internal.t.k(url);
                                com.google.android.gms.common.internal.t.k(l2);
                                com.google.android.gms.common.internal.t.k(l9Var);
                                S.l().D(new j4(S, z, url, l2, null, l9Var));
                            } catch (MalformedURLException unused) {
                                this.f7694j.f().H().c("Failed to parse upload URL. Not uploading. appId", x3.y(z), a4);
                            }
                        }
                    } else {
                        this.x = -1L;
                        String I = U().I(a2 - ka.O());
                        if (!TextUtils.isEmpty(I) && (k0 = U().k0(I)) != null) {
                            r(k0);
                        }
                    }
                }
            }
        } finally {
            this.s = false;
            F();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d0() {
        i0();
        b0();
        if (this.f7696l) {
            return;
        }
        this.f7696l = true;
        if (G()) {
            int a2 = a(this.u);
            int H = this.f7694j.S().H();
            i0();
            if (a2 > H) {
                this.f7694j.f().H().c("Panic: can't downgrade version. Previous, current version", Integer.valueOf(a2), Integer.valueOf(H));
            } else if (a2 < H) {
                if (C(H, this.u)) {
                    this.f7694j.f().P().c("Storage version upgraded. Previous, current version", Integer.valueOf(a2), Integer.valueOf(H));
                } else {
                    this.f7694j.f().H().c("Storage version upgrade failed. Previous, current version", Integer.valueOf(a2), Integer.valueOf(H));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e() {
        this.f7694j.l().d();
        U().D0();
        if (this.f7694j.B().f7705f.a() == 0) {
            this.f7694j.B().f7705f.b(this.f7694j.i().a());
        }
        l0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e0() {
        this.p++;
    }

    @Override // com.google.android.gms.measurement.internal.z5
    public final x3 f() {
        return this.f7694j.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final b5 f0() {
        return this.f7694j;
    }

    @Override // com.google.android.gms.measurement.internal.z5
    public final ja g() {
        return this.f7694j.g();
    }

    @Override // com.google.android.gms.measurement.internal.z5
    public final Context h() {
        return this.f7694j.h();
    }

    @Override // com.google.android.gms.measurement.internal.z5
    public final com.google.android.gms.common.util.e i() {
        return this.f7694j.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0156, code lost:
        r8.f7694j.B().f7707h.b(r8.f7694j.i().a());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j(int r9, java.lang.Throwable r10, byte[] r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.j9.j(int, java.lang.Throwable, byte[], java.lang.String):void");
    }

    @Override // com.google.android.gms.measurement.internal.z5
    public final y4 l() {
        return this.f7694j.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void p(p pVar, z9 z9Var) {
        List<ia> M;
        List<ia> M2;
        List<ia> M3;
        List<String> list;
        p pVar2 = pVar;
        com.google.android.gms.common.internal.t.k(z9Var);
        com.google.android.gms.common.internal.t.g(z9Var.a);
        i0();
        b0();
        String str = z9Var.a;
        long j2 = pVar2.f7792d;
        Y();
        if (r9.T(pVar, z9Var)) {
            if (!z9Var.f7978h) {
                Q(z9Var);
                return;
            }
            if (this.f7694j.y().D(str, r.e0) && (list = z9Var.y) != null) {
                if (list.contains(pVar2.a)) {
                    Bundle l1 = pVar2.f7790b.l1();
                    l1.putLong("ga_safelisted", 1L);
                    pVar2 = new p(pVar2.a, new o(l1), pVar2.f7791c, pVar2.f7792d);
                } else {
                    this.f7694j.f().O().d("Dropping non-safelisted event. appId, event name, origin", str, pVar2.a, pVar2.f7791c);
                    return;
                }
            }
            U().w0();
            try {
                e U = U();
                com.google.android.gms.common.internal.t.g(str);
                U.d();
                U.u();
                int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                if (i2 < 0) {
                    U.f().K().c("Invalid time querying timed out conditional properties", x3.y(str), Long.valueOf(j2));
                    M = Collections.emptyList();
                } else {
                    M = U.M("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j2)});
                }
                for (ia iaVar : M) {
                    if (iaVar != null) {
                        this.f7694j.f().P().d("User property timed out", iaVar.a, this.f7694j.I().B(iaVar.f7654c.f7823b), iaVar.f7654c.i1());
                        if (iaVar.f7658g != null) {
                            K(new p(iaVar.f7658g, j2), z9Var);
                        }
                        U().s0(str, iaVar.f7654c.f7823b);
                    }
                }
                e U2 = U();
                com.google.android.gms.common.internal.t.g(str);
                U2.d();
                U2.u();
                if (i2 < 0) {
                    U2.f().K().c("Invalid time querying expired conditional properties", x3.y(str), Long.valueOf(j2));
                    M2 = Collections.emptyList();
                } else {
                    M2 = U2.M("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j2)});
                }
                ArrayList arrayList = new ArrayList(M2.size());
                for (ia iaVar2 : M2) {
                    if (iaVar2 != null) {
                        this.f7694j.f().P().d("User property expired", iaVar2.a, this.f7694j.I().B(iaVar2.f7654c.f7823b), iaVar2.f7654c.i1());
                        U().m0(str, iaVar2.f7654c.f7823b);
                        p pVar3 = iaVar2.f7662l;
                        if (pVar3 != null) {
                            arrayList.add(pVar3);
                        }
                        U().s0(str, iaVar2.f7654c.f7823b);
                    }
                }
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    K(new p((p) obj, j2), z9Var);
                }
                e U3 = U();
                String str2 = pVar2.a;
                com.google.android.gms.common.internal.t.g(str);
                com.google.android.gms.common.internal.t.g(str2);
                U3.d();
                U3.u();
                if (i2 < 0) {
                    U3.f().K().d("Invalid time querying triggered conditional properties", x3.y(str), U3.j().x(str2), Long.valueOf(j2));
                    M3 = Collections.emptyList();
                } else {
                    M3 = U3.M("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j2)});
                }
                ArrayList arrayList2 = new ArrayList(M3.size());
                for (ia iaVar3 : M3) {
                    if (iaVar3 != null) {
                        q9 q9Var = iaVar3.f7654c;
                        s9 s9Var = new s9(iaVar3.a, iaVar3.f7653b, q9Var.f7823b, j2, q9Var.i1());
                        if (U().U(s9Var)) {
                            this.f7694j.f().P().d("User property triggered", iaVar3.a, this.f7694j.I().B(s9Var.f7861c), s9Var.f7863e);
                        } else {
                            this.f7694j.f().H().d("Too many active user properties, ignoring", x3.y(iaVar3.a), this.f7694j.I().B(s9Var.f7861c), s9Var.f7863e);
                        }
                        p pVar4 = iaVar3.f7660j;
                        if (pVar4 != null) {
                            arrayList2.add(pVar4);
                        }
                        iaVar3.f7654c = new q9(s9Var);
                        iaVar3.f7656e = true;
                        U().V(iaVar3);
                    }
                }
                K(pVar2, z9Var);
                int size2 = arrayList2.size();
                int i4 = 0;
                while (i4 < size2) {
                    Object obj2 = arrayList2.get(i4);
                    i4++;
                    K(new p((p) obj2, j2), z9Var);
                }
                U().x();
            } finally {
                U().B0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void q(p pVar, String str) {
        f4 k0 = U().k0(str);
        if (k0 != null && !TextUtils.isEmpty(k0.T())) {
            Boolean I = I(k0);
            if (I == null) {
                if (!"_ui".equals(pVar.a)) {
                    this.f7694j.f().K().b("Could not find package. appId", x3.y(str));
                }
            } else if (!I.booleanValue()) {
                this.f7694j.f().H().b("App version does not match; dropping event. appId", x3.y(str));
                return;
            }
            p(pVar, new z9(str, k0.A(), k0.T(), k0.V(), k0.X(), k0.Z(), k0.b0(), (String) null, k0.e0(), false, k0.M(), k0.k(), 0L, 0, k0.l(), k0.m(), false, k0.D(), k0.n(), k0.d0(), k0.o(), (com.google.android.gms.internal.measurement.ka.b() && this.f7694j.y().D(k0.t(), r.r0)) ? k0.G() : null));
            return;
        }
        this.f7694j.f().O().b("No app data available; dropping event", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void t(k9 k9Var) {
        this.o++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void v(q9 q9Var, z9 z9Var) {
        i0();
        b0();
        if (V(z9Var)) {
            if (!z9Var.f7978h) {
                Q(z9Var);
                return;
            }
            int w0 = this.f7694j.H().w0(q9Var.f7823b);
            int i2 = 0;
            if (w0 != 0) {
                this.f7694j.H();
                String I = v9.I(q9Var.f7823b, 24, true);
                String str = q9Var.f7823b;
                this.f7694j.H().V(z9Var.a, w0, "_ev", I, str != null ? str.length() : 0);
                return;
            }
            int o0 = this.f7694j.H().o0(q9Var.f7823b, q9Var.i1());
            if (o0 != 0) {
                this.f7694j.H();
                String I2 = v9.I(q9Var.f7823b, 24, true);
                Object i1 = q9Var.i1();
                if (i1 != null && ((i1 instanceof String) || (i1 instanceof CharSequence))) {
                    i2 = String.valueOf(i1).length();
                }
                this.f7694j.H().V(z9Var.a, o0, "_ev", I2, i2);
                return;
            }
            Object x0 = this.f7694j.H().x0(q9Var.f7823b, q9Var.i1());
            if (x0 == null) {
                return;
            }
            if ("_sid".equals(q9Var.f7823b)) {
                long j2 = q9Var.f7824c;
                String str2 = q9Var.f7828g;
                long j3 = 0;
                s9 p0 = U().p0(z9Var.a, "_sno");
                if (p0 != null) {
                    Object obj = p0.f7863e;
                    if (obj instanceof Long) {
                        j3 = ((Long) obj).longValue();
                        v(new q9("_sno", j2, Long.valueOf(j3 + 1), str2), z9Var);
                    }
                }
                if (p0 != null) {
                    this.f7694j.f().K().b("Retrieved last session number from database does not contain a valid (long) value", p0.f7863e);
                }
                l F = U().F(z9Var.a, "_s");
                if (F != null) {
                    j3 = F.f7726c;
                    this.f7694j.f().P().b("Backfill the session number. Last used session number", Long.valueOf(j3));
                }
                v(new q9("_sno", j2, Long.valueOf(j3 + 1), str2), z9Var);
            }
            s9 s9Var = new s9(z9Var.a, q9Var.f7828g, q9Var.f7823b, q9Var.f7824c, x0);
            this.f7694j.f().P().c("Setting user property", this.f7694j.I().B(s9Var.f7861c), x0);
            U().w0();
            try {
                Q(z9Var);
                boolean U = U().U(s9Var);
                U().x();
                if (!U) {
                    this.f7694j.f().H().c("Too many unique user properties are set. Ignoring user property", this.f7694j.I().B(s9Var.f7861c), s9Var.f7863e);
                    this.f7694j.H().V(z9Var.a, 9, null, null, 0);
                }
            } finally {
                U().B0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void w(z9 z9Var) {
        if (this.v != null) {
            ArrayList arrayList = new ArrayList();
            this.w = arrayList;
            arrayList.addAll(this.v);
        }
        e U = U();
        String str = z9Var.a;
        com.google.android.gms.common.internal.t.g(str);
        U.d();
        U.u();
        try {
            SQLiteDatabase y = U.y();
            String[] strArr = {str};
            int delete = y.delete("apps", "app_id=?", strArr) + 0 + y.delete("events", "app_id=?", strArr) + y.delete("user_attributes", "app_id=?", strArr) + y.delete("conditional_properties", "app_id=?", strArr) + y.delete("raw_events", "app_id=?", strArr) + y.delete("raw_events_metadata", "app_id=?", strArr) + y.delete("queue", "app_id=?", strArr) + y.delete("audience_filter_values", "app_id=?", strArr) + y.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                U.f().P().c("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            U.f().H().c("Error resetting analytics data. appId, error", x3.y(str), e2);
        }
        if (z9Var.f7978h) {
            N(z9Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void x(ia iaVar) {
        z9 d2 = d(iaVar.a);
        if (d2 != null) {
            y(iaVar, d2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void y(ia iaVar, z9 z9Var) {
        boolean z;
        com.google.android.gms.common.internal.t.k(iaVar);
        com.google.android.gms.common.internal.t.g(iaVar.a);
        com.google.android.gms.common.internal.t.k(iaVar.f7653b);
        com.google.android.gms.common.internal.t.k(iaVar.f7654c);
        com.google.android.gms.common.internal.t.g(iaVar.f7654c.f7823b);
        i0();
        b0();
        if (V(z9Var)) {
            if (!z9Var.f7978h) {
                Q(z9Var);
                return;
            }
            ia iaVar2 = new ia(iaVar);
            boolean z2 = false;
            iaVar2.f7656e = false;
            U().w0();
            try {
                ia q0 = U().q0(iaVar2.a, iaVar2.f7654c.f7823b);
                if (q0 != null && !q0.f7653b.equals(iaVar2.f7653b)) {
                    this.f7694j.f().K().d("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.f7694j.I().B(iaVar2.f7654c.f7823b), iaVar2.f7653b, q0.f7653b);
                }
                if (q0 != null && (z = q0.f7656e)) {
                    iaVar2.f7653b = q0.f7653b;
                    iaVar2.f7655d = q0.f7655d;
                    iaVar2.f7659h = q0.f7659h;
                    iaVar2.f7657f = q0.f7657f;
                    iaVar2.f7660j = q0.f7660j;
                    iaVar2.f7656e = z;
                    q9 q9Var = iaVar2.f7654c;
                    iaVar2.f7654c = new q9(q9Var.f7823b, q0.f7654c.f7824c, q9Var.i1(), q0.f7654c.f7828g);
                } else if (TextUtils.isEmpty(iaVar2.f7657f)) {
                    q9 q9Var2 = iaVar2.f7654c;
                    iaVar2.f7654c = new q9(q9Var2.f7823b, iaVar2.f7655d, q9Var2.i1(), iaVar2.f7654c.f7828g);
                    iaVar2.f7656e = true;
                    z2 = true;
                }
                if (iaVar2.f7656e) {
                    q9 q9Var3 = iaVar2.f7654c;
                    s9 s9Var = new s9(iaVar2.a, iaVar2.f7653b, q9Var3.f7823b, q9Var3.f7824c, q9Var3.i1());
                    if (U().U(s9Var)) {
                        this.f7694j.f().O().d("User property updated immediately", iaVar2.a, this.f7694j.I().B(s9Var.f7861c), s9Var.f7863e);
                    } else {
                        this.f7694j.f().H().d("(2)Too many active user properties, ignoring", x3.y(iaVar2.a), this.f7694j.I().B(s9Var.f7861c), s9Var.f7863e);
                    }
                    if (z2 && iaVar2.f7660j != null) {
                        K(new p(iaVar2.f7660j, iaVar2.f7655d), z9Var);
                    }
                }
                if (U().V(iaVar2)) {
                    this.f7694j.f().O().d("Conditional property added", iaVar2.a, this.f7694j.I().B(iaVar2.f7654c.f7823b), iaVar2.f7654c.i1());
                } else {
                    this.f7694j.f().H().d("Too many conditional properties, ignoring", x3.y(iaVar2.a), this.f7694j.I().B(iaVar2.f7654c.f7823b), iaVar2.f7654c.i1());
                }
                U().x();
            } finally {
                U().B0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void z(Runnable runnable) {
        i0();
        if (this.n == null) {
            this.n = new ArrayList();
        }
        this.n.add(runnable);
    }

    private j9(p9 p9Var, b5 b5Var) {
        this.f7695k = false;
        com.google.android.gms.common.internal.t.k(p9Var);
        b5 a2 = b5.a(p9Var.a, null, null);
        this.f7694j = a2;
        this.x = -1L;
        r9 r9Var = new r9(this);
        r9Var.v();
        this.f7692h = r9Var;
        e4 e4Var = new e4(this);
        e4Var.v();
        this.f7687c = e4Var;
        w4 w4Var = new w4(this);
        w4Var.v();
        this.f7686b = w4Var;
        a2.l().A(new m9(this, p9Var));
    }
}