package com.coinbase.network.adapter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.x;
import okhttp3.ResponseBody;
import retrofit2.h;
import retrofit2.t;

/* compiled from: UnitConverterFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ;\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0002\b\u0003\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/coinbase/network/adapter/UnitConverterFactory;", "Lretrofit2/h$a;", "Ljava/lang/reflect/Type;", "type", "", "", "annotations", "Lretrofit2/t;", "retrofit", "Lretrofit2/h;", "Lokhttp3/ResponseBody;", "responseBodyConverter", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/t;)Lretrofit2/h;", "<init>", "()V", "UnitConverter", "kotlin-rxjava"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class UnitConverterFactory extends h.a {
    public static final UnitConverterFactory INSTANCE = new UnitConverterFactory();

    /* compiled from: UnitConverterFactory.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/network/adapter/UnitConverterFactory$UnitConverter;", "Lretrofit2/h;", "Lokhttp3/ResponseBody;", "Lkotlin/x;", "value", "convert", "(Lokhttp3/ResponseBody;)V", "<init>", "()V", "kotlin-rxjava"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    private static final class UnitConverter implements h<ResponseBody, x> {
        public static final UnitConverter INSTANCE = new UnitConverter();

        private UnitConverter() {
        }

        @Override // retrofit2.h
        public /* bridge */ /* synthetic */ x convert(ResponseBody responseBody) {
            convert2(responseBody);
            return x.a;
        }

        /* renamed from: convert  reason: avoid collision after fix types in other method */
        public void convert2(ResponseBody value) {
            m.h(value, "value");
            value.close();
        }
    }

    private UnitConverterFactory() {
    }

    @Override // retrofit2.h.a
    public h<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, t retrofit) {
        m.h(type, "type");
        m.h(annotations, "annotations");
        m.h(retrofit, "retrofit");
        if (m.c(type, x.class)) {
            return UnitConverter.INSTANCE;
        }
        return null;
    }
}