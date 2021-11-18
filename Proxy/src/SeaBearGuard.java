public class SeaBearGuard implements VisitSeaBear{
    //proxy class
    private SeaBear seaBear;
    public SeaBearGuard(SeaBear seaBear){
        this.seaBear = seaBear;
    }
    @Override
    public void view(String personType) {
        if(personType.equals("child") || personType.equals("adult") || personType.equals("zooKeeper")){
            //delegating to the seabear class
            seaBear.view(personType);}}
    @Override
    public void feed(String personType) {
       if (personType.equals("zooKeeper")){
           seaBear.feed(personType);}
       else {System.out.println("you can not feed the seaBear");}}
    @Override
    public void pet(String personType) {
        if (personType.equals("child")){
            seaBear.pet(personType);}
        else {System.out.println("you can not pet the seaBear");}}
}
