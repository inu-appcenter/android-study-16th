## Livedata?  

> 📝 한줄 정리 : data의 변경을 관찰 할 수 있는 data holder 클래스  

보통 viewmodel과 함께 사용  

일반적인 observable과는 다르게 livedata는 안드로이드 lifecycle을 알고 있다.  
---> 액티비티나 프레그먼트, 서비스 등과 같은 안드로이드 컴포넌트의 생명주기를 인식하며 그에 따라서 livedata는 활성상태(active)일때만 데이터를 업데이트 한다.  

livedata가 가지고 있는 데이터에 어떠한 변화가 일어날 경우, livedata는 등록된 observer객체에 변화를 알려주고, observer의 onchanged() 메소드가 실행된다.  

## LifeCycleOwner?  

> 📝 한줄 정리 : 안드로이드 생명주기 를 알고 있는 클래스  

메서드가 오직 getLifeCycle() 밖에 없는 단일 메소드 인터페이스 클래스 이며, Activity나 Fragment에서 이를 상속하고 있다.  

LiveData의 Observer 메소드의 LifeCycleOwner를 Activity나 Fragment를 변수로써 사용한다면, 각 화면 별 생명주기에 따라 LiveData는 자신의 임무를 수행 한다.  


## 장점?  

1.  data와 ui간의 동기화  
---> LiveData는 Observer 패턴을 따르기 때문에 Observer 객체를 사용하면 데이터의 변화가 일어나는 곳마다 매번 ui를 업데이트할 필요 x  

2. 메모리 누수 x  
---> Observer 객체는 lifecycle 객체와 결합되어 있어서 컴포넌트가 destroy될 경우 메모리상에서 스스로 해제한다. 

3. stop 상태의 액티비티와 crash 발생 x  
---> Observer의 생명주기가 inactive일 경우, Observer는 LiveData의 어떤 이벤트도 수신 x  

4. 생명주기에 대한 추가적인 handling 필요 x   
---> LiveData가 안드로이드 생명주기에 따른 Observing을 자동으로 관리, UI 컴포넌트는 그저 관련 있는 데이터를 "관찰"만 하면 된다.  

5. 항상 최신 데이터 유지  
6. 자원 공유 가능  

## 주의사항  

1. 관찰하고자 하는 데이터의 타입을 갖는 LiveData 인스턴스를 생성 (by. generic)  

2. LiveData 클래스의 observe() 메소드를 사용해서 Observer 객체를 LiveData 객체에 결합  
---> observe() 메소드는 LifecyclaOwner 객체를 필요로함. activity 전달  
---> LiveData에 변화 발생 -> active인 모든 데이터에 trigger 발생(by. LifeCycleOwner) 

3. Observer 객체를 생성  
---> onChangeㅇ() : LiveDAta가 들고 있는 데이터가 변화가 일어났을 때 수행해야할 로직이 들어있음  

4. removeObserver(Observer) : Observer 제거


## build.gradle에 추가
```kt
        def lifecycle_version = "2.2.0"
        // ViewModel
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
        // ViewModel utilities for Compose
        implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")     
``` 


## 예제  
1. ViewModel 클래스 생성  
아래의 코드에서는 MutableLiveData를 사용했지만 불변(Immutable)객체로 LiveData<>를 사용해도 상관없다.  

```kt  
class TestLiveDataViewModel : ViewModel() {
    // String 타입의 MutableLiveData 생성, by lazy로 초기화는 뒤에
    val textValue: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}   `
```    

<b> LiveData에 Observer를 결합하는 코드는 컴포넌트의 onCreate() 메소드 내에 위치하는 것이 바람직하다. </b>  

2. MainActivity에 onCreate에 Observer 세팅  

```kt  
class MainActivity : AppCompatActivity() {
    // 전역 변수로 ViewModel lateinit 세팅
    private lateinit var model: TestLiveDataViewModel
 
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
 
        // ViewModel 가져오기
        model = ViewModelProvider(this).get(TestLiveDataViewModel::class.java)
 
        // Observer를 생성한 뒤 UI에 업데이트 
        val testObserver = Observer<String> { textValue ->
            // 현재 MainActivity에는 TextView가 하나만 존재
            // 다른 데이터를 받는 UI 컴포넌트가 있다면 같이 세팅
            tv_livedata_test.text = textValue
        }
 
        // LiveData를 Observer를 이용해 관찰하고
        // 현재 Activity 및 Observer를 LifecycleOwner로 전달
        model.textValue.observe(this, testObserver)
    }
}  
```  
