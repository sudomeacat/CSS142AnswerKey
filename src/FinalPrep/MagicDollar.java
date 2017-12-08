package FinalPrep;

import java.math.BigDecimal;

public class MagicDollar {
    public static void main(String[] args) {
        BigDecimal moneys = new BigDecimal(1.0);
        //double money = 1.0;
        for (int i = 0; i <= 1000000; i++) {
            moneys = moneys.divide(new BigDecimal(2)).add(new BigDecimal(1)).add(moneys);
            //money = money + (1 + money/2);
            //System.out.println(moneys);
            //System.out.println(money);
        }
        System.out.println(moneys.toString().substring(0, moneys.toString().indexOf('.')+3));
    }
}

// out.printf("%3.0d", fullStatsOne[1]);
// System.out.printf("%3.2%f", fullStatsOne[i]);