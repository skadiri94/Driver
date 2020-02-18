import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


public class DriverConsoleTest {

        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

        @BeforeEach
        /* for console output testing */
        public void setUpStreams() {
            System.setOut(new PrintStream(outContent));
            System.setErr(new PrintStream(errContent));
        }


        @Test
        public void testageOkMsg() throws IOException
        {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));
            Driver dr1 = new Driver("buddy", 115);
            dr1.checkNumberValid();
            baos.flush();
            String whatWasPrinted = new String(baos.toByteArray());
            String[] linesOfOutput = whatWasPrinted.split(//
                    System.getProperty("line.separator"));
            assertEquals("Driver number valid", linesOfOutput[0]);
        }


        @Test
        public void testageNotOkMsg() throws IOException
        {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));
            Driver dr1 = new Driver("buddy", 5001);
            dr1.checkNumberValid();
            baos.flush();
            String whatWasPrinted = new String(baos.toByteArray());
            String[] linesOfOutput = whatWasPrinted.split(//
                    System.getProperty("line.separator"));
            assertEquals("Error Driver number not valid", linesOfOutput[0]);
        }


        @AfterEach
        /* for console output testing */
        public void cleanUpStreams() {
            System.setOut(null);
            System.setErr(null);
        }

    }
