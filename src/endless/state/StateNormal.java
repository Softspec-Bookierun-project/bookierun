package endless.state;

import endless.model.Player;

public class StateNormal extends State{

	public StateNormal(Player player) {
		super(player);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void pressJump() {
		player.setJumpSpeed(600);
		player.setJumpTime(System.currentTimeMillis());
		player.setJumpY(player.getY());
		
		StateJumpOne fir = new StateJumpOne(player);
		player.setState(fir);
	}

	@Override
	public void pressCrawl() {
		player.setHeight(Player.CRAWL_HEIGHT);
		StateCrawl cra = new StateCrawl(player);
		player.setState(cra);
	}
	
	@Override
	public void update() {
//		System.out.println(player.getIsFloor());
		if(!player.getIsFloor()){
			player.setJumpSpeed(0);
			player.setJumpTime(System.currentTimeMillis());
			player.setJumpY(player.getY());
			StateDrop dop = new StateDrop(player);
			player.setState(dop);
		}
	}
//	public void hero() {
//		player.setHeight(100);
//		player.setJumpSpeed(800);
//		player.setJumpTime(System.currentTimeMillis());
//	
//		StateHero hro = new StateHero(player);
//		player.setState(hro);
//	}

}
