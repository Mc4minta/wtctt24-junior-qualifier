package com.google.api.services.drive;

import e.g.b.a.b.f.e.b;
import e.g.b.a.b.f.e.c;
import java.io.IOException;

/* loaded from: classes2.dex */
public class DriveRequestInitializer extends c {
    public DriveRequestInitializer() {
    }

    protected void initializeDriveRequest(DriveRequest<?> driveRequest) throws IOException {
    }

    @Override // e.g.b.a.b.f.e.c
    public final void initializeJsonRequest(b<?> bVar) throws IOException {
        super.initializeJsonRequest(bVar);
        initializeDriveRequest((DriveRequest) bVar);
    }

    public DriveRequestInitializer(String str) {
        super(str);
    }

    public DriveRequestInitializer(String str, String str2) {
        super(str, str2);
    }
}