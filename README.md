# PSI-SpringBoot-2022
開發工具 : sts4(SpringBoot)
練習     : Jpa + validation + thymeleaf + web 
DB       : mysql

目前進度       : employee / Department OK

紀錄修正(9/13) : 20220905PSI 的 Department 有 Employee 會有刪除失敗提示 / Department 和 Employee 新增提示 / 增加各 Entity validation

thymeleaf 外掛 :
 1. thymeleaf : <html xmlns:th="http://www.thymeleaf.org">

thymeleaf 功能 :
 1. header 和 footer 標籤設定 : <header/footer xmlns:th="http://www.thymeleaf.org" th:fragment="header/footer">
 2. 插入 header/footer : <div th:include="html名稱 :: 標籤名稱"></div>
 3. 圖片掛入 :  <img class="img-fluid" th:src="@{/image/psi_table.png}">
 4. 錯誤訊息 :  <span class="fieldError" th:if="${#fields.hasErrors('*{name}')}" th:errors="*{name}"></span>
 5. JS 取得 thymeleaf 值 :  // 用於專案刪除提醒
      <script th:inline="javascript">
        var message = /*[[${message}]]*/ // 此行
        console.log(message);
        if(message != null){
    	  alert(message);
        }
      </script> 

 6. thymeleaf 取得 list 數量 : ${#lists.size()} // 配合 thymeleaf switch 顯示員工
 
 7. thymeleaf switch : * 為預設
      <span  th:switch="${#lists.size(dept.employees)}">
        <span th:case="0">此員工尚有部門</span>
         <span th:case="*">
          <span th:each="e:${dept.employees}">
           <a th:href="@{/employee/{id}(id=${e.id})}" th:text="${e.name}"></a>
          </span>
         </span>
      </span> 
-------------------------------------------------------------------------------------------------------------------
前端實作注意:
 1. index.html -> 圖片配合 css -> <img class="img-responsive" th:src="@{/image/psi_table.png}">
                    <style type="text/css">
		              .img-responsive {
		              display: block;
		              height: auto;
		              max-width: 100%;
		                              }
	                </style> 

 2. <form class = "form-horizontal"> -> <div class="form-group"> -> <input class="form-control">  
    <select class="form-control select2"> 
	
 3. 錯誤訊息 -> 配合 css -> <span class="fieldError" th:if="${#fields.hasErrors('*{name}')}" th:errors="*{name}"></span>
                  <style type="text/css">
	                .fieldError{color: red;}
                  </style> 
 4. table class : <table border="1" class="table table-striped table-responsive-md">	

 5. JS 取得 thymeleaf 值 :  // 用於專案刪除提醒
      <script th:inline="javascript">
        var message = /*[[${message}]]*/ // 此行
        console.log(message);
        if(message != null){
    	  alert(message); 
        }
      </script> 

 6. thymeleaf 取得 list 數量 : ${#lists.size()} // 配合 thymeleaf switch 顯示員工
 
 7. thymeleaf switch : * 為預設
      <span  th:switch="${#lists.size(dept.employees)}">
        <span th:case="0">此員工尚有部門</span>
         <span th:case="*">
          <span th:each="e:${dept.employees}">
           <a th:href="@{/employee/{id}(id=${e.id})}" th:text="${e.name}"></a>
          </span>
         </span>
      </span> 

 8. redirect -> RedirectAttributesModelMap modelMap -> addFlashAttribute // 成功刪除提示
 
------------------------------------------------------------------------------------------------------------------- 
 Header :
  <header xmlns:th="http://www.thymeleaf.org" th:fragment="header">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>	
  </header>

footer :
  <header xmlns:th="http://www.thymeleaf.org" th:fragment="footer">
	<p />
  	<div style="text-align:center">簡易PSI系統練習</div>
  </header>

navbar 選單 : 查看 navbar.txt 
