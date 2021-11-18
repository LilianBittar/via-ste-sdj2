import java.util.ArrayList;
public class Queue implements StringQueue{
    private ArrayList<String> arrayList;
    public Queue (int cap){
      arrayList = new ArrayList<>(cap);}
    @Override
    public void enqueue(String element) {
      arrayList.add(element);}
    @Override
    public String dequeue() {
       return arrayList.remove(0);}
    @Override
    public String first() {
        return arrayList.get(0);}
    @Override
    public int size() {
        return arrayList.size();}
    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();}
    @Override
    public int indexOf(String element) {
        return arrayList.indexOf(element);}
    @Override
    public boolean contains(String element) {
        return arrayList.contains(element);}
    @Override
    public String toString() {
        String element = "";
        for (int i = 0; i < arrayList.size(); i++) {
             element += arrayList.get(i);}
        return element;}
}
