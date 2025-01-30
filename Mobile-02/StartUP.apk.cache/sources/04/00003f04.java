package com.rt2zz.reactnativecontacts;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import com.coinbase.ApiConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ContactsProvider.java */
/* loaded from: classes2.dex */
public class a {
    private static final List<String> a = new C0230a();

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f10815b = new b();

    /* renamed from: c  reason: collision with root package name */
    private static final List<String> f10816c = new c();

    /* renamed from: d  reason: collision with root package name */
    private final ContentResolver f10817d;

    /* compiled from: ContactsProvider.java */
    /* renamed from: com.rt2zz.reactnativecontacts.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0230a extends ArrayList<String> {
        C0230a() {
            add("_id");
            add("contact_id");
            add("raw_contact_id");
            add("lookup");
            add("mimetype");
            add("display_name");
            add("photo_uri");
            add("data1");
            add("data2");
            add("data5");
            add("data3");
            add("data4");
            add("data6");
            add("data1");
            add("data4");
            add("data2");
            add("data3");
            add("data1");
            add("data1");
            add("data2");
            add("data3");
            add("data1");
            add("data4");
            add("data5");
            add("data1");
            add("data2");
            add("data3");
            add("data4");
            add("data5");
            add("data6");
            add("data7");
            add("data8");
            add("data9");
            add("data10");
            add("data1");
            add("data1");
            add("data1");
            add("data2");
        }
    }

    /* compiled from: ContactsProvider.java */
    /* loaded from: classes2.dex */
    static class b extends ArrayList<String> {
        b() {
            addAll(a.a);
        }
    }

    /* compiled from: ContactsProvider.java */
    /* loaded from: classes2.dex */
    static class c extends ArrayList<String> {
        c() {
            add("photo_uri");
        }
    }

    public a(ContentResolver contentResolver) {
        this.f10817d = contentResolver;
    }

