public class StringInverter implements  StringTransformer{


    @Override
    public void execute(StringDrink drink) {
        StringBuffer drinkBuffer = new StringBuffer(drink.getText());
        drinkBuffer.reverse();
        drink.setText(drinkBuffer.toString());
    }

    @Override
    public void undo(StringDrink drink) {
        StringBuffer drinkBuffer = new StringBuffer(drink.getText());
        drinkBuffer.reverse();
        drink.setText(drinkBuffer.toString());
    }
}
