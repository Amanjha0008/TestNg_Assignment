package test.scientificCalc;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.*;
import temp.scientific.methods.Scientific_Calculator;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class TestScientificCalc {
    private Scientific_Calculator calculator;

    @BeforeMethod
    public void setUp(){
        calculator = new Scientific_Calculator();
    }

    @AfterMethod
    public  void tearDown(){
        calculator = null;
    }

    @DataProvider
    public Object[][] getTestData() throws IOException, CsvException {
        String csvFile = "TestData.csv";
        CSVReader reader = new CSVReader(new FileReader(csvFile));
        List<String[]> lines = reader.readAll();
        reader.close();


        int numOfRows = lines.size();
        Object[][] testData = new Object[numOfRows][5];
        for (int i = 0; i < numOfRows; i++) {
            String[] dataOfRow = lines.get(i);
            testData[i][0] = dataOfRow[0]; // arg1
            testData[i][1] = dataOfRow[1]; // operation
            testData[i][2] = dataOfRow[2]; // arg2
            testData[i][3] = dataOfRow[3]; // expectedResult
            testData[i][4] = dataOfRow[4]; // groups
        }
        return testData;
    }
    @Test(dataProvider = "getTestData", groups = "basicOperations", priority = 0)
    public void testAddition(String arg1, String operation, String arg2, String expectedResult, String groups) {
        // Checking if the test belongs to the correct group
        if ("basicOperations".equals(groups)) {
            try {
                // Perform addition operation
                if ("addition".equalsIgnoreCase(operation)) {
                    // Check for empty strings
                    if (arg1 == null || arg1.isEmpty() || arg2 == null || arg2.isEmpty()) {
                        System.out.println("Empty string found in test data. Skipping the test.");
                        return;
                    }

                    // Convert arguments to double
                    double num1 = Double.parseDouble(arg1);
                    double num2 = Double.parseDouble(arg2);

                    // Perform addition
                    double result = calculator.add(num1, num2);

                    // Verify the result
                    double expected = Double.parseDouble(expectedResult);
                    //double epsilon = 1e-10; // tolerance for floating-point comparison
                    Assert.assertEquals(result, expected, "Addition operation result mismatch");

                    System.out.println("Test for addition executed successfully.");
                }
            } catch (NumberFormatException e) {
                // Handling exceptions during the test execution
                System.out.println("NumberFormatException: Invalid numeric values provided in test data.");
            }
        }
    }

    @Test(dataProvider = "getTestData", groups = "basicOperations", priority = 1)
    public void testSubtraction(String arg1, String operation, String arg2, String expectedResult, String groups) {
        // Checking if the test belongs to the correct group
        if ("basicOperations".equals(groups)) {
            try {
                if ("subtraction".equalsIgnoreCase(operation)) {
                    if (arg1 == null || arg1.isEmpty() || arg2 == null || arg2.isEmpty()) {
                        System.out.println("Empty string found in test data. Skipping the test.");
                        return;
                    }

                    double num1 = Double.parseDouble(arg1);
                    double num2 = Double.parseDouble(arg2);

                    double result = calculator.subtract(num1, num2);

                    // Verify the result
                    double expected = Double.parseDouble(expectedResult);
                    double epsilon = 1e-10; // tolerance for floating-point comparison
                    Assert.assertEquals(result, expected,epsilon,"Subtraction operation result mismatch");

                    System.out.println("Test for Subtraction executed successfully.");
                }
            } catch (NumberFormatException e) {
                // Handling exceptions during the test execution
                System.out.println("NumberFormatException: Invalid numeric values provided in test data.");
            }
        }
    }

    @Test(dataProvider = "getTestData", groups = "basicOperations", priority = 2)
    public void testMultiply(String arg1, String operation, String arg2, String expectedResult, String groups) {
        // Checking if the test belongs to the correct group
        if ("basicOperations".equals(groups)) {
            try {
                if ("multiply".equalsIgnoreCase(operation)) {
                    // Check for empty strings
                    if (arg1 == null || arg1.isEmpty() || arg2 == null || arg2.isEmpty()) {
                        System.out.println("Empty string found in test data. Skipping the test.");
                        return;
                    }

                    // Convert arguments to double
                    double num1 = Double.parseDouble(arg1);
                    double num2 = Double.parseDouble(arg2);

                    //perform multiply operation
                    double result = calculator.multiply(num1, num2);

                    // Verify the result
                    double expected = Double.parseDouble(expectedResult);
                    double epsilon = 1e-10; // tolerance for floating-point comparison
                    Assert.assertEquals(result, expected,epsilon,"multiply operation result mismatch");

                    System.out.println("Test for multiply executed successfully.");
                }
            } catch (NumberFormatException e) {
                // Handling exceptions during the test execution
                System.out.println("NumberFormatException: Invalid numeric values provided in test data.");
            }
        }
    }
    @Test(dataProvider = "getTestData", groups = "basicOperations", priority = 3)
    public void testDivide(String arg1, String operation, String arg2, String expectedResult, String groups) {
        // Checking if the test belongs to the correct group
        if ("basicOperations".equals(groups)) {
            try {
                if ("division".equalsIgnoreCase(operation)) {
                    // Check for empty strings
                    if (arg1 == null || arg1.isEmpty() || arg2 == null || arg2.isEmpty()) {
                        System.out.println("Empty string found in test data. Skipping the test.");
                        return;
                    }

                    // Convert arguments to double
                    double num1 = Double.parseDouble(arg1);
                    double num2 = Double.parseDouble(arg2);

                    // Perform divide
                    double result = calculator.divide(num1, num2);

                    // Verify the result
                    double expected = Double.parseDouble(expectedResult);
                    double epsilon = 1e-10; // tolerance for floating-point comparison
                    Assert.assertEquals(result, expected,epsilon, "division operation result mismatch");

                    System.out.println("Test for division executed successfully.");
                }
            } catch (ArithmeticException e) {
                // Handling exceptions during the test execution
                System.out.println("NumberFormatException: Invalid numeric values provided in test data.");
            }
        }
    }

    @Test(dataProvider = "getTestData", groups = "advanceOperations", priority = 4)
    public void testSquareRoot(String arg1, String operation, String arg2, String expectedResult, String groups) {
        // Checking if the test belongs to the correct group
        if ("advanceOperations".equals(groups)) {
            try {
                if ("squareRoot".equalsIgnoreCase(operation)) {

                    // Convert arguments to double
                    double num1 = Double.parseDouble(arg1);
                    double result = calculator.squareRoot(num1);

                    double expected = Double.parseDouble(expectedResult);
                    double epsilon = 1e-10; // tolerance for floating-point comparison
                    Assert.assertEquals(result, expected,epsilon, "squareRoot operation result mismatch");

                    System.out.println("Test for squareRoot executed successfully.");
                }
            } catch (NumberFormatException e) {
                // Handling exceptions during the test execution
                System.out.println("NumberFormatException: Invalid numeric values provided in test data.");
            }
        }
    }

    @Test(dataProvider = "getTestData", groups = "advanceOperations", priority = 5)
    public void testPower(String arg1, String operation, String arg2, String expectedResult, String groups) {
        // Checking if the test belongs to the correct group
        if ("advanceOperations".equals(groups)) {
            try {

                if ("power".equalsIgnoreCase(operation)) {

                    if (arg1 == null || arg1.isEmpty() || arg2 == null || arg2.isEmpty()) {
                        System.out.println("Empty string found in test data. Skipping the test.");
                        return;
                    }

                    // Convert arguments to double
                    double num1 = Double.parseDouble(arg1);
                    double num2 = Double.parseDouble(arg2);

                    // Perform addition
                    double result = calculator.power(num1, num2);

                    // Verify the result
                    double expected = Double.parseDouble(expectedResult);
                    double epsilon = 1e-10; // tolerance for floating-point comparison
                    Assert.assertEquals(result, expected,epsilon, "power operation result mismatch");

                    System.out.println("Test for power executed successfully.");
                }
            } catch (NumberFormatException e) {
                // Handling exceptions during the test execution
                System.out.println("NumberFormatException: Invalid numeric values provided in test data.");
            }
        }
    }

    @Test(dataProvider = "getTestData", groups = "advanceOperations", priority = 6)
    public void testSinFunction(String arg1, String operation, String arg2, String expectedResult, String groups) {
        // Checking if the test belongs to the correct group
        if ("advanceOperations".equals(groups)) {
            try {
                // Perform addition operation
                if ("sin".equalsIgnoreCase(operation)) {

                    double num1 = Double.parseDouble(arg1);
                    double result = calculator.sin(num1);


                    double expected = Double.parseDouble(expectedResult);
                    double epsilon = 1e-10; // tolerance for floating-point comparison
                    Assert.assertEquals(result, expected,epsilon, "sin operation result mismatch");

                    System.out.println("Test for sin executed successfully.");
                }
            } catch (NumberFormatException e) {
                // Handling exceptions during the test execution
                System.out.println("NumberFormatException: Invalid numeric values provided in test data.");
            }
        }
    }



    @Test(dataProvider = "getTestData", groups = "advanceOperations", priority = 7)
    public void testCosFunction(String arg1, String operation, String arg2, String expectedResult, String groups) {
        // Checking if the test belongs to the correct group
        if ("advanceOperations".equals(groups)) {
            try {
                if ("cos".equalsIgnoreCase(operation)) {
                    // Convert arguments to double
                    double num1 = Double.parseDouble(arg1);
                    double result = calculator.cos(num1);

                    double expected = Double.parseDouble(expectedResult);
                    double epsilon = 1e-10; // tolerance for floating-point comparison
                    Assert.assertEquals(result, expected,epsilon, "cos operation result mismatch");

                    System.out.println("Test for cos executed successfully.");
                }
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException: Invalid numeric values provided in test data.");
            }
        }
    }

    @Test(dataProvider = "getTestData", groups = "advanceOperations", priority = 8)
    public void testTanFunction(String arg1, String operation, String arg2, String expectedResult, String groups) {
        // Checking if the test belongs to the correct group
        if ("advanceOperations".equals(groups)) {
            try {
                if ("tan".equalsIgnoreCase(operation)) {

                    // Convert arguments to double
                    double num1 = Double.parseDouble(arg1);

                    double result = calculator.tan(num1);

                    double expected = Double.parseDouble(expectedResult);
                    // tolerance for floating-point comparison
                    double epsilon = 1e-10;
                    Assert.assertEquals(result, expected,epsilon, "tan operation result mismatch");

                    System.out.println("Test for tan executed successfully.");
                }
            }catch (NumberFormatException e){
                System.out.println("NumberFormatException: Invalid numeric values provided in test data.");
            }
        }
    }
    @Test(dataProvider = "getTestData", groups = "basicOperations", priority = 9)
    public void testInvalidAddition(String arg1, String operation, String arg2, String expectedResult, String groups) {
        // Checking if the test belongs to the correct group
        if ("basicOperations".equals(groups)) {
            try {
                if ("invalidAddition".equalsIgnoreCase(operation)) {
                   if (arg1 == null || arg1.isEmpty() || arg2 == null || arg2.isEmpty()) {
                        System.out.println("Empty string found in test data. Skipping the test.");
                        return;
                    }

                    // Convert arguments to double
                    double num1 = Double.parseDouble(arg1);
                    double num2 = Double.parseDouble(arg2);

                    double result = calculator.add(num1, num2);

                    // Verify the result
                    double expected = Double.parseDouble(expectedResult);
                    double epsilon = 1e-10; // tolerance for floating-point comparison
                    Assert.assertEquals(result, expected,epsilon, "Invalid Number operation result mismatch");

                    System.out.println("Test for Invalid Number format executed successfully.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format");
            }
        }
    }
    @Test(dataProvider = "getTestData", groups = "basicOperations", priority = 9)
    public void testInvalidDivision(String arg1, String operation, String arg2, String expectedResult, String groups) {
        // Checking if the test belongs to the correct group
        if ("basicOperations".equals(groups)) {
            try {
                if ("invalidDivision".equalsIgnoreCase(operation)) {
                    // Check for empty strings
                    if (arg1 == null || arg1.isEmpty() || arg2 == null || arg2.isEmpty()) {
                        System.out.println("Empty string found in test data. Skipping the test.");
                        return;
                    }
                    double num1 = Double.parseDouble(arg1);
                    double num2 = Double.parseDouble(arg2);

                    double result = calculator.divide(num1, num2);

                    // Verify the result
                    double expected = Double.parseDouble(expectedResult);
                    double epsilon = 1e-10; // tolerance for floating-point comparison
                    Assert.assertEquals(result, expected,epsilon, "invalidDivision operation result mismatch");

                    System.out.println("Test for invalidDivision executed successfully.");
                }
            } catch (ArithmeticException e) {
                // Handling exceptions during the test execution
                System.out.println("Division By zero");
            }
        }
    }
}
