<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@include file="../jspUtil/scriptAndLink.jsp"%>
<div class="container">
    <%@ include file="/WEB-INF/jsp/jspUtil/head.jsp" %>

    <div class="row">
        <%@include file="../jspUtil/homePageLeft.jsp"%>
        <table class="table table-striped table-bordered table-hover  table-condensed">
          <thead>
            <th>注意</th>
            <th>日期</th>
          </thead>
          <tbody>
            <c:forEach items="${importantMessage}" var="message" begin="${page.start}" end="${page.start+page.count}">
              <tr>
                <td>${message.content}</td>
                <td>${message.date}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
     </div>
        <div class="row col-lg-offset-5">
            <nav>
                <ul class="pagination">
                    <li <c:if test="${!page.hasPrevious()}">class="disabled"</c:if>>
                       <a href="/homePageAttention/0" aria-label="Previous">
                           <span><<</span>
                       </a>
                    </li>
                    <c:forEach begin="0" end="${page.totalPage-1}" varStatus="satus">
                        <li <c:if test="${!page.hasPrevious()}">class="disabled"</c:if>>
                            <a href="/homePageAttention/${satus.count*5}" class="current">
                                <span>${satus.count}</span>
                            </a>
                        </li>
                    </c:forEach>
                    <li <c:if test="${!page.hasNext()}">class="disabled"</c:if>>
                        <a href="/homePageAttention/${page.last}" aria-label="Next">
                            <span aria-hidden="true">»</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>

</div>
</body>
</html>
