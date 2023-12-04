<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%--- sum - сумма на момент открытия--%>
<%--- percentage - годовая процентная ставка--%>
<%--- years - количество лет--%>

<header>

</header>
<article>
    <h1>Count Percent</h1>
    <form action="finance" method="post">
        sum: <input type="text" name="sum"/><br/>
        percentage: <input type="text" name="percentage"/><br/>
        years: <input type="text" name="years"/><br/>
        <hr>
        <input type="submit" value="count"/>
    </form>
</article>
<footer>

</footer>
</body>
</html>