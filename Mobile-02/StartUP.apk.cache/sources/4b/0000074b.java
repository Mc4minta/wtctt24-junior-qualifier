package com.appsflyer.internal.referrer;

import android.content.Context;
import com.appsflyer.internal.ContentFetcher;
import java.util.Map;

/* loaded from: classes.dex */
public class HuaweiReferrer extends ContentFetcher<Map<String, Object>> {
    public Map<String, Object> map;

    /* renamed from: ɩ  reason: contains not printable characters */
    private Runnable f291;

    public HuaweiReferrer(Runnable runnable, Context context) {
        super(context, "com.huawei.appmarket.commondata", "ffe391e0ea186d0734ed601e4e70e3224b7309d48e2075bac46d8c667eae7212", 0L);
        this.f291 = runnable;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0086, code lost:
        if (r3 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0092, code lost:
        if (0 == 0) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0094, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0097, code lost:
        r12.map = r2;
        r12.f291.run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x009e, code lost:
        return r2;
     */
    @Override // com.appsflyer.internal.ContentFetcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, java.lang.Object> query() {
        /*
            r12 = this;
            java.lang.String r0 = "FEATURE_NOT_SUPPORTED"
            java.lang.String r1 = "response"
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r3 = "source"
            java.lang.String r4 = "huawei"
            r2.put(r3, r4)
            com.appsflyer.internal.referrer.MandatoryFields r3 = new com.appsflyer.internal.referrer.MandatoryFields
            r3.<init>()
            r2.putAll(r3)
            r3 = 0
            android.content.Context r4 = r12.context     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            android.content.ContentResolver r5 = r4.getContentResolver()     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            java.lang.String r6 = "content://"
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            java.lang.String r6 = r12.authority     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            r4.append(r6)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            java.lang.String r6 = "/item/5"
            r4.append(r6)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            android.net.Uri r6 = android.net.Uri.parse(r4)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            r7 = 0
            r8 = 0
            r4 = 1
            java.lang.String[] r9 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            android.content.Context r10 = r12.context     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            java.lang.String r10 = r10.getPackageName()     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            r11 = 0
            r9[r11] = r10     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            r10 = 0
            android.database.Cursor r3 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            if (r3 == 0) goto L81
            boolean r5 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            if (r5 == 0) goto L7d
            java.lang.String r5 = "OK"
            r2.put(r1, r5)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            java.lang.String r5 = "referrer"
            java.lang.String r6 = r3.getString(r11)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            java.lang.String r5 = "install_begin_ts"
            long r6 = r3.getLong(r4)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            r2.put(r5, r4)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            java.lang.String r4 = "install_end_ts"
            r5 = 2
            long r5 = r3.getLong(r5)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            r2.put(r4, r5)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            goto L86
        L7d:
            r2.put(r1, r0)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
            goto L86
        L81:
            java.lang.String r4 = "SERVICE_UNAVAILABLE"
            r2.put(r1, r4)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8b
        L86:
            if (r3 == 0) goto L97
            goto L94
        L89:
            r0 = move-exception
            goto L9f
        L8b:
            r4 = move-exception
            r2.put(r1, r0)     // Catch: java.lang.Throwable -> L89
            r12.onError(r4)     // Catch: java.lang.Throwable -> L89
            if (r3 == 0) goto L97
        L94:
            r3.close()
        L97:
            r12.map = r2
            java.lang.Runnable r0 = r12.f291
            r0.run()
            return r2
        L9f:
            if (r3 == 0) goto La4
            r3.close()
        La4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.referrer.HuaweiReferrer.query():java.util.Map");
    }
}