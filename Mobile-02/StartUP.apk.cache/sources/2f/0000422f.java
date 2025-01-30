package com.toshi.view.custom.recoveryPhrase.keyboard.m;

import java.util.List;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: KeyboardLayout.kt */
/* loaded from: classes2.dex */
public final class b {
    private final List<Object> a;

    public b() {
        this(null, 1, null);
    }

    public b(List<? extends Object> list) {
        m.g(list, "list");
        this.a = list;
    }

    public final List<Object> a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && m.c(this.a, ((b) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "Row(list=" + this.a + ')';
    }

    public /* synthetic */ b(List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? r.g() : list);
    }
}