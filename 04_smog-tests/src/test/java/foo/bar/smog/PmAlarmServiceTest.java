package foo.bar.smog;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PmAlarmServiceTest {

    private static long timeExecution;
    private static long startTime;
    static PmAlarmService service;

    @BeforeAll
    static void setup(){
        service=new PmAlarmService();
        startTime=System.nanoTime();
    }

    @Test
    void shouldReturnNoneForMeasurement_10() {

        assertEquals(AlarmLevel.NONE, service.getAlarmMessage(10, Country.POLAND));
    }

    @Test
    void shouldReturnInfoForMeasurement_201() {
        assertEquals(AlarmLevel.INFO, service.getAlarmMessage(201, Country.POLAND));
    }

    @Test
    void shouldReturnInfoForMeasurement_350() {
        assertEquals(AlarmLevel.WARNING, service.getAlarmMessage(301, Country.POLAND));
    }

    @Test
    void shouldReturnNoneForMeasurement_11_Italy() {

        assertEquals(AlarmLevel.NONE, service.getAlarmMessage(11, Country.ITALY));
    }

    @Test
    void shouldReturnInfoForMeasurement_60_Italy() {
        assertEquals(AlarmLevel.INFO, service.getAlarmMessage(60, Country.ITALY));
    }

    @Test
    void shouldReturnInfoForMeasurement_80() {
        assertEquals(AlarmLevel.WARNING, service.getAlarmMessage(80, Country.ITALY));
    }

    @Test
    void shouldReturnNoneForMeasurement_12_Finland() {

        assertEquals(AlarmLevel.NONE, service.getAlarmMessage(12, Country.FINLAND));
    }

    @Test
    void shouldReturnInfoForMeasurement_65_Finland() {
        assertEquals(AlarmLevel.INFO, service.getAlarmMessage(65, Country.FINLAND));
    }

    @Test
    void shouldReturnInfoForMeasurement_85_Finland() {
        assertEquals(AlarmLevel.WARNING, service.getAlarmMessage(85, Country.FINLAND));
    }

    @Test
    void shouldReturnNoneForMeasurement_12_France() {

        assertEquals(AlarmLevel.NONE, service.getAlarmMessage(12, Country.FRANCE));
    }

    @Test
    void shouldReturnInfoForMeasurement_80_France() {
        assertEquals(AlarmLevel.WARNING, service.getAlarmMessage(80, Country.FRANCE));
    }

    @Test
    void shouldReturnInfoForMeasurement_185_France() {
        assertEquals(AlarmLevel.WARNING, service.getAlarmMessage(85, Country.FRANCE));
    }

    @AfterAll
    static void close(){
        timeExecution=System.nanoTime()-startTime;
        Logger.getLogger("JUnit5").info("Time passed for all tests = "+timeExecution/10000000+" sec.");
    }
}
