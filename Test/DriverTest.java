import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    Driver driver = new Driver("Sam", 101);

    @Test
    public void getDriverNumTest(){

        assertEquals(101, driver.getDriverNum());
    }


    @Test
    public void setDriverNumTest(){

        Driver dr2 = new Driver("SK1", 104);


    }

    @Test
    public void setDriverNumFailTest(){

        assertThrows(IllegalArgumentException.class, () -> {Driver dr2 = new Driver("SK",99);});


    }

    @Test
    public void setDriverNameTest(){

        assertThrows(IllegalArgumentException.class, () -> {Driver dr2 = new Driver("",102);});


    }


    @Test
    public void setDriverNameFailTest(){


    }






}