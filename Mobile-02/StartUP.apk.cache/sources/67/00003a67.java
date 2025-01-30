package com.google.firebase.crashlytics.c.i.x;

import android.util.Base64;
import android.util.JsonReader;
import com.coinbase.ApiConstants;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.firebase.crashlytics.c.i.v;
import com.google.firebase.crashlytics.c.i.w;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import org.apache.http.cookie.ClientCookie;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class h {
    private static final com.google.firebase.encoders.a a = new com.google.firebase.encoders.g.d().g(com.google.firebase.crashlytics.c.i.a.a).h(true).f();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public interface a<T> {
        T a(JsonReader jsonReader) throws IOException;
    }

    private static v.d.e A(JsonReader jsonReader) throws IOException {
        v.d.e.a a2 = v.d.e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -293026577:
                    if (nextName.equals("jailbroken")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals(ClientCookie.VERSION_ATTR)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.b(jsonReader.nextString());
                    break;
                case 1:
                    a2.c(jsonReader.nextBoolean());
                    break;
                case 2:
                    a2.e(jsonReader.nextString());
                    break;
                case 3:
                    a2.d(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    private static v B(JsonReader jsonReader) throws IOException {
        v.a b2 = v.b();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -2118372775:
                    if (nextName.equals("ndkPayload")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1962630338:
                    if (nextName.equals("sdkVersion")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 344431858:
                    if (nextName.equals("gmpAppId")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1984987798:
                    if (nextName.equals("session")) {
                        c2 = 7;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    b2.f(z(jsonReader));
                    break;
                case 1:
                    b2.h(jsonReader.nextString());
                    break;
                case 2:
                    b2.b(jsonReader.nextString());
                    break;
                case 3:
                    b2.d(jsonReader.nextString());
                    break;
                case 4:
                    b2.e(jsonReader.nextString());
                    break;
                case 5:
                    b2.g(jsonReader.nextInt());
                    break;
                case 6:
                    b2.c(jsonReader.nextString());
                    break;
                case 7:
                    b2.i(C(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return b2.a();
    }

    private static v.d C(JsonReader jsonReader) throws IOException {
        v.d.b a2 = v.d.a();
        jsonReader.beginObject();
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
                case -1618432855:
                    if (nextName.equals("identifier")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1606742899:
                    if (nextName.equals("endedAt")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1335157162:
                    if (nextName.equals("device")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1291329255:
                    if (nextName.equals("events")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3556:
                    if (nextName.equals("os")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals("app")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 3599307:
                    if (nextName.equals(ApiConstants.USER)) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 286956243:
                    if (nextName.equals("generator")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 1025385094:
                    if (nextName.equals("crashed")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 2047016109:
                    if (nextName.equals("generatorType")) {
                        c2 = '\n';
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.l(jsonReader.nextLong());
                    break;
                case 1:
                    a2.j(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case 2:
                    a2.e(Long.valueOf(jsonReader.nextLong()));
                    break;
                case 3:
                    a2.d(n(jsonReader));
                    break;
                case 4:
                    a2.f(l(jsonReader, com.google.firebase.crashlytics.c.i.x.a.b()));
                    break;
                case 5:
                    a2.k(A(jsonReader));
                    break;
                case 6:
                    a2.b(k(jsonReader));
                    break;
                case 7:
                    a2.m(D(jsonReader));
                    break;
                case '\b':
                    a2.g(jsonReader.nextString());
                    break;
                case '\t':
                    a2.c(jsonReader.nextBoolean());
                    break;
                case '\n':
                    a2.h(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    private static v.d.f D(JsonReader jsonReader) throws IOException {
        v.d.f.a a2 = v.d.f.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals("identifier")) {
                jsonReader.skipValue();
            } else {
                a2.b(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    private static /* synthetic */ void a(Throwable th, AutoCloseable autoCloseable) {
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable unused) {
        }
    }

    private static v.d.a k(JsonReader jsonReader) throws IOException {
        v.d.a.AbstractC0172a a2 = v.d.a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1618432855:
                    if (nextName.equals("identifier")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals(ClientCookie.VERSION_ATTR)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.c(jsonReader.nextString());
                    break;
                case 1:
                    a2.e(jsonReader.nextString());
                    break;
                case 2:
                    a2.d(jsonReader.nextString());
                    break;
                case 3:
                    a2.b(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    private static <T> w<T> l(JsonReader jsonReader, a<T> aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(aVar.a(jsonReader));
        }
        jsonReader.endArray();
        return w.h(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static v.b m(JsonReader jsonReader) throws IOException {
        v.b.a a2 = v.b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("key")) {
                a2.b(jsonReader.nextString());
            } else if (!nextName.equals("value")) {
                jsonReader.skipValue();
            } else {
                a2.c(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    private static v.d.c n(JsonReader jsonReader) throws IOException {
        v.d.c.a a2 = v.d.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1981332476:
                    if (nextName.equals("simulator")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1969347631:
                    if (nextName.equals("manufacturer")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 112670:
                    if (nextName.equals("ram")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3002454:
                    if (nextName.equals("arch")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 81784169:
                    if (nextName.equals("diskSpace")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 94848180:
                    if (nextName.equals("cores")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 104069929:
                    if (nextName.equals("model")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 109757585:
                    if (nextName.equals(ApiConstants.STATE)) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 2078953423:
                    if (nextName.equals("modelClass")) {
                        c2 = '\b';
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.i(jsonReader.nextBoolean());
                    break;
                case 1:
                    a2.e(jsonReader.nextString());
                    break;
                case 2:
                    a2.h(jsonReader.nextLong());
                    break;
                case 3:
                    a2.b(jsonReader.nextInt());
                    break;
                case 4:
                    a2.d(jsonReader.nextLong());
                    break;
                case 5:
                    a2.c(jsonReader.nextInt());
                    break;
                case 6:
                    a2.f(jsonReader.nextString());
                    break;
                case 7:
                    a2.j(jsonReader.nextInt());
                    break;
                case '\b':
                    a2.g(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static v.d.AbstractC0173d o(JsonReader jsonReader) throws IOException {
        v.d.AbstractC0173d.b a2 = v.d.AbstractC0173d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1335157162:
                    if (nextName.equals("device")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals("app")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 107332:
                    if (nextName.equals("log")) {
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
                case 55126294:
                    if (nextName.equals("timestamp")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.c(r(jsonReader));
                    break;
                case 1:
                    a2.b(p(jsonReader));
                    break;
                case 2:
                    a2.d(v(jsonReader));
                    break;
                case 3:
                    a2.f(jsonReader.nextString());
                    break;
                case 4:
                    a2.e(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    private static v.d.AbstractC0173d.a p(JsonReader jsonReader) throws IOException {
        v.d.AbstractC0173d.a.AbstractC0174a a2 = v.d.AbstractC0173d.a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1332194002:
                    if (nextName.equals(AppStateModule.APP_STATE_BACKGROUND)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1090974952:
                    if (nextName.equals("execution")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 555169704:
                    if (nextName.equals("customAttributes")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 928737948:
                    if (nextName.equals("uiOrientation")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.b(Boolean.valueOf(jsonReader.nextBoolean()));
                    break;
                case 1:
                    a2.d(s(jsonReader));
                    break;
                case 2:
                    a2.c(l(jsonReader, c.b()));
                    break;
                case 3:
                    a2.e(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static v.d.AbstractC0173d.a.b.AbstractC0175a q(JsonReader jsonReader) throws IOException {
        v.d.AbstractC0173d.a.b.AbstractC0175a.AbstractC0176a a2 = v.d.AbstractC0173d.a.b.AbstractC0175a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case 3373707:
                    if (nextName.equals(ApiConstants.NAME)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3530753:
                    if (nextName.equals("size")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3601339:
                    if (nextName.equals("uuid")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1153765347:
                    if (nextName.equals("baseAddress")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.c(jsonReader.nextString());
                    break;
                case 1:
                    a2.d(jsonReader.nextLong());
                    break;
                case 2:
                    a2.f(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case 3:
                    a2.b(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    private static v.d.AbstractC0173d.c r(JsonReader jsonReader) throws IOException {
        v.d.AbstractC0173d.c.a a2 = v.d.AbstractC0173d.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1708606089:
                    if (nextName.equals("batteryLevel")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1455558134:
                    if (nextName.equals("batteryVelocity")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1439500848:
                    if (nextName.equals("orientation")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 279795450:
                    if (nextName.equals("diskUsed")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 976541947:
                    if (nextName.equals("ramUsed")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1516795582:
                    if (nextName.equals("proximityOn")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.b(Double.valueOf(jsonReader.nextDouble()));
                    break;
                case 1:
                    a2.c(jsonReader.nextInt());
                    break;
                case 2:
                    a2.e(jsonReader.nextInt());
                    break;
                case 3:
                    a2.d(jsonReader.nextLong());
                    break;
                case 4:
                    a2.g(jsonReader.nextLong());
                    break;
                case 5:
                    a2.f(jsonReader.nextBoolean());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    private static v.d.AbstractC0173d.a.b s(JsonReader jsonReader) throws IOException {
        v.d.AbstractC0173d.a.b.AbstractC0177b a2 = v.d.AbstractC0173d.a.b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1337936983:
                    if (nextName.equals("threads")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -902467928:
                    if (nextName.equals("signal")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 937615455:
                    if (nextName.equals("binaries")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1481625679:
                    if (nextName.equals("exception")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.e(l(jsonReader, d.b()));
                    break;
                case 1:
                    a2.d(w(jsonReader));
                    break;
                case 2:
                    a2.b(l(jsonReader, e.b()));
                    break;
                case 3:
                    a2.c(t(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    private static v.d.AbstractC0173d.a.b.c t(JsonReader jsonReader) throws IOException {
        v.d.AbstractC0173d.a.b.c.AbstractC0178a a2 = v.d.AbstractC0173d.a.b.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1266514778:
                    if (nextName.equals("frames")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -934964668:
                    if (nextName.equals("reason")) {
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
                case 91997906:
                    if (nextName.equals("causedBy")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 581754413:
                    if (nextName.equals("overflowCount")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.c(l(jsonReader, f.b()));
                    break;
                case 1:
                    a2.e(jsonReader.nextString());
                    break;
                case 2:
                    a2.f(jsonReader.nextString());
                    break;
                case 3:
                    a2.b(t(jsonReader));
                    break;
                case 4:
                    a2.d(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static v.d.AbstractC0173d.a.b.e.AbstractC0182b u(JsonReader jsonReader) throws IOException {
        v.d.AbstractC0173d.a.b.e.AbstractC0182b.AbstractC0183a a2 = v.d.AbstractC0173d.a.b.e.AbstractC0182b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1019779949:
                    if (nextName.equals("offset")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -887523944:
                    if (nextName.equals("symbol")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3571:
                    if (nextName.equals("pc")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3143036:
                    if (nextName.equals("file")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.d(jsonReader.nextLong());
                    break;
                case 1:
                    a2.f(jsonReader.nextString());
                    break;
                case 2:
                    a2.e(jsonReader.nextLong());
                    break;
                case 3:
                    a2.b(jsonReader.nextString());
                    break;
                case 4:
                    a2.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    private static v.d.AbstractC0173d.AbstractC0184d v(JsonReader jsonReader) throws IOException {
        v.d.AbstractC0173d.AbstractC0184d.a a2 = v.d.AbstractC0173d.AbstractC0184d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals("content")) {
                jsonReader.skipValue();
            } else {
                a2.b(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    private static v.d.AbstractC0173d.a.b.AbstractC0179d w(JsonReader jsonReader) throws IOException {
        v.d.AbstractC0173d.a.b.AbstractC0179d.AbstractC0180a a2 = v.d.AbstractC0173d.a.b.AbstractC0179d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1147692044:
                    if (nextName.equals("address")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3059181:
                    if (nextName.equals("code")) {
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
            }
            switch (c2) {
                case 0:
                    a2.b(jsonReader.nextLong());
                    break;
                case 1:
                    a2.c(jsonReader.nextString());
                    break;
                case 2:
                    a2.d(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static v.d.AbstractC0173d.a.b.e x(JsonReader jsonReader) throws IOException {
        v.d.AbstractC0173d.a.b.e.AbstractC0181a a2 = v.d.AbstractC0173d.a.b.e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1266514778:
                    if (nextName.equals("frames")) {
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
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.b(l(jsonReader, g.b()));
                    break;
                case 1:
                    a2.d(jsonReader.nextString());
                    break;
                case 2:
                    a2.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static v.c.b y(JsonReader jsonReader) throws IOException {
        v.c.b.a a2 = v.c.b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("filename")) {
                a2.c(jsonReader.nextString());
            } else if (!nextName.equals("contents")) {
                jsonReader.skipValue();
            } else {
                a2.b(Base64.decode(jsonReader.nextString(), 2));
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    private static v.c z(JsonReader jsonReader) throws IOException {
        v.c.a a2 = v.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("files")) {
                a2.b(l(jsonReader, b.b()));
            } else if (!nextName.equals("orgId")) {
                jsonReader.skipValue();
            } else {
                a2.c(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    public v E(String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            v B = B(jsonReader);
            a(null, jsonReader);
            return B;
        } catch (IllegalStateException e2) {
            throw new IOException(e2);
        }
    }

    public String F(v vVar) {
        return a.b(vVar);
    }

    public v.d.AbstractC0173d i(String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            v.d.AbstractC0173d o = o(jsonReader);
            a(null, jsonReader);
            return o;
        } catch (IllegalStateException e2) {
            throw new IOException(e2);
        }
    }

    public String j(v.d.AbstractC0173d abstractC0173d) {
        return a.b(abstractC0173d);
    }
}