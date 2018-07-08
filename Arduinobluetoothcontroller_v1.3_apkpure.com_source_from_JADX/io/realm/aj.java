package io.realm;

import com.giumig.apps.bluetoothcontroller.p025d.C0396c;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.C0427m;
import io.realm.internal.C0428b;
import io.realm.internal.C0469g;
import io.realm.internal.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class aj extends C0396c implements al, C0427m {
    private static final List f2836d;
    private final ak f2837c;

    static {
        List arrayList = new ArrayList();
        arrayList.add("profileId");
        arrayList.add("profileName");
        arrayList.add("onCommand");
        arrayList.add("offCommand");
        f2836d = Collections.unmodifiableList(arrayList);
    }

    aj(C0428b c0428b) {
        this.f2837c = (ak) c0428b;
    }

    static C0396c m5423a(C0483m c0483m, C0396c c0396c, C0396c c0396c2, Map map) {
        c0396c.mo871f(c0396c2.mo868e());
        c0396c.mo873g(c0396c2.mo870f());
        c0396c.mo874h(c0396c2.mo872g());
        return c0396c;
    }

    public static C0396c m5424a(C0483m c0483m, C0396c c0396c, boolean z, Map map) {
        if (c0396c.f2729b != null && c0396c.f2729b.f2786c != c0483m.c) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if (c0396c.f2729b != null && c0396c.f2729b.mo889f().equals(c0483m.mo889f())) {
            return c0396c;
        } else {
            boolean z2;
            C0396c c0396c2 = null;
            if (z) {
                Table d = c0483m.m5804d(C0396c.class);
                long e = d.m5549e();
                if (c0396c.mo867d() == null) {
                    throw new IllegalArgumentException("Primary key value must not be null.");
                }
                e = d.m5532a(e, c0396c.mo867d());
                if (e != -1) {
                    c0396c2 = new aj(c0483m.g.m5418a(C0396c.class));
                    c0396c2.f2729b = c0483m;
                    c0396c2.f2728a = d.m5555h(e);
                    map.put(c0396c, (C0427m) c0396c2);
                    z2 = z;
                } else {
                    z2 = false;
                }
            } else {
                z2 = z;
            }
            return z2 ? m5423a(c0483m, c0396c2, c0396c, map) : m5426b(c0483m, c0396c, z, map);
        }
    }

    public static Table m5425a(C0469g c0469g) {
        if (c0469g.m5492a("class_SwitchProfile")) {
            return c0469g.m5493b("class_SwitchProfile");
        }
        Table b = c0469g.m5493b("class_SwitchProfile");
        b.m5534a(RealmFieldType.STRING, "profileId", false);
        b.m5534a(RealmFieldType.STRING, "profileName", true);
        b.m5534a(RealmFieldType.STRING, "onCommand", true);
        b.m5534a(RealmFieldType.STRING, "offCommand", true);
        b.m5560j(b.m5536a("profileId"));
        b.m5543b("profileId");
        return b;
    }

    public static C0396c m5426b(C0483m c0483m, C0396c c0396c, boolean z, Map map) {
        C0396c c0396c2 = (C0396c) c0483m.m5797a(C0396c.class, c0396c.mo867d());
        map.put(c0396c, (C0427m) c0396c2);
        c0396c2.mo869e(c0396c.mo867d());
        c0396c2.mo871f(c0396c.mo868e());
        c0396c2.mo873g(c0396c.mo870f());
        c0396c2.mo874h(c0396c.mo872g());
        return c0396c2;
    }

    public static ak m5427b(C0469g c0469g) {
        if (c0469g.m5492a("class_SwitchProfile")) {
            Table b = c0469g.m5493b("class_SwitchProfile");
            if (b.m5545c() != 4) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Field count does not match - expected 4 but was " + b.m5545c());
            }
            Map hashMap = new HashMap();
            for (long j = 0; j < 4; j++) {
                hashMap.put(b.m5546c(j), b.m5548d(j));
            }
            ak akVar = new ak(c0469g.m5702f(), b);
            if (!hashMap.containsKey("profileId")) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Missing field 'profileId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (hashMap.get("profileId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Invalid type 'String' for field 'profileId' in existing Realm file.");
            } else if (b.m5544b(akVar.f2839a)) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Field 'profileId' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'profileId' or migrate using io.realm.internal.Table.convertColumnToNotNullable().");
            } else if (b.m5549e() != b.m5536a("profileId")) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Primary key not defined for field 'profileId' in existing Realm file. Add @PrimaryKey.");
            } else if (!b.m5564l(b.m5536a("profileId"))) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Index not defined for field 'profileId' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            } else if (!hashMap.containsKey("profileName")) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Missing field 'profileName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (hashMap.get("profileName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Invalid type 'String' for field 'profileName' in existing Realm file.");
            } else if (!b.m5544b(akVar.f2840b)) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Field 'profileName' is required. Either set @Required to field 'profileName' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            } else if (!hashMap.containsKey("onCommand")) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Missing field 'onCommand' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (hashMap.get("onCommand") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Invalid type 'String' for field 'onCommand' in existing Realm file.");
            } else if (!b.m5544b(akVar.f2841c)) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Field 'onCommand' is required. Either set @Required to field 'onCommand' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            } else if (!hashMap.containsKey("offCommand")) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Missing field 'offCommand' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (hashMap.get("offCommand") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Invalid type 'String' for field 'offCommand' in existing Realm file.");
            } else if (b.m5544b(akVar.f2842d)) {
                return akVar;
            } else {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Field 'offCommand' is required. Either set @Required to field 'offCommand' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            }
        }
        throw new RealmMigrationNeededException(c0469g.m5702f(), "The SwitchProfile class is missing from the schema for this Realm.");
    }

    public static String m5428h() {
        return "class_SwitchProfile";
    }

    public String mo867d() {
        this.f2729b.m5368e();
        return this.f2728a.mo915h(this.f2837c.f2839a);
    }

    public String mo868e() {
        this.f2729b.m5368e();
        return this.f2728a.mo915h(this.f2837c.f2840b);
    }

    public void mo869e(String str) {
        this.f2729b.m5368e();
        if (str == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field profileId to null.");
        }
        this.f2728a.mo904a(this.f2837c.f2839a, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        aj ajVar = (aj) obj;
        String f = this.f2729b.mo889f();
        String f2 = ajVar.f2729b.mo889f();
        if (f == null ? f2 != null : !f.equals(f2)) {
            return false;
        }
        f = this.f2728a.mo907b().m5561k();
        f2 = ajVar.f2728a.mo907b().m5561k();
        return (f == null ? f2 != null : !f.equals(f2)) ? false : this.f2728a.mo908c() == ajVar.f2728a.mo908c();
    }

    public String mo870f() {
        this.f2729b.m5368e();
        return this.f2728a.mo915h(this.f2837c.f2841c);
    }

    public void mo871f(String str) {
        this.f2729b.m5368e();
        if (str == null) {
            this.f2728a.mo920m(this.f2837c.f2840b);
        } else {
            this.f2728a.mo904a(this.f2837c.f2840b, str);
        }
    }

    public String mo872g() {
        this.f2729b.m5368e();
        return this.f2728a.mo915h(this.f2837c.f2842d);
    }

    public void mo873g(String str) {
        this.f2729b.m5368e();
        if (str == null) {
            this.f2728a.mo920m(this.f2837c.f2841c);
        } else {
            this.f2728a.mo904a(this.f2837c.f2841c, str);
        }
    }

    public void mo874h(String str) {
        this.f2729b.m5368e();
        if (str == null) {
            this.f2728a.mo920m(this.f2837c.f2842d);
        } else {
            this.f2728a.mo904a(this.f2837c.f2842d, str);
        }
    }

    public int hashCode() {
        int i = 0;
        String f = this.f2729b.mo889f();
        String k = this.f2728a.mo907b().m5561k();
        long c = this.f2728a.mo908c();
        int hashCode = ((f != null ? f.hashCode() : 0) + 527) * 31;
        if (k != null) {
            i = k.hashCode();
        }
        return ((i + hashCode) * 31) + ((int) ((c >>> 32) ^ c));
    }

    public String toString() {
        if (!m5232z()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("SwitchProfile = [");
        stringBuilder.append("{profileId:");
        stringBuilder.append(mo867d());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{profileName:");
        stringBuilder.append(mo868e() != null ? mo868e() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{onCommand:");
        stringBuilder.append(mo870f() != null ? mo870f() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{offCommand:");
        stringBuilder.append(mo872g() != null ? mo872g() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
