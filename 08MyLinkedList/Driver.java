public class Driver{
    public static void main(String[] args){
		MyLinkedList<String> a = new MyLinkedList<String>();
		a.add("a");
		a.add("bjlksajdlkasjdl");
		a.add("c");
		a.add("d");
		a.add("e");
		for (int i = 1;i < 10 ;i = i + 2 ) {
			a.add(i,"z");
		}
		

		
System.out.println(a.size);
		System.out.println(a.size());
		System.out.println(a);

    }
}
