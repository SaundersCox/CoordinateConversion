
public class PushMe {

	public static void main(String[] args) {
		
		Consume hungryBoy = new Consume("Todd");
		hungryBoy.tryConsume();
		hungryBoy.tryConsume(10);
		hungryBoy.tryConsume();
		hungryBoy.tryGather(10);
		hungryBoy.tryConsume(10);
	}
}
