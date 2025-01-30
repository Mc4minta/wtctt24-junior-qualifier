package com.facebook.common.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.HttpHost;

/* compiled from: UriUtil.java */
/* loaded from: classes2.dex */
public class e {
    private static final Uri a = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo");

    public static String a(ContentResolver contentResolver, Uri uri) {
        int columnIndex;
        Cursor cursor = null;
        r1 = null;
        r1 = null;
        String string = null;
        if (h(uri)) {
            try {
                Cursor query = contentResolver.query(uri, null, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_data")) != -1) {
                            string = query.getString(columnIndex);
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (query != null) {
                    query.close();
                    return string;
                }
                return string;
            } catch (Throwable th2) {
                th = th2;
            }
        } else if (i(uri)) {
            return uri.getPath();
        } else {
            return null;
        }
    }

    public static String b(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.getScheme();
    }

    public static Uri c(int i2) {
        return new Uri.Builder().scheme("res").path(String.valueOf(i2)).build();
    }

    public static boolean d(Uri uri) {
        return "data".equals(b(uri));
    }

    public static boolean e(Uri uri) {
        return "asset".equals(b(uri));
    }

    public static boolean f(Uri uri) {
        String uri2 = uri.toString();
        return uri2.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || uri2.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString());
    }

    public static boolean g(Uri uri) {
        return h(uri) && "com.android.contacts".equals(uri.getAuthority()) && !uri.getPath().startsWith(a.getPath());
    }

    public static boolean h(Uri uri) {
        return "content".equals(b(uri));
    }

    public static boolean i(Uri uri) {
        return "file".equals(b(uri));
    }

    public static boolean j(Uri uri) {
        return "res".equals(b(uri));
    }

    public static boolean k(Uri uri) {
        String b2 = b(uri);
        return "https".equals(b2) || HttpHost.DEFAULT_SCHEME_NAME.equals(b2);
    }

    public static boolean l(Uri uri) {
        return "android.resource".equals(b(uri));
    }

    public static URL m(Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            return new URL(uri.toString());
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }
}