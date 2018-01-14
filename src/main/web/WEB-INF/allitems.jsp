<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <body>
        <h2>Hello World!</h2>
        <table class="table" border="1px">
            <tr>
                <th>Name</th>
                <th>Breed</th>
                <th>Character</th>
                <th>Cost</th>
                <th>Littering degree</th>
            </tr>

            <c:forEach items="${allitems}" var="items">
                <tr>
                    <td><c:out value="${items.name}"/></td>
                    <td><c:out value="${items.breed}"/></td>
                    <td><c:out value="${items.character}"/></td>
                    <td><c:out value="${items.cost}"/></td>
                    <td><c:out value="${items.litteringdegree}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