    private Map<String, d> j(Cursor cursor) {
        String valueOf;
        String valueOf2;
        String valueOf3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (cursor != null && cursor.moveToNext()) {
            int columnIndex = cursor.getColumnIndex("contact_id");
            int columnIndex2 = cursor.getColumnIndex("_id");
            int columnIndex3 = cursor.getColumnIndex("raw_contact_id");
            char c2 = 65535;
            if (columnIndex != -1) {
                valueOf = cursor.getString(columnIndex);
            } else {
                valueOf = String.valueOf(-1);
            }
            if (columnIndex2 != -1) {
                valueOf2 = cursor.getString(columnIndex2);
            } else {
                valueOf2 = String.valueOf(-1);
            }
            if (columnIndex3 != -1) {
                valueOf3 = cursor.getString(columnIndex3);
            } else {
                valueOf3 = String.valueOf(-1);
            }
            if (!linkedHashMap.containsKey(valueOf)) {
                linkedHashMap.put(valueOf, new d(valueOf));
            }
            d dVar = (d) linkedHashMap.get(valueOf);
            String string = cursor.getString(cursor.getColumnIndex("mimetype"));
            String string2 = cursor.getString(cursor.getColumnIndex("display_name"));
            dVar.f10818b = valueOf3;
            if (!TextUtils.isEmpty(string2) && TextUtils.isEmpty(dVar.f10819c)) {
                dVar.f10819c = string2;
            }
            if (TextUtils.isEmpty(dVar.o)) {
                String string3 = cursor.getString(cursor.getColumnIndex("photo_uri"));
                if (!TextUtils.isEmpty(string3)) {
                    dVar.o = string3;
                    dVar.n = true;
                }
            }
            string.hashCode();
            switch (string.hashCode()) {
                case -1569536764:
                    if (string.equals("vnd.android.cursor.item/email_v2")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1328682538:
                    if (string.equals("vnd.android.cursor.item/contact_event")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1079224304:
                    if (string.equals("vnd.android.cursor.item/name")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -601229436:
                    if (string.equals("vnd.android.cursor.item/postal-address_v2")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 456415478:
                    if (string.equals("vnd.android.cursor.item/website")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 684173810:
                    if (string.equals("vnd.android.cursor.item/phone_v2")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 689862072:
                    if (string.equals("vnd.android.cursor.item/organization")) {
                        c2 = 6;
                        break;
                    }
                    break;
            }
            String str = ApiConstants.CLIENT_PLATFORM;
            String str2 = "other";
            switch (c2) {
                case 0:
                    String string4 = cursor.getString(cursor.getColumnIndex("data1"));
                    int i2 = cursor.getInt(cursor.getColumnIndex("data2"));
                    if (!TextUtils.isEmpty(string4)) {
                        if (i2 == 0) {
                            str = cursor.getString(cursor.getColumnIndex("data3")) != null ? cursor.getString(cursor.getColumnIndex("data3")).toLowerCase() : "";
                        } else if (i2 == 1) {
                            str = "home";
                        } else if (i2 == 2) {
                            str = "work";
                        } else if (i2 != 4) {
                            str = "other";
                        }
                        dVar.p.add(new d.b(str, string4, valueOf2));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (cursor.getInt(cursor.getColumnIndex("data2")) != 3) {
                        break;
                    } else {
                        try {
                            List asList = Arrays.asList(cursor.getString(cursor.getColumnIndex("data1")).replace("--", "").split("-"));
                            if (asList.size() == 2) {
                                int parseInt = Integer.parseInt((String) asList.get(0));
                                int parseInt2 = Integer.parseInt((String) asList.get(1));
                                if (parseInt >= 1 && parseInt <= 12 && parseInt2 >= 1 && parseInt2 <= 31) {
                                    dVar.s = new d.C0231a(parseInt, parseInt2);
                                    break;
                                }
                            } else if (asList.size() != 3) {
                                break;
                            } else {
                                int parseInt3 = Integer.parseInt((String) asList.get(0));
                                int parseInt4 = Integer.parseInt((String) asList.get(1));
                                int parseInt5 = Integer.parseInt((String) asList.get(2));
                                if (parseInt3 > 0 && parseInt4 >= 1 && parseInt4 <= 12 && parseInt5 >= 1 && parseInt5 <= 31) {
                                    dVar.s = new d.C0231a(parseInt3, parseInt4, parseInt5);
                                    break;
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException | NullPointerException | NumberFormatException e2) {
                            Log.w("ContactsProvider", e2.toString());
                            break;
                        }
                    }
                    break;
                case 2:
                    dVar.f10820d = cursor.getString(cursor.getColumnIndex("data2"));
                    if (cursor.getString(cursor.getColumnIndex("data5")) != null) {
                        dVar.f10821e = cursor.getString(cursor.getColumnIndex("data5"));
                    } else {
                        dVar.f10821e = "";
                    }
                    if (cursor.getString(cursor.getColumnIndex("data3")) != null) {
                        dVar.f10822f = cursor.getString(cursor.getColumnIndex("data3"));
                    } else {
                        dVar.f10822f = "";
                    }
                    dVar.f10823g = cursor.getString(cursor.getColumnIndex("data4"));
                    dVar.f10824h = cursor.getString(cursor.getColumnIndex("data6"));
                    break;
                case 3:
                    dVar.r.add(new d.c(cursor));
                    break;
                case 4:
                    String string5 = cursor.getString(cursor.getColumnIndex("data1"));
                    int i3 = cursor.getInt(cursor.getColumnIndex("data2"));
                    if (!TextUtils.isEmpty(string5)) {
                        switch (i3) {
                            case 0:
                                if (cursor.getString(cursor.getColumnIndex("data3")) == null) {
                                    str2 = "";
                                    break;
                                } else {
                                    str2 = cursor.getString(cursor.getColumnIndex("data3")).toLowerCase();
                                    break;
                                }
                            case 1:
                                str2 = "homepage";
                                break;
                            case 2:
                                str2 = "blog";
                                break;
                            case 3:
                                str2 = "profile";
                                break;
                            case 4:
                                str2 = "home";
                                break;
                            case 5:
                                str2 = "work";
                                break;
                            case 6:
                                str2 = "ftp";
                                break;
                        }
                        dVar.m.add(new d.b(str2, string5, valueOf2));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    String string6 = cursor.getString(cursor.getColumnIndex("data1"));
                    int i4 = cursor.getInt(cursor.getColumnIndex("data2"));
                    if (!TextUtils.isEmpty(string6)) {
                        if (i4 == 1) {
                            str = "home";
                        } else if (i4 != 2) {
                            str = i4 != 3 ? "other" : "work";
                        }
                        dVar.q.add(new d.b(str, string6, valueOf2));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    dVar.f10825i = cursor.getString(cursor.getColumnIndex("data1"));
                    dVar.f10826j = cursor.getString(cursor.getColumnIndex("data4"));
                    dVar.f10827k = cursor.getString(cursor.getColumnIndex("data5"));
                    break;
            }
        }
        return linkedHashMap;
    }

    public WritableMap b(String str) {
        ContentResolver contentResolver = this.f10817d;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = f10815b;
        Cursor query = contentResolver.query(uri, (String[]) list.toArray(new String[list.size()]), "contact_id = ?", new String[]{str}, null);
        try {
            Map<String, d> j2 = j(query);
            if (j2.values().size() > 0) {
                return j2.values().iterator().next().t();
            }
            return null;
        } finally {
            if (query != null) {
                query.close();
            }
        }
    }

    public WritableMap c(String str) {
        int columnIndex;
        Cursor query = this.f10817d.query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"contact_id"}, "_id= ?", new String[]{str}, null);
        query.getCount();
        String string = (!query.moveToNext() || (columnIndex = query.getColumnIndex("contact_id")) == -1) ? null : query.getString(columnIndex);
        query.close();
        return b(string);
    }

    public WritableArray d() {
        ContentResolver contentResolver = this.f10817d;
        Uri withAppendedPath = Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data");
        List<String> list = a;
        Cursor query = contentResolver.query(withAppendedPath, (String[]) list.toArray(new String[list.size()]), null, null, null);
        try {
            Map<String, d> j2 = j(query);
            if (query != null) {
                query.close();
            }
            ContentResolver contentResolver2 = this.f10817d;
            Uri uri = ContactsContract.Data.CONTENT_URI;
            List<String> list2 = f10815b;
            query = contentResolver2.query(uri, (String[]) list2.toArray(new String[list2.size()]), "mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=?", new String[]{"vnd.android.cursor.item/email_v2", "vnd.android.cursor.item/phone_v2", "vnd.android.cursor.item/name", "vnd.android.cursor.item/organization", "vnd.android.cursor.item/postal-address_v2", "vnd.android.cursor.item/note", "vnd.android.cursor.item/website", "vnd.android.cursor.item/contact_event"}, null);
            try {
                Map<String, d> j3 = j(query);
                WritableArray createArray = Arguments.createArray();
                for (d dVar : j2.values()) {
                    createArray.pushMap(dVar.t());
                }
                for (d dVar2 : j3.values()) {
                    createArray.pushMap(dVar2.t());
                }
                return createArray;
            } finally {
                if (query != null) {
                    query.close();
                }
            }
        } finally {
            if (query != null) {
                query.close();
            }
        }
    }

    public WritableArray e(String str) {
        ContentResolver contentResolver = this.f10817d;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = f10815b;
        Cursor query = contentResolver.query(uri, (String[]) list.toArray(new String[list.size()]), "data1 LIKE ?", new String[]{"%" + str + "%"}, null);
        try {
            Map<String, d> j2 = j(query);
            WritableArray createArray = Arguments.createArray();
            for (d dVar : j2.values()) {
                createArray.pushMap(dVar.t());
            }
            return createArray;
        } finally {
            if (query != null) {
                query.close();
            }
        }
    }

    public WritableArray f(String str) {
        ContentResolver contentResolver = this.f10817d;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = f10815b;
        Cursor query = contentResolver.query(uri, (String[]) list.toArray(new String[list.size()]), "data1 LIKE ? OR data4 LIKE ?", new String[]{"%" + str + "%", "%" + str + "%"}, null);
        try {
            Map<String, d> j2 = j(query);
            WritableArray createArray = Arguments.createArray();
            for (d dVar : j2.values()) {
                createArray.pushMap(dVar.t());
            }
            return createArray;
        } finally {
            if (query != null) {
                query.close();
            }
        }
    }

    public Integer g() {
        return Integer.valueOf(this.f10817d.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null).getCount());
    }

    public WritableArray h(String str) {
        ContentResolver contentResolver = this.f10817d;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = f10815b;
        Cursor query = contentResolver.query(uri, (String[]) list.toArray(new String[list.size()]), "display_name LIKE ? OR data1 LIKE ?", new String[]{"%" + str + "%", "%" + str + "%"}, null);
        try {
            Map<String, d> j2 = j(query);
            WritableArray createArray = Arguments.createArray();
            for (d dVar : j2.values()) {
                createArray.pushMap(dVar.t());
            }
            return createArray;
        } finally {
            if (query != null) {
                query.close();
            }
        }
    }

    public String i(String str) {
        ContentResolver contentResolver = this.f10817d;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = f10816c;
        Cursor query = contentResolver.query(uri, (String[]) list.toArray(new String[list.size()]), "contact_id = ?", new String[]{str}, null);
        if (query != null) {
            try {
                if (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("photo_uri"));
                    if (!TextUtils.isEmpty(string)) {
                        return string;
                    }
                }
            } finally {
                query.close();
            }
        }
        return query != null ? null : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ContactsProvider.java */
    /* loaded from: classes2.dex */
    public static class d {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private String f10818b;

        /* renamed from: c  reason: collision with root package name */
        private String f10819c;
        private String o;
        private C0231a s;

        /* renamed from: d  reason: collision with root package name */
        private String f10820d = "";

        /* renamed from: e  reason: collision with root package name */
        private String f10821e = "";

        /* renamed from: f  reason: collision with root package name */
        private String f10822f = "";

        /* renamed from: g  reason: collision with root package name */
        private String f10823g = "";

        /* renamed from: h  reason: collision with root package name */
        private String f10824h = "";

        /* renamed from: i  reason: collision with root package name */
        private String f10825i = "";

        /* renamed from: j  reason: collision with root package name */
        private String f10826j = "";

        /* renamed from: k  reason: collision with root package name */
        private String f10827k = "";

        /* renamed from: l  reason: collision with root package name */
        private String f10828l = "";
        private List<b> m = new ArrayList();
        private boolean n = false;
        private List<b> p = new ArrayList();
        private List<b> q = new ArrayList();
        private List<c> r = new ArrayList();

        /* compiled from: ContactsProvider.java */
        /* loaded from: classes2.dex */
        public static class b {
            public String a;

            /* renamed from: b  reason: collision with root package name */
            public String f10831b;

            /* renamed from: c  reason: collision with root package name */
            public String f10832c;

            public b(String str, String str2, String str3) {
                this.f10832c = str3;
                this.a = str;
                this.f10831b = str2;
            }
        }

        /* compiled from: ContactsProvider.java */
        /* loaded from: classes2.dex */
        public static class c {
            public final WritableMap a;

            public c(Cursor cursor) {
                WritableMap createMap = Arguments.createMap();
                this.a = createMap;
                createMap.putString("label", a(cursor));
                b(cursor, "formattedAddress", "data1");
                b(cursor, "street", "data4");
                b(cursor, "pobox", "data5");
                b(cursor, "neighborhood", "data6");
                b(cursor, "city", "data7");
                b(cursor, "region", "data8");
                b(cursor, ApiConstants.STATE, "data8");
                b(cursor, "postCode", "data9");
                b(cursor, "country", "data10");
            }

            static String a(Cursor cursor) {
                int i2 = cursor.getInt(cursor.getColumnIndex("data2"));
                if (i2 != 0) {
                    return i2 != 1 ? i2 != 2 ? "other" : "work" : "home";
                }
                String string = cursor.getString(cursor.getColumnIndex("data3"));
                return string != null ? string : "";
            }

            private void b(Cursor cursor, String str, String str2) {
                String string = cursor.getString(cursor.getColumnIndex(str2));
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                this.a.putString(str, string);
            }
        }

        public d(String str) {
            this.a = str;
        }

        public WritableMap t() {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("recordID", this.a);
            createMap.putString("rawContactId", this.f10818b);
            createMap.putString("givenName", TextUtils.isEmpty(this.f10820d) ? this.f10819c : this.f10820d);
            createMap.putString("displayName", this.f10819c);
            createMap.putString("middleName", this.f10821e);
            createMap.putString("familyName", this.f10822f);
            createMap.putString("prefix", this.f10823g);
            createMap.putString("suffix", this.f10824h);
            createMap.putString("company", this.f10825i);
            createMap.putString("jobTitle", this.f10826j);
            createMap.putString("department", this.f10827k);
            createMap.putString("note", this.f10828l);
            createMap.putBoolean("hasThumbnail", this.n);
            String str = this.o;
            if (str == null) {
                str = "";
            }
            createMap.putString("thumbnailPath", str);
            WritableArray createArray = Arguments.createArray();
            for (b bVar : this.q) {
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putString("number", bVar.f10831b);
                createMap2.putString("label", bVar.a);
                createMap2.putString("id", bVar.f10832c);
                createArray.pushMap(createMap2);
            }
            createMap.putArray("phoneNumbers", createArray);
            WritableArray createArray2 = Arguments.createArray();
            for (b bVar2 : this.m) {
                WritableMap createMap3 = Arguments.createMap();
                createMap3.putString("url", bVar2.f10831b);
                createMap3.putString("id", bVar2.f10832c);
                createArray2.pushMap(createMap3);
            }
            createMap.putArray("urlAddresses", createArray2);
            WritableArray createArray3 = Arguments.createArray();
            for (b bVar3 : this.p) {
                WritableMap createMap4 = Arguments.createMap();
                createMap4.putString("email", bVar3.f10831b);
                createMap4.putString("label", bVar3.a);
                createMap4.putString("id", bVar3.f10832c);
                createArray3.pushMap(createMap4);
            }
            createMap.putArray("emailAddresses", createArray3);
            WritableArray createArray4 = Arguments.createArray();
            for (c cVar : this.r) {
                createArray4.pushMap(cVar.a);
            }
            createMap.putArray("postalAddresses", createArray4);
            WritableMap createMap5 = Arguments.createMap();
            C0231a c0231a = this.s;
            if (c0231a != null) {
                int i2 = c0231a.a;
                if (i2 > 0) {
                    createMap5.putInt("year", i2);
                }
                createMap5.putInt("month", this.s.f10829b);
                createMap5.putInt("day", this.s.f10830c);
                createMap.putMap("birthday", createMap5);
            }
            return createMap;
        }

        /* compiled from: ContactsProvider.java */
        /* renamed from: com.rt2zz.reactnativecontacts.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0231a {
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public int f10829b;

            /* renamed from: c  reason: collision with root package name */
            public int f10830c;

            public C0231a(int i2, int i3, int i4) {
                this.a = 0;
                this.f10829b = 0;
                this.f10830c = 0;
                this.a = i2;
                this.f10829b = i3;
                this.f10830c = i4;
            }

            public C0231a(int i2, int i3) {
                this.a = 0;
                this.f10829b = 0;
                this.f10830c = 0;
                this.f10829b = i2;
                this.f10830c = i3;
            }
        }
    }
}