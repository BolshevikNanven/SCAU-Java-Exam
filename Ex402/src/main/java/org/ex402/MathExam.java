package org.ex402;

import java.util.Random;

public class MathExam {
    private Integer number1, number2;
    private Integer answer;

    public MathExam(Integer max, Integer min) {
        Random random = new Random();

        this.number1 = random.nextInt(min + 1) + (max - min);
        this.number2 = random.nextInt(min + 1) + (max - min);
        this.answer=number1+number2;

    }

    public Integer getNumber1() {
        return number1;
    }

    public Integer getNumber2() {
        return number2;
    }

    public Integer getAnswer() {
        return answer;
    }
}
