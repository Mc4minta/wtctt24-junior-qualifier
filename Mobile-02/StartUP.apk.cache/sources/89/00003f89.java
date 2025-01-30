package com.squareup.wire;

import com.squareup.wire.g;
import com.squareup.wire.g.a;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MessageSerializedForm.kt */
/* loaded from: classes2.dex */
public final class h<M extends g<M, B>, B extends g.a<M, B>> implements Serializable {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f10863b;

    /* renamed from: c  reason: collision with root package name */
    private final Class<M> f10864c;

    /* compiled from: MessageSerializedForm.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public h(byte[] bytes, Class<M> messageClass) {
        kotlin.jvm.internal.m.h(bytes, "bytes");
        kotlin.jvm.internal.m.h(messageClass, "messageClass");
        this.f10863b = bytes;
        this.f10864c = messageClass;
    }
}