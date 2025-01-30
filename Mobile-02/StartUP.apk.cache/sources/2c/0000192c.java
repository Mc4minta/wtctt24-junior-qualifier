package com.coinbase.wallet.core.util;

import android.net.Uri;
import com.coinbase.wallet.core.jsonadapters.BigDecimalAdapter;
import com.coinbase.wallet.core.jsonadapters.BigIntegerAdapter;
import com.coinbase.wallet.core.jsonadapters.UIntAdapter;
import com.coinbase.wallet.core.jsonadapters.UriAdapter;
import com.coinbase.wallet.core.jsonadapters.UrlAdapter;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlin.x;
import l.a.a;

/* compiled from: JSON.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b+\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0003\u0010\u0004J5\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\b\"\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0006\b\u0000\u0010\u0005\u0018\u0001H\u0086\b¢\u0006\u0004\b\r\u0010\u000eJ4\u0010\u0012\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0005\u0018\u00012\u0006\u0010\u0010\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nH\u0087\b¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0015\u001a\u00020\u000f\"\u0006\b\u0000\u0010\u0005\u0018\u00012\u0006\u0010\u0014\u001a\u00028\u0000H\u0087\b¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\u001a\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0007¢\u0006\u0004\b\u001a\u0010\u001bR*\u0010\u001d\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0000@\u0001X\u0081\u0004¢\u0006\u0012\n\u0004\b \u0010!\u0012\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R*\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00028\u0000@BX\u0081\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u0012\u0004\b*\u0010%\u001a\u0004\b)\u0010\u0004¨\u0006,"}, d2 = {"Lcom/coinbase/wallet/core/util/JSON;", "", "Lcom/squareup/moshi/Moshi;", "buildMoshi", "()Lcom/squareup/moshi/Moshi;", "T", "Ljava/lang/reflect/Type;", "rawType", "", "params", "Lcom/squareup/moshi/JsonAdapter;", "parameterizedAdapter", "(Ljava/lang/reflect/Type;[Ljava/lang/reflect/Type;)Lcom/squareup/moshi/JsonAdapter;", "adapter", "()Lcom/squareup/moshi/JsonAdapter;", "", "jsonString", "parameterizedTypeAdapter", "fromJsonString", "(Ljava/lang/String;Lcom/squareup/moshi/JsonAdapter;)Ljava/lang/Object;", "instance", "toJsonString", "(Ljava/lang/Object;)Ljava/lang/String;", "Ljava/lang/Class;", "clazz", "Lkotlin/x;", "add", "(Ljava/lang/Class;Lcom/squareup/moshi/JsonAdapter;)V", "", "entries", "Ljava/util/Map;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "multiReadSingleWriteLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "getMultiReadSingleWriteLock", "()Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "getMultiReadSingleWriteLock$annotations", "()V", "<set-?>", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi", "getMoshi$annotations", "<init>", "core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class JSON {
    public static final JSON INSTANCE;
    private static final Map<Class<?>, JsonAdapter<?>> entries;
    private static Moshi moshi;
    private static final ReentrantReadWriteLock multiReadSingleWriteLock;

    static {
        JSON json = new JSON();
        INSTANCE = json;
        entries = new LinkedHashMap();
        multiReadSingleWriteLock = new ReentrantReadWriteLock();
        moshi = json.buildMoshi();
    }

    private JSON() {
    }

    private final Moshi buildMoshi() {
        Moshi.Builder add = new Moshi.Builder().add(URL.class, new UrlAdapter()).add(BigDecimal.class, new BigDecimalAdapter()).add(BigInteger.class, new BigIntegerAdapter()).add(UInt.class, new UIntAdapter()).add(Uri.class, new UriAdapter());
        for (Map.Entry<Class<?>, JsonAdapter<?>> entry : entries.entrySet()) {
            add.add(entry.getKey(), entry.getValue());
        }
        Moshi build = add.build();
        m.f(build, "builder.build()");
        return build;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:6:0x001b, B:13:0x0035, B:15:0x0060, B:16:0x0072), top: B:22:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0060 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:6:0x001b, B:13:0x0035, B:15:0x0060, B:16:0x0072), top: B:22:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0072 A[Catch: all -> 0x0080, TRY_LEAVE, TryCatch #0 {all -> 0x0080, blocks: (B:6:0x001b, B:13:0x0035, B:15:0x0060, B:16:0x0072), top: B:22:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object fromJsonString$default(com.coinbase.wallet.core.util.JSON r5, java.lang.String r6, com.squareup.moshi.JsonAdapter r7, int r8, java.lang.Object r9) {
        /*
            java.lang.Class<java.lang.Object> r9 = java.lang.Object.class
            java.lang.String r0 = "T"
            r1 = 2
            r8 = r8 & r1
            if (r8 == 0) goto L9
            r7 = 0
        L9:
            java.lang.String r8 = "jsonString"
            kotlin.jvm.internal.m.g(r6, r8)
            java.util.concurrent.locks.ReentrantReadWriteLock r5 = r5.getMultiReadSingleWriteLock()
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r5 = r5.readLock()
            r5.lock()
            r8 = 1
            r2 = 4
            kotlin.jvm.internal.m.l(r2, r0)     // Catch: java.lang.Throwable -> L80
            kotlin.j0.d r3 = kotlin.jvm.internal.e0.b(r9)     // Catch: java.lang.Throwable -> L80
            java.util.List r3 = r3.getTypeParameters()     // Catch: java.lang.Throwable -> L80
            boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L80
            r3 = r3 ^ r8
            if (r3 == 0) goto L32
            if (r7 == 0) goto L30
            goto L32
        L30:
            r3 = 0
            goto L33
        L32:
            r3 = r8
        L33:
            if (r3 != 0) goto L5e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r3.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = "Since "
            r3.append(r4)     // Catch: java.lang.Throwable -> L80
            kotlin.jvm.internal.m.l(r2, r0)     // Catch: java.lang.Throwable -> L80
            kotlin.j0.d r4 = kotlin.jvm.internal.e0.b(r9)     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = r4.getSimpleName()     // Catch: java.lang.Throwable -> L80
            r3.append(r4)     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = " is parameterized please pass an adapter to `parameterizedAdapter`"
            r3.append(r4)     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L80
            com.coinbase.wallet.core.util.AssertionException r4 = new com.coinbase.wallet.core.util.AssertionException     // Catch: java.lang.Throwable -> L80
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L80
            l.a.a.e(r4)     // Catch: java.lang.Throwable -> L80
        L5e:
            if (r7 != 0) goto L72
            com.coinbase.wallet.core.util.JSON r7 = com.coinbase.wallet.core.util.JSON.INSTANCE     // Catch: java.lang.Throwable -> L80
            com.squareup.moshi.Moshi r7 = r7.getMoshi()     // Catch: java.lang.Throwable -> L80
            kotlin.jvm.internal.m.l(r2, r0)     // Catch: java.lang.Throwable -> L80
            com.squareup.moshi.JsonAdapter r7 = r7.adapter(r9)     // Catch: java.lang.Throwable -> L80
            java.lang.Object r6 = r7.fromJson(r6)     // Catch: java.lang.Throwable -> L80
            goto L76
        L72:
            java.lang.Object r6 = r7.fromJson(r6)     // Catch: java.lang.Throwable -> L80
        L76:
            kotlin.jvm.internal.l.b(r1)
            r5.unlock()
            kotlin.jvm.internal.l.a(r1)
            return r6
        L80:
            r6 = move-exception
            kotlin.jvm.internal.l.b(r8)
            r5.unlock()
            kotlin.jvm.internal.l.a(r8)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.core.util.JSON.fromJsonString$default(com.coinbase.wallet.core.util.JSON, java.lang.String, com.squareup.moshi.JsonAdapter, int, java.lang.Object):java.lang.Object");
    }

    public static /* synthetic */ void getMoshi$annotations() {
    }

    public static /* synthetic */ void getMultiReadSingleWriteLock$annotations() {
    }

    public final /* synthetic */ <T> JsonAdapter<T> adapter() {
        m.l(4, "T");
        if (!e0.b(Object.class).getTypeParameters().isEmpty()) {
            m.l(4, "T");
            a.e(new AssertionException(m.o(e0.b(Object.class).getSimpleName(), " is parameterized. Please use `parameterizedAdapter` function.")));
        }
        Moshi moshi2 = getMoshi();
        m.l(4, "T");
        JsonAdapter<T> adapter = moshi2.adapter((Class) Object.class);
        m.f(adapter, "moshi.adapter(T::class.java)");
        return adapter;
    }

    public final <T> void add(Class<T> clazz, JsonAdapter<T> adapter) {
        m.g(clazz, "clazz");
        m.g(adapter, "adapter");
        ReentrantReadWriteLock reentrantReadWriteLock = multiReadSingleWriteLock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i3 = 0; i3 < readHoldCount; i3++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            entries.put(clazz, adapter);
            moshi = INSTANCE.buildMoshi();
            x xVar = x.a;
        } finally {
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030 A[Catch: all -> 0x007c, TryCatch #0 {all -> 0x007c, blocks: (B:3:0x0016, B:10:0x0030, B:12:0x005b, B:13:0x006d), top: B:19:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005b A[Catch: all -> 0x007c, TryCatch #0 {all -> 0x007c, blocks: (B:3:0x0016, B:10:0x0030, B:12:0x005b, B:13:0x006d), top: B:19:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006d A[Catch: all -> 0x007c, TRY_LEAVE, TryCatch #0 {all -> 0x007c, blocks: (B:3:0x0016, B:10:0x0030, B:12:0x005b, B:13:0x006d), top: B:19:0x0016 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ <T> T fromJsonString(java.lang.String r8, com.squareup.moshi.JsonAdapter<T> r9) {
        /*
            r7 = this;
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            java.lang.String r1 = "T"
            java.lang.String r2 = "jsonString"
            kotlin.jvm.internal.m.g(r8, r2)
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = r7.getMultiReadSingleWriteLock()
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r2.readLock()
            r2.lock()
            r3 = 1
            r4 = 4
            kotlin.jvm.internal.m.l(r4, r1)     // Catch: java.lang.Throwable -> L7c
            kotlin.j0.d r5 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> L7c
            java.util.List r5 = r5.getTypeParameters()     // Catch: java.lang.Throwable -> L7c
            boolean r5 = r5.isEmpty()     // Catch: java.lang.Throwable -> L7c
            r5 = r5 ^ r3
            if (r5 == 0) goto L2d
            if (r9 == 0) goto L2b
            goto L2d
        L2b:
            r5 = 0
            goto L2e
        L2d:
            r5 = r3
        L2e:
            if (r5 != 0) goto L59
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            r5.<init>()     // Catch: java.lang.Throwable -> L7c
            java.lang.String r6 = "Since "
            r5.append(r6)     // Catch: java.lang.Throwable -> L7c
            kotlin.jvm.internal.m.l(r4, r1)     // Catch: java.lang.Throwable -> L7c
            kotlin.j0.d r6 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r6 = r6.getSimpleName()     // Catch: java.lang.Throwable -> L7c
            r5.append(r6)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r6 = " is parameterized please pass an adapter to `parameterizedAdapter`"
            r5.append(r6)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L7c
            com.coinbase.wallet.core.util.AssertionException r6 = new com.coinbase.wallet.core.util.AssertionException     // Catch: java.lang.Throwable -> L7c
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L7c
            l.a.a.e(r6)     // Catch: java.lang.Throwable -> L7c
        L59:
            if (r9 != 0) goto L6d
            com.coinbase.wallet.core.util.JSON r9 = com.coinbase.wallet.core.util.JSON.INSTANCE     // Catch: java.lang.Throwable -> L7c
            com.squareup.moshi.Moshi r9 = r9.getMoshi()     // Catch: java.lang.Throwable -> L7c
            kotlin.jvm.internal.m.l(r4, r1)     // Catch: java.lang.Throwable -> L7c
            com.squareup.moshi.JsonAdapter r9 = r9.adapter(r0)     // Catch: java.lang.Throwable -> L7c
            java.lang.Object r8 = r9.fromJson(r8)     // Catch: java.lang.Throwable -> L7c
            goto L71
        L6d:
            java.lang.Object r8 = r9.fromJson(r8)     // Catch: java.lang.Throwable -> L7c
        L71:
            r9 = 2
            kotlin.jvm.internal.l.b(r9)
            r2.unlock()
            kotlin.jvm.internal.l.a(r9)
            return r8
        L7c:
            r8 = move-exception
            kotlin.jvm.internal.l.b(r3)
            r2.unlock()
            kotlin.jvm.internal.l.a(r3)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.core.util.JSON.fromJsonString(java.lang.String, com.squareup.moshi.JsonAdapter):java.lang.Object");
    }

    public final Moshi getMoshi() {
        return moshi;
    }

    public final ReentrantReadWriteLock getMultiReadSingleWriteLock() {
        return multiReadSingleWriteLock;
    }

    public final <T> JsonAdapter<T> parameterizedAdapter(Type rawType, Type... params) {
        m.g(rawType, "rawType");
        m.g(params, "params");
        if (!(params.length == 0)) {
            JsonAdapter<T> adapter = moshi.adapter(Types.newParameterizedType(rawType, (Type[]) Arrays.copyOf(params, params.length)));
            m.f(adapter, "{\n            val type = Types.newParameterizedType(rawType, *params)\n            moshi.adapter(type)\n        }");
            return adapter;
        }
        JsonAdapter<T> adapter2 = moshi.adapter(rawType);
        m.f(adapter2, "{\n            moshi.adapter(rawType)\n        }");
        return adapter2;
    }

    public final /* synthetic */ <T> String toJsonString(T t) {
        ReentrantReadWriteLock.ReadLock readLock = getMultiReadSingleWriteLock().readLock();
        readLock.lock();
        try {
            Moshi moshi2 = INSTANCE.getMoshi();
            m.l(4, "T");
            String json = moshi2.adapter((Class) Object.class).toJson(t);
            m.f(json, "adapter.toJson(instance)");
            l.b(2);
            readLock.unlock();
            l.a(2);
            return json;
        } catch (Throwable th) {
            l.b(1);
            readLock.unlock();
            l.a(1);
            throw th;
        }
    }
}