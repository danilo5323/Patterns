package comportamental.strategy;

import java.util.Scanner;

public class Exec {
  public static void main(String[] args) {

    for (;;) {
      Scanner entrada = new Scanner(System.in);
      int indice = entrada.nextInt();
      int calc = entrada.nextInt();
      Calc proc = null;
      try {
        proc = Calc.values()[indice - 1];
      } catch (ArrayIndexOutOfBoundsException ex) {
        System.out.println("produto nao cadastrado");
        break;
      }
      ;
      String strout = String.valueOf(proc.getStrategyCalc().calcula(calc));
      System.out.println(strout);
    }
  }
}

enum Calc {

  SEDEX(new CalcSedex()), NORMAL(b -> b * 6.0), PAC(new StrategyCalc() {
    @Override
    public double calcula(double input) {
      return input * 7.0;
    }
  });

  StrategyCalc strategy;

  Calc(StrategyCalc str) {
    strategy = str;
  }

  public StrategyCalc getStrategyCalc() {
    return strategy;
  }
}

@FunctionalInterface
interface StrategyCalc {
  public double calcula(double input);
}

class CalcSedex implements StrategyCalc {
  @Override
  public double calcula(double input) {
    return input * 5.0;
  }
}