package com.giumig.apps.bluetoothcontroller;

class be implements Runnable {
    final /* synthetic */ SplashActivity f2694a;

    be(SplashActivity splashActivity) {
        this.f2694a = splashActivity;
    }

    public void run() {
        if (MyApplication.m5137a().m5140c()) {
            this.f2694a.m5151k();
            return;
        }
        this.f2694a.f2598r.setVisibility(8);
        this.f2694a.f2599s.setVisibility(0);
    }
}
