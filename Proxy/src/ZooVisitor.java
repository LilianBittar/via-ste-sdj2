public class ZooVisitor {
    private VisitSeaBear visitSeaBear;
    private String personType;

    public ZooVisitor(VisitSeaBear visitSeaBear, String personType){
        this.visitSeaBear = visitSeaBear;
        this.personType = personType;
    }
    public void view(){
        visitSeaBear.view(personType);
    }
    public void feed(){
        visitSeaBear.feed(personType);
    }
    public void pet(){
        visitSeaBear.pet(personType);
    }
}
