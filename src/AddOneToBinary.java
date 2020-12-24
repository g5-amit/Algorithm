public class AddOneToBinary {

    public String addOneToBinary(StringBuilder sb){
        int carry =1;
        int strLen = sb.length();
        for(int i=strLen-1; i>0; i--){
            carry+= sb.charAt(i)-'0';
            sb.setCharAt(i,(char)(carry%2 + '0'));
            carry = carry/2;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        AddOneToBinary ob = new AddOneToBinary();
        String out = ob.addOneToBinary(new StringBuilder("11111111111111111111111111111110"));
        System.out.print(out);
    }
}
