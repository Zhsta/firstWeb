<%@page language="java" contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%>

<div class="span2  col-xs-12 col-sm-3 col-lg-2">
    <ul class="nav nav-pills nav-stacked">
        <li>
            <div class="btn-group">
            <button type="button" class="btn btn-default dropdown-toggle "  data-toggle="dropdown">
                成绩查询
                <span class="caret"></span>
            </button>

            <ul class="dropdown-menu" role="menu">
                <li>
                    <a href="/PassScore?username=${user.username}&start=0">全部及格成绩</a>
                </li>
                <li role="presentation">
                    <a href="/allScore?username=${user.username}&start=0">所有课程成绩</a>
                </li>
            </ul>
        </div>
        </li>

        <li><div class="btn-group">
            <button type="button" class="btn btn-default dropdown-toggle "  data-toggle="dropdown">
                课程
                <span class="caret"></span>
            </button>

            <ul class="dropdown-menu" role="menu">
                <li>
                    <a href="/CourseArrangement?username=${user.username}&start=0">本学期课程安排</a>
                </li>
                <li role="presentation">
                    <a href="/CourseSearchPage">课程查询</a>
                </li>

            </ul>
        </div>
        </li>
    </ul>
</div>