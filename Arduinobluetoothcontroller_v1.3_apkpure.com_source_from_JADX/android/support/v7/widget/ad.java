package android.support.v7.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

public final class ad {
    public final ComponentName f1907a;
    public final long f1908b;
    public final float f1909c;

    public ad(ComponentName componentName, long j, float f) {
        this.f1907a = componentName;
        this.f1908b = j;
        this.f1909c = f;
    }

    public ad(String str, long j, float f) {
        this(ComponentName.unflattenFromString(str), j, f);
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
        ad adVar = (ad) obj;
        if (this.f1907a == null) {
            if (adVar.f1907a != null) {
                return false;
            }
        } else if (!this.f1907a.equals(adVar.f1907a)) {
            return false;
        }
        return this.f1908b != adVar.f1908b ? false : Float.floatToIntBits(this.f1909c) == Float.floatToIntBits(adVar.f1909c);
    }

    public int hashCode() {
        return (((((this.f1907a == null ? 0 : this.f1907a.hashCode()) + 31) * 31) + ((int) (this.f1908b ^ (this.f1908b >>> 32)))) * 31) + Float.floatToIntBits(this.f1909c);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("; activity:").append(this.f1907a);
        stringBuilder.append("; time:").append(this.f1908b);
        stringBuilder.append("; weight:").append(new BigDecimal((double) this.f1909c));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
