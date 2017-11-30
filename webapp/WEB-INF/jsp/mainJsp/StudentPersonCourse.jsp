<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@include file="../jspUtil/scriptAndLink.jsp"%>

<div class="container">
  <%@include file="../jspUtil/head.jsp"%>
  <div class="row">
   <%@include file="../jspUtil/CourseManageLeft.jsp"%>
      <table class="table table-striped table-bordered table-hover table-condensed col-lg-offset-2 col-lg-6">
      <thead>
      <th>课程名</th>
      <th>开始时间</th>
      <th>结束时间</th>
      <th>课程号</th>
      <th>学分数</th>
      <th>班级</th>
      <th>教师</th>
      </thead>
      <tbody>
      <c:forEach items="${CourseAndValue}" var="CAV" varStatus="status"
                 end="${page.start+page.count}" begin="${page.start}">
          <tr>
              <td>${CAV.key.course_name}</td>
              <td>${CAV.value.begin}</td>
              <td>${CAV.value.end}</td>
              <td>${CAV.value.number}</td>
              <td>${CAV.value.credit}</td>
              <td>${CAV.value.classes}</td>
              <td>${CAV.value.teachername}</td>
              <td>${CAV.key.teacher.name}</td>
              <td><a deleteLink="true" href="/deleteCourse?username=${user.username}&courseId=${CAV.key.course_id}">退课</a></td>
          </tr>

      </c:forEach>
      </tbody>
      </table>
  </div>
    <div class="row col-lg-offset-5">
        <nav>
            <ul class="pagination">
                <li <c:if test="${!page.hasPrevious()}">class="disabled"</c:if>>
                    <a href="/CourseList?username=${user.username}&start=0" aria-label="Previous">
                        <span><<</span>
                    </a>
                </li>
                <c:forEach begin="0" end="${page.totalPage-1}" varStatus="satus">
                    <li <c:if test="${!page.hasPrevious()}">class="disabled"</c:if>>
                        <a href="//CourseList?username=${user.username}&start={satus.count*5}" class="current">
                            <span>${satus.count}</span>
                        </a>
                    </li>
                </c:forEach>
                <li <c:if test="${!page.hasNext()}">class="disabled"</c:if>>
                    <a href="/CourseList?username=${user.username}&start=${page.last}" aria-label="Next">
                        <span aria-hidden="true"> >> </span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
