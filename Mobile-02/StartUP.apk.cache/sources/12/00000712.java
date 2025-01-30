package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.appsflyer.AndroidUtils;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* loaded from: classes.dex */
public class EventDataCollector {

    /* renamed from: ǃ  reason: contains not printable characters */
    private final Context f148;

    public EventDataCollector(Context context) {
        this.f148 = context;
    }

    public long bootTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public String disk() {
        long availableBlocks;
        long blockCount;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
        if (Build.VERSION.SDK_INT >= 18) {
            long blockSizeLong = statFs.getBlockSizeLong();
            availableBlocks = statFs.getAvailableBlocksLong() * blockSizeLong;
            blockCount = statFs.getBlockCountLong() * blockSizeLong;
        } else {
            int blockSize = statFs.getBlockSize();
            availableBlocks = statFs.getAvailableBlocks() * blockSize;
            blockCount = statFs.getBlockCount() * blockSize;
        }
        double pow = Math.pow(2.0d, 20.0d);
        StringBuilder sb = new StringBuilder();
        sb.append((long) (availableBlocks / pow));
        sb.append("/");
        sb.append((long) (blockCount / pow));
        return sb.toString();
    }

    public String signature() throws CertificateException, NoSuchAlgorithmException, PackageManager.NameNotFoundException {
        return AndroidUtils.signature(this.f148.getPackageManager(), this.f148.getPackageName());
    }
}