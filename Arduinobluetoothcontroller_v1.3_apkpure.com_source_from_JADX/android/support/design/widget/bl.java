package android.support.design.widget;

class bl implements bz {
    final /* synthetic */ Snackbar f392a;

    bl(Snackbar snackbar) {
        this.f392a = snackbar;
    }

    public void mo105a() {
        Snackbar.f284a.sendMessage(Snackbar.f284a.obtainMessage(0, this.f392a));
    }

    public void mo106a(int i) {
        Snackbar.f284a.sendMessage(Snackbar.f284a.obtainMessage(1, i, 0, this.f392a));
    }
}
