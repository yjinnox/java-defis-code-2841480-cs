public class Test {

  public static long getSuiteAudiActive(Long nombre) {
    if (nombre == 0) {
      throw new IllegalArgumentException("le nombre doit être supérieur à 0");
    }

    if (!isValid(nombre)) {
      throw new IllegalArgumentException(
          "le nombre ne doit pas être une série de plus 9 chiffres identiques consécutifs");
    }

    long result = 0;
    long temp = Math.abs(nombre);
    long lastNumber = temp % 10;
    long power100 = 1;
    int count = 1;

    do {
      temp /= 10;
      long number = temp % 10;
      if (number != lastNumber || temp == 0) {
        result += (10 * count + lastNumber) * power100;
        lastNumber = number;
        count = 0;
        power100 *= 100;
      }
      count++;
    } while (temp > 0);
    return result;
  }

  public static boolean isValid(long nombre) {
    long temp = Math.abs(nombre);
    int lastNumber = (int) (temp % 10);
    int compteur = 1;
    temp /= 10;
    while (temp > 0) {
      int actualNumber = (int) (temp % 10);
      if (actualNumber == lastNumber) {
        compteur++;
        if (compteur > 9) {
          return false;
        } else {
          lastNumber = actualNumber;
          compteur = 1;
        }
      }
      temp /= 10;
    }
    return true;
  }

  public static void main(String[] args) {
    long nombre = getSuiteAudiActive(3366578);
    System.out.println("Le résultat est :" + nombre);
  }

}
