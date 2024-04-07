# MutableState는 무엇일까
> 📝 한줄 정리 : Compose에서 변화하는 데이터를 저장하는 자료형

mutableState 내부의 값이 변할때마다 UI를 새로 랜더링 하면서

데이터의 변화를 UI에 적용한다.

이 과정을 <b>리컴포지션</b>이라고 한다.

- 사용법
```kt
val count = mutableStateOf(0)

Text(count.value)

Button({ count.value += 1 }) {
    Text("클릭")
}
```
하지만 이렇게 사용하면 count의 새로운 값을 할당해서 

리컴포지션을 발생시켜도 

count의 새로운 값을 할당하면서 똑같은 0이 할당되게되고

똑같은 UI가 표시되게 된다.

그래서 remember를 사용해서 다음과 같이 사용한다.

```kt
val count = remember{ mutableStateOf(0) }

Text(count.value)

Button({ count.value += 1 }) {
    Text("클릭")
}
```

remember을 사용하게 되면 이전에 있었던 값을 기억해서

리컴포지션이 될때 같은 값이 할당되는것을 방지한다.

하지만 화면 회전, 화면 테마 변경 등 리컴포지션이 아닌 UI 자체가 새로 만들어 지는 경우에는

remember을 사용해도 초기의 값이 할당되게 된다.

이때는 아래와 같이 rememberSaveable을 사용할 수 있다. 

```kt
val count = rememberSaveable { mutableStateOf(0) }

Text(count.value)

Button({ count.value += 1 }) {
    Text("클릭")
}
```

remember가 아닌 rememberSaveable를 사용하면

화면 자체가 새로 실행되는 상황에서도 기존의 값이 유지가 된다.