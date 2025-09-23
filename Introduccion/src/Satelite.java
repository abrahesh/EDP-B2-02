public class Satelite implements FicheroSecuencialReader {
    private String objectName;
    private String objectId;
    private String epoch;
    private double meanMotion;
    private double eccentricity;
    private double inclination;
    private double raan;
    private double argumentOfPerigee;

    public Satelite() {
    }

    public String getObjectName() {
        return objectName;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getEpoch() {
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
        this.objectName = data[0];
        this.objectId = data[0];
        this.epoch = data[0];
        this.inclination = Double.parseDouble(data[3]);
        this.raan = Double.parseDouble(data[4]);
        this.eccentricity = Double.parseDouble(data[5]);
        this.argumentOfPerigee = Double.parseDouble(data[6]);
        this.meanMotion = Double.parseDouble(data[7]);
    }
}
