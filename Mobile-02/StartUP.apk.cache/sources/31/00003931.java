package com.google.firebase.abt;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-abt@@19.0.0 */
/* loaded from: classes2.dex */
public class a {
    private static final String[] a = {"experimentId", "experimentStartTime", "timeToLiveMillis", "triggerTimeoutMillis", "variantId"};

    /* renamed from: b  reason: collision with root package name */
    static final DateFormat f8555b = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);

    /* renamed from: c  reason: collision with root package name */
    private final String f8556c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8557d;

    /* renamed from: e  reason: collision with root package name */
    private final String f8558e;

    /* renamed from: f  reason: collision with root package name */
    private final Date f8559f;

    /* renamed from: g  reason: collision with root package name */
    private final long f8560g;

    /* renamed from: h  reason: collision with root package name */
    private final long f8561h;

    a(String str, String str2, String str3, Date date, long j2, long j3) {
        this.f8556c = str;
        this.f8557d = str2;
        this.f8558e = str3;
        this.f8559f = date;
        this.f8560g = j2;
        this.f8561h = j3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(Map<String, String> map) throws AbtException {
        h(map);
        try {
            return new a(map.get("experimentId"), map.get("variantId"), map.containsKey("triggerEvent") ? map.get("triggerEvent") : "", f8555b.parse(map.get("experimentStartTime")), Long.parseLong(map.get("triggerTimeoutMillis")), Long.parseLong(map.get("timeToLiveMillis")));
        } catch (NumberFormatException e2) {
            throw new AbtException("Could not process experiment: one of the durations could not be converted into a long.", e2);
        } catch (ParseException e3) {
            throw new AbtException("Could not process experiment: parsing experiment start time failed.", e3);
        }
    }

    private static void h(Map<String, String> map) throws AbtException {
        String[] strArr;
        ArrayList arrayList = new ArrayList();
        for (String str : a) {
            if (!map.containsKey(str)) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            throw new AbtException(String.format("The following keys are missing from the experiment info map: %s", arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f8556c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long c() {
        return this.f8559f.getTime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long d() {
        return this.f8561h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        return this.f8558e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long f() {
        return this.f8560g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        return this.f8557d;
    }
}