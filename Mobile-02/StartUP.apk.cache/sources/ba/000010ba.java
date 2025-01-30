package com.coinbase.resources.base;

import com.coinbase.ApiConstants;
import com.coinbase.resources.accounts.Account;
import com.coinbase.resources.transactions.entities.EmailResource;
import com.coinbase.resources.users.User;
import com.google.gson.JsonParseException;
import com.google.gson.j;
import com.google.gson.l;
import com.google.gson.v.a;
import java.lang.reflect.Type;
import java.util.Map;

/* loaded from: classes.dex */
public final class DynamicResourceDeserializer extends ResourceTypeDeserializer<DynamicResource> {
    public DynamicResourceDeserializer() {
        this.typeMapping.put("account", Account.class);
        this.typeMapping.put(ApiConstants.USER, User.class);
        this.typeMapping.put("email", EmailResource.class);
    }

    public void addTypeMapping(String str, Class<? extends DynamicResource> cls) {
        this.typeMapping.put(str, cls);
    }

    @Override // com.coinbase.resources.base.ResourceTypeDeserializer, com.google.gson.k
    public DynamicResource deserialize(l lVar, Type type, j jVar) throws JsonParseException {
        Class cls = (Class) this.typeMapping.get(lVar.i().t("resource").l());
        if (cls == null) {
            UnknownResource unknownResource = (UnknownResource) jVar.a(lVar, UnknownResource.class);
            unknownResource.fields = (Map) jVar.a(lVar, new a<Map<String, Object>>() { // from class: com.coinbase.resources.base.DynamicResourceDeserializer.1
            }.getType());
            return unknownResource;
        }
        return (DynamicResource) jVar.a(lVar, cls);
    }
}