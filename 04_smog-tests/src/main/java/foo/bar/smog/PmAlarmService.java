package foo.bar.smog;

public class PmAlarmService {

    public PmAlarmService() { }

    public AlarmLevel getAlarmMessage(int measurement, Country country) {
        switch (country) {
            case ITALY:
                return getAlarmLevel(measurement, 50, 75);
            case FINLAND:
                return getAlarmLevel(measurement, 50, 80);
            case FRANCE:
                return getAlarmLevel(measurement, 80, 80);
            case POLAND:
                return getAlarmLevel(measurement, 200, 300);
        }
        return AlarmLevel.NONE;
    }

    private AlarmLevel getAlarmLevel(int measurement, int lowestValueForInfo, int lowestValueForWarning) {
        if (measurement > 0 && measurement < lowestValueForInfo) {
            return AlarmLevel.NONE;
        } else if (measurement < lowestValueForWarning) {
            return AlarmLevel.INFO;
        } else {
            return AlarmLevel.WARNING;
        }
    }

}
