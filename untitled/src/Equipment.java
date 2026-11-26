public abstract class Equipment {
    protected int level;

    public Equipment(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        level++;
    }

    /** ตัวคูณต่อเลเวลของความเร็วที่ลดลง (ดาบ 0.04, โล่ 0.08) */
    protected abstract double speedPerLevel();

    /** ความเร็วที่ลดลง = r*(0.1 + k*level) โดย r คือความเร็ววิ่งพื้นฐานของตัวละคร */
    public double runSpeedDecrease(double baseRunSpeed) {
        return baseRunSpeed * (0.1 + speedPerLevel() * level);
    }
}
