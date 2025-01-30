package com.appsflyer.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: classes.dex */
public final class ac extends ContentFetcher<String> {
    public ac(Context context) {
        super(context, "com.facebook.katana.provider.AttributionIdProvider", "e3f9e1e0cf99d0e56a055ba65e241b3399f7cea524326b0cdd6ec1327ed0fdc1", 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.appsflyer.internal.ContentFetcher
    /* renamed from: ǃ  reason: contains not printable characters */
    public String query() {
        Cursor cursor;
        Throwable th;
        try {
            ContentResolver contentResolver = this.context.getContentResolver();
            StringBuilder sb = new StringBuilder("content://");
            sb.append(this.authority);
            cursor = contentResolver.query(Uri.parse(sb.toString()), new String[]{"aid"}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndex("aid"));
                        cursor.close();
                        return string;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
        }
    }

    @Override // com.appsflyer.internal.ContentFetcher
    public final /* synthetic */ String get() {
        start();
        return (String) super.get();
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    public final String m122() {
        start();
        return (String) super.get();
    }
}