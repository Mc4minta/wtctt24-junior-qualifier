package com.rd;

import com.rd.b.b.b;

/* compiled from: IndicatorManager.java */
/* loaded from: classes2.dex */
public class a implements b.a {
    private com.rd.c.a a;

    /* renamed from: b  reason: collision with root package name */
    private com.rd.b.a f10556b;

    /* renamed from: c  reason: collision with root package name */
    private InterfaceC0223a f10557c;

    /* compiled from: IndicatorManager.java */
    /* renamed from: com.rd.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    interface InterfaceC0223a {
        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(InterfaceC0223a interfaceC0223a) {
        this.f10557c = interfaceC0223a;
        com.rd.c.a aVar = new com.rd.c.a();
        this.a = aVar;
        this.f10556b = new com.rd.b.a(aVar.b(), this);
    }

    @Override // com.rd.b.b.b.a
    public void a(com.rd.b.c.a aVar) {
        this.a.g(aVar);
        InterfaceC0223a interfaceC0223a = this.f10557c;
        if (interfaceC0223a != null) {
            interfaceC0223a.b();
        }
    }

    public com.rd.b.a b() {
        return this.f10556b;
    }

    public com.rd.c.a c() {
        return this.a;
    }

    public com.rd.c.c.a d() {
        return this.a.b();
    }
}