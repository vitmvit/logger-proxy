package by.vitikova.logger.proxy;

import by.vitikova.logger.proxy.service.impl.CatVoiceImp;
import by.vitikova.logger.proxy.service.proxy.CatProxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatProxyTest {

    private CatProxy catProxy;
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    public void setUp() {
        catProxy = new CatProxy(new CatVoiceImp());
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testGetMayLogsCorrectly() {
        String actual = catProxy.getMay();
        assertEquals("May!", actual);

        String logs = outputStreamCaptor.toString().trim();
        assert (logs.contains("Invoked method CatVoiceImp.getMay") && logs.contains("Method finished with result: May!"));
    }

    @Test
    public void testGetHissingDoesNotLog() {
        String actual = catProxy.getHissing();
        assertEquals("Shhhhh!", actual);

        String logs = outputStreamCaptor.toString().trim();
        assert (!logs.contains("Invoked method CatVoiceImp.getHissing"));
    }

    @Test
    public void testGetGrowlLogsCorrectly() {
        String actual = catProxy.getGrowl();
        assertEquals("Rrrrrr!", actual);

        String logs = outputStreamCaptor.toString().trim();
        assert (logs.contains("Invoked method CatVoiceImp.getGrowl") && logs.contains("Method finished with result: Rrrrrr!"));
    }
}