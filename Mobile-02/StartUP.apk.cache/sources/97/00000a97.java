package com.coinbase;

/* loaded from: classes.dex */
public enum PageOrder {
    ASC("asc"),
    DESC("desc");
    
    private String value;

    PageOrder(String str) {
        this.value = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getValue() {
        return this.value;
    }
}