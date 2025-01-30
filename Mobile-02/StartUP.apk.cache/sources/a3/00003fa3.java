package com.squareup.wire.q;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.g;
import com.squareup.wire.g.a;
import com.squareup.wire.p;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.a0.m0;
import kotlin.a0.z;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.m;

/* compiled from: FieldBinding.kt */
/* loaded from: classes2.dex */
public final class a<M extends g<M, B>, B extends g.a<M, B>> {
    private final p.a a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10881b;

    /* renamed from: c  reason: collision with root package name */
    private final String f10882c;

    /* renamed from: d  reason: collision with root package name */
    private final String f10883d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10884e;

    /* renamed from: f  reason: collision with root package name */
    private final String f10885f;

    /* renamed from: g  reason: collision with root package name */
    private final String f10886g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f10887h;

    /* renamed from: i  reason: collision with root package name */
    private final Field f10888i;

    /* renamed from: j  reason: collision with root package name */
    private final Method f10889j;

    /* renamed from: k  reason: collision with root package name */
    private ProtoAdapter<?> f10890k;

    /* renamed from: l  reason: collision with root package name */
    private ProtoAdapter<?> f10891l;
    private ProtoAdapter<Object> m;
    private final Field n;

    public a(p wireField, Field messageField, Class<B> builderType) {
        String declaredName;
        m.h(wireField, "wireField");
        m.h(messageField, "messageField");
        m.h(builderType, "builderType");
        this.n = messageField;
        this.a = wireField.label();
        String name = messageField.getName();
        m.d(name, "messageField.name");
        this.f10881b = name;
        if (wireField.declaredName().length() == 0) {
            declaredName = messageField.getName();
            m.d(declaredName, "messageField.name");
        } else {
            declaredName = wireField.declaredName();
        }
        this.f10882c = declaredName;
        this.f10883d = wireField.jsonName().length() == 0 ? declaredName : wireField.jsonName();
        this.f10884e = wireField.tag();
        this.f10885f = wireField.keyAdapter();
        this.f10886g = wireField.adapter();
        this.f10887h = wireField.redacted();
        this.f10888i = c(builderType, name);
        Class<?> type = messageField.getType();
        m.d(type, "messageField.type");
        this.f10889j = d(builderType, name, type);
    }

    private final Field c(Class<?> cls, String str) {
        try {
            Field field = cls.getField(str);
            m.d(field, "builderType.getField(name)");
            return field;
        } catch (NoSuchFieldException unused) {
            throw new AssertionError("No builder field " + cls.getName() + '.' + str);
        }
    }

    private final Method d(Class<?> cls, String str, Class<?> cls2) {
        try {
            Method method = cls.getMethod(str, cls2);
            m.d(method, "builderType.getMethod(name, type)");
            return method;
        } catch (NoSuchMethodException unused) {
            throw new AssertionError("No builder method " + cls.getName() + '.' + str + '(' + cls2.getName() + ')');
        }
    }

    public final ProtoAdapter<Object> a() {
        ProtoAdapter<Object> protoAdapter = this.m;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        if (j()) {
            ProtoAdapter<?> k2 = k();
            if (k2 != null) {
                ProtoAdapter<?> m = m();
                if (m != null) {
                    ProtoAdapter<Object> e2 = ProtoAdapter.Companion.e(k2, m);
                    if (e2 != null) {
                        this.m = e2;
                        return e2;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
                }
                throw new TypeCastException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
            }
            throw new TypeCastException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
        }
        ProtoAdapter<?> withLabel$wire_runtime = m().withLabel$wire_runtime(this.a);
        if (withLabel$wire_runtime != null) {
            this.m = withLabel$wire_runtime;
            return withLabel$wire_runtime;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
    }

    public final Object b(M message) {
        m.h(message, "message");
        return this.n.get(message);
    }

    public final Object e(B builder) {
        m.h(builder, "builder");
        return this.f10888i.get(builder);
    }

    public final p.a f() {
        return this.a;
    }

    public final String g() {
        return this.f10881b;
    }

    public final boolean h() {
        return this.f10887h;
    }

    public final int i() {
        return this.f10884e;
    }

    public final boolean j() {
        return this.f10885f.length() > 0;
    }

    public final ProtoAdapter<?> k() {
        ProtoAdapter<?> protoAdapter = this.f10891l;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> c2 = ProtoAdapter.Companion.c(this.f10885f);
        this.f10891l = c2;
        return c2;
    }

    public final void l(B builder, Object obj) {
        m.h(builder, "builder");
        if (this.a.h()) {
            this.f10889j.invoke(builder, obj);
        } else {
            this.f10888i.set(builder, obj);
        }
    }

    public final ProtoAdapter<?> m() {
        ProtoAdapter<?> protoAdapter = this.f10890k;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> c2 = ProtoAdapter.Companion.c(this.f10886g);
        this.f10890k = c2;
        return c2;
    }

    public final void n(B builder, Object value) {
        Class<?> cls;
        Map v;
        List K0;
        m.h(builder, "builder");
        m.h(value, "value");
        if (this.a.isRepeated()) {
            Object e2 = e(builder);
            if (i0.n(e2)) {
                if (e2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any>");
                }
                i0.c(e2).add(value);
                return;
            } else if (e2 instanceof List) {
                K0 = z.K0((Collection) e2);
                K0.add(value);
                l(builder, K0);
                return;
            } else {
                cls = e2 != null ? e2.getClass() : null;
                throw new ClassCastException("Expected a list type, got " + cls + '.');
            }
        }
        if (this.f10885f.length() > 0) {
            Object e3 = e(builder);
            if (i0.o(e3)) {
                ((Map) e3).putAll((Map) value);
                return;
            } else if (e3 instanceof Map) {
                v = m0.v((Map) e3);
                v.putAll((Map) value);
                l(builder, v);
                return;
            } else {
                cls = e3 != null ? e3.getClass() : null;
                throw new ClassCastException("Expected a map type, got " + cls + '.');
            }
        }
        l(builder, value);
    }
}