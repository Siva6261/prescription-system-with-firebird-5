package android.support.v7.widget;

class dd implements Runnable {
    final /* synthetic */ dc f2180a;

    private dd(dc dcVar) {
        this.f2180a = dcVar;
    }

    public void run() {
        this.f2180a.f1577d.getParent().requestDisallowInterceptTouchEvent(true);
    }
}
