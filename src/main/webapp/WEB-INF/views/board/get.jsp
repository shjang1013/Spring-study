<%--
  Created by IntelliJ IDEA.
  User: jangsohyeon
  Date: 2020/10/03
  Time: 12:45 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../includes/header.jsp" %>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading"> Board Read </div>
            <div class="panel-body">
                <div class="form-group">
                    <label>Bno</label>
                    <input class="form-control" name="bno" value="<c:out value="${board.bno}"/>" readonly="readonly">
                </div>
                <div class="form-group">
                    <label>Title</label>
                    <input class="form-control" name="title" value="<c:out value="${board.title}"/>" readonly="readonly">
                </div>

                <div class="form-group">
                    <label>Text Area</label>
                    <textarea class="form-control" rows="3" name="content" readonly="readonly"><c:out value="${board.content}"/></textarea>
                </div>

                <div class="form-group">
                    <label>Writer</label>
                    <input class="form-control" name="writer" value="<c:out value="${board.writer}"/>" readonly="readonly">
                </div>

                <button data-oper="modify" class="btn btn-default">Modify</button>
                <button data-oper="list" class="btn btn-info">List</button>

                <form id="operForm" action="/board/modify" method="get">
                    <input type="hidden" id="bno" name="bno" value="<c:out value="${board.bno}"/> ">
                    <input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
                    <input type="hidden" name="amount" value='<c:out value="${cri.amount}"/>'>
                    <input type="hidden" name="keyword" value='<c:out value="${cri.keyword}"/>'>
                    <input type="hidden" name="type" value='<c:out value="${cri.type}"/>'>
                </form>
                <!-- <button data-oper="modify" class="btn btn-default" onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/>'">Modify</button> -->
                <!-- <button data-oper="list" class="btn btn-info" onclick="location.href='/board/list'">List</button> -->
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="/resources/js/reply.js"></script>

<script>
    console.log("===============");
    console.log("JS TEST");

    var bnoValue = '<c:out value="${board.bno}"/>';

    // ReplyService Add Test
    replyService.add(
        {reply : "JS Test", replyer : "tester", bno : bnoValue} <!-- add()에 던져야 하는 파라미터는 JavaScript의 객체 타입으로 만들어서 전송해 주고, Ajax 전송 결과를 처리하는 함수를 파라미터로 같이 전달한다 -->
        , function (result) {
            alert("RESULT : " + result);
        }
    );

    // ReplyService Select Test
    replyService.getList({bno : bnoValue, page : 1}, function (list) {
        for(var i = 0, len = list.length||0; i < len; i++) {
            console.log(list[i]);
        }
    });

    // ReplyService Delete Test
    replyService.remove(28, function (count) {
        console.log(count);

        if(count === "success") {
            alert("REMOVED");
        }
    }, function (err) {
        alert("ERROR...");
    });

    // ReplyService Update Test, 22번 댓글 수정
    replyService.update({
        rno : 22,
        bno : bnoValue,
        reply : "Modified Reply....."
    }, function(result) {
        alert("수정 완료.....");
    });

    // ReplyService Get Test
    replyService.get(10, function(data) {
        console.log(data);
    });

</script>

<script type="text/javascript">
    $(document).ready(function () {
        var operForm = $("#operForm");

        $("button[data-oper='modify']").on("click", function (e) {
            operForm.attr("action", "/board/modify").submit();
        });

        $("button[data-oper='list']").on("click", function (e) {
            operForm.find("#bno").remove();
            operForm.attr("action", "/board/list");
            operForm.submit();
        });
    });
</script>

<%@ include file="../includes/footer.jsp" %>