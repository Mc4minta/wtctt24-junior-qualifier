package com.google.api.client.http;

import e.g.b.a.d.e0;
import e.g.b.a.d.f0;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.apache.http.client.utils.URLEncodedUtils;

/* compiled from: UrlEncodedParser.java */
/* loaded from: classes2.dex */
public class c0 implements e.g.b.a.d.w {
    public static final String a = new n(URLEncodedUtils.CONTENT_TYPE).l(e.g.b.a.d.h.a).a();

    public static void b(Reader reader, Object obj) throws IOException {
        int read;
        Class<?> cls = obj.getClass();
        e.g.b.a.d.i f2 = e.g.b.a.d.i.f(cls);
        List asList = Arrays.asList(cls);
        e.g.b.a.d.n nVar = e.g.b.a.d.n.class.isAssignableFrom(cls) ? (e.g.b.a.d.n) obj : null;
        Map map = Map.class.isAssignableFrom(cls) ? (Map) obj : null;
        e.g.b.a.d.b bVar = new e.g.b.a.d.b(obj);
        StringWriter stringWriter = new StringWriter();
        StringWriter stringWriter2 = new StringWriter();
        do {
            boolean z = true;
            while (true) {
                read = reader.read();
                if (read == -1 || read == 38) {
                    break;
                } else if (read != 61) {
                    if (z) {
                        stringWriter.write(read);
                    } else {
                        stringWriter2.write(read);
                    }
                } else if (z) {
                    z = false;
                } else {
                    stringWriter2.write(read);
                }
            }
            String a2 = e.g.b.a.d.h0.a.a(stringWriter.toString());
            if (a2.length() != 0) {
                String a3 = e.g.b.a.d.h0.a.a(stringWriter2.toString());
                e.g.b.a.d.m b2 = f2.b(a2);
                if (b2 != null) {
                    Type k2 = e.g.b.a.d.j.k(asList, b2.d());
                    if (f0.j(k2)) {
                        Class<?> f3 = f0.f(asList, f0.b(k2));
                        bVar.a(b2.b(), f3, d(f3, asList, a3));
                    } else if (f0.k(f0.f(asList, k2), Iterable.class)) {
                        Collection<Object> collection = (Collection) b2.g(obj);
                        if (collection == null) {
                            collection = e.g.b.a.d.j.g(k2);
                            b2.m(obj, collection);
                        }
                        collection.add(d(k2 == Object.class ? null : f0.d(k2), asList, a3));
                    } else {
                        b2.m(obj, d(k2, asList, a3));
                    }
                } else if (map != null) {
                    ArrayList arrayList = (ArrayList) map.get(a2);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        if (nVar != null) {
                            nVar.set(a2, arrayList);
                        } else {
                            map.put(a2, arrayList);
                        }
                    }
                    arrayList.add(a3);
                }
            }
            stringWriter = new StringWriter();
            stringWriter2 = new StringWriter();
        } while (read != -1);
        bVar.b();
    }

    public static void c(String str, Object obj) {
        if (str == null) {
            return;
        }
        try {
            b(new StringReader(str), obj);
        } catch (IOException e2) {
            throw e0.a(e2);
        }
    }

    private static Object d(Type type, List<Type> list, String str) {
        return e.g.b.a.d.j.j(e.g.b.a.d.j.k(list, type), str);
    }
}