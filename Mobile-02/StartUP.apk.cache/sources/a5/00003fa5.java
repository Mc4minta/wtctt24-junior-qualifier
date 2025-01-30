package com.squareup.wire.q;

import com.squareup.wire.ProtoAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.l0.y;
import org.apache.http.message.TokenParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Internal.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class c {
    public static final <T> List<T> a(List<? extends T> redactElements, ProtoAdapter<T> adapter) {
        int r;
        m.h(redactElements, "$this$redactElements");
        m.h(adapter, "adapter");
        r = s.r(redactElements, 10);
        ArrayList arrayList = new ArrayList(r);
        for (T t : redactElements) {
            arrayList.add(adapter.redact(t));
        }
        return arrayList;
    }

    public static final int b(Object obj, Object obj2) {
        return (obj != null ? 1 : 0) + (obj2 == null ? 0 : 1);
    }

    public static final String c(String value) {
        boolean U;
        m.h(value, "value");
        StringBuilder sb = new StringBuilder(value.length());
        for (int i2 = 0; i2 < value.length(); i2++) {
            char charAt = value.charAt(i2);
            U = y.U(",[]{}\\", charAt, false, 2, null);
            if (U) {
                sb.append(TokenParser.ESCAPE);
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        m.d(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static final String d(List<String> values) {
        int r;
        String h0;
        m.h(values, "values");
        r = s.r(values, 10);
        ArrayList arrayList = new ArrayList(r);
        for (String str : values) {
            arrayList.add(b.c(str));
        }
        h0 = z.h0(arrayList, null, "[", "]", 0, null, null, 57, null);
        return h0;
    }
}