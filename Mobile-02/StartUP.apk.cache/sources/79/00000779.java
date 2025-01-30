package com.bugsnag.android;

import com.bugsnag.android.o0;
import java.io.IOException;

/* loaded from: classes.dex */
public enum Severity implements o0.a {
    ERROR("error"),
    WARNING("warning"),
    INFO("info");
    
    private final String name;

    Severity(String str) {
        this.name = str;
    }

    static Severity fromChar(char c2) {
        if (c2 != 'e') {
            if (c2 != 'i') {
                if (c2 != 'w') {
                    return null;
                }
                return WARNING;
            }
            return INFO;
        }
        return ERROR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Severity fromString(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 3237038:
                if (str.equals("info")) {
                    c2 = 0;
                    break;
                }
                break;
            case 96784904:
                if (str.equals("error")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1124446108:
                if (str.equals("warning")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return INFO;
            case 1:
                return ERROR;
            case 2:
                return WARNING;
            default:
                return null;
        }
    }

    public String getName() {
        return this.name;
    }

    @Override // com.bugsnag.android.o0.a
    public void toStream(o0 o0Var) throws IOException {
        o0Var.d0(this.name);
    }
}