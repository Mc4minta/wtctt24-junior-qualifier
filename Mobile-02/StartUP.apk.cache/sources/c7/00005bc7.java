package org.apache.commons.logging;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.AccessController;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

/* compiled from: LogFactory.java */
/* loaded from: classes3.dex */
public abstract class h {
    private static PrintStream a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f17586b;

    /* renamed from: c  reason: collision with root package name */
    private static final ClassLoader f17587c;

    /* renamed from: d  reason: collision with root package name */
    protected static Hashtable f17588d;

    /* renamed from: e  reason: collision with root package name */
    protected static volatile h f17589e;

    /* renamed from: f  reason: collision with root package name */
    static /* synthetic */ Class f17590f;

    static {
        String str;
        Class cls = f17590f;
        if (cls == null) {
            cls = c("org.apache.commons.logging.LogFactory");
            f17590f = cls;
        }
        ClassLoader h2 = h(cls);
        f17587c = h2;
        if (h2 == null) {
            str = "BOOTLOADER";
        } else {
            try {
                str = B(h2);
            } catch (SecurityException unused) {
                str = "UNKNOWN";
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[LogFactory from ");
        stringBuffer.append(str);
        stringBuffer.append("] ");
        f17586b = stringBuffer.toString();
        a = v();
        Class cls2 = f17590f;
        if (cls2 == null) {
            cls2 = c("org.apache.commons.logging.LogFactory");
            f17590f = cls2;
        }
        x(cls2);
        f17588d = e();
        if (w()) {
            y("BOOTSTRAP COMPLETED");
        }
    }

    protected h() {
    }

    protected static h A(String str, ClassLoader classLoader, ClassLoader classLoader2) throws LogConfigurationException {
        Object doPrivileged = AccessController.doPrivileged(new c(str, classLoader));
        if (doPrivileged instanceof LogConfigurationException) {
            LogConfigurationException logConfigurationException = (LogConfigurationException) doPrivileged;
            if (w()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("An error occurred while loading the factory class:");
                stringBuffer.append(logConfigurationException.getMessage());
                y(stringBuffer.toString());
            }
            throw logConfigurationException;
        }
        if (w()) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Created object ");
            stringBuffer2.append(B(doPrivileged));
            stringBuffer2.append(" to manage classloader ");
            stringBuffer2.append(B(classLoader2));
            y(stringBuffer2.toString());
        }
        return (h) doPrivileged;
    }

    public static String B(Object obj) {
        if (obj == null) {
            return "null";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append("@");
        stringBuffer.append(System.identityHashCode(obj));
        return stringBuffer.toString();
    }

    private static String D(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    private static void b(ClassLoader classLoader, h hVar) {
        if (hVar != null) {
            if (classLoader == null) {
                f17589e = hVar;
            } else {
                f17588d.put(classLoader, hVar);
            }
        }
    }

    static /* synthetic */ Class c(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object d(String str, ClassLoader classLoader) {
        Class<?> cls = null;
        try {
            if (classLoader != null) {
                try {
                    try {
                        cls = classLoader.loadClass(str);
                        Class cls2 = f17590f;
                        if (cls2 == null) {
                            cls2 = c("org.apache.commons.logging.LogFactory");
                            f17590f = cls2;
                        }
                        if (cls2.isAssignableFrom(cls)) {
                            if (w()) {
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append("Loaded class ");
                                stringBuffer.append(cls.getName());
                                stringBuffer.append(" from classloader ");
                                stringBuffer.append(B(classLoader));
                                y(stringBuffer.toString());
                            }
                        } else if (w()) {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append("Factory class ");
                            stringBuffer2.append(cls.getName());
                            stringBuffer2.append(" loaded from classloader ");
                            stringBuffer2.append(B(cls.getClassLoader()));
                            stringBuffer2.append(" does not extend '");
                            Class cls3 = f17590f;
                            if (cls3 == null) {
                                cls3 = c("org.apache.commons.logging.LogFactory");
                                f17590f = cls3;
                            }
                            stringBuffer2.append(cls3.getName());
                            stringBuffer2.append("' as loaded by this classloader.");
                            y(stringBuffer2.toString());
                            z("[BAD CL TREE] ", classLoader);
                        }
                        return (h) cls.newInstance();
                    } catch (ClassCastException unused) {
                        if (classLoader == f17587c) {
                            boolean u = u(cls);
                            StringBuffer stringBuffer3 = new StringBuffer();
                            stringBuffer3.append("The application has specified that a custom LogFactory implementation ");
                            stringBuffer3.append("should be used but Class '");
                            stringBuffer3.append(str);
                            stringBuffer3.append("' cannot be converted to '");
                            Class cls4 = f17590f;
                            if (cls4 == null) {
                                cls4 = c("org.apache.commons.logging.LogFactory");
                                f17590f = cls4;
                            }
                            stringBuffer3.append(cls4.getName());
                            stringBuffer3.append("'. ");
                            if (u) {
                                stringBuffer3.append("The conflict is caused by the presence of multiple LogFactory classes ");
                                stringBuffer3.append("in incompatible classloaders. ");
                                stringBuffer3.append("Background can be found in http://commons.apache.org/logging/tech.html. ");
                                stringBuffer3.append("If you have not explicitly specified a custom LogFactory then it is likely ");
                                stringBuffer3.append("that the container has set one without your knowledge. ");
                                stringBuffer3.append("In this case, consider using the commons-logging-adapters.jar file or ");
                                stringBuffer3.append("specifying the standard LogFactory from the command line. ");
                            } else {
                                stringBuffer3.append("Please check the custom implementation. ");
                            }
                            stringBuffer3.append("Help can be found @http://commons.apache.org/logging/troubleshooting.html.");
                            if (w()) {
                                y(stringBuffer3.toString());
                            }
                            throw new ClassCastException(stringBuffer3.toString());
                        }
                    } catch (NoClassDefFoundError e2) {
                        if (classLoader == f17587c) {
                            if (w()) {
                                StringBuffer stringBuffer4 = new StringBuffer();
                                stringBuffer4.append("Class '");
                                stringBuffer4.append(str);
                                stringBuffer4.append("' cannot be loaded");
                                stringBuffer4.append(" via classloader ");
                                stringBuffer4.append(B(classLoader));
                                stringBuffer4.append(" - it depends on some other class that cannot be found.");
                                y(stringBuffer4.toString());
                            }
                            throw e2;
                        }
                    }
                } catch (ClassNotFoundException e3) {
                    if (classLoader == f17587c) {
                        if (w()) {
                            StringBuffer stringBuffer5 = new StringBuffer();
                            stringBuffer5.append("Unable to locate any class called '");
                            stringBuffer5.append(str);
                            stringBuffer5.append("' via classloader ");
                            stringBuffer5.append(B(classLoader));
                            y(stringBuffer5.toString());
                        }
                        throw e3;
                    }
                }
            }
            if (w()) {
                StringBuffer stringBuffer6 = new StringBuffer();
                stringBuffer6.append("Unable to load factory class via classloader ");
                stringBuffer6.append(B(classLoader));
                stringBuffer6.append(" - trying the classloader associated with this LogFactory.");
                y(stringBuffer6.toString());
            }
            return (h) Class.forName(str).newInstance();
        } catch (Exception e4) {
            if (w()) {
                y("Unable to create LogFactory instance.");
            }
            if (cls != null) {
                Class cls5 = f17590f;
                if (cls5 == null) {
                    cls5 = c("org.apache.commons.logging.LogFactory");
                    f17590f = cls5;
                }
                if (!cls5.isAssignableFrom(cls)) {
                    return new LogConfigurationException("The chosen LogFactory implementation does not extend LogFactory. Please check your configuration.", e4);
                }
            }
            return new LogConfigurationException(e4);
        }
    }

    private static final Hashtable e() {
        String str;
        Hashtable hashtable = null;
        try {
            str = s("org.apache.commons.logging.LogFactory.HashtableImpl", null);
        } catch (SecurityException unused) {
            str = null;
        }
        if (str == null) {
            str = "org.apache.commons.logging.impl.WeakHashtable";
        }
        try {
            hashtable = (Hashtable) Class.forName(str).newInstance();
        } catch (Throwable th) {
            t(th);
            if (!"org.apache.commons.logging.impl.WeakHashtable".equals(str)) {
                if (w()) {
                    y("[ERROR] LogFactory: Load of custom hashtable failed");
                } else {
                    System.err.println("[ERROR] LogFactory: Load of custom hashtable failed");
                }
            }
        }
        return hashtable == null ? new Hashtable() : hashtable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ClassLoader f() throws LogConfigurationException {
        try {
            return Thread.currentThread().getContextClassLoader();
        } catch (SecurityException unused) {
            return null;
        }
    }

    private static h g(ClassLoader classLoader) {
        if (classLoader == null) {
            return f17589e;
        }
        return (h) f17588d.get(classLoader);
    }

    protected static ClassLoader h(Class cls) {
        try {
            return cls.getClassLoader();
        } catch (SecurityException e2) {
            if (w()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Unable to get classloader for class '");
                stringBuffer.append(cls);
                stringBuffer.append("' due to security restrictions - ");
                stringBuffer.append(e2.getMessage());
                y(stringBuffer.toString());
            }
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.util.Properties i(java.lang.ClassLoader r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.h.i(java.lang.ClassLoader, java.lang.String):java.util.Properties");
    }

    private static ClassLoader j() throws LogConfigurationException {
        return (ClassLoader) AccessController.doPrivileged(new b());
    }

    public static h k() throws LogConfigurationException {
        BufferedReader bufferedReader;
        String property;
        ClassLoader j2 = j();
        if (j2 == null && w()) {
            y("Context classloader is null.");
        }
        h g2 = g(j2);
        if (g2 != null) {
            return g2;
        }
        if (w()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[LOOKUP] LogFactory implementation requested for the first time for context classloader ");
            stringBuffer.append(B(j2));
            y(stringBuffer.toString());
            z("[LOOKUP] ", j2);
        }
        Properties i2 = i(j2, "commons-logging.properties");
        ClassLoader classLoader = (i2 == null || (property = i2.getProperty("use_tccl")) == null || Boolean.valueOf(property).booleanValue()) ? j2 : f17587c;
        if (w()) {
            y("[LOOKUP] Looking for system property [org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...");
        }
        try {
            String s = s("org.apache.commons.logging.LogFactory", null);
            if (s != null) {
                if (w()) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("[LOOKUP] Creating an instance of LogFactory class '");
                    stringBuffer2.append(s);
                    stringBuffer2.append("' as specified by system property ");
                    stringBuffer2.append("org.apache.commons.logging.LogFactory");
                    y(stringBuffer2.toString());
                }
                g2 = A(s, classLoader, j2);
            } else if (w()) {
                y("[LOOKUP] No system property [org.apache.commons.logging.LogFactory] defined.");
            }
        } catch (SecurityException e2) {
            if (w()) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("[LOOKUP] A security exception occurred while trying to create an instance of the custom factory class: [");
                stringBuffer3.append(D(e2.getMessage()));
                stringBuffer3.append("]. Trying alternative implementations...");
                y(stringBuffer3.toString());
            }
        } catch (RuntimeException e3) {
            if (w()) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("[LOOKUP] An exception occurred while trying to create an instance of the custom factory class: [");
                stringBuffer4.append(D(e3.getMessage()));
                stringBuffer4.append("] as specified by a system property.");
                y(stringBuffer4.toString());
            }
            throw e3;
        }
        if (g2 == null) {
            if (w()) {
                y("[LOOKUP] Looking for a resource file of name [META-INF/services/org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...");
            }
            try {
                InputStream q = q(j2, "META-INF/services/org.apache.commons.logging.LogFactory");
                if (q != null) {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(q, "UTF-8"));
                    } catch (UnsupportedEncodingException unused) {
                        bufferedReader = new BufferedReader(new InputStreamReader(q));
                    }
                    String readLine = bufferedReader.readLine();
                    bufferedReader.close();
                    if (readLine != null && !"".equals(readLine)) {
                        if (w()) {
                            StringBuffer stringBuffer5 = new StringBuffer();
                            stringBuffer5.append("[LOOKUP]  Creating an instance of LogFactory class ");
                            stringBuffer5.append(readLine);
                            stringBuffer5.append(" as specified by file '");
                            stringBuffer5.append("META-INF/services/org.apache.commons.logging.LogFactory");
                            stringBuffer5.append("' which was present in the path of the context classloader.");
                            y(stringBuffer5.toString());
                        }
                        g2 = A(readLine, classLoader, j2);
                    }
                } else if (w()) {
                    y("[LOOKUP] No resource file with name 'META-INF/services/org.apache.commons.logging.LogFactory' found.");
                }
            } catch (Exception e4) {
                if (w()) {
                    StringBuffer stringBuffer6 = new StringBuffer();
                    stringBuffer6.append("[LOOKUP] A security exception occurred while trying to create an instance of the custom factory class: [");
                    stringBuffer6.append(D(e4.getMessage()));
                    stringBuffer6.append("]. Trying alternative implementations...");
                    y(stringBuffer6.toString());
                }
            }
        }
        if (g2 == null) {
            if (i2 != null) {
                if (w()) {
                    y("[LOOKUP] Looking in properties file for entry with key 'org.apache.commons.logging.LogFactory' to define the LogFactory subclass to use...");
                }
                String property2 = i2.getProperty("org.apache.commons.logging.LogFactory");
                if (property2 != null) {
                    if (w()) {
                        StringBuffer stringBuffer7 = new StringBuffer();
                        stringBuffer7.append("[LOOKUP] Properties file specifies LogFactory subclass '");
                        stringBuffer7.append(property2);
                        stringBuffer7.append("'");
                        y(stringBuffer7.toString());
                    }
                    g2 = A(property2, classLoader, j2);
                } else if (w()) {
                    y("[LOOKUP] Properties file has no entry specifying LogFactory subclass.");
                }
            } else if (w()) {
                y("[LOOKUP] No properties file available to determine LogFactory subclass from..");
            }
        }
        if (g2 == null) {
            if (w()) {
                y("[LOOKUP] Loading the default LogFactory implementation 'org.apache.commons.logging.impl.LogFactoryImpl' via the same classloader that loaded this LogFactory class (ie not looking in the context classloader).");
            }
            g2 = A("org.apache.commons.logging.impl.LogFactoryImpl", f17587c, j2);
        }
        if (g2 != null) {
            b(j2, g2);
            if (i2 != null) {
                Enumeration<?> propertyNames = i2.propertyNames();
                while (propertyNames.hasMoreElements()) {
                    String str = (String) propertyNames.nextElement();
                    g2.C(str, i2.getProperty(str));
                }
            }
        }
        return g2;
    }

    public static a n(Class cls) throws LogConfigurationException {
        return k().l(cls);
    }

    public static a o(String str) throws LogConfigurationException {
        return k().m(str);
    }

    private static Properties p(URL url) {
        return (Properties) AccessController.doPrivileged(new f(url));
    }

    private static InputStream q(ClassLoader classLoader, String str) {
        return (InputStream) AccessController.doPrivileged(new d(classLoader, str));
    }

    private static Enumeration r(ClassLoader classLoader, String str) {
        return (Enumeration) AccessController.doPrivileged(new e(classLoader, str));
    }

    private static String s(String str, String str2) throws SecurityException {
        return (String) AccessController.doPrivileged(new g(str, str2));
    }

    protected static void t(Throwable th) {
        if (!(th instanceof ThreadDeath)) {
            if (th instanceof VirtualMachineError) {
                throw ((VirtualMachineError) th);
            }
            return;
        }
        throw ((ThreadDeath) th);
    }

    private static boolean u(Class cls) {
        boolean z = false;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    y("[CUSTOM LOG FACTORY] was loaded by the boot classloader");
                } else {
                    z("[CUSTOM LOG FACTORY] ", classLoader);
                    z = Class.forName("org.apache.commons.logging.h", false, classLoader).isAssignableFrom(cls);
                    if (z) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("[CUSTOM LOG FACTORY] ");
                        stringBuffer.append(cls.getName());
                        stringBuffer.append(" implements LogFactory but was loaded by an incompatible classloader.");
                        y(stringBuffer.toString());
                    } else {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("[CUSTOM LOG FACTORY] ");
                        stringBuffer2.append(cls.getName());
                        stringBuffer2.append(" does not implement LogFactory.");
                        y(stringBuffer2.toString());
                    }
                }
            } catch (ClassNotFoundException unused) {
                y("[CUSTOM LOG FACTORY] LogFactory class cannot be loaded by classloader which loaded the custom LogFactory implementation. Is the custom factory in the right classloader?");
            } catch (LinkageError e2) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("[CUSTOM LOG FACTORY] LinkageError thrown whilst trying to determine whether the compatibility was caused by a classloader conflict: ");
                stringBuffer3.append(e2.getMessage());
                y(stringBuffer3.toString());
            } catch (SecurityException e3) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("[CUSTOM LOG FACTORY] SecurityException thrown whilst trying to determine whether the compatibility was caused by a classloader conflict: ");
                stringBuffer4.append(e3.getMessage());
                y(stringBuffer4.toString());
            }
        }
        return z;
    }

    private static PrintStream v() {
        try {
            String s = s("org.apache.commons.logging.diagnostics.dest", null);
            if (s == null) {
                return null;
            }
            if (s.equals("STDOUT")) {
                return System.out;
            }
            if (s.equals("STDERR")) {
                return System.err;
            }
            return new PrintStream(new FileOutputStream(s, true));
        } catch (IOException | SecurityException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean w() {
        return a != null;
    }

    private static void x(Class cls) {
        if (w()) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[ENV] Extension directories (java.ext.dir): ");
                stringBuffer.append(System.getProperty("java.ext.dir"));
                y(stringBuffer.toString());
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("[ENV] Application classpath (java.class.path): ");
                stringBuffer2.append(System.getProperty("java.class.path"));
                y(stringBuffer2.toString());
            } catch (SecurityException unused) {
                y("[ENV] Security setting prevent interrogation of system classpaths.");
            }
            String name = cls.getName();
            try {
                ClassLoader h2 = h(cls);
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("[ENV] Class ");
                stringBuffer3.append(name);
                stringBuffer3.append(" was loaded via classloader ");
                stringBuffer3.append(B(h2));
                y(stringBuffer3.toString());
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("[ENV] Ancestry of classloader which loaded ");
                stringBuffer4.append(name);
                stringBuffer4.append(" is ");
                z(stringBuffer4.toString(), h2);
            } catch (SecurityException unused2) {
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append("[ENV] Security forbids determining the classloader for ");
                stringBuffer5.append(name);
                y(stringBuffer5.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(String str) {
        PrintStream printStream = a;
        if (printStream != null) {
            printStream.print(f17586b);
            a.println(str);
            a.flush();
        }
    }

    private static void z(String str, ClassLoader classLoader) {
        if (w()) {
            if (classLoader != null) {
                String obj = classLoader.toString();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                stringBuffer.append(B(classLoader));
                stringBuffer.append(" == '");
                stringBuffer.append(obj);
                stringBuffer.append("'");
                y(stringBuffer.toString());
            }
            try {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                if (classLoader != null) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(str);
                    stringBuffer2.append("ClassLoader tree:");
                    StringBuffer stringBuffer3 = new StringBuffer(stringBuffer2.toString());
                    do {
                        stringBuffer3.append(B(classLoader));
                        if (classLoader == systemClassLoader) {
                            stringBuffer3.append(" (SYSTEM) ");
                        }
                        try {
                            classLoader = classLoader.getParent();
                            stringBuffer3.append(" --> ");
                        } catch (SecurityException unused) {
                            stringBuffer3.append(" --> SECRET");
                        }
                    } while (classLoader != null);
                    stringBuffer3.append("BOOT");
                    y(stringBuffer3.toString());
                }
            } catch (SecurityException unused2) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(str);
                stringBuffer4.append("Security forbids determining the system classloader.");
                y(stringBuffer4.toString());
            }
        }
    }

    public abstract void C(String str, Object obj);

    public abstract a l(Class cls) throws LogConfigurationException;

    public abstract a m(String str) throws LogConfigurationException;
}