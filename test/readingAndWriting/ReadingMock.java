package readingAndWriting;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;

public class ReadingMock {

    private ReadingAndWriting readingAndWriting;

    @Mock
    private ReadingUtility readingUtility;
    private WritingUtility writingUtility;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setup() throws Exception{
        readingUtility = mock(ReadingUtility.class);
        writingUtility = mock(WritingUtility.class);
        readingAndWriting = new ReadingAndWriting();
        when(readingUtility.readCityInput()).thenReturn(Arrays.asList("Tallinn", "Stockholm", "Riga"));
    }

    @Test
    public void testMockedReading() throws Exception {
        readingAndWriting.ReadAndWrite(readingUtility, writingUtility);
        verify(readingUtility).readCityInput();
    }

    @Test
    public void testMockedWriting() throws Exception {
        readingAndWriting.ReadAndWrite(readingUtility, writingUtility);
        verify(writingUtility).writeOutput(Arrays.asList("Tallinn", "Stockholm", "Riga"));
    }
}
