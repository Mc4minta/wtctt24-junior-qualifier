package com.google.protobuf;

import com.google.protobuf.j;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.apache.http.message.TokenParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessageLiteToString.java */
/* loaded from: classes2.dex */
public final class p {
    private static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    private static boolean b(Object obj) {
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0;
        } else if (obj instanceof Float) {
            return ((Float) obj).floatValue() == 0.0f;
        } else if (obj instanceof Double) {
            return ((Double) obj).doubleValue() == 0.0d;
        } else if (obj instanceof String) {
            return obj.equals("");
        } else {
            if (obj instanceof e) {
                return obj.equals(e.a);
            }
            return obj instanceof n ? obj == ((n) obj).getDefaultInstanceForType() : (obj instanceof Enum) && ((Enum) obj).ordinal() == 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void c(StringBuilder sb, int i2, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                c(sb, i2, str, obj2);
            }
            return;
        }
        sb.append('\n');
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(TokenParser.SP);
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(t.c((String) obj));
            sb.append(TokenParser.DQUOTE);
        } else if (obj instanceof e) {
            sb.append(": \"");
            sb.append(t.a((e) obj));
            sb.append(TokenParser.DQUOTE);
        } else if (obj instanceof j) {
            sb.append(" {");
            d((j) obj, sb, i2 + 2);
            sb.append("\n");
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(TokenParser.SP);
            }
            sb.append("}");
        } else {
            sb.append(": ");
            sb.append(obj.toString());
        }
    }

    private static void d(n nVar, StringBuilder sb, int i2) {
        Method[] declaredMethods;
        Map.Entry<j.f, Object> next;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : nVar.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String replaceFirst = str.replaceFirst("get", "");
            boolean z = true;
            if (replaceFirst.endsWith("List") && !replaceFirst.endsWith("OrBuilderList")) {
                String str2 = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1, replaceFirst.length() - 4);
                Method method2 = (Method) hashMap.get("get" + replaceFirst);
                if (method2 != null) {
                    c(sb, i2, a(str2), j.k(method2, nVar, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set" + replaceFirst)) != null) {
                if (replaceFirst.endsWith("Bytes")) {
                    if (hashMap.containsKey("get" + replaceFirst.substring(0, replaceFirst.length() - 5))) {
                    }
                }
                String str3 = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1);
                Method method3 = (Method) hashMap.get("get" + replaceFirst);
                Method method4 = (Method) hashMap.get("has" + replaceFirst);
                if (method3 != null) {
                    Object k2 = j.k(method3, nVar, new Object[0]);
                    if (method4 == null) {
                        if (b(k2)) {
                            z = false;
                        }
                    } else {
                        z = ((Boolean) j.k(method4, nVar, new Object[0])).booleanValue();
                    }
                    if (z) {
                        c(sb, i2, a(str3), k2);
                    }
                }
            }
        }
        if (nVar instanceof j.e) {
            Iterator<Map.Entry<j.f, Object>> e2 = ((j.e) nVar).f9717d.e();
            while (e2.hasNext()) {
                c(sb, i2, "[" + next.getKey().getNumber() + "]", e2.next().getValue());
            }
        }
        v vVar = ((j) nVar).f9711b;
        if (vVar != null) {
            vVar.i(sb, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(n nVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        d(nVar, sb, 0);
        return sb.toString();
    }
}