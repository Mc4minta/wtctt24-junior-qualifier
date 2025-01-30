package com.google.common.collect;

import com.google.common.collect.v.h;
import com.google.common.collect.v.m;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MapMakerInternalMap.java */
/* loaded from: classes2.dex */
public class v<K, V, E extends h<K, V, E>, S extends m<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final z<Object, Object, d> a = new a();

    /* renamed from: b  reason: collision with root package name */
    final transient int f8509b;

    /* renamed from: c  reason: collision with root package name */
    final transient int f8510c;

    /* renamed from: d  reason: collision with root package name */
    final transient m<K, V, E, S>[] f8511d;

    /* renamed from: e  reason: collision with root package name */
    final int f8512e;

    /* renamed from: f  reason: collision with root package name */
    final com.google.common.base.d<Object> f8513f;

    /* renamed from: g  reason: collision with root package name */
    final transient i<K, V, E, S> f8514g;

    /* renamed from: h  reason: collision with root package name */
    transient Set<K> f8515h;

    /* renamed from: j  reason: collision with root package name */
    transient Collection<V> f8516j;

    /* renamed from: k  reason: collision with root package name */
    transient Set<Map.Entry<K, V>> f8517k;

    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    static class a implements z<Object, Object, d> {
        a() {
        }

        @Override // com.google.common.collect.v.z
        /* renamed from: c */
        public z<Object, Object, d> b(ReferenceQueue<Object> referenceQueue, d dVar) {
            return this;
        }

        @Override // com.google.common.collect.v.z
        public void clear() {
        }

        @Override // com.google.common.collect.v.z
        /* renamed from: d */
        public d a() {
            return null;
        }

        @Override // com.google.common.collect.v.z
        public Object get() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    public static final class a0<K, V, E extends h<K, V, E>> extends WeakReference<V> implements z<K, V, E> {
        final E a;

        a0(ReferenceQueue<V> referenceQueue, V v, E e2) {
            super(v, referenceQueue);
            this.a = e2;
        }

        @Override // com.google.common.collect.v.z
        public E a() {
            return this.a;
        }

        @Override // com.google.common.collect.v.z
        public z<K, V, E> b(ReferenceQueue<V> referenceQueue, E e2) {
            return new a0(referenceQueue, get(), e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    public static abstract class b<K, V, E extends h<K, V, E>> implements h<K, V, E> {
        final K a;

        /* renamed from: b  reason: collision with root package name */
        final int f8518b;

        /* renamed from: c  reason: collision with root package name */
        final E f8519c;

        b(K k2, int i2, E e2) {
            this.a = k2;
            this.f8518b = i2;
            this.f8519c = e2;
        }

        @Override // com.google.common.collect.v.h
        public E a() {
            return this.f8519c;
        }

        @Override // com.google.common.collect.v.h
        public int c() {
            return this.f8518b;
        }

        @Override // com.google.common.collect.v.h
        public K getKey() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    public final class b0 extends com.google.common.collect.b<K, V> {
        final K a;

        /* renamed from: b  reason: collision with root package name */
        V f8520b;

        b0(K k2, V v) {
            this.a = k2;
            this.f8520b = v;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.a.equals(entry.getKey()) && this.f8520b.equals(entry.getValue());
            }
            return false;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V getValue() {
            return this.f8520b;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public int hashCode() {
            return this.a.hashCode() ^ this.f8520b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) v.this.put(this.a, v);
            this.f8520b = v;
            return v2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    public static abstract class c<K, V, E extends h<K, V, E>> extends WeakReference<K> implements h<K, V, E> {
        final int a;

        /* renamed from: b  reason: collision with root package name */
        final E f8522b;

        c(ReferenceQueue<K> referenceQueue, K k2, int i2, E e2) {
            super(k2, referenceQueue);
            this.a = i2;
            this.f8522b = e2;
        }

        @Override // com.google.common.collect.v.h
        public E a() {
            return this.f8522b;
        }

        @Override // com.google.common.collect.v.h
        public int c() {
            return this.a;
        }

        @Override // com.google.common.collect.v.h
        public K getKey() {
            return get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    public static final class d implements h<Object, Object, d> {
        private d() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.v.h
        public int c() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.v.h
        /* renamed from: d */
        public d a() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.v.h
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.v.h
        public Object getValue() {
            throw new AssertionError();
        }
    }

    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    final class e extends v<K, V, E, S>.g<Map.Entry<K, V>> {
        e() {
            super();
        }

        @Override // java.util.Iterator
        /* renamed from: g */
        public Map.Entry<K, V> next() {
            return d();
        }
    }

    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    final class f extends l<Map.Entry<K, V>> {
        f() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            v.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = v.this.get(key)) != null && v.this.n().d(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return v.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new e();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && v.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return v.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    public abstract class g<T> implements Iterator<T> {
        int a;

        /* renamed from: b  reason: collision with root package name */
        int f8524b = -1;

        /* renamed from: c  reason: collision with root package name */
        m<K, V, E, S> f8525c;

        /* renamed from: d  reason: collision with root package name */
        AtomicReferenceArray<E> f8526d;

        /* renamed from: e  reason: collision with root package name */
        E f8527e;

        /* renamed from: f  reason: collision with root package name */
        v<K, V, E, S>.b0 f8528f;

        /* renamed from: g  reason: collision with root package name */
        v<K, V, E, S>.b0 f8529g;

        g() {
            this.a = v.this.f8511d.length - 1;
            b();
        }

        final void b() {
            this.f8528f = null;
            if (e() || f()) {
                return;
            }
            while (true) {
                int i2 = this.a;
                if (i2 < 0) {
                    return;
                }
                m<K, V, E, S>[] mVarArr = v.this.f8511d;
                this.a = i2 - 1;
                m<K, V, E, S> mVar = mVarArr[i2];
                this.f8525c = mVar;
                if (mVar.f8532b != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.f8525c.f8535e;
                    this.f8526d = atomicReferenceArray;
                    this.f8524b = atomicReferenceArray.length() - 1;
                    if (f()) {
                        return;
                    }
                }
            }
        }

        boolean c(E e2) {
            boolean z;
            try {
                Object key = e2.getKey();
                Object d2 = v.this.d(e2);
                if (d2 != null) {
                    this.f8528f = new b0(key, d2);
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } finally {
                this.f8525c.r();
            }
        }

        v<K, V, E, S>.b0 d() {
            v<K, V, E, S>.b0 b0Var = this.f8528f;
            if (b0Var != null) {
                this.f8529g = b0Var;
                b();
                return this.f8529g;
            }
            throw new NoSuchElementException();
        }

        boolean e() {
            E e2 = this.f8527e;
            if (e2 == null) {
                return false;
            }
            while (true) {
                this.f8527e = (E) e2.a();
                E e3 = this.f8527e;
                if (e3 == null) {
                    return false;
                }
                if (c(e3)) {
                    return true;
                }
                e2 = this.f8527e;
            }
        }

        boolean f() {
            while (true) {
                int i2 = this.f8524b;
                if (i2 < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.f8526d;
                this.f8524b = i2 - 1;
                E e2 = atomicReferenceArray.get(i2);
                this.f8527e = e2;
                if (e2 != null && (c(e2) || e())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f8528f != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.collect.d.c(this.f8529g != null);
            v.this.remove(this.f8529g.getKey());
            this.f8529g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    public interface h<K, V, E extends h<K, V, E>> {
        E a();

        int c();

        K getKey();

        V getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    public interface i<K, V, E extends h<K, V, E>, S extends m<K, V, E, S>> {
        E a(S s, E e2, E e3);

        n b();

        void c(S s, E e2, V v);

        S d(v<K, V, E, S> vVar, int i2, int i3);

        E e(S s, K k2, int i2, E e2);
    }

    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    final class j extends v<K, V, E, S>.g<K> {
        j() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return d().getKey();
        }
    }

    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    final class k extends l<K> {
        k() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            v.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return v.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return v.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new j();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return v.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return v.this.size();
        }
    }

    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    private static abstract class l<E> extends AbstractSet<E> {
        private l() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return v.l(this).toArray();
        }

        /* synthetic */ l(a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) v.l(this).toArray(eArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    public static abstract class m<K, V, E extends h<K, V, E>, S extends m<K, V, E, S>> extends ReentrantLock {
        final v<K, V, E, S> a;

        /* renamed from: b  reason: collision with root package name */
        volatile int f8532b;

        /* renamed from: c  reason: collision with root package name */
        int f8533c;

        /* renamed from: d  reason: collision with root package name */
        int f8534d;

        /* renamed from: e  reason: collision with root package name */
        volatile AtomicReferenceArray<E> f8535e;

        /* renamed from: f  reason: collision with root package name */
        final int f8536f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicInteger f8537g = new AtomicInteger();

        m(v<K, V, E, S> vVar, int i2, int i3) {
            this.a = vVar;
            this.f8536f = i3;
            m(q(i2));
        }

        static <K, V, E extends h<K, V, E>> boolean n(E e2) {
            return e2.getValue() == null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean A(K k2, int i2, V v, V v2) {
            lock();
            try {
                s();
                AtomicReferenceArray<E> atomicReferenceArray = this.f8535e;
                int length = (atomicReferenceArray.length() - 1) & i2;
                E e2 = atomicReferenceArray.get(length);
                for (h hVar = e2; hVar != null; hVar = hVar.a()) {
                    Object key = hVar.getKey();
                    if (hVar.c() == i2 && key != null && this.a.f8513f.d(k2, key)) {
                        Object value = hVar.getValue();
                        if (value == null) {
                            if (n(hVar)) {
                                this.f8533c++;
                                atomicReferenceArray.set(length, y(e2, hVar));
                                this.f8532b--;
                            }
                            return false;
                        } else if (this.a.n().d(v, value)) {
                            this.f8533c++;
                            E(hVar, v2);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        void B() {
            C();
        }

        void C() {
            if (tryLock()) {
                try {
                    p();
                    this.f8537g.set(0);
                } finally {
                    unlock();
                }
            }
        }

        abstract S D();

        void E(E e2, V v) {
            this.a.f8514g.c(D(), e2, v);
        }

        void F() {
            if (tryLock()) {
                try {
                    p();
                } finally {
                    unlock();
                }
            }
        }

        void a() {
            if (this.f8532b != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.f8535e;
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    o();
                    this.f8537g.set(0);
                    this.f8533c++;
                    this.f8532b = 0;
                } finally {
                    unlock();
                }
            }
        }

        <T> void b(ReferenceQueue<T> referenceQueue) {
            do {
            } while (referenceQueue.poll() != null);
        }

        boolean c(Object obj, int i2) {
            try {
                boolean z = false;
                if (this.f8532b != 0) {
                    E k2 = k(obj, i2);
                    if (k2 != null) {
                        if (k2.getValue() != null) {
                            z = true;
                        }
                    }
                    return z;
                }
                return false;
            } finally {
                r();
            }
        }

        E d(E e2, E e3) {
            return this.a.f8514g.a(D(), e2, e3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void e(ReferenceQueue<K> referenceQueue) {
            int i2 = 0;
            do {
                Reference<? extends K> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.a.g((h) poll);
                i2++;
            } while (i2 != 16);
        }

        void f(ReferenceQueue<V> referenceQueue) {
            int i2 = 0;
            do {
                Reference<? extends V> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.a.i((z) poll);
                i2++;
            } while (i2 != 16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void g() {
            AtomicReferenceArray<E> atomicReferenceArray = this.f8535e;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i2 = this.f8532b;
            AtomicReferenceArray<E> atomicReferenceArray2 = (AtomicReferenceArray<E>) q(length << 1);
            this.f8534d = (atomicReferenceArray2.length() * 3) / 4;
            int length2 = atomicReferenceArray2.length() - 1;
            for (int i3 = 0; i3 < length; i3++) {
                E e2 = atomicReferenceArray.get(i3);
                if (e2 != null) {
                    h a = e2.a();
                    int c2 = e2.c() & length2;
                    if (a == null) {
                        atomicReferenceArray2.set(c2, e2);
                    } else {
                        h hVar = e2;
                        while (a != null) {
                            int c3 = a.c() & length2;
                            if (c3 != c2) {
                                hVar = a;
                                c2 = c3;
                            }
                            a = a.a();
                        }
                        atomicReferenceArray2.set(c2, hVar);
                        while (e2 != hVar) {
                            int c4 = e2.c() & length2;
                            h d2 = d(e2, (h) atomicReferenceArray2.get(c4));
                            if (d2 != null) {
                                atomicReferenceArray2.set(c4, d2);
                            } else {
                                i2--;
                            }
                            e2 = e2.a();
                        }
                    }
                }
            }
            this.f8535e = atomicReferenceArray2;
            this.f8532b = i2;
        }

        V h(Object obj, int i2) {
            try {
                E k2 = k(obj, i2);
                if (k2 == null) {
                    return null;
                }
                V v = (V) k2.getValue();
                if (v == null) {
                    F();
                }
                return v;
            } finally {
                r();
            }
        }

        E i(Object obj, int i2) {
            if (this.f8532b != 0) {
                for (E j2 = j(i2); j2 != null; j2 = (E) j2.a()) {
                    if (j2.c() == i2) {
                        Object key = j2.getKey();
                        if (key == null) {
                            F();
                        } else if (this.a.f8513f.d(obj, key)) {
                            return j2;
                        }
                    }
                }
                return null;
            }
            return null;
        }

        E j(int i2) {
            AtomicReferenceArray<E> atomicReferenceArray = this.f8535e;
            return atomicReferenceArray.get(i2 & (atomicReferenceArray.length() - 1));
        }

        E k(Object obj, int i2) {
            return i(obj, i2);
        }

        V l(E e2) {
            if (e2.getKey() == null) {
                F();
                return null;
            }
            V v = (V) e2.getValue();
            if (v == null) {
                F();
                return null;
            }
            return v;
        }

        void m(AtomicReferenceArray<E> atomicReferenceArray) {
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.f8534d = length;
            if (length == this.f8536f) {
                this.f8534d = length + 1;
            }
            this.f8535e = atomicReferenceArray;
        }

        void o() {
        }

        void p() {
        }

        AtomicReferenceArray<E> q(int i2) {
            return new AtomicReferenceArray<>(i2);
        }

        void r() {
            if ((this.f8537g.incrementAndGet() & 63) == 0) {
                B();
            }
        }

        void s() {
            C();
        }

        /* JADX WARN: Multi-variable type inference failed */
        V t(K k2, int i2, V v, boolean z) {
            lock();
            try {
                s();
                int i3 = this.f8532b + 1;
                if (i3 > this.f8534d) {
                    g();
                    i3 = this.f8532b + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.f8535e;
                int length = (atomicReferenceArray.length() - 1) & i2;
                E e2 = atomicReferenceArray.get(length);
                for (h hVar = e2; hVar != null; hVar = hVar.a()) {
                    Object key = hVar.getKey();
                    if (hVar.c() == i2 && key != null && this.a.f8513f.d(k2, key)) {
                        V v2 = (V) hVar.getValue();
                        if (v2 == null) {
                            this.f8533c++;
                            E(hVar, v);
                            this.f8532b = this.f8532b;
                            return null;
                        } else if (z) {
                            return v2;
                        } else {
                            this.f8533c++;
                            E(hVar, v);
                            return v2;
                        }
                    }
                }
                this.f8533c++;
                E e3 = this.a.f8514g.e(D(), k2, i2, e2);
                E(e3, v);
                atomicReferenceArray.set(length, e3);
                this.f8532b = i3;
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        boolean u(E e2, int i2) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.f8535e;
                int length = i2 & (atomicReferenceArray.length() - 1);
                E e3 = atomicReferenceArray.get(length);
                for (h hVar = e3; hVar != null; hVar = hVar.a()) {
                    if (hVar == e2) {
                        this.f8533c++;
                        atomicReferenceArray.set(length, y(e3, hVar));
                        this.f8532b--;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        boolean v(K k2, int i2, z<K, V, E> zVar) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.f8535e;
                int length = (atomicReferenceArray.length() - 1) & i2;
                E e2 = atomicReferenceArray.get(length);
                for (h hVar = e2; hVar != null; hVar = hVar.a()) {
                    Object key = hVar.getKey();
                    if (hVar.c() == i2 && key != null && this.a.f8513f.d(k2, key)) {
                        if (((y) hVar).b() == zVar) {
                            this.f8533c++;
                            atomicReferenceArray.set(length, y(e2, hVar));
                            this.f8532b--;
                            return true;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        V w(Object obj, int i2) {
            lock();
            try {
                s();
                AtomicReferenceArray<E> atomicReferenceArray = this.f8535e;
                int length = (atomicReferenceArray.length() - 1) & i2;
                E e2 = atomicReferenceArray.get(length);
                for (h hVar = e2; hVar != null; hVar = hVar.a()) {
                    Object key = hVar.getKey();
                    if (hVar.c() == i2 && key != null && this.a.f8513f.d(obj, key)) {
                        V v = (V) hVar.getValue();
                        if (v == null && !n(hVar)) {
                            return null;
                        }
                        this.f8533c++;
                        atomicReferenceArray.set(length, y(e2, hVar));
                        this.f8532b--;
                        return v;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
            if (r8.a.n().d(r11, r4.getValue()) == false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
            if (n(r4) == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
            r8.f8533c++;
            r0.set(r1, y(r3, r4));
            r8.f8532b--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:
            return false;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean x(java.lang.Object r9, int r10, java.lang.Object r11) {
            /*
                r8 = this;
                r8.lock()
                r8.s()     // Catch: java.lang.Throwable -> L69
                java.util.concurrent.atomic.AtomicReferenceArray<E extends com.google.common.collect.v$h<K, V, E>> r0 = r8.f8535e     // Catch: java.lang.Throwable -> L69
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L69
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r10
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L69
                com.google.common.collect.v$h r3 = (com.google.common.collect.v.h) r3     // Catch: java.lang.Throwable -> L69
                r4 = r3
            L16:
                r5 = 0
                if (r4 == 0) goto L65
                java.lang.Object r6 = r4.getKey()     // Catch: java.lang.Throwable -> L69
                int r7 = r4.c()     // Catch: java.lang.Throwable -> L69
                if (r7 != r10) goto L60
                if (r6 == 0) goto L60
                com.google.common.collect.v<K, V, E extends com.google.common.collect.v$h<K, V, E>, S extends com.google.common.collect.v$m<K, V, E, S>> r7 = r8.a     // Catch: java.lang.Throwable -> L69
                com.google.common.base.d<java.lang.Object> r7 = r7.f8513f     // Catch: java.lang.Throwable -> L69
                boolean r6 = r7.d(r9, r6)     // Catch: java.lang.Throwable -> L69
                if (r6 == 0) goto L60
                java.lang.Object r9 = r4.getValue()     // Catch: java.lang.Throwable -> L69
                com.google.common.collect.v<K, V, E extends com.google.common.collect.v$h<K, V, E>, S extends com.google.common.collect.v$m<K, V, E, S>> r10 = r8.a     // Catch: java.lang.Throwable -> L69
                com.google.common.base.d r10 = r10.n()     // Catch: java.lang.Throwable -> L69
                boolean r9 = r10.d(r11, r9)     // Catch: java.lang.Throwable -> L69
                if (r9 == 0) goto L41
                r5 = r2
                goto L47
            L41:
                boolean r9 = n(r4)     // Catch: java.lang.Throwable -> L69
                if (r9 == 0) goto L5c
            L47:
                int r9 = r8.f8533c     // Catch: java.lang.Throwable -> L69
                int r9 = r9 + r2
                r8.f8533c = r9     // Catch: java.lang.Throwable -> L69
                com.google.common.collect.v$h r9 = r8.y(r3, r4)     // Catch: java.lang.Throwable -> L69
                int r10 = r8.f8532b     // Catch: java.lang.Throwable -> L69
                int r10 = r10 - r2
                r0.set(r1, r9)     // Catch: java.lang.Throwable -> L69
                r8.f8532b = r10     // Catch: java.lang.Throwable -> L69
                r8.unlock()
                return r5
            L5c:
                r8.unlock()
                return r5
            L60:
                com.google.common.collect.v$h r4 = r4.a()     // Catch: java.lang.Throwable -> L69
                goto L16
            L65:
                r8.unlock()
                return r5
            L69:
                r9 = move-exception
                r8.unlock()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.v.m.x(java.lang.Object, int, java.lang.Object):boolean");
        }

        E y(E e2, E e3) {
            int i2 = this.f8532b;
            E e4 = (E) e3.a();
            while (e2 != e3) {
                E d2 = d(e2, e4);
                if (d2 != null) {
                    e4 = d2;
                } else {
                    i2--;
                }
                e2 = (E) e2.a();
            }
            this.f8532b = i2;
            return e4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        V z(K k2, int i2, V v) {
            lock();
            try {
                s();
                AtomicReferenceArray<E> atomicReferenceArray = this.f8535e;
                int length = (atomicReferenceArray.length() - 1) & i2;
                E e2 = atomicReferenceArray.get(length);
                for (h hVar = e2; hVar != null; hVar = hVar.a()) {
                    Object key = hVar.getKey();
                    if (hVar.c() == i2 && key != null && this.a.f8513f.d(k2, key)) {
                        V v2 = (V) hVar.getValue();
                        if (v2 == null) {
                            if (n(hVar)) {
                                this.f8533c++;
                                atomicReferenceArray.set(length, y(e2, hVar));
                                this.f8532b--;
                            }
                            return null;
                        }
                        this.f8533c++;
                        E(hVar, v);
                        return v2;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    public static abstract class n {
        public static final n a;

        /* renamed from: b  reason: collision with root package name */
        public static final n f8538b;

        /* renamed from: c  reason: collision with root package name */
        private static final /* synthetic */ n[] f8539c;

        /* compiled from: MapMakerInternalMap.java */
        /* loaded from: classes2.dex */
        enum a extends n {
            a(String str, int i2) {
                super(str, i2, null);
            }

            @Override // com.google.common.collect.v.n
            com.google.common.base.d<Object> h() {
                return com.google.common.base.d.c();
            }
        }

        /* compiled from: MapMakerInternalMap.java */
        /* loaded from: classes2.dex */
        enum b extends n {
            b(String str, int i2) {
                super(str, i2, null);
            }

            @Override // com.google.common.collect.v.n
            com.google.common.base.d<Object> h() {
                return com.google.common.base.d.f();
            }
        }

        static {
            a aVar = new a("STRONG", 0);
            a = aVar;
            b bVar = new b("WEAK", 1);
            f8538b = bVar;
            f8539c = new n[]{aVar, bVar};
        }

        private n(String str, int i2) {
        }

        public static n valueOf(String str) {
            return (n) Enum.valueOf(n.class, str);
        }

        public static n[] values() {
            return (n[]) f8539c.clone();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract com.google.common.base.d<Object> h();

        /* synthetic */ n(String str, int i2, a aVar) {
            this(str, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    public static final class o<K, V> extends b<K, V, o<K, V>> implements h {

        /* renamed from: d  reason: collision with root package name */
        private volatile V f8540d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MapMakerInternalMap.java */
        /* loaded from: classes2.dex */
        public static final class a<K, V> implements i<K, V, o<K, V>, p<K, V>> {
            private static final a<?, ?> a = new a<>();

            a() {
            }

            static <K, V> a<K, V> g() {
                return (a<K, V>) a;
            }

            @Override // com.google.common.collect.v.i
            public n b() {
                return n.a;
            }

            @Override // com.google.common.collect.v.i
            /* renamed from: f */
            public o<K, V> a(p<K, V> pVar, o<K, V> oVar, o<K, V> oVar2) {
                return oVar.d(oVar2);
            }

            @Override // com.google.common.collect.v.i
            /* renamed from: h */
            public o<K, V> e(p<K, V> pVar, K k2, int i2, o<K, V> oVar) {
                return new o<>(k2, i2, oVar);
            }

            @Override // com.google.common.collect.v.i
            /* renamed from: i */
            public p<K, V> d(v<K, V, o<K, V>, p<K, V>> vVar, int i2, int i3) {
                return new p<>(vVar, i2, i3);
            }

            @Override // com.google.common.collect.v.i
            /* renamed from: j */
            public void c(p<K, V> pVar, o<K, V> oVar, V v) {
                oVar.e(v);
            }
        }

        o(K k2, int i2, o<K, V> oVar) {
            super(k2, i2, oVar);
            this.f8540d = null;
        }

        o<K, V> d(o<K, V> oVar) {
            o<K, V> oVar2 = new o<>(this.a, this.f8518b, oVar);
            oVar2.f8540d = this.f8540d;
            return oVar2;
        }

        void e(V v) {
            this.f8540d = v;
        }

        @Override // com.google.common.collect.v.h
        public V getValue() {
            return this.f8540d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    public static final class p<K, V> extends m<K, V, o<K, V>, p<K, V>> {
        p(v<K, V, o<K, V>, p<K, V>> vVar, int i2, int i3) {
            super(vVar, i2, i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.v.m
        /* renamed from: G */
        public p<K, V> D() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    public static final class q<K, V> extends b<K, V, q<K, V>> implements y<K, V, q<K, V>> {

        /* renamed from: d  reason: collision with root package name */
        private volatile z<K, V, q<K, V>> f8541d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MapMakerInternalMap.java */
        /* loaded from: classes2.dex */
        public static final class a<K, V> implements i<K, V, q<K, V>, r<K, V>> {
            private static final a<?, ?> a = new a<>();

            a() {
            }

            static <K, V> a<K, V> g() {
                return (a<K, V>) a;
            }

            @Override // com.google.common.collect.v.i
            public n b() {
                return n.f8538b;
            }

            @Override // com.google.common.collect.v.i
            /* renamed from: f */
            public q<K, V> a(r<K, V> rVar, q<K, V> qVar, q<K, V> qVar2) {
                if (m.n(qVar)) {
                    return null;
                }
                return qVar.d(((r) rVar).f8542h, qVar2);
            }

            @Override // com.google.common.collect.v.i
            /* renamed from: h */
            public q<K, V> e(r<K, V> rVar, K k2, int i2, q<K, V> qVar) {
                return new q<>(k2, i2, qVar);
            }

            @Override // com.google.common.collect.v.i
            /* renamed from: i */
            public r<K, V> d(v<K, V, q<K, V>, r<K, V>> vVar, int i2, int i3) {
                return new r<>(vVar, i2, i3);
            }

            @Override // com.google.common.collect.v.i
            /* renamed from: j */
            public void c(r<K, V> rVar, q<K, V> qVar, V v) {
                qVar.e(v, ((r) rVar).f8542h);
            }
        }

        q(K k2, int i2, q<K, V> qVar) {
            super(k2, i2, qVar);
            this.f8541d = v.m();
        }

        @Override // com.google.common.collect.v.y
        public z<K, V, q<K, V>> b() {
            return this.f8541d;
        }

        q<K, V> d(ReferenceQueue<V> referenceQueue, q<K, V> qVar) {
            q<K, V> qVar2 = new q<>(this.a, this.f8518b, qVar);
            qVar2.f8541d = this.f8541d.b(referenceQueue, qVar2);
            return qVar2;
        }

        void e(V v, ReferenceQueue<V> referenceQueue) {
            z<K, V, q<K, V>> zVar = this.f8541d;
            this.f8541d = new a0(referenceQueue, v, this);
            zVar.clear();
        }

        @Override // com.google.common.collect.v.h
        public V getValue() {
            return this.f8541d.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    public static final class r<K, V> extends m<K, V, q<K, V>, r<K, V>> {

        /* renamed from: h  reason: collision with root package name */
        private final ReferenceQueue<V> f8542h;

        r(v<K, V, q<K, V>, r<K, V>> vVar, int i2, int i3) {
            super(vVar, i2, i3);
            this.f8542h = new ReferenceQueue<>();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.v.m
        /* renamed from: H */
        public r<K, V> D() {
            return this;
        }

        @Override // com.google.common.collect.v.m
        void o() {
            b((ReferenceQueue<V>) this.f8542h);
        }

        @Override // com.google.common.collect.v.m
        void p() {
            f(this.f8542h);
        }
    }

    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    final class s extends v<K, V, E, S>.g<V> {
        s() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return d().getValue();
        }
    }

    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    final class t extends AbstractCollection<V> {
        t() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            v.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return v.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return v.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new s();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return v.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return v.l(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] eArr) {
            return (E[]) v.l(this).toArray(eArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    public static final class u<K, V> extends c<K, V, u<K, V>> implements h {

        /* renamed from: c  reason: collision with root package name */
        private volatile V f8544c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MapMakerInternalMap.java */
        /* loaded from: classes2.dex */
        public static final class a<K, V> implements i<K, V, u<K, V>, C0160v<K, V>> {
            private static final a<?, ?> a = new a<>();

            a() {
            }

            static <K, V> a<K, V> g() {
                return (a<K, V>) a;
            }

            @Override // com.google.common.collect.v.i
            public n b() {
                return n.a;
            }

            @Override // com.google.common.collect.v.i
            /* renamed from: f */
            public u<K, V> a(C0160v<K, V> c0160v, u<K, V> uVar, u<K, V> uVar2) {
                if (uVar.getKey() == null) {
                    return null;
                }
                return uVar.d(((C0160v) c0160v).f8545h, uVar2);
            }

            @Override // com.google.common.collect.v.i
            /* renamed from: h */
            public u<K, V> e(C0160v<K, V> c0160v, K k2, int i2, u<K, V> uVar) {
                return new u<>(((C0160v) c0160v).f8545h, k2, i2, uVar);
            }

            @Override // com.google.common.collect.v.i
            /* renamed from: i */
            public C0160v<K, V> d(v<K, V, u<K, V>, C0160v<K, V>> vVar, int i2, int i3) {
                return new C0160v<>(vVar, i2, i3);
            }

            @Override // com.google.common.collect.v.i
            /* renamed from: j */
            public void c(C0160v<K, V> c0160v, u<K, V> uVar, V v) {
                uVar.e(v);
            }
        }

        u(ReferenceQueue<K> referenceQueue, K k2, int i2, u<K, V> uVar) {
            super(referenceQueue, k2, i2, uVar);
            this.f8544c = null;
        }

        u<K, V> d(ReferenceQueue<K> referenceQueue, u<K, V> uVar) {
            u<K, V> uVar2 = new u<>(referenceQueue, getKey(), this.a, uVar);
            uVar2.e(this.f8544c);
            return uVar2;
        }

        void e(V v) {
            this.f8544c = v;
        }

        @Override // com.google.common.collect.v.h
        public V getValue() {
            return this.f8544c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* renamed from: com.google.common.collect.v$v  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0160v<K, V> extends m<K, V, u<K, V>, C0160v<K, V>> {

        /* renamed from: h  reason: collision with root package name */
        private final ReferenceQueue<K> f8545h;

        C0160v(v<K, V, u<K, V>, C0160v<K, V>> vVar, int i2, int i3) {
            super(vVar, i2, i3);
            this.f8545h = new ReferenceQueue<>();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.v.m
        /* renamed from: H */
        public C0160v<K, V> D() {
            return this;
        }

        @Override // com.google.common.collect.v.m
        void o() {
            b((ReferenceQueue<K>) this.f8545h);
        }

        @Override // com.google.common.collect.v.m
        void p() {
            e(this.f8545h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    public static final class w<K, V> extends c<K, V, w<K, V>> implements y<K, V, w<K, V>> {

        /* renamed from: c  reason: collision with root package name */
        private volatile z<K, V, w<K, V>> f8546c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MapMakerInternalMap.java */
        /* loaded from: classes2.dex */
        public static final class a<K, V> implements i<K, V, w<K, V>, x<K, V>> {
            private static final a<?, ?> a = new a<>();

            a() {
            }

            static <K, V> a<K, V> g() {
                return (a<K, V>) a;
            }

            @Override // com.google.common.collect.v.i
            public n b() {
                return n.f8538b;
            }

            @Override // com.google.common.collect.v.i
            /* renamed from: f */
            public w<K, V> a(x<K, V> xVar, w<K, V> wVar, w<K, V> wVar2) {
                if (wVar.getKey() == null || m.n(wVar)) {
                    return null;
                }
                return wVar.d(((x) xVar).f8547h, ((x) xVar).f8548j, wVar2);
            }

            @Override // com.google.common.collect.v.i
            /* renamed from: h */
            public w<K, V> e(x<K, V> xVar, K k2, int i2, w<K, V> wVar) {
                return new w<>(((x) xVar).f8547h, k2, i2, wVar);
            }

            @Override // com.google.common.collect.v.i
            /* renamed from: i */
            public x<K, V> d(v<K, V, w<K, V>, x<K, V>> vVar, int i2, int i3) {
                return new x<>(vVar, i2, i3);
            }

            @Override // com.google.common.collect.v.i
            /* renamed from: j */
            public void c(x<K, V> xVar, w<K, V> wVar, V v) {
                wVar.e(v, ((x) xVar).f8548j);
            }
        }

        w(ReferenceQueue<K> referenceQueue, K k2, int i2, w<K, V> wVar) {
            super(referenceQueue, k2, i2, wVar);
            this.f8546c = v.m();
        }

        @Override // com.google.common.collect.v.y
        public z<K, V, w<K, V>> b() {
            return this.f8546c;
        }

        w<K, V> d(ReferenceQueue<K> referenceQueue, ReferenceQueue<V> referenceQueue2, w<K, V> wVar) {
            w<K, V> wVar2 = new w<>(referenceQueue, getKey(), this.a, wVar);
            wVar2.f8546c = this.f8546c.b(referenceQueue2, wVar2);
            return wVar2;
        }

        void e(V v, ReferenceQueue<V> referenceQueue) {
            z<K, V, w<K, V>> zVar = this.f8546c;
            this.f8546c = new a0(referenceQueue, v, this);
            zVar.clear();
        }

        @Override // com.google.common.collect.v.h
        public V getValue() {
            return this.f8546c.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    public static final class x<K, V> extends m<K, V, w<K, V>, x<K, V>> {

        /* renamed from: h  reason: collision with root package name */
        private final ReferenceQueue<K> f8547h;

        /* renamed from: j  reason: collision with root package name */
        private final ReferenceQueue<V> f8548j;

        x(v<K, V, w<K, V>, x<K, V>> vVar, int i2, int i3) {
            super(vVar, i2, i3);
            this.f8547h = new ReferenceQueue<>();
            this.f8548j = new ReferenceQueue<>();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.v.m
        /* renamed from: I */
        public x<K, V> D() {
            return this;
        }

        @Override // com.google.common.collect.v.m
        void o() {
            b((ReferenceQueue<K>) this.f8547h);
        }

        @Override // com.google.common.collect.v.m
        void p() {
            e(this.f8547h);
            f(this.f8548j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    public interface y<K, V, E extends h<K, V, E>> extends h<K, V, E> {
        z<K, V, E> b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes2.dex */
    public interface z<K, V, E extends h<K, V, E>> {
        E a();

        z<K, V, E> b(ReferenceQueue<V> referenceQueue, E e2);

        void clear();

        V get();
    }

    private v(com.google.common.collect.u uVar, i<K, V, E, S> iVar) {
        this.f8512e = Math.min(uVar.a(), 65536);
        this.f8513f = uVar.c();
        this.f8514g = iVar;
        int min = Math.min(uVar.b(), 1073741824);
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        int i5 = 1;
        while (i5 < this.f8512e) {
            i4++;
            i5 <<= 1;
        }
        this.f8510c = 32 - i4;
        this.f8509b = i5 - 1;
        this.f8511d = f(i5);
        int i6 = min / i5;
        while (i3 < (i5 * i6 < min ? i6 + 1 : i6)) {
            i3 <<= 1;
        }
        while (true) {
            m<K, V, E, S>[] mVarArr = this.f8511d;
            if (i2 >= mVarArr.length) {
                return;
            }
            mVarArr[i2] = c(i3, -1);
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> v<K, V, ? extends h<K, V, ?>, ?> b(com.google.common.collect.u uVar) {
        n d2 = uVar.d();
        n nVar = n.a;
        if (d2 == nVar && uVar.e() == nVar) {
            return new v<>(uVar, o.a.g());
        }
        if (uVar.d() == nVar && uVar.e() == n.f8538b) {
            return new v<>(uVar, q.a.g());
        }
        n d3 = uVar.d();
        n nVar2 = n.f8538b;
        if (d3 == nVar2 && uVar.e() == nVar) {
            return new v<>(uVar, u.a.g());
        }
        if (uVar.d() == nVar2 && uVar.e() == nVar2) {
            return new v<>(uVar, w.a.g());
        }
        throw new AssertionError();
    }

    static int j(int i2) {
        int i3 = i2 + ((i2 << 15) ^ (-12931));
        int i4 = i3 ^ (i3 >>> 10);
        int i5 = i4 + (i4 << 3);
        int i6 = i5 ^ (i5 >>> 6);
        int i7 = i6 + (i6 << 2) + (i6 << 14);
        return i7 ^ (i7 >>> 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ArrayList<E> l(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        com.google.common.collect.s.a(arrayList, collection.iterator());
        return arrayList;
    }

    static <K, V, E extends h<K, V, E>> z<K, V, E> m() {
        return (z<K, V, E>) a;
    }

    m<K, V, E, S> c(int i2, int i3) {
        return (S) this.f8514g.d(this, i2, i3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (m<K, V, E, S> mVar : this.f8511d) {
            mVar.a();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int e2 = e(obj);
        return k(e2).c(obj, e2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.google.common.collect.v$m] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.google.common.collect.v$m<K, V, E extends com.google.common.collect.v$h<K, V, E>, S extends com.google.common.collect.v$m<K, V, E, S>>[]] */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        boolean z2 = false;
        if (obj == null) {
            return false;
        }
        m<K, V, E, S>[] mVarArr = this.f8511d;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            long j3 = 0;
            int length = mVarArr.length;
            for (int i3 = z2; i3 < length; i3++) {
                ?? r11 = mVarArr[i3];
                int i4 = r11.f8532b;
                AtomicReferenceArray<E> atomicReferenceArray = r11.f8535e;
                for (int i5 = z2; i5 < atomicReferenceArray.length(); i5++) {
                    for (E e2 = atomicReferenceArray.get(i5); e2 != null; e2 = e2.a()) {
                        Object l2 = r11.l(e2);
                        if (l2 != null && n().d(obj, l2)) {
                            return true;
                        }
                    }
                }
                j3 += r11.f8533c;
                z2 = false;
            }
            if (j3 == j2) {
                return false;
            }
            i2++;
            j2 = j3;
            z2 = false;
        }
        return z2;
    }

    V d(E e2) {
        V v;
        if (e2.getKey() == null || (v = (V) e2.getValue()) == null) {
            return null;
        }
        return v;
    }

    int e(Object obj) {
        return j(this.f8513f.e(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f8517k;
        if (set != null) {
            return set;
        }
        f fVar = new f();
        this.f8517k = fVar;
        return fVar;
    }

    final m<K, V, E, S>[] f(int i2) {
        return new m[i2];
    }

    void g(E e2) {
        int c2 = e2.c();
        k(c2).u(e2, c2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int e2 = e(obj);
        return k(e2).h(obj, e2);
    }

    void i(z<K, V, E> zVar) {
        E a2 = zVar.a();
        int c2 = a2.c();
        k(c2).v((K) a2.getKey(), c2, zVar);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        m<K, V, E, S>[] mVarArr = this.f8511d;
        long j2 = 0;
        for (int i2 = 0; i2 < mVarArr.length; i2++) {
            if (mVarArr[i2].f8532b != 0) {
                return false;
            }
            j2 += mVarArr[i2].f8533c;
        }
        if (j2 != 0) {
            for (int i3 = 0; i3 < mVarArr.length; i3++) {
                if (mVarArr[i3].f8532b != 0) {
                    return false;
                }
                j2 -= mVarArr[i3].f8533c;
            }
            return j2 == 0;
        }
        return true;
    }

    m<K, V, E, S> k(int i2) {
        return this.f8511d[(i2 >>> this.f8510c) & this.f8509b];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f8515h;
        if (set != null) {
            return set;
        }
        k kVar = new k();
        this.f8515h = kVar;
        return kVar;
    }

    com.google.common.base.d<Object> n() {
        return this.f8514g.b().h();
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V put(K k2, V v) {
        com.google.common.base.l.i(k2);
        com.google.common.base.l.i(v);
        int e2 = e(k2);
        return k(e2).t(k2, e2, v, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V putIfAbsent(K k2, V v) {
        com.google.common.base.l.i(k2);
        com.google.common.base.l.i(v);
        int e2 = e(k2);
        return k(e2).t(k2, e2, v, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int e2 = e(obj);
        return k(e2).w(obj, e2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean replace(K k2, V v, V v2) {
        com.google.common.base.l.i(k2);
        com.google.common.base.l.i(v2);
        if (v == null) {
            return false;
        }
        int e2 = e(k2);
        return k(e2).A(k2, e2, v, v2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j2 = 0;
        for (m<K, V, E, S> mVar : this.f8511d) {
            j2 += mVar.f8532b;
        }
        return e.g.c.a.a.a(j2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f8516j;
        if (collection != null) {
            return collection;
        }
        t tVar = new t();
        this.f8516j = tVar;
        return tVar;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int e2 = e(obj);
        return k(e2).x(obj, e2, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V replace(K k2, V v) {
        com.google.common.base.l.i(k2);
        com.google.common.base.l.i(v);
        int e2 = e(k2);
        return k(e2).z(k2, e2, v);
    }
}