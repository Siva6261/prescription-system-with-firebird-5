package android.support.v4.p015h;

public class C0181p implements C0180o {
    private final Object[] f889a;
    private int f890b;

    public C0181p(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f889a = new Object[i];
    }

    private boolean m1564b(Object obj) {
        for (int i = 0; i < this.f890b; i++) {
            if (this.f889a[i] == obj) {
                return true;
            }
        }
        return false;
    }

    public Object mo249a() {
        if (this.f890b <= 0) {
            return null;
        }
        int i = this.f890b - 1;
        Object obj = this.f889a[i];
        this.f889a[i] = null;
        this.f890b--;
        return obj;
    }

    public boolean mo250a(Object obj) {
        if (m1564b(obj)) {
            throw new IllegalStateException("Already in the pool!");
        } else if (this.f890b >= this.f889a.length) {
            return false;
        } else {
            this.f889a[this.f890b] = obj;
            this.f890b++;
            return true;
        }
    }
}
