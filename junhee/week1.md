# Mutablestate란?

MutableState는 상태 관리를 위한 핵심 개념 중 하나이며 Compose에서 읽기와 쓰기를 관찰하기 위해 만들어진 클래스입니다.

- 상태 관리는 UI의 데이터가 시간에 따라 어떻게 변하는지, 그리고 이 데이터 변화가 UI에 어떻게 반영되는지를 처리하는 과정입니다. Compose는 리액티브 프로그래밍 모델을 사용하여, 데이터의 상태가 변경될 때 UI를 자동으로 업데이트합니다.

- Compose에서 상태를 저장하고 상태가 변경 되었을 때 재구성하기 위해서는 관찰 가능한 객체를 사용해야 하는데 이때 Mutablestate 클래스가 사용됩니다.

- Recomposition(재구성)이란 Compose에서 어떠한 상태 값이 바뀌게 되면 일어나는 것이고 말 그대로 재 생성한다는 뜻이다.

## Remember

#### Remember을 사용하는 이유 : 상태 값이 변함에 따라 재구성 되었을 때 값을 저장할  수 있도록 하기 위해서입니다.

remember은 다음과 같은 형식으로 사용
```kotlin 
val count = remember{ mutableStateOf(0)}
```
- remember 함수는 Composable 함수가 다시 렌더링될 때 상태를 보존하는 데 사용됩니다.

- 상태를 보존하기 위해 메모리 내에서 관리되므로, 일반적으로 앱의 생명주기와 상관없이 Composable 함수가 다시 렌더링될 때까지 유지됩니다.

- 예를 들어, 화면 회전 등과 같이 Composable 함수가 다시 렌더링될 때 상태가 유지되어야 하는 경우에 사용됩니다.

rememberSaveable은 다음과 같은 형식으로 사용
```kotlin
val count = rememberSaveable { mutableStateOf(0) }
```
- rememberSaveable 함수는 remember와 유사하지만, 추가적으로 시스템의 구성 변경(예: 화면 회전)과 같은 경우에도 상태를 보존합니다.

- 시스템의 구성 변경 시, rememberSaveable로 보존된 상태는 일시적으로 이동하여 다시 생성됩니다. 이후에는 다시 Composable 함수가 실행될 때까지 유지됩니다.

- 시스템의 구성 변경에 영향을 받는 앱이나 화면에서 상태를 보존할 때 사용됩니다.

즉, rememberSaveable을 사용하면 화면 자체가 새로 실행되도 기존 값을 저장하고 있습니다.