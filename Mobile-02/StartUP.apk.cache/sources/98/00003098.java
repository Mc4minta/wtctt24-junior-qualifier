package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.util.RequestPayload;

/* loaded from: classes2.dex */
public class JsonParseException extends JsonProcessingException {
    protected RequestPayload _requestPayload;

    @Override // com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (this._requestPayload == null) {
            return message;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(message);
        sb.append("\nRequest payload : ");
        throw null;
    }
}