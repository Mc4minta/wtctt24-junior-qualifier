package com.google.gson;

import java.math.BigInteger;

/* compiled from: JsonPrimitive.java */
/* loaded from: classes2.dex */
public final class o extends l {
    private static final Class<?>[] a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* renamed from: b  reason: collision with root package name */
    private Object f9544b;

    public o(Boolean bool) {
        E(bool);
    }

    private static boolean C(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : a) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    private static boolean z(o oVar) {
        Object obj = oVar.f9544b;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }

    public boolean B() {
        return this.f9544b instanceof Number;
    }

    public boolean D() {
        return this.f9544b instanceof String;
    }

    void E(Object obj) {
        if (obj instanceof Character) {
            this.f9544b = String.valueOf(((Character) obj).charValue());
            return;
        }
        com.google.gson.u.a.a((obj instanceof Number) || C(obj));
        this.f9544b = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f9544b == null) {
            return oVar.f9544b == null;
        } else if (z(this) && z(oVar)) {
            return x().longValue() == oVar.x().longValue();
        } else {
            Object obj2 = this.f9544b;
            if ((obj2 instanceof Number) && (oVar.f9544b instanceof Number)) {
                double doubleValue = x().doubleValue();
                double doubleValue2 = oVar.x().doubleValue();
                if (doubleValue != doubleValue2) {
                    return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
                }
                return true;
            }
            return obj2.equals(oVar.f9544b);
        }
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f9544b == null) {
            return 31;
        }
        if (z(this)) {
            doubleToLongBits = x().longValue();
        } else {
            Object obj = this.f9544b;
            if (obj instanceof Number) {
                doubleToLongBits = Double.doubleToLongBits(x().doubleValue());
            } else {
                return obj.hashCode();
            }
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    @Override // com.google.gson.l
    public String l() {
        if (B()) {
            return x().toString();
        }
        if (y()) {
            return s().toString();
        }
        return (String) this.f9544b;
    }

    public boolean r() {
        if (y()) {
            return s().booleanValue();
        }
        return Boolean.parseBoolean(l());
    }

    Boolean s() {
        return (Boolean) this.f9544b;
    }

    public double t() {
        return B() ? x().doubleValue() : Double.parseDouble(l());
    }

    public int u() {
        return B() ? x().intValue() : Integer.parseInt(l());
    }

    public long w() {
        return B() ? x().longValue() : Long.parseLong(l());
    }

    public Number x() {
        Object obj = this.f9544b;
        return obj instanceof String ? new com.google.gson.u.g((String) this.f9544b) : (Number) obj;
    }

    public boolean y() {
        return this.f9544b instanceof Boolean;
    }

    public o(Number number) {
        E(number);
    }

    public o(String str) {
        E(str);
    }
}