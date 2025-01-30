package com.bugsnag.android;

import android.util.JsonReader;
import android.util.JsonToken;
import com.coinbase.ApiConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ErrorReader.java */
/* loaded from: classes.dex */
public class d0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ErrorReader.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            a = iArr;
            try {
                iArr[JsonToken.BEGIN_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonToken.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonToken.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static <T> T a(JsonReader jsonReader) throws IOException {
        int i2 = a.a[jsonReader.peek().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return null;
                        }
                        return (T) b(jsonReader);
                    }
                    try {
                        try {
                            return (T) Integer.valueOf(jsonReader.nextInt());
                        } catch (NumberFormatException unused) {
                            return (T) Long.valueOf(jsonReader.nextLong());
                        }
                    } catch (NumberFormatException unused2) {
                        return (T) Double.valueOf(jsonReader.nextDouble());
                    }
                }
                return (T) Boolean.valueOf(jsonReader.nextBoolean());
            }
            return (T) jsonReader.nextString();
        }
        return (T) c(jsonReader);
    }

    private static <T> List<T> b(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            Object a2 = a(jsonReader);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        jsonReader.endArray();
        return arrayList;
    }

    private static Map<String, Object> c(JsonReader jsonReader) throws IOException {
        HashMap hashMap = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object a2 = a(jsonReader);
            if (a2 != null) {
                hashMap.put(nextName, a2);
            }
        }
        jsonReader.endObject();
        return hashMap;
    }

    private static Breadcrumb d(JsonReader jsonReader) throws IOException {
        HashMap hashMap = new HashMap();
        jsonReader.beginObject();
        String str = null;
        Date date = null;
        String str2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -450957489:
                    if (nextName.equals("metaData")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3373707:
                    if (nextName.equals(ApiConstants.NAME)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals("type")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 55126294:
                    if (nextName.equals("timestamp")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        hashMap.put(jsonReader.nextName(), jsonReader.nextString());
                    }
                    jsonReader.endObject();
                    break;
                case 1:
                    str = jsonReader.nextString();
                    break;
                case 2:
                    str2 = jsonReader.nextString().toUpperCase(Locale.US);
                    break;
                case 3:
                    try {
                        date = x.a(jsonReader.nextString());
                        break;
                    } catch (Exception e2) {
                        throw new IOException("Failed to parse breadcrumb timestamp: ", e2);
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (str == null || date == null || str2 == null) {
            return null;
        }
        return new Breadcrumb(str, BreadcrumbType.valueOf(str2), date, hashMap);
    }

    private static Breadcrumbs e(s sVar, JsonReader jsonReader) throws IOException {
        Breadcrumbs breadcrumbs = new Breadcrumbs(sVar);
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            Breadcrumb d2 = d(jsonReader);
            if (d2 != null) {
                breadcrumbs.add(d2);
            }
        }
        jsonReader.endArray();
        return breadcrumbs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v2, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bugsnag.android.c0 f(com.bugsnag.android.s r20, java.io.File r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 536
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.d0.f(com.bugsnag.android.s, java.io.File):com.bugsnag.android.c0");
    }

    private static k g(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[0];
        String str = null;
        String str2 = "android";
        String str3 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case 3575610:
                    if (nextName.equals("type")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 954925063:
                    if (nextName.equals(ApiConstants.MESSAGE)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1610083408:
                    if (nextName.equals("errorClass")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 2055832509:
                    if (nextName.equals("stacktrace")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    str2 = jsonReader.nextString();
                    break;
                case 1:
                    str3 = jsonReader.nextString();
                    break;
                case 2:
                    str = jsonReader.nextString();
                    break;
                case 3:
                    stackTraceElementArr = l(jsonReader);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        k kVar = new k(str, str3, stackTraceElementArr);
        kVar.d(str2);
        return kVar;
    }

    private static h0 h(s sVar, JsonReader jsonReader) throws IOException {
        jsonReader.beginArray();
        k g2 = g(jsonReader);
        k kVar = g2;
        while (jsonReader.hasNext()) {
            k g3 = g(jsonReader);
            kVar.initCause(g3);
            kVar = g3;
        }
        jsonReader.endArray();
        h0 h0Var = new h0(sVar, g2);
        if (g2 != null) {
            h0Var.e(g2.b());
        }
        return h0Var;
    }

    private static w0 i(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        int i2 = 0;
        int i3 = 0;
        String str = null;
        Date date = null;
        d1 d1Var = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -2128794476:
                    if (nextName.equals("startedAt")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1291329255:
                    if (nextName.equals("events")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3355:
                    if (nextName.equals("id")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3599307:
                    if (nextName.equals(ApiConstants.USER)) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    try {
                        date = x.a(jsonReader.nextString());
                        break;
                    } catch (Exception e2) {
                        throw new IOException("Unable to parse session startedAt: ", e2);
                    }
                case 1:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        nextName2.hashCode();
                        if (nextName2.equals("unhandled")) {
                            i2 = jsonReader.nextInt();
                        } else if (!nextName2.equals("handled")) {
                            jsonReader.skipValue();
                        } else {
                            i3 = jsonReader.nextInt();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 2:
                    str = jsonReader.nextString();
                    break;
                case 3:
                    d1Var = o(jsonReader);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (str != null && date != null) {
            return new w0(str, date, d1Var, i2, i3);
        }
        throw new IOException("Session data missing required fields");
    }

    private static ArrayList<String> j(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("type")) {
                str = jsonReader.nextString();
            } else if (!nextName.equals("attributes")) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginObject();
                jsonReader.nextName();
                str2 = jsonReader.nextString();
                jsonReader.endObject();
            }
        }
        jsonReader.endObject();
        ArrayList<String> arrayList = new ArrayList<>();
        if (str != null) {
            arrayList.add(str);
            if (str2 != null) {
                arrayList.add(str2);
            }
            return arrayList;
        }
        throw new IOException("Severity Reason type is required");
    }

    private static StackTraceElement k(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String str = null;
        int i2 = 0;
        String str2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1077554975:
                    if (nextName.equals("method")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -329142179:
                    if (nextName.equals("lineNumber")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3143036:
                    if (nextName.equals("file")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    i2 = jsonReader.nextInt();
                    break;
                case 2:
                    str2 = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new StackTraceElement("", str, str2, i2);
    }

    private static StackTraceElement[] l(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(k(jsonReader));
        }
        jsonReader.endArray();
        return (StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]);
    }

    private static o m(s sVar, JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        long j2 = 0;
        boolean z = false;
        String str = null;
        String str2 = null;
        StackTraceElement[] stackTraceElementArr = null;
        while (true) {
            long j3 = j2;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c2 = 65535;
                switch (nextName.hashCode()) {
                    case -767067472:
                        if (nextName.equals("errorReportingThread")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 3355:
                        if (nextName.equals("id")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 3373707:
                        if (nextName.equals(ApiConstants.NAME)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 3575610:
                        if (nextName.equals("type")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 2055832509:
                        if (nextName.equals("stacktrace")) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        z = jsonReader.nextBoolean();
                    case 1:
                        break;
                    case 2:
                        str = jsonReader.nextString();
                    case 3:
                        str2 = jsonReader.nextString();
                    case 4:
                        stackTraceElementArr = l(jsonReader);
                    default:
                        jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (str2 == null || stackTraceElementArr == null) {
                return null;
            }
            return new o(sVar, j3, str, str2, z, stackTraceElementArr);
            j2 = jsonReader.nextLong();
        }
    }

    private static c1 n(s sVar, JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            o m = m(sVar, jsonReader);
            if (m != null) {
                arrayList.add(m);
            }
        }
        jsonReader.endArray();
        return new c1((o[]) arrayList.toArray(new o[0]));
    }

    private static d1 o(JsonReader jsonReader) throws IOException {
        d1 d1Var = new d1();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case 3355:
                    if (nextName.equals("id")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3373707:
                    if (nextName.equals(ApiConstants.NAME)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 96619420:
                    if (nextName.equals("email")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    d1Var.e(jsonReader.nextString());
                    break;
                case 1:
                    d1Var.f(jsonReader.nextString());
                    break;
                case 2:
                    d1Var.d(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return d1Var;
    }
}