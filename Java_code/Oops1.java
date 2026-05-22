public class Oops1{
    public static void main(String args[]){
       Queen q1 = new Queen();
       q1.moves() ;

       Bear b = new Bear();
       b.eats();

       Horse h1 = new Horse();
     }
}

interface ChessPlayer {
    void moves();
}

class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("up,down,left,right,diagonl(in all direction)");
    }
}
class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("up,down,left,right");
    }
}

//Multple Inheritance:-
interface Hervivour{
    void eats();
    
}
interface Carnivore{
    void eats();
}
class Bear implements Carnivore,Hervivour{
    public void eats(){
        System.out.println("eats both");
    }
}

//Learning to use super keyword:-
class Animal{
    Animal(){
        System.out.println("Animal constructor is called");
    }
}
class Horse extends Animal{
    Horse(){
        super();//it will call the animal class also
        System.out.println("Horse constructor is called");
    }
}