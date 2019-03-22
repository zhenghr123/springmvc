<html>
<body>
<h2>Hello World!</h2>
<a href="springmvc/testRequestMapping">Test RequestMapping</a>
<br/><br/>
<a href="springmvc/testAntPath/xxx/abc">Test AntPath</a>
<br/><br/>
<a href="/springmvc/testPathVariable/123">Test PathVariable</a>
<br/><br/>


<form action="springmvc/testRest/1" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" name="_method" value="TestRest DELETE">
</form>
<br/><br/>

<form action="springmvc/testRest/1" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    <input type="submit" name="_method" value="TestRest PUT">
</form>
<br/><br/>

<a href="springmvc/testRequestParam">testRequestParam</a>
<br/><br/>


<form action="/springmvc/testPoJo" method="post">
    name:<input type="text" name="name"/><br/>
    age:<input type="text" name="age"/><br/>
    <input type="submit" value="submit"/>
</form>

<a href="springmvc/testServletAPI">Test ServletAPI</a>
<br/><br/>

<a href="springmvc/testModelAndView">TestModelAndVies</a>
<br/><br/>

<a href="springmvc/testMap">Test Map</a>
<br/><br/>

<a href="/springmvc/testSessionAttributes">Test SessionAttributes</a>
<br/><br/>


<form action="springmvc/testModelAttribute" method="post">
    <input type="hidden" name="id" value="1">
    username : <input type="text" name="username" value="Tom">
    <br>
    email : <input type="text" name="email" value="5161@qq.com">
    <br>
    age : <input type="text" name="age" value="23">
    <input type="submit" name="Submit">
</form>


<br/>
<a href="emps">List All Employees</a>
<br><br>


</body>
</html>
