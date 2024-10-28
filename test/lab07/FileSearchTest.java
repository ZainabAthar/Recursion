package lab07;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class FileSearchTest {
    private FileSearch fileSearch;

    @Before
    public void setUp() {
        fileSearch = new FileSearch();
    }

    @Test
    public void testFileFound() {
        // Provide the directory path and a valid file name that exists in the directory
        String directoryPath = "C:\\Users\\ZAINAB\\OneDrive - National University of Sciences & Technology\\Semester 5\\Cloud Computing\\Lec";
        String targetFileName = "Lecture 3ABC.pdf";

        // Call the searchFile method
        fileSearch.searchFile(new File(directoryPath), targetFileName);

        // Assert that the file is found and the path matches
        assertTrue("File should be found", fileSearch.isFileFound());
        assertNotNull("Found file path should not be null", fileSearch.getFoundFile());
        assertEquals("Path should match the expected file location",
                directoryPath + "\\" + targetFileName, fileSearch.getFoundFile());
    }

    @Test
    public void testFileNotFound() {
        // Provide the directory path and a non-existent file name
        String directoryPath = "C:\\Users\\ZAINAB\\OneDrive - National University of Sciences & Technology\\Semester 5\\Cloud Computing\\Lec";
        String targetFileName = "NonExistentFile.pdf";

        // Call the searchFile method
        fileSearch.searchFile(new File(directoryPath), targetFileName);

        // Assert that the file is not found and no path is returned
        assertFalse("File should not be found", fileSearch.isFileFound());
        assertNull("No file path should be set", fileSearch.getFoundFile());
    }

    @Test
    public void testInvalidDirectory() {
        // Provide an invalid directory path
        String directoryPath = "C:\\InvalidDirectoryPath";
        String targetFileName = "AnyFile.pdf";

        // Call the searchFile method with an invalid directory
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            fileSearch.searchFile(directory, targetFileName);

            // Assert that the file is not found and no path is set
            assertFalse("File should not be found in an invalid directory", fileSearch.isFileFound());
            assertNull("No file path should be set", fileSearch.getFoundFile());
        } else {
            System.out.println("Directory exists, please adjust path to simulate invalid directory test.");
        }
    }
}
