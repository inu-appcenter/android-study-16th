<?php
   $con=mysqli_connect("localhost", "202201469user", "202201469pw", "hollydb") or die("MySQL 접속 실패 !!");

   $sql ="SELECT * FROM user";
 
   $ret = mysqli_query($con, $sql);   
   if($ret) {
	   $count = mysqli_num_rows($ret);
   }
   else {
	   echo "userTBL 데이터 검색 실패!!!"."<br>";
	   echo "실패 원인 :".mysqli_error($con);
	   exit();
   } 
   
   echo "<h1> 회원 검색 결과 </h1>";
   echo "<TABLE border=1>";
   echo "<TR>";
   echo "<TH>아이디</TH><TH>이름</TH><TH>전화번호</TH><TH>반</TH>";
   // echo "<TH>수정</TH><TH>삭제</TH>";
   echo "</TR>";
   
   while($row = mysqli_fetch_array($ret)) {
	  echo "<TR>";
	  echo "<TD>", $row['userid'], "</TD>";
	  echo "<TD>", $row['name'], "</TD>";


	  echo "<TD>", $row['phone'], "</TD>";

	  echo "<TD>", $row['class'], "</TD>";
	 /* echo "<TD>", "<a href='update.php?userID=", $row['userID'], "'>수정</a></TD>";
	  echo "<TD>", "<a href='delete.php?userID=", $row['userID'], "'>삭제</a></TD>";
	  */echo "</TR>";	  
   }   
   mysqli_close($con);
   echo "</TABLE>"; 
   echo "<br> <a href='main.html'> <--초기 화면</a> ";
?>