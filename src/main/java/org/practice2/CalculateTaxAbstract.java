package org.practice2;

// oop-polymorphic
public class CalculateTaxAbstract {
    public static void main(String[] args) {
        Income[] incomes = new Income[]{
                new Salary(7000.0),
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

interface Income {
    double getTax();
}

class Salary implements Income {
    private Double income;
    public Salary(Double income) {
        this.income = income;
    }

    @Override
    public double getTax() {
        if (income <= 5000) {
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}

class StateCouncilSpecialAllowance implements Income {
    private Double income;
    public StateCouncilSpecialAllowance(double income) {
        this.income = income;
    }

    @Override
    public double getTax() {
        return 0;
    }
}

class RoyaltyIncome implements Income {
    private Double income;
    public RoyaltyIncome(Double income) {
        this.income = income;
    }

    @Override
    public double getTax() {
        return income * 0.14;
    }
}
