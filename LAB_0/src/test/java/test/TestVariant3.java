package test;

import static org.testng.Assert.assertEquals;

import lab0.Variant3;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class TestVariant3 {

    private final Variant3 var = new Variant3();

    // 1. Перетворення розміру файлу в кілобайти
    @Test(dataProvider = "integerProvider")
    public void testIntegerNumbersTask(int sizeInBytes, int expectedKilobytes) {
        assertEquals(var.integerNumbersTask(sizeInBytes), expectedKilobytes);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][]{
                {1000, 0},
                {2048, 2},
                {10240, 10}
        };
    }

    // 2. Перевірка, чи є число парним
    @Test(dataProvider = "booleanProvider")
    public void testBooleanTask(int A, boolean isEven) {
        assertEquals(var.booleanTask(A), isEven);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][]{
                {2, true},
                {3, false},
                {0, true}
        };
    }

    // 3. Перетворення числа залежно від його значення
    @Test(dataProvider = "ifProvider")
    public void testIfTask(int number, int expectedResult) {
        assertEquals(var.ifTask(number), expectedResult);
    }

    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][]{
                {1, 2},
                {-1, -3},
                {0, 10}
        };
    }

    // 4. Визначення пори року за номером місяця
    @Test(dataProvider = "switchProvider")
    public void testSwitchTask(int month, String expectedSeason) {
        assertEquals(var.switchTask(month), expectedSeason);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][]{
                {1, "зима"},
                {4, "весна"},
                {8, "літо"},
                {10, "осінь"}
        };
    }

    // 5. Виведення чисел у порядку спадання між двома заданими числами
    @Test(dataProvider = "forProvider")
    public void testForTask(int A, int B, List<Integer> expectedList) {
        assertEquals(var.forTask(A, B), expectedList);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][]{
                {1, 5, List.of(4, 3, 2)},
                {2, 8, List.of(7, 6, 5, 4, 3)}
        };
    }

    // 6. Ділення з залишком
    @Test(dataProvider = "whileProvider")
    public void testWhileTask(int N, int K, int[] expectedResult) {
        assertEquals(var.whileTask(N, K), expectedResult);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][]{
                {10, 3, new int[]{3, 1}},
                {15, 5, new int[]{3, 0}}
        };
    }

    // 7. Формування арифметичної прогресії
    @Test(dataProvider = "arrayProvider")
    public void testArrayTask(int N, int A, int D, int[] expectedArray) {
        assertEquals(var.arrayTask(N, A, D), expectedArray);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][]{
                {5, 1, 2, new int[]{1, 3, 5, 7, 9}}
        };
    }

    // 8. Створення матриці з повторюваними стовпцями
    @Test(dataProvider = "matrixProvider")
    public void testTwoDimensionArrayTask(int[] MValues, int M, int N, int[][] expectedMatrix) {
        assertEquals(var.twoDimensionArrayTask(MValues, M, N), expectedMatrix);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        return new Object[][]{
                {new int[]{1, 2, 3}, 3, 3, new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}}}
        };
    }
}
