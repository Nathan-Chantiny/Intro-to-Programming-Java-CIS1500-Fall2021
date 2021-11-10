package project3;

public class Plane {

    private final String MAKE;
    private final String MODEL;
    private final String NUMBER;
    private final int MAXALTITUDEINMETERS;
    private int currentAltitudeInMeters;
    private int changeInAltitudeInMeters;

    public Plane(String make, String model, String number, int maxAltitudeInMeters) {
        this.MAKE = make;
        this.MODEL = model;
        this.NUMBER = number;
        this.MAXALTITUDEINMETERS = maxAltitudeInMeters;
        currentAltitudeInMeters = 0;
        changeInAltitudeInMeters = 0;
    }

    public String getMake() {
        return MAKE;
    }

    public String getModel() {
        return MODEL;
    }

    public String getNumber() {
        return NUMBER;
    }

    public int getMaxAltitudeInMeters() {
        return MAXALTITUDEINMETERS;
    }

    public int getCurrentAltitudeInMeters() {
        return currentAltitudeInMeters;
    }

    public boolean isLandingGearIsEnabled() {
        // Landing gear enabled will be false unless the current altitude is between 0 and max altitude
        if (currentAltitudeInMeters >= 0 && currentAltitudeInMeters <= MAXALTITUDEINMETERS) {
            if (currentAltitudeInMeters >= 0 && currentAltitudeInMeters < 100) {
                return true;
            } else if (currentAltitudeInMeters >= 0 && currentAltitudeInMeters > 100) {
                return false;
                // In case current altitude is 100 the plane can go up or down
            } else if (currentAltitudeInMeters == 100) {
                if (currentAltitudeInMeters > deltaAltitude()) {
                    return true;
                } else if (currentAltitudeInMeters < deltaAltitude()) {
                    return false;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean changeAltitude(int changeInAltitudeInMeters) {
        this.changeInAltitudeInMeters = changeInAltitudeInMeters;
        // When landing gear IS enabled...
        // newAltitude cannot be GREATER than 100 and has to be positive
        if (isLandingGearIsEnabled() == true) {
            if (deltaAltitude() >= 0
                    && deltaAltitude() <= 100) {
                currentAltitudeInMeters += changeInAltitudeInMeters;
                return true;
            } else if (deltaAltitude() > 100
                    || deltaAltitude() < 0) {
                return false;
            }
            // When landing gear IS NOT enabled...
            // newAltitude cannot be LESS than 100 or GREATER than MAXALTITUDEINMETERS and has to be positive
        } else if (isLandingGearIsEnabled() == false) {
            if (deltaAltitude() > 0
                    && deltaAltitude() >= 100
                    && deltaAltitude() <= MAXALTITUDEINMETERS) {
                currentAltitudeInMeters += changeInAltitudeInMeters;
                return true;
            } else if (deltaAltitude() < 100
                    || deltaAltitude() < 0) {
                return false;
            }
        }
        return false;
    }

    private int deltaAltitude() {
        int i = currentAltitudeInMeters + changeInAltitudeInMeters;
        return i;
    }

}
