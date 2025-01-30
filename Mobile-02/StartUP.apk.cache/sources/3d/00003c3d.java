package com.google.gson.u.n;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.q;
import com.google.gson.s;
import com.google.gson.t;

/* compiled from: JsonAdapterAnnotationTypeAdapterFactory.java */
/* loaded from: classes2.dex */
public final class d implements t {
    private final com.google.gson.u.c a;

    public d(com.google.gson.u.c cVar) {
        this.a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s<?> a(com.google.gson.u.c cVar, com.google.gson.f fVar, com.google.gson.v.a<?> aVar, JsonAdapter jsonAdapter) {
        s<?> lVar;
        Object a = cVar.a(com.google.gson.v.a.get((Class) jsonAdapter.value())).a();
        if (a instanceof s) {
            lVar = (s) a;
        } else if (a instanceof t) {
            lVar = ((t) a).create(fVar, aVar);
        } else {
            boolean z = a instanceof q;
            if (!z && !(a instanceof com.google.gson.k)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            lVar = new l<>(z ? (q) a : null, a instanceof com.google.gson.k ? (com.google.gson.k) a : null, fVar, aVar, null);
        }
        return (lVar == null || !jsonAdapter.nullSafe()) ? lVar : lVar.nullSafe();
    }

    @Override // com.google.gson.t
    public <T> s<T> create(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
        JsonAdapter jsonAdapter = (JsonAdapter) aVar.getRawType().getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return (s<T>) a(this.a, fVar, aVar, jsonAdapter);
    }
}