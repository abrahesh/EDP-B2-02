public class Satelite implements FicheroSecuencialReader{
    private double epoch;
    private double inclination;
    private double raan;
    private double eccentricity;
    private double argumentOfPerigee;
    private double meanMotion;

    public Satelite(double epoch, double inclination, double raan, double eccentricity, double argumentOfPerigee, double meanMotion) {
        this.epoch = epoch;
        this.inclination = inclination;
        this.raan = raan;
        this.eccentricity = eccentricity;
        this.argumentOfPerigee = argumentOfPerigee;
        this.meanMotion = meanMotion;
    }

    public double getEpoch() {
        return epoch;
    }

    public double getInclination() {
        return inclination;
    }

    public double getRaan() {
        return raan;
    }

    public double getEccentricity() {
        return eccentricity;
    }

    public double getArgumentOfPerigee() {
        return argumentOfPerigee;
    }

    public double getMeanMotion() {
        return meanMotion;
    }

    @Override
    public void readData(String[] data) {
        this.epoch = Double.parseDouble(data[0]);
        this.inclination = Double.parseDouble(data[1]);
        this.raan = Double.parseDouble(data[2]);
        this.eccentricity = Double.parseDouble(data[3]);
        this.argumentOfPerigee = Double.parseDouble(data[4]);
        this.meanMotion = Double.parseDouble(data[5]);
    }
}