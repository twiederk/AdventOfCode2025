import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class Day12Test {

    private val shapes = listOf(7, 7, 7, 7, 7, 7)

    @Test
    fun read_shapes() {
        // act
        val result = Day12.readShapes("Day12_TestData.txt")

        // assert
        assertThat(result).isEqualTo(shapes)
    }

    @Test
    fun read_regions() {
        // act
        val shapes = Day12.readRegions("Day12_TestData.txt")

        // assert
        assertThat(shapes).isEqualTo(listOf(
            Region(16, listOf(0, 0, 0, 0, 2, 0)),
            Region(60, listOf(1, 0, 1, 0, 2, 2)),
            Region(60, listOf(1, 0, 1, 0, 3, 2)),
        ))
    }

    @Test
    fun example_1() {
        // arrange
        // 4x4: 0 0 0 0 2 0
        val region = Region(16, listOf(0, 0, 0, 0, 2, 0))

        // act
        val result = Day12(shapes).fit(region)

        // assert
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun example_2() {
        // arrange
        //12x5: 1 0 1 0 2 2
        val region = Region(60, listOf(1, 0, 1, 0, 2, 2))

        // act
        val result = Day12(shapes).fit(region)

        // assert
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun example_3() {
        // arrange
        //12x5: 1 0 1 0 3 2

        val region = Region(60, listOf(1, 0, 1, 0, 3, 2))

        // act
        val result = Day12(shapes).fit(region)

        // assert
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun solve_part1() {
        // arrange
        val regions = listOf(
            Region(16, listOf(0, 0, 0, 0, 2, 0)),
            Region(60, listOf(1, 0, 1, 0, 2, 2)),
            Region(60, listOf(1, 0, 1, 0, 3, 2))
        )

        // act
        val result = Day12(shapes).part1(regions)

        // assert
        assertThat(result).isEqualTo(3)


    }
}

