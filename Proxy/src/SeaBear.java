public class SeaBear implements VisitSeaBear{
    public SeaBear(){
    }
    @Override
    public void view(String personType) {
        System.out.println("a " + personType + " is viewing the seabear");}
    @Override
    public void feed(String personType) {
        System.out.println("a " + personType + " is feeding the seabear");}
    @Override
    public void pet(String personType) {
        System.out.println("a " + personType + " is petting the seabear");}
}
