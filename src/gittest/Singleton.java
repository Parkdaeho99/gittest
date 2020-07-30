package gittest;

public class Singleton {

	public static void main(String[] args) {
		T.getInstance();
		System.out.println("***********");
		System.out.println(T.getInstance());
		//제거해준 후에는(instance에 null을 대입하면 갈 곳을 잃은 객체를 가비지컬렉터가 없앰)
		//제거한 덕에 객체생성, 생성자호출이 다시 된다.
		System.out.println("***********");
		T.getInstance();
		/*
		싱글톤 패턴
		> 오직 하나의 객체만을 생성하게 하고 그 객체를 어디서든 참조할 수 있게 하는 패턴
		왜 쓸까? 왜 이렇게 할까? 그냥 new DAO하는거랑 getInstance하는거랑 뭐가 차이일까
		단 하나의 객체만 생성할 수 있게 한다는 것 때문인가?
		만약 new DAO new DAO new DAO 총 세번해서 세개의 객체를 만들고 각각의 객체가 DB에 접근한다고 하면?
		> 구글링 : 메모리낭비 방지, 데이터 공유의 편리화
		*/
	}
}

class T {
	private static T instance; //오직 getInstance()를 통해서만 접근 가능
	private T() {
		//생성자를 private로 만들면 외부에서 new T()를 할 수 없다.
		System.out.println("생성자 실행합니다."); //생성될 때만 실행되기 때문에 두번째 getInstance()부터는 실행되지 않는다.
	}

	public static T getInstance() {
		if (instance == null) {
			System.out.println("객체를 생성합니다.");
			instance = new T(); //객체를 생성해서 static 변수에 넣었기 때문에 instance가 계속 존재한다.
		} else {
			System.out.println("객체를 제거합니다.");
			instance = null;
		}
		System.out.println("객체를 반환합니다.");
		return instance;
	}
}
