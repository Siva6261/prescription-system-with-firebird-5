package android.support.v4.p014g;

class C0155k implements C0154m {
    public static final C0155k f836a = new C0155k(true);
    public static final C0155k f837b = new C0155k(false);
    private final boolean f838c;

    private C0155k(boolean z) {
        this.f838c = z;
    }

    public int mo236a(CharSequence charSequence, int i, int i2) {
        int i3 = i + i2;
        int i4 = 0;
        while (i < i3) {
            switch (C0152i.m1477c(Character.getDirectionality(charSequence.charAt(i)))) {
                case 0:
                    if (!this.f838c) {
                        i4 = 1;
                        break;
                    }
                    return 0;
                case 1:
                    if (this.f838c) {
                        i4 = 1;
                        break;
                    }
                    return 1;
                default:
                    break;
            }
            i++;
        }
        return i4 != 0 ? !this.f838c ? 0 : 1 : 2;
    }
}
