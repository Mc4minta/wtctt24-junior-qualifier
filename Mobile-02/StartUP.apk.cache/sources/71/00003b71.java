package com.google.firebase.perf.internal;

import androidx.annotation.Keep;
import com.google.android.gms.internal.p000firebaseperf.k0;
import com.google.android.gms.internal.p000firebaseperf.p0;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
@Keep
/* loaded from: classes2.dex */
public class RemoteConfigManager {
    private static final RemoteConfigManager zzer = new RemoteConfigManager();
    private static final long zzes = TimeUnit.HOURS.toMillis(12);
    private final Executor executor;
    private k0 zzaj;
    private long zzet;
    private com.google.firebase.remoteconfig.e zzeu;

    private RemoteConfigManager() {
        this(new ThreadPoolExecutor(0, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue()), null);
    }

    public static RemoteConfigManager zzci() {
        return zzer;
    }

    private final boolean zzck() {
        return this.zzeu != null;
    }

    private final com.google.firebase.remoteconfig.h zzl(String str) {
        if (zzck()) {
            if (System.currentTimeMillis() - this.zzet > zzes) {
                this.zzet = System.currentTimeMillis();
                this.zzeu.d().e(this.executor, new com.google.android.gms.tasks.d(this) { // from class: com.google.firebase.perf.internal.x
                    private final RemoteConfigManager a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.a = this;
                    }

                    @Override // com.google.android.gms.tasks.d
                    public final void c(Exception exc) {
                        this.a.zza(exc);
                    }
                });
            }
        }
        if (zzck()) {
            com.google.firebase.remoteconfig.h f2 = this.zzeu.f(str);
            if (f2.getSource() == 2) {
                this.zzaj.c(String.format("Fetched value: '%s' for key: '%s' from Firebase Remote Config.", f2.asString(), str));
                return f2;
            }
            return null;
        }
        return null;
    }

    public final void zza(com.google.firebase.remoteconfig.e eVar) {
        this.zzeu = eVar;
    }

    public final p0<Boolean> zzb(String str) {
        if (str == null) {
            this.zzaj.c("The key to get Remote Config boolean value is null.");
            return p0.e();
        }
        com.google.firebase.remoteconfig.h zzl = zzl(str);
        if (zzl != null) {
            try {
                return p0.c(Boolean.valueOf(zzl.asBoolean()));
            } catch (IllegalArgumentException unused) {
                if (!zzl.asString().isEmpty()) {
                    this.zzaj.c(String.format("Could not parse value: '%s' for key: '%s'.", zzl.asString(), str));
                }
            }
        }
        return p0.e();
    }

    public final p0<String> zzc(String str) {
        if (str == null) {
            this.zzaj.c("The key to get Remote Config String value is null.");
            return p0.e();
        }
        com.google.firebase.remoteconfig.h zzl = zzl(str);
        if (zzl != null) {
            return p0.c(zzl.asString());
        }
        return p0.e();
    }

    public final boolean zzcj() {
        com.google.firebase.remoteconfig.e eVar = this.zzeu;
        return eVar == null || eVar.e().a() == 1;
    }

    public final p0<Float> zzd(String str) {
        if (str == null) {
            this.zzaj.c("The key to get Remote Config float value is null.");
            return p0.e();
        }
        com.google.firebase.remoteconfig.h zzl = zzl(str);
        if (zzl != null) {
            try {
                return p0.c(Float.valueOf(Double.valueOf(zzl.asDouble()).floatValue()));
            } catch (IllegalArgumentException unused) {
                if (!zzl.asString().isEmpty()) {
                    this.zzaj.c(String.format("Could not parse value: '%s' for key: '%s'.", zzl.asString(), str));
                }
            }
        }
        return p0.e();
    }

    public final p0<Long> zze(String str) {
        if (str == null) {
            this.zzaj.c("The key to get Remote Config long value is null.");
            return p0.e();
        }
        com.google.firebase.remoteconfig.h zzl = zzl(str);
        if (zzl != null) {
            try {
                return p0.c(Long.valueOf(zzl.a()));
            } catch (IllegalArgumentException unused) {
                if (!zzl.asString().isEmpty()) {
                    this.zzaj.c(String.format("Could not parse value: '%s' for key: '%s'.", zzl.asString(), str));
                }
            }
        }
        return p0.e();
    }

    private RemoteConfigManager(Executor executor, com.google.firebase.remoteconfig.e eVar) {
        this.zzet = 0L;
        this.executor = executor;
        this.zzeu = null;
        this.zzaj = k0.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [T] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v5 */
    public final <T> T zza(String str, T t) {
        com.google.firebase.remoteconfig.h zzl = zzl(str);
        if (zzl != null) {
            try {
                if (t instanceof Boolean) {
                    t = (T) Boolean.valueOf(zzl.asBoolean());
                } else if (t instanceof Float) {
                    t = Float.valueOf(Double.valueOf(zzl.asDouble()).floatValue());
                } else {
                    if (!(t instanceof Long) && !(t instanceof Integer)) {
                        if (t instanceof String) {
                            t = zzl.asString();
                        } else {
                            String asString = zzl.asString();
                            try {
                                this.zzaj.c(String.format("No matching type found for the defaultValue: '%s', using String.", t));
                                t = asString;
                            } catch (IllegalArgumentException unused) {
                                t = (T) asString;
                                if (!zzl.asString().isEmpty()) {
                                    this.zzaj.c(String.format("Could not parse value: '%s' for key: '%s'.", zzl.asString(), str));
                                }
                                return (T) t;
                            }
                        }
                    }
                    t = Long.valueOf(zzl.a());
                }
            } catch (IllegalArgumentException unused2) {
            }
        }
        return (T) t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Exception exc) {
        this.zzet = 0L;
    }
}