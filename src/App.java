
public class App {
    public static void main(String[] args) throws Exception {
        HashMap<String,String> testHashMap = new HashMap<String,String>(); 

        testHashMap.put("Vitaliy", "dkjf");
        testHashMap.put("mmm","msod");
        testHashMap.put("993842","dfdfg");
        System.out.println(testHashMap.size());
        System.out.println(testHashMap.keySet());
        System.out.println(testHashMap.values());
        testHashMap.display();
        testHashMap.remove("Vitaliy");
        testHashMap.display();
        testHashMap.clear();
        testHashMap.display();
        System.out.println(testHashMap.isEmpty());
        System.out.println(testHashMap.keySet());
    }
}


