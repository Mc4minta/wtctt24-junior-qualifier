package com.coinbase.android.apiv3;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.g;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import retrofit2.h;
import retrofit2.t;

/* compiled from: ApiV3QueryEncoderConverterFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ9\u0010\u000b\u001a\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/coinbase/android/apiv3/ApiV3QueryEncoderConverterFactory;", "Lretrofit2/h$a;", "Ljava/lang/reflect/Type;", "type", "", "", "annotations", "Lretrofit2/t;", "retrofit", "Lretrofit2/h;", "", "stringConverter", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/t;)Lretrofit2/h;", "<init>", "()V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class ApiV3QueryEncoderConverterFactory extends h.a {
    public static final Companion Companion = new Companion(null);

    /* compiled from: ApiV3QueryEncoderConverterFactory.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/coinbase/android/apiv3/ApiV3QueryEncoderConverterFactory$Companion;", "", "Lcom/coinbase/android/apiv3/ApiV3QueryEncoderConverterFactory;", "create", "()Lcom/coinbase/android/apiv3/ApiV3QueryEncoderConverterFactory;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final ApiV3QueryEncoderConverterFactory create() {
            return new ApiV3QueryEncoderConverterFactory();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // retrofit2.h.a
    public h<?, String> stringConverter(Type type, Annotation[] annotations, t retrofit) {
        m.h(type, "type");
        m.h(annotations, "annotations");
        m.h(retrofit, "retrofit");
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (g.class.isAssignableFrom(cls)) {
                return new WireQueryEncoderConverter(ProtoAdapter.Companion.b(cls));
            }
            return null;
        }
        return null;
    }
}