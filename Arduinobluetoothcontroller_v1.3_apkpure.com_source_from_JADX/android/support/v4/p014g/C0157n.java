package android.support.v4.p014g;

abstract class C0157n implements C0151h {
    private final C0154m f840a;

    public C0157n(C0154m c0154m) {
        this.f840a = c0154m;
    }

    private boolean m1482b(CharSequence charSequence, int i, int i2) {
        switch (this.f840a.mo236a(charSequence, i, i2)) {
            case 0:
                return true;
            case 1:
                return false;
            default:
                return mo238a();
        }
    }

    protected abstract boolean mo238a();

    public boolean mo237a(CharSequence charSequence, int i, int i2) {
        if (charSequence != null && i >= 0 && i2 >= 0 && charSequence.length() - i2 >= i) {
            return this.f840a == null ? mo238a() : m1482b(charSequence, i, i2);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
