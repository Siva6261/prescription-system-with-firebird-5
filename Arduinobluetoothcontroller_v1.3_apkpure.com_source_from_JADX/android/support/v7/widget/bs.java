package android.support.v7.widget;

class bs {
    long f2063a = 0;
    bs f2064b;

    bs() {
    }

    private void m4203b() {
        if (this.f2064b == null) {
            this.f2064b = new bs();
        }
    }

    void m4204a() {
        this.f2063a = 0;
        if (this.f2064b != null) {
            this.f2064b.m4204a();
        }
    }

    void m4205a(int i) {
        if (i >= 64) {
            m4203b();
            this.f2064b.m4205a(i - 64);
            return;
        }
        this.f2063a |= 1 << i;
    }

    void m4206a(int i, boolean z) {
        if (i >= 64) {
            m4203b();
            this.f2064b.m4206a(i - 64, z);
            return;
        }
        boolean z2 = (this.f2063a & Long.MIN_VALUE) != 0;
        long j = (1 << i) - 1;
        this.f2063a = (((j ^ -1) & this.f2063a) << 1) | (this.f2063a & j);
        if (z) {
            m4205a(i);
        } else {
            m4207b(i);
        }
        if (z2 || this.f2064b != null) {
            m4203b();
            this.f2064b.m4206a(0, z2);
        }
    }

    void m4207b(int i) {
        if (i < 64) {
            this.f2063a &= (1 << i) ^ -1;
        } else if (this.f2064b != null) {
            this.f2064b.m4207b(i - 64);
        }
    }

    boolean m4208c(int i) {
        if (i < 64) {
            return (this.f2063a & (1 << i)) != 0;
        } else {
            m4203b();
            return this.f2064b.m4208c(i - 64);
        }
    }

    boolean m4209d(int i) {
        if (i >= 64) {
            m4203b();
            return this.f2064b.m4209d(i - 64);
        }
        long j = 1 << i;
        boolean z = (this.f2063a & j) != 0;
        this.f2063a &= j ^ -1;
        j--;
        this.f2063a = Long.rotateRight((j ^ -1) & this.f2063a, 1) | (this.f2063a & j);
        if (this.f2064b == null) {
            return z;
        }
        if (this.f2064b.m4208c(0)) {
            m4205a(63);
        }
        this.f2064b.m4209d(0);
        return z;
    }

    int m4210e(int i) {
        return this.f2064b == null ? i >= 64 ? Long.bitCount(this.f2063a) : Long.bitCount(this.f2063a & ((1 << i) - 1)) : i < 64 ? Long.bitCount(this.f2063a & ((1 << i) - 1)) : this.f2064b.m4210e(i - 64) + Long.bitCount(this.f2063a);
    }

    public String toString() {
        return this.f2064b == null ? Long.toBinaryString(this.f2063a) : this.f2064b.toString() + "xx" + Long.toBinaryString(this.f2063a);
    }
}
