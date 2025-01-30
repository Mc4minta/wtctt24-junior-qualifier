package com.squareup.wire;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.wire.g;
import com.squareup.wire.g.a;
import java.lang.reflect.Array;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AndroidMessage.kt */
/* loaded from: classes2.dex */
public abstract class a<M extends g<M, B>, B extends g.a<M, B>> extends g<M, B> implements Parcelable {
    public static final C0233a Companion = new C0233a(null);

    /* compiled from: AndroidMessage.kt */
    /* renamed from: com.squareup.wire.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0233a {
        private C0233a() {
        }

        public final <E> Parcelable.Creator<E> a(ProtoAdapter<E> adapter) {
            kotlin.jvm.internal.m.h(adapter, "adapter");
            return new b(adapter);
        }

        public /* synthetic */ C0233a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidMessage.kt */
    /* loaded from: classes2.dex */
    public static final class b<M> implements Parcelable.Creator<M> {
        private final ProtoAdapter<M> a;

        public b(ProtoAdapter<M> adapter) {
            kotlin.jvm.internal.m.h(adapter, "adapter");
            this.a = adapter;
        }

        @Override // android.os.Parcelable.Creator
        public M createFromParcel(Parcel input) {
            kotlin.jvm.internal.m.h(input, "input");
            ProtoAdapter<M> protoAdapter = this.a;
            byte[] createByteArray = input.createByteArray();
            kotlin.jvm.internal.m.d(createByteArray, "input.createByteArray()");
            return protoAdapter.decode(createByteArray);
        }

        @Override // android.os.Parcelable.Creator
        public M[] newArray(int i2) {
            kotlin.j0.d<?> type = this.a.getType();
            Object newInstance = Array.newInstance(type != null ? kotlin.e0.a.c(type) : null, i2);
            if (newInstance != null) {
                return (M[]) ((Object[]) newInstance);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<M>");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ProtoAdapter<M> adapter, j.i unknownFields) {
        super(adapter, unknownFields);
        kotlin.jvm.internal.m.h(adapter, "adapter");
        kotlin.jvm.internal.m.h(unknownFields, "unknownFields");
    }

    public static final <E> Parcelable.Creator<E> newCreator(ProtoAdapter<E> protoAdapter) {
        return Companion.a(protoAdapter);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i2) {
        kotlin.jvm.internal.m.h(dest, "dest");
        dest.writeByteArray(encode());
    }
}