package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import com.appsflyer.AFLogger;
import com.appsflyer.AndroidUtils;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public abstract class ContentFetcher<T> {
    public final String authority;
    public final Context context;

    /* renamed from: ı  reason: contains not printable characters */
    private final String f144;

    /* renamed from: ǃ  reason: contains not printable characters */
    private final long f145;

    /* renamed from: ι  reason: contains not printable characters */
    private FutureTask<T> f146 = new FutureTask<>(new Callable<T>() { // from class: com.appsflyer.internal.ContentFetcher.2
        @Override // java.util.concurrent.Callable
        public final T call() {
            if (ContentFetcher.this.valid()) {
                return (T) ContentFetcher.this.query();
            }
            return null;
        }
    });

    public ContentFetcher(Context context, String str, String str2, long j2) {
        this.context = context;
        this.authority = str;
        this.f144 = str2;
        this.f145 = j2;
    }

    public T get() {
        try {
            return this.f146.get(this.f145, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            onError(e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onError(Exception exc) {
        AFLogger.afErrorLog(getClass().getSimpleName(), exc);
    }

    protected abstract T query();

    public void start() {
        new Thread(this.f146).start();
    }

    public boolean valid() {
        try {
            ProviderInfo resolveContentProvider = this.context.getPackageManager().resolveContentProvider(this.authority, 128);
            if (resolveContentProvider != null) {
                return AndroidUtils.signature(this.context.getPackageManager(), ((PackageItemInfo) resolveContentProvider).packageName).equalsIgnoreCase(this.f144);
            }
            return false;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException | CertificateException e2) {
            onError(e2);
            return false;
        }
    }
}