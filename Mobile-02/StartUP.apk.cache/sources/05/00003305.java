package com.google.android.gms.internal.clearcut;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class v5 {

    /* renamed from: f  reason: collision with root package name */
    private static HashMap<String, String> f6592f;

    /* renamed from: k  reason: collision with root package name */
    private static Object f6597k;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f6598l;
    private static final Uri a = Uri.parse("content://com.google.android.gsf.gservices");

    /* renamed from: b  reason: collision with root package name */
    private static final Uri f6588b = Uri.parse("content://com.google.android.gsf.gservices/prefix");

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f6589c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f6590d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicBoolean f6591e = new AtomicBoolean();

    /* renamed from: g  reason: collision with root package name */
    private static final HashMap<String, Boolean> f6593g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private static final HashMap<String, Integer> f6594h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private static final HashMap<String, Long> f6595i = new HashMap<>();

    /* renamed from: j  reason: collision with root package name */
    private static final HashMap<String, Float> f6596j = new HashMap<>();
    private static String[] m = new String[0];

    public static long a(ContentResolver contentResolver, String str, long j2) {
        Object i2 = i(contentResolver);
        long j3 = 0;
        Long l2 = (Long) b(f6595i, str, 0L);
        if (l2 != null) {
            return l2.longValue();
        }
        String c2 = c(contentResolver, str, null);
        if (c2 != null) {
            try {
                long parseLong = Long.parseLong(c2);
                l2 = Long.valueOf(parseLong);
                j3 = parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        g(i2, f6595i, str, l2);
        return j3;
    }

    private static <T> T b(HashMap<String, T> hashMap, String str, T t) {
        synchronized (v5.class) {
            if (hashMap.containsKey(str)) {
                T t2 = hashMap.get(str);
                if (t2 != null) {
                    t = t2;
                }
                return t;
            }
            return null;
        }
    }

    public static String c(ContentResolver contentResolver, String str, String str2) {
        synchronized (v5.class) {
            e(contentResolver);
            Object obj = f6597k;
            if (f6592f.containsKey(str)) {
                String str3 = f6592f.get(str);
                return str3 != null ? str3 : null;
            }
            for (String str4 : m) {
                if (str.startsWith(str4)) {
                    if (!f6598l || f6592f.isEmpty()) {
                        f6592f.putAll(d(contentResolver, m));
                        f6598l = true;
                        if (f6592f.containsKey(str)) {
                            String str5 = f6592f.get(str);
                            return str5 != null ? str5 : null;
                        }
                    }
                    return null;
                }
            }
            Cursor query = contentResolver.query(a, null, null, new String[]{str}, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(1);
                        if (string != null && string.equals(null)) {
                            string = null;
                        }
                        f(obj, str, string);
                        String str6 = string != null ? string : null;
                        query.close();
                        return str6;
                    }
                } finally {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            f(obj, str, null);
            return null;
        }
    }

    private static Map<String, String> d(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(f6588b, null, null, strArr, null);
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

    private static void e(ContentResolver contentResolver) {
        if (f6592f == null) {
            f6591e.set(false);
            f6592f = new HashMap<>();
            f6597k = new Object();
            f6598l = false;
            contentResolver.registerContentObserver(a, true, new w5(null));
        } else if (f6591e.getAndSet(false)) {
            f6592f.clear();
            f6593g.clear();
            f6594h.clear();
            f6595i.clear();
            f6596j.clear();
            f6597k = new Object();
            f6598l = false;
        }
    }

    private static void f(Object obj, String str, String str2) {
        synchronized (v5.class) {
            if (obj == f6597k) {
                f6592f.put(str, str2);
            }
        }
    }

    private static <T> void g(Object obj, HashMap<String, T> hashMap, String str, T t) {
        synchronized (v5.class) {
            if (obj == f6597k) {
                hashMap.put(str, t);
                f6592f.remove(str);
            }
        }
    }

    public static boolean h(ContentResolver contentResolver, String str, boolean z) {
        Object i2 = i(contentResolver);
        HashMap<String, Boolean> hashMap = f6593g;
        Boolean bool = (Boolean) b(hashMap, str, Boolean.valueOf(z));
        if (bool != null) {
            return bool.booleanValue();
        }
        String c2 = c(contentResolver, str, null);
        if (c2 != null && !c2.equals("")) {
            if (f6589c.matcher(c2).matches()) {
                z = true;
                bool = Boolean.TRUE;
            } else if (f6590d.matcher(c2).matches()) {
                z = false;
                bool = Boolean.FALSE;
            } else {
                Log.w("Gservices", "attempt to read gservices key " + str + " (value \"" + c2 + "\") as boolean");
            }
        }
        g(i2, hashMap, str, bool);
        return z;
    }

    private static Object i(ContentResolver contentResolver) {
        Object obj;
        synchronized (v5.class) {
            e(contentResolver);
            obj = f6597k;
        }
        return obj;
    }
}