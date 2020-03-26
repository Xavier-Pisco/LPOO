public class StringReplacer implements StringTransformer {
    private char previousChar, newChar;

    public StringReplacer(char previousChar, char newChar) {
        this.previousChar = previousChar;
        this.newChar = newChar;
    }

    @Override
    public void execute(StringDrink drink) {
        String text = drink.getText();
        text = text.replace(previousChar,newChar);
        drink.setText(text);
    }

    @Override
    public void undo(StringDrink drink) {
        String text = drink.getText();
        text = text.replace(newChar, previousChar);
        drink.setText(text);
    }
}
