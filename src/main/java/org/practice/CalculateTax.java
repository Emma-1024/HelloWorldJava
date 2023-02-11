package org.practice;

// oop-polymorphic
public class CalculateTax {
    public static void main(String[] args) {
        Income[] incomes = new Income[]{
                new Income(3000.0), new Salary(7000.0),
                new StateCouncilSpecialAllowance(15000.0), new RoyaltyIncome(20000.0)
        };
        System.out.println(Math.floor(totalTax(incomes)));
    }

    public static double totalTax(Income... incomes) {
        double total = 0;
        for (Income income : incomes) {
            total = total + income.getTax();
        }
        return total;
    }
}

class Income {
    protected double income;

    public Income(Double income) {
        this.income = income;
    }

    public double getTax() {
        return income * 0.1;
    }
}

class Salary extends Income {
    public Salary(Double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (income <= 5000) {
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}

class StateCouncilSpecialAllowance extends Income {
    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return 0;
    }
}

class RoyaltyIncome extends Income {
    public RoyaltyIncome(Double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return income * 0.14;
    }
}
