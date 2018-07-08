package io.realm.internal;

public class C0476r implements Comparable {
    final long f2961a;
    final long f2962b;

    C0476r(long j, long j2) {
        this.f2961a = j;
        this.f2962b = j2;
    }

    public int m5752a(C0476r c0476r) {
        return this.f2961a > c0476r.f2961a ? 1 : this.f2961a < c0476r.f2961a ? -1 : 0;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m5752a((C0476r) obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        C0476r c0476r = (C0476r) obj;
        return this.f2961a == c0476r.f2961a && this.f2962b == c0476r.f2962b;
    }

    public int hashCode() {
        return (((super.hashCode() * 31) + ((int) (this.f2961a ^ (this.f2961a >>> 32)))) * 31) + ((int) (this.f2962b ^ (this.f2962b >>> 32)));
    }

    public String toString() {
        return "VersionID{version=" + this.f2961a + ", index=" + this.f2962b + '}';
    }
}
