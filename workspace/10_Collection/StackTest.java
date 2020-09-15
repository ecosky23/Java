import java.util.Stack;
import static java.lang.System.out;
class StackTest{
	public static void main(String[] args){
		String[] groupA = {"우주베키스탄","쿠웨이트","사우디","대한민국"};
		Stack<String> stack = new Stack<String>();

		for(int i = 0; i<groupA.length; i++)
			stack.push(groupA[i]);//스택에 그룹을 내용 넣기

		while(! stack.isEmpty())//스택이 비었나?
			out.println(stack.pop());//스택내용 출력
		
		}
}
