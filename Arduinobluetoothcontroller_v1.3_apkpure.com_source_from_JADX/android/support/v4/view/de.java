package android.support.v4.view;

class de implements Runnable {
    final /* synthetic */ ViewPager f994a;

    de(ViewPager viewPager) {
        this.f994a = viewPager;
    }

    public void run() {
        this.f994a.setScrollState(0);
        this.f994a.m1620c();
    }
}
