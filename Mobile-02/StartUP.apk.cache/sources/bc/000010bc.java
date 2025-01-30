package com.coinbase.resources.base;

import com.coinbase.resources.base.BaseResource;
import com.google.gson.JsonParseException;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.l;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class ResourceTypeDeserializer<T extends BaseResource> implements k<T> {
    protected final Map<String, Class<? extends T>> typeMapping = new HashMap();

    @Override // com.google.gson.k
    public T deserialize(l lVar, Type type, j jVar) throws JsonParseException {
        Class<? extends T> cls = this.typeMapping.get(lVar.i().t("resource").l());
        if (cls != null) {
            return (T) jVar.a(lVar, cls);
        }
        return null;
    }
}