package kamoun.kata

import org.scalatest.{FlatSpec, Matchers}

import scala.util.{Failure, Success}

/**
  * @author Ahmed KAMOUN
  */
class RomanNumberTest extends FlatSpec with Matchers {


  "RomanNumber#unitesRomain" should "return IV for 4" in {
    RomanNumber.romanUnitsNumber(4) should equal(Success("IV"))
  }
  it should "return VI for 6" in {
    RomanNumber.romanUnitsNumber(6) should equal(Success("VI"))
  }
  it should "return IX for 9" in {
    RomanNumber.romanUnitsNumber(9) should equal(Success("IX"))
  }

  "RomanNumber#dizainesRomain" should "return X for 1" in {
    RomanNumber.romanTensNumber(1) should equal(Success("X"))
  }
  it should "return XXX for 3" in {
    RomanNumber.romanTensNumber(3) should equal(Success("XXX"))
  }
  it should "return XL for 4" in {
    RomanNumber.romanTensNumber(4) should equal(Success("XL"))
  }
  it should "return XC for 9" in {
    RomanNumber.romanTensNumber(9) should equal(Success("XC"))
  }

  "RomanNumber#centainesRomain" should "return C for 1" in {
    RomanNumber.romanHundredsNumber(1) should equal(Success("C"))
  }
  it should "return CCC for 3" in {
    RomanNumber.romanHundredsNumber(3) should equal(Success("CCC"))
  }
  it should "return CD for 4" in {
    RomanNumber.romanHundredsNumber(4) should equal(Success("CD"))
  }
  it should "return CM for 9" in {
    RomanNumber.romanHundredsNumber(9) should equal(Success("CM"))
  }

  "RomanNumber#convert" should "return empty-string for integer <= 0 or > 3000 " in {
    //DSL for expressing assertion
    RomanNumber.convert(0) shouldBe an[Failure[_]]
    RomanNumber.convert(-20) shouldBe an[Failure[_]]

    // RomanNumber.convert(4000) should equal(Failure)
    assert(RomanNumber.convert(4000).isFailure)
    assertResult(true) {
      RomanNumber.convert(4000).isFailure
    }

  }
  it should "return I for 1" in {
    RomanNumber.convert(1) should equal(Success("I"))
  }
  it should "return V for 5" in {
    RomanNumber.convert(5) should equal(Success("V"))
  }
  it should "return X for 10" in {
    RomanNumber.convert(10) should equal(Success("X"))
  }
  it should "return L for 50" in {
    RomanNumber.convert(50) should equal(Success("L"))
  }
  it should "return C for 100" in {
    RomanNumber.convert(100) should equal(Success("C"))
  }
  it should "return D for 500" in {
    RomanNumber.convert(500) should equal(Success("D"))
  }
  it should "return M for 1000" in {
    RomanNumber.convert(1000) should equal(Success("M"))
  }
  it should "return XI for 11" in {
    RomanNumber.convert(11) should equal(Success("XI"))
  }
  it should "return XLIV for 44" in {
    RomanNumber.convert(44) should equal(Success("XLIV"))
  }
  it should "return LXXIII for 73" in {
    RomanNumber.convert(73) should equal(Success("LXXIII"))
  }
}
