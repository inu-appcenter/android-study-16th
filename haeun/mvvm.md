## mvc?  
model, view, <b>controller(activity)</b>  

model: 어플리케이션에서 사용되는 데이터와 그 데이터를 처리하는 부분
view: 사용자에서 보여지는 ui 부분  
controller: 사용자의 입력을 받고 처리하는 부분

1. 사용자의 action들이 controller에 들어옴
2. controller는 사용자의 action을 확인하고 model을 업데이트함
3. controller는 model을 나타내줄 view를 선택함
4. view는 model을 이용하여 화면을 나타냄 

build.gradle -> buildFeatures { dataBinding true } -> sync now    

model ---model changed---> view  
-view가 model을 이용하여 직접 업데이트  
-model에서 view에게 norify하여 업데이트  
-view가 polling으로 주기적으로 model의 변경을 감지하여 업데이트

controller는 view를 선택할 뿐 직접 업데이트 x   
단순한 패턴 ---> 널리 사용됨  
but, view와 model 사이의 의존성이 높음 ---> 유지보수 x

## mvp?  
model, view, <b>presenter</b>   
presenter : view에서 요청한 정보로 model을 가공하여 view에 전달해 주는 부분, view와 model을 붙여주는 역할

1. 사용자의 action들이 view를 통해 들어옴
2. view는 데이터를 presenter에 요청함
3. presenter는  model에게 데이터를 요청함
4. model은 presenter에서 요청받은 데이터를 응답함.
5. presenter은 view에게 데이터를 응답함.
6. view는 presenter가 응답한 데이터를 이용하여 화면을 나타냄.

model이 view를 직접적으로 제어 못함   
---> view와 model의 의존성 x(mvc의 단점 해결)  
하나의 view만 연결 가능 ---> 1:1 관계  
controller ---> interface : controller 모든 권한을 presenter에게 넘기고, 정보만 입력 받는 interface로 변함   
--->view와 presenter 사이의 의존성이 높아짐  

또 다른 activity가 생겼을 때 손쉽게 presenter를 인식할 수 있는 장점

## mvvm?  
model, view, <b>view model</b>  
view model: view를 표현하기 위해 만든 view를 위한 model, view를 나타내 주기 위한 mdoel이자 view를 나타내기 위한 데이터 처리를 하는 부분  
presenter ---> Viewmodel

1. 사용자의 action들이 view를 통해 들어옴
2. view에 action이 들어오면, command 패턴으로 view model에 action 을 전달
3. viewmodel은 model에게 데이터를 요청
4. model 은 view model에게 요청받은 데이터를 응답
5. view model은 응답 받은 데이터를 가공하여 저장
6. view는 view model과 data binding 하여 화면을 나타냄

command패턴 + data binding ---> view와 viewmodel 사이의 의존성을 없앰.  
여러개의 view를 연결 할 수 있음 ---> viewmodel:view = 1:n

view model의 설계가 어렵다는 단점