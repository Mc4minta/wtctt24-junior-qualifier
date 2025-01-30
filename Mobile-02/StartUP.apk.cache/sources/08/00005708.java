package kotlin.reflect.jvm.internal.impl.name;

import com.coinbase.ApiConstants;

/* loaded from: classes3.dex */
public final class Name implements Comparable<Name> {
    private final String name;
    private final boolean special;

    private static /* synthetic */ void $$$reportNull$$$0(int i2) {
        String str = (i2 == 1 || i2 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 1 || i2 == 2) ? 2 : 3];
        if (i2 == 1 || i2 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = ApiConstants.NAME;
        }
        if (i2 == 1) {
            objArr[1] = "asString";
        } else if (i2 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[1] = "getIdentifier";
        }
        switch (i2) {
            case 1:
            case 2:
                break;
            case 3:
                objArr[2] = "identifier";
                break;
            case 4:
                objArr[2] = "isValidIdentifier";
                break;
            case 5:
                objArr[2] = "special";
                break;
            case 6:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    private Name(String str, boolean z) {
        if (str == null) {
            $$$reportNull$$$0(0);
        }
        this.name = str;
        this.special = z;
    }

    public static Name guessByFirstCharacter(String str) {
        if (str == null) {
            $$$reportNull$$$0(6);
        }
        if (str.startsWith("<")) {
            return special(str);
        }
        return identifier(str);
    }

    public static Name identifier(String str) {
        if (str == null) {
            $$$reportNull$$$0(3);
        }
        return new Name(str, false);
    }

    public static boolean isValidIdentifier(String str) {
        if (str == null) {
            $$$reportNull$$$0(4);
        }
        if (str.isEmpty() || str.startsWith("<")) {
            return false;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '.' || charAt == '/' || charAt == '\\') {
                return false;
            }
        }
        return true;
    }

    public static Name special(String str) {
        if (str == null) {
            $$$reportNull$$$0(5);
        }
        if (str.startsWith("<")) {
            return new Name(str, true);
        }
        throw new IllegalArgumentException("special name must start with '<': " + str);
    }

    public String asString() {
        String str = this.name;
        if (str == null) {
            $$$reportNull$$$0(1);
        }
        return str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Name) {
            Name name = (Name) obj;
            return this.special == name.special && this.name.equals(name.name);
        }
        return false;
    }

    public String getIdentifier() {
        if (!this.special) {
            String asString = asString();
            if (asString == null) {
                $$$reportNull$$$0(2);
            }
            return asString;
        }
        throw new IllegalStateException("not identifier: " + this);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + (this.special ? 1 : 0);
    }

    public boolean isSpecial() {
        return this.special;
    }

    public String toString() {
        return this.name;
    }

    @Override // java.lang.Comparable
    public int compareTo(Name name) {
        return this.name.compareTo(name.name);
    }
}