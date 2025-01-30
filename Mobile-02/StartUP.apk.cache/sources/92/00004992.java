package e.j.i;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.application.extensions.StoreKeys_ApplicationKt;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.common.extensions.Trace_CommonKt;
import com.coinbase.wallet.common.utilities.BuildConfigWrapper;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.features.cloudbackup.models.BackupPayload;
import com.coinbase.wallet.features.cloudbackup.models.BackupPayloadJsonAdapter;
import com.coinbase.wallet.features.cloudbackup.models.BackupStatus;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.squareup.moshi.Moshi;
import e.j.l.o.a;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;

/* compiled from: MnemonicBackupRepository.kt */
@ApplicationScoped
/* loaded from: classes2.dex */
public final class a2 implements e.j.i.i2.d {
    public static final a a = new a(null);

    /* renamed from: b */
    private final e.j.j.b f13598b;

    /* renamed from: c */
    private final e.j.l.o.a f13599c;

    /* renamed from: d */
    private final SimpleDateFormat f13600d;

    /* renamed from: e */
    private final Moshi f13601e;

    /* renamed from: f */
    private final StoreInterface f13602f;

    /* renamed from: g */
    private final BuildConfigWrapper f13603g;

    /* renamed from: h */
    private final h.c.a0 f13604h;

    /* renamed from: i */
    private final h.c.a0 f13605i;

    /* renamed from: j */
    private final kotlin.h f13606j;

    /* renamed from: k */
    private final h.c.v0.a<Optional<BackupStatus>> f13607k;

    /* renamed from: l */
    private final h.c.v0.a<Boolean> f13608l;
    private Drive m;

    /* compiled from: MnemonicBackupRepository.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MnemonicBackupRepository.kt */
    /* loaded from: classes2.dex */
    public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.a<h.c.k0.a> {
        public static final b a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public final h.c.k0.a invoke() {
            return new h.c.k0.a();
        }
    }

    /* compiled from: Comparisons.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements Comparator<T> {
        public c() {
            a2.this = r1;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            long j2;
            int c2;
            long j3 = 0;
            try {
                j2 = a2.this.f13600d.parse(((BackupPayload) t2).getTimestamp()).getTime();
            } catch (ParseException unused) {
                j2 = 0;
            }
            Long valueOf = Long.valueOf(j2);
            try {
                j3 = a2.this.f13600d.parse(((BackupPayload) t).getTimestamp()).getTime();
            } catch (ParseException unused2) {
            }
            c2 = kotlin.b0.b.c(valueOf, Long.valueOf(j3));
            return c2;
        }
    }

    /* compiled from: MnemonicBackupRepository.kt */
    /* loaded from: classes2.dex */
    public static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.a<FileList> {
        final /* synthetic */ Drive a;

        /* renamed from: b */
        final /* synthetic */ String f13609b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Drive drive, String str) {
            super(0);
            this.a = drive;
            this.f13609b = str;
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final FileList invoke() {
            Drive.Files.List orderBy = this.a.files().list().setOrderBy(ApiConstants.NAME);
            return orderBy.setQ('\'' + this.f13609b + "' in parents and trashed = false").setSpaces("drive").execute();
        }
    }

    /* compiled from: MnemonicBackupRepository.kt */
    /* loaded from: classes2.dex */
    public static final class e extends kotlin.jvm.internal.o implements kotlin.e0.c.a<File> {
        final /* synthetic */ Drive a;

        /* renamed from: b */
        final /* synthetic */ File f13610b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Drive drive, File file) {
            super(0);
            this.a = drive;
            this.f13610b = file;
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final File invoke() {
            return this.a.files().get(this.f13610b.getId()).setFields2("*").execute();
        }
    }

    /* compiled from: MnemonicBackupRepository.kt */
    /* loaded from: classes2.dex */
    public static final class f extends kotlin.jvm.internal.o implements kotlin.e0.c.a<FileList> {
        final /* synthetic */ Drive a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(Drive drive) {
            super(0);
            this.a = drive;
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final FileList invoke() {
            return this.a.files().list().setOrderBy(ApiConstants.NAME).setQ("name='CoinbaseWalletBackups' and mimeType='application/vnd.google-apps.folder' and trashed = false").setSpaces("drive").execute();
        }
    }

    /* compiled from: MnemonicBackupRepository.kt */
    /* loaded from: classes2.dex */
    static final class g extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Boolean, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g() {
            super(1);
            a2.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Boolean bool) {
            invoke2(bool);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Boolean bool) {
            a2.this.O0();
        }
    }

    public a2(e.j.j.b appPrefs, e.j.l.o.a base64Util, SimpleDateFormat simpleDateFormat, Moshi moshi, StoreInterface store, BuildConfigWrapper buildConfigWrapper) {
        kotlin.h b2;
        kotlin.jvm.internal.m.g(appPrefs, "appPrefs");
        kotlin.jvm.internal.m.g(base64Util, "base64Util");
        kotlin.jvm.internal.m.g(simpleDateFormat, "simpleDateFormat");
        kotlin.jvm.internal.m.g(moshi, "moshi");
        kotlin.jvm.internal.m.g(store, "store");
        kotlin.jvm.internal.m.g(buildConfigWrapper, "buildConfigWrapper");
        this.f13598b = appPrefs;
        this.f13599c = base64Util;
        this.f13600d = simpleDateFormat;
        this.f13601e = moshi;
        this.f13602f = store;
        this.f13603g = buildConfigWrapper;
        this.f13604h = h.c.j0.c.a.b();
        h.c.a0 c2 = h.c.u0.a.c();
        kotlin.jvm.internal.m.f(c2, "io()");
        this.f13605i = c2;
        b2 = kotlin.k.b(b.a);
        this.f13606j = b2;
        h.c.v0.a<Optional<BackupStatus>> e2 = h.c.v0.a.e(new Optional(BackupStatus.NotBackedUp.INSTANCE));
        kotlin.jvm.internal.m.f(e2, "createDefault(Optional(BackupStatus.NotBackedUp))");
        this.f13607k = e2;
        h.c.v0.a<Boolean> e3 = h.c.v0.a.e(Boolean.FALSE);
        kotlin.jvm.internal.m.f(e3, "createDefault(false)");
        this.f13608l = e3;
    }

