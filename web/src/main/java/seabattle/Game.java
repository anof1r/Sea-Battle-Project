package seabattle;

import java.security.Principal;

public class Game {
    public char [][] field ;
    private Principal player1Cross;
    private Principal player2Circle;
    public int turnOrder = 1;

    public Game(Principal p1, Principal p2){
        this.player1Cross = p1;
        this.player2Circle = p2;
        this.field = new char[][]{{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
    }

    public char[][] turn(Principal player, int x, int y) {
        if (this.turnOrder == 1 && player.getName() == this.player1Cross.getName()) {
            this.field[x][y] = 'X';
            this.turnOrder = 2;
        } else if (this.turnOrder == 2 && player.getName() == this.player2Circle.getName()) {
            this.field[x][y] = 'O';
            this.turnOrder = 1;
        }
        return this.field;
    }

    public boolean checkTurnOrder(Principal player){
        if (this.turnOrder == 1 && player.getName() == this.player1Cross.getName()) {
            return true;
        }
        else if (this.turnOrder == 2 && player.getName() == this.player2Circle.getName()) {
            return true;
        }
        return false;
    }
}
