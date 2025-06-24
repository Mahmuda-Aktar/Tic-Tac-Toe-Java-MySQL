public class TicTacToePlayer{
    String name;
    char symbol;
    public TicTacToePlayer(String name,char symbol) {
        this.name = name;
        this.symbol=symbol;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }

}