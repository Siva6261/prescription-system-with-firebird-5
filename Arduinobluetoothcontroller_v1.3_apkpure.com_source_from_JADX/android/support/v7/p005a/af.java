package android.support.v7.p005a;

class af implements Runnable {
    final /* synthetic */ ae f1200a;

    af(ae aeVar) {
        this.f1200a = aeVar;
    }

    public void run() {
        if ((this.f1200a.f1172F & 1) != 0) {
            this.f1200a.m2927f(0);
        }
        if ((this.f1200a.f1172F & 4096) != 0) {
            this.f1200a.m2927f(108);
        }
        this.f1200a.f1171E = false;
        this.f1200a.f1172F = 0;
    }
}
