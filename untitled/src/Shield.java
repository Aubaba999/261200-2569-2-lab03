public class Shield extends Equipment {
    private final double baseDefense; // s

    public Shield(double baseDefense, int level) {
        super(level);
        this.baseDefense = baseDefense;
    }

    /** ค่าป้องกัน = s*(1+0.05*level) */
    public double getDefense() {
        return baseDefense * (1 + 0.05 * level);
    }

    @Override
    protected double speedPerLevel() {
        return 0.08;
    }
}
