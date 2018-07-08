package android.support.v7.widget;

class cg {
    public ey f2108a;
    public ey f2109b;
    public int f2110c;
    public int f2111d;
    public int f2112e;
    public int f2113f;

    private cg(ey eyVar, ey eyVar2) {
        this.f2108a = eyVar;
        this.f2109b = eyVar2;
    }

    private cg(ey eyVar, ey eyVar2, int i, int i2, int i3, int i4) {
        this(eyVar, eyVar2);
        this.f2110c = i;
        this.f2111d = i2;
        this.f2112e = i3;
        this.f2113f = i4;
    }

    public String toString() {
        return "ChangeInfo{oldHolder=" + this.f2108a + ", newHolder=" + this.f2109b + ", fromX=" + this.f2110c + ", fromY=" + this.f2111d + ", toX=" + this.f2112e + ", toY=" + this.f2113f + '}';
    }
}
