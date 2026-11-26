public class RPGCharacter {
    private int level;
    private final double baseRunSpeed; // r
    private double hp;
    private double mana;
    private Sword sword;   // null = ไม่ได้สวมใส่
    private Shield shield; // null = ไม่ได้สวมใส่

    public RPGCharacter(double baseRunSpeed, int level) {
        this.baseRunSpeed = baseRunSpeed;
        this.level = level;
        this.hp = getMaxHp();     // เริ่มต้นเต็ม
        this.mana = getMaxMana();
    }

    // ---- ค่าที่คำนวณ (ไม่เก็บซ้ำ) ----
    public double getMaxHp()   { return 100 + 10 * level; }
    public double getMaxMana() { return 50 + 2 * level; }
    public double getMaxRunSpeed() { return baseRunSpeed * (0.1 + 0.03 * level); }

    /** ความเร็วปัจจุบัน = ความเร็วสูงสุด - ค่าที่ลดลงจากอุปกรณ์ที่สวมอยู่ (ไม่ต่ำกว่า 0) */
    public double getRunSpeed() {
        double speed = getMaxRunSpeed();
        if (sword != null)  speed -= sword.runSpeedDecrease(baseRunSpeed);
        if (shield != null) speed -= shield.runSpeedDecrease(baseRunSpeed);
        return Math.max(0, speed);
    }

    public double getHp()   { return hp; }
    public double getMana() { return mana; }
    public int getLevel()   { return level; }
    public boolean isAlive() { return hp > 0; }

    // ---- การดำเนินการ ----
    /** เลเวลอัป: ค่าสูงสุดเพิ่ม แต่ HP/มานาปัจจุบันไม่เปลี่ยน */
    public void levelUp() { level++; }

    public void equipSword(Sword s)    { sword = s; }
    public void unequipSword()         { sword = null; }
    public void equipShield(Shield s)  { shield = s; }
    public void unequipShield()        { shield = null; }

    /** ถูกโจมตีด้วยดาบ โล่ช่วยลดดาเมจ คืนค่าดาเมจที่ได้รับจริง */
    public double takeAttack(Sword attacker) {
        double damage = attacker.getDamage();
        if (shield != null) damage -= shield.getDefense();
        damage = Math.max(0, damage);
        hp = Math.max(0, hp - damage);
        return damage;
    }
}