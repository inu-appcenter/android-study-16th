# 스레드 란
- 스레드 : 코드를 해석하는 주체, 하나의 프로그램은 스레드가 하나 이상 있다.
  
    여러개의 스레드를 가지고 동시에 여러개의 코드를 해설 할 수도 있다.

    이 방식을 비동기 방식이라고 한다.


# 동기 / 비동기 이란
## 동기 통신
- 동기 : 모든 작업을 순차적으로 진행하는 방식
- 서버에 요청을 보내면 요청을 보내는 시간동안 정지한다.
- 서버와 통신이 끝나면 다시 동작 시작한다.

## 비동기 통신
- 비동기 : 여러 작업을 동시에 진행하는 방식
- 새로운 스레드를 만들어서 비동기를 적용한다.
- 서버에 통신을 할때 새로운 스레드를 만들어서 요청한다.
- 기존에 있던 스레드에서는 앱이 동작한다.