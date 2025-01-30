package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: KotlinJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u001b\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJd\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b2\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022,\u0010\b\u001a(\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00060\u0006 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00070\u00052\u000e\u0010\n\u001a\n \u0003*\u0004\u0018\u00010\t0\tH\u0097\u0001¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/squareup/moshi/KotlinJsonAdapterFactory;", "Lcom/squareup/moshi/JsonAdapter$Factory;", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "p0", "", "", "", "p1", "Lcom/squareup/moshi/Moshi;", "p2", "Lcom/squareup/moshi/JsonAdapter;", "create", "(Ljava/lang/reflect/Type;Ljava/util/Set;Lcom/squareup/moshi/Moshi;)Lcom/squareup/moshi/JsonAdapter;", "<init>", "()V", "reflect"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class KotlinJsonAdapterFactory implements JsonAdapter.Factory {
    private final /* synthetic */ com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory $$delegate_0 = new com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory();

    @Override // com.squareup.moshi.JsonAdapter.Factory
    public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
        return this.$$delegate_0.create(type, set, moshi);
    }
}