### 템플릿 메서드 패턴

* 템플릿 메서드 패턴은 전체적으로는 동일하면서 부분적으로는 다른 구문으로 구성된 메서드의 코드 중복을 최소화할 때 유용하다.
* after 예제처럼 Motor 클래스의  move메서드(템플릿 메서드)는 HyundaiMotor와 LGMotor에서 동일한 기능을 구현하면서 각 하위 클래스에서
  구체적으로 정의할 필요가 있는 부분, 즉 moveMotor메서드(primitive or hook메서드) 부분만 각 하위 클래스에서 오버라이드되도록 한다.
  
#### before (템플릿 메서드 패턴 적용 X)

![before](https://user-images.githubusercontent.com/28583661/72605682-948af600-3960-11ea-9dfc-f5f6230056b3.PNG)

#### after (템플릿 메서드 패턴 적용 O)

![after](https://user-images.githubusercontent.com/28583661/72605603-71f8dd00-3960-11ea-80ad-7366923af23d.PNG)