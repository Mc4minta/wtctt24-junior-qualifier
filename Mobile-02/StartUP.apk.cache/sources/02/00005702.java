package kotlin.reflect.jvm.internal.impl.name;

import com.coinbase.ApiConstants;
import kotlin.l0.y;

/* loaded from: classes3.dex */
public final class ClassId {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean local;
    private final FqName packageFqName;
    private final FqName relativeClassName;

    private static /* synthetic */ void $$$reportNull$$$0(int i2) {
        String str = (i2 == 5 || i2 == 6 || i2 == 7 || i2 == 9 || i2 == 13 || i2 == 14) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 5 || i2 == 6 || i2 == 7 || i2 == 9 || i2 == 13 || i2 == 14) ? 2 : 3];
        switch (i2) {
            case 1:
            case 3:
                objArr[0] = "packageFqName";
                break;
            case 2:
                objArr[0] = "relativeClassName";
                break;
            case 4:
                objArr[0] = "topLevelName";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                break;
            case 8:
                objArr[0] = ApiConstants.NAME;
                break;
            case 10:
                objArr[0] = "segment";
                break;
            case 11:
            case 12:
                objArr[0] = "string";
                break;
            default:
                objArr[0] = "topLevelFqName";
                break;
        }
        if (i2 == 5) {
            objArr[1] = "getPackageFqName";
        } else if (i2 == 6) {
            objArr[1] = "getRelativeClassName";
        } else if (i2 == 7) {
            objArr[1] = "getShortClassName";
        } else if (i2 == 9) {
            objArr[1] = "asSingleFqName";
        } else if (i2 == 13 || i2 == 14) {
            objArr[1] = "asString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
        }
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
                objArr[2] = "<init>";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                break;
            case 8:
                objArr[2] = "createNestedClassId";
                break;
            case 10:
                objArr[2] = "startsWith";
                break;
            case 11:
            case 12:
                objArr[2] = "fromString";
                break;
            default:
                objArr[2] = "topLevel";
                break;
        }
        String format = String.format(str, objArr);
        if (i2 != 5 && i2 != 6 && i2 != 7 && i2 != 9 && i2 != 13 && i2 != 14) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public ClassId(FqName fqName, FqName fqName2, boolean z) {
        if (fqName == null) {
            $$$reportNull$$$0(1);
        }
        if (fqName2 == null) {
            $$$reportNull$$$0(2);
        }
        this.packageFqName = fqName;
        this.relativeClassName = fqName2;
        this.local = z;
    }

    public static ClassId fromString(String str) {
        if (str == null) {
            $$$reportNull$$$0(11);
        }
        return fromString(str, false);
    }

    public static ClassId topLevel(FqName fqName) {
        if (fqName == null) {
            $$$reportNull$$$0(0);
        }
        return new ClassId(fqName.parent(), fqName.shortName());
    }

    public FqName asSingleFqName() {
        if (this.packageFqName.isRoot()) {
            FqName fqName = this.relativeClassName;
            if (fqName == null) {
                $$$reportNull$$$0(9);
            }
            return fqName;
        }
        return new FqName(this.packageFqName.asString() + "." + this.relativeClassName.asString());
    }

    public String asString() {
        if (this.packageFqName.isRoot()) {
            String asString = this.relativeClassName.asString();
            if (asString == null) {
                $$$reportNull$$$0(13);
            }
            return asString;
        }
        String str = this.packageFqName.asString().replace('.', '/') + "/" + this.relativeClassName.asString();
        if (str == null) {
            $$$reportNull$$$0(14);
        }
        return str;
    }

    public ClassId createNestedClassId(Name name) {
        if (name == null) {
            $$$reportNull$$$0(8);
        }
        return new ClassId(getPackageFqName(), this.relativeClassName.child(name), this.local);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ClassId.class != obj.getClass()) {
            return false;
        }
        ClassId classId = (ClassId) obj;
        return this.packageFqName.equals(classId.packageFqName) && this.relativeClassName.equals(classId.relativeClassName) && this.local == classId.local;
    }

    public ClassId getOuterClassId() {
        FqName parent = this.relativeClassName.parent();
        if (parent.isRoot()) {
            return null;
        }
        return new ClassId(getPackageFqName(), parent, this.local);
    }

    public FqName getPackageFqName() {
        FqName fqName = this.packageFqName;
        if (fqName == null) {
            $$$reportNull$$$0(5);
        }
        return fqName;
    }

    public FqName getRelativeClassName() {
        FqName fqName = this.relativeClassName;
        if (fqName == null) {
            $$$reportNull$$$0(6);
        }
        return fqName;
    }

    public Name getShortClassName() {
        Name shortName = this.relativeClassName.shortName();
        if (shortName == null) {
            $$$reportNull$$$0(7);
        }
        return shortName;
    }

    public int hashCode() {
        return (((this.packageFqName.hashCode() * 31) + this.relativeClassName.hashCode()) * 31) + Boolean.valueOf(this.local).hashCode();
    }

    public boolean isLocal() {
        return this.local;
    }

    public boolean isNestedClass() {
        return !this.relativeClassName.parent().isRoot();
    }

    public String toString() {
        if (this.packageFqName.isRoot()) {
            return "/" + asString();
        }
        return asString();
    }

    public static ClassId fromString(String str, boolean z) {
        String f1;
        String X0;
        if (str == null) {
            $$$reportNull$$$0(12);
        }
        f1 = y.f1(str, '/', "");
        String replace = f1.replace('/', '.');
        X0 = y.X0(str, '/', str);
        return new ClassId(new FqName(replace), new FqName(X0), z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClassId(FqName fqName, Name name) {
        this(fqName, FqName.topLevel(name), false);
        if (fqName == null) {
            $$$reportNull$$$0(3);
        }
        if (name == null) {
            $$$reportNull$$$0(4);
        }
    }
}