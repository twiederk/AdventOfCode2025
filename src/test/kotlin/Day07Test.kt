import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day07Test {

    private val grid = listOf(
        ".......S.......",
        "...............",
        ".......^.......",
        "...............",
        "......^.^......",
        "...............",
        ".....^.^.^.....",
        "...............",
        "....^.^...^....",
        "...............",
        "...^.^...^.^...",
        "...............",
        "..^...^.....^..",
        "...............",
        ".^.^.^.^.^...^.",
        "...............",
    )

    @Test
    fun read_data() {
        // act
        val grid = Day07().readData("Day07_TestData.txt")

        // assert
        assertThat(grid).containsExactly(
            ".......S.......",
            "...............",
            ".......^.......",
            "...............",
            "......^.^......",
            "...............",
            ".....^.^.^.....",
            "...............",
            "....^.^...^....",
            "...............",
            "...^.^...^.^...",
            "...............",
            "..^...^.....^..",
            "...............",
            ".^.^.^.^.^...^.",
            "...............",
        )
    }

    @Test
    fun starting_position() {
        // act
        val startingPosition: Int = Day07().startingPosition(".......S.......")

        // assert
        assertThat(startingPosition).isEqualTo(7)
    }

    @Test
    fun downward_row_2() {
        // arrange
        val beams = setOf(7)

        // act
        val (result, splits) = Day07().downward(grid, beams, 2)

        // assert
        assertThat(result).containsExactly(6, 8)
        assertThat(splits).isEqualTo(1)
    }

    @Test
    fun downward_row_4() {
        // arrange
        val beams = setOf(6, 8)

        // act
        val (result, splits) = Day07().downward(grid, beams, 4)

        // assert
        assertThat(result).containsExactly(5, 7, 9)
        assertThat(splits).isEqualTo(2)
    }

    @Test
    fun downward_row_8() {
        // arrange
        val beams = setOf(4, 6, 8, 10)

        // act
        val (result, splits) = Day07().downward(grid, beams, 8)

        // assert
        assertThat(result).containsExactly(3, 5, 7, 8, 9, 11)
        assertThat(splits).isEqualTo(3)
    }

    @Test
    fun solve_part1() {
        // act
        val result: Int = Day07().part1(grid)

        // assert
        assertThat(result).isEqualTo(21)
    }

//    000000000011111
//    012345678901234
//    .......S.......
//    .......1.......  (7,1)
//    ......|^|......
//    ......1.1......  (6,1) (8,1)
//    .....|^|^|.....
//    .....1.2.1.....  (5,1) (7,2) (9,1)
//    ....|^|^|^|....
//    ....1.3.3.1....  (4,1) (6,3) (8,3) (10,1)
//    ....^.^...^....
//    ...1.4.331.1...  (3,1) (5,4) (7,3) (8,3) (9,1) (11,1)
//    ...^.^...^.^...
//    ..1.5.434.2.1..  (2,1) (4,5) (6,4) (7,3) (8,4) (10,2) (12,1)
//    ..^...^.....^..
//    .1.154.74.21.1.  (1,1) (3,1) (4,5) (5,4) (7,7) (8,4) (10,2) (11,1) (13,1)
//    .^.^.^.^.^...^.
//    1.2.1.1.1.211.1  (0,1) (2,2) (4,10) (6,11) (8,11) (10,2) (11,1) (12,1) (14,1)
//        0 1 1
//
//    1+2+10+11+11+2+1+1+1=40

    @Test
    fun downwardTimeline_row_2() {
        // arrange
        val beams = mapOf(7 to 1L)

        // act
        val result = Day07().downwardTimeline(grid, beams, 2)

        // assert
        assertThat(result).hasSize(2)
        assertThat(result[6]).isEqualTo(1)
        assertThat(result[8]).isEqualTo(1)
    }


    @Test
    fun solve_part2() {
//        // act
//        val result: Int = Day07().part2(grid)
//
//        // assert
//        assertThat(result).isEqualTo(40)
    }

}