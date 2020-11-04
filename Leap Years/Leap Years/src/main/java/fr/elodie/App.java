package fr.elodie;

/**
 * Hello world!
 */
 public final class App {

    public static boolean leapYearTest(int anneeTestee) {

        if (anneeTestee % 4 == 0) {
            if (anneeTestee % 400 == 0) {
                if (anneeTestee % 100 == 0)
                    return true;
                else
                    return false;
            } else
                return true;
        } else {
            return false;
        }
    }

 
 
 public static String fooBarQix(int chiffreTeste) {
    String resultat = "";
    if (chiffreTeste % 3 == 0) {
      resultat += "Foo";
    }
    if (chiffreTeste % 5 == 0) {
      resultat += "Bar";
    }
    if (chiffreTeste % 7 == 0) {
      resultat += "Qix";
    }

    int number = chiffreTeste;
    int puissance = (int) Math.pow(
      10,
      String.valueOf(chiffreTeste).length() - 1
    );

    if (chiffreTeste > 10) {
      number = chiffreTeste / puissance % 10;
    }

    while (puissance > 0) {
      if (number == 5) {
        resultat += "Bar";
      } else if (number == 7) {
        resultat += "Qix";
      } else if (number == 3) {
        resultat += "Foo";
      } else if (number == 0) {
        resultat += "*";
      }
      if (chiffreTeste > 10 && puissance >= 10) {
        puissance /= 10;
        number = chiffreTeste / puissance % 10;
      } else {
        break;
      }
    }

    if (resultat == "") {
      return Integer.toString(chiffreTeste);
    } else {
      return resultat;
    }
  }
}




public static String numberToText(int number) {
        String resultat = "";

        String[] chiffresTexteAvantDix = new String[] { "", "one", "two", "three", "four", "five", "six", "seven",
                "eight", "nine" };
        String[] chiffresPremiereDizaine = new String[] { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen" };
        String[] chiffresDizaineFrom20 = new String[] { "", "", "twenty", "thirty", "forty", "fifty", "sixty",
                "seventy", "eighty", "ninety" };
        String[] grandsNombres = new String[] { "hundred", "thousand", "million", "billion", "trillion", "quadrillon" };

        if (number == 0) {
            resultat = "zero";
        } else if (number < 10 && number >= 0) {
            resultat = chiffresTexteAvantDix[number];
        } else if (number >= 10 && number < 20) {
            resultat = chiffresPremiereDizaine[number - 10];
        } else if (number >= 20) {

            int puissance = (int) Math.pow(10, String.valueOf(number).length() - 1);
            int longueurNombre = number / puissance % 10;
            while (puissance > 0) {

                int indice = 0;
                int chiffreduRang = number / puissance % 10;
                int rang = (int) Math.log10(puissance) + 1;
                int chiffreSuivant = 0;
                int chiffrePrecedent = -1;

                if (rang < longueurNombre) {
                    chiffrePrecedent = number / (puissance * 10) % 10;
                }
                if (rang > 1) {
                    chiffreSuivant = number / (puissance / 10) % 10;
                }

                // centaine des groupes de 3 digits avec modulo 3 égale zéro (rang 3, 6, 9)

                if (rang % 3 == 0 || chiffrePrecedent > 0 || chiffrePrecedent == -1) {
                    resultat += chiffresTexteAvantDix[chiffreduRang] + " ";
                    resultat += grandsNombres[0];
                }

                // dizaine de groupe de 3 digits avec modulo 3 = 1 (rang 2, 5, 8, 11)
                if (rang % 3 == 2 && chiffreduRang != 1) {
                    resultat += chiffresDizaineFrom20[chiffreduRang];
                }
                // dizaine de groupe de 3 digits avec modulo 3 = 2 avec adaptation du chiffre 1
                if (rang % 3 == 2 && chiffreduRang == 1) {

                    if (chiffreSuivant == 0) {
                        resultat += "ten";
                    } else {
                        resultat += chiffresPremiereDizaine[chiffreSuivant];
                    }
                }
                // unité de chaque groupe de 3 digits
                if (rang % 3 == 1 && chiffrePrecedent != 0 && chiffreduRang != 0) {
                    resultat += "-";
                }

                if (rang % 3 == 1 && indice != 0 && chiffrePrecedent == 0 && chiffreduRang != 0) {
                    System.out.println(chiffrePrecedent);
                    resultat += "and";
                }

                if (rang % 3 == 1) {
                    resultat += chiffresTexteAvantDix[chiffreduRang];
                }

                if (rang > 3 && rang % 3 == 1) {
                    resultat += grandsNombres[rang / 3] + " ";
                }
                indice++;
                puissance /= 10;

                // resultat2 = length + " " + resultat;
            }

        }

        System.out.println(resultat);
        return resultat;

    }

    public static String CodeCracker(String mot) {
        mot.toLowerCase();//en minuscule
        char[] motTransformeEnTableauChar = mot.toCharArray();
        char[] alphabetNormal = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        char[] encryptionKey = new char[] { '!', ')', '\"', '(', '£', '*', '%', '&', '>', '<', '@', 'a', 'b', 'c', 'd',
                'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o' };

        for (int j = 0; j < motTransformeEnTableauChar.length; j++) {
            for (int i = 0; i < 25; i++) {
                if (alphabetNormal[i] == motTransformeEnTableauChar[j]) {
                    motTransformeEnTableauChar[j] = encryptionKey[i];
                }

            }

        }
        String motConverti = new String(motTransformeEnTableauChar);
        return motConverti;
    }
    