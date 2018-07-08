package com.giumig.apps.bluetoothcontroller;

public class bd {
    int f2691a = -1;
    float f2692b = 1.0f;
    float f2693c = 1.0f;

    public bd(int i, float f, float f2) {
        this.f2691a = i;
        this.f2692b = f;
        this.f2693c = f2;
    }

    public boolean m5206a() {
        return (this.f2692b == 0.0f || this.f2693c == 0.0f || this.f2691a == -1) ? false : true;
    }

    public boolean m5207b() {
        return this.f2692b == -101.1986f;
    }

    public boolean m5208c() {
        return this.f2693c == -101.1986f;
    }
}
