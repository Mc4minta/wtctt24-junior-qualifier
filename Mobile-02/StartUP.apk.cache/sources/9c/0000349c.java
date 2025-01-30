package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public class e1 {

    /* renamed from: f  reason: collision with root package name */
    private static HashMap<String, String> f7107f;

    /* renamed from: k  reason: collision with root package name */
    private static Object f7112k;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f7113l;
    public static final Uri a = Uri.parse("content://com.google.android.gsf.gservices");

    /* renamed from: b  reason: collision with root package name */
    private static final Uri f7103b = Uri.parse("content://com.google.android.gsf.gservices/prefix");

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f7104c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f7105d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicBoolean f7106e = new AtomicBoolean();

    /* renamed from: g  reason: collision with root package name */
    private static final HashMap<String, Boolean> f7108g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private static final HashMap<String, Integer> f7109h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private static final HashMap<String, Long> f7110i = new HashMap<>();

    /* renamed from: j  reason: collision with root package name */
    private static final HashMap<String, Float> f7111j = new HashMap<>();
    private static String[] m = new String[0];

    public static String a(ContentResolver contentResolver, String str, String str2) {
        synchronized (e1.class) {
            if (f7107f == null) {
                f7106e.set(false);
                f7107f = new HashMap<>();
                f7112k = new Object();
                f7113l = false;
                contentResolver.registerContentObserver(a, true, new g1(null));
            } else if (f7106e.getAndSet(false)) {
                f7107f.clear();
                f7108g.clear();
                f7109h.clear();
                f7110i.clear();
                f7111j.clear();
                f7112k = new Object();
                f7113l = false;
            }
            Object obj = f7112k;
            if (f7107f.containsKey(str)) {
                String str3 = f7107f.get(str);
                return str3 != null ? str3 : null;
            }
            for (String str4 : m) {
                if (str.startsWith(str4)) {
                    if (!f7113l || f7107f.isEmpty()) {
                        f7107f.putAll(b(contentResolver, m));
                        f7113l = true;
                        if (f7107f.containsKey(str)) {
                            String str5 = f7107f.get(str);
                            return str5 != null ? str5 : null;
                        }
                    }
                    return null;
                }
            }
            Cursor query = contentResolver.query(a, null, null, new String[]{str}, null);
            if (query == null) {
                if (query != null) {
                }
                return null;
            }
            try {
                if (!query.moveToFirst()) {
                    d(obj, str, null);
                    return null;
                }
                String string = query.getString(1);
                if (string != null && string.equals(null)) {
                    string = null;
                }
                d(obj, str, string);
                return string != null ? string : null;
            } finally {
                query.close();
            }
        }
    }

    private static Map<String, String> b(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(f7103b, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }

    private static void d(Object obj, String str, String str2) {
        synchronized (e1.class) {
            if (obj == f7112k) {
                f7107f.put(str, str2);
            }
        }
    }
}