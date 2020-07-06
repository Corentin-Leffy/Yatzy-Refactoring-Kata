import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.ints.shouldBeExactly

class YatzyTest : StringSpec({

    "chance_scores_sum_of_all_dice" {
        val expected = 15
        val actual = Yatzy.chance(2, 3, 4, 5, 1)
        actual shouldBeExactly expected
        Yatzy.chance(3, 3, 4, 5, 1) shouldBeExactly 16
    }

    "yatzy_scores_50" {
        val expected = 50
        val actual = Yatzy.yatzy(4, 4, 4, 4, 4)
        actual shouldBeExactly expected
        Yatzy.yatzy(6, 6, 6, 6, 6) shouldBeExactly 50
        Yatzy.yatzy(6, 6, 6, 6, 3) shouldBeExactly 0
    }

    "test_1s" {
        (Yatzy.ones(1, 2, 3, 4, 5) == 1).shouldBeTrue()
        Yatzy.ones(1, 2, 1, 4, 5) shouldBeExactly 2
        Yatzy.ones(6, 2, 2, 4, 5) shouldBeExactly 0
        Yatzy.ones(1, 2, 1, 1, 1) shouldBeExactly 4
    }

    "test_2s" {
        Yatzy.twos(1, 2, 3, 2, 6) shouldBeExactly 4
        Yatzy.twos(2, 2, 2, 2, 2) shouldBeExactly 10
    }

    "test_threes" {
        Yatzy.threes(1, 2, 3, 2, 3) shouldBeExactly 6
        Yatzy.threes(2, 3, 3, 3, 3) shouldBeExactly 12
    }

    "fours_test" {
        Yatzy(4, 4, 4, 5, 5).fours() shouldBeExactly 12
        Yatzy(4, 4, 5, 5, 5).fours() shouldBeExactly 8
        Yatzy(4, 5, 5, 5, 5).fours() shouldBeExactly 4
    }

    "fives" {
        Yatzy(4, 4, 4, 5, 5).fives() shouldBeExactly 10
        Yatzy(4, 4, 5, 5, 5).fives() shouldBeExactly 15
        Yatzy(4, 5, 5, 5, 5).fives() shouldBeExactly 20
    }

    "sixes_test" {
        Yatzy(4, 4, 4, 5, 5).sixes() shouldBeExactly 0
        Yatzy(4, 4, 6, 5, 5).sixes() shouldBeExactly 6
        Yatzy(6, 5, 6, 6, 5).sixes() shouldBeExactly 18
    }

    "one_pair" {
        Yatzy.score_pair(3, 4, 3, 5, 6) shouldBeExactly 6
        Yatzy.score_pair(5, 3, 3, 3, 5) shouldBeExactly 10
        Yatzy.score_pair(5, 3, 6, 6, 5) shouldBeExactly 12
    }

    "two_Pair" {
        Yatzy.two_pair(3, 3, 5, 4, 5) shouldBeExactly 16
        Yatzy.two_pair(3, 3, 5, 5, 5) shouldBeExactly 16
    }

    "three_of_a_kind" {
        Yatzy.three_of_a_kind(3, 3, 3, 4, 5) shouldBeExactly 9
        Yatzy.three_of_a_kind(5, 3, 5, 4, 5) shouldBeExactly 15
        Yatzy.three_of_a_kind(3, 3, 3, 3, 5) shouldBeExactly 9
    }

    "four_of_a_kind" {
        Yatzy.four_of_a_kind(3, 3, 3, 3, 5) shouldBeExactly 12
        Yatzy.four_of_a_kind(5, 5, 5, 4, 5) shouldBeExactly 20
        Yatzy.three_of_a_kind(3, 3, 3, 3, 3) shouldBeExactly 9
    }

    "smallStraight" {
        Yatzy.smallStraight(1, 2, 3, 4, 5) shouldBeExactly 15
        Yatzy.smallStraight(2, 3, 4, 5, 1) shouldBeExactly 15
        Yatzy.smallStraight(1, 2, 2, 4, 5) shouldBeExactly 0
    }

    "largeStraight" {
        Yatzy.largeStraight(6, 2, 3, 4, 5) shouldBeExactly 20
        Yatzy.largeStraight(2, 3, 4, 5, 6) shouldBeExactly 20
        Yatzy.largeStraight(1, 2, 2, 4, 5) shouldBeExactly 0
    }

    "fullHouse" {
        Yatzy.fullHouse(6, 2, 2, 2, 6) shouldBeExactly 18
        Yatzy.fullHouse(2, 3, 4, 5, 6) shouldBeExactly 0
    }
})
