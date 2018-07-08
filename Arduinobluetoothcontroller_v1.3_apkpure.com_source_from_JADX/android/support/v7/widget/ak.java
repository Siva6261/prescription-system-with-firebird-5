package android.support.v7.widget;

class ak {
    int f1926a;
    int f1927b;
    Object f1928c;
    int f1929d;

    ak(int i, int i2, int i3, Object obj) {
        this.f1926a = i;
        this.f1927b = i2;
        this.f1929d = i3;
        this.f1928c = obj;
    }

    String m4054a() {
        switch (this.f1926a) {
            case 1:
                return "add";
            case 2:
                return "rm";
            case 4:
                return "up";
            case 8:
                return "mv";
            default:
                return "??";
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ak akVar = (ak) obj;
        return this.f1926a != akVar.f1926a ? false : (this.f1926a == 8 && Math.abs(this.f1929d - this.f1927b) == 1 && this.f1929d == akVar.f1927b && this.f1927b == akVar.f1929d) ? true : this.f1929d != akVar.f1929d ? false : this.f1927b != akVar.f1927b ? false : this.f1928c != null ? this.f1928c.equals(akVar.f1928c) : akVar.f1928c == null;
    }

    public int hashCode() {
        return (((this.f1926a * 31) + this.f1927b) * 31) + this.f1929d;
    }

    public String toString() {
        return Integer.toHexString(System.identityHashCode(this)) + "[" + m4054a() + ",s:" + this.f1927b + "c:" + this.f1929d + ",p:" + this.f1928c + "]";
    }
}
