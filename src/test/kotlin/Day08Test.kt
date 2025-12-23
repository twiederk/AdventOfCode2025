import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.sqrt

class Day08Test  {

    @Test
    fun read_data() {
        // act
        val data = Day08().readData("Day08_TestData.txt")

        // assert
        assertThat(data).containsExactly(
            Point3D(162,817,812),
            Point3D(57,618,57),
            Point3D(906,360,560),
            Point3D(592,479,940),
            Point3D(352,342,300),
            Point3D(466,668,158),
            Point3D(542,29,236),
            Point3D(431,825,988),
            Point3D(739,650,466),
            Point3D(52,470,668),
            Point3D(216,146,977),
            Point3D(819,987,18),
            Point3D(117,168,530),
            Point3D(805,96,715),
            Point3D(346,949,466),
            Point3D(970,615,88),
            Point3D(941,993,340),
            Point3D(862,61,35),
            Point3D(984,92,344),
            Point3D(425,690,689),
        )
    }

    @Test
    fun straightLineDistance() {

        // act
        val distance = Point3D(0,0,0).straightLineDistance(Point3D(3,3,3))

        // assert
        val expected = sqrt((3 * 3 + 3 * 3 + 3 * 3).toDouble())
        assertThat(distance).isEqualTo(expected)
    }

}