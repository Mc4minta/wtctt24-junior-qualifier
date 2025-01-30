package com.bugsnag.android;

import com.bugsnag.android.o0;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class Breadcrumb implements o0.a {
    private static final String DEFAULT_NAME = "manual";
    private static final int MAX_MESSAGE_LENGTH = 140;
    private static final String MESSAGE_METAKEY = "message";
    private static final String METADATA_KEY = "metaData";
    private static final String NAME_KEY = "name";
    private static final String TIMESTAMP_KEY = "timestamp";
    private static final String TYPE_KEY = "type";
    private final Map<String, String> metadata;
    private final String name;
    private final String timestamp;
    private final BreadcrumbType type;

    Breadcrumb(String str) {
        this(DEFAULT_NAME, BreadcrumbType.MANUAL, Collections.singletonMap("message", str.substring(0, Math.min(str.length(), 140))));
    }

    public Map<String, String> getMetadata() {
        return this.metadata;
    }

    public String getName() {
        return this.name;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public BreadcrumbType getType() {
        return this.type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int payloadSize() throws IOException {
        StringWriter stringWriter = new StringWriter();
        toStream(new o0(stringWriter));
        return stringWriter.toString().length();
    }

    @Override // com.bugsnag.android.o0.a
    public void toStream(o0 o0Var) throws IOException {
        o0Var.d();
        o0Var.j(TIMESTAMP_KEY).d0(this.timestamp);
        o0Var.j("name").d0(this.name);
        o0Var.j("type").d0(this.type.toString());
        o0Var.j(METADATA_KEY);
        o0Var.d();
        ArrayList<String> arrayList = new ArrayList(this.metadata.keySet());
        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        for (String str : arrayList) {
            o0Var.j(str).d0(this.metadata.get(str));
        }
        o0Var.g();
        o0Var.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Breadcrumb(String str, BreadcrumbType breadcrumbType, Map<String, String> map) {
        this(str, breadcrumbType, new Date(), map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Breadcrumb(String str, BreadcrumbType breadcrumbType, Date date, Map<String, String> map) {
        this.timestamp = x.b(date);
        this.type = breadcrumbType;
        this.name = str;
        this.metadata = new HashMap(map);
    }
}