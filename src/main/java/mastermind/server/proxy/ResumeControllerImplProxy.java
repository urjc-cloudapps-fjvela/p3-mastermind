package mastermind.server.proxy;

import mastermind.controllers.ResumeController;
import mastermind.models.Session;
import mastermind.types.FrameType;
import santaTecla.utils.TCPIP;

public class ResumeControllerImplProxy extends ResumeController {

    private TCPIP tcpip;

	public ResumeControllerImplProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void resume(boolean newGame) {
		this.tcpip.send(FrameType.RESUME);

	}

}
