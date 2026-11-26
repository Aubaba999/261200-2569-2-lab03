public class Sword extends Equipment {
    private final double baseDamage; // d

    public Sword(double baseDamage, int level) {
        super(level);
        this.baseDamage = baseDamage;
    }

    /** ดาเมจ = d*(1+0.1*level) */
    public double getDamage() {
        return baseDamage * (1 + 0.1 * level);
    }

    @Override
    protected double speedPerLevel() {
        return 0.04;
    }
}