    private final h.c.b0<Optional<Void>> A(final Drive drive, final String str) {
        h.c.b0<Optional<Void>> fromCallable = h.c.b0.fromCallable(new Callable() { // from class: e.j.i.h1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a2.F0(Drive.this, str);
            }
        });
        kotlin.jvm.internal.m.f(fromCallable, "fromCallable { driveClient.files().delete(backupFileId).execute().toOptional() }");
        return fromCallable;
    }

    public static /* synthetic */ h.c.h0 A0(a2 a2Var, Drive drive, File file) {
        return y(a2Var, drive, file);
    }

    public static final Optional B(Drive driveClient, String backupFileId) {
        kotlin.jvm.internal.m.g(driveClient, "$driveClient");
        kotlin.jvm.internal.m.g(backupFileId, "$backupFileId");
        return OptionalKt.toOptional(driveClient.files().delete(backupFileId).execute());
    }

    public static /* synthetic */ BackupStatus B0(a2 a2Var, File file) {
        return o(a2Var, file);
    }

    public static /* synthetic */ void C0(a2 a2Var, Boolean bool) {
        Q0(a2Var, bool);
    }

    public static final h.c.h0 D(a2 this$0, Drive driveClient, File it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(driveClient, "$driveClient");
        kotlin.jvm.internal.m.g(it, "it");
        String id = it.getId();
        kotlin.jvm.internal.m.f(id, "it.id");
        return this$0.I(driveClient, id);
    }

    public static /* synthetic */ List D0(a2 a2Var, List list) {
        return G(a2Var, list);
    }

    public static final List E(List files) {
        int r;
        List I0;
        List<String> A0;
        kotlin.jvm.internal.m.g(files, "files");
        r = kotlin.a0.s.r(files, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = files.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            StringBuilder sb = new StringBuilder();
            I0 = kotlin.a0.z.I0(file.getAppProperties().keySet());
            A0 = kotlin.a0.z.A0(I0);
            for (String str : A0) {
                sb.append(file.getAppProperties().get(str));
            }
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    public static /* synthetic */ List E0(a2 a2Var, List list) {
        return F(a2Var, list);
    }

    public static final List F(a2 this$0, List files) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(files, "files");
        ArrayList arrayList = new ArrayList();
        Iterator it = files.iterator();
        while (it.hasNext()) {
            BackupPayload fromJson = new BackupPayloadJsonAdapter(this$0.f13601e).fromJson((String) it.next());
            if (fromJson != null) {
                arrayList.add(fromJson);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ Optional F0(Drive drive, String str) {
        return B(drive, str);
    }

    public static final List G(a2 this$0, List backups) {
        List B0;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(backups, "backups");
        B0 = kotlin.a0.z.B0(backups, new c());
        return B0;
    }

    public static /* synthetic */ List G0(List list) {
        return P(list);
    }

    public static /* synthetic */ Object[] H0(Object[] objArr) {
        return N(objArr);
    }

    private final h.c.b0<List<File>> I(final Drive drive, final String str) {
        h.c.b0<List<File>> map = h.c.b0.fromCallable(new Callable() { // from class: e.j.i.l1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a2.J0(Drive.this, str);
            }
        }).map(new h.c.m0.n() { // from class: e.j.i.b1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return a2.z0(Drive.this, (FileList) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: e.j.i.k0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return a2.i0((List) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.i.h0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return a2.f0((Object[]) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.i.i1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return a2.G0((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "fromCallable {\n            trace(\"MnemonicBackupRepository#getAllBackups drive query\") {\n                driveClient.files().list().setOrderBy(ORDER_BY_CRITERIA)\n                    .setQ(\"'$parentId' in parents and trashed = false\")\n                    .setSpaces(\"drive\")\n                    .execute()\n            }\n        }.map { fileList ->\n            fileList.files.map {\n                Single.fromCallable {\n                    trace(\"MnemonicBackupRepository#getAllBackups drive id query\") {\n                        driveClient.files()\n                            .get(it.id)\n                            .setFields(\"*\")\n                            .execute()\n                    }\n                }\n            }\n        }\n            .flatMap { fileRequests -> Single.zip(fileRequests) { it as Array<Any> } }\n            .map { it.map { file -> file as? File } }\n            .map { it.filterNotNull().toList() }");
        return map;
    }

    public static /* synthetic */ Boolean I0(FileList fileList) {
        return Z(fileList);
    }

    public static final FileList J(Drive driveClient, String parentId) {
        kotlin.jvm.internal.m.g(driveClient, "$driveClient");
        kotlin.jvm.internal.m.g(parentId, "$parentId");
        return (FileList) Trace_CommonKt.trace("MnemonicBackupRepository#getAllBackups drive query", new d(driveClient, parentId));
    }

    public static /* synthetic */ FileList J0(Drive drive, String str) {
        return J(drive, str);
    }

    public static final List K(final Drive driveClient, FileList fileList) {
        int r;
        kotlin.jvm.internal.m.g(driveClient, "$driveClient");
        kotlin.jvm.internal.m.g(fileList, "fileList");
        List<File> files = fileList.getFiles();
        kotlin.jvm.internal.m.f(files, "fileList.files");
        r = kotlin.a0.s.r(files, 10);
        ArrayList arrayList = new ArrayList(r);
        for (final File file : files) {
            arrayList.add(h.c.b0.fromCallable(new Callable() { // from class: e.j.i.q0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return a2.o0(Drive.this, file);
                }
            }));
        }
        return arrayList;
    }

    public static final String K0(a2 this$0, BackupPayload backup, String password) {
        byte[] n;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(backup, "$backup");
        kotlin.jvm.internal.m.g(password, "$password");
        e.j.l.o.a aVar = this$0.f13599c;
        String cipherText = backup.getCipherText();
        a.EnumC0327a enumC0327a = a.EnumC0327a.NO_WRAP;
        byte[] a2 = aVar.a(cipherText, enumC0327a);
        Objects.requireNonNull(a2, "cipherText is null");
        byte[] a3 = this$0.f13599c.a(backup.getAuthTag(), enumC0327a);
        Objects.requireNonNull(a3, "authTag is null");
        n = kotlin.a0.m.n(a2, a3);
        byte[] a4 = this$0.f13599c.a(backup.getSalt(), enumC0327a);
        Objects.requireNonNull(a4, "salt is null");
        SecretKeySpec M0 = this$0.M0(password, a4);
        byte[] a5 = this$0.f13599c.a(backup.getIv(), enumC0327a);
        Objects.requireNonNull(a5, "iv is null");
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, a5);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, M0, gCMParameterSpec);
        try {
            byte[] decryptedText = cipher.doFinal(n);
            kotlin.jvm.internal.m.f(decryptedText, "decryptedText");
            Charset forName = Charset.forName("UTF8");
            kotlin.jvm.internal.m.f(forName, "forName(\"UTF8\")");
            return new String(decryptedText, forName);
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final File L(Drive driveClient, File file) {
        kotlin.jvm.internal.m.g(driveClient, "$driveClient");
        return (File) Trace_CommonKt.trace("MnemonicBackupRepository#getAllBackups drive id query", new e(driveClient, file));
    }

    private final void L0() {
        Object obj;
        if (this.f13598b.a() && this.f13598b.c()) {
            obj = BackupStatus.BackedUpAll.INSTANCE;
        } else if (this.f13598b.a()) {
            obj = BackupStatus.BackedUpToCloud.INSTANCE;
        } else {
            obj = this.f13598b.c() ? BackupStatus.BackedUpManually.INSTANCE : BackupStatus.NotBackedUp.INSTANCE;
        }
        this.f13607k.onNext(OptionalKt.toOptional(obj));
    }

    public static final h.c.h0 M(List fileRequests) {
        kotlin.jvm.internal.m.g(fileRequests, "fileRequests");
        return h.c.b0.zip(fileRequests, new h.c.m0.n() { // from class: e.j.i.j1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return a2.H0((Object[]) obj);
            }
        });
    }

    private final SecretKeySpec M0(String str, byte[] bArr) {
        byte[] key;
        if (this.f13603g.getSdkInt() >= 26) {
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            char[] charArray = str.toCharArray();
            kotlin.jvm.internal.m.f(charArray, "(this as java.lang.String).toCharArray()");
            key = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(new PBEKeySpec(charArray, bArr, 100000, 256)).getEncoded();
        } else {
            PKCS5S2ParametersGenerator pKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator(new SHA256Digest());
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            char[] charArray2 = str.toCharArray();
            kotlin.jvm.internal.m.f(charArray2, "(this as java.lang.String).toCharArray()");
            pKCS5S2ParametersGenerator.init(PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(charArray2), bArr, 100000);
            CipherParameters generateDerivedMacParameters = pKCS5S2ParametersGenerator.generateDerivedMacParameters(256);
            Objects.requireNonNull(generateDerivedMacParameters, "null cannot be cast to non-null type org.spongycastle.crypto.params.KeyParameter");
            key = ((KeyParameter) generateDerivedMacParameters).getKey();
        }
        return new SecretKeySpec(key, "AES");
    }

    public static final Object[] N(Object[] it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it;
    }

    public static final kotlin.x N0(a2 this$0, boolean z) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.f13598b.r(z);
        this$0.L0();
        return kotlin.x.a;
    }

    public static final List O(Object[] it) {
        kotlin.jvm.internal.m.g(it, "it");
        ArrayList arrayList = new ArrayList(it.length);
        for (Object obj : it) {
            arrayList.add(obj instanceof File ? (File) obj : null);
        }
        return arrayList;
    }

    public final void O0() {
        final Drive drive = this.m;
        final String H = H();
        if (drive == null || H == null) {
            return;
        }
        h.c.b0 subscribeOn = S(drive).flatMap(new h.c.m0.n() { // from class: e.j.i.d0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return a2.b0(a2.this, drive, H, (File) obj);
            }
        }).subscribeOn(this.f13605i).doOnSuccess(new h.c.m0.f() { // from class: e.j.i.e1
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                a2.C0(a2.this, (Boolean) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.i.t0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return a2.r0(a2.this, (Boolean) obj);
            }
        }).subscribeOn(this.f13605i);
        kotlin.jvm.internal.m.f(subscribeOn, "getBackupsFolder(driveClient)\n            .flatMap { hasBackupForCurrentMnemonic(driveClient, activeMnemonicHash, it.id) }\n            .subscribeOn(concurrentScheduler)\n            .doOnSuccess { appPrefs.setHasBackedUpToCloud(it) }\n            .map { hasBackup ->\n                reloadBackupStatusFromPrefs()\n                hasBackup\n            }\n            .subscribeOn(concurrentScheduler)");
        h.c.t0.a.a(h.c.t0.g.i(subscribeOn, null, null, 3, null), V());
    }

    public static final List P(List it) {
        List V;
        List I0;
        kotlin.jvm.internal.m.g(it, "it");
        V = kotlin.a0.z.V(it);
        I0 = kotlin.a0.z.I0(V);
        return I0;
    }

    public static final h.c.h0 P0(a2 this$0, Drive drive, String str, File it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        String id = it.getId();
        kotlin.jvm.internal.m.f(id, "it.id");
        return this$0.X(drive, str, id);
    }

    private final h.c.b0<FileList> Q(final Drive drive, final String str, final String str2) {
        h.c.b0<FileList> fromCallable = h.c.b0.fromCallable(new Callable() { // from class: e.j.i.s0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a2.q0(Drive.this, str, str2);
            }
        });
        kotlin.jvm.internal.m.f(fromCallable, "fromCallable {\n            driveClient.files().list().setOrderBy(ORDER_BY_CRITERIA)\n                .setQ(\"name = '$backupName' and '$parentId' in parents and trashed = false\")\n                .setSpaces(\"drive\")\n                .execute()\n        }");
        return fromCallable;
    }

    public static final void Q0(a2 this$0, Boolean it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        e.j.j.b bVar = this$0.f13598b;
        kotlin.jvm.internal.m.f(it, "it");
        bVar.h(it.booleanValue());
    }

    public static final FileList R(Drive driveClient, String backupName, String parentId) {
        kotlin.jvm.internal.m.g(driveClient, "$driveClient");
        kotlin.jvm.internal.m.g(backupName, "$backupName");
        kotlin.jvm.internal.m.g(parentId, "$parentId");
        Drive.Files.List orderBy = driveClient.files().list().setOrderBy(ApiConstants.NAME);
        return orderBy.setQ("name = '" + backupName + "' and '" + parentId + "' in parents and trashed = false").setSpaces("drive").execute();
    }

    public static final Boolean R0(a2 this$0, Boolean hasBackup) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(hasBackup, "hasBackup");
        this$0.L0();
        return hasBackup;
    }

    private final h.c.b0<File> S(final Drive drive) {
        h.c.b0<File> flatMap = h.c.b0.fromCallable(new Callable() { // from class: e.j.i.e0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a2.c0(Drive.this);
            }
        }).subscribeOn(this.f13605i).flatMap(new h.c.m0.n() { // from class: e.j.i.v0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return a2.t0(a2.this, drive, (FileList) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "fromCallable {\n                trace(\"MnemonicBackupRepository#getBackupsFolder driveQuery\") {\n                    driveClient.files().list().setOrderBy(ORDER_BY_CRITERIA)\n                        .setQ(\"name='$FOLDER_NAME' and mimeType='$FOLDER_MIME_TYPE' and trashed = false\")\n                        .setSpaces(\"drive\")\n                        .execute()\n                }\n            }\n            .subscribeOn(concurrentScheduler)\n            .flatMap {\n                if (it.files.isEmpty()) {\n                    createBackupsFolder(driveClient)\n                } else {\n                    Single.just(it.files.firstOrNull())\n                }\n            }");
        return flatMap;
    }

    public static final FileList T(Drive driveClient) {
        kotlin.jvm.internal.m.g(driveClient, "$driveClient");
        return (FileList) Trace_CommonKt.trace("MnemonicBackupRepository#getBackupsFolder driveQuery", new f(driveClient));
    }

    public static final h.c.h0 U(a2 this$0, Drive driveClient, FileList it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(driveClient, "$driveClient");
        kotlin.jvm.internal.m.g(it, "it");
        if (it.getFiles().isEmpty()) {
            return this$0.u(driveClient);
        }
        List<File> files = it.getFiles();
        kotlin.jvm.internal.m.f(files, "it.files");
        h.c.b0 just = h.c.b0.just(kotlin.a0.p.a0(files));
        kotlin.jvm.internal.m.f(just, "{\n                    Single.just(it.files.firstOrNull())\n                }");
        return just;
    }

    private final h.c.k0.a V() {
        return (h.c.k0.a) this.f13606j.getValue();
    }

    private final h.c.s<Boolean> W() {
        h.c.s<Boolean> hide = this.f13608l.hide();
        kotlin.jvm.internal.m.f(hide, "driveClientInitializedSubject.hide()");
        return hide;
    }

    private final h.c.b0<Boolean> X(final Drive drive, final String str, final String str2) {
        return h.c.b0.fromCallable(new Callable() { // from class: e.j.i.n0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a2.l0(Drive.this, str, str2);
            }
        }).map(new h.c.m0.n() { // from class: e.j.i.k1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return a2.I0((FileList) obj);
            }
        });
    }

    public static final FileList Y(Drive driveClient, String backupName, String parentId) {
        kotlin.jvm.internal.m.g(driveClient, "$driveClient");
        kotlin.jvm.internal.m.g(backupName, "$backupName");
        kotlin.jvm.internal.m.g(parentId, "$parentId");
        Drive.Files.List orderBy = driveClient.files().list().setOrderBy(ApiConstants.NAME);
        return orderBy.setQ("name = '" + backupName + "' and '" + parentId + "' in parents and trashed = false").setSpaces("drive").execute();
    }

    public static final Boolean Z(FileList it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.valueOf(it.getFiles().size() == 1);
    }

    private final String a0(String str) {
        return e.j.f.u.d(str, "CoinbaseWallet");
    }

    public static /* synthetic */ h.c.h0 b0(a2 a2Var, Drive drive, String str, File file) {
        return P0(a2Var, drive, str, file);
    }

    public static /* synthetic */ FileList c0(Drive drive) {
        return T(drive);
    }

    public static /* synthetic */ h.c.h0 d0(a2 a2Var, Drive drive, String str, File file) {
        return w(a2Var, drive, str, file);
    }

    public static /* synthetic */ List e0(List list) {
        return E(list);
    }

    public static /* synthetic */ List f0(Object[] objArr) {
        return O(objArr);
    }

    public static /* synthetic */ void g0(a2 a2Var, BackupStatus backupStatus) {
        p(a2Var, backupStatus);
    }

    public static /* synthetic */ kotlin.x h0(a2 a2Var, Optional optional) {
        return z(a2Var, optional);
    }

    public static /* synthetic */ h.c.h0 i0(List list) {
        return M(list);
    }

    public static /* synthetic */ File j0(FileList fileList) {
        return x(fileList);
    }

    public static /* synthetic */ h.c.h0 k0(a2 a2Var, Drive drive, File file) {
        return D(a2Var, drive, file);
    }

    public static final h.c.h0 l(a2 this$0, Drive driveClient, String fileName, Map encryptedPayloadChunks, File it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(driveClient, "$driveClient");
        kotlin.jvm.internal.m.g(fileName, "$fileName");
        kotlin.jvm.internal.m.g(encryptedPayloadChunks, "$encryptedPayloadChunks");
        kotlin.jvm.internal.m.g(it, "it");
        String id = it.getId();
        kotlin.jvm.internal.m.f(id, "it.id");
        return this$0.s(driveClient, fileName, id, encryptedPayloadChunks);
    }

    public static /* synthetic */ FileList l0(Drive drive, String str, String str2) {
        return Y(drive, str, str2);
    }

    public static final void m(Throwable th) {
        l.a.a.f(th, "Error while backing up mnemonic", new Object[0]);
    }

    public static /* synthetic */ Boolean m0(a2 a2Var, BackupStatus backupStatus) {
        return q(a2Var, backupStatus);
    }

    public static final void n(a2 this$0, String fileName, File file) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(fileName, "$fileName");
        this$0.f13598b.h(true);
        this$0.i(fileName);
    }

    public static /* synthetic */ void n0(a2 a2Var, String str, File file) {
        n(a2Var, str, file);
    }

    public static final BackupStatus o(a2 this$0, File it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.f13598b.c() ? BackupStatus.BackedUpAll.INSTANCE : BackupStatus.BackedUpToCloud.INSTANCE;
    }

    public static /* synthetic */ File o0(Drive drive, File file) {
        return L(drive, file);
    }

    public static final void p(a2 this$0, BackupStatus backupStatus) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.f13607k.onNext(OptionalKt.toOptional(backupStatus));
    }

    public static /* synthetic */ h.c.h0 p0(a2 a2Var, Drive drive, String str, Map map, File file) {
        return l(a2Var, drive, str, map, file);
    }

    public static final Boolean q(a2 this$0, BackupStatus it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.valueOf(this$0.f13598b.a());
    }

    public static /* synthetic */ FileList q0(Drive drive, String str, String str2) {
        return R(drive, str, str2);
    }

    public static final h.c.h0 r(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return h.c.b0.error(it);
    }

    public static /* synthetic */ Boolean r0(a2 a2Var, Boolean bool) {
        return R0(a2Var, bool);
    }

    private final h.c.b0<File> s(final Drive drive, final String str, final String str2, final Map<String, String> map) {
        h.c.b0 map2 = Q(drive, str, str2).subscribeOn(this.f13605i).map(new h.c.m0.n() { // from class: e.j.i.w0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return a2.u0(Drive.this, str, str2, map, (FileList) obj);
            }
        });
        kotlin.jvm.internal.m.f(map2, "getBackupIfExists(driveClient, backupName, parentId)\n            .subscribeOn(concurrentScheduler)\n            .map {\n                if (it.files.isEmpty()) {\n                    val file = File().apply {\n                        name = backupName\n                        parents = listOf(parentId)\n                        appProperties = payload\n                    }\n                    driveClient.files().create(file)\n                        .setFields(\"id, parents\")\n                        .execute()\n                } else {\n                    it.files.first()\n                }\n            }");
        return map2;
    }

    public static /* synthetic */ File s0(Drive drive, File file) {
        return v(drive, file);
    }

    public static final File t(Drive driveClient, String backupName, String parentId, Map payload, FileList it) {
        List<String> b2;
        kotlin.jvm.internal.m.g(driveClient, "$driveClient");
        kotlin.jvm.internal.m.g(backupName, "$backupName");
        kotlin.jvm.internal.m.g(parentId, "$parentId");
        kotlin.jvm.internal.m.g(payload, "$payload");
        kotlin.jvm.internal.m.g(it, "it");
        if (it.getFiles().isEmpty()) {
            File file = new File();
            file.setName(backupName);
            b2 = kotlin.a0.q.b(parentId);
            file.setParents(b2);
            file.setAppProperties(payload);
            return driveClient.files().create(file).setFields2("id, parents").execute();
        }
        List<File> files = it.getFiles();
        kotlin.jvm.internal.m.f(files, "it.files");
        return (File) kotlin.a0.p.Y(files);
    }

    public static /* synthetic */ h.c.h0 t0(a2 a2Var, Drive drive, FileList fileList) {
        return U(a2Var, drive, fileList);
    }

    private final h.c.b0<File> u(final Drive drive) {
        Map<String, String> m;
        final File file = new File();
        file.setMimeType("application/vnd.google-apps.folder");
        file.setName("CoinbaseWalletBackups");
        m = kotlin.a0.m0.m(kotlin.u.a("creator", "cb-wallet"));
        file.setAppProperties(m);
        h.c.b0<File> fromCallable = h.c.b0.fromCallable(new Callable() { // from class: e.j.i.u0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a2.s0(Drive.this, file);
            }
        });
        kotlin.jvm.internal.m.f(fromCallable, "fromCallable {\n            driveClient.files().create(fileMetadata)\n                .setFields(\"id\")\n                .execute()\n        }");
        return fromCallable;
    }

    public static /* synthetic */ File u0(Drive drive, String str, String str2, Map map, FileList fileList) {
        return t(drive, str, str2, map, fileList);
    }

    public static final File v(Drive driveClient, File fileMetadata) {
        kotlin.jvm.internal.m.g(driveClient, "$driveClient");
        kotlin.jvm.internal.m.g(fileMetadata, "$fileMetadata");
        return driveClient.files().create(fileMetadata).setFields2("id").execute();
    }

    public static /* synthetic */ void v0(Throwable th) {
        m(th);
    }

    public static final h.c.h0 w(a2 this$0, Drive driveClient, String backupName, File it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(driveClient, "$driveClient");
        kotlin.jvm.internal.m.g(backupName, "$backupName");
        kotlin.jvm.internal.m.g(it, "it");
        String id = it.getId();
        kotlin.jvm.internal.m.f(id, "it.id");
        return this$0.Q(driveClient, backupName, id);
    }

    public static /* synthetic */ h.c.h0 w0(Throwable th) {
        return r(th);
    }

    public static final File x(FileList it) {
        kotlin.jvm.internal.m.g(it, "it");
        List<File> files = it.getFiles();
        kotlin.jvm.internal.m.f(files, "it.files");
        return (File) kotlin.a0.p.a0(files);
    }

    public static /* synthetic */ String x0(a2 a2Var, BackupPayload backupPayload, String str) {
        return K0(a2Var, backupPayload, str);
    }

    public static final h.c.h0 y(a2 this$0, Drive driveClient, File it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(driveClient, "$driveClient");
        kotlin.jvm.internal.m.g(it, "it");
        String id = it.getId();
        kotlin.jvm.internal.m.f(id, "it.id");
        return this$0.A(driveClient, id);
    }

    public static /* synthetic */ kotlin.x y0(a2 a2Var, boolean z) {
        return N0(a2Var, z);
    }

    public static final kotlin.x z(a2 this$0, Optional it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.O0();
        return kotlin.x.a;
    }

    public static /* synthetic */ List z0(Drive drive, FileList fileList) {
        return K(drive, fileList);
    }

    public final String C(String password, String mnemonic, String username) {
        byte[] h2;
        byte[] h3;
        kotlin.jvm.internal.m.g(password, "password");
        kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
        kotlin.jvm.internal.m.g(username, "username");
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        byte[] bArr2 = new byte[12];
        new SecureRandom().nextBytes(bArr2);
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr2);
        SecretKeySpec M0 = M0(password, bArr);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, M0, gCMParameterSpec);
        byte[] bytes = mnemonic.getBytes(kotlin.l0.d.a);
        kotlin.jvm.internal.m.f(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] cipherTextWithAuthTag = cipher.doFinal(bytes);
        kotlin.jvm.internal.m.f(cipherTextWithAuthTag, "cipherTextWithAuthTag");
        h2 = kotlin.a0.m.h(cipherTextWithAuthTag, 0, cipherTextWithAuthTag.length - 16);
        h3 = kotlin.a0.m.h(cipherTextWithAuthTag, cipherTextWithAuthTag.length - 16, cipherTextWithAuthTag.length);
        String timestamp = this.f13600d.format(new Date());
        String a2 = e.j.f.f.a(bArr);
        String a3 = e.j.f.f.a(bArr2);
        String a4 = e.j.f.f.a(h2);
        String a5 = e.j.f.f.a(h3);
        String a0 = a0(mnemonic);
        kotlin.jvm.internal.m.f(timestamp, "timestamp");
        String json = new BackupPayloadJsonAdapter(this.f13601e).toJson(new BackupPayload(a2, a3, a4, a5, a0, timestamp, username));
        kotlin.jvm.internal.m.f(json, "BackupPayloadJsonAdapter(moshi).toJson(backupPayload)");
        return json;
    }

    public String H() {
        return (String) this.f13602f.get(StoreKeys_ApplicationKt.getActiveMnemonicHash(StoreKeys.INSTANCE));
    }

    @Override // e.j.i.i2.d
    public h.c.b0<List<BackupPayload>> a() {
        final Drive drive = this.m;
        if (drive == null) {
            h.c.b0<List<BackupPayload>> error = h.c.b0.error(new IllegalStateException("Drive client not initialized"));
            kotlin.jvm.internal.m.f(error, "error(IllegalStateException(\"Drive client not initialized\"))");
            return error;
        }
        h.c.b0<List<BackupPayload>> map = S(drive).flatMap(new h.c.m0.n() { // from class: e.j.i.m0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return a2.k0(a2.this, drive, (File) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.i.g0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return a2.e0((List) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.i.g1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return a2.E0(a2.this, (List) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.i.f1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return a2.D0(a2.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "getBackupsFolder(driveClient)\n            .flatMap { getAllBackups(driveClient, it.id) }\n            .map { files ->\n                files.map { file ->\n                    val payload = StringBuilder()\n                    file.appProperties.keys\n                        .toList()\n                        .sorted()\n                        .forEach { s -> payload.append(file.appProperties[s]) }\n                    payload.toString()\n                }\n            }\n            .map { files -> files.mapNotNull { BackupPayloadJsonAdapter(moshi).fromJson(it) } }\n            .map { backups ->\n                backups.sortedByDescending {\n                    try {\n                        simpleDateFormat.parse(it.timestamp).time\n                    } catch (e: ParseException) {\n                        0L\n                    }\n                }\n            }");
        return map;
    }

    @Override // e.j.i.i2.d
    public h.c.b0<kotlin.x> b(final boolean z) {
        h.c.b0<kotlin.x> fromCallable = h.c.b0.fromCallable(new Callable() { // from class: e.j.i.a1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a2.y0(a2.this, z);
            }
        });
        kotlin.jvm.internal.m.f(fromCallable, "fromCallable {\n        appPrefs.setHasBackedUpPhrase(hasBackedUpManually)\n        reloadBackupStatusFromPrefs()\n    }");
        return fromCallable;
    }

    @Override // e.j.i.i2.d
    public h.c.c c(final String backupName) {
        kotlin.jvm.internal.m.g(backupName, "backupName");
        final Drive drive = this.m;
        if (drive == null) {
            h.c.c q = h.c.c.q(new IllegalStateException("Drive client not initialized"));
            kotlin.jvm.internal.m.f(q, "error(IllegalStateException(\"Drive client not initialized\"))");
            return q;
        }
        h.c.b0 flatMap = S(drive).subscribeOn(this.f13605i).flatMap(new h.c.m0.n() { // from class: e.j.i.f0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return a2.d0(a2.this, drive, backupName, (File) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.i.l0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return a2.j0((FileList) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: e.j.i.c1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return a2.A0(a2.this, drive, (File) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "getBackupsFolder(driveClient)\n            .subscribeOn(concurrentScheduler)\n            .flatMap { getBackupIfExists(driveClient, backupName, it.id) }\n            .map { it.files.firstOrNull() }\n            .flatMap { deleteBackupFromDrive(driveClient, it.id) }");
        h.c.c ignoreElement = Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null).map(new h.c.m0.n() { // from class: e.j.i.j0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return a2.h0(a2.this, (Optional) obj);
            }
        }).ignoreElement();
        kotlin.jvm.internal.m.f(ignoreElement, "getBackupsFolder(driveClient)\n            .subscribeOn(concurrentScheduler)\n            .flatMap { getBackupIfExists(driveClient, backupName, it.id) }\n            .map { it.files.firstOrNull() }\n            .flatMap { deleteBackupFromDrive(driveClient, it.id) }\n            .logError()\n            .map { syncBackupStatusFromCloud() }\n            .ignoreElement()");
        return ignoreElement;
    }

    @Override // e.j.i.i2.d
    public boolean d() {
        return this.f13598b.c() || this.f13598b.a();
    }

    @Override // e.j.i.i2.d
    public void destroy() {
        this.f13607k.onNext(new Optional<>(BackupStatus.NotBackedUp.INSTANCE));
    }

    @Override // e.j.i.i2.d
    public void e(Drive drive) {
        kotlin.jvm.internal.m.g(drive, "drive");
        this.m = drive;
        this.f13608l.onNext(Boolean.TRUE);
    }

    @Override // e.j.i.i2.d
    public h.c.s<Optional<BackupStatus>> f() {
        h.c.s<Optional<BackupStatus>> hide = this.f13607k.hide();
        kotlin.jvm.internal.m.f(hide, "backupStatusSubject.hide()");
        return hide;
    }

    @Override // e.j.i.i2.d
    public h.c.b0<Boolean> g(String password, String mnemonic, String username) {
        List<String> i1;
        kotlin.jvm.internal.m.g(password, "password");
        kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
        kotlin.jvm.internal.m.g(username, "username");
        final Drive drive = this.m;
        if (drive == null) {
            h.c.b0<Boolean> error = h.c.b0.error(new IllegalStateException("Drive client not initialized"));
            kotlin.jvm.internal.m.f(error, "error(IllegalStateException(\"Drive client not initialized\"))");
            return error;
        }
        final String a0 = a0(mnemonic);
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        i1 = kotlin.l0.a0.i1(C(password, mnemonic, username), 100);
        int i2 = 0;
        for (Object obj : i1) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a0.r.q();
            }
            linkedHashMap.put(String.valueOf(i2), (String) obj);
            i2 = i3;
        }
        h.c.b0 map = S(drive).subscribeOn(this.f13605i).flatMap(new h.c.m0.n() { // from class: e.j.i.r0
            @Override // h.c.m0.n
            public final Object apply(Object obj2) {
                return a2.p0(a2.this, drive, a0, linkedHashMap, (File) obj2);
            }
        }).doOnError(new h.c.m0.f() { // from class: e.j.i.x0
            @Override // h.c.m0.f
            public final void accept(Object obj2) {
                a2.v0((Throwable) obj2);
            }
        }).doOnSuccess(new h.c.m0.f() { // from class: e.j.i.p0
            @Override // h.c.m0.f
            public final void accept(Object obj2) {
                a2.n0(a2.this, a0, (File) obj2);
            }
        }).map(new h.c.m0.n() { // from class: e.j.i.d1
            @Override // h.c.m0.n
            public final Object apply(Object obj2) {
                return a2.B0(a2.this, (File) obj2);
            }
        }).doOnSuccess(new h.c.m0.f() { // from class: e.j.i.i0
            @Override // h.c.m0.f
            public final void accept(Object obj2) {
                a2.g0(a2.this, (BackupStatus) obj2);
            }
        }).map(new h.c.m0.n() { // from class: e.j.i.o0
            @Override // h.c.m0.n
            public final Object apply(Object obj2) {
                return a2.m0(a2.this, (BackupStatus) obj2);
            }
        });
        kotlin.jvm.internal.m.f(map, "getBackupsFolder(driveClient)\n            .subscribeOn(concurrentScheduler)\n            .flatMap { createBackup(driveClient, fileName, it.id, encryptedPayloadChunks) }\n            .doOnError { Timber.e(it, \"Error while backing up mnemonic\") }\n            .doOnSuccess {\n                appPrefs.setHasBackedUpToCloud(true)\n                activeMnemonicHash = fileName\n            }\n            .map { if (appPrefs.hasBackedUpPhrase()) BackupStatus.BackedUpAll else BackupStatus.BackedUpToCloud }\n            .doOnSuccess { backupStatusSubject.onNext(it.toOptional()) }\n            .map { appPrefs.hasBackedUpToCloud() }");
        h.c.b0<Boolean> onErrorResumeNext = Single_AnalyticsKt.logError$default(map, "Error while backing up mnemonic", null, 2, null).onErrorResumeNext(new h.c.m0.n() { // from class: e.j.i.y0
            @Override // h.c.m0.n
            public final Object apply(Object obj2) {
                return a2.w0((Throwable) obj2);
            }
        });
        kotlin.jvm.internal.m.f(onErrorResumeNext, "getBackupsFolder(driveClient)\n            .subscribeOn(concurrentScheduler)\n            .flatMap { createBackup(driveClient, fileName, it.id, encryptedPayloadChunks) }\n            .doOnError { Timber.e(it, \"Error while backing up mnemonic\") }\n            .doOnSuccess {\n                appPrefs.setHasBackedUpToCloud(true)\n                activeMnemonicHash = fileName\n            }\n            .map { if (appPrefs.hasBackedUpPhrase()) BackupStatus.BackedUpAll else BackupStatus.BackedUpToCloud }\n            .doOnSuccess { backupStatusSubject.onNext(it.toOptional()) }\n            .map { appPrefs.hasBackedUpToCloud() }\n            .logError(\"Error while backing up mnemonic\")\n            .onErrorResumeNext { Single.error(it) }");
        return onErrorResumeNext;
    }

    @Override // e.j.i.i2.d
    public h.c.b0<String> h(final String password, final BackupPayload backup) {
        kotlin.jvm.internal.m.g(password, "password");
        kotlin.jvm.internal.m.g(backup, "backup");
        h.c.b0<String> subscribeOn = h.c.b0.fromCallable(new Callable() { // from class: e.j.i.z0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a2.x0(a2.this, backup, password);
            }
        }).subscribeOn(this.f13605i);
        kotlin.jvm.internal.m.f(subscribeOn, "fromCallable {\n            val cipherText = base64Util.decode(backup.cipherText, Base64Interface.Flag.NO_WRAP)\n                ?: throw NullPointerException(\"cipherText is null\")\n            val authTag = base64Util.decode(backup.authTag, Base64Interface.Flag.NO_WRAP)\n                ?: throw NullPointerException(\"authTag is null\")\n            val encryptedData = cipherText + authTag\n\n            val salt = base64Util.decode(backup.salt, Base64Interface.Flag.NO_WRAP)\n                ?: throw NullPointerException(\"salt is null\")\n            val secretKey = secretKey(password, salt)\n\n            val iv = base64Util.decode(backup.iv, Base64Interface.Flag.NO_WRAP)\n                ?: throw NullPointerException(\"iv is null\")\n            val gcmSpec = GCMParameterSpec(AUTH_TAG_SIZE, iv)\n            val cipher = Cipher.getInstance(CIPHER_DERIVATION_PATH)\n            cipher.init(Cipher.DECRYPT_MODE, secretKey, gcmSpec)\n\n            try {\n                val decryptedText = cipher.doFinal(encryptedData)\n                return@fromCallable String(decryptedText, Charset.forName(\"UTF8\"))\n            } catch (e: Exception) {\n                throw e\n            }\n        }\n        .subscribeOn(concurrentScheduler)");
        return subscribeOn;
    }

    @Override // e.j.i.i2.d
    public void i(String str) {
        this.f13602f.set(StoreKeys_ApplicationKt.getActiveMnemonicHash(StoreKeys.INSTANCE), str);
    }

    @Override // e.j.i.i2.d
    public void start() {
        L0();
        h.c.s<Boolean> observeOn = W().subscribeOn(this.f13605i).observeOn(this.f13604h);
        kotlin.jvm.internal.m.f(observeOn, "driveClientInitializedObservable\n            .subscribeOn(concurrentScheduler)\n            .observeOn(mainScheduler)");
        h.c.t0.a.a(h.c.t0.g.h(Observable_AnalyticsKt.logError$default(observeOn, "Error while observing backups", null, 2, null), null, null, new g(), 3, null), V());
    }
}