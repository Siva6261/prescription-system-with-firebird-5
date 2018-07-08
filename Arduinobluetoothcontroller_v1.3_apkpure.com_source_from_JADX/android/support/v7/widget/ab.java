package android.support.v7.widget;

import android.content.pm.ResolveInfo;
import java.math.BigDecimal;

public final class ab implements Comparable {
    public final ResolveInfo f1904a;
    public float f1905b;
    final /* synthetic */ C0372z f1906c;

    public ab(C0372z c0372z, ResolveInfo resolveInfo) {
        this.f1906c = c0372z;
        this.f1904a = resolveInfo;
    }

    public int m4007a(ab abVar) {
        return Float.floatToIntBits(abVar.f1905b) - Float.floatToIntBits(this.f1905b);
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m4007a((ab) obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return Float.floatToIntBits(this.f1905b) == Float.floatToIntBits(((ab) obj).f1905b);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f1905b) + 31;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("resolveInfo:").append(this.f1904a.toString());
        stringBuilder.append("; weight:").append(new BigDecimal((double) this.f1905b));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
