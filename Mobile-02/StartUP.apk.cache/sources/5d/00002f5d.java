package com.facebook.react.uimanager;

import java.util.Comparator;

/* compiled from: ViewAtIndex.java */
/* loaded from: classes2.dex */
public class u0 {
    public static Comparator<u0> a = new a();

    /* renamed from: b  reason: collision with root package name */
    public final int f5266b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5267c;

    /* compiled from: ViewAtIndex.java */
    /* loaded from: classes2.dex */
    static class a implements Comparator<u0> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(u0 u0Var, u0 u0Var2) {
            return u0Var.f5267c - u0Var2.f5267c;
        }
    }

    public u0(int i2, int i3) {
        this.f5266b = i2;
        this.f5267c = i3;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != u0.class) {
            return false;
        }
        u0 u0Var = (u0) obj;
        return this.f5267c == u0Var.f5267c && this.f5266b == u0Var.f5266b;
    }

    public String toString() {
        return "[" + this.f5266b + ", " + this.f5267c + "]";
    }
}