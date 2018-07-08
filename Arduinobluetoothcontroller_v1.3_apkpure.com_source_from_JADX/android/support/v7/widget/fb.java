package android.support.v7.widget;

class fb {
    private int f2276a = 0;
    private int f2277b = 0;
    private int f2278c = Integer.MIN_VALUE;
    private int f2279d = Integer.MIN_VALUE;
    private int f2280e = 0;
    private int f2281f = 0;
    private boolean f2282g = false;
    private boolean f2283h = false;

    fb() {
    }

    public int m4678a() {
        return this.f2276a;
    }

    public void m4679a(int i, int i2) {
        this.f2278c = i;
        this.f2279d = i2;
        this.f2283h = true;
        if (this.f2282g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f2276a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f2277b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f2276a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2277b = i2;
        }
    }

    public void m4680a(boolean z) {
        if (z != this.f2282g) {
            this.f2282g = z;
            if (!this.f2283h) {
                this.f2276a = this.f2280e;
                this.f2277b = this.f2281f;
            } else if (z) {
                this.f2276a = this.f2279d != Integer.MIN_VALUE ? this.f2279d : this.f2280e;
                this.f2277b = this.f2278c != Integer.MIN_VALUE ? this.f2278c : this.f2281f;
            } else {
                this.f2276a = this.f2278c != Integer.MIN_VALUE ? this.f2278c : this.f2280e;
                this.f2277b = this.f2279d != Integer.MIN_VALUE ? this.f2279d : this.f2281f;
            }
        }
    }

    public int m4681b() {
        return this.f2277b;
    }

    public void m4682b(int i, int i2) {
        this.f2283h = false;
        if (i != Integer.MIN_VALUE) {
            this.f2280e = i;
            this.f2276a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2281f = i2;
            this.f2277b = i2;
        }
    }

    public int m4683c() {
        return this.f2282g ? this.f2277b : this.f2276a;
    }

    public int m4684d() {
        return this.f2282g ? this.f2276a : this.f2277b;
    }
}
