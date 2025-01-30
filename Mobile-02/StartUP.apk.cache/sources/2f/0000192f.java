package com.coinbase.wallet.core.util;

import h.c.h;
import h.c.k0.b;
import h.c.n;
import h.c.s;
import h.c.y;
import h.c.z;
import k.a.c;
import k.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ReplayingShare.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u000e*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0003:\u0006\u000e\u000f\u0010\u0011\u0012\u0013B\u0015\b\u0002\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b\u0006\u0010\tR\u0018\u0010\n\u001a\u0004\u0018\u00018\u00008\u0002@\u0003X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/coinbase/wallet/core/util/ReplayingShare;", "T", "Lh/c/y;", "Lh/c/n;", "Lh/c/s;", "upstream", "apply", "(Lh/c/s;)Lh/c/s;", "Lh/c/h;", "(Lh/c/h;)Lh/c/h;", "defaultValue", "Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;)V", "Companion", "LastSeen", "LastSeenFlowable", "LastSeenObservable", "LastSeenObserver", "LastSeenSubscriber", "core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ReplayingShare<T> implements y<T, T>, n<T, T> {
    public static final Companion Companion = new Companion(null);
    private final T defaultValue;

    /* compiled from: ReplayingShare.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/core/util/ReplayingShare$Companion;", "", "T", "defaultValue", "Lcom/coinbase/wallet/core/util/ReplayingShare;", "create", "(Ljava/lang/Object;)Lcom/coinbase/wallet/core/util/ReplayingShare;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ReplayingShare create$default(Companion companion, Object obj, int i2, Object obj2) {
            if ((i2 & 1) != 0) {
                obj = null;
            }
            return companion.create(obj);
        }

        public final <T> ReplayingShare<T> create(T t) {
            return new ReplayingShare<>(t, null);
        }
    }

    /* compiled from: ReplayingShare.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0011\u0012\b\b\u0001\u0010\u0018\u001a\u00028\u0001¢\u0006\u0004\b\u0019\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0010\u0010\u0013R$\u0010\u0004\u001a\u0004\u0018\u00018\u00018\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0007R\u0016\u0010\u0018\u001a\u00028\u00018\u0002@\u0003X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/core/util/ReplayingShare$LastSeen;", "T", "Lh/c/z;", "Lk/a/c;", "value", "Lkotlin/x;", "onNext", "(Ljava/lang/Object;)V", "", "e", "onError", "(Ljava/lang/Throwable;)V", "onComplete", "()V", "Lk/a/d;", "ignored", "onSubscribe", "(Lk/a/d;)V", "Lh/c/k0/b;", "(Lh/c/k0/b;)V", "Ljava/lang/Object;", "getValue$core_release", "()Ljava/lang/Object;", "setValue$core_release", "defaultValue", "<init>", "core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class LastSeen<T> implements z<T>, c<T> {
        private final T defaultValue;
        private volatile T value;

        public LastSeen(T t) {
            this.defaultValue = t;
            this.value = t;
        }

        public final T getValue$core_release() {
            return this.value;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.value = this.defaultValue;
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable e2) {
            m.g(e2, "e");
            this.value = this.defaultValue;
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.value = t;
        }

        @Override // h.c.z
        public void onSubscribe(b ignored) {
            m.g(ignored, "ignored");
        }

        @Override // k.a.c
        public void onSubscribe(d ignored) {
            m.g(ignored, "ignored");
        }

        public final void setValue$core_release(T t) {
            this.value = t;
        }
    }

    /* compiled from: ReplayingShare.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B#\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/coinbase/wallet/core/util/ReplayingShare$LastSeenFlowable;", "T", "Lh/c/h;", "Lk/a/c;", "subscriber", "Lkotlin/x;", "subscribeActual", "(Lk/a/c;)V", "Lcom/coinbase/wallet/core/util/ReplayingShare$LastSeen;", "lastSeen", "Lcom/coinbase/wallet/core/util/ReplayingShare$LastSeen;", "upstream", "Lh/c/h;", "<init>", "(Lh/c/h;Lcom/coinbase/wallet/core/util/ReplayingShare$LastSeen;)V", "core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class LastSeenFlowable<T> extends h<T> {
        private final LastSeen<T> lastSeen;
        private final h<T> upstream;

        public LastSeenFlowable(h<T> upstream, LastSeen<T> lastSeen) {
            m.g(upstream, "upstream");
            m.g(lastSeen, "lastSeen");
            this.upstream = upstream;
            this.lastSeen = lastSeen;
        }

        @Override // h.c.h
        protected void subscribeActual(c<? super T> subscriber) {
            m.g(subscriber, "subscriber");
            this.upstream.subscribe(new LastSeenSubscriber(subscriber, this.lastSeen));
        }
    }

    /* compiled from: ReplayingShare.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B#\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/coinbase/wallet/core/util/ReplayingShare$LastSeenObservable;", "T", "Lh/c/s;", "Lh/c/z;", "observer", "Lkotlin/x;", "subscribeActual", "(Lh/c/z;)V", "upstream", "Lh/c/s;", "Lcom/coinbase/wallet/core/util/ReplayingShare$LastSeen;", "lastSeen", "Lcom/coinbase/wallet/core/util/ReplayingShare$LastSeen;", "<init>", "(Lh/c/s;Lcom/coinbase/wallet/core/util/ReplayingShare$LastSeen;)V", "core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class LastSeenObservable<T> extends s<T> {
        private final LastSeen<T> lastSeen;
        private final s<T> upstream;

        public LastSeenObservable(s<T> upstream, LastSeen<T> lastSeen) {
            m.g(upstream, "upstream");
            m.g(lastSeen, "lastSeen");
            this.upstream = upstream;
            this.lastSeen = lastSeen;
        }

        @Override // h.c.s
        protected void subscribeActual(z<? super T> observer) {
            m.g(observer, "observer");
            this.upstream.subscribe(new LastSeenObserver(observer, this.lastSeen));
        }
    }

    /* compiled from: ReplayingShare.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B%\u0012\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0002\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/core/util/ReplayingShare$LastSeenObserver;", "T", "Lh/c/z;", "Lh/c/k0/b;", "d", "Lkotlin/x;", "onSubscribe", "(Lh/c/k0/b;)V", "value", "onNext", "(Ljava/lang/Object;)V", "onComplete", "()V", "", "e", "onError", "(Ljava/lang/Throwable;)V", "Lcom/coinbase/wallet/core/util/ReplayingShare$LastSeen;", "lastSeen", "Lcom/coinbase/wallet/core/util/ReplayingShare$LastSeen;", "downstream", "Lh/c/z;", "<init>", "(Lh/c/z;Lcom/coinbase/wallet/core/util/ReplayingShare$LastSeen;)V", "core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class LastSeenObserver<T> implements z<T> {
        private final z<? super T> downstream;
        private final LastSeen<T> lastSeen;

        public LastSeenObserver(z<? super T> downstream, LastSeen<T> lastSeen) {
            m.g(downstream, "downstream");
            m.g(lastSeen, "lastSeen");
            this.downstream = downstream;
            this.lastSeen = lastSeen;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable e2) {
            m.g(e2, "e");
            this.downstream.onError(e2);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // h.c.z
        public void onSubscribe(b d2) {
            m.g(d2, "d");
            this.downstream.onSubscribe(d2);
            T value$core_release = this.lastSeen.getValue$core_release();
            if (value$core_release == null || d2.isDisposed()) {
                return;
            }
            this.downstream.onNext(value$core_release);
        }
    }

    /* compiled from: ReplayingShare.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\u00020\u0003B%\u0012\u000e\u0010\u0019\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0002\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b¢\u0006\u0004\b \u0010!J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\rJ\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u001f¨\u0006\""}, d2 = {"Lcom/coinbase/wallet/core/util/ReplayingShare$LastSeenSubscriber;", "T", "Lk/a/c;", "Lk/a/d;", "subscription", "Lkotlin/x;", "onSubscribe", "(Lk/a/d;)V", "", "amountInput", "request", "(J)V", "cancel", "()V", "value", "onNext", "(Ljava/lang/Object;)V", "onComplete", "", "t", "onError", "(Ljava/lang/Throwable;)V", "", "cancelled", "Z", "downstream", "Lk/a/c;", "Lcom/coinbase/wallet/core/util/ReplayingShare$LastSeen;", "lastSeen", "Lcom/coinbase/wallet/core/util/ReplayingShare$LastSeen;", "first", "Lk/a/d;", "<init>", "(Lk/a/c;Lcom/coinbase/wallet/core/util/ReplayingShare$LastSeen;)V", "core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class LastSeenSubscriber<T> implements c<T>, d {
        private volatile boolean cancelled;
        private final c<? super T> downstream;
        private boolean first;
        private final LastSeen<T> lastSeen;
        private d subscription;

        public LastSeenSubscriber(c<? super T> downstream, LastSeen<T> lastSeen) {
            m.g(downstream, "downstream");
            m.g(lastSeen, "lastSeen");
            this.downstream = downstream;
            this.lastSeen = lastSeen;
            this.first = true;
        }

        @Override // k.a.d
        public void cancel() {
            d dVar = this.subscription;
            m.e(dVar);
            this.cancelled = true;
            dVar.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable t) {
            m.g(t, "t");
            this.downstream.onError(t);
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // k.a.c
        public void onSubscribe(d subscription) {
            m.g(subscription, "subscription");
            this.subscription = subscription;
            this.downstream.onSubscribe(this);
        }

        @Override // k.a.d
        public void request(long j2) {
            if (j2 == 0) {
                return;
            }
            if (this.first) {
                this.first = false;
                T value$core_release = this.lastSeen.getValue$core_release();
                if (value$core_release != null && !this.cancelled) {
                    this.downstream.onNext(value$core_release);
                    if (j2 != Long.MAX_VALUE) {
                        j2--;
                        if (j2 == 0) {
                            return;
                        }
                    }
                }
            }
            d dVar = this.subscription;
            m.e(dVar);
            dVar.request(j2);
        }
    }

    private ReplayingShare(T t) {
        this.defaultValue = t;
    }

    public /* synthetic */ ReplayingShare(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj);
    }

    @Override // h.c.y
    public s<T> apply(s<T> upstream) {
        m.g(upstream, "upstream");
        LastSeen lastSeen = new LastSeen(this.defaultValue);
        s<T> share = upstream.doOnEach(lastSeen).share();
        m.f(share, "upstream.doOnEach(lastSeen).share()");
        s<T> hide = new LastSeenObservable(share, lastSeen).hide();
        m.f(hide, "LastSeenObservable(upstream.doOnEach(lastSeen).share(), lastSeen).hide()");
        return hide;
    }

    @Override // h.c.n
    public h<T> apply(h<T> upstream) {
        m.g(upstream, "upstream");
        LastSeen lastSeen = new LastSeen(this.defaultValue);
        h<T> share = upstream.doOnEach(lastSeen).share();
        m.f(share, "upstream.doOnEach(lastSeen).share()");
        h<T> hide = new LastSeenFlowable(share, lastSeen).hide();
        m.f(hide, "LastSeenFlowable(upstream.doOnEach(lastSeen).share(), lastSeen).hide()");
        return hide;
    }
}