<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@include file="../jspUtil/scriptAndLink.jsp"%>
<div class="container">
    <%@include file="../TeacherJspUtil/head.jsp"%>
    <div class="row">
        <script>
            $(function(){
                $("PersonManage").attr("class","active")
            });
        </script>

        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-body">

                    <div class="row col-lg-12 ">
                        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingOne">
                                    <h4 class="panel-title">
                                        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                            基本信息
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                                    <div class="panel-body">
                                        <div class="row">
                                            <c:forEach items="${propertyAndValue}" var="PAV" varStatus="status">
                                                <c:if test="${PAV.key=='basicInfo'}">
                                                    <div class="col-xs-6 ">${PAV.value}</div>
                                                </c:if>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingTwo">
                                    <h4 class="panel-title">
                                        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                            科研经历
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                                    <div class="panel-body">
                                        <div class="row">
                                        <c:forEach items="${propertyAndValue}" var="PAV" varStatus="status">
                                            <c:if test="${PAV.key=='science'}">
                                                <div class="col-xs-6 ">${PAV.value}</div>
                                            </c:if>
                                        </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingThree">
                                    <h4 class="panel-title">
                                        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                            奖惩信息
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                                    <div class="panel-body">
                                        <div class="row">
                                        <c:forEach items="${propertyAndValue}" var="PAV" varStatus="status">
                                            <c:if test="${PAV.key=='rewardAndPunish'}">
                                                <div class="col-xs-6 ">${PAV.value}</div>
                                            </c:if>
                                        </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingFour">
                                    <h4 class="panel-title">
                                        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                                           职业生涯
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
                                    <div class="panel-body">
                                        <div class="row">
                                        <c:forEach items="${propertyAndValue}" var="PAV" varStatus="status">
                                            <c:if test="${PAV.key=='career'}">
                                                <div class="col-xs-6 ">${PAV.value}</div>
                                            </c:if>
                                        </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
