package com.google.api.client.http;

import e.g.b.a.d.f0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import org.spongycastle.asn1.eac.EACTags;

/* compiled from: UriTemplate.java */
/* loaded from: classes2.dex */
public class a0 {
    static final Map<Character, a> a = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UriTemplate.java */
    /* loaded from: classes2.dex */
    public enum a {
        PLUS('+', "", ",", false, true),
        HASH('#', "#", ",", false, true),
        DOT('.', ".", ".", false, false),
        FORWARD_SLASH('/', "/", "/", false, false),
        SEMI_COLON(';', ";", ";", true, false),
        QUERY('?', "?", "&", true, false),
        AMP('&', "&", "&", true, false),
        SIMPLE(null, "", ",", false, false);
        

        /* renamed from: k  reason: collision with root package name */
        private final Character f8336k;

        /* renamed from: l  reason: collision with root package name */
        private final String f8337l;
        private final String m;
        private final boolean n;
        private final boolean p;

        a(Character ch, String str, String str2, boolean z, boolean z2) {
            this.f8336k = ch;
            this.f8337l = (String) e.g.b.a.d.y.d(str);
            this.m = (String) e.g.b.a.d.y.d(str2);
            this.n = z;
            this.p = z2;
            if (ch != null) {
                a0.a.put(ch, this);
            }
        }

        String h(String str) {
            if (this.p) {
                return e.g.b.a.d.h0.a.c(str);
            }
            return e.g.b.a.d.h0.a.b(str);
        }

        String n() {
            return this.m;
        }

        String q() {
            return this.f8337l;
        }

        boolean s() {
            return this.p;
        }

        int y() {
            return this.f8336k == null ? 0 : 1;
        }

        boolean z() {
            return this.n;
        }
    }

    static {
        a.values();
    }

    public static String a(String str, Object obj, boolean z) {
        Object d2;
        Map<String, Object> e2 = e(obj);
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            int indexOf = str.indexOf(123, i2);
            if (indexOf != -1) {
                sb.append(str.substring(i2, indexOf));
                int indexOf2 = str.indexOf(EACTags.SECURE_MESSAGING_TEMPLATE, indexOf + 2);
                int i3 = indexOf2 + 1;
                String substring = str.substring(indexOf + 1, indexOf2);
                a c2 = c(substring);
                ListIterator<String> listIterator = com.google.common.base.o.d(',').f(substring).listIterator();
                boolean z2 = true;
                while (listIterator.hasNext()) {
                    String next = listIterator.next();
                    boolean endsWith = next.endsWith("*");
                    int y = listIterator.nextIndex() == 1 ? c2.y() : 0;
                    int length2 = next.length();
                    if (endsWith) {
                        length2--;
                    }
                    String substring2 = next.substring(y, length2);
                    Object remove = e2.remove(substring2);
                    if (remove != null) {
                        if (!z2) {
                            sb.append(c2.n());
                        } else {
                            sb.append(c2.q());
                            z2 = false;
                        }
                        if (remove instanceof Iterator) {
                            d2 = d(substring2, (Iterator) remove, endsWith, c2);
                        } else if (!(remove instanceof Iterable) && !remove.getClass().isArray()) {
                            if (remove.getClass().isEnum()) {
                                if (e.g.b.a.d.m.j((Enum) remove).e() != null) {
                                    if (c2.z()) {
                                        remove = String.format("%s=%s", substring2, remove);
                                    }
                                    remove = e.g.b.a.d.h0.a.c(remove.toString());
                                }
                                d2 = remove;
                            } else if (!e.g.b.a.d.j.e(remove)) {
                                d2 = f(substring2, e(remove), endsWith, c2);
                            } else {
                                if (c2.z()) {
                                    remove = String.format("%s=%s", substring2, remove);
                                }
                                if (c2.s()) {
                                    d2 = e.g.b.a.d.h0.a.d(remove.toString());
                                } else {
                                    d2 = e.g.b.a.d.h0.a.c(remove.toString());
                                }
                            }
                        } else {
                            d2 = d(substring2, f0.l(remove).iterator(), endsWith, c2);
                        }
                        sb.append(d2);
                    }
                }
                i2 = i3;
            } else if (i2 == 0 && !z) {
                return str;
            } else {
                sb.append(str.substring(i2));
            }
        }
        if (z) {
            g.b(e2.entrySet(), sb);
        }
        return sb.toString();
    }

    public static String b(String str, String str2, Object obj, boolean z) {
        g gVar;
        if (str2.startsWith("/")) {
            new g(str).o(null);
            str2 = gVar.e() + str2;
        } else if (!str2.startsWith("http://") && !str2.startsWith("https://")) {
            str2 = str + str2;
        }
        return a(str2, obj, z);
    }

    static a c(String str) {
        a aVar = a.get(Character.valueOf(str.charAt(0)));
        return aVar == null ? a.SIMPLE : aVar;
    }

    private static String d(String str, Iterator<?> it, boolean z, a aVar) {
        String str2;
        if (it.hasNext()) {
            StringBuilder sb = new StringBuilder();
            if (z) {
                str2 = aVar.n();
            } else {
                if (aVar.z()) {
                    sb.append(e.g.b.a.d.h0.a.c(str));
                    sb.append("=");
                }
                str2 = ",";
            }
            while (it.hasNext()) {
                if (z && aVar.z()) {
                    sb.append(e.g.b.a.d.h0.a.c(str));
                    sb.append("=");
                }
                sb.append(aVar.h(it.next().toString()));
                if (it.hasNext()) {
                    sb.append(str2);
                }
            }
            return sb.toString();
        }
        return "";
    }

    private static Map<String, Object> e(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : e.g.b.a.d.j.f(obj).entrySet()) {
            Object value = entry.getValue();
            if (value != null && !e.g.b.a.d.j.c(value)) {
                linkedHashMap.put(entry.getKey(), value);
            }
        }
        return linkedHashMap;
    }

    private static String f(String str, Map<String, Object> map, boolean z, a aVar) {
        if (map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String str2 = "=";
        String str3 = ",";
        if (z) {
            str3 = aVar.n();
        } else {
            if (aVar.z()) {
                sb.append(e.g.b.a.d.h0.a.c(str));
                sb.append("=");
            }
            str2 = ",";
        }
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> next = it.next();
            String h2 = aVar.h(next.getKey());
            String h3 = aVar.h(next.getValue().toString());
            sb.append(h2);
            sb.append(str2);
            sb.append(h3);
            if (it.hasNext()) {
                sb.append(str3);
            }
        }
        return sb.toString();
    }
}