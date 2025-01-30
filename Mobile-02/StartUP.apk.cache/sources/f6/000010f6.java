package com.coinbase.resources.users;

import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class AuthInfo {
    private String method;
    private Map<String, String> oauthMeta;
    private List<String> scopes;

    public String getMethod() {
        return this.method;
    }

    public Map<String, String> getOauthMeta() {
        return this.oauthMeta;
    }

    public List<String> getScopes() {
        return this.scopes;
    }
}