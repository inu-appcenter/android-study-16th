# LivaData

#### Android Jetpack 라이브러리의 하나의 기능

LiveData는 Data 변경을 관챃할 수 있는 Data Holder 클래스 입니다.
일반적인 Observable들과의 차이점으로 안드로이드 생명주기를 알고 있다는 점이 있다.
따라서 액티비티, 프래그먼트, 서비스 등과 같은 안드로이드 컴포턴트의 생명주기를 인식해 활성상태인 경우에만 데이터를 업데이트한다.
Observable 객체와 함께 사용되고 LiveData가 가지고 있는 데이터에 변화가 생기는 경우 LivaData는 등록된 Observer 객체에 변화를 알려주고 Observaer의 onChanged() 메소드가 실행된다.

### 장점

- Data와 UI 동기화
- 메모리 누수 X
- Stop 상태인 액티비티와 Crash가 없음
- 생명주기에 따른 추가적인 handling 필요 X
- 항상 최신 데이터를 유지
- 자원을 공유할 수 있음

### 단점

- 비동기 데이터 스트림 처리하기 힘듬
- Domain Layer에 사용하기 적합하지 않음
- 한번만 데이터를 관찰해야 할 경우 문제 발생
  - ex) Dialog, Toast, Snackbar
  - -> 이때를 위해 SingleLiveData를 사용

# StateFlow

LiveData와 마찬가지로 관찰 가능한 Data Holder 클래스이다.
하지만 Android에 종속적인 LiveData와 달리 순수 Kotlin 라이브러리이다.
따라서 안드로이드 생명주기를 모른다.
-> 생명주기를 모르기 때문에 백그라운드에 있을 때도 데이터를 수집하여 메모리 문제가 발생할 수 있음
(생명주기를 알려주려면 Lifecycle.repeatOnLifeCycle 블록에서 흐름을 수집해야 함)

Clean Architecture 관점에서는 LiveData를 Flow로 대체하는 것이 좋음.

Flow : Cold Stream
Flow에서 수집되는 하나의 소비자에게 전송

StateFlow : Hot Stream
StateFlow에서 수집되는 모든 클래스가 소비자

ex) Cold Stream = CD | Hot Stream = Radio
