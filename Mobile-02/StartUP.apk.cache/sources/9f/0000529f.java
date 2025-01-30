package kotlin.l0;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Indent.kt */
/* loaded from: classes3.dex */
public class q extends p {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Indent.kt */
    /* loaded from: classes3.dex */
    public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, String> {
        public static final a a = new a();

        a() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final String invoke(String line) {
            kotlin.jvm.internal.m.g(line, "line");
            return line;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Indent.kt */
    /* loaded from: classes3.dex */
    public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, String> {
        final /* synthetic */ String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.a = str;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final String invoke(String line) {
            kotlin.jvm.internal.m.g(line, "line");
            return this.a + line;
        }
    }

    private static final kotlin.e0.c.l<String, String> b(String str) {
        return str.length() == 0 ? a.a : new b(str);
    }

    private static final int c(String str) {
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (!kotlin.l0.a.c(str.charAt(i2))) {
                break;
            } else {
                i2++;
            }
        }
        return i2 == -1 ? str.length() : i2;
    }

    public static final String d(String replaceIndent, String newIndent) {
        String str;
        String invoke;
        kotlin.jvm.internal.m.g(replaceIndent, "$this$replaceIndent");
        kotlin.jvm.internal.m.g(newIndent, "newIndent");
        List<String> q0 = y.q0(replaceIndent);
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : q0) {
            if (!o.D((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.a0.p.r(arrayList, 10));
        for (String str2 : arrayList) {
            arrayList2.add(Integer.valueOf(c(str2)));
        }
        Integer num = (Integer) kotlin.a0.p.o0(arrayList2);
        int i2 = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = replaceIndent.length() + (newIndent.length() * q0.size());
        kotlin.e0.c.l<String, String> b2 = b(newIndent);
        int i3 = kotlin.a0.p.i(q0);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : q0) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                kotlin.a0.p.q();
            }
            String str3 = (String) obj2;
            if ((i2 == 0 || i2 == i3) && o.D(str3)) {
                str = null;
            } else {
                String j1 = a0.j1(str3, intValue);
                if (j1 != null && (invoke = b2.invoke(j1)) != null) {
                    str3 = invoke;
                }
                str = str3;
            }
            if (str != null) {
                arrayList3.add(str);
            }
            i2 = i4;
        }
        String sb = ((StringBuilder) kotlin.a0.p.f0(arrayList3, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
        kotlin.jvm.internal.m.f(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    public static final String e(String replaceIndentByMargin, String newIndent, String marginPrefix) {
        int i2;
        String invoke;
        kotlin.jvm.internal.m.g(replaceIndentByMargin, "$this$replaceIndentByMargin");
        kotlin.jvm.internal.m.g(newIndent, "newIndent");
        kotlin.jvm.internal.m.g(marginPrefix, "marginPrefix");
        if (!o.D(marginPrefix)) {
            List<String> q0 = y.q0(replaceIndentByMargin);
            int length = replaceIndentByMargin.length() + (newIndent.length() * q0.size());
            kotlin.e0.c.l<String, String> b2 = b(newIndent);
            int i3 = kotlin.a0.p.i(q0);
            ArrayList arrayList = new ArrayList();
            int i4 = 0;
            for (Object obj : q0) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    kotlin.a0.p.q();
                }
                String str = (String) obj;
                String str2 = null;
                if ((i4 != 0 && i4 != i3) || !o.D(str)) {
                    int length2 = str.length();
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length2) {
                            i2 = -1;
                            break;
                        } else if (!kotlin.l0.a.c(str.charAt(i6))) {
                            i2 = i6;
                            break;
                        } else {
                            i6++;
                        }
                    }
                    if (i2 != -1) {
                        int i7 = i2;
                        if (o.P(str, marginPrefix, i2, false, 4, null)) {
                            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                            str2 = str.substring(i7 + marginPrefix.length());
                            kotlin.jvm.internal.m.f(str2, "(this as java.lang.String).substring(startIndex)");
                        }
                    }
                    if (str2 != null && (invoke = b2.invoke(str2)) != null) {
                        str = invoke;
                    }
                    str2 = str;
                }
                if (str2 != null) {
                    arrayList.add(str2);
                }
                i4 = i5;
            }
            String sb = ((StringBuilder) kotlin.a0.p.f0(arrayList, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
            kotlin.jvm.internal.m.f(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
            return sb;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static String f(String trimIndent) {
        kotlin.jvm.internal.m.g(trimIndent, "$this$trimIndent");
        return d(trimIndent, "");
    }

    public static final String g(String trimMargin, String marginPrefix) {
        kotlin.jvm.internal.m.g(trimMargin, "$this$trimMargin");
        kotlin.jvm.internal.m.g(marginPrefix, "marginPrefix");
        return e(trimMargin, "", marginPrefix);
    }

    public static /* synthetic */ String h(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "|";
        }
        return g(str, str2);
    }
}