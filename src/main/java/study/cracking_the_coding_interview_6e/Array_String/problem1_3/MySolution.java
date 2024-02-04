package study.cracking_the_coding_interview_6e.array_string.problem1_3;

public class MySolution {

    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        String result1 = mySolution.replaceBlank("Mr John Smith", 13);
        System.out.println(result1);
    }

    public String replaceBlank(String str, long size) {
        String delimiter = "%20";
        return str.replaceAll(" ", delimiter);
    }
}
