package websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/ChatServer02")
public class ChatServer02 {
	
	/*
	  - 해당 set컬렉션은 클라이언트가 접속 할 때 마다 세션 ID를 저장하므로
	  static으로 선언된다..
	  - 접속한 웹브라우저가 웹소켓을 지원해야 하며, 웹브라우저를 닫으면
	  OnClose가 호출된다.
	  - Collections클래스의 synchronizedSet()메소드는 공유객체에 동시접근을
	  막도록 동기화 하는 역할을 담당한다.
	 */
	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
	
	//클라이언트가 접속 했을 때......^^................
	@OnOpen
	public void onOpen(Session session) {
		
		//Set 컬렉션에 사용자 세션 아이디를 추가한다.
		clients.add(session);
		
		System.out.println("연결띠");
		System.out.println("Open session id : "+ session.getId());
		System.out.println("session.getBasiocRemote() : "+ session.getBasicRemote());
	}
	
	//클라이언트가 접속을 끊었을 때...........................................@@
	@OnClose
	public void OnClose(Session session) {
		clients.remove(session);
		System.out.println("종료띠");

	}
	
	//클라이언트가 보낸 메세지가 도착 했을 때............^^.........@@........
	@OnMessage
	public void OnMessage(String message, Session session) throws IOException {
		
		System.out.println(session.getId() +":"+message);
		
		//동기화 블럭으로 공유객체에 대한 동시접근을 막는다.
		synchronized (clients) {
			//Set컬렉션에 저장 된 모든 클라이언트에게 메세지를 전송한다.
			for (Session client : clients) {
				//단, 메세지를 보낸 '나(Me)'를 제외한 나머지에게만 전송된다.
				if (!client.equals(session)) {
					client.getBasicRemote().sendText(message);
				}
			}
		}
	}
	
	//채팅중 에러가 발생 했을 때...............................................
	@OnError
	public void onError(Throwable e) {
		e.printStackTrace();
	}
}
