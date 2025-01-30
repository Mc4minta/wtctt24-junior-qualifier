package com.google.firebase.encoders.g;

import com.google.firebase.encoders.EncodingException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.1.0 */
/* loaded from: classes2.dex */
public final class d implements com.google.firebase.encoders.f.b<d> {
    private static final com.google.firebase.encoders.b<Object> a = com.google.firebase.encoders.g.a.b();

    /* renamed from: b  reason: collision with root package name */
    private static final com.google.firebase.encoders.d<String> f9086b = com.google.firebase.encoders.g.b.b();

    /* renamed from: c  reason: collision with root package name */
    private static final com.google.firebase.encoders.d<Boolean> f9087c = c.b();

    /* renamed from: d  reason: collision with root package name */
    private static final b f9088d = new b(null);

    /* renamed from: e  reason: collision with root package name */
    private final Map<Class<?>, com.google.firebase.encoders.b<?>> f9089e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final Map<Class<?>, com.google.firebase.encoders.d<?>> f9090f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private com.google.firebase.encoders.b<Object> f9091g = a;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9092h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-encoders-json@@16.1.0 */
    /* loaded from: classes2.dex */
    public class a implements com.google.firebase.encoders.a {
        a() {
        }

        @Override // com.google.firebase.encoders.a
        public void a(Object obj, Writer writer) throws IOException {
            e eVar = new e(writer, d.this.f9089e, d.this.f9090f, d.this.f9091g, d.this.f9092h);
            eVar.h(obj, false);
            eVar.q();
        }

        @Override // com.google.firebase.encoders.a
        public String b(Object obj) {
            StringWriter stringWriter = new StringWriter();
            try {
                a(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }
    }

    /* compiled from: com.google.firebase:firebase-encoders-json@@16.1.0 */
    /* loaded from: classes2.dex */
    private static final class b implements com.google.firebase.encoders.d<Date> {
        private static final DateFormat a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        private b() {
        }

        @Override // com.google.firebase.encoders.d
        /* renamed from: b */
        public void a(Date date, com.google.firebase.encoders.e eVar) throws IOException {
            eVar.add(a.format(date));
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    public d() {
        m(String.class, f9086b);
        m(Boolean.class, f9087c);
        m(Date.class, f9088d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void i(Object obj, com.google.firebase.encoders.c cVar) throws IOException {
        throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    public com.google.firebase.encoders.a f() {
        return new a();
    }

    public d g(com.google.firebase.encoders.f.a aVar) {
        aVar.a(this);
        return this;
    }

    public d h(boolean z) {
        this.f9092h = z;
        return this;
    }

    @Override // com.google.firebase.encoders.f.b
    /* renamed from: l */
    public <T> d a(Class<T> cls, com.google.firebase.encoders.b<? super T> bVar) {
        this.f9089e.put(cls, bVar);
        this.f9090f.remove(cls);
        return this;
    }

    public <T> d m(Class<T> cls, com.google.firebase.encoders.d<? super T> dVar) {
        this.f9090f.put(cls, dVar);
        this.f9089e.remove(cls);
        return this;
    }
}