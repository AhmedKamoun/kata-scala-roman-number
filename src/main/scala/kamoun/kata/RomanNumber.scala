package kamoun.kata

import scala.util.{Failure, Success, Try}

/**
  * @author Ahmed KAMOUN
  */
object RomanNumber {
  def convert(i: Int): Try[String] = {
    i match {
      case x if (x <= 0) || (x > 3999) => Failure(new RuntimeException("invalid number"))
      case _ => {
        //x = a * 1000 + b * 100 + c * 10 + d * 1
        for {
          romanUnits <- RomanNumber.romanUnitsNumber(i % 10)
          romanTends <- RomanNumber.romanTensNumber((i % 100) / 10)
          romanHundred <- RomanNumber.romanHundredsNumber((i % 1000) / 100)
          romanThousands <- RomanNumber.romanThousandsNumber((i / 1000))
        }
          yield
            s"$romanThousands$romanHundred$romanTends$romanUnits"

      }


    }
  }


  def romanUnitsNumber(i: Int): Try[String] = {
    i match {
      case 1 => Success("I")
      case 2 => Success("II")
      case 3 => Success("III")
      case 4 => Success("IV")
      case 5 => Success("V")
      case 6 => Success("VI")
      case 7 => Success("VII")
      case 8 => Success("VIII")
      case 9 => Success("IX")
      case 0 => Success("")
      case _ => Failure(new RuntimeException("invalid number of units"))
    }
  }

  def romanTensNumber(i: Int): Try[String] = {
    i match {
      case 1 => Success("X")
      case 2 => Success("XX")
      case 3 => Success("XXX")
      case 4 => Success("XL")
      case 5 => Success("L")
      case 6 => Success("LX")
      case 7 => Success("LXX")
      case 8 => Success("LXXX")
      case 9 => Success("XC")
      case 0 => Success("")
      case _ => Failure(new RuntimeException("invalid number of tens"))
    }
  }

  def romanHundredsNumber(i: Int): Try[String] = {
    i match {
      case 1 => Success("C")
      case 2 => Success("CC")
      case 3 => Success("CCC")
      case 4 => Success("CD")
      case 5 => Success("D")
      case 6 => Success("DC")
      case 7 => Success("DCC")
      case 8 => Success("DCCC")
      case 9 => Success("CM")
      case 0 => Success("")
      case _ => Failure(new RuntimeException("invalid number of hundreds"))
    }
  }

  def romanThousandsNumber(i: Int): Try[String] = {
    i match {
      case 1 => Success("M")
      case 2 => Success("MM")
      case 3 => Success("MMM")
      case 0 => Success("")
      case _ => Failure(new RuntimeException("invalid number of thousands"))
    }
  }
}
