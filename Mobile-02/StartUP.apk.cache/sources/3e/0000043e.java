package androidx.room.t;

import android.database.Cursor;
import android.os.Build;
import com.appsflyer.share.Constants;
import com.coinbase.ApiConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* compiled from: TableInfo.java */
/* loaded from: classes.dex */
public class f {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, a> f2306b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<b> f2307c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<d> f2308d;

    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static class a {
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2309b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2310c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f2311d;

        /* renamed from: e  reason: collision with root package name */
        public final int f2312e;

        /* renamed from: f  reason: collision with root package name */
        public final String f2313f;

        /* renamed from: g  reason: collision with root package name */
        private final int f2314g;

        public a(String str, String str2, boolean z, int i2, String str3, int i3) {
            this.a = str;
            this.f2309b = str2;
            this.f2311d = z;
            this.f2312e = i2;
            this.f2310c = a(str2);
            this.f2313f = str3;
            this.f2314g = i3;
        }

        private static int a(String str) {
            if (str == null) {
                return 5;
            }
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains("INT")) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            return (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
        }

        public boolean b() {
            return this.f2312e > 0;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (Build.VERSION.SDK_INT >= 20) {
                if (this.f2312e != aVar.f2312e) {
                    return false;
                }
            } else if (b() != aVar.b()) {
                return false;
            }
            if (this.a.equals(aVar.a) && this.f2311d == aVar.f2311d) {
                if (this.f2314g != 1 || aVar.f2314g != 2 || (str3 = this.f2313f) == null || str3.equals(aVar.f2313f)) {
                    if (this.f2314g != 2 || aVar.f2314g != 1 || (str2 = aVar.f2313f) == null || str2.equals(this.f2313f)) {
                        int i2 = this.f2314g;
                        return (i2 == 0 || i2 != aVar.f2314g || ((str = this.f2313f) == null ? aVar.f2313f == null : str.equals(aVar.f2313f))) && this.f2310c == aVar.f2310c;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.a.hashCode() * 31) + this.f2310c) * 31) + (this.f2311d ? 1231 : 1237)) * 31) + this.f2312e;
        }

        public String toString() {
            return "Column{name='" + this.a + "', type='" + this.f2309b + "', affinity='" + this.f2310c + "', notNull=" + this.f2311d + ", primaryKeyPosition=" + this.f2312e + ", defaultValue='" + this.f2313f + "'}";
        }
    }

    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static class b {
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2315b;

        /* renamed from: c  reason: collision with root package name */
        public final String f2316c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f2317d;

        /* renamed from: e  reason: collision with root package name */
        public final List<String> f2318e;

        public b(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.a = str;
            this.f2315b = str2;
            this.f2316c = str3;
            this.f2317d = Collections.unmodifiableList(list);
            this.f2318e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.a.equals(bVar.a) && this.f2315b.equals(bVar.f2315b) && this.f2316c.equals(bVar.f2316c) && this.f2317d.equals(bVar.f2317d)) {
                return this.f2318e.equals(bVar.f2318e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.a.hashCode() * 31) + this.f2315b.hashCode()) * 31) + this.f2316c.hashCode()) * 31) + this.f2317d.hashCode()) * 31) + this.f2318e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.a + "', onDelete='" + this.f2315b + "', onUpdate='" + this.f2316c + "', columnNames=" + this.f2317d + ", referenceColumnNames=" + this.f2318e + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static class c implements Comparable<c> {
        final int a;

        /* renamed from: b  reason: collision with root package name */
        final int f2319b;

        /* renamed from: c  reason: collision with root package name */
        final String f2320c;

        /* renamed from: d  reason: collision with root package name */
        final String f2321d;

        c(int i2, int i3, String str, String str2) {
            this.a = i2;
            this.f2319b = i3;
            this.f2320c = str;
            this.f2321d = str2;
        }

        @Override // java.lang.Comparable
        /* renamed from: h */
        public int compareTo(c cVar) {
            int i2 = this.a - cVar.a;
            return i2 == 0 ? this.f2319b - cVar.f2319b : i2;
        }
    }

    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static class d {
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f2322b;

        /* renamed from: c  reason: collision with root package name */
        public final List<String> f2323c;

        public d(String str, boolean z, List<String> list) {
            this.a = str;
            this.f2322b = z;
            this.f2323c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f2322b == dVar.f2322b && this.f2323c.equals(dVar.f2323c)) {
                if (this.a.startsWith("index_")) {
                    return dVar.a.startsWith("index_");
                }
                return this.a.equals(dVar.a);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.a.startsWith("index_") ? -1184239155 : this.a.hashCode()) * 31) + (this.f2322b ? 1 : 0)) * 31) + this.f2323c.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.a + "', unique=" + this.f2322b + ", columns=" + this.f2323c + '}';
        }
    }

    public f(String str, Map<String, a> map, Set<b> set, Set<d> set2) {
        this.a = str;
        this.f2306b = Collections.unmodifiableMap(map);
        this.f2307c = Collections.unmodifiableSet(set);
        this.f2308d = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    public static f a(c.r.a.b bVar, String str) {
        return new f(str, b(bVar, str), d(bVar, str), f(bVar, str));
    }

    private static Map<String, a> b(c.r.a.b bVar, String str) {
        Cursor i0 = bVar.i0("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (i0.getColumnCount() > 0) {
                int columnIndex = i0.getColumnIndex(ApiConstants.NAME);
                int columnIndex2 = i0.getColumnIndex("type");
                int columnIndex3 = i0.getColumnIndex("notnull");
                int columnIndex4 = i0.getColumnIndex("pk");
                int columnIndex5 = i0.getColumnIndex("dflt_value");
                while (i0.moveToNext()) {
                    String string = i0.getString(columnIndex);
                    hashMap.put(string, new a(string, i0.getString(columnIndex2), i0.getInt(columnIndex3) != 0, i0.getInt(columnIndex4), i0.getString(columnIndex5), 2));
                }
            }
            return hashMap;
        } finally {
            i0.close();
        }
    }

    private static List<c> c(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex(ApiConstants.FROM);
        int columnIndex4 = cursor.getColumnIndex(ApiConstants.TO);
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < count; i2++) {
            cursor.moveToPosition(i2);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static Set<b> d(c.r.a.b bVar, String str) {
        HashSet hashSet = new HashSet();
        Cursor i0 = bVar.i0("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = i0.getColumnIndex("id");
            int columnIndex2 = i0.getColumnIndex("seq");
            int columnIndex3 = i0.getColumnIndex("table");
            int columnIndex4 = i0.getColumnIndex("on_delete");
            int columnIndex5 = i0.getColumnIndex("on_update");
            List<c> c2 = c(i0);
            int count = i0.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                i0.moveToPosition(i2);
                if (i0.getInt(columnIndex2) == 0) {
                    int i3 = i0.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (c cVar : c2) {
                        if (cVar.a == i3) {
                            arrayList.add(cVar.f2320c);
                            arrayList2.add(cVar.f2321d);
                        }
                    }
                    hashSet.add(new b(i0.getString(columnIndex3), i0.getString(columnIndex4), i0.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            return hashSet;
        } finally {
            i0.close();
        }
    }

    private static d e(c.r.a.b bVar, String str, boolean z) {
        Cursor i0 = bVar.i0("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = i0.getColumnIndex("seqno");
            int columnIndex2 = i0.getColumnIndex("cid");
            int columnIndex3 = i0.getColumnIndex(ApiConstants.NAME);
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                TreeMap treeMap = new TreeMap();
                while (i0.moveToNext()) {
                    if (i0.getInt(columnIndex2) >= 0) {
                        int i2 = i0.getInt(columnIndex);
                        treeMap.put(Integer.valueOf(i2), i0.getString(columnIndex3));
                    }
                }
                ArrayList arrayList = new ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                return new d(str, z, arrayList);
            }
            return null;
        } finally {
            i0.close();
        }
    }

    private static Set<d> f(c.r.a.b bVar, String str) {
        Cursor i0 = bVar.i0("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = i0.getColumnIndex(ApiConstants.NAME);
            int columnIndex2 = i0.getColumnIndex("origin");
            int columnIndex3 = i0.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                HashSet hashSet = new HashSet();
                while (i0.moveToNext()) {
                    if (Constants.URL_CAMPAIGN.equals(i0.getString(columnIndex2))) {
                        String string = i0.getString(columnIndex);
                        boolean z = true;
                        if (i0.getInt(columnIndex3) != 1) {
                            z = false;
                        }
                        d e2 = e(bVar, string, z);
                        if (e2 == null) {
                            return null;
                        }
                        hashSet.add(e2);
                    }
                }
                return hashSet;
            }
            return null;
        } finally {
            i0.close();
        }
    }

    public boolean equals(Object obj) {
        Set<d> set;
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        String str = this.a;
        if (str == null ? fVar.a == null : str.equals(fVar.a)) {
            Map<String, a> map = this.f2306b;
            if (map == null ? fVar.f2306b == null : map.equals(fVar.f2306b)) {
                Set<b> set2 = this.f2307c;
                if (set2 == null ? fVar.f2307c == null : set2.equals(fVar.f2307c)) {
                    Set<d> set3 = this.f2308d;
                    if (set3 == null || (set = fVar.f2308d) == null) {
                        return true;
                    }
                    return set3.equals(set);
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, a> map = this.f2306b;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set<b> set = this.f2307c;
        return hashCode2 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        return "TableInfo{name='" + this.a + "', columns=" + this.f2306b + ", foreignKeys=" + this.f2307c + ", indices=" + this.f2308d + '}';
    }
}