<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
    <script>
        let userList = new Array();
        userList.push({username:"张三", age:25});
        userList.push({username:"里斯", age:32});

        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/user/quick11",
            data:JSON.stringify(userList),
            contentType:"application/json;charset=utf-8"
        });
    </script>
</head>
<body>

</body>
</html>
