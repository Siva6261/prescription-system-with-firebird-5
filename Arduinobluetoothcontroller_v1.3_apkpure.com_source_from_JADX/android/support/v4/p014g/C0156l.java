package android.support.v4.p014g;

class C0156l implements C0154m {
    public static final C0156l f839a = new C0156l();

    private C0156l() {
    }

    public int mo236a(CharSequence charSequence, int i, int i2) {
        int i3 = i + i2;
        int i4 = 2;
        while (i < i3 && i4 == 2) {
            i4 = C0152i.m1478d(Character.getDirectionality(charSequence.charAt(i)));
            i++;
        }
        return i4;
    }
}
