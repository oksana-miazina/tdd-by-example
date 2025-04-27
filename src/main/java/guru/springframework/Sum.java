package guru.springframework;

public class Sum implements Expression {
    final Expression augmend;
    final Expression addmend;

    public Sum(Expression addmend, Expression augmend) {
        this.addmend = addmend;
        this.augmend = augmend;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = augmend.reduce(bank, to).amount + addmend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression added) {
        return new Sum(this, added);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augmend.times(multiplier), addmend.times(multiplier));
    }
}
