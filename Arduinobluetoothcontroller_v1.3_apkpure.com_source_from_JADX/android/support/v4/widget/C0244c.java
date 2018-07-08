package android.support.v4.widget;

import android.view.animation.AnimationUtils;

class C0244c {
    private int f1131a;
    private int f1132b;
    private float f1133c;
    private float f1134d;
    private long f1135e = Long.MIN_VALUE;
    private long f1136f = 0;
    private int f1137g = 0;
    private int f1138h = 0;
    private long f1139i = -1;
    private float f1140j;
    private int f1141k;

    private float m2752a(float f) {
        return ((-4.0f * f) * f) + (4.0f * f);
    }

    private float m2753a(long j) {
        if (j < this.f1135e) {
            return 0.0f;
        }
        if (this.f1139i < 0 || j < this.f1139i) {
            return C0240a.m2567b(((float) (j - this.f1135e)) / ((float) this.f1131a), 0.0f, 1.0f) * 0.5f;
        }
        long j2 = j - this.f1139i;
        return (C0240a.m2567b(((float) j2) / ((float) this.f1141k), 0.0f, 1.0f) * this.f1140j) + (1.0f - this.f1140j);
    }

    public void m2754a() {
        this.f1135e = AnimationUtils.currentAnimationTimeMillis();
        this.f1139i = -1;
        this.f1136f = this.f1135e;
        this.f1140j = 0.5f;
        this.f1137g = 0;
        this.f1138h = 0;
    }

    public void m2755a(float f, float f2) {
        this.f1133c = f;
        this.f1134d = f2;
    }

    public void m2756a(int i) {
        this.f1131a = i;
    }

    public void m2757b() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f1141k = C0240a.m2568b((int) (currentAnimationTimeMillis - this.f1135e), 0, this.f1132b);
        this.f1140j = m2753a(currentAnimationTimeMillis);
        this.f1139i = currentAnimationTimeMillis;
    }

    public void m2758b(int i) {
        this.f1132b = i;
    }

    public boolean m2759c() {
        return this.f1139i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1139i + ((long) this.f1141k);
    }

    public void m2760d() {
        if (this.f1136f == 0) {
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        float a = m2752a(m2753a(currentAnimationTimeMillis));
        long j = currentAnimationTimeMillis - this.f1136f;
        this.f1136f = currentAnimationTimeMillis;
        this.f1137g = (int) ((((float) j) * a) * this.f1133c);
        this.f1138h = (int) ((((float) j) * a) * this.f1134d);
    }

    public int m2761e() {
        return (int) (this.f1133c / Math.abs(this.f1133c));
    }

    public int m2762f() {
        return (int) (this.f1134d / Math.abs(this.f1134d));
    }

    public int m2763g() {
        return this.f1137g;
    }

    public int m2764h() {
        return this.f1138h;
    }
}
