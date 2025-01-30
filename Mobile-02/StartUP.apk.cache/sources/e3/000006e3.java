package com.appsflyer;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import com.appsflyer.share.Constants;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.http.cookie.ClientCookie;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2ParameterSpec;

/* loaded from: classes.dex */
public class AndroidUtils {
    public static boolean isPermissionAvailable(Context context, String str) {
        if (str != null) {
            int checkPermission = context.checkPermission(str, Process.myPid(), Process.myUid());
            StringBuilder sb = new StringBuilder("is Permission Available: ");
            sb.append(str);
            sb.append("; res: ");
            sb.append(checkPermission);
            AFLogger.afRDLog(sb.toString());
            return checkPermission == 0;
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static String signature(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException, CertificateException, NoSuchAlgorithmException {
        Signature[] signatureArr = packageManager.getPackageInfo(str, 64).signatures;
        MessageDigest messageDigest = MessageDigest.getInstance(McElieceCCA2ParameterSpec.DEFAULT_MD);
        messageDigest.update(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getEncoded());
        return String.format("%032X", new BigInteger(1, messageDigest.digest()));
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    public static boolean m34(Context context, Intent intent) {
        return context.getPackageManager().queryIntentServices(intent, 0).size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ι  reason: contains not printable characters */
    public static Map<String, String> m35(Context context, Map<String, String> map, Uri uri) {
        boolean z;
        String[] split;
        int i2;
        if (uri.getQuery() != null) {
            z = false;
            for (String str : uri.getQuery().split("&")) {
                int indexOf = str.indexOf("=");
                String substring = indexOf > 0 ? str.substring(0, indexOf) : str;
                if (!map.containsKey(substring)) {
                    if (substring.equals(Constants.URL_CAMPAIGN)) {
                        substring = "campaign";
                    } else if (substring.equals(Constants.URL_MEDIA_SOURCE)) {
                        substring = "media_source";
                    } else if (substring.equals("af_prt")) {
                        z = true;
                        substring = "agency";
                    }
                    map.put(substring, "");
                }
                map.put(substring, (indexOf <= 0 || str.length() <= (i2 = indexOf + 1)) ? null : str.substring(i2));
            }
        } else {
            z = false;
        }
        try {
            if (!map.containsKey("install_time")) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                long j2 = packageInfo.firstInstallTime;
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                map.put("install_time", simpleDateFormat.format(new Date(j2)));
            }
        } catch (Exception e2) {
            AFLogger.afErrorLog("Could not fetch install time. ", e2);
        }
        if (uri.getQueryParameter("af_deeplink") != null && !map.containsKey("af_status")) {
            map.put("af_status", "Non-organic");
        }
        if (z) {
            map.remove("media_source");
        }
        String path = uri.getPath();
        if (path != null) {
            map.put(ClientCookie.PATH_ATTR, path);
        }
        String scheme = uri.getScheme();
        if (scheme != null) {
            map.put("scheme", scheme);
        }
        String host = uri.getHost();
        if (host != null) {
            map.put("host", host);
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ɩ  reason: contains not printable characters */
    public static boolean m33() {
        return Build.BRAND.equals("OPPO");
    }
}