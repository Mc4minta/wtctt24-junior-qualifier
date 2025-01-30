package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.p;
import kotlin.x;

/* compiled from: ExceptionsConstuctor.kt */
/* loaded from: classes3.dex */
public final class f {
    private static final int a = d(Throwable.class, -1);

    /* renamed from: b  reason: collision with root package name */
    private static final ReentrantReadWriteLock f17494b = new ReentrantReadWriteLock();

    /* renamed from: c  reason: collision with root package name */
    private static final WeakHashMap<Class<? extends Throwable>, kotlin.e0.c.l<Throwable, Throwable>> f17495c = new WeakHashMap<>();

    /* compiled from: ExceptionsConstuctor.kt */
    /* loaded from: classes3.dex */
    public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, Throwable> {
        final /* synthetic */ Constructor a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Constructor constructor) {
            super(1);
            this.a = constructor;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final Throwable invoke(Throwable th) {
            Object a;
            Object newInstance;
            try {
                p.a aVar = kotlin.p.a;
                newInstance = this.a.newInstance(th.getMessage(), th);
            } catch (Throwable th2) {
                p.a aVar2 = kotlin.p.a;
                a = kotlin.p.a(kotlin.q.a(th2));
            }
            if (newInstance != null) {
                a = kotlin.p.a((Throwable) newInstance);
                if (kotlin.p.c(a)) {
                    a = null;
                }
                return (Throwable) a;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        }
    }

    /* compiled from: ExceptionsConstuctor.kt */
    /* loaded from: classes3.dex */
    public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, Throwable> {
        final /* synthetic */ Constructor a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Constructor constructor) {
            super(1);
            this.a = constructor;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final Throwable invoke(Throwable th) {
            Object a;
            Object newInstance;
            try {
                p.a aVar = kotlin.p.a;
                newInstance = this.a.newInstance(th);
            } catch (Throwable th2) {
                p.a aVar2 = kotlin.p.a;
                a = kotlin.p.a(kotlin.q.a(th2));
            }
            if (newInstance != null) {
                a = kotlin.p.a((Throwable) newInstance);
                if (kotlin.p.c(a)) {
                    a = null;
                }
                return (Throwable) a;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        }
    }

    /* compiled from: ExceptionsConstuctor.kt */
    /* loaded from: classes3.dex */
    public static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, Throwable> {
        final /* synthetic */ Constructor a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Constructor constructor) {
            super(1);
            this.a = constructor;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final Throwable invoke(Throwable th) {
            Object a;
            Object newInstance;
            try {
                p.a aVar = kotlin.p.a;
                newInstance = this.a.newInstance(th.getMessage());
            } catch (Throwable th2) {
                p.a aVar2 = kotlin.p.a;
                a = kotlin.p.a(kotlin.q.a(th2));
            }
            if (newInstance != null) {
                Throwable th3 = (Throwable) newInstance;
                th3.initCause(th);
                a = kotlin.p.a(th3);
                if (kotlin.p.c(a)) {
                    a = null;
                }
                return (Throwable) a;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        }
    }

    /* compiled from: ExceptionsConstuctor.kt */
    /* loaded from: classes3.dex */
    public static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, Throwable> {
        final /* synthetic */ Constructor a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Constructor constructor) {
            super(1);
            this.a = constructor;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final Throwable invoke(Throwable th) {
            Object a;
            Object newInstance;
            try {
                p.a aVar = kotlin.p.a;
                newInstance = this.a.newInstance(new Object[0]);
            } catch (Throwable th2) {
                p.a aVar2 = kotlin.p.a;
                a = kotlin.p.a(kotlin.q.a(th2));
            }
            if (newInstance != null) {
                Throwable th3 = (Throwable) newInstance;
                th3.initCause(th);
                a = kotlin.p.a(th3);
                if (kotlin.p.c(a)) {
                    a = null;
                }
                return (Throwable) a;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        }
    }

    /* compiled from: Comparisons.kt */
    /* loaded from: classes3.dex */
    public static final class e<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int c2;
            c2 = kotlin.b0.b.c(Integer.valueOf(((Constructor) t2).getParameterTypes().length), Integer.valueOf(((Constructor) t).getParameterTypes().length));
            return c2;
        }
    }

    /* compiled from: ExceptionsConstuctor.kt */
    /* renamed from: kotlinx.coroutines.internal.f$f  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class C0421f extends kotlin.jvm.internal.o implements kotlin.e0.c.l {
        public static final C0421f a = new C0421f();

        C0421f() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final Void invoke(Throwable th) {
            return null;
        }
    }

    /* compiled from: ExceptionsConstuctor.kt */
    /* loaded from: classes3.dex */
    static final class g extends kotlin.jvm.internal.o implements kotlin.e0.c.l {
        public static final g a = new g();

        g() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final Void invoke(Throwable th) {
            return null;
        }
    }

    private static final kotlin.e0.c.l<Throwable, Throwable> a(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length != 0) {
            if (length != 1) {
                if (length == 2 && kotlin.jvm.internal.m.c(parameterTypes[0], String.class) && kotlin.jvm.internal.m.c(parameterTypes[1], Throwable.class)) {
                    return new a(constructor);
                }
            } else {
                Class<?> cls = parameterTypes[0];
                if (kotlin.jvm.internal.m.c(cls, Throwable.class)) {
                    return new b(constructor);
                }
                if (kotlin.jvm.internal.m.c(cls, String.class)) {
                    return new c(constructor);
                }
            }
            return null;
        }
        return new d(constructor);
    }

    private static final int b(Class<?> cls, int i2) {
        Field[] declaredFields;
        do {
            int length = cls.getDeclaredFields().length;
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                if (!Modifier.isStatic(declaredFields[i4].getModifiers())) {
                    i3++;
                }
            }
            i2 += i3;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i2;
    }

    static /* synthetic */ int c(Class cls, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return b(cls, i2);
    }

    private static final int d(Class<?> cls, int i2) {
        Integer a2;
        kotlin.e0.a.e(cls);
        try {
            p.a aVar = kotlin.p.a;
            a2 = kotlin.p.a(Integer.valueOf(c(cls, 0, 1, null)));
        } catch (Throwable th) {
            p.a aVar2 = kotlin.p.a;
            a2 = kotlin.p.a(kotlin.q.a(th));
        }
        Integer valueOf = Integer.valueOf(i2);
        if (kotlin.p.c(a2)) {
            a2 = valueOf;
        }
        return ((Number) a2).intValue();
    }

    public static final <E extends Throwable> E e(E e2) {
        Object a2;
        List W;
        ReentrantReadWriteLock.ReadLock readLock;
        int readHoldCount;
        ReentrantReadWriteLock.WriteLock writeLock;
        if (e2 instanceof kotlinx.coroutines.r) {
            try {
                p.a aVar = kotlin.p.a;
                a2 = kotlin.p.a(((kotlinx.coroutines.r) e2).a());
            } catch (Throwable th) {
                p.a aVar2 = kotlin.p.a;
                a2 = kotlin.p.a(kotlin.q.a(th));
            }
            return (E) (kotlin.p.c(a2) ? null : a2);
        }
        ReentrantReadWriteLock reentrantReadWriteLock = f17494b;
        ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
        readLock2.lock();
        try {
            kotlin.e0.c.l<Throwable, Throwable> lVar = f17495c.get(e2.getClass());
            if (lVar != null) {
                return (E) lVar.invoke(e2);
            }
            int i2 = 0;
            if (a != d(e2.getClass(), 0)) {
                readLock = reentrantReadWriteLock.readLock();
                readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                for (int i3 = 0; i3 < readHoldCount; i3++) {
                    readLock.unlock();
                }
                writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    f17495c.put(e2.getClass(), C0421f.a);
                    x xVar = x.a;
                    return null;
                } finally {
                    while (i2 < readHoldCount) {
                        readLock.lock();
                        i2++;
                    }
                    writeLock.unlock();
                }
            }
            W = kotlin.a0.n.W(e2.getClass().getConstructors(), new e());
            Iterator it = W.iterator();
            kotlin.e0.c.l<Throwable, Throwable> lVar2 = null;
            while (it.hasNext() && (lVar2 = a((Constructor) it.next())) == null) {
            }
            ReentrantReadWriteLock reentrantReadWriteLock2 = f17494b;
            readLock = reentrantReadWriteLock2.readLock();
            readHoldCount = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
            for (int i4 = 0; i4 < readHoldCount; i4++) {
                readLock.unlock();
            }
            writeLock = reentrantReadWriteLock2.writeLock();
            writeLock.lock();
            try {
                f17495c.put(e2.getClass(), lVar2 != null ? lVar2 : g.a);
                x xVar2 = x.a;
                while (i2 < readHoldCount) {
                    readLock.lock();
                    i2++;
                }
                writeLock.unlock();
                if (lVar2 != null) {
                    return (E) lVar2.invoke(e2);
                }
                return null;
            } finally {
                while (i2 < readHoldCount) {
                    readLock.lock();
                    i2++;
                }
                writeLock.unlock();
            }
        } finally {
            readLock2.unlock();
        }
    }
}