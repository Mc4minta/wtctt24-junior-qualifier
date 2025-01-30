package com.fasterxml.jackson.core;

import java.io.IOException;

/* loaded from: classes2.dex */
public class JsonProcessingException extends IOException {
    protected JsonLocation _location;

    public JsonLocation getLocation() {
        return this._location;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            message = "N/A";
        }
        JsonLocation location = getLocation();
        String messageSuffix = getMessageSuffix();
        if (location == null && messageSuffix == null) {
            return message;
        }
        StringBuilder sb = new StringBuilder(100);
        sb.append(message);
        if (messageSuffix != null) {
            sb.append(messageSuffix);
        }
        if (location == null) {
            return sb.toString();
        }
        sb.append('\n');
        sb.append(" at ");
        throw null;
    }

    protected String getMessageSuffix() {
        return null;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }
}